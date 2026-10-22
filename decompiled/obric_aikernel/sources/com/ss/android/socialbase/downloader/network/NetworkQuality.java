package com.ss.android.socialbase.downloader.network;

/* JADX INFO: loaded from: classes2.dex */
public final enum NetworkQuality extends Enum<NetworkQuality> {
    private static final /* synthetic */ NetworkQuality[] $VALUES = null;
    public static final NetworkQuality EXCELLENT = null;
    public static final NetworkQuality GOOD = null;
    public static final NetworkQuality MODERATE = null;
    public static final NetworkQuality POOR = null;
    public static final NetworkQuality UNKNOWN = null;

    static {
        NetworkQuality r10 = new NetworkQuality("POOR", 0);
        POOR = r10;
        NetworkQuality r11 = new NetworkQuality("MODERATE", 1);
        MODERATE = r11;
        NetworkQuality r12 = new NetworkQuality("GOOD", 2);
        GOOD = r12;
        NetworkQuality r13 = new NetworkQuality("EXCELLENT", 3);
        EXCELLENT = r13;
        NetworkQuality r14 = new NetworkQuality("UNKNOWN", 4);
        UNKNOWN = r14;
        $VALUES = new NetworkQuality[]{r10, r11, r12, r13, r14};
    }

    private NetworkQuality(String r10, int r11) {
        super(r10, r11);
    }

    public static NetworkQuality valueOf(String r10) {
        return (NetworkQuality) Enum.valueOf(NetworkQuality.class, r10);
    }

    public static NetworkQuality[] values() {
        return (NetworkQuality[]) $VALUES.clone();
    }
}
