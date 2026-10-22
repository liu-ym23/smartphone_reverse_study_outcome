package com.bytedance.android.live.broadcast.api.framework.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/AnchorRoomStatus;", "", "", "value", "I", "getValue", "()I", "Streaming", "Pause", "PauseByVoluntary", "Stop", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnchorRoomStatus extends Enum<AnchorRoomStatus> {
    public static final AnchorRoomStatus Pause = null;
    public static final AnchorRoomStatus PauseByVoluntary = null;
    public static final AnchorRoomStatus Stop = null;
    public static final AnchorRoomStatus Streaming = null;
    public static final /* synthetic */ AnchorRoomStatus[] a = null;
    private final int value;

    static {
        AnchorRoomStatus r1 = new AnchorRoomStatus("Streaming", 0, 0);
        Streaming = r1;
        AnchorRoomStatus r2 = new AnchorRoomStatus("Pause", 1, 1);
        Pause = r2;
        AnchorRoomStatus r3 = new AnchorRoomStatus("PauseByVoluntary", 2, 2);
        PauseByVoluntary = r3;
        AnchorRoomStatus r4 = new AnchorRoomStatus("Stop", 3, 3);
        Stop = r4;
        a = new AnchorRoomStatus[]{r1, r2, r3, r4};
    }

    public static AnchorRoomStatus valueOf(String r1) {
        return (AnchorRoomStatus) r27.a.a(AnchorRoomStatus.class, r1);
    }

    public static AnchorRoomStatus[] values() {
        return (AnchorRoomStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AnchorRoomStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
