package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_DISJOINT = 1;
    public static final int INDICATOR_DIRECTION_END_TO_START = 3;
    public static final int INDICATOR_DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int INDICATOR_DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int INDICATOR_DIRECTION_START_TO_END = 2;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndeterminateAnimationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_LinearProgressIndicator;
    }

    public LinearProgressIndicator(@NonNull Context r5) {
        this(r5, null);
    }

    private void initializeDrawables() {
        LinearDrawingDelegate r5 = new LinearDrawingDelegate((LinearProgressIndicatorSpec) this.spec);
        setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec, r5));
        setProgressDrawable(DeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec, r5));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public /* bridge */ /* synthetic */ BaseProgressIndicatorSpec createSpec(@NonNull Context r5, @NonNull AttributeSet r10) {
        return createSpec(r5, r10);
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    @Px
    public int getTrackStopIndicatorSize() {
        return ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize;
    }

    @Override // android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        S r14 = this.spec;
        LinearProgressIndicatorSpec r15 = (LinearProgressIndicatorSpec) r14;
        boolean r16 = true;
        if (((LinearProgressIndicatorSpec) r14).indicatorDirection != 1) goto L5;
    L14:
        r15.drawHorizontallyInverse = r16;
        return;
    L5:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        if (((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) goto L14;
    L9:
        if (ViewCompat.getLayoutDirection(this) == 0) goto L11;
    L13:
        r16 = false;
        goto L14
    L11:
        if (((LinearProgressIndicatorSpec) this.spec).indicatorDirection != 3) goto L13;
        goto L13
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        int r13 = getPaddingLeft();
        int r14 = r5 - (getPaddingRight() + r13);
        int r15 = getPaddingTop();
        int r16 = r10 - (getPaddingBottom() + r15);
        IndeterminateDrawable<LinearProgressIndicatorSpec> r17 = getIndeterminateDrawable();
        if (r17 == null) goto L5;
        r17.setBounds(0, 0, r14, r16);
    L5:
        DeterminateDrawable<LinearProgressIndicatorSpec> r18 = getProgressDrawable();
        if (r18 == null) goto L9;
        r18.setBounds(0, 0, r14, r16);
        return;
    }

    public void setIndeterminateAnimationType(int r5) {
        if (((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType != r5) goto L6;
        return;
    L6:
        if (visibleToUser() == true) goto L8;
    L12:
        S r10 = this.spec;
        ((LinearProgressIndicatorSpec) r10).indeterminateAnimationType = r5;
        ((LinearProgressIndicatorSpec) r10).validateSpec();
        if (r5 != 0) goto L15;
        getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec) this.spec));
    L16:
        invalidate();
        return;
    L15:
        getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec) this.spec));
        goto L16
    L8:
        if (isIndeterminate() == false) goto L12;
        throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... r5) {
        super.setIndicatorColor(r5);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
    }

    public void setIndicatorDirection(int r5) {
        S r10 = this.spec;
        ((LinearProgressIndicatorSpec) r10).indicatorDirection = r5;
        LinearProgressIndicatorSpec r11 = (LinearProgressIndicatorSpec) r10;
        boolean r12 = true;
        if (r5 != 1) goto L5;
    L14:
        r11.drawHorizontallyInverse = r12;
        invalidate();
        return;
    L5:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        if (((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) goto L14;
    L9:
        if (ViewCompat.getLayoutDirection(this) == 0) goto L11;
    L13:
        r12 = false;
        goto L14
    L11:
        if (r5 != 3) goto L13;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int r5, boolean r10) {
        S r11 = this.spec;
        if (r11 != 0) goto L5;
    L9:
        super.setProgressCompat(r5, r10);
        return;
    L5:
        if (((LinearProgressIndicatorSpec) r11).indeterminateAnimationType != 0) goto L9;
        if (isIndeterminate() == false) goto L9;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int r5) {
        super.setTrackCornerRadius(r5);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
        invalidate();
    }

    public void setTrackStopIndicatorSize(@Px int r5) {
        S r10 = this.spec;
        if (((LinearProgressIndicatorSpec) r10).trackStopIndicatorSize == r5) goto L6;
        LinearProgressIndicatorSpec r11 = (LinearProgressIndicatorSpec) r10;
        r11.trackStopIndicatorSize = Math.min(r5, ((LinearProgressIndicatorSpec) r10).trackThickness);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
        invalidate();
        return;
    }

    public LinearProgressIndicator(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.linearProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public LinearProgressIndicatorSpec createSpec(@NonNull Context r5, @NonNull AttributeSet r10) {
        return new LinearProgressIndicatorSpec(r5, r10);
    }

    public LinearProgressIndicator(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11) {
        super(r5, r10, r11, DEF_STYLE_RES);
        initializeDrawables();
    }
}
