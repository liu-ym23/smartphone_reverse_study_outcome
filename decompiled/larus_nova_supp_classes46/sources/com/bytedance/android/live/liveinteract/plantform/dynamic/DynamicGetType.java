package com.bytedance.android.live.liveinteract.plantform.dynamic;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamic/DynamicGetType;", "", "NONE", "LINKMIC", "PLAYMODE", "SEAT", "GET_DATA", "COMMON_GET_DATA", "DRESS", "FRAME_INFO", "ENTER_INFO", "ROOM", "TEAM_FIGHT", "CREATE_CHECK", "LIVE_STREAM_DELAY_TIME", "CHANNEL_INFO", "LINK_SERVICE", "KTV_ORDER_INFO", "INTERACT_PANEL_CONFIG", "SETTING_PANEL_CONFIG", "SUBTITLE", "CHORUS", "KARAOKE", "AVATAR", "INTERACTIVE_ORDER_SONG", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DynamicGetType extends Enum<DynamicGetType> {
    public static final DynamicGetType AVATAR = null;
    public static final DynamicGetType CHANNEL_INFO = null;
    public static final DynamicGetType CHORUS = null;
    public static final DynamicGetType COMMON_GET_DATA = null;
    public static final DynamicGetType CREATE_CHECK = null;
    public static final DynamicGetType DRESS = null;
    public static final DynamicGetType ENTER_INFO = null;
    public static final DynamicGetType FRAME_INFO = null;
    public static final DynamicGetType GET_DATA = null;
    public static final DynamicGetType INTERACTIVE_ORDER_SONG = null;
    public static final DynamicGetType INTERACT_PANEL_CONFIG = null;
    public static final DynamicGetType KARAOKE = null;
    public static final DynamicGetType KTV_ORDER_INFO = null;
    public static final DynamicGetType LINKMIC = null;
    public static final DynamicGetType LINK_SERVICE = null;
    public static final DynamicGetType LIVE_STREAM_DELAY_TIME = null;
    public static final DynamicGetType NONE = null;
    public static final DynamicGetType PLAYMODE = null;
    public static final DynamicGetType ROOM = null;
    public static final DynamicGetType SEAT = null;
    public static final DynamicGetType SETTING_PANEL_CONFIG = null;
    public static final DynamicGetType SUBTITLE = null;
    public static final DynamicGetType TEAM_FIGHT = null;
    public static final /* synthetic */ DynamicGetType[] a = null;

    static {
        DynamicGetType r1 = new DynamicGetType("NONE", 0);
        NONE = r1;
        DynamicGetType r2 = new DynamicGetType("LINKMIC", 1);
        LINKMIC = r2;
        DynamicGetType r3 = new DynamicGetType("PLAYMODE", 2);
        PLAYMODE = r3;
        DynamicGetType r4 = new DynamicGetType("SEAT", 3);
        SEAT = r4;
        DynamicGetType r5 = new DynamicGetType("GET_DATA", 4);
        GET_DATA = r5;
        DynamicGetType r6 = new DynamicGetType("COMMON_GET_DATA", 5);
        COMMON_GET_DATA = r6;
        DynamicGetType r7 = new DynamicGetType("DRESS", 6);
        DRESS = r7;
        DynamicGetType r8 = new DynamicGetType("FRAME_INFO", 7);
        FRAME_INFO = r8;
        DynamicGetType r9 = new DynamicGetType("ENTER_INFO", 8);
        ENTER_INFO = r9;
        DynamicGetType r10 = new DynamicGetType("ROOM", 9);
        ROOM = r10;
        DynamicGetType r11 = new DynamicGetType("TEAM_FIGHT", 10);
        TEAM_FIGHT = r11;
        DynamicGetType r12 = new DynamicGetType("CREATE_CHECK", 11);
        CREATE_CHECK = r12;
        DynamicGetType r13 = new DynamicGetType("LIVE_STREAM_DELAY_TIME", 12);
        LIVE_STREAM_DELAY_TIME = r13;
        DynamicGetType r14 = new DynamicGetType("CHANNEL_INFO", 13);
        CHANNEL_INFO = r14;
        DynamicGetType r15 = new DynamicGetType("LINK_SERVICE", 14);
        LINK_SERVICE = r15;
        DynamicGetType r16 = new DynamicGetType("KTV_ORDER_INFO", 15);
        KTV_ORDER_INFO = r16;
        DynamicGetType r17 = new DynamicGetType("INTERACT_PANEL_CONFIG", 16);
        INTERACT_PANEL_CONFIG = r17;
        DynamicGetType r18 = new DynamicGetType("SETTING_PANEL_CONFIG", 17);
        SETTING_PANEL_CONFIG = r18;
        DynamicGetType r19 = new DynamicGetType("SUBTITLE", 18);
        SUBTITLE = r19;
        DynamicGetType r20 = new DynamicGetType("CHORUS", 19);
        CHORUS = r20;
        DynamicGetType r21 = new DynamicGetType("KARAOKE", 20);
        KARAOKE = r21;
        DynamicGetType r22 = new DynamicGetType("AVATAR", 21);
        AVATAR = r22;
        DynamicGetType r23 = new DynamicGetType("INTERACTIVE_ORDER_SONG", 22);
        INTERACTIVE_ORDER_SONG = r23;
        a = new DynamicGetType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23};
    }

    public static DynamicGetType valueOf(String r1) {
        return (DynamicGetType) a.a(DynamicGetType.class, r1);
    }

    public static DynamicGetType[] values() {
        return (DynamicGetType[]) a.clone();
    }

    public DynamicGetType(String r1, int r2) {
        super(r1, r2);
    }
}
