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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
            int[] r0 = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = r0;
            r0[ImageView.ScaleType.FIT_XY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_BOUNDS};
        NULL_MATRIX_EVALUATOR = new AnonymousClass1();
        final Class<Matrix> r1 = Matrix.class;
        final String r2 = "animatedTransform";
        ANIMATED_TRANSFORM_PROPERTY = new AnonymousClass2(r1, r2);
    }

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    private void captureValues(TransitionValues r6) {
        View r5 = r6.view;
        if (ZeusTransformUtils.instanceOf(r5, ImageView.class) == true) goto L5;
        return;
    L5:
        if (r5.getVisibility() != 0) goto L13;
        ImageView r0 = (ImageView) ZeusTransformUtils.preCheckCast(r5, ImageView.class, "com.obric.memorydata.plugin");
        if (r0.getDrawable() != null) goto L10;
        return;
    L10:
        Map<String, Object> r7 = r6.values;
        r7.put(PROPNAME_BOUNDS, new Rect(r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom()));
        r7.put(PROPNAME_MATRIX, copyImageMatrix(r0));
        return;
    }

    private static Matrix centerCropMatrix(ImageView r5) {
        Drawable r0 = r5.getDrawable();
        int r1 = r0.getIntrinsicWidth();
        float r2 = r5.getWidth();
        float r3 = r1;
        int r4 = r0.getIntrinsicHeight();
        float r6 = r5.getHeight();
        float r7 = r4;
        float r8 = Math.max(r2 / r3, r6 / r7);
        int r9 = Math.round((r2 - (r3 * r8)) / 2.0f);
        int r10 = Math.round((r6 - (r7 * r8)) / 2.0f);
        Matrix r11 = new Matrix();
        r11.postScale(r8, r8);
        r11.postTranslate(r9, r10);
        return r11;
    }

    private static Matrix copyImageMatrix(ImageView r2) {
        Drawable r0 = r2.getDrawable();
        if (r0.getIntrinsicWidth() <= 0) goto L16;
        if (r0.getIntrinsicHeight() <= 0) goto L16;
        int r1 = AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[r2.getScaleType().ordinal()];
        if (r1 == 1) goto L14;
        if (r1 != 2) goto L16;
        return centerCropMatrix(r2);
    L14:
        return fitXYMatrix(r2);
    L16:
        return new Matrix(r2.getImageMatrix());
    }

    private ObjectAnimator createMatrixAnimator(ImageView r4, Matrix r5, Matrix r6) {
        return ObjectAnimator.ofObject(r4, ANIMATED_TRANSFORM_PROPERTY, new TransitionUtils.MatrixEvaluator(), new Matrix[]{r5, r6});
    }

    private ObjectAnimator createNullAnimator(ImageView r5) {
        return ObjectAnimator.ofObject(r5, ANIMATED_TRANSFORM_PROPERTY, NULL_MATRIX_EVALUATOR, new Matrix[]{MatrixUtils.IDENTITY_MATRIX, MatrixUtils.IDENTITY_MATRIX});
    }

    private static Matrix fitXYMatrix(ImageView r4) {
        Drawable r0 = r4.getDrawable();
        Matrix r1 = new Matrix();
        r1.postScale(r4.getWidth() / r0.getIntrinsicWidth(), r4.getHeight() / r0.getIntrinsicHeight());
        return r1;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r6, TransitionValues r7, TransitionValues r8) {
        if (r7 == null) goto L33;
        if (r8 == null) goto L33;
        Rect r0 = (Rect) ZeusTransformUtils.preCheckCast(r7.values.get(PROPNAME_BOUNDS), Rect.class, "com.obric.memorydata.plugin");
        Rect r1 = (Rect) ZeusTransformUtils.preCheckCast(r8.values.get(PROPNAME_BOUNDS), Rect.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L33;
        if (r1 == null) goto L33;
        Matrix r9 = (Matrix) ZeusTransformUtils.preCheckCast(r7.values.get(PROPNAME_MATRIX), Matrix.class, "com.obric.memorydata.plugin");
        Matrix r2 = (Matrix) ZeusTransformUtils.preCheckCast(r8.values.get(PROPNAME_MATRIX), Matrix.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L13;
        if (r2 != null) goto L13;
    L16:
        boolean r4 = true;
    L19:
        if (r0.equals(r1) == false) goto L22;
        if (r4 == false) goto L22;
        return null;
    L22:
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r8.view, ImageView.class, "com.obric.memorydata.plugin");
        Drawable r11 = r10.getDrawable();
        int r3 = r11.getIntrinsicWidth();
        int r12 = r11.getIntrinsicHeight();
        if (r3 <= 0) goto L32;
        if (r12 <= 0) goto L32;
        if (r9 != null) goto L28;
        r9 = MatrixUtils.IDENTITY_MATRIX;
    L28:
        if (r2 != null) goto L30;
        r2 = MatrixUtils.IDENTITY_MATRIX;
    L30:
        ANIMATED_TRANSFORM_PROPERTY.set(r10, r9);
        return createMatrixAnimator(r10, r9, r2);
    L32:
        return createNullAnimator(r10);
    L13:
        if (r9 != null) goto L15;
    L17:
        r4 = false;
        goto L19
    L15:
        if (r9.equals(r2) == false) goto L17;
    L33:
        return null;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}
