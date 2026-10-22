package com.bytedance.pia.core.metrics;

/* JADX INFO: loaded from: classes2.dex */
public final enum PvEventType extends Enum<PvEventType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PvEventType f7038b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PvEventType f7039c = null;
    public static final PvEventType d = null;
    public static final PvEventType e = null;
    public static final PvEventType f = null;
    public static final /* synthetic */ PvEventType[] g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7040a;

    static {
        PvEventType r5 = new PvEventType("PREFETCH_ENABLED", 0, "prefetch_enabled");
        f7038b = r5;
        PvEventType r10 = new PvEventType("LOADING_ENABLED", 1, "native_loading_enabled");
        PvEventType r11 = new PvEventType("NSR_ENABLED", 2, "nsr_enabled");
        f7039c = r11;
        PvEventType r12 = new PvEventType("NSR_HIT", 3, "nsr_hit");
        d = r12;
        PvEventType r13 = new PvEventType("SNAPSHOT_ENABLED", 4, "snapshot_enabled");
        e = r13;
        PvEventType r14 = new PvEventType("SNAPSHOT_HIT", 5, "snapshot_hit");
        f = r14;
        g = new PvEventType[]{r5, r10, r11, r12, r13, r14};
    }

    public PvEventType(String r5, int r10, String r11) {
        super(r5, r10);
        this.f7040a = r11;
    }

    public static PvEventType valueOf(String r5) {
        return (PvEventType) Enum.valueOf(PvEventType.class, r5);
    }

    public static PvEventType[] values() {
        return (PvEventType[]) g.clone();
    }
}
