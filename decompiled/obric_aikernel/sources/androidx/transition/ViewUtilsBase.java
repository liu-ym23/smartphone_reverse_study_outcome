package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewUtilsBase {
    private static final String TAG = "ViewUtilsBase";
    private static final int VISIBILITY_MASK = 12;
    private static boolean sSetFrameFetched;
    private static Method sSetFrameMethod;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;
    private float[] mMatrixValues;

    ViewUtilsBase() {
    }

    @SuppressLint({"PrivateApi"})
    private void fetchSetFrame() {
        if (sSetFrameFetched == false) goto L11;
        return;
    L11:
        Class r10 = Integer.TYPE;     // Catch: NoSuchMethodException -> L7
        Method r11 = View.class.getDeclaredMethod("setFrame", new Class[]{r10, r10, r10, r10});     // Catch: NoSuchMethodException -> L7
        sSetFrameMethod = r11;     // Catch: NoSuchMethodException -> L7
        r11.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L9:
        sSetFrameFetched = true;
        return;
    L7:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve setFrame method", e);
        goto L9
    }

    public void clearNonTransitionAlpha(@NonNull View r10) {
        if (r10.getVisibility() != 0) goto L6;
        r10.setTag(R.id.save_non_transition_alpha, null);
        return;
    }

    public float getTransitionAlpha(@NonNull View r10) {
        Float r11 = (Float) r10.getTag(R.id.save_non_transition_alpha);
        if (r11 == null) goto L7;
        return r10.getAlpha() / r11.floatValue();
    L7:
        return r10.getAlpha();
    }

    public void saveNonTransitionAlpha(@NonNull View r10) {
        int r11 = R.id.save_non_transition_alpha;
        if (r10.getTag(r11) != null) goto L6;
        r10.setTag(r11, Float.valueOf(r10.getAlpha()));
        return;
    }

    public void setAnimationMatrix(@NonNull View r10, @Nullable Matrix r11) {
        if (r11 != null) goto L5;
    L15:
        r10.setPivotX(r10.getWidth() / 2);
        r10.setPivotY(r10.getHeight() / 2);
        r10.setTranslationX(0.0f);
        r10.setTranslationY(0.0f);
        r10.setScaleX(1.0f);
        r10.setScaleY(1.0f);
        r10.setRotation(0.0f);
        return;
    L5:
        if (r11.isIdentity() == true) goto L15;
        float[] r12 = this.mMatrixValues;
        if (r12 != null) goto L10;
        r12 = new float[9];
        this.mMatrixValues = r12;
    L10:
        r11.getValues(r12);
        float r13 = r12[3];
        float r14 = (float) Math.sqrt(1.0f - (r13 * r13));
        if (r12[0] >= 0.0f) goto L13;
        int r15 = -1;
    L14:
        float r16 = r14 * r15;
        float r17 = (float) Math.toDegrees(Math.atan2(r13, r16));
        float r18 = r12[0] / r16;
        float r19 = r12[4] / r16;
        float r110 = r12[2];
        float r20 = r12[5];
        r10.setPivotX(0.0f);
        r10.setPivotY(0.0f);
        r10.setTranslationX(r110);
        r10.setTranslationY(r20);
        r10.setRotation(r17);
        r10.setScaleX(r18);
        r10.setScaleY(r19);
        return;
    L13:
        r15 = 1;
        goto L14
    }

    public void setLeftTopRightBottom(@NonNull View r10, int r11, int r12, int r13, int r14) {
        fetchSetFrame();
        Method r15 = sSetFrameMethod;
        if (r15 != null) goto L12;
        return;
    L12:
        r15.invoke(r10, new Object[]{Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13), Integer.valueOf(r14)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L11
        goto L15
    L14:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    public void setTransitionAlpha(@NonNull View r10, float r11) {
        Float r12 = (Float) r10.getTag(R.id.save_non_transition_alpha);
        if (r12 == null) goto L5;
        r10.setAlpha(r12.floatValue() * r11);
        return;
    L5:
        r10.setAlpha(r11);
    }

    public void setTransitionVisibility(@NonNull View r10, int r11) {
        if (sViewFlagsFieldFetched == false) goto L16;
    L9:
        Field r12 = sViewFlagsField;
        if (r12 == null) goto L18;
        int r13 = r12.getInt(r10);     // Catch: IllegalAccessException -> L13
        sViewFlagsField.setInt(r10, (r13 & (-13)) | r11);     // Catch: IllegalAccessException -> L13
        return;
    L19:
        return;
    L18:
        return;
    L16:
        Field r14 = View.class.getDeclaredField("mViewFlags");     // Catch: NoSuchFieldException -> L7
        sViewFlagsField = r14;     // Catch: NoSuchFieldException -> L7
        r14.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L8:
        sViewFlagsFieldFetched = true;
    L7:
        Log.i(TAG, "fetchViewFlagsField: ");
        goto L8
    }

    public void transformMatrixToGlobal(@NonNull View r10, @NonNull Matrix r11) {
        Object r12 = r10.getParent();
        if ((r12 instanceof View) == false) goto L5;
        View r13 = (View) r12;
        transformMatrixToGlobal(r13, r11);
        r11.preTranslate(-r13.getScrollX(), -r13.getScrollY());
    L5:
        r11.preTranslate(r10.getLeft(), r10.getTop());
        Matrix r14 = r10.getMatrix();
        if (r14.isIdentity() == true) goto L9;
        r11.preConcat(r14);
        return;
    }

    public void transformMatrixToLocal(@NonNull View r10, @NonNull Matrix r11) {
        Object r12 = r10.getParent();
        if ((r12 instanceof View) == false) goto L5;
        View r13 = (View) r12;
        transformMatrixToLocal(r13, r11);
        r11.postTranslate(r13.getScrollX(), r13.getScrollY());
    L5:
        r11.postTranslate(-r10.getLeft(), -r10.getTop());
        Matrix r14 = r10.getMatrix();
        if (r14.isIdentity() == true) goto L11;
        Matrix r15 = new Matrix();
        if (r14.invert(r15) == false) goto L12;
        r11.postConcat(r15);
        return;
    L12:
        return;
    }
}
