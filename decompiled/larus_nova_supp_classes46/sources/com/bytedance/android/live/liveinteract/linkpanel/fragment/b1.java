package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b1<T> implements Consumer {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public b1(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.j) r2).a == 0) goto L7;
        VideoTalkSettingFragment r3 = this.a;
        int r0 = VideoTalkSettingFragment.z;
        r3.va0();
        return;
    }
}
