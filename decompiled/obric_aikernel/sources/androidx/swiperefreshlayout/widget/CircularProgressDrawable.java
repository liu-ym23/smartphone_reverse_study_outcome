package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final int[] COLORS = null;
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = null;
    private static final Interpolator MATERIAL_INTERPOLATOR = null;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animator mAnimator;
    boolean mFinishing;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    float mRotationCount;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ProgressDrawableSize {
    }

    private static class Ring {
        int mAlpha;
        Path mArrow;
        int mArrowHeight;
        final Paint mArrowPaint;
        float mArrowScale;
        int mArrowWidth;
        final Paint mCirclePaint;
        int mColorIndex;
        int[] mColors;
        int mCurrentColor;
        float mEndTrim;
        final Paint mPaint;
        float mRingCenterRadius;
        float mRotation;
        boolean mShowArrow;
        float mStartTrim;
        float mStartingEndTrim;
        float mStartingRotation;
        float mStartingStartTrim;
        float mStrokeWidth;
        final RectF mTempBounds;

        Ring() {
            this.mTempBounds = new RectF();
            Paint r10 = new Paint();
            this.mPaint = r10;
            Paint r11 = new Paint();
            this.mArrowPaint = r11;
            Paint r12 = new Paint();
            this.mCirclePaint = r12;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mArrowScale = 1.0f;
            this.mAlpha = 255;
            r10.setStrokeCap(Paint.Cap.SQUARE);
            r10.setAntiAlias(true);
            r10.setStyle(Paint.Style.STROKE);
            r11.setStyle(Paint.Style.FILL);
            r11.setAntiAlias(true);
            r12.setColor(0);
        }

        void draw(Canvas r10, Rect r11) {
            RectF r12 = this.mTempBounds;
            float r13 = this.mRingCenterRadius;
            float r14 = (this.mStrokeWidth / 2.0f) + r13;
            if (r13 > 0.0f) goto L5;
            r14 = (Math.min(r11.width(), r11.height()) / 2.0f) - Math.max((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
        L5:
            r12.set(r11.centerX() - r14, r11.centerY() - r14, r11.centerX() + r14, r11.centerY() + r14);
            float r15 = this.mStartTrim;
            float r16 = this.mRotation;
            float r17 = (r15 + r16) * 360.0f;
            float r18 = ((this.mEndTrim + r16) * 360.0f) - r17;
            this.mPaint.setColor(this.mCurrentColor);
            this.mPaint.setAlpha(this.mAlpha);
            float r19 = this.mStrokeWidth / 2.0f;
            r12.inset(r19, r19);
            r10.drawCircle(r12.centerX(), r12.centerY(), r12.width() / 2.0f, this.mCirclePaint);
            float r20 = -r19;
            r12.inset(r20, r20);
            r10.drawArc(r12, r17, r18, false, this.mPaint);
            drawTriangle(r10, r17, r18, r12);
        }

        void drawTriangle(Canvas r10, float r11, float r12, RectF r13) {
            if (this.mShowArrow == false) goto L10;
            Path r14 = this.mArrow;
            if (r14 != null) goto L7;
            Path r15 = new Path();
            this.mArrow = r15;
            r15.setFillType(Path.FillType.EVEN_ODD);
        L8:
            float r16 = Math.min(r13.width(), r13.height()) / 2.0f;
            float r17 = (this.mArrowWidth * this.mArrowScale) / 2.0f;
            this.mArrow.moveTo(0.0f, 0.0f);
            this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
            Path r18 = this.mArrow;
            float r19 = this.mArrowWidth;
            float r20 = this.mArrowScale;
            r18.lineTo((r19 * r20) / 2.0f, this.mArrowHeight * r20);
            this.mArrow.offset((r16 + r13.centerX()) - r17, r13.centerY() + (this.mStrokeWidth / 2.0f));
            this.mArrow.close();
            this.mArrowPaint.setColor(this.mCurrentColor);
            this.mArrowPaint.setAlpha(this.mAlpha);
            r10.save();
            r10.rotate(r11 + r12, r13.centerX(), r13.centerY());
            r10.drawPath(this.mArrow, this.mArrowPaint);
            r10.restore();
            return;
        L7:
            r14.reset();
            goto L8
        }

        int getAlpha() {
            return this.mAlpha;
        }

        float getArrowHeight() {
            return this.mArrowHeight;
        }

        float getArrowScale() {
            return this.mArrowScale;
        }

        float getArrowWidth() {
            return this.mArrowWidth;
        }

        int getBackgroundColor() {
            return this.mCirclePaint.getColor();
        }

        float getCenterRadius() {
            return this.mRingCenterRadius;
        }

        int[] getColors() {
            return this.mColors;
        }

        float getEndTrim() {
            return this.mEndTrim;
        }

        int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        float getRotation() {
            return this.mRotation;
        }

        boolean getShowArrow() {
            return this.mShowArrow;
        }

        float getStartTrim() {
            return this.mStartTrim;
        }

        int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        float getStartingRotation() {
            return this.mStartingRotation;
        }

        float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        Paint.Cap getStrokeCap() {
            return this.mPaint.getStrokeCap();
        }

        float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        void setAlpha(int r10) {
            this.mAlpha = r10;
        }

        void setArrowDimensions(float r10, float r11) {
            this.mArrowWidth = (int) r10;
            this.mArrowHeight = (int) r11;
        }

        void setArrowScale(float r10) {
            if (r10 == this.mArrowScale) goto L6;
            this.mArrowScale = r10;
            return;
        }

        void setBackgroundColor(int r10) {
            this.mCirclePaint.setColor(r10);
        }

        void setCenterRadius(float r10) {
            this.mRingCenterRadius = r10;
        }

        void setColor(int r10) {
            this.mCurrentColor = r10;
        }

        void setColorFilter(ColorFilter r10) {
            this.mPaint.setColorFilter(r10);
        }

        void setColorIndex(int r10) {
            this.mColorIndex = r10;
            this.mCurrentColor = this.mColors[r10];
        }

        void setColors(@NonNull int[] r10) {
            this.mColors = r10;
            setColorIndex(0);
        }

        void setEndTrim(float r10) {
            this.mEndTrim = r10;
        }

        void setRotation(float r10) {
            this.mRotation = r10;
        }

        void setShowArrow(boolean r10) {
            if (this.mShowArrow == r10) goto L6;
            this.mShowArrow = r10;
            return;
        }

        void setStartTrim(float r10) {
            this.mStartTrim = r10;
        }

        void setStrokeCap(Paint.Cap r10) {
            this.mPaint.setStrokeCap(r10);
        }

        void setStrokeWidth(float r10) {
            this.mStrokeWidth = r10;
            this.mPaint.setStrokeWidth(r10);
        }

        void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }
    }

    static {
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
        COLORS = new int[]{ViewCompat.MEASURED_STATE_MASK};
    }

    public CircularProgressDrawable(@NonNull Context r10) {
        this.mResources = ((Context) Preconditions.checkNotNull(r10)).getResources();
        Ring r11 = new Ring();
        this.mRing = r11;
        r11.setColors(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    private void applyFinishTranslation(float r10, Ring r11) {
        updateRingColor(r10, r11);
        float r12 = (float) (Math.floor(r11.getStartingRotation() / MAX_PROGRESS_ARC) + 1.0d);
        r11.setStartTrim(r11.getStartingStartTrim() + (((r11.getStartingEndTrim() - MIN_PROGRESS_ARC) - r11.getStartingStartTrim()) * r10));
        r11.setEndTrim(r11.getStartingEndTrim());
        r11.setRotation(r11.getStartingRotation() + ((r12 - r11.getStartingRotation()) * r10));
    }

    private int evaluateColorChange(float r10, int r11, int r12) {
        int r13 = (r11 >> 24) & 255;
        int r14 = (r11 >> 16) & 255;
        int r15 = (r11 >> 8) & 255;
        int r16 = r11 & 255;
        return ((((r13 + ((int) ((((r12 >> 24) & 255) - r13) * r10))) << 24) | ((r14 + ((int) ((((r12 >> 16) & 255) - r14) * r10))) << 16)) | ((r15 + ((int) ((((r12 >> 8) & 255) - r15) * r10))) << 8)) | (r16 + ((int) (r10 * ((r12 & 255) - r16))));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setRotation(float r10) {
        this.mRotation = r10;
    }

    private void setSizeParameters(float r10, float r11, float r12, float r13) {
        Ring r14 = this.mRing;
        float r15 = this.mResources.getDisplayMetrics().density;
        r14.setStrokeWidth(r11 * r15);
        r14.setCenterRadius(r10 * r15);
        r14.setColorIndex(0);
        r14.setArrowDimensions(r12 * r15, r13 * r15);
    }

    private void setupAnimators() {
        final Ring r10 = this.mRing;
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r11.addUpdateListener(new AnonymousClass1(this, r10));
        r11.setRepeatCount(-1);
        r11.setRepeatMode(1);
        r11.setInterpolator(LINEAR_INTERPOLATOR);
        r11.addListener(new AnonymousClass2(this, r10));
        this.mAnimator = r11;
    }

    void applyTransformation(float r10, Ring r11, boolean r12) {
        if (this.mFinishing == false) goto L6;
        applyFinishTranslation(r10, r11);
        return;
    L6:
        if (r10 != 1.0f) goto L8;
        if (r12 == true) goto L8;
        return;
    L8:
        float r13 = r11.getStartingRotation();
        if (r10 >= 0.5f) goto L11;
        float r14 = r11.getStartingStartTrim();
        Interpolator r15 = MATERIAL_INTERPOLATOR;
        float r16 = ((r15.getInterpolation(r10 / 0.5f) * 0.79f) + MIN_PROGRESS_ARC) + r14;
    L12:
        float r17 = r13 + (RING_ROTATION * r10);
        float r18 = (r10 + this.mRotationCount) * GROUP_FULL_ROTATION;
        r11.setStartTrim(r14);
        r11.setEndTrim(r16);
        r11.setRotation(r17);
        setRotation(r18);
        return;
    L11:
        float r19 = r11.getStartingStartTrim() + 0.79f;
        Interpolator r20 = MATERIAL_INTERPOLATOR;
        r14 = r19 - (((1.0f - r20.getInterpolation((r10 - 0.5f) / 0.5f)) * 0.79f) + MIN_PROGRESS_ARC);
        r16 = r19;
        goto L12
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        Rect r11 = getBounds();
        r10.save();
        r10.rotate(this.mRotation, r11.exactCenterX(), r11.exactCenterY());
        this.mRing.draw(r10, r11);
        r10.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    public boolean getArrowEnabled() {
        return this.mRing.getShowArrow();
    }

    public float getArrowHeight() {
        return this.mRing.getArrowHeight();
    }

    public float getArrowScale() {
        return this.mRing.getArrowScale();
    }

    public float getArrowWidth() {
        return this.mRing.getArrowWidth();
    }

    public int getBackgroundColor() {
        return this.mRing.getBackgroundColor();
    }

    public float getCenterRadius() {
        return this.mRing.getCenterRadius();
    }

    @NonNull
    public int[] getColorSchemeColors() {
        return this.mRing.getColors();
    }

    public float getEndTrim() {
        return this.mRing.getEndTrim();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.mRing.getRotation();
    }

    public float getStartTrim() {
        return this.mRing.getStartTrim();
    }

    @NonNull
    public Paint.Cap getStrokeCap() {
        return this.mRing.getStrokeCap();
    }

    public float getStrokeWidth() {
        return this.mRing.getStrokeWidth();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.mRing.setAlpha(r10);
        invalidateSelf();
    }

    public void setArrowDimensions(float r10, float r11) {
        this.mRing.setArrowDimensions(r10, r11);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean r10) {
        this.mRing.setShowArrow(r10);
        invalidateSelf();
    }

    public void setArrowScale(float r10) {
        this.mRing.setArrowScale(r10);
        invalidateSelf();
    }

    public void setBackgroundColor(int r10) {
        this.mRing.setBackgroundColor(r10);
        invalidateSelf();
    }

    public void setCenterRadius(float r10) {
        this.mRing.setCenterRadius(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.mRing.setColorFilter(r10);
        invalidateSelf();
    }

    public void setColorSchemeColors(@NonNull int... r10) {
        this.mRing.setColors(r10);
        this.mRing.setColorIndex(0);
        invalidateSelf();
    }

    public void setProgressRotation(float r10) {
        this.mRing.setRotation(r10);
        invalidateSelf();
    }

    public void setStartEndTrim(float r10, float r11) {
        this.mRing.setStartTrim(r10);
        this.mRing.setEndTrim(r11);
        invalidateSelf();
    }

    public void setStrokeCap(@NonNull Paint.Cap r10) {
        this.mRing.setStrokeCap(r10);
        invalidateSelf();
    }

    public void setStrokeWidth(float r10) {
        this.mRing.setStrokeWidth(r10);
        invalidateSelf();
    }

    public void setStyle(int r10) {
        if (r10 != 0) goto L4;
        float r11 = CENTER_RADIUS_LARGE;
        float r12 = STROKE_WIDTH_LARGE;
        float r13 = 12.0f;
        float r14 = 6.0f;
    L5:
        setSizeParameters(r11, r12, r13, r14);
        invalidateSelf();
        return;
    L4:
        r11 = CENTER_RADIUS;
        r12 = STROKE_WIDTH;
        r13 = 10.0f;
        r14 = 5.0f;
        goto L5
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimator.cancel();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() == this.mRing.getStartTrim()) goto L5;
        this.mFinishing = true;
        Animator r10 = this.mAnimator;
        long r11 = 666;
    L6:
        r10.setDuration(r11);
        this.mAnimator.start();
        return;
    L5:
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        r10 = this.mAnimator;
        r11 = 1332;
        goto L6
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        invalidateSelf();
    }

    void updateRingColor(float r10, Ring r11) {
        if (r10 <= 0.75f) goto L5;
        int r12 = evaluateColorChange((r10 - 0.75f) / 0.25f, r11.getStartingColor(), r11.getNextColor());
    L6:
        r11.setColor(r12);
        return;
    L5:
        r12 = r11.getStartingColor();
        goto L6
    }
}
