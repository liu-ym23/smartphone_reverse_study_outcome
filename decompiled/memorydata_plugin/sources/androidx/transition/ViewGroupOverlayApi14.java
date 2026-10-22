package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    ViewGroupOverlayApi14(Context r3, ViewGroup r4, View r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    static ViewGroupOverlayApi14 createFrom(ViewGroup r2) {
        return (ViewGroupOverlayApi14) ZeusTransformUtils.preCheckCast(ViewOverlayApi14.createFrom(r2), ViewGroupOverlayApi14.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(View r1) {
        this.mOverlayViewGroup.add(r1);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(View r1) {
        this.mOverlayViewGroup.remove(r1);
    }
}
