package com.bytedance.android.live.broadcast.api.framework.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/LiveRoomStateUpdateIntent;", "", "", "value", "I", "getValue", "()I", "START", "PAUSE", "RESUME", "STOP", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveRoomStateUpdateIntent extends Enum<LiveRoomStateUpdateIntent> {
    public static final LiveRoomStateUpdateIntent PAUSE = null;
    public static final LiveRoomStateUpdateIntent RESUME = null;
    public static final LiveRoomStateUpdateIntent START = null;
    public static final LiveRoomStateUpdateIntent STOP = null;
    public static final /* synthetic */ LiveRoomStateUpdateIntent[] a = null;
    private final int value;

    static {
        LiveRoomStateUpdateIntent r1 = new LiveRoomStateUpdateIntent("START", 0, 0);
        START = r1;
        LiveRoomStateUpdateIntent r2 = new LiveRoomStateUpdateIntent("PAUSE", 1, 1);
        PAUSE = r2;
        LiveRoomStateUpdateIntent r3 = new LiveRoomStateUpdateIntent("RESUME", 2, 2);
        RESUME = r3;
        LiveRoomStateUpdateIntent r4 = new LiveRoomStateUpdateIntent("STOP", 3, 3);
        STOP = r4;
        a = new LiveRoomStateUpdateIntent[]{r1, r2, r3, r4};
    }

    public static LiveRoomStateUpdateIntent valueOf(String r1) {
        return (LiveRoomStateUpdateIntent) r27.a.a(LiveRoomStateUpdateIntent.class, r1);
    }

    public static LiveRoomStateUpdateIntent[] values() {
        return (LiveRoomStateUpdateIntent[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveRoomStateUpdateIntent(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
