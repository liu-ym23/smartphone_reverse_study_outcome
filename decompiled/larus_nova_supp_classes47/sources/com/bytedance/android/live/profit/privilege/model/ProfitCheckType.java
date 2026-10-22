package com.bytedance.android.live.profit.privilege.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1¨\u00062"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/ProfitCheckType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "", "index", "J", "getIndex", "()J", "setIndex", "(J)V", "", "localReport", "Z", "getLocalReport", "()Z", "setLocalReport", "(Z)V", "Companion", "a", "ANCHOR_GIFT_IM", "ANCHOR_GIFT_EFFECT", "Unknown", "GIFT_TRAY", "GIFT_EFFECT", "GIFT_PUBLIC_AREA_MSG", "ENTER_ROOM_EFFECT", "DRESS_SHOW", "DRESS_OPEN_EFFECT", "GIFT_LIST_INFO", "SCREEN_CHAT_DISPLAY", "FANS_CLUB_PAGE", "PK", "GRADE_LEVEL", "EXHIBITION_INFO", "WISH_LIST", "AUDIENCE_RANK_LIST", "AWMELITE_TASK", "LINK_MIC_CONTRIBUTE_RANK_LIST", "CONSUME_REQUEST", "GIFT_EFFECT_SELF_IM", "GIFT_OPTION_RIGHT", "SHORT_TOUCH_SELF_LUCKYMONEY", "RECHARGE_COUPON_ACTIVITY", "GENERAL_TASK", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ProfitCheckType extends Enum<ProfitCheckType> {
    public static final ProfitCheckType ANCHOR_GIFT_EFFECT = null;
    public static final ProfitCheckType ANCHOR_GIFT_IM = null;
    public static final ProfitCheckType AUDIENCE_RANK_LIST = null;
    public static final ProfitCheckType AWMELITE_TASK = null;
    public static final ProfitCheckType CONSUME_REQUEST = null;
    public static final a Companion = null;
    public static final ProfitCheckType DRESS_OPEN_EFFECT = null;
    public static final ProfitCheckType DRESS_SHOW = null;
    public static final ProfitCheckType ENTER_ROOM_EFFECT = null;
    public static final ProfitCheckType EXHIBITION_INFO = null;
    public static final ProfitCheckType FANS_CLUB_PAGE = null;
    public static final ProfitCheckType GENERAL_TASK = null;
    public static final ProfitCheckType GIFT_EFFECT = null;
    public static final ProfitCheckType GIFT_EFFECT_SELF_IM = null;
    public static final ProfitCheckType GIFT_LIST_INFO = null;
    public static final ProfitCheckType GIFT_OPTION_RIGHT = null;
    public static final ProfitCheckType GIFT_PUBLIC_AREA_MSG = null;
    public static final ProfitCheckType GIFT_TRAY = null;
    public static final ProfitCheckType GRADE_LEVEL = null;
    public static final ProfitCheckType LINK_MIC_CONTRIBUTE_RANK_LIST = null;
    public static final long LOCAL_REPORT_INDEX = -114514;
    public static final ProfitCheckType PK = null;
    public static final ProfitCheckType RECHARGE_COUPON_ACTIVITY = null;
    public static final ProfitCheckType SCREEN_CHAT_DISPLAY = null;
    public static final ProfitCheckType SHORT_TOUCH_SELF_LUCKYMONEY = null;
    public static final ProfitCheckType Unknown = null;
    public static final ProfitCheckType WISH_LIST = null;
    public static final /* synthetic */ ProfitCheckType[] a = null;
    private long index;
    private boolean localReport;
    private String typeName;

    public static final class a {
        public a() {
        }
    }

    public static ProfitCheckType valueOf(String r1) {
        return (ProfitCheckType) r27.a.a(ProfitCheckType.class, r1);
    }

    public static ProfitCheckType[] values() {
        return (ProfitCheckType[]) a.clone();
    }

    static {
        ProfitCheckType r8 = new ProfitCheckType("ANCHOR_GIFT_IM", 0, "anchor_gift_im", LOCAL_REPORT_INDEX, true);
        ANCHOR_GIFT_IM = r8;
        ProfitCheckType r1 = new ProfitCheckType("ANCHOR_GIFT_EFFECT", 1, "anchor_gift_effect", LOCAL_REPORT_INDEX, true);
        ANCHOR_GIFT_EFFECT = r1;
        boolean r9 = false;
        int r10 = 4;
        DefaultConstructorMarker r12 = null;
        ProfitCheckType r2 = new ProfitCheckType("Unknown", 2, "unKnown", 0, r9, r10, r12);
        Unknown = r2;
        ProfitCheckType r3 = new ProfitCheckType("GIFT_TRAY", 3, "gift_tray", 1, r9, r10, r12);
        GIFT_TRAY = r3;
        ProfitCheckType r4 = new ProfitCheckType("GIFT_EFFECT", 4, "gift_effect", 2, r9, r10, r12);
        GIFT_EFFECT = r4;
        ProfitCheckType r5 = new ProfitCheckType("GIFT_PUBLIC_AREA_MSG", 5, "gift_public_area_msg", 3, r9, r10, r12);
        GIFT_PUBLIC_AREA_MSG = r5;
        ProfitCheckType r6 = new ProfitCheckType("ENTER_ROOM_EFFECT", 6, "enter_room_effect", 4, r9, r10, r12);
        ENTER_ROOM_EFFECT = r6;
        ProfitCheckType r7 = new ProfitCheckType("DRESS_SHOW", 7, "dress_show", 5, r9, r10, r12);
        DRESS_SHOW = r7;
        ProfitCheckType r13 = new ProfitCheckType("DRESS_OPEN_EFFECT", 8, "dress_open_effect", 6, r9, r10, r12);
        DRESS_OPEN_EFFECT = r13;
        ProfitCheckType r14 = new ProfitCheckType("GIFT_LIST_INFO", 9, "gift_list_info", 7, r9, r10, r12);
        GIFT_LIST_INFO = r14;
        ProfitCheckType r15 = new ProfitCheckType("SCREEN_CHAT_DISPLAY", 10, "screenchat_display", 8, r9, r10, r12);
        SCREEN_CHAT_DISPLAY = r15;
        ProfitCheckType r16 = new ProfitCheckType("FANS_CLUB_PAGE", 11, "fansclub_page", 9, r9, r10, r12);
        FANS_CLUB_PAGE = r16;
        ProfitCheckType r17 = new ProfitCheckType("PK", 12, "pk", 10, r9, r10, r12);
        PK = r17;
        ProfitCheckType r18 = new ProfitCheckType("GRADE_LEVEL", 13, "grade_level", 11, r9, r10, r12);
        GRADE_LEVEL = r18;
        ProfitCheckType r19 = new ProfitCheckType("EXHIBITION_INFO", 14, "exhibition_info", 12, r9, r10, r12);
        EXHIBITION_INFO = r19;
        ProfitCheckType r20 = new ProfitCheckType("WISH_LIST", 15, "wish_list", 13, r9, r10, r12);
        WISH_LIST = r20;
        ProfitCheckType r22 = new ProfitCheckType("AUDIENCE_RANK_LIST", 16, "audience_ranklist", 14, r9, r10, r12);
        AUDIENCE_RANK_LIST = r22;
        ProfitCheckType r23 = new ProfitCheckType("AWMELITE_TASK", 17, "awmelite_task", 15, r9, r10, r12);
        AWMELITE_TASK = r23;
        ProfitCheckType r24 = new ProfitCheckType("LINK_MIC_CONTRIBUTE_RANK_LIST", 18, "linkmic_contribute_ranklist", 16, r9, r10, r12);
        LINK_MIC_CONTRIBUTE_RANK_LIST = r24;
        ProfitCheckType r25 = new ProfitCheckType("CONSUME_REQUEST", 19, "consume_request", 17, r9, r10, r12);
        CONSUME_REQUEST = r25;
        ProfitCheckType r26 = new ProfitCheckType("GIFT_EFFECT_SELF_IM", 20, "gift_effect_self_im", 18, r9, r10, r12);
        GIFT_EFFECT_SELF_IM = r26;
        ProfitCheckType r27 = new ProfitCheckType("GIFT_OPTION_RIGHT", 21, "gift_option_right", 19, r9, r10, r12);
        GIFT_OPTION_RIGHT = r27;
        ProfitCheckType r28 = new ProfitCheckType("SHORT_TOUCH_SELF_LUCKYMONEY", 22, "short_touch_self_luckymoney", 21, false, 4, null);
        SHORT_TOUCH_SELF_LUCKYMONEY = r28;
        ProfitCheckType r29 = new ProfitCheckType("RECHARGE_COUPON_ACTIVITY", 23, "recharge_coupon_activity", 22, true);
        RECHARGE_COUPON_ACTIVITY = r29;
        ProfitCheckType r30 = new ProfitCheckType("GENERAL_TASK", 24, "general_task", 100, false, 4, null);
        GENERAL_TASK = r30;
        a = new ProfitCheckType[]{r8, r1, r2, r3, r4, r5, r6, r7, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30};
        Companion = new a();
    }

    public final long getIndex() {
        return this.index;
    }

    public final boolean getLocalReport() {
        return this.localReport;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final void setIndex(long r1) {
        this.index = r1;
    }

    public final void setLocalReport(boolean r1) {
        this.localReport = r1;
    }

    public final void setTypeName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.typeName = r2;
    }

    public ProfitCheckType(String r1, int r2, String r3, long r4, boolean r6) {
        super(r1, r2);
        this.typeName = r3;
        this.index = r4;
        this.localReport = r6;
    }

    public /* synthetic */ ProfitCheckType(String r8, int r9, String r10, long r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L5;
        boolean r6 = false;
    L6:
        this(r8, r9, r10, r12, r6);
        return;
    L5:
        r6 = r13;
        goto L6
    }
}
