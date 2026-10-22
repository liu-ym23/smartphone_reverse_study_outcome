package com.bytedance.android.live.platformplayer.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/platformplayer/model/LivePanelType;", "", "", "identifier", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "UN_KNOW", "AUDIENCE_LIST", "HOUR_RANK_LIST", "TOOL_BAR_MORE", "GIFT", "PERSONAL_PROFILE", "INPUT", "SHOPPING_CAT", "SHOPPING_CARD", "SHOPPING_RANK_LIST", "OLD_LONG_PRESS", "RECOGNITION_CONTAINER", "LOCAL_LIFE_LIST", "GAME_DETAIL", "LOTTERY", "PREDICTOR", "WINDMILL", "platform-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePanelType extends Enum<LivePanelType> {
    public static final LivePanelType AUDIENCE_LIST = null;
    public static final LivePanelType GAME_DETAIL = null;
    public static final LivePanelType GIFT = null;
    public static final LivePanelType HOUR_RANK_LIST = null;
    public static final LivePanelType INPUT = null;
    public static final LivePanelType LOCAL_LIFE_LIST = null;
    public static final LivePanelType LOTTERY = null;
    public static final LivePanelType OLD_LONG_PRESS = null;
    public static final LivePanelType PERSONAL_PROFILE = null;
    public static final LivePanelType PREDICTOR = null;
    public static final LivePanelType RECOGNITION_CONTAINER = null;
    public static final LivePanelType SHOPPING_CARD = null;
    public static final LivePanelType SHOPPING_CAT = null;
    public static final LivePanelType SHOPPING_RANK_LIST = null;
    public static final LivePanelType TOOL_BAR_MORE = null;
    public static final LivePanelType UN_KNOW = null;
    public static final LivePanelType WINDMILL = null;
    public static final /* synthetic */ LivePanelType[] a = null;
    private final String identifier;

    public static LivePanelType valueOf(String r1) {
        return (LivePanelType) a.a(LivePanelType.class, r1);
    }

    public static LivePanelType[] values() {
        return (LivePanelType[]) a.clone();
    }

    static {
        LivePanelType r1 = new LivePanelType("UN_KNOW", 0, "un_know");
        UN_KNOW = r1;
        LivePanelType r2 = new LivePanelType("AUDIENCE_LIST", 1, "audience_list");
        AUDIENCE_LIST = r2;
        LivePanelType r3 = new LivePanelType("HOUR_RANK_LIST", 2, "hour_ranklist");
        HOUR_RANK_LIST = r3;
        LivePanelType r4 = new LivePanelType("TOOL_BAR_MORE", 3, "live_more_tools_panel");
        TOOL_BAR_MORE = r4;
        LivePanelType r5 = new LivePanelType("GIFT", 4, "live_send_gift_panel");
        GIFT = r5;
        LivePanelType r6 = new LivePanelType("PERSONAL_PROFILE", 5, "live_user_card_panel");
        PERSONAL_PROFILE = r6;
        LivePanelType r7 = new LivePanelType("INPUT", 6, "live_comment_board");
        INPUT = r7;
        LivePanelType r8 = new LivePanelType("SHOPPING_CAT", 7, "live_goods_list");
        SHOPPING_CAT = r8;
        LivePanelType r9 = new LivePanelType("SHOPPING_CARD", 8, "live_explain_card");
        SHOPPING_CARD = r9;
        LivePanelType r10 = new LivePanelType("SHOPPING_RANK_LIST", 9, "shopping_rank_list");
        SHOPPING_RANK_LIST = r10;
        LivePanelType r11 = new LivePanelType("OLD_LONG_PRESS", 10, "long_press");
        OLD_LONG_PRESS = r11;
        LivePanelType r12 = new LivePanelType("RECOGNITION_CONTAINER", 11, "live_recognition_container");
        RECOGNITION_CONTAINER = r12;
        LivePanelType r13 = new LivePanelType("LOCAL_LIFE_LIST", 12, "local_life_list");
        LOCAL_LIFE_LIST = r13;
        LivePanelType r14 = new LivePanelType("GAME_DETAIL", 13, "game_detail");
        GAME_DETAIL = r14;
        LivePanelType r15 = new LivePanelType("LOTTERY", 14, "lottery");
        LOTTERY = r15;
        LivePanelType r16 = new LivePanelType("PREDICTOR", 15, "predictor");
        PREDICTOR = r16;
        LivePanelType r17 = new LivePanelType("WINDMILL", 16, "windmill");
        WINDMILL = r17;
        a = new LivePanelType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public LivePanelType(String r1, int r2, String r3) {
        super(r1, r2);
        this.identifier = r3;
    }
}
