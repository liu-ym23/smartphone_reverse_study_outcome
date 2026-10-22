package com.bytedance.android.live.room.discovery.drawer.processor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/discovery/drawer/processor/LiveEntranceStatus;", "", "NOT_DISPLAYED", "DISPLAYING", "DISPLAY_COMPLETED", "DISPLAY_ERROR", "DISPLAY_POST_INTERCEPT", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveEntranceStatus extends Enum<LiveEntranceStatus> {
    public static final LiveEntranceStatus DISPLAYING = null;
    public static final LiveEntranceStatus DISPLAY_COMPLETED = null;
    public static final LiveEntranceStatus DISPLAY_ERROR = null;
    public static final LiveEntranceStatus DISPLAY_POST_INTERCEPT = null;
    public static final LiveEntranceStatus NOT_DISPLAYED = null;
    public static final /* synthetic */ LiveEntranceStatus[] a = null;

    static {
        LiveEntranceStatus r1 = new LiveEntranceStatus("NOT_DISPLAYED", 0);
        NOT_DISPLAYED = r1;
        LiveEntranceStatus r2 = new LiveEntranceStatus("DISPLAYING", 1);
        DISPLAYING = r2;
        LiveEntranceStatus r3 = new LiveEntranceStatus("DISPLAY_COMPLETED", 2);
        DISPLAY_COMPLETED = r3;
        LiveEntranceStatus r4 = new LiveEntranceStatus("DISPLAY_ERROR", 3);
        DISPLAY_ERROR = r4;
        LiveEntranceStatus r5 = new LiveEntranceStatus("DISPLAY_POST_INTERCEPT", 4);
        DISPLAY_POST_INTERCEPT = r5;
        a = new LiveEntranceStatus[]{r1, r2, r3, r4, r5};
    }

    public static LiveEntranceStatus valueOf(String r1) {
        return (LiveEntranceStatus) r27.a.a(LiveEntranceStatus.class, r1);
    }

    public static LiveEntranceStatus[] values() {
        return (LiveEntranceStatus[]) a.clone();
    }

    public LiveEntranceStatus(String r1, int r2) {
        super(r1, r2);
    }
}
