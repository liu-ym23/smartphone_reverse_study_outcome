package com.bytedance.android.live.liveinteract.bgComponent.platform;

import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/bgComponent/platform/MultiLinkBgManagerWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkBgManagerWidget extends PlatformMultiLinkWidget {
    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget
    public final void multiLinkRoomScopeFallback() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return je0.d.f();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        int r0 = vd0.a.g;
        vd0.a.C0284a.a(((Widget) this).dataCenter);
    }

    public MultiLinkBgManagerWidget() {
    }
}
