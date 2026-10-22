package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@OptIn(markerClass = {ExperimentalBadgeUtils.class})
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public static final int BADGE_CONTENT_NOT_TRUNCATED = -2;
    static final int BADGE_RADIUS_NOT_SPECIFIED = -1;

    @Deprecated
    public static final int BOTTOM_END = 8388693;

    @Deprecated
    public static final int BOTTOM_START = 8388691;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    static final String DEFAULT_EXCEED_MAX_BADGE_TEXT_SUFFIX = "…";

    @StyleRes
    private static final int DEFAULT_STYLE = 0;

    @AttrRes
    private static final int DEFAULT_THEME_ATTR = 0;
    private static final float FONT_SCALE_THRESHOLD = 0.3f;
    static final int OFFSET_ALIGNMENT_MODE_EDGE = 0;
    static final int OFFSET_ALIGNMENT_MODE_LEGACY = 1;
    private static final String TAG = "Badge";
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;

    @Nullable
    private WeakReference<View> anchorViewRef;

    @NonNull
    private final Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;

    @NonNull
    private final WeakReference<Context> contextRef;
    private float cornerRadius;

    @Nullable
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;

    @NonNull
    private final MaterialShapeDrawable shapeDrawable;

    @NonNull
    private final BadgeState state;

    @NonNull
    private final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    static {
        DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;
        DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    }

    private BadgeDrawable(@NonNull Context r10, @XmlRes int r11, @AttrRes int r12, @StyleRes int r13, @Nullable BadgeState.State r14) {
        this.contextRef = new WeakReference(r10);
        ThemeEnforcement.checkMaterialTheme(r10);
        this.badgeBounds = new Rect();
        TextDrawableHelper r5 = new TextDrawableHelper(this);
        this.textDrawableHelper = r5;
        r5.getTextPaint().setTextAlign(Paint.Align.CENTER);
        BadgeState r15 = new BadgeState(r10, r11, r12, r13, r14);
        this.state = r15;
        if (hasBadgeContent() == false) goto L5;
        int r16 = r15.getBadgeWithTextShapeAppearanceResId();
    L7:
        if (hasBadgeContent() == false) goto L9;
        int r17 = r15.getBadgeWithTextShapeAppearanceOverlayResId();
    L10:
        this.shapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(r10, r16, r17).build());
        restoreState();
        return;
    L9:
        r17 = r15.getBadgeShapeAppearanceOverlayResId();
        goto L10
    L5:
        r16 = r15.getBadgeShapeAppearanceResId();
        goto L7
    }

    private void autoAdjustWithinGrandparentBounds(@NonNull View r10) {
        View r5 = getCustomBadgeParent();
        if (r5 != null) goto L9;
        if ((r10.getParent() instanceof View) == true) goto L7;
        return;
    L7:
        float r11 = r10.getY();
        float r12 = r10.getX();
        r5 = (View) r10.getParent();
        float r13 = r11;
    L15:
        float r14 = getTopCutOff(r5, r13);
        float r15 = getLeftCutOff(r5, r12);
        float r16 = getBottomCutOff(r5, r13);
        float r17 = getRightCutoff(r5, r12);
        if (r14 >= 0.0f) goto L19;
        this.badgeCenterY = Math.abs(r14) + this.badgeCenterY;
    L19:
        if (r15 >= 0.0f) goto L22;
        this.badgeCenterX = Math.abs(r15) + this.badgeCenterX;
    L22:
        if (r16 <= 0.0f) goto L25;
        this.badgeCenterY -= Math.abs(r16);
    L25:
        if (r17 <= 0.0f) goto L28;
        this.badgeCenterX -= Math.abs(r17);
        return;
    L28:
        return;
    L9:
        if (isAnchorViewWrappedInCompatParent() == true) goto L11;
        r13 = 0.0f;
        r12 = 0.0f;
        goto L15
    L11:
        if ((r5.getParent() instanceof View) == true) goto L13;
        return;
    L13:
        r13 = r5.getY();
        r12 = r5.getX();
        r5 = (View) r5.getParent();
        goto L15
    }

    private void calculateCenterAndBounds(@NonNull Rect r10, @NonNull View r11) {
        if (hasBadgeContent() == false) goto L5;
        float r5 = this.state.badgeWithTextRadius;
    L6:
        this.cornerRadius = r5;
        if (r5 == (-1.0f)) goto L10;
        this.halfBadgeWidth = r5;
        this.halfBadgeHeight = r5;
    L21:
        if (hasBadgeContent() == false) goto L23;
        String r12 = getBadgeContent();
        this.halfBadgeWidth = Math.max(this.halfBadgeWidth, (this.textDrawableHelper.getTextWidth(r12) / 2.0f) + this.state.getBadgeHorizontalPadding());
        float r13 = Math.max(this.halfBadgeHeight, (this.textDrawableHelper.getTextHeight(r12) / 2.0f) + this.state.getBadgeVerticalPadding());
        this.halfBadgeHeight = r13;
        this.halfBadgeWidth = Math.max(this.halfBadgeWidth, r13);
    L23:
        int r14 = getTotalVerticalOffsetForState();
        int r15 = this.state.getBadgeGravity();
        if (r15 != 8388691) goto L26;
    L28:
        this.badgeCenterY = r10.bottom - r14;
    L29:
        int r16 = getTotalHorizontalOffsetForState();
        int r17 = this.state.getBadgeGravity();
        if (r17 == 8388659) goto L38;
        if (r17 == 8388691) goto L38;
        if (ViewCompat.getLayoutDirection(r11) != 0) goto L35;
        float r18 = (r10.right + this.halfBadgeWidth) - r16;
    L36:
        this.badgeCenterX = r18;
    L43:
        if (this.state.isAutoAdjustedToGrandparentBounds() == false) goto L46;
        autoAdjustWithinGrandparentBounds(r11);
        return;
    L46:
        return;
    L35:
        r18 = (r10.left - this.halfBadgeWidth) + r16;
    L38:
        if (ViewCompat.getLayoutDirection(r11) != 0) goto L40;
        float r19 = (r10.left - this.halfBadgeWidth) + r16;
    L41:
        this.badgeCenterX = r19;
        goto L43
    L40:
        r19 = (r10.right + this.halfBadgeWidth) - r16;
        goto L41
    L26:
        if (r15 == 8388693) goto L28;
        this.badgeCenterY = r10.top + r14;
        goto L29
    L10:
        if (hasBadgeContent() == false) goto L13;
        float r20 = this.state.badgeWithTextWidth;
    L14:
        this.halfBadgeWidth = Math.round(r20 / 2.0f);
        if (hasBadgeContent() == false) goto L18;
        float r21 = this.state.badgeWithTextHeight;
    L19:
        this.halfBadgeHeight = Math.round(r21 / 2.0f);
        goto L21
    L18:
        r21 = this.state.badgeHeight;
        goto L19
    L13:
        r20 = this.state.badgeWidth;
        goto L14
    L5:
        r5 = this.state.badgeRadius;
        goto L6
    }

    @NonNull
    public static BadgeDrawable create(@NonNull Context r10) {
        return new BadgeDrawable(r10, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, null);
    }

    @NonNull
    public static BadgeDrawable createFromResource(@NonNull Context r10, @XmlRes int r11) {
        return new BadgeDrawable(r10, r11, DEFAULT_THEME_ATTR, DEFAULT_STYLE, null);
    }

    @NonNull
    public static BadgeDrawable createFromSavedState(@NonNull Context r10, @NonNull BadgeState.State r11) {
        return new BadgeDrawable(r10, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, r11);
    }

    private void drawBadgeContent(Canvas r10) {
        String r5 = getBadgeContent();
        if (r5 == null) goto L11;
        Rect r11 = new Rect();
        this.textDrawableHelper.getTextPaint().getTextBounds(r5, 0, r5.length(), r11);
        float r12 = this.badgeCenterY - r11.exactCenterY();
        float r13 = this.badgeCenterX;
        if (r11.bottom > 0) goto L8;
        int r14 = (int) r12;
    L9:
        r10.drawText(r5, r13, r14, this.textDrawableHelper.getTextPaint());
        return;
    L8:
        r14 = Math.round(r12);
        goto L9
    }

    @Nullable
    private String getBadgeContent() {
        if (hasText() == false) goto L7;
        return getTextBadgeText();
    L7:
        if (hasNumber() == true) goto L9;
        return null;
    L9:
        return getNumberBadgeText();
    }

    private float getBottomCutOff(View r5, float r10) {
        if ((r5.getParent() instanceof View) == true) goto L7;
        return 0.0f;
    L7:
        return ((this.badgeCenterY + this.halfBadgeHeight) - (((View) r5.getParent()).getHeight() - r5.getY())) + r10;
    }

    private CharSequence getEmptyContentDescription() {
        return this.state.getContentDescriptionNumberless();
    }

    private float getLeftCutOff(View r5, float r10) {
        float r11 = this.badgeCenterX - this.halfBadgeWidth;
        return (r5.getX() + r11) + r10;
    }

    @NonNull
    private String getNumberBadgeText() {
        if (this.maxBadgeNumber == (-2)) goto L14;
        if (getNumber() <= this.maxBadgeNumber) goto L14;
        Context r5 = this.contextRef.get();
        if (r5 != null) goto L12;
        return "";
    L12:
        return String.format(this.state.getNumberLocale(), r5.getString(R.string.mtrl_exceed_max_badge_number_suffix), new Object[]{Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
    L14:
        return NumberFormat.getInstance(this.state.getNumberLocale()).format(getNumber());
    }

    @Nullable
    private String getNumberContentDescription() {
        if (this.state.getContentDescriptionQuantityStrings() == 0) goto L16;
        Context r5 = this.contextRef.get();
        if (r5 != null) goto L8;
        return null;
    L8:
        if (this.maxBadgeNumber == (-2)) goto L15;
        if (getNumber() <= this.maxBadgeNumber) goto L15;
        return r5.getString(this.state.getContentDescriptionExceedsMaxBadgeNumberStringResource(), new Object[]{Integer.valueOf(this.maxBadgeNumber)});
    L15:
        return r5.getResources().getQuantityString(this.state.getContentDescriptionQuantityStrings(), getNumber(), new Object[]{Integer.valueOf(getNumber())});
    L16:
        return null;
    }

    private float getRightCutoff(View r5, float r10) {
        if ((r5.getParent() instanceof View) == true) goto L7;
        return 0.0f;
    L7:
        return ((this.badgeCenterX + this.halfBadgeWidth) - (((View) r5.getParent()).getWidth() - r5.getX())) + r10;
    }

    @Nullable
    private String getTextBadgeText() {
        String r5 = getText();
        int r10 = getMaxCharacterCount();
        if (r10 != (-2)) goto L5;
        return r5;
    L5:
        if (r5 != null) goto L7;
    L14:
        return r5;
    L7:
        if (r5.length() <= r10) goto L14;
        Context r11 = this.contextRef.get();
        if (r11 != null) goto L13;
        return "";
    L13:
        return String.format(r11.getString(R.string.m3_exceed_max_badge_text_suffix), new Object[]{r5.substring(0, r10 - 1), DEFAULT_EXCEED_MAX_BADGE_TEXT_SUFFIX});
    }

    @Nullable
    private CharSequence getTextContentDescription() {
        CharSequence r5 = this.state.getContentDescriptionForText();
        if (r5 == null) goto L6;
        return r5;
    L6:
        return getText();
    }

    private float getTopCutOff(View r5, float r10) {
        float r11 = this.badgeCenterY - this.halfBadgeHeight;
        return (r5.getY() + r11) + r10;
    }

    private int getTotalHorizontalOffsetForState() {
        if (hasBadgeContent() == false) goto L5;
        int r5 = this.state.getHorizontalOffsetWithText();
    L7:
        if (this.state.offsetAlignmentMode != 1) goto L14;
        if (hasBadgeContent() == false) goto L11;
        int r10 = this.state.horizontalInsetWithText;
    L12:
        r5 = r5 + r10;
        goto L14
    L11:
        r10 = this.state.horizontalInset;
    L14:
        return this.state.getAdditionalHorizontalOffset() + r5;
    L5:
        r5 = this.state.getHorizontalOffsetWithoutText();
        goto L7
    }

    private int getTotalVerticalOffsetForState() {
        int r5 = this.state.getVerticalOffsetWithoutText();
        if (hasBadgeContent() == false) goto L8;
        r5 = this.state.getVerticalOffsetWithText();
        Context r10 = this.contextRef.get();
        if (r10 == null) goto L8;
        float r11 = AnimationUtils.lerp(0.0f, 1.0f, FONT_SCALE_THRESHOLD, 1.0f, MaterialResources.getFontScale(r10) - 1.0f);
        r5 = AnimationUtils.lerp(r5, r5 - this.state.getLargeFontVerticalOffsetAdjustment(), r11);
    L8:
        if (this.state.offsetAlignmentMode != 0) goto L11;
        r5 = r5 - Math.round(this.halfBadgeHeight);
    L11:
        return this.state.getAdditionalVerticalOffset() + r5;
    }

    private boolean hasBadgeContent() {
        if (hasText() == false) goto L5;
    L8:
        return true;
    L5:
        if (hasNumber() == true) goto L8;
        return false;
    }

    private boolean isAnchorViewWrappedInCompatParent() {
        FrameLayout r5 = getCustomBadgeParent();
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.getId() != R.id.mtrl_anchor_parent) goto L7;
        return true;
    }

    private void onAlphaUpdated() {
        this.textDrawableHelper.getTextPaint().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void onBackgroundColorUpdated() {
        ColorStateList r5 = ColorStateList.valueOf(this.state.getBackgroundColor());
        if (this.shapeDrawable.getFillColor() == r5) goto L6;
        this.shapeDrawable.setFillColor(r5);
        invalidateSelf();
        return;
    }

    private void onBadgeContentUpdated() {
        this.textDrawableHelper.setTextSizeDirty(true);
        onBadgeShapeAppearanceUpdated();
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onBadgeGravityUpdated() {
        WeakReference<View> r5 = this.anchorViewRef;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.get() == null) goto L13;
        View r10 = this.anchorViewRef.get();
        WeakReference<FrameLayout> r11 = this.customBadgeParentRef;
        if (r11 == null) goto L9;
        FrameLayout r12 = r11.get();
    L10:
        updateBadgeCoordinates(r10, r12);
        return;
    L9:
        r12 = null;
        goto L10
    }

    private void onBadgeShapeAppearanceUpdated() {
        Context r5 = this.contextRef.get();
        if (r5 != null) goto L5;
        return;
    L5:
        MaterialShapeDrawable r10 = this.shapeDrawable;
        if (hasBadgeContent() == false) goto L8;
        int r11 = this.state.getBadgeWithTextShapeAppearanceResId();
    L10:
        if (hasBadgeContent() == false) goto L12;
        int r12 = this.state.getBadgeWithTextShapeAppearanceOverlayResId();
    L13:
        r10.setShapeAppearanceModel(ShapeAppearanceModel.builder(r5, r11, r12).build());
        invalidateSelf();
        return;
    L12:
        r12 = this.state.getBadgeShapeAppearanceOverlayResId();
        goto L13
    L8:
        r11 = this.state.getBadgeShapeAppearanceResId();
        goto L10
    }

    private void onBadgeTextAppearanceUpdated() {
        Context r5 = this.contextRef.get();
        if (r5 != null) goto L5;
        return;
    L5:
        TextAppearance r10 = new TextAppearance(r5, this.state.getTextAppearanceResId());
        if (this.textDrawableHelper.getTextAppearance() != r10) goto L8;
        return;
    L8:
        this.textDrawableHelper.setTextAppearance(r10, r5);
        onBadgeTextColorUpdated();
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onBadgeTextColorUpdated() {
        this.textDrawableHelper.getTextPaint().setColor(this.state.getBadgeTextColor());
        invalidateSelf();
    }

    private void onMaxBadgeLengthUpdated() {
        updateMaxBadgeNumber();
        this.textDrawableHelper.setTextSizeDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onNumberUpdated() {
        if (hasText() == true) goto L6;
        onBadgeContentUpdated();
        return;
    }

    private void onTextUpdated() {
        onBadgeContentUpdated();
    }

    private void onVisibilityUpdated() {
        boolean r5 = this.state.isVisible();
        setVisible(r5, false);
        if (BadgeUtils.USE_COMPAT_PARENT == true) goto L5;
        return;
    L5:
        if (getCustomBadgeParent() == null) goto L10;
        if (r5 == true) goto L11;
        ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
        return;
    L11:
        return;
    }

    private void restoreState() {
        onBadgeShapeAppearanceUpdated();
        onBadgeTextAppearanceUpdated();
        onMaxBadgeLengthUpdated();
        onBadgeContentUpdated();
        onAlphaUpdated();
        onBackgroundColorUpdated();
        onBadgeTextColorUpdated();
        onBadgeGravityUpdated();
        updateCenterAndBounds();
        onVisibilityUpdated();
    }

    private void tryWrapAnchorInCompatParent(final View r10) {
        ViewGroup r5 = (ViewGroup) r10.getParent();
        if (r5 != null) goto L5;
    L6:
        WeakReference<FrameLayout> r11 = this.customBadgeParentRef;
        if (r11 != null) goto L9;
    L11:
        updateAnchorParentToNotClip(r10);
        final FrameLayout r12 = new FrameLayout(r10.getContext());
        r12.setId(R.id.mtrl_anchor_parent);
        r12.setClipChildren(false);
        r12.setClipToPadding(false);
        r12.setLayoutParams(r10.getLayoutParams());
        r12.setMinimumWidth(r10.getWidth());
        r12.setMinimumHeight(r10.getHeight());
        int r13 = r5.indexOfChild(r10);
        r5.removeViewAt(r13);
        r10.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r12.addView(r10);
        r5.addView(r12, r13);
        this.customBadgeParentRef = new WeakReference(r12);
        r12.post(new AnonymousClass1(this, r10, r12));
        return;
    L9:
        if (r11.get() != r5) goto L11;
        return;
    L5:
        if (r5.getId() != R.id.mtrl_anchor_parent) goto L6;
    }

    private static void updateAnchorParentToNotClip(View r5) {
        ViewGroup r10 = (ViewGroup) r5.getParent();
        r10.setClipChildren(false);
        r10.setClipToPadding(false);
    }

    private void updateCenterAndBounds() {
        Context r5 = this.contextRef.get();
        WeakReference<View> r10 = this.anchorViewRef;
        FrameLayout r11 = null;
        if (r10 == null) goto L5;
        View r12 = r10.get();
    L6:
        if (r5 == null) goto L25;
        if (r12 == null) goto L27;
        Rect r13 = new Rect();
        r13.set(this.badgeBounds);
        Rect r14 = new Rect();
        r12.getDrawingRect(r14);
        WeakReference<FrameLayout> r15 = this.customBadgeParentRef;
        if (r15 == null) goto L12;
        r11 = r15.get();
    L12:
        if (r11 == null) goto L14;
    L15:
        if (r11 != null) goto L17;
        r11 = (ViewGroup) r12.getParent();
    L17:
        r11.offsetDescendantRectToMyCoords(r12, r14);
    L18:
        calculateCenterAndBounds(r14, r12);
        BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        float r16 = this.cornerRadius;
        if (r16 == (-1.0f)) goto L22;
        this.shapeDrawable.setCornerSize(r16);
    L22:
        if (r13.equals(this.badgeBounds) == true) goto L26;
        this.shapeDrawable.setBounds(this.badgeBounds);
        return;
    L26:
        return;
    L14:
        if (BadgeUtils.USE_COMPAT_PARENT == false) goto L18;
    L27:
        return;
    L25:
        return;
    L5:
        r12 = null;
        goto L6
    }

    private void updateMaxBadgeNumber() {
        if (getMaxCharacterCount() == (-2)) goto L5;
        this.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) getMaxCharacterCount()) - 1.0d)) - 1;
        return;
    L5:
        this.maxBadgeNumber = getMaxNumber();
    }

    public void clearNumber() {
        if (this.state.hasNumber() == false) goto L6;
        this.state.clearNumber();
        onNumberUpdated();
        return;
    }

    public void clearText() {
        if (this.state.hasText() == false) goto L6;
        this.state.clearText();
        onTextUpdated();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r5) {
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() != 0) goto L7;
        return;
    L7:
        if (isVisible() == false) goto L16;
        this.shapeDrawable.draw(r5);
        if (hasBadgeContent() == false) goto L15;
        drawBadgeContent(r5);
        return;
    L15:
        return;
    }

    public int getAdditionalHorizontalOffset() {
        return this.state.getAdditionalHorizontalOffset();
    }

    @Px
    public int getAdditionalVerticalOffset() {
        return this.state.getAdditionalVerticalOffset();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.state.getAlpha();
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return this.state.getBadgeGravity();
    }

    @NonNull
    public Locale getBadgeNumberLocale() {
        return this.state.getNumberLocale();
    }

    @ColorInt
    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    @Nullable
    public CharSequence getContentDescription() {
        if (isVisible() == true) goto L7;
        return null;
    L7:
        if (hasText() == false) goto L11;
        return getTextContentDescription();
    L11:
        if (hasNumber() == false) goto L15;
        return getNumberContentDescription();
    L15:
        return getEmptyContentDescription();
    }

    @Nullable
    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> r5 = this.customBadgeParentRef;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.get();
    }

    public int getHorizontalOffset() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    @Px
    public int getHorizontalOffsetWithText() {
        return this.state.getHorizontalOffsetWithText();
    }

    @Px
    public int getHorizontalOffsetWithoutText() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    @Px
    public int getHorizontalPadding() {
        return this.state.getBadgeHorizontalPadding();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    @Px
    public int getLargeFontVerticalOffsetAdjustment() {
        return this.state.getLargeFontVerticalOffsetAdjustment();
    }

    public int getMaxCharacterCount() {
        return this.state.getMaxCharacterCount();
    }

    public int getMaxNumber() {
        return this.state.getMaxNumber();
    }

    public int getNumber() {
        if (this.state.hasNumber() == true) goto L7;
        return 0;
    L7:
        return this.state.getNumber();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @NonNull
    public BadgeState.State getSavedState() {
        return this.state.getOverridingState();
    }

    @Nullable
    public String getText() {
        return this.state.getText();
    }

    public int getVerticalOffset() {
        return this.state.getVerticalOffsetWithoutText();
    }

    @Px
    public int getVerticalOffsetWithText() {
        return this.state.getVerticalOffsetWithText();
    }

    @Px
    public int getVerticalOffsetWithoutText() {
        return this.state.getVerticalOffsetWithoutText();
    }

    @Px
    public int getVerticalPadding() {
        return this.state.getBadgeVerticalPadding();
    }

    public boolean hasNumber() {
        if (this.state.hasText() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.state.hasNumber() == false) goto L7;
        return true;
    }

    public boolean hasText() {
        return this.state.hasText();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] r5) {
        return super.onStateChange(r5);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setAdditionalHorizontalOffset(int r5) {
        this.state.setAdditionalHorizontalOffset(r5);
        updateCenterAndBounds();
    }

    public void setAdditionalVerticalOffset(@Px int r5) {
        this.state.setAdditionalVerticalOffset(r5);
        updateCenterAndBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        this.state.setAlpha(r5);
        onAlphaUpdated();
    }

    public void setAutoAdjustToWithinGrandparentBounds(boolean r5) {
        if (this.state.isAutoAdjustedToGrandparentBounds() != r5) goto L5;
        return;
    L5:
        this.state.setAutoAdjustToGrandparentBounds(r5);
        WeakReference<View> r10 = this.anchorViewRef;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.get() == null) goto L12;
        autoAdjustWithinGrandparentBounds(this.anchorViewRef.get());
        return;
    }

    public void setBackgroundColor(@ColorInt int r5) {
        this.state.setBackgroundColor(r5);
        onBackgroundColorUpdated();
    }

    public void setBadgeGravity(int r5) {
        if (r5 != 8388691) goto L5;
    L6:
        Log.w(TAG, "Bottom badge gravities are deprecated; please use a top gravity instead.");
    L8:
        if (this.state.getBadgeGravity() == r5) goto L11;
        this.state.setBadgeGravity(r5);
        onBadgeGravityUpdated();
        return;
    L11:
        return;
    L5:
        if (r5 != 8388693) goto L8;
        goto L6
    }

    public void setBadgeNumberLocale(@NonNull Locale r5) {
        if (r5.equals(this.state.getNumberLocale()) == true) goto L6;
        this.state.setNumberLocale(r5);
        invalidateSelf();
        return;
    }

    public void setBadgeTextColor(@ColorInt int r5) {
        if (this.textDrawableHelper.getTextPaint().getColor() == r5) goto L6;
        this.state.setBadgeTextColor(r5);
        onBadgeTextColorUpdated();
        return;
    }

    public void setBadgeWithTextShapeAppearance(@StyleRes int r5) {
        this.state.setBadgeWithTextShapeAppearanceResId(r5);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithTextShapeAppearanceOverlay(@StyleRes int r5) {
        this.state.setBadgeWithTextShapeAppearanceOverlayResId(r5);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithoutTextShapeAppearance(@StyleRes int r5) {
        this.state.setBadgeShapeAppearanceResId(r5);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithoutTextShapeAppearanceOverlay(@StyleRes int r5) {
        this.state.setBadgeShapeAppearanceOverlayResId(r5);
        onBadgeShapeAppearanceUpdated();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int r5) {
        this.state.setContentDescriptionExceedsMaxBadgeNumberStringResource(r5);
    }

    public void setContentDescriptionForText(@Nullable CharSequence r5) {
        this.state.setContentDescriptionForText(r5);
    }

    public void setContentDescriptionNumberless(CharSequence r5) {
        this.state.setContentDescriptionNumberless(r5);
    }

    public void setContentDescriptionQuantityStringsResource(@PluralsRes int r5) {
        this.state.setContentDescriptionQuantityStringsResource(r5);
    }

    public void setHorizontalOffset(int r5) {
        setHorizontalOffsetWithoutText(r5);
        setHorizontalOffsetWithText(r5);
    }

    public void setHorizontalOffsetWithText(@Px int r5) {
        this.state.setHorizontalOffsetWithText(r5);
        updateCenterAndBounds();
    }

    public void setHorizontalOffsetWithoutText(@Px int r5) {
        this.state.setHorizontalOffsetWithoutText(r5);
        updateCenterAndBounds();
    }

    public void setHorizontalPadding(@Px int r5) {
        if (r5 == this.state.getBadgeHorizontalPadding()) goto L6;
        this.state.setBadgeHorizontalPadding(r5);
        updateCenterAndBounds();
        return;
    }

    public void setLargeFontVerticalOffsetAdjustment(@Px int r5) {
        this.state.setLargeFontVerticalOffsetAdjustment(r5);
        updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int r5) {
        if (this.state.getMaxCharacterCount() == r5) goto L6;
        this.state.setMaxCharacterCount(r5);
        onMaxBadgeLengthUpdated();
        return;
    }

    public void setMaxNumber(int r5) {
        if (this.state.getMaxNumber() == r5) goto L6;
        this.state.setMaxNumber(r5);
        onMaxBadgeLengthUpdated();
        return;
    }

    public void setNumber(int r5) {
        int r10 = Math.max(0, r5);
        if (this.state.getNumber() == r10) goto L6;
        this.state.setNumber(r10);
        onNumberUpdated();
        return;
    }

    public void setText(@Nullable String r5) {
        if (TextUtils.equals(this.state.getText(), r5) == true) goto L6;
        this.state.setText(r5);
        onTextUpdated();
        return;
    }

    public void setTextAppearance(@StyleRes int r5) {
        this.state.setTextAppearanceResId(r5);
        onBadgeTextAppearanceUpdated();
    }

    public void setVerticalOffset(int r5) {
        setVerticalOffsetWithoutText(r5);
        setVerticalOffsetWithText(r5);
    }

    public void setVerticalOffsetWithText(@Px int r5) {
        this.state.setVerticalOffsetWithText(r5);
        updateCenterAndBounds();
    }

    public void setVerticalOffsetWithoutText(@Px int r5) {
        this.state.setVerticalOffsetWithoutText(r5);
        updateCenterAndBounds();
    }

    public void setVerticalPadding(@Px int r5) {
        if (r5 == this.state.getBadgeVerticalPadding()) goto L6;
        this.state.setBadgeVerticalPadding(r5);
        updateCenterAndBounds();
        return;
    }

    public void setVisible(boolean r5) {
        this.state.setVisible(r5);
        onVisibilityUpdated();
    }

    @Deprecated
    public void updateBadgeCoordinates(@NonNull View r5, @Nullable ViewGroup r10) {
        if ((r10 instanceof FrameLayout) == false) goto L7;
        updateBadgeCoordinates(r5, (FrameLayout) r10);
        return;
    L7:
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(@NonNull View r5) {
        updateBadgeCoordinates(r5, null);
    }

    public void updateBadgeCoordinates(@NonNull View r5, @Nullable FrameLayout r10) {
        this.anchorViewRef = new WeakReference(r5);
        boolean r11 = BadgeUtils.USE_COMPAT_PARENT;
        if (r11 == false) goto L6;
        if (r10 != null) goto L6;
        tryWrapAnchorInCompatParent(r5);
    L7:
        if (r11 == true) goto L9;
        updateAnchorParentToNotClip(r5);
    L9:
        updateCenterAndBounds();
        invalidateSelf();
        return;
    L6:
        this.customBadgeParentRef = new WeakReference(r10);
        goto L7
    }
}
