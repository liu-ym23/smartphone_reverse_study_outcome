package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = 0;
    public static final int INDICATOR_DIRECTION_CLOCKWISE = 0;
    public static final int INDICATOR_DIRECTION_COUNTERCLOCKWISE = 1;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_CircularProgressIndicator;
    }

    public CircularProgressIndicator(@NonNull Context r5) {
        this(r5, null);
    }

    private void initializeDrawables() {
        CircularDrawingDelegate r5 = new CircularDrawingDelegate((CircularProgressIndicatorSpec) this.spec);
        setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec, r5));
        setProgressDrawable(DeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec, r5));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public /* bridge */ /* synthetic */ BaseProgressIndicatorSpec createSpec(@NonNull Context r5, @NonNull AttributeSet r10) {
        return createSpec(r5, r10);
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    @Px
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
    }

    @Px
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize;
    }

    public void setIndicatorDirection(int r5) {
        ((CircularProgressIndicatorSpec) this.spec).indicatorDirection = r5;
        invalidate();
    }

    public void setIndicatorInset(@Px int r5) {
        S r10 = this.spec;
        if (((CircularProgressIndicatorSpec) r10).indicatorInset == r5) goto L6;
        ((CircularProgressIndicatorSpec) r10).indicatorInset = r5;
        invalidate();
        return;
    }

    public void setIndicatorSize(@Px int r5) {
        int r10 = Math.max(r5, getTrackThickness() * 2);
        S r11 = this.spec;
        if (((CircularProgressIndicatorSpec) r11).indicatorSize == r10) goto L6;
        ((CircularProgressIndicatorSpec) r11).indicatorSize = r10;
        ((CircularProgressIndicatorSpec) r11).validateSpec();
        requestLayout();
        invalidate();
        return;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int r5) {
        super.setTrackThickness(r5);
        ((CircularProgressIndicatorSpec) this.spec).validateSpec();
    }

    public CircularProgressIndicator(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.circularProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public CircularProgressIndicatorSpec createSpec(@NonNull Context r5, @NonNull AttributeSet r10) {
        return new CircularProgressIndicatorSpec(r5, r10);
    }

    public CircularProgressIndicator(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11) {
        super(r5, r10, r11, DEF_STYLE_RES);
        initializeDrawables();
    }
}
