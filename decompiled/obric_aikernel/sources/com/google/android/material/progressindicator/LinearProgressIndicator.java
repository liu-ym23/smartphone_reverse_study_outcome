package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import q5.k;

/* JADX INFO: loaded from: classes.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f3516t = 0;

    static {
        f3516t = k.Widget_MaterialComponents_LinearProgressIndicator;
    }

    public LinearProgressIndicator(@NonNull Context r10) {
        this(r10, null);
    }

    public LinearProgressIndicator(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        super(r10, r11, r12, f3516t);
        s();
    }

    private void s() {
        setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.f3495c));
        setProgressDrawable(DeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.f3495c));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f3495c).f3517g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f3495c).f3518h;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* bridge */ /* synthetic */ b i(@NonNull Context r10, @NonNull AttributeSet r11) {
        return r(r10, r11);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void o(int r10, boolean r11) {
        S r12 = this.f3495c;
        if (r12 != 0) goto L5;
    L9:
        super.o(r10, r11);
        return;
    L5:
        if (((LinearProgressIndicatorSpec) r12).f3517g != 0) goto L9;
        if (isIndeterminate() == false) goto L9;
    }

    @Override // android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        S r15 = this.f3495c;
        LinearProgressIndicatorSpec r16 = (LinearProgressIndicatorSpec) r15;
        boolean r17 = true;
        if (((LinearProgressIndicatorSpec) r15).f3518h != 1) goto L5;
    L14:
        r16.f3519i = r17;
        return;
    L5:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        if (((LinearProgressIndicatorSpec) this.f3495c).f3518h == 2) goto L14;
    L9:
        if (ViewCompat.getLayoutDirection(this) == 0) goto L11;
    L13:
        r17 = false;
        goto L14
    L11:
        if (((LinearProgressIndicatorSpec) this.f3495c).f3518h != 3) goto L13;
        goto L13
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        int r14 = r10 - (getPaddingLeft() + getPaddingRight());
        int r15 = r11 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable<LinearProgressIndicatorSpec> r16 = getIndeterminateDrawable();
        if (r16 == null) goto L5;
        r16.setBounds(0, 0, r14, r15);
    L5:
        DeterminateDrawable<LinearProgressIndicatorSpec> r17 = getProgressDrawable();
        if (r17 == null) goto L9;
        r17.setBounds(0, 0, r14, r15);
        return;
    }

    LinearProgressIndicatorSpec r(@NonNull Context r10, @NonNull AttributeSet r11) {
        return new LinearProgressIndicatorSpec(r10, r11);
    }

    public void setIndeterminateAnimationType(int r10) {
        if (((LinearProgressIndicatorSpec) this.f3495c).f3517g != r10) goto L6;
        return;
    L6:
        if (q() == true) goto L8;
    L12:
        S r11 = this.f3495c;
        ((LinearProgressIndicatorSpec) r11).f3517g = r10;
        ((LinearProgressIndicatorSpec) r11).e();
        if (r10 != 0) goto L15;
        IndeterminateDrawable<LinearProgressIndicatorSpec> r12 = getIndeterminateDrawable();
        f<ObjectAnimator> r13 = new h((LinearProgressIndicatorSpec) this.f3495c);
    L16:
        r12.setAnimatorDelegate(r13);
        invalidate();
        return;
    L15:
        r12 = getIndeterminateDrawable();
        r13 = new i(getContext(), (LinearProgressIndicatorSpec) this.f3495c);
        goto L16
    L8:
        if (isIndeterminate() == false) goto L12;
        throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... r10) {
        super.setIndicatorColor(r10);
        ((LinearProgressIndicatorSpec) this.f3495c).e();
    }

    public void setIndicatorDirection(int r10) {
        S r11 = this.f3495c;
        ((LinearProgressIndicatorSpec) r11).f3518h = r10;
        LinearProgressIndicatorSpec r12 = (LinearProgressIndicatorSpec) r11;
        boolean r13 = true;
        if (r10 != 1) goto L5;
    L14:
        r12.f3519i = r13;
        invalidate();
        return;
    L5:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        if (((LinearProgressIndicatorSpec) this.f3495c).f3518h == 2) goto L14;
    L9:
        if (ViewCompat.getLayoutDirection(this) == 0) goto L11;
    L13:
        r13 = false;
        goto L14
    L11:
        if (r10 != 3) goto L13;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int r10) {
        super.setTrackCornerRadius(r10);
        ((LinearProgressIndicatorSpec) this.f3495c).e();
        invalidate();
    }
}
