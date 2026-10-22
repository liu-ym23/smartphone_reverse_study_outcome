package com.bytedance.android.live.effect.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/event/ReleaseStatus;", "", "Start", "End", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReleaseStatus extends Enum<ReleaseStatus> {
    public static final ReleaseStatus End = null;
    public static final ReleaseStatus Start = null;
    public static final /* synthetic */ ReleaseStatus[] a = null;

    static {
        ReleaseStatus r1 = new ReleaseStatus("Start", 0);
        Start = r1;
        ReleaseStatus r2 = new ReleaseStatus("End", 1);
        End = r2;
        a = new ReleaseStatus[]{r1, r2};
    }

    public static ReleaseStatus valueOf(String r1) {
        return (ReleaseStatus) a.a(ReleaseStatus.class, r1);
    }

    public static ReleaseStatus[] values() {
        return (ReleaseStatus[]) a.clone();
    }

    public ReleaseStatus(String r1, int r2) {
        super(r1, r2);
    }
}
