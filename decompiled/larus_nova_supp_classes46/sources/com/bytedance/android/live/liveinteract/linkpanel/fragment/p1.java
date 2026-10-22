package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.DialogInterface;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ VideoTalkSettingFragment a;
    public final /* synthetic */ boolean b;

    public p1(VideoTalkSettingFragment r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        r3.dismiss();
        ILinkPanelService r5 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r5 == null) goto L6;
        r5.close();
    L6:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.b.a() == false) goto L11;
        VideoTalkSettingFragment r6 = this.a;
        boolean r0 = this.b;
        int r1 = VideoTalkSettingFragment.z;
        if (r6.v == false) goto L10;
        r6.v = false;
    L12:
        com.bytedance.android.live.liveinteract.linkpanel.util.o.E(this.a.r, "confirm");
        return;
    L10:
        r6.ra0(r0);
        r6.ia0(r0);
        goto L12
    L11:
        f2.b(2131917584, 0);
        goto L12
    }
}
