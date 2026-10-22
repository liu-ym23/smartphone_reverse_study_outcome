package com.google.android.material.transition.platform;

import ai.j0;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.PathParser;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
class TransitionUtils {

    @AttrRes
    static final int NO_ATTR_RES_ID = 0;
    static final int NO_DURATION = -1;
    private static final int PATH_TYPE_ARC = 1;
    private static final int PATH_TYPE_LINEAR = 0;
    private static final RectF transformAlphaRectF = null;

    public interface CornerSizeBinaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize r5, @NonNull CornerSize r10);
    }

    static {
        transformAlphaRectF = new RectF();
    }

    private TransitionUtils() {
    }

    public static /* synthetic */ CornerSize a(RectF r5, CornerSize r10) {
        return lambda$convertToRelativeCornerSizes$0(r5, r10);
    }

    public static float calculateArea(@NonNull RectF r5) {
        float r10 = r5.width();
        return r5.height() * r10;
    }

    public static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel r5, final RectF r10) {
        return r5.withTransformedCornerSizes(new a(r10));
    }

    public static Shader createColorShader(@ColorInt int r10) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, r10, r10, Shader.TileMode.CLAMP);
    }

    @NonNull
    public static <T> T defaultIfNull(@Nullable T r5, @NonNull T r10) {
        if (r5 == null) goto L5;
        return r5;
    L5:
        return r10;
    }

    public static View findAncestorById(View r5, @IdRes int r10) {
        String r11 = r5.getResources().getResourceName(r10);
    L3:
        if (r5 == null) goto L11;
        if (r5.getId() == r10) goto L6;
        Object r12 = r5.getParent();
        if ((r12 instanceof View) == false) goto L11;
        r5 = (View) r12;
        goto L3
    L6:
        return r5;
    L11:
        throw new IllegalArgumentException(j0.j(r11, " is not a valid ancestor"));
    }

    public static View findDescendantOrAncestorById(View r5, @IdRes int r10) {
        View r11 = r5.findViewById(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return findAncestorById(r5, r10);
    }

    public static RectF getLocationOnScreen(View r5) {
        int[] r10 = new int[2];
        r5.getLocationOnScreen(r10);
        int r11 = r10[0];
        int r12 = r10[1];
        return new RectF(r11, r12, r5.getWidth() + r11, r5.getHeight() + r12);
    }

    public static RectF getRelativeBounds(View r5) {
        return new RectF(r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom());
    }

    public static Rect getRelativeBoundsRect(View r5) {
        return new Rect(r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom());
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel r5, RectF r10) {
        if (r5.getTopLeftCornerSize().getCornerSize(r10) == 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (r5.getTopRightCornerSize().getCornerSize(r10) != 0.0f) goto L12;
        if (r5.getBottomRightCornerSize().getCornerSize(r10) != 0.0f) goto L12;
        if (r5.getBottomLeftCornerSize().getCornerSize(r10) != 0.0f) goto L12;
        return false;
    }

    private static /* synthetic */ CornerSize lambda$convertToRelativeCornerSizes$0(RectF r5, CornerSize r10) {
        return RelativeCornerSize.createFromCornerSize(r5, r10);
    }

    public static float lerp(float r5, float r10, float r11) {
        return j0.b(r10, r5, r11, r5);
    }

    public static void maybeAddTransition(TransitionSet r5, @Nullable Transition r10) {
        if (r10 == null) goto L5;
        r5.addTransition(r10);
        return;
    }

    public static boolean maybeApplyThemeDuration(Transition r5, Context r10, @AttrRes int r11) {
        if (r11 != 0) goto L4;
        return false;
    L4:
        if (r5.getDuration() != (-1)) goto L11;
        int r12 = MotionUtils.resolveThemeDuration(r10, r11, -1);
        if (r12 == (-1)) goto L12;
        r5.setDuration(r12);
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public static boolean maybeApplyThemeInterpolator(Transition r5, Context r10, @AttrRes int r11, TimeInterpolator r12) {
        if (r11 != 0) goto L4;
        return false;
    L4:
        if (r5.getInterpolator() != null) goto L9;
        r5.setInterpolator(MotionUtils.resolveThemeInterpolator(r10, r11, r12));
        return true;
    L9:
        return false;
    }

    public static boolean maybeApplyThemePath(Transition r5, Context r10, @AttrRes int r11) {
        if (r11 == 0) goto L7;
        PathMotion r12 = resolveThemePath(r10, r11);
        if (r12 == null) goto L9;
        r5.setPathMotion(r12);
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    public static void maybeRemoveTransition(TransitionSet r5, @Nullable Transition r10) {
        if (r10 == null) goto L5;
        r5.removeTransition(r10);
        return;
    }

    @Nullable
    public static PathMotion resolveThemePath(Context r5, @AttrRes int r10) {
        TypedValue r11 = new TypedValue();
        if (r5.getTheme().resolveAttribute(r10, r11, true) == false) goto L20;
        int r12 = r11.type;
        if (r12 != 16) goto L15;
        int r13 = r11.data;
        if (r13 != 0) goto L9;
        return null;
    L9:
        if (r13 != 1) goto L13;
        return new MaterialArcMotion();
    L13:
        throw new IllegalArgumentException(j0.g(r13, "Invalid motion path type: "));
    L15:
        if (r12 != 3) goto L19;
        return new PatternPathMotion(PathParser.createPathFromPathData(String.valueOf(r11.string)));
    L19:
        throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
    L20:
        return null;
    }

    private static int saveLayerAlphaCompat(Canvas r5, Rect r10, int r11) {
        RectF r12 = transformAlphaRectF;
        r12.set(r10);
        return r5.saveLayerAlpha(r12, r11);
    }

    public static void transform(Canvas r5, Rect r10, float r11, float r12, float r13, int r14, CanvasCompat.CanvasOperation r15) {
        if (r14 > 0) goto L4;
        return;
    L4:
        int r16 = r5.save();
        r5.translate(r11, r12);
        r5.scale(r13, r13);
        if (r14 >= 255) goto L7;
        saveLayerAlphaCompat(r5, r10, r14);
    L7:
        r15.run(r5);
        r5.restoreToCount(r16);
    }

    public static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel r5, ShapeAppearanceModel r10, RectF r11, CornerSizeBinaryOperator r12) {
        if (isShapeAppearanceSignificant(r5, r11) == false) goto L5;
        ShapeAppearanceModel r13 = r5;
    L7:
        return r13.toBuilder().setTopLeftCornerSize(r12.apply(r5.getTopLeftCornerSize(), r10.getTopLeftCornerSize())).setTopRightCornerSize(r12.apply(r5.getTopRightCornerSize(), r10.getTopRightCornerSize())).setBottomLeftCornerSize(r12.apply(r5.getBottomLeftCornerSize(), r10.getBottomLeftCornerSize())).setBottomRightCornerSize(r12.apply(r5.getBottomRightCornerSize(), r10.getBottomRightCornerSize())).build();
    L5:
        r13 = r10;
        goto L7
    }

    public static float lerp(float r10, float r11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r12, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r13, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r14) {
        return lerp(r10, r11, r12, r13, r14, false);
    }

    public static float lerp(float r5, float r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r12, @FloatRange(from = 0.0d) float r13, boolean r14) {
        if (r14 == false) goto L10;
        if (r13 < 0.0f) goto L8;
        if (r13 <= 1.0f) goto L10;
    L8:
        return lerp(r5, r10, r13);
    L10:
        if (r13 >= r11) goto L13;
        return r5;
    L13:
        if (r13 <= r12) goto L16;
        return r10;
    L16:
        return lerp(r5, r10, (r13 - r11) / (r12 - r11));
    }

    public static int lerp(int r5, int r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r12, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r13) {
        if (r13 >= r11) goto L6;
        return r5;
    L6:
        if (r13 <= r12) goto L9;
        return r10;
    L9:
        return (int) lerp(r5, r10, (r13 - r11) / (r12 - r11));
    }

    public static ShapeAppearanceModel lerp(ShapeAppearanceModel r10, ShapeAppearanceModel r11, final RectF r12, final RectF r13, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) final float r14, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) final float r15, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) final float r16) {
        if (r16 >= r14) goto L6;
        return r10;
    L6:
        if (r16 <= r15) goto L9;
        return r11;
    L9:
        return transformCornerSizes(r10, r11, r12, new AnonymousClass1(r12, r13, r14, r15, r16));
    }
}
