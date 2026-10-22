package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeImageTransform extends Transition {
    private static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY = null;
    private static final TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR = null;
    private static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    private static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    private static final String[] sTransitionProperties = null;

    /* JADX INFO: renamed from: androidx.transition.ChangeImageTransform$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = null;

        static {
            int[] r10 = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = r10;
            r10[ImageView.ScaleType.FIT_XY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_BOUNDS};
        NULL_MATRIX_EVALUATOR = new AnonymousClass1();
        final Class<Matrix> r10 = Matrix.class;
        final String r11 = "animatedTransform";
        ANIMATED_TRANSFORM_PROPERTY = new AnonymousClass2(r10, r11);
    }

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    private void captureValues(TransitionValues r10) {
        View r11 = r10.view;
        if ((r11 instanceof ImageView) == true) goto L5;
        return;
    L5:
        if (r11.getVisibility() != 0) goto L13;
        ImageView r12 = (ImageView) r11;
        if (r12.getDrawable() != null) goto L10;
        return;
    L10:
        Map<String, Object> r13 = r10.values;
        r13.put(PROPNAME_BOUNDS, new Rect(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom()));
        r13.put(PROPNAME_MATRIX, copyImageMatrix(r12));
        return;
    }

    private static Matrix centerCropMatrix(ImageView r10) {
        Drawable r11 = r10.getDrawable();
        int r12 = r11.getIntrinsicWidth();
        float r13 = r10.getWidth();
        float r14 = r12;
        int r15 = r11.getIntrinsicHeight();
        float r16 = r10.getHeight();
        float r17 = r15;
        float r18 = Math.max(r13 / r14, r16 / r17);
        int r19 = Math.round((r13 - (r14 * r18)) / 2.0f);
        int r20 = Math.round((r16 - (r17 * r18)) / 2.0f);
        Matrix r21 = new Matrix();
        r21.postScale(r18, r18);
        r21.postTranslate(r19, r20);
        return r21;
    }

    @NonNull
    private static Matrix copyImageMatrix(@NonNull ImageView r10) {
        Drawable r11 = r10.getDrawable();
        if (r11.getIntrinsicWidth() <= 0) goto L16;
        if (r11.getIntrinsicHeight() <= 0) goto L16;
        int r12 = AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[r10.getScaleType().ordinal()];
        if (r12 == 1) goto L14;
        if (r12 != 2) goto L16;
        return centerCropMatrix(r10);
    L14:
        return fitXYMatrix(r10);
    L16:
        return new Matrix(r10.getImageMatrix());
    }

    private ObjectAnimator createMatrixAnimator(ImageView r10, Matrix r11, Matrix r12) {
        return ObjectAnimator.ofObject(r10, ANIMATED_TRANSFORM_PROPERTY, new TransitionUtils.MatrixEvaluator(), new Matrix[]{r11, r12});
    }

    @NonNull
    private ObjectAnimator createNullAnimator(@NonNull ImageView r10) {
        Property<ImageView, Matrix> r11 = ANIMATED_TRANSFORM_PROPERTY;
        TypeEvaluator<Matrix> r12 = NULL_MATRIX_EVALUATOR;
        Matrix r13 = MatrixUtils.IDENTITY_MATRIX;
        return ObjectAnimator.ofObject(r10, r11, r12, new Matrix[]{r13, r13});
    }

    private static Matrix fitXYMatrix(ImageView r10) {
        Drawable r11 = r10.getDrawable();
        Matrix r12 = new Matrix();
        r12.postScale(r10.getWidth() / r11.getIntrinsicWidth(), r10.getHeight() / r11.getIntrinsicHeight());
        return r12;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup r10, TransitionValues r11, TransitionValues r12) {
        if (r11 == null) goto L33;
        if (r12 == null) goto L33;
        Rect r13 = (Rect) r11.values.get(PROPNAME_BOUNDS);
        Rect r14 = (Rect) r12.values.get(PROPNAME_BOUNDS);
        if (r13 == null) goto L33;
        if (r14 == null) goto L33;
        Matrix r15 = (Matrix) r11.values.get(PROPNAME_MATRIX);
        Matrix r16 = (Matrix) r12.values.get(PROPNAME_MATRIX);
        if (r15 != null) goto L13;
        if (r16 != null) goto L13;
    L16:
        boolean r17 = true;
    L19:
        if (r13.equals(r14) == false) goto L22;
        if (r17 == false) goto L22;
        return null;
    L22:
        ImageView r18 = (ImageView) r12.view;
        Drawable r19 = r18.getDrawable();
        int r20 = r19.getIntrinsicWidth();
        int r21 = r19.getIntrinsicHeight();
        if (r20 <= 0) goto L32;
        if (r21 <= 0) goto L32;
        if (r15 != null) goto L28;
        r15 = MatrixUtils.IDENTITY_MATRIX;
    L28:
        if (r16 != null) goto L30;
        r16 = MatrixUtils.IDENTITY_MATRIX;
    L30:
        ANIMATED_TRANSFORM_PROPERTY.set(r18, r15);
        return createMatrixAnimator(r18, r15, r16);
    L32:
        return createNullAnimator(r18);
    L13:
        if (r15 != null) goto L15;
    L17:
        r17 = false;
        goto L19
    L15:
        if (r15.equals(r16) == false) goto L17;
    L33:
        return null;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}
