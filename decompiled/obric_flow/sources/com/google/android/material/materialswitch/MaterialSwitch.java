package com.google.android.material.materialswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialSwitch extends SwitchCompat {
    private static final int DEF_STYLE_RES = 0;
    private static final int[] STATE_SET_WITH_ICON = null;
    private int[] currentStateChecked;
    private int[] currentStateUnchecked;

    @Nullable
    private Drawable thumbDrawable;

    @Nullable
    private Drawable thumbIconDrawable;

    @Px
    private int thumbIconSize;

    @Nullable
    private ColorStateList thumbIconTintList;

    @NonNull
    private PorterDuff.Mode thumbIconTintMode;

    @Nullable
    private ColorStateList thumbTintList;

    @Nullable
    private Drawable trackDecorationDrawable;

    @Nullable
    private ColorStateList trackDecorationTintList;

    @NonNull
    private PorterDuff.Mode trackDecorationTintMode;

    @Nullable
    private Drawable trackDrawable;

    @Nullable
    private ColorStateList trackTintList;

    static {
        DEF_STYLE_RES = R.style.Widget_Material3_CompoundButton_MaterialSwitch;
        STATE_SET_WITH_ICON = new int[]{R.attr.state_with_icon};
    }

    public MaterialSwitch(@NonNull Context r5) {
        this(r5, null);
    }

    private void refreshThumbDrawable() {
        this.thumbDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.thumbDrawable, this.thumbTintList, getThumbTintMode());
        this.thumbIconDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.thumbIconDrawable, this.thumbIconTintList, this.thumbIconTintMode);
        updateDrawableTints();
        Drawable r5 = this.thumbDrawable;
        Drawable r10 = this.thumbIconDrawable;
        int r11 = this.thumbIconSize;
        super.setThumbDrawable(DrawableUtils.compositeTwoLayeredDrawable(r5, r10, r11, r11));
        refreshDrawableState();
    }

    private void refreshTrackDrawable() {
        this.trackDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.trackDrawable, this.trackTintList, getTrackTintMode());
        this.trackDecorationDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.trackDecorationDrawable, this.trackDecorationTintList, this.trackDecorationTintMode);
        updateDrawableTints();
        Drawable r5 = this.trackDrawable;
        if (r5 != null) goto L5;
    L7:
        if (r5 != null) goto L10;
        r5 = this.trackDecorationDrawable;
    L10:
        if (r5 == null) goto L12;
        setSwitchMinWidth(r5.getIntrinsicWidth());
    L12:
        super.setTrackDrawable(r5);
        return;
    L5:
        if (this.trackDecorationDrawable == null) goto L7;
        r5 = new LayerDrawable(new Drawable[]{this.trackDrawable, this.trackDecorationDrawable});
        goto L10
    }

    private static void setInterpolatedDrawableTintIfPossible(@Nullable Drawable r5, @Nullable ColorStateList r10, @NonNull int[] r11, @NonNull int[] r12, float r13) {
        if (r5 == null) goto L7;
        if (r10 == null) goto L8;
        DrawableCompat.setTint(r5, ColorUtils.blendARGB(r10.getColorForState(r11, 0), r10.getColorForState(r12, 0), r13));
        return;
    L8:
        return;
    }

    private void updateDrawableTints() {
        if (this.thumbTintList == null) goto L5;
    L11:
        float r5 = getThumbPosition();
        ColorStateList r10 = this.thumbTintList;
        if (r10 == null) goto L14;
        setInterpolatedDrawableTintIfPossible(this.thumbDrawable, r10, this.currentStateUnchecked, this.currentStateChecked, r5);
    L14:
        ColorStateList r11 = this.thumbIconTintList;
        if (r11 == null) goto L17;
        setInterpolatedDrawableTintIfPossible(this.thumbIconDrawable, r11, this.currentStateUnchecked, this.currentStateChecked, r5);
    L17:
        ColorStateList r12 = this.trackTintList;
        if (r12 == null) goto L20;
        setInterpolatedDrawableTintIfPossible(this.trackDrawable, r12, this.currentStateUnchecked, this.currentStateChecked, r5);
    L20:
        ColorStateList r13 = this.trackDecorationTintList;
        if (r13 == null) goto L24;
        setInterpolatedDrawableTintIfPossible(this.trackDecorationDrawable, r13, this.currentStateUnchecked, this.currentStateChecked, r5);
        return;
    L24:
        return;
    L5:
        if (this.thumbIconTintList != null) goto L11;
        if (this.trackTintList != null) goto L11;
        if (this.trackDecorationTintList != null) goto L11;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public Drawable getThumbDrawable() {
        return this.thumbDrawable;
    }

    @Nullable
    public Drawable getThumbIconDrawable() {
        return this.thumbIconDrawable;
    }

    @Px
    public int getThumbIconSize() {
        return this.thumbIconSize;
    }

    @Nullable
    public ColorStateList getThumbIconTintList() {
        return this.thumbIconTintList;
    }

    @NonNull
    public PorterDuff.Mode getThumbIconTintMode() {
        return this.thumbIconTintMode;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public ColorStateList getThumbTintList() {
        return this.thumbTintList;
    }

    @Nullable
    public Drawable getTrackDecorationDrawable() {
        return this.trackDecorationDrawable;
    }

    @Nullable
    public ColorStateList getTrackDecorationTintList() {
        return this.trackDecorationTintList;
    }

    @NonNull
    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.trackDecorationTintMode;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public Drawable getTrackDrawable() {
        return this.trackDrawable;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    @Nullable
    public ColorStateList getTrackTintList() {
        return this.trackTintList;
    }

    @Override // android.view.View
    public void invalidate() {
        updateDrawableTints();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r5) {
        int[] r10 = super.onCreateDrawableState(r5 + 1);
        if (this.thumbIconDrawable == null) goto L5;
        View.mergeDrawableStates(r10, STATE_SET_WITH_ICON);
    L5:
        this.currentStateUnchecked = DrawableUtils.getUncheckedState(r10);
        this.currentStateChecked = DrawableUtils.getCheckedState(r10);
        return r10;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(@Nullable Drawable r5) {
        this.thumbDrawable = r5;
        refreshThumbDrawable();
    }

    public void setThumbIconDrawable(@Nullable Drawable r5) {
        this.thumbIconDrawable = r5;
        refreshThumbDrawable();
    }

    public void setThumbIconResource(@DrawableRes int r5) {
        setThumbIconDrawable(AppCompatResources.getDrawable(getContext(), r5));
    }

    public void setThumbIconSize(@Px int r5) {
        if (this.thumbIconSize == r5) goto L6;
        this.thumbIconSize = r5;
        refreshThumbDrawable();
        return;
    }

    public void setThumbIconTintList(@Nullable ColorStateList r5) {
        this.thumbIconTintList = r5;
        refreshThumbDrawable();
    }

    public void setThumbIconTintMode(@NonNull PorterDuff.Mode r5) {
        this.thumbIconTintMode = r5;
        refreshThumbDrawable();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(@Nullable ColorStateList r5) {
        this.thumbTintList = r5;
        refreshThumbDrawable();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(@Nullable PorterDuff.Mode r5) {
        super.setThumbTintMode(r5);
        refreshThumbDrawable();
    }

    public void setTrackDecorationDrawable(@Nullable Drawable r5) {
        this.trackDecorationDrawable = r5;
        refreshTrackDrawable();
    }

    public void setTrackDecorationResource(@DrawableRes int r5) {
        setTrackDecorationDrawable(AppCompatResources.getDrawable(getContext(), r5));
    }

    public void setTrackDecorationTintList(@Nullable ColorStateList r5) {
        this.trackDecorationTintList = r5;
        refreshTrackDrawable();
    }

    public void setTrackDecorationTintMode(@NonNull PorterDuff.Mode r5) {
        this.trackDecorationTintMode = r5;
        refreshTrackDrawable();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(@Nullable Drawable r5) {
        this.trackDrawable = r5;
        refreshTrackDrawable();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(@Nullable ColorStateList r5) {
        this.trackTintList = r5;
        refreshTrackDrawable();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(@Nullable PorterDuff.Mode r5) {
        super.setTrackTintMode(r5);
        refreshTrackDrawable();
    }

    public MaterialSwitch(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.materialSwitchStyle);
    }

    public MaterialSwitch(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        this.thumbIconSize = -1;
        Context r13 = getContext();
        this.thumbDrawable = super.getThumbDrawable();
        this.thumbTintList = super.getThumbTintList();
        super.setThumbTintList(null);
        this.trackDrawable = super.getTrackDrawable();
        this.trackTintList = super.getTrackTintList();
        super.setTrackTintList(null);
        TintTypedArray r14 = ThemeEnforcement.obtainTintedStyledAttributes(r13, r11, R.styleable.MaterialSwitch, r12, r5, new int[0]);
        this.thumbIconDrawable = r14.getDrawable(R.styleable.MaterialSwitch_thumbIcon);
        this.thumbIconSize = r14.getDimensionPixelSize(R.styleable.MaterialSwitch_thumbIconSize, -1);
        this.thumbIconTintList = r14.getColorStateList(R.styleable.MaterialSwitch_thumbIconTint);
        int r15 = r14.getInt(R.styleable.MaterialSwitch_thumbIconTintMode, -1);
        PorterDuff.Mode r16 = PorterDuff.Mode.SRC_IN;
        this.thumbIconTintMode = ViewUtils.parseTintMode(r15, r16);
        this.trackDecorationDrawable = r14.getDrawable(R.styleable.MaterialSwitch_trackDecoration);
        this.trackDecorationTintList = r14.getColorStateList(R.styleable.MaterialSwitch_trackDecorationTint);
        this.trackDecorationTintMode = ViewUtils.parseTintMode(r14.getInt(R.styleable.MaterialSwitch_trackDecorationTintMode, -1), r16);
        r14.recycle();
        setEnforceSwitchWidth(false);
        refreshThumbDrawable();
        refreshTrackDrawable();
    }
}
