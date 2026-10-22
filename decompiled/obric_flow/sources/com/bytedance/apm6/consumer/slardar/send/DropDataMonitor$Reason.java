package com.bytedance.apm6.consumer.slardar.send;

/* JADX INFO: loaded from: classes2.dex */
final enum DropDataMonitor$Reason extends Enum<DropDataMonitor$Reason> {
    public static final DropDataMonitor$Reason FULL_DISK = null;
    public static final DropDataMonitor$Reason SERVER_DROP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DropDataMonitor$Reason[] f3919a = null;
    private String reason;

    static {
        DropDataMonitor$Reason r5 = new DropDataMonitor$Reason("SERVER_DROP", 0, "server drop message");
        SERVER_DROP = r5;
        DropDataMonitor$Reason r10 = new DropDataMonitor$Reason("FULL_DISK", 1, "disk is full");
        FULL_DISK = r10;
        f3919a = new DropDataMonitor$Reason[]{r5, r10};
    }

    public DropDataMonitor$Reason(String r5, int r10, String r11) {
        super(r5, r10);
        this.reason = r11;
    }

    public static DropDataMonitor$Reason valueOf(String r5) {
        return (DropDataMonitor$Reason) Enum.valueOf(DropDataMonitor$Reason.class, r5);
    }

    public static DropDataMonitor$Reason[] values() {
        return (DropDataMonitor$Reason[]) f3919a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.reason;
    }
}
