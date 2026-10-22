package com.ss.android.socialbase.downloader.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadDBInitInfo {
    public int diskCacheCount;
    public long initCpuDuration;
    public long initDuration;
    public int memoryCacheCount;

    public DownloadDBInitInfo() {
    }

    public String toString() {
        return "DownloadDBInitInfo{initDuration=" + this.initDuration + ", diskCacheCount=" + this.diskCacheCount + ", memoryCacheCount=" + this.memoryCacheCount + ", initCpuDuration=" + this.initCpuDuration + '}';
    }
}
