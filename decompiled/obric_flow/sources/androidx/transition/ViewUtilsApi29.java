package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
class ViewUtilsApi29 extends ViewUtilsApi23 {
    public ViewUtilsApi29() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    public float getTransitionAlpha(@NonNull View r5) {
        return r5.getTransitionAlpha();
    }

    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsApi19
    public void setAnimationMatrix(@NonNull View r5, @Nullable Matrix r10) {
        r5.setAnimationMatrix(r10);
    }

    @Override // androidx.transition.ViewUtilsApi22, androidx.transition.ViewUtilsApi19
    public void setLeftTopRightBottom(@NonNull View r5, int r10, int r11, int r12, int r13) {
        r5.setLeftTopRightBottom(r10, r11, r12, r13);
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void setTransitionAlpha(@NonNull View r5, float r10) {
        r5.setTransitionAlpha(r10);
    }

    @Override // androidx.transition.ViewUtilsApi23, androidx.transition.ViewUtilsApi19
    public void setTransitionVisibility(@NonNull View r5, int r10) {
        r5.setTransitionVisibility(r10);
    }

    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsApi19
    public void transformMatrixToGlobal(@NonNull View r5, @NonNull Matrix r10) {
        r5.transformMatrixToGlobal(r10);
    }

    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsApi19
    public void transformMatrixToLocal(@NonNull View r5, @NonNull Matrix r10) {
        r5.transformMatrixToLocal(r10);
    }
}
