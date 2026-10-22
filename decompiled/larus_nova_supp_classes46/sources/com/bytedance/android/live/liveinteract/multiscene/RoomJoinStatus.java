package com.bytedance.android.live.liveinteract.multiscene;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/RoomJoinStatus;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "UNKNOWN", "ROOM_BATTLE_MATCHING", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RoomJoinStatus extends Enum<RoomJoinStatus> {
    public static final a Companion = null;
    public static final RoomJoinStatus ROOM_BATTLE_MATCHING = null;
    public static final RoomJoinStatus UNKNOWN = null;
    public static final /* synthetic */ RoomJoinStatus[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.liveinteract.multiscene.RoomJoinStatus$a] */
    static {
        RoomJoinStatus r1 = new RoomJoinStatus("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        RoomJoinStatus r2 = new RoomJoinStatus("ROOM_BATTLE_MATCHING", 1, 1);
        ROOM_BATTLE_MATCHING = r2;
        a = new RoomJoinStatus[]{r1, r2};
        Companion = new a();
    }

    public static RoomJoinStatus valueOf(String r1) {
        return (RoomJoinStatus) r27.a.a(RoomJoinStatus.class, r1);
    }

    public static RoomJoinStatus[] values() {
        return (RoomJoinStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RoomJoinStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
