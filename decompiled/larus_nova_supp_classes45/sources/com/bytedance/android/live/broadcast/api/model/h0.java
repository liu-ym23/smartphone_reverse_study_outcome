package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.ugm.api.webcast_anchor_manager.GenLiveRoomTopicResponse.ResponseData")
public final class h0 implements vh7.h {
    public h0() {
    }

    public h0(am3.g r5) {
        long r0 = r5.c();
    L4:
        if (r5.f() == (-1)) goto L6;
        am3.h.e(r5);
        goto L4
    L6:
        r5.d(r0);
    }
}
