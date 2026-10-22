package com.bytedance.android.live.core.monitor;

import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.paas.c;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;
import wm0.b;
import y50.h;
import y50.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveTracingMonitor {
    public static final SettingKey<Boolean> a = null;

    public static final enum EventModule extends Enum<EventModule> {
        public static final EventModule ACTIVITY = null;
        public static final EventModule ADVENTURE = null;
        public static final EventModule AI_CLONE = null;
        public static final EventModule ANCHOR_ASR = null;
        public static final EventModule AUDIENCE = null;
        public static final EventModule AUDIENCE_INTERACT = null;
        public static final EventModule AUDIO = null;
        public static final EventModule BACKEND = null;
        public static final EventModule BANNER = null;
        public static final EventModule BEAUTY = null;
        public static final EventModule BIG_PARTY = null;
        public static final EventModule CHAT_CHANNEL = null;
        public static final EventModule CLEAR_SCREEN = null;
        public static final EventModule CLOUD_GAME = null;
        public static final EventModule COMMENT = null;
        public static final EventModule COMMON_CARD = null;
        public static final EventModule DANMAKU = null;
        public static final EventModule DANMU_GAME = null;
        public static final EventModule DIGG = null;
        public static final EventModule DRESS = null;
        public static final EventModule DYNAMIC_STRATEGY = null;
        public static final EventModule EFFECT_GAME = null;
        public static final EventModule ENTER_ANIM = null;
        public static final EventModule ENTER_ROOM = null;
        public static final EventModule EXCHANGE = null;
        public static final EventModule FACE_STICKER = null;
        public static final EventModule FANS_CLUB = null;
        public static final EventModule FEED = null;
        public static final EventModule FEED_TAB = null;
        public static final EventModule FM_INTERACT = null;
        public static final EventModule FORMAT = null;
        public static final EventModule FORMAT_LIVE = null;
        public static final EventModule FRIEND_ROOM_BASE = null;
        public static final EventModule FRIEND_ROOM_COMMON = null;
        public static final EventModule GAME_LIVE = null;
        public static final EventModule GAME_ORDER = null;
        public static final EventModule GAME_PLAY_TOGETHER = null;
        public static final EventModule GAME_PROMOTE = null;
        public static final EventModule GIFT = null;
        public static final EventModule GIFT_PANEL_TOUCH = null;
        public static final EventModule GUEST_BATTLE = null;
        public static final EventModule HAMLET_AVATAR = null;
        public static final EventModule IMAGE_PICKER = null;
        public static final EventModule IMAGE_RECOGNITION = null;
        public static final EventModule INNER_DRAW = null;
        public static final EventModule INPUT_PANEL = null;
        public static final EventModule INTERACTION = null;
        public static final EventModule INTERACTION_OPT = null;
        public static final EventModule INTERACTIVITY = null;
        public static final EventModule INTERACTIVITY_DEGRADE = null;
        public static final EventModule INTERACT_STREAM = null;
        public static final EventModule INTERACT_XPLAY = null;
        public static final EventModule KTV = null;
        public static final EventModule KTV_CHORUS = null;
        public static final EventModule LIVE_CORE = null;
        public static final EventModule LIVE_GIFT = null;
        public static final EventModule LIVE_MESSAGE = null;
        public static final EventModule LIVE_PROFIT = null;
        public static final EventModule LIVE_ROOM_OBSERVER = null;
        public static final EventModule MATCH_TRAY = null;
        public static final EventModule MEDIA_MULTI_LINKER = null;
        public static final EventModule MSG_WINDOW_CARD = null;
        public static final EventModule MULTI_AUDIO = null;
        public static final EventModule MULTI_LINKER = null;
        public static final EventModule MULTI_LINK_DYNAMIC = null;
        public static final EventModule MULTI_LINK_GIFT = null;
        public static final EventModule MULTI_TAB = null;
        public static final EventModule NETWORK = null;
        public static final EventModule OPEN_ASSET = null;
        public static final EventModule OPEN_LIVE = null;
        public static final EventModule OPEN_PLATFORM = null;
        public static final EventModule PAID_LINK_MIC = null;
        public static final EventModule PAY_GRADE = null;
        public static final EventModule PCDN = null;
        public static final EventModule PERSONALIZED_CHANNEL = null;
        public static final EventModule PIN_COMMENT = null;
        public static final EventModule PK = null;
        public static final EventModule PLAYER = null;
        public static final EventModule PREDICTOR_PLAYING = null;
        public static final EventModule PREVIEW = null;
        public static final EventModule PRIVILEGE_DANMAKU = null;
        public static final EventModule PRIVILEGE_INFO = null;
        public static final EventModule PULL_STREAM = null;
        public static final EventModule PUSH_STREAM = null;
        public static final EventModule REAL_NAME = null;
        public static final EventModule RECHARGE = null;
        public static final EventModule ROOM_APM = null;
        public static final EventModule ROOM_BATTLE = null;
        public static final EventModule ROOM_STATE_AND_AV_RESOURCE = null;
        public static final EventModule SCREEN_LINKER = null;
        public static final EventModule SETTING = null;
        public static final EventModule SHORT_TOUCH = null;
        public static final EventModule SHORT_VIDEO = null;
        public static final EventModule SOLO_KTV = null;
        public static final EventModule STRATEGY = null;
        public static final EventModule SUBSCRIBE_VIP = null;
        public static final EventModule SWITCH_RESOLUTION = null;
        public static final EventModule TEAM_FIGHT = null;
        public static final EventModule TEXT_MESSAGE = null;
        public static final EventModule TEXT_RENDER_ENGINE = null;
        public static final EventModule USER_ENTER = null;
        public static final EventModule VOICE_CHAT = null;
        public static final EventModule WRDS = null;
        public static final EventModule XPLAY = null;
        public static final /* synthetic */ EventModule[] a = null;
        public static final EventModule common = null;
        public static final EventModule hybrid = null;
        public static final EventModule vs = null;
        private String mName;

        static {
            EventModule r0 = new EventModule("common", 0, "common");
            common = r0;
            EventModule r1 = new EventModule("vs", 1, "vs");
            vs = r1;
            EventModule r3 = new EventModule("FORMAT", 2, "format_room");
            FORMAT = r3;
            EventModule r5 = new EventModule("FORMAT_LIVE", 3, "format_live");
            FORMAT_LIVE = r5;
            EventModule r6 = new EventModule("NETWORK", 4, NewBroadcastMonitor.STAGE.NETWORK);
            NETWORK = r6;
            EventModule r8 = new EventModule("ROOM_APM", 5, "room_apm");
            ROOM_APM = r8;
            EventModule r11 = new EventModule("ENTER_ROOM", 6, "enter_room");
            ENTER_ROOM = r11;
            EventModule r12 = new EventModule("OPEN_LIVE", 7, "anchor_live");
            OPEN_LIVE = r12;
            EventModule r14 = new EventModule("PUSH_STREAM", 8, "push_stream");
            PUSH_STREAM = r14;
            EventModule r13 = new EventModule("PULL_STREAM", 9, "pull_stream");
            PULL_STREAM = r13;
            EventModule r15 = new EventModule("INTERACT_STREAM", 10, "interact_stream");
            INTERACT_STREAM = r15;
            EventModule r9 = new EventModule("BEAUTY", 11, FileUtils.BEAUTY);
            BEAUTY = r9;
            EventModule r7 = new EventModule("FACE_STICKER", 12, "face_sticker");
            FACE_STICKER = r7;
            EventModule r4 = new EventModule("EFFECT_GAME", 13, "effect_game");
            EFFECT_GAME = r4;
            EventModule r2 = new EventModule("INTERACTIVITY", 14, "interactivty");
            INTERACTIVITY = r2;
            EventModule r16 = new EventModule("PK", 15, "pk");
            PK = r16;
            EventModule r17 = new EventModule("GIFT", 16, "gift");
            GIFT = r17;
            EventModule r18 = new EventModule("RECHARGE", 17, "recharge");
            RECHARGE = r18;
            EventModule r19 = new EventModule("VOICE_CHAT", 18, "voice_chat");
            VOICE_CHAT = r19;
            EventModule r21 = new EventModule("IMAGE_PICKER", 19, "image_picker");
            IMAGE_PICKER = r21;
            EventModule r22 = new EventModule("ROOM_STATE_AND_AV_RESOURCE", 20, "room_state_and_av_resource");
            ROOM_STATE_AND_AV_RESOURCE = r22;
            EventModule r23 = new EventModule("EXCHANGE", 21, "exchange");
            EXCHANGE = r23;
            EventModule r24 = new EventModule("AUDIENCE_INTERACT", 22, "audience_interact");
            AUDIENCE_INTERACT = r24;
            EventModule r25 = new EventModule("FM_INTERACT", 23, "fm_interact");
            FM_INTERACT = r25;
            EventModule r26 = new EventModule("MULTI_AUDIO", 24, "multi_audio");
            MULTI_AUDIO = r26;
            EventModule r27 = new EventModule("BIG_PARTY", 25, "big_party");
            BIG_PARTY = r27;
            EventModule r28 = new EventModule("MULTI_LINKER", 26, "muti_linker");
            MULTI_LINKER = r28;
            EventModule r29 = new EventModule("MEDIA_MULTI_LINKER", 27, "media_muti_linker");
            MEDIA_MULTI_LINKER = r29;
            EventModule r31 = new EventModule("SCREEN_LINKER", 28, "screen_linker");
            SCREEN_LINKER = r31;
            EventModule r32 = new EventModule("TEXT_MESSAGE", 29, "text_message");
            TEXT_MESSAGE = r32;
            EventModule r33 = new EventModule("DYNAMIC_STRATEGY", 30, "dynamic_strategy");
            DYNAMIC_STRATEGY = r33;
            EventModule r34 = new EventModule("INTERACTION_OPT", 31, "interaction_opt");
            INTERACTION_OPT = r34;
            EventModule r35 = new EventModule("REAL_NAME", 32, "real_name");
            REAL_NAME = r35;
            EventModule r36 = new EventModule("ACTIVITY", 33, "activity");
            ACTIVITY = r36;
            EventModule r37 = new EventModule("KTV", 34, "ktv");
            KTV = r37;
            EventModule r38 = new EventModule("KTV_CHORUS", 35, "ktv_chorus");
            KTV_CHORUS = r38;
            EventModule r39 = new EventModule("SOLO_KTV", 36, "solo_ktv");
            SOLO_KTV = r39;
            EventModule r41 = new EventModule("HAMLET_AVATAR", 37, "hamlet_avatar");
            HAMLET_AVATAR = r41;
            EventModule r42 = new EventModule("DIGG", 38, "digg");
            DIGG = r42;
            EventModule r43 = new EventModule("OPEN_PLATFORM", 39, "interactive_open_platform");
            OPEN_PLATFORM = r43;
            EventModule r44 = new EventModule("PLAYER", 40, "palyer");
            PLAYER = r44;
            EventModule r45 = new EventModule("PREVIEW", 41, "preview");
            PREVIEW = r45;
            EventModule r46 = new EventModule("GAME_LIVE", 42, "game_live");
            GAME_LIVE = r46;
            EventModule r47 = new EventModule("LIVE_MESSAGE", 43, "live_message");
            LIVE_MESSAGE = r47;
            EventModule r48 = new EventModule("SETTING", 44, "setting");
            SETTING = r48;
            EventModule r49 = new EventModule("FRIEND_ROOM_BASE", 45, "friend_room_base");
            FRIEND_ROOM_BASE = r49;
            EventModule r51 = new EventModule("FRIEND_ROOM_COMMON", 46, "friend_room_common");
            FRIEND_ROOM_COMMON = r51;
            EventModule r52 = new EventModule("SHORT_VIDEO", 47, "short_video");
            SHORT_VIDEO = r52;
            EventModule r53 = new EventModule("GAME_PROMOTE", 48, "cooperation_partner");
            GAME_PROMOTE = r53;
            EventModule r54 = new EventModule("GAME_PLAY_TOGETHER", 49, "game_play_together");
            GAME_PLAY_TOGETHER = r54;
            EventModule r55 = new EventModule("LIVE_CORE", 50, "livecore");
            LIVE_CORE = r55;
            EventModule r56 = new EventModule("hybrid", 51, "hybrid");
            hybrid = r56;
            EventModule r57 = new EventModule("LIVE_GIFT", 52, "live_gift");
            LIVE_GIFT = r57;
            EventModule r58 = new EventModule("ENTER_ANIM", 53, "enter_anim");
            ENTER_ANIM = r58;
            EventModule r59 = new EventModule("LIVE_PROFIT", 54, "live_profit");
            LIVE_PROFIT = r59;
            EventModule r61 = new EventModule("INNER_DRAW", 55, "inner_draw");
            INNER_DRAW = r61;
            EventModule r62 = new EventModule("PCDN", 56, "pcdn");
            PCDN = r62;
            EventModule r63 = new EventModule("LIVE_ROOM_OBSERVER", 57, "live_room_observer");
            LIVE_ROOM_OBSERVER = r63;
            EventModule r64 = new EventModule("STRATEGY", 58, "strategy");
            STRATEGY = r64;
            EventModule r65 = new EventModule("AUDIO", 59, "audio");
            AUDIO = r65;
            EventModule r66 = new EventModule("DRESS", 60, "dress");
            DRESS = r66;
            EventModule r67 = new EventModule("DANMAKU", 61, "danmaku");
            DANMAKU = r67;
            EventModule r68 = new EventModule("COMMENT", 62, "comment");
            COMMENT = r68;
            EventModule r69 = new EventModule("PIN_COMMENT", 63, "pin_comment");
            PIN_COMMENT = r69;
            EventModule r71 = new EventModule("TEXT_RENDER_ENGINE", 64, "text_render_engine");
            TEXT_RENDER_ENGINE = r71;
            EventModule r72 = new EventModule("FANS_CLUB", 65, "fans_club");
            FANS_CLUB = r72;
            EventModule r73 = new EventModule("SUBSCRIBE_VIP", 66, "subscribe_vip");
            SUBSCRIBE_VIP = r73;
            EventModule r74 = new EventModule("PRIVILEGE_INFO", 67, "privilege_info");
            PRIVILEGE_INFO = r74;
            EventModule r75 = new EventModule("PAY_GRADE", 68, "pay_grade");
            PAY_GRADE = r75;
            EventModule r76 = new EventModule("GIFT_PANEL_TOUCH", 69, "gift_panel_touch");
            GIFT_PANEL_TOUCH = r76;
            EventModule r77 = new EventModule("PRIVILEGE_DANMAKU", 70, "privilege_danmaku");
            PRIVILEGE_DANMAKU = r77;
            EventModule r78 = new EventModule("AUDIENCE", 71, "audience");
            AUDIENCE = r78;
            EventModule r79 = new EventModule("MSG_WINDOW_CARD", 72, "msg_window_card");
            MSG_WINDOW_CARD = r79;
            EventModule r81 = new EventModule("COMMON_CARD", 73, "common_card");
            COMMON_CARD = r81;
            EventModule r82 = new EventModule("GAME_ORDER", 74, "game_order");
            GAME_ORDER = r82;
            EventModule r83 = new EventModule("PREDICTOR_PLAYING", 75, "predictor_playing");
            PREDICTOR_PLAYING = r83;
            EventModule r84 = new EventModule("ROOM_BATTLE", 76, "room_battle");
            ROOM_BATTLE = r84;
            EventModule r85 = new EventModule("TEAM_FIGHT", 77, "team_fight");
            TEAM_FIGHT = r85;
            EventModule r86 = new EventModule("GUEST_BATTLE", 78, "guest_battle");
            GUEST_BATTLE = r86;
            EventModule r87 = new EventModule("ADVENTURE", 79, "adventure");
            ADVENTURE = r87;
            EventModule r88 = new EventModule("DANMU_GAME", 80, "danmu_game");
            DANMU_GAME = r88;
            EventModule r89 = new EventModule("INTERACT_XPLAY", 81, "interact_xplay");
            INTERACT_XPLAY = r89;
            EventModule r91 = new EventModule("MULTI_LINK_DYNAMIC", 82, "multi_link_dynamic");
            MULTI_LINK_DYNAMIC = r91;
            EventModule r92 = new EventModule("MULTI_LINK_GIFT", 83, "multi_link_gift");
            MULTI_LINK_GIFT = r92;
            EventModule r93 = new EventModule("FEED", 84, FileUtils.FEED_CACHE);
            FEED = r93;
            EventModule r94 = new EventModule("FEED_TAB", 85, "feed_tab");
            FEED_TAB = r94;
            EventModule r95 = new EventModule("SWITCH_RESOLUTION", 86, "switch_resolution");
            SWITCH_RESOLUTION = r95;
            EventModule r96 = new EventModule("WRDS", 87, "wrds");
            WRDS = r96;
            EventModule r97 = new EventModule("CHAT_CHANNEL", 88, "chat_channel");
            CHAT_CHANNEL = r97;
            EventModule r98 = new EventModule("MULTI_TAB", 89, "multi_tab");
            MULTI_TAB = r98;
            EventModule r99 = new EventModule("ANCHOR_ASR", 90, "anchor_asr");
            ANCHOR_ASR = r99;
            EventModule r100 = new EventModule("AI_CLONE", 91, "ai_clone");
            AI_CLONE = r100;
            EventModule r101 = new EventModule("PERSONALIZED_CHANNEL", 92, "personalized_channel");
            PERSONALIZED_CHANNEL = r101;
            EventModule r102 = new EventModule("INPUT_PANEL", 93, "input_panel");
            INPUT_PANEL = r102;
            EventModule r103 = new EventModule("IMAGE_RECOGNITION", 94, "image_recognition");
            IMAGE_RECOGNITION = r103;
            EventModule r104 = new EventModule("CLOUD_GAME", 95, "cloud_game");
            CLOUD_GAME = r104;
            EventModule r105 = new EventModule("XPLAY", 96, "xplay");
            XPLAY = r105;
            EventModule r106 = new EventModule("MATCH_TRAY", 97, "match_tray");
            MATCH_TRAY = r106;
            EventModule r107 = new EventModule("PAID_LINK_MIC", 98, "paid_linkmic");
            PAID_LINK_MIC = r107;
            EventModule r108 = new EventModule("CLEAR_SCREEN", 99, "clear_screen");
            CLEAR_SCREEN = r108;
            EventModule r109 = new EventModule("OPEN_ASSET", 100, "open_asset");
            OPEN_ASSET = r109;
            EventModule r110 = new EventModule("INTERACTIVITY_DEGRADE", 101, "interactivity_degrade");
            INTERACTIVITY_DEGRADE = r110;
            EventModule r111 = new EventModule("USER_ENTER", OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH, "user_enter");
            USER_ENTER = r111;
            EventModule r112 = new EventModule("SHORT_TOUCH", 103, "short_touch");
            SHORT_TOUCH = r112;
            EventModule r113 = new EventModule("INTERACTION", 104, "interaction");
            INTERACTION = r113;
            EventModule r114 = new EventModule("BANNER", 105, "banner");
            BANNER = r114;
            EventModule r115 = new EventModule("BACKEND", 106, "backend");
            BACKEND = r115;
            a = new EventModule[]{r0, r1, r3, r5, r6, r8, r11, r12, r14, r13, r15, r9, r7, r4, r2, r16, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34, r35, r36, r37, r38, r39, r41, r42, r43, r44, r45, r46, r47, r48, r49, r51, r52, r53, r54, r55, r56, r57, r58, r59, r61, r62, r63, r64, r65, r66, r67, r68, r69, r71, r72, r73, r74, r75, r76, r77, r78, r79, r81, r82, r83, r84, r85, r86, r87, r88, r89, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115};
        }

        public static EventModule[] values() {
            return (EventModule[]) a.clone();
        }

        public String getName() {
            return this.mName;
        }

        public static EventModule valueOf(String r1) {
            return (EventModule) a.a(EventModule.class, r1);
        }

        public EventModule(String r1, int r2, String r3) {
            super(r1, r2);
            this.mName = r3;
        }
    }

    public static final enum EventType extends Enum<EventType> {
        public static final EventType BUSSINESS_API_CALL = null;
        public static final EventType MESSAGE_RECEIVED = null;
        public static final EventType SDK_CALLBACK = null;
        public static final EventType SDK_INTERFACE_CALL = null;
        public static final EventType SERVER_API_CALL = null;
        public static final /* synthetic */ EventType[] a = null;
        private String mName;

        static {
            EventType r0 = new EventType("BUSSINESS_API_CALL", 0, "bussiness_api_call");
            BUSSINESS_API_CALL = r0;
            EventType r1 = new EventType("SERVER_API_CALL", 1, "server_api_call");
            SERVER_API_CALL = r1;
            EventType r2 = new EventType("MESSAGE_RECEIVED", 2, "message_received");
            MESSAGE_RECEIVED = r2;
            EventType r4 = new EventType("SDK_INTERFACE_CALL", 3, "sdk_interface_call");
            SDK_INTERFACE_CALL = r4;
            EventType r6 = new EventType("SDK_CALLBACK", 4, "sdk_callback");
            SDK_CALLBACK = r6;
            a = new EventType[]{r0, r1, r2, r4, r6};
        }

        public static EventType[] values() {
            return (EventType[]) a.clone();
        }

        public String getName() {
            return this.mName;
        }

        public static EventType valueOf(String r1) {
            return (EventType) a.a(EventType.class, r1);
        }

        public EventType(String r1, int r2, String r3) {
            super(r1, r2);
            this.mName = r3;
        }
    }

    static {
        Boolean r2 = Boolean.FALSE;
        a = new SettingKey("live_sdk_enable_dolphin_platform_test_key", "dolphin平台精准熔断演练", r2, r2);
    }

    public static EventModule b(int r1) {
        if (r1 != 1) goto L7;
        return EventModule.PK;
    L7:
        if (r1 != 17) goto L11;
        return EventModule.MEDIA_MULTI_LINKER;
    L11:
        if (r1 != 14) goto L15;
        return EventModule.SCREEN_LINKER;
    L15:
        return EventModule.MULTI_LINKER;
    }

    public static void a(String r0, Throwable r1, String r2) {
        d.f(r0, r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ALogger.e("ensureNotReachHere", "error occur!", th);
    }

    public static void l(JSONObject r0, String r1, String r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e("LiveLinkSlardarMonitor", e.getMessage());
    }

    public static void d(String r6, EventModule r7, EventType r8, JSONObject r9) {
        e(r6, r7, r8, null, null, r9);
    }

    public static void h(String r7, JSONObject r8, JSONObject r9, JSONObject r11) {
        if (((IHostMonitor) BaseServices.as(IHostMonitor.class)) != null) goto L6;
        return;
    L6:
        if (r7.startsWith("ttlive_") == true) goto L8;
        r7 = "ttlive_".concat(r7);
    L8:
        l(r11, "event_source", "live_platform_client");
        JSONObject r0 = new JSONObject();
        JSONArray r1 = r11.names();     // Catch: Exception -> L23
        if (r1 == null) goto L21;
        int r2 = r1.length();     // Catch: Exception -> L23
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L21;
        String r4 = JSONArrayProtectorUtils.getString(r1, r3);     // Catch: Exception -> L23
        if (r4 != null) goto L16;
        String r5 = "";
    L17:
        Object r6 = r11.get(r5);     // Catch: Exception -> L23
        if ((r6 instanceof String) == true) goto L20;
        r11.put(r4, String.valueOf(r6));     // Catch: Exception -> L23
    L20:
        r3 = r3 + 1;     // Catch: Exception -> L23
        goto L12
    L16:
        r5 = r4;
    L21:
        r0.put("extra", r11);     // Catch: Exception -> L23
        l(r0, "tag", "ttlive_sdk");     // Catch: Exception -> L23
        l(r0, "ttlive_sdk_version", String.valueOf(c.b()));     // Catch: Exception -> L23
    L25:
        int r12 = j.a;
        b r13 = om0.c.j();
        if (r13 == null) goto L34;
        r13.monitorEvent(r7, r8, r9, r0);
        return;
    L34:
        return;
    L23:
        e = move-exception;
        Logger.e("LiveLinkSlardarMonitor", e.getMessage());
        goto L25
    }

    public static void i(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        if (((IHostMonitor) BaseServices.as(IHostMonitor.class)) != null) goto L6;
        return;
    L6:
        if (h.a(r2) == false) goto L8;
        return;
    L8:
        if (r5 != null) goto L11;
        r5 = new JSONObject();
    L11:
        if (r2.startsWith("ttlive_") == true) goto L13;
        r2 = "ttlive_".concat(r2);
    L13:
        l(r5, "tag", "ttlive_sdk");
        l(r5, "ttlive_sdk_version", String.valueOf(c.b()));
        int r0 = j.a;
        b r1 = om0.c.j();
        if (r1 == null) goto L17;
        r1.monitorEvent(r2, r3, r4, r5);
        return;
    }

    public static void j(String r7, EventModule r8, int r9, JSONObject r11) {
        if (h.a(r7) == false) goto L5;
        return;
    L5:
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        r4.put("status_code", r9);     // Catch: JSONException -> L8
    L10:
        e(r7, r8, EventType.BUSSINESS_API_CALL, r4, r5, r11);
        return;
    L8:
        e = move-exception;
        Logger.e("LiveLinkSlardarMonitor", e.getMessage());
        goto L10
    }

    public static void f(String r1, EventModule r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        if (h.a(r1) == false) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        r5 = new JSONObject();
    L7:
        l(r5, "event_module", r2.getName());
        l(r5, "event_type", EventType.BUSSINESS_API_CALL.getName());
        h(r1, r3, r4, r5);
    }

    public static void e(String r1, EventModule r2, EventType r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        if (h.a(r1) == false) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
        r6 = new JSONObject();
    L7:
        l(r6, "event_module", r2.getName());
        l(r6, "event_type", r3.getName());
        h(r1, r4, r5, r6);
    }

    public static void g(String r1, String r2, String r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        if (h.a(r1) == false) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
        r6 = new JSONObject();
    L7:
        l(r6, "event_module", r2);
        l(r6, "event_type", r3);
        h(r1, r4, r5, r6);
    }

    public static void k(String r3, EventModule r4, long r5, JSONObject r7, JSONObject r8, JSONObject r9) {
        if (h.a(r3) == false) goto L6;
        return;
    L6:
        if (r5 > 0) goto L14;
    L12:
        l(r9, "event_module", r4.getName());
        l(r9, "event_type", EventType.BUSSINESS_API_CALL.getName());
        h(r3, r7, r8, r9);
        return;
    L14:
        r8.put("latency", r5);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        Logger.e("LiveLinkSlardarMonitor", e.getMessage());
        goto L12
    }

    public static void c(String r6, EventModule r7, EventType r8, int r9, String r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        if (h.a(r6) == false) goto L5;
        return;
    L5:
        if (r14 != null) goto L7;
        r14 = new JSONObject();
    L7:
        JSONObject r5 = r14;
        l(r5, "status_code", String.valueOf(r9));
        l(r5, "status_msg", String.valueOf(r11));
        e(r6, r7, r8, r12, r13, r5);
    }
}
