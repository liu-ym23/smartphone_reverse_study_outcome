package com.larksuite.component.ui.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.utils.CarUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUIRoundedImageView extends AppCompatImageView {
    private static final int DEFAULT_BADGE_POSITION_ANGLE = -45;
    private static final int DEFAULT_BADGE_TEXT_PADDING = 2;
    private static final int DEFAULT_BADGE_TEXT_SIZE = 12;
    float mBadgeCenterX;
    float mBadgeCenterY;
    boolean mBadgeEnable;
    private int mBadgePadding;
    private int mBadgePosAngle;
    private int mBadgeTextColor;
    private int mBadgeTextSize;
    private RectF mBordRectF;
    private int mBorderColor;
    Drawable mBorderDrawable;
    private int mBorderPadding;
    private Paint mBorderPaint;
    private float mBorderWidth;
    private Paint mClearPaint;
    private Path mClearPath;
    private Matrix mImageMatrix;
    Paint mImagePaint;
    private RectF mImageRectF;
    private boolean mIsOval;
    private boolean mIsTouchSelectModeEnabled;
    a mLkUIBadgeDrawable;
    private Path mPath;
    private float[] mRadiusii;
    private final int mSelectedBorderColor;
    private PorterDuffColorFilter mSelectedColorFilter;
    private final int mSelectedMaskColor;
    private RectF mViewRectF;

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        setLayerType(2, null);
        Paint r0 = new Paint();
        this.mImagePaint = r0;
        r0.setFilterBitmap(true);
        this.mImagePaint.setAntiAlias(true);
        this.mImagePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPath = new Path();
        Paint r1 = new Paint();
        this.mBorderPaint = r1;
        r1.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        if (this.mSelectedMaskColor == 0) goto L5;
        this.mSelectedColorFilter = new PorterDuffColorFilter(this.mSelectedMaskColor, PorterDuff.Mode.DARKEN);
    L5:
        this.mImageMatrix = new Matrix();
        Paint r2 = new Paint(1);
        this.mClearPaint = r2;
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void compute() {
        this.mViewRectF.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        Drawable r0 = this.mBorderDrawable;
        if (r0 == null) goto L5;
        RectF r1 = this.mViewRectF;
        r0.setBounds((int) r1.left, (int) r1.top, (int) r1.right, (int) r1.bottom);
    L5:
        float r2 = (this.mBorderWidth * 1.0f) / 2.0f;
        this.mBordRectF.set(this.mViewRectF);
        this.mBordRectF.inset(r2, r2);
        this.mImageRectF.set(this.mViewRectF);
        RectF r3 = this.mImageRectF;
        float r4 = this.mBorderWidth;
        int r5 = this.mBorderPadding;
        r3.inset(r5 + r4, r4 + r5);
        if (this.mIsOval == true) goto L8;
        return;
    L8:
        if (this.mLkUIBadgeDrawable == null) goto L12;
        float r6 = this.mBordRectF.width() / 2.0f;
        float r7 = this.mBordRectF.height() / 2.0f;
        this.mBadgeCenterX = (float) (((double) (getWidth() / 2)) + (Math.cos((((double) this.mBadgePosAngle) * 6.283185307179586d) / 360.0d) * ((double) r6)));
        this.mBadgeCenterY = (float) (((double) (getHeight() / 2)) + (Math.sin((((double) this.mBadgePosAngle) * 6.283185307179586d) / 360.0d) * ((double) r7)));
        this.mBadgeCenterX = Math.min(this.mBadgeCenterX, getWidth() - (this.mLkUIBadgeDrawable.j / 2));
        this.mBadgeCenterY = Math.max(this.mBadgeCenterY, this.mLkUIBadgeDrawable.k / 2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a getBadgeDrawable() {
        if (this.mLkUIBadgeDrawable != null) goto L6;
        a.C0035a r0 = new a.C0035a(getContext());
        r0.f = this.mBadgePadding;
        r0.b = this.mBadgeTextSize;
        r0.d = this.mBadgeTextColor;
        a r1 = new a(r0);
        this.mLkUIBadgeDrawable = r1;
        r1.setCallback(this);
        this.mBadgeEnable = true;
    L6:
        return this.mLkUIBadgeDrawable;
    }

    public float getCornerRadius() {
        return this.mRadiusii[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.widget.ImageView*/.onAttachedToWindow();
        if (CarUtils.c() == false) goto L6;
        setLayerType(1, null);
        return;
    }

    public boolean isOval() {
        return this.mIsOval;
    }

    public LKUIRoundedImageView(Context r2) {
        this(r2, null);
    }

    private void drawBadge(Canvas r3) {
        if (this.mIsOval == true) goto L5;
        return;
    L5:
        if (this.mBadgeEnable == false) goto L20;
        a r0 = this.mLkUIBadgeDrawable;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.c == null) goto L11;
    L15:
        boolean r1 = false;
    L16:
        if (r1 == true) goto L22;
        r3.save();
        r3.translate(this.mBadgeCenterX, this.mBadgeCenterY);
        this.mLkUIBadgeDrawable.draw(r3);
        r3.restore();
        return;
    L22:
        return;
    L11:
        if (r0.e != null) goto L15;
        if (TextUtils.isEmpty(r0.a) == false) goto L15;
        r1 = true;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void drawBoard(Canvas r5) {
        if (this.mBorderWidth <= 0.0f) goto L5;
    L7:
        Drawable r0 = this.mBorderDrawable;
        if (r0 == null) goto L10;
        r0.draw(r5);
        return;
    L10:
        Paint r1 = this.mBorderPaint;
        if (isSelected() == false) goto L13;
        int r2 = this.mSelectedBorderColor;
    L14:
        r1.setColor(r2);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mPath.reset();
        if (this.mIsOval == false) goto L17;
        this.mPath.addOval(this.mBordRectF, Path.Direction.CW);
    L18:
        r5.drawPath(this.mPath, this.mBorderPaint);
        return;
    L17:
        this.mPath.addRoundRect(this.mBordRectF, this.mRadiusii, Path.Direction.CW);
        goto L18
    L13:
        r2 = this.mBorderColor;
        goto L14
    L5:
        if (this.mBorderDrawable != null) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void drawImage(Canvas r7) {
        Drawable r0 = getDrawable();
        if (isDrawableValid(r0) == true) goto L5;
        return;
    L5:
        Rect r1 = r0.getBounds();
        if (r1.width() != 0) goto L8;
        return;
    L8:
        if (r1.height() == 0) goto L28;
        int r2 = r0.getIntrinsicWidth();
        int r3 = r0.getIntrinsicHeight();
        if (r2 > 0) goto L13;
        r2 = r1.width();
    L13:
        if (r3 > 0) goto L15;
        r3 = r1.height();
    L15:
        float r4 = r2;
        float r5 = r3;
        float r6 = Math.max((this.mImageRectF.width() * 1.0f) / r4, (this.mImageRectF.height() * 1.0f) / r5);
        this.mImageMatrix.reset();
        this.mImageMatrix.setScale(r6, r6);
        this.mImageMatrix.postTranslate((-((r4 * r6) - getWidth())) / 2.0f, (-((r6 * r5) - getHeight())) / 2.0f);
        int r8 = r7.getSaveCount();
        r7.save();
        this.mPath.reset();
        if (this.mIsOval == false) goto L18;
        this.mPath.addOval(this.mImageRectF, Path.Direction.CW);
    L19:
        Matrix r9 = this.mImageMatrix;
        if (r9 == null) goto L22;
        r7.setMatrix(r9);
    L22:
        r0.draw(r7);
        if (getCropToPadding() == false) goto L25;
        int r10 = getScrollX();
        int r11 = getScrollY();
        r7.clipRect(getPaddingLeft() + r10, getPaddingTop() + r11, ((r10 + getRight()) - getLeft()) - getPaddingRight(), ((r11 + getBottom()) - getTop()) - getPaddingRight());
    L25:
        r7.restoreToCount(r8);
        this.mClearPath.reset();
        this.mClearPath.set(this.mPath);
        this.mClearPath.toggleInverseFillType();
        r7.drawPath(this.mClearPath, this.mClearPaint);
        return;
    L18:
        this.mPath.addRoundRect(this.mImageRectF, this.mRadiusii, Path.Direction.CW);
        goto L19
    }

    private boolean isDrawableValid(Drawable r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if ((r4 instanceof BitmapDrawable) == false) goto L12;
        Bitmap r5 = ((BitmapDrawable) r4).getBitmap();
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.isRecycled() == true) goto L15;
        return true;
    L15:
        return false;
    L12:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void invalidateDrawable(Drawable r2) {
        if (r2 != this.mLkUIBadgeDrawable) goto L5;
        invalidate();
        return;
    L5:
        super/*android.widget.ImageView*/.invalidateDrawable(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r2) {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L10;
        compute();
        drawImage(r2);
        drawBoard(r2);
        drawBadge(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r3) {
        if (isClickable() == true) goto L7;
        setSelected(false);
        return super/*android.widget.ImageView*/.onTouchEvent(r3);
    L7:
        if (this.mIsTouchSelectModeEnabled == true) goto L11;
        return super/*android.widget.ImageView*/.onTouchEvent(r3);
    L11:
        if (r3.getAction() == 0) goto L13;
        setSelected(false);
    L15:
        return super/*android.widget.ImageView*/.onTouchEvent(r3);
    L13:
        setSelected(true);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBadgeEnable(boolean r1) {
        this.mBadgeEnable = r1;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBadgePosAngle(int r2) {
        if (this.mBadgePosAngle == r2) goto L6;
        this.mBadgePosAngle = r2;
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderColor(int r2) {
        if (this.mBorderColor == r2) goto L6;
        this.mBorderColor = r2;
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderDrawable(Drawable r2) {
        if (this.mBorderDrawable == r2) goto L6;
        this.mBorderDrawable = r2;
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderPaddingInDp(float r2) {
        float r3 = j08.b.a(getContext(), r2);
        if (r3 == this.mBorderPadding) goto L6;
        this.mBorderPadding = (int) r3;
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderWidthDP(float r2) {
        float r3 = j08.b.a(getContext(), r2);
        if (r3 == this.mBorderWidth) goto L6;
        this.mBorderWidth = r3;
        invalidate();
        return;
    }

    public void setCornerRadiusDP(float r1) {
        setCornerRadiusDP(r1, r1, r1, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOval(boolean r1) {
        this.mIsOval = r1;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSelected(boolean r2) {
        if (r2 == isSelected()) goto L10;
        super/*android.widget.ImageView*/.setSelected(r2);
        if (r2 == false) goto L7;
        PorterDuffColorFilter r3 = this.mSelectedColorFilter;
    L8:
        setColorFilter(r3);
        invalidate();
        return;
    L7:
        r3 = null;
        goto L8
    }

    public LKUIRoundedImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r8, int r9) {
        super/*android.widget.ImageView*/.onMeasure(r8, r9);
        int r0 = getMeasuredWidth();
        int r1 = getMeasuredHeight();
        if (this.mIsOval == true) goto L41;
        int r10 = View.MeasureSpec.getMode(r8);
        int r11 = View.MeasureSpec.getMode(r9);
        Drawable r2 = getDrawable();
        if (r2 != null) goto L7;
        return;
    L7:
        boolean r3 = false;
        if (r10 == Integer.MIN_VALUE) goto L12;
        if (r10 == 0) goto L12;
        boolean r12 = false;
    L13:
        if (r11 == Integer.MIN_VALUE) goto L15;
        if (r11 == 0) goto L15;
    L16:
        float r13 = r2.getIntrinsicWidth();
        float r4 = r2.getIntrinsicHeight();
        float r5 = r0 / r13;
        float r6 = r1 / r4;
        if (r12 == false) goto L36;
        if (r3 == false) goto L36;
        if (r5 >= 1.0f) goto L22;
    L25:
        if (r5 < 1.0f) goto L29;
        setMeasuredDimension((int) (r4 * r6), r1);
        return;
    L29:
        if (r6 < 1.0f) goto L33;
        setMeasuredDimension(r0, (int) (r4 * r5));
        return;
    L33:
        if (r5 >= r6) goto L35;
        setMeasuredDimension(r0, (int) (r4 * r5));
        return;
    L35:
        setMeasuredDimension((int) (r13 * r6), r1);
        return;
    L22:
        if (r6 < 1.0f) goto L25;
        setMeasuredDimension((int) r13, (int) r4);
        return;
    L36:
        if (r12 == false) goto L38;
        setMeasuredDimension((int) (r13 * r6), r1);
        return;
    L38:
        if (r3 == false) goto L45;
        setMeasuredDimension(r0, (int) (r4 * r5));
        return;
    L45:
        return;
    L15:
        r3 = true;
    L12:
        r12 = true;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LKUIRoundedImageView(Context r17, AttributeSet r19, int r110) {
        super(r17, r19, r110);
        this.mIsTouchSelectModeEnabled = true;
        this.mBordRectF = new RectF();
        this.mImageRectF = new RectF();
        this.mViewRectF = new RectF();
        this.mRadiusii = new float[8];
        this.mClearPath = new Path();
        TypedArray r4 = r17.obtainStyledAttributes(r19, new int[]{2130969229, 2130969230, 2130969231, 2130969232, 2130969233, 2130969234, 2130969235, 2130969236, 2130969237, 2130969238, 2130969239, 2130969240, 2130969241, 2130969242, 2130969243, 2130969244, 2130969245, 2130969246, 2130969247, 2130969248, 2130969249}, r110, 0);
        this.mBorderWidth = r4.getDimensionPixelSize(11, 0);
        this.mBorderColor = r4.getColor(8, -1);
        this.mBorderPadding = r4.getDimensionPixelSize(10, 0);
        this.mBorderDrawable = r4.getDrawable(9);
        Drawable r3 = r4.getDrawable(0);
        String r8 = r4.getString(5);
        Drawable r9 = r4.getDrawable(1);
        this.mBadgeTextColor = r4.getColor(6, -1);
        this.mBadgePadding = r4.getDimensionPixelSize(3, (int) j08.b.a(r17, 2.0f));
        this.mBadgeTextSize = r4.getDimensionPixelSize(7, (int) j08.b.a(r17, 12.0f));
        this.mBadgePosAngle = r4.getInteger(4, DEFAULT_BADGE_POSITION_ANGLE);
        this.mIsTouchSelectModeEnabled = r4.getBoolean(20, true);
        this.mSelectedBorderColor = r4.getColor(18, this.mBorderColor);
        this.mSelectedMaskColor = r4.getColor(19, 0);
        int r13 = r4.getDimensionPixelSize(13, 0);
        int r14 = r4.getDimensionPixelSize(15, r13);
        int r15 = r4.getDimensionPixelSize(17, r13);
        int r10 = r4.getDimensionPixelSize(16, r13);
        int r12 = r4.getDimensionPixelSize(14, r13);
        float[] r16 = this.mRadiusii;
        float r111 = r14;
        r16[1] = r111;
        r16[0] = r111;
        float r112 = r15;
        r16[3] = r112;
        r16[2] = r112;
        float r11 = r10;
        r16[5] = r11;
        r16[4] = r11;
        float r6 = r12;
        r16[7] = r6;
        r16[6] = r6;
        this.mIsOval = r4.getBoolean(12, false);
        r4.recycle();
        if (r3 == null) goto L5;
    L7:
        this.mBadgeEnable = true;
        a.C0035a r2 = new a.C0035a(r17);
        r2.c = r3;
        r2.f = this.mBadgePadding;
        r2.e = r9;
        r2.a = r8;
        r2.b = this.mBadgeTextSize;
        r2.d = this.mBadgeTextColor;
        a r1 = new a(r2);
        this.mLkUIBadgeDrawable = r1;
        r1.setCallback(this);
    L8:
        init();
        return;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        if (r9 == null) goto L8;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCornerRadiusDP(float r7, float r8, float r9, float r10) {
        float r11 = j08.b.a(getContext(), r7);
        float r12 = j08.b.a(getContext(), r8);
        float r13 = j08.b.a(getContext(), r9);
        float r14 = j08.b.a(getContext(), r10);
        float[] r0 = this.mRadiusii;
        if (r11 == r0[0]) goto L5;
    L10:
        r0[1] = r11;
        r0[0] = r11;
        r0[3] = r12;
        r0[2] = r12;
        r0[5] = r13;
        r0[4] = r13;
        r0[7] = r14;
        r0[6] = r14;
        this.mIsOval = false;
        invalidate();
        return;
    L5:
        if (r12 != r0[2]) goto L10;
        if (r13 != r0[4]) goto L10;
        if (r14 != r0[6]) goto L10;
    }
}
