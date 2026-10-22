package com.bytedance.pia.core.metrics;

/* JADX INFO: loaded from: classes2.dex */
public final enum MetricsType extends Enum<MetricsType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MetricsType f7035a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MetricsType f7036b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MetricsType f7037c = null;
    public static final /* synthetic */ MetricsType[] d = null;

    static {
        MetricsType r5 = new MetricsType("EXCEPTION", 0, "exception");
        f7035a = r5;
        MetricsType r10 = new MetricsType("PV", 1, "pv");
        f7036b = r10;
        MetricsType r11 = new MetricsType("NSR_PERFORMANCE", 2, "nsr_worker_performance");
        f7037c = r11;
        d = new MetricsType[]{r5, r10, r11};
    }

    public MetricsType(String r5, int r10, String r11) {
        super(r5, r10);
    }

    public static MetricsType valueOf(String r5) {
        return (MetricsType) Enum.valueOf(MetricsType.class, r5);
    }

    public static MetricsType[] values() {
        return (MetricsType[]) d.clone();
    }
}
