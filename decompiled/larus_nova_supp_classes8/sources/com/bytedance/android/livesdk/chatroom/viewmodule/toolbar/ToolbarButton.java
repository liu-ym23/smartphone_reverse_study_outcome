package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.util.SparseArray;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.business.VSInjectWidgetType;
import com.bytedance.android.livesdk.utils.n5;
import com.bytedance.android.livesdkapi.model.DislikeConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final enum ToolbarButton extends Enum<ToolbarButton> implements a2 {
    private static final /* synthetic */ ToolbarButton[] $VALUES = null;
    public static final ToolbarButton ACTIVITY_ZONE = null;
    public static final ToolbarButton ADD_PICTURE = null;
    public static final ToolbarButton ADVANCE_ANNOUNCEMENT = null;
    public static final ToolbarButton AIRDROP_GIFT = null;
    public static final ToolbarButton ANCHOR_BACKTRACK = null;
    public static final ToolbarButton ANCHOR_CHAT_CHANNEL = null;
    public static final ToolbarButton ANCHOR_SHOW = null;
    public static final ToolbarButton ASSEMBLED_SETTING = null;
    public static final ToolbarButton ATTACK_AND_DEFENSE = null;
    public static final ToolbarButton AUDIENCE_LANDSCAPE = null;
    public static final ToolbarButton AUDIENCE_PUBLIC_SCREEN_CONFIG = null;
    public static final ToolbarButton AUDIENCE_RECORD = null;
    public static final ToolbarButton AUDIENCE_RESOLUTION = null;
    public static final ToolbarButton AUDIO = null;
    public static final ToolbarButton AUDIO_COMMENT = null;
    public static final ToolbarButton AUDIO_SUBTITLE_SETTING = null;
    public static final ToolbarButton AUDIO_TOGGLE = null;
    public static final ToolbarButton AUTO_CAR = null;
    public static final ToolbarButton AUTO_REPLY = null;
    public static final ToolbarButton AV_ADJUST = null;
    public static final ToolbarButton BARRAGE = null;
    public static final ToolbarButton BARRAGE_SETTING = null;
    public static final ToolbarButton BEAUTY = null;
    public static final ToolbarButton BGM = null;
    public static final ToolbarButton BLOCK = null;
    public static final ToolbarButton BLOCK_MEDIA = null;
    public static final ToolbarButton BROADCAST_ADMIN = null;
    public static final ToolbarButton BROADCAST_BARRAGE = null;
    public static final ToolbarButton BROADCAST_EFFECT = null;
    public static final ToolbarButton BROADCAST_GIFT = null;
    public static final ToolbarButton BROADCAST_INFO = null;
    public static final ToolbarButton BROADCAST_PAUSE = null;
    public static final ToolbarButton BROADCAST_RESTART = null;
    public static final ToolbarButton BROADCAST_SHARE = null;
    public static final ToolbarButton BROADCAST_TASK = null;
    public static final ToolbarButton CAMERA_MOVEMENT = null;
    public static final ToolbarButton CASH_EXCHANGE = null;
    public static final ToolbarButton CAST_FEED_BACK = null;
    public static final ToolbarButton CAST_REFRESH = null;
    public static final ToolbarButton CAST_SCREEN = null;
    public static final ToolbarButton CAST_SCREEN_FEED_BACK = null;
    public static final ToolbarButton CAST_SCREEN_MORE_PANEL = null;
    public static final ToolbarButton CAST_SCREEN_REFRESH = null;
    public static final ToolbarButton CHANNEL_COMMENT = null;
    public static final ToolbarButton CHAT_CHANNEL_LANDSCAPE = null;
    public static final ToolbarButton CLEAR_SCREEN = null;
    public static final ToolbarButton CLEAR_SCREEN_OPTIMIZE_OFF = null;
    public static final ToolbarButton CLEAR_SCREEN_OPTIMIZE_ON = null;
    public static final ToolbarButton CLOSE_ROOM = null;
    public static final ToolbarButton COLLECT = null;
    public static final ToolbarButton COMMENT = null;
    public static final ToolbarButton COMMERCE = null;
    public static final ToolbarButton COMMERCE_IM = null;
    public static final ToolbarButton COMMERCE_LIVE_AD = null;
    public static final ToolbarButton COMMERCE_MORE = null;
    public static final ToolbarButton COPY_LINK = null;
    public static final ToolbarButton COUPON_EXCHANGE = null;
    public static final ToolbarButton DECORATION = null;
    public static final ToolbarButton DESKTOP_WIDGET_PIN_ANCHOR = null;
    public static final ToolbarButton DESKTOP_WIDGET_UNPIN_ANCHOR = null;
    public static final ToolbarButton DISLIKE = null;
    public static final ToolbarButton DIVIDER = null;
    public static final ToolbarButton DOUYIN_CLOSE = null;
    public static final ToolbarButton DOUYIN_GAME = null;
    public static final ToolbarButton DOUYIN_OFFICIAL_EFFECT = null;
    public static final ToolbarButton DOUYIN_OFFICIAL_IMMERSE = null;
    public static final ToolbarButton DOUYIN_OFFICIAL_QUALITY = null;
    public static final ToolbarButton DOU_PLUS_PROMOTE = null;
    public static final ToolbarButton DOU_PLUS_PROMOTE_AUDIENCE = null;
    public static final ToolbarButton DRIVE = null;
    public static final ToolbarButton DUTY_GIFT = null;
    public static final ToolbarButton EASTER_EGG = null;
    public static final ToolbarButton FAN_GROUP_MANAGE = null;
    public static final ToolbarButton FAST_GIFT = null;
    public static final ToolbarButton FILTER = null;
    public static final ToolbarButton FLOW_FEEDBACK = null;
    public static final ToolbarButton FNA_GROUP = null;
    public static final ToolbarButton FollowerShare = null;
    public static final ToolbarButton GAME_CAST_SCREEN = null;
    public static final ToolbarButton GAME_EXIT = null;
    public static final ToolbarButton GAME_GUESS = null;
    public static final ToolbarButton GAME_PROMOTE = null;
    public static final ToolbarButton GAME_PROMOTE_AUDIENCE = null;
    public static final ToolbarButton GAME_PROMOTE_AUDIENCE_MORE = null;
    public static final ToolbarButton GAME_PROMOTE_MORE = null;
    public static final ToolbarButton GAME_QUIZ = null;
    public static final ToolbarButton GESTURE_MAGIC = null;
    public static final ToolbarButton GIFT = null;
    public static final ToolbarButton GIFT_ANIMATION = null;
    public static final ToolbarButton GIFT_CONSUMER_TOAST = null;
    public static final ToolbarButton GIFT_EFFECT = null;
    public static final ToolbarButton GROUP_PURCHASE = null;
    public static final ToolbarButton GROUP_PURCHASE_AUDIENCE = null;
    public static final ToolbarButton GROUP_PURCHASE_MORE = null;
    public static final ToolbarButton GUARD_BOX = null;
    public static final ToolbarButton GUEST_BATTLE_ADMIN = null;
    public static final ToolbarButton HASH_TAG = null;
    public static final ToolbarButton HOTSOON_PROMOTION = null;
    public static final ToolbarButton HOUR_RANK = null;
    public static final ToolbarButton IM_LIST_VIRTUAL = null;
    public static final ToolbarButton INCOME_MORE = null;
    public static final ToolbarButton INNER_SMALL_WINDOW_ACTION_BUTTON = null;
    public static final ToolbarButton INTERACTION = null;
    public static final ToolbarButton INTERACTION_AUDIENCE = null;
    public static final ToolbarButton INTERACTION_MORE = null;
    public static final ToolbarButton INTERACTION_ROOM = null;
    public static final ToolbarButton INTERACTION_ROOM_BATTLE = null;
    public static final ToolbarButton INTERACTION_SCENE = null;
    public static final ToolbarButton INTERACT_GAME = null;
    public static final ToolbarButton INTERACT_GAME_EXIT = null;
    public static final ToolbarButton INTERACT_GIFT = null;
    public static final ToolbarButton INTERACT_PLAY = null;
    public static final ToolbarButton INTERACT_PLAY_FOR_GROUP_LIVE_GAME = null;
    public static final ToolbarButton IN_ROOM_RESOLUTION = null;
    public static final ToolbarButton KEY_ROOM_INFO = null;
    public static final ToolbarButton KTV = null;
    public static final ToolbarButton KTV_GROUP = null;
    public static final ToolbarButton LANDSCAPE_MULTI_TAB = null;
    public static final ToolbarButton LICENSE_INFO = null;
    public static final ToolbarButton LIKE_FEEDBACK = null;
    public static final ToolbarButton LINKMIC_ANNOUNCE = null;
    public static final ToolbarButton LINKMIC_GAME = null;
    public static final ToolbarButton LINKMIC_SETTING = null;
    public static final ToolbarButton LITTLE_GAME = null;
    public static final ToolbarButton LITTLE_PLUGIN = null;
    public static final ToolbarButton LIVE_CONTENT = null;
    public static final ToolbarButton LIVE_FLOAT_WINDOW_PLAY = null;
    public static final ToolbarButton LIVE_IM_ENTRANCE = null;
    public static final ToolbarButton LIVE_IM_ENTRANCE_MORE = null;
    public static final ToolbarButton LIVE_LISTEN = null;
    public static final ToolbarButton LIVE_MATRIX = null;
    public static final ToolbarButton LIVE_MULTI_CAMERA = null;
    public static final ToolbarButton LIVE_PICTURE_PRESENTATION = null;
    public static final ToolbarButton LIVE_PICTURE_TYPE = null;
    public static final ToolbarButton LIVE_WIDGET = null;
    public static final ToolbarButton LIVING_DRAINAGE = null;
    public static final ToolbarButton LOTTERY = null;
    public static final ToolbarButton MANAGE = null;
    public static final ToolbarButton MANAGE_UNFOLD = null;
    public static final ToolbarButton MARKETING_WIDGET_PIN_BUTTON = null;
    public static final ToolbarButton MATCH_ROOM_MOMENT = null;
    public static final ToolbarButton MATCH_ROOM_MULTI_CAMERA = null;
    public static final ToolbarButton MERCHANT_QUALIFICATIONS = null;
    public static final ToolbarButton MESSAGE_BOX = null;
    public static final ToolbarButton MESSAGE_PUSH = null;
    public static final ToolbarButton MINI_APP = null;
    public static final ToolbarButton MINI_APP_MORE = null;
    public static final ToolbarButton MINOR_REFUND = null;
    public static final ToolbarButton MORE = null;
    public static final ToolbarButton MULTI_CAMERA = null;
    public static final ToolbarButton MULTI_CAMERA_LINKED_ROOM = null;
    public static final ToolbarButton MULTI_SCENE_GAME_PLAY = null;
    public static final ToolbarButton OPEN_PLATFORM_GAME = null;
    public static final ToolbarButton OPEN_PLATFORM_LYNX_GAME = null;
    public static final ToolbarButton OPEN_PLATFORM_MINI_APP = null;
    public static final ToolbarButton OPEN_PLATFORM_MINI_APP_MORE = null;
    public static final ToolbarButton OPEN_PLATFORM_MINI_GAME = null;
    public static final ToolbarButton PAD_AND_PC_PLAY = null;
    public static final ToolbarButton PAD_AND_PC_PLAY_LANDSCAPE = null;
    public static final ToolbarButton PERMANENT_CHAT_GUEST = null;
    public static final ToolbarButton PERMANENT_CHAT_ROOM = null;
    public static final ToolbarButton PK = null;
    public static final ToolbarButton PLAY_QUALITY_OPT = null;
    public static final ToolbarButton PLAY_SETTING = null;
    public static final ToolbarButton POI = null;
    public static final ToolbarButton PREDICTOR_GUESS = null;
    public static final ToolbarButton PROMOTION_CARD = null;
    public static final ToolbarButton PROMOTION_VIDEO = null;
    public static final ToolbarButton PROMPT = null;
    public static final ToolbarButton PUBLIC_SCREEN_AI_HELPER = null;
    public static final ToolbarButton PUBLIC_SCREEN_CONFIG = null;
    public static final ToolbarButton PUBLIC_SCREEN_SELECTED_MESSAGE = null;
    public static final ToolbarButton PUSH_URL = null;
    public static final ToolbarButton QR_CODE = null;
    public static final ToolbarButton QUESTION_AND_ANSWER = null;
    public static final ToolbarButton QUICK_SCREEN_SHOT = null;
    public static final ToolbarButton RADIO_COVER = null;
    public static final ToolbarButton RADIO_INTERACTION_AUDIENCE = null;
    public static final ToolbarButton RECHARGE_RECORD = null;
    public static final ToolbarButton RECORD = null;
    public static final ToolbarButton RECORD_COMBINE = null;
    public static final ToolbarButton RECORD_LANDSCAPE = null;
    public static final ToolbarButton RED_ENVELOPE = null;
    public static final ToolbarButton REN_QI_BAO = null;
    public static final ToolbarButton REPLAY_CAST_SCREEN = null;
    public static final ToolbarButton REPLAY_CAST_SCREEN_FEED_BACK = null;
    public static final ToolbarButton REPLAY_CHOOSE = null;
    public static final ToolbarButton REPLAY_TICKET_SALE = null;
    public static final ToolbarButton REPORT = null;
    public static final ToolbarButton REVERSE_CAMERA = null;
    public static final ToolbarButton REVERSE_MIRROR = null;
    public static final ToolbarButton REVOKE_AUTH = null;
    public static final ToolbarButton ROOM_CHANNEL = null;
    public static final ToolbarButton ROOM_CHANNEL_LANDSCAPE = null;
    public static final ToolbarButton ROOM_FIGHT_ADMIN = null;
    public static final ToolbarButton ROOM_INTRO = null;
    public static final ToolbarButton ROOM_NOTICE = null;
    public static final ToolbarButton SCHEDULE_CLOSE = null;
    public static final ToolbarButton SHAKE_MATCH_SETTING = null;
    public static final ToolbarButton SHARE = null;
    public static final ToolbarButton SHARE_TO_DAILY = null;
    public static final ToolbarButton SMALL_WINDOW_ACTION_BUTTON = null;
    public static final ToolbarButton SOUND_EFFECT = null;
    public static final ToolbarButton SQUARE_COMMENT = null;
    public static final ToolbarButton STABLE_MODE = null;
    public static final ToolbarButton STAR_GRAPH = null;
    public static final ToolbarButton STICKER = null;
    public static final ToolbarButton STICKER_NEW = null;
    public static final ToolbarButton SWITCH_ACCOUNT = null;
    public static final ToolbarButton SWITCH_SCREEN_ORIENTATION = null;
    public static final ToolbarButton SWITCH_VIDEO_QUALITY = null;
    public static final ToolbarButton SWITCH_VIDEO_QUALITY_MATCH = null;
    public static final ToolbarButton TASK_CENTER = null;
    public static final ToolbarButton TEAM_FIGHT = null;
    public static final ToolbarButton TEAM_FIGHT_ADMIN = null;
    public static final ToolbarButton TICKET_SALE = null;
    public static final ToolbarButton TICKET_SALE_ANCHOR = null;
    public static final ToolbarButton TICKET_SALE_ANCHOR_MORE = null;
    public static final ToolbarButton TOUTIAO_FLOAT_WINDOW = null;
    public static final ToolbarButton TRANSFORM_WIDGET = null;
    public static final ToolbarButton TRANSFORM_WIDGET_AUDIENCE_MORE = null;
    public static final ToolbarButton TRANSFORM_WIDGET_MORE = null;
    public static final ToolbarButton TREASURE_BOX = null;
    public static final ToolbarButton TURNTABLE_V2 = null;
    public static final ToolbarButton UNION_LIVE = null;
    public static final ToolbarButton VIDEO_PLAY = null;
    public static final ToolbarButton VIP_IM = null;
    public static final ToolbarButton VIRTUAL_LIVE = null;
    public static final ToolbarButton VOICE_LIVE_THEME = null;
    public static final ToolbarButton VOTE = null;
    public static final ToolbarButton VR_MODE = null;
    public static final ToolbarButton VS_ACTIVITY_ONE = null;
    public static final ToolbarButton VS_ACTIVITY_THREE = null;
    public static final ToolbarButton VS_ACTIVITY_TWO = null;
    public static final ToolbarButton VS_BARRAGE_KEY_FILTER = null;
    public static final ToolbarButton VS_BARRAGE_SETTING = null;
    public static final ToolbarButton VS_CACHE = null;
    public static final ToolbarButton VS_CART = null;
    public static final ToolbarButton VS_CAST_SCREEN = null;
    public static final ToolbarButton VS_COLLECT = null;
    public static final ToolbarButton VS_DELETE = null;
    public static final ToolbarButton VS_FAST_PLAY = null;
    public static final ToolbarButton VS_FLOAT_WINDOW = null;
    public static final ToolbarButton VS_GIFT_CONSUMER_TOAST = null;
    public static final ToolbarButton VS_HIGHLIGHT = null;
    public static final ToolbarButton VS_INTERACTIVE = null;
    public static final ToolbarButton VS_LANDSCAPE_MORE = null;
    public static final ToolbarButton VS_LANDSCAPE_OPERATION = null;
    public static final ToolbarButton VS_MESSAGE_BOARD = null;
    public static final ToolbarButton VS_MORE_LIVE_ENTRY = null;
    public static final ToolbarButton VS_ONLY_TA = null;
    public static final ToolbarButton VS_ONLY_TA_LANDSCAPE = null;
    public static final ToolbarButton VS_PORTRAIT_LOCK = null;
    public static final ToolbarButton VS_PORTRAIT_MORE = null;
    public static final ToolbarButton VS_PORTRAIT_OPERATION = null;
    public static final ToolbarButton VS_PORTRAIT_TOP_MORE = null;
    public static final ToolbarButton VS_RECORD_PORTAIT_DAMAKU_ENABLE = null;
    public static final ToolbarButton VS_REPORT = null;
    public static final ToolbarButton VS_SCHEDULE_CLOSE = null;
    public static final ToolbarButton VS_SELECT_EPISODE = null;
    public static final ToolbarButton VS_SHARE = null;
    public static final ToolbarButton VS_SHARE_UNFOLD = null;
    public static final ToolbarButton VS_TEDIOUS = null;
    public static final ToolbarButton VS_TOPIC_OPERATION = null;
    public static final ToolbarButton VS_VERTICAL_RESOLUTION = null;
    public static final ToolbarButton VS_VIDEO_QUALITY = null;
    public static final ToolbarButton VS_VISIBILITY_SETTING = null;
    public static final ToolbarButton WATCH_LATER = null;
    public static final ToolbarButton WELFARE = null;
    public static final ToolbarButton WELFARE_FOLD = null;
    public static final ToolbarButton WISH_LIST = null;
    public static final ToolbarButton XT_GAMELIVE_INTERACTION = null;
    public static final ToolbarButton XT_LANDSCAPE_SHARE = null;
    private static Map<String, ToolbarButton> nameEnumMap;
    private int broadcastDrawableFolded;
    private int broadcastDrawableUnfolded;
    private int broadcastLayoutId;
    private int broadcastTitleId;
    private int drawableFolded;
    private int drawableUnfolded;
    private int layoutId;
    private boolean pureText;
    private long serverId;
    private int titleId;
    private String titleStr;
    private boolean useStandardLayout;
    private k4 vsToolbarExtendProperty;

    private static int getInteractSceneDrawable() {
        if (((Boolean) j40.u.a.getValue()).booleanValue() == false) goto L6;
        return 2131251089;
    L6:
        return 2131251101;
    }

    private static int getTicketSaleIcon() {
        if (((Boolean) j40.h4.a.getValue()).booleanValue() == false) goto L6;
        return 2131243771;
    L6:
        return 2131251551;
    }

    public static ToolbarButton[] values() {
        return (ToolbarButton[]) $VALUES.clone();
    }

    public ExtendedToolbarButton extended() {
        ExtendedToolbarButton.h.getClass();
        return ExtendedToolbarButton.a.a(this);
    }

    public int getBroadcastDrawableFolded() {
        int r0 = this.broadcastDrawableFolded;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.drawableFolded;
    }

    public int getBroadcastDrawableUnfolded() {
        int r0 = this.broadcastDrawableUnfolded;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.drawableUnfolded;
    }

    public int getBroadcastLayoutId() {
        int r0 = this.broadcastLayoutId;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.layoutId;
    }

    public int getBroadcastTitleId() {
        int r0 = this.broadcastTitleId;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.titleId;
    }

    public String getTag() {
        return ToolbarButton.class.getName();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public String debugName() {
        return name();
    }

    static {
        int r2 = 0;
        VS_LANDSCAPE_MORE = new ToolbarButton("VS_LANDSCAPE_MORE", 0, 2131567991, 2131567991);
        VS_PORTRAIT_TOP_MORE = new ToolbarButton("VS_PORTRAIT_TOP_MORE", 1, 2131567991, 2131567991);
        VS_PORTRAIT_MORE = new ToolbarButton("VS_PORTRAIT_MORE", 2, 2131253419, 2131253419, 2131914471);
        VS_SELECT_EPISODE = new ToolbarButton("VS_SELECT_EPISODE", 3, 0, 0, 2131923391);
        VS_VIDEO_QUALITY = new ToolbarButton("VS_VIDEO_QUALITY", 4, 0, 0, 2131923359);
        REPLAY_CHOOSE = new ToolbarButton("REPLAY_CHOOSE", 5, 0, 0, 2131922162);
        VS_FAST_PLAY = new ToolbarButton("VS_FAST_PLAY", 6, 2131253364, 2131253364, 2131923327);
        VS_ONLY_TA = new ToolbarButton("VS_ONLY_TA", 7, 2131253414, 2131253414, 2131923356);
        VS_ONLY_TA_LANDSCAPE = new ToolbarButton("VS_ONLY_TA_LANDSCAPE", 8, 2131567986, 2131567986);
        VS_PORTRAIT_LOCK = new ToolbarButton("VS_PORTRAIT_LOCK", 9, 2131253418, 2131253418, 2131923346);
        VS_HIGHLIGHT = new ToolbarButton("VS_HIGHLIGHT", 10, 0, 0, 2131923339);
        VS_TEDIOUS = new ToolbarButton("VS_TEDIOUS", 11, 2131253437, 2131253437, 2131916228, new k4(null, null, 2131253438, null));
        VS_SCHEDULE_CLOSE = new ToolbarButton("VS_SCHEDULE_CLOSE", 12, 2131253430, 2131253430, 2131923381, new k4(null, null, 2131253430, null));
        VS_FLOAT_WINDOW = new ToolbarButton("VS_FLOAT_WINDOW", 13, 2131253376, 2131253376, 2131923329, new k4(2131253374, 2131923329, 2131253375, null));
        VS_COLLECT = new ToolbarButton("VS_COLLECT", 14, 2131253357, 2131253357, 2131923299, new k4(null, null, 2131253356, null));
        VS_CACHE = new ToolbarButton("VS_CACHE", 15, 2131253352, 2131253352, 2131923289, new k4(null, null, 2131253351, null));
        VS_VISIBILITY_SETTING = new ToolbarButton("VS_VISIBILITY_SETTING", 16, 0, 0, 2131923394, new k4(null, null, 2131253432, null));
        VS_DELETE = new ToolbarButton("VS_DELETE", 17, 0, 0, 2131923316, new k4(null, null, 2131253362, null));
        VS_CAST_SCREEN = new ToolbarButton("VS_CAST_SCREEN", 18, 0, 0, 2131923373, new k4(2131251879, null, 2131251880, null));
        CAST_FEED_BACK = new ToolbarButton("CAST_FEED_BACK", 19, 2131232532, 2131232532, 2131915555);
        CAST_REFRESH = new ToolbarButton("CAST_REFRESH", 20, 2131232533, 2131232533, 2131915557);
        VS_TOPIC_OPERATION = new ToolbarButton("VS_TOPIC_OPERATION", 21, 2131567893);
        VS_PORTRAIT_OPERATION = new ToolbarButton("VS_PORTRAIT_OPERATION", 22, 2131567890, 2131923266, new k4());
        VS_LANDSCAPE_OPERATION = new ToolbarButton("VS_LANDSCAPE_OPERATION", 23, 0, 0, 2131923266, new k4());
        VS_ACTIVITY_ONE = new ToolbarButton("VS_ACTIVITY_ONE", 24, 0, 0, 2131923265, new k4());
        VS_ACTIVITY_TWO = new ToolbarButton("VS_ACTIVITY_TWO", 25, 0, 0, 2131923268, new k4());
        VS_ACTIVITY_THREE = new ToolbarButton("VS_ACTIVITY_THREE", 26, 0, 0, 2131923267, new k4());
        VS_SHARE = new ToolbarButton("VS_SHARE", 27, 2131253433, 2131253433, 2131922489, new k4(null, null, 2131253399, null));
        VS_SHARE_UNFOLD = new ToolbarButton("VS_SHARE_UNFOLD", 28, 2131253434, 2131253434, 2131922489, new k4());
        VS_BARRAGE_SETTING = new ToolbarButton("VS_BARRAGE_SETTING", 29, 2131253360, 2131253360, 2131915275, new k4(null, null, 2131253361, null));
        VS_RECORD_PORTAIT_DAMAKU_ENABLE = new ToolbarButton("VS_RECORD_PORTAIT_DAMAKU_ENABLE", 30, 2131251644, 2131251644, 2131923306);
        VS_REPORT = new ToolbarButton("VS_REPORT", 31, 2131253387, 2131253387, 2131922171, new k4(null, null, 2131253426, null));
        VS_INTERACTIVE = new ToolbarButton("VS_INTERACTIVE", 32, 2131251656, 2131251656, 2131918144, new k4(null, null, 2131251655, null));
        VS_MESSAGE_BOARD = new ToolbarButton("VS_MESSAGE_BOARD", 33, 2131251660, 2131251661, 2131923348);
        MULTI_CAMERA_LINKED_ROOM = new ToolbarButton("MULTI_CAMERA_LINKED_ROOM", 34, 2131566894);
        MATCH_ROOM_MOMENT = new ToolbarButton("MATCH_ROOM_MOMENT", 35, 2131566901);
        EASTER_EGG = new ToolbarButton("EASTER_EGG", 36, 2131566791);
        KTV = new ToolbarButton("KTV", 37, 2131250804, 2131250804, 2131915386, 2131250805, 2131250805, 2131915386);
        KTV_GROUP = new ToolbarButton("KTV_GROUP", 38, 2131253137, 2131253137, 2131915387, 2131253137, 2131253137, 2131915387);
        INTERACTION_AUDIENCE = new ToolbarButton("INTERACTION_AUDIENCE", 39, 2131566788);
        INTERACTION_ROOM = new ToolbarButton("INTERACTION_ROOM", 40, 2131567881, 2131567881);
        INTERACTION = new ToolbarButton("INTERACTION", 41, 2131567879, 2131567876);
        j40.h4 r1 = j40.h4.a;
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L5;
        int r22 = 2131243774;
    L6:
        INTERACTION_MORE = new ToolbarButton("INTERACTION_MORE", 42, 2131250848, r22, 2131918107);
        INTERACTION_SCENE = new ToolbarButton("INTERACTION_SCENE", 43, getInteractSceneDrawable(), getInteractSceneDrawable(), 2131918107);
        INTERACTION_ROOM_BATTLE = new ToolbarButton("INTERACTION_ROOM_BATTLE", 44, 2131567892, 2131567892);
        TEAM_FIGHT = new ToolbarButton("TEAM_FIGHT", 45, 2131251104, 2131251104, 2131922767);
        MULTI_SCENE_GAME_PLAY = new ToolbarButton("MULTI_SCENE_GAME_PLAY", 46, 2131567887, 2131567887);
        PK = new ToolbarButton("PK", 47, 2131567891, 2131567891);
        CLOSE_ROOM = new ToolbarButton("CLOSE_ROOM", 48, 2131251575, 0, 0, 2131251574, 0, 0);
        RED_ENVELOPE = new ToolbarButton("RED_ENVELOPE", 49, 2131252966, 2131252966, 0);
        MORE = new ToolbarButton("MORE", 50, 2131567886, 2131567885);
        LIVING_DRAINAGE = new ToolbarButton("LIVING_DRAINAGE", 51, 2131252279, 2131252279, 2131920116);
        BARRAGE_SETTING = new ToolbarButton("BARRAGE_SETTING", 52, 2131250891, 2131250891, 2131915275);
        SHARE = new ToolbarButton("SHARE", 53, 2131253001, 2131251494, 2131922489, 2131251488, 2131251489, 0);
        BROADCAST_SHARE = new ToolbarButton("BROADCAST_SHARE", 54, 2131252948, 2131252970, 2131922489, 2131251488, 2131251489, 0);
        SHARE_TO_DAILY = new ToolbarButton("SHARE_TO_DAILY", 55, 2131253050, 2131253050, 2131922996);
        FollowerShare = new ToolbarButton("FollowerShare", 56, 2131252989, 2131252989, 2131915425);
        WELFARE = new ToolbarButton("WELFARE", 57, 2131567533, 2131567533);
        WELFARE_FOLD = new ToolbarButton("WELFARE_FOLD", 58, 2131251669, 2131251669, 2131923444, 0, 2131251670, 2131923444);
        GROUP_PURCHASE = new ToolbarButton("GROUP_PURCHASE", 59, 2131567870, 2131567870);
        GROUP_PURCHASE_MORE = new ToolbarButton("GROUP_PURCHASE_MORE", 60, 2131251045, 2131251045, 2131917222, 2131251046, 2131251046, 2131917222);
        GROUP_PURCHASE_AUDIENCE = new ToolbarButton("GROUP_PURCHASE_AUDIENCE", 61, 2131567869);
        MANAGE = new ToolbarButton("MANAGE", 62, 2131251457, 2131251457, 2131915402, 2131251457, 2131251457, 2131915402);
        PROMPT = new ToolbarButton("PROMPT", 63, 2131251767, 2131251767, 2131922856);
        VIDEO_PLAY = new ToolbarButton("VIDEO_PLAY", 64, 2131251608, 2131251608, 2131922872);
        ACTIVITY_ZONE = new ToolbarButton("ACTIVITY_ZONE", 65, 2131250785, 2131250785, 2131915317, 0, 2131250786, 2131915317);
        BROADCAST_ADMIN = new ToolbarButton("BROADCAST_ADMIN", 66, 2131251701, 2131251701, 2131922849);
        FLOW_FEEDBACK = new ToolbarButton("FLOW_FEEDBACK", 67, 2131251011, 2131251011, 2131922837);
        MANAGE_UNFOLD = new ToolbarButton("MANAGE_UNFOLD", 68, 2131567883);
        UNION_LIVE = new ToolbarButton("UNION_LIVE", 69, 1036, 2131251599, 2131251599, 2131915406, 2131251600, 2131251600, 2131915406);
        ANCHOR_CHAT_CHANNEL = new ToolbarButton("ANCHOR_CHAT_CHANNEL", 70, 2131250800, 2131250800, 2131920485);
        STABLE_MODE = new ToolbarButton("STABLE_MODE", 71, 2131251525, 2131251525, 2131915380);
        MINI_APP = new ToolbarButton("MINI_APP", 72, 2131251235, 2131251235, 2131920360, 2131250908, 2131250909, 2131920360);
        MINI_APP_MORE = new ToolbarButton("MINI_APP_MORE", 73, 2131250908, 2131250909, 2131920360);
        LITTLE_GAME = new ToolbarButton("LITTLE_GAME", 74, 2131567529, 2131567529, 2131916748, 2131916748);
        TICKET_SALE = new ToolbarButton("TICKET_SALE", 75, getTicketSaleIcon(), getTicketSaleIcon(), 2131922901, 2131251551, 2131251551, 2131922901);
        REPLAY_TICKET_SALE = new ToolbarButton("REPLAY_TICKET_SALE", 76, 2131252567, 2131252567, 2131922901);
        TICKET_SALE_ANCHOR = new ToolbarButton("TICKET_SALE_ANCHOR", 77, 2131252566, 2131252566, 2131922902, 2131252566, 2131252566, 2131922902);
        TICKET_SALE_ANCHOR_MORE = new ToolbarButton("TICKET_SALE_ANCHOR_MORE", 78, 2131252565, 2131252565, 2131922902, 2131252565, 2131252565, 2131922902);
        LICENSE_INFO = new ToolbarButton("LICENSE_INFO", 79, 2131252192, 2131252192, 2131918664, 2131252192, 2131252192, 2131918664);
        CLEAR_SCREEN = new ToolbarButton("CLEAR_SCREEN", 80, 2131250939, 2131250939, 2131915814);
        ROOM_CHANNEL_LANDSCAPE = new ToolbarButton("ROOM_CHANNEL_LANDSCAPE", 81, 2131567532);
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L9;
        int r30 = 2131243769;
    L10:
        ROOM_CHANNEL = new ToolbarButton("ROOM_CHANNEL", 82, r30, 2131251452, 2131922217);
        SCHEDULE_CLOSE = new ToolbarButton("SCHEDULE_CLOSE", 83, 2131253430, 2131253430, 2131923381);
        COLLECT = new ToolbarButton("COLLECT", 84, 2131253357, 2131253357, 2131923299, new k4(null, null, 2131253356, null));
        CLEAR_SCREEN_OPTIMIZE_OFF = new ToolbarButton("CLEAR_SCREEN_OPTIMIZE_OFF", 85, 2131250937, 2131250937, 2131915814);
        CLEAR_SCREEN_OPTIMIZE_ON = new ToolbarButton("CLEAR_SCREEN_OPTIMIZE_ON", 86, 2131250938, 2131250938, 2131915814);
        REPORT = new ToolbarButton("REPORT", 87, 2131251436, 2131251436, 2131922171);
        MINOR_REFUND = new ToolbarButton("MINOR_REFUND", 88, 2131252409, 2131252409, 2131914410);
        SWITCH_ACCOUNT = new ToolbarButton("SWITCH_ACCOUNT", 89, 2131251589, 2131251589, 2131914466);
        VIP_IM = new ToolbarButton("VIP_IM", 90, 2131251614, 2131251614, 2131923201);
        int r3 = com.bytedance.android.livesdk.utils.landscape.d.a;
        PREDICTOR_GUESS = new ToolbarButton("PREDICTOR_GUESS", 91, 2131251028, 2131251028, 2131916824);
        RECORD = new ToolbarButton("RECORD", 92, 2131251411, 2131252965, 2131915401, 2131251410, 2131250907, 0);
        RECORD_LANDSCAPE = new ToolbarButton("RECORD_LANDSCAPE", 93, 2131251401, 2131251400, 2131915401);
        GAME_CAST_SCREEN = new ToolbarButton("GAME_CAST_SCREEN", 94, 2131251123, 2131251123, 2131915401);
        CAST_SCREEN = new ToolbarButton("CAST_SCREEN", 95, 2131250187, 2131250187, 2131923373);
        PAD_AND_PC_PLAY = new ToolbarButton("PAD_AND_PC_PLAY", 96, 2131251289, 2131251289, 2131920482);
        PAD_AND_PC_PLAY_LANDSCAPE = new ToolbarButton("PAD_AND_PC_PLAY_LANDSCAPE", 97, 2131251289, 2131251289, 2131920482);
        WATCH_LATER = new ToolbarButton("WATCH_LATER", 98, 2131251666, 2131251666, 2131923434);
        LIVE_WIDGET = new ToolbarButton("LIVE_WIDGET", 99, 2131248576, 2131248576, 2131914516);
        ANCHOR_BACKTRACK = new ToolbarButton("ANCHOR_BACKTRACK", 100, 2131250822, 2131250822, 2131914659, 2131250822, 2131250822, 0);
        PUBLIC_SCREEN_SELECTED_MESSAGE = new ToolbarButton("PUBLIC_SCREEN_SELECTED_MESSAGE", 101, 2131251585, 2131251585, 2131922410, 2131251585, 2131251586, 2131922410);
        PUBLIC_SCREEN_AI_HELPER = new ToolbarButton("PUBLIC_SCREEN_AI_HELPER", VSInjectWidgetType.LIVE_SHADOW_PLAYER, 2131251585, 2131251585, 2131921793, 2131251585, 2131251586, 2131921793);
        PUBLIC_SCREEN_CONFIG = new ToolbarButton("PUBLIC_SCREEN_CONFIG", VSInjectWidgetType.LIVE_MULTI_DEVICE_ENTRY, 2131251583, 2131251583, 2131921787, 2131251583, 2131251584, 2131921787);
        AUDIENCE_PUBLIC_SCREEN_CONFIG = new ToolbarButton("AUDIENCE_PUBLIC_SCREEN_CONFIG", 104, 2131251583, 2131251583, 2131921787);
        BARRAGE = new ToolbarButton("BARRAGE", 105, 2131251146, 2131251146, 0);
        LIVE_PICTURE_TYPE = new ToolbarButton("LIVE_PICTURE_TYPE", 106, 2131251312, 2131251312, 2131921361);
        BLOCK = new ToolbarButton("BLOCK", 107, 2131251147, 2131251147, 0);
        BLOCK_MEDIA = new ToolbarButton("BLOCK_MEDIA", 108, 2131251180, 2131251180, 0);
        HASH_TAG = new ToolbarButton("HASH_TAG", 109, 2131251729, 2131251729, 2131917329, 2131251730, 2131251730, 0);
        int r4 = j40.g4.a;
        if (j40.g4.a.a() == false) goto L13;
        int r33 = 2131251622;
    L15:
        if (j40.g4.a.a() == false) goto L17;
        int r34 = 2131251622;
    L18:
        VOTE = new ToolbarButton("VOTE", 110, 2131251620, 2131251620, 2131918883, r33, r34, 0);
        if (j40.g4.a.a() == false) goto L21;
        int r42 = 2131251676;
    L23:
        if (j40.g4.a.a() == false) goto L25;
        int r43 = 2131251676;
    L26:
        WISH_LIST = new ToolbarButton("WISH_LIST", 111, 2131251675, 2131251675, 2131918884, r42, r43, 0);
        boolean r5 = tb1.c.a;
        if (r5 == true) goto L29;
    L31:
        int r6 = 2131567877;
    L32:
        if (r5 == true) goto L34;
    L36:
        int r7 = 2131567878;
    L37:
        INTERACT_GAME = new ToolbarButton("INTERACT_GAME", 112, r6, r7);
        INTERACT_PLAY = new ToolbarButton("INTERACT_PLAY", 113, 2131567880, 2131567880);
        INTERACT_PLAY_FOR_GROUP_LIVE_GAME = new ToolbarButton("INTERACT_PLAY_FOR_GROUP_LIVE_GAME", 114, 2131567880, 2131567880);
        COMMERCE = new ToolbarButton("COMMERCE", 115, 2131567857, 2131567859);
        COMMERCE_IM = new ToolbarButton("COMMERCE_IM", 116, 2131567860);
        COMMERCE_MORE = new ToolbarButton("COMMERCE_MORE", 117, 2131567861, 2131567861, 2131922936, 2131922936);
        if (j40.g4.a.a() == false) goto L40;
        int r40 = 2131251580;
    L42:
        if (j40.g4.a.a() == false) goto L44;
        int r41 = 2131251580;
    L45:
        LOTTERY = new ToolbarButton("LOTTERY", 118, 2131251578, 2131251578, 2131920144, r40, r41, 2131920144);
        BROADCAST_EFFECT = new ToolbarButton("BROADCAST_EFFECT", 119, 2131250978, 2131250978, 0, 2131250979, 2131250979, 0);
        DECORATION = new ToolbarButton("DECORATION", 120, 2131252950, 2131252950, 2131918964, 2131250961, 2131250961, 2131915393);
        AUDIO = new ToolbarButton("AUDIO", 121, 2131243757, 2131243757, 2131918852, 2131243757, 2131243757, 2131918852);
        REVERSE_CAMERA = new ToolbarButton("REVERSE_CAMERA", 122, 0, 2131252967, 2131922207, 2131251441, 2131251442, 0);
        STICKER = new ToolbarButton("STICKER", 123, 0, 2131252971, 2131919995, 2131251531, 2131251531, 0);
        STICKER_NEW = new ToolbarButton("STICKER_NEW", 124, 0, 2131252971, 2131919997, 2131251531, 2131251531, 0);
        BEAUTY = new ToolbarButton("BEAUTY", 125, 0, 2131252974, 2131919988, 2131250896, 2131250896, 2131915390);
        AV_ADJUST = new ToolbarButton("AV_ADJUST", 126, 0, 2131250897, 2131915389);
        LIVE_MULTI_CAMERA = new ToolbarButton("LIVE_MULTI_CAMERA", 127, 0, 2131250910, 2131915399);
        LIVE_PICTURE_PRESENTATION = new ToolbarButton("LIVE_PICTURE_PRESENTATION", 128, 0, 2131250912, 2131915400);
        CAMERA_MOVEMENT = new ToolbarButton("CAMERA_MOVEMENT", 129, 0, 2131250962, 2131915391);
        SOUND_EFFECT = new ToolbarButton("SOUND_EFFECT", 130, 0, 2131251519, 2131922629);
        FILTER = new ToolbarButton("FILTER", 131, 0, 2131252975, 2131916639);
        GESTURE_MAGIC = new ToolbarButton("GESTURE_MAGIC", 132, 0, 2131252976, 2131919129, 2131251036, 2131251036, 0);
        REVERSE_MIRROR = new ToolbarButton("REVERSE_MIRROR", 133, 0, 2131252969, 2131922208, 2131251444, 2131251444, 0);
        POI = new ToolbarButton("POI", 134, 0, 2131252977, 2131921609, 2131251347, 2131251348, 0);
        SWITCH_SCREEN_ORIENTATION = new ToolbarButton("SWITCH_SCREEN_ORIENTATION", 135, 2131252973, 2131252972, 2131920007);
        SWITCH_VIDEO_QUALITY = new ToolbarButton("SWITCH_VIDEO_QUALITY", 136, 2131567896);
        LANDSCAPE_MULTI_TAB = new ToolbarButton("LANDSCAPE_MULTI_TAB", 137, 2131567882);
        KEY_ROOM_INFO = new ToolbarButton("KEY_ROOM_INFO", 138, 0, 2131235961, 2131918181);
        PUSH_URL = new ToolbarButton("PUSH_URL", 139, 0, 2131252960, 2131921816);
        BROADCAST_PAUSE = new ToolbarButton("BROADCAST_PAUSE", 140, 2131248928, 2131248928, 2131915359);
        ADD_PICTURE = new ToolbarButton("ADD_PICTURE", 141, 2131250787, 2131250787, 2131915318);
        LIVE_MATRIX = new ToolbarButton("LIVE_MATRIX", 142, 2131251178, 2131251178, 2131919525);
        QUESTION_AND_ANSWER = new ToolbarButton("QUESTION_AND_ANSWER", 143, 2131251379, 2131251379, 2131921822);
        INNER_SMALL_WINDOW_ACTION_BUTTON = new ToolbarButton("INNER_SMALL_WINDOW_ACTION_BUTTON", 144, 0, 2131253056, 2131922551);
        BROADCAST_INFO = new ToolbarButton("BROADCAST_INFO", 145, 2131251702, 2131251702, 2131915334);
        BROADCAST_RESTART = new ToolbarButton("BROADCAST_RESTART", 146, 2131250913, 2131250913, 2131915368);
        FAST_GIFT = new ToolbarButton("FAST_GIFT", 147, 2131567867);
        CASH_EXCHANGE = new ToolbarButton("CASH_EXCHANGE", 148, 2131567856);
        TREASURE_BOX = new ToolbarButton("TREASURE_BOX", 149, 2131567895);
        COUPON_EXCHANGE = new ToolbarButton("COUPON_EXCHANGE", 150, 2131567863);
        GIFT = new ToolbarButton("GIFT", 151, 2131566792);
        QUICK_SCREEN_SHOT = new ToolbarButton("QUICK_SCREEN_SHOT", 152, 2131566796);
        BROADCAST_GIFT = new ToolbarButton("BROADCAST_GIFT", 153, 0, 0, 2131915396, 2131251040, 2131251040, 2131915396);
        INTERACT_GIFT = new ToolbarButton("INTERACT_GIFT", 154, 0, 0, 2131918047, 2131251039, 2131251039, 2131918047);
        LINKMIC_ANNOUNCE = new ToolbarButton("LINKMIC_ANNOUNCE", 155, 0, 0, 2131918679, 2131251140, 2131251140, 2131918679);
        BGM = new ToolbarButton("BGM", 156, 0, 0, 0, 0, 2131253134, 2131922944);
        GIFT_ANIMATION = new ToolbarButton("GIFT_ANIMATION", 157, 2131252953, 2131252953, 0);
        PERMANENT_CHAT_ROOM = new ToolbarButton("PERMANENT_CHAT_ROOM", 158, 0, 0, 0, 0, 2131252439, 2131921327);
        PERMANENT_CHAT_GUEST = new ToolbarButton("PERMANENT_CHAT_GUEST", 159, 0, 0, 0, 0, 2131252439, 2131921328);
        GIFT_EFFECT = new ToolbarButton("GIFT_EFFECT", 160, 2131251042, 2131251042, 2131922937);
        AUDIO_TOGGLE = new ToolbarButton("AUDIO_TOGGLE", 161, 2131251145, 2131251145, 2131920359);
        MESSAGE_PUSH = new ToolbarButton("MESSAGE_PUSH", 162, 2131251218, 2131251218, 2131920335);
        GAME_QUIZ = new ToolbarButton("GAME_QUIZ", 163, 2131252991, 0, 0);
        AUTO_REPLY = new ToolbarButton("AUTO_REPLY", 164, 2131252947, 2131252947, 2131915220);
        DIVIDER = new ToolbarButton("DIVIDER", 165, 2131567524);
        XT_LANDSCAPE_SHARE = new ToolbarButton("XT_LANDSCAPE_SHARE", 166, 2131253472, 2131252970, 2131922489);
        HOUR_RANK = new ToolbarButton("HOUR_RANK", 167, 2131251072, 0, 0);
        AUTO_CAR = new ToolbarButton("AUTO_CAR", 168, 2131565201);
        DOUYIN_CLOSE = new ToolbarButton("DOUYIN_CLOSE", 169, 2131567864);
        PROMOTION_VIDEO = new ToolbarButton("PROMOTION_VIDEO", 170, 2131250986, 2131250986, 2131919188, 2131250987, 2131250987, 2131919188);
        DOU_PLUS_PROMOTE = new ToolbarButton("DOU_PLUS_PROMOTE", 171, 2131250359, 2131250359, 2131916261, 2131250969, 2131250969, 0);
        DOU_PLUS_PROMOTE_AUDIENCE = new ToolbarButton("DOU_PLUS_PROMOTE_AUDIENCE", 172, 2131250969, 2131250969, 2131916262, 2131250969, 2131250969, 0);
        if (n5.d() == false) goto L48;
        int r39 = 2131251431;
    L50:
        if (n5.d() == false) goto L52;
        int r44 = 2131251431;
    L54:
        if (n5.d() == false) goto L56;
        int r45 = 2131251431;
    L58:
        if (n5.d() == false) goto L60;
        int r46 = 2131251431;
    L61:
        REN_QI_BAO = new ToolbarButton("REN_QI_BAO", 173, r39, r44, 2131922066, r45, r46, 2131922066);
        VR_MODE = new ToolbarButton("VR_MODE", 174, 2131566797);
        MULTI_CAMERA = new ToolbarButton("MULTI_CAMERA", 175, 2131566795);
        HOTSOON_PROMOTION = new ToolbarButton("HOTSOON_PROMOTION", 176, 2131251059, 2131251059, 2131921780);
        PROMOTION_CARD = new ToolbarButton("PROMOTION_CARD", 177, 2131252959, 2131252959, 0);
        DOUYIN_OFFICIAL_IMMERSE = new ToolbarButton("DOUYIN_OFFICIAL_IMMERSE", 178, 2131567525);
        DOUYIN_OFFICIAL_QUALITY = new ToolbarButton("DOUYIN_OFFICIAL_QUALITY", 179, 2131567526);
        DOUYIN_OFFICIAL_EFFECT = new ToolbarButton("DOUYIN_OFFICIAL_EFFECT", 180, 2131250364, 2131250364, 0);
        DOUYIN_GAME = new ToolbarButton("DOUYIN_GAME", 181, 2131250902, 2131251725, 2131919059, 2131251023, 2131251023, 0);
        XT_GAMELIVE_INTERACTION = new ToolbarButton("XT_GAMELIVE_INTERACTION", 182, 2131251108, 2131251108, 2131918106);
        BROADCAST_TASK = new ToolbarButton("BROADCAST_TASK", 183, 2131248612, 2131248612, 2131915384, 2131251539, 2131251541, 0);
        COMMENT = new ToolbarButton("COMMENT", 184, 2131250953, 2131250953, 2131915392, 0, 2131250954, 2131915392);
        CHANNEL_COMMENT = new ToolbarButton("CHANNEL_COMMENT", 185, 2131250802, 2131250802, 2131915392, 2131250802, 2131250802, 2131915392);
        SQUARE_COMMENT = new ToolbarButton("SQUARE_COMMENT", 186, 2131250802, 2131250802, 2131915392, 2131250802, 2131250802, 2131915403);
        AUDIO_COMMENT = new ToolbarButton("AUDIO_COMMENT", 187, 2131250858, 2131250858, 2131915388);
        COMMERCE_LIVE_AD = new ToolbarButton("COMMERCE_LIVE_AD", 188, 2131567858);
        TRANSFORM_WIDGET = new ToolbarButton("TRANSFORM_WIDGET", 189, 2131567894, 2131567894);
        TRANSFORM_WIDGET_AUDIENCE_MORE = new ToolbarButton("TRANSFORM_WIDGET_AUDIENCE_MORE", 190, 2131251596, 2131251596, 2131922964);
        TRANSFORM_WIDGET_MORE = new ToolbarButton("TRANSFORM_WIDGET_MORE", 191, 2131251596, 2131251596, 2131922964, 2131251596, 2131251598, 2131922964);
        GAME_EXIT = new ToolbarButton("GAME_EXIT", 192, 2131567527, 2131567527);
        PLAY_SETTING = new ToolbarButton("PLAY_SETTING", 193, 2131251573, 2131251573, 2131921597);
        INTERACT_GAME_EXIT = new ToolbarButton("INTERACT_GAME_EXIT", 194, 2131567527, 2131567527);
        GAME_GUESS = new ToolbarButton("GAME_GUESS", 195, 2131567528, 2131567528);
        OPEN_PLATFORM_LYNX_GAME = new ToolbarButton("OPEN_PLATFORM_LYNX_GAME", 196, 2131567528, 2131567528);
        OPEN_PLATFORM_MINI_APP = new ToolbarButton("OPEN_PLATFORM_MINI_APP", 197, 2131567531, 2131567531);
        OPEN_PLATFORM_MINI_APP_MORE = new ToolbarButton("OPEN_PLATFORM_MINI_APP_MORE", 198, 2131251237, 2131251237, 2131920360, 2131251237, 2131251238, 2131920360);
        OPEN_PLATFORM_MINI_GAME = new ToolbarButton("OPEN_PLATFORM_MINI_GAME", 199, 2131567531, 2131567531);
        OPEN_PLATFORM_GAME = new ToolbarButton("OPEN_PLATFORM_GAME", 200, 2131567530, 2131567530);
        AUDIENCE_RECORD = new ToolbarButton("AUDIENCE_RECORD", 201, 0, 0, 2131915074, 0, 0, 0);
        AIRDROP_GIFT = new ToolbarButton("AIRDROP_GIFT", 202, 2131567852);
        VS_VERTICAL_RESOLUTION = new ToolbarButton("VS_VERTICAL_RESOLUTION", 203, 2131251881, 2131251881, 2131915066);
        AUDIENCE_RESOLUTION = new ToolbarButton("AUDIENCE_RESOLUTION", 204, 2131251857, 2131251857, 2131915066);
        IN_ROOM_RESOLUTION = new ToolbarButton("IN_ROOM_RESOLUTION", 205, 2131251857, 2131251857, 2131915066, 2131251857, 2131251857, 2131915066);
        VOICE_LIVE_THEME = new ToolbarButton("VOICE_LIVE_THEME", 206, 2131253119, 2131253119, 2131915404, 2131253119, 2131253120, 2131915404);
        RECORD_COMBINE = new ToolbarButton("RECORD_COMBINE", 207, 0, 0, 2131922941, 0, 0, 0);
        LIVE_CONTENT = new ToolbarButton("LIVE_CONTENT", 208, 2131251154, 2131251154, 2131922354, 2131251154, 2131251154, 2131922354);
        FNA_GROUP = new ToolbarButton("FNA_GROUP", 209, 2131251561, 2131251561, 2131914878, 0, 2131251559, 2131914878);
        FAN_GROUP_MANAGE = new ToolbarButton("FAN_GROUP_MANAGE", 210, 2131251560, 2131251560, 2131914879);
        ANCHOR_SHOW = new ToolbarButton("ANCHOR_SHOW", 211, 2131250810, 2131250810, 2131922216, 0, 2131250811, 2131922216);
        ROOM_INTRO = new ToolbarButton("ROOM_INTRO", 212, 0, 2131253143, 2131922288);
        ROOM_NOTICE = new ToolbarButton("ROOM_NOTICE", 213, 0, 2131253143, 2131922292);
        ADVANCE_ANNOUNCEMENT = new ToolbarButton("ADVANCE_ANNOUNCEMENT", 214, 0, 2131253129, 2131914538);
        LINKMIC_SETTING = new ToolbarButton("LINKMIC_SETTING", 215, 2131253140, 2131253140, 2131918800, 0, 2131253141, 2131918800);
        LINKMIC_GAME = new ToolbarButton("LINKMIC_GAME", 216, 2131253139, 2131253139, 2131918786);
        VIRTUAL_LIVE = new ToolbarButton("VIRTUAL_LIVE", 217, 2131253147, 2131253147, 2131923203);
        DISLIKE = new ToolbarButton("DISLIKE", 218, 0, 2131253131, 2131916228);
        LITTLE_PLUGIN = new ToolbarButton("LITTLE_PLUGIN", 219, 0, 0, 2131918815);
        LIVE_IM_ENTRANCE = new ToolbarButton("LIVE_IM_ENTRANCE", 220, 2131567871, 2131567871);
        LIVE_IM_ENTRANCE_MORE = new ToolbarButton("LIVE_IM_ENTRANCE_MORE", 221, 2131567871, 2131567871, 2131917397, 2131917397);
        LIKE_FEEDBACK = new ToolbarButton("LIKE_FEEDBACK", 222, 0, 2131253138, 2131916236, ((DislikeConfig) j40.k1.a.getValue()).getFeedbackText());
        STAR_GRAPH = new ToolbarButton("STAR_GRAPH", 223, 0, 2131253144, 2131922942);
        GAME_PROMOTE = new ToolbarButton("GAME_PROMOTE", 224, 2131566106, 2131566106);
        GAME_PROMOTE_MORE = new ToolbarButton("GAME_PROMOTE_MORE", 225, 2131251029, 2131251029, 2131916951, 2131251030, 2131251030, 2131916951);
        GAME_PROMOTE_AUDIENCE = new ToolbarButton("GAME_PROMOTE_AUDIENCE", 226, 2131566108, 2131566107);
        GAME_PROMOTE_AUDIENCE_MORE = new ToolbarButton("GAME_PROMOTE_AUDIENCE_MORE", 227, 2131251029, 2131251031, 2131916951);
        TASK_CENTER = new ToolbarButton("TASK_CENTER", 228, 0, 2131253146, 2131922943);
        TOUTIAO_FLOAT_WINDOW = new ToolbarButton("TOUTIAO_FLOAT_WINDOW", 229, 0, 2131251594, 2131922960);
        GIFT_CONSUMER_TOAST = new ToolbarButton("GIFT_CONSUMER_TOAST", 230, 0, 2131251595, 2131917098);
        VS_GIFT_CONSUMER_TOAST = new ToolbarButton("VS_GIFT_CONSUMER_TOAST", 231, 0, 2131251595, 2131917098);
        ASSEMBLED_SETTING = new ToolbarButton("ASSEMBLED_SETTING", 232, 0, 2131251573, 2131922935);
        PLAY_QUALITY_OPT = new ToolbarButton("PLAY_QUALITY_OPT", 233, 0, 2131251582, 2131922938);
        LIVE_FLOAT_WINDOW_PLAY = new ToolbarButton("LIVE_FLOAT_WINDOW_PLAY", 234, 0, 2131252417, 2131920490);
        GUARD_BOX = new ToolbarButton("GUARD_BOX", 235, 2131248600, 2131248600, 2131914685, 2131248600, 2131248601, 2131914685);
        SHAKE_MATCH_SETTING = new ToolbarButton("SHAKE_MATCH_SETTING", 236, 2131251482, 2131251482, 2131922488);
        AUDIO_SUBTITLE_SETTING = new ToolbarButton("AUDIO_SUBTITLE_SETTING", 237, 2131250863, 2131250863, 2131915142);
        CHAT_CHANNEL_LANDSCAPE = new ToolbarButton("CHAT_CHANNEL_LANDSCAPE", 238, 2131567523);
        SMALL_WINDOW_ACTION_BUTTON = new ToolbarButton("SMALL_WINDOW_ACTION_BUTTON", 239, 0, 2131253056, 2131922551);
        MARKETING_WIDGET_PIN_BUTTON = new ToolbarButton("MARKETING_WIDGET_PIN_BUTTON", 240, 0, 2131251759, 2131920212);
        CAST_SCREEN_MORE_PANEL = new ToolbarButton("CAST_SCREEN_MORE_PANEL", 241, 2131250187, 2131250187, 2131923373);
        CAST_SCREEN_REFRESH = new ToolbarButton("CAST_SCREEN_REFRESH", 242, 2131250186, 2131250186, 2131915602);
        CAST_SCREEN_FEED_BACK = new ToolbarButton("CAST_SCREEN_FEED_BACK", 243, 2131250181, 2131250181, 2131915576);
        SWITCH_VIDEO_QUALITY_MATCH = new ToolbarButton("SWITCH_VIDEO_QUALITY_MATCH", 244, 2131567897);
        TEAM_FIGHT_ADMIN = new ToolbarButton("TEAM_FIGHT_ADMIN", 245, 2131253136, 2131253136, 2131922798, 2131253136, 2131253136, 2131922798);
        GUEST_BATTLE_ADMIN = new ToolbarButton("GUEST_BATTLE_ADMIN", 246, 2131253135, 2131253135, 2131917225, 2131253135, 2131253135, 2131917225);
        ROOM_FIGHT_ADMIN = new ToolbarButton("ROOM_FIGHT_ADMIN", 247, 2131252894, 2131252894, 2131918743, 2131252894, 2131252894, 2131918743);
        RADIO_COVER = new ToolbarButton("RADIO_COVER", 248, 2131251185, 2131251185, 0);
        DUTY_GIFT = new ToolbarButton("DUTY_GIFT", 249, 2131567865);
        AUDIENCE_LANDSCAPE = new ToolbarButton("AUDIENCE_LANDSCAPE", 250, 2131567853);
        DRIVE = new ToolbarButton("DRIVE", 251, 0, 0, 2131916302);
        TURNTABLE_V2 = new ToolbarButton("TURNTABLE_V2", 252, 0, 0, 2131922985);
        BROADCAST_BARRAGE = new ToolbarButton("BROADCAST_BARRAGE", 253, 2131251024, 2131251024, 0);
        REPLAY_CAST_SCREEN_FEED_BACK = new ToolbarButton("REPLAY_CAST_SCREEN_FEED_BACK", 254, 2131232532, 2131232532, 2131915555);
        MATCH_ROOM_MULTI_CAMERA = new ToolbarButton("MATCH_ROOM_MULTI_CAMERA", 255, 2131566894);
        RADIO_INTERACTION_AUDIENCE = new ToolbarButton("RADIO_INTERACTION_AUDIENCE", 256, 2131566788);
        VS_MORE_LIVE_ENTRY = new ToolbarButton("VS_MORE_LIVE_ENTRY", 257, 2131567985);
        INCOME_MORE = new ToolbarButton("INCOME_MORE", 258, 2131567874, 2131567875);
        REVOKE_AUTH = new ToolbarButton("REVOKE_AUTH", 259, 2131251864, 2131251864, 2131922209);
        VS_BARRAGE_KEY_FILTER = new ToolbarButton("VS_BARRAGE_KEY_FILTER", 260, 2131251633, 2131251633, 2131923305);
        VS_CART = new ToolbarButton("VS_CART", 261, 2131567898);
        LIVE_LISTEN = new ToolbarButton("LIVE_LISTEN", 262, 1043, 2131251174, 2131251174, 2131919519, null);
        REPLAY_CAST_SCREEN = new ToolbarButton("REPLAY_CAST_SCREEN", 263, 2131250179, 2131250179, 2131923373);
        com.bytedance.android.livesdk.l1 r8 = com.bytedance.android.livesdk.l1.a;
        if (((Boolean) r8.getValue()).booleanValue() == false) goto L64;
        int r31 = 2131252419;
    L66:
        if (((Boolean) r8.getValue()).booleanValue() == false) goto L68;
        int r32 = 2131252419;
    L70:
        if (((Boolean) r8.getValue()).booleanValue() == false) goto L72;
        int r35 = 2131920486;
    L73:
        COPY_LINK = new ToolbarButton("COPY_LINK", 264, r31, r32, r35);
        QR_CODE = new ToolbarButton("QR_CODE", 265, 2131252422, 2131252422, 2131920491);
        IM_LIST_VIRTUAL = new ToolbarButton("IM_LIST_VIRTUAL", 266, 0, 0, 0);
        DESKTOP_WIDGET_PIN_ANCHOR = new ToolbarButton("DESKTOP_WIDGET_PIN_ANCHOR", 267, 2131251181, 2131251181, 2131919625);
        DESKTOP_WIDGET_UNPIN_ANCHOR = new ToolbarButton("DESKTOP_WIDGET_UNPIN_ANCHOR", 268, 2131251199, 2131251199, 2131920027);
        ATTACK_AND_DEFENSE = new ToolbarButton("ATTACK_AND_DEFENSE", 269, 2131251562, 2131251562, 2131918849);
        RECHARGE_RECORD = new ToolbarButton("RECHARGE_RECORD", 270, 1060, 0, 2131251854, 2131922940, null);
        MESSAGE_BOX = new ToolbarButton("MESSAGE_BOX", 271, 1059, 0, 2131251853, 2131920737, null);
        MERCHANT_QUALIFICATIONS = new ToolbarButton("MERCHANT_QUALIFICATIONS", 272, 1061, 0, 0, 0, 0);
        $VALUES = new ToolbarButton[]{VS_LANDSCAPE_MORE, VS_PORTRAIT_TOP_MORE, VS_PORTRAIT_MORE, VS_SELECT_EPISODE, VS_VIDEO_QUALITY, REPLAY_CHOOSE, VS_FAST_PLAY, VS_ONLY_TA, VS_ONLY_TA_LANDSCAPE, VS_PORTRAIT_LOCK, VS_HIGHLIGHT, VS_TEDIOUS, VS_SCHEDULE_CLOSE, VS_FLOAT_WINDOW, VS_COLLECT, VS_CACHE, VS_VISIBILITY_SETTING, VS_DELETE, VS_CAST_SCREEN, CAST_FEED_BACK, CAST_REFRESH, VS_TOPIC_OPERATION, VS_PORTRAIT_OPERATION, VS_LANDSCAPE_OPERATION, VS_ACTIVITY_ONE, VS_ACTIVITY_TWO, VS_ACTIVITY_THREE, VS_SHARE, VS_SHARE_UNFOLD, VS_BARRAGE_SETTING, VS_RECORD_PORTAIT_DAMAKU_ENABLE, VS_REPORT, VS_INTERACTIVE, VS_MESSAGE_BOARD, MULTI_CAMERA_LINKED_ROOM, MATCH_ROOM_MOMENT, EASTER_EGG, KTV, KTV_GROUP, INTERACTION_AUDIENCE, INTERACTION_ROOM, INTERACTION, INTERACTION_MORE, INTERACTION_SCENE, INTERACTION_ROOM_BATTLE, TEAM_FIGHT, MULTI_SCENE_GAME_PLAY, PK, CLOSE_ROOM, RED_ENVELOPE, MORE, LIVING_DRAINAGE, BARRAGE_SETTING, SHARE, BROADCAST_SHARE, SHARE_TO_DAILY, FollowerShare, WELFARE, WELFARE_FOLD, GROUP_PURCHASE, GROUP_PURCHASE_MORE, GROUP_PURCHASE_AUDIENCE, MANAGE, PROMPT, VIDEO_PLAY, ACTIVITY_ZONE, BROADCAST_ADMIN, FLOW_FEEDBACK, MANAGE_UNFOLD, UNION_LIVE, ANCHOR_CHAT_CHANNEL, STABLE_MODE, MINI_APP, MINI_APP_MORE, LITTLE_GAME, TICKET_SALE, REPLAY_TICKET_SALE, TICKET_SALE_ANCHOR, TICKET_SALE_ANCHOR_MORE, LICENSE_INFO, CLEAR_SCREEN, ROOM_CHANNEL_LANDSCAPE, ROOM_CHANNEL, SCHEDULE_CLOSE, COLLECT, CLEAR_SCREEN_OPTIMIZE_OFF, CLEAR_SCREEN_OPTIMIZE_ON, REPORT, MINOR_REFUND, SWITCH_ACCOUNT, VIP_IM, PREDICTOR_GUESS, RECORD, RECORD_LANDSCAPE, GAME_CAST_SCREEN, CAST_SCREEN, PAD_AND_PC_PLAY, PAD_AND_PC_PLAY_LANDSCAPE, WATCH_LATER, LIVE_WIDGET, ANCHOR_BACKTRACK, PUBLIC_SCREEN_SELECTED_MESSAGE, PUBLIC_SCREEN_AI_HELPER, PUBLIC_SCREEN_CONFIG, AUDIENCE_PUBLIC_SCREEN_CONFIG, BARRAGE, LIVE_PICTURE_TYPE, BLOCK, BLOCK_MEDIA, HASH_TAG, VOTE, WISH_LIST, INTERACT_GAME, INTERACT_PLAY, INTERACT_PLAY_FOR_GROUP_LIVE_GAME, COMMERCE, COMMERCE_IM, COMMERCE_MORE, LOTTERY, BROADCAST_EFFECT, DECORATION, AUDIO, REVERSE_CAMERA, STICKER, STICKER_NEW, BEAUTY, AV_ADJUST, LIVE_MULTI_CAMERA, LIVE_PICTURE_PRESENTATION, CAMERA_MOVEMENT, SOUND_EFFECT, FILTER, GESTURE_MAGIC, REVERSE_MIRROR, POI, SWITCH_SCREEN_ORIENTATION, SWITCH_VIDEO_QUALITY, LANDSCAPE_MULTI_TAB, KEY_ROOM_INFO, PUSH_URL, BROADCAST_PAUSE, ADD_PICTURE, LIVE_MATRIX, QUESTION_AND_ANSWER, INNER_SMALL_WINDOW_ACTION_BUTTON, BROADCAST_INFO, BROADCAST_RESTART, FAST_GIFT, CASH_EXCHANGE, TREASURE_BOX, COUPON_EXCHANGE, GIFT, QUICK_SCREEN_SHOT, BROADCAST_GIFT, INTERACT_GIFT, LINKMIC_ANNOUNCE, BGM, GIFT_ANIMATION, PERMANENT_CHAT_ROOM, PERMANENT_CHAT_GUEST, GIFT_EFFECT, AUDIO_TOGGLE, MESSAGE_PUSH, GAME_QUIZ, AUTO_REPLY, DIVIDER, XT_LANDSCAPE_SHARE, HOUR_RANK, AUTO_CAR, DOUYIN_CLOSE, PROMOTION_VIDEO, DOU_PLUS_PROMOTE, DOU_PLUS_PROMOTE_AUDIENCE, REN_QI_BAO, VR_MODE, MULTI_CAMERA, HOTSOON_PROMOTION, PROMOTION_CARD, DOUYIN_OFFICIAL_IMMERSE, DOUYIN_OFFICIAL_QUALITY, DOUYIN_OFFICIAL_EFFECT, DOUYIN_GAME, XT_GAMELIVE_INTERACTION, BROADCAST_TASK, COMMENT, CHANNEL_COMMENT, SQUARE_COMMENT, AUDIO_COMMENT, COMMERCE_LIVE_AD, TRANSFORM_WIDGET, TRANSFORM_WIDGET_AUDIENCE_MORE, TRANSFORM_WIDGET_MORE, GAME_EXIT, PLAY_SETTING, INTERACT_GAME_EXIT, GAME_GUESS, OPEN_PLATFORM_LYNX_GAME, OPEN_PLATFORM_MINI_APP, OPEN_PLATFORM_MINI_APP_MORE, OPEN_PLATFORM_MINI_GAME, OPEN_PLATFORM_GAME, AUDIENCE_RECORD, AIRDROP_GIFT, VS_VERTICAL_RESOLUTION, AUDIENCE_RESOLUTION, IN_ROOM_RESOLUTION, VOICE_LIVE_THEME, RECORD_COMBINE, LIVE_CONTENT, FNA_GROUP, FAN_GROUP_MANAGE, ANCHOR_SHOW, ROOM_INTRO, ROOM_NOTICE, ADVANCE_ANNOUNCEMENT, LINKMIC_SETTING, LINKMIC_GAME, VIRTUAL_LIVE, DISLIKE, LITTLE_PLUGIN, LIVE_IM_ENTRANCE, LIVE_IM_ENTRANCE_MORE, LIKE_FEEDBACK, STAR_GRAPH, GAME_PROMOTE, GAME_PROMOTE_MORE, GAME_PROMOTE_AUDIENCE, GAME_PROMOTE_AUDIENCE_MORE, TASK_CENTER, TOUTIAO_FLOAT_WINDOW, GIFT_CONSUMER_TOAST, VS_GIFT_CONSUMER_TOAST, ASSEMBLED_SETTING, PLAY_QUALITY_OPT, LIVE_FLOAT_WINDOW_PLAY, GUARD_BOX, SHAKE_MATCH_SETTING, AUDIO_SUBTITLE_SETTING, CHAT_CHANNEL_LANDSCAPE, SMALL_WINDOW_ACTION_BUTTON, MARKETING_WIDGET_PIN_BUTTON, CAST_SCREEN_MORE_PANEL, CAST_SCREEN_REFRESH, CAST_SCREEN_FEED_BACK, SWITCH_VIDEO_QUALITY_MATCH, TEAM_FIGHT_ADMIN, GUEST_BATTLE_ADMIN, ROOM_FIGHT_ADMIN, RADIO_COVER, DUTY_GIFT, AUDIENCE_LANDSCAPE, DRIVE, TURNTABLE_V2, BROADCAST_BARRAGE, REPLAY_CAST_SCREEN_FEED_BACK, MATCH_ROOM_MULTI_CAMERA, RADIO_INTERACTION_AUDIENCE, VS_MORE_LIVE_ENTRY, INCOME_MORE, REVOKE_AUTH, VS_BARRAGE_KEY_FILTER, VS_CART, LIVE_LISTEN, REPLAY_CAST_SCREEN, COPY_LINK, QR_CODE, IM_LIST_VIRTUAL, DESKTOP_WIDGET_PIN_ANCHOR, DESKTOP_WIDGET_UNPIN_ANCHOR, ATTACK_AND_DEFENSE, RECHARGE_RECORD, MESSAGE_BOX, MERCHANT_QUALIFICATIONS};
        ToolbarButton[] r0 = values();
        nameEnumMap = new HashMap(r0.length);
        int r9 = r0.length;
    L74:
        if (r2 >= r9) goto L76;
        ToolbarButton r10 = r0[r2];
        nameEnumMap.put(r10.name(), r10);
        r2 = r2 + 1;
        goto L74
    L76:
        return;
    L72:
        r35 = 2131920487;
        goto L73
    L68:
        r32 = 2131252418;
        goto L70
    L64:
        r31 = 2131252418;
        goto L66
    L60:
        r46 = 2131251430;
        goto L61
    L56:
        r45 = 2131251430;
        goto L58
    L52:
        r44 = 2131251430;
        goto L54
    L48:
        r39 = 2131251430;
        goto L50
    L44:
        r41 = 2131251579;
        goto L45
    L40:
        r40 = 2131251579;
        goto L42
    L34:
        if (tb1.c.c == true) goto L36;
        r7 = 2131567889;
        goto L37
    L29:
        if (tb1.c.c == true) goto L31;
        r6 = 2131567888;
        goto L32
    L25:
        r43 = 2131251675;
        goto L26
    L21:
        r42 = 2131251675;
        goto L23
    L17:
        r34 = 2131251621;
        goto L18
    L13:
        r33 = 2131251621;
        goto L15
    L9:
        r30 = 2131251454;
        goto L10
    L5:
        r22 = 2131250848;
        goto L6
    }

    public int getDrawableFolded() {
        return this.drawableFolded;
    }

    public int getDrawableUnfolded() {
        return this.drawableUnfolded;
    }

    public long getId() {
        return this.serverId;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public String getTitleStr() {
        return this.titleStr;
    }

    public int getTrueBroadcastLayoutId() {
        return this.broadcastLayoutId;
    }

    public k4 getVsToolbarExtendProperty() {
        return this.vsToolbarExtendProperty;
    }

    public boolean isPureText() {
        return this.pureText;
    }

    public boolean useStandardLayout() {
        return this.useStandardLayout;
    }

    public static ToolbarButton fromName(String r1) {
        return nameEnumMap.get(r1);
    }

    public static ExtendedToolbarButton mappingFold(ExtendedToolbarButton r1) {
        ToolbarButton r2 = fromName(r1.f());
        if (r2 == INTERACTION) goto L38;
        if (r2 == INTERACTION_AUDIENCE) goto L38;
        if (r2 != COMMERCE) goto L12;
        return COMMERCE_MORE.extended();
    L12:
        if (r2 != TRANSFORM_WIDGET) goto L16;
        return TRANSFORM_WIDGET_MORE.extended();
    L16:
        if (r2 == GAME_PROMOTE_AUDIENCE) goto L18;
        ToolbarButton r0 = LIVE_IM_ENTRANCE;
        if (r2 == r0) goto L22;
        ToolbarButton r3 = VS_ACTIVITY_ONE;
        if (r2 == r3) goto L26;
        ToolbarButton r4 = ROOM_CHANNEL;
        if (r2 == r4) goto L30;
        ToolbarButton r5 = VS_MESSAGE_BOARD;
        if (r2 == r5) goto L34;
        return null;
    L34:
        return r5.extended();
    L30:
        return r4.extended();
    L26:
        return r3.extended();
    L22:
        return r0.extended();
    L18:
        return GAME_PROMOTE_AUDIENCE_MORE.extended();
    L38:
        return INTERACTION_MORE.extended();
    }

    public static ToolbarButton valueOf(String r1) {
        return (ToolbarButton) r27.a.a(ToolbarButton.class, r1);
    }

    public ToolbarButton originalToolbarButton(ToolbarButton r4) {
        if (r4.name().equals(DOU_PLUS_PROMOTE.name()) == false) goto L6;
        r4.titleId = 2131916261;
        r4.drawableFolded = 2131250359;
        r4.drawableUnfolded = 2131250359;
        r4.broadcastDrawableUnfolded = 2131250969;
        r4.broadcastDrawableFolded = 2131250969;
    L8:
        return r4;
    L6:
        if (r4.name().equals(DOU_PLUS_PROMOTE_AUDIENCE.name()) == false) goto L8;
        r4.titleId = 2131916262;
        r4.drawableFolded = 2131250969;
        r4.drawableUnfolded = 2131250969;
        r4.broadcastDrawableUnfolded = 2131250969;
        r4.broadcastDrawableFolded = 2131250969;
        goto L8
    }

    public void setBroadcastDrawableUnfolded(int r1) {
        this.broadcastDrawableUnfolded = r1;
    }

    public void setBroadcastLayoutId(int r1) {
        this.broadcastLayoutId = r1;
    }

    public void setDrawableFolded(int r1) {
        this.drawableFolded = r1;
    }

    public ToolbarButton setPureText(boolean r1) {
        this.pureText = r1;
        return this;
    }

    public void setServerId(long r1) {
        this.serverId = r1;
        int r2 = (int) r1;
        SparseArray<ToolbarButton> r3 = x2.a;
        Intrinsics.checkNotNullParameter(this, "toolbarButton");
        x2.a.put(r2, this);
    }

    public void setTitleId(int r1) {
        this.titleId = r1;
    }

    private ToolbarButton(String r1, int r2, int r3) {
        super(r1, r2);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.broadcastLayoutId = 2131567861;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        this.layoutId = r3;
    }

    private ToolbarButton(String r1, int r2, long r3, int r5) {
        super(r1, r2);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.broadcastLayoutId = 2131567861;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        this.layoutId = r5;
        setServerId(r3);
    }

    public ToolbarButton dynamicWrapToolbarButton(ToolbarButton r2, int r3, int r4, int r5) {
        r2.titleId = r3;
        if (r2.name().equals(DOU_PLUS_PROMOTE.name()) == false) goto L6;
        r2.drawableFolded = 2131250359;
        r2.drawableUnfolded = 2131250359;
    L8:
        r2.broadcastDrawableUnfolded = r4;
        r2.broadcastDrawableFolded = r5;
        return r2;
    L6:
        if (r2.name().equals(DOU_PLUS_PROMOTE_AUDIENCE.name()) == false) goto L8;
        r2.drawableFolded = r4;
        r2.drawableUnfolded = r4;
        goto L8
    }

    private ToolbarButton(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        this.layoutId = r3;
        this.broadcastLayoutId = r4;
    }

    private ToolbarButton(String r1, int r2, int r3, int r4, k4 r5) {
        super(r1, r2);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.broadcastLayoutId = 2131567861;
        this.pureText = false;
        this.layoutId = r3;
        this.titleId = r4;
        this.vsToolbarExtendProperty = r5;
    }

    private ToolbarButton(String r10, int r11, int r12, int r13, int r14) {
        this(r10, r11, r12, r13, r14, 0, 0, 0);
    }

    private ToolbarButton(String r1, int r2, int r3, int r4, int r5, String r6) {
        super(r1, r2);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.layoutId = 2131567861;
        this.broadcastLayoutId = 2131567861;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        this.drawableUnfolded = r3;
        this.drawableFolded = r4;
        this.titleId = r5;
        this.titleStr = r6;
    }

    private ToolbarButton(String r12, int r13, int r14, int r15, int r16, k4 r17) {
        this(r12, r13, -1, r14, r15, r16, 0, 0, 0);
        this.vsToolbarExtendProperty = r17;
    }

    private ToolbarButton(String r10, int r11, int r12, int r13, int r14, int r15) {
        this(r10, r11, -1, r12, r13, r14, r15);
    }

    private ToolbarButton(String r1, int r2, long r3, int r5, int r6, int r7, int r8) {
        super(r1, r2);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        this.layoutId = r5;
        this.broadcastLayoutId = r6;
        this.titleId = r7;
        this.broadcastTitleId = r8;
        setServerId(r3);
    }

    private ToolbarButton(String r12, int r13, long r14, int r16, int r17, int r18, k4 r19) {
        this(r12, r13, r14, r16, r17, r18, 0, 0, 0);
        this.vsToolbarExtendProperty = r19;
    }

    private ToolbarButton(String r10, int r11, boolean r12, long r13, int r15, int r16, int r17) {
        this(r10, r11, r15, r16, r17, 0, 0, 0);
        this.useStandardLayout = r12;
    }

    private ToolbarButton(String r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        this(r12, r13, -1, r14, r15, r16, r17, r18, r19);
    }

    private ToolbarButton(String r1, int r2, long r3, int r5, int r6, int r7, int r8, int r9, int r10) {
        super(r1, r2);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.layoutId = 2131567861;
        this.broadcastLayoutId = 2131567861;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        setServerId(r3);
        this.drawableUnfolded = r5;
        this.drawableFolded = r6;
        this.titleId = r7;
        this.broadcastDrawableUnfolded = r8;
        this.broadcastDrawableFolded = r9;
        this.broadcastTitleId = r10;
    }

    private ToolbarButton(String r1, int r2, boolean r3, long r4, int r6, int r7, int r8, int r9, int r10, int r11) {
        super(r1, r2);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.layoutId = 2131567861;
        this.broadcastLayoutId = 2131567861;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        setServerId(r4);
        this.useStandardLayout = r3;
        this.drawableUnfolded = r6;
        this.drawableFolded = r7;
        this.titleId = r8;
        this.broadcastDrawableUnfolded = r9;
        this.broadcastDrawableFolded = r10;
        this.broadcastTitleId = r11;
    }
}
