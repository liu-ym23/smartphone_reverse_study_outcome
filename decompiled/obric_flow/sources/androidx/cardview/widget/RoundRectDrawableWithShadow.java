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

    public interface RoundRectHelper {
        void drawRoundRect(Canvas r5, RectF r10, float r11, Paint r12);
    }

    static {
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public RoundRectDrawableWithShadow(Resources r5, ColorStateList r10, float r11, float r12, float r13) {
        this.mDirty = true;
        this.mAddPaddingForCorners = true;
        this.mPrintedShadowClipWarning = false;
        this.mShadowStartColor = r5.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = r5.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = r5.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        setBackground(r10);
        Paint r14 = new Paint(5);
        this.mCornerShadowPaint = r14;
        r14.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (int) (r11 + 0.5f);
        this.mCardBounds = new RectF();
        Paint r15 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = r15;
        r15.setAntiAlias(false);
        setShadowSize(r12, r13);
    }

    private void buildComponents(Rect r10) {
        float r5 = this.mRawMaxShadowSize;
        float r11 = SHADOW_MULTIPLIER * r5;
        this.mCardBounds.set(r10.left + r5, r10.top + r11, r10.right - r5, r10.bottom - r11);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float r5 = this.mCornerRadius;
        RectF r10 = new RectF(-r5, -r5, r5, r5);
        RectF r11 = new RectF(r10);
        float r12 = this.mShadowSize;
        r11.inset(-r12, -r12);
        Path r13 = this.mCornerShadowPath;
        if (r13 != null) goto L5;
        this.mCornerShadowPath = new Path();
    L6:
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(r11, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(r10, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float r14 = this.mCornerRadius;
        float r15 = r14 / (this.mShadowSize + r14);
        Paint r16 = this.mCornerShadowPaint;
        float r17 = this.mCornerRadius + this.mShadowSize;
        int r18 = this.mShadowStartColor;
        Shader.TileMode r21 = Shader.TileMode.CLAMP;
        r16.setShader(new RadialGradient(0.0f, 0.0f, r17, new int[]{r18, r18, this.mShadowEndColor}, new float[]{0.0f, r15, 1.0f}, r21));
        Paint r19 = this.mEdgeShadowPaint;
        float r20 = this.mCornerRadius;
        float r22 = this.mShadowSize;
        float r110 = (-r20) + r22;
        float r111 = (-r20) - r22;
        int r23 = this.mShadowStartColor;
        r19.setShader(new LinearGradient(0.0f, r110, 0.0f, r111, new int[]{r23, r23, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, r21));
        this.mEdgeShadowPaint.setAntiAlias(false);
        return;
    L5:
        r13.reset();
        goto L6
    }

    public static float calculateHorizontalPadding(float r10, float r11, boolean r12) {
        if (r12 == true) goto L4;
        return r10;
    L4:
        return (float) (((1.0d - COS_45) * ((double) r11)) + r10);
    }

    public static float calculateVerticalPadding(float r10, float r11, boolean r12) {
        if (r12 == false) goto L7;
        return (float) (((1.0d - COS_45) * ((double) r11)) + (r10 * SHADOW_MULTIPLIER));
    L7:
        return r10 * SHADOW_MULTIPLIER;
    }

    private void drawShadow(Canvas r13) {
        float r5 = this.mCornerRadius;
        float r10 = (-r5) - this.mShadowSize;
        float r11 = (this.mRawShadowSize / 2.0f) + (r5 + this.mInsetShadow);
        float r12 = r11 * 2.0f;
        if ((this.mCardBounds.width() - r12) <= 0.0f) goto L5;
        boolean r14 = true;
    L7:
        if ((this.mCardBounds.height() - r12) <= 0.0f) goto L9;
        boolean r15 = true;
    L10:
        int r16 = r13.save();
        RectF r17 = this.mCardBounds;
        r13.translate(r17.left + r11, r17.top + r11);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r14 == false) goto L13;
        r13.drawRect(0.0f, r10, this.mCardBounds.width() - r12, -this.mCornerRadius, this.mEdgeShadowPaint);
    L13:
        r13.restoreToCount(r16);
        int r18 = r13.save();
        RectF r19 = this.mCardBounds;
        r13.translate(r19.right - r11, r19.bottom - r11);
        r13.rotate(180.0f);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r14 == false) goto L16;
        r13.drawRect(0.0f, r10, this.mCardBounds.width() - r12, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
    L16:
        r13.restoreToCount(r18);
        int r20 = r13.save();
        RectF r21 = this.mCardBounds;
        r13.translate(r21.left + r11, r21.bottom - r11);
        r13.rotate(270.0f);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r15 == false) goto L19;
        r13.drawRect(0.0f, r10, this.mCardBounds.height() - r12, -this.mCornerRadius, this.mEdgeShadowPaint);
    L19:
        r13.restoreToCount(r20);
        int r22 = r13.save();
        RectF r23 = this.mCardBounds;
        r13.translate(r23.right - r11, r23.top + r11);
        r13.rotate(90.0f);
        r13.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (r15 == false) goto L22;
        r13.drawRect(0.0f, r10, this.mCardBounds.height() - r12, -this.mCornerRadius, this.mEdgeShadowPaint);
    L22:
        r13.restoreToCount(r22);
        return;
    L9:
        r15 = false;
        goto L10
    L5:
        r14 = false;
        goto L7
    }

    private void setBackground(ColorStateList r5) {
        if (r5 != null) goto L4;
        r5 = ColorStateList.valueOf(0);
    L4:
        this.mBackground = r5;
        this.mPaint.setColor(r5.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private void setShadowSize(float r5, float r10) {
        if (r5 < 0.0f) goto L22;
        if (r10 < 0.0f) goto L20;
        float r11 = toEven(r5);
        float r12 = toEven(r10);
        if (r11 <= r12) goto L13;
        if (this.mPrintedShadowClipWarning == true) goto L11;
        this.mPrintedShadowClipWarning = true;
    L11:
        r11 = r12;
    L13:
        if (this.mRawShadowSize == r11) goto L15;
    L17:
        this.mRawShadowSize = r11;
        this.mRawMaxShadowSize = r12;
        this.mShadowSize = (int) (((r11 * SHADOW_MULTIPLIER) + this.mInsetShadow) + 0.5f);
        this.mDirty = true;
        invalidateSelf();
        return;
    L15:
        if (this.mRawMaxShadowSize != r12) goto L17;
        return;
    L20:
        throw new IllegalArgumentException("Invalid max shadow size " + r10 + ". Must be >= 0");
    L22:
        throw new IllegalArgumentException("Invalid shadow size " + r5 + ". Must be >= 0");
    }

    private int toEven(float r5) {
        int r10 = (int) (r5 + 0.5f);
        if ((r10 % 2) == 1) goto L5;
        return r10;
    L5:
        return r10 - 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        if (this.mDirty == false) goto L5;
        buildComponents(getBounds());
        this.mDirty = false;
    L5:
        r5.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(r5);
        r5.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(r5, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    public ColorStateList getColor() {
        return this.mBackground;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public void getMaxShadowAndCornerPadding(Rect r5) {
        getPadding(r5);
    }

    public float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    public float getMinHeight() {
        float r5 = this.mRawMaxShadowSize;
        return (((this.mRawMaxShadowSize * SHADOW_MULTIPLIER) + this.mInsetShadow) * 2.0f) + (Math.max(r5, ((r5 * SHADOW_MULTIPLIER) / 2.0f) + (this.mCornerRadius + this.mInsetShadow)) * 2.0f);
    }

    public float getMinWidth() {
        float r5 = this.mRawMaxShadowSize;
        return ((this.mRawMaxShadowSize + this.mInsetShadow) * 2.0f) + (Math.max(r5, (r5 / 2.0f) + (this.mCornerRadius + this.mInsetShadow)) * 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r5) {
        int r10 = (int) Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int r11 = (int) Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        r5.set(r11, r10, r11, r10);
        return true;
    }

    public float getShadowSize() {
        return this.mRawShadowSize;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r5 = this.mBackground;
        if (r5 == null) goto L7;
        if (r5.isStateful() == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isStateful() == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        super.onBoundsChange(r5);
        this.mDirty = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r5) {
        ColorStateList r10 = this.mBackground;
        int r11 = r10.getColorForState(r5, r10.getDefaultColor());
        if (this.mPaint.getColor() != r11) goto L6;
        return false;
    L6:
        this.mPaint.setColor(r11);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    public void setAddPaddingForCorners(boolean r5) {
        this.mAddPaddingForCorners = r5;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        this.mPaint.setAlpha(r5);
        this.mCornerShadowPaint.setAlpha(r5);
        this.mEdgeShadowPaint.setAlpha(r5);
    }

    public void setColor(@Nullable ColorStateList r5) {
        setBackground(r5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
        this.mPaint.setColorFilter(r5);
    }

    public void setCornerRadius(float r5) {
        if (r5 < 0.0f) goto L10;
        float r10 = (int) (r5 + 0.5f);
        if (this.mCornerRadius != r10) goto L7;
        return;
    L7:
        this.mCornerRadius = r10;
        this.mDirty = true;
        invalidateSelf();
        return;
    L10:
        throw new IllegalArgumentException("Invalid radius " + r5 + ". Must be >= 0");
    }

    public void setMaxShadowSize(float r5) {
        setShadowSize(this.mRawShadowSize, r5);
    }

    public void setShadowSize(float r5) {
        setShadowSize(r5, this.mRawMaxShadowSize);
    }
}
