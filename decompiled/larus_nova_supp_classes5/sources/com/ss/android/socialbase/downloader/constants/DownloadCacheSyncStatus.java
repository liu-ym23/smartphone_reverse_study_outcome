package com.ss.android.socialbase.downloader.constants;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum DownloadCacheSyncStatus extends Enum<DownloadCacheSyncStatus> {
    private static final /* synthetic */ DownloadCacheSyncStatus[] $VALUES = null;
    public static final DownloadCacheSyncStatus SYNC_NONE = null;
    public static final DownloadCacheSyncStatus SYNC_START = null;
    public static final DownloadCacheSyncStatus SYNC_SUCCESS = null;

    static {
        DownloadCacheSyncStatus r0 = new DownloadCacheSyncStatus("SYNC_NONE", 0);
        SYNC_NONE = r0;
        DownloadCacheSyncStatus r1 = new DownloadCacheSyncStatus("SYNC_START", 1);
        SYNC_START = r1;
        DownloadCacheSyncStatus r3 = new DownloadCacheSyncStatus("SYNC_SUCCESS", 2);
        SYNC_SUCCESS = r3;
        $VALUES = new DownloadCacheSyncStatus[]{r0, r1, r3};
    }

    public static DownloadCacheSyncStatus[] values() {
        return (DownloadCacheSyncStatus[]) $VALUES.clone();
    }

    public static DownloadCacheSyncStatus valueOf(String r1) {
        return (DownloadCacheSyncStatus) a.a(DownloadCacheSyncStatus.class, r1);
    }

    private DownloadCacheSyncStatus(String r1, int r2) {
        super(r1, r2);
    }
}
