package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.widget.CompoundButton;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public c1(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r2, boolean r3) {
        gd0.m r4 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r4 == null) goto L5;
        LinkPanelTransitService r5 = (LinkPanelTransitService) r4;
        r5.h(this.a.m, r3);
    L5:
        yf0.g r6 = this.a.d;
        if (r6 == null) goto L9;
        r6.dismiss();
        return;
    }
}
