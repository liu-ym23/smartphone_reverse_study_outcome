package com.bytedance.apm6.consumer.slardar.send.downgrade;

/* JADX INFO: loaded from: classes2.dex */
public final enum DowngradeInfo$LogType extends Enum<DowngradeInfo$LogType> {
    public static final DowngradeInfo$LogType OTHER_LOG_TYPE = null;
    public static final DowngradeInfo$LogType SERVICE_MONITOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DowngradeInfo$LogType[] f3920a = null;
    public final String logType;

    static {
        DowngradeInfo$LogType r5 = new DowngradeInfo$LogType("OTHER_LOG_TYPE", 0, "other");
        OTHER_LOG_TYPE = r5;
        DowngradeInfo$LogType r10 = new DowngradeInfo$LogType("SERVICE_MONITOR", 1, "service_monitor");
        SERVICE_MONITOR = r10;
        f3920a = new DowngradeInfo$LogType[]{r5, r10};
    }

    public DowngradeInfo$LogType(String r5, int r10, String r11) {
        super(r5, r10);
        this.logType = r11;
    }

    public static DowngradeInfo$LogType valueOf(String r5) {
        return (DowngradeInfo$LogType) Enum.valueOf(DowngradeInfo$LogType.class, r5);
    }

    public static DowngradeInfo$LogType[] values() {
        return (DowngradeInfo$LogType[]) f3920a.clone();
    }
}
