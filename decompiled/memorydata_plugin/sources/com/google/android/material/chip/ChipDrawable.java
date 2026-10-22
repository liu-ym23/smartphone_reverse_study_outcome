package com.google.android.material.chip;

import android.R;
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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.a.h;
import com.google.android.material.internal.i;
import com.google.android.material.internal.k;
import com.google.android.material.internal.r;
import com.google.android.material.resources.c;
import com.google.android.material.resources.d;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ChipDrawable extends MaterialShapeDrawable implements Drawable.Callback, TintAwareDrawable, i.a {
    private static final boolean DEBUG = false;
    private static final int[] DEFAULT_STATE = null;
    private static final int MAX_CHIP_ICON_HEIGHT = 24;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private static final ShapeDrawable closeIconRippleMask = null;
    private int alpha;
    private boolean checkable;
    private Drawable checkedIcon;
    private ColorStateList checkedIconTint;
    private boolean checkedIconVisible;
    private ColorStateList chipBackgroundColor;
    private float chipCornerRadius;
    private float chipEndPadding;
    private Drawable chipIcon;
    private float chipIconSize;
    private ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final Paint chipPaint;
    private float chipStartPadding;
    private ColorStateList chipStrokeColor;
    private float chipStrokeWidth;
    private ColorStateList chipSurfaceColor;
    private Drawable closeIcon;
    private CharSequence closeIconContentDescription;
    private float closeIconEndPadding;
    private Drawable closeIconRipple;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;
    private ColorStateList closeIconTint;
    private boolean closeIconVisible;
    private ColorFilter colorFilter;
    private ColorStateList compatRippleColor;
    private final Context context;
    private boolean currentChecked;
    private int currentChipBackgroundColor;
    private int currentChipStrokeColor;
    private int currentChipSurfaceColor;
    private int currentCompatRippleColor;
    private int currentCompositeSurfaceBackgroundColor;
    private int currentTextColor;
    private int currentTint;
    private final Paint debugPaint;
    private WeakReference<a> delegate;
    private final Paint.FontMetrics fontMetrics;
    private boolean hasChipIconTint;
    private h hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private boolean isShapeThemingEnabled;
    private int maxWidth;
    private final PointF pointF;
    private final RectF rectF;
    private ColorStateList rippleColor;
    private final Path shapePath;
    private boolean shouldDrawText;
    private h showMotionSpec;
    private CharSequence text;
    private final i textDrawableHelper;
    private float textEndPadding;
    private float textStartPadding;
    private ColorStateList tint;
    private PorterDuffColorFilter tintFilter;
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

    private ChipDrawable(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r7, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5, r6);
        this.chipCornerRadius = -1.0f;
        this.chipPaint = new Paint(1);
        this.fontMetrics = new Paint.FontMetrics();
        this.rectF = new RectF();
        this.pointF = new PointF();
        this.shapePath = new Path();
        this.alpha = 255;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        this.delegate = new WeakReference(null);
        initializeElevationOverlay(r7);
        this.context = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        i r8 = new i(this);
        this.textDrawableHelper = r8;
        this.text = "";
        TextPaint r9 = r8.a();
        r9.density = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        this.debugPaint = null;
        int[] r10 = DEFAULT_STATE;
        setState(r10);
        setCloseIconState(r10);
        this.shouldDrawText = true;
        if (com.google.android.material.ripple.a.f4033a == false) goto L6;
        closeIconRippleMask.setTint(-1);
        return;
    }

    private void applyChildDrawable(Drawable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.setCallback(this);
        DrawableCompat.setLayoutDirection(r3, DrawableCompat.getLayoutDirection(this));
        r3.setLevel(getLevel());
        r3.setVisible(isVisible(), false);
        if (r3 == this.closeIcon) goto L7;
        Drawable r0 = this.chipIcon;
        if (r3 != r0) goto L17;
        if (this.hasChipIconTint == false) goto L17;
        DrawableCompat.setTintList(r0, this.chipIconTint);
    L17:
        if (r3.isStateful() == false) goto L20;
        r3.setState(getState());
        return;
    L20:
        return;
    L7:
        if (r3.isStateful() == false) goto L9;
        r3.setState(getCloseIconState());
    L9:
        DrawableCompat.setTintList(r3, this.closeIconTint);
    }

    private void calculateChipIconBounds(Rect r4, RectF r5) {
        r5.setEmpty();
        if (showsChipIcon() == false) goto L5;
    L6:
        float r0 = this.chipStartPadding + this.iconStartPadding;
        float r1 = getCurrentChipIconWidth();
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L9;
        r5.left = r4.left + r0;
        r5.right = r5.left + r1;
    L10:
        float r3 = getCurrentChipIconHeight();
        r5.top = r4.exactCenterY() - (r3 / 2.0f);
        r5.bottom = r5.top + r3;
        return;
    L9:
        r5.right = r4.right - r0;
        r5.left = r5.right - r1;
        goto L10
    L5:
        if (showsCheckedIcon() == true) goto L6;
    }

    private void calculateChipTouchBounds(Rect r3, RectF r4) {
        r4.set(r3);
        if (showsCloseIcon() == false) goto L9;
        float r0 = (((this.chipEndPadding + this.closeIconEndPadding) + this.closeIconSize) + this.closeIconStartPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r4.right = r3.right - r0;
        return;
    L7:
        r4.left = r3.left + r0;
        return;
    }

    private void calculateCloseIconBounds(Rect r3, RectF r4) {
        r4.setEmpty();
        if (showsCloseIcon() == false) goto L10;
        float r0 = this.chipEndPadding + this.closeIconEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r4.right = r3.right - r0;
        r4.left = r4.right - this.closeIconSize;
    L8:
        r4.top = r3.exactCenterY() - (this.closeIconSize / 2.0f);
        r4.bottom = r4.top + this.closeIconSize;
        return;
    L7:
        r4.left = r3.left + r0;
        r4.right = r4.left + this.closeIconSize;
        goto L8
    }

    private void calculateCloseIconTouchBounds(Rect r3, RectF r4) {
        r4.setEmpty();
        if (showsCloseIcon() == false) goto L10;
        float r0 = (((this.chipEndPadding + this.closeIconEndPadding) + this.closeIconSize) + this.closeIconStartPadding) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r4.right = r3.right;
        r4.left = r4.right - r0;
    L8:
        r4.top = r3.top;
        r4.bottom = r3.bottom;
        return;
    L7:
        r4.left = r3.left;
        r4.right = r3.left + r0;
        goto L8
    }

    private void calculateTextBounds(Rect r4, RectF r5) {
        r5.setEmpty();
        if (this.text == null) goto L10;
        float r0 = (this.chipStartPadding + calculateChipIconWidth()) + this.textStartPadding;
        float r1 = (this.chipEndPadding + calculateCloseIconWidth()) + this.textEndPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r5.left = r4.left + r0;
        float r3 = r4.right - r1;
    L8:
        r5.right = r3;
        r5.top = r4.top;
        r5.bottom = r4.bottom;
        return;
    L7:
        r5.left = r4.left + r1;
        r3 = r4.right - r0;
        goto L8
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.a().getFontMetrics(this.fontMetrics);
        return (this.fontMetrics.descent + this.fontMetrics.ascent) / 2.0f;
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

    public static ChipDrawable createFromAttributes(Context r2, AttributeSet r3, int r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        ChipDrawable r0 = new ChipDrawable(r6, r7, r4, r5);
        r0.loadFromAttributes(r7, r4, r5);
        return r0;
    }

    public static ChipDrawable createFromResource(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = com.google.android.material.d.a.a(r6, r5, "chip");
        int r0 = r7.getStyleAttribute();
        if (r0 != 0) goto L6;
        r0 = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.style.Widget_MaterialComponents_Chip_Entry, "style", "Widget_MaterialComponents_Chip_Entry");
    L6:
        return createFromAttributes(r6, r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.chipStandaloneStyle, "attr", "chipStandaloneStyle"), r0);
    }

    private void drawCheckedIcon(Canvas r6, Rect r7) {
        if (showsCheckedIcon() == false) goto L6;
        calculateChipIconBounds(r7, this.rectF);
        float r8 = this.rectF.left;
        float r0 = this.rectF.top;
        r6.translate(r8, r0);
        this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.checkedIcon.draw(r6);
        r6.translate(-r8, -r0);
        return;
    }

    private void drawChipBackground(Canvas r3, Rect r4) {
        if (this.isShapeThemingEnabled == true) goto L6;
        this.chipPaint.setColor(this.currentChipBackgroundColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.chipPaint.setColorFilter(getTintColorFilter());
        this.rectF.set(r4);
        r3.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    }

    private void drawChipIcon(Canvas r6, Rect r7) {
        if (showsChipIcon() == false) goto L6;
        calculateChipIconBounds(r7, this.rectF);
        float r8 = this.rectF.left;
        float r0 = this.rectF.top;
        r6.translate(r8, r0);
        this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.chipIcon.draw(r6);
        r6.translate(-r8, -r0);
        return;
    }

    private void drawChipStroke(Canvas r7, Rect r8) {
        if (this.chipStrokeWidth > 0.0f) goto L5;
        return;
    L5:
        if (this.isShapeThemingEnabled == true) goto L12;
        this.chipPaint.setColor(this.currentChipStrokeColor);
        this.chipPaint.setStyle(Paint.Style.STROKE);
        if (this.isShapeThemingEnabled == true) goto L9;
        this.chipPaint.setColorFilter(getTintColorFilter());
    L9:
        this.rectF.set(r8.left + (this.chipStrokeWidth / 2.0f), r8.top + (this.chipStrokeWidth / 2.0f), r8.right - (this.chipStrokeWidth / 2.0f), r8.bottom - (this.chipStrokeWidth / 2.0f));
        float r9 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
        r7.drawRoundRect(this.rectF, r9, r9, this.chipPaint);
        return;
    }

    private void drawChipSurface(Canvas r3, Rect r4) {
        if (this.isShapeThemingEnabled == true) goto L6;
        this.chipPaint.setColor(this.currentChipSurfaceColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(r4);
        r3.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    }

    private void drawCloseIcon(Canvas r6, Rect r7) {
        if (showsCloseIcon() == false) goto L10;
        calculateCloseIconBounds(r7, this.rectF);
        float r8 = this.rectF.left;
        float r0 = this.rectF.top;
        r6.translate(r8, r0);
        this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        if (com.google.android.material.ripple.a.f4033a == false) goto L7;
        this.closeIconRipple.setBounds(this.closeIcon.getBounds());
        this.closeIconRipple.jumpToCurrentState();
        Drawable r5 = this.closeIconRipple;
    L8:
        r5.draw(r6);
        r6.translate(-r8, -r0);
        return;
    L7:
        r5 = this.closeIcon;
        goto L8
    }

    private void drawCompatRipple(Canvas r3, Rect r4) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(r4);
        if (this.isShapeThemingEnabled == true) goto L5;
        r3.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        return;
    L5:
        calculatePathForSize(new RectF(r4), this.shapePath);
        super.drawShape(r3, this.chipPaint, this.shapePath, getBoundsAsRectF());
    }

    private void drawDebug(Canvas r10, Rect r11) {
        Paint r0 = this.debugPaint;
        if (r0 == null) goto L17;
        r0.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
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

    private void drawText(Canvas r10, Rect r11) {
        if (this.text == null) goto L22;
        Paint.Align r0 = calculateTextOriginAndAlignment(r11, this.pointF);
        calculateTextBounds(r11, this.rectF);
        if (this.textDrawableHelper.b() == null) goto L7;
        this.textDrawableHelper.a().drawableState = getState();
        this.textDrawableHelper.a(this.context);
    L7:
        this.textDrawableHelper.a().setTextAlign(r0);
        int r1 = 0;
        if (Math.round(this.textDrawableHelper.a(getText().toString())) <= Math.round(this.rectF.width())) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == false) goto L13;
        r1 = r10.save();
        r10.clipRect(this.rectF);
    L13:
        CharSequence r2 = this.text;
        if (r12 == true) goto L16;
    L18:
        CharSequence r3 = r2;
        r10.drawText(r3, 0, r3.length(), this.pointF.x, this.pointF.y, this.textDrawableHelper.a());
        if (r12 == false) goto L23;
        r10.restoreToCount(r1);
        return;
    L23:
        return;
    L16:
        if (this.truncateAt == null) goto L18;
        r2 = TextUtils.ellipsize(r2, this.textDrawableHelper.a(), this.rectF.width(), this.truncateAt);
        goto L18
    L10:
        r12 = false;
        goto L11
    }

    private float getCurrentChipIconHeight() {
        if (this.currentChecked == false) goto L5;
        Drawable r0 = this.checkedIcon;
    L6:
        float r1 = this.chipIconSize;
        if (r1 > 0.0f) goto L13;
        if (r0 == null) goto L13;
        float r3 = (float) Math.ceil(r.a(this.context, 24));
        if (r0.getIntrinsicHeight() <= r3) goto L12;
        return r3;
    L12:
        return r0.getIntrinsicHeight();
    L13:
        return r1;
    L5:
        r0 = this.chipIcon;
        goto L6
    }

    private float getCurrentChipIconWidth() {
        if (this.currentChecked == false) goto L5;
        Drawable r0 = this.checkedIcon;
    L6:
        float r2 = this.chipIconSize;
        if (r2 > 0.0f) goto L11;
        if (r0 != null) goto L10;
        return r2;
    L10:
        return r0.getIntrinsicWidth();
    L11:
        return r2;
    L5:
        r0 = this.chipIcon;
        goto L6
    }

    private ColorFilter getTintColorFilter() {
        ColorFilter r0 = this.colorFilter;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.tintFilter;
    }

    private static boolean hasState(int[] r4, int r5) {
        if (r4 != null) goto L5;
        return false;
    L5:
        int r1 = r4.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (r4[r2] == r5) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static boolean isStateful(ColorStateList r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.isStateful() == false) goto L6;
        return true;
    }

    private static boolean isStateful(Drawable r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.isStateful() == false) goto L6;
        return true;
    }

    private static boolean isStateful(d r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.b() == null) goto L8;
        if (r1.b().isStateful() == false) goto L8;
        return true;
    }

    private void loadFromAttributes(AttributeSet r8, int r9, int r10) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r12 = k.a(this.context, r11, com.obric.memorydata.plugin.R.styleable.Chip, r9, r10, new int[0]);
        this.isShapeThemingEnabled = r12.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_shapeAppearance, "styleable", "Chip_shapeAppearance"));
        setChipSurfaceColor(c.a(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipSurfaceColor, "styleable", "Chip_chipSurfaceColor")));
        setChipBackgroundColor(c.a(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipBackgroundColor, "styleable", "Chip_chipBackgroundColor")));
        setChipMinHeight(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipMinHeight, "styleable", "Chip_chipMinHeight"), 0.0f));
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipCornerRadius, "styleable", "Chip_chipCornerRadius")) == false) goto L5;
        setChipCornerRadius(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipCornerRadius, "styleable", "Chip_chipCornerRadius"), 0.0f));
    L5:
        setChipStrokeColor(c.a(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipStrokeColor, "styleable", "Chip_chipStrokeColor")));
        setChipStrokeWidth(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipStrokeWidth, "styleable", "Chip_chipStrokeWidth"), 0.0f));
        setRippleColor(c.a(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_rippleColor, "styleable", "Chip_rippleColor")));
        setText(r12.getText(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_android_text, "styleable", "Chip_android_text")));
        d r13 = c.c(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_android_textAppearance, "styleable", "Chip_android_textAppearance"));
        r13.a(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_android_textSize, "styleable", "Chip_android_textSize"), r13.c()));
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        r13.a(c.a(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_android_textColor, "styleable", "Chip_android_textColor")));
    L8:
        setTextAppearance(r13);
        int r14 = r12.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_android_ellipsize, "styleable", "Chip_android_ellipsize"), 0);
        if (r14 != 1) goto L11;
        TextUtils.TruncateAt r15 = TextUtils.TruncateAt.START;
    L18:
        setEllipsize(r15);
    L19:
        setChipIconVisible(r12.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipIconVisible, "styleable", "Chip_chipIconVisible"), false));
        if (r11 != null) goto L22;
    L26:
        setChipIcon(c.b(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipIcon, "styleable", "Chip_chipIcon")));
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipIconTint, "styleable", "Chip_chipIconTint")) == false) goto L29;
        setChipIconTint(c.a(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipIconTint, "styleable", "Chip_chipIconTint")));
    L29:
        setChipIconSize(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipIconSize, "styleable", "Chip_chipIconSize"), -1.0f));
        setCloseIconVisible(r12.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_closeIconVisible, "styleable", "Chip_closeIconVisible"), false));
        if (r11 != null) goto L32;
    L36:
        setCloseIcon(c.b(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_closeIcon, "styleable", "Chip_closeIcon")));
        setCloseIconTint(c.a(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_closeIconTint, "styleable", "Chip_closeIconTint")));
        setCloseIconSize(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_closeIconSize, "styleable", "Chip_closeIconSize"), 0.0f));
        setCheckable(r12.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_android_checkable, "styleable", "Chip_android_checkable"), false));
        setCheckedIconVisible(r12.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_checkedIconVisible, "styleable", "Chip_checkedIconVisible"), false));
        if (r11 != null) goto L39;
    L43:
        setCheckedIcon(c.b(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_checkedIcon, "styleable", "Chip_checkedIcon")));
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_checkedIconTint, "styleable", "Chip_checkedIconTint")) == false) goto L46;
        setCheckedIconTint(c.a(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_checkedIconTint, "styleable", "Chip_checkedIconTint")));
    L46:
        setShowMotionSpec(h.a(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_showMotionSpec, "styleable", "Chip_showMotionSpec")));
        setHideMotionSpec(h.a(this.context, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_hideMotionSpec, "styleable", "Chip_hideMotionSpec")));
        setChipStartPadding(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipStartPadding, "styleable", "Chip_chipStartPadding"), 0.0f));
        setIconStartPadding(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_iconStartPadding, "styleable", "Chip_iconStartPadding"), 0.0f));
        setIconEndPadding(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_iconEndPadding, "styleable", "Chip_iconEndPadding"), 0.0f));
        setTextStartPadding(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_textStartPadding, "styleable", "Chip_textStartPadding"), 0.0f));
        setTextEndPadding(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_textEndPadding, "styleable", "Chip_textEndPadding"), 0.0f));
        setCloseIconStartPadding(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_closeIconStartPadding, "styleable", "Chip_closeIconStartPadding"), 0.0f));
        setCloseIconEndPadding(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_closeIconEndPadding, "styleable", "Chip_closeIconEndPadding"), 0.0f));
        setChipEndPadding(r12.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipEndPadding, "styleable", "Chip_chipEndPadding"), 0.0f));
        setMaxWidth(r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_android_maxWidth, "styleable", "Chip_android_maxWidth"), Integer.MAX_VALUE));
        r12.recycle();
        return;
    L39:
        if (r11.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") == null) goto L43;
        if (r11.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") != null) goto L43;
        setCheckedIconVisible(r12.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_checkedIconEnabled, "styleable", "Chip_checkedIconEnabled"), false));
        goto L43
    L32:
        if (r11.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") == null) goto L36;
        if (r11.getAttributeValue(NAMESPACE_APP, "closeIconVisible") != null) goto L36;
        setCloseIconVisible(r12.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_closeIconEnabled, "styleable", "Chip_closeIconEnabled"), false));
        goto L36
    L22:
        if (r11.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") == null) goto L26;
        if (r11.getAttributeValue(NAMESPACE_APP, "chipIconVisible") != null) goto L26;
        setChipIconVisible(r12.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.Chip_chipIconEnabled, "styleable", "Chip_chipIconEnabled"), false));
        goto L26
    L11:
        if (r14 != 2) goto L13;
        r15 = TextUtils.TruncateAt.MIDDLE;
        goto L18
    L13:
        if (r14 != 3) goto L19;
        r15 = TextUtils.TruncateAt.END;
        goto L18
    }

    private boolean onStateChange(int[] r7, int[] r8) {
        boolean r0 = super.onStateChange(r7);
        ColorStateList r1 = this.chipSurfaceColor;
        if (r1 == null) goto L5;
        int r2 = r1.getColorForState(r7, this.currentChipSurfaceColor);
    L6:
        int r3 = compositeElevationOverlayIfNeeded(r2);
        boolean r4 = true;
        if (this.currentChipSurfaceColor == r3) goto L9;
        this.currentChipSurfaceColor = r3;
        r0 = true;
    L9:
        ColorStateList r5 = this.chipBackgroundColor;
        if (r5 == null) goto L12;
        int r6 = r5.getColorForState(r7, this.currentChipBackgroundColor);
    L13:
        int r9 = compositeElevationOverlayIfNeeded(r6);
        if (this.currentChipBackgroundColor == r9) goto L16;
        this.currentChipBackgroundColor = r9;
        r0 = true;
    L16:
        int r10 = com.google.android.material.c.a.a(r3, r9);
        if (this.currentCompositeSurfaceBackgroundColor == r10) goto L19;
        boolean r11 = true;
    L21:
        if (getFillColor() != null) goto L23;
        boolean r12 = true;
    L25:
        if ((r11 | r12) == false) goto L27;
        this.currentCompositeSurfaceBackgroundColor = r10;
        setFillColor(ColorStateList.valueOf(r10));
        r0 = true;
    L27:
        ColorStateList r13 = this.chipStrokeColor;
        if (r13 == null) goto L30;
        int r14 = r13.getColorForState(r7, this.currentChipStrokeColor);
    L32:
        if (this.currentChipStrokeColor == r14) goto L35;
        this.currentChipStrokeColor = r14;
        r0 = true;
    L35:
        if (this.compatRippleColor != null) goto L37;
    L39:
        int r15 = 0;
    L41:
        if (this.currentCompatRippleColor == r15) goto L46;
        this.currentCompatRippleColor = r15;
        if (this.useCompatRipple == false) goto L46;
        r0 = true;
    L46:
        if (this.textDrawableHelper.b() != null) goto L48;
    L50:
        int r16 = 0;
    L52:
        if (this.currentTextColor == r16) goto L55;
        this.currentTextColor = r16;
        r0 = true;
    L55:
        if (hasState(getState(), R.attr.state_checked) == true) goto L57;
    L59:
        boolean r17 = false;
    L61:
        if (this.currentChecked != r17) goto L63;
    L68:
        boolean r18 = false;
    L69:
        ColorStateList r19 = this.tint;
        if (r19 == null) goto L72;
        int r20 = r19.getColorForState(r7, this.currentTint);
    L74:
        if (this.currentTint == r20) goto L76;
        this.currentTint = r20;
        this.tintFilter = com.google.android.material.d.a.a(this, this.tint, this.tintMode);
    L78:
        if (isStateful(this.chipIcon) == false) goto L81;
        r4 = r4 | this.chipIcon.setState(r7);
    L81:
        if (isStateful(this.checkedIcon) == false) goto L84;
        r4 = r4 | this.checkedIcon.setState(r7);
    L84:
        if (isStateful(this.closeIcon) == false) goto L87;
        int[] r21 = new int[r7.length + r8.length];
        System.arraycopy(r7, 0, r21, 0, r7.length);
        System.arraycopy(r8, 0, r21, r7.length, r8.length);
        r4 = r4 | this.closeIcon.setState(r21);
    L87:
        if (com.google.android.material.ripple.a.f4033a == true) goto L89;
    L91:
        if (r4 == false) goto L93;
        invalidateSelf();
    L93:
        if (r18 == false) goto L95;
        onSizeChange();
    L95:
        return r4;
    L89:
        if (isStateful(this.closeIconRipple) == false) goto L91;
        r4 = r4 | this.closeIconRipple.setState(r8);
        goto L91
    L76:
        r4 = r0;
        goto L78
    L72:
        r20 = 0;
        goto L74
    L63:
        if (this.checkedIcon == null) goto L68;
        float r22 = calculateChipIconWidth();
        this.currentChecked = r17;
        if (r22 == calculateChipIconWidth()) goto L67;
        r0 = true;
        r18 = true;
        goto L69
    L67:
        r18 = false;
        r0 = true;
        goto L69
    L57:
        if (this.checkable == false) goto L59;
        r17 = true;
        goto L61
    L48:
        if (this.textDrawableHelper.b().b() == null) goto L50;
        r16 = this.textDrawableHelper.b().b().getColorForState(r7, this.currentTextColor);
        goto L52
    L37:
        if (com.google.android.material.ripple.a.a(r7) == false) goto L39;
        r15 = this.compatRippleColor.getColorForState(r7, this.currentCompatRippleColor);
        goto L41
    L30:
        r14 = 0;
        goto L32
    L23:
        r12 = false;
        goto L25
    L19:
        r11 = false;
        goto L21
    L12:
        r6 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    private void setChipSurfaceColor(ColorStateList r2) {
        if (this.chipSurfaceColor == r2) goto L6;
        this.chipSurfaceColor = r2;
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

    private void unapplyChildDrawable(Drawable r1) {
        if (r1 == null) goto L5;
        r1.setCallback(null);
        return;
    }

    private void updateCompatRippleColor() {
        if (this.useCompatRipple == false) goto L5;
        ColorStateList r0 = com.google.android.material.ripple.a.b(this.rippleColor);
    L6:
        this.compatRippleColor = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void updateFrameworkCloseIconRipple() {
        this.closeIconRipple = new RippleDrawable(com.google.android.material.ripple.a.b(getRippleColor()), this.closeIcon, closeIconRippleMask);
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

    Paint.Align calculateTextOriginAndAlignment(Rect r3, PointF r4) {
        r4.set(0.0f, 0.0f);
        Paint.Align r0 = Paint.Align.LEFT;
        if (this.text == null) goto L9;
        float r1 = (this.chipStartPadding + calculateChipIconWidth()) + this.textStartPadding;
        if (DrawableCompat.getLayoutDirection(this) != 0) goto L7;
        r4.x = r3.left + r1;
        r0 = Paint.Align.LEFT;
    L8:
        r4.y = r3.centerY() - calculateTextCenterFromBaseline();
        goto L9
    L7:
        r4.x = r3.right - r1;
        r0 = Paint.Align.RIGHT;
    L9:
        return r0;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r11) {
        Rect r0 = getBounds();
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() == 0) goto L22;
        int r1 = 0;
        if (this.alpha >= 255) goto L10;
        r1 = com.google.android.material.b.a.a(r11, r0.left, r0.top, r0.right, r0.bottom, this.alpha);
    L10:
        drawChipSurface(r11, r0);
        drawChipBackground(r11, r0);
        if (this.isShapeThemingEnabled == false) goto L13;
        super.draw(r11);
    L13:
        drawChipStroke(r11, r0);
        drawCompatRipple(r11, r0);
        drawChipIcon(r11, r0);
        drawCheckedIcon(r11, r0);
        if (this.shouldDrawText == false) goto L16;
        drawText(r11, r0);
    L16:
        drawCloseIcon(r11, r0);
        drawDebug(r11, r0);
        if (this.alpha >= 255) goto L21;
        r11.restoreToCount(r1);
        return;
    L21:
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

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

    public Drawable getChipIcon() {
        Drawable r0 = this.chipIcon;
        if (r0 != null) goto L7;
        return null;
    L7:
        return DrawableCompat.unwrap(r0);
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    public ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    public ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public void getChipTouchBounds(RectF r2) {
        calculateChipTouchBounds(getBounds(), r2);
    }

    public Drawable getCloseIcon() {
        Drawable r0 = this.closeIcon;
        if (r0 != null) goto L7;
        return null;
    L7:
        return DrawableCompat.unwrap(r0);
    }

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

    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    public ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    public void getCloseIconTouchBounds(RectF r2) {
        calculateCloseIconTouchBounds(getBounds(), r2);
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.truncateAt;
    }

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
        return Math.min(Math.round((((((this.chipStartPadding + calculateChipIconWidth()) + this.textStartPadding) + this.textDrawableHelper.a(getText().toString())) + this.textEndPadding) + calculateCloseIconWidth()) + this.chipEndPadding), this.maxWidth);
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void getOutline(Outline r9) {
        if (this.isShapeThemingEnabled == false) goto L6;
        super.getOutline(r9);
        return;
    L6:
        Rect r0 = getBounds();
        if (r0.isEmpty() == true) goto L9;
        r9.setRoundRect(r0, this.chipCornerRadius);
    L10:
        r9.setAlpha(getAlpha() / 255.0f);
        return;
    L9:
        r9.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
        goto L10
    }

    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public h getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public CharSequence getText() {
        return this.text;
    }

    public d getTextAppearance() {
        return this.textDrawableHelper.b();
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
    public void invalidateDrawable(Drawable r1) {
        Drawable.Callback r2 = getCallback();
        if (r2 == null) goto L6;
        r2.invalidateDrawable(this);
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
        if (isStateful(this.textDrawableHelper.b()) == true) goto L24;
        if (canShowCheckedIcon() == true) goto L24;
        if (isStateful(this.chipIcon) == true) goto L24;
        if (isStateful(this.checkedIcon) == true) goto L24;
        if (isStateful(this.tint) == true) goto L24;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int r3) {
        boolean r0 = super.onLayoutDirectionChanged(r3);
        if (showsChipIcon() == false) goto L6;
        r0 = r0 | DrawableCompat.setLayoutDirection(this.chipIcon, r3);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r0 = r0 | DrawableCompat.setLayoutDirection(this.checkedIcon, r3);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r0 = r0 | DrawableCompat.setLayoutDirection(this.closeIcon, r3);
    L11:
        if (r0 == false) goto L15;
        invalidateSelf();
        return true;
    L15:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r3) {
        boolean r0 = super.onLevelChange(r3);
        if (showsChipIcon() == false) goto L6;
        r0 = r0 | this.chipIcon.setLevel(r3);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r0 = r0 | this.checkedIcon.setLevel(r3);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r0 = r0 | this.closeIcon.setLevel(r3);
    L11:
        if (r0 == false) goto L13;
        invalidateSelf();
    L13:
        return r0;
    }

    public void onSizeChange() {
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.delegate.get(), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.onChipDrawableSizeChange();
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.i.a
    public boolean onStateChange(int[] r2) {
        if (this.isShapeThemingEnabled == false) goto L6;
        super.onStateChange(r2);
    L6:
        return onStateChange(r2, getCloseIconState());
    }

    @Override // com.google.android.material.internal.i.a
    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r2, Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Drawable.Callback r6 = getCallback();
        if (r6 == null) goto L6;
        r6.scheduleDrawable(this, r5, r4);
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (this.alpha == r2) goto L6;
        this.alpha = r2;
        invalidateSelf();
        return;
    }

    public void setCheckable(boolean r2) {
        if (this.checkable == r2) goto L13;
        this.checkable = r2;
        float r0 = calculateChipIconWidth();
        if (r2 == false) goto L7;
    L9:
        float r3 = calculateChipIconWidth();
        invalidateSelf();
        if (r0 == r3) goto L14;
        onSizeChange();
        return;
    L14:
        return;
    L7:
        if (this.currentChecked == false) goto L9;
        this.currentChecked = false;
        goto L9
    }

    public void setCheckableResource(int r3) {
        setCheckable(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getBoolean(r3));
    }

    public void setCheckedIcon(Drawable r3) {
        if (this.checkedIcon == r3) goto L8;
        float r0 = calculateChipIconWidth();
        this.checkedIcon = r3;
        float r4 = calculateChipIconWidth();
        unapplyChildDrawable(this.checkedIcon);
        applyChildDrawable(this.checkedIcon);
        invalidateSelf();
        if (r0 == r4) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean r1) {
        setCheckedIconVisible(r1);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int r3) {
        setCheckedIconVisible(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getBoolean(r3));
    }

    public void setCheckedIconResource(int r2) {
        setCheckedIcon(AppCompatResources.getDrawable(this.context, r2));
    }

    public void setCheckedIconTint(ColorStateList r2) {
        if (this.checkedIconTint == r2) goto L9;
        this.checkedIconTint = r2;
        if (canShowCheckedIcon() == false) goto L7;
        DrawableCompat.setTintList(this.checkedIcon, r2);
    L7:
        onStateChange(getState());
        return;
    }

    public void setCheckedIconTintResource(int r2) {
        setCheckedIconTint(AppCompatResources.getColorStateList(this.context, r2));
    }

    public void setCheckedIconVisible(int r3) {
        setCheckedIconVisible(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getBoolean(r3));
    }

    public void setCheckedIconVisible(boolean r2) {
        if (this.checkedIconVisible == r2) goto L14;
        boolean r0 = showsCheckedIcon();
        this.checkedIconVisible = r2;
        boolean r3 = showsCheckedIcon();
        if (r0 == r3) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L15;
        if (r3 == false) goto L11;
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
        r1 = false;
        goto L8
    }

    public void setChipBackgroundColor(ColorStateList r2) {
        if (this.chipBackgroundColor == r2) goto L6;
        this.chipBackgroundColor = r2;
        onStateChange(getState());
        return;
    }

    public void setChipBackgroundColorResource(int r2) {
        setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, r2));
    }

    @Deprecated
    public void setChipCornerRadius(float r2) {
        if (this.chipCornerRadius == r2) goto L6;
        this.chipCornerRadius = r2;
        setShapeAppearanceModel(getShapeAppearanceModel().a(r2));
        return;
    }

    @Deprecated
    public void setChipCornerRadiusResource(int r3) {
        setChipCornerRadius(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public void setChipEndPadding(float r2) {
        if (this.chipEndPadding == r2) goto L6;
        this.chipEndPadding = r2;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipEndPaddingResource(int r3) {
        setChipEndPadding(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public void setChipIcon(Drawable r3) {
        Drawable r0 = getChipIcon();
        if (r0 == r3) goto L15;
        float r1 = calculateChipIconWidth();
        if (r3 == null) goto L7;
        Drawable r4 = DrawableCompat.wrap(r3).mutate();
    L8:
        this.chipIcon = r4;
        float r5 = calculateChipIconWidth();
        unapplyChildDrawable(r0);
        if (showsChipIcon() == false) goto L11;
        applyChildDrawable(this.chipIcon);
    L11:
        invalidateSelf();
        if (r1 == r5) goto L16;
        onSizeChange();
        return;
    L16:
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Deprecated
    public void setChipIconEnabled(boolean r1) {
        setChipIconVisible(r1);
    }

    @Deprecated
    public void setChipIconEnabledResource(int r1) {
        setChipIconVisible(r1);
    }

    public void setChipIconResource(int r2) {
        setChipIcon(AppCompatResources.getDrawable(this.context, r2));
    }

    public void setChipIconSize(float r2) {
        if (this.chipIconSize == r2) goto L8;
        float r0 = calculateChipIconWidth();
        this.chipIconSize = r2;
        float r3 = calculateChipIconWidth();
        invalidateSelf();
        if (r0 == r3) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setChipIconSizeResource(int r3) {
        setChipIconSize(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public void setChipIconTint(ColorStateList r2) {
        this.hasChipIconTint = true;
        if (this.chipIconTint == r2) goto L9;
        this.chipIconTint = r2;
        if (showsChipIcon() == false) goto L7;
        DrawableCompat.setTintList(this.chipIcon, r2);
    L7:
        onStateChange(getState());
        return;
    }

    public void setChipIconTintResource(int r2) {
        setChipIconTint(AppCompatResources.getColorStateList(this.context, r2));
    }

    public void setChipIconVisible(int r3) {
        setChipIconVisible(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getBoolean(r3));
    }

    public void setChipIconVisible(boolean r2) {
        if (this.chipIconVisible == r2) goto L14;
        boolean r0 = showsChipIcon();
        this.chipIconVisible = r2;
        boolean r3 = showsChipIcon();
        if (r0 == r3) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L15;
        if (r3 == false) goto L11;
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
        r1 = false;
        goto L8
    }

    public void setChipMinHeight(float r2) {
        if (this.chipMinHeight == r2) goto L6;
        this.chipMinHeight = r2;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipMinHeightResource(int r3) {
        setChipMinHeight(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public void setChipStartPadding(float r2) {
        if (this.chipStartPadding == r2) goto L6;
        this.chipStartPadding = r2;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setChipStartPaddingResource(int r3) {
        setChipStartPadding(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public void setChipStrokeColor(ColorStateList r2) {
        if (this.chipStrokeColor == r2) goto L9;
        this.chipStrokeColor = r2;
        if (this.isShapeThemingEnabled == false) goto L7;
        setStrokeColor(r2);
    L7:
        onStateChange(getState());
        return;
    }

    public void setChipStrokeColorResource(int r2) {
        setChipStrokeColor(AppCompatResources.getColorStateList(this.context, r2));
    }

    public void setChipStrokeWidth(float r2) {
        if (this.chipStrokeWidth == r2) goto L9;
        this.chipStrokeWidth = r2;
        this.chipPaint.setStrokeWidth(r2);
        if (this.isShapeThemingEnabled == false) goto L7;
        super.setStrokeWidth(r2);
    L7:
        invalidateSelf();
        return;
    }

    public void setChipStrokeWidthResource(int r3) {
        setChipStrokeWidth(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public void setCloseIcon(Drawable r3) {
        Drawable r0 = getCloseIcon();
        if (r0 == r3) goto L18;
        float r1 = calculateCloseIconWidth();
        if (r3 == null) goto L7;
        Drawable r4 = DrawableCompat.wrap(r3).mutate();
    L8:
        this.closeIcon = r4;
        if (com.google.android.material.ripple.a.f4033a == false) goto L11;
        updateFrameworkCloseIconRipple();
    L11:
        float r5 = calculateCloseIconWidth();
        unapplyChildDrawable(r0);
        if (showsCloseIcon() == false) goto L14;
        applyChildDrawable(this.closeIcon);
    L14:
        invalidateSelf();
        if (r1 == r5) goto L19;
        onSizeChange();
        return;
    L19:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public void setCloseIconContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.closeIconContentDescription == r4) goto L6;
        this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(r4);
        invalidateSelf();
        return;
    }

    @Deprecated
    public void setCloseIconEnabled(boolean r1) {
        setCloseIconVisible(r1);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int r1) {
        setCloseIconVisible(r1);
    }

    public void setCloseIconEndPadding(float r2) {
        if (this.closeIconEndPadding == r2) goto L8;
        this.closeIconEndPadding = r2;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconEndPaddingResource(int r3) {
        setCloseIconEndPadding(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public void setCloseIconResource(int r2) {
        setCloseIcon(AppCompatResources.getDrawable(this.context, r2));
    }

    public void setCloseIconSize(float r2) {
        if (this.closeIconSize == r2) goto L8;
        this.closeIconSize = r2;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconSizeResource(int r3) {
        setCloseIconSize(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public void setCloseIconStartPadding(float r2) {
        if (this.closeIconStartPadding == r2) goto L8;
        this.closeIconStartPadding = r2;
        invalidateSelf();
        if (showsCloseIcon() == false) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setCloseIconStartPaddingResource(int r3) {
        setCloseIconStartPadding(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public boolean setCloseIconState(int[] r2) {
        if (Arrays.equals(this.closeIconStateSet, r2) == true) goto L8;
        this.closeIconStateSet = r2;
        if (showsCloseIcon() == true) goto L7;
        return false;
    L7:
        return onStateChange(getState(), r2);
    L8:
        return false;
    }

    public void setCloseIconTint(ColorStateList r2) {
        if (this.closeIconTint == r2) goto L9;
        this.closeIconTint = r2;
        if (showsCloseIcon() == false) goto L7;
        DrawableCompat.setTintList(this.closeIcon, r2);
    L7:
        onStateChange(getState());
        return;
    }

    public void setCloseIconTintResource(int r2) {
        setCloseIconTint(AppCompatResources.getColorStateList(this.context, r2));
    }

    public void setCloseIconVisible(int r3) {
        setCloseIconVisible(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getBoolean(r3));
    }

    public void setCloseIconVisible(boolean r2) {
        if (this.closeIconVisible == r2) goto L14;
        boolean r0 = showsCloseIcon();
        this.closeIconVisible = r2;
        boolean r3 = showsCloseIcon();
        if (r0 == r3) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L15;
        if (r3 == false) goto L11;
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
        r1 = false;
        goto L8
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        if (this.colorFilter == r2) goto L6;
        this.colorFilter = r2;
        invalidateSelf();
        return;
    }

    public void setDelegate(a r3) {
        this.delegate = new WeakReference((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"));
    }

    public void setEllipsize(TextUtils.TruncateAt r1) {
        this.truncateAt = r1;
    }

    public void setHideMotionSpec(h r1) {
        this.hideMotionSpec = r1;
    }

    public void setHideMotionSpecResource(int r2) {
        setHideMotionSpec(h.a(this.context, r2));
    }

    public void setIconEndPadding(float r2) {
        if (this.iconEndPadding == r2) goto L8;
        float r0 = calculateChipIconWidth();
        this.iconEndPadding = r2;
        float r3 = calculateChipIconWidth();
        invalidateSelf();
        if (r0 == r3) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setIconEndPaddingResource(int r3) {
        setIconEndPadding(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public void setIconStartPadding(float r2) {
        if (this.iconStartPadding == r2) goto L8;
        float r0 = calculateChipIconWidth();
        this.iconStartPadding = r2;
        float r3 = calculateChipIconWidth();
        invalidateSelf();
        if (r0 == r3) goto L9;
        onSizeChange();
        return;
    L9:
        return;
    }

    public void setIconStartPaddingResource(int r3) {
        setIconStartPadding(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public void setMaxWidth(int r1) {
        this.maxWidth = r1;
    }

    public void setRippleColor(ColorStateList r2) {
        if (this.rippleColor == r2) goto L6;
        this.rippleColor = r2;
        updateCompatRippleColor();
        onStateChange(getState());
        return;
    }

    public void setRippleColorResource(int r2) {
        setRippleColor(AppCompatResources.getColorStateList(this.context, r2));
    }

    void setShouldDrawText(boolean r1) {
        this.shouldDrawText = r1;
    }

    public void setShowMotionSpec(h r1) {
        this.showMotionSpec = r1;
    }

    public void setShowMotionSpecResource(int r2) {
        setShowMotionSpec(h.a(this.context, r2));
    }

    public void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        if (TextUtils.equals(this.text, r4) == true) goto L9;
        this.text = r4;
        this.textDrawableHelper.a(true);
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextAppearance(d r2) {
        this.textDrawableHelper.a(r2, this.context);
    }

    public void setTextAppearanceResource(int r3) {
        setTextAppearance(new d(this.context, r3));
    }

    public void setTextColor(int r1) {
        setTextColor(ColorStateList.valueOf(r1));
    }

    public void setTextColor(ColorStateList r2) {
        d r0 = getTextAppearance();
        if (r0 == null) goto L6;
        r0.a(r2);
        invalidateSelf();
        return;
    }

    public void setTextEndPadding(float r2) {
        if (this.textEndPadding == r2) goto L6;
        this.textEndPadding = r2;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextEndPaddingResource(int r3) {
        setTextEndPadding(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    public void setTextResource(int r3) {
        setText(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getString(r3));
    }

    public void setTextSize(float r2) {
        d r0 = getTextAppearance();
        if (r0 == null) goto L6;
        r0.a(r2);
        this.textDrawableHelper.a().setTextSize(r2);
        onTextSizeChange();
        return;
    }

    public void setTextStartPadding(float r2) {
        if (this.textStartPadding == r2) goto L6;
        this.textStartPadding = r2;
        invalidateSelf();
        onSizeChange();
        return;
    }

    public void setTextStartPaddingResource(int r3) {
        setTextStartPadding(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimension(r3));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r2) {
        if (this.tint == r2) goto L6;
        this.tint = r2;
        onStateChange(getState());
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r2) {
        if (this.tintMode == r2) goto L6;
        this.tintMode = r2;
        this.tintFilter = com.google.android.material.d.a.a(this, this.tint, r2);
        invalidateSelf();
        return;
    }

    public void setUseCompatRipple(boolean r2) {
        if (this.useCompatRipple == r2) goto L6;
        this.useCompatRipple = r2;
        updateCompatRippleColor();
        onStateChange(getState());
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r3, boolean r4) {
        boolean r0 = super.setVisible(r3, r4);
        if (showsChipIcon() == false) goto L6;
        r0 = r0 | this.chipIcon.setVisible(r3, r4);
    L6:
        if (showsCheckedIcon() == false) goto L9;
        r0 = r0 | this.checkedIcon.setVisible(r3, r4);
    L9:
        if (showsCloseIcon() == false) goto L11;
        r0 = r0 | this.closeIcon.setVisible(r3, r4);
    L11:
        if (r0 == false) goto L13;
        invalidateSelf();
    L13:
        return r0;
    }

    boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Drawable.Callback r5 = getCallback();
        if (r5 == null) goto L6;
        r5.unscheduleDrawable(this, r4);
        return;
    }
}
