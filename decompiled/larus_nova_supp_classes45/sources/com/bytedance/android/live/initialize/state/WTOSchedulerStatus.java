package com.bytedance.android.live.initialize.state;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/initialize/state/WTOSchedulerStatus;", "", "IDLE", "RUNNING", "BLOCK_FINISHED", "FINISHED", "live-initialize-scheduler_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WTOSchedulerStatus extends Enum<WTOSchedulerStatus> {
    public static final WTOSchedulerStatus BLOCK_FINISHED = null;
    public static final WTOSchedulerStatus FINISHED = null;
    public static final WTOSchedulerStatus IDLE = null;
    public static final WTOSchedulerStatus RUNNING = null;
    public static final /* synthetic */ WTOSchedulerStatus[] a = null;

    static {
        WTOSchedulerStatus r1 = new WTOSchedulerStatus("IDLE", 0);
        IDLE = r1;
        WTOSchedulerStatus r2 = new WTOSchedulerStatus("RUNNING", 1);
        RUNNING = r2;
        WTOSchedulerStatus r3 = new WTOSchedulerStatus("BLOCK_FINISHED", 2);
        BLOCK_FINISHED = r3;
        WTOSchedulerStatus r4 = new WTOSchedulerStatus("FINISHED", 3);
        FINISHED = r4;
        a = new WTOSchedulerStatus[]{r1, r2, r3, r4};
    }

    public static WTOSchedulerStatus valueOf(String r1) {
        return (WTOSchedulerStatus) a.a(WTOSchedulerStatus.class, r1);
    }

    public static WTOSchedulerStatus[] values() {
        return (WTOSchedulerStatus[]) a.clone();
    }

    public WTOSchedulerStatus(String r1, int r2) {
        super(r1, r2);
    }
}
