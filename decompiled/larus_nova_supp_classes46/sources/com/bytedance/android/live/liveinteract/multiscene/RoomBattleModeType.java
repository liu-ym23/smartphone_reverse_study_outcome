package com.bytedance.android.live.liveinteract.multiscene;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleModeType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "UNKNOWN", "THEME_BATTLE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RoomBattleModeType extends Enum<RoomBattleModeType> {
    public static final a Companion = null;
    public static final RoomBattleModeType THEME_BATTLE = null;
    public static final RoomBattleModeType UNKNOWN = null;
    public static final /* synthetic */ RoomBattleModeType[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.liveinteract.multiscene.RoomBattleModeType$a] */
    static {
        RoomBattleModeType r1 = new RoomBattleModeType("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        RoomBattleModeType r2 = new RoomBattleModeType("THEME_BATTLE", 1, 1);
        THEME_BATTLE = r2;
        a = new RoomBattleModeType[]{r1, r2};
        Companion = new a();
    }

    public static RoomBattleModeType valueOf(String r1) {
        return (RoomBattleModeType) r27.a.a(RoomBattleModeType.class, r1);
    }

    public static RoomBattleModeType[] values() {
        return (RoomBattleModeType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RoomBattleModeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
