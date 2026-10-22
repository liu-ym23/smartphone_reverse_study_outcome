package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/GiftPluginType;", BuildConfig.FLAVOR, "TYPE_BANNER", "TYPE_RED_PACKET", "TYPE_POPULAR_BOX", "TYPE_GIFT_RELAY", "TYPE_PROP_POPULAR_CARD", "TYPE_GIFT_DOODLE", "TYPE_GAME_GIFT", "TYPE_BLIND_BOX", "TYPE_PERIOD_CARD", "TYPE_DEFAULT_BANNER", "TYPE_LYNX_BANNER", "TYPE_FAST_GIFT", "TYPE_AIRDROP_GIFT", "TYPE_INTERACT_GIFT", "TYPE_BIG_GIFT", "TYPE_MSGBOARD_GIFT", "TYPE_GOODS", "TYPE_DS", "TYPE_PK_PROP", "TYPE_RECHARGE_COUPON", "DEFAULT", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftPluginType extends Enum<GiftPluginType> {
    public static final GiftPluginType DEFAULT = null;
    public static final GiftPluginType TYPE_AIRDROP_GIFT = null;
    public static final GiftPluginType TYPE_BANNER = null;
    public static final GiftPluginType TYPE_BIG_GIFT = null;
    public static final GiftPluginType TYPE_BLIND_BOX = null;
    public static final GiftPluginType TYPE_DEFAULT_BANNER = null;
    public static final GiftPluginType TYPE_DS = null;
    public static final GiftPluginType TYPE_FAST_GIFT = null;
    public static final GiftPluginType TYPE_GAME_GIFT = null;
    public static final GiftPluginType TYPE_GIFT_DOODLE = null;
    public static final GiftPluginType TYPE_GIFT_RELAY = null;
    public static final GiftPluginType TYPE_GOODS = null;
    public static final GiftPluginType TYPE_INTERACT_GIFT = null;
    public static final GiftPluginType TYPE_LYNX_BANNER = null;
    public static final GiftPluginType TYPE_MSGBOARD_GIFT = null;
    public static final GiftPluginType TYPE_PERIOD_CARD = null;
    public static final GiftPluginType TYPE_PK_PROP = null;
    public static final GiftPluginType TYPE_POPULAR_BOX = null;
    public static final GiftPluginType TYPE_PROP_POPULAR_CARD = null;
    public static final GiftPluginType TYPE_RECHARGE_COUPON = null;
    public static final GiftPluginType TYPE_RED_PACKET = null;
    public static final /* synthetic */ GiftPluginType[] a = null;

    static {
        GiftPluginType r1 = new GiftPluginType("TYPE_BANNER", 0);
        TYPE_BANNER = r1;
        GiftPluginType r2 = new GiftPluginType("TYPE_RED_PACKET", 1);
        TYPE_RED_PACKET = r2;
        GiftPluginType r3 = new GiftPluginType("TYPE_POPULAR_BOX", 2);
        TYPE_POPULAR_BOX = r3;
        GiftPluginType r4 = new GiftPluginType("TYPE_GIFT_RELAY", 3);
        TYPE_GIFT_RELAY = r4;
        GiftPluginType r5 = new GiftPluginType("TYPE_PROP_POPULAR_CARD", 4);
        TYPE_PROP_POPULAR_CARD = r5;
        GiftPluginType r6 = new GiftPluginType("TYPE_GIFT_DOODLE", 5);
        TYPE_GIFT_DOODLE = r6;
        GiftPluginType r7 = new GiftPluginType("TYPE_GAME_GIFT", 6);
        TYPE_GAME_GIFT = r7;
        GiftPluginType r8 = new GiftPluginType("TYPE_BLIND_BOX", 7);
        TYPE_BLIND_BOX = r8;
        GiftPluginType r9 = new GiftPluginType("TYPE_PERIOD_CARD", 8);
        TYPE_PERIOD_CARD = r9;
        GiftPluginType r10 = new GiftPluginType("TYPE_DEFAULT_BANNER", 9);
        TYPE_DEFAULT_BANNER = r10;
        GiftPluginType r11 = new GiftPluginType("TYPE_LYNX_BANNER", 10);
        TYPE_LYNX_BANNER = r11;
        GiftPluginType r13 = new GiftPluginType("TYPE_FAST_GIFT", 11);
        TYPE_FAST_GIFT = r13;
        GiftPluginType r14 = new GiftPluginType("TYPE_AIRDROP_GIFT", 12);
        TYPE_AIRDROP_GIFT = r14;
        GiftPluginType r15 = new GiftPluginType("TYPE_INTERACT_GIFT", 13);
        TYPE_INTERACT_GIFT = r15;
        GiftPluginType r16 = new GiftPluginType("TYPE_BIG_GIFT", 14);
        TYPE_BIG_GIFT = r16;
        GiftPluginType r17 = new GiftPluginType("TYPE_MSGBOARD_GIFT", 15);
        TYPE_MSGBOARD_GIFT = r17;
        GiftPluginType r18 = new GiftPluginType("TYPE_GOODS", 16);
        TYPE_GOODS = r18;
        GiftPluginType r19 = new GiftPluginType("TYPE_DS", 17);
        TYPE_DS = r19;
        GiftPluginType r20 = new GiftPluginType("TYPE_PK_PROP", 18);
        TYPE_PK_PROP = r20;
        GiftPluginType r21 = new GiftPluginType("TYPE_RECHARGE_COUPON", 19);
        TYPE_RECHARGE_COUPON = r21;
        GiftPluginType r23 = new GiftPluginType("DEFAULT", 20);
        DEFAULT = r23;
        a = new GiftPluginType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23};
    }

    public static GiftPluginType valueOf(String r1) {
        return (GiftPluginType) r27.a.a(GiftPluginType.class, r1);
    }

    public static GiftPluginType[] values() {
        return (GiftPluginType[]) a.clone();
    }

    public GiftPluginType(String r1, int r2) {
        super(r1, r2);
    }
}
