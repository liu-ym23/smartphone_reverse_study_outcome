package com.bytedance.android.livesdk.chatroom.vs_base.base.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/model/ReplayRoomState;", "", "IDLE", "INITIALIZED", "PREPARING", "PREPARING_WITH_PRE_SHOW", "PREPARED", "VIDEO_STARTED", "VIDEO_FINISHED", "DETACHED", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayRoomState extends Enum<ReplayRoomState> {
    public static final ReplayRoomState DETACHED = null;
    public static final ReplayRoomState IDLE = null;
    public static final ReplayRoomState INITIALIZED = null;
    public static final ReplayRoomState PREPARED = null;
    public static final ReplayRoomState PREPARING = null;
    public static final ReplayRoomState PREPARING_WITH_PRE_SHOW = null;
    public static final ReplayRoomState VIDEO_FINISHED = null;
    public static final ReplayRoomState VIDEO_STARTED = null;
    public static final /* synthetic */ ReplayRoomState[] a = null;

    static {
        ReplayRoomState r1 = new ReplayRoomState("IDLE", 0);
        IDLE = r1;
        ReplayRoomState r2 = new ReplayRoomState("INITIALIZED", 1);
        INITIALIZED = r2;
        ReplayRoomState r3 = new ReplayRoomState("PREPARING", 2);
        PREPARING = r3;
        ReplayRoomState r4 = new ReplayRoomState("PREPARING_WITH_PRE_SHOW", 3);
        PREPARING_WITH_PRE_SHOW = r4;
        ReplayRoomState r5 = new ReplayRoomState("PREPARED", 4);
        PREPARED = r5;
        ReplayRoomState r6 = new ReplayRoomState("VIDEO_STARTED", 5);
        VIDEO_STARTED = r6;
        ReplayRoomState r7 = new ReplayRoomState("VIDEO_FINISHED", 6);
        VIDEO_FINISHED = r7;
        ReplayRoomState r8 = new ReplayRoomState("DETACHED", 7);
        DETACHED = r8;
        a = new ReplayRoomState[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public static ReplayRoomState valueOf(String r1) {
        return (ReplayRoomState) a.a(ReplayRoomState.class, r1);
    }

    public static ReplayRoomState[] values() {
        return (ReplayRoomState[]) a.clone();
    }

    public ReplayRoomState(String r1, int r2) {
        super(r1, r2);
    }
}
