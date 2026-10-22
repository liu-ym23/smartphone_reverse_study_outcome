package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void setLeftTopRightBottom(View r5, int r10, int r11, int r12, int r13) {
            r5.setLeftTopRightBottom(r10, r11, r12, r13);
        }
    }

    public ViewUtilsApi22() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    @SuppressLint({"NewApi"})
    public void setLeftTopRightBottom(@NonNull View r5, int r10, int r11, int r12, int r13) {
        if (sTryHiddenSetLeftTopRightBottom == false) goto L10;
        Api29Impl.setLeftTopRightBottom(r5, r10, r11, r12, r13);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSetLeftTopRightBottom = false;
        return;
    }
}
