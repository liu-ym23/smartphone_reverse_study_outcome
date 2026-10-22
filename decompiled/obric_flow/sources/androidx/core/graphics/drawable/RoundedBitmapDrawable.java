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

    public RoundedBitmapDrawable(Resources r5, Bitmap r10) {
        this.mTargetDensity = 160;
        this.mGravity = 119;
        this.mPaint = new Paint(3);
        this.mShaderMatrix = new Matrix();
        this.mDstRect = new Rect();
        this.mDstRectF = new RectF();
        this.mApplyGravity = true;
        if (r5 == null) goto L5;
        this.mTargetDensity = r5.getDisplayMetrics().densityDpi;
    L5:
        this.mBitmap = r10;
        if (r10 == null) goto L8;
        computeBitmapSize();
        Shader.TileMode r11 = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(r10, r11, r11);
        return;
    L8:
        this.mBitmapHeight = -1;
        this.mBitmapWidth = -1;
        this.mBitmapShader = null;
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }

    private static boolean isGreaterThanZero(float r5) {
        if (r5 <= 0.05f) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateCircularCornerRadius() {
        this.mCornerRadius = Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r5) {
        Bitmap r10 = this.mBitmap;
        if (r10 != null) goto L5;
        return;
    L5:
        updateDstRect();
        if (this.mPaint.getShader() != null) goto L8;
        r5.drawBitmap(r10, null, this.mDstRect, this.mPaint);
        return;
    L8:
        RectF r11 = this.mDstRectF;
        float r12 = this.mCornerRadius;
        r5.drawRoundRect(r11, r12, r12, this.mPaint);
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
        Bitmap r5 = this.mBitmap;
        if (r5 != null) goto L10;
        return -3;
    L10:
        if (r5.hasAlpha() == false) goto L12;
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

    public void gravityCompatApply(int r5, int r10, int r11, Rect r12, Rect r13) {
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
    public void onBoundsChange(@NonNull Rect r5) {
        super.onBoundsChange(r5);
        if (this.mIsCircular == false) goto L5;
        updateCircularCornerRadius();
    L5:
        this.mApplyGravity = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        if (r5 == this.mPaint.getAlpha()) goto L6;
        this.mPaint.setAlpha(r5);
        invalidateSelf();
        return;
    }

    public void setAntiAlias(boolean r5) {
        this.mPaint.setAntiAlias(r5);
        invalidateSelf();
    }

    public void setCircular(boolean r5) {
        this.mIsCircular = r5;
        this.mApplyGravity = true;
        if (r5 == false) goto L5;
        updateCircularCornerRadius();
        this.mPaint.setShader(this.mBitmapShader);
        invalidateSelf();
        return;
    L5:
        setCornerRadius(0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
        this.mPaint.setColorFilter(r5);
        invalidateSelf();
    }

    public void setCornerRadius(float r5) {
        if (this.mCornerRadius != r5) goto L5;
        return;
    L5:
        this.mIsCircular = false;
        if (isGreaterThanZero(r5) == false) goto L8;
        this.mPaint.setShader(this.mBitmapShader);
    L9:
        this.mCornerRadius = r5;
        invalidateSelf();
        return;
    L8:
        this.mPaint.setShader(null);
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r5) {
        this.mPaint.setDither(r5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r5) {
        this.mPaint.setFilterBitmap(r5);
        invalidateSelf();
    }

    public void setGravity(int r5) {
        if (this.mGravity == r5) goto L6;
        this.mGravity = r5;
        this.mApplyGravity = true;
        invalidateSelf();
        return;
    }

    public void setMipMap(boolean r5) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(@NonNull Canvas r5) {
        setTargetDensity(r5.getDensity());
    }

    public void updateDstRect() {
        if (this.mApplyGravity == true) goto L5;
        return;
    L5:
        if (this.mIsCircular == false) goto L7;
        int r10 = Math.min(this.mBitmapWidth, this.mBitmapHeight);
        gravityCompatApply(this.mGravity, r10, r10, getBounds(), this.mDstRect);
        int r5 = Math.min(this.mDstRect.width(), this.mDstRect.height());
        this.mDstRect.inset(Math.max(0, (this.mDstRect.width() - r5) / 2), Math.max(0, (this.mDstRect.height() - r5) / 2));
        this.mCornerRadius = r5 * 0.5f;
    L8:
        this.mDstRectF.set(this.mDstRect);
        if (this.mBitmapShader == null) goto L11;
        Matrix r11 = this.mShaderMatrix;
        RectF r12 = this.mDstRectF;
        r11.setTranslate(r12.left, r12.top);
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

    public void setTargetDensity(@NonNull DisplayMetrics r5) {
        setTargetDensity(r5.densityDpi);
    }

    public void setTargetDensity(int r5) {
        if (this.mTargetDensity == r5) goto L11;
        if (r5 != 0) goto L6;
        r5 = 160;
    L6:
        this.mTargetDensity = r5;
        if (this.mBitmap == null) goto L9;
        computeBitmapSize();
    L9:
        invalidateSelf();
        return;
    }
}
