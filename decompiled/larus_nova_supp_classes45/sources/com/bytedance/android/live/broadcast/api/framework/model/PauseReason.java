package com.bytedance.android.live.broadcast.api.framework.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/model/PauseReason;", "", "", "USER_INITIATED", "BACKGROUND", "SCREEN_OFF", "BUSINESS", "OVERLAY", "OVERLAY_BY_MONITOR", "FLOAT_WINDOW_ERROR", "ERROR", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PauseReason extends Enum<PauseReason> {
    public static final PauseReason BACKGROUND = null;
    public static final PauseReason BUSINESS = null;
    public static final PauseReason ERROR = null;
    public static final PauseReason FLOAT_WINDOW_ERROR = null;
    public static final PauseReason OVERLAY = null;
    public static final PauseReason OVERLAY_BY_MONITOR = null;
    public static final PauseReason SCREEN_OFF = null;
    public static final PauseReason USER_INITIATED = null;
    public static final /* synthetic */ PauseReason[] a = null;

    static {
        PauseReason r1 = new PauseReason("USER_INITIATED", 0);
        USER_INITIATED = r1;
        PauseReason r2 = new PauseReason("BACKGROUND", 1);
        BACKGROUND = r2;
        PauseReason r3 = new PauseReason("SCREEN_OFF", 2);
        SCREEN_OFF = r3;
        PauseReason r4 = new PauseReason("BUSINESS", 3);
        BUSINESS = r4;
        PauseReason r5 = new PauseReason("OVERLAY", 4);
        OVERLAY = r5;
        PauseReason r6 = new PauseReason("OVERLAY_BY_MONITOR", 5);
        OVERLAY_BY_MONITOR = r6;
        PauseReason r7 = new PauseReason("FLOAT_WINDOW_ERROR", 6);
        FLOAT_WINDOW_ERROR = r7;
        PauseReason r8 = new PauseReason("ERROR", 7);
        ERROR = r8;
        a = new PauseReason[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public static PauseReason valueOf(String r1) {
        return (PauseReason) a.a(PauseReason.class, r1);
    }

    public static PauseReason[] values() {
        return (PauseReason[]) a.clone();
    }

    public PauseReason(String r1, int r2) {
        super(r1, r2);
    }
}
