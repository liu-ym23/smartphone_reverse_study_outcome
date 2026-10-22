package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public q1(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
        com.bytedance.android.live.liveinteract.linkpanel.util.o.E(this.a.r, "cancel");
    }
}
