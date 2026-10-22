package androidx.swiperefreshlayout.widget;

import ai.j0;
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

    public static class Ring {
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

        public Ring() {
            this.mTempBounds = new RectF();
            Paint r5 = new Paint();
            this.mPaint = r5;
            Paint r10 = new Paint();
            this.mArrowPaint = r10;
            Paint r11 = new Paint();
            this.mCirclePaint = r11;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mArrowScale = 1.0f;
            this.mAlpha = 255;
            r5.setStrokeCap(Paint.Cap.SQUARE);
            r5.setAntiAlias(true);
            r5.setStyle(Paint.Style.STROKE);
            r10.setStyle(Paint.Style.FILL);
            r10.setAntiAlias(true);
            r11.setColor(0);
        }

        public void draw(Canvas r10, Rect r11) {
            RectF r12 = this.mTempBounds;
            float r5 = this.mRingCenterRadius;
            float r13 = (this.mStrokeWidth / 2.0f) + r5;
            if (r5 > 0.0f) goto L5;
            r13 = (Math.min(r11.width(), r11.height()) / 2.0f) - Math.max((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
        L5:
            r12.set(r11.centerX() - r13, r11.centerY() - r13, r11.centerX() + r13, r11.centerY() + r13);
            float r14 = this.mStartTrim;
            float r15 = this.mRotation;
            float r16 = (r14 + r15) * 360.0f;
            float r17 = ((this.mEndTrim + r15) * 360.0f) - r16;
            this.mPaint.setColor(this.mCurrentColor);
            this.mPaint.setAlpha(this.mAlpha);
            float r18 = this.mStrokeWidth / 2.0f;
            r12.inset(r18, r18);
            r10.drawCircle(r12.centerX(), r12.centerY(), r12.width() / 2.0f, this.mCirclePaint);
            float r19 = -r18;
            r12.inset(r19, r19);
            r10.drawArc(r12, r16, r17, false, this.mPaint);
            drawTriangle(r10, r16, r17, r12);
        }

        public void drawTriangle(Canvas r10, float r11, float r12, RectF r13) {
            if (this.mShowArrow == false) goto L10;
            Path r5 = this.mArrow;
            if (r5 != null) goto L7;
            Path r14 = new Path();
            this.mArrow = r14;
            r14.setFillType(Path.FillType.EVEN_ODD);
        L8:
            float r15 = Math.min(r13.width(), r13.height()) / 2.0f;
            float r16 = (this.mArrowWidth * this.mArrowScale) / 2.0f;
            this.mArrow.moveTo(0.0f, 0.0f);
            this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
            Path r17 = this.mArrow;
            float r18 = this.mArrowWidth;
            float r19 = this.mArrowScale;
            r17.lineTo((r18 * r19) / 2.0f, this.mArrowHeight * r19);
            this.mArrow.offset((r13.centerX() + r15) - r16, (this.mStrokeWidth / 2.0f) + r13.centerY());
            this.mArrow.close();
            this.mArrowPaint.setColor(this.mCurrentColor);
            this.mArrowPaint.setAlpha(this.mAlpha);
            r10.save();
            r10.rotate(r11 + r12, r13.centerX(), r13.centerY());
            r10.drawPath(this.mArrow, this.mArrowPaint);
            r10.restore();
            return;
        L7:
            r5.reset();
            goto L8
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public float getArrowHeight() {
            return this.mArrowHeight;
        }

        public float getArrowScale() {
            return this.mArrowScale;
        }

        public float getArrowWidth() {
            return this.mArrowWidth;
        }

        public int getBackgroundColor() {
            return this.mCirclePaint.getColor();
        }

        public float getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public int[] getColors() {
            return this.mColors;
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        public int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        public float getRotation() {
            return this.mRotation;
        }

        public boolean getShowArrow() {
            return this.mShowArrow;
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public Paint.Cap getStrokeCap() {
            return this.mPaint.getStrokeCap();
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        public void setAlpha(int r5) {
            this.mAlpha = r5;
        }

        public void setArrowDimensions(float r5, float r10) {
            this.mArrowWidth = (int) r5;
            this.mArrowHeight = (int) r10;
        }

        public void setArrowScale(float r5) {
            if (r5 == this.mArrowScale) goto L6;
            this.mArrowScale = r5;
            return;
        }

        public void setBackgroundColor(int r5) {
            this.mCirclePaint.setColor(r5);
        }

        public void setCenterRadius(float r5) {
            this.mRingCenterRadius = r5;
        }

        public void setColor(int r5) {
            this.mCurrentColor = r5;
        }

        public void setColorFilter(ColorFilter r5) {
            this.mPaint.setColorFilter(r5);
        }

        public void setColorIndex(int r5) {
            this.mColorIndex = r5;
            this.mCurrentColor = this.mColors[r5];
        }

        public void setColors(@NonNull int[] r5) {
            this.mColors = r5;
            setColorIndex(0);
        }

        public void setEndTrim(float r5) {
            this.mEndTrim = r5;
        }

        public void setRotation(float r5) {
            this.mRotation = r5;
        }

        public void setShowArrow(boolean r5) {
            if (this.mShowArrow == r5) goto L6;
            this.mShowArrow = r5;
            return;
        }

        public void setStartTrim(float r5) {
            this.mStartTrim = r5;
        }

        public void setStrokeCap(Paint.Cap r5) {
            this.mPaint.setStrokeCap(r5);
        }

        public void setStrokeWidth(float r5) {
            this.mStrokeWidth = r5;
            this.mPaint.setStrokeWidth(r5);
        }

        public void storeOriginals() {
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

    public CircularProgressDrawable(@NonNull Context r5) {
        this.mResources = ((Context) Preconditions.checkNotNull(r5)).getResources();
        Ring r10 = new Ring();
        this.mRing = r10;
        r10.setColors(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    private void applyFinishTranslation(float r5, Ring r10) {
        updateRingColor(r5, r10);
        float r11 = (float) (Math.floor(r10.getStartingRotation() / MAX_PROGRESS_ARC) + 1.0d);
        r10.setStartTrim(j0.b(r10.getStartingEndTrim() - MIN_PROGRESS_ARC, r10.getStartingStartTrim(), r5, r10.getStartingStartTrim()));
        r10.setEndTrim(r10.getStartingEndTrim());
        r10.setRotation(j0.b(r11, r10.getStartingRotation(), r5, r10.getStartingRotation()));
    }

    private int evaluateColorChange(float r10, int r11, int r12) {
        int r5 = (r11 >> 24) & 255;
        int r13 = (r11 >> 16) & 255;
        int r14 = (r11 >> 8) & 255;
        int r15 = r11 & 255;
        return ((((r5 + ((int) ((((r12 >> 24) & 255) - r5) * r10))) << 24) | ((r13 + ((int) ((((r12 >> 16) & 255) - r13) * r10))) << 16)) | ((r14 + ((int) ((((r12 >> 8) & 255) - r14) * r10))) << 8)) | (r15 + ((int) (r10 * ((r12 & 255) - r15))));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setRotation(float r5) {
        this.mRotation = r5;
    }

    private void setSizeParameters(float r5, float r10, float r11, float r12) {
        Ring r13 = this.mRing;
        float r14 = this.mResources.getDisplayMetrics().density;
        r13.setStrokeWidth(r10 * r14);
        r13.setCenterRadius(r5 * r14);
        r13.setColorIndex(0);
        r13.setArrowDimensions(r11 * r14, r12 * r14);
    }

    private void setupAnimators() {
        final Ring r5 = this.mRing;
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.addUpdateListener(new AnonymousClass1(this, r5));
        r10.setRepeatCount(-1);
        r10.setRepeatMode(1);
        r10.setInterpolator(LINEAR_INTERPOLATOR);
        r10.addListener(new AnonymousClass2(this, r5));
        this.mAnimator = r10;
    }

    public void applyTransformation(float r10, Ring r11, boolean r12) {
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
        float r5 = r11.getStartingStartTrim();
        Interpolator r14 = MATERIAL_INTERPOLATOR;
        float r15 = ((r14.getInterpolation(r10 / 0.5f) * 0.79f) + MIN_PROGRESS_ARC) + r5;
    L12:
        float r16 = (RING_ROTATION * r10) + r13;
        float r17 = (r10 + this.mRotationCount) * GROUP_FULL_ROTATION;
        r11.setStartTrim(r5);
        r11.setEndTrim(r15);
        r11.setRotation(r16);
        setRotation(r17);
        return;
    L11:
        float r18 = r11.getStartingStartTrim() + 0.79f;
        Interpolator r19 = MATERIAL_INTERPOLATOR;
        r5 = r18 - (((1.0f - r19.getInterpolation((r10 - 0.5f) / 0.5f)) * 0.79f) + MIN_PROGRESS_ARC);
        r15 = r18;
        goto L12
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        Rect r10 = getBounds();
        r5.save();
        r5.rotate(this.mRotation, r10.exactCenterX(), r10.exactCenterY());
        this.mRing.draw(r5, r10);
        r5.restore();
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
    public void setAlpha(int r5) {
        this.mRing.setAlpha(r5);
        invalidateSelf();
    }

    public void setArrowDimensions(float r5, float r10) {
        this.mRing.setArrowDimensions(r5, r10);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean r5) {
        this.mRing.setShowArrow(r5);
        invalidateSelf();
    }

    public void setArrowScale(float r5) {
        this.mRing.setArrowScale(r5);
        invalidateSelf();
    }

    public void setBackgroundColor(int r5) {
        this.mRing.setBackgroundColor(r5);
        invalidateSelf();
    }

    public void setCenterRadius(float r5) {
        this.mRing.setCenterRadius(r5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
        this.mRing.setColorFilter(r5);
        invalidateSelf();
    }

    public void setColorSchemeColors(@NonNull int... r5) {
        this.mRing.setColors(r5);
        this.mRing.setColorIndex(0);
        invalidateSelf();
    }

    public void setProgressRotation(float r5) {
        this.mRing.setRotation(r5);
        invalidateSelf();
    }

    public void setStartEndTrim(float r5, float r10) {
        this.mRing.setStartTrim(r5);
        this.mRing.setEndTrim(r10);
        invalidateSelf();
    }

    public void setStrokeCap(@NonNull Paint.Cap r5) {
        this.mRing.setStrokeCap(r5);
        invalidateSelf();
    }

    public void setStrokeWidth(float r5) {
        this.mRing.setStrokeWidth(r5);
        invalidateSelf();
    }

    public void setStyle(int r5) {
        if (r5 != 0) goto L4;
        setSizeParameters(CENTER_RADIUS_LARGE, STROKE_WIDTH_LARGE, 12.0f, 6.0f);
    L5:
        invalidateSelf();
        return;
    L4:
        setSizeParameters(CENTER_RADIUS, STROKE_WIDTH, 10.0f, 5.0f);
        goto L5
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimator.cancel();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() == this.mRing.getStartTrim()) goto L5;
        this.mFinishing = true;
        this.mAnimator.setDuration(666);
        this.mAnimator.start();
        return;
    L5:
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.mAnimator.setDuration(1332);
        this.mAnimator.start();
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

    public void updateRingColor(float r5, Ring r10) {
        if (r5 <= 0.75f) goto L5;
        r10.setColor(evaluateColorChange((r5 - 0.75f) / 0.25f, r10.getStartingColor(), r10.getNextColor()));
        return;
    L5:
        r10.setColor(r10.getStartingColor());
    }
}
