package com.bytedance.android.live.liveinteract.videotalk;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

    public x(MultiLinkVideoTalkRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        String r4 = (String) r3;
        tf0.o r0 = this.a.T;
        if (r0 == null) goto L5;
        int r1 = r0.C0();
    L7:
        if (com.bytedance.android.live.liveinteract.spatial.a.e(r1) == false) goto L12;
        com.bytedance.android.live.liveinteract.spatial.b.a("MultiLinkVideoTalkRoomGuestWidget", "singingGuestId changed  new " + r4 + " updateSpatialAudioPosition------");
        MultiLinkVideoTalkRoomGuestWidget r5 = this.a;
        tf0.o r2 = r5.T;
        if (r2 == null) goto L13;
        r2.u(Boolean.valueOf(r5.isEngineOn()));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = 0;
        goto L7
    }
}
