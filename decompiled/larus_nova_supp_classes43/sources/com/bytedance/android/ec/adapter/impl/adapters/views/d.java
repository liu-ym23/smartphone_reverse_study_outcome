package com.bytedance.android.ec.adapter.impl.adapters.views;

import android.view.View;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.IECWidgetType;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IWidgetType;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.jvm.internal.Intrinsics;
import wd.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements IExternalWidget, IWidgetType {
    public final g a;

    public final View getView() {
        return this.a.getView();
    }

    public final IWidgetType.ExternalWidgetType getWidgetType() {
        g r0 = this.a;
        if ((r0 instanceof IECWidgetType) == false) goto L15;
        int r1 = ((IECWidgetType) r0).j().getValue();
        IWidgetType.ExternalWidgetType r10 = IWidgetType.ExternalWidgetType.ECOMMERCE_SIZE_COMPONENTS;
        if (r1 == r10.getValue()) goto L17;
        IWidgetType.ExternalWidgetType r11 = IWidgetType.ExternalWidgetType.ECOMMERCE_POP_CARD;
        if (r1 == r11.getValue()) goto L18;
        IWidgetType.ExternalWidgetType r12 = IWidgetType.ExternalWidgetType.ECOMMERCE_PROPERTY_COMPONENTS;
        if (r1 != r12.getValue()) goto L16;
        return r12;
    L16:
        return IWidgetType.ExternalWidgetType.UNKNOWN;
    L18:
        return r11;
    L17:
        return r10;
    L15:
        return IWidgetType.ExternalWidgetType.UNKNOWN;
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

    public d(g r10) {
        Intrinsics.checkNotNullParameter(r10, "realWidget");
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
