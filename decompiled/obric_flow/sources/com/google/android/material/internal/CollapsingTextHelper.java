package com.google.android.material.internal;

import ai.j0;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TypefaceUtils;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;

    @NonNull
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final String TAG = "CollapsingTextHelper";
    private static final boolean USE_SCALING_TEXTURE = false;
    private boolean boundsChanged;

    @NonNull
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private float collapsedLetterSpacing;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private int collapsedTextGravity;
    private float collapsedTextSize;
    private float collapsedTextWidth;
    private Typeface collapsedTypeface;
    private Typeface collapsedTypefaceBold;
    private Typeface collapsedTypefaceDefault;

    @NonNull
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentLetterSpacing;
    private int currentOffsetY;
    private int currentShadowColor;
    private float currentShadowDx;
    private float currentShadowDy;
    private float currentShadowRadius;
    private float currentTextSize;
    private Typeface currentTypeface;

    @NonNull
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private int expandedLineCount;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity;
    private float expandedTextSize;

    @Nullable
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private Typeface expandedTypefaceBold;
    private Typeface expandedTypefaceDefault;
    private boolean fadeModeEnabled;
    private float fadeModeStartFraction;
    private float fadeModeThresholdFraction;
    private int hyphenationFrequency;
    private boolean isRtl;
    private boolean isRtlTextDirectionHeuristicsEnabled;
    private float lineSpacingAdd;
    private float lineSpacingMultiplier;
    private int maxLines;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;

    @Nullable
    private StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer;

    @Nullable
    private CharSequence text;
    private StaticLayout textLayout;

    @NonNull
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;

    @Nullable
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;
    private TextUtils.TruncateAt titleTextEllipsize;

    @NonNull
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    static {
        USE_SCALING_TEXTURE = false;
        DEBUG_DRAW_PAINT = null;
    }

    public CollapsingTextHelper(View r5) {
        this.expandedTextGravity = 16;
        this.collapsedTextGravity = 16;
        this.expandedTextSize = 15.0f;
        this.collapsedTextSize = 15.0f;
        this.titleTextEllipsize = TextUtils.TruncateAt.END;
        this.isRtlTextDirectionHeuristicsEnabled = true;
        this.maxLines = 1;
        this.lineSpacingAdd = 0.0f;
        this.lineSpacingMultiplier = 1.0f;
        this.hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
        this.view = r5;
        TextPaint r10 = new TextPaint(129);
        this.textPaint = r10;
        this.tmpPaint = new TextPaint(r10);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
        maybeUpdateFontWeightAdjustment(r5.getContext().getResources().getConfiguration());
    }

    @ColorInt
    private static int blendARGB(@ColorInt int r5, @ColorInt int r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11) {
        float r12 = 1.0f - r11;
        return Color.argb(Math.round((Color.alpha(r10) * r11) + (Color.alpha(r5) * r12)), Math.round((Color.red(r10) * r11) + (Color.red(r5) * r12)), Math.round((Color.green(r10) * r11) + (Color.green(r5) * r12)), Math.round((Color.blue(r10) * r11) + (Color.blue(r5) * r12)));
    }

    private void calculateBaseOffsets(boolean r10) {
        calculateUsingTextSize(1.0f, r10);
        CharSequence r5 = this.textToDraw;
        if (r5 == null) goto L7;
        StaticLayout r11 = this.textLayout;
        if (r11 == null) goto L7;
        this.textToDrawCollapsed = TextUtils.ellipsize(r5, this.textPaint, r11.getWidth(), this.titleTextEllipsize);
    L7:
        CharSequence r12 = this.textToDrawCollapsed;
        float r13 = 0.0f;
        if (r12 == null) goto L10;
        this.collapsedTextWidth = measureTextWidth(this.textPaint, r12);
    L11:
        int r14 = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int r15 = r14 & 112;
        if (r15 == 48) goto L16;
        if (r15 == 80) goto L15;
        this.collapsedDrawY = this.collapsedBounds.centerY() - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
    L17:
        int r16 = r14 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r16 == 1) goto L22;
        if (r16 == 5) goto L21;
        this.collapsedDrawX = this.collapsedBounds.left;
    L23:
        calculateUsingTextSize(0.0f, r10);
        StaticLayout r17 = this.textLayout;
        if (r17 == null) goto L26;
        float r18 = r17.getHeight();
    L27:
        StaticLayout r19 = this.textLayout;
        if (r19 != null) goto L30;
    L32:
        CharSequence r20 = this.textToDraw;
        if (r20 == null) goto L35;
        r13 = measureTextWidth(this.textPaint, r20);
    L35:
        StaticLayout r21 = this.textLayout;
        if (r21 == null) goto L38;
        int r22 = r21.getLineCount();
    L39:
        this.expandedLineCount = r22;
        int r23 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int r24 = r23 & 112;
        if (r24 == 48) goto L44;
        if (r24 == 80) goto L43;
        this.expandedDrawY = this.expandedBounds.centerY() - (r18 / 2.0f);
    L45:
        int r110 = r23 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r110 == 1) goto L50;
        if (r110 == 5) goto L49;
        this.expandedDrawX = this.expandedBounds.left;
    L51:
        clearTexture();
        setInterpolatedTextSize(this.expandedFraction);
        return;
    L49:
        this.expandedDrawX = this.expandedBounds.right - r13;
        goto L51
    L50:
        this.expandedDrawX = this.expandedBounds.centerX() - (r13 / 2.0f);
        goto L51
    L43:
        this.expandedDrawY = this.textPaint.descent() + (this.expandedBounds.bottom - r18);
        goto L45
    L44:
        this.expandedDrawY = this.expandedBounds.top;
        goto L45
    L38:
        r22 = 0;
        goto L39
    L30:
        if (this.maxLines <= 1) goto L32;
        r13 = r19.getWidth();
        goto L35
    L26:
        r18 = 0.0f;
        goto L27
    L21:
        this.collapsedDrawX = this.collapsedBounds.right - this.collapsedTextWidth;
        goto L23
    L22:
        this.collapsedDrawX = this.collapsedBounds.centerX() - (this.collapsedTextWidth / 2.0f);
        goto L23
    L15:
        this.collapsedDrawY = this.textPaint.ascent() + this.collapsedBounds.bottom;
        goto L17
    L16:
        this.collapsedDrawY = this.collapsedBounds.top;
        goto L17
    L10:
        this.collapsedTextWidth = 0.0f;
        goto L11
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private float calculateFadeModeTextAlpha(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        float r10 = this.fadeModeThresholdFraction;
        if (r5 > r10) goto L7;
        return AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, r10, r5);
    L7:
        return AnimationUtils.lerp(0.0f, 1.0f, r10, 1.0f, r5);
    }

    private float calculateFadeModeThresholdFraction() {
        float r5 = this.fadeModeStartFraction;
        return j0.b(1.0f, r5, 0.5f, r5);
    }

    private boolean calculateIsRtl(@NonNull CharSequence r5) {
        boolean r10 = isDefaultIsRtl();
        if (this.isRtlTextDirectionHeuristicsEnabled == true) goto L5;
        return r10;
    L5:
        return isTextDirectionHeuristicsIsRtl(r5, r10);
    }

    private void calculateOffsets(float r10) {
        interpolateBounds(r10);
        if (this.fadeModeEnabled == true) goto L5;
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, r10, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, r10, this.positionInterpolator);
        setInterpolatedTextSize(r10);
        float r5 = r10;
    L9:
        TimeInterpolator r11 = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - r10, r11));
        setExpandedTextBlend(lerp(1.0f, 0.0f, r10, r11));
        if (this.collapsedTextColor == this.expandedTextColor) goto L12;
        this.textPaint.setColor(blendARGB(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), r5));
    L13:
        float r12 = this.collapsedLetterSpacing;
        float r13 = this.expandedLetterSpacing;
        if (r12 == r13) goto L16;
        this.textPaint.setLetterSpacing(lerp(r13, r12, r10, r11));
    L17:
        this.currentShadowRadius = lerp(this.expandedShadowRadius, this.collapsedShadowRadius, r10, null);
        this.currentShadowDx = lerp(this.expandedShadowDx, this.collapsedShadowDx, r10, null);
        this.currentShadowDy = lerp(this.expandedShadowDy, this.collapsedShadowDy, r10, null);
        int r14 = blendARGB(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), r10);
        this.currentShadowColor = r14;
        this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, r14);
        if (this.fadeModeEnabled == false) goto L20;
        this.textPaint.setAlpha((int) (calculateFadeModeTextAlpha(r10) * this.textPaint.getAlpha()));
        TextPaint r15 = this.textPaint;
        r15.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, r15.getAlpha()));
    L20:
        ViewCompat.postInvalidateOnAnimation(this.view);
        return;
    L16:
        this.textPaint.setLetterSpacing(r12);
        goto L17
    L12:
        this.textPaint.setColor(getCurrentCollapsedTextColor());
        goto L13
    L5:
        if (r10 >= this.fadeModeThresholdFraction) goto L7;
        this.currentDrawX = this.expandedDrawX;
        this.currentDrawY = this.expandedDrawY;
        setInterpolatedTextSize(0.0f);
        r5 = 0.0f;
        goto L9
    L7:
        this.currentDrawX = this.collapsedDrawX;
        this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
        setInterpolatedTextSize(1.0f);
        r5 = 1.0f;
        goto L9
    }

    private void calculateUsingTextSize(float r5) {
        calculateUsingTextSize(r5, false);
    }

    private void clearTexture() {
        Bitmap r5 = this.expandedTitleTexture;
        if (r5 == null) goto L6;
        r5.recycle();
        this.expandedTitleTexture = null;
        return;
    }

    private StaticLayout createStaticLayout(int r5, float r10, boolean r11) {
        if (r5 != 1) goto L7;
        Layout.Alignment r12 = Layout.Alignment.ALIGN_NORMAL;     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L5
    L8:
        StaticLayout r13 = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) r10).setEllipsize(this.titleTextEllipsize).setIsRtl(r11).setAlignment(r12).setIncludePad(false).setMaxLines(r5).setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier).setHyphenationFrequency(this.hyphenationFrequency).setStaticLayoutBuilderConfigurer(this.staticLayoutBuilderConfigurer).build();     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L5
    L12:
        return (StaticLayout) Preconditions.checkNotNull(r13);
    L7:
        r12 = getMultilineTextLayoutAlignment();     // Catch: StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException -> L5
    L5:
        e = move-exception;
        Log.e(TAG, e.getCause().getMessage(), e);
        r13 = null;
        goto L12
    }

    private void drawMultilineTransition(@NonNull Canvas r13, float r14, float r15) {
        int r5 = this.textPaint.getAlpha();
        r13.translate(r14, r15);
        if (this.fadeModeEnabled == true) goto L6;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * r5));
        TextPaint r16 = this.textPaint;
        r16.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, r16.getAlpha()));
        this.textLayout.draw(r13);
    L6:
        if (this.fadeModeEnabled == true) goto L8;
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * r5));
    L8:
        TextPaint r17 = this.textPaint;
        r17.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, r17.getAlpha()));
        int r18 = this.textLayout.getLineBaseline(0);
        CharSequence r10 = this.textToDrawCollapsed;
        float r11 = r18;
        r13.drawText(r10, 0, r10.length(), 0.0f, r11, this.textPaint);
        this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, this.currentShadowColor);
        if (this.fadeModeEnabled == true) goto L15;
        String r19 = this.textToDrawCollapsed.toString().trim();
        if (r19.endsWith(ELLIPSIS_NORMAL) == false) goto L13;
        r19 = androidx.constraintlayout.motion.widget.a.n(r19, 1, 0);
    L13:
        String r12 = r19;
        this.textPaint.setAlpha(r5);
        r13.drawText(r12, 0, Math.min(this.textLayout.getLineEnd(0), r12.length()), 0.0f, r11, this.textPaint);
        return;
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture == null) goto L5;
        return;
    L5:
        if (this.expandedBounds.isEmpty() == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.textToDraw) == true) goto L21;
        calculateOffsets(0.0f);
        int r5 = this.textLayout.getWidth();
        int r10 = this.textLayout.getHeight();
        if (r5 <= 0) goto L19;
        if (r10 <= 0) goto L22;
        this.expandedTitleTexture = Bitmap.createBitmap(r5, r10, Bitmap.Config.ARGB_8888);
        Canvas r11 = new Canvas(this.expandedTitleTexture);
        this.textLayout.draw(r11);
        if (this.texturePaint != null) goto L20;
        this.texturePaint = new Paint(3);
        return;
    L20:
        return;
    L22:
        return;
    L19:
        return;
    }

    private float getCollapsedTextLeftBound(int r5, int r10) {
        if (r10 == 17) goto L23;
        if ((r10 & 7) == 1) goto L23;
        if ((r10 & GravityCompat.END) == 8388613) goto L18;
        if ((r10 & 5) == 5) goto L18;
        if (this.isRtl == false) goto L16;
        return this.collapsedBounds.right - this.collapsedTextWidth;
    L16:
        return this.collapsedBounds.left;
    L18:
        if (this.isRtl == false) goto L21;
        return this.collapsedBounds.left;
    L21:
        return this.collapsedBounds.right - this.collapsedTextWidth;
    L23:
        return (r5 / 2.0f) - (this.collapsedTextWidth / 2.0f);
    }

    private float getCollapsedTextRightBound(@NonNull RectF r5, int r10, int r11) {
        if (r11 == 17) goto L23;
        if ((r11 & 7) == 1) goto L23;
        if ((r11 & GravityCompat.END) == 8388613) goto L18;
        if ((r11 & 5) == 5) goto L18;
        if (this.isRtl == false) goto L16;
        return this.collapsedBounds.right;
    L16:
        return this.collapsedTextWidth + r5.left;
    L18:
        if (this.isRtl == false) goto L21;
        return r5.left + this.collapsedTextWidth;
    L21:
        return this.collapsedBounds.right;
    L23:
        return (this.collapsedTextWidth / 2.0f) + (r10 / 2.0f);
    }

    @ColorInt
    private int getCurrentColor(@Nullable ColorStateList r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int[] r10 = this.state;
        if (r10 == null) goto L10;
        return r5.getColorForState(r10, 0);
    L10:
        return r5.getDefaultColor();
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private Layout.Alignment getMultilineTextLayoutAlignment() {
        int r5 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0) & 7;
        if (r5 == 1) goto L17;
        if (r5 == 5) goto L12;
        if (this.isRtl == false) goto L10;
        return Layout.Alignment.ALIGN_OPPOSITE;
    L10:
        return Layout.Alignment.ALIGN_NORMAL;
    L12:
        if (this.isRtl == false) goto L15;
        return Layout.Alignment.ALIGN_NORMAL;
    L15:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L17:
        return Layout.Alignment.ALIGN_CENTER;
    }

    private void getTextPaintCollapsed(@NonNull TextPaint r5) {
        r5.setTextSize(this.collapsedTextSize);
        r5.setTypeface(this.collapsedTypeface);
        r5.setLetterSpacing(this.collapsedLetterSpacing);
    }

    private void getTextPaintExpanded(@NonNull TextPaint r5) {
        r5.setTextSize(this.expandedTextSize);
        r5.setTypeface(this.expandedTypeface);
        r5.setLetterSpacing(this.expandedLetterSpacing);
    }

    private void interpolateBounds(float r5) {
        if (this.fadeModeEnabled == false) goto L9;
        RectF r10 = this.currentBounds;
        if (r5 >= this.fadeModeThresholdFraction) goto L7;
        Rect r11 = this.expandedBounds;
    L8:
        r10.set(r11);
        return;
    L7:
        r11 = this.collapsedBounds;
        goto L8
    L9:
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, r5, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, r5, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, r5, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, r5, this.positionInterpolator);
    }

    private static boolean isClose(float r5, float r10) {
        if (Math.abs(r5 - r10) >= 1.0E-5f) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isDefaultIsRtl() {
        if (ViewCompat.getLayoutDirection(this.view) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isTextDirectionHeuristicsIsRtl(@NonNull CharSequence r5, boolean r10) {
        if (r10 == false) goto L4;
        TextDirectionHeuristicCompat r11 = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    L6:
        return r11.isRtl(r5, 0, r5.length());
    L4:
        r11 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        goto L6
    }

    private static float lerp(float r5, float r10, float r11, @Nullable TimeInterpolator r12) {
        if (r12 == null) goto L5;
        r11 = r12.getInterpolation(r11);
    L5:
        return AnimationUtils.lerp(r5, r10, r11);
    }

    private float measureTextWidth(TextPaint r5, CharSequence r10) {
        return r5.measureText(r10, 0, r10.length());
    }

    private static boolean rectEquals(@NonNull Rect r5, int r10, int r11, int r12, int r13) {
        if (r5.left == r10) goto L5;
    L11:
        return false;
    L5:
        if (r5.top != r11) goto L11;
        if (r5.right != r12) goto L11;
        if (r5.bottom != r13) goto L11;
        return true;
    }

    private void setCollapsedTextBlend(float r5) {
        this.collapsedTextBlend = r5;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setCollapsedTypefaceInternal(Typeface r5) {
        CancelableFontCallback r10 = this.collapsedFontCallback;
        if (r10 == null) goto L6;
        r10.cancel();
    L6:
        if (this.collapsedTypefaceDefault == r5) goto L12;
        this.collapsedTypefaceDefault = r5;
        Typeface r11 = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), r5);
        this.collapsedTypefaceBold = r11;
        if (r11 != null) goto L10;
        r11 = this.collapsedTypefaceDefault;
    L10:
        this.collapsedTypeface = r11;
        return true;
    L12:
        return false;
    }

    private void setExpandedTextBlend(float r5) {
        this.expandedTextBlend = r5;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setExpandedTypefaceInternal(Typeface r5) {
        CancelableFontCallback r10 = this.expandedFontCallback;
        if (r10 == null) goto L6;
        r10.cancel();
    L6:
        if (this.expandedTypefaceDefault == r5) goto L12;
        this.expandedTypefaceDefault = r5;
        Typeface r11 = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), r5);
        this.expandedTypefaceBold = r11;
        if (r11 != null) goto L10;
        r11 = this.expandedTypefaceDefault;
    L10:
        this.expandedTypeface = r11;
        return true;
    L12:
        return false;
    }

    private void setInterpolatedTextSize(float r5) {
        calculateUsingTextSize(r5);
        if (USE_SCALING_TEXTURE == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        this.useTexture = r10;
        if (r10 == false) goto L11;
        ensureExpandedTexture();
    L11:
        ViewCompat.postInvalidateOnAnimation(this.view);
        return;
    L5:
        if (this.scale == 1.0f) goto L7;
        r10 = true;
        goto L8
    }

    private boolean shouldDrawMultiline() {
        if (this.maxLines > 1) goto L5;
    L11:
        return false;
    L5:
        if (this.isRtl == false) goto L9;
        if (this.fadeModeEnabled == false) goto L11;
    L9:
        if (this.useTexture == true) goto L11;
        return true;
    }

    public void draw(@NonNull Canvas r10) {
        int r5 = r10.save();
        if (this.textToDraw != null) goto L5;
        return;
    L5:
        if (this.currentBounds.width() > 0.0f) goto L7;
        return;
    L7:
        if (this.currentBounds.height() <= 0.0f) goto L34;
        this.textPaint.setTextSize(this.currentTextSize);
        float r11 = this.currentDrawX;
        float r12 = this.currentDrawY;
        if (this.useTexture == true) goto L11;
    L13:
        boolean r13 = false;
    L14:
        float r14 = this.scale;
        if (r14 != 1.0f) goto L17;
    L19:
        if (r13 == false) goto L23;
        r10.drawBitmap(this.expandedTitleTexture, r11, r12, this.texturePaint);
        r10.restoreToCount(r5);
        return;
    L23:
        if (shouldDrawMultiline() == true) goto L25;
    L29:
        r10.translate(r11, r12);
        this.textLayout.draw(r10);
    L30:
        r10.restoreToCount(r5);
        return;
    L25:
        if (this.fadeModeEnabled == true) goto L27;
    L28:
        drawMultilineTransition(r10, this.currentDrawX - this.textLayout.getLineStart(0), r12);
        goto L30
    L27:
        if (this.expandedFraction <= this.fadeModeThresholdFraction) goto L29;
    L17:
        if (this.fadeModeEnabled == true) goto L19;
        r10.scale(r14, r14, r11, r12);
        goto L19
    L11:
        if (this.expandedTitleTexture == null) goto L13;
        r13 = true;
        goto L14
    }

    public void getCollapsedTextActualBounds(@NonNull RectF r5, int r10, int r11) {
        this.isRtl = calculateIsRtl(this.text);
        r5.left = Math.max(getCollapsedTextLeftBound(r10, r11), this.collapsedBounds.left);
        r5.top = this.collapsedBounds.top;
        r5.right = Math.min(getCollapsedTextRightBound(r5, r10, r11), this.collapsedBounds.right);
        r5.bottom = getCollapsedTextHeight() + this.collapsedBounds.top;
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface r5 = this.collapsedTypeface;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return Typeface.DEFAULT;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public int getExpandedLineCount() {
        return this.expandedLineCount;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public float getExpandedTextFullHeight() {
        getTextPaintExpanded(this.tmpPaint);
        float r5 = -this.tmpPaint.ascent();
        return this.tmpPaint.descent() + r5;
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface r5 = this.expandedTypeface;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    @RequiresApi(23)
    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout r5 = this.textLayout;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getLineCount();
    }

    @RequiresApi(23)
    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    @RequiresApi(23)
    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    @Nullable
    public TimeInterpolator getPositionInterpolator() {
        return this.positionInterpolator;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.titleTextEllipsize;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    public final boolean isStateful() {
        ColorStateList r5 = this.collapsedTextColor;
        if (r5 != null) goto L5;
    L6:
        ColorStateList r10 = this.expandedTextColor;
        if (r10 != null) goto L9;
    L11:
        return false;
    L9:
        if (r10.isStateful() == false) goto L11;
    L10:
        return true;
    L5:
        if (r5.isStateful() == true) goto L10;
        goto L6
    }

    public void maybeUpdateFontWeightAdjustment(@NonNull Configuration r5) {
        Typeface r10 = this.collapsedTypefaceDefault;
        if (r10 == null) goto L5;
        this.collapsedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(r5, r10);
    L5:
        Typeface r11 = this.expandedTypefaceDefault;
        if (r11 == null) goto L8;
        this.expandedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(r5, r11);
    L8:
        Typeface r12 = this.collapsedTypefaceBold;
        if (r12 != null) goto L12;
        r12 = this.collapsedTypefaceDefault;
    L12:
        this.collapsedTypeface = r12;
        Typeface r13 = this.expandedTypefaceBold;
        if (r13 != null) goto L16;
        r13 = this.expandedTypefaceDefault;
    L16:
        this.expandedTypeface = r13;
        recalculate(true);
    }

    public void recalculate() {
        recalculate(false);
    }

    public void setCollapsedAndExpandedTextColor(@Nullable ColorStateList r5) {
        if (this.collapsedTextColor == r5) goto L5;
    L6:
        this.collapsedTextColor = r5;
        this.expandedTextColor = r5;
        recalculate();
        return;
    L5:
        if (this.expandedTextColor != r5) goto L6;
    }

    public void setCollapsedBounds(int r5, int r10, int r11, int r12) {
        if (rectEquals(this.collapsedBounds, r5, r10, r11, r12) == true) goto L6;
        this.collapsedBounds.set(r5, r10, r11, r12);
        this.boundsChanged = true;
        return;
    }

    public void setCollapsedTextAppearance(int r5) {
        TextAppearance r10 = new TextAppearance(this.view.getContext(), r5);
        if (r10.getTextColor() == null) goto L6;
        this.collapsedTextColor = r10.getTextColor();
    L6:
        if (r10.getTextSize() == 0.0f) goto L8;
        this.collapsedTextSize = r10.getTextSize();
    L8:
        ColorStateList r11 = r10.shadowColor;
        if (r11 == null) goto L11;
        this.collapsedShadowColor = r11;
    L11:
        this.collapsedShadowDx = r10.shadowDx;
        this.collapsedShadowDy = r10.shadowDy;
        this.collapsedShadowRadius = r10.shadowRadius;
        this.collapsedLetterSpacing = r10.letterSpacing;
        CancelableFontCallback r12 = this.collapsedFontCallback;
        if (r12 == null) goto L14;
        r12.cancel();
    L14:
        this.collapsedFontCallback = new CancelableFontCallback(new AnonymousClass1(this), r10.getFallbackFont());
        r10.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList r5) {
        if (this.collapsedTextColor == r5) goto L6;
        this.collapsedTextColor = r5;
        recalculate();
        return;
    }

    public void setCollapsedTextGravity(int r5) {
        if (this.collapsedTextGravity == r5) goto L6;
        this.collapsedTextGravity = r5;
        recalculate();
        return;
    }

    public void setCollapsedTextSize(float r5) {
        if (this.collapsedTextSize == r5) goto L6;
        this.collapsedTextSize = r5;
        recalculate();
        return;
    }

    public void setCollapsedTypeface(Typeface r5) {
        if (setCollapsedTypefaceInternal(r5) == false) goto L6;
        recalculate();
        return;
    }

    public void setCurrentOffsetY(int r5) {
        this.currentOffsetY = r5;
    }

    public void setExpandedBounds(int r5, int r10, int r11, int r12) {
        if (rectEquals(this.expandedBounds, r5, r10, r11, r12) == true) goto L6;
        this.expandedBounds.set(r5, r10, r11, r12);
        this.boundsChanged = true;
        return;
    }

    public void setExpandedLetterSpacing(float r5) {
        if (this.expandedLetterSpacing == r5) goto L6;
        this.expandedLetterSpacing = r5;
        recalculate();
        return;
    }

    public void setExpandedTextAppearance(int r5) {
        TextAppearance r10 = new TextAppearance(this.view.getContext(), r5);
        if (r10.getTextColor() == null) goto L6;
        this.expandedTextColor = r10.getTextColor();
    L6:
        if (r10.getTextSize() == 0.0f) goto L8;
        this.expandedTextSize = r10.getTextSize();
    L8:
        ColorStateList r11 = r10.shadowColor;
        if (r11 == null) goto L11;
        this.expandedShadowColor = r11;
    L11:
        this.expandedShadowDx = r10.shadowDx;
        this.expandedShadowDy = r10.shadowDy;
        this.expandedShadowRadius = r10.shadowRadius;
        this.expandedLetterSpacing = r10.letterSpacing;
        CancelableFontCallback r12 = this.expandedFontCallback;
        if (r12 == null) goto L14;
        r12.cancel();
    L14:
        this.expandedFontCallback = new CancelableFontCallback(new AnonymousClass2(this), r10.getFallbackFont());
        r10.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList r5) {
        if (this.expandedTextColor == r5) goto L6;
        this.expandedTextColor = r5;
        recalculate();
        return;
    }

    public void setExpandedTextGravity(int r5) {
        if (this.expandedTextGravity == r5) goto L6;
        this.expandedTextGravity = r5;
        recalculate();
        return;
    }

    public void setExpandedTextSize(float r5) {
        if (this.expandedTextSize == r5) goto L6;
        this.expandedTextSize = r5;
        recalculate();
        return;
    }

    public void setExpandedTypeface(Typeface r5) {
        if (setExpandedTypefaceInternal(r5) == false) goto L6;
        recalculate();
        return;
    }

    public void setExpansionFraction(float r5) {
        float r10 = MathUtils.clamp(r5, 0.0f, 1.0f);
        if (r10 == this.expandedFraction) goto L6;
        this.expandedFraction = r10;
        calculateCurrentOffsets();
        return;
    }

    public void setFadeModeEnabled(boolean r5) {
        this.fadeModeEnabled = r5;
    }

    public void setFadeModeStartFraction(float r5) {
        this.fadeModeStartFraction = r5;
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    @RequiresApi(23)
    public void setHyphenationFrequency(int r5) {
        this.hyphenationFrequency = r5;
    }

    @RequiresApi(23)
    public void setLineSpacingAdd(float r5) {
        this.lineSpacingAdd = r5;
    }

    @RequiresApi(23)
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float r5) {
        this.lineSpacingMultiplier = r5;
    }

    public void setMaxLines(int r5) {
        if (r5 == this.maxLines) goto L6;
        this.maxLines = r5;
        clearTexture();
        recalculate();
        return;
    }

    public void setPositionInterpolator(TimeInterpolator r5) {
        this.positionInterpolator = r5;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean r5) {
        this.isRtlTextDirectionHeuristicsEnabled = r5;
    }

    public final boolean setState(int[] r5) {
        this.state = r5;
        if (isStateful() == false) goto L6;
        recalculate();
        return true;
    L6:
        return false;
    }

    @RequiresApi(23)
    public void setStaticLayoutBuilderConfigurer(@Nullable StaticLayoutBuilderConfigurer r5) {
        if (this.staticLayoutBuilderConfigurer == r5) goto L6;
        this.staticLayoutBuilderConfigurer = r5;
        recalculate(true);
        return;
    }

    public void setText(@Nullable CharSequence r5) {
        if (r5 != null) goto L4;
    L5:
        this.text = r5;
        this.textToDraw = null;
        clearTexture();
        recalculate();
        return;
    L4:
        if (TextUtils.equals(this.text, r5) == false) goto L5;
    }

    public void setTextSizeInterpolator(TimeInterpolator r5) {
        this.textSizeInterpolator = r5;
        recalculate();
    }

    public void setTitleTextEllipsize(@NonNull TextUtils.TruncateAt r5) {
        this.titleTextEllipsize = r5;
        recalculate();
    }

    public void setTypefaces(Typeface r5) {
        boolean r10 = setCollapsedTypefaceInternal(r5);
        boolean r11 = setExpandedTypefaceInternal(r5);
        if (r10 == true) goto L5;
        if (r11 == true) goto L5;
        return;
    L5:
        recalculate();
    }

    private void calculateUsingTextSize(float r11, boolean r12) {
        if (this.text != null) goto L5;
        return;
    L5:
        float r5 = this.collapsedBounds.width();
        float r10 = this.expandedBounds.width();
        if (isClose(r11, 1.0f) == false) goto L8;
        float r13 = this.collapsedTextSize;
        float r14 = this.collapsedLetterSpacing;
        this.scale = 1.0f;
        Typeface r15 = this.collapsedTypeface;
    L22:
        int r16 = 1;
        boolean r17 = false;
        if (r5 <= 0.0f) goto L56;
        if (this.currentTextSize == r13) goto L27;
        boolean r18 = true;
    L29:
        if (this.currentLetterSpacing == r14) goto L31;
        boolean r19 = true;
    L33:
        if (this.currentTypeface == r15) goto L35;
        boolean r20 = true;
    L36:
        StaticLayout r21 = this.textLayout;
        if (r21 != null) goto L39;
    L41:
        boolean r22 = false;
    L42:
        if (r18 == true) goto L50;
        if (r19 == true) goto L50;
        if (r22 == true) goto L50;
        if (r20 == true) goto L50;
        if (this.boundsChanged == true) goto L50;
        boolean r23 = false;
    L51:
        this.currentTextSize = r13;
        this.currentLetterSpacing = r14;
        this.currentTypeface = r15;
        this.boundsChanged = false;
        TextPaint r110 = this.textPaint;
        if (this.scale == 1.0f) goto L54;
        r17 = true;
    L54:
        r110.setLinearText(r17);
        r17 = r23;
    L50:
        r23 = true;
        goto L51
    L39:
        if (r5 == r21.getWidth()) goto L41;
        r22 = true;
        goto L42
    L35:
        r20 = false;
        goto L36
    L31:
        r19 = false;
        goto L33
    L27:
        r18 = false;
    L56:
        if (this.textToDraw == null) goto L58;
        if (r17 == true) goto L58;
        return;
    L58:
        this.textPaint.setTextSize(this.currentTextSize);
        this.textPaint.setTypeface(this.currentTypeface);
        this.textPaint.setLetterSpacing(this.currentLetterSpacing);
        this.isRtl = calculateIsRtl(this.text);
        if (shouldDrawMultiline() == false) goto L61;
        r16 = this.maxLines;
    L61:
        StaticLayout r111 = createStaticLayout(r16, r5, this.isRtl);
        this.textLayout = r111;
        this.textToDraw = r111.getText();
        return;
    L8:
        float r24 = this.expandedTextSize;
        float r25 = this.expandedLetterSpacing;
        Typeface r26 = this.expandedTypeface;
        if (isClose(r11, 0.0f) == false) goto L11;
        this.scale = 1.0f;
    L12:
        float r112 = this.collapsedTextSize / this.expandedTextSize;
        float r27 = r10 * r112;
        if (r12 == false) goto L15;
    L21:
        r5 = r10;
    L20:
        r13 = r24;
        r14 = r25;
        r15 = r26;
        goto L22
    L15:
        if (this.fadeModeEnabled == true) goto L21;
        if (r27 <= r5) goto L21;
        r5 = Math.min(r5 / r112, r10);
        goto L20
    L11:
        this.scale = lerp(this.expandedTextSize, this.collapsedTextSize, r11, this.textSizeInterpolator) / this.expandedTextSize;
        goto L12
    }

    public void recalculate(boolean r5) {
        if (this.view.getHeight() > 0) goto L5;
    L6:
        if (r5 == false) goto L9;
    L7:
        calculateBaseOffsets(r5);
        calculateCurrentOffsets();
        return;
    L9:
        return;
    L5:
        if (this.view.getWidth() > 0) goto L7;
        goto L6
    }

    public void setCollapsedBounds(@NonNull Rect r5) {
        setCollapsedBounds(r5.left, r5.top, r5.right, r5.bottom);
    }

    public void setExpandedBounds(@NonNull Rect r5) {
        setExpandedBounds(r5.left, r5.top, r5.right, r5.bottom);
    }
}
