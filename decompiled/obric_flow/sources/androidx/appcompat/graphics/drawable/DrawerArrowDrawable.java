package androidx.appcompat.graphics.drawable;

import ai.j0;
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
import com.google.android.material.color.utilities.Contrast;
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
        Paint r5 = new Paint();
        this.mPaint = r5;
        this.mPath = new Path();
        this.mVerticalMirror = false;
        this.mDirection = 2;
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeJoin(Paint.Join.MITER);
        r5.setStrokeCap(Paint.Cap.BUTT);
        r5.setAntiAlias(true);
        TypedArray r11 = r10.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(r11.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(r11.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(r11.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(r11.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.mSize = r11.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarLength = Math.round(r11.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.mArrowHeadLength = Math.round(r11.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.mArrowShaftLength = r11.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        r11.recycle();
    }

    private static float lerp(float r5, float r10, float r11) {
        return j0.b(r10, r5, r11, r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r19) {
        Rect r5 = getBounds();
        int r10 = this.mDirection;
        boolean r11 = false;
        if (r10 == 0) goto L13;
        if (r10 != 1) goto L6;
    L12:
        r11 = true;
        goto L13
    L6:
        if (r10 == 3) goto L11;
        if (DrawableCompat.getLayoutDirection(this) != 1) goto L13;
    L11:
        if (DrawableCompat.getLayoutDirection(this) == 0) goto L12;
    L13:
        float r12 = this.mArrowHeadLength;
        float r13 = lerp(this.mBarLength, (float) Math.sqrt((r12 * r12) * 2.0f), this.mProgress);
        float r14 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
        float r15 = Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
        float r16 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        if (r11 == false) goto L16;
        float r17 = 0.0f;
    L18:
        if (r11 == false) goto L20;
        float r18 = 180.0f;
    L21:
        float r110 = lerp(r17, r18, this.mProgress);
        double r111 = r13;
        double r112 = r16;
        boolean r20 = r11;
        float r21 = Math.round(Math.cos(r112) * r111);
        float r22 = Math.round(Math.sin(r112) * r111);
        this.mPath.rewind();
        float r113 = lerp(this.mPaint.getStrokeWidth() + this.mBarGap, -this.mMaxCutForBarSize, this.mProgress);
        float r114 = (-r14) / 2.0f;
        this.mPath.moveTo(r114 + r15, 0.0f);
        this.mPath.rLineTo(r14 - (r15 * 2.0f), 0.0f);
        this.mPath.moveTo(r114, r113);
        this.mPath.rLineTo(r21, r22);
        this.mPath.moveTo(r114, -r113);
        this.mPath.rLineTo(r21, -r22);
        this.mPath.close();
        r19.save();
        float r23 = this.mPaint.getStrokeWidth();
        float r24 = r5.height() - (3.0f * r23);
        float r25 = this.mBarGap;
        float r26 = r5.centerX();
        r19.translate(r26, ((r23 * 1.5f) + r25) + ((((int) (r24 - (2.0f * r25))) / 4) * 2));
        if (this.mSpin == true) goto L24;
        if (r20 == false) goto L30;
        r19.rotate(180.0f);
    L30:
        r19.drawPath(this.mPath, this.mPaint);
        r19.restore();
        return;
    L24:
        if ((this.mVerticalMirror ^ r20) == false) goto L26;
        int r27 = -1;
    L27:
        r19.rotate(r110 * r27);
        goto L30
    L26:
        r27 = 1;
        goto L27
    L20:
        r18 = 0.0f;
        goto L21
    L16:
        r17 = -180.0f;
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

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float getProgress() {
        return this.mProgress;
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        if (r5 == this.mPaint.getAlpha()) goto L6;
        this.mPaint.setAlpha(r5);
        invalidateSelf();
        return;
    }

    public void setArrowHeadLength(float r5) {
        if (this.mArrowHeadLength == r5) goto L6;
        this.mArrowHeadLength = r5;
        invalidateSelf();
        return;
    }

    public void setArrowShaftLength(float r5) {
        if (this.mArrowShaftLength == r5) goto L6;
        this.mArrowShaftLength = r5;
        invalidateSelf();
        return;
    }

    public void setBarLength(float r5) {
        if (this.mBarLength == r5) goto L6;
        this.mBarLength = r5;
        invalidateSelf();
        return;
    }

    public void setBarThickness(float r5) {
        if (this.mPaint.getStrokeWidth() == r5) goto L6;
        this.mPaint.setStrokeWidth(r5);
        this.mMaxCutForBarSize = (float) (Math.cos(ARROW_HEAD_ANGLE) * (r5 / 2.0f));
        invalidateSelf();
        return;
    }

    public void setColor(@ColorInt int r5) {
        if (r5 == this.mPaint.getColor()) goto L6;
        this.mPaint.setColor(r5);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
        this.mPaint.setColorFilter(r5);
        invalidateSelf();
    }

    public void setDirection(int r5) {
        if (r5 == this.mDirection) goto L6;
        this.mDirection = r5;
        invalidateSelf();
        return;
    }

    public void setGapSize(float r5) {
        if (r5 == this.mBarGap) goto L6;
        this.mBarGap = r5;
        invalidateSelf();
        return;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        if (this.mProgress == r5) goto L6;
        this.mProgress = r5;
        invalidateSelf();
        return;
    }

    public void setSpinEnabled(boolean r5) {
        if (this.mSpin == r5) goto L6;
        this.mSpin = r5;
        invalidateSelf();
        return;
    }

    public void setVerticalMirror(boolean r5) {
        if (this.mVerticalMirror == r5) goto L6;
        this.mVerticalMirror = r5;
        invalidateSelf();
        return;
    }
}
