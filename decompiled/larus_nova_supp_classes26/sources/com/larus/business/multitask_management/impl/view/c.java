package com.larus.business.multitask_management.impl.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final int a;
    public final long b;
    public Integer c;
    public Long d;
    public final LinkedHashSet<b0> e;
    public ValueAnimator f;
    public ValueAnimator g;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            c r4 = this.a;
            String r0 = this.b;
            Lazy r1 = TaskProgressMockCache.a;
            r4.e(r0, TaskProgressMockCache.a(r0));
        }

        public b(c r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public c() {
        this.a = 470;
        this.b = 600;
        this.e = new LinkedHashSet();
    }

    public final void a(t r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.e.contains(r2) == true) goto L6;
        this.e.add(r2);
        return;
    }

    public final void d(t r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e.remove(r2);
    }

    public final void e(String r3, int r4) {
        int r5 = RangesKt.coerceIn(r4, 0, 500);
        Lazy r0 = TaskProgressMockCache.a;
        TaskProgressMockCache.d(r3, r5);
        if (this.e.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r6 = CollectionsKt.toList(this.e).iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((b0) r6.next()).onProgress(r5);
        goto L7
    }

    public final void b(final String r10, int r11, Long r12) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        int r13 = RangesKt.coerceIn(r11 * 5, 0, 500);
        Lazy r2 = TaskProgressMockCache.a;
        int r3 = TaskProgressMockCache.a(r10);
        int r4 = Math.max(r13, r3);
        if (r3 > 0) goto L5;
        int r5 = r4;
    L6:
        e(r10, r5);
        long r6 = 0;
        if (500 <= r13) goto L12;
        if (r12 == null) goto L11;
        r6 = r12.longValue();
    L11:
        r6 = (r6 * ((long) (500 - r4))) / ((long) (500 - r13));
    L12:
        FLogger r1 = FLogger.a;
        r1.d("multitask-CappedRemainingSecondsProgressStrategy", "bind " + r10 + ", progress " + r13 + ", remainingSeconds " + r12 + ", portioned remainingSeconds " + r6 + ", cached " + r3 + ", baseline " + r4 + ", current " + r5);
        Integer r14 = this.c;
        if (r14 != null) goto L16;
    L23:
        this.c = Integer.valueOf(r13);
        this.d = Long.valueOf(r6);
        int r15 = c(r13, Long.valueOf(r6), r4);
        ValueAnimator r16 = this.g;
        if (r16 == null) goto L26;
        r16.cancel();
    L26:
        this.g = null;
        if (r5 >= r4) goto L32;
        r1.d("multitask-CappedRemainingSecondsProgressStrategy", "startTransition " + r10 + ", from " + r5 + ", to " + r4);
        ValueAnimator r17 = this.f;
        if (r17 == null) goto L31;
        r17.cancel();
    L31:
        ValueAnimator r18 = ValueAnimator.ofInt(new int[]{r5, r4});
        r18.setDuration(((long) RangesKt.coerceIn(Math.abs(r4 - r5), 1, 20)) * 100);
        r18.setInterpolator(new DecelerateInterpolator());
        r18.addUpdateListener(new com.larus.business.multitask_management.impl.view.a(this, r10));
        r18.addListener(new d(r10, r4, this));
        this.f = r18;
        r18.start();
        return;
    L32:
        ValueAnimator r0 = this.f;
        if (r0 == null) goto L35;
        r0.cancel();
    L35:
        this.f = null;
        f(r10, r4, r15, Long.valueOf(r6));
        return;
    L16:
        if (r13 != r14.intValue()) goto L23;
        Long r19 = this.d;
        if (r19 == null) goto L23;
        if (r6 != r19.longValue()) goto L23;
        return;
    L5:
        r5 = RangesKt.coerceIn(r3, 0, 500);
        goto L6
    }

    public final int c(int r4, Long r5, int r6) {
        if (r4 < 500) goto L5;
        return 500;
    L5:
        if (r5 != null) goto L7;
    L11:
        return r6;
    L7:
        if (r5.longValue() <= 0) goto L11;
        return Math.max(r6, RangesKt.coerceIn(this.a, 0, 470));
    }

    public final void f(final String r9, int r10, int r11, Long r12) {
        FLogger.a.d("multitask-CappedRemainingSecondsProgressStrategy", "startMockIfNeeded " + r9 + ", from " + r10 + ", to " + r11 + ", remainingSeconds " + r12);
        if (r10 < r11) goto L6;
        return;
    L6:
        if (r12 != null) goto L8;
    L11:
        long r2 = 0;
    L13:
        if (r2 > 0) goto L15;
        return;
    L15:
        ValueAnimator r13 = this.g;
        if (r13 == null) goto L18;
        r13.cancel();
    L18:
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{r10, r11});
        r14.setDuration(r2);
        r14.setInterpolator(new DecelerateInterpolator());
        r14.addUpdateListener(new com.larus.business.multitask_management.impl.view.b(this, r9));
        r14.addListener(new b(this, r9));
        this.g = r14;
        r14.start();
        return;
    L8:
        if (r12.longValue() <= 0) goto L11;
        double r3 = r12.longValue();
        r2 = RangesKt.coerceAtLeast(MathKt.roundToLong(Math.min(1.2d * r3, r3 + 10.0d) * 1000.0d), this.b);
        goto L13
    }
}
