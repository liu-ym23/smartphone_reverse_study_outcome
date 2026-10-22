package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h1 implements View.OnClickListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public h1(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        VideoTalkSettingFragment r4 = this.a;
        yf0.g r0 = r4.d;
        if (r0 == null) goto L6;
        int r1 = ApplyPermissionSwitchFragment.o;
        r0.Rh(ApplyPermissionSwitchFragment.a.a(r0, r4.getRoom(), 1));
        return;
    }
}
