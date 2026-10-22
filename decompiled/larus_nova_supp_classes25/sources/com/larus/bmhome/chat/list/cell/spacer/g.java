package com.larus.bmhome.chat.list.cell.spacer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.PathInterpolator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ SpacerCell b;
    public final /* synthetic */ View c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Ref.BooleanRef e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ int g;
    public final /* synthetic */ Ref.IntRef h;
    public final /* synthetic */ Function0<Unit> i;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        if (this.a == false) goto L5;
        return;
    L5:
        SpacerCell r5 = this.b;
        View r0 = this.c;
        int r1 = this.d;
        PathInterpolator r2 = SpacerCell.e;
        r5.getClass();
        SpacerCell.x(r0, r1);
        if (this.e.element == true) goto L8;
    L11:
        Function0<Unit> r6 = this.i;
        if (r6 == null) goto L15;
        r6.invoke();
        return;
    L15:
        return;
    L8:
        if (this.f == false) goto L10;
        SpacerCell.o(this.b, this.c, this.g - this.h.element);
        goto L11
    L10:
        this.b.u(Integer.MAX_VALUE);
        goto L11
    }

    public g(SpacerCell r1, View r2, int r3, Ref.BooleanRef r4, boolean r5, int r6, Ref.IntRef r7, Function0<Unit> r8) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
    }
}
