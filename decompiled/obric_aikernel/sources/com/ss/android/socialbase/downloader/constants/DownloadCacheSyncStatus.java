package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes2.dex */
public final enum DownloadCacheSyncStatus extends Enum<DownloadCacheSyncStatus> {
    private static final /* synthetic */ DownloadCacheSyncStatus[] $VALUES = null;
    public static final DownloadCacheSyncStatus SYNC_NONE = null;
    public static final DownloadCacheSyncStatus SYNC_START = null;
    public static final DownloadCacheSyncStatus SYNC_SUCCESS = null;

    static {
        DownloadCacheSyncStatus r10 = new DownloadCacheSyncStatus("SYNC_NONE", 0);
        SYNC_NONE = r10;
        DownloadCacheSyncStatus r11 = new DownloadCacheSyncStatus("SYNC_START", 1);
        SYNC_START = r11;
        DownloadCacheSyncStatus r12 = new DownloadCacheSyncStatus("SYNC_SUCCESS", 2);
        SYNC_SUCCESS = r12;
        $VALUES = new DownloadCacheSyncStatus[]{r10, r11, r12};
    }

    private DownloadCacheSyncStatus(String r10, int r11) {
        super(r10, r11);
    }

    public static DownloadCacheSyncStatus valueOf(String r10) {
        return (DownloadCacheSyncStatus) Enum.valueOf(DownloadCacheSyncStatus.class, r10);
    }

    public static DownloadCacheSyncStatus[] values() {
        return (DownloadCacheSyncStatus[]) $VALUES.clone();
    }
}
