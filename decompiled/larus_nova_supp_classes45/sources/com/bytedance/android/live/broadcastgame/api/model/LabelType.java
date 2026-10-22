package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/LabelType;", "", "", "id", "I", "getId", "()I", "TASK", "GAME_TYPE", "GAME_VALUE", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LabelType extends Enum<LabelType> {
    public static final LabelType GAME_TYPE = null;
    public static final LabelType GAME_VALUE = null;
    public static final LabelType TASK = null;
    public static final /* synthetic */ LabelType[] a = null;
    private final int id;

    static {
        LabelType r2 = new LabelType("TASK", 0, 1);
        TASK = r2;
        LabelType r3 = new LabelType("GAME_TYPE", 1, 2);
        GAME_TYPE = r3;
        LabelType r4 = new LabelType("GAME_VALUE", 2, 3);
        GAME_VALUE = r4;
        a = new LabelType[]{r2, r3, r4};
    }

    public static LabelType valueOf(String r1) {
        return (LabelType) r27.a.a(LabelType.class, r1);
    }

    public static LabelType[] values() {
        return (LabelType[]) a.clone();
    }

    public final int getId() {
        return this.id;
    }

    public LabelType(String r1, int r2, int r3) {
        super(r1, r2);
        this.id = r3;
    }
}
