package com.bytedance.frameworks.baselib.network.connectionclass;

/* JADX INFO: loaded from: classes.dex */
public final enum ConnectionQuality extends Enum<ConnectionQuality> {
    private static final /* synthetic */ ConnectionQuality[] $VALUES = null;
    public static final ConnectionQuality EXCELLENT = null;
    public static final ConnectionQuality GOOD = null;
    public static final ConnectionQuality MODERATE = null;
    public static final ConnectionQuality POOR = null;
    public static final ConnectionQuality UNKNOWN = null;

    static {
        ConnectionQuality r10 = new ConnectionQuality("POOR", 0);
        POOR = r10;
        ConnectionQuality r11 = new ConnectionQuality("MODERATE", 1);
        MODERATE = r11;
        ConnectionQuality r12 = new ConnectionQuality("GOOD", 2);
        GOOD = r12;
        ConnectionQuality r13 = new ConnectionQuality("EXCELLENT", 3);
        EXCELLENT = r13;
        ConnectionQuality r14 = new ConnectionQuality("UNKNOWN", 4);
        UNKNOWN = r14;
        $VALUES = new ConnectionQuality[]{r10, r11, r12, r13, r14};
    }

    private ConnectionQuality(String r10, int r11) {
        super(r10, r11);
    }

    public static ConnectionQuality valueOf(String r10) {
        return (ConnectionQuality) Enum.valueOf(ConnectionQuality.class, r10);
    }

    public static ConnectionQuality[] values() {
        return (ConnectionQuality[]) $VALUES.clone();
    }
}
