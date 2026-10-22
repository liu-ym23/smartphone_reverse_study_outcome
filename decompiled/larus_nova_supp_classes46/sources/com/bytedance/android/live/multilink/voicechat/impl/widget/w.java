package com.bytedance.android.live.multilink.voicechat.impl.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

    public w(MultiLinkVoiceChatRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        if (com.bytedance.android.live.liveinteract.spatial.a.e(this.a.C0()) == false) goto L8;
        com.bytedance.android.live.liveinteract.spatial.b.a("MultiLinkVoiceChatRoomGuestWidget", r3 + " singingGuestId changed  new updateSpatialAudioPosition------");
        MultiLinkVoiceChatRoomGuestWidget r4 = this.a;
        tf0.o r0 = r4.Z;
        if (r0 == null) goto L9;
        r0.u(Boolean.valueOf(r4.isEngineOn()));
        return;
    L9:
        return;
    }
}
