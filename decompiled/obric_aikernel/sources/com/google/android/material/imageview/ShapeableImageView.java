package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.resources.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.google.android.material.shape.m;
import com.google.android.material.shape.p;
import q5.k;

/* JADX INFO: loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements p {
    private static final int DEF_STYLE_RES = 0;
    private static final int UNDEFINED_PADDING = Integer.MIN_VALUE;
    private final Paint borderPaint;

    @Dimension
    private int bottomContentPadding;
    private final Paint clearPaint;
    private final RectF destination;

    @Dimension
    private int endContentPadding;
    private boolean hasAdjustedPaddingAfterLayoutDirectionResolved;

    @Dimension
    private int leftContentPadding;
    private Path maskPath;
    private final RectF maskRect;
    private final Path path;
    private final m pathProvider;

    @Dimension
    private int rightContentPadding;

    @Nullable
    private MaterialShapeDrawable shadowDrawable;
    private l shapeAppearanceModel;

    @Dimension
    private int startContentPadding;

    @Nullable
    private ColorStateList strokeColor;

    @Dimension
    private float strokeWidth;

    @Dimension
    private int topContentPadding;

    @TargetApi(21)
    class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f3333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShapeableImageView f3334b;

        a(ShapeableImageView r10) {
            this.f3334b = r10;
            this.f3333a = new Rect();
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            if (ShapeableImageView.access$000(this.f3334b) != null) goto L6;
            return;
        L6:
            if (ShapeableImageView.access$100(this.f3334b) != null) goto L8;
            ShapeableImageView.access$102(this.f3334b, new MaterialShapeDrawable(ShapeableImageView.access$000(this.f3334b)));
        L8:
            ShapeableImageView.access$200(this.f3334b).round(this.f3333a);
            ShapeableImageView.access$100(this.f3334b).setBounds(this.f3333a);
            ShapeableImageView.access$100(this.f3334b).getOutline(r11);
        }
    }

    static {
        DEF_STYLE_RES = k.Widget_MaterialComponents_ShapeableImageView;
    }

    public ShapeableImageView(Context r10) {
        this(r10, null, 0);
    }

    public ShapeableImageView(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ShapeableImageView(Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(b6.a.c(r10, r11, r12, r13), r11, r12);
        this.pathProvider = m.k();
        this.path = new Path();
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = false;
        Context r14 = getContext();
        Paint r15 = new Paint();
        this.clearPaint = r15;
        r15.setAntiAlias(true);
        r15.setColor(-1);
        r15.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.destination = new RectF();
        this.maskRect = new RectF();
        this.maskPath = new Path();
        TypedArray r16 = r14.obtainStyledAttributes(r11, q5.l.ShapeableImageView, r12, r13);
        this.strokeColor = c.a(r14, r16, q5.l.ShapeableImageView_strokeColor);
        this.strokeWidth = r16.getDimensionPixelSize(q5.l.ShapeableImageView_strokeWidth, 0);
        int r17 = r16.getDimensionPixelSize(q5.l.ShapeableImageView_contentPadding, 0);
        this.leftContentPadding = r17;
        this.topContentPadding = r17;
        this.rightContentPadding = r17;
        this.bottomContentPadding = r17;
        this.leftContentPadding = r16.getDimensionPixelSize(q5.l.ShapeableImageView_contentPaddingLeft, r17);
        this.topContentPadding = r16.getDimensionPixelSize(q5.l.ShapeableImageView_contentPaddingTop, r17);
        this.rightContentPadding = r16.getDimensionPixelSize(q5.l.ShapeableImageView_contentPaddingRight, r17);
        this.bottomContentPadding = r16.getDimensionPixelSize(q5.l.ShapeableImageView_contentPaddingBottom, r17);
        this.startContentPadding = r16.getDimensionPixelSize(q5.l.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.endContentPadding = r16.getDimensionPixelSize(q5.l.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        r16.recycle();
        Paint r18 = new Paint();
        this.borderPaint = r18;
        r18.setStyle(Paint.Style.STROKE);
        r18.setAntiAlias(true);
        this.shapeAppearanceModel = l.e(r14, r11, r12, r13).m();
        if (Build.VERSION.SDK_INT < 21) goto L6;
        setOutlineProvider(new a(this));
        return;
    }

    static /* synthetic */ l access$000(ShapeableImageView r10) {
        return r10.shapeAppearanceModel;
    }

    static /* synthetic */ MaterialShapeDrawable access$100(ShapeableImageView r10) {
        return r10.shadowDrawable;
    }

    static /* synthetic */ MaterialShapeDrawable access$102(ShapeableImageView r10, MaterialShapeDrawable r11) {
        r10.shadowDrawable = r11;
        return r11;
    }

    static /* synthetic */ RectF access$200(ShapeableImageView r10) {
        return r10.destination;
    }

    private void drawStroke(Canvas r10) {
        if (this.strokeColor != null) goto L5;
        return;
    L5:
        this.borderPaint.setStrokeWidth(this.strokeWidth);
        int r11 = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
        if (this.strokeWidth <= 0.0f) goto L10;
        if (r11 == 0) goto L11;
        this.borderPaint.setColor(r11);
        r10.drawPath(this.path, this.borderPaint);
        return;
    L11:
        return;
    }

    private boolean isContentPaddingRelative() {
        if (this.startContentPadding == Integer.MIN_VALUE) goto L5;
    L8:
        return true;
    L5:
        if (this.endContentPadding != Integer.MIN_VALUE) goto L8;
        return false;
    }

    private boolean isRtl() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
    L7:
        return false;
    L5:
        if (getLayoutDirection() != 1) goto L7;
        return true;
    }

    private void updateShapeMask(int r10, int r11) {
        this.destination.set(getPaddingLeft(), getPaddingTop(), r10 - getPaddingRight(), r11 - getPaddingBottom());
        this.pathProvider.d(this.shapeAppearanceModel, 1.0f, this.destination, this.path);
        this.maskPath.rewind();
        this.maskPath.addPath(this.path);
        this.maskRect.set(0.0f, 0.0f, r10, r11);
        this.maskPath.addRect(this.maskRect, Path.Direction.CCW);
    }

    @Dimension
    public int getContentPaddingBottom() {
        return this.bottomContentPadding;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        int r10 = this.endContentPadding;
        if (r10 == Integer.MIN_VALUE) goto L6;
        return r10;
    L6:
        if (isRtl() == false) goto L9;
        return this.leftContentPadding;
    L9:
        return this.rightContentPadding;
    }

    @Dimension
    public int getContentPaddingLeft() {
        if (isContentPaddingRelative() == false) goto L15;
        if (isRtl() == false) goto L10;
        int r10 = this.endContentPadding;
        if (r10 == Integer.MIN_VALUE) goto L10;
        return r10;
    L10:
        if (isRtl() == true) goto L15;
        int r11 = this.startContentPadding;
        if (r11 == Integer.MIN_VALUE) goto L15;
        return r11;
    L15:
        return this.leftContentPadding;
    }

    @Dimension
    public int getContentPaddingRight() {
        if (isContentPaddingRelative() == false) goto L15;
        if (isRtl() == false) goto L10;
        int r10 = this.startContentPadding;
        if (r10 == Integer.MIN_VALUE) goto L10;
        return r10;
    L10:
        if (isRtl() == true) goto L15;
        int r11 = this.endContentPadding;
        if (r11 == Integer.MIN_VALUE) goto L15;
        return r11;
    L15:
        return this.rightContentPadding;
    }

    @Dimension
    public final int getContentPaddingStart() {
        int r10 = this.startContentPadding;
        if (r10 == Integer.MIN_VALUE) goto L6;
        return r10;
    L6:
        if (isRtl() == false) goto L9;
        return this.rightContentPadding;
    L9:
        return this.leftContentPadding;
    }

    @Dimension
    public int getContentPaddingTop() {
        return this.topContentPadding;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // com.google.android.material.shape.p
    @NonNull
    public l getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas r10) {
        super.onDraw(r10);
        r10.drawPath(this.maskPath, this.clearPaint);
        drawStroke(r10);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (this.hasAdjustedPaddingAfterLayoutDirectionResolved == false) goto L5;
        return;
    L5:
        int r12 = Build.VERSION.SDK_INT;
        if (r12 > 19) goto L8;
    L10:
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = true;
        if (r12 >= 21) goto L13;
    L18:
        setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
        return;
    L13:
        if (isPaddingRelative() == false) goto L15;
    L16:
        setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        return;
    L15:
        if (isContentPaddingRelative() == false) goto L18;
    L8:
        if (isLayoutDirectionResolved() == true) goto L10;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        updateShapeMask(r10, r11);
    }

    public void setContentPadding(@Dimension int r10, @Dimension int r11, @Dimension int r12, @Dimension int r13) {
        this.startContentPadding = Integer.MIN_VALUE;
        this.endContentPadding = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.leftContentPadding) + r10, (super.getPaddingTop() - this.topContentPadding) + r11, (super.getPaddingRight() - this.rightContentPadding) + r12, (super.getPaddingBottom() - this.bottomContentPadding) + r13);
        this.leftContentPadding = r10;
        this.topContentPadding = r11;
        this.rightContentPadding = r12;
        this.bottomContentPadding = r13;
    }

    @RequiresApi(17)
    public void setContentPaddingRelative(@Dimension int r10, @Dimension int r11, @Dimension int r12, @Dimension int r13) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + r10, (super.getPaddingTop() - this.topContentPadding) + r11, (super.getPaddingEnd() - getContentPaddingEnd()) + r12, (super.getPaddingBottom() - this.bottomContentPadding) + r13);
        if (isRtl() == false) goto L5;
        int r14 = r12;
    L6:
        this.leftContentPadding = r14;
        this.topContentPadding = r11;
        if (isRtl() == true) goto L10;
        r10 = r12;
    L10:
        this.rightContentPadding = r10;
        this.bottomContentPadding = r13;
        return;
    L5:
        r14 = r10;
        goto L6
    }

    @Override // android.view.View
    public void setPadding(@Dimension int r10, @Dimension int r11, @Dimension int r12, @Dimension int r13) {
        super.setPadding(r10 + getContentPaddingLeft(), r11 + getContentPaddingTop(), r12 + getContentPaddingRight(), r13 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(@Dimension int r10, @Dimension int r11, @Dimension int r12, @Dimension int r13) {
        super.setPaddingRelative(r10 + getContentPaddingStart(), r11 + getContentPaddingTop(), r12 + getContentPaddingEnd(), r13 + getContentPaddingBottom());
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(@NonNull l r10) {
        this.shapeAppearanceModel = r10;
        MaterialShapeDrawable r11 = this.shadowDrawable;
        if (r11 == null) goto L5;
        r11.setShapeAppearanceModel(r10);
    L5:
        updateShapeMask(getWidth(), getHeight());
        invalidate();
        if (Build.VERSION.SDK_INT < 21) goto L9;
        invalidateOutline();
        return;
    }

    public void setStrokeColor(@Nullable ColorStateList r10) {
        this.strokeColor = r10;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int r10) {
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), r10));
    }

    public void setStrokeWidth(@Dimension float r10) {
        if (this.strokeWidth == r10) goto L6;
        this.strokeWidth = r10;
        invalidate();
        return;
    }

    public void setStrokeWidthResource(@DimenRes int r10) {
        setStrokeWidth(getResources().getDimensionPixelSize(r10));
    }
}
