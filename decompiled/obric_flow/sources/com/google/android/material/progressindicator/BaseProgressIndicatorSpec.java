package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseProgressIndicatorSpec {
    public int hideAnimationBehavior;

    @NonNull
    public int[] indicatorColors;

    @Px
    public int indicatorTrackGapSize;
    public int showAnimationBehavior;

    @ColorInt
    public int trackColor;

    @Px
    public int trackCornerRadius;

    @Px
    public int trackThickness;

    public BaseProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        this.indicatorColors = new int[0];
        int r5 = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.BaseProgressIndicator, r12, r13, new int[0]);
        this.trackThickness = MaterialResources.getDimensionPixelSize(r10, r14, R.styleable.BaseProgressIndicator_trackThickness, r5);
        this.trackCornerRadius = Math.min(MaterialResources.getDimensionPixelSize(r10, r14, R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.trackThickness / 2);
        this.showAnimationBehavior = r14.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.hideAnimationBehavior = r14.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        this.indicatorTrackGapSize = r14.getDimensionPixelSize(R.styleable.BaseProgressIndicator_indicatorTrackGapSize, 0);
        loadIndicatorColors(r10, r14);
        loadTrackColor(r10, r14);
        r14.recycle();
    }

    private void loadIndicatorColors(@NonNull Context r5, @NonNull TypedArray r10) {
        if (r10.hasValue(R.styleable.BaseProgressIndicator_indicatorColor) == true) goto L7;
        this.indicatorColors = new int[]{MaterialColors.getColor(r5, R.attr.colorPrimary, -1)};
        return;
    L7:
        if (r10.peekValue(R.styleable.BaseProgressIndicator_indicatorColor).type == 1) goto L10;
        this.indicatorColors = new int[]{r10.getColor(R.styleable.BaseProgressIndicator_indicatorColor, -1)};
        return;
    L10:
        int[] r11 = r5.getResources().getIntArray(r10.getResourceId(R.styleable.BaseProgressIndicator_indicatorColor, -1));
        this.indicatorColors = r11;
        if (r11.length == 0) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    private void loadTrackColor(@NonNull Context r5, @NonNull TypedArray r10) {
        if (r10.hasValue(R.styleable.BaseProgressIndicator_trackColor) == false) goto L6;
        this.trackColor = r10.getColor(R.styleable.BaseProgressIndicator_trackColor, -1);
        return;
    L6:
        this.trackColor = this.indicatorColors[0];
        TypedArray r11 = r5.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float r12 = r11.getFloat(0, 0.2f);
        r11.recycle();
        int r13 = (int) (r12 * 255.0f);
        this.trackColor = MaterialColors.compositeARGBWithAlpha(this.trackColor, r13);
    }

    public boolean isHideAnimationEnabled() {
        if (this.hideAnimationBehavior == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isShowAnimationEnabled() {
        if (this.showAnimationBehavior == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @CallSuper
    public void validateSpec() {
        if (this.indicatorTrackGapSize < 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
    }
}
