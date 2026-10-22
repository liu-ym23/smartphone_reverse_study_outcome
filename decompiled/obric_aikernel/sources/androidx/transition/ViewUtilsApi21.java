package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class ViewUtilsApi21 extends ViewUtilsApi19 {
    private static boolean sTryHiddenSetAnimationMatrix = true;
    private static boolean sTryHiddenTransformMatrixToGlobal = true;
    private static boolean sTryHiddenTransformMatrixToLocal = true;

    static {
    }

    ViewUtilsApi21() {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setAnimationMatrix(@NonNull View r10, @Nullable Matrix r11) {
        if (sTryHiddenSetAnimationMatrix == false) goto L10;
        r10.setAnimationMatrix(r11);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSetAnimationMatrix = false;
        return;
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void transformMatrixToGlobal(@NonNull View r10, @NonNull Matrix r11) {
        if (sTryHiddenTransformMatrixToGlobal == false) goto L10;
        r10.transformMatrixToGlobal(r11);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenTransformMatrixToGlobal = false;
        return;
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void transformMatrixToLocal(@NonNull View r10, @NonNull Matrix r11) {
        if (sTryHiddenTransformMatrixToLocal == false) goto L10;
        r10.transformMatrixToLocal(r11);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenTransformMatrixToLocal = false;
        return;
    }
}
