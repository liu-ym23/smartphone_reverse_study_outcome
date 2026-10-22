package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewUtilsApi19 {
    private static final String TAG = "ViewUtilsApi19";
    private static final int VISIBILITY_MASK = 12;
    private static boolean sSetFrameFetched = false;
    private static Method sSetFrameMethod = null;
    private static boolean sTryHiddenTransitionAlpha = true;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;
    private float[] mMatrixValues;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static float getTransitionAlpha(View r5) {
            return r5.getTransitionAlpha();
        }

        @DoNotInline
        public static void setTransitionAlpha(View r5, float r10) {
            r5.setTransitionAlpha(r10);
        }
    }

    public ViewUtilsApi19() {
    }

    @SuppressLint({"PrivateApi", "SoonBlockedPrivateApi"})
    private void fetchSetFrame() {
        if (sSetFrameFetched == false) goto L11;
        return;
    L11:
        Class r5 = Integer.TYPE;     // Catch: NoSuchMethodException -> L7
        Method r10 = View.class.getDeclaredMethod("setFrame", new Class[]{r5, r5, r5, r5});     // Catch: NoSuchMethodException -> L7
        sSetFrameMethod = r10;     // Catch: NoSuchMethodException -> L7
        r10.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L9:
        sSetFrameFetched = true;
        return;
    L7:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve setFrame method", e);
        goto L9
    }

    public void clearNonTransitionAlpha(@NonNull View r5) {
    }

    @SuppressLint({"NewApi"})
    public float getTransitionAlpha(@NonNull View r5) {
        if (sTryHiddenTransitionAlpha == false) goto L8;
        return Api29Impl.getTransitionAlpha(r5);
    L6:
        sTryHiddenTransitionAlpha = false;
    L8:
        return r5.getAlpha();
    }

    public void saveNonTransitionAlpha(@NonNull View r5) {
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
        float[] r5 = this.mMatrixValues;
        if (r5 != null) goto L10;
        r5 = new float[9];
        this.mMatrixValues = r5;
    L10:
        r11.getValues(r5);
        float r12 = r5[3];
        float r13 = (float) Math.sqrt(1.0f - (r12 * r12));
        if (r5[0] >= 0.0f) goto L13;
        int r14 = -1;
    L14:
        float r15 = r13 * r14;
        float r16 = (float) Math.toDegrees(Math.atan2(r12, r15));
        float r17 = r5[0] / r15;
        float r18 = r5[4] / r15;
        float r19 = r5[2];
        float r20 = r5[5];
        r10.setPivotX(0.0f);
        r10.setPivotY(0.0f);
        r10.setTranslationX(r19);
        r10.setTranslationY(r20);
        r10.setRotation(r16);
        r10.setScaleX(r17);
        r10.setScaleY(r18);
        return;
    L13:
        r14 = 1;
        goto L14
    }

    @SuppressLint({"BanUncheckedReflection"})
    public void setLeftTopRightBottom(@NonNull View r5, int r10, int r11, int r12, int r13) {
        fetchSetFrame();
        Method r14 = sSetFrameMethod;
        if (r14 != null) goto L11;
        return;
    L11:
        r14.invoke(r5, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13)});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L10
        goto L14
    L13:
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    @SuppressLint({"NewApi"})
    public void setTransitionAlpha(@NonNull View r5, float r10) {
        if (sTryHiddenTransitionAlpha == true) goto L9;
    L7:
        r5.setAlpha(r10);
        return;
    L9:
        Api29Impl.setTransitionAlpha(r5, r10);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenTransitionAlpha = false;
        goto L7
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public void setTransitionVisibility(@NonNull View r5, int r10) {
        if (sViewFlagsFieldFetched == false) goto L16;
    L9:
        Field r11 = sViewFlagsField;
        if (r11 == null) goto L18;
        int r12 = r11.getInt(r5);     // Catch: IllegalAccessException -> L13
        sViewFlagsField.setInt(r5, (r12 & (-13)) | r10);     // Catch: IllegalAccessException -> L13
        return;
    L19:
        return;
    L18:
        return;
    L16:
        Field r13 = View.class.getDeclaredField("mViewFlags");     // Catch: NoSuchFieldException -> L7
        sViewFlagsField = r13;     // Catch: NoSuchFieldException -> L7
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L8:
        sViewFlagsFieldFetched = true;
    L7:
        Log.i(TAG, "fetchViewFlagsField: ");
        goto L8
    }

    public void transformMatrixToGlobal(@NonNull View r5, @NonNull Matrix r10) {
        Object r11 = r5.getParent();
        if ((r11 instanceof View) == false) goto L5;
        View r12 = (View) r11;
        transformMatrixToGlobal(r12, r10);
        r10.preTranslate(-r12.getScrollX(), -r12.getScrollY());
    L5:
        r10.preTranslate(r5.getLeft(), r5.getTop());
        Matrix r13 = r5.getMatrix();
        if (r13.isIdentity() == true) goto L9;
        r10.preConcat(r13);
        return;
    }

    public void transformMatrixToLocal(@NonNull View r5, @NonNull Matrix r10) {
        Object r11 = r5.getParent();
        if ((r11 instanceof View) == false) goto L5;
        View r12 = (View) r11;
        transformMatrixToLocal(r12, r10);
        r10.postTranslate(r12.getScrollX(), r12.getScrollY());
    L5:
        r10.postTranslate(-r5.getLeft(), -r5.getTop());
        Matrix r13 = r5.getMatrix();
        if (r13.isIdentity() == true) goto L11;
        Matrix r14 = new Matrix();
        if (r13.invert(r14) == false) goto L12;
        r10.postConcat(r14);
        return;
    L12:
        return;
    }
}
