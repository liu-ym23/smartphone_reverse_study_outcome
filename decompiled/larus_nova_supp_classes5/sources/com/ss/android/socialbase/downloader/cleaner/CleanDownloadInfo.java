package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class CleanDownloadInfo {
    private int mId;
    private String mMonitorScene;
    private String mName;
    private String mSavePath;
    private String mTempPath;
    private String mUrl;

    public CleanDownloadInfo() {
    }

    public int getId() {
        return this.mId;
    }

    public String getMonitorScene() {
        return this.mMonitorScene;
    }

    public String getName() {
        return this.mName;
    }

    public String getSavePath() {
        return this.mSavePath;
    }

    public String getTempPath() {
        return this.mTempPath;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public CleanDownloadInfo(DownloadInfo r2) {
        this.mId = r2.getId();
        this.mSavePath = r2.getSavePath();
        this.mTempPath = r2.getTempPath();
        this.mName = r2.getName();
        this.mMonitorScene = r2.getMonitorScene();
        this.mUrl = r2.getUrl();
    }

    public void setId(int r1) {
        this.mId = r1;
    }

    public void setMonitorScene(String r1) {
        this.mMonitorScene = r1;
    }

    public void setName(String r1) {
        this.mName = r1;
    }

    public void setSavePath(String r1) {
        this.mSavePath = r1;
    }

    public void setTempPath(String r1) {
        this.mTempPath = r1;
    }

    public void setUrl(String r1) {
        this.mUrl = r1;
    }
}
