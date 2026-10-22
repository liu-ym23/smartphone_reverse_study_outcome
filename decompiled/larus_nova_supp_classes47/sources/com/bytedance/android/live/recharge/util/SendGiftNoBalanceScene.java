package com.bytedance.android.live.recharge.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/recharge/util/SendGiftNoBalanceScene;", "", "", "sceneName", "Ljava/lang/String;", "getSceneName", "()Ljava/lang/String;", "FANS_CLUB_LIGHT_BOARD", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SendGiftNoBalanceScene extends Enum<SendGiftNoBalanceScene> {
    public static final SendGiftNoBalanceScene FANS_CLUB_LIGHT_BOARD = null;
    public static final /* synthetic */ SendGiftNoBalanceScene[] a = null;
    private final String sceneName;

    static {
        SendGiftNoBalanceScene r1 = new SendGiftNoBalanceScene();
        FANS_CLUB_LIGHT_BOARD = r1;
        a = new SendGiftNoBalanceScene[]{r1};
    }

    public static SendGiftNoBalanceScene valueOf(String r1) {
        return (SendGiftNoBalanceScene) r27.a.a(SendGiftNoBalanceScene.class, r1);
    }

    public static SendGiftNoBalanceScene[] values() {
        return (SendGiftNoBalanceScene[]) a.clone();
    }

    public SendGiftNoBalanceScene() {
        super("FANS_CLUB_LIGHT_BOARD", 0);
        this.sceneName = "fansclub_panel_light_board";
    }

    public final String getSceneName() {
        return this.sceneName;
    }
}
