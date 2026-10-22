package com.bytedance.android.live.liveinteract.api.chatroom.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LinkApplyType;", "", "", "value", "I", "getValue", "()I", "NORMAL", "SONG", "MATCH", "CITY", "CITYSONG", "STRONG_REACH", "PREPARE_APPLY", "PUBLIC_AREA_COMMENT", "KTV_MULTI_CHORUS", "GUEST_LINK_AGAIN", "REAL_TIME_CHORUS_INVITE", "LINK_FROM_LINK_RESULT", "ANCHOR_POINT_ENTER", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkApplyType extends Enum<LinkApplyType> {
    public static final LinkApplyType ANCHOR_POINT_ENTER = null;
    public static final LinkApplyType CITY = null;
    public static final LinkApplyType CITYSONG = null;
    public static final LinkApplyType GUEST_LINK_AGAIN = null;
    public static final LinkApplyType KTV_MULTI_CHORUS = null;
    public static final LinkApplyType LINK_FROM_LINK_RESULT = null;
    public static final LinkApplyType MATCH = null;
    public static final LinkApplyType NORMAL = null;
    public static final LinkApplyType PREPARE_APPLY = null;
    public static final LinkApplyType PUBLIC_AREA_COMMENT = null;
    public static final LinkApplyType REAL_TIME_CHORUS_INVITE = null;
    public static final LinkApplyType SONG = null;
    public static final LinkApplyType STRONG_REACH = null;
    public static final /* synthetic */ LinkApplyType[] a = null;
    private final int value;

    public static LinkApplyType valueOf(String r1) {
        return (LinkApplyType) r27.a.a(LinkApplyType.class, r1);
    }

    public static LinkApplyType[] values() {
        return (LinkApplyType[]) a.clone();
    }

    static {
        LinkApplyType r1 = new LinkApplyType("NORMAL", 0, 0);
        NORMAL = r1;
        LinkApplyType r2 = new LinkApplyType("SONG", 1, 1);
        SONG = r2;
        LinkApplyType r3 = new LinkApplyType("MATCH", 2, 2);
        MATCH = r3;
        LinkApplyType r4 = new LinkApplyType("CITY", 3, 4);
        CITY = r4;
        LinkApplyType r5 = new LinkApplyType("CITYSONG", 4, 5);
        CITYSONG = r5;
        LinkApplyType r6 = new LinkApplyType("STRONG_REACH", 5, 8);
        STRONG_REACH = r6;
        LinkApplyType r7 = new LinkApplyType("PREPARE_APPLY", 6, 32);
        PREPARE_APPLY = r7;
        LinkApplyType r8 = new LinkApplyType("PUBLIC_AREA_COMMENT", 7, 256);
        PUBLIC_AREA_COMMENT = r8;
        LinkApplyType r9 = new LinkApplyType("KTV_MULTI_CHORUS", 8, 512);
        KTV_MULTI_CHORUS = r9;
        LinkApplyType r10 = new LinkApplyType("GUEST_LINK_AGAIN", 9, 1024);
        GUEST_LINK_AGAIN = r10;
        LinkApplyType r11 = new LinkApplyType("REAL_TIME_CHORUS_INVITE", 10, 2048);
        REAL_TIME_CHORUS_INVITE = r11;
        LinkApplyType r12 = new LinkApplyType("LINK_FROM_LINK_RESULT", 11, 4096);
        LINK_FROM_LINK_RESULT = r12;
        LinkApplyType r13 = new LinkApplyType("ANCHOR_POINT_ENTER", 12, 8192);
        ANCHOR_POINT_ENTER = r13;
        a = new LinkApplyType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13};
    }

    public final int getValue() {
        return this.value;
    }

    public LinkApplyType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
