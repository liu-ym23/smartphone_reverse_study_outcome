package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float ARROW_HEAD_ANGLE = 0.0f;
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection;
    private float mMaxCutForBarSize;
    private final Paint mPaint;
    private final Path mPath;
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ArrowDirection {
    }

    static {
        ARROW_HEAD_ANGLE = (float) Math.toRadians(45.0d);
    }

    public DrawerArrowDrawable(Context r10) {
        Paint r11 = new Paint();
        this.mPaint = r11;
        this.mPath = new Path();
        this.mVerticalMirror = false;
        this.mDirection = 2;
        r11.setStyle(Paint.Style.STROKE);
        r11.setStrokeJoin(Paint.Join.MITER);
        r11.setStrokeCap(Paint.Cap.BUTT);
        r11.setAntiAlias(true);
        TypedArray r12 = r10.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(r12.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(r12.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(r12.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(r12.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.mSize = r12.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarLength = Math.round(r12.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.mArrowHeadLength = Math.round(r12.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.mArrowShaftLength = r12.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        r12.recycle();
    }

    private static float lerp(float r10, float r11, float r12) {
        return r10 + ((r11 - r10) * r12);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r19) {
        Rect r10 = getBounds();
        int r11 = this.mDirection;
        boolean r12 = false;
        if (r11 == 0) goto L13;
        if (r11 != 1) goto L6;
    L12:
        r12 = true;
        goto L13
    L6:
        if (r11 == 3) goto L11;
        if (DrawableCompat.getLayoutDirection(this) != 1) goto L13;
    L11:
        if (DrawableCompat.getLayoutDirection(this) == 0) goto L12;
    L13:
        float r13 = this.mArrowHeadLength;
        float r14 = lerp(this.mBarLength, (float) Math.sqrt((r13 * r13) * 2.0f), this.mProgress);
        float r15 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
        float r16 = Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
        float r17 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        if (r12 == false) goto L16;
        float r18 = 0.0f;
    L18:
        if (r12 == false) goto L20;
        float r110 = 180.0f;
    L21:
        float r111 = lerp(r18, r110, this.mProgress);
        double r112 = r14;
        double r113 = r17;
        boolean r20 = r12;
        float r21 = Math.round(Math.cos(r113) * r112);
        float r22 = Math.round(r112 * Math.sin(r113));
        this.mPath.rewind();
        float r114 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
        float r115 = (-r15) / 2.0f;
        this.mPath.moveTo(r115 + r16, 0.0f);
        this.mPath.rLineTo(r15 - (r16 * 2.0f), 0.0f);
        this.mPath.moveTo(r115, r114);
        this.mPath.rLineTo(r21, r22);
        this.mPath.moveTo(r115, -r114);
        this.mPath.rLineTo(r21, -r22);
        this.mPath.close();
        r19.save();
        float r23 = this.mPaint.getStrokeWidth();
        float r24 = r10.height() - (3.0f * r23);
        float r25 = this.mBarGap;
        r19.translate(r10.centerX(), ((((int) (r24 - (2.0f * r25))) / 4) * 2) + ((r23 * 1.5f) + r25));
        if (this.mSpin == true) goto L24;
        if (r20 == false) goto L30;
        r19.rotate(180.0f);
    L30:
        r19.drawPath(this.mPath, this.mPaint);
        r19.restore();
        return;
    L24:
        if ((this.mVerticalMirror ^ r20) == false) goto L26;
        int r26 = -1;
    L27:
        r19.rotate(r111 * r26);
        goto L30
    L26:
        r26 = 1;
        goto L27
    L20:
        r110 = 0.0f;
        goto L21
    L16:
        r18 = -180.0f;
        goto L18
    }

    public float getArrowHeadLength() {
        return this.mArrowHeadLength;
    }

    public float getArrowShaftLength() {
        return this.mArrowShaftLength;
    }

    public float getBarLength() {
        return this.mBarLength;
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    @ColorInt
    public int getColor() {
        return this.mPaint.getColor();
    }

    public int getDirection() {
        return this.mDirection;
    }

    public float getGapSize() {
        return this.mBarGap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.mProgress;
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        if (r10 == this.mPaint.getAlpha()) goto L6;
        this.mPaint.setAlpha(r10);
        invalidateSelf();
        return;
    }

    public void setArrowHeadLength(float r10) {
        if (this.mArrowHeadLength == r10) goto L6;
        this.mArrowHeadLength = r10;
        invalidateSelf();
        return;
    }

    public void setArrowShaftLength(float r10) {
        if (this.mArrowShaftLength == r10) goto L6;
        this.mArrowShaftLength = r10;
        invalidateSelf();
        return;
    }

    public void setBarLength(float r10) {
        if (this.mBarLength == r10) goto L6;
        this.mBarLength = r10;
        invalidateSelf();
        return;
    }

    public void setBarThickness(float r10) {
        if (this.mPaint.getStrokeWidth() == r10) goto L6;
        this.mPaint.setStrokeWidth(r10);
        this.mMaxCutForBarSize = (float) (((double) (r10 / 2.0f)) * Math.cos(ARROW_HEAD_ANGLE));
        invalidateSelf();
        return;
    }

    public void setColor(@ColorInt int r10) {
        if (r10 == this.mPaint.getColor()) goto L6;
        this.mPaint.setColor(r10);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.mPaint.setColorFilter(r10);
        invalidateSelf();
    }

    public void setDirection(int r10) {
        if (r10 == this.mDirection) goto L6;
        this.mDirection = r10;
        invalidateSelf();
        return;
    }

    public void setGapSize(float r10) {
        if (r10 == this.mBarGap) goto L6;
        this.mBarGap = r10;
        invalidateSelf();
        return;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        if (this.mProgress == r10) goto L6;
        this.mProgress = r10;
        invalidateSelf();
        return;
    }

    public void setSpinEnabled(boolean r10) {
        if (this.mSpin == r10) goto L6;
        this.mSpin = r10;
        invalidateSelf();
        return;
    }

    public void setVerticalMirror(boolean r10) {
        if (this.mVerticalMirror == r10) goto L6;
        this.mVerticalMirror = r10;
        invalidateSelf();
        return;
    }
}
