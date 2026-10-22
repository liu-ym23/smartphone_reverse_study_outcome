package com.bytedance.android.live.broadcast.api.gamepromote;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/gamepromote/GameStageType;", "", "", "type", "I", "getType", "()I", "Companion", "a", "NONE", "RESERVATION", "TEST", "DOWNLOAD", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameStageType extends Enum<GameStageType> {
    public static final a Companion = null;
    public static final GameStageType DOWNLOAD = null;
    public static final GameStageType NONE = null;
    public static final GameStageType RESERVATION = null;
    public static final GameStageType TEST = null;
    public static final /* synthetic */ GameStageType[] a = null;
    private final int type;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.broadcast.api.gamepromote.GameStageType$a] */
    static {
        GameStageType r1 = new GameStageType("NONE", 0, 0);
        NONE = r1;
        GameStageType r2 = new GameStageType("RESERVATION", 1, 10);
        RESERVATION = r2;
        GameStageType r3 = new GameStageType("TEST", 2, 20);
        TEST = r3;
        GameStageType r4 = new GameStageType("DOWNLOAD", 3, 30);
        DOWNLOAD = r4;
        a = new GameStageType[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static GameStageType valueOf(String r1) {
        return (GameStageType) r27.a.a(GameStageType.class, r1);
    }

    public static GameStageType[] values() {
        return (GameStageType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public GameStageType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
