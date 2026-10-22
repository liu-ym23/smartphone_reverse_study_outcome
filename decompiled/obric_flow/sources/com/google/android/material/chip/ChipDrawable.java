package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    private static final boolean DEBUG = false;
    private static final int[] DEFAULT_STATE = null;
    private static final int MAX_CHIP_ICON_HEIGHT = 24;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private static final ShapeDrawable closeIconRippleMask = null;
    private int alpha;
    private boolean checkable;

    @Nullable
    private Drawable checkedIcon;

    @Nullable
    private ColorStateList checkedIconTint;
    private boolean checkedIconVisible;

    @Nullable
    private ColorStateList chipBackgroundColor;
    private float chipCornerRadius;
    private float chipEndPadding;

    @Nullable
    private Drawable chipIcon;
    private float chipIconSize;

    @Nullable
    private ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final Paint chipPaint;
    private float chipStartPadding;

    @Nullable
    private ColorStateList chipStrokeColor;
    private float chipStrokeWidth;

    @Nullable
    private ColorStateList chipSurfaceColor;

    @Nullable
    private Drawable closeIcon;

    @Nullable
    private CharSequence closeIconContentDescription;
    private float closeIconEndPadding;

    @Nullable
    private Drawable closeIconRipple;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;

    @Nullable
    private ColorStateList closeIconTint;
    private boolean closeIconVisible;

    @Nullable
    private ColorFilter colorFilter;

    @Nullable
    private ColorStateList compatRippleColor;

    @NonNull
    private final Context context;
    private boolean currentChecked;

    @ColorInt
    private int currentChipBackgroundColor;

    @ColorInt
    private int currentChipStrokeColor;

    @ColorInt
    private int currentChipSurfaceColor;

    @ColorInt
    private int currentCompatRippleColor;

    @ColorInt
    private int currentCompositeSurfaceBackgroundColor;

    @ColorInt
    private int currentTextColor;

    @ColorInt
    private int currentTint;

    @Nullable
    private final Paint debugPaint;

    @NonNull
    private WeakReference<Delegate> delegate;
    private final Paint.FontMetrics fontMetrics;
    private boolean hasChipIconTint;

    @Nullable
    private MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private boolean isShapeThemingEnabled;
    private int maxWidth;
    private final PointF pointF;
    private final RectF rectF;

    @Nullable
    private ColorStateList rippleColor;
    private final Path shapePath;
    private boolean shouldDrawText;

    @Nullable
    private MotionSpec showMotionSpec;

    @Nullable
    private CharSequence text;

    @NonNull
    private final TextDrawableHelper textDrawableHelper;
    private float textEndPadding;
    private float textStartPadding;

    @Nullable
    private ColorStateList tint;

    @Nullable
    private PorterDuffColorFilter tintFilter;

    @Nullable
    private PorterDuff.Mode tintMode;
    private TextUtils.TruncateAt truncateAt;
    private boolean useCompatRipple;

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    static {
        DEFAULT_STATE = new int[]{R.attr.state_enabled};
        closeIconRippleMask = new ShapeDrawable(new OvalShape());
    }

    private ChipDrawable(@NonNull Context r5, AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        super(r5, r10, r11, r12);
        this.chipCornerRadius = -1.0f;
        this.chipPaint = new Paint(1);
        this.fontMetrics = new Paint.FontMetrics();
        this.rectF = new RectF();
        this.pointF = new PointF();
        this.shapePath = new Path();
        this.alpha = 255;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        this.delegate = new WeakReference(null);
        initializeElevationOverlay(r5);
        this.context = r5;
        TextDrawableHelper r13 = new TextDrawableHelper(this);
        this.textDrawableHelper = r13;
        this.text = "";
        TextPaint r14 = r13.getTextPaint();
        r14.density = r5.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        int[] r15 = DEFAULT_STATE;
        setState(r15);
        setCloseIconState(r15);
        this.shouldDrawText = true;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L6;
        closeIconRippleMask.setTint(-1);
        return;
    }

    private void applyChildDrawable(@Nullable Drawable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        r5.setCallback(this);
        DrawableCompat.setLayoutDirection(r5, DrawableCompat.getLayoutDirection(this));
        r5.setLevel(getLevel());
        r5.setVisible(isVisible(), false);
        if (r5 == this.closeIcon) goto L7;
        Drawable r10 = this.chipIcon;
        if (r5 != r10) goto L17;
        if (this.hasChipIconTint == false) goto L17;
        DrawableCompat.setTintList(r10, this.chipIconTint);
    L17:
        if (r5.isStateful() == false) goto L20;
        r5.setState(getState());
        return;
    L20:
        return;
    L7:
        if (r5.isStateful() == false) goto L9;
        r5.setState(getCloseIconState());
    L9:
        DrawableCompat.setTintList(r5, this.closeIconTint);
    }

    private void calculateChipIconBounds(@NonNull Rect r5, @NonNull RectF r10) {
        r10.setEmpty();
        if (showsChipIcon() == false) goto L5;
    L6:
        float r11 = this.chipStartPadding + this.iconStartPadding;
        float r12 = getCurrentChipIconWidth();
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L9;
        float r13 = r5.left + r11;
        r10.left = r13;
        r10.right = r13 + r12;
    L10:
        float r14 = getCurrentChipIconHeight();
        float r15 = r5.exactCenterY() - (r14 / 2.0f);
        r10.top = r15;
        r10.bottom = r15 + r14;
        return;
    L9:
        float r16 = r5.right - r11;
        r10.right = r16;
        r10.left = r16 - r12;
        goto L10
    L5:
        if (showsCheckedIcon() == true) goto L6;
    }

    private void calculateChipTouchBounds(@NonNull Rect r5, @NonNull RectF r10) {
        r10.set(r5);
        if (showsCloseIcon() == false) goto L9;
        float r11 = (((this.chipEndPadding + this.closeIconEndPadding) + this.closeIconSize) + this.closeIconStartPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r10.right = r5.right - r11;
        return;
    L7:
        r10.left = r5.left + r11;
        return;
    }

    private void calculateCloseIconBounds(@NonNull Rect r5, @NonNull RectF r10) {
        r10.setEmpty();
        if (showsCloseIcon() == false) goto L10;
        float r11 = this.chipEndPadding + this.closeIconEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        float r12 = r5.right - r11;
        r10.right = r12;
        r10.left = r12 - this.closeIconSize;
    L8:
        float r13 = r5.exactCenterY();
        float r14 = this.closeIconSize;
        float r15 = r13 - (r14 / 2.0f);
        r10.top = r15;
        r10.bottom = r15 + r14;
        return;
    L7:
        float r16 = r5.left + r11;
        r10.left = r16;
        r10.right = r16 + this.closeIconSize;
        goto L8
    }

    private void calculateCloseIconTouchBounds(@NonNull Rect r5, @NonNull RectF r10) {
        r10.setEmpty();
        if (showsCloseIcon() == false) goto L10;
        float r11 = (((this.chipEndPadding + this.closeIconEndPadding) + this.closeIconSize) + this.closeIconStartPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        float r12 = r5.right;
        r10.right = r12;
        r10.left = r12 - r11;
    L8:
        r10.top = r5.top;
        r10.bottom = r5.bottom;
        return;
    L7:
        int r13 = r5.left;
        r10.left = r13;
        r10.right = r13 + r11;
        goto L8
    }

    private void calculateTextBounds(@NonNull Rect r5, @NonNull RectF r10) {
        r10.setEmpty();
        if (this.text == null) goto L10;
        float r11 = (calculateChipIconWidth() + this.chipStartPadding) + this.textStartPadding;
        float r12 = (calculateCloseIconWidth() + this.chipEndPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r10.left = r5.left + r11;
        r10.right = r5.right - r12;
    L8:
        r10.top = r5.top;
        r10.bottom = r5.bottom;
        return;
    L7:
        r10.left = r5.left + r12;
        r10.right = r5.right - r11;
        goto L8
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        Paint.FontMetrics r5 = this.fontMetrics;
        return (r5.descent + r5.ascent) / 2.0f;
    }

    private boolean canShowCheckedIcon() {
        if (this.checkedIconVisible == true) goto L5;
    L9:
        return false;
    L5:
        if (this.checkedIcon == null) goto L9;
        if (this.checkable == false) goto L9;
        return true;
    }

    @NonNull
    public static ChipDrawable createFromAttributes(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        ChipDrawable r13 = new ChipDrawable(r5, r10, r11, r12);
        r13.loadFromAttributes(r10, r11, r12);
        return r13;
    }

    @NonNull
    public static ChipDrawable createFromResource(@NonNull Context r5, @XmlRes int r10) {
        AttributeSet r11 = DrawableUtils.parseDrawableXml(r5, r10, "chip");
        int r12 = r11.getStyleAttribute();
        if (r12 != 0) goto L6;
        r12 = com.google.android.material.R.style.Widget_MaterialComponents_Chip_Entry;
    L6:
        return createFromAttributes(r5, r11, com.google.android.material.R.attr.chipStandaloneStyle, r12);
    }

    private void drawCheckedIcon(@NonNull Canvas r10, @NonNull Rect r11) {
        if (showsCheckedIcon() == false) goto L6;
        calculateChipIconBounds(r11, this.rectF);
        RectF r12 = this.rectF;
        float r5 = r12.left;
        float r13 = r12.top;
        r10.translate(r5, r13);
        this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.checkedIcon.draw(r10);
        r10.translate(-r5, -r13);
        return;
    }

    private void drawChipBackground(@NonNull Canvas r5, @NonNull Rect r10) {
        if (this.isShapeThemingEnabled == true) goto L6;
        this.chipPaint.setColor(this.currentChipBackgroundColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.chipPaint.setColorFilter(getTintColorFilter());
        this.rectF.set(r10);
        r5.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    }

    private void drawChipIcon(@NonNull Canvas r10, @NonNull Rect r11) {
        if (showsChipIcon() == false) goto L6;
        calculateChipIconBounds(r11, this.rectF);
        RectF r12 = this.rectF;
        float r5 = r12.left;
        float r13 = r12.top;
        r10.translate(r5, r13);
        this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.chipIcon.draw(r10);
        r10.translate(-r5, -r13);
        return;
    }

    private void drawChipStroke(@NonNull Canvas r10, @NonNull Rect r11) {
        if (this.chipStrokeWidth > 0.0f) goto L5;
        return;
    L5:
        if (this.isShapeThemingEnabled == true) goto L12;
        this.chipPaint.setColor(this.currentChipStrokeColor);
        this.chipPaint.setStyle(Paint.Style.STROKE);
        if (this.isShapeThemingEnabled == true) goto L9;
        this.chipPaint.setColorFilter(getTintColorFilter());
    L9:
        RectF r5 = this.rectF;
        float r12 = r11.left;
        float r13 = this.chipStrokeWidth;
        r5.set((r13 / 2.0f) + r12, (r13 / 2.0f) + r11.top, r11.right - (r13 / 2.0f), r11.bottom - (r13 / 2.0f));
        float r14 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
        r10.drawRoundRect(this.rectF, r14, r14, this.chipPaint);
        return;
    }

    private void drawChipSurface(@NonNull Canvas r5, @NonNull Rect r10) {
        if (this.isShapeThemingEnabled == true) goto L6;
        this.chipPaint.setColor(this.currentChipSurfaceColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(r10);
        r5.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    }

    private void drawCloseIcon(@NonNull Canvas r10, @NonNull Rect r11) {
        if (showsCloseIcon() == false) goto L10;
        calculateCloseIconBounds(r11, this.rectF);
        RectF r12 = this.rectF;
        float r5 = r12.left;
        float r13 = r12.top;
        r10.translate(r5, r13);
        this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L7;
        this.closeIconRipple.setBounds(this.closeIcon.getBounds());
        this.closeIconRipple.jumpToCurrentState();
        this.closeIconRipple.draw(r10);
    L8:
        r10.translate(-r5, -r13);
        return;
    L7:
        this.closeIcon.draw(r10);
        goto L8
    }

    private void drawCompatRipple(@NonNull Canvas r5, @NonNull Rect r10) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(r10);
        if (this.isShapeThemingEnabled == true) goto L5;
        r5.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    L5:
        calculatePathForSize(new RectF(r10), this.shapePath);
        super.drawShape(r5, this.chipPaint, this.shapePath, getBoundsAsRectF());
    }

    private void drawDebug(@NonNull Canvas r10, @NonNull Rect r11) {
        Paint r5 = this.debugPaint;
        if (r5 == null) goto L17;
        r5.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
        r10.drawRect(r11, this.debugPaint);
        if (showsChipIcon() == false) goto L7;
    L8:
        calculateChipIconBounds(r11, this.rectF);
        r10.drawRect(this.rectF, this.debugPaint);
    L10:
        if (this.text == null) goto L13;
        r10.drawLine(r11.left, r11.exactCenterY(), r11.right, r11.exactCenterY(), this.debugPaint);
    L13:
        if (showsCloseIcon() == false) goto L15;
        calculateCloseIconBounds(r11, this.rectF);
        r10.drawRect(this.rectF, this.debugPaint);
    L15:
        this.debugPaint.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
        calculateChipTouchBounds(r11, this.rectF);
        r10.drawRect(this.rectF, this.debugPaint);
        this.debugPaint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
        calculateCloseIconTouchBounds(r11, this.rectF);
        r10.drawRect(this.rectF, this.debugPaint);
        return;
    L7:
        if (showsCheckedIcon() == false) goto L10;
    }

    private void drawText(@NonNull Canvas r10, @NonNull Rect r11) {
        if (this.text == null) goto L22;
        Paint.Align r5 = calculateTextOriginAndAlignment(r11, this.pointF);
        calculateTextBounds(r11, this.rectF);
        if (this.textDrawableHelper.getTextAppearance() == null) goto L7;
        this.textDrawableHelper.getTextPaint().drawableState = getState();
        this.textDrawableHelper.updateTextPaintDrawState(this.context);
    L7:
        this.textDrawableHelper.getTextPaint().setTextAlign(r5);
        int r12 = 0;
        if (Math.round(this.textDrawableHelper.getTextWidth(getText().toString())) <= Math.round(this.rectF.width())) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == false) goto L13;
        r12 = r10.save();
        r10.clipRect(this.rectF);
    L13:
        CharSequence r14 = this.text;
        if (r13 == true) goto L16;
    L18:
        CharSequence r15 = r14;
        int r16 = r15.length();
        PointF r17 = this.pointF;
        r10.drawText(r15, 0, r16, r17.x, r17.y, this.textDrawableHelper.getTextPaint());
        if (r13 == false) goto L23;
        r10.restoreToCount(r12);
        return;
    L23:
        return;
    L16:
        if (this.truncateAt == null) goto L18;
        r14 = TextUtils.ellipsize(r14, this.textDrawableHelper.getTextPaint(), this.rectF.width(), this.truncateAt);
        goto L18
    L10:
        r13 = false;
        goto L11
    }

    private float getCurrentChipIconHeight() {
        if (this.currentChecked == false) goto L5;
        Drawable r5 = this.checkedIcon;
    L6:
        float r10 = this.chipIconSize;
        if (r10 > 0.0f) goto L13;
        if (r5 == null) goto L13;
        float r11 = (float) Math.ceil(ViewUtils.dpToPx(this.context, 24));
        if (r5.getIntrinsicHeight() <= r11) goto L12;
        return r11;
    L12:
        return r5.getIntrinsicHeight();
    L13:
        return r10;
    L5:
        r5 = this.chipIcon;
        goto L6
    }

    private float getCurrentChipIconWidth() {
        if (this.currentChecked == false) goto L5;
        Drawable r5 = this.checkedIcon;
    L6:
        float r10 = this.chipIconSize;
        if (r10 > 0.0f) goto L11;
        if (r5 != null) goto L10;
        return r10;
    L10:
        return r5.getIntrinsicWidth();
    L11:
        return r10;
    L5:
        r5 = this.chipIcon;
        goto L6
    }

    @Nullable
    private ColorFilter getTintColorFilter() {
        ColorFilter r5 = this.colorFilter;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return this.tintFilter;
    }

    private static boolean hasState(@Nullable int[] r5, @AttrRes int r10) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r11 = r5.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L12;
        if (r5[r12] == r10) goto L9;
        r12 = r12 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private void loadFromAttributes(@Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(this.context, r10, com.google.android.material.R.styleable.Chip, r11, r12, new int[0]);
        this.isShapeThemingEnabled = r13.hasValue(com.google.android.material.R.styleable.Chip_shapeAppearance);
        setChipSurfaceColor(MaterialResources.getColorStateList(this.context, r13, com.google.android.material.R.styleable.Chip_chipSurfaceColor));
        setChipBackgroundColor(MaterialResources.getColorStateList(this.context, r13, com.google.android.material.R.styleable.Chip_chipBackgroundColor));
        setChipMinHeight(r13.getDimension(com.google.android.material.R.styleable.Chip_chipMinHeight, 0.0f));
        if (r13.hasValue(com.google.android.material.R.styleable.Chip_chipCornerRadius) == false) goto L5;
        setChipCornerRadius(r13.getDimension(com.google.android.material.R.styleable.Chip_chipCornerRadius, 0.0f));
    L5:
        setChipStrokeColor(MaterialResources.getColorStateList(this.context, r13, com.google.android.material.R.styleable.Chip_chipStrokeColor));
        setChipStrokeWidth(r13.getDimension(com.google.android.material.R.styleable.Chip_chipStrokeWidth, 0.0f));
        setRippleColor(MaterialResources.getColorStateList(this.context, r13, com.google.android.material.R.styleable.Chip_rippleColor));
        setText(r13.getText(com.google.android.material.R.styleable.Chip_android_text));
        TextAppearance r14 = MaterialResources.getTextAppearance(this.context, r13, com.google.android.material.R.styleable.Chip_android_textAppearance);
        r14.setTextSize(r13.getDimension(com.google.android.material.R.styleable.Chip_android_textSize, r14.getTextSize()));
        setTextAppearance(r14);
        int r15 = r13.getInt(com.google.android.material.R.styleable.Chip_android_ellipsize, 0);
        if (r15 != 1) goto L8;
        setEllipsize(TextUtils.TruncateAt.START);
    L15:
        setChipIconVisible(r13.getBoolean(com.google.android.material.R.styleable.Chip_chipIconVisible, false));
        if (r10 != null) goto L18;
    L22:
        setChipIcon(MaterialResources.getDrawable(this.context, r13, com.google.android.material.R.styleable.Chip_chipIcon));
        if (r13.hasValue(com.google.android.material.R.styleable.Chip_chipIconTint) == false) goto L25;
        setChipIconTint(MaterialResources.getColorStateList(this.context, r13, com.google.android.material.R.styleable.Chip_chipIconTint));
    L25:
        setChipIconSize(r13.getDimension(com.google.android.material.R.styleable.Chip_chipIconSize, -1.0f));
        setCloseIconVisible(r13.getBoolean(com.google.android.material.R.styleable.Chip_closeIconVisible, false));
        if (r10 != null) goto L28;
    L32:
        setCloseIcon(MaterialResources.getDrawable(this.context, r13, com.google.android.material.R.styleable.Chip_closeIcon));
        setCloseIconTint(MaterialResources.getColorStateList(this.context, r13, com.google.android.material.R.styleable.Chip_closeIconTint));
        setCloseIconSize(r13.getDimension(com.google.android.material.R.styleable.Chip_closeIconSize, 0.0f));
        setCheckable(r13.getBoolean(com.google.android.material.R.styleable.Chip_android_checkable, false));
        setCheckedIconVisible(r13.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconVisible, false));
        if (r10 != null) goto L35;
    L39:
        setCheckedIcon(MaterialResources.getDrawable(this.context, r13, com.google.android.material.R.styleable.Chip_checkedIcon));
        if (r13.hasValue(com.google.android.material.R.styleable.Chip_checkedIconTint) == false) goto L42;
        setCheckedIconTint(MaterialResources.getColorStateList(this.context, r13, com.google.android.material.R.styleable.Chip_checkedIconTint));
    L42:
        setShowMotionSpec(MotionSpec.createFromAttribute(this.context, r13, com.google.android.material.R.styleable.Chip_showMotionSpec));
        setHideMotionSpec(MotionSpec.createFromAttribute(this.context, r13, com.google.android.material.R.styleable.Chip_hideMotionSpec));
        setChipStartPadding(r13.getDimension(com.google.android.material.R.styleable.Chip_chipStartPadding, 0.0f));
        setIconStartPadding(r13.getDimension(com.google.android.material.R.styleable.Chip_iconStartPadding, 0.0f));
        setIconEndPadding(r13.getDimension(com.google.android.material.R.styleable.Chip_iconEndPadding, 0.0f));
        setTextStartPadding(r13.getDimension(com.google.android.material.R.styleable.Chip_textStartPadding, 0.0f));
        setTextEndPadding(r13.getDimension(com.google.android.material.R.styleable.Chip_textEndPadding, 0.0f));
        setCloseIconStartPadding(r13.getDimension(com.google.android.material.R.styleable.Chip_closeIconStartPadding, 0.0f));
        setCloseIconEndPadding(r13.getDimension(com.google.android.material.R.styleable.Chip_closeIconEndPadding, 0.0f));
        setChipEndPadding(r13.getDimension(com.google.android.material.R.styleable.Chip_chipEndPadding, 0.0f));
        setMaxWidth(r13.getDimensionPixelSize(com.google.android.material.R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        r13.recycle();
        return;
    L35:
        if (r10.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") == null) goto L39;
        if (r10.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") != null) goto L39;
        setCheckedIconVisible(r13.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconEnabled, false));
        goto L39
    L28:
        if (r10.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") == null) goto L32;
        if (r10.getAttributeValue(NAMESPACE_APP, "closeIconVisible") != null) goto L32;
        setCloseIconVisible(r13.getBoolean(com.google.android.material.R.styleable.Chip_closeIconEnabled, false));
        goto L32
    L18:
        if (r10.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") == null) goto L22;
        if (r10.getAttributeValue(NAMESPACE_APP, "chipIconVisible") != null) goto L22;
        setChipIconVisible(r13.getBoolean(com.google.android.material.R.styleable.Chip_chipIconEnabled, false));
        goto L22
    L8:
        if (r15 != 2) goto L10;
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        goto L15
    L10:
        if (r15 != 3) goto L15;
        setEllipsize(TextUtils.TruncateAt.END);
        goto L15
    }

    private void setChipSurfaceColor(@Nullable ColorStateList r5) {
        if (this.chipSurfaceColor == r5) goto L6;
        this.chipSurfaceColor = r5;
        onStateChange(getState());
        return;
    }

    private boolean showsCheckedIcon() {
        if (this.checkedIconVisible == true) goto L5;
    L9:
        return false;
    L5:
        if (this.checkedIcon == null) goto L9;
        if (this.currentChecked == false) goto L9;
        return true;
    }

    private boolean showsChipIcon() {
        if (this.chipIconVisible == true) goto L5;
    L7:
        return false;
    L5:
        if (this.chipIcon == null) goto L7;
        return true;
    }

    private boolean showsCloseIcon() {
        if (this.closeIconVisible == true) goto L5;
    L7:
        return false;
    L5:
        if (this.closeIcon == null) goto L7;
        return true;
    }

    private void unapplyChildDrawable(@Nullable Drawable r5) {
        if (r5 == null) goto L5;
        r5.setCallback(null);
        return;
    }

    private void updateCompatRippleColor() {
        if (this.useCompatRipple == false) goto L5;
        ColorStateList r5 = RippleUtils.sanitizeRippleDrawableColor(this.rippleColor);
    L6:
        this.compatRippleColor = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    @TargetApi(21)
    private void updateFrameworkCloseIconRipple() {
        this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(getRippleColor()), this.closeIcon, closeIconRippleMask);
    }

    public float calculateChipIconWidth() {
        if (showsChipIcon() == true) goto L10;
        if (showsCheckedIcon() == true) goto L10;
        return 0.0f;
    L10:
        return (this.iconStartPadding + getCurrentChipIconWidth()) + this.iconEndPadding;
    }

    public float calculateCloseIconWidth() {
        if (showsCloseIcon() == true) goto L5;
        return 0.0f;
    L5:
        return (this.closeIconStartPadding + this.closeIconSize) + this.closeIconEndPadding;
    }

    @NonNull
    public Paint.Align calculateTextOriginAndAlignment(@NonNull Rect r5, @NonNull PointF r10) {
        r10.set(0.0f, 0.0f);
        Paint.Align r11 = Paint.Align.LEFT;
        if (this.text == null) goto L9;
        float r12 = (calculateChipIconWidth() + this.chipStartPadding) + this.textStartPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r10.x = r5.left + r12;
    L8:
        r10.y = r5.centerY() - calculateTextCenterFromBaseline();
        goto L9
    L7:
        r10.x = r5.right - r12;
        r11 = Paint.Align.RIGHT;
    L9:
        return r11;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        Rect r5 = getBounds();
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() == 0) goto L23;
        int r11 = this.alpha;
        if (r11 >= 255) goto L10;
        int r12 = CanvasCompat.saveLayerAlpha(r10, r5.left, r5.top, r5.right, r5.bottom, r11);
    L11:
        drawChipSurface(r10, r5);
        drawChipBackground(r10, r5);
        if (this.isShapeThemingEnabled == false) goto L14;
        super.draw(r10);
    L14:
        drawChipStroke(r10, r5);
        drawCompatRipple(r10, r5);
        drawChipIcon(r10, r5);
        drawCheckedIcon(r10, r5);
        if (this.shouldDrawText == false) goto L17;
        drawText(r10, r5);
    L17:
        drawCloseIcon(r10, r5);
        drawDebug(r10, r5);
        if (this.alpha >= 255) goto L22;
        r10.restoreToCount(r12);
        return;
    L22:
        return;
    L10:
        r12 = 0;
        goto L11
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public float getChipCornerRadius() {
        if (this.isShapeThemingEnabled == false) goto L6;
        return getTopLeftCornerResolvedSize();
    L6:
        return this.chipCornerRadius;
    }

    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable r5 = this.chipIcon;
        if (r5 != null) goto L7;
        return null;
    L7:
        return DrawableCompat.unwrap(r5);
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public void getChipTouchBounds(@NonNull RectF r5) {
        calculateChipTouchBounds(getBounds(), r5);
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable r5 = this.closeIcon;
        if (r5 != null) goto L7;
        return null;
    L7:
        return DrawableCompat.unwrap(r5);
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    @NonNull
    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    public void getCloseIconTouchBounds(@NonNull RectF r5) {
        calculateCloseIconTouchBounds(getBounds(), r5);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        float r5 = this.chipStartPadding;
        float r10 = (calculateChipIconWidth() + r5) + this.textStartPadding;
        float r11 = (this.textDrawableHelper.getTextWidth(getText().toString()) + r10) + this.textEndPadding;
        return Math.min(Math.round((calculateCloseIconWidth() + r11) + this.chipEndPadding), this.maxWidth);
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline r10) {
        if (this.isShapeThemingEnabled == false) goto L6;
        super.getOutline(r10);
        return;
    L6:
        Rect r5 = getBounds();
        if (r5.isEmpty() == true) goto L9;
        r10.setRoundRect(r5, this.chipCornerRadius);
    L10:
        r10.setAlpha(getAlpha() / 255.0f);
        return;
    L9:
        r10.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
        goto L10
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable r5) {
        Drawable.Callback r10 = getCallback();
        if (r10 == null) goto L6;
        r10.invalidateDrawable(this);
        return;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconStateful() {
        return isStateful(this.closeIcon);
    }

    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    public boolean isShapeThemingEnabled() {
        return this.isShapeThemingEnabled;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (isStateful(this.chipSurfaceColor) == false) goto L5;
    L24:
        return true;
    L5:
        if (isStateful(this.chipBackgroundColor) == true) goto L24;
        if (isStateful(this.chipStrokeColor) == true) goto L24;
        if (this.useCompatRipple == false) goto L13;
        if (isStateful(this.compatRippleColor) == true) goto L24;
    L13:
        if (isStateful(this.textDrawableHelper.getTextAppearance()) == true) goto L24;
        if (canShowCheckedIcon() == true) goto L24;
        if (isStateful(this.chipIcon) == true) goto L24;
        if (isStateful(this.checkedIcon) == true) goto L24;
        if (isStateful(this.tint) == true) goto L24;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int r5) {
        boolean r10 = super.onLayoutDirectionChanged(r5);
        if (showsChipIcon() == false) goto L6;
        r10 = r10 | DrawableCompat.setLayoutDirection(this.chipIcon, r5);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r10 = r10 | DrawableCompat.setLayoutDirection(this.checkedIcon, r5);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r10 = r10 | DrawableCompat.setLayoutDirection(this.closeIcon, r5);
    L11:
        if (r10 == false) goto L15;
        invalidateSelf();
        return true;
    L15:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r5) {
        boolean r10 = super.onLevelChange(r5);
        if (showsChipIcon() == false) goto L6;
        r10 = r10 | this.chipIcon.setLevel(r5);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r10 = r10 | this.checkedIcon.setLevel(r5);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r10 = r10 | this.closeIcon.setLevel(r5);
    L11:
        if (r10 == false) goto L13;
        invalidateSelf();
    L13:
        return r10;
    }

    public void onSizeChange() {
        Delegate r5 = this.delegate.get();
        if (r5 == null) goto L6;
        r5.onChipDrawableSizeChange();
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(@NonNull int[] r5) {
        if (this.isShapeThemingEnabled == false) goto L6;
        super.onStateChange(r5);
    L6:
        return onStateChange(r5, getCloseIconState());
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable r5, @NonNull Runnable r10, long r11) {
        Drawable.Callback r12 = getCallback();
        if (r12 == null) goto L6;
        r12.scheduleDrawable(this, r10, r11);
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        if (this.alpha == r5) goto L6;
        this.alpha = r5;
        invalidateSelf();
        return;
    }

    public void setCheckable(boolean r5) {
        if (this.checkable == r5) goto L13;
        this.checkable = r5;
        float r10 = calculateChipIconWidth();
        if (r5 == false) goto L7;
    L9:
        float r11 = calculateChipIconWidth();
        invalidateSelf();
        if (r10 == r11) goto L14;
        onSizeChange();
        return;
    L14:
        return;
    L7:
        if (this.currentChecked == false) goto L9;
        this.currentChecked = false;
        goto L9
    }

    public void setCheckableResource(@BoolRes int r5) {
        setCheckable(this.context.getResources().getBoolean(r5));
    }

    public void setCheckedIcon(@Nullable Drawable r5) {
        if (this.checkedIcon == r5) goto L8;
        float r10 = calculateChipIconWidth();
        this.checkedIcon = r5;
        float r11 = calculateChipIconWidth();
        unapplyChildDrawable(this.checkedIcon);
        applyChildDrawable(this.checkedIcon);
        invalidateSelf();
        if (r10 == r11) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean r5) {
        setCheckedIconVisible(r5);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int r5) {
        setCheckedIconVisible(this.context.getResources().getBoolean(r5));
    }

    public void setCheckedIconResource(@DrawableRes int r5) {
        setCheckedIcon(AppCompatResources.getDrawable(this.context, r5));
    }

    public void setCheckedIconTint(@Nullable ColorStateList r5) {
        if (this.checkedIconTint == r5) goto L9;
        this.checkedIconTint = r5;
        if (canShowCheckedIcon() == false) goto L7;
        DrawableCompat.setTintList(this.checkedIcon, r5);
    L7:
        onStateChange(getState());
        return;
    }

    public void setCheckedIconTintResource(@ColorRes int r5) {
        setCheckedIconTint(AppCompatResources.getColorStateList(this.context, r5));
    }

    public void setCheckedIconVisible(@BoolRes int r5) {
        setCheckedIconVisible(this.context.getResources().getBoolean(r5));
    }

    public void setChipBackgroundColor(@Nullable ColorStateList r5) {
        if (this.chipBackgroundColor == r5) goto L6;
        this.chipBackgroundColor = r5;
        onStateChange(getState());
        return;
    }

    public void setChipBackgroundColorResource(@ColorRes int r5) {
        setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, r5));
    }

    @Deprecated
    public void setChipCornerRadius(float r5) {
        if (this.chipCornerRadius == r5) goto L6;
        this.chipCornerRadius = r5;
        setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(r5));
        return;
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int r5) {
        setChipCornerRadius(this.context.getResources().getDimension(r5));
    }

    public void setChipEndPadding(float r5) {
        if (this.chipEndPadding == r5) goto L6;
        this.chipEndPadding = r5;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipEndPaddingResource(@DimenRes int r5) {
        setChipEndPadding(this.context.getResources().getDimension(r5));
    }

    public void setChipIcon(@Nullable Drawable r5) {
        Drawable r10 = getChipIcon();
        if (r10 == r5) goto L15;
        float r11 = calculateChipIconWidth();
        if (r5 == null) goto L7;
        Drawable r12 = DrawableCompat.wrap(r5).mutate();
    L8:
        this.chipIcon = r12;
        float r13 = calculateChipIconWidth();
        unapplyChildDrawable(r10);
        if (showsChipIcon() == false) goto L11;
        applyChildDrawable(this.chipIcon);
    L11:
        invalidateSelf();
        if (r11 == r13) goto L16;
        onSizeChange();
        return;
    L16:
        return;
    L7:
        r12 = null;
        goto L8
    }

    @Deprecated
    public void setChipIconEnabled(boolean r5) {
        setChipIconVisible(r5);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int r5) {
        setChipIconVisible(r5);
    }

    public void setChipIconResource(@DrawableRes int r5) {
        setChipIcon(AppCompatResources.getDrawable(this.context, r5));
    }

    public void setChipIconSize(float r5) {
        if (this.chipIconSize == r5) goto L8;
        float r10 = calculateChipIconWidth();
        this.chipIconSize = r5;
        float r11 = calculateChipIconWidth();
        invalidateSelf();
        if (r10 == r11) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setChipIconSizeResource(@DimenRes int r5) {
        setChipIconSize(this.context.getResources().getDimension(r5));
    }

    public void setChipIconTint(@Nullable ColorStateList r5) {
        this.hasChipIconTint = true;
        if (this.chipIconTint == r5) goto L9;
        this.chipIconTint = r5;
        if (showsChipIcon() == false) goto L7;
        DrawableCompat.setTintList(this.chipIcon, r5);
    L7:
        onStateChange(getState());
        return;
    }

    public void setChipIconTintResource(@ColorRes int r5) {
        setChipIconTint(AppCompatResources.getColorStateList(this.context, r5));
    }

    public void setChipIconVisible(@BoolRes int r5) {
        setChipIconVisible(this.context.getResources().getBoolean(r5));
    }

    public void setChipMinHeight(float r5) {
        if (this.chipMinHeight == r5) goto L6;
        this.chipMinHeight = r5;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipMinHeightResource(@DimenRes int r5) {
        setChipMinHeight(this.context.getResources().getDimension(r5));
    }

    public void setChipStartPadding(float r5) {
        if (this.chipStartPadding == r5) goto L6;
        this.chipStartPadding = r5;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipStartPaddingResource(@DimenRes int r5) {
        setChipStartPadding(this.context.getResources().getDimension(r5));
    }

    public void setChipStrokeColor(@Nullable ColorStateList r5) {
        if (this.chipStrokeColor == r5) goto L9;
        this.chipStrokeColor = r5;
        if (this.isShapeThemingEnabled == false) goto L7;
        setStrokeColor(r5);
    L7:
        onStateChange(getState());
        return;
    }

    public void setChipStrokeColorResource(@ColorRes int r5) {
        setChipStrokeColor(AppCompatResources.getColorStateList(this.context, r5));
    }

    public void setChipStrokeWidth(float r5) {
        if (this.chipStrokeWidth == r5) goto L9;
        this.chipStrokeWidth = r5;
        this.chipPaint.setStrokeWidth(r5);
        if (this.isShapeThemingEnabled == false) goto L7;
        super.setStrokeWidth(r5);
    L7:
        invalidateSelf();
        return;
    }

    public void setChipStrokeWidthResource(@DimenRes int r5) {
        setChipStrokeWidth(this.context.getResources().getDimension(r5));
    }

    public void setCloseIcon(@Nullable Drawable r5) {
        Drawable r10 = getCloseIcon();
        if (r10 == r5) goto L18;
        float r11 = calculateCloseIconWidth();
        if (r5 == null) goto L7;
        Drawable r12 = DrawableCompat.wrap(r5).mutate();
    L8:
        this.closeIcon = r12;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L11;
        updateFrameworkCloseIconRipple();
    L11:
        float r13 = calculateCloseIconWidth();
        unapplyChildDrawable(r10);
        if (showsCloseIcon() == false) goto L14;
        applyChildDrawable(this.closeIcon);
    L14:
        invalidateSelf();
        if (r11 == r13) goto L19;
        onSizeChange();
        return;
    L19:
        return;
    L7:
        r12 = null;
        goto L8
    }

    public void setCloseIconContentDescription(@Nullable CharSequence r5) {
        if (this.closeIconContentDescription == r5) goto L6;
        this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(r5);
        invalidateSelf();
        return;
    }

    @Deprecated
    public void setCloseIconEnabled(boolean r5) {
        setCloseIconVisible(r5);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int r5) {
        setCloseIconVisible(r5);
    }

    public void setCloseIconEndPadding(float r5) {
        if (this.closeIconEndPadding == r5) goto L8;
        this.closeIconEndPadding = r5;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconEndPaddingResource(@DimenRes int r5) {
        setCloseIconEndPadding(this.context.getResources().getDimension(r5));
    }

    public void setCloseIconResource(@DrawableRes int r5) {
        setCloseIcon(AppCompatResources.getDrawable(this.context, r5));
    }

    public void setCloseIconSize(float r5) {
        if (this.closeIconSize == r5) goto L8;
        this.closeIconSize = r5;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconSizeResource(@DimenRes int r5) {
        setCloseIconSize(this.context.getResources().getDimension(r5));
    }

    public void setCloseIconStartPadding(float r5) {
        if (this.closeIconStartPadding == r5) goto L8;
        this.closeIconStartPadding = r5;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconStartPaddingResource(@DimenRes int r5) {
        setCloseIconStartPadding(this.context.getResources().getDimension(r5));
    }

    public boolean setCloseIconState(@NonNull int[] r5) {
        if (Arrays.equals(this.closeIconStateSet, r5) == true) goto L8;
        this.closeIconStateSet = r5;
        if (showsCloseIcon() == true) goto L7;
        return false;
    L7:
        return onStateChange(getState(), r5);
    L8:
        return false;
    }

    public void setCloseIconTint(@Nullable ColorStateList r5) {
        if (this.closeIconTint == r5) goto L9;
        this.closeIconTint = r5;
        if (showsCloseIcon() == false) goto L7;
        DrawableCompat.setTintList(this.closeIcon, r5);
    L7:
        onStateChange(getState());
        return;
    }

    public void setCloseIconTintResource(@ColorRes int r5) {
        setCloseIconTint(AppCompatResources.getColorStateList(this.context, r5));
    }

    public void setCloseIconVisible(@BoolRes int r5) {
        setCloseIconVisible(this.context.getResources().getBoolean(r5));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r5) {
        if (this.colorFilter == r5) goto L6;
        this.colorFilter = r5;
        invalidateSelf();
        return;
    }

    public void setDelegate(@Nullable Delegate r5) {
        this.delegate = new WeakReference(r5);
    }

    public void setEllipsize(@Nullable TextUtils.TruncateAt r5) {
        this.truncateAt = r5;
    }

    public void setHideMotionSpec(@Nullable MotionSpec r5) {
        this.hideMotionSpec = r5;
    }

    public void setHideMotionSpecResource(@AnimatorRes int r5) {
        setHideMotionSpec(MotionSpec.createFromResource(this.context, r5));
    }

    public void setIconEndPadding(float r5) {
        if (this.iconEndPadding == r5) goto L8;
        float r10 = calculateChipIconWidth();
        this.iconEndPadding = r5;
        float r11 = calculateChipIconWidth();
        invalidateSelf();
        if (r10 == r11) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setIconEndPaddingResource(@DimenRes int r5) {
        setIconEndPadding(this.context.getResources().getDimension(r5));
    }

    public void setIconStartPadding(float r5) {
        if (this.iconStartPadding == r5) goto L8;
        float r10 = calculateChipIconWidth();
        this.iconStartPadding = r5;
        float r11 = calculateChipIconWidth();
        invalidateSelf();
        if (r10 == r11) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setIconStartPaddingResource(@DimenRes int r5) {
        setIconStartPadding(this.context.getResources().getDimension(r5));
    }

    public void setMaxWidth(@Px int r5) {
        this.maxWidth = r5;
    }

    public void setRippleColor(@Nullable ColorStateList r5) {
        if (this.rippleColor == r5) goto L6;
        this.rippleColor = r5;
        updateCompatRippleColor();
        onStateChange(getState());
        return;
    }

    public void setRippleColorResource(@ColorRes int r5) {
        setRippleColor(AppCompatResources.getColorStateList(this.context, r5));
    }

    public void setShouldDrawText(boolean r5) {
        this.shouldDrawText = r5;
    }

    public void setShowMotionSpec(@Nullable MotionSpec r5) {
        this.showMotionSpec = r5;
    }

    public void setShowMotionSpecResource(@AnimatorRes int r5) {
        setShowMotionSpec(MotionSpec.createFromResource(this.context, r5));
    }

    public void setText(@Nullable CharSequence r5) {
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        if (TextUtils.equals(this.text, r5) == true) goto L8;
        this.text = r5;
        this.textDrawableHelper.setTextWidthDirty(true);
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextAppearance(@Nullable TextAppearance r5) {
        this.textDrawableHelper.setTextAppearance(r5, this.context);
    }

    public void setTextAppearanceResource(@StyleRes int r5) {
        setTextAppearance(new TextAppearance(this.context, r5));
    }

    public void setTextColor(@ColorInt int r5) {
        setTextColor(ColorStateList.valueOf(r5));
    }

    public void setTextEndPadding(float r5) {
        if (this.textEndPadding == r5) goto L6;
        this.textEndPadding = r5;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextEndPaddingResource(@DimenRes int r5) {
        setTextEndPadding(this.context.getResources().getDimension(r5));
    }

    public void setTextResource(@StringRes int r5) {
        setText(this.context.getResources().getString(r5));
    }

    public void setTextSize(@Dimension float r5) {
        TextAppearance r10 = getTextAppearance();
        if (r10 == null) goto L6;
        r10.setTextSize(r5);
        this.textDrawableHelper.getTextPaint().setTextSize(r5);
        onTextSizeChange();
        return;
    }

    public void setTextStartPadding(float r5) {
        if (this.textStartPadding == r5) goto L6;
        this.textStartPadding = r5;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextStartPaddingResource(@DimenRes int r5) {
        setTextStartPadding(this.context.getResources().getDimension(r5));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList r5) {
        if (this.tint == r5) goto L6;
        this.tint = r5;
        onStateChange(getState());
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode r5) {
        if (this.tintMode == r5) goto L6;
        this.tintMode = r5;
        this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, r5);
        invalidateSelf();
        return;
    }

    public void setUseCompatRipple(boolean r5) {
        if (this.useCompatRipple == r5) goto L6;
        this.useCompatRipple = r5;
        updateCompatRippleColor();
        onStateChange(getState());
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r5, boolean r10) {
        boolean r11 = super.setVisible(r5, r10);
        if (showsChipIcon() == false) goto L6;
        r11 = r11 | this.chipIcon.setVisible(r5, r10);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r11 = r11 | this.checkedIcon.setVisible(r5, r10);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r11 = r11 | this.closeIcon.setVisible(r5, r10);
    L11:
        if (r11 == false) goto L13;
        invalidateSelf();
    L13:
        return r11;
    }

    public boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable r5, @NonNull Runnable r10) {
        Drawable.Callback r11 = getCallback();
        if (r11 == null) goto L6;
        r11.unscheduleDrawable(this, r10);
        return;
    }

    public void setCheckedIconVisible(boolean r5) {
        if (this.checkedIconVisible == r5) goto L11;
        boolean r10 = showsCheckedIcon();
        this.checkedIconVisible = r5;
        boolean r11 = showsCheckedIcon();
        if (r10 == r11) goto L12;
        if (r11 == false) goto L8;
        applyChildDrawable(this.checkedIcon);
    L9:
        invalidateSelf();
        onSizeChange();
        return;
    L8:
        unapplyChildDrawable(this.checkedIcon);
        goto L9
    L12:
        return;
    }

    public void setChipIconVisible(boolean r5) {
        if (this.chipIconVisible == r5) goto L11;
        boolean r10 = showsChipIcon();
        this.chipIconVisible = r5;
        boolean r11 = showsChipIcon();
        if (r10 == r11) goto L12;
        if (r11 == false) goto L8;
        applyChildDrawable(this.chipIcon);
    L9:
        invalidateSelf();
        onSizeChange();
        return;
    L8:
        unapplyChildDrawable(this.chipIcon);
        goto L9
    L12:
        return;
    }

    public void setCloseIconVisible(boolean r5) {
        if (this.closeIconVisible == r5) goto L11;
        boolean r10 = showsCloseIcon();
        this.closeIconVisible = r5;
        boolean r11 = showsCloseIcon();
        if (r10 == r11) goto L12;
        if (r11 == false) goto L8;
        applyChildDrawable(this.closeIcon);
    L9:
        invalidateSelf();
        onSizeChange();
        return;
    L8:
        unapplyChildDrawable(this.closeIcon);
        goto L9
    L12:
        return;
    }

    public void setTextColor(@Nullable ColorStateList r5) {
        TextAppearance r10 = getTextAppearance();
        if (r10 == null) goto L6;
        r10.setTextColor(r5);
        invalidateSelf();
        return;
    }

    private boolean onStateChange(@NonNull int[] r10, @NonNull int[] r11) {
        boolean r5 = super.onStateChange(r10);
        ColorStateList r12 = this.chipSurfaceColor;
        if (r12 == null) goto L5;
        int r13 = r12.getColorForState(r10, this.currentChipSurfaceColor);
    L6:
        int r14 = compositeElevationOverlayIfNeeded(r13);
        boolean r15 = true;
        if (this.currentChipSurfaceColor == r14) goto L9;
        this.currentChipSurfaceColor = r14;
        r5 = true;
    L9:
        ColorStateList r16 = this.chipBackgroundColor;
        if (r16 == null) goto L12;
        int r17 = r16.getColorForState(r10, this.currentChipBackgroundColor);
    L13:
        int r18 = compositeElevationOverlayIfNeeded(r17);
        if (this.currentChipBackgroundColor == r18) goto L16;
        this.currentChipBackgroundColor = r18;
        r5 = true;
    L16:
        int r19 = MaterialColors.layer(r14, r18);
        if (this.currentCompositeSurfaceBackgroundColor == r19) goto L19;
        boolean r20 = true;
    L21:
        if (getFillColor() != null) goto L23;
        boolean r21 = true;
    L25:
        if ((r20 | r21) == false) goto L27;
        this.currentCompositeSurfaceBackgroundColor = r19;
        setFillColor(ColorStateList.valueOf(r19));
        r5 = true;
    L27:
        ColorStateList r22 = this.chipStrokeColor;
        if (r22 == null) goto L30;
        int r23 = r22.getColorForState(r10, this.currentChipStrokeColor);
    L32:
        if (this.currentChipStrokeColor == r23) goto L35;
        this.currentChipStrokeColor = r23;
        r5 = true;
    L35:
        if (this.compatRippleColor != null) goto L37;
    L39:
        int r24 = 0;
    L41:
        if (this.currentCompatRippleColor == r24) goto L46;
        this.currentCompatRippleColor = r24;
        if (this.useCompatRipple == false) goto L46;
        r5 = true;
    L46:
        if (this.textDrawableHelper.getTextAppearance() != null) goto L48;
    L50:
        int r25 = 0;
    L52:
        if (this.currentTextColor == r25) goto L55;
        this.currentTextColor = r25;
        r5 = true;
    L55:
        if (hasState(getState(), R.attr.state_checked) == true) goto L57;
    L59:
        boolean r26 = false;
    L61:
        if (this.currentChecked != r26) goto L63;
    L68:
        boolean r27 = false;
    L69:
        ColorStateList r28 = this.tint;
        if (r28 == null) goto L72;
        int r29 = r28.getColorForState(r10, this.currentTint);
    L74:
        if (this.currentTint == r29) goto L76;
        this.currentTint = r29;
        this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, this.tintMode);
    L78:
        if (isStateful(this.chipIcon) == false) goto L81;
        r15 = r15 | this.chipIcon.setState(r10);
    L81:
        if (isStateful(this.checkedIcon) == false) goto L84;
        r15 = r15 | this.checkedIcon.setState(r10);
    L84:
        if (isStateful(this.closeIcon) == false) goto L87;
        int[] r30 = new int[r10.length + r11.length];
        System.arraycopy(r10, 0, r30, 0, r10.length);
        System.arraycopy(r11, 0, r30, r10.length, r11.length);
        r15 = r15 | this.closeIcon.setState(r30);
    L87:
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == true) goto L89;
    L91:
        if (r15 == false) goto L93;
        invalidateSelf();
    L93:
        if (r27 == false) goto L95;
        onSizeChange();
    L95:
        return r15;
    L89:
        if (isStateful(this.closeIconRipple) == false) goto L91;
        r15 = r15 | this.closeIconRipple.setState(r11);
        goto L91
    L76:
        r15 = r5;
        goto L78
    L72:
        r29 = 0;
        goto L74
    L63:
        if (this.checkedIcon == null) goto L68;
        float r31 = calculateChipIconWidth();
        this.currentChecked = r26;
        if (r31 == calculateChipIconWidth()) goto L67;
        r5 = true;
        r27 = true;
        goto L69
    L67:
        r27 = false;
        r5 = true;
        goto L69
    L57:
        if (this.checkable == false) goto L59;
        r26 = true;
        goto L61
    L48:
        if (this.textDrawableHelper.getTextAppearance().getTextColor() == null) goto L50;
        r25 = this.textDrawableHelper.getTextAppearance().getTextColor().getColorForState(r10, this.currentTextColor);
        goto L52
    L37:
        if (RippleUtils.shouldDrawRippleCompat(r10) == false) goto L39;
        r24 = this.compatRippleColor.getColorForState(r10, this.currentCompatRippleColor);
        goto L41
    L30:
        r23 = 0;
        goto L32
    L23:
        r21 = false;
        goto L25
    L19:
        r20 = false;
        goto L21
    L12:
        r17 = 0;
        goto L13
    L5:
        r13 = 0;
        goto L6
    }

    private static boolean isStateful(@Nullable ColorStateList r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5.isStateful() == false) goto L6;
        return true;
    }

    private static boolean isStateful(@Nullable Drawable r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5.isStateful() == false) goto L6;
        return true;
    }

    private static boolean isStateful(@Nullable TextAppearance r5) {
        if (r5 != null) goto L4;
    L8:
        return false;
    L4:
        if (r5.getTextColor() == null) goto L8;
        if (r5.getTextColor().isStateful() == false) goto L8;
        return true;
    }
}
