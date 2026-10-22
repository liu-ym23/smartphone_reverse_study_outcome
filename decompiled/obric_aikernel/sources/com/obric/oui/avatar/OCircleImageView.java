package com.obric.oui.avatar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
public class OCircleImageView extends AppCompatImageView {
    private static final Bitmap.Config BITMAP_CONFIG = null;
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final boolean DEFAULT_BORDER_OVERLAY = false;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_CIRCLE_BACKGROUND_COLOR = 0;
    private static final int DEFAULT_IMAGE_ALPHA = 255;
    private static final ImageView.ScaleType SCALE_TYPE = null;
    private Bitmap mBitmap;
    private Canvas mBitmapCanvas;
    private final Paint mBitmapPaint;
    private int mBorderColor;
    private boolean mBorderOverlay;
    private final Paint mBorderPaint;
    private float mBorderRadius;
    private final RectF mBorderRect;
    private int mBorderWidth;
    private int mCircleBackgroundColor;
    private final Paint mCircleBackgroundPaint;
    private ColorFilter mColorFilter;
    private int mContentPadding;
    private boolean mDisableCircularTransformation;
    private boolean mDrawableDirty;
    private float mDrawableRadius;
    private final RectF mDrawableRect;
    private int mImageAlpha;
    private boolean mInitialized;
    private boolean mRebuildShader;
    private final Matrix mShaderMatrix;

    static /* synthetic */ class a {
    }

    @RequiresApi(api = 21)
    private class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCircleImageView f6212a;

        private b(OCircleImageView r10) {
            this.f6212a = r10;
        }

