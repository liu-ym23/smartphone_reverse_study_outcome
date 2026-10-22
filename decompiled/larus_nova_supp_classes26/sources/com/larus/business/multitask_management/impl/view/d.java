package com.larus.business.multitask_management.impl.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ c d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        if (this.a == false) goto L5;
        return;
    L5:
        Lazy r7 = TaskProgressMockCache.a;
        TaskProgressMockCache.d(this.b, this.c);
        c r8 = this.d;
        Integer r0 = r8.c;
        if (r0 == null) goto L8;
        int r1 = r0.intValue();
    L9:
        int r9 = r8.c(r1, this.d.d, RangesKt.coerceIn(this.c, 0, 500));
        this.d.f(this.b, RangesKt.coerceIn(this.c, 0, 500), r9, this.d.d);
        return;
    L8:
        r1 = 0;
        goto L9
    }

    public d(String r1, int r2, c r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
