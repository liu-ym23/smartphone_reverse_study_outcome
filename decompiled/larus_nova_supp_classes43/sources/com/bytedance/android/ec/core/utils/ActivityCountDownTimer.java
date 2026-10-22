package com.bytedance.android.ec.core.utils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ActivityCountDownTimer {
    public static final Lazy c = null;
    public int a;
    public l1 b;

    public static final class a {
        public static ActivityCountDownTimer a() {
            return (ActivityCountDownTimer) ActivityCountDownTimer.c.getValue();
        }
    }

    public ActivityCountDownTimer() {
    }

    public final void c() {
        this.a = 0;
        l1 r0 = this.b;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.b = null;
    }

    static {
        c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ActivityCountDownTimer$Companion$instance$2.INSTANCE);
    }

    public static /* synthetic */ void b(ActivityCountDownTimer r10, long r11, long r12, l1.a r13) {
        r10.a(r11, r12, r13, null);
    }

    public final void a(long r10, long r11, l1.a r12, Long r13) {
        Intrinsics.checkNotNullParameter(r12, "listener");
        if (this.a != 0) goto L9;
        c();
        this.a++;
        TimeUnit r1 = TimeUnit.SECONDS;
        long r14 = r1.toMillis(r11 - r10);
        if (r13 == null) goto L7;
        long r15 = r13.longValue();
    L8:
        l1 r0 = new l1(r14, r15, r12);
        this.b = r0;
        r0.d();
        return;
    L7:
        r15 = r1.toMillis(1);
        goto L8
    L9:
        l1 r16 = this.b;
        if (r16 != null) goto L12;
        return;
    L12:
        if (r12 != r16.i) goto L14;
        return;
    L14:
        if (((ArrayList) r16.j).contains(r12) == true) goto L20;
        this.a++;
        ((ArrayList) r16.j).add(r12);
        return;
    }
}
