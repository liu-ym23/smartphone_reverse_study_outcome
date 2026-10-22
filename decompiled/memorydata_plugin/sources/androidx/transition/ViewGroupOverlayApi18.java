package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay mViewGroupOverlay;

    ViewGroupOverlayApi18(ViewGroup r1) {
        this.mViewGroupOverlay = r1.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(Drawable r1) {
        this.mViewGroupOverlay.add(r1);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(View r1) {
        this.mViewGroupOverlay.add(r1);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(Drawable r1) {
        this.mViewGroupOverlay.remove(r1);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(View r1) {
        this.mViewGroupOverlay.remove(r1);
    }
}
