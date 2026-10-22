package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeImageTransform extends Transition {
    private static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY = null;
    private static final TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR = null;
    private static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    private static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    private static final String[] sTransitionProperties = null;

    /* JADX INFO: renamed from: androidx.transition.ChangeImageTransform$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = null;

        static {
            int[] r5 = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = r5;
            r5[ImageView.ScaleType.FIT_XY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class Listener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final Matrix mEndMatrix;
        private final ImageView mImageView;
        private boolean mIsBeforeAnimator;
        private final Matrix mStartMatrix;

        public Listener(ImageView r5, Matrix r10, Matrix r11) {
            this.mIsBeforeAnimator = true;
            this.mImageView = r5;
            this.mStartMatrix = r10;
            this.mEndMatrix = r11;
        }

        private void restoreMatrix() {
            Matrix r5 = (Matrix) this.mImageView.getTag(R.id.transition_image_transform);
            if (r5 == null) goto L6;
            ImageViewUtils.animateTransform(this.mImageView, r5);
            this.mImageView.setTag(R.id.transition_image_transform, null);
            return;
        }

        private void saveMatrix(Matrix r5) {
            this.mImageView.setTag(R.id.transition_image_transform, r5);
            ImageViewUtils.animateTransform(this.mImageView, this.mEndMatrix);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator r5, boolean r10) {
            this.mIsBeforeAnimator = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator r5) {
            saveMatrix((Matrix) ((ObjectAnimator) r5).getAnimatedValue());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator r5) {
            restoreMatrix();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator r5, boolean r10) {
            this.mIsBeforeAnimator = false;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r5) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r5) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r5) {
            if (this.mIsBeforeAnimator == false) goto L6;
            saveMatrix(this.mStartMatrix);
            return;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r5) {
            restoreMatrix();
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r5) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            this.mIsBeforeAnimator = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r5) {
            this.mIsBeforeAnimator = false;
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_BOUNDS};
        NULL_MATRIX_EVALUATOR = new AnonymousClass1();
        final Class<Matrix> r5 = Matrix.class;
        final String r10 = "animatedTransform";
        ANIMATED_TRANSFORM_PROPERTY = new AnonymousClass2(r5, r10);
    }

    public ChangeImageTransform() {
    }

    private void captureValues(TransitionValues r10, boolean r11) {
        View r5 = r10.view;
        if ((r5 instanceof ImageView) == true) goto L5;
        return;
    L5:
        if (r5.getVisibility() != 0) goto L19;
        ImageView r12 = (ImageView) r5;
        if (r12.getDrawable() != null) goto L10;
        return;
    L10:
        Map<String, Object> r13 = r10.values;
        r13.put(PROPNAME_BOUNDS, new Rect(r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom()));
        if (r11 == false) goto L13;
        Matrix r14 = (Matrix) r12.getTag(R.id.transition_image_transform);
    L14:
        if (r14 != null) goto L16;
        r14 = copyImageMatrix(r12);
    L16:
        r13.put(PROPNAME_MATRIX, r14);
        return;
    L13:
        r14 = null;
        goto L14
    }

    private static Matrix centerCropMatrix(ImageView r5) {
        Drawable r10 = r5.getDrawable();
        int r11 = r10.getIntrinsicWidth();
        float r12 = r5.getWidth();
        float r13 = r11;
        int r14 = r10.getIntrinsicHeight();
        float r15 = r5.getHeight();
        float r16 = r14;
        float r17 = Math.max(r12 / r13, r15 / r16);
        int r18 = Math.round((r12 - (r13 * r17)) / 2.0f);
        int r19 = Math.round((r15 - (r16 * r17)) / 2.0f);
        Matrix r20 = new Matrix();
        r20.postScale(r17, r17);
        r20.postTranslate(r18, r19);
        return r20;
    }

    @NonNull
    private static Matrix copyImageMatrix(@NonNull ImageView r5) {
        Drawable r10 = r5.getDrawable();
        if (r10.getIntrinsicWidth() <= 0) goto L17;
        if (r10.getIntrinsicHeight() <= 0) goto L17;
        int r11 = AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[r5.getScaleType().ordinal()];
        if (r11 == 1) goto L15;
        if (r11 == 2) goto L13;
        return new Matrix(r5.getImageMatrix());
    L13:
        return centerCropMatrix(r5);
    L15:
        return fitXYMatrix(r5);
    L17:
        return new Matrix(r5.getImageMatrix());
    }

    private ObjectAnimator createMatrixAnimator(ImageView r5, Matrix r10, Matrix r11) {
        return ObjectAnimator.ofObject(r5, ANIMATED_TRANSFORM_PROPERTY, new TransitionUtils.MatrixEvaluator(), new Matrix[]{r10, r11});
    }

    @NonNull
    private ObjectAnimator createNullAnimator(@NonNull ImageView r5) {
        Property<ImageView, Matrix> r10 = ANIMATED_TRANSFORM_PROPERTY;
        TypeEvaluator<Matrix> r11 = NULL_MATRIX_EVALUATOR;
        Matrix r12 = MatrixUtils.IDENTITY_MATRIX;
        return ObjectAnimator.ofObject(r5, r10, r11, new Matrix[]{r12, r12});
    }

    private static Matrix fitXYMatrix(ImageView r5) {
        Drawable r10 = r5.getDrawable();
        Matrix r11 = new Matrix();
        r11.postScale(r5.getWidth() / r10.getIntrinsicWidth(), r5.getHeight() / r10.getIntrinsicHeight());
        return r11;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r5) {
        captureValues(r5, false);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r5) {
        captureValues(r5, true);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r5, @Nullable TransitionValues r10, @Nullable TransitionValues r11) {
        if (r10 == null) goto L33;
        if (r11 == null) goto L33;
        Rect r12 = (Rect) r10.values.get(PROPNAME_BOUNDS);
        Rect r13 = (Rect) r11.values.get(PROPNAME_BOUNDS);
        if (r12 == null) goto L33;
        if (r13 == null) goto L33;
        Matrix r14 = (Matrix) r10.values.get(PROPNAME_MATRIX);
        Matrix r15 = (Matrix) r11.values.get(PROPNAME_MATRIX);
        if (r14 != null) goto L13;
        if (r15 != null) goto L13;
    L16:
        boolean r16 = true;
    L19:
        if (r12.equals(r13) == false) goto L22;
        if (r16 == false) goto L22;
        return null;
    L22:
        ImageView r17 = (ImageView) r11.view;
        Drawable r18 = r17.getDrawable();
        int r19 = r18.getIntrinsicWidth();
        int r20 = r18.getIntrinsicHeight();
        if (r19 <= 0) goto L32;
        if (r20 <= 0) goto L32;
        if (r14 != null) goto L28;
        r14 = MatrixUtils.IDENTITY_MATRIX;
    L28:
        if (r15 != null) goto L30;
        r15 = MatrixUtils.IDENTITY_MATRIX;
    L30:
        ANIMATED_TRANSFORM_PROPERTY.set(r17, r14);
        ObjectAnimator r21 = createMatrixAnimator(r17, r14, r15);
        Listener r22 = new Listener(r17, r14, r15);
        r21.addListener(r22);
        r21.addPauseListener(r22);
        addListener(r22);
        return r21;
    L32:
        return createNullAnimator(r17);
    L13:
        if (r14 != null) goto L15;
    L17:
        r16 = false;
        goto L19
    L15:
        if (r14.equals(r15) == false) goto L17;
    L33:
        return null;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    public ChangeImageTransform(@NonNull Context r5, @NonNull AttributeSet r10) {
        super(r5, r10);
    }
}
