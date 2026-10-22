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
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    public int indicatorDirection;

    @Px
    public int indicatorInset;

    @Px
    public int indicatorSize;

    public CircularProgressIndicatorSpec(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.circularProgressIndicatorStyle);
    }

    public int getIndicatorTrackGapSizeDegree() {
        int r5 = this.indicatorTrackGapSize;
        if (r5 != 0) goto L7;
        return 0;
    L7:
        return (int) Math.round(360.0d / ((((double) ((this.indicatorSize - (this.indicatorInset * 2)) - this.trackThickness)) * 3.141592653589793d) / ((double) (r5 + this.trackCornerRadius))));
    }

    public CircularProgressIndicatorSpec(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11) {
        this(r5, r10, r11, CircularProgressIndicator.DEF_STYLE_RES);
    }

    public CircularProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(r10, r11, r12, r13);
        int r5 = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int r14 = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.CircularProgressIndicator, r12, r13, new int[0]);
        this.indicatorSize = Math.max(MaterialResources.getDimensionPixelSize(r10, r15, R.styleable.CircularProgressIndicator_indicatorSize, r5), this.trackThickness * 2);
        this.indicatorInset = MaterialResources.getDimensionPixelSize(r10, r15, R.styleable.CircularProgressIndicator_indicatorInset, r14);
        this.indicatorDirection = r15.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        r15.recycle();
        validateSpec();
    }
}