        /* synthetic */ b(OCircleImageView r10, a r11) {
            this(r10);
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            if (OCircleImageView.access$100(this.f6212a) == false) goto L5;
            ViewOutlineProvider.BACKGROUND.getOutline(r10, r11);
            return;
        L5:
            Rect r12 = new Rect();
            OCircleImageView.access$200(this.f6212a).roundOut(r12);
            r11.setRoundRect(r12, r12.width() / 2.0f);
        }
    }

    static {
        SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
        BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    }

    public OCircleImageView(Context r10) {
        super(r10);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCircleBackgroundPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mCircleBackgroundColor = 0;
        this.mImageAlpha = 255;
        init();
    }

    public OCircleImageView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OCircleImageView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mCircleBackgroundPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mCircleBackgroundColor = 0;
        this.mImageAlpha = 255;
        TypedArray r13 = r10.obtainStyledAttributes(r11, l.OCircleImageView, r12, 0);
        this.mBorderWidth = r13.getDimensionPixelSize(l.OCircleImageView_o_civ_border_width, 0);
        this.mBorderColor = r13.getColor(l.OCircleImageView_o_civ_border_color, -16777216);
        this.mBorderOverlay = r13.getBoolean(l.OCircleImageView_o_civ_border_overlay, false);
        this.mCircleBackgroundColor = r13.getColor(l.OCircleImageView_o_civ_circle_background_color, 0);
        r13.recycle();
        init();
    }

    static /* synthetic */ boolean access$100(OCircleImageView r10) {
        return r10.mDisableCircularTransformation;
    }

    static /* synthetic */ RectF access$200(OCircleImageView r10) {
        return r10.mBorderRect;
    }

    private RectF calculateBounds() {
        int r10 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r11 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r12 = Math.min(r10, r11);
        float r13 = getPaddingLeft() + ((r10 - r12) / 2.0f);
        float r14 = getPaddingTop() + ((r11 - r12) / 2.0f);
        float r15 = r12;
        return new RectF(r13, r14, r13 + r15, r15 + r14);
    }

    private RectF calculateContentBounds() {
        int r10 = getWidth() - (this.mContentPadding * 2);
        int r11 = getHeight() - (this.mContentPadding * 2);
        int r12 = Math.min(r11, r10);
        int r13 = this.mContentPadding;
        float r14 = r13 + ((r10 - r12) / 2.0f);
        float r15 = r13 + ((r11 - r12) / 2.0f);
        float r16 = r12;
        return new RectF(r14, r15, r14 + r16, r16 + r15);
    }

    private Bitmap getBitmapFromDrawable(Drawable r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof BitmapDrawable) == true) goto L8;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        if ((r10 instanceof ColorDrawable) == false) goto L12;
        Bitmap r11 = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);     // Catch: Exception -> L15
    L13:
        Canvas r12 = new Canvas(r11);     // Catch: Exception -> L15
        r10.setBounds(0, 0, r12.getWidth(), r12.getHeight());     // Catch: Exception -> L15
        r10.draw(r12);     // Catch: Exception -> L15
        return r11;
    L12:
        r11 = Bitmap.createBitmap(r10.getIntrinsicWidth(), r10.getIntrinsicHeight(), BITMAP_CONFIG);     // Catch: Exception -> L15
        goto L13
    L8:
        return ((BitmapDrawable) r10).getBitmap();
    }

    private boolean inTouchableArea(float r10, float r11) {
        if (this.mBorderRect.isEmpty() == false) goto L6;
        return true;
    L6:
        if ((Math.pow(r10 - this.mBorderRect.centerX(), 2.0d) + Math.pow(r11 - this.mBorderRect.centerY(), 2.0d)) <= Math.pow(this.mBorderRadius, 2.0d)) goto L10;
        return false;
    L10:
        return true;
    }

    private void init() {
        this.mInitialized = true;
        super.setScaleType(SCALE_TYPE);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setDither(true);
        this.mBitmapPaint.setFilterBitmap(true);
        this.mBitmapPaint.setAlpha(this.mImageAlpha);
        this.mBitmapPaint.setColorFilter(this.mColorFilter);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mCircleBackgroundPaint.setStyle(Paint.Style.FILL);
        this.mCircleBackgroundPaint.setAntiAlias(true);
        this.mCircleBackgroundPaint.setColor(this.mCircleBackgroundColor);
        if (Build.VERSION.SDK_INT < 21) goto L6;
        setOutlineProvider(new b(this, null));
        return;
    }

    private void initializeBitmap() {
        Bitmap r10 = getBitmapFromDrawable(getDrawable());
        this.mBitmap = r10;
        if (r10 != null) goto L5;
    L7:
        this.mBitmapCanvas = null;
    L9:
        if (this.mInitialized == true) goto L12;
        return;
    L12:
        if (this.mBitmap == null) goto L14;
        updateShaderMatrix();
        return;
    L14:
        this.mBitmapPaint.setShader(null);
        return;
    L5:
        if (r10.isMutable() == false) goto L7;
        this.mBitmapCanvas = new Canvas(this.mBitmap);
        goto L9
    }

    private void updateDimensions() {
        this.mBorderRect.set(calculateBounds());
        this.mBorderRadius = Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0f, (this.mBorderRect.width() - this.mBorderWidth) / 2.0f);
        this.mDrawableRect.set(calculateContentBounds());
        if (this.mBorderOverlay == true) goto L7;
        int r10 = this.mBorderWidth;
        if (r10 <= 0) goto L7;
        this.mDrawableRect.inset(r10 - 1.0f, r10 - 1.0f);
    L7:
        this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
        updateShaderMatrix();
    }

    private void updateShaderMatrix() {
        if (this.mBitmap != null) goto L5;
        return;
    L5:
        this.mShaderMatrix.set(null);
        int r10 = this.mBitmap.getHeight();
        float r11 = this.mBitmap.getWidth();
        float r12 = r10;
        float r13 = 0.0f;
        if ((this.mDrawableRect.height() * r11) <= (this.mDrawableRect.width() * r12)) goto L8;
        float r14 = this.mDrawableRect.height() / r12;
        float r15 = (this.mDrawableRect.width() - (r11 * r14)) * 0.5f;
        float r16 = 0.0f;
        r13 = r15;
    L9:
        this.mShaderMatrix.setScale(r14, r14);
        Matrix r17 = this.mShaderMatrix;
        float r18 = (int) (r13 + 0.5f);
        RectF r19 = this.mDrawableRect;
        r17.postTranslate(r18 + r19.left, ((int) (r16 + 0.5f)) + r19.top);
        this.mRebuildShader = true;
        return;
    L8:
        r14 = this.mDrawableRect.width() / r11;
        r16 = (this.mDrawableRect.height() - (r12 * r14)) * 0.5f;
        goto L9
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getCircleBackgroundColor() {
        return this.mCircleBackgroundColor;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        return this.mImageAlpha;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable r10) {
        this.mDrawableDirty = true;
        invalidate();
    }

    public boolean isBorderOverlay() {
        return this.mBorderOverlay;
    }

    public boolean isDisableCircularTransformation() {
        return this.mDisableCircularTransformation;
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"CanvasSize"})
    protected void onDraw(Canvas r10) {
        if (this.mDisableCircularTransformation == false) goto L7;
        super.onDraw(r10);
        return;
    L7:
        if (this.mCircleBackgroundColor == 0) goto L10;
        r10.drawCircle(this.mBorderRect.centerX(), this.mBorderRect.centerY(), this.mBorderRadius, this.mCircleBackgroundPaint);
    L10:
        if (this.mBitmap == null) goto L21;
        if (this.mDrawableDirty == false) goto L17;
        if (this.mBitmapCanvas == null) goto L17;
        this.mDrawableDirty = false;
        Drawable r11 = getDrawable();
        r11.setBounds(0, 0, this.mBitmapCanvas.getWidth(), this.mBitmapCanvas.getHeight());
        r11.draw(this.mBitmapCanvas);
    L17:
        if (this.mRebuildShader == false) goto L19;
        this.mRebuildShader = false;
        Bitmap r12 = this.mBitmap;
        Shader.TileMode r13 = Shader.TileMode.CLAMP;
        BitmapShader r14 = new BitmapShader(r12, r13, r13);
        r14.setLocalMatrix(this.mShaderMatrix);
        this.mBitmapPaint.setShader(r14);
    L19:
        r10.drawCircle(this.mDrawableRect.centerX(), this.mDrawableRect.centerY(), this.mDrawableRadius, this.mBitmapPaint);
    L21:
        if (this.mBorderWidth <= 0) goto L24;
        r10.drawCircle(this.mBorderRect.centerX(), this.mBorderRect.centerY(), this.mBorderRadius, this.mBorderPaint);
        return;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        updateDimensions();
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mDisableCircularTransformation == false) goto L7;
        return super.onTouchEvent(r10);
    L7:
        if (inTouchableArea(r10.getX(), r10.getY()) == true) goto L9;
    L11:
        return false;
    L9:
        if (super.onTouchEvent(r10) == false) goto L11;
        return true;
    }

    public void resetPaint() {
        this.mBorderPaint.reset();
        this.mBitmapPaint.reset();
        this.mCircleBackgroundPaint.reset();
        init();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r10) {
        if (r10 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("adjustViewBounds not supported.");
    }

    public void setBorderColor(@ColorInt int r10) {
        if (r10 != this.mBorderColor) goto L5;
        return;
    L5:
        this.mBorderColor = r10;
        this.mBorderPaint.setColor(r10);
        invalidate();
    }

    public void setBorderGradientColor(@ColorInt int r10, @ColorInt int r11) {
        RectF r12 = this.mBorderRect;
        float r13 = r12.left;
        float r14 = r12.top + (r12.height() / 2.0f);
        RectF r15 = this.mBorderRect;
        LinearGradient r16 = new LinearGradient(r13, r14, r15.right, r15.top + (r15.height() / 2.0f), r10, r11, Shader.TileMode.MIRROR);
        this.mBorderPaint.setShader(r16);
        invalidate();
    }

    public void setBorderOverlay(boolean r10) {
        if (r10 != this.mBorderOverlay) goto L5;
        return;
    L5:
        this.mBorderOverlay = r10;
        updateDimensions();
        invalidate();
    }

    public void setBorderWidth(int r10) {
        if (r10 != this.mBorderWidth) goto L5;
        return;
    L5:
        this.mBorderWidth = r10;
        this.mBorderPaint.setStrokeWidth(r10);
        updateDimensions();
        invalidate();
    }

    public void setCircleBackgroundColor(@ColorInt int r10) {
        if (r10 != this.mCircleBackgroundColor) goto L5;
        return;
    L5:
        this.mCircleBackgroundColor = r10;
        this.mCircleBackgroundPaint.setColor(r10);
        invalidate();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(@ColorRes int r10) {
        setCircleBackgroundColor(getContext().getResources().getColor(r10));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter r10) {
        if (r10 != this.mColorFilter) goto L5;
        return;
    L5:
        this.mColorFilter = r10;
        if (this.mInitialized == false) goto L9;
        this.mBitmapPaint.setColorFilter(r10);
        invalidate();
        return;
    }

    public void setContentPadding(int r10) {
        this.mContentPadding = r10;
        updateDimensions();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean r10) {
        if (r10 != this.mDisableCircularTransformation) goto L5;
        return;
    L5:
        this.mDisableCircularTransformation = r10;
        if (r10 == false) goto L8;
        this.mBitmap = null;
        this.mBitmapCanvas = null;
        this.mBitmapPaint.setShader(null);
    L9:
        invalidate();
        return;
    L8:
        initializeBitmap();
        goto L9
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int r10) {
        int r11 = r10 & 255;
        if (r11 != this.mImageAlpha) goto L5;
        return;
    L5:
        this.mImageAlpha = r11;
        if (this.mInitialized == false) goto L9;
        this.mBitmapPaint.setAlpha(r11);
        invalidate();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r10) {
        super.setImageBitmap(r10);
        initializeBitmap();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r10) {
        super.setImageDrawable(r10);
        initializeBitmap();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int r10) {
        super.setImageResource(r10);
        initializeBitmap();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r10) {
        super.setImageURI(r10);
        initializeBitmap();
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int r10, int r11, int r12, int r13) {
        super.setPadding(r10, r11, r12, r13);
        updateDimensions();
        invalidate();
    }

    @Override // android.view.View
    public void setPaddingRelative(int r10, int r11, int r12, int r13) {
        super.setPaddingRelative(r10, r11, r12, r13);
        updateDimensions();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r10) {
        if (r10 != SCALE_TYPE) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{r10}));
    }
}
