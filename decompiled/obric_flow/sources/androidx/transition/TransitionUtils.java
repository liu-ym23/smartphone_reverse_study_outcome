package androidx.transition;

import ai.j0;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes.dex */
class TransitionUtils {
    private static final boolean HAS_PICTURE_BITMAP = false;
    private static final int MAX_IMAGE_SIZE = 1048576;

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static Bitmap createBitmap(Picture r5) {
            return Bitmap.createBitmap(r5);
        }
    }

    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        final float[] mTempEndValues;
        final Matrix mTempMatrix;
        final float[] mTempStartValues;

        public MatrixEvaluator() {
            this.mTempStartValues = new float[9];
            this.mTempEndValues = new float[9];
            this.mTempMatrix = new Matrix();
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Matrix evaluate(float r5, Matrix r10, Matrix r11) {
            return evaluate2(r5, r10, r11);
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public Matrix evaluate2(float r5, Matrix r10, Matrix r11) {
            r10.getValues(this.mTempStartValues);
            r11.getValues(this.mTempEndValues);
            int r12 = 0;
        L4:
            if (r12 >= 9) goto L6;
            float[] r13 = this.mTempEndValues;
            float r14 = r13[r12];
            float r15 = this.mTempStartValues[r12];
            r13[r12] = j0.b(r14, r15, r5, r15);
            r12 = r12 + 1;
            goto L4
        L6:
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }
    }

    static {
        HAS_PICTURE_BITMAP = true;
    }

    private TransitionUtils() {
    }

    public static View copyViewImage(ViewGroup r10, View r11, View r12) {
        Matrix r5 = new Matrix();
        r5.setTranslate(-r12.getScrollX(), -r12.getScrollY());
        ViewUtils.transformMatrixToGlobal(r11, r5);
        ViewUtils.transformMatrixToLocal(r10, r5);
        RectF r13 = new RectF(0.0f, 0.0f, r11.getWidth(), r11.getHeight());
        r5.mapRect(r13);
        int r14 = Math.round(r13.left);
        int r15 = Math.round(r13.top);
        int r16 = Math.round(r13.right);
        int r17 = Math.round(r13.bottom);
        ImageView r18 = new ImageView(r11.getContext());
        r18.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap r19 = createViewBitmap(r11, r5, r13, r10);
        if (r19 == null) goto L5;
        r18.setImageBitmap(r19);
    L5:
        r18.measure(View.MeasureSpec.makeMeasureSpec(r16 - r14, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r17 - r15, BasicMeasure.EXACTLY));
        r18.layout(r14, r15, r16, r17);
        return r18;
    }

    private static Bitmap createViewBitmap(View r10, Matrix r11, RectF r12, ViewGroup r13) {
        boolean r5 = r10.isAttachedToWindow();
        if (r13 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        Bitmap r15 = null;
        if (r5 == true) goto L13;
        if (r14 == true) goto L12;
        return null;
    L12:
        ViewGroup r16 = (ViewGroup) r10.getParent();
        int r17 = r16.indexOfChild(r10);
        r13.getOverlay().add(r10);
    L14:
        int r18 = Math.round(r12.width());
        int r19 = Math.round(r12.height());
        if (r18 <= 0) goto L21;
        if (r19 <= 0) goto L21;
        float r20 = Math.min(1.0f, 1048576.0f / (r18 * r19));
        int r21 = Math.round(r18 * r20);
        int r22 = Math.round(r19 * r20);
        r11.postTranslate(-r12.left, -r12.top);
        r11.postScale(r20, r20);
        if (HAS_PICTURE_BITMAP == false) goto L20;
        Picture r23 = new Picture();
        Canvas r24 = r23.beginRecording(r21, r22);
        r24.concat(r11);
        r10.draw(r24);
        r23.endRecording();
        r15 = Api28Impl.createBitmap(r23);
        goto L21
    L20:
        r15 = Bitmap.createBitmap(r21, r22, Bitmap.Config.ARGB_8888);
        Canvas r25 = new Canvas(r15);
        r25.concat(r11);
        r10.draw(r25);
    L21:
        if (r5 == true) goto L23;
        r13.getOverlay().remove(r10);
        r16.addView(r10, r17);
    L23:
        return r15;
    L13:
        r17 = 0;
        r16 = null;
        goto L14
    L5:
        if (r13.isAttachedToWindow() == false) goto L7;
        r14 = true;
        goto L8
    }

    public static Animator mergeAnimators(Animator r5, Animator r10) {
        if (r5 != null) goto L4;
        return r10;
    L4:
        if (r10 != null) goto L6;
        return r5;
    L6:
        AnimatorSet r11 = new AnimatorSet();
        r11.playTogether(new Animator[]{r5, r10});
        return r11;
    }
}
