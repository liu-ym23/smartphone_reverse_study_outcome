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
import android.os.Build;
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
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.i;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import q5.b;
import q5.k;
import q5.l;
import r5.h;

/* JADX INFO: loaded from: classes.dex */
public class ChipDrawable extends MaterialShapeDrawable implements Drawable.Callback, i.b {
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
    private WeakReference<a> delegate;
    private final Paint.FontMetrics fontMetrics;
    private boolean hasChipIconTint;

    @Nullable
    private h hideMotionSpec;
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
    private h showMotionSpec;

    @Nullable
    private CharSequence text;

    @NonNull
    private final i textDrawableHelper;
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

    public interface a {
        void onChipDrawableSizeChange();
    }

    static {
        DEFAULT_STATE = new int[]{R.attr.state_enabled};
        closeIconRippleMask = new ShapeDrawable(new OvalShape());
    }

    private ChipDrawable(@NonNull Context r10, AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(r10, r11, r12, r13);
        this.chipCornerRadius = -1.0f;
        this.chipPaint = new Paint(1);
        this.fontMetrics = new Paint.FontMetrics();
        this.rectF = new RectF();
        this.pointF = new PointF();
        this.shapePath = new Path();
        this.alpha = 255;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        this.delegate = new WeakReference(null);
        initializeElevationOverlay(r10);
        this.context = r10;
        i r14 = new i(this);
        this.textDrawableHelper = r14;
        this.text = "";
        TextPaint r15 = r14.e();
        r15.density = r10.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        int[] r16 = DEFAULT_STATE;
        setState(r16);
        setCloseIconState(r16);
        this.shouldDrawText = true;
        if (com.google.android.material.ripple.a.f3599a == false) goto L6;
        closeIconRippleMask.setTint(-1);
        return;
    }

    private void applyChildDrawable(@Nullable Drawable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.setCallback(this);
        DrawableCompat.setLayoutDirection(r10, DrawableCompat.getLayoutDirection(this));
        r10.setLevel(getLevel());
        r10.setVisible(isVisible(), false);
        if (r10 == this.closeIcon) goto L7;
        Drawable r11 = this.chipIcon;
        if (r10 != r11) goto L17;
        if (this.hasChipIconTint == false) goto L17;
        DrawableCompat.setTintList(r11, this.chipIconTint);
    L17:
        if (r10.isStateful() == false) goto L20;
        r10.setState(getState());
        return;
    L20:
        return;
    L7:
        if (r10.isStateful() == false) goto L9;
        r10.setState(getCloseIconState());
    L9:
        DrawableCompat.setTintList(r10, this.closeIconTint);
    }

    private void calculateChipIconBounds(@NonNull Rect r10, @NonNull RectF r11) {
        r11.setEmpty();
        if (showsChipIcon() == false) goto L5;
    L6:
        float r12 = this.chipStartPadding + this.iconStartPadding;
        float r13 = getCurrentChipIconWidth();
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L9;
        float r14 = r10.left + r12;
        r11.left = r14;
        r11.right = r14 + r13;
    L10:
        float r15 = getCurrentChipIconHeight();
        float r16 = r10.exactCenterY() - (r15 / 2.0f);
        r11.top = r16;
        r11.bottom = r16 + r15;
        return;
    L9:
        float r17 = r10.right - r12;
        r11.right = r17;
        r11.left = r17 - r13;
        goto L10
    L5:
        if (showsCheckedIcon() == true) goto L6;
    }

