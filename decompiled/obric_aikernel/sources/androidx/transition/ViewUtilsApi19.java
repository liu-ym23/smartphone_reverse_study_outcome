package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
class ViewUtilsApi19 extends ViewUtilsBase {
    private static boolean sTryHiddenTransitionAlpha = true;

    static {
    }

    ViewUtilsApi19() {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void clearNonTransitionAlpha(@NonNull View r10) {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public float getTransitionAlpha(@NonNull View r10) {
        if (sTryHiddenTransitionAlpha == false) goto L8;
        return r10.getTransitionAlpha();
    L6:
        sTryHiddenTransitionAlpha = false;
    L8:
        return r10.getAlpha();
    }

    @Override // androidx.transition.ViewUtilsBase
    public void saveNonTransitionAlpha(@NonNull View r10) {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setTransitionAlpha(@NonNull View r10, float r11) {
        if (sTryHiddenTransitionAlpha == true) goto L9;
    L7:
        r10.setAlpha(r11);
        return;
    L9:
        r10.setTransitionAlpha(r11);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenTransitionAlpha = false;
        goto L7
    }
}
