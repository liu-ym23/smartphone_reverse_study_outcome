package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(18)
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay mViewGroupOverlay;

    ViewGroupOverlayApi18(@NonNull ViewGroup r10) {
        this.mViewGroupOverlay = r10.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(@NonNull Drawable r10) {
        this.mViewGroupOverlay.add(r10);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(@NonNull View r10) {
        this.mViewGroupOverlay.add(r10);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(@NonNull Drawable r10) {
        this.mViewGroupOverlay.remove(r10);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(@NonNull View r10) {
        this.mViewGroupOverlay.remove(r10);
    }
}
