package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    static {
    }

    ViewUtilsApi22() {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setLeftTopRightBottom(@NonNull View r10, int r11, int r12, int r13, int r14) {
        if (sTryHiddenSetLeftTopRightBottom == false) goto L10;
        r10.setLeftTopRightBottom(r11, r12, r13, r14);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSetLeftTopRightBottom = false;
        return;
    }
}
