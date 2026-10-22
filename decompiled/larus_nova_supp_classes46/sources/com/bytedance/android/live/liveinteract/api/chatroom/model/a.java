package com.bytedance.android.live.liveinteract.api.chatroom.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final LinkApplyType a(int r1) {
        if (r1 == 0) goto L41;
        if (r1 == 1) goto L54;
        if (r1 == 2) goto L53;
        if (r1 == 4) goto L52;
        if (r1 == 5) goto L51;
        if (r1 == 8) goto L50;
        if (r1 == 32) goto L49;
        if (r1 == 256) goto L48;
        if (r1 == 512) goto L47;
        if (r1 == 1024) goto L46;
        if (r1 == 2048) goto L45;
        if (r1 == 4096) goto L44;
        if (r1 == 8192) goto L43;
        return LinkApplyType.NORMAL;
    L43:
        return LinkApplyType.ANCHOR_POINT_ENTER;
    L44:
        return LinkApplyType.LINK_FROM_LINK_RESULT;
    L45:
        return LinkApplyType.REAL_TIME_CHORUS_INVITE;
    L46:
        return LinkApplyType.GUEST_LINK_AGAIN;
    L47:
        return LinkApplyType.KTV_MULTI_CHORUS;
    L48:
        return LinkApplyType.PUBLIC_AREA_COMMENT;
    L49:
        return LinkApplyType.PREPARE_APPLY;
    L50:
        return LinkApplyType.STRONG_REACH;
    L51:
        return LinkApplyType.CITYSONG;
    L52:
        return LinkApplyType.CITY;
    L53:
        return LinkApplyType.MATCH;
    L54:
        return LinkApplyType.SONG;
    L41:
        return LinkApplyType.NORMAL;
    }
}
