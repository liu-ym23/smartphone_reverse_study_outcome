package com.larus.deeplink.impl;

import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import com.larus.platform.api.ExternalRouteEntry;
import com.larus.platform.api.ExternalRouteLaunchMode;
import com.larus.platform.api.q;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final AtomicLong a = null;
    public static final String b = null;

    /* JADX INFO: renamed from: com.larus.deeplink.impl.a$a, reason: collision with other inner class name */
    public static final class C0023a {
        public final q a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0023a) == true) goto L8;
            return false;
        L8:
            C0023a r6 = (C0023a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "StartResult(session=" + this.a + ", shouldReportStart=" + this.b + ')';
        }

        public C0023a(q r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "session");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ExternalRouteEntry.values().length];
            r0[ExternalRouteEntry.NEW_INTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ExternalRouteEntry.EXISTING_STACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ExternalRouteEntry.INITIAL_ACTIVITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new AtomicLong();
        b = Integer.toString(Process.myPid(), CharsKt.checkRadix(36)) + '-' + Long.toString(SystemClock.elapsedRealtimeNanos(), CharsKt.checkRadix(36)) + '-';
    }

    public static q a(Intent r7) {
        Intrinsics.checkNotNullParameter(r7, "intent");
        if (Intrinsics.areEqual(r7.getAction(), "android.intent.action.VIEW") == false) goto L5;
        Intent r0 = r7;
    L6:
        if (r0 == null) goto L22;
        Uri r1 = r0.getData();
        if (r1 == null) goto L23;
        String r2 = r1.toString();
        if (r2 == null) goto L24;
        String r3 = r7.getStringExtra("com.larus.deeplink.extra.ROUTE_SESSION_ID");
        boolean r4 = false;
        if (r3 != null) goto L15;
    L17:
        if (r4 == true) goto L21;
        r7.removeExtra("com.larus.deeplink.extra.ROUTE_SESSION_STARTED");
        r3 = b + Long.toString(a.incrementAndGet(), CharsKt.checkRadix(36));
        r7.putExtra("com.larus.deeplink.extra.ROUTE_SESSION_ID", r3);
    L21:
        return new q(r3, ExternalRouteLaunchMode.UNKNOWN, r2);
    L15:
        if (StringsKt.startsWith$default(r3, b, false, 2, null) != true) goto L17;
        r4 = true;
        goto L17
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L5:
        r0 = null;
        goto L6
    }
}
