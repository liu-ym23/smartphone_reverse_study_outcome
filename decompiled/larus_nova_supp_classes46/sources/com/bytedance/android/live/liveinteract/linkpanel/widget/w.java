package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ LinkPanelTopBarWidget a;
    public final /* synthetic */ Ref.IntRef b;

    public w(LinkPanelTopBarWidget r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L10;
        int r5 = this.b.element;
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 == null) goto L7;
        r0.j3(r5);
    L7:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L10;
        r1.updatePosition(r5);
    L10:
        yf0.g r6 = this.a.i;
        if (r6 == null) goto L14;
        r6.dismiss();
        return;
    }
}
