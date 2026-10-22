package com.bytedance.android.ec.adapter.impl.adapters.views;

import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements IExternalView {
    public final wd.e a;

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

    public c(wd.e r10) {
        Intrinsics.checkNotNullParameter(r10, "realView");
        this.a = r10;
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
