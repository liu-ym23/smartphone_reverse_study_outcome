package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoundedBitmapDrawable extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS = 3;
    private boolean mApplyGravity;
    final Bitmap mBitmap;
    private int mBitmapHeight;
    private final BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private float mCornerRadius;
    final Rect mDstRect;
    private final RectF mDstRectF;
    private int mGravity;
    private boolean mIsCircular;
    private final Paint mPaint;
    private final Matrix mShaderMatrix;
    private int mTargetDensity;

    RoundedBitmapDrawable(Resources r10, Bitmap r11) {
        this.mTargetDensity = 160;
        this.mGravity = 119;
        this.mPaint = new Paint(3);
        this.mShaderMatrix = new Matrix();
        this.mDstRect = new Rect();
        this.mDstRectF = new RectF();
        this.mApplyGravity = true;
        if (r10 == null) goto L5;
        this.mTargetDensity = r10.getDisplayMetrics().densityDpi;
    L5:
        this.mBitmap = r11;
        if (r11 == null) goto L8;
        computeBitmapSize();
        Shader.TileMode r12 = Shader.TileMode.CLAMP;
        BitmapShader r13 = new BitmapShader(r11, r12, r12);
    L9:
        this.mBitmapShader = r13;
        return;
    L8:
        this.mBitmapHeight = -1;
        this.mBitmapWidth = -1;
        r13 = null;
        goto L9
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }

    private static boolean isGreaterThanZero(float r10) {
        if (r10 <= 0.05f) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateCircularCornerRadius() {
        this.mCornerRadius = Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        Bitmap r11 = this.mBitmap;
        if (r11 != null) goto L5;
        return;
    L5:
        updateDstRect();
        if (this.mPaint.getShader() != null) goto L8;
        r10.drawBitmap(r11, null, this.mDstRect, this.mPaint);
        return;
    L8:
        RectF r12 = this.mDstRectF;
        float r13 = this.mCornerRadius;
        r10.drawRoundRect(r12, r13, r13, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getGravity() {
        return this.mGravity;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mGravity == 119) goto L5;
        return -3;
    L5:
        if (this.mIsCircular == true) goto L22;
        Bitmap r10 = this.mBitmap;
        if (r10 != null) goto L10;
        return -3;
    L10:
        if (r10.hasAlpha() == false) goto L12;
        return -3;
    L12:
        if (this.mPaint.getAlpha() >= 255) goto L14;
        return -3;
    L14:
        if (isGreaterThanZero(this.mCornerRadius) == true) goto L23;
        return -1;
    L23:
        return -3;
    L22:
        return -3;
    }

    @NonNull
    public final Paint getPaint() {
        return this.mPaint;
    }

    void gravityCompatApply(int r10, int r11, int r12, Rect r13, Rect r14) {
        throw new UnsupportedOperationException();
    }

    public boolean hasAntiAlias() {
        return this.mPaint.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.mIsCircular;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect r10) {
        super.onBoundsChange(r10);
        if (this.mIsCircular == false) goto L5;
        updateCircularCornerRadius();
    L5:
        this.mApplyGravity = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        if (r10 == this.mPaint.getAlpha()) goto L6;
        this.mPaint.setAlpha(r10);
        invalidateSelf();
        return;
    }

    public void setAntiAlias(boolean r10) {
        this.mPaint.setAntiAlias(r10);
        invalidateSelf();
    }

    public void setCircular(boolean r10) {
        this.mIsCircular = r10;
        this.mApplyGravity = true;
        if (r10 == false) goto L5;
        updateCircularCornerRadius();
        this.mPaint.setShader(this.mBitmapShader);
        invalidateSelf();
        return;
    L5:
        setCornerRadius(0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.mPaint.setColorFilter(r10);
        invalidateSelf();
    }

    public void setCornerRadius(float r10) {
        if (this.mCornerRadius != r10) goto L5;
        return;
    L5:
        this.mIsCircular = false;
        if (isGreaterThanZero(r10) == false) goto L8;
        Paint r11 = this.mPaint;
        BitmapShader r12 = this.mBitmapShader;
    L9:
        r11.setShader(r12);
        this.mCornerRadius = r10;
        invalidateSelf();
        return;
    L8:
        r11 = this.mPaint;
        r12 = null;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r10) {
        this.mPaint.setDither(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r10) {
        this.mPaint.setFilterBitmap(r10);
        invalidateSelf();
    }

    public void setGravity(int r10) {
        if (this.mGravity == r10) goto L6;
        this.mGravity = r10;
        this.mApplyGravity = true;
        invalidateSelf();
        return;
    }

    public void setMipMap(boolean r10) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(int r10) {
        if (this.mTargetDensity == r10) goto L11;
        if (r10 != 0) goto L6;
        r10 = 160;
    L6:
        this.mTargetDensity = r10;
        if (this.mBitmap == null) goto L9;
        computeBitmapSize();
    L9:
        invalidateSelf();
        return;
    }

    public void setTargetDensity(@NonNull Canvas r10) {
        setTargetDensity(r10.getDensity());
    }

    public void setTargetDensity(@NonNull DisplayMetrics r10) {
        setTargetDensity(r10.densityDpi);
    }

    void updateDstRect() {
        if (this.mApplyGravity == true) goto L5;
        return;
    L5:
        if (this.mIsCircular == false) goto L7;
        int r10 = Math.min(this.mBitmapWidth, this.mBitmapHeight);
        gravityCompatApply(this.mGravity, r10, r10, getBounds(), this.mDstRect);
        int r11 = Math.min(this.mDstRect.width(), this.mDstRect.height());
        this.mDstRect.inset(Math.max(0, (this.mDstRect.width() - r11) / 2), Math.max(0, (this.mDstRect.height() - r11) / 2));
        this.mCornerRadius = r11 * 0.5f;
    L8:
        this.mDstRectF.set(this.mDstRect);
        if (this.mBitmapShader == null) goto L11;
        Matrix r12 = this.mShaderMatrix;
        RectF r13 = this.mDstRectF;
        r12.setTranslate(r13.left, r13.top);
        this.mShaderMatrix.preScale(this.mDstRectF.width() / this.mBitmap.getWidth(), this.mDstRectF.height() / this.mBitmap.getHeight());
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
        this.mPaint.setShader(this.mBitmapShader);
    L11:
        this.mApplyGravity = false;
        return;
    L7:
        gravityCompatApply(this.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.mDstRect);
        goto L8
    }
}
