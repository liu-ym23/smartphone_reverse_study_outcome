package com.bytedance.android.live.liveinteract.videotalk;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

    public g(MultiLinkVideoTalkRoomAnchorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        String r4 = (String) r3;
        if (com.bytedance.android.live.liveinteract.spatial.a.e(this.a.C0()) == false) goto L8;
        com.bytedance.android.live.liveinteract.spatial.b.a("[VideoTalk]VideoTalkRoomAnchorWidget", "singingGuestId changed  new " + r4 + " updateSpatialAudioPosition------");
        MultiLinkVideoTalkRoomAnchorWidget r5 = this.a;
        tf0.o r0 = r5.E;
        if (r0 == null) goto L9;
        r0.u(Boolean.valueOf(r5.isEngineOn()));
        return;
    L9:
        return;
    }
}
