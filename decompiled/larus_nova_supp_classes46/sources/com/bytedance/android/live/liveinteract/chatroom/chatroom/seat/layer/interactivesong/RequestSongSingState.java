package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/layer/interactivesong/RequestSongSingState;", "", "", "value", "I", "getValue", "()I", "STATE_NOSING", "STATE_SINGING", "STATE_START_SING", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RequestSongSingState extends Enum<RequestSongSingState> {
    public static final RequestSongSingState STATE_NOSING = null;
    public static final RequestSongSingState STATE_SINGING = null;
    public static final RequestSongSingState STATE_START_SING = null;
    public static final /* synthetic */ RequestSongSingState[] a = null;
    private final int value;

    static {
        RequestSongSingState r1 = new RequestSongSingState("STATE_NOSING", 0, 0);
        STATE_NOSING = r1;
        RequestSongSingState r2 = new RequestSongSingState("STATE_SINGING", 1, 1);
        STATE_SINGING = r2;
        RequestSongSingState r3 = new RequestSongSingState("STATE_START_SING", 2, 2);
        STATE_START_SING = r3;
        a = new RequestSongSingState[]{r1, r2, r3};
    }

    public static RequestSongSingState valueOf(String r1) {
        return (RequestSongSingState) r27.a.a(RequestSongSingState.class, r1);
    }

    public static RequestSongSingState[] values() {
        return (RequestSongSingState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RequestSongSingState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
