package com.bytedance.android.livesdk.chatroom.vs_base.metrics;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/metrics/ReplayUIMetrics;", "", "", "description", "Ljava/lang/String;", "TOOLBAR", "EXPAND_AREA", "BACK_GROUND", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayUIMetrics extends Enum<ReplayUIMetrics> {
    public static final ReplayUIMetrics BACK_GROUND = null;
    public static final ReplayUIMetrics EXPAND_AREA = null;
    public static final ReplayUIMetrics TOOLBAR = null;
    public static final /* synthetic */ ReplayUIMetrics[] a = null;
    private final String description;

    static {
        ReplayUIMetrics r1 = new ReplayUIMetrics("TOOLBAR", 0, "vs底部Tooolbar");
        TOOLBAR = r1;
        ReplayUIMetrics r2 = new ReplayUIMetrics("EXPAND_AREA", 1, "vs延展区");
        EXPAND_AREA = r2;
        ReplayUIMetrics r3 = new ReplayUIMetrics("BACK_GROUND", 2, "录播背景");
        BACK_GROUND = r3;
        a = new ReplayUIMetrics[]{r1, r2, r3};
    }

    public static ReplayUIMetrics valueOf(String r1) {
        return (ReplayUIMetrics) a.a(ReplayUIMetrics.class, r1);
    }

    public static ReplayUIMetrics[] values() {
        return (ReplayUIMetrics[]) a.clone();
    }

    public ReplayUIMetrics(String r1, int r2, String r3) {
        super(r1, r2);
        this.description = r3;
    }
}
