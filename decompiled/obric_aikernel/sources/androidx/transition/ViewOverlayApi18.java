package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(18)
class ViewOverlayApi18 implements ViewOverlayImpl {
    private final ViewOverlay mViewOverlay;

    ViewOverlayApi18(@NonNull View r10) {
        this.mViewOverlay = r10.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(@NonNull Drawable r10) {
        this.mViewOverlay.add(r10);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(@NonNull Drawable r10) {
        this.mViewOverlay.remove(r10);
    }
}
