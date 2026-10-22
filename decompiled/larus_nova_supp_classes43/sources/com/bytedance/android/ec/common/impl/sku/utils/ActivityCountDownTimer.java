package com.bytedance.android.ec.common.impl.sku.utils;

import com.bytedance.android.ec.core.utils.l1;
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

    public final void b() {
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

    public final void a(long r10, long r11, l1.a r12) {
        Intrinsics.checkNotNullParameter(r12, "listener");
        if (this.a != 0) goto L5;
        b();
        this.a++;
        TimeUnit r1 = TimeUnit.SECONDS;
        l1 r0 = new l1(r1.toMillis(r11 - r10), r1.toMillis(1), r12);
        this.b = r0;
        r0.d();
        return;
    L5:
        l1 r13 = this.b;
        if (r13 != null) goto L8;
        return;
    L8:
        if (r12 != r13.i) goto L10;
        return;
    L10:
        if (((ArrayList) r13.j).contains(r12) == true) goto L16;
        this.a++;
        ((ArrayList) r13.j).add(r12);
        return;
    }
}
