package com.bytedance.android.live.countdown;

import android.os.SystemClock;
import com.bytedance.android.live.revenue.common.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public long a;
    public boolean b;
    public final long c;
    public final long d;

    /* JADX INFO: renamed from: com.bytedance.android.live.countdown.a$a, reason: collision with other inner class name */
    public static final class C0176a {
    }

    static {
    }

    public abstract void b();

    public abstract void c(long r1);

    public final synchronized void d() {
        monitor-enter(this);
        this.b = false;     // Catch: Throwable -> L12
        if (this.c > 0) goto L9;
        monitor-exit(this);
        return;
    L9:
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");     // Catch: Throwable -> L12
        this.a = SystemClock.elapsedRealtime() + this.c;     // Catch: Throwable -> L12
        p0.a(0, false, true, new CountDownTimer$start$1(this), 3);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public a(long r1) {
        this.c = r1;
        this.d = 1000;
    }

    public static final void a(final a r14) {
        if (r14.b == true) goto L23;
        long r0 = r14.a;
        i97.a r2 = i97.a.a;
        Intrinsics.checkNotNullParameter(r2, "$this$elapsedRealtime");
        long r1 = r0 - SystemClock.elapsedRealtime();
        if (r1 > 0) goto L8;
        r14.b();
        return;
    L8:
        Intrinsics.checkNotNullParameter(r2, "$this$elapsedRealtime");
        long r6 = SystemClock.elapsedRealtime();
        r14.c(r1);
        Intrinsics.checkNotNullParameter(r2, "$this$elapsedRealtime");
        long r3 = SystemClock.elapsedRealtime() - r6;
        long r7 = r14.d;
        if (r1 >= r7) goto L14;
        long r4 = r1 - r3;
        if (r4 >= 0) goto L13;
        long r8 = 0;
    L19:
        p0.a(r8, false, true, new CountDownTimer$checkTime$1(r14), 2);
        return;
    L13:
        r8 = r4;
        goto L19
    L14:
        long r9 = r7 - r3;
    L16:
        if (r9 >= 0) goto L18;
        r9 = r9 + r14.d;
        goto L16
    L18:
        r8 = r9;
        goto L19
    }
}
