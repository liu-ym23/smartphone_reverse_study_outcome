package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void setTransitionVisibility(View r5, int r10) {
            r5.setTransitionVisibility(r10);
        }
    }

    public ViewUtilsApi23() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    @SuppressLint({"NewApi"})
    public void setTransitionVisibility(@NonNull View r5, int r10) {
        if (sTryHiddenSetTransitionVisibility == false) goto L10;
        Api29Impl.setTransitionVisibility(r5, r10);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenSetTransitionVisibility = false;
        return;
    }
}
