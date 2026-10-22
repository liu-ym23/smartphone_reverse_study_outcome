package com.ss.android.socialbase.downloader.network;

/* JADX INFO: loaded from: classes3.dex */
public final enum NetworkQuality extends Enum<NetworkQuality> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetworkQuality f15969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final NetworkQuality f15970b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final NetworkQuality f15971c = null;
    public static final NetworkQuality d = null;
    public static final NetworkQuality e = null;
    public static final /* synthetic */ NetworkQuality[] f = null;

    static {
        NetworkQuality r5 = new NetworkQuality("POOR", 0);
        f15969a = r5;
        NetworkQuality r10 = new NetworkQuality("MODERATE", 1);
        f15970b = r10;
        NetworkQuality r11 = new NetworkQuality("GOOD", 2);
        f15971c = r11;
        NetworkQuality r12 = new NetworkQuality("EXCELLENT", 3);
        d = r12;
        NetworkQuality r13 = new NetworkQuality("UNKNOWN", 4);
        e = r13;
        f = new NetworkQuality[]{r5, r10, r11, r12, r13};
    }

    public NetworkQuality(String r5, int r10) {
        super(r5, r10);
    }

    public static NetworkQuality valueOf(String r5) {
        return (NetworkQuality) Enum.valueOf(NetworkQuality.class, r5);
    }

    public static NetworkQuality[] values() {
        return (NetworkQuality[]) f.clone();
    }
}
