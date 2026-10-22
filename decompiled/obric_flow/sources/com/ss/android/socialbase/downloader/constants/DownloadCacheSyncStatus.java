package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes3.dex */
public final enum DownloadCacheSyncStatus extends Enum<DownloadCacheSyncStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadCacheSyncStatus f15272a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DownloadCacheSyncStatus f15273b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ DownloadCacheSyncStatus[] f15274c = null;

    static {
        DownloadCacheSyncStatus r5 = new DownloadCacheSyncStatus("SYNC_NONE", 0);
        DownloadCacheSyncStatus r10 = new DownloadCacheSyncStatus("SYNC_START", 1);
        f15272a = r10;
        DownloadCacheSyncStatus r11 = new DownloadCacheSyncStatus("SYNC_SUCCESS", 2);
        f15273b = r11;
        f15274c = new DownloadCacheSyncStatus[]{r5, r10, r11};
    }

    public DownloadCacheSyncStatus(String r5, int r10) {
        super(r5, r10);
    }

    public static DownloadCacheSyncStatus valueOf(String r5) {
        return (DownloadCacheSyncStatus) Enum.valueOf(DownloadCacheSyncStatus.class, r5);
    }

    public static DownloadCacheSyncStatus[] values() {
        return (DownloadCacheSyncStatus[]) f15274c.clone();
    }
}
