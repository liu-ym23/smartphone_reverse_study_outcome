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
import androidx.core.graphics.ColorUtils;
import com.google.android.material.c.a;
import com.google.android.material.internal.i;
import com.google.android.material.internal.k;
import com.google.android.material.resources.c;
import com.google.android.material.resources.d;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.f;
import com.google.android.material.shape.g;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TooltipDrawable extends MaterialShapeDrawable implements i.a {
    private static final int DEFAULT_STYLE = 0;
    private static final int DEFAULT_THEME_ATTR = 0;
    private int arrowSize;
    private final View.OnLayoutChangeListener attachedViewLayoutChangeListener;
    private final Context context;
    private final Rect displayFrame;
    private final Paint.FontMetrics fontMetrics;
    private float labelOpacity;
    private int layoutMargin;
    private int locationOnScreenX;
    private int minHeight;
    private int minWidth;
    private int padding;
    private CharSequence text;
    private final i textDrawableHelper;
    private final float tooltipPivotX;
    private float tooltipPivotY;
    private float tooltipScaleX;
    private float tooltipScaleY;

    static {
        DEFAULT_STYLE = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_Tooltip, "style", "Widget_MaterialComponents_Tooltip");
        DEFAULT_THEME_ATTR = ZeusTransformUtils.mapRes(R.attr.tooltipStyle, "attr", "tooltipStyle");
    }

    private TooltipDrawable(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r7, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5, r6);
        this.fontMetrics = new Paint.FontMetrics();
        i r8 = new i(this);
        this.textDrawableHelper = r8;
        this.attachedViewLayoutChangeListener = new AnonymousClass1(this);
        this.displayFrame = new Rect();
        this.tooltipScaleX = 1.0f;
        this.tooltipScaleY = 1.0f;
        this.tooltipPivotX = 0.5f;
        this.tooltipPivotY = 0.5f;
        this.labelOpacity = 1.0f;
        this.context = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        TextPaint r2 = r8.a();
        r2.density = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        r8.a().setTextAlign(Paint.Align.CENTER);
    }

    static /* synthetic */ void access$000(TooltipDrawable r0, View r1) {
        r0.updateLocationOnScreen(r1);
    }

    private float calculatePointerOffset() {
        if ((((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin) >= 0) goto L7;
        int r0 = ((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin;
    L11:
        return r0;
    L7:
        if ((((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin) <= 0) goto L9;
        r0 = ((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin;
        goto L11
    L9:
        return 0.0f;
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.a().getFontMetrics(this.fontMetrics);
        return (this.fontMetrics.descent + this.fontMetrics.ascent) / 2.0f;
    }

    private float calculateTextOriginAndAlignment(Rect r1) {
        return r1.centerY() - calculateTextCenterFromBaseline();
    }

    public static TooltipDrawable create(Context r3) {
        return createFromAttributes((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    public static TooltipDrawable createFromAttributes(Context r2, AttributeSet r3) {
        return createFromAttributes((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"), DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    public static TooltipDrawable createFromAttributes(Context r2, AttributeSet r3, int r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        TooltipDrawable r0 = new TooltipDrawable(r6, r7, r4, r5);
        r0.loadFromAttributes(r7, r4, r5);
        return r0;
    }

    private f createMarkerEdge() {
        float r0 = -calculatePointerOffset();
        float r1 = ((float) (((double) getBounds().width()) - (((double) this.arrowSize) * Math.sqrt(2.0d)))) / 2.0f;
        return new com.google.android.material.shape.i(new g(this.arrowSize), Math.min(Math.max(r0, -r1), r1));
    }

    private void drawText(Canvas r12) {
        if (this.text != null) goto L5;
        return;
    L5:
        Rect r0 = getBounds();
        int r1 = (int) calculateTextOriginAndAlignment(r0);
        if (this.textDrawableHelper.b() == null) goto L8;
        this.textDrawableHelper.a().drawableState = getState();
        this.textDrawableHelper.a(this.context);
        this.textDrawableHelper.a().setAlpha((int) (this.labelOpacity * 255.0f));
    L8:
        CharSequence r5 = this.text;
        r12.drawText(r5, 0, r5.length(), r0.centerX(), r1, this.textDrawableHelper.a());
    }

    private float getTextWidth() {
        CharSequence r0 = this.text;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return this.textDrawableHelper.a(r0.toString());
    }

    private void loadFromAttributes(AttributeSet r10, int r11, int r12) {
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r13 = k.a(this.context, r4, R.styleable.Tooltip, r11, r12, new int[0]);
        this.arrowSize = ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_tooltip_arrowSize, "dimen", "mtrl_tooltip_arrowSize"));
        setShapeAppearanceModel(getShapeAppearanceModel().n().b(createMarkerEdge()).a());
        setText(r13.getText(ZeusTransformUtils.mapRes(R.styleable.Tooltip_android_text, "styleable", "Tooltip_android_text")));
        d r14 = c.c(this.context, r13, ZeusTransformUtils.mapRes(R.styleable.Tooltip_android_textAppearance, "styleable", "Tooltip_android_textAppearance"));
        if (r14 != null) goto L5;
    L7:
        setTextAppearance(r14);
        int r15 = a.a(this.context, ZeusTransformUtils.mapRes(R.attr.colorOnBackground, "attr", "colorOnBackground"), TooltipDrawable.class.getCanonicalName());
        int r16 = a.a(ColorUtils.setAlphaComponent(a.a(this.context, android.R.attr.colorBackground, TooltipDrawable.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(r15, 153));
        setFillColor(ColorStateList.valueOf(r13.getColor(ZeusTransformUtils.mapRes(R.styleable.Tooltip_backgroundTint, "styleable", "Tooltip_backgroundTint"), r16)));
        setStrokeColor(ColorStateList.valueOf(a.a(this.context, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), TooltipDrawable.class.getCanonicalName())));
        this.padding = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Tooltip_android_padding, "styleable", "Tooltip_android_padding"), 0);
        this.minWidth = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Tooltip_android_minWidth, "styleable", "Tooltip_android_minWidth"), 0);
        this.minHeight = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Tooltip_android_minHeight, "styleable", "Tooltip_android_minHeight"), 0);
        this.layoutMargin = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Tooltip_android_layout_margin, "styleable", "Tooltip_android_layout_margin"), 0);
        r13.recycle();
        return;
    L5:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.Tooltip_android_textColor, "styleable", "Tooltip_android_textColor")) == false) goto L7;
        r14.a(c.a(this.context, r13, ZeusTransformUtils.mapRes(R.styleable.Tooltip_android_textColor, "styleable", "Tooltip_android_textColor")));
        goto L7
    }

    private void updateLocationOnScreen(View r3) {
        int[] r0 = new int[2];
        r3.getLocationOnScreen(r0);
        this.locationOnScreenX = r0[0];
        r3.getWindowVisibleDisplayFrame(this.displayFrame);
    }

    public void detachView(View r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.removeOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r9) {
        r9.save();
        float r0 = calculatePointerOffset();
        float r1 = (float) (-((((double) this.arrowSize) * Math.sqrt(2.0d)) - ((double) this.arrowSize)));
        r9.scale(this.tooltipScaleX, this.tooltipScaleY, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.tooltipPivotY));
        r9.translate(r0, r1);
        super.draw(r9);
        drawText(r9);
        r9.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.textDrawableHelper.a().getTextSize(), this.minHeight);
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

    public CharSequence getText() {
        return this.text;
    }

    public d getTextAppearance() {
        return this.textDrawableHelper.b();
    }

    public int getTextPadding() {
        return this.padding;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r2) {
        super.onBoundsChange(r2);
        setShapeAppearanceModel(getShapeAppearanceModel().n().b(createMarkerEdge()).a());
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.i.a
    public boolean onStateChange(int[] r1) {
        return super.onStateChange(r1);
    }

    @Override // com.google.android.material.internal.i.a
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setLayoutMargin(int r1) {
        this.layoutMargin = r1;
        invalidateSelf();
    }

    public void setMinHeight(int r1) {
        this.minHeight = r1;
        invalidateSelf();
    }

    public void setMinWidth(int r1) {
        this.minWidth = r1;
        invalidateSelf();
    }

    public void setRelativeToView(View r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        updateLocationOnScreen(r1);
        r1.addOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    public void setRevealFraction(float r4) {
        this.tooltipPivotY = 1.2f;
        this.tooltipScaleX = r4;
        this.tooltipScaleY = r4;
        this.labelOpacity = com.google.android.material.a.a.a(0.0f, 1.0f, 0.19f, 1.0f, r4);
        invalidateSelf();
    }

    public void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals(this.text, r4) == true) goto L6;
        this.text = r4;
        this.textDrawableHelper.a(true);
        invalidateSelf();
        return;
    }

    public void setTextAppearance(d r2) {
        this.textDrawableHelper.a(r2, this.context);
    }

    public void setTextAppearanceResource(int r3) {
        setTextAppearance(new d(this.context, r3));
    }

    public void setTextPadding(int r1) {
        this.padding = r1;
        invalidateSelf();
    }

    public void setTextResource(int r3) {
        setText(ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getString(r3));
    }
}
