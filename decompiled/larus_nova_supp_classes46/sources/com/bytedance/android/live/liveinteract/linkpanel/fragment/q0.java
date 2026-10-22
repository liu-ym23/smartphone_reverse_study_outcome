package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q0 implements View.OnClickListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public q0(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (((Boolean) vm2.c.e.getValue(null, vm2.c.a[3])).booleanValue() == false) goto L7;
        IMiddlewareLiveService r4 = TTLiveServiceMiddleware.getLiveService();
        if (r4 == null) goto L11;
        r4.showLivePrivilegeManagerDialog(this.a.getContext());
        return;
    L11:
        return;
    L7:
        IMiddlewareLiveService r5 = TTLiveServiceMiddleware.getLiveService();
        if (r5 == null) goto L13;
        r5.showLiveProfileManagerDialog(this.a.getContext());
        return;
    }
}
