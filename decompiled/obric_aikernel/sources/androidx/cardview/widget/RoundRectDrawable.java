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

    RoundRectDrawable(ColorStateList r10, float r11) {
        this.mInsetForPadding = false;
        this.mInsetForRadius = true;
        this.mTintMode = PorterDuff.Mode.SRC_IN;
        this.mRadius = r11;
        this.mPaint = new Paint(5);
        setBackground(r10);
        this.mBoundsF = new RectF();
        this.mBoundsI = new Rect();
    }

    private PorterDuffColorFilter createTintFilter(ColorStateList r10, PorterDuff.Mode r11) {
        if (r10 == null) goto L7;
        if (r11 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r10.getColorForState(getState(), 0), r11);
    L7:
        return null;
    }

    private void setBackground(ColorStateList r10) {
        if (r10 != null) goto L4;
        r10 = ColorStateList.valueOf(0);
    L4:
        this.mBackground = r10;
        this.mPaint.setColor(r10.getColorForState(getState(), this.mBackground.getDefaultColor()));
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
    public void draw(Canvas r10) {
        Paint r11 = this.mPaint;
        if (this.mTintFilter != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        RectF r13 = this.mBoundsF;
        float r14 = this.mRadius;
        r10.drawRoundRect(r13, r14, r14, r11);
        if (r12 == false) goto L12;
        r11.setColorFilter(null);
        return;
    L12:
        return;
    L5:
        if (r11.getColorFilter() != null) goto L7;
        r11.setColorFilter(this.mTintFilter);
        r12 = true;
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
    public void getOutline(Outline r10) {
        r10.setRoundRect(this.mBoundsI, this.mRadius);
    }

    float getPadding() {
        return this.mPadding;
    }

    public float getRadius() {
        return this.mRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r10 = this.mTint;
        if (r10 != null) goto L5;
    L6:
        ColorStateList r11 = this.mBackground;
        if (r11 == null) goto L11;
        if (r11.isStateful() == false) goto L11;
    L12:
        return true;
    L11:
        if (super.isStateful() == true) goto L12;
        return false;
    L5:
        if (r10.isStateful() == true) goto L12;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r10) {
        super.onBoundsChange(r10);
        updateBounds(r10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r10) {
        ColorStateList r11 = this.mBackground;
        int r12 = r11.getColorForState(r10, r11.getDefaultColor());
        if (r12 == this.mPaint.getColor()) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L8;
        this.mPaint.setColor(r12);
    L8:
        ColorStateList r14 = this.mTint;
        if (r14 == null) goto L14;
        PorterDuff.Mode r15 = this.mTintMode;
        if (r15 == null) goto L14;
        this.mTintFilter = createTintFilter(r14, r15);
        return true;
    L14:
        return r13;
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.mPaint.setAlpha(r10);
    }

    public void setColor(@Nullable ColorStateList r10) {
        setBackground(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.mPaint.setColorFilter(r10);
    }

    void setPadding(float r10, boolean r11, boolean r12) {
        if (r10 == this.mPadding) goto L5;
    L9:
        this.mPadding = r10;
        this.mInsetForPadding = r11;
        this.mInsetForRadius = r12;
        updateBounds(null);
        invalidateSelf();
        return;
    L5:
        if (this.mInsetForPadding != r11) goto L9;
        if (this.mInsetForRadius != r12) goto L9;
    }

    void setRadius(float r10) {
        if (r10 != this.mRadius) goto L5;
        return;
    L5:
        this.mRadius = r10;
        updateBounds(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r10) {
        this.mTint = r10;
        this.mTintFilter = createTintFilter(r10, this.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r10) {
        this.mTintMode = r10;
        this.mTintFilter = createTintFilter(this.mTint, r10);
        invalidateSelf();
    }
}
