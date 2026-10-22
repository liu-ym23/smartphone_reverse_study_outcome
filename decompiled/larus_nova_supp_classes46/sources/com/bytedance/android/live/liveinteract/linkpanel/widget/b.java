package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        gd0.m r2 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r2 == null) goto L5;
        ((LinkPanelTransitService) r2).k();
    L5:
        this.a.a.s.dismiss();
    }
}
