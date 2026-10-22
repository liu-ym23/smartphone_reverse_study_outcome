package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {

    @StyleRes
    private static final int DEFAULT_STYLE = 0;

    @AttrRes
    private static final int DEFAULT_THEME_ATTR = 0;
    private int arrowSize;

    @NonNull
    private final View.OnLayoutChangeListener attachedViewLayoutChangeListener;

    @NonNull
    private final Context context;

    @NonNull
    private final Rect displayFrame;

    @Nullable
    private final Paint.FontMetrics fontMetrics;
    private float labelOpacity;
    private int layoutMargin;
    private int locationOnScreenX;
    private int minHeight;
    private int minWidth;
    private int padding;
    private boolean showMarker;

    @Nullable
    private CharSequence text;

    @NonNull
    private final TextDrawableHelper textDrawableHelper;
    private final float tooltipPivotX;
    private float tooltipPivotY;
    private float tooltipScaleX;
    private float tooltipScaleY;

    static {
        DEFAULT_STYLE = R.style.Widget_MaterialComponents_Tooltip;
        DEFAULT_THEME_ATTR = R.attr.tooltipStyle;
    }

    private TooltipDrawable(@NonNull Context r5, AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        super(r5, r10, r11, r12);
        this.fontMetrics = new Paint.FontMetrics();
        TextDrawableHelper r13 = new TextDrawableHelper(this);
        this.textDrawableHelper = r13;
        this.attachedViewLayoutChangeListener = new AnonymousClass1(this);
        this.displayFrame = new Rect();
        this.tooltipScaleX = 1.0f;
        this.tooltipScaleY = 1.0f;
        this.tooltipPivotX = 0.5f;
        this.tooltipPivotY = 0.5f;
        this.labelOpacity = 1.0f;
        this.context = r5;
        TextPaint r14 = r13.getTextPaint();
        r14.density = r5.getResources().getDisplayMetrics().density;
        r13.getTextPaint().setTextAlign(Paint.Align.CENTER);
    }

    public static /* synthetic */ void access$000(TooltipDrawable r5, View r10) {
        r5.updateLocationOnScreen(r10);
    }

    private float calculatePointerOffset() {
        if ((((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin) >= 0) goto L7;
        int r5 = ((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin;
    L11:
        return r5;
    L7:
        if ((((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin) <= 0) goto L9;
        r5 = ((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin;
        goto L11
    L9:
        return 0.0f;
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        Paint.FontMetrics r5 = this.fontMetrics;
        return (r5.descent + r5.ascent) / 2.0f;
    }

    private float calculateTextOriginAndAlignment(@NonNull Rect r5) {
        return r5.centerY() - calculateTextCenterFromBaseline();
    }

    @NonNull
    public static TooltipDrawable create(@NonNull Context r5) {
        return createFromAttributes(r5, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    @NonNull
    public static TooltipDrawable createFromAttributes(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        TooltipDrawable r13 = new TooltipDrawable(r5, r10, r11, r12);
        r13.loadFromAttributes(r10, r11, r12);
        return r13;
    }

    private EdgeTreatment createMarkerEdge() {
        float r5 = -calculatePointerOffset();
        float r10 = ((float) (getBounds().width() - (Math.sqrt(2.0d) * this.arrowSize))) / 2.0f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.arrowSize), Math.min(Math.max(r5, -r10), r10));
    }

    private void drawText(@NonNull Canvas r12) {
        if (this.text != null) goto L5;
        return;
    L5:
        Rect r5 = getBounds();
        int r10 = (int) calculateTextOriginAndAlignment(r5);
        if (this.textDrawableHelper.getTextAppearance() == null) goto L8;
        this.textDrawableHelper.getTextPaint().drawableState = getState();
        this.textDrawableHelper.updateTextPaintDrawState(this.context);
        this.textDrawableHelper.getTextPaint().setAlpha((int) (this.labelOpacity * 255.0f));
    L8:
        CharSequence r11 = this.text;
        r12.drawText(r11, 0, r11.length(), r5.centerX(), r10, this.textDrawableHelper.getTextPaint());
    }

    private float getTextWidth() {
        CharSequence r5 = this.text;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return this.textDrawableHelper.getTextWidth(r5.toString());
    }

    private void loadFromAttributes(@Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(this.context, r10, R.styleable.Tooltip, r11, r12, new int[0]);
        this.arrowSize = this.context.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        boolean r14 = r13.getBoolean(R.styleable.Tooltip_showMarker, true);
        this.showMarker = r14;
        if (r14 == false) goto L5;
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
    L6:
        setText(r13.getText(R.styleable.Tooltip_android_text));
        TextAppearance r15 = MaterialResources.getTextAppearance(this.context, r13, R.styleable.Tooltip_android_textAppearance);
        if (r15 != null) goto L9;
    L11:
        setTextAppearance(r15);
        int r16 = MaterialColors.getColor(this.context, R.attr.colorOnBackground, TooltipDrawable.class.getCanonicalName());
        int r17 = MaterialColors.layer(ColorUtils.setAlphaComponent(MaterialColors.getColor(this.context, android.R.attr.colorBackground, TooltipDrawable.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(r16, 153));
        setFillColor(ColorStateList.valueOf(r13.getColor(R.styleable.Tooltip_backgroundTint, r17)));
        setStrokeColor(ColorStateList.valueOf(MaterialColors.getColor(this.context, R.attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
        this.padding = r13.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        this.minWidth = r13.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        this.minHeight = r13.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        this.layoutMargin = r13.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        r13.recycle();
        return;
    L9:
        if (r13.hasValue(R.styleable.Tooltip_android_textColor) == false) goto L11;
        r15.setTextColor(MaterialResources.getColorStateList(this.context, r13, R.styleable.Tooltip_android_textColor));
        goto L11
    L5:
        this.arrowSize = 0;
        goto L6
    }

    private void updateLocationOnScreen(@NonNull View r5) {
        int[] r10 = new int[2];
        r5.getLocationOnScreen(r10);
        this.locationOnScreenX = r10[0];
        r5.getWindowVisibleDisplayFrame(this.displayFrame);
    }

    public void detachView(@Nullable View r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        r5.removeOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        r10.save();
        float r5 = calculatePointerOffset();
        float r11 = (float) (-((Math.sqrt(2.0d) * this.arrowSize) - ((double) this.arrowSize)));
        r10.scale(this.tooltipScaleX, this.tooltipScaleY, (getBounds().width() * 0.5f) + getBounds().left, (getBounds().height() * this.tooltipPivotY) + getBounds().top);
        r10.translate(r5, r11);
        super.draw(r10);
        drawText(r10);
        r10.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.textDrawableHelper.getTextPaint().getTextSize(), this.minHeight);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.padding * 2) + getTextWidth(), this.minWidth);
    }

    public int getLayoutMargin() {
        return this.layoutMargin;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public int getTextPadding() {
        return this.padding;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        super.onBoundsChange(r5);
        if (this.showMarker == false) goto L6;
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
        return;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] r5) {
        return super.onStateChange(r5);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setLayoutMargin(@Px int r5) {
        this.layoutMargin = r5;
        invalidateSelf();
    }

    public void setMinHeight(@Px int r5) {
        this.minHeight = r5;
        invalidateSelf();
    }

    public void setMinWidth(@Px int r5) {
        this.minWidth = r5;
        invalidateSelf();
    }

    public void setRelativeToView(@Nullable View r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        updateLocationOnScreen(r5);
        r5.addOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    public void setRevealFraction(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        this.tooltipPivotY = 1.2f;
        this.tooltipScaleX = r5;
        this.tooltipScaleY = r5;
        this.labelOpacity = AnimationUtils.lerp(0.0f, 1.0f, 0.19f, 1.0f, r5);
        invalidateSelf();
    }

    public void setText(@Nullable CharSequence r5) {
        if (TextUtils.equals(this.text, r5) == true) goto L6;
        this.text = r5;
        this.textDrawableHelper.setTextWidthDirty(true);
        invalidateSelf();
        return;
    }

    public void setTextAppearance(@Nullable TextAppearance r5) {
        this.textDrawableHelper.setTextAppearance(r5, this.context);
    }

    public void setTextAppearanceResource(@StyleRes int r5) {
        setTextAppearance(new TextAppearance(this.context, r5));
    }

    public void setTextPadding(@Px int r5) {
        this.padding = r5;
        invalidateSelf();
    }

    public void setTextResource(@StringRes int r5) {
        setText(this.context.getResources().getString(r5));
    }

    @NonNull
    public static TooltipDrawable createFromAttributes(@NonNull Context r5, @Nullable AttributeSet r10) {
        return createFromAttributes(r5, r10, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }
}
