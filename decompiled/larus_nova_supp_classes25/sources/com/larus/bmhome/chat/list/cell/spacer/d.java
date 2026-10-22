package com.larus.bmhome.chat.list.cell.spacer;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ View c;
    public final /* synthetic */ SpacerCell d;
    public final /* synthetic */ Ref.BooleanRef e;
    public final /* synthetic */ int f;
    public final /* synthetic */ Ref.IntRef g;
    public final /* synthetic */ boolean h;

    public /* synthetic */ d(int r1, int r2, View r3, SpacerCell r4, Ref.BooleanRef r5, int r6, Ref.IntRef r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r10) {
        int r0 = this.a;
        int r1 = this.b;
        View r2 = this.c;
        SpacerCell r3 = this.d;
        Ref.BooleanRef r4 = this.e;
        int r5 = this.f;
        Ref.IntRef r6 = this.g;
        boolean r7 = this.h;
        PathInterpolator r8 = SpacerCell.e;
        Intrinsics.checkNotNullParameter(r10, "animator");
        Object r11 = r10.getAnimatedValue();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Float");
        float r12 = ((Float) r11).floatValue();
        int r9 = r0 + ((int) ((r1 - r0) * r12));
        int r13 = r2.getHeight();
        r3.getClass();
        SpacerCell.x(r2, r9);
        if (r4.element == false) goto L23;
        int r14 = ((int) (r5 * r12)) - r6.element;
        if (r14 == 0) goto L20;
        if (r14 >= 0) goto L9;
        if (r7 == true) goto L9;
        r2.requestLayout();
        return;
    L9:
        int r15 = SpacerCell$c.b[r3.s(r14).ordinal()];
        if (r15 != 1) goto L12;
        r6.element += r14;
        return;
    L12:
        if (r15 != 2) goto L14;
        r2.requestLayout();
        return;
    L14:
        if (r15 != 3) goto L17;
        r4.element = false;
        return;
    L17:
        throw new NoWhenBranchMatchedException();
    L20:
        if (r13 == r9) goto L28;
        r2.requestLayout();
        return;
    L28:
        return;
    }
}
