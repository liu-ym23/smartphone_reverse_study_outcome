package com.bytedance.android.live.liveinteract.multianchor.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements am3.c<ListUserExtra> {
    public k() {
    }

    public final Object decode(am3.g r7) throws Exception {
        ListUserExtra r0 = new ListUserExtra();
        r0.setThreadSafe(false);
        r0.rankContributorOpenIds = new ArrayList();
        r0.rankUserIds = new ArrayList();
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L22;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r7);
        if (r3 != 5000) goto L7;
        r0.rankContributorOpenIds.add(am3.h.c(r7));
        goto L3
    L7:
        switch(r3) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            default: goto L8;
        };
    L9:
        r0.listUserRole = r7.i();
        goto L3
    L10:
        r0.rankUserIds.add(Long.valueOf(r7.j()));
        goto L3
    L11:
        r0.fanTicketRealStr = am3.h.c(r7);
        goto L3
    L12:
        r0.fanTicketFuzzyStr = am3.h.c(r7);
        goto L3
    L13:
        r0.currentTime = r7.j();
        goto L3
    L14:
        r0.expectLeaveTime = r7.j();
        goto L3
    L15:
        r0.joinChannelTime = r7.j();
        goto L3
    L16:
        r0.devicePlatform = am3.h.c(r7);
        goto L3
    L17:
        r0.clientVersion = r7.j();
        goto L3
    L18:
        r0.appId = r7.j();
        goto L3
    L19:
        r0.isHost = am3.h.a(r7);
        goto L3
    L20:
        r0.fanTicket = r7.j();
        goto L3
    L8:
        am3.h.d(r4, r7);
        goto L3
    L22:
        r7.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }
}
