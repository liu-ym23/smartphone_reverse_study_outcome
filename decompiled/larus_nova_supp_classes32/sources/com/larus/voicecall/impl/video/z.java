package com.larus.voicecall.impl.video;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z implements Animator.AnimatorListener {
    public final /* synthetic */ y a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ ViewPortContainerView c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;
    public final /* synthetic */ float f;
    public final /* synthetic */ Function0 g;
    public final /* synthetic */ ViewPortContainerView h;
    public final /* synthetic */ float i;
    public final /* synthetic */ float j;
    public final /* synthetic */ float k;
    public final /* synthetic */ boolean l;
    public final /* synthetic */ ViewPortContainerView m;
    public final /* synthetic */ float n;
    public final /* synthetic */ float o;
    public final /* synthetic */ float p;
    public final /* synthetic */ Function0 q;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        this.h.setScaleX(this.i);
        this.h.setScaleY(this.i);
        this.h.setTranslationX(this.j);
        this.h.setTranslationY(this.k);
        this.a.getClass();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        this.a.getClass();
        if (this.b == true) goto L5;
        this.c.setScaleX(this.d);
        this.c.setScaleY(this.d);
        this.c.setTranslationX(this.e);
        this.c.setTranslationY(this.f);
    L5:
        Function0 r3 = this.g;
        if (r3 == null) goto L9;
        r3.invoke();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        this.a.getClass();
        if (this.l == false) goto L5;
        this.m.setScaleX(this.n);
        this.m.setScaleY(this.n);
        this.m.setTranslationX(this.o);
        this.m.setTranslationY(this.p);
    L5:
        Function0 r3 = this.q;
        if (r3 == null) goto L9;
        r3.invoke();
        return;
    }

    public z(y r3, boolean r4, ViewPortContainerView r5, float r6, float r7, float r8, Function0 r9, ViewPortContainerView r10, float r11, float r12, float r13, boolean r14, ViewPortContainerView r15, float r16, float r17, float r18, Function0 r19) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
    }
}
