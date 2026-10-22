package com.bytedance.android.live.broadcastgame.api.xplay;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/xplay/LittleWindowPos;", "", "", "id", "I", "getId", "()I", "TOP", "LEFT", "RIGHT", "RIGHT_BOTTOM", "CUSTOM", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LittleWindowPos extends Enum<LittleWindowPos> {
    public static final LittleWindowPos CUSTOM = null;
    public static final LittleWindowPos LEFT = null;
    public static final LittleWindowPos RIGHT = null;
    public static final LittleWindowPos RIGHT_BOTTOM = null;
    public static final LittleWindowPos TOP = null;
    public static final /* synthetic */ LittleWindowPos[] a = null;
    private final int id;

    static {
        LittleWindowPos r2 = new LittleWindowPos("TOP", 0, 1);
        TOP = r2;
        LittleWindowPos r3 = new LittleWindowPos("LEFT", 1, 2);
        LEFT = r3;
        LittleWindowPos r4 = new LittleWindowPos("RIGHT", 2, 3);
        RIGHT = r4;
        LittleWindowPos r5 = new LittleWindowPos("RIGHT_BOTTOM", 3, 4);
        RIGHT_BOTTOM = r5;
        LittleWindowPos r6 = new LittleWindowPos("CUSTOM", 4, 5);
        CUSTOM = r6;
        a = new LittleWindowPos[]{r2, r3, r4, r5, r6};
    }

    public static LittleWindowPos valueOf(String r1) {
        return (LittleWindowPos) r27.a.a(LittleWindowPos.class, r1);
    }

    public static LittleWindowPos[] values() {
        return (LittleWindowPos[]) a.clone();
    }

    public final int getId() {
        return this.id;
    }

    public LittleWindowPos(String r1, int r2, int r3) {
        super(r1, r2);
        this.id = r3;
    }
}
