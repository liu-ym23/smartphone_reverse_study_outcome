package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.k;
import java.util.ArrayList;
import java.util.List;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class RangeSlider extends BaseSlider<RangeSlider, Object, Object> {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private float f3753l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private int f3754m0;

    static class RangeSliderState extends AbsSavedState {
        public static final Parcelable.Creator<RangeSliderState> CREATOR = null;
        private float minSeparation;
        private int separationUnit;

        class a implements Parcelable.Creator<RangeSliderState> {
            a() {
            }

            public RangeSliderState a(Parcel r10) {
                return new RangeSliderState(r10, null);
            }

            public RangeSliderState[] b(int r10) {
                return new RangeSliderState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ RangeSliderState createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ RangeSliderState[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        private RangeSliderState(Parcel r10) {
            super(r10.readParcelable(RangeSliderState.class.getClassLoader()));
            this.minSeparation = r10.readFloat();
            this.separationUnit = r10.readInt();
        }

        /* synthetic */ RangeSliderState(Parcel r10, a r11) {
            this(r10);
        }

        RangeSliderState(Parcelable r10) {
            super(r10);
        }

        static /* synthetic */ float access$000(RangeSliderState r10) {
            return r10.minSeparation;
        }

        static /* synthetic */ float access$002(RangeSliderState r10, float r11) {
            r10.minSeparation = r11;
            return r11;
        }

        static /* synthetic */ int access$100(RangeSliderState r10) {
            return r10.separationUnit;
        }

        static /* synthetic */ int access$102(RangeSliderState r10, int r11) {
            r10.separationUnit = r11;
            return r11;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeFloat(this.minSeparation);
            r10.writeInt(this.separationUnit);
        }
    }

    static /* synthetic */ class a {
    }

    public RangeSlider(@NonNull Context r10) {
        this(r10, null);
    }

    public RangeSlider(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.sliderStyle);
    }

    public RangeSlider(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        TypedArray r13 = k.h(r10, r11, l.RangeSlider, r12, BaseSlider.f3714k0, new int[0]);
        int r14 = l.RangeSlider_values;
        if (r13.hasValue(r14) == false) goto L5;
        int r15 = r13.getResourceId(r14, 0);
        setValues(t0(r13.getResources().obtainTypedArray(r15)));
    L5:
        this.f3753l0 = r13.getDimension(l.RangeSlider_minSeparation, 0.0f);
        r13.recycle();
    }

    private static List<Float> t0(TypedArray r10) {
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L6;
        r11.add(Float.valueOf(r10.getFloat(r12, -1.0f)));
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    @NonNull
    public /* bridge */ /* synthetic */ CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getActiveThumbIndex() {
        return super.getActiveThumbIndex();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getFocusedThumbIndex() {
        return super.getFocusedThumbIndex();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @Dimension
    public /* bridge */ /* synthetic */ int getHaloRadius() {
        return super.getHaloRadius();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getHaloTintList() {
        return super.getHaloTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getLabelBehavior() {
        return super.getLabelBehavior();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public float getMinSeparation() {
        return this.f3753l0;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getStepSize() {
        return super.getStepSize();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getThumbElevation() {
        return super.getThumbElevation();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @Dimension
    public /* bridge */ /* synthetic */ int getThumbRadius() {
        return super.getThumbRadius();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getThumbStrokeColor() {
        return super.getThumbStrokeColor();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getThumbStrokeWidth() {
        return super.getThumbStrokeWidth();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getThumbTintList() {
        return super.getThumbTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickActiveTintList() {
        return super.getTickActiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickInactiveTintList() {
        return super.getTickInactiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickTintList() {
        return super.getTickTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackActiveTintList() {
        return super.getTrackActiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @Dimension
    public /* bridge */ /* synthetic */ int getTrackHeight() {
        return super.getTrackHeight();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackInactiveTintList() {
        return super.getTrackInactiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @Dimension
    public /* bridge */ /* synthetic */ int getTrackSidePadding() {
        return super.getTrackSidePadding();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackTintList() {
        return super.getTrackTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @Dimension
    public /* bridge */ /* synthetic */ int getTrackWidth() {
        return super.getTrackWidth();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getValueFrom() {
        return super.getValueFrom();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getValueTo() {
        return super.getValueTo();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @NonNull
    public List<Float> getValues() {
        return super.getValues();
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable r10) {
        RangeSliderState r11 = (RangeSliderState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.f3753l0 = RangeSliderState.access$000(r11);
        int r12 = RangeSliderState.access$100(r11);
        this.f3754m0 = r12;
        setSeparationUnit(r12);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        RangeSliderState r10 = new RangeSliderState(super.onSaveInstanceState());
        RangeSliderState.access$002(r10, this.f3753l0);
        RangeSliderState.access$102(r10, this.f3754m0);
        return r10;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawable(@DrawableRes int r10) {
        super.setCustomThumbDrawable(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawable(@NonNull Drawable r10) {
        super.setCustomThumbDrawable(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... r10) {
        super.setCustomThumbDrawablesForValues(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawablesForValues(@NonNull Drawable... r10) {
        super.setCustomThumbDrawablesForValues(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean r10) {
        super.setEnabled(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setFocusedThumbIndex(int r10) {
        super.setFocusedThumbIndex(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloRadius(@IntRange(from = 0) @Dimension int r10) {
        super.setHaloRadius(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloRadiusResource(@DimenRes int r10) {
        super.setHaloRadiusResource(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloTintList(@NonNull ColorStateList r10) {
        super.setHaloTintList(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setLabelBehavior(int r10) {
        super.setLabelBehavior(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setLabelFormatter(@Nullable c r10) {
        super.setLabelFormatter(r10);
    }

    public void setMinSeparation(@Dimension float r10) {
        this.f3753l0 = r10;
        this.f3754m0 = 0;
        setSeparationUnit(0);
    }

    public void setMinSeparationValue(float r10) {
        this.f3753l0 = r10;
        this.f3754m0 = 1;
        setSeparationUnit(1);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setStepSize(float r10) {
        super.setStepSize(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbElevation(float r10) {
        super.setThumbElevation(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbElevationResource(@DimenRes int r10) {
        super.setThumbElevationResource(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbRadius(@IntRange(from = 0) @Dimension int r10) {
        super.setThumbRadius(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbRadiusResource(@DimenRes int r10) {
        super.setThumbRadiusResource(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeColor(@Nullable ColorStateList r10) {
        super.setThumbStrokeColor(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeColorResource(@ColorRes int r10) {
        super.setThumbStrokeColorResource(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeWidth(float r10) {
        super.setThumbStrokeWidth(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeWidthResource(@DimenRes int r10) {
        super.setThumbStrokeWidthResource(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbTintList(@NonNull ColorStateList r10) {
        super.setThumbTintList(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickActiveTintList(@NonNull ColorStateList r10) {
        super.setTickActiveTintList(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickInactiveTintList(@NonNull ColorStateList r10) {
        super.setTickInactiveTintList(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickTintList(@NonNull ColorStateList r10) {
        super.setTickTintList(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickVisible(boolean r10) {
        super.setTickVisible(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackActiveTintList(@NonNull ColorStateList r10) {
        super.setTrackActiveTintList(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackHeight(@IntRange(from = 0) @Dimension int r10) {
        super.setTrackHeight(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackInactiveTintList(@NonNull ColorStateList r10) {
        super.setTrackInactiveTintList(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackTintList(@NonNull ColorStateList r10) {
        super.setTrackTintList(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setValueFrom(float r10) {
        super.setValueFrom(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setValueTo(float r10) {
        super.setValueTo(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(@NonNull List<Float> r10) {
        super.setValues(r10);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(@NonNull Float... r10) {
        super.setValues(r10);
    }
}
