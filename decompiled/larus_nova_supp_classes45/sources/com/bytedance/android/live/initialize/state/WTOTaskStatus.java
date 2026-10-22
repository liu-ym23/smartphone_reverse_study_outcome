package com.bytedance.android.live.initialize.state;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/initialize/state/WTOTaskStatus;", "", "IDLE", "QUEUE", "RUNNING", "FINISHED", "FAILED", "live-initialize-scheduler_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WTOTaskStatus extends Enum<WTOTaskStatus> {
    public static final WTOTaskStatus FAILED = null;
    public static final WTOTaskStatus FINISHED = null;
    public static final WTOTaskStatus IDLE = null;
    public static final WTOTaskStatus QUEUE = null;
    public static final WTOTaskStatus RUNNING = null;
    public static final /* synthetic */ WTOTaskStatus[] a = null;

    static {
        WTOTaskStatus r1 = new WTOTaskStatus("IDLE", 0);
        IDLE = r1;
        WTOTaskStatus r2 = new WTOTaskStatus("QUEUE", 1);
        QUEUE = r2;
        WTOTaskStatus r3 = new WTOTaskStatus("RUNNING", 2);
        RUNNING = r3;
        WTOTaskStatus r4 = new WTOTaskStatus("FINISHED", 3);
        FINISHED = r4;
        WTOTaskStatus r5 = new WTOTaskStatus("FAILED", 4);
        FAILED = r5;
        a = new WTOTaskStatus[]{r1, r2, r3, r4, r5};
    }

    public static WTOTaskStatus valueOf(String r1) {
        return (WTOTaskStatus) a.a(WTOTaskStatus.class, r1);
    }

    public static WTOTaskStatus[] values() {
        return (WTOTaskStatus[]) a.clone();
    }

    public WTOTaskStatus(String r1, int r2) {
        super(r1, r2);
    }
}
