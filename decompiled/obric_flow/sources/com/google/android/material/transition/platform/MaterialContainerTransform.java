package com.google.android.material.transition.platform;

import ai.j0;
import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public final class MaterialContainerTransform extends Transition {
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS = null;
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC = null;
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS = null;
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC = null;
    private static final float ELEVATION_NOT_SET = -1.0f;
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    private static final String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    private static final String TAG = "MaterialContainerTransform";
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private static final String[] TRANSITION_PROPS = null;
    private boolean appliedThemeValues;

    @ColorInt
    private int containerColor;
    private boolean drawDebugEnabled;

    @IdRes
    private int drawingViewId;
    private boolean elevationShadowEnabled;

    @ColorInt
    private int endContainerColor;
    private float endElevation;

    @Nullable
    private ShapeAppearanceModel endShapeAppearanceModel;

    @Nullable
    private View endView;

    @IdRes
    private int endViewId;
    private int fadeMode;

    @Nullable
    private ProgressThresholds fadeProgressThresholds;
    private int fitMode;
    private boolean holdAtEndEnabled;
    private boolean pathMotionCustom;

    @Nullable
    private ProgressThresholds scaleMaskProgressThresholds;

    @Nullable
    private ProgressThresholds scaleProgressThresholds;

    @ColorInt
    private int scrimColor;

    @Nullable
    private ProgressThresholds shapeMaskProgressThresholds;

    @ColorInt
    private int startContainerColor;
    private float startElevation;

    @Nullable
    private ShapeAppearanceModel startShapeAppearanceModel;

    @Nullable
    private View startView;

    @IdRes
    private int startViewId;
    private int transitionDirection;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FitMode {
    }

    public static class ProgressThresholds {

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        private final float end;

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        private final float start;

        public ProgressThresholds(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10) {
            this.start = r5;
            this.end = r10;
        }

        public static /* synthetic */ float access$1000(ProgressThresholds r5) {
            return r5.start;
        }

        public static /* synthetic */ float access$1100(ProgressThresholds r5) {
            return r5.end;
        }

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        public float getEnd() {
            return this.end;
        }

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        public float getStart() {
            return this.start;
        }
    }

    public static class ProgressThresholdsGroup {

        @NonNull
        private final ProgressThresholds fade;

        @NonNull
        private final ProgressThresholds scale;

        @NonNull
        private final ProgressThresholds scaleMask;

        @NonNull
        private final ProgressThresholds shapeMask;

        public /* synthetic */ ProgressThresholdsGroup(ProgressThresholds r5, ProgressThresholds r10, ProgressThresholds r11, ProgressThresholds r12, AnonymousClass1 r13) {
            this(r5, r10, r11, r12);
        }

        public static /* synthetic */ ProgressThresholds access$400(ProgressThresholdsGroup r5) {
            return r5.fade;
        }

        public static /* synthetic */ ProgressThresholds access$500(ProgressThresholdsGroup r5) {
            return r5.scale;
        }

        public static /* synthetic */ ProgressThresholds access$600(ProgressThresholdsGroup r5) {
            return r5.scaleMask;
        }

        public static /* synthetic */ ProgressThresholds access$700(ProgressThresholdsGroup r5) {
            return r5.shapeMask;
        }

        private ProgressThresholdsGroup(@NonNull ProgressThresholds r5, @NonNull ProgressThresholds r10, @NonNull ProgressThresholds r11, @NonNull ProgressThresholds r12) {
            this.fade = r5;
            this.scale = r10;
            this.scaleMask = r11;
            this.shapeMask = r12;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TransitionDirection {
    }

    public static final class TransitionDrawable extends Drawable {
        private static final int COMPAT_SHADOW_COLOR = -7829368;
        private static final int SHADOW_COLOR = 754974720;
        private static final float SHADOW_DX_MULTIPLIER_ADJUSTMENT = 0.3f;
        private static final float SHADOW_DY_MULTIPLIER_ADJUSTMENT = 1.5f;
        private final MaterialShapeDrawable compatShadowDrawable;
        private final Paint containerPaint;
        private float currentElevation;
        private float currentElevationDy;
        private final RectF currentEndBounds;
        private final RectF currentEndBoundsMasked;
        private RectF currentMaskBounds;
        private final RectF currentStartBounds;
        private final RectF currentStartBoundsMasked;
        private final Paint debugPaint;
        private final Path debugPath;
        private final float displayHeight;
        private final float displayWidth;
        private final boolean drawDebugEnabled;
        private final boolean elevationShadowEnabled;
        private final RectF endBounds;
        private final Paint endContainerPaint;
        private final float endElevation;
        private final ShapeAppearanceModel endShapeAppearanceModel;
        private final View endView;
        private final boolean entering;
        private final FadeModeEvaluator fadeModeEvaluator;
        private FadeModeResult fadeModeResult;
        private final FitModeEvaluator fitModeEvaluator;
        private FitModeResult fitModeResult;
        private final MaskEvaluator maskEvaluator;
        private final float motionPathLength;
        private final PathMeasure motionPathMeasure;
        private final float[] motionPathPosition;
        private float progress;
        private final ProgressThresholdsGroup progressThresholds;
        private final Paint scrimPaint;
        private final Paint shadowPaint;
        private final RectF startBounds;
        private final Paint startContainerPaint;
        private final float startElevation;
        private final ShapeAppearanceModel startShapeAppearanceModel;
        private final View startView;

        public /* synthetic */ TransitionDrawable(PathMotion r5, View r10, RectF r11, ShapeAppearanceModel r12, float r13, View r14, RectF r15, ShapeAppearanceModel r16, float r17, int r18, int r19, int r110, int r111, boolean r112, boolean r113, FadeModeEvaluator r114, FitModeEvaluator r115, ProgressThresholdsGroup r116, boolean r117, AnonymousClass1 r20) {
            this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117);
        }

        public static /* synthetic */ void access$200(TransitionDrawable r5, float r10) {
            r5.setProgress(r10);
        }

        public static /* synthetic */ View access$800(TransitionDrawable r5) {
            return r5.startView;
        }

        public static /* synthetic */ View access$900(TransitionDrawable r5) {
            return r5.endView;
        }

        private static float calculateElevationDxMultiplier(RectF r5, float r10) {
            return ((r5.centerX() / (r10 / 2.0f)) - 1.0f) * SHADOW_DX_MULTIPLIER_ADJUSTMENT;
        }

        private static float calculateElevationDyMultiplier(RectF r5, float r10) {
            return (r5.centerY() / r10) * SHADOW_DY_MULTIPLIER_ADJUSTMENT;
        }

        private void drawDebugCumulativePath(Canvas r5, RectF r10, Path r11, @ColorInt int r12) {
            PointF r13 = getMotionPathPoint(r10);
            if (this.progress != 0.0f) goto L5;
            r11.reset();
            r11.moveTo(r13.x, r13.y);
            return;
        L5:
            r11.lineTo(r13.x, r13.y);
            this.debugPaint.setColor(r12);
            r5.drawPath(r11, this.debugPaint);
        }

        private void drawDebugRect(Canvas r5, RectF r10, @ColorInt int r11) {
            this.debugPaint.setColor(r11);
            r5.drawRect(r10, this.debugPaint);
        }

        private void drawElevationShadow(Canvas r5) {
            r5.save();
            r5.clipPath(this.maskEvaluator.getPath(), Region.Op.DIFFERENCE);
            drawElevationShadowWithPaintShadowLayer(r5);
            r5.restore();
        }

        private void drawElevationShadowWithMaterialShapeDrawable(Canvas r10) {
            MaterialShapeDrawable r5 = this.compatShadowDrawable;
            RectF r11 = this.currentMaskBounds;
            r5.setBounds((int) r11.left, (int) r11.top, (int) r11.right, (int) r11.bottom);
            this.compatShadowDrawable.setElevation(this.currentElevation);
            this.compatShadowDrawable.setShadowVerticalOffset((int) this.currentElevationDy);
            this.compatShadowDrawable.setShapeAppearanceModel(this.maskEvaluator.getCurrentShapeAppearanceModel());
            this.compatShadowDrawable.draw(r10);
        }

        private void drawElevationShadowWithPaintShadowLayer(Canvas r5) {
            ShapeAppearanceModel r10 = this.maskEvaluator.getCurrentShapeAppearanceModel();
            if (r10.isRoundRect(this.currentMaskBounds) == false) goto L5;
            float r11 = r10.getTopLeftCornerSize().getCornerSize(this.currentMaskBounds);
            r5.drawRoundRect(this.currentMaskBounds, r11, r11, this.shadowPaint);
            return;
        L5:
            r5.drawPath(this.maskEvaluator.getPath(), this.shadowPaint);
        }

        private void drawEndView(Canvas r10) {
            maybeDrawContainerColor(r10, this.endContainerPaint);
            Rect r5 = getBounds();
            RectF r11 = this.currentEndBounds;
            TransitionUtils.transform(r10, r5, r11.left, r11.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new AnonymousClass2(this));
        }

        private void drawStartView(Canvas r10) {
            maybeDrawContainerColor(r10, this.startContainerPaint);
            Rect r5 = getBounds();
            RectF r11 = this.currentStartBounds;
            TransitionUtils.transform(r10, r5, r11.left, r11.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new AnonymousClass1(this));
        }

        private static PointF getMotionPathPoint(RectF r5) {
            return new PointF(r5.centerX(), r5.top);
        }

        private void maybeDrawContainerColor(Canvas r5, Paint r10) {
            if (r10.getColor() != 0) goto L5;
            return;
        L5:
            if (r10.getAlpha() <= 0) goto L9;
            r5.drawRect(getBounds(), r10);
            return;
        }

        private void setProgress(float r5) {
            if (this.progress == r5) goto L6;
            updateProgress(r5);
            return;
        }

        private void updateProgress(float r13) {
            this.progress = r13;
            Paint r5 = this.scrimPaint;
            if (this.entering == false) goto L5;
            float r10 = TransitionUtils.lerp(0.0f, 255.0f, r13);
        L6:
            r5.setAlpha((int) r10);
            this.motionPathMeasure.getPosTan(this.motionPathLength * r13, this.motionPathPosition, null);
            float[] r11 = this.motionPathPosition;
            float r12 = r11[0];
            float r14 = r11[1];
            if (r13 <= 1.0f) goto L9;
        L12:
            if (r13 <= 1.0f) goto L14;
            float r15 = (r13 - 1.0f) / 0.00999999f;
            float r16 = 0.99f;
        L15:
            this.motionPathMeasure.getPosTan(this.motionPathLength * r16, r11, null);
            float[] r17 = this.motionPathPosition;
            float r18 = r17[0];
            float r19 = r17[1];
            r12 = j0.b(r12, r18, r15, r12);
            r14 = j0.b(r14, r19, r15, r14);
        L11:
            float r110 = r12;
            float r111 = r14;
            FitModeResult r20 = this.fitModeEvaluator.evaluate(r13, ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$500(this.progressThresholds))))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$500(this.progressThresholds))))).floatValue(), this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
            this.fitModeResult = r20;
            RectF r21 = this.currentStartBounds;
            float r22 = r20.currentStartWidth;
            r21.set(r110 - (r22 / 2.0f), r111, (r22 / 2.0f) + r110, r20.currentStartHeight + r111);
            RectF r23 = this.currentEndBounds;
            FitModeResult r24 = this.fitModeResult;
            float r25 = r24.currentEndWidth;
            r23.set(r110 - (r25 / 2.0f), r111, (r25 / 2.0f) + r110, r24.currentEndHeight + r111);
            this.currentStartBoundsMasked.set(this.currentStartBounds);
            this.currentEndBoundsMasked.set(this.currentEndBounds);
            float r26 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$600(this.progressThresholds))))).floatValue();
            float r27 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$600(this.progressThresholds))))).floatValue();
            boolean r28 = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
            if (r28 == false) goto L19;
            RectF r29 = this.currentStartBoundsMasked;
        L20:
            float r30 = TransitionUtils.lerp(0.0f, 1.0f, r26, r27, r13);
            if (r28 == true) goto L24;
            r30 = 1.0f - r30;
        L24:
            this.fitModeEvaluator.applyMask(r29, r30, this.fitModeResult);
            this.currentMaskBounds = new RectF(Math.min(this.currentStartBoundsMasked.left, this.currentEndBoundsMasked.left), Math.min(this.currentStartBoundsMasked.top, this.currentEndBoundsMasked.top), Math.max(this.currentStartBoundsMasked.right, this.currentEndBoundsMasked.right), Math.max(this.currentStartBoundsMasked.bottom, this.currentEndBoundsMasked.bottom));
            this.maskEvaluator.evaluate(r13, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, ProgressThresholdsGroup.access$700(this.progressThresholds));
            this.currentElevation = TransitionUtils.lerp(this.startElevation, this.endElevation, r13);
            float r31 = calculateElevationDxMultiplier(this.currentMaskBounds, this.displayWidth);
            float r32 = calculateElevationDyMultiplier(this.currentMaskBounds, this.displayHeight);
            float r33 = this.currentElevation;
            float r34 = (int) (r32 * r33);
            this.currentElevationDy = r34;
            this.shadowPaint.setShadowLayer(r33, (int) (r31 * r33), r34, SHADOW_COLOR);
            this.fadeModeResult = this.fadeModeEvaluator.evaluate(r13, ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$400(this.progressThresholds))))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$400(this.progressThresholds))))).floatValue(), 0.35f);
            if (this.startContainerPaint.getColor() == 0) goto L28;
            this.startContainerPaint.setAlpha(this.fadeModeResult.startAlpha);
        L28:
            if (this.endContainerPaint.getColor() == 0) goto L30;
            this.endContainerPaint.setAlpha(this.fadeModeResult.endAlpha);
        L30:
            invalidateSelf();
            return;
        L19:
            r29 = this.currentEndBoundsMasked;
            goto L20
        L14:
            r16 = 0.01f;
            r15 = (r13 / 0.01f) * MaterialContainerTransform.ELEVATION_NOT_SET;
            goto L15
        L9:
            if (r13 >= 0.0f) goto L11;
        L5:
            r10 = TransitionUtils.lerp(255.0f, 0.0f, r13);
            goto L6
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas r5) {
            if (this.scrimPaint.getAlpha() <= 0) goto L6;
            r5.drawRect(getBounds(), this.scrimPaint);
        L6:
            if (this.drawDebugEnabled == false) goto L8;
            int r10 = r5.save();
        L10:
            if (this.elevationShadowEnabled == true) goto L12;
        L14:
            this.maskEvaluator.clip(r5);
            maybeDrawContainerColor(r5, this.containerPaint);
            if (this.fadeModeResult.endOnTop == false) goto L17;
            drawStartView(r5);
            drawEndView(r5);
        L19:
            if (this.drawDebugEnabled == false) goto L22;
            r5.restoreToCount(r10);
            drawDebugCumulativePath(r5, this.currentStartBounds, this.debugPath, -65281);
            drawDebugRect(r5, this.currentStartBoundsMasked, InputDeviceCompat.SOURCE_ANY);
            drawDebugRect(r5, this.currentStartBounds, -16711936);
            drawDebugRect(r5, this.currentEndBoundsMasked, -16711681);
            drawDebugRect(r5, this.currentEndBounds, -16776961);
            return;
        L22:
            return;
        L17:
            drawEndView(r5);
            drawStartView(r5);
            goto L19
        L12:
            if (this.currentElevation <= 0.0f) goto L14;
            drawElevationShadow(r5);
            goto L14
        L8:
            r10 = -1;
            goto L10
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r5) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter r5) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private TransitionDrawable(PathMotion r14, View r15, RectF r16, ShapeAppearanceModel r17, float r18, View r19, RectF r20, ShapeAppearanceModel r21, float r22, @ColorInt int r23, @ColorInt int r24, @ColorInt int r25, int r26, boolean r27, boolean r28, FadeModeEvaluator r29, FitModeEvaluator r30, ProgressThresholdsGroup r31, boolean r32) {
            Paint r5 = new Paint();
            this.containerPaint = r5;
            Paint r10 = new Paint();
            this.startContainerPaint = r10;
            Paint r11 = new Paint();
            this.endContainerPaint = r11;
            this.shadowPaint = new Paint();
            Paint r12 = new Paint();
            this.scrimPaint = r12;
            this.maskEvaluator = new MaskEvaluator();
            this.motionPathPosition = new float[]{r16.centerX(), r16.top};
            MaterialShapeDrawable r13 = new MaterialShapeDrawable();
            this.compatShadowDrawable = r13;
            Paint r33 = new Paint();
            this.debugPaint = r33;
            this.debugPath = new Path();
            this.startView = r15;
            this.startBounds = r16;
            this.startShapeAppearanceModel = r17;
            this.startElevation = r18;
            this.endView = r19;
            this.endBounds = r20;
            this.endShapeAppearanceModel = r21;
            this.endElevation = r22;
            this.entering = r27;
            this.elevationShadowEnabled = r28;
            this.fadeModeEvaluator = r29;
            this.fitModeEvaluator = r30;
            this.progressThresholds = r31;
            this.drawDebugEnabled = r32;
            WindowManager r110 = (WindowManager) r15.getContext().getSystemService("window");
            DisplayMetrics r111 = new DisplayMetrics();
            r110.getDefaultDisplay().getMetrics(r111);
            this.displayWidth = r111.widthPixels;
            this.displayHeight = r111.heightPixels;
            r5.setColor(r23);
            r10.setColor(r24);
            r11.setColor(r25);
            r13.setFillColor(ColorStateList.valueOf(0));
            r13.setShadowCompatibilityMode(2);
            r13.setShadowBitmapDrawingEnable(false);
            r13.setShadowColor(COMPAT_SHADOW_COLOR);
            RectF r34 = new RectF(r16);
            this.currentStartBounds = r34;
            this.currentStartBoundsMasked = new RectF(r34);
            RectF r35 = new RectF(r34);
            this.currentEndBounds = r35;
            this.currentEndBoundsMasked = new RectF(r35);
            PointF r36 = getMotionPathPoint(r16);
            PointF r37 = getMotionPathPoint(r20);
            PathMeasure r38 = new PathMeasure(r14.getPath(r36.x, r36.y, r37.x, r37.y), false);
            this.motionPathMeasure = r38;
            this.motionPathLength = r38.getLength();
            r12.setStyle(Paint.Style.FILL);
            r12.setShader(TransitionUtils.createColorShader(r26));
            r33.setStyle(Paint.Style.STROKE);
            r33.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }
    }

    static {
        TRANSITION_PROPS = new String[]{PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
        DEFAULT_ENTER_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f), null);
        AnonymousClass1 r14 = null;
        DEFAULT_RETURN_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f), r14);
        DEFAULT_ENTER_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f), null);
        DEFAULT_RETURN_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f), r14);
    }

    public MaterialContainerTransform() {
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        this.elevationShadowEnabled = true;
        this.startElevation = ELEVATION_NOT_SET;
        this.endElevation = ELEVATION_NOT_SET;
    }

    public static /* synthetic */ boolean access$300(MaterialContainerTransform r5) {
        return r5.holdAtEndEnabled;
    }

    private ProgressThresholdsGroup buildThresholdsGroup(boolean r5) {
        PathMotion r10 = getPathMotion();
        if ((r10 instanceof ArcMotion) == true) goto L10;
        if ((r10 instanceof MaterialArcMotion) == true) goto L10;
        return getThresholdsOrDefault(r5, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    L10:
        return getThresholdsOrDefault(r5, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC);
    }

    private static RectF calculateDrawableBounds(View r5, @Nullable View r10, float r11, float r12) {
        if (r10 == null) goto L6;
        RectF r13 = TransitionUtils.getLocationOnScreen(r10);
        r13.offset(r11, r12);
        return r13;
    L6:
        return new RectF(0.0f, 0.0f, r5.getWidth(), r5.getHeight());
    }

    private static ShapeAppearanceModel captureShapeAppearance(@NonNull View r5, @NonNull RectF r10, @Nullable ShapeAppearanceModel r11) {
        return TransitionUtils.convertToRelativeCornerSizes(getShapeAppearance(r5, r11), r10);
    }

    private static void captureValues(@NonNull TransitionValues r5, @Nullable View r10, @IdRes int r11, @Nullable ShapeAppearanceModel r12) {
        if (r11 == (-1)) goto L5;
        r5.view = TransitionUtils.findDescendantOrAncestorById(r5.view, r11);
    L10:
        View r13 = r5.view;
        if (ViewCompat.isLaidOut(r13) == true) goto L17;
        if (r13.getWidth() != 0) goto L17;
        if (r13.getHeight() != 0) goto L17;
        return;
    L17:
        if (r13.getParent() != null) goto L19;
        RectF r14 = TransitionUtils.getRelativeBounds(r13);
    L20:
        r5.values.put(PROP_BOUNDS, r14);
        r5.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(r13, r14, r12));
        return;
    L19:
        r14 = TransitionUtils.getLocationOnScreen(r13);
        goto L20
    L5:
        if (r10 == null) goto L8;
        r5.view = r10;
        goto L10
    L8:
        if ((r5.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof View) == false) goto L10;
        View r15 = (View) r5.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
        r5.view.setTag(com.google.android.material.R.id.mtrl_motion_snapshot_view, null);
        r5.view = r15;
        goto L10
    }

    private static float getElevationOrDefault(float r5, View r10) {
        if (r5 == ELEVATION_NOT_SET) goto L6;
        return r5;
    L6:
        return ViewCompat.getElevation(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ShapeAppearanceModel getShapeAppearance(@NonNull View r5, @Nullable ShapeAppearanceModel r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        if ((r5.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof ShapeAppearanceModel) == true) goto L7;
        Context r11 = r5.getContext();
        int r12 = getTransitionShapeAppearanceResId(r11);
        if (r12 == (-1)) goto L13;
        return ShapeAppearanceModel.builder(r11, r12, 0).build();
    L13:
        if ((r5 instanceof Shapeable) == false) goto L17;
        return ((Shapeable) r5).getShapeAppearanceModel();
    L17:
        return ShapeAppearanceModel.builder().build();
    L7:
        return (ShapeAppearanceModel) r5.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
    }

    private ProgressThresholdsGroup getThresholdsOrDefault(boolean r10, ProgressThresholdsGroup r11, ProgressThresholdsGroup r12) {
        if (r10 == true) goto L6;
        r11 = r12;
    L6:
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.defaultIfNull(this.fadeProgressThresholds, ProgressThresholdsGroup.access$400(r11)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleProgressThresholds, ProgressThresholdsGroup.access$500(r11)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, ProgressThresholdsGroup.access$600(r11)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, ProgressThresholdsGroup.access$700(r11)), null);
    }

    @StyleRes
    private static int getTransitionShapeAppearanceResId(Context r5) {
        TypedArray r10 = r5.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int r11 = r10.getResourceId(0, -1);
        r10.recycle();
        return r11;
    }

    private boolean isEntering(@NonNull RectF r5, @NonNull RectF r10) {
        int r11 = this.transitionDirection;
        if (r11 == 0) goto L12;
        if (r11 != 1) goto L6;
        return true;
    L6:
        if (r11 != 2) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
    L12:
        if (TransitionUtils.calculateArea(r10) > TransitionUtils.calculateArea(r5)) goto L14;
        return false;
    L14:
        return true;
    }

    private void maybeApplyThemeValues(Context r5, boolean r10) {
        TransitionUtils.maybeApplyThemeInterpolator(this, r5, com.google.android.material.R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        if (r10 == false) goto L5;
        int r11 = com.google.android.material.R.attr.motionDurationLong2;
    L6:
        TransitionUtils.maybeApplyThemeDuration(this, r5, r11);
        if (this.pathMotionCustom == true) goto L10;
        TransitionUtils.maybeApplyThemePath(this, r5, com.google.android.material.R.attr.motionPath);
        return;
    L10:
        return;
    L5:
        r11 = com.google.android.material.R.attr.motionDurationMedium4;
        goto L6
    }

    @Override // android.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r5) {
        captureValues(r5, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    @Override // android.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r5) {
        captureValues(r5, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Override // android.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r30, @Nullable TransitionValues r31, @Nullable TransitionValues r32) {
        if (r31 == null) goto L30;
        if (r32 == null) goto L30;
        RectF r10 = (RectF) r31.values.get(PROP_BOUNDS);
        ShapeAppearanceModel r11 = (ShapeAppearanceModel) r31.values.get(PROP_SHAPE_APPEARANCE);
        if (r10 == null) goto L29;
        if (r11 == null) goto L29;
        RectF r14 = (RectF) r32.values.get(PROP_BOUNDS);
        ShapeAppearanceModel r15 = (ShapeAppearanceModel) r32.values.get(PROP_SHAPE_APPEARANCE);
        if (r14 == null) goto L27;
        if (r15 == null) goto L27;
        final View r5 = r31.view;
        final View r12 = r32.view;
        if (r12.getParent() == null) goto L17;
        View r13 = r12;
    L19:
        if (this.drawingViewId != r13.getId()) goto L21;
        final View r16 = (View) r13.getParent();
        View r17 = r13;
    L22:
        RectF r18 = TransitionUtils.getLocationOnScreen(r16);
        float r19 = -r18.left;
        float r20 = -r18.top;
        RectF r21 = calculateDrawableBounds(r16, r17, r19, r20);
        r10.offset(r19, r20);
        r14.offset(r19, r20);
        boolean r22 = isEntering(r10, r14);
        if (this.appliedThemeValues == true) goto L25;
        maybeApplyThemeValues(r13.getContext(), r22);
    L25:
        final TransitionDrawable r23 = new TransitionDrawable(getPathMotion(), r5, r10, r11, getElevationOrDefault(this.startElevation, r5), r12, r14, r15, getElevationOrDefault(this.endElevation, r12), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, r22, this.elevationShadowEnabled, FadeModeEvaluators.get(this.fadeMode, r22), FitModeEvaluators.get(this.fitMode, r22, r10, r14), buildThresholdsGroup(r22), this.drawDebugEnabled, null);
        r23.setBounds(Math.round(r21.left), Math.round(r21.top), Math.round(r21.right), Math.round(r21.bottom));
        ValueAnimator r24 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r24.addUpdateListener(new AnonymousClass1(this, r23));
        addListener(new AnonymousClass2(this, r16, r23, r5, r12));
        return r24;
    L21:
        r16 = TransitionUtils.findAncestorById(r13, this.drawingViewId);
        r17 = null;
        goto L22
    L17:
        r13 = r5;
    L27:
        Log.w(TAG, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
        return null;
    L29:
        Log.w(TAG, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
    L30:
        return null;
    }

    @ColorInt
    public int getContainerColor() {
        return this.containerColor;
    }

    @IdRes
    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    @ColorInt
    public int getEndContainerColor() {
        return this.endContainerColor;
    }

    public float getEndElevation() {
        return this.endElevation;
    }

    @Nullable
    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    @Nullable
    public View getEndView() {
        return this.endView;
    }

    @IdRes
    public int getEndViewId() {
        return this.endViewId;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    @Nullable
    public ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    @Nullable
    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    @Nullable
    public ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    @ColorInt
    public int getScrimColor() {
        return this.scrimColor;
    }

    @Nullable
    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    @ColorInt
    public int getStartContainerColor() {
        return this.startContainerColor;
    }

    public float getStartElevation() {
        return this.startElevation;
    }

    @Nullable
    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    @Nullable
    public View getStartView() {
        return this.startView;
    }

    @IdRes
    public int getStartViewId() {
        return this.startViewId;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    @Override // android.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public boolean isElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public void setAllContainerColors(@ColorInt int r5) {
        this.containerColor = r5;
        this.startContainerColor = r5;
        this.endContainerColor = r5;
    }

    public void setContainerColor(@ColorInt int r5) {
        this.containerColor = r5;
    }

    public void setDrawDebugEnabled(boolean r5) {
        this.drawDebugEnabled = r5;
    }

    public void setDrawingViewId(@IdRes int r5) {
        this.drawingViewId = r5;
    }

    public void setElevationShadowEnabled(boolean r5) {
        this.elevationShadowEnabled = r5;
    }

    public void setEndContainerColor(@ColorInt int r5) {
        this.endContainerColor = r5;
    }

    public void setEndElevation(float r5) {
        this.endElevation = r5;
    }

    public void setEndShapeAppearanceModel(@Nullable ShapeAppearanceModel r5) {
        this.endShapeAppearanceModel = r5;
    }

    public void setEndView(@Nullable View r5) {
        this.endView = r5;
    }

    public void setEndViewId(@IdRes int r5) {
        this.endViewId = r5;
    }

    public void setFadeMode(int r5) {
        this.fadeMode = r5;
    }

    public void setFadeProgressThresholds(@Nullable ProgressThresholds r5) {
        this.fadeProgressThresholds = r5;
    }

    public void setFitMode(int r5) {
        this.fitMode = r5;
    }

    public void setHoldAtEndEnabled(boolean r5) {
        this.holdAtEndEnabled = r5;
    }

    @Override // android.transition.Transition
    public void setPathMotion(@Nullable PathMotion r5) {
        super.setPathMotion(r5);
        this.pathMotionCustom = true;
    }

    public void setScaleMaskProgressThresholds(@Nullable ProgressThresholds r5) {
        this.scaleMaskProgressThresholds = r5;
    }

    public void setScaleProgressThresholds(@Nullable ProgressThresholds r5) {
        this.scaleProgressThresholds = r5;
    }

    public void setScrimColor(@ColorInt int r5) {
        this.scrimColor = r5;
    }

    public void setShapeMaskProgressThresholds(@Nullable ProgressThresholds r5) {
        this.shapeMaskProgressThresholds = r5;
    }

    public void setStartContainerColor(@ColorInt int r5) {
        this.startContainerColor = r5;
    }

    public void setStartElevation(float r5) {
        this.startElevation = r5;
    }

    public void setStartShapeAppearanceModel(@Nullable ShapeAppearanceModel r5) {
        this.startShapeAppearanceModel = r5;
    }

    public void setStartView(@Nullable View r5) {
        this.startView = r5;
    }

    public void setStartViewId(@IdRes int r5) {
        this.startViewId = r5;
    }

    public void setTransitionDirection(int r5) {
        this.transitionDirection = r5;
    }

    public MaterialContainerTransform(@NonNull Context r5, boolean r10) {
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        this.elevationShadowEnabled = true;
        this.startElevation = ELEVATION_NOT_SET;
        this.endElevation = ELEVATION_NOT_SET;
        maybeApplyThemeValues(r5, r10);
        this.appliedThemeValues = true;
    }
}
