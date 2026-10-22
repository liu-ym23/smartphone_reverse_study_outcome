package com.obric.oui.material;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.obric.oui.color.a[] f13663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.obric.oui.color.a[] f13664c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ OMaterialDrawable e;
    public final /* synthetic */ int f;

    public /* synthetic */ j(com.obric.oui.color.a[] r5, com.obric.oui.color.a[] r10, OMaterialDrawable r11, int r12, Object r13) {
        this.f13662a = 0;
        this.f13663b = r5;
        this.f13664c = r10;
        this.e = r11;
        this.f = r12;
        this.d = r13;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r13) {
        switch(this.f13662a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        OMaterialDrawable r5 = this.e;
        int r10 = this.f;
        OMaterialDrawable.c(this.f13663b, this.f13664c, r5, r10, this.d, r13);
        return;
    L6:
        int r11 = this.f;
        Object r12 = this.d;
        OMaterialDrawable.e(this.f13663b, this.f13664c, this.e, r11, r12, r13);
    }

    public /* synthetic */ j(com.obric.oui.color.a[] r5, com.obric.oui.color.a[] r10, Object r11, OMaterialDrawable r12, int r13) {
        this.f13662a = 1;
        this.f13663b = r5;
        this.f13664c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
    }
}
