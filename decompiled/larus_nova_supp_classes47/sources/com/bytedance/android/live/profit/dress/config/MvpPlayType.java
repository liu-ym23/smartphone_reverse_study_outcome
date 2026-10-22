package com.bytedance.android.live.profit.dress.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/MvpPlayType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "Unknown", "GroupBattle", "RoomBattle", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MvpPlayType extends Enum<MvpPlayType> {
    public static final a Companion = null;
    public static final MvpPlayType GroupBattle = null;
    public static final MvpPlayType RoomBattle = null;
    public static final MvpPlayType Unknown = null;
    public static final /* synthetic */ MvpPlayType[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.profit.dress.config.MvpPlayType$a] */
    static {
        MvpPlayType r1 = new MvpPlayType("Unknown", 0, -1);
        Unknown = r1;
        MvpPlayType r2 = new MvpPlayType("GroupBattle", 1, 0);
        GroupBattle = r2;
        MvpPlayType r3 = new MvpPlayType("RoomBattle", 2, 1);
        RoomBattle = r3;
        a = new MvpPlayType[]{r1, r2, r3};
        Companion = new a();
    }

    public static MvpPlayType valueOf(String r1) {
        return (MvpPlayType) r27.a.a(MvpPlayType.class, r1);
    }

    public static MvpPlayType[] values() {
        return (MvpPlayType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MvpPlayType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
