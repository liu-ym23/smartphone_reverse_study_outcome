package com.lynx.tasm.fluency;

/* JADX INFO: loaded from: classes2.dex */
public final enum FluencyTraceHelper$ForceStatus extends Enum<FluencyTraceHelper$ForceStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FluencyTraceHelper$ForceStatus f10847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FluencyTraceHelper$ForceStatus f10848b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FluencyTraceHelper$ForceStatus f10849c = null;
    public static final /* synthetic */ FluencyTraceHelper$ForceStatus[] d = null;

    static {
        FluencyTraceHelper$ForceStatus r5 = new FluencyTraceHelper$ForceStatus("FORCED_ON", 0);
        f10847a = r5;
        FluencyTraceHelper$ForceStatus r10 = new FluencyTraceHelper$ForceStatus("FORCED_OFF", 1);
        f10848b = r10;
        FluencyTraceHelper$ForceStatus r11 = new FluencyTraceHelper$ForceStatus("NON_FORCED", 2);
        f10849c = r11;
        d = new FluencyTraceHelper$ForceStatus[]{r5, r10, r11};
    }

    public FluencyTraceHelper$ForceStatus(String r5, int r10) {
        super(r5, r10);
    }

    public static FluencyTraceHelper$ForceStatus valueOf(String r5) {
        return (FluencyTraceHelper$ForceStatus) Enum.valueOf(FluencyTraceHelper$ForceStatus.class, r5);
    }

    public static FluencyTraceHelper$ForceStatus[] values() {
        return (FluencyTraceHelper$ForceStatus[]) d.clone();
    }
}
