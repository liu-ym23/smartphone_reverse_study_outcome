package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f5164b;

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public void y(View r8, View r10, boolean r11, boolean r12) {
        AnimatorSet r13 = this.f5164b;
        if (r13 == null) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        r13.cancel();
    L8:
        AnimatorSet r15 = z(r8, r10, r11, r14);
        this.f5164b = r15;
        r15.addListener(new fa.a(this));
        this.f5164b.start();
        if (r12 == true) goto L12;
        this.f5164b.end();
        return;
    L12:
        return;
    L5:
        r14 = false;
        goto L6
    }

    public abstract AnimatorSet z(View r8, View r10, boolean r11, boolean r12);
}
