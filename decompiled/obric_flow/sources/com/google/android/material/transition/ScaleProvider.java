package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ScaleProvider implements VisibilityAnimatorProvider {
    private boolean growing;
    private float incomingEndScale;
    private float incomingStartScale;
    private float outgoingEndScale;
    private float outgoingStartScale;
    private boolean scaleOnDisappear;

    public ScaleProvider() {
        this(true);
    }

    private static Animator createScaleAnimator(final View r10, float r11, float r12) {
        final float r5 = r10.getScaleX();
        final float r13 = r10.getScaleY();
        ObjectAnimator r14 = ObjectAnimator.ofPropertyValuesHolder(r10, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{r5 * r11, r5 * r12}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{r11 * r13, r12 * r13})});
        r14.addListener(new AnonymousClass1(r10, r5, r13));
        return r14;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r5, @NonNull View r10) {
        if (this.growing == false) goto L7;
        return createScaleAnimator(r10, this.incomingStartScale, this.incomingEndScale);
    L7:
        return createScaleAnimator(r10, this.outgoingEndScale, this.outgoingStartScale);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup r5, @NonNull View r10) {
        if (this.scaleOnDisappear == true) goto L7;
        return null;
    L7:
        if (this.growing == false) goto L11;
        return createScaleAnimator(r10, this.outgoingStartScale, this.outgoingEndScale);
    L11:
        return createScaleAnimator(r10, this.incomingEndScale, this.incomingStartScale);
    }

    public float getIncomingEndScale() {
        return this.incomingEndScale;
    }

    public float getIncomingStartScale() {
        return this.incomingStartScale;
    }

    public float getOutgoingEndScale() {
        return this.outgoingEndScale;
    }

    public float getOutgoingStartScale() {
        return this.outgoingStartScale;
    }

    public boolean isGrowing() {
        return this.growing;
    }

    public boolean isScaleOnDisappear() {
        return this.scaleOnDisappear;
    }

    public void setGrowing(boolean r5) {
        this.growing = r5;
    }

    public void setIncomingEndScale(float r5) {
        this.incomingEndScale = r5;
    }

    public void setIncomingStartScale(float r5) {
        this.incomingStartScale = r5;
    }

    public void setOutgoingEndScale(float r5) {
        this.outgoingEndScale = r5;
    }

    public void setOutgoingStartScale(float r5) {
        this.outgoingStartScale = r5;
    }

    public void setScaleOnDisappear(boolean r5) {
        this.scaleOnDisappear = r5;
    }

    public ScaleProvider(boolean r5) {
        this.outgoingStartScale = 1.0f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1.0f;
        this.scaleOnDisappear = true;
        this.growing = r5;
    }
}
