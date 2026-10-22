package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import com.bytedance.android.live.liveinteract.api.IInteractService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements ye0.a {
    public final /* synthetic */ MultiLinkVoiceGuestContainerWidget a;
    public final /* synthetic */ Runnable b;

    @Override // ye0.a
    public final void onFailure() {
        Runnable r0 = this.b;
        if (r0 == null) goto L5;
        r0.run();
    L5:
        MultiLinkVoiceGuestContainerWidget.wq(this.a);
    }

    @Override // ye0.a
    public final void onSuccess() {
        if (jc1.k.f(IInteractService.class) != null) goto L5;
    L7:
        Runnable r0 = this.b;
        if (r0 == null) goto L11;
        r0.run();
        return;
    L11:
        return;
    L5:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getInteractFloatWindowService() == null) goto L7;
        ((com.bytedance.android.live.liveinteract.service.g) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractFloatWindowService()).d(true);
        goto L7
    }

    public n(MultiLinkVoiceGuestContainerWidget r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }
}
