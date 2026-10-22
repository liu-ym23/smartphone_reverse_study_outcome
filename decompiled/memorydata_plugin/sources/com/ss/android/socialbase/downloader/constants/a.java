package com.ss.android.socialbase.downloader.constants;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;

/* JADX INFO: loaded from: classes6.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f15350a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f15351b = null;
    public static final String[] c = null;
    public static final String[] d = null;

    static {
        f15350a = new String[]{"_id", "url", "savePath", "tempPath", ActivityLifecycle.NAME, "chunkCount", "status", "curBytes", "totalBytes", "eTag", "onlyWifi", "force", "retryCount", WsConstants.KEY_EXTRA, "mimeType", "title", "notificationEnable", "notificationVisibility", "isFirstDownload", "isFirstSuccess", "needHttpsToHttpRetry", "downloadTime", ObricMemoryConstants.KEY_PACKAGE_NAME, "md5", "retryDelay", "curRetryTime", "retryDelayStatus", "defaultHttpServiceBackUp", "chunkRunnableReuse", "retryDelayTimeArray", "chunkDowngradeRetry", "backUpUrlsStr", "backUpUrlRetryCount", "realDownloadTime", "retryScheduleMinutes", "independentProcess", "auxiliaryJsonobjectString", "iconUrl", "appVersionCode", "taskId", "downloadStartTimeStamp", "downloadFinishTimeStamp", "installedTimeStamp", "hasDoInstallation", "cacheLifeTimeMax", "pcdnUrlsStr", "cdnUrlsStr", "backCurBytes", "realBackDownloadTime"};
        f15351b = new String[]{"_id"};
        c = new String[]{"_id", "info"};
        d = new String[]{"_id"};
    }
}
