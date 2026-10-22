package com.ss.android.lark.chat.message.menu.v2;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ b0 b;

    public e0(Ref.IntRef r1, b0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r9) {
        Intrinsics.checkNotNullParameter(r9, "it");
        Object r0 = r9.getAnimatedValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Int");
        int r1 = ((Integer) r0).intValue() - this.a.element;
        b0 r2 = this.b;
        float r3 = r1;
        r2.getClass();
        boolean r4 = true;
        if (r3 != 0.0f) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == true) goto L37;
        if (r3 >= 0.0f) goto L22;
        int r5 = r2.f;
        if (r5 > 0) goto L13;
        r4 = false;
    L13:
        r2.p = r4;
        if (r5 <= Math.abs(r3)) goto L16;
        Number r6 = Float.valueOf(r3);
    L17:
        int r8 = r6.intValue();
        float r10 = r3 - r8;
        if (r2.g > Math.abs(r10)) goto L21;
        r10 = -r2.g;
    L21:
        r2.f += r8;
        r2.g += r10;
        r2.c.scrollBy(0, r8);
        r2.c.setTranslationY(r2.n - r2.g);
        goto L37
    L16:
        r6 = Integer.valueOf(-r2.f);
        goto L17
    L22:
        int r11 = (int) r3;
        if (r2.p == true) goto L26;
        r11 = 0;
    L31:
        r2.f += r11;
        float r12 = r3 - r11;
        if (r12 == 0.0f) goto L35;
        r4 = false;
    L35:
        if (r4 == true) goto L37;
        float r13 = r2.g + r12;
        r2.g = r13;
        r2.c.setTranslationY(r2.n - r13);
        goto L37
    L26:
        if (r2.e.a() == true) goto L28;
        r2.c.scrollBy(0, r11);
        goto L31
    L28:
        r2.c.scrollBy(0, r11);
        if (r2.c.canScrollVertically(1) == true) goto L31;
        r2.p = false;
        r2.a.getLocationOnScreen(r2.m);
        r11 = (((r2.q + r2.h) - r2.m[1]) - r2.f) - ((int) r2.g);
    L37:
        Ref.IntRef r14 = this.a;
        Object r15 = r9.getAnimatedValue();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Int");
        r14.element = ((Integer) r15).intValue();
        return;
    L5:
        r7 = false;
        goto L6
    }
}
