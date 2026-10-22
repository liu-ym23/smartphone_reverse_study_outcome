package com.bytedance.android.ec.adapter.impl.adapters.views;

import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IExternalButton {
    public final wd.d a;

    public final View getButtonViewInMore() {
        return this.a.getButtonViewInMore();
    }

    public final String getTargetButtonName() {
        return this.a.getTargetButtonName();
    }

    public final View getView() {
        return this.a.getView();
    }

    public final void onHide() {
        this.a.onHide();
    }

    public final void onLoad() {
        this.a.onLoad();
    }

    public final void onShow() {
        this.a.onShow();
    }

    public final void onUnload() {
        this.a.onUnload();
    }

    public final void onViewDetached() {
        this.a.onViewDetached();
    }

    public final void onViewWillDetach() {
        this.a.onViewWillDetach();
    }

    public a(wd.d r10) {
        Intrinsics.checkNotNullParameter(r10, "realButton");
        this.a = r10;
    }

    public final void onBehaviorUpdate(String r10) {
        Intrinsics.checkNotNullParameter(r10, "extraData");
        IExternalButton.DefaultImpls.onBehaviorUpdate(this, r10);
    }

    public final void onShow(ToolbarMatchInterface r1) {
        IExternalButton.DefaultImpls.onShow(this, r1);
    }

    public final boolean onTriggerAnimation(long r10) {
        return this.a.onTriggerAnimation(r10);
    }

    public final void onViewAttached(Rect r10) {
        Intrinsics.checkNotNullParameter(r10, "viewContainerLayoutParam");
        this.a.onViewAttached(new wd.c(r10.getLeft(), r10.getTop(), r10.getWidth(), r10.getHeight()));
    }

    public final void onViewWillAttach(Rect r10) {
        Intrinsics.checkNotNullParameter(r10, "viewContainerLayoutParam");
        this.a.onViewWillAttach(new wd.c(r10.getLeft(), r10.getTop(), r10.getWidth(), r10.getHeight()));
    }
}
