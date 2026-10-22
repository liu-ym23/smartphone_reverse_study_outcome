package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEFAULT_PLACEHOLDER_FADE_DURATION = 87;
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] EDIT_TEXT_BACKGROUND_RIPPLE_STATE = null;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private static final int NO_WIDTH = -1;
    private static final int PLACEHOLDER_START_DELAY = 67;
    private ValueAnimator animator;
    private boolean areCornerRadiiRtl;

    @Nullable
    private MaterialShapeDrawable boxBackground;
    private boolean boxBackgroundApplied;

    @ColorInt
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;

    @ColorInt
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;

    @Nullable
    private MaterialShapeDrawable boxUnderlineDefault;

    @Nullable
    private MaterialShapeDrawable boxUnderlineFocused;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;

    @Nullable
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;

    @Nullable
    private ColorStateList counterTextColor;

    @Nullable
    private TextView counterView;

    @Nullable
    private ColorStateList cursorColor;

    @Nullable
    private ColorStateList cursorErrorColor;

    @ColorInt
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;

    @ColorInt
    private int defaultStrokeColor;

    @ColorInt
    private int disabledColor;

    @ColorInt
    private int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;

    @Nullable
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;

    @NonNull
    private final EndCompoundLayout endLayout;
    private boolean expandedHintEnabled;
    private StateListDrawable filledDropDownMenuBackground;

    @ColorInt
    private int focusedFilledBackgroundColor;

    @ColorInt
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean globalLayoutListenerAdded;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;

    @ColorInt
    private int hoveredFilledBackgroundColor;

    @ColorInt
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;

    @NonNull
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;

    @NonNull
    private LengthCounter lengthCounter;
    private int maxEms;
    private int maxWidth;
    private int minEms;
    private int minWidth;
    private Drawable originalEditTextEndDrawable;
    int originalEditTextMinimumHeight;
    private CharSequence originalHint;
    private MaterialShapeDrawable outlinedDropDownMenuBackground;
    private boolean placeholderEnabled;

    @Nullable
    private Fade placeholderFadeIn;

    @Nullable
    private Fade placeholderFadeOut;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;

    @Nullable
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;
    private boolean restoringSavedState;

    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;

    @Nullable
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;

    @NonNull
    private final StartCompoundLayout startLayout;
    private ColorStateList strokeErrorColor;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(@NonNull TextInputLayout r5) {
            this.layout = r5;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View r12, @NonNull AccessibilityNodeInfoCompat r13) {
            super.onInitializeAccessibilityNodeInfo(r12, r13);
            EditText r5 = this.layout.getEditText();
            if (r5 == null) goto L5;
            CharSequence r10 = r5.getText();
        L6:
            CharSequence r11 = this.layout.getHint();
            CharSequence r14 = this.layout.getError();
            CharSequence r15 = this.layout.getPlaceholderText();
            int r16 = this.layout.getCounterMaxLength();
            CharSequence r17 = this.layout.getCounterOverflowDescription();
            boolean r18 = TextUtils.isEmpty(r10);
            boolean r19 = TextUtils.isEmpty(r11);
            boolean r20 = this.layout.isHintExpanded();
            boolean r21 = TextUtils.isEmpty(r14);
            if (r21 == true) goto L9;
        L12:
            boolean r110 = true;
        L13:
            if (r19 == true) goto L15;
            String r22 = r11.toString();
        L16:
            TextInputLayout.access$400(this.layout).setupAccessibilityNodeInfo(r13);
            if (r18 == true) goto L20;
            r13.setText(r10);
        L28:
            if (TextUtils.isEmpty(r22) == true) goto L30;
            r13.setHintText(r22);
            r13.setShowingHintText(r18);
        L30:
            if (r10 != null) goto L32;
        L34:
            r16 = -1;
        L35:
            r13.setMaxTextLength(r16);
            if (r110 == false) goto L41;
            if (r21 == false) goto L40;
            r14 = r17;
        L40:
            r13.setError(r14);
        L41:
            View r23 = TextInputLayout.access$500(this.layout).getHelperTextView();
            if (r23 == null) goto L44;
            r13.setLabelFor(r23);
        L44:
            TextInputLayout.access$300(this.layout).getEndIconDelegate().onInitializeAccessibilityNodeInfo(r12, r13);
            return;
        L32:
            if (r10.length() != r16) goto L34;
        L20:
            if (TextUtils.isEmpty(r22) == true) goto L25;
            r13.setText(r22);
            if (r20 == true) goto L28;
            if (r15 == null) goto L28;
            r13.setText(r22 + ", " + r15);
            goto L28
        L25:
            if (r15 == null) goto L28;
            r13.setText(r15);
            goto L28
        L15:
            r22 = "";
            goto L16
        L9:
            if (TextUtils.isEmpty(r17) == false) goto L12;
            r110 = false;
            goto L13
        L5:
            r10 = null;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(@NonNull View r5, @NonNull AccessibilityEvent r10) {
            super.onPopulateAccessibilityEvent(r5, r10);
            TextInputLayout.access$300(this.layout).getEndIconDelegate().onPopulateAccessibilityEvent(r5, r10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface EndIconMode {
    }

    public interface LengthCounter {
        int countLength(@Nullable Editable r5);
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(@NonNull TextInputLayout r5);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(@NonNull TextInputLayout r5, int r10);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        CharSequence error;
        boolean isEndIconChecked;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            TextUtils.writeToParcel(this.error, r5, r10);
            r5.writeInt(this.isEndIconChecked ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r5, ClassLoader r10) {
            super(r5, r10);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r5);
            boolean r11 = true;
            if (r5.readInt() == 1) goto L6;
            r11 = false;
        L6:
            this.isEndIconChecked = r11;
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_TextInputLayout;
        EDIT_TEXT_BACKGROUND_RIPPLE_STATE = new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]};
    }

    public TextInputLayout(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(TextInputLayout r5) {
        r5.lambda$onGlobalLayout$1();
    }

    public static /* synthetic */ boolean access$000(TextInputLayout r5) {
        return r5.restoringSavedState;
    }

    public static /* synthetic */ boolean access$100(TextInputLayout r5) {
        return r5.placeholderEnabled;
    }

    public static /* synthetic */ void access$200(TextInputLayout r5, Editable r10) {
        r5.updatePlaceholderText(r10);
    }

    public static /* synthetic */ EndCompoundLayout access$300(TextInputLayout r5) {
        return r5.endLayout;
    }

    public static /* synthetic */ StartCompoundLayout access$400(TextInputLayout r5) {
        return r5.startLayout;
    }

    public static /* synthetic */ IndicatorViewController access$500(TextInputLayout r5) {
        return r5.indicatorViewController;
    }

    private void addPlaceholderTextView() {
        TextView r5 = this.placeholderTextView;
        if (r5 == null) goto L6;
        this.inputFrame.addView(r5);
        this.placeholderTextView.setVisibility(0);
        return;
    }

    private void adjustFilledEditTextPaddingForLargeFont() {
        if (this.editText != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode == 1) goto L8;
        return;
    L8:
        if (MaterialResources.isFontScaleAtLeast2_0(getContext()) == false) goto L11;
        EditText r5 = this.editText;
        ViewCompat.setPaddingRelative(r5, ViewCompat.getPaddingStart(r5), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        return;
    L11:
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L16;
        EditText r10 = this.editText;
        ViewCompat.setPaddingRelative(r10, ViewCompat.getPaddingStart(r10), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        return;
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable r5 = this.boxBackground;
        if (r5 != null) goto L5;
        return;
    L5:
        ShapeAppearanceModel r10 = r5.getShapeAppearanceModel();
        ShapeAppearanceModel r11 = this.shapeAppearanceModel;
        if (r10 == r11) goto L9;
        this.boxBackground.setShapeAppearanceModel(r11);
    L9:
        if (canDrawOutlineStroke() == false) goto L11;
        this.boxBackground.setStroke(this.boxStrokeWidthPx, this.boxStrokeColor);
    L11:
        int r12 = calculateBoxBackgroundColor();
        this.boxBackgroundColor = r12;
        this.boxBackground.setFillColor(ColorStateList.valueOf(r12));
        applyBoxUnderlineAttributes();
        updateEditTextBoxBackgroundIfNeeded();
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderlineDefault != null) goto L5;
        return;
    L5:
        if (this.boxUnderlineFocused != null) goto L8;
        return;
    L8:
        if (canDrawStroke() == false) goto L14;
        MaterialShapeDrawable r5 = this.boxUnderlineDefault;
        if (this.editText.isFocused() == false) goto L12;
        ColorStateList r10 = ColorStateList.valueOf(this.defaultStrokeColor);
    L13:
        r5.setFillColor(r10);
        this.boxUnderlineFocused.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
        goto L14
    L12:
        r10 = ColorStateList.valueOf(this.boxStrokeColor);
    L14:
        invalidate();
    }

    private void applyCutoutPadding(@NonNull RectF r5) {
        float r10 = r5.left;
        int r11 = this.boxLabelCutoutPaddingPx;
        r5.left = r10 - r11;
        r5.right += r11;
    }

    private void assignBoxBackgroundByMode() {
        int r5 = this.boxBackgroundMode;
        if (r5 != 0) goto L5;
        this.boxBackground = null;
        this.boxUnderlineDefault = null;
        this.boxUnderlineFocused = null;
        return;
    L5:
        if (r5 != 1) goto L7;
        this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.boxUnderlineDefault = new MaterialShapeDrawable();
        this.boxUnderlineFocused = new MaterialShapeDrawable();
        return;
    L7:
        if (r5 != 2) goto L16;
        if (this.hintEnabled == true) goto L11;
    L13:
        this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
    L14:
        this.boxUnderlineDefault = null;
        this.boxUnderlineFocused = null;
        return;
    L11:
        if ((this.boxBackground instanceof CutoutDrawable) == true) goto L13;
        this.boxBackground = CutoutDrawable.create(this.shapeAppearanceModel);
        goto L14
    L16:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.s(new StringBuilder(), this.boxBackgroundMode, " is illegal; only @BoxBackgroundMode constants are supported."));
    }

    public static /* synthetic */ int b(Editable r5) {
        return lambda$new$0(r5);
    }

    private int calculateBoxBackgroundColor() {
        int r5 = this.boxBackgroundColor;
        if (this.boxBackgroundMode == 1) goto L5;
        return r5;
    L5:
        return MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface, 0), this.boxBackgroundColor);
    }

    @NonNull
    private Rect calculateCollapsedTextBounds(@NonNull Rect r5) {
        if (this.editText == null) goto L15;
        Rect r10 = this.tmpBoundsRect;
        boolean r11 = ViewUtils.isLayoutRtl(this);
        r10.bottom = r5.bottom;
        int r12 = this.boxBackgroundMode;
        if (r12 != 1) goto L7;
        r10.left = getLabelLeftBoundAlignedWithPrefixAndSuffix(r5.left, r11);
        r10.top = r5.top + this.boxCollapsedPaddingTopPx;
        r10.right = getLabelRightBoundAlignedWithPrefixAndSuffix(r5.right, r11);
        return r10;
    L7:
        if (r12 == 2) goto L10;
        r10.left = getLabelLeftBoundAlignedWithPrefixAndSuffix(r5.left, r11);
        r10.top = getPaddingTop();
        r10.right = getLabelRightBoundAlignedWithPrefixAndSuffix(r5.right, r11);
        return r10;
    L10:
        int r13 = r5.left;
        r10.left = this.editText.getPaddingLeft() + r13;
        r10.top = r5.top - calculateLabelMarginTop();
        r10.right = r5.right - this.editText.getPaddingRight();
        return r10;
    L15:
        throw new IllegalStateException();
    }

    private int calculateExpandedLabelBottom(@NonNull Rect r5, @NonNull Rect r10, float r11) {
        if (isSingleLineFilledTextField() == false) goto L7;
        return (int) (r10.top + r11);
    L7:
        return r5.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(@NonNull Rect r5, float r10) {
        if (isSingleLineFilledTextField() == false) goto L7;
        return (int) (r5.centerY() - (r10 / 2.0f));
    L7:
        return this.editText.getCompoundPaddingTop() + r5.top;
    }

    @NonNull
    private Rect calculateExpandedTextBounds(@NonNull Rect r5) {
        if (this.editText == null) goto L7;
        Rect r10 = this.tmpBoundsRect;
        float r11 = this.collapsingTextHelper.getExpandedTextHeight();
        int r12 = r5.left;
        r10.left = this.editText.getCompoundPaddingLeft() + r12;
        r10.top = calculateExpandedLabelTop(r5, r11);
        r10.right = r5.right - this.editText.getCompoundPaddingRight();
        r10.bottom = calculateExpandedLabelBottom(r5, r10, r11);
        return r10;
    L7:
        throw new IllegalStateException();
    }

    private int calculateLabelMarginTop() {
        if (this.hintEnabled == true) goto L5;
        return 0;
    L5:
        int r5 = this.boxBackgroundMode;
        if (r5 != 0) goto L8;
        float r10 = this.collapsingTextHelper.getCollapsedTextHeight();
    L12:
        return (int) r10;
    L8:
        if (r5 == 2) goto L10;
        return 0;
    L10:
        r10 = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        goto L12
    }

    private boolean canDrawOutlineStroke() {
        if (this.boxBackgroundMode == 2) goto L5;
    L7:
        return false;
    L5:
        if (canDrawStroke() == false) goto L7;
        return true;
    }

    private boolean canDrawStroke() {
        if (this.boxStrokeWidthPx > (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.boxStrokeColor == 0) goto L7;
        return true;
    }

    private void closeCutout() {
        if (cutoutEnabled() == false) goto L6;
        ((CutoutDrawable) this.boxBackground).removeCutout();
        return;
    }

    private void collapseHint(boolean r5) {
        ValueAnimator r10 = this.animator;
        if (r10 == null) goto L8;
        if (r10.isRunning() == false) goto L8;
        this.animator.cancel();
    L8:
        if (r5 == true) goto L10;
    L12:
        this.collapsingTextHelper.setExpansionFraction(1.0f);
    L13:
        this.hintExpanded = false;
        if (cutoutEnabled() == false) goto L16;
        openCutout();
    L16:
        updatePlaceholderText();
        this.startLayout.onHintStateChanged(false);
        this.endLayout.onHintStateChanged(false);
        return;
    L10:
        if (this.hintAnimationEnabled == false) goto L12;
        animateToExpansionFraction(1.0f);
        goto L13
    }

    private Fade createPlaceholderFadeTransition() {
        Fade r5 = new Fade();
        r5.setDuration(MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationShort2, 87));
        r5.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR));
        return r5;
    }

    private boolean cutoutEnabled() {
        if (this.hintEnabled == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.hint) == true) goto L9;
        if ((this.boxBackground instanceof CutoutDrawable) == false) goto L9;
        return true;
    }

    private void dispatchOnEditTextAttached() {
        Iterator<OnEditTextAttachedListener> r5 = this.editTextAttachedListeners.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().onEditTextAttached(this);
        goto L4
    }

    private void drawBoxUnderline(Canvas r10) {
        if (this.boxUnderlineFocused == null) goto L10;
        MaterialShapeDrawable r5 = this.boxUnderlineDefault;
        if (r5 == null) goto L11;
        r5.draw(r10);
        if (this.editText.isFocused() == false) goto L12;
        Rect r11 = this.boxUnderlineFocused.getBounds();
        Rect r12 = this.boxUnderlineDefault.getBounds();
        float r13 = this.collapsingTextHelper.getExpansionFraction();
        int r14 = r12.centerX();
        r11.left = AnimationUtils.lerp(r14, r12.left, r13);
        r11.right = AnimationUtils.lerp(r14, r12.right, r13);
        this.boxUnderlineFocused.draw(r10);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void drawHint(@NonNull Canvas r5) {
        if (this.hintEnabled == false) goto L6;
        this.collapsingTextHelper.draw(r5);
        return;
    }

    private void expandHint(boolean r5) {
        ValueAnimator r10 = this.animator;
        if (r10 == null) goto L8;
        if (r10.isRunning() == false) goto L8;
        this.animator.cancel();
    L8:
        if (r5 == true) goto L10;
    L12:
        this.collapsingTextHelper.setExpansionFraction(0.0f);
    L14:
        if (cutoutEnabled() == true) goto L16;
    L18:
        this.hintExpanded = true;
        hidePlaceholderText();
        this.startLayout.onHintStateChanged(true);
        this.endLayout.onHintStateChanged(true);
        return;
    L16:
        if (((CutoutDrawable) this.boxBackground).hasCutout() == false) goto L18;
        closeCutout();
        goto L18
    L10:
        if (this.hintAnimationEnabled == false) goto L12;
        animateToExpansionFraction(0.0f);
        goto L14
    }

    private MaterialShapeDrawable getDropDownMaterialShapeDrawable(boolean r5) {
        float r10 = getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        if (r5 == false) goto L5;
        float r11 = r10;
    L6:
        EditText r12 = this.editText;
        if ((r12 instanceof MaterialAutoCompleteTextView) == false) goto L9;
        float r13 = ((MaterialAutoCompleteTextView) r12).getPopupElevation();
    L10:
        int r14 = getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ShapeAppearanceModel r15 = ShapeAppearanceModel.builder().setTopLeftCornerSize(r11).setTopRightCornerSize(r11).setBottomLeftCornerSize(r10).setBottomRightCornerSize(r10).build();
        EditText r16 = this.editText;
        if ((r16 instanceof MaterialAutoCompleteTextView) == false) goto L13;
        ColorStateList r17 = ((MaterialAutoCompleteTextView) r16).getDropDownBackgroundTintList();
    L14:
        MaterialShapeDrawable r18 = MaterialShapeDrawable.createWithElevationOverlay(getContext(), r13, r17);
        r18.setShapeAppearanceModel(r15);
        r18.setPadding(0, r14, 0, r14);
        return r18;
    L13:
        r17 = null;
        goto L14
    L9:
        r13 = getResources().getDimensionPixelOffset(R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        goto L10
    L5:
        r11 = 0.0f;
        goto L6
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        EditText r5 = this.editText;
        if ((r5 instanceof AutoCompleteTextView) == false) goto L18;
        if (EditTextUtils.isEditable(r5) == true) goto L18;
        int r10 = MaterialColors.getColor(this.editText, R.attr.colorControlHighlight);
        int r11 = this.boxBackgroundMode;
        if (r11 != 2) goto L12;
        return getOutlinedBoxBackgroundWithRipple(getContext(), this.boxBackground, r10, EDIT_TEXT_BACKGROUND_RIPPLE_STATE);
    L12:
        if (r11 == 1) goto L14;
        return null;
    L14:
        return getFilledBoxBackgroundWithRipple(this.boxBackground, this.boxBackgroundColor, r10, EDIT_TEXT_BACKGROUND_RIPPLE_STATE);
    L18:
        return this.boxBackground;
    }

    private static Drawable getFilledBoxBackgroundWithRipple(MaterialShapeDrawable r5, int r10, int r11, int[][] r12) {
        return new RippleDrawable(new ColorStateList(r12, new int[]{MaterialColors.layer(r11, r10, 0.1f), r10}), r5, r5);
    }

    private int getLabelLeftBoundAlignedWithPrefixAndSuffix(int r5, boolean r10) {
        if (r10 == false) goto L4;
    L8:
        if (r10 == false) goto L13;
        if (getSuffixText() == null) goto L13;
        int r11 = this.endLayout.getSuffixTextEndOffset();
    L7:
        return r5 + r11;
    L13:
        return this.editText.getCompoundPaddingLeft() + r5;
    L4:
        if (getPrefixText() == null) goto L8;
        r11 = this.startLayout.getPrefixTextStartOffset();
        goto L7
    }

    private int getLabelRightBoundAlignedWithPrefixAndSuffix(int r5, boolean r10) {
        if (r10 == false) goto L4;
    L8:
        if (r10 == true) goto L10;
    L12:
        int r11 = this.editText.getCompoundPaddingRight();
    L7:
        return r5 - r11;
    L10:
        if (getPrefixText() == null) goto L12;
        r11 = this.startLayout.getPrefixTextStartOffset();
        goto L7
    L4:
        if (getSuffixText() == null) goto L8;
        r11 = this.endLayout.getSuffixTextEndOffset();
        goto L7
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.filledDropDownMenuBackground != null) goto L6;
        StateListDrawable r5 = new StateListDrawable();
        this.filledDropDownMenuBackground = r5;
        r5.addState(new int[]{android.R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
        this.filledDropDownMenuBackground.addState(new int[0], getDropDownMaterialShapeDrawable(false));
    L6:
        return this.filledDropDownMenuBackground;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.outlinedDropDownMenuBackground != null) goto L6;
        this.outlinedDropDownMenuBackground = getDropDownMaterialShapeDrawable(true);
    L6:
        return this.outlinedDropDownMenuBackground;
    }

    private static Drawable getOutlinedBoxBackgroundWithRipple(Context r5, MaterialShapeDrawable r10, int r11, int[][] r12) {
        int r13 = MaterialColors.getColor(r5, R.attr.colorSurface, LOG_TAG);
        MaterialShapeDrawable r14 = new MaterialShapeDrawable(r10.getShapeAppearanceModel());
        int r15 = MaterialColors.layer(r11, r13, 0.1f);
        r14.setFillColor(new ColorStateList(r12, new int[]{r15, 0}));
        r14.setTint(r13);
        ColorStateList r16 = new ColorStateList(r12, new int[]{r15, r13});
        MaterialShapeDrawable r17 = new MaterialShapeDrawable(r10.getShapeAppearanceModel());
        r17.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(r16, r14, r17), r10});
    }

    private void hidePlaceholderText() {
        TextView r5 = this.placeholderTextView;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.placeholderEnabled == false) goto L9;
        r5.setText(null);
        TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeOut);
        this.placeholderTextView.setVisibility(4);
        return;
    }

    private boolean isOnError() {
        if (shouldShowError() == false) goto L5;
    L10:
        return true;
    L5:
        if (this.counterView != null) goto L7;
    L9:
        return false;
    L7:
        if (this.counterOverflowed == false) goto L9;
        goto L9
    }

    private boolean isSingleLineFilledTextField() {
        if (this.boxBackgroundMode == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.editText.getMinLines() > 1) goto L7;
        return true;
    }

    private static /* synthetic */ int lambda$new$0(Editable r5) {
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.length();
    }

    private /* synthetic */ void lambda$onGlobalLayout$1() {
        this.editText.requestLayout();
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        updateEditTextBoxBackgroundIfNeeded();
        updateTextInputBoxState();
        updateBoxCollapsedPaddingTop();
        adjustFilledEditTextPaddingForLargeFont();
        if (this.boxBackgroundMode == 0) goto L5;
        updateInputLayoutMargins();
    L5:
        setDropDownMenuBackgroundIfNeeded();
    }

    private void openCutout() {
        if (cutoutEnabled() == true) goto L5;
        return;
    L5:
        RectF r5 = this.tmpRectF;
        this.collapsingTextHelper.getCollapsedTextActualBounds(r5, this.editText.getWidth(), this.editText.getGravity());
        if (r5.width() > 0.0f) goto L8;
        return;
    L8:
        if (r5.height() <= 0.0f) goto L13;
        applyCutoutPadding(r5);
        r5.offset(-getPaddingLeft(), ((-getPaddingTop()) - (r5.height() / 2.0f)) + this.boxStrokeWidthPx);
        ((CutoutDrawable) this.boxBackground).setCutout(r5);
        return;
    }

    private void recalculateCutout() {
        if (cutoutEnabled() == true) goto L5;
        return;
    L5:
        if (this.hintExpanded == true) goto L9;
        closeCutout();
        openCutout();
        return;
    }

    private static void recursiveSetEnabled(@NonNull ViewGroup r5, boolean r10) {
        int r11 = r5.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        View r13 = r5.getChildAt(r12);
        r13.setEnabled(r10);
        if ((r13 instanceof ViewGroup) == false) goto L7;
        recursiveSetEnabled((ViewGroup) r13, r10);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    private void removePlaceholderTextView() {
        TextView r5 = this.placeholderTextView;
        if (r5 == null) goto L6;
        r5.setVisibility(8);
        return;
    }

    private void setDropDownMenuBackgroundIfNeeded() {
        EditText r5 = this.editText;
        if ((r5 instanceof AutoCompleteTextView) == true) goto L5;
        return;
    L5:
        AutoCompleteTextView r10 = (AutoCompleteTextView) r5;
        if (r10.getDropDownBackground() != null) goto L14;
        int r11 = this.boxBackgroundMode;
        if (r11 != 2) goto L11;
        r10.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
        return;
    L11:
        if (r11 != 1) goto L16;
        r10.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
        return;
    L16:
        return;
    }

    private void setEditText(final EditText r5) {
        if (this.editText != null) goto L35;
        if (getEndIconMode() != 3) goto L7;
    L9:
        this.editText = r5;
        int r10 = this.minEms;
        if (r10 == (-1)) goto L12;
        setMinEms(r10);
    L13:
        int r11 = this.maxEms;
        if (r11 == (-1)) goto L16;
        setMaxEms(r11);
    L17:
        this.boxBackgroundApplied = false;
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        this.collapsingTextHelper.setExpandedLetterSpacing(this.editText.getLetterSpacing());
        int r12 = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((r12 & (-113)) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(r12);
        this.originalEditTextMinimumHeight = ViewCompat.getMinimumHeight(r5);
        this.editText.addTextChangedListener(new AnonymousClass1(this, r5));
        if (this.defaultHintTextColor != null) goto L21;
        this.defaultHintTextColor = this.editText.getHintTextColors();
    L21:
        if (this.hintEnabled == true) goto L23;
    L26:
        updateCursorColor();
        if (this.counterView == null) goto L29;
        updateCounter(this.editText.getText());
    L29:
        updateEditTextBackground();
        this.indicatorViewController.adjustIndicatorPadding();
        this.startLayout.bringToFront();
        this.endLayout.bringToFront();
        dispatchOnEditTextAttached();
        this.endLayout.updateSuffixTextViewPadding();
        if (isEnabled() == true) goto L32;
        r5.setEnabled(false);
    L32:
        updateLabelState(false, true);
        return;
    L23:
        if (TextUtils.isEmpty(this.hint) == false) goto L25;
        CharSequence r13 = this.editText.getHint();
        this.originalHint = r13;
        setHint(r13);
        this.editText.setHint(null);
    L25:
        this.isProvidingHint = true;
        goto L26
    L16:
        setMaxWidth(this.maxWidth);
        goto L17
    L12:
        setMinWidth(this.minWidth);
        goto L13
    L7:
        if ((r5 instanceof TextInputEditText) == true) goto L9;
        Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        goto L9
    L35:
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence r5) {
        if (TextUtils.equals(r5, this.hint) == true) goto L8;
        this.hint = r5;
        this.collapsingTextHelper.setText(r5);
        if (this.hintExpanded == true) goto L9;
        openCutout();
        return;
    L9:
        return;
    }

    private void setPlaceholderTextEnabled(boolean r5) {
        if (this.placeholderEnabled != r5) goto L5;
        return;
    L5:
        if (r5 == false) goto L7;
        addPlaceholderTextView();
    L8:
        this.placeholderEnabled = r5;
        return;
    L7:
        removePlaceholderTextView();
        this.placeholderTextView = null;
        goto L8
    }

    private boolean shouldUpdateEndDummyDrawable() {
        if (this.endLayout.isErrorIconVisible() == true) goto L11;
        if (this.endLayout.hasEndIcon() == false) goto L9;
        if (isEndIconVisible() == true) goto L11;
    L9:
        if (this.endLayout.getSuffixText() != null) goto L11;
    L13:
        return false;
    L11:
        if (this.endLayout.getMeasuredWidth() <= 0) goto L13;
        return true;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        if (getStartIconDrawable() != null) goto L9;
        if (getPrefixText() != null) goto L7;
    L11:
        return false;
    L7:
        if (getPrefixTextView().getVisibility() != 0) goto L11;
    L9:
        if (this.startLayout.getMeasuredWidth() <= 0) goto L11;
        return true;
    }

    private void showPlaceholderText() {
        if (this.placeholderTextView != null) goto L5;
        return;
    L5:
        if (this.placeholderEnabled == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.placeholderText) == true) goto L12;
        this.placeholderTextView.setText(this.placeholderText);
        TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeIn);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
        announceForAccessibility(this.placeholderText);
        return;
    }

    private void updateBoxCollapsedPaddingTop() {
        if (this.boxBackgroundMode == 1) goto L5;
        return;
    L5:
        if (MaterialResources.isFontScaleAtLeast2_0(getContext()) == false) goto L8;
        this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
        return;
    L8:
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L13;
        this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
        return;
    }

    private void updateBoxUnderlineBounds(@NonNull Rect r10) {
        MaterialShapeDrawable r5 = this.boxUnderlineDefault;
        if (r5 == null) goto L5;
        int r11 = r10.bottom;
        int r12 = r11 - this.boxStrokeWidthDefaultPx;
        r5.setBounds(r10.left, r12, r10.right, r11);
    L5:
        MaterialShapeDrawable r13 = this.boxUnderlineFocused;
        if (r13 == null) goto L9;
        int r14 = r10.bottom;
        int r15 = r14 - this.boxStrokeWidthFocusedPx;
        r13.setBounds(r10.left, r15, r10.right, r14);
        return;
    }

    private void updateCounter() {
        if (this.counterView == null) goto L10;
        EditText r5 = this.editText;
        if (r5 != null) goto L7;
        Editable r10 = null;
    L8:
        updateCounter(r10);
        return;
    L7:
        r10 = r5.getText();
        goto L8
    }

    private static void updateCounterContentDescription(@NonNull Context r5, @NonNull TextView r10, int r11, int r12, boolean r13) {
        if (r13 == false) goto L4;
        int r14 = R.string.character_counter_overflowed_content_description;
    L5:
        r10.setContentDescription(r5.getString(r14, new Object[]{Integer.valueOf(r11), Integer.valueOf(r12)}));
        return;
    L4:
        r14 = R.string.character_counter_content_description;
        goto L5
    }

    private void updateCounterTextAppearanceAndColor() {
        TextView r5 = this.counterView;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.counterOverflowed == false) goto L7;
        int r10 = this.counterOverflowTextAppearance;
    L8:
        setTextAppearanceCompatWithErrorFallback(r5, r10);
        if (this.counterOverflowed == true) goto L14;
        ColorStateList r11 = this.counterTextColor;
        if (r11 == null) goto L14;
        this.counterView.setTextColor(r11);
    L14:
        if (this.counterOverflowed == false) goto L20;
        ColorStateList r12 = this.counterOverflowTextColor;
        if (r12 == null) goto L21;
        this.counterView.setTextColor(r12);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r10 = this.counterTextAppearance;
        goto L8
    }

    @RequiresApi(29)
    private void updateCursorColor() {
        ColorStateList r5 = this.cursorColor;
        if (r5 != null) goto L6;
        r5 = MaterialColors.getColorStateListOrNull(getContext(), R.attr.colorControlActivated);
    L6:
        EditText r10 = this.editText;
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.getTextCursorDrawable() == null) goto L19;
        Drawable r11 = DrawableCompat.wrap(this.editText.getTextCursorDrawable()).mutate();
        if (isOnError() == false) goto L16;
        ColorStateList r12 = this.cursorErrorColor;
        if (r12 == null) goto L16;
        r5 = r12;
    L16:
        DrawableCompat.setTintList(r11, r5);
        return;
    }

    private void updateEditTextBoxBackground() {
        Drawable r5 = getEditTextBoxBackground();
        ViewCompat.setBackground(this.editText, r5);
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        if (this.editText != null) goto L5;
        return false;
    L5:
        int r5 = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight());
        if (this.editText.getMeasuredHeight() >= r5) goto L9;
        this.editText.setMinimumHeight(r5);
        return true;
    L9:
        return false;
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode == 1) goto L8;
        LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
        int r10 = calculateLabelMarginTop();
        if (r10 == r5.topMargin) goto L9;
        r5.topMargin = r10;
        this.inputFrame.requestLayout();
        return;
    L9:
        return;
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        if (this.placeholderTextView == null) goto L8;
        EditText r5 = this.editText;
        if (r5 == null) goto L9;
        int r10 = r5.getGravity();
        this.placeholderTextView.setGravity(r10);
        this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        return;
    L9:
        return;
    }

    private void updatePlaceholderText() {
        EditText r5 = this.editText;
        if (r5 != null) goto L5;
        Editable r10 = null;
    L6:
        updatePlaceholderText(r10);
        return;
    L5:
        r10 = r5.getText();
        goto L6
    }

    private void updateStrokeErrorColor(boolean r10, boolean r11) {
        int r5 = this.strokeErrorColor.getDefaultColor();
        int r12 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, r5);
        int r13 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, r5);
        if (r10 == false) goto L5;
        this.boxStrokeColor = r13;
        return;
    L5:
        if (r11 == false) goto L7;
        this.boxStrokeColor = r12;
        return;
    L7:
        this.boxStrokeColor = r5;
    }

    public void addOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener r5) {
        this.editTextAttachedListeners.add(r5);
        if (this.editText == null) goto L6;
        r5.onEditTextAttached(this);
        return;
    }

    public void addOnEndIconChangedListener(@NonNull OnEndIconChangedListener r5) {
        this.endLayout.addOnEndIconChangedListener(r5);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View r5, int r10, @NonNull ViewGroup.LayoutParams r11) {
        if ((r5 instanceof EditText) == false) goto L5;
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(r11);
        r12.gravity = (r12.gravity & (-113)) | 16;
        this.inputFrame.addView(r5, r12);
        this.inputFrame.setLayoutParams(r11);
        updateInputLayoutMargins();
        setEditText((EditText) r5);
        return;
    L5:
        super.addView(r5, r10, r11);
    }

    @VisibleForTesting
    public void animateToExpansionFraction(float r5) {
        if (this.collapsingTextHelper.getExpansionFraction() != r5) goto L6;
        return;
    L6:
        if (this.animator != null) goto L8;
        ValueAnimator r10 = new ValueAnimator();
        this.animator = r10;
        r10.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        this.animator.setDuration(MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationMedium4, LABEL_SCALE_ANIMATION_DURATION));
        this.animator.addUpdateListener(new AnonymousClass3(this));
    L8:
        this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), r5});
        this.animator.start();
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endLayout.clearOnEndIconChangedListeners();
    }

    @VisibleForTesting
    public boolean cutoutIsOpen() {
        if (cutoutEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (((CutoutDrawable) this.boxBackground).hasCutout() == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure r5, int r10) {
        EditText r11 = this.editText;
        if (r11 != null) goto L6;
        super.dispatchProvideAutofillStructure(r5, r10);
        return;
    L6:
        int r12 = 0;
        if (this.originalHint == null) goto L14;
        boolean r13 = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence r14 = r11.getHint();
        this.editText.setHint(this.originalHint);
        super.dispatchProvideAutofillStructure(r5, r10);     // Catch: Throwable -> L11
        this.editText.setHint(r14);
        this.isProvidingHint = r13;
        return;
    L11:
        th = move-exception;
        this.editText.setHint(r14);
        this.isProvidingHint = r13;
        throw th;
    L14:
        r5.setAutofillId(getAutofillId());
        onProvideAutofillStructure(r5, r10);
        onProvideAutofillVirtualStructure(r5, r10);
        r5.setChildCount(this.inputFrame.getChildCount());
    L16:
        if (r12 >= this.inputFrame.getChildCount()) goto L27;
        View r15 = this.inputFrame.getChildAt(r12);
        ViewStructure r16 = r5.newChild(r12);
        r15.dispatchProvideAutofillStructure(r16, r10);
        if (r15 != this.editText) goto L20;
        r16.setHint(getHint());
    L20:
        r12 = r12 + 1;
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> r5) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(r5);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r5) {
        super.draw(r5);
        drawHint(r5);
        drawBoxUnderline(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.inDrawableStateChanged == false) goto L5;
        return;
    L5:
        boolean r5 = true;
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] r10 = getDrawableState();
        CollapsingTextHelper r11 = this.collapsingTextHelper;
        if (r11 == null) goto L8;
        boolean r12 = r11.setState(r10);
    L10:
        if (this.editText != null) goto L12;
    L18:
        updateEditTextBackground();
        updateTextInputBoxState();
        if (r12 == false) goto L21;
        invalidate();
    L21:
        this.inDrawableStateChanged = false;
        return;
    L12:
        if (ViewCompat.isLaidOut(this) == true) goto L14;
    L16:
        r5 = false;
    L17:
        updateLabelState(r5);
        goto L18
    L14:
        if (isEnabled() == false) goto L16;
    L8:
        r12 = false;
        goto L10
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText r5 = this.editText;
        if (r5 == null) goto L7;
        int r10 = r5.getBaseline();
        return (getPaddingTop() + r10) + calculateLabelMarginTop();
    L7:
        return super.getBaseline();
    }

    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int r5 = this.boxBackgroundMode;
        if (r5 == 1) goto L10;
        if (r5 == 2) goto L10;
        throw new IllegalStateException();
    L10:
        return this.boxBackground;
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.boxCollapsedPaddingTopPx;
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusTopStart() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L6;
        return this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
    L6:
        return this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        if (this.counterEnabled == true) goto L5;
        return null;
    L5:
        if (this.counterOverflowed == false) goto L12;
        TextView r5 = this.counterView;
        if (r5 != null) goto L9;
        return null;
    L9:
        return r5.getContentDescription();
    L12:
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.counterOverflowTextColor;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorColor() {
        return this.cursorColor;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorErrorColor() {
        return this.cursorErrorColor;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    @Nullable
    public EditText getEditText() {
        return this.editText;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.endLayout.getEndIconContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.endLayout.getEndIconDrawable();
    }

    public int getEndIconMinSize() {
        return this.endLayout.getEndIconMinSize();
    }

    public int getEndIconMode() {
        return this.endLayout.getEndIconMode();
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.endLayout.getEndIconScaleType();
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.endLayout.getEndIconView();
    }

    @Nullable
    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getErrorText();
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.indicatorViewController.getErrorAccessibilityLiveRegion();
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.getErrorContentDescription();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.endLayout.getErrorIconDrawable();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled() == true) goto L7;
        return null;
    L7:
        return this.indicatorViewController.getHelperText();
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.hintEnabled == true) goto L7;
        return null;
    L7:
        return this.hint;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    @NonNull
    public LengthCounter getLengthCounter() {
        return this.lengthCounter;
    }

    public int getMaxEms() {
        return this.maxEms;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMinEms() {
        return this.minEms;
    }

    @Px
    public int getMinWidth() {
        return this.minWidth;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endLayout.getPasswordVisibilityToggleContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endLayout.getPasswordVisibilityToggleDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled == true) goto L7;
        return null;
    L7:
        return this.placeholderText;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.startLayout.getPrefixText();
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.startLayout.getPrefixTextColor();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.startLayout.getPrefixTextView();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.startLayout.getStartIconContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.startLayout.getStartIconDrawable();
    }

    public int getStartIconMinSize() {
        return this.startLayout.getStartIconMinSize();
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.startLayout.getStartIconScaleType();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.endLayout.getSuffixText();
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.endLayout.getSuffixTextColor();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.endLayout.getSuffixTextView();
    }

    @Nullable
    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endLayout.isEndIconCheckable();
    }

    public boolean isEndIconVisible() {
        return this.endLayout.isEndIconVisible();
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    @VisibleForTesting
    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.endLayout.isPasswordVisibilityToggleEnabled();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public boolean isStartIconCheckable() {
        return this.startLayout.isStartIconCheckable();
    }

    public boolean isStartIconVisible() {
        return this.startLayout.isStartIconVisible();
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NonNull Configuration r5) {
        super.onConfigurationChanged(r5);
        this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(r5);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.endLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.globalLayoutListenerAdded = false;
        boolean r5 = updateEditTextHeightBasedOnIcon();
        boolean r10 = updateDummyDrawables();
        if (r5 == true) goto L5;
        if (r10 == true) goto L5;
        return;
    L5:
        this.editText.post(new d(this, 2));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        EditText r14 = this.editText;
        if (r14 == null) goto L12;
        Rect r15 = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect(this, r14, r15);
        updateBoxUnderlineBounds(r15);
        if (this.hintEnabled == false) goto L13;
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int r16 = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((r16 & (-113)) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(r16);
        this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(r15));
        this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(r15));
        this.collapsingTextHelper.recalculate();
        if (cutoutEnabled() == true) goto L9;
        return;
    L9:
        if (this.hintExpanded == true) goto L15;
        openCutout();
        return;
    L15:
        return;
    L13:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        if (this.globalLayoutListenerAdded == true) goto L5;
        this.endLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.globalLayoutListenerAdded = true;
    L5:
        updatePlaceholderMeasurementsBasedOnEditText();
        this.endLayout.updateSuffixTextViewPadding();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        setError(r10.error);
        if (r10.isEndIconChecked == false) goto L9;
        post(new AnonymousClass2(this));
    L9:
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int r10) {
        super.onRtlPropertiesChanged(r10);
        boolean r5 = true;
        if (r10 == 1) goto L7;
        r5 = false;
    L7:
        if (r5 == this.areCornerRadiiRtl) goto L10;
        float r11 = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
        float r12 = this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
        float r13 = this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
        float r14 = this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
        CornerTreatment r15 = this.shapeAppearanceModel.getTopLeftCorner();
        CornerTreatment r16 = this.shapeAppearanceModel.getTopRightCorner();
        CornerTreatment r17 = this.shapeAppearanceModel.getBottomLeftCorner();
        CornerTreatment r18 = this.shapeAppearanceModel.getBottomRightCorner();
        ShapeAppearanceModel r19 = ShapeAppearanceModel.builder().setTopLeftCorner(r16).setTopRightCorner(r15).setBottomLeftCorner(r18).setBottomRightCorner(r17).setTopLeftCornerSize(r12).setTopRightCornerSize(r11).setBottomLeftCornerSize(r14).setBottomRightCornerSize(r13).build();
        this.areCornerRadiiRtl = r5;
        setShapeAppearanceModel(r19);
        return;
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        if (shouldShowError() == false) goto L5;
        r5.error = getError();
    L5:
        r5.isEndIconChecked = this.endLayout.isEndIconChecked();
        return r5;
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean r5) {
        this.endLayout.togglePasswordVisibilityToggle(r5);
    }

    public void refreshEndIconDrawableState() {
        this.endLayout.refreshEndIconDrawableState();
    }

    public void refreshErrorIconDrawableState() {
        this.endLayout.refreshErrorIconDrawableState();
    }

    public void refreshStartIconDrawableState() {
        this.startLayout.refreshStartIconDrawableState();
    }

    public void removeOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener r5) {
        this.editTextAttachedListeners.remove(r5);
    }

    public void removeOnEndIconChangedListener(@NonNull OnEndIconChangedListener r5) {
        this.endLayout.removeOnEndIconChangedListener(r5);
    }

    public void setBoxBackgroundColor(@ColorInt int r5) {
        if (this.boxBackgroundColor == r5) goto L6;
        this.boxBackgroundColor = r5;
        this.defaultFilledBackgroundColor = r5;
        this.focusedFilledBackgroundColor = r5;
        this.hoveredFilledBackgroundColor = r5;
        applyBoxAttributes();
        return;
    }

    public void setBoxBackgroundColorResource(@ColorRes int r5) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), r5));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList r5) {
        int r10 = r5.getDefaultColor();
        this.defaultFilledBackgroundColor = r10;
        this.boxBackgroundColor = r10;
        this.disabledFilledBackgroundColor = r5.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = r5.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = r5.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int r5) {
        if (r5 != this.boxBackgroundMode) goto L5;
        return;
    L5:
        this.boxBackgroundMode = r5;
        if (this.editText == null) goto L9;
        onApplyBoxBackgroundMode();
        return;
    }

    public void setBoxCollapsedPaddingTop(int r5) {
        this.boxCollapsedPaddingTopPx = r5;
    }

    public void setBoxCornerFamily(int r5) {
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCorner(r5, this.shapeAppearanceModel.getTopLeftCornerSize()).setTopRightCorner(r5, this.shapeAppearanceModel.getTopRightCornerSize()).setBottomLeftCorner(r5, this.shapeAppearanceModel.getBottomLeftCornerSize()).setBottomRightCorner(r5, this.shapeAppearanceModel.getBottomRightCornerSize()).build();
        applyBoxAttributes();
    }

    public void setBoxCornerRadii(float r5, float r10, float r11, float r12) {
        boolean r13 = ViewUtils.isLayoutRtl(this);
        this.areCornerRadiiRtl = r13;
        if (r13 == false) goto L5;
        float r14 = r10;
    L6:
        if (r13 == true) goto L9;
        r5 = r10;
    L9:
        if (r13 == false) goto L11;
        float r15 = r12;
    L12:
        if (r13 == true) goto L15;
        r11 = r12;
    L15:
        MaterialShapeDrawable r16 = this.boxBackground;
        if (r16 != null) goto L18;
    L25:
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(r14).setTopRightCornerSize(r5).setBottomLeftCornerSize(r15).setBottomRightCornerSize(r11).build();
        applyBoxAttributes();
        return;
    L18:
        if (r16.getTopLeftCornerResolvedSize() != r14) goto L25;
        if (this.boxBackground.getTopRightCornerResolvedSize() != r5) goto L25;
        if (this.boxBackground.getBottomLeftCornerResolvedSize() != r15) goto L25;
        if (this.boxBackground.getBottomRightCornerResolvedSize() != r11) goto L25;
        return;
    L11:
        r15 = r11;
        goto L12
    L5:
        r14 = r5;
        goto L6
    }

    public void setBoxCornerRadiiResources(@DimenRes int r5, @DimenRes int r10, @DimenRes int r11, @DimenRes int r12) {
        setBoxCornerRadii(getContext().getResources().getDimension(r5), getContext().getResources().getDimension(r10), getContext().getResources().getDimension(r12), getContext().getResources().getDimension(r11));
    }

    public void setBoxStrokeColor(@ColorInt int r5) {
        if (this.focusedStrokeColor == r5) goto L6;
        this.focusedStrokeColor = r5;
        updateTextInputBoxState();
        return;
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList r5) {
        if (r5.isStateful() == false) goto L6;
        this.defaultStrokeColor = r5.getDefaultColor();
        this.disabledColor = r5.getColorForState(new int[]{-16842910}, -1);
        this.hoveredStrokeColor = r5.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        this.focusedStrokeColor = r5.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
    L8:
        updateTextInputBoxState();
        return;
    L6:
        if (this.focusedStrokeColor == r5.getDefaultColor()) goto L8;
        this.focusedStrokeColor = r5.getDefaultColor();
        goto L8
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList r5) {
        if (this.strokeErrorColor == r5) goto L6;
        this.strokeErrorColor = r5;
        updateTextInputBoxState();
        return;
    }

    public void setBoxStrokeWidth(int r5) {
        this.boxStrokeWidthDefaultPx = r5;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int r5) {
        this.boxStrokeWidthFocusedPx = r5;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int r5) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(r5));
    }

    public void setBoxStrokeWidthResource(@DimenRes int r5) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(r5));
    }

    public void setCounterEnabled(boolean r5) {
        if (this.counterEnabled != r5) goto L5;
        return;
    L5:
        if (r5 == false) goto L10;
        AppCompatTextView r10 = new AppCompatTextView(getContext());
        this.counterView = r10;
        r10.setId(R.id.textinput_counter);
        Typeface r11 = this.typeface;
        if (r11 == null) goto L9;
        this.counterView.setTypeface(r11);
    L9:
        this.counterView.setMaxLines(1);
        this.indicatorViewController.addIndicator(this.counterView, 2);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
        updateCounterTextAppearanceAndColor();
        updateCounter();
    L11:
        this.counterEnabled = r5;
        return;
    L10:
        this.indicatorViewController.removeIndicator(this.counterView, 2);
        this.counterView = null;
        goto L11
    }

    public void setCounterMaxLength(int r5) {
        if (this.counterMaxLength == r5) goto L11;
        if (r5 <= 0) goto L6;
        this.counterMaxLength = r5;
    L8:
        if (this.counterEnabled == false) goto L12;
        updateCounter();
        return;
    L12:
        return;
    L6:
        this.counterMaxLength = -1;
        goto L8
    }

    public void setCounterOverflowTextAppearance(int r5) {
        if (this.counterOverflowTextAppearance == r5) goto L6;
        this.counterOverflowTextAppearance = r5;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList r5) {
        if (this.counterOverflowTextColor == r5) goto L6;
        this.counterOverflowTextColor = r5;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterTextAppearance(int r5) {
        if (this.counterTextAppearance == r5) goto L6;
        this.counterTextAppearance = r5;
        updateCounterTextAppearanceAndColor();
        return;
    }

    public void setCounterTextColor(@Nullable ColorStateList r5) {
        if (this.counterTextColor == r5) goto L6;
        this.counterTextColor = r5;
        updateCounterTextAppearanceAndColor();
        return;
    }

    @RequiresApi(29)
    public void setCursorColor(@Nullable ColorStateList r5) {
        if (this.cursorColor == r5) goto L6;
        this.cursorColor = r5;
        updateCursorColor();
        return;
    }

    @RequiresApi(29)
    public void setCursorErrorColor(@Nullable ColorStateList r5) {
        if (this.cursorErrorColor == r5) goto L8;
        this.cursorErrorColor = r5;
        if (isOnError() == false) goto L9;
        updateCursorColor();
        return;
    L9:
        return;
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList r5) {
        this.defaultHintTextColor = r5;
        this.focusedTextColor = r5;
        if (this.editText == null) goto L6;
        updateLabelState(false);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        recursiveSetEnabled(this, r5);
        super.setEnabled(r5);
    }

    public void setEndIconActivated(boolean r5) {
        this.endLayout.setEndIconActivated(r5);
    }

    public void setEndIconCheckable(boolean r5) {
        this.endLayout.setEndIconCheckable(r5);
    }

    public void setEndIconContentDescription(@StringRes int r5) {
        this.endLayout.setEndIconContentDescription(r5);
    }

    public void setEndIconDrawable(@DrawableRes int r5) {
        this.endLayout.setEndIconDrawable(r5);
    }

    public void setEndIconMinSize(@IntRange(from = 0) int r5) {
        this.endLayout.setEndIconMinSize(r5);
    }

    public void setEndIconMode(int r5) {
        this.endLayout.setEndIconMode(r5);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener r5) {
        this.endLayout.setEndIconOnClickListener(r5);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener r5) {
        this.endLayout.setEndIconOnLongClickListener(r5);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType r5) {
        this.endLayout.setEndIconScaleType(r5);
    }

    public void setEndIconTintList(@Nullable ColorStateList r5) {
        this.endLayout.setEndIconTintList(r5);
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode r5) {
        this.endLayout.setEndIconTintMode(r5);
    }

    public void setEndIconVisible(boolean r5) {
        this.endLayout.setEndIconVisible(r5);
    }

    public void setError(@Nullable CharSequence r5) {
        if (this.indicatorViewController.isErrorEnabled() == true) goto L9;
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return;
    L7:
        setErrorEnabled(true);
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        this.indicatorViewController.showError(r5);
        return;
    L11:
        this.indicatorViewController.hideError();
    }

    public void setErrorAccessibilityLiveRegion(int r5) {
        this.indicatorViewController.setErrorAccessibilityLiveRegion(r5);
    }

    public void setErrorContentDescription(@Nullable CharSequence r5) {
        this.indicatorViewController.setErrorContentDescription(r5);
    }

    public void setErrorEnabled(boolean r5) {
        this.indicatorViewController.setErrorEnabled(r5);
    }

    public void setErrorIconDrawable(@DrawableRes int r5) {
        this.endLayout.setErrorIconDrawable(r5);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener r5) {
        this.endLayout.setErrorIconOnClickListener(r5);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener r5) {
        this.endLayout.setErrorIconOnLongClickListener(r5);
    }

    public void setErrorIconTintList(@Nullable ColorStateList r5) {
        this.endLayout.setErrorIconTintList(r5);
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode r5) {
        this.endLayout.setErrorIconTintMode(r5);
    }

    public void setErrorTextAppearance(@StyleRes int r5) {
        this.indicatorViewController.setErrorTextAppearance(r5);
    }

    public void setErrorTextColor(@Nullable ColorStateList r5) {
        this.indicatorViewController.setErrorViewTextColor(r5);
    }

    public void setExpandedHintEnabled(boolean r5) {
        if (this.expandedHintEnabled == r5) goto L6;
        this.expandedHintEnabled = r5;
        updateLabelState(false);
        return;
    }

    public void setHelperText(@Nullable CharSequence r5) {
        if (TextUtils.isEmpty(r5) == false) goto L8;
        if (isHelperTextEnabled() == false) goto L12;
        setHelperTextEnabled(false);
        return;
    L12:
        return;
    L8:
        if (isHelperTextEnabled() == true) goto L10;
        setHelperTextEnabled(true);
    L10:
        this.indicatorViewController.showHelper(r5);
    }

    public void setHelperTextColor(@Nullable ColorStateList r5) {
        this.indicatorViewController.setHelperTextViewTextColor(r5);
    }

    public void setHelperTextEnabled(boolean r5) {
        this.indicatorViewController.setHelperTextEnabled(r5);
    }

    public void setHelperTextTextAppearance(@StyleRes int r5) {
        this.indicatorViewController.setHelperTextAppearance(r5);
    }

    public void setHint(@Nullable CharSequence r5) {
        if (this.hintEnabled == false) goto L6;
        setHintInternal(r5);
        sendAccessibilityEvent(2048);
        return;
    }

    public void setHintAnimationEnabled(boolean r5) {
        this.hintAnimationEnabled = r5;
    }

    public void setHintEnabled(boolean r5) {
        if (r5 == this.hintEnabled) goto L23;
        this.hintEnabled = r5;
        if (r5 == true) goto L12;
        this.isProvidingHint = false;
        if (TextUtils.isEmpty(this.hint) == false) goto L9;
    L11:
        setHintInternal(null);
    L20:
        if (this.editText == null) goto L24;
        updateInputLayoutMargins();
        return;
    L24:
        return;
    L9:
        if (TextUtils.isEmpty(this.editText.getHint()) == false) goto L11;
        this.editText.setHint(this.hint);
        goto L11
    L12:
        CharSequence r10 = this.editText.getHint();
        if (TextUtils.isEmpty(r10) == false) goto L15;
    L18:
        this.isProvidingHint = true;
        goto L20
    L15:
        if (TextUtils.isEmpty(this.hint) == false) goto L17;
        setHint(r10);
    L17:
        this.editText.setHint(null);
        goto L18
    }

    public void setHintTextAppearance(@StyleRes int r5) {
        this.collapsingTextHelper.setCollapsedTextAppearance(r5);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText == null) goto L6;
        updateLabelState(false);
        updateInputLayoutMargins();
        return;
    }

    public void setHintTextColor(@Nullable ColorStateList r5) {
        if (this.focusedTextColor != r5) goto L5;
        return;
    L5:
        if (this.defaultHintTextColor != null) goto L7;
        this.collapsingTextHelper.setCollapsedTextColor(r5);
    L7:
        this.focusedTextColor = r5;
        if (this.editText == null) goto L12;
        updateLabelState(false);
        return;
    }

    public void setLengthCounter(@NonNull LengthCounter r5) {
        this.lengthCounter = r5;
    }

    public void setMaxEms(int r5) {
        this.maxEms = r5;
        EditText r10 = this.editText;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r5 == (-1)) goto L9;
        r10.setMaxEms(r5);
        return;
    }

    public void setMaxWidth(@Px int r5) {
        this.maxWidth = r5;
        EditText r10 = this.editText;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r5 == (-1)) goto L9;
        r10.setMaxWidth(r5);
        return;
    }

    public void setMaxWidthResource(@DimenRes int r5) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(r5));
    }

    public void setMinEms(int r5) {
        this.minEms = r5;
        EditText r10 = this.editText;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r5 == (-1)) goto L9;
        r10.setMinEms(r5);
        return;
    }

    public void setMinWidth(@Px int r5) {
        this.minWidth = r5;
        EditText r10 = this.editText;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r5 == (-1)) goto L9;
        r10.setMinWidth(r5);
        return;
    }

    public void setMinWidthResource(@DimenRes int r5) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(r5));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int r5) {
        this.endLayout.setPasswordVisibilityToggleContentDescription(r5);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int r5) {
        this.endLayout.setPasswordVisibilityToggleDrawable(r5);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean r5) {
        this.endLayout.setPasswordVisibilityToggleEnabled(r5);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList r5) {
        this.endLayout.setPasswordVisibilityToggleTintList(r5);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode r5) {
        this.endLayout.setPasswordVisibilityToggleTintMode(r5);
    }

    public void setPlaceholderText(@Nullable CharSequence r5) {
        if (this.placeholderTextView != null) goto L6;
        AppCompatTextView r10 = new AppCompatTextView(getContext());
        this.placeholderTextView = r10;
        r10.setId(R.id.textinput_placeholder);
        ViewCompat.setImportantForAccessibility(this.placeholderTextView, 2);
        Fade r11 = createPlaceholderFadeTransition();
        this.placeholderFadeIn = r11;
        r11.setStartDelay(67);
        this.placeholderFadeOut = createPlaceholderFadeTransition();
        setPlaceholderTextAppearance(this.placeholderTextAppearance);
        setPlaceholderTextColor(this.placeholderTextColor);
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L9;
        setPlaceholderTextEnabled(false);
    L12:
        updatePlaceholderText();
        return;
    L9:
        if (this.placeholderEnabled == true) goto L11;
        setPlaceholderTextEnabled(true);
    L11:
        this.placeholderText = r5;
        goto L12
    }

    public void setPlaceholderTextAppearance(@StyleRes int r5) {
        this.placeholderTextAppearance = r5;
        TextView r10 = this.placeholderTextView;
        if (r10 == null) goto L6;
        TextViewCompat.setTextAppearance(r10, r5);
        return;
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList r5) {
        if (this.placeholderTextColor == r5) goto L9;
        this.placeholderTextColor = r5;
        TextView r10 = this.placeholderTextView;
        if (r10 == null) goto L10;
        if (r5 == null) goto L11;
        r10.setTextColor(r5);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setPrefixText(@Nullable CharSequence r5) {
        this.startLayout.setPrefixText(r5);
    }

    public void setPrefixTextAppearance(@StyleRes int r5) {
        this.startLayout.setPrefixTextAppearance(r5);
    }

    public void setPrefixTextColor(@NonNull ColorStateList r5) {
        this.startLayout.setPrefixTextColor(r5);
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r5) {
        MaterialShapeDrawable r10 = this.boxBackground;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getShapeAppearanceModel() == r5) goto L9;
        this.shapeAppearanceModel = r5;
        applyBoxAttributes();
        return;
    }

    public void setStartIconCheckable(boolean r5) {
        this.startLayout.setStartIconCheckable(r5);
    }

    public void setStartIconContentDescription(@StringRes int r5) {
        if (r5 == 0) goto L4;
        CharSequence r10 = getResources().getText(r5);
    L5:
        setStartIconContentDescription(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setStartIconDrawable(@DrawableRes int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5);
    L5:
        setStartIconDrawable(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setStartIconMinSize(@IntRange(from = 0) int r5) {
        this.startLayout.setStartIconMinSize(r5);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener r5) {
        this.startLayout.setStartIconOnClickListener(r5);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener r5) {
        this.startLayout.setStartIconOnLongClickListener(r5);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType r5) {
        this.startLayout.setStartIconScaleType(r5);
    }

    public void setStartIconTintList(@Nullable ColorStateList r5) {
        this.startLayout.setStartIconTintList(r5);
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode r5) {
        this.startLayout.setStartIconTintMode(r5);
    }

    public void setStartIconVisible(boolean r5) {
        this.startLayout.setStartIconVisible(r5);
    }

    public void setSuffixText(@Nullable CharSequence r5) {
        this.endLayout.setSuffixText(r5);
    }

    public void setSuffixTextAppearance(@StyleRes int r5) {
        this.endLayout.setSuffixTextAppearance(r5);
    }

    public void setSuffixTextColor(@NonNull ColorStateList r5) {
        this.endLayout.setSuffixTextColor(r5);
    }

    public void setTextAppearanceCompatWithErrorFallback(@NonNull TextView r5, @StyleRes int r10) {
        TextViewCompat.setTextAppearance(r5, r10);     // Catch: Exception -> L7
        if (r5.getTextColors().getDefaultColor() == (-65281)) goto L5;
        return;
    L5:
        TextViewCompat.setTextAppearance(r5, R.style.TextAppearance_AppCompat_Caption);
        r5.setTextColor(ContextCompat.getColor(getContext(), R.color.design_error));
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate r5) {
        EditText r10 = this.editText;
        if (r10 == null) goto L6;
        ViewCompat.setAccessibilityDelegate(r10, r5);
        return;
    }

    public void setTypeface(@Nullable Typeface r5) {
        if (r5 == this.typeface) goto L8;
        this.typeface = r5;
        this.collapsingTextHelper.setTypefaces(r5);
        this.indicatorViewController.setTypefaces(r5);
        TextView r10 = this.counterView;
        if (r10 == null) goto L9;
        r10.setTypeface(r5);
        return;
    L9:
        return;
    }

    public boolean shouldShowError() {
        return this.indicatorViewController.errorShouldBeShown();
    }

    public boolean updateDummyDrawables() {
        if (this.editText != null) goto L5;
        return false;
    L5:
        boolean r5 = true;
        if (shouldUpdateStartDummyDrawable() == false) goto L16;
        int r10 = this.startLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
        if (this.startDummyDrawable != null) goto L10;
    L11:
        ColorDrawable r11 = new ColorDrawable();
        this.startDummyDrawable = r11;
        this.startDummyDrawableWidth = r10;
        r11.setBounds(0, 0, r10, 1);
    L12:
        Drawable[] r12 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        Drawable r13 = r12[0];
        Drawable r14 = this.startDummyDrawable;
        if (r13 == r14) goto L19;
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r14, r12[1], r12[2], r12[3]);
    L18:
        boolean r15 = true;
    L21:
        if (shouldUpdateEndDummyDrawable() == false) goto L38;
        int r16 = this.endLayout.getSuffixTextView().getMeasuredWidth() - this.editText.getPaddingRight();
        CheckableImageButton r17 = this.endLayout.getCurrentEndIconView();
        if (r17 == null) goto L25;
        r16 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r17.getLayoutParams()) + (r17.getMeasuredWidth() + r16);
    L25:
        Drawable[] r18 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        Drawable r19 = this.endDummyDrawable;
        if (r19 != null) goto L28;
    L30:
        if (r19 != null) goto L32;
        ColorDrawable r20 = new ColorDrawable();
        this.endDummyDrawable = r20;
        this.endDummyDrawableWidth = r16;
        r20.setBounds(0, 0, r16, 1);
    L32:
        Drawable r21 = r18[2];
        Drawable r22 = this.endDummyDrawable;
        if (r21 == r22) goto L35;
        this.originalEditTextEndDrawable = r21;
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r18[0], r18[1], r22, r18[3]);
    L44:
        return r5;
    L35:
        r5 = r15;
        goto L44
    L28:
        if (this.endDummyDrawableWidth == r16) goto L30;
        this.endDummyDrawableWidth = r16;
        r19.setBounds(0, 0, r16, 1);
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r18[0], r18[1], this.endDummyDrawable, r18[3]);
        goto L44
    L38:
        if (this.endDummyDrawable == null) goto L45;
        Drawable[] r23 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        if (r23[2] != this.endDummyDrawable) goto L42;
        TextViewCompat.setCompoundDrawablesRelative(this.editText, r23[0], r23[1], this.originalEditTextEndDrawable, r23[3]);
    L43:
        this.endDummyDrawable = null;
        goto L44
    L42:
        r5 = r15;
        goto L43
    L45:
        return r15;
    L19:
        r15 = false;
        goto L21
    L10:
        if (this.startDummyDrawableWidth == r10) goto L12;
    L16:
        if (this.startDummyDrawable == null) goto L19;
        Drawable[] r24 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        TextViewCompat.setCompoundDrawablesRelative(this.editText, null, r24[1], r24[2], r24[3]);
        this.startDummyDrawable = null;
        goto L18
    }

    public void updateEditTextBackground() {
        EditText r5 = this.editText;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode != 0) goto L26;
        Drawable r10 = r5.getBackground();
        if (r10 != null) goto L11;
        return;
    L11:
        if (DrawableUtils.canSafelyMutateDrawable(r10) == false) goto L14;
        r10 = r10.mutate();
    L14:
        if (shouldShowError() == false) goto L17;
        r10.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        return;
    L17:
        if (this.counterOverflowed == false) goto L21;
        TextView r11 = this.counterView;
        if (r11 == null) goto L21;
        r10.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(r11.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        return;
    L21:
        DrawableCompat.clearColorFilter(r10);
        this.editText.refreshDrawableState();
        return;
    }

    public void updateEditTextBoxBackgroundIfNeeded() {
        EditText r5 = this.editText;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.boxBackground != null) goto L7;
        return;
    L7:
        if (this.boxBackgroundApplied == true) goto L11;
        if (r5.getBackground() == null) goto L11;
        return;
    L11:
        if (this.boxBackgroundMode == 0) goto L18;
        updateEditTextBoxBackground();
        this.boxBackgroundApplied = true;
        return;
    }

    public void updateLabelState(boolean r5) {
        updateLabelState(r5, false);
    }

    public void updateTextInputBoxState() {
        if (this.boxBackground != null) goto L5;
        return;
    L5:
        if (this.boxBackgroundMode == 0) goto L70;
        boolean r5 = false;
        if (isFocused() == true) goto L15;
        EditText r10 = this.editText;
        if (r10 != null) goto L12;
    L14:
        boolean r11 = false;
    L17:
        if (isHovered() == true) goto L22;
        EditText r12 = this.editText;
        if (r12 == null) goto L24;
        if (r12.isHovered() == true) goto L22;
    L24:
        if (isEnabled() == true) goto L27;
        this.boxStrokeColor = this.disabledColor;
    L45:
        updateCursorColor();
        this.endLayout.onTextInputBoxStateUpdated();
        refreshStartIconDrawableState();
        if (this.boxBackgroundMode != 2) goto L57;
        int r13 = this.boxStrokeWidthPx;
        if (r11 == true) goto L50;
    L52:
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
    L54:
        if (this.boxStrokeWidthPx == r13) goto L57;
        recalculateCutout();
        goto L57
    L50:
        if (isEnabled() == false) goto L52;
        this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
    L57:
        if (this.boxBackgroundMode == 1) goto L59;
    L67:
        applyBoxAttributes();
        return;
    L59:
        if (isEnabled() == true) goto L61;
        this.boxBackgroundColor = this.disabledFilledBackgroundColor;
        goto L67
    L61:
        if (r5 == false) goto L64;
        if (r11 == true) goto L64;
        this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
    L64:
        if (r11 == false) goto L66;
        this.boxBackgroundColor = this.focusedFilledBackgroundColor;
        goto L67
    L66:
        this.boxBackgroundColor = this.defaultFilledBackgroundColor;
        goto L67
    L27:
        if (shouldShowError() == false) goto L33;
        if (this.strokeErrorColor == null) goto L31;
        updateStrokeErrorColor(r11, r5);
        goto L45
    L31:
        this.boxStrokeColor = getErrorCurrentTextColors();
        goto L45
    L33:
        if (this.counterOverflowed == false) goto L40;
        TextView r14 = this.counterView;
        if (r14 == null) goto L40;
        if (this.strokeErrorColor == null) goto L39;
        updateStrokeErrorColor(r11, r5);
        goto L45
    L39:
        this.boxStrokeColor = r14.getCurrentTextColor();
    L40:
        if (r11 == false) goto L42;
        this.boxStrokeColor = this.focusedStrokeColor;
        goto L45
    L42:
        if (r5 == false) goto L44;
        this.boxStrokeColor = this.hoveredStrokeColor;
        goto L45
    L44:
        this.boxStrokeColor = this.defaultStrokeColor;
    L22:
        r5 = true;
        goto L24
    L12:
        if (r10.hasFocus() == false) goto L14;
    L15:
        r11 = true;
        goto L17
    }

    public TextInputLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.textInputStyle);
    }

    private void updateLabelState(boolean r10, boolean r11) {
        boolean r5 = isEnabled();
        EditText r12 = this.editText;
        boolean r13 = false;
        if (r12 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        EditText r15 = this.editText;
        if (r15 != null) goto L11;
    L13:
        ColorStateList r16 = this.defaultHintTextColor;
        if (r16 == null) goto L16;
        this.collapsingTextHelper.setCollapsedAndExpandedTextColor(r16);
    L16:
        if (r5 == true) goto L23;
        ColorStateList r17 = this.defaultHintTextColor;
        if (r17 == null) goto L20;
        int r18 = r17.getColorForState(new int[]{-16842910}, this.disabledColor);
    L21:
        this.collapsingTextHelper.setCollapsedAndExpandedTextColor(ColorStateList.valueOf(r18));
    L34:
        if (r14 == false) goto L36;
    L45:
        if (r11 == false) goto L47;
    L48:
        collapseHint(r10);
        return;
    L47:
        if (this.hintExpanded == true) goto L48;
        return;
    L36:
        if (this.expandedHintEnabled == false) goto L45;
        if (isEnabled() == false) goto L41;
        if (r13 == true) goto L45;
    L41:
        if (r11 == false) goto L43;
    L44:
        expandHint(r10);
        return;
    L43:
        if (this.hintExpanded == false) goto L44;
        return;
    L20:
        r18 = this.disabledColor;
        goto L21
    L23:
        if (shouldShowError() == false) goto L26;
        this.collapsingTextHelper.setCollapsedAndExpandedTextColor(this.indicatorViewController.getErrorViewTextColors());
        goto L34
    L26:
        if (this.counterOverflowed == false) goto L30;
        TextView r19 = this.counterView;
        if (r19 == null) goto L30;
        this.collapsingTextHelper.setCollapsedAndExpandedTextColor(r19.getTextColors());
    L30:
        if (r13 == false) goto L34;
        ColorStateList r20 = this.focusedTextColor;
        if (r20 == null) goto L34;
        this.collapsingTextHelper.setCollapsedTextColor(r20);
        goto L34
    L11:
        if (r15.hasFocus() == false) goto L13;
        r13 = true;
        goto L13
    L5:
        if (TextUtils.isEmpty(r12.getText()) == true) goto L7;
        r14 = true;
        goto L8
    }

    private void updatePlaceholderText(@Nullable Editable r5) {
        if (this.lengthCounter.countLength(r5) == 0) goto L5;
    L7:
        hidePlaceholderText();
        return;
    L5:
        if (this.hintExpanded == true) goto L7;
        showPlaceholderText();
    }

    public void setEndIconContentDescription(@Nullable CharSequence r5) {
        this.endLayout.setEndIconContentDescription(r5);
    }

    public void setEndIconDrawable(@Nullable Drawable r5) {
        this.endLayout.setEndIconDrawable(r5);
    }

    public void setErrorIconDrawable(@Nullable Drawable r5) {
        this.endLayout.setErrorIconDrawable(r5);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence r5) {
        this.endLayout.setPasswordVisibilityToggleContentDescription(r5);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable r5) {
        this.endLayout.setPasswordVisibilityToggleDrawable(r5);
    }

    public void setStartIconContentDescription(@Nullable CharSequence r5) {
        this.startLayout.setStartIconContentDescription(r5);
    }

    public void setStartIconDrawable(@Nullable Drawable r5) {
        this.startLayout.setStartIconDrawable(r5);
    }

    public TextInputLayout(@NonNull Context r17, @Nullable AttributeSet r18, int r19) {
        int r10 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r17, r18, r19, r10), r18, r19);
        this.minEms = -1;
        this.maxEms = -1;
        this.minWidth = -1;
        this.maxWidth = -1;
        this.indicatorViewController = new IndicatorViewController(this);
        this.lengthCounter = new com.bytedance.ai.resource.core.net.a(4);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet();
        CollapsingTextHelper r5 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = r5;
        this.globalLayoutListenerAdded = false;
        Context r12 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout r14 = new FrameLayout(r12);
        this.inputFrame = r14;
        r14.setAddStatesFromChildren(true);
        TimeInterpolator r11 = AnimationUtils.LINEAR_INTERPOLATOR;
        r5.setTextSizeInterpolator(r11);
        r5.setPositionInterpolator(r11);
        r5.setCollapsedTextGravity(8388659);
        TintTypedArray r13 = ThemeEnforcement.obtainTintedStyledAttributes(r12, r18, R.styleable.TextInputLayout, r19, r10, new int[]{R.styleable.TextInputLayout_counterTextAppearance, R.styleable.TextInputLayout_counterOverflowTextAppearance, R.styleable.TextInputLayout_errorTextAppearance, R.styleable.TextInputLayout_helperTextTextAppearance, R.styleable.TextInputLayout_hintTextAppearance});
        StartCompoundLayout r15 = new StartCompoundLayout(this, r13);
        this.startLayout = r15;
        this.hintEnabled = r13.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(r13.getText(R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = r13.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.expandedHintEnabled = r13.getBoolean(R.styleable.TextInputLayout_expandedHintEnabled, true);
        if (r13.hasValue(R.styleable.TextInputLayout_android_minEms) == false) goto L6;
        setMinEms(r13.getInt(R.styleable.TextInputLayout_android_minEms, -1));
    L9:
        if (r13.hasValue(R.styleable.TextInputLayout_android_maxEms) == false) goto L12;
        setMaxEms(r13.getInt(R.styleable.TextInputLayout_android_maxEms, -1));
    L14:
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(r12, r18, r19, r10).build();
        this.boxLabelCutoutPaddingPx = r12.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = r13.getDimensionPixelOffset(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = r13.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidth, r12.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = r13.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidthFocused, r12.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float r16 = r13.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float r20 = r13.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float r21 = r13.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float r22 = r13.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        ShapeAppearanceModel.Builder r23 = this.shapeAppearanceModel.toBuilder();
        if (r16 < 0.0f) goto L18;
        r23.setTopLeftCornerSize(r16);
    L18:
        if (r20 < 0.0f) goto L21;
        r23.setTopRightCornerSize(r20);
    L21:
        if (r21 < 0.0f) goto L24;
        r23.setBottomRightCornerSize(r21);
    L24:
        if (r22 < 0.0f) goto L26;
        r23.setBottomLeftCornerSize(r22);
    L26:
        this.shapeAppearanceModel = r23.build();
        ColorStateList r24 = MaterialResources.getColorStateList(r12, r13, R.styleable.TextInputLayout_boxBackgroundColor);
        if (r24 == null) goto L32;
        int r25 = r24.getDefaultColor();
        this.defaultFilledBackgroundColor = r25;
        this.boxBackgroundColor = r25;
        if (r24.isStateful() == false) goto L31;
        this.disabledFilledBackgroundColor = r24.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = r24.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = r24.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
    L34:
        if (r13.hasValue(R.styleable.TextInputLayout_android_textColorHint) == false) goto L36;
        ColorStateList r26 = r13.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
        this.focusedTextColor = r26;
        this.defaultHintTextColor = r26;
    L36:
        ColorStateList r27 = MaterialResources.getColorStateList(r12, r13, R.styleable.TextInputLayout_boxStrokeColor);
        this.focusedStrokeColor = r13.getColor(R.styleable.TextInputLayout_boxStrokeColor, 0);
        this.defaultStrokeColor = ContextCompat.getColor(r12, R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.getColor(r12, R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.getColor(r12, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (r27 == null) goto L40;
        setBoxStrokeColorStateList(r27);
    L40:
        if (r13.hasValue(R.styleable.TextInputLayout_boxStrokeErrorColor) == false) goto L43;
        setBoxStrokeErrorColor(MaterialResources.getColorStateList(r12, r13, R.styleable.TextInputLayout_boxStrokeErrorColor));
    L43:
        if (r13.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) == (-1)) goto L45;
        setHintTextAppearance(r13.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
    L45:
        this.cursorColor = r13.getColorStateList(R.styleable.TextInputLayout_cursorColor);
        this.cursorErrorColor = r13.getColorStateList(R.styleable.TextInputLayout_cursorErrorColor);
        int r28 = r13.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
        CharSequence r29 = r13.getText(R.styleable.TextInputLayout_errorContentDescription);
        int r30 = r13.getInt(R.styleable.TextInputLayout_errorAccessibilityLiveRegion, 1);
        boolean r31 = r13.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
        int r32 = r13.getResourceId(R.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean r33 = r13.getBoolean(R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence r34 = r13.getText(R.styleable.TextInputLayout_helperText);
        int r110 = r13.getResourceId(R.styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence r111 = r13.getText(R.styleable.TextInputLayout_placeholderText);
        boolean r112 = r13.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(r13.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = r13.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.counterOverflowTextAppearance = r13.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        setBoxBackgroundMode(r13.getInt(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        setErrorContentDescription(r29);
        setErrorAccessibilityLiveRegion(r30);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setHelperTextTextAppearance(r32);
        setErrorTextAppearance(r28);
        setCounterTextAppearance(this.counterTextAppearance);
        setPlaceholderText(r111);
        setPlaceholderTextAppearance(r110);
        if (r13.hasValue(R.styleable.TextInputLayout_errorTextColor) == false) goto L49;
        setErrorTextColor(r13.getColorStateList(R.styleable.TextInputLayout_errorTextColor));
    L49:
        if (r13.hasValue(R.styleable.TextInputLayout_helperTextTextColor) == false) goto L52;
        setHelperTextColor(r13.getColorStateList(R.styleable.TextInputLayout_helperTextTextColor));
    L52:
        if (r13.hasValue(R.styleable.TextInputLayout_hintTextColor) == false) goto L55;
        setHintTextColor(r13.getColorStateList(R.styleable.TextInputLayout_hintTextColor));
    L55:
        if (r13.hasValue(R.styleable.TextInputLayout_counterTextColor) == false) goto L58;
        setCounterTextColor(r13.getColorStateList(R.styleable.TextInputLayout_counterTextColor));
    L58:
        if (r13.hasValue(R.styleable.TextInputLayout_counterOverflowTextColor) == false) goto L61;
        setCounterOverflowTextColor(r13.getColorStateList(R.styleable.TextInputLayout_counterOverflowTextColor));
    L61:
        if (r13.hasValue(R.styleable.TextInputLayout_placeholderTextColor) == false) goto L63;
        setPlaceholderTextColor(r13.getColorStateList(R.styleable.TextInputLayout_placeholderTextColor));
    L63:
        EndCompoundLayout r35 = new EndCompoundLayout(this, r13);
        this.endLayout = r35;
        boolean r36 = r13.getBoolean(R.styleable.TextInputLayout_android_enabled, true);
        r13.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        ViewCompat.setImportantForAutofill(this, 1);
        r14.addView(r15);
        r14.addView(r35);
        addView(r14);
        setEnabled(r36);
        setHelperTextEnabled(r33);
        setErrorEnabled(r31);
        setCounterEnabled(r112);
        setHelperText(r34);
        return;
    L31:
        this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
        ColorStateList r37 = AppCompatResources.getColorStateList(r12, R.color.mtrl_filled_background_color);
        this.disabledFilledBackgroundColor = r37.getColorForState(new int[]{-16842910}, -1);
        this.hoveredFilledBackgroundColor = r37.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
        goto L34
    L32:
        this.boxBackgroundColor = 0;
        this.defaultFilledBackgroundColor = 0;
        this.disabledFilledBackgroundColor = 0;
        this.focusedFilledBackgroundColor = 0;
        this.hoveredFilledBackgroundColor = 0;
        goto L34
    L12:
        if (r13.hasValue(R.styleable.TextInputLayout_android_maxWidth) == false) goto L14;
        setMaxWidth(r13.getDimensionPixelSize(R.styleable.TextInputLayout_android_maxWidth, -1));
        goto L14
    L6:
        if (r13.hasValue(R.styleable.TextInputLayout_android_minWidth) == false) goto L9;
        setMinWidth(r13.getDimensionPixelSize(R.styleable.TextInputLayout_android_minWidth, -1));
        goto L9
    }

    public void updateCounter(@Nullable Editable r10) {
        int r11 = this.lengthCounter.countLength(r10);
        boolean r5 = this.counterOverflowed;
        int r12 = this.counterMaxLength;
        if (r12 != (-1)) goto L5;
        this.counterView.setText(String.valueOf(r11));
        this.counterView.setContentDescription(null);
        this.counterOverflowed = false;
    L13:
        if (this.editText != null) goto L15;
        return;
    L15:
        if (r5 == this.counterOverflowed) goto L19;
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
        return;
    L19:
        return;
    L5:
        if (r11 <= r12) goto L7;
        boolean r13 = true;
    L8:
        this.counterOverflowed = r13;
        updateCounterContentDescription(getContext(), this.counterView, r11, this.counterMaxLength, this.counterOverflowed);
        if (r5 == this.counterOverflowed) goto L11;
        updateCounterTextAppearanceAndColor();
    L11:
        this.counterView.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(r11), Integer.valueOf(this.counterMaxLength)})));
        goto L13
    L7:
        r13 = false;
        goto L8
    }

    public void setHint(@StringRes int r5) {
        if (r5 == 0) goto L4;
        CharSequence r10 = getResources().getText(r5);
    L5:
        setHint(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }
}
