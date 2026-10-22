package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FadeThroughDrawable extends Drawable {
    private final float[] alphas;
    private final Drawable fadeInDrawable;
    private final Drawable fadeOutDrawable;
    private float progress;

    public FadeThroughDrawable(@NonNull Drawable r5, @NonNull Drawable r10) {
        this.fadeOutDrawable = r5.getConstantState().newDrawable().mutate();
        Drawable r11 = r10.getConstantState().newDrawable().mutate();
        this.fadeInDrawable = r11;
        r11.setAlpha(0);
        this.alphas = new float[2];
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r5) {
        this.fadeOutDrawable.draw(r5);
        this.fadeInDrawable.draw(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.fadeOutDrawable.getIntrinsicHeight(), this.fadeInDrawable.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.fadeOutDrawable.getIntrinsicWidth(), this.fadeInDrawable.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.fadeOutDrawable.getMinimumHeight(), this.fadeInDrawable.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.fadeOutDrawable.getMinimumWidth(), this.fadeInDrawable.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.fadeOutDrawable.isStateful() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.fadeInDrawable.isStateful() == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        if (this.progress > 0.5f) goto L5;
        this.fadeOutDrawable.setAlpha(r5);
        this.fadeInDrawable.setAlpha(0);
    L6:
        invalidateSelf();
        return;
    L5:
        this.fadeOutDrawable.setAlpha(0);
        this.fadeInDrawable.setAlpha(r5);
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r5, int r10, int r11, int r12) {
        super.setBounds(r5, r10, r11, r12);
        this.fadeOutDrawable.setBounds(r5, r10, r11, r12);
        this.fadeInDrawable.setBounds(r5, r10, r11, r12);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r5) {
        this.fadeOutDrawable.setColorFilter(r5);
        this.fadeInDrawable.setColorFilter(r5);
        invalidateSelf();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        if (this.progress == r5) goto L6;
        this.progress = r5;
        FadeThroughUtils.calculateFadeOutAndInAlphas(r5, this.alphas);
        this.fadeOutDrawable.setAlpha((int) (this.alphas[0] * 255.0f));
        this.fadeInDrawable.setAlpha((int) (this.alphas[1] * 255.0f));
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r5) {
        boolean r10 = this.fadeOutDrawable.setState(r5);
        boolean r11 = this.fadeInDrawable.setState(r5);
        if (r10 == true) goto L7;
        if (r11 == true) goto L7;
        return false;
    L7:
        return true;
    }
}
