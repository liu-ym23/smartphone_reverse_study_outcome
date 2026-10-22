package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/layer/interactivesong/RequestSongGoldMicrophoneState;", "", "", "value", "I", "getValue", "()I", "HIDDEN", "NOSING", "SINGING", "DIGITAL", "PLUS_ANIM", "START_ANIM", "SHOW_ANCHOR", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RequestSongGoldMicrophoneState extends Enum<RequestSongGoldMicrophoneState> {
    public static final RequestSongGoldMicrophoneState DIGITAL = null;
    public static final RequestSongGoldMicrophoneState HIDDEN = null;
    public static final RequestSongGoldMicrophoneState NOSING = null;
    public static final RequestSongGoldMicrophoneState PLUS_ANIM = null;
    public static final RequestSongGoldMicrophoneState SHOW_ANCHOR = null;
    public static final RequestSongGoldMicrophoneState SINGING = null;
    public static final RequestSongGoldMicrophoneState START_ANIM = null;
    public static final /* synthetic */ RequestSongGoldMicrophoneState[] a = null;
    private final int value;

    static {
        RequestSongGoldMicrophoneState r1 = new RequestSongGoldMicrophoneState("HIDDEN", 0, -1);
        HIDDEN = r1;
        RequestSongGoldMicrophoneState r2 = new RequestSongGoldMicrophoneState("NOSING", 1, 0);
        NOSING = r2;
        RequestSongGoldMicrophoneState r3 = new RequestSongGoldMicrophoneState("SINGING", 2, 1);
        SINGING = r3;
        RequestSongGoldMicrophoneState r4 = new RequestSongGoldMicrophoneState("DIGITAL", 3, 2);
        DIGITAL = r4;
        RequestSongGoldMicrophoneState r5 = new RequestSongGoldMicrophoneState("PLUS_ANIM", 4, 3);
        PLUS_ANIM = r5;
        RequestSongGoldMicrophoneState r6 = new RequestSongGoldMicrophoneState("START_ANIM", 5, 4);
        START_ANIM = r6;
        RequestSongGoldMicrophoneState r7 = new RequestSongGoldMicrophoneState("SHOW_ANCHOR", 6, 5);
        SHOW_ANCHOR = r7;
        a = new RequestSongGoldMicrophoneState[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static RequestSongGoldMicrophoneState valueOf(String r1) {
        return (RequestSongGoldMicrophoneState) r27.a.a(RequestSongGoldMicrophoneState.class, r1);
    }

    public static RequestSongGoldMicrophoneState[] values() {
        return (RequestSongGoldMicrophoneState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RequestSongGoldMicrophoneState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
