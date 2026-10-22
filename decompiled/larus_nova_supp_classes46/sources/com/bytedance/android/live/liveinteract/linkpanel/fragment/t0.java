package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t0 implements View.OnClickListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public t0(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        tb6.a.b();
        int r3 = com.bytedance.android.live.liveinteract.revenue.guestlink.a.a;
        com.bytedance.android.live.liveinteract.revenue.guestlink.a.b(this.a.requireContext());
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.l1;
        Boolean r0 = Boolean.FALSE;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
    }
}
