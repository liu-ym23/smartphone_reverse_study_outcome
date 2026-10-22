package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class ViewUtilsApi21 extends ViewUtilsApi19 {
    private static boolean sTryHiddenSetAnimationMatrix = true;
    private static boolean sTryHiddenTransformMatrixToGlobal = true;
    private static boolean sTryHiddenTransformMatrixToLocal = true;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void setAnimationMatrix(View r5, Matrix r10) {
            r5.setAnimationMatrix(r10);
        }

        @DoNotInline
        public static void transformMatrixToGlobal(View r5, Matrix r10) {
            r5.transformMatrixToGlobal(r10);
        }

        @DoNotInline
        public static void transformMatrixToLocal(View r5, Matrix r10) {
            r5.transformMatrixToLocal(r10);
        }
    }

    public ViewUtilsApi21() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    @SuppressLint({"NewApi"})
    public void setAnimationMatrix(@NonNull View r5, @Nullable Matrix r10) {
        if (sTryHiddenSetAnimationMatrix == false) goto L10;
        Api29Impl.setAnimationMatrix(r5, r10);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSetAnimationMatrix = false;
        return;
    }

    @Override // androidx.transition.ViewUtilsApi19
    @SuppressLint({"NewApi"})
    public void transformMatrixToGlobal(@NonNull View r5, @NonNull Matrix r10) {
        if (sTryHiddenTransformMatrixToGlobal == false) goto L10;
        Api29Impl.transformMatrixToGlobal(r5, r10);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenTransformMatrixToGlobal = false;
        return;
    }

    @Override // androidx.transition.ViewUtilsApi19
    @SuppressLint({"NewApi"})
    public void transformMatrixToLocal(@NonNull View r5, @NonNull Matrix r10) {
        if (sTryHiddenTransformMatrixToLocal == false) goto L10;
        Api29Impl.transformMatrixToLocal(r5, r10);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenTransformMatrixToLocal = false;
        return;
    }
}
