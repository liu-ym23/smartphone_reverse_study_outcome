package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.cardview.R;

/* JADX INFO: loaded from: classes.dex */
class RoundRectDrawableWithShadow extends Drawable {
    private static final double COS_45 = 0.0d;
    private static final float SHADOW_MULTIPLIER = 1.5f;
    static RoundRectHelper sRoundRectHelper;
    private boolean mAddPaddingForCorners;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private boolean mDirty;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private Paint mPaint;
    private boolean mPrintedShadowClipWarning;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;

    interface RoundRectHelper {
        void drawRoundRect(Canvas r10, RectF r11, float r12, Paint r13);
    }

    static {
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    RoundRectDrawableWithShadow(Resources r10, ColorStateList r11, float r12, float r13, float r14) {
        this.mDirty = true;
        this.mAddPaddingForCorners = true;
        this.mPrintedShadowClipWarning = false;
        this.mShadowStartColor = r10.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = r10.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = r10.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        setBackground(r11);
        Paint r15 = new Paint(5);
        this.mCornerShadowPaint = r15;
        r15.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (int) (r12 + 0.5f);
        this.mCardBounds = new RectF();
        Paint r16 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = r16;
        r16.setAntiAlias(false);
        setShadowSize(r13, r14);
    }

    private void buildComponents(Rect r10) {
        float r11 = this.mRawMaxShadowSize;
        float r12 = SHADOW_MULTIPLIER * r11;
        this.mCardBounds.set(r10.left + r11, r10.top + r12, r10.right - r11, r10.bottom - r12);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float r10 = this.mCornerRadius;
        RectF r11 = new RectF(-r10, -r10, r10, r10);
        RectF r12 = new RectF(r11);
        float r13 = this.mShadowSize;
        r12.inset(-r13, -r13);
        Path r14 = this.mCornerShadowPath;
        if (r14 != null) goto L5;
        this.mCornerShadowPath = new Path();
    L6:
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(r12, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(r11, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float r15 = this.mCornerRadius;
        float r16 = r15 / (this.mShadowSize + r15);
        Paint r17 = this.mCornerShadowPaint;
        float r18 = this.mCornerRadius + this.mShadowSize;
        int r19 = this.mShadowStartColor;
        r17.setShader(new RadialGradient(0.0f, 0.0f, r18, new int[]{r19, r19, this.mShadowEndColor}, new float[]{0.0f, r16, 1.0f}, Shader.TileMode.CLAMP));
        Paint r20 = this.mEdgeShadowPaint;
        float r21 = this.mCornerRadius;
        float r22 = this.mShadowSize;
        int r23 = this.mShadowStartColor;
        r20.setShader(new LinearGradient(0.0f, (-r21) + r22, 0.0f, (-r21) - r22, new int[]{r23, r23, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.mEdgeShadowPaint.setAntiAlias(false);
        return;
    L5:
        r14.reset();
        goto L6
    }

    static float calculateHorizontalPadding(float r10, float r11, boolean r12) {
        if (r12 == true) goto L4;
        return r10;
    L4:
        return (float) (((double) r10) + ((1.0d - COS_45) * ((double) r11)));
    }

    static float calculateVerticalPadding(float r10, float r11, boolean r12) {
        float r13 = r10 * SHADOW_MULTIPLIER;
        if (r12 == true) goto L5;
        return r13;
    L5:
        return (float) (((double) r13) + ((1.0d - COS_45) * ((double) r11)));
    }

    private void drawShadow(Canvas r13) {
        float r10 = this.mCornerRadius;
        float r11 = (-r10) - this.mShadowSize;
        float r12 = (r10 + this.mInsetShadow) + (this.mRawShadowSize / 2.0f);
        float r14 = r12 * 2.0f;
        if ((this.mCardBounds.width() - r14) <= 0.0f) goto L5;
        boolean r15 = true;
    L7:
        if ((this.mCardBounds.height() - r14) <= 0.0f) goto L9;
        boolean r16 = true;
    L10:
        int r17 = r13.save();
        RectF r18 = this.mCardBounds;
        r13.translate(r18.left + r12, r18.top + r12);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r15 == false) goto L13;
        r13.drawRect(0.0f, r11, this.mCardBounds.width() - r14, -this.mCornerRadius, this.mEdgeShadowPaint);
    L13:
        r13.restoreToCount(r17);
        int r19 = r13.save();
        RectF r20 = this.mCardBounds;
        r13.translate(r20.right - r12, r20.bottom - r12);
        r13.rotate(180.0f);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r15 == false) goto L16;
        r13.drawRect(0.0f, r11, this.mCardBounds.width() - r14, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
    L16:
        r13.restoreToCount(r19);
        int r21 = r13.save();
        RectF r22 = this.mCardBounds;
        r13.translate(r22.left + r12, r22.bottom - r12);
        r13.rotate(270.0f);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r16 == false) goto L19;
        r13.drawRect(0.0f, r11, this.mCardBounds.height() - r14, -this.mCornerRadius, this.mEdgeShadowPaint);
    L19:
        r13.restoreToCount(r21);
        int r23 = r13.save();
        RectF r24 = this.mCardBounds;
        r13.translate(r24.right - r12, r24.top + r12);
        r13.rotate(90.0f);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r16 == false) goto L22;
        r13.drawRect(0.0f, r11, this.mCardBounds.height() - r14, -this.mCornerRadius, this.mEdgeShadowPaint);
    L22:
        r13.restoreToCount(r23);
        return;
    L9:
        r16 = false;
        goto L10
    L5:
        r15 = false;
        goto L7
    }

    private void setBackground(ColorStateList r10) {
        if (r10 != null) goto L4;
        r10 = ColorStateList.valueOf(0);
    L4:
        this.mBackground = r10;
        this.mPaint.setColor(r10.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private void setShadowSize(float r10, float r11) {
        if (r10 < 0.0f) goto L22;
        if (r11 < 0.0f) goto L20;
        float r12 = toEven(r10);
        float r13 = toEven(r11);
        if (r12 <= r13) goto L13;
        if (this.mPrintedShadowClipWarning == true) goto L11;
        this.mPrintedShadowClipWarning = true;
    L11:
        r12 = r13;
    L13:
        if (this.mRawShadowSize == r12) goto L15;
    L17:
        this.mRawShadowSize = r12;
        this.mRawMaxShadowSize = r13;
        this.mShadowSize = (int) (((r12 * SHADOW_MULTIPLIER) + this.mInsetShadow) + 0.5f);
        this.mDirty = true;
        invalidateSelf();
        return;
    L15:
        if (this.mRawMaxShadowSize != r13) goto L17;
        return;
    L20:
        throw new IllegalArgumentException("Invalid max shadow size " + r11 + ". Must be >= 0");
    L22:
        throw new IllegalArgumentException("Invalid shadow size " + r10 + ". Must be >= 0");
    }

    private int toEven(float r10) {
        int r11 = (int) (r10 + 0.5f);
        if ((r11 % 2) == 1) goto L5;
        return r11;
    L5:
        return r11 - 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        if (this.mDirty == false) goto L5;
        buildComponents(getBounds());
        this.mDirty = false;
    L5:
        r10.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(r10);
        r10.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(r10, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    ColorStateList getColor() {
        return this.mBackground;
    }

    float getCornerRadius() {
        return this.mCornerRadius;
    }

    void getMaxShadowAndCornerPadding(Rect r10) {
        getPadding(r10);
    }

    float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    float getMinHeight() {
        float r10 = this.mRawMaxShadowSize;
        return (Math.max(r10, (this.mCornerRadius + this.mInsetShadow) + ((r10 * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * SHADOW_MULTIPLIER) + this.mInsetShadow) * 2.0f);
    }

    float getMinWidth() {
        float r10 = this.mRawMaxShadowSize;
        return (Math.max(r10, (this.mCornerRadius + this.mInsetShadow) + (r10 / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + this.mInsetShadow) * 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r10) {
        int r11 = (int) Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int r12 = (int) Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        r10.set(r12, r11, r12, r11);
        return true;
    }

    float getShadowSize() {
        return this.mRawShadowSize;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r10 = this.mBackground;
        if (r10 == null) goto L7;
        if (r10.isStateful() == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isStateful() == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r10) {
        super.onBoundsChange(r10);
        this.mDirty = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r10) {
        ColorStateList r11 = this.mBackground;
        int r12 = r11.getColorForState(r10, r11.getDefaultColor());
        if (this.mPaint.getColor() != r12) goto L6;
        return false;
    L6:
        this.mPaint.setColor(r12);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    void setAddPaddingForCorners(boolean r10) {
        this.mAddPaddingForCorners = r10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.mPaint.setAlpha(r10);
        this.mCornerShadowPaint.setAlpha(r10);
        this.mEdgeShadowPaint.setAlpha(r10);
    }

    void setColor(@Nullable ColorStateList r10) {
        setBackground(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.mPaint.setColorFilter(r10);
    }

    void setCornerRadius(float r10) {
        if (r10 < 0.0f) goto L10;
        float r11 = (int) (r10 + 0.5f);
        if (this.mCornerRadius != r11) goto L7;
        return;
    L7:
        this.mCornerRadius = r11;
        this.mDirty = true;
        invalidateSelf();
        return;
    L10:
        throw new IllegalArgumentException("Invalid radius " + r10 + ". Must be >= 0");
    }

    void setMaxShadowSize(float r10) {
        setShadowSize(this.mRawShadowSize, r10);
    }

    void setShadowSize(float r10) {
        setShadowSize(r10, this.mRawMaxShadowSize);
    }
}
