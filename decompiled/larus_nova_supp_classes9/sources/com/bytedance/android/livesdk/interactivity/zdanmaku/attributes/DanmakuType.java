package com.bytedance.android.livesdk.interactivity.zdanmaku.attributes;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import nf6.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/attributes/DanmakuType;", BuildConfig.FLAVOR, "Lnf6/a;", "UnDefined", "Chat", "Carnival", "CarnivalEgg", "Gift", "Business", "Admin", "Normal", "Talent", "Official", "Privilege", "ChatChannel", "NotifyEffect", "RedPacketEgg", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DanmakuType extends Enum<DanmakuType> implements a {
    public static final DanmakuType Admin = null;
    public static final DanmakuType Business = null;
    public static final DanmakuType Carnival = null;
    public static final DanmakuType CarnivalEgg = null;
    public static final DanmakuType Chat = null;
    public static final DanmakuType ChatChannel = null;
    public static final DanmakuType Gift = null;
    public static final DanmakuType Normal = null;
    public static final DanmakuType NotifyEffect = null;
    public static final DanmakuType Official = null;
    public static final DanmakuType Privilege = null;
    public static final DanmakuType RedPacketEgg = null;
    public static final DanmakuType Talent = null;
    public static final DanmakuType UnDefined = null;
    public static final /* synthetic */ DanmakuType[] a = null;

    static {
        DanmakuType r1 = new DanmakuType("UnDefined", 0);
        UnDefined = r1;
        DanmakuType r2 = new DanmakuType("Chat", 1);
        Chat = r2;
        DanmakuType r3 = new DanmakuType("Carnival", 2);
        Carnival = r3;
        DanmakuType r4 = new DanmakuType("CarnivalEgg", 3);
        CarnivalEgg = r4;
        DanmakuType r5 = new DanmakuType("Gift", 4);
        Gift = r5;
        DanmakuType r6 = new DanmakuType("Business", 5);
        Business = r6;
        DanmakuType r7 = new DanmakuType("Admin", 6);
        Admin = r7;
        DanmakuType r8 = new DanmakuType("Normal", 7);
        Normal = r8;
        DanmakuType r9 = new DanmakuType("Talent", 8);
        Talent = r9;
        DanmakuType r10 = new DanmakuType("Official", 9);
        Official = r10;
        DanmakuType r11 = new DanmakuType("Privilege", 10);
        Privilege = r11;
        DanmakuType r13 = new DanmakuType("ChatChannel", 11);
        ChatChannel = r13;
        DanmakuType r14 = new DanmakuType("NotifyEffect", 12);
        NotifyEffect = r14;
        DanmakuType r15 = new DanmakuType("RedPacketEgg", 13);
        RedPacketEgg = r15;
        a = new DanmakuType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15};
    }

    public static DanmakuType valueOf(String r1) {
        return (DanmakuType) r27.a.a(DanmakuType.class, r1);
    }

    public static DanmakuType[] values() {
        return (DanmakuType[]) a.clone();
    }

    public DanmakuType(String r1, int r2) {
        super(r1, r2);
    }
}
