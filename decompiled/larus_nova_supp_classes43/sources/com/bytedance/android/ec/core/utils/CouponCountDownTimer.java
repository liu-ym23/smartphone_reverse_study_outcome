package com.bytedance.android.ec.core.utils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class CouponCountDownTimer {
    public static final Lazy c = null;
    public int a;
    public l1 b;

    public static final class a {
        public static CouponCountDownTimer a() {
            return (CouponCountDownTimer) CouponCountDownTimer.c.getValue();
        }
    }

    public CouponCountDownTimer() {
    }

    public final void b() {
        this.a = 0;
        l1 r0 = this.b;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.b = null;
        dm.a.a("CouponCountDownTimer").a("stopCountDown");
    }

    static {
        c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CouponCountDownTimer$Companion$instance$2.INSTANCE);
    }

    public final void a(long r10, long r11, l1.a r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "listener");
        if (this.a != 0) goto L5;
        b();
        this.a++;
        l1 r0 = new l1(TimeUnit.SECONDS.toMillis(r11 - r10), r13, r12);
        this.b = r0;
        r0.d();
    L12:
        dm.a.a("CouponCountDownTimer").a("startCountDown");
        return;
    L5:
        l1 r14 = this.b;
        if (r14 == null) goto L12;
        if (r12 == r14.i) goto L12;
        if (((ArrayList) r14.j).contains(r12) == true) goto L12;
        this.a++;
        ((ArrayList) r14.j).add(r12);
        goto L12
    }
}
