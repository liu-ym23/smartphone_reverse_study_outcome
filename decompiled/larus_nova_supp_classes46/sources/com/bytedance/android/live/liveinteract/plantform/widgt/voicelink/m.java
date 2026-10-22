package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements ye0.a {
    public final /* synthetic */ MultiLinkVoiceGuestContainerWidget a;
    public final /* synthetic */ Runnable b;

    @Override // ye0.a
    public final void onFailure() {
        Runnable r0 = this.b;
        if (r0 == null) goto L5;
        r0.run();
    L5:
        DataCenter r1 = ((Widget) this.a).dataCenter;
        if (r1 == null) goto L8;
        r1.put("data_close_room_from_small_window_play", Boolean.FALSE);
    L8:
        MultiLinkVoiceGuestContainerWidget.wq(this.a);
    }

    @Override // ye0.a
    public final void onSuccess() {
        if (jc1.k.f(IInteractService.class) != null) goto L5;
    L7:
        Runnable r0 = this.b;
        if (r0 == null) goto L10;
        r0.run();
    L10:
        DataCenter r1 = ((Widget) this.a).dataCenter;
        if (r1 == null) goto L14;
        r1.put("data_close_room_from_small_window_play", Boolean.FALSE);
        return;
    L14:
        return;
    L5:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getInteractFloatWindowService() == null) goto L7;
        ((com.bytedance.android.live.liveinteract.service.g) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractFloatWindowService()).d(false);
        goto L7
    }

    public m(MultiLinkVoiceGuestContainerWidget r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }
}
