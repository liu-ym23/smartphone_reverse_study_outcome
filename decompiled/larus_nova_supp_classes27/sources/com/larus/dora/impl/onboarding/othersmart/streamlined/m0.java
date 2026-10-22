package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m0 extends AnimatorListenerAdapter {
    public final /* synthetic */ DoraHStreamlinedWakeupFragment a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ float c;
    public final /* synthetic */ Ref.FloatRef d;
    public final /* synthetic */ RecyclerView e;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        DoraHStreamlinedWakeupFragment r4 = this.a;
        r4.A = null;
        this.b.element = true;
        r4.w = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.A = null;
        if (this.b.element == false) goto L5;
        return;
    L5:
        int r4 = MathKt.roundToInt(this.c - this.d.element);
        if (r4 == 0) goto L8;
        this.e.scrollBy(0, r4);
    L8:
        DoraHStreamlinedWakeupFragment r5 = this.a;
        r5.w = false;
        r5.la0(r5.u + 1, false);
    }

    public m0(DoraHStreamlinedWakeupFragment r1, Ref.BooleanRef r2, float r3, Ref.FloatRef r4, RecyclerView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
