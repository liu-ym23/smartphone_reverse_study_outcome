package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.message.e2;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends a implements vlc.l {
    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        com.bytedance.android.livesdk.chatroom.t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        r1.c(new FriendOnlineDataHandler$attachMessage$1(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        com.bytedance.android.livesdk.chatroom.t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        r1.c(new FriendOnlineDataHandler$detachMessage$1(this));
        return;
    L9:
        return;
    }

    public f() {
    }

    public final void onMessage(tlc.d r4) {
        if ((r4 instanceof e2) == false) goto L8;
        ALogger.d("ttlive_link", "receive ILinkMicFriendOnlineMessage.");
        boolean r0 = tb1.d.a;
        if (((Boolean) vm2.d.X6.getValue(null, vm2.d.a[411(0x19b, float:5.76E-43)])).booleanValue() == false) goto L9;
        e2 r5 = (e2) r4;
        ch0.b r1 = new ch0.b(r5.getFriend(), r5.isIsInRoom());
        a().O0(r1);
        return;
    L9:
        return;
    }
}
