package com.bytedance.frameworks.baselib.network.connectionclass;

/* JADX INFO: loaded from: classes2.dex */
public final enum ConnectionQuality extends Enum<ConnectionQuality> {
    public static final ConnectionQuality EXCELLENT = null;
    public static final ConnectionQuality GOOD = null;
    public static final ConnectionQuality MODERATE = null;
    public static final ConnectionQuality POOR = null;
    public static final ConnectionQuality UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConnectionQuality[] f4664a = null;

    static {
        ConnectionQuality r5 = new ConnectionQuality("POOR", 0);
        POOR = r5;
        ConnectionQuality r10 = new ConnectionQuality("MODERATE", 1);
        MODERATE = r10;
        ConnectionQuality r11 = new ConnectionQuality("GOOD", 2);
        GOOD = r11;
        ConnectionQuality r12 = new ConnectionQuality("EXCELLENT", 3);
        EXCELLENT = r12;
        ConnectionQuality r13 = new ConnectionQuality("UNKNOWN", 4);
        UNKNOWN = r13;
        f4664a = new ConnectionQuality[]{r5, r10, r11, r12, r13};
    }

    public static ConnectionQuality valueOf(String r5) {
        return (ConnectionQuality) Enum.valueOf(ConnectionQuality.class, r5);
    }

    public static ConnectionQuality[] values() {
        return (ConnectionQuality[]) f4664a.clone();
    }
}
