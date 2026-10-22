package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/GameType;", "", "", "value", "I", "getValue", "()I", "EffectGame", "WMiniGame", "WGameX", "CloudGame", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameType extends Enum<GameType> {
    public static final GameType CloudGame = null;
    public static final GameType EffectGame = null;
    public static final GameType WGameX = null;
    public static final GameType WMiniGame = null;
    public static final /* synthetic */ GameType[] a = null;
    private final int value;

    static {
        GameType r2 = new GameType("EffectGame", 0, 1);
        EffectGame = r2;
        GameType r3 = new GameType("WMiniGame", 1, 2);
        WMiniGame = r3;
        GameType r4 = new GameType("WGameX", 2, 3);
        WGameX = r4;
        GameType r5 = new GameType("CloudGame", 3, 4);
        CloudGame = r5;
        a = new GameType[]{r2, r3, r4, r5};
    }

    public static GameType valueOf(String r1) {
        return (GameType) r27.a.a(GameType.class, r1);
    }

    public static GameType[] values() {
        return (GameType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public GameType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
