package com.bytedance.android.live.broadcast.api.framework.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/model/ResumeReason;", "", "", "USER_INITIATED", "FOREGROUND", "SCREEN_ON", "BUSINESS", "OVERLAY_REMOVED", "OVERLAY_BY_MONITOR_REMOVED", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ResumeReason extends Enum<ResumeReason> {
    public static final ResumeReason BUSINESS = null;
    public static final ResumeReason FOREGROUND = null;
    public static final ResumeReason OVERLAY_BY_MONITOR_REMOVED = null;
    public static final ResumeReason OVERLAY_REMOVED = null;
    public static final ResumeReason SCREEN_ON = null;
    public static final ResumeReason USER_INITIATED = null;
    public static final /* synthetic */ ResumeReason[] a = null;

    static {
        ResumeReason r1 = new ResumeReason("USER_INITIATED", 0);
        USER_INITIATED = r1;
        ResumeReason r2 = new ResumeReason("FOREGROUND", 1);
        FOREGROUND = r2;
        ResumeReason r3 = new ResumeReason("SCREEN_ON", 2);
        SCREEN_ON = r3;
        ResumeReason r4 = new ResumeReason("BUSINESS", 3);
        BUSINESS = r4;
        ResumeReason r5 = new ResumeReason("OVERLAY_REMOVED", 4);
        OVERLAY_REMOVED = r5;
        ResumeReason r6 = new ResumeReason("OVERLAY_BY_MONITOR_REMOVED", 5);
        OVERLAY_BY_MONITOR_REMOVED = r6;
        a = new ResumeReason[]{r1, r2, r3, r4, r5, r6};
    }

    public static ResumeReason valueOf(String r1) {
        return (ResumeReason) a.a(ResumeReason.class, r1);
    }

    public static ResumeReason[] values() {
        return (ResumeReason[]) a.clone();
    }

    public ResumeReason(String r1, int r2) {
        super(r1, r2);
    }
}
