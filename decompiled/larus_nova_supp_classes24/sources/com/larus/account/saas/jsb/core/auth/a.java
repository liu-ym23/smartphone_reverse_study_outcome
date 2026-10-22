package com.larus.account.saas.jsb.core.auth;

import android.app.Activity;
import android.content.Intent;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final ConcurrentHashMap<String, C0063a> a = null;

    /* JADX INFO: renamed from: com.larus.account.saas.jsb.core.auth.a$a, reason: collision with other inner class name */
    public static final class C0063a {
        public final Function1<ActivityResultAuthProxyActivity, Unit> a;
        public final Function1<Throwable, Unit> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0063a) == true) goto L8;
            return false;
        L8:
            C0063a r6 = (C0063a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PendingLaunch(onActivityReady=" + this.a + ", onLaunchError=" + this.b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0063a(Function1<? super ActivityResultAuthProxyActivity, Unit> r2, Function1<? super Throwable, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "onActivityReady");
            Intrinsics.checkNotNullParameter(r3, "onLaunchError");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(Activity r3, Function1 r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r3, "fromActivity");
        Intrinsics.checkNotNullParameter(r4, "onActivityReady");
        Intrinsics.checkNotNullParameter(r5, "onLaunchError");
        String r0 = UUID.randomUUID().toString();
        a.put(r0, new C0063a(r4, r5));
        Intent r6 = new Intent(r3, ActivityResultAuthProxyActivity.class);     // Catch: Throwable -> L5
        r6.putExtra("account_saas_auth_request_id", r0);     // Catch: Throwable -> L5
        r3.startActivity(r6);     // Catch: Throwable -> L5
        r3.overridePendingTransition(0, 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        C0063a r7 = a.remove(r0);
        if (r7 == null) goto L14;
        Function1<Throwable, Unit> r8 = r7.b;
        if (r8 == null) goto L15;
        r8.invoke(th);
        return;
    L15:
        return;
    }
}
