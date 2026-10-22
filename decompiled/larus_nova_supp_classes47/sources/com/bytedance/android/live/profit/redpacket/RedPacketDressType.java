package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketDressType;", "", "Name", "ShortTouchWaitingPng", "ShortTouchRushPng", "ShortTouchEmptyHideWebp", "ShortTouchEmptyMoreWebp", "EnterSkinPng", "TopCover", "BottomCoverPng", "BackGround", "Border", "ResultCard", "CountDownBg", "BlessIcon", "BlessWord", "SurpriseGift", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RedPacketDressType extends Enum<RedPacketDressType> {
    public static final RedPacketDressType BackGround = null;
    public static final RedPacketDressType BlessIcon = null;
    public static final RedPacketDressType BlessWord = null;
    public static final RedPacketDressType Border = null;
    public static final RedPacketDressType BottomCoverPng = null;
    public static final RedPacketDressType CountDownBg = null;
    public static final RedPacketDressType EnterSkinPng = null;
    public static final RedPacketDressType Name = null;
    public static final RedPacketDressType ResultCard = null;
    public static final RedPacketDressType ShortTouchEmptyHideWebp = null;
    public static final RedPacketDressType ShortTouchEmptyMoreWebp = null;
    public static final RedPacketDressType ShortTouchRushPng = null;
    public static final RedPacketDressType ShortTouchWaitingPng = null;
    public static final RedPacketDressType SurpriseGift = null;
    public static final RedPacketDressType TopCover = null;
    public static final /* synthetic */ RedPacketDressType[] a = null;

    static {
        RedPacketDressType r1 = new RedPacketDressType("Name", 0);
        Name = r1;
        RedPacketDressType r2 = new RedPacketDressType("ShortTouchWaitingPng", 1);
        ShortTouchWaitingPng = r2;
        RedPacketDressType r3 = new RedPacketDressType("ShortTouchRushPng", 2);
        ShortTouchRushPng = r3;
        RedPacketDressType r4 = new RedPacketDressType("ShortTouchEmptyHideWebp", 3);
        ShortTouchEmptyHideWebp = r4;
        RedPacketDressType r5 = new RedPacketDressType("ShortTouchEmptyMoreWebp", 4);
        ShortTouchEmptyMoreWebp = r5;
        RedPacketDressType r6 = new RedPacketDressType("EnterSkinPng", 5);
        EnterSkinPng = r6;
        RedPacketDressType r7 = new RedPacketDressType("TopCover", 6);
        TopCover = r7;
        RedPacketDressType r8 = new RedPacketDressType("BottomCoverPng", 7);
        BottomCoverPng = r8;
        RedPacketDressType r9 = new RedPacketDressType("BackGround", 8);
        BackGround = r9;
        RedPacketDressType r10 = new RedPacketDressType("Border", 9);
        Border = r10;
        RedPacketDressType r12 = new RedPacketDressType("ResultCard", 10);
        ResultCard = r12;
        RedPacketDressType r13 = new RedPacketDressType("CountDownBg", 11);
        CountDownBg = r13;
        RedPacketDressType r14 = new RedPacketDressType("BlessIcon", 12);
        BlessIcon = r14;
        RedPacketDressType r15 = new RedPacketDressType("BlessWord", 13);
        BlessWord = r15;
        RedPacketDressType r16 = new RedPacketDressType("SurpriseGift", 14);
        SurpriseGift = r16;
        a = new RedPacketDressType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16};
    }

    public static RedPacketDressType valueOf(String r1) {
        return (RedPacketDressType) r27.a.a(RedPacketDressType.class, r1);
    }

    public static RedPacketDressType[] values() {
        return (RedPacketDressType[]) a.clone();
    }

    public RedPacketDressType(String r1, int r2) {
        super(r1, r2);
    }
}
