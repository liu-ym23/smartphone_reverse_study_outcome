package com.ss.android.lark.gadget.preload.entity;

import com.tt.refer.common.base.AppType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class PreLoadAppEntity {
    public static final int DOWNLOAD_PRIORITY_HIGH = 1;
    public static final int DOWNLOAD_PRIORITY_HIGHEST = 2;
    public static final int DOWNLOAD_PRIORITY_NORMAL = 0;
    public static final int PRELOAD_MODE_LATEST = 2;
    public static final int PRELOAD_MODE_LAZY = 1;
    private AppType brandAppType;
    private String mAppId;
    private int mAppType;
    private int mDownloadPriority;
    private int mOriginDownloadPriority;
    private int mPreloadMode;

    public static boolean compareDownloadPriority(int r0, int r1) {
        if (r0 <= r1) goto L4;
        return true;
    L4:
        return false;
    }

    public static boolean isPreloadModeValid(int r2) {
        if (r2 != 1) goto L5;
    L8:
        return true;
    L5:
        if (r2 == 2) goto L8;
        return false;
    }

    public void downgradePriority() {
        this.mDownloadPriority = 0;
    }

    public boolean downgraded() {
        int r0 = this.mDownloadPriority;
        if (r0 == 0) goto L5;
    L7:
        return false;
    L5:
        if (r0 == this.mOriginDownloadPriority) goto L7;
        return true;
    }

    public String toString() {
        return "mAppId: " + this.mAppId + " mAppType: " + this.mAppType + " mDownloadPriority: " + this.mDownloadPriority + " mOriginDownloadPriority: " + this.mOriginDownloadPriority;
    }

    public PreLoadAppEntity() {
        this.mDownloadPriority = 0;
        this.mOriginDownloadPriority = 0;
        this.mPreloadMode = -1;
    }

    public String getAppid() {
        return this.mAppId;
    }

    public int getApptype() {
        return this.mAppType;
    }

    public AppType getBrandAppType() {
        return this.brandAppType;
    }

    public int getDownloadPriority() {
        return this.mDownloadPriority;
    }

    public int getOriginDownloadPriority() {
        return this.mOriginDownloadPriority;
    }

    public int getPreloadMode() {
        return this.mPreloadMode;
    }

    public void setAppid(String r1) {
        this.mAppId = r1;
    }

    public void setApptype(int r1) {
        this.mAppType = r1;
    }

    public void setBrandAppType(AppType r1) {
        this.brandAppType = r1;
    }

    public void setDownloadPriority(int r3) {
        if (r3 == 1) goto L7;
        if (r3 == 2) goto L7;
        if (r3 == 0) goto L7;
        r3 = 0;
    L7:
        this.mDownloadPriority = r3;
        this.mOriginDownloadPriority = r3;
        if (r3 == 2) goto L10;
        return;
    L10:
        if (isPreloadModeValid(this.mPreloadMode) == true) goto L14;
        this.mPreloadMode = 2;
        return;
    }

    public void setPreloadMode(int r1) {
        this.mPreloadMode = r1;
    }
}
