package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements am3.c<ListUserLinkmicContent> {
    public m() {
    }

    public final Object decode(am3.g r7) throws Exception {
        ListUserLinkmicContent r0 = new ListUserLinkmicContent();
        r0.setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L24;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L8;
        r0.resourceId = r7.j();
        goto L3
    L8:
        if (r3 != 3) goto L10;
        r0.role = r7.i();
        goto L3
    L10:
        if (r3 != 4) goto L11;
        r0.mGameName = am3.h.c(r7);
        goto L3
    L11:
        switch(r3) {
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            default: goto L12;
        };
    L13:
        r0.virtualTool = am3.h.c(r7);
        goto L3
    L14:
        r0.liveRoomMode = r7.j();
        goto L3
    L15:
        r0.hostSwitch = am3.h.a(r7);
        goto L3
    L16:
        r0.hostLabelNameColor = am3.h.c(r7);
        goto L3
    L17:
        r0.hostLabelBackgroundColor = am3.h.c(r7);
        goto L3
    L18:
        r0.hostLabelName = am3.h.c(r7);
        goto L3
    L19:
        r0.anchorAuthRole = r7.i();
        goto L3
    L20:
        r0.mAnchorLinkMicIdInfo = (AnchorLinkMicIdInfo) vh7.f.a(r7, AnchorLinkMicIdInfo.class);
        goto L3
    L12:
        am3.h.d(r4, r7);
        goto L3
    L24:
        r7.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }
}
