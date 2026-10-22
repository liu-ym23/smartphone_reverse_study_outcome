package com.google.android.material.card;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final Drawable CHECKED_ICON_NONE = null;
    private static final double COS_45 = 0.0d;
    public static final int DEFAULT_FADE_ANIM_DURATION = 300;
    private static final int DEFAULT_STROKE_VALUE = -1;

    @NonNull
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;
    private float checkedAnimationProgress;

    @Nullable
    private Drawable checkedIcon;
    private int checkedIconGravity;

    @Dimension
    private int checkedIconMargin;

    @Dimension
    private int checkedIconSize;

    @Nullable
    private ColorStateList checkedIconTint;

    @Nullable
    private LayerDrawable clickableForegroundDrawable;

    @Nullable
    private MaterialShapeDrawable compatRippleDrawable;

    @Nullable
    private Drawable fgDrawable;

    @NonNull
    private final MaterialShapeDrawable foregroundContentDrawable;

    @Nullable
    private MaterialShapeDrawable foregroundShapeDrawable;

    @Nullable
    private ValueAnimator iconAnimator;
    private final TimeInterpolator iconFadeAnimInterpolator;
    private final int iconFadeInAnimDuration;
    private final int iconFadeOutAnimDuration;
    private boolean isBackgroundOverwritten;

    @NonNull
    private final MaterialCardView materialCardView;

    @Nullable
    private ColorStateList rippleColor;

    @Nullable
    private Drawable rippleDrawable;

    @Nullable
    private ShapeAppearanceModel shapeAppearanceModel;

    @Nullable
    private ColorStateList strokeColor;

    @Dimension
    private int strokeWidth;

    @NonNull
    private final Rect userContentPadding;

    static {
        COS_45 = Math.cos(Math.toRadians(45.0d));
        CHECKED_ICON_NONE = null;
    }

    public MaterialCardViewHelper(@NonNull MaterialCardView r5, AttributeSet r10, int r11, @StyleRes int r12) {
        this.userContentPadding = new Rect();
        this.isBackgroundOverwritten = false;
        this.checkedAnimationProgress = 0.0f;
        this.materialCardView = r5;
        MaterialShapeDrawable r13 = new MaterialShapeDrawable(r5.getContext(), r10, r11, r12);
        this.bgDrawable = r13;
        r13.initializeElevationOverlay(r5.getContext());
        r13.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder r14 = r13.getShapeAppearanceModel().toBuilder();
        TypedArray r15 = r5.getContext().obtainStyledAttributes(r10, R.styleable.CardView, r11, R.style.CardView);
        if (r15.hasValue(R.styleable.CardView_cardCornerRadius) == false) goto L5;
        r14.setAllCornerSizes(r15.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f));
    L5:
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(r14.build());
        this.iconFadeAnimInterpolator = MotionUtils.resolveThemeInterpolator(r5.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.iconFadeInAnimDuration = MotionUtils.resolveThemeDuration(r5.getContext(), R.attr.motionDurationShort2, 300);
        this.iconFadeOutAnimDuration = MotionUtils.resolveThemeDuration(r5.getContext(), R.attr.motionDurationShort1, 300);
        r15.recycle();
    }

    public static /* synthetic */ void a(MaterialCardViewHelper r5, ValueAnimator r10) {
        r5.lambda$animateCheckedIcon$0(r10);
    }

    private float calculateActualCornerPadding() {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment r5, float r10) {
        if ((r5 instanceof RoundedCornerTreatment) == false) goto L7;
        return (float) ((1.0d - COS_45) * ((double) r10));
    L7:
        if ((r5 instanceof CutCornerTreatment) == true) goto L9;
        return 0.0f;
    L9:
        return r10 / 2.0f;
    }

    private float calculateHorizontalBackgroundPadding() {
        float r5 = this.materialCardView.getMaxCardElevation();
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L5;
        float r10 = calculateActualCornerPadding();
    L7:
        return r5 + r10;
    L5:
        r10 = 0.0f;
        goto L7
    }

    private float calculateVerticalBackgroundPadding() {
        float r5 = this.materialCardView.getMaxCardElevation() * CARD_VIEW_SHADOW_MULTIPLIER;
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L5;
        float r10 = calculateActualCornerPadding();
    L7:
        return r5 + r10;
    L5:
        r10 = 0.0f;
        goto L7
    }

    private boolean canClipToOutline() {
        return this.bgDrawable.isRoundRect();
    }

    @NonNull
    private Drawable createCompatRippleDrawable() {
        StateListDrawable r5 = new StateListDrawable();
        MaterialShapeDrawable r10 = createForegroundShapeDrawable();
        this.compatRippleDrawable = r10;
        r10.setFillColor(this.rippleColor);
        r5.addState(new int[]{android.R.attr.state_pressed}, this.compatRippleDrawable);
        return r5;
    }

    @NonNull
    private Drawable createForegroundRippleDrawable() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L7;
        this.foregroundShapeDrawable = createForegroundShapeDrawable();
        return new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
    L7:
        return createCompatRippleDrawable();
    }

    @NonNull
    private MaterialShapeDrawable createForegroundShapeDrawable() {
        return new MaterialShapeDrawable(this.shapeAppearanceModel);
    }

    @NonNull
    private Drawable getClickableForeground() {
        if (this.rippleDrawable != null) goto L6;
        this.rippleDrawable = createForegroundRippleDrawable();
    L6:
        if (this.clickableForegroundDrawable != null) goto L9;
        LayerDrawable r5 = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, this.checkedIcon});
        this.clickableForegroundDrawable = r5;
        r5.setId(2, R.id.mtrl_card_checked_layer_id);
    L9:
        return this.clickableForegroundDrawable;
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (this.materialCardView.getPreventCornerOverlap() == true) goto L5;
        return 0.0f;
    L5:
        if (this.materialCardView.getUseCompatPadding() == true) goto L7;
        return 0.0f;
    L7:
        return (float) ((1.0d - COS_45) * ((double) this.materialCardView.getCardViewRadius()));
    }

    @NonNull
    private Drawable insetDrawable(final Drawable r10) {
        if (this.materialCardView.getUseCompatPadding() == false) goto L5;
        final int r11 = (int) Math.ceil(calculateVerticalBackgroundPadding());
        final int r12 = (int) Math.ceil(calculateHorizontalBackgroundPadding());
    L6:
        final int r5 = r12;
        final int r13 = r11;
        return new AnonymousClass1(this, r10, r5, r13, r12, r11);
    L5:
        r12 = 0;
        r11 = 0;
        goto L6
    }

    private boolean isCheckedIconBottom() {
        if ((this.checkedIconGravity & 80) != 80) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isCheckedIconEnd() {
        if ((this.checkedIconGravity & GravityCompat.END) != 8388613) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$animateCheckedIcon$0(ValueAnimator r5) {
        float r10 = ((Float) r5.getAnimatedValue()).floatValue();
        Drawable r11 = this.checkedIcon;
        r11.setAlpha((int) (255.0f * r10));
        this.checkedAnimationProgress = r10;
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        if (this.materialCardView.getPreventCornerOverlap() == true) goto L5;
    L7:
        return false;
    L5:
        if (canClipToOutline() == true) goto L7;
        return true;
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        if (this.materialCardView.getPreventCornerOverlap() == true) goto L5;
    L9:
        return false;
    L5:
        if (canClipToOutline() == false) goto L9;
        if (this.materialCardView.getUseCompatPadding() == false) goto L9;
        return true;
    }

    private boolean shouldUseClickableForeground() {
        if (this.materialCardView.isClickable() == false) goto L6;
        return true;
    L6:
        View r5 = this.materialCardView;
    L8:
        if (r5.isDuplicateParentStateEnabled() == false) goto L13;
        if ((r5.getParent() instanceof View) == false) goto L13;
        r5 = (View) r5.getParent();
    L13:
        return r5.isClickable();
    }

    private void updateInsetForeground(Drawable r5) {
        if ((this.materialCardView.getForeground() instanceof InsetDrawable) == false) goto L5;
        ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(r5);
        return;
    L5:
        this.materialCardView.setForeground(insetDrawable(r5));
    }

    private void updateRippleColor() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L7;
        Drawable r5 = this.rippleDrawable;
        if (r5 == null) goto L7;
        ((RippleDrawable) r5).setColor(this.rippleColor);
        return;
    L7:
        MaterialShapeDrawable r10 = this.compatRippleDrawable;
        if (r10 == null) goto L12;
        r10.setFillColor(this.rippleColor);
        return;
    }

    public void animateCheckedIcon(boolean r10) {
        if (r10 == false) goto L5;
        float r5 = 1.0f;
    L6:
        if (r10 == false) goto L8;
        float r11 = 1.0f - this.checkedAnimationProgress;
    L9:
        ValueAnimator r12 = this.iconAnimator;
        if (r12 == null) goto L12;
        r12.cancel();
        this.iconAnimator = null;
    L12:
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{this.checkedAnimationProgress, r5});
        this.iconAnimator = r13;
        r13.addUpdateListener(new a(this));
        this.iconAnimator.setInterpolator(this.iconFadeAnimInterpolator);
        ValueAnimator r14 = this.iconAnimator;
        if (r10 == false) goto L16;
        int r15 = this.iconFadeInAnimDuration;
    L17:
        r14.setDuration((long) (r15 * r11));
        this.iconAnimator.start();
        return;
    L16:
        r15 = this.iconFadeOutAnimDuration;
        goto L17
    L8:
        r11 = this.checkedAnimationProgress;
        goto L9
    L5:
        r5 = 0.0f;
        goto L6
    }

    @RequiresApi(api = 23)
    public void forceRippleRedraw() {
        Drawable r5 = this.rippleDrawable;
        if (r5 == null) goto L6;
        Rect r10 = r5.getBounds();
        int r11 = r10.bottom;
        this.rippleDrawable.setBounds(r10.left, r10.top, r10.right, r11 - 1);
        this.rippleDrawable.setBounds(r10.left, r10.top, r10.right, r11);
        return;
    }

    @NonNull
    public MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    public ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    public ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    public int getCheckedIconGravity() {
        return this.checkedIconGravity;
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    public float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @ColorInt
    public int getStrokeColor() {
        ColorStateList r5 = this.strokeColor;
        if (r5 != null) goto L6;
        return -1;
    L6:
        return r5.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    @NonNull
    public Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    public boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void loadFromAttributes(@NonNull TypedArray r5) {
        ColorStateList r10 = MaterialResources.getColorStateList(this.materialCardView.getContext(), r5, R.styleable.MaterialCardView_strokeColor);
        this.strokeColor = r10;
        if (r10 != null) goto L5;
        this.strokeColor = ColorStateList.valueOf(-1);
    L5:
        this.strokeWidth = r5.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        boolean r11 = r5.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        this.checkable = r11;
        this.materialCardView.setLongClickable(r11);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), r5, R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), r5, R.styleable.MaterialCardView_checkedIcon));
        setCheckedIconSize(r5.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconSize, 0));
        setCheckedIconMargin(r5.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconMargin, 0));
        this.checkedIconGravity = r5.getInteger(R.styleable.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList r12 = MaterialResources.getColorStateList(this.materialCardView.getContext(), r5, R.styleable.MaterialCardView_rippleColor);
        this.rippleColor = r12;
        if (r12 != null) goto L8;
        this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, R.attr.colorControlHighlight));
    L8:
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), r5, R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        if (shouldUseClickableForeground() == false) goto L11;
        Drawable r13 = getClickableForeground();
    L12:
        this.fgDrawable = r13;
        this.materialCardView.setForeground(insetDrawable(r13));
        return;
    L11:
        r13 = this.foregroundContentDrawable;
        goto L12
    }

    public void recalculateCheckedIconPosition(int r11, int r12) {
        if (this.clickableForegroundDrawable != null) goto L5;
        return;
    L5:
        if (this.materialCardView.getUseCompatPadding() == false) goto L7;
        int r5 = (int) Math.ceil(calculateVerticalBackgroundPadding() * 2.0f);
        int r10 = (int) Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f);
    L9:
        if (isCheckedIconEnd() == false) goto L11;
        int r13 = ((r11 - this.checkedIconMargin) - this.checkedIconSize) - r10;
    L13:
        if (isCheckedIconBottom() == false) goto L16;
        int r14 = this.checkedIconMargin;
    L15:
        int r15 = r14;
        if (isCheckedIconEnd() == false) goto L20;
        int r16 = this.checkedIconMargin;
    L22:
        if (isCheckedIconBottom() == false) goto L25;
        int r17 = ((r12 - this.checkedIconMargin) - this.checkedIconSize) - r5;
    L24:
        int r18 = r17;
        if (ViewCompat.getLayoutDirection(this.materialCardView) != 1) goto L29;
        int r19 = r16;
        int r20 = r13;
    L30:
        this.clickableForegroundDrawable.setLayerInset(2, r19, r18, r20, r15);
        return;
    L29:
        r20 = r16;
        r19 = r13;
        goto L30
    L25:
        r17 = this.checkedIconMargin;
        goto L24
    L20:
        r16 = ((r11 - this.checkedIconMargin) - this.checkedIconSize) - r10;
        goto L22
    L16:
        r14 = ((r12 - this.checkedIconMargin) - this.checkedIconSize) - r5;
        goto L15
    L11:
        r13 = this.checkedIconMargin;
        goto L13
    L7:
        r5 = 0;
        r10 = 0;
        goto L9
    }

    public void setBackgroundOverwritten(boolean r5) {
        this.isBackgroundOverwritten = r5;
    }

    public void setCardBackgroundColor(ColorStateList r5) {
        this.bgDrawable.setFillColor(r5);
    }

    public void setCardForegroundColor(@Nullable ColorStateList r5) {
        MaterialShapeDrawable r10 = this.foregroundContentDrawable;
        if (r5 != null) goto L5;
        r5 = ColorStateList.valueOf(0);
    L5:
        r10.setFillColor(r5);
    }

    public void setCheckable(boolean r5) {
        this.checkable = r5;
    }

    public void setChecked(boolean r5) {
        setChecked(r5, false);
    }

    public void setCheckedIcon(@Nullable Drawable r5) {
        if (r5 == null) goto L4;
        Drawable r10 = DrawableCompat.wrap(r5).mutate();
        this.checkedIcon = r10;
        DrawableCompat.setTintList(r10, this.checkedIconTint);
        setChecked(this.materialCardView.isChecked());
    L5:
        LayerDrawable r11 = this.clickableForegroundDrawable;
        if (r11 == null) goto L9;
        r11.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.checkedIcon);
        return;
    L9:
        return;
    L4:
        this.checkedIcon = CHECKED_ICON_NONE;
        goto L5
    }

    public void setCheckedIconGravity(int r5) {
        this.checkedIconGravity = r5;
        recalculateCheckedIconPosition(this.materialCardView.getMeasuredWidth(), this.materialCardView.getMeasuredHeight());
    }

    public void setCheckedIconMargin(@Dimension int r5) {
        this.checkedIconMargin = r5;
    }

    public void setCheckedIconSize(@Dimension int r5) {
        this.checkedIconSize = r5;
    }

    public void setCheckedIconTint(@Nullable ColorStateList r5) {
        this.checkedIconTint = r5;
        Drawable r10 = this.checkedIcon;
        if (r10 == null) goto L6;
        DrawableCompat.setTintList(r10, r5);
        return;
    }

    public void setCornerRadius(float r5) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(r5));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L5;
    L6:
        updateContentPadding();
    L8:
        if (shouldAddCornerPaddingOutsideCardBackground() == false) goto L11;
        updateInsets();
        return;
    L11:
        return;
    L5:
        if (shouldAddCornerPaddingInsideCardBackground() == false) goto L8;
        goto L6
    }

    public void setProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        this.bgDrawable.setInterpolation(r5);
        MaterialShapeDrawable r10 = this.foregroundContentDrawable;
        if (r10 == null) goto L5;
        r10.setInterpolation(r5);
    L5:
        MaterialShapeDrawable r11 = this.foregroundShapeDrawable;
        if (r11 == null) goto L9;
        r11.setInterpolation(r5);
        return;
    }

    public void setRippleColor(@Nullable ColorStateList r5) {
        this.rippleColor = r5;
        updateRippleColor();
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r5) {
        this.shapeAppearanceModel = r5;
        this.bgDrawable.setShapeAppearanceModel(r5);
        MaterialShapeDrawable r10 = this.bgDrawable;
        r10.setShadowBitmapDrawingEnable(!r10.isRoundRect());
        MaterialShapeDrawable r11 = this.foregroundContentDrawable;
        if (r11 == null) goto L5;
        r11.setShapeAppearanceModel(r5);
    L5:
        MaterialShapeDrawable r12 = this.foregroundShapeDrawable;
        if (r12 == null) goto L8;
        r12.setShapeAppearanceModel(r5);
    L8:
        MaterialShapeDrawable r13 = this.compatRippleDrawable;
        if (r13 == null) goto L12;
        r13.setShapeAppearanceModel(r5);
        return;
    }

    public void setStrokeColor(ColorStateList r5) {
        if (this.strokeColor != r5) goto L5;
        return;
    L5:
        this.strokeColor = r5;
        updateStroke();
    }

    public void setStrokeWidth(@Dimension int r5) {
        if (r5 != this.strokeWidth) goto L5;
        return;
    L5:
        this.strokeWidth = r5;
        updateStroke();
    }

    public void setUserContentPadding(int r5, int r10, int r11, int r12) {
        this.userContentPadding.set(r5, r10, r11, r12);
        updateContentPadding();
    }

    public void updateClickable() {
        Drawable r5 = this.fgDrawable;
        if (shouldUseClickableForeground() == false) goto L5;
        Drawable r10 = getClickableForeground();
    L6:
        this.fgDrawable = r10;
        if (r5 == r10) goto L10;
        updateInsetForeground(r10);
        return;
    L10:
        return;
    L5:
        r10 = this.foregroundContentDrawable;
        goto L6
    }

    public void updateContentPadding() {
        if (shouldAddCornerPaddingInsideCardBackground() == false) goto L5;
    L8:
        float r5 = calculateActualCornerPadding();
    L9:
        int r10 = (int) (r5 - getParentCardViewCalculatedCornerPadding());
        MaterialCardView r11 = this.materialCardView;
        Rect r12 = this.userContentPadding;
        r11.setAncestorContentPadding(r12.left + r10, r12.top + r10, r12.right + r10, r12.bottom + r10);
        return;
    L5:
        if (shouldAddCornerPaddingOutsideCardBackground() == true) goto L8;
        r5 = 0.0f;
        goto L9
    }

    public void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    public void updateInsets() {
        if (isBackgroundOverwritten() == true) goto L5;
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
    L5:
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    public void updateStroke() {
        this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }

    public void setChecked(boolean r5, boolean r10) {
        Drawable r11 = this.checkedIcon;
        if (r11 == null) goto L15;
        if (r10 == false) goto L6;
        animateCheckedIcon(r5);
        return;
    L6:
        if (r5 == false) goto L8;
        int r12 = 255;
    L9:
        r11.setAlpha(r12);
        if (r5 == false) goto L12;
        float r13 = 1.0f;
    L13:
        this.checkedAnimationProgress = r13;
        return;
    L12:
        r13 = 0.0f;
        goto L13
    L8:
        r12 = 0;
        goto L9
    }
}
