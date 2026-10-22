package com.bytedance.android.live.revenue.platform.container.impl.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/NotifyRoomStateRequestState;", "", "", "tag", "I", "getTag", "()I", "UNKNOWN", "ENTERED", "COMPONENTS_LOADED", "PRE_ENTERED", "LEFT", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum NotifyRoomStateRequestState extends Enum<NotifyRoomStateRequestState> {
    public static final NotifyRoomStateRequestState COMPONENTS_LOADED = null;
    public static final NotifyRoomStateRequestState ENTERED = null;
    public static final NotifyRoomStateRequestState LEFT = null;
    public static final NotifyRoomStateRequestState PRE_ENTERED = null;
    public static final NotifyRoomStateRequestState UNKNOWN = null;
    public static final /* synthetic */ NotifyRoomStateRequestState[] a = null;
    private final int tag;

    static {
        NotifyRoomStateRequestState r1 = new NotifyRoomStateRequestState("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        NotifyRoomStateRequestState r2 = new NotifyRoomStateRequestState("ENTERED", 1, 1);
        ENTERED = r2;
        NotifyRoomStateRequestState r3 = new NotifyRoomStateRequestState("COMPONENTS_LOADED", 2, 3);
        COMPONENTS_LOADED = r3;
        NotifyRoomStateRequestState r4 = new NotifyRoomStateRequestState("PRE_ENTERED", 3, 4);
        PRE_ENTERED = r4;
        NotifyRoomStateRequestState r5 = new NotifyRoomStateRequestState("LEFT", 4, 20);
        LEFT = r5;
        a = new NotifyRoomStateRequestState[]{r1, r2, r3, r4, r5};
    }

    public static NotifyRoomStateRequestState valueOf(String r1) {
        return (NotifyRoomStateRequestState) r27.a.a(NotifyRoomStateRequestState.class, r1);
    }

    public static NotifyRoomStateRequestState[] values() {
        return (NotifyRoomStateRequestState[]) a.clone();
    }

    public final int getTag() {
        return this.tag;
    }

    public NotifyRoomStateRequestState(String r1, int r2, int r3) {
        super(r1, r2);
        this.tag = r3;
    }
}
