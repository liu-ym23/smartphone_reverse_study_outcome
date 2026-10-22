package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/sonicgame/GameCastStrategy;", "", "NONE", "VIDEO_SINGLE", "VIDEO_CHATROOM", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameCastStrategy extends Enum<GameCastStrategy> {
    public static final GameCastStrategy NONE = null;
    public static final GameCastStrategy VIDEO_CHATROOM = null;
    public static final GameCastStrategy VIDEO_SINGLE = null;
    public static final /* synthetic */ GameCastStrategy[] a = null;

    static {
        GameCastStrategy r1 = new GameCastStrategy("NONE", 0);
        NONE = r1;
        GameCastStrategy r2 = new GameCastStrategy("VIDEO_SINGLE", 1);
        VIDEO_SINGLE = r2;
        GameCastStrategy r3 = new GameCastStrategy("VIDEO_CHATROOM", 2);
        VIDEO_CHATROOM = r3;
        a = new GameCastStrategy[]{r1, r2, r3};
    }

    public static GameCastStrategy valueOf(String r1) {
        return (GameCastStrategy) r27.a.a(GameCastStrategy.class, r1);
    }

    public static GameCastStrategy[] values() {
        return (GameCastStrategy[]) a.clone();
    }

    public GameCastStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
