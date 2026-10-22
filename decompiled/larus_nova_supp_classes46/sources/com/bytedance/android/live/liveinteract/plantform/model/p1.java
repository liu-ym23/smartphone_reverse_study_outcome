package com.bytedance.android.live.liveinteract.plantform.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p1 implements am3.c<RoomLinkerContent> {
    public p1() {
    }

    public static RoomLinkerContent a(am3.g r6) throws Exception {
        RoomLinkerContent r0 = new RoomLinkerContent();
        r0.setThreadSafe(false);
        r0.linkedUsers = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L16;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r6);
        if (r3 != 5000) goto L7;
        r0.anchorId = am3.h.c(r6);
        goto L3
    L7:
        switch(r3) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        r0.roomLiveMode = r6.j();
        goto L3
    L10:
        r0.mVersion = r6.j();
        goto L3
    L11:
        r0.mIsGuestAnchorBackground = (int) r6.j();
        goto L3
    L12:
        r0.mAnchorId = r6.j();
        goto L3
    L13:
        r0.mRoomLinkSilenceStatus = r6.i();
        goto L3
    L14:
        r0.linkedUsers.add((com.bytedance.android.livesdk.link.model.bridge.k) vh7.f.a(r6, com.bytedance.android.livesdk.link.model.bridge.k.class));
        goto L3
    L8:
        am3.h.d(r4, r6);
        goto L3
    L16:
        r6.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
