package com.ss.android.socialbase.downloader.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = null;
    private static final int DEFAULT_MAX_PROCESS_POST_COUNT = 100;
    private static final long DEFAULT_MIN_BYTES_INTERVAL = 1048576;
    private static boolean OPTIMIZE_MONITOR_LOAD = false;
    private static final int RESERVE_STATUS_NEVER = 0;
    private static final int RESERVE_STATUS_NOW = 2;
    private static final int RESERVE_STATUS_ONCE = 1;
    private static final String TAG = "DownloadInfo";
    private List<String> accessHttpHeaderKeys;
    private boolean addListenerToSameTask;
    private boolean addTTNetCommonParam;
    private AtomicLong allConnectTime;
    private int appVersionCode;
    private AsyncHandleStatus asyncHandleStatus;
    private boolean autoResumed;
    private AtomicLong backCurBytes;
    private int backUpUrlRetryCount;
    private boolean backUpUrlUsed;
    private List<String> backUpUrls;
    private String backUpUrlsStr;
    private int bindValueCount;
    private ByteInvalidRetryStatus byteInvalidRetryStatus;
    private long cacheLifeTimeMax;
    private String callStack;
    private List<String> cdnUrls;
    private String cdnUrlsStr;
    private int chunkCount;
    private int concurrentConnCount;
    private String contentEncoding;
    private int curBackUpUrlIndex;
    private AtomicLong curBytes;
    private int curNetworkRetryCount;
    private int curRetryTime;
    private JSONObject dbJsonData;
    private String dbJsonDataString;
    private boolean deleteCacheIfCheckFailed;
    private long downloadFinishTimeStamp;
    private long downloadStartTimeStamp;
    private long downloadTime;
    private String eTag;
    private EnqueueType enqueueType;
    private boolean expiredHttpCheck;
    private boolean expiredRedownload;
    private String extra;
    private List<HttpHeader> extraHeaders;
    private int[] extraMonitorStatus;
    private BaseException failedException;
    private boolean fastDownload;
    private boolean fastDownloadCommonThreadPool;
    private String filePackageName;
    private List<String> forbiddenBackupUrls;
    private boolean force;
    private boolean forceWifiBound;
    private boolean handleRequest;
    private boolean hasDoInstallation;
    private Map<String, String> httpHeaders;
    private String httpRequestHeader;
    private String httpResponseHeader;
    private int httpStatusCode;
    private String httpStatusMessage;
    private boolean httpsToHttpRetryUsed;
    private String iconUrl;
    private int id;
    private boolean ignoreDataVerify;
    private Boolean ignoreInterceptor;
    private long installedTimeStamp;
    private int interceptFlag;
    private Boolean isAutoInstallWithoutNotification;
    private boolean isCacheExistsInDownloading;
    private boolean isFirstDownload;
    private boolean isFirstSuccess;
    private boolean isForbiddenRetryed;
    private long lastNotifyProgressTime;
    private int mDBInitStatus;
    private boolean mDownloadFromReserveWifi;
    private int mTaskSleepTime;
    private int maxBytes;
    private int maxProgressCount;
    private String md5;
    private long md5Time;
    private String mimeType;
    private int minProgressTimeMsInterval;
    private String monitorScene;
    private String name;
    private boolean needCurrentProcess;
    private boolean needDefaultHttpServiceBackUp;
    private boolean needHttpsToHttpRetry;
    private boolean needIndependentProcess;
    private boolean needPostProgress;
    private boolean needSDKMonitor;
    private String networkQuality;
    private int notificationVisibility;
    private boolean onlyWifi;
    private boolean openLimitSpeed;
    private String[] outIp;
    private int[] outSize;
    private SoftReference<PackageInfo> packageInfoRef;
    private String packageName;
    private JSONObject pcdnStats;
    private List<String> pcdnUrls;
    private String pcdnUrlsStr;
    private long racingTaskExcessBytes;
    private long realBackDownloadTime;
    private long realDownloadTime;
    private long realStartDownloadTime;
    private String requestLog;
    private boolean resumeFileDownload;
    private int retryCount;
    private String savePath;
    private boolean showNotification;
    private boolean showNotificationForAutoResumed;
    private boolean showNotificationForNetworkResumed;
    private JSONObject spData;
    private long startDownloadTime;
    private AtomicInteger status;
    private int statusAtDbInit;
    private boolean successByCache;
    private boolean supportPartial;
    private ConcurrentHashMap<String, Object> tempCacheData;
    private String tempPath;
    private long throttleNetSpeed;
    private int throttleSmoothness;
    private String title;
    private long totalBytes;
    private boolean ttnetByPassProxy;
    private long ttnetProtectTimeout;
    private String url;
    private long verifyCurBytes;
    private long xTotalBytes;

    public static class Builder {
        private List<String> accessHttpHeaderKeys;
        private boolean addListenerToSameTask;
        private boolean addTTNetCommonParam;
        protected int appVersionCode;
        private boolean autoInstall;
        private boolean autoResumed;
        protected int backUpUrlRetryCount;
        private List<String> backUpUrls;
        protected long cacheLifeTimeMax;
        protected String callStack;
        protected List<String> cdnUrls;
        private int concurrentConnCount;
        private boolean deleteCacheIfCheckFailed;
        private boolean distinctDirectory;
        private JSONObject downloadSetting;
        private long endOffset;
        private EnqueueType enqueueType;
        private int executorGroup;
        private long expectFileLength;
        private boolean expiredHttpCheck;
        private boolean expiredRedownload;
        protected String extra;
        private List<HttpHeader> extraHeaders;
        private int[] extraMonitorStatus;
        private boolean fastDownload;
        private boolean fastDownloadCommonThreadPool;
        protected boolean force;
        private boolean forceWifiBound;
        private boolean handleRequest;
        protected String iconUrl;
        private boolean ignoreDataVerify;
        private boolean ignoreInterceptor;
        private int maxBytes;
        private int maxProgressCount;
        protected String md5;
        protected String mimeType;
        private int minProgressTimeMsInterval;
        protected String monitorScene;
        protected String name;
        protected boolean needCurrentProcess;
        protected boolean needDefaultHttpServiceBackUp;
        protected boolean needHttpsToHttpRetry;
        protected boolean needIndependentProcess;
        private boolean needPostProgress;
        private boolean needSDKMonitor;
        protected boolean onlyWifi;
        private boolean openLimitSpeed;
        private String[] outIp;
        private int[] outSize;
        protected String packageName;
        protected List<String> pcdnUrls;
        private boolean resumeFileDownload;
        protected int retryCount;
        protected String savePath;
        protected boolean showNotification;
        private boolean showNotificationForAutoResumed;
        private long startOffset;
        private String taskKey;
        protected String tempPath;
        private long throttleNetSpeed;
        private int throttleSmoothness;
        protected String title;
        private boolean ttnetByPassProxy;
        private long ttnetProtectTimeout;
        protected String url;

        public Builder fastDownload() {
            this.fastDownload = true;
            return this;
        }

        public Builder fastDownloadCommonThreadPool() {
            this.fastDownloadCommonThreadPool = true;
            return this;
        }

        public Builder handleRequest() {
            this.handleRequest = true;
            return this;
        }

        public Builder resumeFileDownload() {
            this.resumeFileDownload = true;
            return this;
        }

        public DownloadInfo build() {
            return new DownloadInfo(this, null);
        }

        public Builder() {
            this.needPostProgress = true;
            this.autoInstall = true;
            this.needDefaultHttpServiceBackUp = true;
            this.enqueueType = EnqueueType.ENQUEUE_NONE;
            this.startOffset = 0;
            this.endOffset = -1;
            this.needSDKMonitor = true;
        }

        public Builder(String r4) {
            this.needPostProgress = true;
            this.autoInstall = true;
            this.needDefaultHttpServiceBackUp = true;
            this.enqueueType = EnqueueType.ENQUEUE_NONE;
            this.startOffset = 0;
            this.endOffset = -1;
            this.needSDKMonitor = true;
            this.url = r4;
        }

        public static /* synthetic */ boolean access$000(Builder r0) {
            return r0.fastDownload;
        }

        public static /* synthetic */ boolean access$100(Builder r0) {
            return r0.fastDownloadCommonThreadPool;
        }

        public static /* synthetic */ String[] access$1000(Builder r0) {
            return r0.outIp;
        }

        public static /* synthetic */ int[] access$1100(Builder r0) {
            return r0.outSize;
        }

        public static /* synthetic */ boolean access$1200(Builder r0) {
            return r0.needPostProgress;
        }

        public static /* synthetic */ int access$1300(Builder r0) {
            return r0.maxProgressCount;
        }

        public static /* synthetic */ int access$1400(Builder r0) {
            return r0.minProgressTimeMsInterval;
        }

        public static /* synthetic */ boolean access$1500(Builder r0) {
            return r0.autoResumed;
        }

        public static /* synthetic */ boolean access$1600(Builder r0) {
            return r0.showNotificationForAutoResumed;
        }

        public static /* synthetic */ EnqueueType access$1700(Builder r0) {
            return r0.enqueueType;
        }

        public static /* synthetic */ boolean access$1800(Builder r0) {
            return r0.ignoreDataVerify;
        }

        public static /* synthetic */ boolean access$1900(Builder r0) {
            return r0.addListenerToSameTask;
        }

        public static /* synthetic */ boolean access$200(Builder r0) {
            return r0.resumeFileDownload;
        }

        public static /* synthetic */ long access$2000(Builder r2) {
            return r2.throttleNetSpeed;
        }

        public static /* synthetic */ int access$2100(Builder r0) {
            return r0.throttleSmoothness;
        }

        public static /* synthetic */ boolean access$2200(Builder r0) {
            return r0.forceWifiBound;
        }

        public static /* synthetic */ boolean access$2300(Builder r0) {
            return r0.openLimitSpeed;
        }

        public static /* synthetic */ JSONObject access$2400(Builder r0) {
            return r0.downloadSetting;
        }

        public static /* synthetic */ long access$2500(Builder r2) {
            return r2.expectFileLength;
        }

        public static /* synthetic */ int access$2600(Builder r0) {
            return r0.executorGroup;
        }

        public static /* synthetic */ boolean access$2700(Builder r0) {
            return r0.autoInstall;
        }

        public static /* synthetic */ boolean access$2800(Builder r0) {
            return r0.needSDKMonitor;
        }

        public static /* synthetic */ int[] access$2900(Builder r0) {
            return r0.extraMonitorStatus;
        }

        public static /* synthetic */ boolean access$300(Builder r0) {
            return r0.handleRequest;
        }

        public static /* synthetic */ boolean access$3000(Builder r0) {
            return r0.expiredRedownload;
        }

        public static /* synthetic */ boolean access$3100(Builder r0) {
            return r0.expiredHttpCheck;
        }

        public static /* synthetic */ boolean access$3200(Builder r0) {
            return r0.deleteCacheIfCheckFailed;
        }

        public static /* synthetic */ long access$3300(Builder r2) {
            return r2.ttnetProtectTimeout;
        }

        public static /* synthetic */ boolean access$3400(Builder r0) {
            return r0.addTTNetCommonParam;
        }

        public static /* synthetic */ boolean access$3500(Builder r0) {
            return r0.ttnetByPassProxy;
        }

        public static /* synthetic */ boolean access$3600(Builder r0) {
            return r0.ignoreInterceptor;
        }

        public static /* synthetic */ List access$3700(Builder r0) {
            return r0.accessHttpHeaderKeys;
        }

        public static /* synthetic */ long access$3800(Builder r2) {
            return r2.startOffset;
        }

        public static /* synthetic */ long access$3900(Builder r2) {
            return r2.endOffset;
        }

        public static /* synthetic */ List access$400(Builder r0) {
            return r0.backUpUrls;
        }

        public static /* synthetic */ int access$500(Builder r0) {
            return r0.concurrentConnCount;
        }

        public static /* synthetic */ String access$600(Builder r0) {
            return r0.taskKey;
        }

        public static /* synthetic */ boolean access$700(Builder r0) {
            return r0.distinctDirectory;
        }

        public static /* synthetic */ List access$800(Builder r0) {
            return r0.extraHeaders;
        }

        public static /* synthetic */ int access$900(Builder r0) {
            return r0.maxBytes;
        }

        public Builder accessHttpHeaderKeys(List<String> r1) {
            this.accessHttpHeaderKeys = r1;
            return this;
        }

        public Builder addListenerToSameTask(boolean r1) {
            this.addListenerToSameTask = r1;
            return this;
        }

        public Builder addTTNetCommonParam(boolean r1) {
            this.addTTNetCommonParam = r1;
            return this;
        }

        public Builder appVersionCode(int r1) {
            this.appVersionCode = r1;
            return this;
        }

        public Builder autoResumed(boolean r1) {
            this.autoResumed = r1;
            return this;
        }

        public Builder backUpUrlRetryCount(int r1) {
            this.backUpUrlRetryCount = r1;
            return this;
        }

        public Builder backUpUrls(List<String> r1) {
            this.backUpUrls = r1;
            return this;
        }

        public Builder cacheLifeTimeMax(long r1) {
            this.cacheLifeTimeMax = r1;
            return this;
        }

        public Builder callStack(String r1) {
            this.callStack = r1;
            return this;
        }

        public Builder cdnUrls(List<String> r1) {
            this.cdnUrls = r1;
            return this;
        }

        public Builder concurrentConnCount(int r1) {
            this.concurrentConnCount = r1;
            return this;
        }

        public Builder deleteCacheIfCheckFailed(boolean r1) {
            this.deleteCacheIfCheckFailed = r1;
            return this;
        }

        public Builder distinctDirectory(boolean r1) {
            this.distinctDirectory = r1;
            return this;
        }

        public Builder downloadSetting(JSONObject r1) {
            this.downloadSetting = r1;
            return this;
        }

        public Builder endOffset(long r1) {
            this.endOffset = r1;
            return this;
        }

        public Builder enqueueType(EnqueueType r1) {
            this.enqueueType = r1;
            return this;
        }

        public Builder executorGroup(int r1) {
            this.executorGroup = r1;
            return this;
        }

        public Builder expectFileLength(long r1) {
            this.expectFileLength = r1;
            return this;
        }

        public Builder expiredHttpCheck(boolean r1) {
            this.expiredHttpCheck = r1;
            return this;
        }

        public Builder expiredRedownload(boolean r1) {
            this.expiredRedownload = r1;
            return this;
        }

        public Builder extra(String r1) {
            this.extra = r1;
            return this;
        }

        public Builder extraHeaders(List<HttpHeader> r1) {
            this.extraHeaders = r1;
            return this;
        }

        public Builder extraMonitorStatus(int[] r1) {
            this.extraMonitorStatus = r1;
            return this;
        }

        public Builder force(boolean r1) {
            this.force = r1;
            return this;
        }

        public Builder forceWifiBound(boolean r1) {
            this.forceWifiBound = r1;
            return this;
        }

        public Builder iconUrl(String r1) {
            this.iconUrl = r1;
            return this;
        }

        public Builder ignoreDataVerify(boolean r1) {
            this.ignoreDataVerify = r1;
            return this;
        }

        public Builder ignoreInterceptor(boolean r1) {
            this.ignoreInterceptor = r1;
            return this;
        }

        public Builder isOpenLimitSpeed(boolean r1) {
            this.openLimitSpeed = r1;
            return this;
        }

        public Builder maxBytes(int r1) {
            this.maxBytes = r1;
            return this;
        }

        public Builder maxProgressCount(int r1) {
            this.maxProgressCount = r1;
            return this;
        }

        public Builder md5(String r1) {
            this.md5 = r1;
            return this;
        }

        public Builder mimeType(String r1) {
            this.mimeType = r1;
            return this;
        }

        public Builder minProgressTimeMsInterval(int r1) {
            this.minProgressTimeMsInterval = r1;
            return this;
        }

        public Builder monitorScene(String r1) {
            this.monitorScene = r1;
            return this;
        }

        public Builder name(String r1) {
            this.name = r1;
            return this;
        }

        public Builder needCurrentProcess(boolean r1) {
            this.needCurrentProcess = r1;
            return this;
        }

        public Builder needDefaultHttpServiceBackUp(boolean r1) {
            this.needDefaultHttpServiceBackUp = r1;
            return this;
        }

        public Builder needHttpsToHttpRetry(boolean r1) {
            this.needHttpsToHttpRetry = r1;
            return this;
        }

        public Builder needIndependentProcess(boolean r1) {
            this.needIndependentProcess = r1;
            return this;
        }

        public Builder needPostProgress(boolean r1) {
            this.needPostProgress = r1;
            return this;
        }

        public Builder needSDKMonitor(boolean r1) {
            this.needSDKMonitor = r1;
            return this;
        }

        public Builder onlyWifi(boolean r1) {
            this.onlyWifi = r1;
            return this;
        }

        public Builder outIp(String[] r1) {
            this.outIp = r1;
            return this;
        }

        public Builder outSize(int[] r1) {
            this.outSize = r1;
            return this;
        }

        public Builder packageName(String r1) {
            this.packageName = r1;
            return this;
        }

        public Builder pcdnUrls(List<String> r1) {
            this.pcdnUrls = r1;
            return this;
        }

        public Builder retryCount(int r1) {
            this.retryCount = r1;
            return this;
        }

        public Builder savePath(String r1) {
            this.savePath = r1;
            return this;
        }

        public Builder setAutoInstall(boolean r1) {
            this.autoInstall = r1;
            return this;
        }

        public Builder showNotification(boolean r1) {
            this.showNotification = r1;
            return this;
        }

        public Builder showNotificationForAutoResumed(boolean r1) {
            this.showNotificationForAutoResumed = r1;
            return this;
        }

        public Builder startOffset(long r4) {
            if (r4 <= 0) goto L5;
            this.startOffset = r4;
        L5:
            return this;
        }

        public Builder taskKey(String r1) {
            this.taskKey = r1;
            return this;
        }

        public Builder tempPath(String r1) {
            this.tempPath = r1;
            return this;
        }

        public Builder throttleNetSpeed(long r1) {
            this.throttleNetSpeed = r1;
            return this;
        }

        public Builder throttleSmoothness(int r1) {
            this.throttleSmoothness = r1;
            return this;
        }

        public Builder title(String r1) {
            this.title = r1;
            return this;
        }

        public Builder ttnetByPassProxy(boolean r1) {
            this.ttnetByPassProxy = r1;
            return this;
        }

        public Builder ttnetProtectTimeout(long r1) {
            this.ttnetProtectTimeout = r1;
            return this;
        }

        public Builder url(String r1) {
            this.url = r1;
            return this;
        }
    }

    public static class RawBuilder extends Builder {
        public long backCurBytes;
        public String backUpUrlsStr;
        public String cdnUrlsStr;
        public int chunkCount;
        public long curBytes;
        public int curRetryTime;
        public String dbJsonDataString;
        public long downloadFinishTimeStamp;
        public long downloadStartTimeStamp;
        public long downloadTime;
        public String etag;
        public boolean hasDoInstallation;
        public int id;
        public long installedTimeStamp;
        public boolean isFirstDownload;
        public boolean isFirstSuccess;
        public int notificationVisibility;
        public String pcdnUrlsStr;
        public long realBackDownloadTime;
        public long realDownloadTime;
        public int status;
        public long totalBytes;

        @Override // com.ss.android.socialbase.downloader.model.DownloadInfo.Builder
        public DownloadInfo build() {
            return new DownloadInfo(this, null);
        }

        public RawBuilder() {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setDeleteCacheIfCheckFailed() {
        this.deleteCacheIfCheckFailed = true;
    }

    public void setForbiddenRetryed() {
        this.isForbiddenRetryed = true;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    private void ensureDBJsonData() {
        if (this.dbJsonData != null) goto L18;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.dbJsonData == null) goto L20;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L20:
    L12:
        this.dbJsonData = new JSONObject();     // Catch: Throwable -> L15
        goto L13
    L8:
        if (TextUtils.isEmpty(this.dbJsonDataString) == true) goto L10;
        this.dbJsonData = new JSONObject(this.dbJsonDataString);     // Catch: Throwable -> L12
        this.dbJsonDataString = null;     // Catch: Throwable -> L12
    L19:
    L10:
        this.dbJsonData = new JSONObject();     // Catch: Throwable -> L12
        goto L19
    }

    private void ensureSpData() {
        if (this.spData != null) goto L18;
        Context r0 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r0 == null) goto L13;
        String r1 = r0.getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0).getString(Long.toString(getId()), "");
        if (TextUtils.isEmpty(r1) == true) goto L13;
        this.spData = new JSONObject(r1);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L13:
        if (this.spData != null) goto L19;
        this.spData = new JSONObject();
        return;
    L19:
        return;
    }

    private void ensureTempCacheData() {
        if (this.tempCacheData != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.tempCacheData != null) goto L8;
        this.tempCacheData = new ConcurrentHashMap();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    private void parseMonitorSetting() {
        if (OPTIMIZE_MONITOR_LOAD == true) goto L5;
    L7:
        unsafeEnsureDBJsonData();
        int r2 = 0;
        this.needSDKMonitor = this.dbJsonData.optBoolean("need_sdk_monitor", false);
        this.monitorScene = this.dbJsonData.optString("monitor_scene", "");
        JSONArray r0 = this.dbJsonData.optJSONArray("extra_monitor_status");
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.length() <= 0) goto L17;
        this.extraMonitorStatus = new int[r0.length()];
    L13:
        if (r2 >= r0.length()) goto L18;
        this.extraMonitorStatus[r2] = r0.optInt(r2);
        r2 = r2 + 1;
        goto L13
    L18:
        return;
    L17:
        return;
    L5:
        if (TextUtils.isEmpty(this.monitorScene) == true) goto L7;
    }

    public boolean canNotifyProgress() {
        if (this.lastNotifyProgressTime != 0) goto L5;
    L8:
        return true;
    L5:
        if ((SystemClock.uptimeMillis() - this.lastNotifyProgressTime) > 20) goto L8;
        return false;
    }

    public boolean canReplaceHttpForRetry() {
        if (TextUtils.isEmpty(this.url) == false) goto L5;
    L11:
        return false;
    L5:
        if (this.url.startsWith("https") == false) goto L11;
        if (this.needHttpsToHttpRetry == false) goto L11;
        if (this.httpsToHttpRetryUsed == true) goto L11;
        return true;
    }

    public boolean canShowNotification() {
        boolean r0 = this.autoResumed;
        if (r0 == false) goto L5;
    L6:
        if (r0 == true) goto L8;
    L12:
        return false;
    L8:
        if (this.showNotificationForAutoResumed == false) goto L10;
    L11:
        return true;
    L10:
        if (this.showNotificationForNetworkResumed == false) goto L12;
    L5:
        if (this.showNotification == true) goto L11;
        goto L6
    }

    public int checkMd5Status() {
        return DownloadUtils.checkMd5Status(new DownloadFile(getSavePath(), getName()), this.md5);
    }

    public void erase() {
        setCurBytes(0, true);
        setBackCurBytes(0);
        this.totalBytes = 0;
        this.chunkCount = 1;
        this.downloadTime = 0;
        this.realStartDownloadTime = 0;
        this.realDownloadTime = 0;
        this.realBackDownloadTime = 0;
        this.curRetryTime = 0;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.backUpUrlUsed = false;
        this.httpsToHttpRetryUsed = false;
        this.eTag = null;
        this.failedException = null;
        this.tempCacheData = null;
        this.packageInfoRef = null;
    }

    public long getBackCurBytes() {
        AtomicLong r0 = this.backCurBytes;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.get();
    }

    public String getBackUpUrl() {
        if (this.backUpUrlUsed == false) goto L15;
        List<String> r0 = this.backUpUrls;
        if (r0 == null) goto L15;
        if (r0.size() <= 0) goto L15;
        int r1 = this.curBackUpUrlIndex;
        if (r1 < 0) goto L15;
        if (r1 >= this.backUpUrls.size()) goto L15;
        String r2 = (String) ListProtector.get(this.backUpUrls, this.curBackUpUrlIndex);
        if (TextUtils.isEmpty(r2) == true) goto L15;
        return r2;
    L15:
        return "";
    }

    public String getBackUpUrlsStr() {
        if (this.backUpUrlsStr != null) goto L6;
        this.backUpUrlsStr = DownloadUtils.listToJsonString(this.backUpUrls);
    L6:
        return this.backUpUrlsStr;
    }

    public String getCdnUrlsStr() {
        if (this.cdnUrlsStr != null) goto L6;
        this.cdnUrlsStr = DownloadUtils.listToJsonString(this.cdnUrls);
    L6:
        return this.cdnUrlsStr;
    }

    public String getConnectionUrl() {
        String r0 = this.url;
        if (getStatus() != 8) goto L12;
        List<String> r1 = this.forbiddenBackupUrls;
        if (r1 == null) goto L12;
        if (r1.isEmpty() == true) goto L12;
        if (this.backUpUrlUsed == true) goto L12;
        return (String) ListProtector.get(this.forbiddenBackupUrls, 0);
    L12:
        if (this.backUpUrlUsed == false) goto L25;
        List<String> r2 = this.backUpUrls;
        if (r2 == null) goto L25;
        if (r2.size() <= 0) goto L25;
        int r3 = this.curBackUpUrlIndex;
        if (r3 < 0) goto L25;
        if (r3 >= this.backUpUrls.size()) goto L25;
        String r4 = (String) ListProtector.get(this.backUpUrls, this.curBackUpUrlIndex);
        if (TextUtils.isEmpty(r4) == false) goto L36;
        return r0;
    L36:
        return r4;
    L25:
        if (TextUtils.isEmpty(this.url) == false) goto L27;
        return r0;
    L27:
        if (this.url.startsWith("https") == true) goto L29;
        return r0;
    L29:
        if (this.needHttpsToHttpRetry == true) goto L31;
        return r0;
    L31:
        if (this.httpsToHttpRetryUsed == true) goto L33;
        return r0;
    L33:
        return this.url.replaceFirst("https", "http");
    }

    public long getCurBytes() {
        AtomicLong r0 = this.curBytes;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.get();
    }

    public int getCurRetryTimeInTotal() {
        int r0 = this.curRetryTime;
        if (this.backUpUrlUsed == false) goto L8;
        int r1 = r0 + this.retryCount;
        int r2 = this.curBackUpUrlIndex;
        if (r2 > 0) goto L7;
        return r1;
    L7:
        return r1 + (r2 * this.backUpUrlRetryCount);
    L8:
        return r0;
    }

    public String getDBJsonDataString() {
        String r0 = this.dbJsonDataString;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ensureDBJsonData();
        JSONObject r1 = this.dbJsonData;
        monitor-enter(r1);
        String r2 = this.dbJsonData.toString();     // Catch: Throwable -> L10
        this.dbJsonDataString = r2;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public int getDownloadProcess() {
        if (this.totalBytes > 0) goto L7;
        return 0;
    L7:
        if (getCurBytes() <= this.totalBytes) goto L11;
        return 100;
    L11:
        return (int) ((getCurBytes() * 100) / this.totalBytes);
    }

    public int getId() {
        if (this.id != 0) goto L6;
        this.id = ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).generate(this);
    L6:
        return this.id;
    }

    public int getMinProgressTimeMsInterval() {
        int r0 = this.minProgressTimeMsInterval;
        if (r0 >= 1000) goto L6;
        return 1000;
    L6:
        return r0;
    }

    public PackageInfo getPackageInfo() {
        SoftReference<PackageInfo> r0 = this.packageInfoRef;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    public String getPcdnUrlsStr() {
        if (this.pcdnUrlsStr != null) goto L6;
        this.pcdnUrlsStr = DownloadUtils.listToJsonString(this.pcdnUrls);
    L6:
        return this.pcdnUrlsStr;
    }

    public long getRealBackDownloadTime() {
        return TimeUnit.NANOSECONDS.toMillis(this.realBackDownloadTime);
    }

    public long getRealDownloadTime() {
        return TimeUnit.NANOSECONDS.toMillis(this.realDownloadTime);
    }

    public int getRealStatus() {
        AtomicInteger r0 = this.status;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.get();
    }

    public int getStatus() {
        AtomicInteger r0 = this.status;
        if (r0 == null) goto L8;
        int r1 = r0.get();
        if (r1 != (-5)) goto L10;
        return -2;
    L10:
        return r1;
    L8:
        return 0;
    }

    public String getTargetFilePath() {
        return DownloadUtils.getTargetFilePath(this.savePath, this.name);
    }

    public String getTempFilePath() {
        return DownloadUtils.getTempFilePath(this.savePath, this.tempPath, this.name);
    }

    public String getTempName() {
        return DownloadUtils.getTempFileName(this.name);
    }

    public String getTempPath() {
        return DownloadUtils.getTempFileSavePath(this.savePath, this.tempPath);
    }

    public String getTitle() {
        if (TextUtils.isEmpty(this.title) == false) goto L7;
        return this.name;
    L7:
        return this.title;
    }

    public int getTotalRetryCount() {
        int r0 = this.retryCount;
        List<String> r1 = this.backUpUrls;
        if (r1 != null) goto L5;
        return r0;
    L5:
        if (r1.isEmpty() == false) goto L7;
        return r0;
    L7:
        return r0 + (this.backUpUrlRetryCount * this.backUpUrls.size());
    }

    public boolean hasNextBackupUrl() {
        List<String> r0 = this.backUpUrls;
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (r0.size() <= 0) goto L13;
        if (this.backUpUrlUsed == false) goto L15;
        int r1 = this.curBackUpUrlIndex;
        if (r1 < 0) goto L13;
        if (r1 >= (this.backUpUrls.size() - 1)) goto L13;
        return true;
    L15:
        return true;
    }

    public boolean isAutoInstallWithoutNotification() {
        if (this.isAutoInstallWithoutNotification != null) goto L11;
        if (TextUtils.isEmpty(this.extra) == false) goto L12;
        this.isAutoInstallWithoutNotification = Boolean.FALSE;
        goto L11
    L12:
        this.isAutoInstallWithoutNotification = Boolean.valueOf(new JSONObject(this.extra).optBoolean(DownloadConstants.AUTO_INSTALL_WITHOUT_NOTIFICATION, false));     // Catch: JSONException -> L8
    L8:
        this.isAutoInstallWithoutNotification = Boolean.FALSE;
    L11:
        return this.isAutoInstallWithoutNotification.booleanValue();
    }

    public boolean isChunked() {
        return DownloadUtils.isChunkedTask(this.totalBytes);
    }

    public boolean isEntityInvalid() {
        if (TextUtils.isEmpty(this.url) == false) goto L5;
    L10:
        return true;
    L5:
        if (TextUtils.isEmpty(this.name) == true) goto L10;
        if (TextUtils.isEmpty(this.savePath) == true) goto L10;
        return false;
    }

    public boolean isFirstDownload() {
        if (this.isFirstDownload == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(getTempPath()) == false) goto L8;
    L12:
        return false;
    L8:
        if (TextUtils.isEmpty(getTempName()) == true) goto L12;
        return !new PolarisFileWrapper(getTempPath(), getTempName()).exists();
    }

    public boolean isIgnoreInterceptor() {
        if (this.ignoreInterceptor != null) goto L9;
        ensureDBJsonData();
        boolean r2 = false;
        if (this.dbJsonData.optInt("ignore_intercept", 0) != 1) goto L7;
        r2 = true;
    L7:
        this.ignoreInterceptor = Boolean.valueOf(r2);
    L9:
        return this.ignoreInterceptor.booleanValue();
    }

    public boolean isPauseByNotification() {
        if (TextUtils.isEmpty(this.extra) == true) goto L12;
        return new JSONObject(this.extra).optBoolean(DownloadConstants.PAUSE_BY_NOTIFICATION);
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    L12:
        return false;
    }

    public boolean isPauseReserveWithWifiValid() {
        if (this.mDownloadFromReserveWifi == true) goto L5;
        return true;
    L5:
        if (isPauseReserveOnWifi() == true) goto L7;
    L9:
        return false;
    L7:
        if (DownloadUtils.isWifi(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()) == false) goto L9;
        return true;
    }

    public boolean isWaitingWifiStatus() {
        BaseException r0 = this.failedException;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getErrorCode() != 1013) goto L7;
        return true;
    }

    public void reset() {
        setCurBytes(0, true);
        setBackCurBytes(0);
        this.totalBytes = 0;
        this.chunkCount = 1;
        this.downloadTime = 0;
        this.realStartDownloadTime = 0;
        this.realDownloadTime = 0;
        this.realBackDownloadTime = 0;
    }

    public void resetCacheLifeTimeMax() {
        this.cacheLifeTimeMax = 0;
    }

    public void resetRealStartDownloadTime() {
        this.realStartDownloadTime = 0;
    }

    public String toDetailString() {
        return "DownloadInfo{id=" + this.id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "', tempPath='" + this.tempPath + "', onlyWifi=" + this.onlyWifi + ", extra='" + this.extra + "', extraHeaders=" + this.extraHeaders + ", maxBytes=" + this.maxBytes + ", outIp=" + Arrays.toString(this.outIp) + ", outSize=" + Arrays.toString(this.outSize) + ", retryCount=" + this.retryCount + ", backUpUrlRetryCount=" + this.backUpUrlRetryCount + ", force=" + this.force + ", needPostProgress=" + this.needPostProgress + ", maxProgressCount=" + this.maxProgressCount + ", minProgressTimeMsInterval=" + this.minProgressTimeMsInterval + ", backUpUrls=" + this.backUpUrls + ", showNotification=" + this.showNotification + ", mimeType='" + this.mimeType + "', needHttpsToHttpRetry=" + this.needHttpsToHttpRetry + ", cacheLifeTimeMax=" + this.cacheLifeTimeMax + ", pcdnUrls=" + this.pcdnUrls + ", cdnUrls=" + this.cdnUrls + ", pcdnUrlsStr='" + this.pcdnUrlsStr + "', cdnUrlsStr='" + this.cdnUrlsStr + "', packageName='" + this.packageName + "', filePackageName='" + this.filePackageName + "', md5='" + this.md5 + "', allConnectTime=" + this.allConnectTime + ", needDefaultHttpServiceBackUp=" + this.needDefaultHttpServiceBackUp + ", eTag='" + this.eTag + "', curRetryTime=" + this.curRetryTime + ", asyncHandleStatus=" + this.asyncHandleStatus + ", ignoreDataVerify=" + this.ignoreDataVerify + ", needIndependentProcess=" + this.needIndependentProcess + ", needCurrentProcess=" + this.needCurrentProcess + ", supportPartial=" + this.supportPartial + ", iconUrl='" + this.iconUrl + "', curNetworkRetryCount=" + this.curNetworkRetryCount + ", needSDKMonitor=" + this.needSDKMonitor + ", monitorScene='" + this.monitorScene + "', extraMonitorStatus=" + Arrays.toString(this.extraMonitorStatus) + ", expiredRedownload=" + this.expiredRedownload + ", expiredHttpCheck=" + this.expiredHttpCheck + ", deleteCacheIfCheckFailed=" + this.deleteCacheIfCheckFailed + ", successByCache=" + this.successByCache + ", ignoreInterceptor=" + this.ignoreInterceptor + ", interceptFlag=" + this.interceptFlag + ", downloadStartTimeStamp=" + this.downloadStartTimeStamp + ", downloadFinishTimeStamp=" + this.downloadFinishTimeStamp + ", installedTimeStamp=" + this.installedTimeStamp + ", hasDoInstallation=" + this.hasDoInstallation + ", networkQuality='" + this.networkQuality + "', curBackUpUrlIndex=" + this.curBackUpUrlIndex + ", notificationVisibility=" + this.notificationVisibility + ", chunkCount=" + this.chunkCount + ", curBytes=" + this.curBytes + ", totalBytes=" + this.totalBytes + ", xTotalBytes=" + this.xTotalBytes + ", status=" + this.status + ", isFirstDownload=" + this.isFirstDownload + ", isFirstSuccess=" + this.isFirstSuccess + ", downloadTime=" + this.downloadTime + ", realDownloadTime=" + this.realDownloadTime + ", backUpUrlUsed=" + this.backUpUrlUsed + ", httpsToHttpRetryUsed=" + this.httpsToHttpRetryUsed + ", startDownloadTime=" + this.startDownloadTime + ", realStartDownloadTime=" + this.realStartDownloadTime + ", bindValueCount=" + this.bindValueCount + ", autoResumed=" + this.autoResumed + ", showNotificationForAutoResumed=" + this.showNotificationForAutoResumed + ", showNotificationForNetworkResumed=" + this.showNotificationForNetworkResumed + ", forbiddenBackupUrls=" + this.forbiddenBackupUrls + ", byteInvalidRetryStatus=" + this.byteInvalidRetryStatus + ", enqueueType=" + this.enqueueType + ", httpStatusCode=" + this.httpStatusCode + ", httpStatusMessage='" + this.httpStatusMessage + "', lastNotifyProgressTime=" + this.lastNotifyProgressTime + ", isForbiddenRetryed=" + this.isForbiddenRetryed + ", appVersionCode=" + this.appVersionCode + ", throttleNetSpeed=" + this.throttleNetSpeed + ", throttleSmoothness=" + this.throttleSmoothness + ", openLimitSpeed=" + this.openLimitSpeed + ", isCacheExistsInDownloading=" + this.isCacheExistsInDownloading + ", contentEncoding='" + this.contentEncoding + "', addListenerToSameTask=" + this.addListenerToSameTask + ", backUpUrlsStr='" + this.backUpUrlsStr + "', failedException=" + this.failedException + ", pcdnStats=" + this.pcdnStats + ", spData=" + this.spData + ", dbJsonData=" + this.dbJsonData + ", dbJsonDataString='" + this.dbJsonDataString + "', tempCacheData=" + this.tempCacheData + ", statusAtDbInit=" + this.statusAtDbInit + ", mDownloadFromReserveWifi=" + this.mDownloadFromReserveWifi + ", packageInfoRef=" + this.packageInfoRef + ", ttnetProtectTimeout=" + this.ttnetProtectTimeout + ", addTTNetCommonParam=" + this.addTTNetCommonParam + ", ttnetByPassProxy=" + this.ttnetByPassProxy + ", accessHttpHeaderKeys=" + this.accessHttpHeaderKeys + ", httpHeaders=" + this.httpHeaders + ", isAutoInstallWithoutNotification=" + this.isAutoInstallWithoutNotification + ", callStack=" + this.callStack + '}';
    }

    public String toString() {
        return "DownloadInfo{id=" + this.id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "'}";
    }

    public boolean trySwitchToNextBackupUrl() {
        if (this.backUpUrlUsed == false) goto L5;
        this.curBackUpUrlIndex++;
    L5:
        List<String> r0 = this.backUpUrls;
        if (r0 != null) goto L8;
    L19:
        return false;
    L8:
        if (r0.size() == 0) goto L19;
        if (this.curBackUpUrlIndex < 0) goto L19;
    L13:
        if (this.curBackUpUrlIndex >= this.backUpUrls.size()) goto L19;
        if (TextUtils.isEmpty((String) ListProtector.get(this.backUpUrls, this.curBackUpUrlIndex)) == false) goto L16;
        this.curBackUpUrlIndex++;
        goto L13
    L16:
        this.backUpUrlUsed = true;
        return true;
    }

    public void unsafeEnsureDBJsonData() {
        if (this.dbJsonData == null) goto L14;
        return;
    L14:
    L10:
        this.dbJsonData = new JSONObject();
    L11:
        this.dbJsonDataString = null;
        return;
    L6:
        if (TextUtils.isEmpty(this.dbJsonDataString) == true) goto L8;
        this.dbJsonData = new JSONObject(this.dbJsonDataString);     // Catch: Throwable -> L10
    L13:
        goto L11
    L8:
        this.dbJsonData = new JSONObject();     // Catch: Throwable -> L10
        goto L13
    }

    public void updateDownloadTime() {
        if (this.startDownloadTime != 0) goto L5;
        return;
    L5:
        long r0 = SystemClock.uptimeMillis() - this.startDownloadTime;
        if (this.downloadTime >= 0) goto L9;
        this.downloadTime = 0;
    L9:
        if (r0 <= 0) goto L12;
        this.downloadTime = r0;
        return;
    }

    public void updateRealStartDownloadTime() {
        if (this.realStartDownloadTime != 0) goto L6;
        this.realStartDownloadTime = System.nanoTime();
        return;
    }

    public void updateSpData() {
        if (this.spData != null) goto L5;
        return;
    L5:
        Context r0 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r0 == null) goto L9;
        r0.getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0).edit().putString(Integer.toString(getId()), this.spData.toString()).apply();
        return;
    }

    public DownloadInfo() {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0;
        this.downloadFinishTimeStamp = 0;
        this.installedTimeStamp = 0;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
    }

    private int getReserveWifiStatus() {
        ensureSpData();
        return this.spData.optInt("pause_reserve_on_wifi", 0);
    L8:
        return 0;
    }

    public boolean cacheExpierd() {
        if (isDownloaded() == true) goto L7;
        return true;
    L7:
        return DownloadUtils.cacheExpired(this);
    }

    public boolean canReStartAsyncTask() {
        if (getStatus() != (-3)) goto L5;
    L7:
        return false;
    L5:
        if (this.asyncHandleStatus != AsyncHandleStatus.ASYNC_HANDLE_WAITING) goto L7;
        return true;
    }

    public boolean canSkipStatusHandler() {
        if (getStatus() == 8) goto L12;
        AsyncHandleStatus r0 = this.asyncHandleStatus;
        if (r0 == AsyncHandleStatus.ASYNC_HANDLE_WAITING) goto L12;
        if (r0 == AsyncHandleStatus.ASYNC_HANDLE_RESTART) goto L12;
        if (this.byteInvalidRetryStatus == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART) goto L12;
        return false;
    L12:
        return true;
    }

    public void changeSkipStatus() {
        if (getStatus() == 8) goto L8;
        AsyncHandleStatus r0 = this.asyncHandleStatus;
        if (r0 == AsyncHandleStatus.ASYNC_HANDLE_WAITING) goto L8;
        if (r0 == AsyncHandleStatus.ASYNC_HANDLE_RESTART) goto L8;
    L10:
        if (this.byteInvalidRetryStatus != ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART) goto L13;
        setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        return;
    L13:
        return;
    L8:
        setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING);
        goto L10
    }

    public boolean checkMd5Valid() {
        return DownloadUtils.checkMd5Valid(getSavePath(), getName(), this.md5);
    }

    public long getAllConnectTime() {
        ensureDBJsonData();
        if (this.allConnectTime != null) goto L6;
        this.allConnectTime = new AtomicLong(this.dbJsonData.optLong("dbjson_key_all_connect_time"));
    L6:
        return this.allConnectTime.get();
    }

    public long getCacheExpiredTime() {
        ensureSpData();
        return this.spData.optLong("cache-control/expired_time", -1);
    L8:
        return -1;
    }

    public long getDownloadPrepareTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_download_prepare_time");
    }

    public String getDownloadSettingString() {
        ensureDBJsonData();
        return this.dbJsonData.optString("download_setting");
    }

    public double getDownloadSpeed() {
        double r0 = getCurBytes() / 1048576.0d;
        double r2 = getRealDownloadTime() / 1000.0d;
        if (r0 > 0.0d) goto L5;
    L7:
        return -1.0d;
    L5:
        if (r2 <= 0.0d) goto L7;
        return r0 / r2;
    }

    public long getEndOffset() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("end_offset", -1);
    }

    public int getExecutorGroup() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("executor_group", 2);
    }

    public long getExpectFileLength() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_expect_file_length");
    }

    public int getFailedResumeCount() {
        ensureSpData();
        return this.spData.optInt("failed_resume_count", 0);
    }

    public long getFirstSpeedTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_first_speed_time");
    }

    public String getInstallBizParamsJson() {
        ensureSpData();
        return this.spData.optString("install_biz_params_json");
    }

    public String getInstallBizType() {
        ensureSpData();
        return this.spData.optString("install_biz_type");
    }

    public String getInstallCertId() {
        ensureSpData();
        return this.spData.optString("install_cert_id");
    }

    public long getLastDownloadTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_last_start_download_time", 0);
    }

    public long getLastFailedResumeTime() {
        ensureSpData();
        return this.spData.optLong("last_failed_resume_time", 0);
    }

    public String getLastModified() {
        ensureSpData();
        return this.spData.optString(DownloadHelper.LAST_MODIFIED, null);
    L8:
        return null;
    }

    public long getLastUninstallResumeTime() {
        ensureSpData();
        return this.spData.optLong("last_unins_resume_time", 0);
    }

    public int getLinkMode() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("link_mode");
    }

    public PackageInfo getPackageInfoWithCache() {
        ensureDBJsonData();
        String r0 = this.dbJsonData.optString("app_package_info");
        if (TextUtils.isEmpty(r0) == false) goto L10;
        return null;
    L10:
        String[] r1 = r0.split(",");     // Catch: Throwable -> L7
        PackageInfo r2 = new PackageInfo();     // Catch: Throwable -> L7
        r2.packageName = r1[0];     // Catch: Throwable -> L7
        r2.versionName = r1[1];     // Catch: Throwable -> L7
        r2.versionCode = CastIntegerProtector.parseInt(r1[2]);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public int getPausedResumeCount() {
        ensureSpData();
        return this.spData.optInt(DownloadConstants.KEY_PAUSED_RESUME_COUNT, 0);
    }

    public String getRedirectPartialUrlResults() {
        ensureDBJsonData();
        return this.dbJsonData.optString("redirect_partial_url_results");
    }

    public int getRetryScheduleCount() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("retry_schedule_count", 0);
    }

    public long getStartOffset() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("start_offset");
    }

    public int getTTMd5CheckStatus() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("ttmd5_check_status", -1);
    }

    public String getTaskKey() {
        ensureDBJsonData();
        return this.dbJsonData.optString("task_key");
    }

    public ConcurrentHashMap<String, Object> getTempCacheData() {
        ensureTempCacheData();
        return this.tempCacheData;
    }

    public int getUninstallResumeCount() {
        ensureSpData();
        return this.spData.optInt("unins_resume_count", 0);
    }

    public boolean hasPauseReservedOnWifi() {
        if ((getReserveWifiStatus() & 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isAutoInstall() {
        ensureDBJsonData();
        if (this.dbJsonData.optInt("auto_install", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isCanResumeFromBreakPointStatus() {
        int r0 = getStatus();
        if (r0 != 4) goto L5;
        return true;
    L5:
        if (r0 != 3) goto L7;
        return true;
    L7:
        if (r0 != (-1)) goto L9;
        return true;
    L9:
        if (r0 != 5) goto L11;
        return true;
    L11:
        if (r0 == 8) goto L24;
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L16;
    L18:
        return false;
    L16:
        if (getCurBytes() <= 0) goto L18;
        return true;
    L24:
        return true;
    }

    public boolean isDownloadOverStatus() {
        return DownloadStatus.isDownloadOver(getStatus());
    }

    public boolean isDownloadWithWifiValid() {
        if (isOnlyWifi() == true) goto L5;
    L8:
        return true;
    L5:
        if (DownloadUtils.isWifi(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()) == true) goto L8;
        return false;
    }

    public boolean isDownloaded() {
        return DownloadUtils.isFileDownloaded(this);
    }

    public boolean isDownloadingStatus() {
        return DownloadStatus.isDownloading(getStatus());
    }

    public boolean isFileDataExists() {
        if (isEntityInvalid() == false) goto L5;
        return false;
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(getTempPath(), getTempName());
        boolean r2 = r0.exists();
        boolean r1 = r0.isDirectory();
        if (r2 == false) goto L11;
        if (r1 == true) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean isFileDataValid() {
        if (isEntityInvalid() == false) goto L5;
        return false;
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(getTempPath(), getTempName());
        boolean r2 = r0.exists();
        boolean r3 = r0.isDirectory();
        if (Logger.debugScene(this) == false) goto L8;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Temp file:" + r0 + "IsExists:" + r2 + " isDirectory: " + r3);
    L8:
        if (r2 == false) goto L30;
        if (r3 == true) goto L30;
        long r4 = r0.length();
        long r7 = getCurBytes();
        if (r7 <= 0) goto L28;
        long r11 = this.totalBytes;
        if (r11 <= 0) goto L28;
        if (this.chunkCount <= 0) goto L28;
        if (r4 < r7) goto L28;
        if (r4 > r11) goto L28;
        if (Logger.debugScene(this) == false) goto L31;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Valid, FileLength+" + r4 + " curBytes:" + r7);
        return true;
    L31:
        return true;
    L28:
        if (Logger.debugScene(this) == false) goto L30;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Invalid, Cur = " + r7 + ",totalBytes =" + this.totalBytes + ",fileLength=" + r4 + ", chunkCount:" + this.chunkCount);
    L30:
        return false;
    }

    public boolean isFileDataValidOptimize() {
        if (isEntityInvalid() == false) goto L5;
        return false;
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(getTempPath(), getTempName());
        boolean r2 = r0.exists();
        if (r2 == false) goto L8;
        boolean r3 = r0.isDirectory();
        if (r3 == true) goto L14;
        long r4 = getCurBytes();
        if (r4 <= 0) goto L39;
        if (this.totalBytes <= 0) goto L39;
        if (this.chunkCount <= 0) goto L39;
        long r9 = r0.length();
        if (r9 < r4) goto L35;
        if (r9 > this.totalBytes) goto L35;
        if (Logger.debugScene(this) == false) goto L42;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Valid, FileLength+" + r9 + " curBytes:" + r4);
        return true;
    L42:
        return true;
    L35:
        if (Logger.debugScene(this) == false) goto L37;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Invalid, Cur = " + r4 + ",totalBytes =" + this.totalBytes + ",fileLength=" + r9 + ", chunkCount:" + this.chunkCount);
    L37:
        return false;
    L39:
        if (Logger.debugScene(this) == false) goto L41;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Invalid, Cur = " + r4 + ",totalBytes =" + this.totalBytes + ", chunkCount:" + this.chunkCount);
    L41:
        return false;
    L14:
        if (Logger.debugScene(this) == false) goto L16;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Temp file:" + r0 + "IsDirectory:" + r3);
    L16:
        return false;
    L8:
        if (Logger.debugScene(this) == false) goto L10;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Temp file:" + r0 + "IsExists:" + r2);
    L10:
        return false;
    }

    public boolean isNewTask() {
        if (getStatus() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPauseReserveOnWifi() {
        if ((getReserveWifiStatus() & 2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSavePathRedirected() {
        ensureDBJsonData();
        return this.dbJsonData.optBoolean("is_save_path_redirected", false);
    }

    public void setLastNotifyProgressTime() {
        this.lastNotifyProgressTime = SystemClock.uptimeMillis();
    }

    public void startPauseReserveOnWifi() {
        ensureSpData();
        this.spData.put("pause_reserve_on_wifi", 3);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    }

    public boolean statusInPause() {
        if (getRealStatus() != (-2)) goto L5;
    L8:
        return true;
    L5:
        if (getRealStatus() == (-5)) goto L8;
        return false;
    }

    public void stopPauseReserveOnWifi() {
        ensureSpData();
        this.spData.put("pause_reserve_on_wifi", 1);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    }

    public void updateStartDownloadTime() {
        this.startDownloadTime = SystemClock.uptimeMillis();
        if (this.fastDownload == false) goto L5;
        return;
    L5:
        safePutToDBJsonData("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
    }

    public List<String> getAccessHttpHeaderKeys() {
        return this.accessHttpHeaderKeys;
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public AsyncHandleStatus getAsyncHandleStatus() {
        return this.asyncHandleStatus;
    }

    public int getBackUpUrlRetryCount() {
        return this.backUpUrlRetryCount;
    }

    public List<String> getBackUpUrls() {
        return this.backUpUrls;
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public ByteInvalidRetryStatus getByteInvalidRetryStatus() {
        return this.byteInvalidRetryStatus;
    }

    public long getCacheLifeTimeMax() {
        return this.cacheLifeTimeMax;
    }

    public String getCallStack() {
        return this.callStack;
    }

    public List<String> getCdnUrls() {
        return this.cdnUrls;
    }

    public int getChunkCount() {
        return this.chunkCount;
    }

    public int getConcurrentConnCount() {
        return this.concurrentConnCount;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public int getCurBackUpUrlIndex() {
        return this.curBackUpUrlIndex;
    }

    public int getCurNetworkRetryCount() {
        return this.curNetworkRetryCount;
    }

    public int getCurRetryTime() {
        return this.curRetryTime;
    }

    public int getDBInitStatus() {
        return this.mDBInitStatus;
    }

    public long getDownloadFinishTimeStamp() {
        return this.downloadFinishTimeStamp;
    }

    public long getDownloadStartTimeStamp() {
        return this.downloadStartTimeStamp;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public EnqueueType getEnqueueType() {
        return this.enqueueType;
    }

    public String getExtra() {
        return this.extra;
    }

    public List<HttpHeader> getExtraHeaders() {
        return this.extraHeaders;
    }

    public int[] getExtraMonitorStatus() {
        return this.extraMonitorStatus;
    }

    public BaseException getFailedException() {
        return this.failedException;
    }

    public String getFilePackageName() {
        return this.filePackageName;
    }

    public List<String> getForbiddenBackupUrls() {
        return this.forbiddenBackupUrls;
    }

    public Map<String, String> getHttpHeaders() {
        return this.httpHeaders;
    }

    public String getHttpRequestHeader() {
        return this.httpRequestHeader;
    }

    public String getHttpResponseHeader() {
        return this.httpResponseHeader;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public String getHttpStatusMessage() {
        return this.httpStatusMessage;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getInstalledTimeStamp() {
        return this.installedTimeStamp;
    }

    public int getInterceptFlag() {
        return this.interceptFlag;
    }

    public boolean getIsFirstDownload() {
        return this.isFirstDownload;
    }

    public int getMaxBytes() {
        return this.maxBytes;
    }

    public int getMaxProgressCount() {
        return this.maxProgressCount;
    }

    public String getMd5() {
        return this.md5;
    }

    public long getMd5Time() {
        return this.md5Time;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getMonitorScene() {
        return this.monitorScene;
    }

    public String getName() {
        return this.name;
    }

    public String getNetworkQuality() {
        return this.networkQuality;
    }

    public int getNotificationVisibility() {
        return this.notificationVisibility;
    }

    public boolean getOpenLimitSpeed() {
        return this.openLimitSpeed;
    }

    public String[] getOutIp() {
        return this.outIp;
    }

    public int[] getOutSize() {
        return this.outSize;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public JSONObject getPcdnStats() {
        return this.pcdnStats;
    }

    public List<String> getPcdnUrls() {
        return this.pcdnUrls;
    }

    public long getRacingTaskExcessBytes() {
        return this.racingTaskExcessBytes;
    }

    public int getRawId() {
        return this.id;
    }

    public long getRawRealBackDownloadTime() {
        return this.realBackDownloadTime;
    }

    public long getRawRealDownloadTime() {
        return this.realDownloadTime;
    }

    public String getRawTempPath() {
        return this.tempPath;
    }

    public String getRawTitle() {
        return this.title;
    }

    public String getRequestLog() {
        return this.requestLog;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public int getStatusAtDbInit() {
        return this.statusAtDbInit;
    }

    public int getTaskSleepTime() {
        return this.mTaskSleepTime;
    }

    public long getThrottleNetSpeed() {
        return this.throttleNetSpeed;
    }

    public int getThrottleSmoothness() {
        return this.throttleSmoothness;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public long getTtnetProtectTimeout() {
        return this.ttnetProtectTimeout;
    }

    public String getUrl() {
        return this.url;
    }

    public long getVerifyCurBytes() {
        return this.verifyCurBytes;
    }

    public long getXTotalBytes() {
        return this.xTotalBytes;
    }

    public String geteTag() {
        return this.eTag;
    }

    public boolean isAddListenerToSameTask() {
        return this.addListenerToSameTask;
    }

    public boolean isAddTTNetCommonParam() {
        return this.addTTNetCommonParam;
    }

    public boolean isAutoResumed() {
        return this.autoResumed;
    }

    public boolean isBackUpUrlUsed() {
        return this.backUpUrlUsed;
    }

    public boolean isCacheExistsInDownloading() {
        return this.isCacheExistsInDownloading;
    }

    public boolean isDeleteCacheIfCheckFailed() {
        return this.deleteCacheIfCheckFailed;
    }

    public boolean isDownloadFromReserveWifi() {
        return this.mDownloadFromReserveWifi;
    }

    public boolean isExpiredHttpCheck() {
        return this.expiredHttpCheck;
    }

    public boolean isExpiredRedownload() {
        return this.expiredRedownload;
    }

    public boolean isFastDownload() {
        return this.fastDownload;
    }

    public boolean isFastDownloadCommonThreadPool() {
        return this.fastDownloadCommonThreadPool;
    }

    public boolean isFirstSuccess() {
        return this.isFirstSuccess;
    }

    public boolean isForbiddenRetryed() {
        return this.isForbiddenRetryed;
    }

    public boolean isForce() {
        return this.force;
    }

    public boolean isForceWifiBound() {
        return this.forceWifiBound;
    }

    public boolean isHandleRequest() {
        return this.handleRequest;
    }

    public boolean isHasDoInstallation() {
        return this.hasDoInstallation;
    }

    public boolean isHttpsToHttpRetryUsed() {
        return this.httpsToHttpRetryUsed;
    }

    public boolean isIgnoreDataVerify() {
        return this.ignoreDataVerify;
    }

    public boolean isNeedCurrentProcess() {
        return this.needCurrentProcess;
    }

    public boolean isNeedDefaultHttpServiceBackUp() {
        return this.needDefaultHttpServiceBackUp;
    }

    public boolean isNeedHttpsToHttpRetry() {
        return this.needHttpsToHttpRetry;
    }

    public boolean isNeedIndependentProcess() {
        return this.needIndependentProcess;
    }

    public boolean isNeedPostProgress() {
        return this.needPostProgress;
    }

    public boolean isNeedSDKMonitor() {
        return this.needSDKMonitor;
    }

    public boolean isOnlyWifi() {
        return this.onlyWifi;
    }

    public boolean isResumeFileDownload() {
        return this.resumeFileDownload;
    }

    public boolean isShowNotification() {
        return this.showNotification;
    }

    public boolean isShowNotificationForAutoResumed() {
        return this.showNotificationForAutoResumed;
    }

    public boolean isShowNotificationForNetworkResumed() {
        return this.showNotificationForNetworkResumed;
    }

    public boolean isSuccessByCache() {
        return this.successByCache;
    }

    public boolean isSupportPartial() {
        return this.supportPartial;
    }

    public boolean isTTNetByPassProxy() {
        return this.ttnetByPassProxy;
    }

    private DownloadInfo(Builder r6) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        int r1 = 0;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0;
        this.downloadFinishTimeStamp = 0;
        this.installedTimeStamp = 0;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
        if (r6 != null) goto L5;
        return;
    L5:
        this.status = new AtomicInteger(0);
        this.curBytes = new AtomicLong(0);
        this.monitorScene = r6.monitorScene;
        this.fastDownload = Builder.access$000(r6);
        this.fastDownloadCommonThreadPool = Builder.access$100(r6);
        this.resumeFileDownload = Builder.access$200(r6);
        this.name = r6.name;
        this.url = r6.url;
        String r0 = r6.savePath;
        if (TextUtils.isEmpty(r0) == true) goto L49;
    L11:
        this.savePath = r0;
        this.handleRequest = Builder.access$300(r6);
        this.backUpUrls = Builder.access$400(r6);
        this.concurrentConnCount = Builder.access$500(r6);
        if (Builder.access$000(r6) == false) goto L15;
        this.tempPath = DownloadDirUtils.getDownloadFastTempPath();
        return;
    L15:
        this.backCurBytes = new AtomicLong(0);
        this.tempPath = r6.tempPath;
        unsafeEnsureDBJsonData();
        unsafePutToDBJsonData("task_key", Builder.access$600(r6));
        if (TextUtils.isEmpty(this.tempPath) == false) goto L21;
        if (DownloadDirUtils.isSavePathSecurity(r0) == true) goto L21;
        this.tempPath = DownloadDirUtils.getDownloadTempPath();
    L21:
        if (Builder.access$700(r6) == true) goto L23;
    L25:
        this.extra = r6.extra;
        this.onlyWifi = r6.onlyWifi;
        this.extraHeaders = Builder.access$800(r6);
        this.maxBytes = Builder.access$900(r6);
        this.retryCount = r6.retryCount;
        this.backUpUrlRetryCount = r6.backUpUrlRetryCount;
        this.force = r6.force;
        this.outIp = Builder.access$1000(r6);
        this.outSize = Builder.access$1100(r6);
        this.needPostProgress = Builder.access$1200(r6);
        this.maxProgressCount = Builder.access$1300(r6);
        this.minProgressTimeMsInterval = Builder.access$1400(r6);
        this.showNotification = r6.showNotification;
        this.mimeType = r6.mimeType;
        this.needHttpsToHttpRetry = r6.needHttpsToHttpRetry;
        this.autoResumed = Builder.access$1500(r6);
        this.showNotificationForAutoResumed = Builder.access$1600(r6);
        this.needDefaultHttpServiceBackUp = r6.needDefaultHttpServiceBackUp;
        this.packageName = r6.packageName;
        this.md5 = r6.md5;
        this.needIndependentProcess = r6.needIndependentProcess;
        this.needCurrentProcess = r6.needCurrentProcess;
        this.enqueueType = Builder.access$1700(r6);
        this.ignoreDataVerify = Builder.access$1800(r6);
        this.addListenerToSameTask = Builder.access$1900(r6);
        this.iconUrl = r6.iconUrl;
        this.throttleNetSpeed = Builder.access$2000(r6);
        this.throttleSmoothness = Builder.access$2100(r6);
        this.forceWifiBound = Builder.access$2200(r6);
        this.openLimitSpeed = Builder.access$2300(r6);
        this.title = r6.title;
        this.callStack = r6.callStack;
        JSONObject r2 = Builder.access$2400(r6);
        if (r2 == null) goto L28;
        DownloadSetting.addTaskDownloadSetting(getId(), r6.monitorScene, r2);
        unsafePutToDBJsonData("download_setting", r2.toString());
    L28:
        unsafePutToDBJsonData("dbjson_key_expect_file_length", Long.valueOf(Builder.access$2500(r6)));
        unsafePutToDBJsonData("executor_group", Integer.valueOf(Builder.access$2600(r6)));
        unsafePutToDBJsonData("auto_install", Integer.valueOf(Builder.access$2700(r6) ? 1 : 0));
        this.needSDKMonitor = Builder.access$2800(r6);
        this.extraMonitorStatus = Builder.access$2900(r6);
        this.expiredRedownload = Builder.access$3000(r6);
        this.expiredHttpCheck = Builder.access$3100(r6);
        this.deleteCacheIfCheckFailed = Builder.access$3200(r6);
        this.ttnetProtectTimeout = Builder.access$3300(r6);
        this.addTTNetCommonParam = Builder.access$3400(r6);
        this.ttnetByPassProxy = Builder.access$3500(r6);
        Boolean r3 = Boolean.valueOf(Builder.access$3600(r6));
        this.ignoreInterceptor = r3;
        if (r3.booleanValue() == false) goto L31;
    L32:
        this.interceptFlag = 0;
    L33:
        this.accessHttpHeaderKeys = Builder.access$3700(r6);
        this.pcdnUrls = r6.pcdnUrls;
        this.cdnUrls = r6.cdnUrls;
        this.cacheLifeTimeMax = r6.cacheLifeTimeMax;
        unsafePutToDBJsonData("ignore_intercept", Integer.valueOf(Builder.access$3600(r6) ? 1 : 0));
        unsafePutToDBJsonData("start_offset", Long.valueOf(Builder.access$3800(r6)));
        unsafePutToDBJsonData("end_offset", Long.valueOf(Builder.access$3900(r6)));
        if (OPTIMIZE_MONITOR_LOAD == false) goto L36;
        return;
    L36:
        unsafePutToDBJsonData("need_sdk_monitor", Boolean.valueOf(this.needSDKMonitor));
        unsafePutToDBJsonData("monitor_scene", this.monitorScene);
        JSONArray r7 = new JSONArray();     // Catch: Throwable -> L46
        int[] r4 = this.extraMonitorStatus;     // Catch: Throwable -> L46
        if (r4 != null) goto L40;
    L44:
        unsafePutToDBJsonData("extra_monitor_status", r7);     // Catch: Throwable -> L46
        return;
    L40:
        if (r4.length <= 0) goto L44;
    L41:
        int[] r5 = this.extraMonitorStatus;     // Catch: Throwable -> L46
        if (r1 >= r5.length) goto L44;
        r7.put(r5[r1]);     // Catch: Throwable -> L46
        r1 = r1 + 1;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        if (((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getDownloadInterceptor() != null) goto L33;
    L23:
        if (((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getDownloadInfo(getId()) != null) goto L25;
        this.savePath = DownloadUtils.generateDistinctDirectory(this.savePath, this.url);
        this.tempPath = DownloadUtils.generateDistinctDirectory(this.tempPath, this.url);
        goto L25
    L49:
        r0 = DownloadDirUtils.getDownloadPath();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    private void convertEnqueueType(int r3) {
        EnqueueType r0 = EnqueueType.ENQUEUE_HEAD;
        if (r3 != r0.ordinal()) goto L5;
        this.enqueueType = r0;
        return;
    L5:
        EnqueueType r1 = EnqueueType.ENQUEUE_TAIL;
        if (r3 != r1.ordinal()) goto L8;
        this.enqueueType = r1;
        return;
    L8:
        EnqueueType r2 = EnqueueType.NEW_ENQUEUE_NORMAL;
        if (r3 != r2.ordinal()) goto L11;
        this.enqueueType = r2;
        return;
    L11:
        EnqueueType r4 = EnqueueType.NEW_ENQUEUE_IMMEDIATE;
        if (r3 != r4.ordinal()) goto L14;
        this.enqueueType = r4;
        return;
    L14:
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
    }

    private void mergeAuxiliaryJSONObject(JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        ensureDBJsonData();
        JSONObject r0 = this.dbJsonData;
        monitor-enter(r0);
        Iterator<String> r1 = r6.keys();     // Catch: Throwable -> L15 Exception -> L24
    L8:
        if (r1.hasNext() == false) goto L18;
        String r2 = r1.next();     // Catch: Throwable -> L15 Exception -> L24
        Object r3 = r6.opt(r2);     // Catch: Throwable -> L15 Exception -> L24
        if (this.dbJsonData.has(r2) == true) goto L8;
        if (r3 == null) goto L8;
        this.dbJsonData.put(r2, r3);     // Catch: Throwable -> L15 Exception -> L24
    L15:
        th = move-exception;
        throw th;
    L18:
        this.dbJsonDataString = null;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        parseMonitorSetting();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    private void refreshBackupUrls(boolean r3) {
        List<String> r0 = this.forbiddenBackupUrls;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= r3) goto L16;
        List<String> r1 = this.backUpUrls;
        if (r1 != null) goto L9;
        this.backUpUrls = new ArrayList();
    L10:
        this.backUpUrlUsed = false;
        this.curBackUpUrlIndex = 0;
        ?? r4 = r3;
    L12:
        if (r4 >= this.forbiddenBackupUrls.size()) goto L17;
        this.backUpUrls.add((String) ListProtector.get(this.forbiddenBackupUrls, r4));
        r4 = r4 + 1;
        goto L12
    L17:
        return;
    L9:
        r1.clear();
        goto L10
    }

    public static void setOptimizeMonitorLoad(boolean r0) {
        OPTIMIZE_MONITOR_LOAD = r0;
    }

    public void bindValue(SQLiteStatement r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.bindValueCount = 0;
        r10.clearBindings();
        int r0 = this.bindValueCount + 1;
        this.bindValueCount = r0;
        r10.bindLong(r0, this.id);
        int r1 = this.bindValueCount + 1;
        this.bindValueCount = r1;
        String r2 = this.url;
        String r3 = "";
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r10.bindString(r1, r2);
        int r4 = this.bindValueCount + 1;
        this.bindValueCount = r4;
        String r5 = this.savePath;
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r10.bindString(r4, r5);
        int r6 = this.bindValueCount + 1;
        this.bindValueCount = r6;
        String r7 = this.tempPath;
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        r10.bindString(r6, r7);
        int r8 = this.bindValueCount + 1;
        this.bindValueCount = r8;
        String r9 = this.name;
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        r10.bindString(r8, r9);
        int r11 = this.bindValueCount + 1;
        this.bindValueCount = r11;
        r10.bindLong(r11, this.chunkCount);
        int r12 = this.bindValueCount + 1;
        this.bindValueCount = r12;
        r10.bindLong(r12, getStatus());
        int r13 = this.bindValueCount + 1;
        this.bindValueCount = r13;
        r10.bindLong(r13, getCurBytes());
        int r14 = this.bindValueCount + 1;
        this.bindValueCount = r14;
        r10.bindLong(r14, this.totalBytes);
        int r15 = this.bindValueCount + 1;
        this.bindValueCount = r15;
        String r16 = this.eTag;
        if (r16 != null) goto L19;
        r16 = "";
    L19:
        r10.bindString(r15, r16);
        int r17 = this.bindValueCount + 1;
        this.bindValueCount = r17;
        long r18 = 1;
        if (this.onlyWifi == false) goto L22;
        long r19 = 1;
    L23:
        r10.bindLong(r17, r19);
        int r20 = this.bindValueCount + 1;
        this.bindValueCount = r20;
        if (this.force == false) goto L26;
        long r21 = 1;
    L27:
        r10.bindLong(r20, r21);
        int r22 = this.bindValueCount + 1;
        this.bindValueCount = r22;
        r10.bindLong(r22, this.retryCount);
        int r23 = this.bindValueCount + 1;
        this.bindValueCount = r23;
        String r24 = this.extra;
        if (r24 != null) goto L30;
        r24 = "";
    L30:
        r10.bindString(r23, r24);
        int r25 = this.bindValueCount + 1;
        this.bindValueCount = r25;
        String r26 = this.mimeType;
        if (r26 != null) goto L33;
        r26 = "";
    L33:
        r10.bindString(r25, r26);
        int r27 = this.bindValueCount + 1;
        this.bindValueCount = r27;
        String r28 = this.title;
        if (r28 != null) goto L36;
        r28 = "";
    L36:
        r10.bindString(r27, r28);
        int r29 = this.bindValueCount + 1;
        this.bindValueCount = r29;
        if (this.showNotification == false) goto L39;
        long r30 = 1;
    L40:
        r10.bindLong(r29, r30);
        int r31 = this.bindValueCount + 1;
        this.bindValueCount = r31;
        r10.bindLong(r31, this.notificationVisibility);
        int r32 = this.bindValueCount + 1;
        this.bindValueCount = r32;
        if (this.isFirstDownload == false) goto L43;
        long r33 = 1;
    L44:
        r10.bindLong(r32, r33);
        int r34 = this.bindValueCount + 1;
        this.bindValueCount = r34;
        if (this.isFirstSuccess == false) goto L47;
        long r35 = 1;
    L48:
        r10.bindLong(r34, r35);
        int r36 = this.bindValueCount + 1;
        this.bindValueCount = r36;
        if (this.needHttpsToHttpRetry == false) goto L51;
        long r37 = 1;
    L52:
        r10.bindLong(r36, r37);
        int r38 = this.bindValueCount + 1;
        this.bindValueCount = r38;
        r10.bindLong(r38, this.downloadTime);
        int r39 = this.bindValueCount + 1;
        this.bindValueCount = r39;
        String r40 = this.packageName;
        if (r40 != null) goto L55;
        r40 = "";
    L55:
        r10.bindString(r39, r40);
        int r41 = this.bindValueCount + 1;
        this.bindValueCount = r41;
        String r42 = this.md5;
        if (r42 != null) goto L58;
        r42 = "";
    L58:
        r10.bindString(r41, r42);
        int r43 = this.bindValueCount + 1;
        this.bindValueCount = r43;
        r10.bindLong(r43, 0);
        int r44 = this.bindValueCount + 1;
        this.bindValueCount = r44;
        r10.bindLong(r44, this.curRetryTime);
        int r45 = this.bindValueCount + 1;
        this.bindValueCount = r45;
        r10.bindLong(r45, 0);
        int r46 = this.bindValueCount + 1;
        this.bindValueCount = r46;
        if (this.needDefaultHttpServiceBackUp == false) goto L61;
        long r47 = 1;
    L62:
        r10.bindLong(r46, r47);
        int r48 = this.bindValueCount + 1;
        this.bindValueCount = r48;
        r10.bindLong(r48, 0);
        int r49 = this.bindValueCount + 1;
        this.bindValueCount = r49;
        r10.bindString(r49, "");
        int r50 = this.bindValueCount + 1;
        this.bindValueCount = r50;
        r10.bindLong(r50, 0);
        int r51 = this.bindValueCount + 1;
        this.bindValueCount = r51;
        r10.bindString(r51, getBackUpUrlsStr());
        int r52 = this.bindValueCount + 1;
        this.bindValueCount = r52;
        r10.bindLong(r52, this.backUpUrlRetryCount);
        int r53 = this.bindValueCount + 1;
        this.bindValueCount = r53;
        r10.bindLong(r53, this.realDownloadTime);
        int r54 = this.bindValueCount + 1;
        this.bindValueCount = r54;
        r10.bindLong(r54, 0);
        int r55 = this.bindValueCount + 1;
        this.bindValueCount = r55;
        if (this.needIndependentProcess == false) goto L65;
        long r56 = 1;
    L66:
        r10.bindLong(r55, r56);
        int r57 = this.bindValueCount + 1;
        this.bindValueCount = r57;
        r10.bindString(r57, getDBJsonDataString());
        int r58 = this.bindValueCount + 1;
        this.bindValueCount = r58;
        String r59 = this.iconUrl;
        if (r59 != null) goto L69;
        r59 = "";
    L69:
        r10.bindString(r58, r59);
        int r60 = this.bindValueCount + 1;
        this.bindValueCount = r60;
        r10.bindLong(r60, this.appVersionCode);
        int r61 = this.bindValueCount + 1;
        this.bindValueCount = r61;
        r10.bindString(r61, "");
        int r62 = this.bindValueCount + 1;
        this.bindValueCount = r62;
        r10.bindLong(r62, this.downloadStartTimeStamp);
        int r63 = this.bindValueCount + 1;
        this.bindValueCount = r63;
        r10.bindLong(r63, this.downloadFinishTimeStamp);
        int r64 = this.bindValueCount + 1;
        this.bindValueCount = r64;
        r10.bindLong(r64, this.installedTimeStamp);
        int r65 = this.bindValueCount + 1;
        this.bindValueCount = r65;
        if (this.hasDoInstallation == true) goto L73;
        r18 = 0;
    L73:
        r10.bindLong(r65, r18);
        int r66 = this.bindValueCount + 1;
        this.bindValueCount = r66;
        r10.bindLong(r66, this.cacheLifeTimeMax);
        int r67 = this.bindValueCount + 1;
        this.bindValueCount = r67;
        r10.bindString(r67, getPcdnUrlsStr());
        int r68 = this.bindValueCount + 1;
        this.bindValueCount = r68;
        r10.bindString(r68, getCdnUrlsStr());
        int r69 = this.bindValueCount + 1;
        this.bindValueCount = r69;
        r10.bindLong(r69, getBackCurBytes());
        int r70 = this.bindValueCount + 1;
        this.bindValueCount = r70;
        r10.bindLong(r70, this.realBackDownloadTime);
        int r71 = this.bindValueCount + 1;
        this.bindValueCount = r71;
        String r72 = this.monitorScene;
        if (r72 == null) goto L77;
        r3 = r72;
    L77:
        r10.bindString(r71, r3);
        return;
    L65:
        r56 = 0;
        goto L66
    L61:
        r47 = 0;
        goto L62
    L51:
        r37 = 0;
        goto L52
    L47:
        r35 = 0;
        goto L48
    L43:
        r33 = 0;
        goto L44
    L39:
        r30 = 0;
        goto L40
    L26:
        r21 = 0;
        goto L27
    L22:
        r19 = 0;
        goto L23
    }

    public boolean equalsTask(DownloadInfo r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String r1 = this.url;
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.equals(r4.getUrl()) == false) goto L16;
        String r2 = this.savePath;
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r2.equals(r4.getSavePath()) == false) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    public int getAntiHijackErrorCode(int r3) {
        ensureDBJsonData();
        return this.dbJsonData.optInt("anti_hijack_error_code", r3);
    }

    public int getDBJsonInt(String r2) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(r2);
    }

    public String getDBJsonString(String r2) {
        ensureDBJsonData();
        return this.dbJsonData.optString(r2);
    }

    public long getMinByteIntervalForPostToMainThread(long r4) {
        int r0 = this.maxProgressCount;
        if (r0 > 0) goto L5;
        r0 = 100;
    L5:
        long r5 = r4 / ((long) (r0 + 1));
        if (r5 > 0) goto L9;
        return 1048576;
    L9:
        return r5;
    }

    public int getSpIntVal(String r3) {
        ensureSpData();
        return this.spData.optInt(r3, 0);
    }

    public long getSpLongVal(String r4) {
        ensureSpData();
        return this.spData.optLong(r4, 0);
    }

    public String getSpStringVal(String r3) {
        ensureSpData();
        return this.spData.optString(r3, null);
    }

    public void increaseAllConnectTime(long r4) {
        if (r4 <= 0) goto L6;
        getAllConnectTime();
        safePutToDBJsonData("dbjson_key_all_connect_time", Long.valueOf(this.allConnectTime.addAndGet(r4)));
        return;
    }

    public void increaseCurBytes(long r2) {
        this.curBytes.addAndGet(r2);
        if (this.fastDownload == false) goto L5;
        return;
    L5:
        if (AppStatusManager.getInstance().isAppBackground() == false) goto L9;
        this.backCurBytes.addAndGet(r2);
        return;
    }

    public void increaseDownloadPrepareTime(long r4) {
        if (this.fastDownload == false) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis() - r4;
        if (r0 <= 0) goto L9;
        safePutToDBJsonData("dbjson_key_download_prepare_time", Long.valueOf(getDownloadPrepareTime() + r0));
        return;
    }

    public void readFromParcel(Parcel r6) {
        this.id = r6.readInt();
        this.name = r6.readString();
        this.title = r6.readString();
        this.url = r6.readString();
        this.savePath = r6.readString();
        this.tempPath = r6.readString();
        boolean r1 = true;
        if (r6.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.onlyWifi = r0;
        this.extra = r6.readString();
        this.extraHeaders = r6.createTypedArrayList(HttpHeader.CREATOR);
        this.maxBytes = r6.readInt();
        this.outIp = r6.createStringArray();
        this.outSize = r6.createIntArray();
        this.retryCount = r6.readInt();
        this.backUpUrlRetryCount = r6.readInt();
        if (r6.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.force = r2;
        if (r6.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.needPostProgress = r3;
        this.maxProgressCount = r6.readInt();
        this.minProgressTimeMsInterval = r6.readInt();
        this.backUpUrls = r6.createStringArrayList();
        if (r6.readByte() == 0) goto L17;
        boolean r4 = true;
    L18:
        this.showNotification = r4;
        this.mimeType = r6.readString();
        if (r6.readByte() == 0) goto L21;
        boolean r5 = true;
    L22:
        this.needHttpsToHttpRetry = r5;
        this.packageName = r6.readString();
        this.md5 = r6.readString();
        if (r6.readByte() == 0) goto L25;
        boolean r7 = true;
    L26:
        this.needDefaultHttpServiceBackUp = r7;
        this.eTag = r6.readString();
        this.curRetryTime = r6.readInt();
        this.networkQuality = r6.readString();
        this.curBackUpUrlIndex = r6.readInt();
        this.notificationVisibility = r6.readInt();
        this.chunkCount = r6.readInt();
        setCurBytes(r6.readLong());
        setBackCurBytes(r6.readLong());
        this.totalBytes = r6.readLong();
        setStatus(r6.readInt());
        this.downloadTime = r6.readLong();
        this.realDownloadTime = r6.readLong();
        this.realBackDownloadTime = r6.readLong();
        if (r6.readByte() == 0) goto L29;
        boolean r8 = true;
    L30:
        this.backUpUrlUsed = r8;
        if (r6.readByte() == 0) goto L33;
        boolean r9 = true;
    L34:
        this.httpsToHttpRetryUsed = r9;
        if (r6.readByte() == 0) goto L37;
        boolean r10 = true;
    L38:
        this.autoResumed = r10;
        if (r6.readByte() == 0) goto L41;
        boolean r11 = true;
    L42:
        this.showNotificationForAutoResumed = r11;
        if (r6.readByte() == 0) goto L45;
        boolean r12 = true;
    L46:
        this.showNotificationForNetworkResumed = r12;
        this.forbiddenBackupUrls = r6.createStringArrayList();
        if (r6.readByte() == 0) goto L49;
        boolean r13 = true;
    L50:
        this.needIndependentProcess = r13;
        convertEnqueueType(r6.readInt());
        this.httpStatusCode = r6.readInt();
        this.httpStatusMessage = r6.readString();
        if (r6.readByte() == 0) goto L53;
        boolean r14 = true;
    L54:
        this.isForbiddenRetryed = r14;
        if (r6.readByte() == 0) goto L57;
        boolean r15 = true;
    L58:
        this.addListenerToSameTask = r15;
        this.failedException = (BaseException) r6.readParcelable(BaseException.class.getClassLoader());
        this.dbJsonDataString = r6.readString();
        if (r6.readByte() == 0) goto L61;
        boolean r16 = true;
    L62:
        this.supportPartial = r16;
        this.iconUrl = r6.readString();
        this.appVersionCode = r6.readInt();
        if (r6.readByte() == 0) goto L65;
        boolean r17 = true;
    L66:
        this.expiredRedownload = r17;
        if (r6.readByte() == 0) goto L69;
        boolean r18 = true;
    L70:
        this.deleteCacheIfCheckFailed = r18;
        if (r6.readByte() == 0) goto L73;
        boolean r19 = true;
    L74:
        this.successByCache = r19;
        if (r6.readByte() == 0) goto L77;
        boolean r20 = true;
    L78:
        this.expiredHttpCheck = r20;
        this.xTotalBytes = r6.readLong();
        this.interceptFlag = r6.readInt();
        this.accessHttpHeaderKeys = r6.createStringArrayList();
        this.httpHeaders = r6.readHashMap(getClass().getClassLoader());
        this.downloadStartTimeStamp = r6.readLong();
        this.downloadFinishTimeStamp = r6.readLong();
        this.installedTimeStamp = r6.readLong();
        if (r6.readByte() == 0) goto L81;
        boolean r21 = true;
    L82:
        this.hasDoInstallation = r21;
        if (r6.readByte() == 0) goto L85;
        boolean r22 = true;
    L86:
        this.isCacheExistsInDownloading = r22;
        this.cacheLifeTimeMax = r6.readLong();
        this.pcdnUrls = r6.createStringArrayList();
        this.cdnUrls = r6.createStringArrayList();
        this.contentEncoding = r6.readString();
        if (r6.readByte() == 0) goto L89;
        boolean r23 = true;
    L90:
        this.fastDownload = r23;
        if (r6.readByte() == 0) goto L93;
        boolean r24 = true;
    L94:
        this.handleRequest = r24;
        this.md5Time = r6.readLong();
        this.httpRequestHeader = r6.readString();
        this.httpResponseHeader = r6.readString();
        this.requestLog = r6.readString();
        this.verifyCurBytes = r6.readLong();
        if (r6.readByte() == 0) goto L97;
        boolean r25 = true;
    L98:
        this.needCurrentProcess = r25;
        this.monitorScene = r6.readString();
        this.callStack = r6.readString();
        if (r6.readByte() == 0) goto L101;
        boolean r26 = true;
    L102:
        this.resumeFileDownload = r26;
        this.concurrentConnCount = r6.readInt();
        this.racingTaskExcessBytes = r6.readLong();
        if (r6.readByte() != 0) goto L106;
        r1 = false;
    L106:
        this.fastDownloadCommonThreadPool = r1;
        parseMonitorSetting();
        return;
    L101:
        r26 = false;
        goto L102
    L97:
        r25 = false;
        goto L98
    L93:
        r24 = false;
        goto L94
    L89:
        r23 = false;
        goto L90
    L85:
        r22 = false;
        goto L86
    L81:
        r21 = false;
        goto L82
    L77:
        r20 = false;
        goto L78
    L73:
        r19 = false;
        goto L74
    L69:
        r18 = false;
        goto L70
    L65:
        r17 = false;
        goto L66
    L61:
        r16 = false;
        goto L62
    L57:
        r15 = false;
        goto L58
    L53:
        r14 = false;
        goto L54
    L49:
        r13 = false;
        goto L50
    L45:
        r12 = false;
        goto L46
    L41:
        r11 = false;
        goto L42
    L37:
        r10 = false;
        goto L38
    L33:
        r9 = false;
        goto L34
    L29:
        r8 = false;
        goto L30
    L25:
        r7 = false;
        goto L26
    L21:
        r5 = false;
        goto L22
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public void resetDataForEtagEndure(String r4) {
        setCurBytes(0, true);
        setBackCurBytes(0);
        setTotalBytes(0);
        seteTag(r4);
        setChunkCount(1);
        setLastModified(null);
        this.downloadTime = 0;
        this.realStartDownloadTime = 0;
        this.realDownloadTime = 0;
        this.realBackDownloadTime = 0;
    }

    public void setAddListenerToSameTask(boolean r1) {
        this.addListenerToSameTask = r1;
    }

    public void setAntiHijackErrorCode(int r2) {
        safePutToDBJsonData("anti_hijack_error_code", Integer.valueOf(r2));
    }

    public void setAppVersionCode(int r1) {
        this.appVersionCode = r1;
    }

    public void setAsyncHandleStatus(AsyncHandleStatus r1) {
        this.asyncHandleStatus = r1;
    }

    public void setAutoResumed(boolean r1) {
        this.autoResumed = r1;
    }

    public void setBackCurBytes(long r2) {
        AtomicLong r0 = this.backCurBytes;
        if (r0 == null) goto L5;
        r0.set(r2);
        return;
    L5:
        this.backCurBytes = new AtomicLong(r2);
    }

    public void setBackUpUrlRetryCount(int r1) {
        this.backUpUrlRetryCount = r1;
    }

    public void setBackUpUrlsStr(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (getStatus() == (-3)) goto L10;
        this.backUpUrlsStr = r3;
        this.backUpUrls = DownloadUtils.jsonStringTolist(r3);
        return;
    }

    public void setByteInvalidRetryStatus(ByteInvalidRetryStatus r1) {
        this.byteInvalidRetryStatus = r1;
    }

    public void setCacheExistsInDownloading(boolean r1) {
        this.isCacheExistsInDownloading = r1;
    }

    public void setCacheExpiredTime(long r3) {
        ensureSpData();
        this.spData.put("cache-control/expired_time", r3);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    }

    public void setCacheLifeTimeMax(long r1) {
        this.cacheLifeTimeMax = r1;
    }

    public void setCdnUrlsStr(String r1) {
        this.cdnUrlsStr = r1;
    }

    public void setChunkCount(int r1) {
        this.chunkCount = r1;
    }

    public void setContentEncoding(String r1) {
        this.contentEncoding = r1;
    }

    public void setCurBytes(long r2) {
        AtomicLong r0 = this.curBytes;
        if (r0 == null) goto L5;
        r0.set(r2);
        return;
    L5:
        this.curBytes = new AtomicLong(r2);
    }

    public void setCurNetworkRetryCount(int r1) {
        this.curNetworkRetryCount = r1;
    }

    public void setCurRetryTime(int r1) {
        this.curRetryTime = r1;
    }

    public void setDBInitStatus(int r1) {
        this.mDBInitStatus = r1;
    }

    public void setDbJsonDataString(String r1) {
        this.dbJsonDataString = r1;
    }

    public void setDownloadFinishTimeStamp(long r1) {
        this.downloadFinishTimeStamp = r1;
    }

    public void setDownloadFromReserveWifi(boolean r1) {
        this.mDownloadFromReserveWifi = r1;
    }

    public void setDownloadStartTimeStamp(long r1) {
        this.downloadStartTimeStamp = r1;
    }

    public void setDownloadTime(long r1) {
        this.downloadTime = r1;
    }

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setFailedException(BaseException r1) {
        this.failedException = r1;
    }

    public void setFailedResumeCount(int r3) {
        ensureSpData();
        this.spData.put("failed_resume_count", r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setFilePackageName(String r1) {
        this.filePackageName = r1;
    }

    public void setFirstDownload(boolean r1) {
        this.isFirstDownload = r1;
    }

    public void setFirstSpeedTime(long r2) {
        safePutToDBJsonData("dbjson_key_first_speed_time", Long.valueOf(r2));
    }

    public void setFirstSuccess(boolean r1) {
        this.isFirstSuccess = r1;
    }

    public void setForce(boolean r1) {
        this.force = r1;
    }

    public void setHasDoInstallation(boolean r1) {
        this.hasDoInstallation = r1;
    }

    public void setHttpHeaders(Map<String, String> r1) {
        this.httpHeaders = r1;
    }

    public void setHttpRequestHeader(String r1) {
        this.httpRequestHeader = r1;
    }

    public void setHttpResponseHeader(String r1) {
        this.httpResponseHeader = r1;
    }

    public void setHttpStatusCode(int r1) {
        this.httpStatusCode = r1;
    }

    public void setHttpStatusMessage(String r1) {
        this.httpStatusMessage = r1;
    }

    public void setHttpsToHttpRetryUsed(boolean r1) {
        this.httpsToHttpRetryUsed = r1;
    }

    public void setIconUrl(String r1) {
        this.iconUrl = r1;
    }

    public void setId(int r1) {
        this.id = r1;
    }

    public void setIgnoreDataVerify(boolean r1) {
        this.ignoreDataVerify = r1;
    }

    public void setInstallBizParamsJson(String r4) {
        ensureSpData();
        this.spData.put("install_biz_params_json", r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.taskError(TAG, this.id, "setInstallBizParamsJson", "Error:" + e);
    }

    public void setInstallBizType(String r4) {
        ensureSpData();
        this.spData.put("install_biz_type", r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.taskError(TAG, this.id, "setInstallBizType", "Error:" + e);
    }

    public void setInstallCertId(String r4) {
        ensureSpData();
        this.spData.put("install_cert_id", r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.taskError(TAG, this.id, "setInstallCertId", "Error:" + e);
    }

    public void setInstalledTimeStamp(long r1) {
        this.installedTimeStamp = r1;
    }

    public void setInterceptFlag(int r1) {
        this.interceptFlag = r1;
    }

    public void setLastFailedResumeTime(long r3) {
        ensureSpData();
        this.spData.put("last_failed_resume_time", r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setLastModified(String r3) {
        ensureSpData();
        this.spData.put(DownloadHelper.LAST_MODIFIED, r3);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    }

    public void setLastUninstallResumeTime(long r3) {
        ensureSpData();
        this.spData.put("last_unins_resume_time", r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setLinkMode(int r2) {
        safePutToDBJsonData("link_mode", Integer.valueOf(r2));
    }

    public void setMd5(String r1) {
        this.md5 = r1;
    }

    public void setMd5Time(long r1) {
        this.md5Time = r1;
    }

    public void setMimeType(String r1) {
        this.mimeType = r1;
    }

    public void setMonitorScene(String r1) {
        this.monitorScene = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setNeedDefaultHttpServiceBackUp(boolean r1) {
        this.needDefaultHttpServiceBackUp = r1;
    }

    public void setNeedHttpsToHttpRetry(boolean r1) {
        this.needHttpsToHttpRetry = r1;
    }

    public void setNeedIndependentProcess(boolean r1) {
        this.needIndependentProcess = r1;
    }

    public void setNetworkQuality(String r1) {
        this.networkQuality = r1;
    }

    public void setNotificationVisibility(int r1) {
        this.notificationVisibility = r1;
    }

    public void setOnlyWifi(boolean r1) {
        this.onlyWifi = r1;
    }

    public void setOpenLimitSpeed(boolean r1) {
        this.openLimitSpeed = r1;
    }

    public void setPackageInfo(PackageInfo r2) {
        this.packageInfoRef = new SoftReference(r2);
    }

    public void setPackageInfoToCache(PackageInfo r4) {
        safePutToDBJsonData("app_package_info", r4.packageName + "," + r4.versionName + "," + r4.versionCode);
    }

    public void setPackageName(String r1) {
        this.packageName = r1;
    }

    public void setPauseByNotification(boolean r3) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (TextUtils.isEmpty(this.extra) == false) goto L5;
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L8
    L6:
        r0.put(DownloadConstants.PAUSE_BY_NOTIFICATION, r3);     // Catch: JSONException -> L8
        this.extra = r0.toString();     // Catch: JSONException -> L8
        return;
    L5:
        r0 = new JSONObject(this.extra);     // Catch: JSONException -> L8
        goto L6
    }

    public void setPausedResumeCount(int r3) {
        ensureSpData();
        this.spData.put(DownloadConstants.KEY_PAUSED_RESUME_COUNT, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setPcdnStats(JSONObject r1) {
        this.pcdnStats = r1;
    }

    public void setPcdnUrlsStr(String r1) {
        this.pcdnUrlsStr = r1;
    }

    public void setRacingTaskExcessBytes(long r1) {
        this.racingTaskExcessBytes = r1;
    }

    public void setRealBackDownloadTime(long r1) {
        this.realBackDownloadTime = r1;
    }

    public void setRealDownloadTime(long r1) {
        this.realDownloadTime = r1;
    }

    public void setRedirectPartialUrlResults(String r2) {
        safePutToDBJsonData("redirect_partial_url_results", r2);
    }

    public void setRequestLog(String r1) {
        this.requestLog = r1;
    }

    public void setRetryCount(int r1) {
        this.retryCount = r1;
    }

    public void setRetryScheduleCount(int r2) {
        safePutToDBJsonData("retry_schedule_count", Integer.valueOf(r2));
    }

    public void setSavePath(String r1) {
        this.savePath = r1;
    }

    public void setSavePathRedirected(boolean r2) {
        safePutToDBJsonData("is_save_path_redirected", Boolean.valueOf(r2));
    }

    public void setShowNotification(boolean r1) {
        this.showNotification = r1;
    }

    public void setShowNotificationForAutoResumed(boolean r1) {
        this.showNotificationForAutoResumed = r1;
    }

    public void setShowNotificationForNetworkResumed(boolean r1) {
        this.showNotificationForNetworkResumed = r1;
    }

    public void setStatus(int r2) {
        AtomicInteger r0 = this.status;
        if (r0 == null) goto L5;
        r0.set(r2);
        return;
    L5:
        this.status = new AtomicInteger(r2);
    }

    public void setStatusAtDbInit(int r1) {
        this.statusAtDbInit = r1;
    }

    public void setSuccessByCache(boolean r1) {
        this.successByCache = r1;
    }

    public void setSupportPartial(boolean r1) {
        this.supportPartial = r1;
    }

    public void setTTMd5CheckStatus(int r2) {
        safePutToDBJsonData("ttmd5_check_status", Integer.valueOf(r2));
    }

    public void setTaskSleepTime(int r1) {
        this.mTaskSleepTime = r1;
    }

    public void setTempPath(String r1) {
        this.tempPath = r1;
    }

    public void setThrottleNetSpeed(long r2) {
        setThrottleNetSpeed(r2, -1);
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setTotalBytes(long r1) {
        this.totalBytes = r1;
    }

    public void setUninstallResumeCount(int r3) {
        ensureSpData();
        this.spData.put("unins_resume_count", r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public void setVerifyCurBytes(long r1) {
        this.verifyCurBytes = r1;
    }

    public void setXTotalBytes(long r1) {
        this.xTotalBytes = r1;
    }

    public void seteTag(String r1) {
        this.eTag = r1;
    }

    public void updateCurRetryTime(int r2) {
        if (this.backUpUrlUsed == false) goto L5;
        int r0 = this.backUpUrlRetryCount;
    L6:
        int r1 = r0 - r2;
        this.curRetryTime = r1;
        if (r1 >= 0) goto L10;
        this.curRetryTime = 0;
        return;
    L10:
        return;
    L5:
        r0 = this.retryCount;
        goto L6
    }

    public void updateRealDownloadTime(boolean r8) {
        long r0 = System.nanoTime();
        long r2 = this.realStartDownloadTime;
        if (r2 > 0) goto L7;
        if (r8 == false) goto L19;
        this.realStartDownloadTime = r0;
        return;
    L19:
        return;
    L7:
        long r3 = r0 - r2;
        if (r8 == false) goto L10;
        this.realStartDownloadTime = r0;
    L12:
        if (r3 <= 0) goto L20;
        this.realDownloadTime += r3;
        if (this.fastDownload == false) goto L16;
        return;
    L16:
        if (AppStatusManager.getInstance().isAppBackground() == false) goto L22;
        this.realBackDownloadTime += r3;
        return;
    L22:
        return;
    L20:
        return;
    L10:
        this.realStartDownloadTime = 0;
        goto L12
    }

    private DownloadInfo(RawBuilder r6) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0;
        this.downloadFinishTimeStamp = 0;
        this.installedTimeStamp = 0;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
        this.id = r6.id;
        this.name = r6.name;
        this.title = r6.title;
        this.url = r6.url;
        this.savePath = r6.savePath;
        this.tempPath = r6.tempPath;
        this.chunkCount = r6.chunkCount;
        setStatus(r6.status);
        setCurBytes(r6.curBytes);
        setBackCurBytes(r6.backCurBytes);
        this.totalBytes = r6.totalBytes;
        this.eTag = r6.etag;
        this.onlyWifi = r6.onlyWifi;
        this.force = r6.force;
        this.retryCount = r6.retryCount;
        this.extra = r6.extra;
        this.mimeType = r6.mimeType;
        this.showNotification = r6.showNotification;
        this.notificationVisibility = r6.notificationVisibility;
        this.isFirstDownload = r6.isFirstDownload;
        this.isFirstSuccess = r6.isFirstSuccess;
        this.needHttpsToHttpRetry = r6.needHttpsToHttpRetry;
        this.downloadTime = r6.downloadTime;
        this.packageName = r6.packageName;
        this.md5 = r6.md5;
        this.curRetryTime = r6.curRetryTime;
        this.needDefaultHttpServiceBackUp = r6.needDefaultHttpServiceBackUp;
        this.backUpUrlsStr = r6.backUpUrlsStr;
        this.backUpUrlRetryCount = r6.backUpUrlRetryCount;
        this.realDownloadTime = r6.realDownloadTime;
        this.realBackDownloadTime = r6.realBackDownloadTime;
        this.needIndependentProcess = r6.needIndependentProcess;
        this.needCurrentProcess = r6.needCurrentProcess;
        this.dbJsonDataString = r6.dbJsonDataString;
        this.iconUrl = r6.iconUrl;
        this.appVersionCode = r6.appVersionCode;
        this.downloadStartTimeStamp = r6.downloadStartTimeStamp;
        this.downloadFinishTimeStamp = r6.downloadFinishTimeStamp;
        this.installedTimeStamp = r6.installedTimeStamp;
        this.hasDoInstallation = r6.hasDoInstallation;
        this.pcdnUrlsStr = r6.pcdnUrlsStr;
        this.cdnUrlsStr = r6.cdnUrlsStr;
        this.cacheLifeTimeMax = r6.cacheLifeTimeMax;
        this.monitorScene = r6.monitorScene;
        parseMonitorSetting();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public DownloadInfo(Parcel r6) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0;
        this.downloadFinishTimeStamp = 0;
        this.installedTimeStamp = 0;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
        readFromParcel(r6);
    }

    public DownloadInfo(Cursor r5) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0;
        this.downloadFinishTimeStamp = 0;
        this.installedTimeStamp = 0;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
    }

    public /* synthetic */ DownloadInfo(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    private void unsafePutToDBJsonData(String r2, Object r3) {
        this.dbJsonData.put(r2, r3);     // Catch: Exception -> L4
        return;
    }

    public void copyFromCacheData(DownloadInfo r4, boolean r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        setChunkCount(r4.getChunkCount());
        setTotalBytes(r4.getTotalBytes());
        setCurBytes(r4.getCurBytes(), true);
        setBackCurBytes(r4.getBackCurBytes());
        this.realDownloadTime = r4.realDownloadTime;
        this.realBackDownloadTime = r4.realBackDownloadTime;
        if (r4.canSkipStatusHandler() == false) goto L7;
    L9:
        this.curRetryTime = r4.getCurRetryTime();
    L10:
        seteTag(r4.geteTag());
        setMimeType(r4.getMimeType());
        if (r5 == false) goto L13;
        setStatus(r4.getStatus());
    L13:
        this.isFirstDownload = r4.getIsFirstDownload();
        this.isFirstSuccess = r4.isFirstSuccess();
        this.downloadStartTimeStamp = r4.getDownloadStartTimeStamp();
        this.downloadFinishTimeStamp = r4.getDownloadFinishTimeStamp();
        this.installedTimeStamp = r4.getInstalledTimeStamp();
        this.hasDoInstallation = r4.hasDoInstallation;
        mergeAuxiliaryJSONObject(r4.dbJsonData);
        return;
    L7:
        if (canSkipStatusHandler() == true) goto L9;
        this.curRetryTime = 0;
        this.isForbiddenRetryed = false;
        this.backUpUrlUsed = false;
        this.curBackUpUrlIndex = 0;
        this.httpsToHttpRetryUsed = false;
        goto L10
    }

    public void safePutToDBJsonData(String r3, Object r4) {
        ensureDBJsonData();
        JSONObject r0 = this.dbJsonData;
        monitor-enter(r0);
        this.dbJsonData.put(r3, r4);     // Catch: Throwable -> L6 Exception -> L14
    L6:
        th = move-exception;
        throw th;
    L9:
        this.dbJsonDataString = null;     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
    }

    public void setCurBytes(long r3, boolean r5) {
        if (r5 == false) goto L5;
        setCurBytes(r3);
        return;
    L5:
        if (r3 <= getCurBytes()) goto L9;
        setCurBytes(r3);
        return;
    }

    public void setForbiddenBackupUrls(List<String> r1, boolean r2) {
        this.forbiddenBackupUrls = r1;
        refreshBackupUrls(r2);
    }

    public void setSpValue(String r2, String r3) {
        ensureSpData();
        this.spData.put(r2, r3);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setThrottleNetSpeed(long r1, int r3) {
        this.throttleNetSpeed = r1;
        this.throttleSmoothness = r3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.id);
        r3.writeString(this.name);
        r3.writeString(this.title);
        r3.writeString(this.url);
        r3.writeString(this.savePath);
        r3.writeString(this.tempPath);
        r3.writeByte(this.onlyWifi ? 1 : 0);
        r3.writeString(this.extra);
        r3.writeTypedList(this.extraHeaders);
        r3.writeInt(this.maxBytes);
        r3.writeStringArray(this.outIp);
        r3.writeIntArray(this.outSize);
        r3.writeInt(this.retryCount);
        r3.writeInt(this.backUpUrlRetryCount);
        r3.writeByte(this.force ? 1 : 0);
        r3.writeByte(this.needPostProgress ? 1 : 0);
        r3.writeInt(this.maxProgressCount);
        r3.writeInt(this.minProgressTimeMsInterval);
        r3.writeStringList(this.backUpUrls);
        r3.writeByte(this.showNotification ? 1 : 0);
        r3.writeString(this.mimeType);
        r3.writeByte(this.needHttpsToHttpRetry ? 1 : 0);
        r3.writeString(this.packageName);
        r3.writeString(this.md5);
        r3.writeByte(this.needDefaultHttpServiceBackUp ? 1 : 0);
        r3.writeString(this.eTag);
        r3.writeInt(this.curRetryTime);
        r3.writeString(this.networkQuality);
        r3.writeInt(this.curBackUpUrlIndex);
        r3.writeInt(this.notificationVisibility);
        r3.writeInt(this.chunkCount);
        r3.writeLong(getCurBytes());
        r3.writeLong(getBackCurBytes());
        r3.writeLong(this.totalBytes);
        r3.writeInt(getRealStatus());
        r3.writeLong(this.downloadTime);
        r3.writeLong(this.realDownloadTime);
        r3.writeLong(this.realBackDownloadTime);
        r3.writeByte(this.backUpUrlUsed ? 1 : 0);
        r3.writeByte(this.httpsToHttpRetryUsed ? 1 : 0);
        r3.writeByte(this.autoResumed ? 1 : 0);
        r3.writeByte(this.showNotificationForAutoResumed ? 1 : 0);
        r3.writeByte(this.showNotificationForNetworkResumed ? 1 : 0);
        r3.writeStringList(this.forbiddenBackupUrls);
        r3.writeByte(this.needIndependentProcess ? 1 : 0);
        r3.writeInt(this.enqueueType.ordinal());
        r3.writeInt(this.httpStatusCode);
        r3.writeString(this.httpStatusMessage);
        r3.writeByte(this.isForbiddenRetryed ? 1 : 0);
        r3.writeByte(this.addListenerToSameTask ? 1 : 0);
        r3.writeParcelable(this.failedException, r4);
        r3.writeString(getDBJsonDataString());
        r3.writeByte(this.supportPartial ? 1 : 0);
        r3.writeString(this.iconUrl);
        r3.writeInt(this.appVersionCode);
        r3.writeByte(this.expiredRedownload ? 1 : 0);
        r3.writeByte(this.deleteCacheIfCheckFailed ? 1 : 0);
        r3.writeByte(this.successByCache ? 1 : 0);
        r3.writeByte(this.expiredHttpCheck ? 1 : 0);
        r3.writeLong(this.xTotalBytes);
        r3.writeInt(this.interceptFlag);
        r3.writeStringList(this.accessHttpHeaderKeys);
        r3.writeMap(this.httpHeaders);
        r3.writeLong(this.downloadStartTimeStamp);
        r3.writeLong(this.downloadFinishTimeStamp);
        r3.writeLong(this.installedTimeStamp);
        r3.writeByte(this.hasDoInstallation ? 1 : 0);
        r3.writeByte(this.isCacheExistsInDownloading ? 1 : 0);
        r3.writeLong(this.cacheLifeTimeMax);
        r3.writeStringList(this.pcdnUrls);
        r3.writeStringList(this.cdnUrls);
        r3.writeString(this.contentEncoding);
        r3.writeByte(this.fastDownload ? 1 : 0);
        r3.writeByte(this.handleRequest ? 1 : 0);
        r3.writeLong(this.md5Time);
        r3.writeString(this.httpRequestHeader);
        r3.writeString(this.httpResponseHeader);
        r3.writeString(this.requestLog);
        r3.writeLong(this.verifyCurBytes);
        r3.writeByte(this.needCurrentProcess ? 1 : 0);
        r3.writeString(this.monitorScene);
        r3.writeString(this.callStack);
        r3.writeByte(this.resumeFileDownload ? 1 : 0);
        r3.writeInt(this.concurrentConnCount);
        r3.writeLong(this.racingTaskExcessBytes);
        r3.writeByte(this.fastDownloadCommonThreadPool ? 1 : 0);
    }

    public /* synthetic */ DownloadInfo(RawBuilder r1, AnonymousClass1 r2) {
        this(r1);
    }
}
