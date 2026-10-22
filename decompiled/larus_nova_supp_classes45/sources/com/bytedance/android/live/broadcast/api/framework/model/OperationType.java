package com.bytedance.android.live.broadcast.api.framework.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/model/OperationType;", "", "START", "PAUSE", "RESUME", "STOP", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OperationType extends Enum<OperationType> {
    public static final OperationType PAUSE = null;
    public static final OperationType RESUME = null;
    public static final OperationType START = null;
    public static final OperationType STOP = null;
    public static final /* synthetic */ OperationType[] a = null;

    static {
        OperationType r1 = new OperationType("START", 0);
        START = r1;
        OperationType r2 = new OperationType("PAUSE", 1);
        PAUSE = r2;
        OperationType r3 = new OperationType("RESUME", 2);
        RESUME = r3;
        OperationType r4 = new OperationType("STOP", 3);
        STOP = r4;
        a = new OperationType[]{r1, r2, r3, r4};
    }

    public static OperationType valueOf(String r1) {
        return (OperationType) a.a(OperationType.class, r1);
    }

    public static OperationType[] values() {
        return (OperationType[]) a.clone();
    }

    public OperationType(String r1, int r2) {
        super(r1, r2);
    }
}
