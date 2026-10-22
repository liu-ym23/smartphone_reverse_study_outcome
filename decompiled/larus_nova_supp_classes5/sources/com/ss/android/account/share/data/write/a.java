package com.ss.android.account.share.data.write;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static a b;
    public final Context a;

    /* JADX INFO: renamed from: com.ss.android.account.share.data.write.a$a, reason: collision with other inner class name */
    public static final class C0007a {
        @JvmStatic
        public static a a(Context r2) {
            if (a.b == null) goto L5;
        L15:
            a r3 = a.b;
            if (r3 != null) goto L18;
            Intrinsics.throwNpe();
        L18:
            return r3;
        L5:
            monitor-enter(a.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (a.b != null) goto L9;
            a.b = new a(r2.getApplicationContext());     // Catch: Throwable -> L12
        L9:
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(a.class);
            goto L15
        }
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r1) {
        this.a = r1;
    }
}
