package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class RoundRectDrawable extends Drawable {
    private ColorStateList mBackground;
    private final RectF mBoundsF;
    private final Rect mBoundsI;
    private boolean mInsetForPadding;
    private boolean mInsetForRadius;
    private float mPadding;
    private final Paint mPaint;
    private float mRadius;
    private ColorStateList mTint;
    private PorterDuffColorFilter mTintFilter;
    private PorterDuff.Mode mTintMode;

    public RoundRectDrawable(ColorStateList r5, float r10) {
        this.mInsetForPadding = false;
        this.mInsetForRadius = true;
        this.mTintMode = PorterDuff.Mode.SRC_IN;
        this.mRadius = r10;
        this.mPaint = new Paint(5);
        setBackground(r5);
        this.mBoundsF = new RectF();
        this.mBoundsI = new Rect();
    }

    private PorterDuffColorFilter createTintFilter(ColorStateList r5, PorterDuff.Mode r10) {
        if (r5 == null) goto L7;
        if (r10 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r5.getColorForState(getState(), 0), r10);
    L7:
        return null;
    }

    private void setBackground(ColorStateList r5) {
        if (r5 != null) goto L4;
        r5 = ColorStateList.valueOf(0);
    L4:
        this.mBackground = r5;
        this.mPaint.setColor(r5.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private void updateBounds(Rect r10) {
        if (r10 != null) goto L4;
        r10 = getBounds();
    L4:
        this.mBoundsF.set(r10.left, r10.top, r10.right, r10.bottom);
        this.mBoundsI.set(r10);
        if (this.mInsetForPadding == false) goto L8;
        float r11 = RoundRectDrawableWithShadow.calculateVerticalPadding(this.mPadding, this.mRadius, this.mInsetForRadius);
        this.mBoundsI.inset((int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(this.mPadding, this.mRadius, this.mInsetForRadius)), (int) Math.ceil(r11));
        this.mBoundsF.set(this.mBoundsI);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        Paint r10 = this.mPaint;
        if (this.mTintFilter != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        RectF r12 = this.mBoundsF;
        float r13 = this.mRadius;
        r5.drawRoundRect(r12, r13, r13, r10);
        if (r11 == false) goto L12;
        r10.setColorFilter(null);
        return;
    L12:
        return;
    L5:
        if (r10.getColorFilter() != null) goto L7;
        r10.setColorFilter(this.mTintFilter);
        r11 = true;
        goto L8
    }

    public ColorStateList getColor() {
        return this.mBackground;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r5) {
        r5.setRoundRect(this.mBoundsI, this.mRadius);
    }

    public float getPadding() {
        return this.mPadding;
    }

    public float getRadius() {
        return this.mRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r5 = this.mTint;
        if (r5 != null) goto L5;
    L6:
        ColorStateList r10 = this.mBackground;
        if (r10 == null) goto L11;
        if (r10.isStateful() == false) goto L11;
    L12:
        return true;
    L11:
        if (super.isStateful() == true) goto L12;
        return false;
    L5:
        if (r5.isStateful() == true) goto L12;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        super.onBoundsChange(r5);
        updateBounds(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r5) {
        ColorStateList r10 = this.mBackground;
        int r11 = r10.getColorForState(r5, r10.getDefaultColor());
        if (r11 == this.mPaint.getColor()) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        this.mPaint.setColor(r11);
    L8:
        ColorStateList r13 = this.mTint;
        if (r13 == null) goto L14;
        PorterDuff.Mode r14 = this.mTintMode;
        if (r14 == null) goto L14;
        this.mTintFilter = createTintFilter(r13, r14);
        return true;
    L14:
        return r12;
    L5:
        r12 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        this.mPaint.setAlpha(r5);
    }

    public void setColor(@Nullable ColorStateList r5) {
        setBackground(r5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
        this.mPaint.setColorFilter(r5);
    }

    public void setPadding(float r5, boolean r10, boolean r11) {
        if (r5 == this.mPadding) goto L5;
    L9:
        this.mPadding = r5;
        this.mInsetForPadding = r10;
        this.mInsetForRadius = r11;
        updateBounds(null);
        invalidateSelf();
        return;
    L5:
        if (this.mInsetForPadding != r10) goto L9;
        if (this.mInsetForRadius != r11) goto L9;
    }

    public void setRadius(float r5) {
        if (r5 != this.mRadius) goto L5;
        return;
    L5:
        this.mRadius = r5;
        updateBounds(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r5) {
        this.mTint = r5;
        this.mTintFilter = createTintFilter(r5, this.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r5) {
        this.mTintMode = r5;
        this.mTintFilter = createTintFilter(this.mTint, r5);
        invalidateSelf();
    }
}
