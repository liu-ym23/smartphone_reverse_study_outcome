package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialButtonHelper {
    private static final boolean IS_LOLLIPOP = false;

    @ChecksSdkIntAtLeast(api = 21)
    private static final boolean IS_MIN_LOLLIPOP = false;
    private boolean backgroundOverwritten;

    @Nullable
    private ColorStateList backgroundTint;

    @Nullable
    private PorterDuff.Mode backgroundTintMode;
    private boolean checkable;
    private int cornerRadius;
    private boolean cornerRadiusSet;
    private int elevation;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;

    @Nullable
    private Drawable maskDrawable;
    private final MaterialButton materialButton;

    @Nullable
    private ColorStateList rippleColor;
    private LayerDrawable rippleDrawable;

    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;
    private boolean shouldDrawSurfaceColorStroke;

    @Nullable
    private ColorStateList strokeColor;
    private int strokeWidth;
    private boolean toggleCheckedStateOnClick;

    static {
        IS_MIN_LOLLIPOP = true;
        IS_LOLLIPOP = false;
    }

    public MaterialButtonHelper(MaterialButton r5, @NonNull ShapeAppearanceModel r10) {
        this.shouldDrawSurfaceColorStroke = false;
        this.backgroundOverwritten = false;
        this.cornerRadiusSet = false;
        this.toggleCheckedStateOnClick = true;
        this.materialButton = r5;
        this.shapeAppearanceModel = r10;
    }

    private Drawable createBackground() {
        MaterialShapeDrawable r5 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        r5.initializeElevationOverlay(this.materialButton.getContext());
        DrawableCompat.setTintList(r5, this.backgroundTint);
        PorterDuff.Mode r10 = this.backgroundTintMode;
        if (r10 == null) goto L5;
        DrawableCompat.setTintMode(r5, r10);
    L5:
        r5.setStroke(this.strokeWidth, this.strokeColor);
        MaterialShapeDrawable r11 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        r11.setTint(0);
        float r12 = this.strokeWidth;
        if (this.shouldDrawSurfaceColorStroke == false) goto L8;
        int r13 = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
    L9:
        r11.setStroke(r12, r13);
        if (IS_MIN_LOLLIPOP == false) goto L13;
        MaterialShapeDrawable r14 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.maskDrawable = r14;
        DrawableCompat.setTint(r14, -1);
        RippleDrawable r15 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new LayerDrawable(new Drawable[]{r11, r5})), this.maskDrawable);
        this.rippleDrawable = r15;
        return r15;
    L13:
        RippleDrawableCompat r16 = new RippleDrawableCompat(this.shapeAppearanceModel);
        this.maskDrawable = r16;
        DrawableCompat.setTintList(r16, RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
        LayerDrawable r17 = new LayerDrawable(new Drawable[]{r11, r5, this.maskDrawable});
        this.rippleDrawable = r17;
        return wrapDrawableWithInset(r17);
    L8:
        r13 = 0;
        goto L9
    }

    @Nullable
    private MaterialShapeDrawable getMaterialShapeDrawable(boolean r5) {
        LayerDrawable r10 = this.rippleDrawable;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.getNumberOfLayers() > 0) goto L7;
        return null;
    L7:
        if (IS_MIN_LOLLIPOP == false) goto L11;
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(!r5 ? 1 : 0);
    L11:
        return (MaterialShapeDrawable) this.rippleDrawable.getDrawable(!r5 ? 1 : 0);
    }

    @Nullable
    private MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    private void setVerticalInsets(@Dimension int r10, @Dimension int r11) {
        int r5 = ViewCompat.getPaddingStart(this.materialButton);
        int r12 = this.materialButton.getPaddingTop();
        int r13 = ViewCompat.getPaddingEnd(this.materialButton);
        int r14 = this.materialButton.getPaddingBottom();
        int r15 = this.insetTop;
        int r16 = this.insetBottom;
        this.insetBottom = r11;
        this.insetTop = r10;
        if (this.backgroundOverwritten == true) goto L5;
        updateBackground();
    L5:
        ViewCompat.setPaddingRelative(this.materialButton, r5, (r12 + r10) - r15, r13, (r14 + r11) - r16);
    }

    private void updateBackground() {
        this.materialButton.setInternalBackground(createBackground());
        MaterialShapeDrawable r5 = getMaterialShapeDrawable();
        if (r5 == null) goto L6;
        r5.setElevation(this.elevation);
        r5.setState(this.materialButton.getDrawableState());
        return;
    }

    private void updateButtonShape(@NonNull ShapeAppearanceModel r5) {
        if (IS_LOLLIPOP == false) goto L8;
        if (this.backgroundOverwritten == true) goto L8;
        int r10 = ViewCompat.getPaddingStart(this.materialButton);
        int r11 = this.materialButton.getPaddingTop();
        int r12 = ViewCompat.getPaddingEnd(this.materialButton);
        int r13 = this.materialButton.getPaddingBottom();
        updateBackground();
        ViewCompat.setPaddingRelative(this.materialButton, r10, r11, r12, r13);
        return;
    L8:
        if (getMaterialShapeDrawable() == null) goto L11;
        getMaterialShapeDrawable().setShapeAppearanceModel(r5);
    L11:
        if (getSurfaceColorStrokeDrawable() == null) goto L14;
        getSurfaceColorStrokeDrawable().setShapeAppearanceModel(r5);
    L14:
        if (getMaskDrawable() == null) goto L18;
        getMaskDrawable().setShapeAppearanceModel(r5);
        return;
    }

    private void updateStroke() {
        MaterialShapeDrawable r5 = getMaterialShapeDrawable();
        MaterialShapeDrawable r10 = getSurfaceColorStrokeDrawable();
        if (r5 == null) goto L12;
        r5.setStroke(this.strokeWidth, this.strokeColor);
        if (r10 == null) goto L13;
        float r11 = this.strokeWidth;
        if (this.shouldDrawSurfaceColorStroke == false) goto L9;
        int r12 = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
    L10:
        r10.setStroke(r11, r12);
        return;
    L9:
        r12 = 0;
        goto L10
    L13:
        return;
    }

    @NonNull
    private InsetDrawable wrapDrawableWithInset(Drawable r10) {
        return new InsetDrawable(r10, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    public int getInsetBottom() {
        return this.insetBottom;
    }

    public int getInsetTop() {
        return this.insetTop;
    }

    @Nullable
    public Shapeable getMaskDrawable() {
        LayerDrawable r5 = this.rippleDrawable;
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.getNumberOfLayers() > 1) goto L7;
        return null;
    L7:
        if (this.rippleDrawable.getNumberOfLayers() <= 2) goto L11;
        return (Shapeable) this.rippleDrawable.getDrawable(2);
    L11:
        return (Shapeable) this.rippleDrawable.getDrawable(1);
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public boolean isToggleCheckedStateOnClick() {
        return this.toggleCheckedStateOnClick;
    }

    public void loadFromAttributes(@NonNull TypedArray r10) {
        this.insetLeft = r10.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = r10.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = r10.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = r10.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        if (r10.hasValue(R.styleable.MaterialButton_cornerRadius) == false) goto L5;
        int r5 = r10.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, -1);
        this.cornerRadius = r5;
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r5));
        this.cornerRadiusSet = true;
    L5:
        this.strokeWidth = r10.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(r10.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), r10, R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), r10, R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), r10, R.styleable.MaterialButton_rippleColor);
        this.checkable = r10.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.elevation = r10.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        this.toggleCheckedStateOnClick = r10.getBoolean(R.styleable.MaterialButton_toggleCheckedStateOnClick, true);
        int r11 = ViewCompat.getPaddingStart(this.materialButton);
        int r12 = this.materialButton.getPaddingTop();
        int r13 = ViewCompat.getPaddingEnd(this.materialButton);
        int r14 = this.materialButton.getPaddingBottom();
        if (r10.hasValue(R.styleable.MaterialButton_android_background) == false) goto L8;
        setBackgroundOverwritten();
    L9:
        ViewCompat.setPaddingRelative(this.materialButton, r11 + this.insetLeft, r12 + this.insetTop, r13 + this.insetRight, r14 + this.insetBottom);
        return;
    L8:
        updateBackground();
        goto L9
    }

    public void setBackgroundColor(int r5) {
        if (getMaterialShapeDrawable() == null) goto L6;
        getMaterialShapeDrawable().setTint(r5);
        return;
    }

    public void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    public void setCheckable(boolean r5) {
        this.checkable = r5;
    }

    public void setCornerRadius(int r5) {
        if (this.cornerRadiusSet == true) goto L5;
    L6:
        this.cornerRadius = r5;
        this.cornerRadiusSet = true;
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r5));
        return;
    L5:
        if (this.cornerRadius != r5) goto L6;
    }

    public void setInsetBottom(@Dimension int r5) {
        setVerticalInsets(this.insetTop, r5);
    }

    public void setInsetTop(@Dimension int r5) {
        setVerticalInsets(r5, this.insetBottom);
    }

    public void setRippleColor(@Nullable ColorStateList r5) {
        if (this.rippleColor == r5) goto L14;
        this.rippleColor = r5;
        boolean r10 = IS_MIN_LOLLIPOP;
        if (r10 == true) goto L7;
    L9:
        if (r10 == false) goto L11;
        return;
    L11:
        if ((this.materialButton.getBackground() instanceof RippleDrawableCompat) == false) goto L17;
        ((RippleDrawableCompat) this.materialButton.getBackground()).setTintList(RippleUtils.sanitizeRippleDrawableColor(r5));
        return;
    L17:
        return;
    L7:
        if ((this.materialButton.getBackground() instanceof RippleDrawable) == false) goto L9;
        ((RippleDrawable) this.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(r5));
        return;
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r5) {
        this.shapeAppearanceModel = r5;
        updateButtonShape(r5);
    }

    public void setShouldDrawSurfaceColorStroke(boolean r5) {
        this.shouldDrawSurfaceColorStroke = r5;
        updateStroke();
    }

    public void setStrokeColor(@Nullable ColorStateList r5) {
        if (this.strokeColor == r5) goto L6;
        this.strokeColor = r5;
        updateStroke();
        return;
    }

    public void setStrokeWidth(int r5) {
        if (this.strokeWidth == r5) goto L6;
        this.strokeWidth = r5;
        updateStroke();
        return;
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList r5) {
        if (this.backgroundTint == r5) goto L8;
        this.backgroundTint = r5;
        if (getMaterialShapeDrawable() == null) goto L9;
        DrawableCompat.setTintList(getMaterialShapeDrawable(), this.backgroundTint);
        return;
    L9:
        return;
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
        if (this.backgroundTintMode == r5) goto L10;
        this.backgroundTintMode = r5;
        if (getMaterialShapeDrawable() != null) goto L7;
        return;
    L7:
        if (this.backgroundTintMode == null) goto L12;
        DrawableCompat.setTintMode(getMaterialShapeDrawable(), this.backgroundTintMode);
        return;
    L12:
        return;
    }

    public void setToggleCheckedStateOnClick(boolean r5) {
        this.toggleCheckedStateOnClick = r5;
    }

    public void updateMaskBounds(int r5, int r10) {
        Drawable r11 = this.maskDrawable;
        if (r11 == null) goto L6;
        r11.setBounds(this.insetLeft, this.insetTop, r10 - this.insetRight, r5 - this.insetBottom);
        return;
    }

    @Nullable
    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
    }
}
