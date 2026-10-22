package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/utils/GiftPanelNitaViewInfo;", BuildConfig.FLAVOR, "Lzo2/a;", BuildConfig.FLAVOR, "getResId", "()I", "resId", BuildConfig.FLAVOR, "getTag", "()Ljava/lang/String;", "tag", "getCount", "count", "getType", "type", "TTLIVE_DIALOG_SELECT_GIFT_RECEIVER_WIDGET_NEW", "TTLIVE_DIALOG_GROUP_LIVE_ROOM_WIDGET_NEW", "TTLIVE_BASE_GIFT_COMBO_WIDGET", "TTLIVE_BASE_GIFT_TAB_VIEW", "TTLIVE_BASE_GIFT_RECHARGE_VIEW", "TTLIVE_GIFT_HONOR_LEVEL_VIEW_V3", "TTLIVE_GROWTH_TOUCH_LYNX_VIEW", "TTLIVE_TOP_GIFT_GROUP_VIEW", "TTLIVE_GIFT_ACTIVITY_TOP_VIEW", "TTLIVE_CUSTOM_GIFT_TOPBAR_WIDGET", "TTLIVE_DIALOG_TOP_DETAIL_WIDGET", "TTLIVE_TOP_GIFT_DIY_VIEW", "TTLIVE_WIDGET_FORBIDEN_MINORS_CONSUME_NOTICE", "TTLIVE_TOP_GIFT_BUFF_VIEW", "TTLIVE_BASE_GIFT_VIEW_HOLDER_NEW_VERTICAL", "TTLIVE_GIFT_FANS_CLUB_TOP_BAR_WIDGET", "TTLIVE_GIFT_BAG_TOPBAR_WIDGET", "TTLIVE_TOP_DEFAULT_VIEW", "TTLIVE_MVI_VERTICAL_PAGER", "TTLIVE_MVI_COUNTER_PAGE", "TTLIVE_BASE_COUNTER_VIEW_ITEM", "TTLIVE_BASE_COUNTER_GIFT_ITEM", "TTLIVE_GIFT_BACKPACK_CHECK_RECORD_ITEM", "TTLIVE_BASE_PROP_VIEW_HOLDER_NEW_VERTICAL", "TTLIVE_MVI_VIEW_PAGER_PAGE", "TTLIVE_BASE_LOAD_MORE_VIEW_HOLDER_ITEM", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftPanelNitaViewInfo extends Enum<GiftPanelNitaViewInfo> implements zo2.a {
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_COUNTER_GIFT_ITEM = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_COUNTER_VIEW_ITEM = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_GIFT_COMBO_WIDGET = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_GIFT_RECHARGE_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_GIFT_TAB_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_GIFT_VIEW_HOLDER_NEW_VERTICAL = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_LOAD_MORE_VIEW_HOLDER_ITEM = null;
    public static final GiftPanelNitaViewInfo TTLIVE_BASE_PROP_VIEW_HOLDER_NEW_VERTICAL = null;
    public static final GiftPanelNitaViewInfo TTLIVE_CUSTOM_GIFT_TOPBAR_WIDGET = null;
    public static final GiftPanelNitaViewInfo TTLIVE_DIALOG_GROUP_LIVE_ROOM_WIDGET_NEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_DIALOG_SELECT_GIFT_RECEIVER_WIDGET_NEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_DIALOG_TOP_DETAIL_WIDGET = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GIFT_ACTIVITY_TOP_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GIFT_BACKPACK_CHECK_RECORD_ITEM = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GIFT_BAG_TOPBAR_WIDGET = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GIFT_FANS_CLUB_TOP_BAR_WIDGET = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GIFT_HONOR_LEVEL_VIEW_V3 = null;
    public static final GiftPanelNitaViewInfo TTLIVE_GROWTH_TOUCH_LYNX_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_MVI_COUNTER_PAGE = null;
    public static final GiftPanelNitaViewInfo TTLIVE_MVI_VERTICAL_PAGER = null;
    public static final GiftPanelNitaViewInfo TTLIVE_MVI_VIEW_PAGER_PAGE = null;
    public static final GiftPanelNitaViewInfo TTLIVE_TOP_DEFAULT_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_TOP_GIFT_BUFF_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_TOP_GIFT_DIY_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_TOP_GIFT_GROUP_VIEW = null;
    public static final GiftPanelNitaViewInfo TTLIVE_WIDGET_FORBIDEN_MINORS_CONSUME_NOTICE = null;
    public static final /* synthetic */ GiftPanelNitaViewInfo[] a = null;

    static {
        GiftPanelNitaViewInfo r1 = new GiftPanelNitaViewInfo("TTLIVE_DIALOG_SELECT_GIFT_RECEIVER_WIDGET_NEW", 0);
        TTLIVE_DIALOG_SELECT_GIFT_RECEIVER_WIDGET_NEW = r1;
        GiftPanelNitaViewInfo r2 = new GiftPanelNitaViewInfo("TTLIVE_DIALOG_GROUP_LIVE_ROOM_WIDGET_NEW", 1);
        TTLIVE_DIALOG_GROUP_LIVE_ROOM_WIDGET_NEW = r2;
        GiftPanelNitaViewInfo r3 = new GiftPanelNitaViewInfo("TTLIVE_BASE_GIFT_COMBO_WIDGET", 2);
        TTLIVE_BASE_GIFT_COMBO_WIDGET = r3;
        GiftPanelNitaViewInfo r4 = new GiftPanelNitaViewInfo("TTLIVE_BASE_GIFT_TAB_VIEW", 3);
        TTLIVE_BASE_GIFT_TAB_VIEW = r4;
        GiftPanelNitaViewInfo r5 = new GiftPanelNitaViewInfo("TTLIVE_BASE_GIFT_RECHARGE_VIEW", 4);
        TTLIVE_BASE_GIFT_RECHARGE_VIEW = r5;
        GiftPanelNitaViewInfo r6 = new GiftPanelNitaViewInfo("TTLIVE_GIFT_HONOR_LEVEL_VIEW_V3", 5);
        TTLIVE_GIFT_HONOR_LEVEL_VIEW_V3 = r6;
        GiftPanelNitaViewInfo r7 = new GiftPanelNitaViewInfo("TTLIVE_GROWTH_TOUCH_LYNX_VIEW", 6);
        TTLIVE_GROWTH_TOUCH_LYNX_VIEW = r7;
        GiftPanelNitaViewInfo r8 = new GiftPanelNitaViewInfo("TTLIVE_TOP_GIFT_GROUP_VIEW", 7);
        TTLIVE_TOP_GIFT_GROUP_VIEW = r8;
        GiftPanelNitaViewInfo r9 = new GiftPanelNitaViewInfo("TTLIVE_GIFT_ACTIVITY_TOP_VIEW", 8);
        TTLIVE_GIFT_ACTIVITY_TOP_VIEW = r9;
        GiftPanelNitaViewInfo r10 = new GiftPanelNitaViewInfo("TTLIVE_CUSTOM_GIFT_TOPBAR_WIDGET", 9);
        TTLIVE_CUSTOM_GIFT_TOPBAR_WIDGET = r10;
        GiftPanelNitaViewInfo r11 = new GiftPanelNitaViewInfo("TTLIVE_DIALOG_TOP_DETAIL_WIDGET", 10);
        TTLIVE_DIALOG_TOP_DETAIL_WIDGET = r11;
        GiftPanelNitaViewInfo r13 = new GiftPanelNitaViewInfo("TTLIVE_TOP_GIFT_DIY_VIEW", 11);
        TTLIVE_TOP_GIFT_DIY_VIEW = r13;
        GiftPanelNitaViewInfo r14 = new GiftPanelNitaViewInfo("TTLIVE_WIDGET_FORBIDEN_MINORS_CONSUME_NOTICE", 12);
        TTLIVE_WIDGET_FORBIDEN_MINORS_CONSUME_NOTICE = r14;
        GiftPanelNitaViewInfo r15 = new GiftPanelNitaViewInfo("TTLIVE_TOP_GIFT_BUFF_VIEW", 13);
        TTLIVE_TOP_GIFT_BUFF_VIEW = r15;
        GiftPanelNitaViewInfo r16 = new GiftPanelNitaViewInfo("TTLIVE_BASE_GIFT_VIEW_HOLDER_NEW_VERTICAL", 14);
        TTLIVE_BASE_GIFT_VIEW_HOLDER_NEW_VERTICAL = r16;
        GiftPanelNitaViewInfo r17 = new GiftPanelNitaViewInfo("TTLIVE_GIFT_FANS_CLUB_TOP_BAR_WIDGET", 15);
        TTLIVE_GIFT_FANS_CLUB_TOP_BAR_WIDGET = r17;
        GiftPanelNitaViewInfo r18 = new GiftPanelNitaViewInfo("TTLIVE_GIFT_BAG_TOPBAR_WIDGET", 16);
        TTLIVE_GIFT_BAG_TOPBAR_WIDGET = r18;
        GiftPanelNitaViewInfo r19 = new GiftPanelNitaViewInfo("TTLIVE_TOP_DEFAULT_VIEW", 17);
        TTLIVE_TOP_DEFAULT_VIEW = r19;
        GiftPanelNitaViewInfo r20 = new GiftPanelNitaViewInfo("TTLIVE_MVI_VERTICAL_PAGER", 18);
        TTLIVE_MVI_VERTICAL_PAGER = r20;
        GiftPanelNitaViewInfo r21 = new GiftPanelNitaViewInfo("TTLIVE_MVI_COUNTER_PAGE", 19);
        TTLIVE_MVI_COUNTER_PAGE = r21;
        GiftPanelNitaViewInfo r23 = new GiftPanelNitaViewInfo("TTLIVE_BASE_COUNTER_VIEW_ITEM", 20);
        TTLIVE_BASE_COUNTER_VIEW_ITEM = r23;
        GiftPanelNitaViewInfo r24 = new GiftPanelNitaViewInfo("TTLIVE_BASE_COUNTER_GIFT_ITEM", 21);
        TTLIVE_BASE_COUNTER_GIFT_ITEM = r24;
        GiftPanelNitaViewInfo r25 = new GiftPanelNitaViewInfo("TTLIVE_GIFT_BACKPACK_CHECK_RECORD_ITEM", 22);
        TTLIVE_GIFT_BACKPACK_CHECK_RECORD_ITEM = r25;
        GiftPanelNitaViewInfo r26 = new GiftPanelNitaViewInfo("TTLIVE_BASE_PROP_VIEW_HOLDER_NEW_VERTICAL", 23);
        TTLIVE_BASE_PROP_VIEW_HOLDER_NEW_VERTICAL = r26;
        GiftPanelNitaViewInfo r27 = new GiftPanelNitaViewInfo("TTLIVE_MVI_VIEW_PAGER_PAGE", 24);
        TTLIVE_MVI_VIEW_PAGER_PAGE = r27;
        GiftPanelNitaViewInfo r28 = new GiftPanelNitaViewInfo("TTLIVE_BASE_LOAD_MORE_VIEW_HOLDER_ITEM", 25);
        TTLIVE_BASE_LOAD_MORE_VIEW_HOLDER_ITEM = r28;
        a = new GiftPanelNitaViewInfo[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28};
    }

    public static GiftPanelNitaViewInfo valueOf(String r1) {
        return (GiftPanelNitaViewInfo) r27.a.a(GiftPanelNitaViewInfo.class, r1);
    }

    public static GiftPanelNitaViewInfo[] values() {
        return (GiftPanelNitaViewInfo[]) a.clone();
    }

    public int getType() {
        return 0;
    }

    public int getCount() {
        switch(r.b[ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L6;
            case 16: goto L8;
            case 17: goto L8;
            case 18: goto L8;
            case 19: goto L8;
            case 20: goto L8;
            case 21: goto L8;
            case 22: goto L8;
            case 23: goto L8;
            case 24: goto L8;
            case 25: goto L8;
            case 26: goto L8;
            default: goto L5;
        };
    L6:
        return 20;
    L8:
        return 1;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public int getResId() {
        switch(r.a[ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L13;
            case 20: goto L12;
            case 21: goto L11;
            case 22: goto L10;
            case 23: goto L9;
            case 24: goto L8;
            case 25: goto L7;
            case 26: goto L6;
            default: goto L5;
        };
    L6:
        return 2131567033;
    L7:
        return 2131565257;
    L8:
        return 2131565263;
    L9:
        return 2131566116;
    L10:
        return 2131565220;
    L11:
        return 2131565221;
    L12:
        return 2131567028;
    L13:
        return 2131567032;
    L14:
        return 2131567534;
    L15:
        return 2131566117;
    L16:
        return 2131566124;
    L17:
        return 2131565255;
    L18:
        return 2131567537;
    L19:
        return 2131568010;
    L20:
        return 2131567541;
    L21:
        return 2131565785;
    L22:
        return 2131565348;
    L23:
        return 2131566113;
    L24:
        return 2131567543;
    L25:
        return 2131566143;
    L26:
        return 2131566130;
    L27:
        return 2131565245;
    L28:
        return 2131565250;
    L29:
        return 2131565236;
    L30:
        return 2131565476;
    L31:
        return 2131565766;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public String getTag() {
        return name();
    }

    public GiftPanelNitaViewInfo(String r1, int r2) {
        super(r1, r2);
    }
}
