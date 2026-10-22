package com.ss.android.socialbase.downloader.network;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum NetworkQuality extends Enum<NetworkQuality> {
    private static final /* synthetic */ NetworkQuality[] $VALUES = null;
    public static final NetworkQuality EXCELLENT = null;
    public static final NetworkQuality GOOD = null;
    public static final NetworkQuality MODERATE = null;
    public static final NetworkQuality POOR = null;
    public static final NetworkQuality UNKNOWN = null;

    static {
        NetworkQuality r0 = new NetworkQuality("POOR", 0);
        POOR = r0;
        NetworkQuality r1 = new NetworkQuality("MODERATE", 1);
        MODERATE = r1;
        NetworkQuality r3 = new NetworkQuality("GOOD", 2);
        GOOD = r3;
        NetworkQuality r5 = new NetworkQuality("EXCELLENT", 3);
        EXCELLENT = r5;
        NetworkQuality r7 = new NetworkQuality("UNKNOWN", 4);
        UNKNOWN = r7;
        $VALUES = new NetworkQuality[]{r0, r1, r3, r5, r7};
    }

    private NetworkQuality(String r1, int r2) {
        super(r1, r2);
    }

    public static NetworkQuality valueOf(String r2) {
        return (NetworkQuality) ZeusTransformUtils.preCheckCast(Enum.valueOf(NetworkQuality.class, r2), NetworkQuality.class, "com.obric.memorydata.plugin");
    }

    public static NetworkQuality[] values() {
        return (NetworkQuality[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NetworkQuality[].class, "com.obric.memorydata.plugin");
    }
}
