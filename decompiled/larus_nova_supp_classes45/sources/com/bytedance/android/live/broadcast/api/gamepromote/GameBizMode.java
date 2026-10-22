package com.bytedance.android.live.broadcast.api.gamepromote;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/gamepromote/GameBizMode;", "", "", "mode", "J", "getMode", "()J", "Companion", "a", "CPS", "CPA", "SALARY", "POI", "CPC", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameBizMode extends Enum<GameBizMode> {
    public static final GameBizMode CPA = null;
    public static final GameBizMode CPC = null;
    public static final GameBizMode CPS = null;
    public static final a Companion = null;
    public static final GameBizMode POI = null;
    public static final GameBizMode SALARY = null;
    public static final /* synthetic */ GameBizMode[] a = null;
    private final long mode;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.broadcast.api.gamepromote.GameBizMode$a] */
    static {
        GameBizMode r1 = new GameBizMode("CPS", 0, 0);
        CPS = r1;
        GameBizMode r2 = new GameBizMode("CPA", 1, 1);
        CPA = r2;
        GameBizMode r3 = new GameBizMode("SALARY", 2, 2);
        SALARY = r3;
        GameBizMode r4 = new GameBizMode("POI", 3, 3);
        POI = r4;
        GameBizMode r5 = new GameBizMode("CPC", 4, 4);
        CPC = r5;
        a = new GameBizMode[]{r1, r2, r3, r4, r5};
        Companion = new a();
    }

    public static GameBizMode valueOf(String r1) {
        return (GameBizMode) r27.a.a(GameBizMode.class, r1);
    }

    public static GameBizMode[] values() {
        return (GameBizMode[]) a.clone();
    }

    public final long getMode() {
        return this.mode;
    }

    public GameBizMode(String r1, int r2, long r3) {
        super(r1, r2);
        this.mode = r3;
    }
}
