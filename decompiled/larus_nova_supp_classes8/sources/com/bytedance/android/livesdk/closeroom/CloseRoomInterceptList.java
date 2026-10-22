package com.bytedance.android.livesdk.closeroom;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final enum CloseRoomInterceptList extends Enum<CloseRoomInterceptList> {
    public static final CloseRoomInterceptList AUTH_REWARD = null;
    public static final CloseRoomInterceptList COIN_TASK = null;
    public static final CloseRoomInterceptList CSJ_COMMERCE = null;
    public static final CloseRoomInterceptList DEFAULT = null;
    public static final CloseRoomInterceptList EXPAND_COUPON = null;
    public static final CloseRoomInterceptList LINKING_REMAIN = null;
    public static final CloseRoomInterceptList MORE_LIVE = null;
    public static final CloseRoomInterceptList SLIDE_TASK = null;
    public static final CloseRoomInterceptList TICKET_EXPAND = null;
    public static final CloseRoomInterceptList UG_COUPON_REMAIN = null;
    public static final /* synthetic */ CloseRoomInterceptList[] a = null;

    static {
        CloseRoomInterceptList r0 = new CloseRoomInterceptList("DEFAULT", 0);
        DEFAULT = r0;
        CloseRoomInterceptList r1 = new CloseRoomInterceptList("MORE_LIVE", 1);
        MORE_LIVE = r1;
        CloseRoomInterceptList r3 = new CloseRoomInterceptList("LINKING_REMAIN", 2);
        LINKING_REMAIN = r3;
        CloseRoomInterceptList r5 = new CloseRoomInterceptList("COIN_TASK", 3);
        COIN_TASK = r5;
        CloseRoomInterceptList r7 = new CloseRoomInterceptList("SLIDE_TASK", 4);
        SLIDE_TASK = r7;
        CloseRoomInterceptList r9 = new CloseRoomInterceptList("UG_COUPON_REMAIN", 5);
        UG_COUPON_REMAIN = r9;
        CloseRoomInterceptList r11 = new CloseRoomInterceptList("EXPAND_COUPON", 6);
        EXPAND_COUPON = r11;
        CloseRoomInterceptList r13 = new CloseRoomInterceptList("CSJ_COMMERCE", 7);
        CSJ_COMMERCE = r13;
        CloseRoomInterceptList r15 = new CloseRoomInterceptList("AUTH_REWARD", 8);
        AUTH_REWARD = r15;
        CloseRoomInterceptList r14 = new CloseRoomInterceptList("TICKET_EXPAND", 9);
        TICKET_EXPAND = r14;
        a = new CloseRoomInterceptList[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }

    public static CloseRoomInterceptList[] values() {
        return (CloseRoomInterceptList[]) a.clone();
    }

    public static CloseRoomInterceptList valueOf(String r1) {
        return (CloseRoomInterceptList) a.a(CloseRoomInterceptList.class, r1);
    }

    public CloseRoomInterceptList(String r1, int r2) {
        super(r1, r2);
    }
}
