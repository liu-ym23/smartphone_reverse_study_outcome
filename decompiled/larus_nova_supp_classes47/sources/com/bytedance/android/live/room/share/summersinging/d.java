package com.bytedance.android.live.room.share.summersinging;

import android.animation.ValueAnimator;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GroupPhotoDialogFragment a;

    public d(GroupPhotoDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        ConstraintLayout r0 = this.a.e;
        if (r0 == null) goto L40;
        Object r1 = r6.getAnimatedValue("xOffset");
        Object r3 = null;
        if ((r1 instanceof Float) == true) goto L7;
        r1 = null;
    L7:
        Float r2 = (Float) r1;
        float r4 = 0.0f;
        if (r2 == null) goto L10;
        float r5 = r2.floatValue();
    L11:
        r0.setTranslationX(r5);
        Object r7 = r6.getAnimatedValue("yOffset");
        if ((r7 instanceof Float) == true) goto L14;
        r7 = null;
    L14:
        Float r8 = (Float) r7;
        if (r8 == null) goto L17;
        float r9 = r8.floatValue();
    L18:
        r0.setTranslationY(r9);
        Object r10 = r6.getAnimatedValue("scale");
        if ((r10 instanceof Float) == true) goto L21;
        r10 = null;
    L21:
        Float r12 = (Float) r10;
        if (r12 == null) goto L24;
        float r13 = r12.floatValue();
        r0.setScaleX(r13);
        r0.setScaleY(r13);
    L24:
        Object r14 = r6.getAnimatedValue("rotation");
        if ((r14 instanceof Float) == true) goto L27;
        r14 = null;
    L27:
        Float r15 = (Float) r14;
        if (r15 == null) goto L30;
        float r16 = r15.floatValue();
    L31:
        r0.setRotation(r16);
        Object r17 = r6.getAnimatedValue("alpha");
        if ((r17 instanceof Float) == false) goto L35;
        r3 = r17;
    L35:
        Float r18 = (Float) r3;
        if (r18 == null) goto L38;
        r4 = r18.floatValue();
    L38:
        r0.setAlpha(r4);
        return;
    L30:
        r16 = 0.0f;
        goto L31
    L17:
        r9 = 0.0f;
        goto L18
    L10:
        r5 = 0.0f;
        goto L11
    }
}
