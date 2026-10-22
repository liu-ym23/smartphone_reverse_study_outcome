package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: loaded from: classes2.dex */
public final class LinearProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    boolean drawHorizontallyInverse;
    public int indeterminateAnimationType;
    public int indicatorDirection;

    @Px
    public int trackStopIndicatorSize;

    public LinearProgressIndicatorSpec(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.linearProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    public void validateSpec() {
        super.validateSpec();
        if (this.trackStopIndicatorSize < 0) goto L20;
        if (this.indeterminateAnimationType == 0) goto L7;
        return;
    L7:
        if (this.trackCornerRadius <= 0) goto L14;
        if (this.indicatorTrackGapSize != 0) goto L14;
        throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
    L14:
        if (this.indicatorColors.length < 3) goto L17;
        return;
    L17:
        throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
    L20:
        throw new IllegalArgumentException("Stop indicator size must be >= 0.");
    }

    public LinearProgressIndicatorSpec(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11) {
        this(r5, r10, r11, LinearProgressIndicator.DEF_STYLE_RES);
    }

    public LinearProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(r10, r11, r12, r13);
        boolean r14 = false;
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.LinearProgressIndicator, R.attr.linearProgressIndicatorStyle, LinearProgressIndicator.DEF_STYLE_RES, new int[0]);
        this.indeterminateAnimationType = r15.getInt(R.styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.indicatorDirection = r15.getInt(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        this.trackStopIndicatorSize = Math.min(r15.getDimensionPixelSize(R.styleable.LinearProgressIndicator_trackStopIndicatorSize, 0), this.trackThickness);
        r15.recycle();
        validateSpec();
        if (this.indicatorDirection != 1) goto L5;
        r14 = true;
    L5:
        this.drawHorizontallyInverse = r14;
    }
}
