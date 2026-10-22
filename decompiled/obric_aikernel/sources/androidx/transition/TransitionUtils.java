package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
class TransitionUtils {
    private static final boolean HAS_IS_ATTACHED_TO_WINDOW = false;
    private static final boolean HAS_OVERLAY = false;
    private static final boolean HAS_PICTURE_BITMAP = false;
    private static final int MAX_IMAGE_SIZE = 1048576;

    static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        final float[] mTempEndValues;
        final Matrix mTempMatrix;
        final float[] mTempStartValues;

        MatrixEvaluator() {
            this.mTempStartValues = new float[9];
            this.mTempEndValues = new float[9];
            this.mTempMatrix = new Matrix();
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public Matrix evaluate2(float r10, Matrix r11, Matrix r12) {
            r11.getValues(this.mTempStartValues);
            r12.getValues(this.mTempEndValues);
            int r13 = 0;
        L4:
            if (r13 >= 9) goto L6;
            float[] r14 = this.mTempEndValues;
            float r15 = r14[r13];
            float[] r16 = this.mTempStartValues;
            float r17 = r15 - r16[r13];
            r14[r13] = r16[r13] + (r17 * r10);
            r13 = r13 + 1;
            goto L4
        L6:
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Matrix evaluate(float r10, Matrix r11, Matrix r12) {
            return evaluate2(r10, r11, r12);
        }
    }

    static {
        int r10 = Build.VERSION.SDK_INT;
        boolean r11 = true;
        if (r10 < 19) goto L5;
        boolean r12 = true;
    L6:
        HAS_IS_ATTACHED_TO_WINDOW = r12;
        if (r10 < 18) goto L9;
        boolean r13 = true;
    L10:
        HAS_OVERLAY = r13;
        if (r10 >= 28) goto L14;
        r11 = false;
    L14:
        HAS_PICTURE_BITMAP = r11;
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    private TransitionUtils() {
    }

    static View copyViewImage(ViewGroup r10, View r11, View r12) {
        Matrix r13 = new Matrix();
        r13.setTranslate(-r12.getScrollX(), -r12.getScrollY());
        ViewUtils.transformMatrixToGlobal(r11, r13);
        ViewUtils.transformMatrixToLocal(r10, r13);
        RectF r14 = new RectF(0.0f, 0.0f, r11.getWidth(), r11.getHeight());
        r13.mapRect(r14);
        int r15 = Math.round(r14.left);
        int r16 = Math.round(r14.top);
        int r17 = Math.round(r14.right);
        int r18 = Math.round(r14.bottom);
        ImageView r19 = new ImageView(r11.getContext());
        r19.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap r20 = createViewBitmap(r11, r13, r14, r10);
        if (r20 == null) goto L5;
        r19.setImageBitmap(r20);
    L5:
        r19.measure(View.MeasureSpec.makeMeasureSpec(r17 - r15, 1073741824), View.MeasureSpec.makeMeasureSpec(r18 - r16, 1073741824));
        r19.layout(r15, r16, r17, r18);
        return r19;
    }

    private static Bitmap createViewBitmap(View r10, Matrix r11, RectF r12, ViewGroup r13) {
        if (HAS_IS_ATTACHED_TO_WINDOW == false) goto L8;
        boolean r14 = !r10.isAttachedToWindow();
        if (r13 != null) goto L7;
        boolean r15 = false;
    L9:
        boolean r16 = HAS_OVERLAY;
        Bitmap r17 = null;
        if (r16 == false) goto L15;
        if (r14 == false) goto L15;
        if (r15 == true) goto L14;
        return null;
    L14:
        ViewGroup r18 = (ViewGroup) r10.getParent();
        int r19 = r18.indexOfChild(r10);
        r13.getOverlay().add(r10);
    L16:
        int r20 = Math.round(r12.width());
        int r21 = Math.round(r12.height());
        if (r20 <= 0) goto L23;
        if (r21 <= 0) goto L23;
        float r22 = Math.min(1.0f, 1048576.0f / (r20 * r21));
        int r23 = Math.round(r20 * r22);
        int r24 = Math.round(r21 * r22);
        r11.postTranslate(-r12.left, -r12.top);
        r11.postScale(r22, r22);
        if (HAS_PICTURE_BITMAP == false) goto L22;
        Picture r110 = new Picture();
        Canvas r25 = r110.beginRecording(r23, r24);
        r25.concat(r11);
        r10.draw(r25);
        r110.endRecording();
        r17 = Bitmap.createBitmap(r110);
        goto L23
    L22:
        r17 = Bitmap.createBitmap(r23, r24, Bitmap.Config.ARGB_8888);
        Canvas r111 = new Canvas(r17);
        r111.concat(r11);
        r10.draw(r111);
    L23:
        if (r16 == false) goto L26;
        if (r14 == false) goto L26;
        r13.getOverlay().remove(r10);
        r18.addView(r10, r19);
    L26:
        return r17;
    L15:
        r19 = 0;
        r18 = null;
        goto L16
    L7:
        r15 = r13.isAttachedToWindow();
        goto L9
    L8:
        r14 = false;
        r15 = false;
        goto L9
    }

    static Animator mergeAnimators(Animator r10, Animator r11) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        if (r11 != null) goto L6;
        return r10;
    L6:
        AnimatorSet r12 = new AnimatorSet();
        r12.playTogether(new Animator[]{r10, r11});
        return r12;
    }
}
