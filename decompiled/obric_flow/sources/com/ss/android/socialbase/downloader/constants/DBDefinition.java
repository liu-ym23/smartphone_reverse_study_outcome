package com.ss.android.socialbase.downloader.constants;

import androidx.core.app.NotificationCompat;
import cn.nubia.neopush.commons.Constant;

/* JADX INFO: loaded from: classes3.dex */
public interface DBDefinition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f15269a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f15270b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f15271c = null;
    public static final String[] d = null;

    static {
        f15269a = new String[]{"_id", "url", "savePath", "tempPath", "name", "chunkCount", NotificationCompat.CATEGORY_STATUS, "curBytes", "totalBytes", "eTag", "onlyWifi", "force", "retryCount", "extra", "mimeType", Constant.TITLE, "notificationEnable", "notificationVisibility", "isFirstDownload", "isFirstSuccess", "needHttpsToHttpRetry", "downloadTime", "packageName", "md5", "retryDelay", "curRetryTime", "retryDelayStatus", "defaultHttpServiceBackUp", "chunkRunnableReuse", "retryDelayTimeArray", "chunkDowngradeRetry", "backUpUrlsStr", "backUpUrlRetryCount", "realDownloadTime", "retryScheduleMinutes", "independentProcess", "auxiliaryJsonobjectString", "iconUrl", "appVersionCode", "taskId", "downloadStartTimeStamp", "downloadFinishTimeStamp", "installedTimeStamp", "hasDoInstallation", "cacheLifeTimeMax", "pcdnUrlsStr", "cdnUrlsStr", "backCurBytes", "realBackDownloadTime", "monitorScene"};
        f15270b = new String[]{"_id"};
        f15271c = new String[]{"_id", "info"};
        d = new String[]{"_id"};
    }
}
