package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0 extends y50.b {
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public final void b(Map<String, Object> r5) {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        String r1 = null;
        if (r0 == null) goto L5;
        LinkCrossRoomDataHolder r2 = r0.getLinkCrossRoomDataHolder();
    L6:
        if (r2 == null) goto L8;
        long r3 = r2.c();
    L9:
        r5.put("channel_id", Long.valueOf(r3));
        com.bytedance.android.live.revlink.impl.global.c r4 = this.c;
        if (r4 == null) goto L12;
        com.bytedance.android.live.revlink.impl.utils.s r6 = r4.getRevLinkCommonUtil();
    L13:
        if (r6 == null) goto L15;
        String r7 = r6.e();
    L16:
        r5.put("user_id", String.valueOf(r7));
        com.bytedance.android.livesdk.revenue.service.room.c r8 = this.b;
        if (r8 == null) goto L21;
        com.bytedance.android.livesdk.revenue.room.a r9 = r8.getRoomContext();
        if (r9 == null) goto L21;
        IRoomBase r10 = r9.getCommonRoom();
    L22:
        IRoomBase r12 = (IRoom) r10;
        if (r12 == null) goto L26;
        String r13 = String.valueOf(IRoomKtKt.getId(r12));
        if (r13 == null) goto L26;
    L27:
        r5.put("room_id", r13);
        com.bytedance.android.livesdk.revenue.service.room.c r14 = this.b;
        if (r14 == null) goto L32;
        com.bytedance.android.livesdk.revenue.room.a r15 = r14.getRoomContext();
        if (r15 == null) goto L32;
        IRoomBase r16 = r15.getCommonRoom();
    L33:
        IRoom r17 = (IRoom) r16;
        if (r17 == null) goto L38;
        IBaseUser r18 = r17.getOwnerKt();
        if (r18 == null) goto L38;
        r1 = r18.getIdString();
    L38:
        r5.put("anchor_id", String.valueOf(r1));
        return;
    L32:
        r16 = null;
    L26:
        r13 = "";
    L21:
        r10 = null;
        goto L22
    L15:
        r7 = null;
        goto L16
    L12:
        r6 = null;
        goto L13
    L8:
        r3 = 0;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public f0(com.bytedance.android.livesdk.revenue.service.room.c r1, LinkFakeGlobalService r2) {
        this.b = r1;
        this.c = r2;
    }
}