    private void calculateChipTouchBounds(@NonNull Rect r10, @NonNull RectF r11) {
        r11.set(r10);
        if (showsCloseIcon() == false) goto L9;
        float r12 = (((this.chipEndPadding + this.closeIconEndPadding) + this.closeIconSize) + this.closeIconStartPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r11.right = r10.right - r12;
        return;
    L7:
        r11.left = r10.left + r12;
        return;
    }

    private void calculateCloseIconBounds(@NonNull Rect r10, @NonNull RectF r11) {
        r11.setEmpty();
        if (showsCloseIcon() == false) goto L10;
        float r12 = this.chipEndPadding + this.closeIconEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        float r13 = r10.right - r12;
        r11.right = r13;
        r11.left = r13 - this.closeIconSize;
    L8:
        float r14 = r10.exactCenterY();
        float r15 = this.closeIconSize;
        float r16 = r14 - (r15 / 2.0f);
        r11.top = r16;
        r11.bottom = r16 + r15;
        return;
    L7:
        float r17 = r10.left + r12;
        r11.left = r17;
        r11.right = r17 + this.closeIconSize;
        goto L8
    }

    private void calculateCloseIconTouchBounds(@NonNull Rect r10, @NonNull RectF r11) {
        r11.setEmpty();
        if (showsCloseIcon() == false) goto L10;
        float r12 = (((this.chipEndPadding + this.closeIconEndPadding) + this.closeIconSize) + this.closeIconStartPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        float r13 = r10.right;
        r11.right = r13;
        r11.left = r13 - r12;
    L8:
        r11.top = r10.top;
        r11.bottom = r10.bottom;
        return;
    L7:
        int r14 = r10.left;
        r11.left = r14;
        r11.right = r14 + r12;
        goto L8
    }

    private void calculateTextBounds(@NonNull Rect r10, @NonNull RectF r11) {
        r11.setEmpty();
        if (this.text == null) goto L10;
        float r12 = (this.chipStartPadding + calculateChipIconWidth()) + this.textStartPadding;
        float r13 = (this.chipEndPadding + calculateCloseIconWidth()) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r11.left = r10.left + r12;
        float r14 = r10.right - r13;
    L8:
        r11.right = r14;
        r11.top = r10.top;
        r11.bottom = r10.bottom;
        return;
    L7:
        r11.left = r10.left + r13;
        r14 = r10.right - r12;
        goto L8
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.e().getFontMetrics(this.fontMetrics);
        Paint.FontMetrics r10 = this.fontMetrics;
        return (r10.descent + r10.ascent) / 2.0f;
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
    public static ChipDrawable createFromAttributes(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        ChipDrawable r14 = new ChipDrawable(r10, r11, r12, r13);
        r14.loadFromAttributes(r11, r12, r13);
        return r14;
    }

    @NonNull
    public static ChipDrawable createFromResource(@NonNull Context r10, @XmlRes int r11) {
        AttributeSet r12 = v5.a.a(r10, r11, "chip");
        int r13 = r12.getStyleAttribute();
        if (r13 != 0) goto L6;
        r13 = k.Widget_MaterialComponents_Chip_Entry;
    L6:
        return createFromAttributes(r10, r12, b.chipStandaloneStyle, r13);
    }

    private void drawCheckedIcon(@NonNull Canvas r10, @NonNull Rect r11) {
        if (showsCheckedIcon() == false) goto L6;
        calculateChipIconBounds(r11, this.rectF);
        RectF r12 = this.rectF;
        float r13 = r12.left;
        float r14 = r12.top;
        r10.translate(r13, r14);
        this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.checkedIcon.draw(r10);
        r10.translate(-r13, -r14);
        return;
    }

    private void drawChipBackground(@NonNull Canvas r10, @NonNull Rect r11) {
        if (this.isShapeThemingEnabled == true) goto L6;
        this.chipPaint.setColor(this.currentChipBackgroundColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.chipPaint.setColorFilter(getTintColorFilter());
        this.rectF.set(r11);
        r10.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    }

    private void drawChipIcon(@NonNull Canvas r10, @NonNull Rect r11) {
        if (showsChipIcon() == false) goto L6;
        calculateChipIconBounds(r11, this.rectF);
        RectF r12 = this.rectF;
        float r13 = r12.left;
        float r14 = r12.top;
        r10.translate(r13, r14);
        this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.chipIcon.draw(r10);
        r10.translate(-r13, -r14);
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
        RectF r12 = this.rectF;
        float r13 = r11.left;
        float r14 = this.chipStrokeWidth;
        r12.set(r13 + (r14 / 2.0f), r11.top + (r14 / 2.0f), r11.right - (r14 / 2.0f), r11.bottom - (r14 / 2.0f));
        float r15 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
        r10.drawRoundRect(this.rectF, r15, r15, this.chipPaint);
        return;
    }

    private void drawChipSurface(@NonNull Canvas r10, @NonNull Rect r11) {
        if (this.isShapeThemingEnabled == true) goto L6;
        this.chipPaint.setColor(this.currentChipSurfaceColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(r11);
        r10.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    }

    private void drawCloseIcon(@NonNull Canvas r10, @NonNull Rect r11) {
        if (showsCloseIcon() == false) goto L10;
        calculateCloseIconBounds(r11, this.rectF);
        RectF r12 = this.rectF;
        float r13 = r12.left;
        float r14 = r12.top;
        r10.translate(r13, r14);
        this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        if (com.google.android.material.ripple.a.f3599a == false) goto L7;
        this.closeIconRipple.setBounds(this.closeIcon.getBounds());
        this.closeIconRipple.jumpToCurrentState();
        Drawable r15 = this.closeIconRipple;
    L8:
        r15.draw(r10);
        r10.translate(-r13, -r14);
        return;
    L7:
        r15 = this.closeIcon;
        goto L8
    }

    private void drawCompatRipple(@NonNull Canvas r10, @NonNull Rect r11) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(r11);
        if (this.isShapeThemingEnabled == true) goto L5;
        r10.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    L5:
        calculatePathForSize(new RectF(r11), this.shapePath);
        super.drawShape(r10, this.chipPaint, this.shapePath, getBoundsAsRectF());
    }

    private void drawDebug(@NonNull Canvas r10, @NonNull Rect r11) {
        Paint r12 = this.debugPaint;
        if (r12 == null) goto L17;
        r12.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
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
        this.debugPaint.setColor(ColorUtils.setAlphaComponent(-65536, 127));
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
        Paint.Align r12 = calculateTextOriginAndAlignment(r11, this.pointF);
        calculateTextBounds(r11, this.rectF);
        if (this.textDrawableHelper.d() == null) goto L7;
        this.textDrawableHelper.e().drawableState = getState();
        this.textDrawableHelper.j(this.context);
    L7:
        this.textDrawableHelper.e().setTextAlign(r12);
        int r13 = 0;
        if (Math.round(this.textDrawableHelper.f(getText().toString())) <= Math.round(this.rectF.width())) goto L10;
        boolean r14 = true;
    L11:
        if (r14 == false) goto L13;
        r13 = r10.save();
        r10.clipRect(this.rectF);
    L13:
        CharSequence r15 = this.text;
        if (r14 == true) goto L16;
    L18:
        CharSequence r16 = r15;
        int r17 = r16.length();
        PointF r18 = this.pointF;
        r10.drawText(r16, 0, r17, r18.x, r18.y, this.textDrawableHelper.e());
        if (r14 == false) goto L23;
        r10.restoreToCount(r13);
        return;
    L23:
        return;
    L16:
        if (this.truncateAt == null) goto L18;
        r15 = TextUtils.ellipsize(r15, this.textDrawableHelper.e(), this.rectF.width(), this.truncateAt);
        goto L18
    L10:
        r14 = false;
        goto L11
    }

    private float getCurrentChipIconHeight() {
        if (this.currentChecked == false) goto L5;
        Drawable r10 = this.checkedIcon;
    L6:
        float r11 = this.chipIconSize;
        if (r11 > 0.0f) goto L13;
        if (r10 == null) goto L13;
        float r12 = (float) Math.ceil(ViewUtils.c(this.context, 24));
        if (r10.getIntrinsicHeight() <= r12) goto L12;
        return r12;
    L12:
        return r10.getIntrinsicHeight();
    L13:
        return r11;
    L5:
        r10 = this.chipIcon;
        goto L6
    }

    private float getCurrentChipIconWidth() {
        if (this.currentChecked == false) goto L5;
        Drawable r10 = this.checkedIcon;
    L6:
        float r11 = this.chipIconSize;
        if (r11 > 0.0f) goto L11;
        if (r10 != null) goto L10;
        return r11;
    L10:
        return r10.getIntrinsicWidth();
    L11:
        return r11;
    L5:
        r10 = this.chipIcon;
        goto L6
    }

    @Nullable
    private ColorFilter getTintColorFilter() {
        ColorFilter r10 = this.colorFilter;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.tintFilter;
    }

    private static boolean hasState(@Nullable int[] r10, @AttrRes int r11) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r12 = r10.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L12;
        if (r10[r13] == r11) goto L9;
        r13 = r13 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static boolean isStateful(@Nullable ColorStateList r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.isStateful() == false) goto L6;
        return true;
    }

    private static boolean isStateful(@Nullable Drawable r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.isStateful() == false) goto L6;
        return true;
    }

    private static boolean isStateful(@Nullable TextAppearance r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if (r10.i() == null) goto L8;
        if (r10.i().isStateful() == false) goto L8;
        return true;
    }

    private void loadFromAttributes(@Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        TypedArray r13 = com.google.android.material.internal.k.h(this.context, r10, l.Chip, r11, r12, new int[0]);
        this.isShapeThemingEnabled = r13.hasValue(l.Chip_shapeAppearance);
        setChipSurfaceColor(c.a(this.context, r13, l.Chip_chipSurfaceColor));
        setChipBackgroundColor(c.a(this.context, r13, l.Chip_chipBackgroundColor));
        setChipMinHeight(r13.getDimension(l.Chip_chipMinHeight, 0.0f));
        int r14 = l.Chip_chipCornerRadius;
        if (r13.hasValue(r14) == false) goto L5;
        setChipCornerRadius(r13.getDimension(r14, 0.0f));
    L5:
        setChipStrokeColor(c.a(this.context, r13, l.Chip_chipStrokeColor));
        setChipStrokeWidth(r13.getDimension(l.Chip_chipStrokeWidth, 0.0f));
        setRippleColor(c.a(this.context, r13, l.Chip_rippleColor));
        setText(r13.getText(l.Chip_android_text));
        TextAppearance r15 = c.g(this.context, r13, l.Chip_android_textAppearance);
        r15.l(r13.getDimension(l.Chip_android_textSize, r15.j()));
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        r15.k(c.a(this.context, r13, l.Chip_android_textColor));
    L8:
        setTextAppearance(r15);
        int r16 = r13.getInt(l.Chip_android_ellipsize, 0);
        if (r16 != 1) goto L11;
        TextUtils.TruncateAt r17 = TextUtils.TruncateAt.START;
    L18:
        setEllipsize(r17);
    L19:
        setChipIconVisible(r13.getBoolean(l.Chip_chipIconVisible, false));
        if (r10 != null) goto L22;
    L26:
        setChipIcon(c.e(this.context, r13, l.Chip_chipIcon));
        int r18 = l.Chip_chipIconTint;
        if (r13.hasValue(r18) == false) goto L29;
        setChipIconTint(c.a(this.context, r13, r18));
    L29:
        setChipIconSize(r13.getDimension(l.Chip_chipIconSize, -1.0f));
        setCloseIconVisible(r13.getBoolean(l.Chip_closeIconVisible, false));
        if (r10 != null) goto L32;
    L36:
        setCloseIcon(c.e(this.context, r13, l.Chip_closeIcon));
        setCloseIconTint(c.a(this.context, r13, l.Chip_closeIconTint));
        setCloseIconSize(r13.getDimension(l.Chip_closeIconSize, 0.0f));
        setCheckable(r13.getBoolean(l.Chip_android_checkable, false));
        setCheckedIconVisible(r13.getBoolean(l.Chip_checkedIconVisible, false));
        if (r10 != null) goto L39;
    L43:
        setCheckedIcon(c.e(this.context, r13, l.Chip_checkedIcon));
        int r19 = l.Chip_checkedIconTint;
        if (r13.hasValue(r19) == false) goto L46;
        setCheckedIconTint(c.a(this.context, r13, r19));
    L46:
        setShowMotionSpec(h.c(this.context, r13, l.Chip_showMotionSpec));
        setHideMotionSpec(h.c(this.context, r13, l.Chip_hideMotionSpec));
        setChipStartPadding(r13.getDimension(l.Chip_chipStartPadding, 0.0f));
        setIconStartPadding(r13.getDimension(l.Chip_iconStartPadding, 0.0f));
        setIconEndPadding(r13.getDimension(l.Chip_iconEndPadding, 0.0f));
        setTextStartPadding(r13.getDimension(l.Chip_textStartPadding, 0.0f));
        setTextEndPadding(r13.getDimension(l.Chip_textEndPadding, 0.0f));
        setCloseIconStartPadding(r13.getDimension(l.Chip_closeIconStartPadding, 0.0f));
        setCloseIconEndPadding(r13.getDimension(l.Chip_closeIconEndPadding, 0.0f));
        setChipEndPadding(r13.getDimension(l.Chip_chipEndPadding, 0.0f));
        setMaxWidth(r13.getDimensionPixelSize(l.Chip_android_maxWidth, Integer.MAX_VALUE));
        r13.recycle();
        return;
    L39:
        if (r10.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") == null) goto L43;
        if (r10.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") != null) goto L43;
        setCheckedIconVisible(r13.getBoolean(l.Chip_checkedIconEnabled, false));
        goto L43
    L32:
        if (r10.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") == null) goto L36;
        if (r10.getAttributeValue(NAMESPACE_APP, "closeIconVisible") != null) goto L36;
        setCloseIconVisible(r13.getBoolean(l.Chip_closeIconEnabled, false));
        goto L36
    L22:
        if (r10.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") == null) goto L26;
        if (r10.getAttributeValue(NAMESPACE_APP, "chipIconVisible") != null) goto L26;
        setChipIconVisible(r13.getBoolean(l.Chip_chipIconEnabled, false));
        goto L26
    L11:
        if (r16 != 2) goto L13;
        r17 = TextUtils.TruncateAt.MIDDLE;
        goto L18
    L13:
        if (r16 != 3) goto L19;
        r17 = TextUtils.TruncateAt.END;
        goto L18
    }

    private boolean onStateChange(@NonNull int[] r10, @NonNull int[] r11) {
        boolean r12 = super.onStateChange(r10);
        ColorStateList r13 = this.chipSurfaceColor;
        if (r13 == null) goto L5;
        int r14 = r13.getColorForState(r10, this.currentChipSurfaceColor);
    L6:
        int r15 = compositeElevationOverlayIfNeeded(r14);
        boolean r16 = true;
        if (this.currentChipSurfaceColor == r15) goto L9;
        this.currentChipSurfaceColor = r15;
        r12 = true;
    L9:
        ColorStateList r17 = this.chipBackgroundColor;
        if (r17 == null) goto L12;
        int r18 = r17.getColorForState(r10, this.currentChipBackgroundColor);
    L13:
        int r19 = compositeElevationOverlayIfNeeded(r18);
        if (this.currentChipBackgroundColor == r19) goto L16;
        this.currentChipBackgroundColor = r19;
        r12 = true;
    L16:
        int r20 = t5.a.g(r15, r19);
        if (this.currentCompositeSurfaceBackgroundColor == r20) goto L19;
        boolean r21 = true;
    L21:
        if (getFillColor() != null) goto L23;
        boolean r22 = true;
    L25:
        if ((r21 | r22) == false) goto L27;
        this.currentCompositeSurfaceBackgroundColor = r20;
        setFillColor(ColorStateList.valueOf(r20));
        r12 = true;
    L27:
        ColorStateList r23 = this.chipStrokeColor;
        if (r23 == null) goto L30;
        int r24 = r23.getColorForState(r10, this.currentChipStrokeColor);
    L32:
        if (this.currentChipStrokeColor == r24) goto L35;
        this.currentChipStrokeColor = r24;
        r12 = true;
    L35:
        if (this.compatRippleColor != null) goto L37;
    L39:
        int r25 = 0;
    L41:
        if (this.currentCompatRippleColor == r25) goto L46;
        this.currentCompatRippleColor = r25;
        if (this.useCompatRipple == false) goto L46;
        r12 = true;
    L46:
        if (this.textDrawableHelper.d() != null) goto L48;
    L50:
        int r26 = 0;
    L52:
        if (this.currentTextColor == r26) goto L55;
        this.currentTextColor = r26;
        r12 = true;
    L55:
        if (hasState(getState(), R.attr.state_checked) == true) goto L57;
    L59:
        boolean r27 = false;
    L61:
        if (this.currentChecked != r27) goto L63;
    L68:
        boolean r28 = false;
    L69:
        ColorStateList r29 = this.tint;
        if (r29 == null) goto L72;
        int r30 = r29.getColorForState(r10, this.currentTint);
    L74:
        if (this.currentTint == r30) goto L76;
        this.currentTint = r30;
        this.tintFilter = v5.a.c(this, this.tint, this.tintMode);
    L78:
        if (isStateful(this.chipIcon) == false) goto L81;
        r16 = r16 | this.chipIcon.setState(r10);
    L81:
        if (isStateful(this.checkedIcon) == false) goto L84;
        r16 = r16 | this.checkedIcon.setState(r10);
    L84:
        if (isStateful(this.closeIcon) == false) goto L87;
        int[] r31 = new int[r10.length + r11.length];
        System.arraycopy(r10, 0, r31, 0, r10.length);
        System.arraycopy(r11, 0, r31, r10.length, r11.length);
        r16 = r16 | this.closeIcon.setState(r31);
    L87:
        if (com.google.android.material.ripple.a.f3599a == true) goto L89;
    L91:
        if (r16 == false) goto L93;
        invalidateSelf();
    L93:
        if (r28 == false) goto L95;
        onSizeChange();
    L95:
        return r16;
    L89:
        if (isStateful(this.closeIconRipple) == false) goto L91;
        r16 = r16 | this.closeIconRipple.setState(r11);
        goto L91
    L76:
        r16 = r12;
        goto L78
    L72:
        r30 = 0;
        goto L74
    L63:
        if (this.checkedIcon == null) goto L68;
        float r32 = calculateChipIconWidth();
        this.currentChecked = r27;
        if (r32 == calculateChipIconWidth()) goto L67;
        r12 = true;
        r28 = true;
        goto L69
    L67:
        r28 = false;
        r12 = true;
        goto L69
    L57:
        if (this.checkable == false) goto L59;
        r27 = true;
        goto L61
    L48:
        if (this.textDrawableHelper.d().i() == null) goto L50;
        r26 = this.textDrawableHelper.d().i().getColorForState(r10, this.currentTextColor);
        goto L52
    L37:
        if (com.google.android.material.ripple.a.e(r10) == false) goto L39;
        r25 = this.compatRippleColor.getColorForState(r10, this.currentCompatRippleColor);
        goto L41
    L30:
        r24 = 0;
        goto L32
    L23:
        r22 = false;
        goto L25
    L19:
        r21 = false;
        goto L21
    L12:
        r18 = 0;
        goto L13
    L5:
        r14 = 0;
        goto L6
    }

    private void setChipSurfaceColor(@Nullable ColorStateList r10) {
        if (this.chipSurfaceColor == r10) goto L6;
        this.chipSurfaceColor = r10;
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

    private void unapplyChildDrawable(@Nullable Drawable r10) {
        if (r10 == null) goto L5;
        r10.setCallback(null);
        return;
    }

    private void updateCompatRippleColor() {
        if (this.useCompatRipple == false) goto L5;
        ColorStateList r10 = com.google.android.material.ripple.a.d(this.rippleColor);
    L6:
        this.compatRippleColor = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    @TargetApi(21)
    private void updateFrameworkCloseIconRipple() {
        this.closeIconRipple = new RippleDrawable(com.google.android.material.ripple.a.d(getRippleColor()), this.closeIcon, closeIconRippleMask);
    }

    float calculateChipIconWidth() {
        if (showsChipIcon() == true) goto L10;
        if (showsCheckedIcon() == true) goto L10;
        return 0.0f;
    L10:
        return (this.iconStartPadding + getCurrentChipIconWidth()) + this.iconEndPadding;
    }

    float calculateCloseIconWidth() {
        if (showsCloseIcon() == true) goto L5;
        return 0.0f;
    L5:
        return (this.closeIconStartPadding + this.closeIconSize) + this.closeIconEndPadding;
    }

    @NonNull
    Paint.Align calculateTextOriginAndAlignment(@NonNull Rect r10, @NonNull PointF r11) {
        r11.set(0.0f, 0.0f);
        Paint.Align r12 = Paint.Align.LEFT;
        if (this.text == null) goto L9;
        float r13 = (this.chipStartPadding + calculateChipIconWidth()) + this.textStartPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r11.x = r10.left + r13;
        r12 = Paint.Align.LEFT;
    L8:
        r11.y = r10.centerY() - calculateTextCenterFromBaseline();
        goto L9
    L7:
        r11.x = r10.right - r13;
        r12 = Paint.Align.RIGHT;
    L9:
        return r12;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        Rect r11 = getBounds();
        if (r11.isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() == 0) goto L22;
        int r12 = 0;
        int r13 = this.alpha;
        if (r13 >= 255) goto L10;
        r12 = s5.a.a(r10, r11.left, r11.top, r11.right, r11.bottom, r13);
    L10:
        drawChipSurface(r10, r11);
        drawChipBackground(r10, r11);
        if (this.isShapeThemingEnabled == false) goto L13;
        super.draw(r10);
    L13:
        drawChipStroke(r10, r11);
        drawCompatRipple(r10, r11);
        drawChipIcon(r10, r11);
        drawCheckedIcon(r10, r11);
        if (this.shouldDrawText == false) goto L16;
        drawText(r10, r11);
    L16:
        drawCloseIcon(r10, r11);
        drawDebug(r10, r11);
        if (this.alpha >= 255) goto L21;
        r10.restoreToCount(r12);
        return;
    L21:
        return;
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
        Drawable r10 = this.chipIcon;
        if (r10 != null) goto L7;
        return null;
    L7:
        return DrawableCompat.unwrap(r10);
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

    public void getChipTouchBounds(@NonNull RectF r10) {
        calculateChipTouchBounds(getBounds(), r10);
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable r10 = this.closeIcon;
        if (r10 != null) goto L7;
        return null;
    L7:
        return DrawableCompat.unwrap(r10);
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

    public void getCloseIconTouchBounds(@NonNull RectF r10) {
        calculateCloseIconTouchBounds(getBounds(), r10);
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
    public h getHideMotionSpec() {
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
        return Math.min(Math.round((((((this.chipStartPadding + calculateChipIconWidth()) + this.textStartPadding) + this.textDrawableHelper.f(getText().toString())) + this.textEndPadding) + calculateCloseIconWidth()) + this.chipEndPadding), this.maxWidth);
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
        Rect r11 = getBounds();
        if (r11.isEmpty() == true) goto L9;
        r10.setRoundRect(r11, this.chipCornerRadius);
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
    public h getShowMotionSpec() {
        return this.showMotionSpec;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.d();
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
    public void invalidateDrawable(@NonNull Drawable r10) {
        Drawable.Callback r11 = getCallback();
        if (r11 == null) goto L6;
        r11.invalidateDrawable(this);
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

    boolean isShapeThemingEnabled() {
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
        if (isStateful(this.textDrawableHelper.d()) == true) goto L24;
        if (canShowCheckedIcon() == true) goto L24;
        if (isStateful(this.chipIcon) == true) goto L24;
        if (isStateful(this.checkedIcon) == true) goto L24;
        if (isStateful(this.tint) == true) goto L24;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int r10) {
        boolean r11 = super.onLayoutDirectionChanged(r10);
        if (showsChipIcon() == false) goto L6;
        r11 = r11 | DrawableCompat.setLayoutDirection(this.chipIcon, r10);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r11 = r11 | DrawableCompat.setLayoutDirection(this.checkedIcon, r10);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r11 = r11 | DrawableCompat.setLayoutDirection(this.closeIcon, r10);
    L11:
        if (r11 == false) goto L15;
        invalidateSelf();
        return true;
    L15:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r10) {
        boolean r11 = super.onLevelChange(r10);
        if (showsChipIcon() == false) goto L6;
        r11 = r11 | this.chipIcon.setLevel(r10);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r11 = r11 | this.checkedIcon.setLevel(r10);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r11 = r11 | this.closeIcon.setLevel(r10);
    L11:
        if (r11 == false) goto L13;
        invalidateSelf();
    L13:
        return r11;
    }

    protected void onSizeChange() {
        a r10 = this.delegate.get();
        if (r10 == null) goto L6;
        r10.onChipDrawableSizeChange();
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.i.b
    public boolean onStateChange(@NonNull int[] r10) {
        if (this.isShapeThemingEnabled == false) goto L6;
        super.onStateChange(r10);
    L6:
        return onStateChange(r10, getCloseIconState());
    }

    @Override // com.google.android.material.internal.i.b
    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable r10, @NonNull Runnable r11, long r12) {
        Drawable.Callback r13 = getCallback();
        if (r13 == null) goto L6;
        r13.scheduleDrawable(this, r11, r12);
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        if (this.alpha == r10) goto L6;
        this.alpha = r10;
        invalidateSelf();
        return;
    }

    public void setCheckable(boolean r10) {
        if (this.checkable == r10) goto L13;
        this.checkable = r10;
        float r11 = calculateChipIconWidth();
        if (r10 == false) goto L7;
    L9:
        float r12 = calculateChipIconWidth();
        invalidateSelf();
        if (r11 == r12) goto L14;
        onSizeChange();
        return;
    L14:
        return;
    L7:
        if (this.currentChecked == false) goto L9;
        this.currentChecked = false;
        goto L9
    }

    public void setCheckableResource(@BoolRes int r10) {
        setCheckable(this.context.getResources().getBoolean(r10));
    }

    public void setCheckedIcon(@Nullable Drawable r10) {
        if (this.checkedIcon == r10) goto L8;
        float r11 = calculateChipIconWidth();
        this.checkedIcon = r10;
        float r12 = calculateChipIconWidth();
        unapplyChildDrawable(this.checkedIcon);
        applyChildDrawable(this.checkedIcon);
        invalidateSelf();
        if (r11 == r12) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean r10) {
        setCheckedIconVisible(r10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int r10) {
        setCheckedIconVisible(this.context.getResources().getBoolean(r10));
    }

    public void setCheckedIconResource(@DrawableRes int r10) {
        setCheckedIcon(AppCompatResources.getDrawable(this.context, r10));
    }

    public void setCheckedIconTint(@Nullable ColorStateList r10) {
        if (this.checkedIconTint == r10) goto L9;
        this.checkedIconTint = r10;
        if (canShowCheckedIcon() == false) goto L7;
        DrawableCompat.setTintList(this.checkedIcon, r10);
    L7:
        onStateChange(getState());
        return;
    }

    public void setCheckedIconTintResource(@ColorRes int r10) {
        setCheckedIconTint(AppCompatResources.getColorStateList(this.context, r10));
    }

    public void setCheckedIconVisible(@BoolRes int r10) {
        setCheckedIconVisible(this.context.getResources().getBoolean(r10));
    }

    public void setCheckedIconVisible(boolean r10) {
        if (this.checkedIconVisible == r10) goto L14;
        boolean r11 = showsCheckedIcon();
        this.checkedIconVisible = r10;
        boolean r12 = showsCheckedIcon();
        if (r11 == r12) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L15;
        if (r12 == false) goto L11;
        applyChildDrawable(this.checkedIcon);
    L12:
        invalidateSelf();
        onSizeChange();
        return;
    L11:
        unapplyChildDrawable(this.checkedIcon);
        goto L12
    L15:
        return;
    L7:
        r13 = false;
        goto L8
    }

    public void setChipBackgroundColor(@Nullable ColorStateList r10) {
        if (this.chipBackgroundColor == r10) goto L6;
        this.chipBackgroundColor = r10;
        onStateChange(getState());
        return;
    }

    public void setChipBackgroundColorResource(@ColorRes int r10) {
        setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, r10));
    }

    @Deprecated
    public void setChipCornerRadius(float r10) {
        if (this.chipCornerRadius == r10) goto L6;
        this.chipCornerRadius = r10;
        setShapeAppearanceModel(getShapeAppearanceModel().w(r10));
        return;
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int r10) {
        setChipCornerRadius(this.context.getResources().getDimension(r10));
    }

    public void setChipEndPadding(float r10) {
        if (this.chipEndPadding == r10) goto L6;
        this.chipEndPadding = r10;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipEndPaddingResource(@DimenRes int r10) {
        setChipEndPadding(this.context.getResources().getDimension(r10));
    }

    public void setChipIcon(@Nullable Drawable r10) {
        Drawable r11 = getChipIcon();
        if (r11 == r10) goto L15;
        float r12 = calculateChipIconWidth();
        if (r10 == null) goto L7;
        Drawable r13 = DrawableCompat.wrap(r10).mutate();
    L8:
        this.chipIcon = r13;
        float r14 = calculateChipIconWidth();
        unapplyChildDrawable(r11);
        if (showsChipIcon() == false) goto L11;
        applyChildDrawable(this.chipIcon);
    L11:
        invalidateSelf();
        if (r12 == r14) goto L16;
        onSizeChange();
        return;
    L16:
        return;
    L7:
        r13 = null;
        goto L8
    }

    @Deprecated
    public void setChipIconEnabled(boolean r10) {
        setChipIconVisible(r10);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int r10) {
        setChipIconVisible(r10);
    }

    public void setChipIconResource(@DrawableRes int r10) {
        setChipIcon(AppCompatResources.getDrawable(this.context, r10));
    }

    public void setChipIconSize(float r10) {
        if (this.chipIconSize == r10) goto L8;
        float r11 = calculateChipIconWidth();
        this.chipIconSize = r10;
        float r12 = calculateChipIconWidth();
        invalidateSelf();
        if (r11 == r12) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setChipIconSizeResource(@DimenRes int r10) {
        setChipIconSize(this.context.getResources().getDimension(r10));
    }

    public void setChipIconTint(@Nullable ColorStateList r10) {
        this.hasChipIconTint = true;
        if (this.chipIconTint == r10) goto L9;
        this.chipIconTint = r10;
        if (showsChipIcon() == false) goto L7;
        DrawableCompat.setTintList(this.chipIcon, r10);
    L7:
        onStateChange(getState());
        return;
    }

    public void setChipIconTintResource(@ColorRes int r10) {
        setChipIconTint(AppCompatResources.getColorStateList(this.context, r10));
    }

    public void setChipIconVisible(@BoolRes int r10) {
        setChipIconVisible(this.context.getResources().getBoolean(r10));
    }

    public void setChipIconVisible(boolean r10) {
        if (this.chipIconVisible == r10) goto L14;
        boolean r11 = showsChipIcon();
        this.chipIconVisible = r10;
        boolean r12 = showsChipIcon();
        if (r11 == r12) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L15;
        if (r12 == false) goto L11;
        applyChildDrawable(this.chipIcon);
    L12:
        invalidateSelf();
        onSizeChange();
        return;
    L11:
        unapplyChildDrawable(this.chipIcon);
        goto L12
    L15:
        return;
    L7:
        r13 = false;
        goto L8
    }

    public void setChipMinHeight(float r10) {
        if (this.chipMinHeight == r10) goto L6;
        this.chipMinHeight = r10;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipMinHeightResource(@DimenRes int r10) {
        setChipMinHeight(this.context.getResources().getDimension(r10));
    }

    public void setChipStartPadding(float r10) {
        if (this.chipStartPadding == r10) goto L6;
        this.chipStartPadding = r10;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipStartPaddingResource(@DimenRes int r10) {
        setChipStartPadding(this.context.getResources().getDimension(r10));
    }

    public void setChipStrokeColor(@Nullable ColorStateList r10) {
        if (this.chipStrokeColor == r10) goto L9;
        this.chipStrokeColor = r10;
        if (this.isShapeThemingEnabled == false) goto L7;
        setStrokeColor(r10);
    L7:
        onStateChange(getState());
        return;
    }

    public void setChipStrokeColorResource(@ColorRes int r10) {
        setChipStrokeColor(AppCompatResources.getColorStateList(this.context, r10));
    }

    public void setChipStrokeWidth(float r10) {
        if (this.chipStrokeWidth == r10) goto L9;
        this.chipStrokeWidth = r10;
        this.chipPaint.setStrokeWidth(r10);
        if (this.isShapeThemingEnabled == false) goto L7;
        super.setStrokeWidth(r10);
    L7:
        invalidateSelf();
        return;
    }

    public void setChipStrokeWidthResource(@DimenRes int r10) {
        setChipStrokeWidth(this.context.getResources().getDimension(r10));
    }

    public void setCloseIcon(@Nullable Drawable r10) {
        Drawable r11 = getCloseIcon();
        if (r11 == r10) goto L18;
        float r12 = calculateCloseIconWidth();
        if (r10 == null) goto L7;
        Drawable r13 = DrawableCompat.wrap(r10).mutate();
    L8:
        this.closeIcon = r13;
        if (com.google.android.material.ripple.a.f3599a == false) goto L11;
        updateFrameworkCloseIconRipple();
    L11:
        float r14 = calculateCloseIconWidth();
        unapplyChildDrawable(r11);
        if (showsCloseIcon() == false) goto L14;
        applyChildDrawable(this.closeIcon);
    L14:
        invalidateSelf();
        if (r12 == r14) goto L19;
        onSizeChange();
        return;
    L19:
        return;
    L7:
        r13 = null;
        goto L8
    }

    public void setCloseIconContentDescription(@Nullable CharSequence r10) {
        if (this.closeIconContentDescription == r10) goto L6;
        this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(r10);
        invalidateSelf();
        return;
    }

    @Deprecated
    public void setCloseIconEnabled(boolean r10) {
        setCloseIconVisible(r10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int r10) {
        setCloseIconVisible(r10);
    }

    public void setCloseIconEndPadding(float r10) {
        if (this.closeIconEndPadding == r10) goto L8;
        this.closeIconEndPadding = r10;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconEndPaddingResource(@DimenRes int r10) {
        setCloseIconEndPadding(this.context.getResources().getDimension(r10));
    }

    public void setCloseIconResource(@DrawableRes int r10) {
        setCloseIcon(AppCompatResources.getDrawable(this.context, r10));
    }

    public void setCloseIconSize(float r10) {
        if (this.closeIconSize == r10) goto L8;
        this.closeIconSize = r10;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconSizeResource(@DimenRes int r10) {
        setCloseIconSize(this.context.getResources().getDimension(r10));
    }

    public void setCloseIconStartPadding(float r10) {
        if (this.closeIconStartPadding == r10) goto L8;
        this.closeIconStartPadding = r10;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconStartPaddingResource(@DimenRes int r10) {
        setCloseIconStartPadding(this.context.getResources().getDimension(r10));
    }

    public boolean setCloseIconState(@NonNull int[] r10) {
        if (Arrays.equals(this.closeIconStateSet, r10) == true) goto L8;
        this.closeIconStateSet = r10;
        if (showsCloseIcon() == true) goto L7;
        return false;
    L7:
        return onStateChange(getState(), r10);
    L8:
        return false;
    }

    public void setCloseIconTint(@Nullable ColorStateList r10) {
        if (this.closeIconTint == r10) goto L9;
        this.closeIconTint = r10;
        if (showsCloseIcon() == false) goto L7;
        DrawableCompat.setTintList(this.closeIcon, r10);
    L7:
        onStateChange(getState());
        return;
    }

    public void setCloseIconTintResource(@ColorRes int r10) {
        setCloseIconTint(AppCompatResources.getColorStateList(this.context, r10));
    }

    public void setCloseIconVisible(@BoolRes int r10) {
        setCloseIconVisible(this.context.getResources().getBoolean(r10));
    }

    public void setCloseIconVisible(boolean r10) {
        if (this.closeIconVisible == r10) goto L14;
        boolean r11 = showsCloseIcon();
        this.closeIconVisible = r10;
        boolean r12 = showsCloseIcon();
        if (r11 == r12) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L15;
        if (r12 == false) goto L11;
        applyChildDrawable(this.closeIcon);
    L12:
        invalidateSelf();
        onSizeChange();
        return;
    L11:
        unapplyChildDrawable(this.closeIcon);
        goto L12
    L15:
        return;
    L7:
        r13 = false;
        goto L8
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r10) {
        if (this.colorFilter == r10) goto L6;
        this.colorFilter = r10;
        invalidateSelf();
        return;
    }

    public void setDelegate(@Nullable a r10) {
        this.delegate = new WeakReference(r10);
    }

    public void setEllipsize(@Nullable TextUtils.TruncateAt r10) {
        this.truncateAt = r10;
    }

    public void setHideMotionSpec(@Nullable h r10) {
        this.hideMotionSpec = r10;
    }

    public void setHideMotionSpecResource(@AnimatorRes int r10) {
        setHideMotionSpec(h.d(this.context, r10));
    }

    public void setIconEndPadding(float r10) {
        if (this.iconEndPadding == r10) goto L8;
        float r11 = calculateChipIconWidth();
        this.iconEndPadding = r10;
        float r12 = calculateChipIconWidth();
        invalidateSelf();
        if (r11 == r12) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setIconEndPaddingResource(@DimenRes int r10) {
        setIconEndPadding(this.context.getResources().getDimension(r10));
    }

    public void setIconStartPadding(float r10) {
        if (this.iconStartPadding == r10) goto L8;
        float r11 = calculateChipIconWidth();
        this.iconStartPadding = r10;
        float r12 = calculateChipIconWidth();
        invalidateSelf();
        if (r11 == r12) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setIconStartPaddingResource(@DimenRes int r10) {
        setIconStartPadding(this.context.getResources().getDimension(r10));
    }

    public void setMaxWidth(@Px int r10) {
        this.maxWidth = r10;
    }

    public void setRippleColor(@Nullable ColorStateList r10) {
        if (this.rippleColor == r10) goto L6;
        this.rippleColor = r10;
        updateCompatRippleColor();
        onStateChange(getState());
        return;
    }

    public void setRippleColorResource(@ColorRes int r10) {
        setRippleColor(AppCompatResources.getColorStateList(this.context, r10));
    }

    void setShouldDrawText(boolean r10) {
        this.shouldDrawText = r10;
    }

    public void setShowMotionSpec(@Nullable h r10) {
        this.showMotionSpec = r10;
    }

    public void setShowMotionSpecResource(@AnimatorRes int r10) {
        setShowMotionSpec(h.d(this.context, r10));
    }

    public void setText(@Nullable CharSequence r10) {
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        if (TextUtils.equals(this.text, r10) == true) goto L8;
        this.text = r10;
        this.textDrawableHelper.i(true);
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextAppearance(@Nullable TextAppearance r10) {
        this.textDrawableHelper.h(r10, this.context);
    }

    public void setTextAppearanceResource(@StyleRes int r10) {
        setTextAppearance(new TextAppearance(this.context, r10));
    }

    public void setTextColor(@ColorInt int r10) {
        setTextColor(ColorStateList.valueOf(r10));
    }

    public void setTextColor(@Nullable ColorStateList r10) {
        TextAppearance r11 = getTextAppearance();
        if (r11 == null) goto L6;
        r11.k(r10);
        invalidateSelf();
        return;
    }

    public void setTextEndPadding(float r10) {
        if (this.textEndPadding == r10) goto L6;
        this.textEndPadding = r10;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextEndPaddingResource(@DimenRes int r10) {
        setTextEndPadding(this.context.getResources().getDimension(r10));
    }

    public void setTextResource(@StringRes int r10) {
        setText(this.context.getResources().getString(r10));
    }

    public void setTextSize(@Dimension float r10) {
        TextAppearance r11 = getTextAppearance();
        if (r11 == null) goto L6;
        r11.l(r10);
        this.textDrawableHelper.e().setTextSize(r10);
        onTextSizeChange();
        return;
    }

    public void setTextStartPadding(float r10) {
        if (this.textStartPadding == r10) goto L6;
        this.textStartPadding = r10;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextStartPaddingResource(@DimenRes int r10) {
        setTextStartPadding(this.context.getResources().getDimension(r10));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList r10) {
        if (this.tint == r10) goto L6;
        this.tint = r10;
        onStateChange(getState());
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode r10) {
        if (this.tintMode == r10) goto L6;
        this.tintMode = r10;
        this.tintFilter = v5.a.c(this, this.tint, r10);
        invalidateSelf();
        return;
    }

    public void setUseCompatRipple(boolean r10) {
        if (this.useCompatRipple == r10) goto L6;
        this.useCompatRipple = r10;
        updateCompatRippleColor();
        onStateChange(getState());
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        boolean r12 = super.setVisible(r10, r11);
        if (showsChipIcon() == false) goto L6;
        r12 = r12 | this.chipIcon.setVisible(r10, r11);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r12 = r12 | this.checkedIcon.setVisible(r10, r11);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r12 = r12 | this.closeIcon.setVisible(r10, r11);
    L11:
        if (r12 == false) goto L13;
        invalidateSelf();
    L13:
        return r12;
    }

    boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable r10, @NonNull Runnable r11) {
        Drawable.Callback r12 = getCallback();
        if (r12 == null) goto L6;
        r12.unscheduleDrawable(this, r11);
        return;
    }
}
