package com.bytedance.android.live.liveinteract.linkbase.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkbase/api/LoadDurationItemId;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CHORUS_EMPTY_SEAT_LIST", "CHORUS_GUEST_SEAT_LIST", "TEAM_FIGHT_START_LOAD", "ROOM_BATTLE_START_LOAD", "TEAM_FIGHT_SCORE_BAR", "TEAM_FIGHT_FOREGROUND", "HYBRIYD_MAIN_DID_CONSTRUCTOR", "HYBRIYD_RENDER_DID_CONSTRUCTOR", "HYBRIYD_MAIN_DID_MOUNT", "HYBRIYD_RENDER_DID_MOUNT", "RENDER_LYNX_SETUP_DRAW_END", "RENDER_LYNX_UPDATE_DRAW_END", "JSB_RECEIVE_LINKMIC_INFO", "JSB_RECEIVE_LAYOUT_INFO", "JSB_RECEIVE_USER_LIST", "LYNX_ERCEIVE_LINKMIC_INFO", "LYNX_RECEIVE_LAYOUT_INFO", "LYNX_RECEIVE_USER_LIST", "RENDER_LYNX_EMPTY_SEAT_LIST", "RENDER_LYNX_GUEST_SEAT_LIST", "RENDER_LYNX_LISTENER_USER_LIST_DATA", "RENDER_LYNX_SWITCH_LAYOUT_END", "RENDER_LYNX_RECEIVE_FRAME_INFO", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LoadDurationItemId extends Enum<LoadDurationItemId> {
    public static final LoadDurationItemId CHORUS_EMPTY_SEAT_LIST = null;
    public static final LoadDurationItemId CHORUS_GUEST_SEAT_LIST = null;
    public static final LoadDurationItemId HYBRIYD_MAIN_DID_CONSTRUCTOR = null;
    public static final LoadDurationItemId HYBRIYD_MAIN_DID_MOUNT = null;
    public static final LoadDurationItemId HYBRIYD_RENDER_DID_CONSTRUCTOR = null;
    public static final LoadDurationItemId HYBRIYD_RENDER_DID_MOUNT = null;
    public static final LoadDurationItemId JSB_RECEIVE_LAYOUT_INFO = null;
    public static final LoadDurationItemId JSB_RECEIVE_LINKMIC_INFO = null;
    public static final LoadDurationItemId JSB_RECEIVE_USER_LIST = null;
    public static final LoadDurationItemId LYNX_ERCEIVE_LINKMIC_INFO = null;
    public static final LoadDurationItemId LYNX_RECEIVE_LAYOUT_INFO = null;
    public static final LoadDurationItemId LYNX_RECEIVE_USER_LIST = null;
    public static final LoadDurationItemId RENDER_LYNX_EMPTY_SEAT_LIST = null;
    public static final LoadDurationItemId RENDER_LYNX_GUEST_SEAT_LIST = null;
    public static final LoadDurationItemId RENDER_LYNX_LISTENER_USER_LIST_DATA = null;
    public static final LoadDurationItemId RENDER_LYNX_RECEIVE_FRAME_INFO = null;
    public static final LoadDurationItemId RENDER_LYNX_SETUP_DRAW_END = null;
    public static final LoadDurationItemId RENDER_LYNX_SWITCH_LAYOUT_END = null;
    public static final LoadDurationItemId RENDER_LYNX_UPDATE_DRAW_END = null;
    public static final LoadDurationItemId ROOM_BATTLE_START_LOAD = null;
    public static final LoadDurationItemId TEAM_FIGHT_FOREGROUND = null;
    public static final LoadDurationItemId TEAM_FIGHT_SCORE_BAR = null;
    public static final LoadDurationItemId TEAM_FIGHT_START_LOAD = null;
    public static final /* synthetic */ LoadDurationItemId[] a = null;
    private final String value;

    public static LoadDurationItemId valueOf(String r1) {
        return (LoadDurationItemId) a.a(LoadDurationItemId.class, r1);
    }

    public static LoadDurationItemId[] values() {
        return (LoadDurationItemId[]) a.clone();
    }

    static {
        LoadDurationItemId r1 = new LoadDurationItemId("CHORUS_EMPTY_SEAT_LIST", 0, "chorus_empty_seat_list");
        CHORUS_EMPTY_SEAT_LIST = r1;
        LoadDurationItemId r2 = new LoadDurationItemId("CHORUS_GUEST_SEAT_LIST", 1, "chorus_guest_seat_list");
        CHORUS_GUEST_SEAT_LIST = r2;
        LoadDurationItemId r3 = new LoadDurationItemId("TEAM_FIGHT_START_LOAD", 2, "team_fight_start_load");
        TEAM_FIGHT_START_LOAD = r3;
        LoadDurationItemId r4 = new LoadDurationItemId("ROOM_BATTLE_START_LOAD", 3, "room_battle_start_load");
        ROOM_BATTLE_START_LOAD = r4;
        LoadDurationItemId r5 = new LoadDurationItemId("TEAM_FIGHT_SCORE_BAR", 4, "team_fight_score_bar");
        TEAM_FIGHT_SCORE_BAR = r5;
        LoadDurationItemId r6 = new LoadDurationItemId("TEAM_FIGHT_FOREGROUND", 5, "team_fight_foreground");
        TEAM_FIGHT_FOREGROUND = r6;
        LoadDurationItemId r7 = new LoadDurationItemId("HYBRIYD_MAIN_DID_CONSTRUCTOR", 6, "hybriyd_main_did_constructor");
        HYBRIYD_MAIN_DID_CONSTRUCTOR = r7;
        LoadDurationItemId r8 = new LoadDurationItemId("HYBRIYD_RENDER_DID_CONSTRUCTOR", 7, "hybriyd_render_did_constructor");
        HYBRIYD_RENDER_DID_CONSTRUCTOR = r8;
        LoadDurationItemId r9 = new LoadDurationItemId("HYBRIYD_MAIN_DID_MOUNT", 8, "hybriyd_main_did_mount");
        HYBRIYD_MAIN_DID_MOUNT = r9;
        LoadDurationItemId r10 = new LoadDurationItemId("HYBRIYD_RENDER_DID_MOUNT", 9, "hybriyd_render_did_mount");
        HYBRIYD_RENDER_DID_MOUNT = r10;
        LoadDurationItemId r11 = new LoadDurationItemId("RENDER_LYNX_SETUP_DRAW_END", 10, "lynx_setup_draw_end");
        RENDER_LYNX_SETUP_DRAW_END = r11;
        LoadDurationItemId r12 = new LoadDurationItemId("RENDER_LYNX_UPDATE_DRAW_END", 11, "lynx_update_draw_end");
        RENDER_LYNX_UPDATE_DRAW_END = r12;
        LoadDurationItemId r13 = new LoadDurationItemId("JSB_RECEIVE_LINKMIC_INFO", 12, "jsb_receive_linkmic_info");
        JSB_RECEIVE_LINKMIC_INFO = r13;
        LoadDurationItemId r14 = new LoadDurationItemId("JSB_RECEIVE_LAYOUT_INFO", 13, "jsb_receive_layout_info");
        JSB_RECEIVE_LAYOUT_INFO = r14;
        LoadDurationItemId r15 = new LoadDurationItemId("JSB_RECEIVE_USER_LIST", 14, "jsb_receive_user_list");
        JSB_RECEIVE_USER_LIST = r15;
        LoadDurationItemId r16 = new LoadDurationItemId("LYNX_ERCEIVE_LINKMIC_INFO", 15, "lynx_receive_linkmic_info");
        LYNX_ERCEIVE_LINKMIC_INFO = r16;
        LoadDurationItemId r17 = new LoadDurationItemId("LYNX_RECEIVE_LAYOUT_INFO", 16, "lynx_receive_layout_info");
        LYNX_RECEIVE_LAYOUT_INFO = r17;
        LoadDurationItemId r18 = new LoadDurationItemId("LYNX_RECEIVE_USER_LIST", 17, "lynx_receive_user_list");
        LYNX_RECEIVE_USER_LIST = r18;
        LoadDurationItemId r19 = new LoadDurationItemId("RENDER_LYNX_EMPTY_SEAT_LIST", 18, "lynx_empty_seat_list");
        RENDER_LYNX_EMPTY_SEAT_LIST = r19;
        LoadDurationItemId r20 = new LoadDurationItemId("RENDER_LYNX_GUEST_SEAT_LIST", 19, "lynx_guest_seat_list");
        RENDER_LYNX_GUEST_SEAT_LIST = r20;
        LoadDurationItemId r21 = new LoadDurationItemId("RENDER_LYNX_LISTENER_USER_LIST_DATA", 20, "lynx_listener_user_list_data");
        RENDER_LYNX_LISTENER_USER_LIST_DATA = r21;
        LoadDurationItemId r22 = new LoadDurationItemId("RENDER_LYNX_SWITCH_LAYOUT_END", 21, "lynx_switch_layout_end");
        RENDER_LYNX_SWITCH_LAYOUT_END = r22;
        LoadDurationItemId r23 = new LoadDurationItemId("RENDER_LYNX_RECEIVE_FRAME_INFO", 22, "lynx_receive_frame_info");
        RENDER_LYNX_RECEIVE_FRAME_INFO = r23;
        a = new LoadDurationItemId[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23};
    }

    public final String getValue() {
        return this.value;
    }

    public LoadDurationItemId(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
