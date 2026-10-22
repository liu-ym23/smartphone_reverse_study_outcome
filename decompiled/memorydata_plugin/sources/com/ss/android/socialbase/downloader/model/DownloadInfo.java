package com.ss.android.socialbase.downloader.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.service.k;
import com.ss.android.socialbase.downloader.service.l;
import com.ss.android.socialbase.downloader.service.n;
import com.ss.android.socialbase.downloader.service.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
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

/* JADX INFO: loaded from: classes6.dex */
public class DownloadInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = null;
    private static final int DEFAULT_MAX_PROCESS_POST_COUNT = 100;
    private static final long DEFAULT_MIN_BYTES_INTERVAL = 1048576;
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
    private List<String> cdnUrls;
    private String cdnUrlsStr;
    private int chunkCount;
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
    private String filePackageName;
    private List<String> forbiddenBackupUrls;
    private boolean force;
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
    private long realBackDownloadTime;
    private long realDownloadTime;
    private long realStartDownloadTime;
    private String requestLog;
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
    private long ttnetProtectTimeout;
    private String url;
    private long verifyCurBytes;
    private long xTotalBytes;

    public static class a {
        private int[] A;
        private boolean B;
        private int C;
        private int D;
        private List<String> E;
        private boolean F;
        private boolean G;
        private boolean H;
        private long I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private EnqueueType f15555J;
        private boolean K;
        private long L;
        private long M;
        private long N;
        private int O;
        private boolean P;
        private boolean Q;
        private JSONObject R;
        private boolean S;
        private String T;
        private int[] U;
        private int V;
        private boolean W;
        private boolean X;
        private boolean Y;
        private long Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected String f15556a;
        private boolean aa;
        private boolean ab;
        private String ac;
        private boolean ad;
        private List<String> ae;
        private boolean af;
        private boolean ag;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f15557b;
        protected String c;
        protected List<String> d;
        protected List<String> e;
        protected String f;
        protected String g;
        protected boolean h;
        protected String i;
        protected int j;
        protected int k;
        protected boolean l;
        protected boolean m;
        protected String n;
        protected boolean o;
        protected long p;
        protected boolean q;
        protected String r;
        protected String s;
        protected boolean t;
        protected boolean u;
        protected String v;
        protected int w;
        private List<HttpHeader> x;
        private int y;
        private String[] z;

        public a() {
            this.B = true;
            this.F = true;
            this.q = true;
            this.f15555J = EnqueueType.ENQUEUE_NONE;
            this.L = 0;
            this.M = -1;
            this.S = true;
        }

        static /* synthetic */ int[] A(a r0) {
            return r0.U;
        }

        static /* synthetic */ boolean B(a r0) {
            return r0.W;
        }

        static /* synthetic */ boolean C(a r0) {
            return r0.X;
        }

        static /* synthetic */ boolean D(a r0) {
            return r0.Y;
        }

        static /* synthetic */ long E(a r2) {
            return r2.Z;
        }

        static /* synthetic */ boolean F(a r0) {
            return r0.aa;
        }

        static /* synthetic */ boolean G(a r0) {
            return r0.ad;
        }

        static /* synthetic */ List H(a r0) {
            return r0.ae;
        }

        static /* synthetic */ long I(a r2) {
            return r2.L;
        }

        static /* synthetic */ long J(a r2) {
            return r2.M;
        }

        static /* synthetic */ String a(a r0) {
            return r0.T;
        }

        static /* synthetic */ boolean b(a r0) {
            return r0.af;
        }

        static /* synthetic */ boolean c(a r0) {
            return r0.ag;
        }

        static /* synthetic */ String d(a r0) {
            return r0.ac;
        }

        static /* synthetic */ boolean e(a r0) {
            return r0.ab;
        }

        static /* synthetic */ List f(a r0) {
            return r0.x;
        }

        static /* synthetic */ int g(a r0) {
            return r0.y;
        }

        static /* synthetic */ String[] h(a r0) {
            return r0.z;
        }

        static /* synthetic */ int[] i(a r0) {
            return r0.A;
        }

        static /* synthetic */ boolean j(a r0) {
            return r0.B;
        }

        static /* synthetic */ int k(a r0) {
            return r0.C;
        }

        static /* synthetic */ int l(a r0) {
            return r0.D;
        }

        static /* synthetic */ List m(a r0) {
            return r0.E;
        }

        static /* synthetic */ boolean n(a r0) {
            return r0.G;
        }

        static /* synthetic */ boolean o(a r0) {
            return r0.H;
        }

        static /* synthetic */ EnqueueType p(a r0) {
            return r0.f15555J;
        }

        static /* synthetic */ boolean q(a r0) {
            return r0.K;
        }

        static /* synthetic */ boolean r(a r0) {
            return r0.Q;
        }

        static /* synthetic */ long s(a r2) {
            return r2.N;
        }

        static /* synthetic */ int t(a r0) {
            return r0.O;
        }

        static /* synthetic */ boolean u(a r0) {
            return r0.P;
        }

        static /* synthetic */ JSONObject v(a r0) {
            return r0.R;
        }

        static /* synthetic */ long w(a r2) {
            return r2.I;
        }

        static /* synthetic */ int x(a r0) {
            return r0.V;
        }

        static /* synthetic */ boolean y(a r0) {
            return r0.F;
        }

        static /* synthetic */ boolean z(a r0) {
            return r0.S;
        }

        public a a() {
            this.af = true;
            return this;
        }

        public a a(int r1) {
            this.y = r1;
            return this;
        }

        public a a(long r1) {
            this.I = r1;
            return this;
        }

        public a a(EnqueueType r1) {
            this.f15555J = r1;
            return this;
        }

        public a a(String r1) {
            this.ac = r1;
            return this;
        }

        public a a(List<String> r3) {
            this.d = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a a(JSONObject r1) {
            this.R = r1;
            return this;
        }

        public a a(boolean r1) {
            this.ad = r1;
            return this;
        }

        public a a(int[] r1) {
            this.A = r1;
            return this;
        }

        public a a(String[] r1) {
            this.z = r1;
            return this;
        }

        public a b() {
            this.ag = true;
            return this;
        }

        public a b(int r1) {
            this.j = r1;
            return this;
        }

        public a b(long r1) {
            this.N = r1;
            return this;
        }

        public a b(String r1) {
            this.f15556a = r1;
            return this;
        }

        public a b(List<String> r3) {
            this.e = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a b(boolean r1) {
            this.h = r1;
            return this;
        }

        public a b(int[] r1) {
            this.U = r1;
            return this;
        }

        public a c(int r1) {
            this.k = r1;
            return this;
        }

        public a c(long r3) {
            if (r3 <= 0) goto L5;
            this.L = r3;
        L5:
            return this;
        }

        public a c(String r1) {
            this.f15557b = r1;
            return this;
        }

        public a c(List<HttpHeader> r3) {
            this.x = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a c(boolean r1) {
            this.l = r1;
            return this;
        }

        public DownloadInfo c() {
            return new DownloadInfo(this, null);
        }

        public a d(int r1) {
            this.C = r1;
            return this;
        }

        public a d(long r1) {
            this.M = r1;
            return this;
        }

        public a d(String r1) {
            this.c = r1;
            return this;
        }

        public a d(List<String> r3) {
            this.ae = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a d(boolean r1) {
            this.B = r1;
            return this;
        }

        public a e(int r1) {
            this.D = r1;
            return this;
        }

        public a e(long r1) {
            this.Z = r1;
            return this;
        }

        public a e(String r1) {
            this.f = r1;
            return this;
        }

        public a e(List<String> r3) {
            this.E = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a e(boolean r1) {
            this.o = r1;
            return this;
        }

        public a f(int r1) {
            this.V = r1;
            return this;
        }

        public a f(long r1) {
            this.p = r1;
            return this;
        }

        public a f(String r1) {
            this.g = r1;
            return this;
        }

        public a f(boolean r1) {
            this.m = r1;
            return this;
        }

        public a g(int r1) {
            this.O = r1;
            return this;
        }

        public a g(String r1) {
            this.i = r1;
            return this;
        }

        public a g(boolean r1) {
            this.G = r1;
            return this;
        }

        public a h(int r1) {
            this.w = r1;
            return this;
        }

        public a h(String r1) {
            this.n = r1;
            return this;
        }

        public a h(boolean r1) {
            this.H = r1;
            return this;
        }

        public a i(String r1) {
            this.r = r1;
            return this;
        }

        public a i(boolean r1) {
            this.q = r1;
            return this;
        }

        public a j(String r1) {
            this.s = r1;
            return this;
        }

        public a j(boolean r1) {
            this.t = r1;
            return this;
        }

        public a k(String r1) {
            this.T = r1;
            return this;
        }

        public a k(boolean r1) {
            this.u = r1;
            return this;
        }

        public a l(String r1) {
            this.v = r1;
            return this;
        }

        public a l(boolean r1) {
            this.K = r1;
            return this;
        }

        public a m(boolean r1) {
            this.Q = r1;
            return this;
        }

        public a n(boolean r1) {
            this.S = r1;
            return this;
        }

        public a o(boolean r1) {
            this.P = r1;
            return this;
        }

        public a p(boolean r1) {
            this.W = r1;
            return this;
        }

        public a q(boolean r1) {
            this.X = r1;
            return this;
        }

        public a r(boolean r1) {
            this.Y = r1;
            return this;
        }

        public a s(boolean r1) {
            this.aa = r1;
            return this;
        }

        public a t(boolean r1) {
            this.ab = r1;
            return this;
        }

        public a u(boolean r1) {
            this.F = r1;
            return this;
        }
    }

    public static class b extends a {
        public long A;
        public long B;
        public long C;
        public int D;
        public boolean E;
        public boolean F;
        public long G;
        public long H;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public String f15558J;
        public long K;
        public String L;
        public String M;
        public long N;
        public long O;
        public long P;
        public boolean Q;
        public String R;
        public String S;
        public int x;
        public int y;
        public int z;

        public b() {
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadInfo.a
        public DownloadInfo c() {
            return new DownloadInfo(this, null);
        }
    }

    static {
        CREATOR = new AnonymousClass1();
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

    @Deprecated
    public DownloadInfo(Cursor r5) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
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

    private DownloadInfo(a r6) {
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
        this.monitorScene = a.a(r6);
        this.fastDownload = a.b(r6);
        this.name = r6.f15556a;
        this.url = r6.c;
        String r0 = r6.f;
        if (TextUtils.isEmpty(r0) == true) goto L48;
    L11:
        this.savePath = r0;
        this.handleRequest = a.c(r6);
        if (a.b(r6) == false) goto L15;
        this.tempPath = com.ss.android.socialbase.downloader.utils.a.e();
        return;
    L15:
        this.backCurBytes = new AtomicLong(0);
        this.tempPath = r6.g;
        unsafeEnsureDBJsonData();
        unsafePutToDBJsonData("task_key", a.d(r6));
        if (TextUtils.isEmpty(this.tempPath) == false) goto L21;
        if (com.ss.android.socialbase.downloader.utils.a.a(r0) == true) goto L21;
        this.tempPath = com.ss.android.socialbase.downloader.utils.a.c();
    L21:
        if (a.e(r6) == true) goto L23;
    L25:
        this.extra = r6.i;
        this.onlyWifi = r6.h;
        this.extraHeaders = a.f(r6);
        this.maxBytes = a.g(r6);
        this.retryCount = r6.j;
        this.backUpUrlRetryCount = r6.k;
        this.force = r6.l;
        this.outIp = a.h(r6);
        this.outSize = a.i(r6);
        this.needPostProgress = a.j(r6);
        this.maxProgressCount = a.k(r6);
        this.minProgressTimeMsInterval = a.l(r6);
        this.backUpUrls = a.m(r6);
        this.showNotification = r6.m;
        this.mimeType = r6.n;
        this.needHttpsToHttpRetry = r6.o;
        this.autoResumed = a.n(r6);
        this.showNotificationForAutoResumed = a.o(r6);
        this.needDefaultHttpServiceBackUp = r6.q;
        this.packageName = r6.r;
        this.md5 = r6.s;
        this.needIndependentProcess = r6.t;
        this.needCurrentProcess = r6.u;
        this.enqueueType = a.p(r6);
        this.ignoreDataVerify = a.q(r6);
        this.addListenerToSameTask = a.r(r6);
        this.iconUrl = r6.v;
        this.throttleNetSpeed = a.s(r6);
        this.throttleSmoothness = a.t(r6);
        this.openLimitSpeed = a.u(r6);
        this.title = r6.f15557b;
        JSONObject r2 = a.v(r6);
        if (r2 == null) goto L28;
        com.ss.android.socialbase.downloader.g.a.a(getId(), r2);
        unsafePutToDBJsonData("download_setting", r2.toString());
    L28:
        unsafePutToDBJsonData("dbjson_key_expect_file_length", Long.valueOf(a.w(r6)));
        unsafePutToDBJsonData("executor_group", Integer.valueOf(a.x(r6)));
        unsafePutToDBJsonData("auto_install", Integer.valueOf(a.y(r6) ? 1 : 0));
        this.needSDKMonitor = a.z(r6);
        this.extraMonitorStatus = a.A(r6);
        this.expiredRedownload = a.B(r6);
        this.expiredHttpCheck = a.C(r6);
        this.deleteCacheIfCheckFailed = a.D(r6);
        this.ttnetProtectTimeout = a.E(r6);
        this.addTTNetCommonParam = a.F(r6);
        Boolean r3 = Boolean.valueOf(a.G(r6));
        this.ignoreInterceptor = r3;
        if (r3.booleanValue() == false) goto L31;
    L32:
        this.interceptFlag = 0;
    L33:
        this.accessHttpHeaderKeys = a.H(r6);
        this.pcdnUrls = r6.d;
        this.cdnUrls = r6.e;
        this.cacheLifeTimeMax = r6.p;
        unsafePutToDBJsonData("ignore_intercept", Integer.valueOf(a.G(r6) ? 1 : 0));
        unsafePutToDBJsonData("start_offset", Long.valueOf(a.I(r6)));
        unsafePutToDBJsonData("end_offset", Long.valueOf(a.J(r6)));
        unsafePutToDBJsonData("need_sdk_monitor", Boolean.valueOf(this.needSDKMonitor));
        unsafePutToDBJsonData("monitor_scene", this.monitorScene);
        JSONArray r7 = new JSONArray();     // Catch: Throwable -> L43
        int[] r4 = this.extraMonitorStatus;     // Catch: Throwable -> L43
        if (r4 != null) goto L37;
    L41:
        unsafePutToDBJsonData("extra_monitor_status", r7);     // Catch: Throwable -> L43
        return;
    L37:
        if (r4.length <= 0) goto L41;
    L38:
        int[] r5 = this.extraMonitorStatus;     // Catch: Throwable -> L43
        if (r1 >= r5.length) goto L41;
        r7.put(r5[r1]);     // Catch: Throwable -> L43
        r1 = r1 + 1;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        if (((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).c() != null) goto L33;
    L23:
        if (((t) ZeusTransformUtils.preCheckCast(k.a(t.class), t.class, "com.obric.memorydata.plugin")).h(getId()) != null) goto L25;
        this.savePath = com.ss.android.socialbase.downloader.utils.g.a(this.savePath, this.url);
        this.tempPath = com.ss.android.socialbase.downloader.utils.g.a(this.tempPath, this.url);
        goto L25
    L48:
        r0 = com.ss.android.socialbase.downloader.utils.a.b();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    /* synthetic */ DownloadInfo(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    private DownloadInfo(b r6) {
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
        this.id = r6.x;
        this.name = r6.f15556a;
        this.title = r6.f15557b;
        this.url = r6.c;
        this.savePath = r6.f;
        this.tempPath = r6.g;
        this.chunkCount = r6.y;
        setStatus(r6.z);
        setCurBytes(r6.A);
        setBackCurBytes(r6.B);
        this.totalBytes = r6.C;
        this.eTag = r6.M;
        this.onlyWifi = r6.h;
        this.force = r6.l;
        this.retryCount = r6.j;
        this.extra = r6.i;
        this.mimeType = r6.n;
        this.showNotification = r6.m;
        this.notificationVisibility = r6.D;
        this.isFirstDownload = r6.E;
        this.isFirstSuccess = r6.F;
        this.needHttpsToHttpRetry = r6.o;
        this.downloadTime = r6.G;
        this.packageName = r6.r;
        this.md5 = r6.s;
        this.curRetryTime = r6.I;
        this.needDefaultHttpServiceBackUp = r6.q;
        this.backUpUrlsStr = r6.f15558J;
        this.backUpUrlRetryCount = r6.k;
        this.realDownloadTime = r6.K;
        this.realBackDownloadTime = r6.H;
        this.needIndependentProcess = r6.t;
        this.needCurrentProcess = r6.u;
        this.dbJsonDataString = r6.L;
        this.iconUrl = r6.v;
        this.appVersionCode = r6.w;
        this.downloadStartTimeStamp = r6.N;
        this.downloadFinishTimeStamp = r6.O;
        this.installedTimeStamp = r6.P;
        this.hasDoInstallation = r6.Q;
        this.pcdnUrlsStr = r6.R;
        this.cdnUrlsStr = r6.S;
        this.cacheLifeTimeMax = r6.p;
        parseMonitorSetting();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    /* synthetic */ DownloadInfo(b r1, AnonymousClass1 r2) {
        this(r1);
    }

    private void convertEnqueueType(int r2) {
        if (r2 != EnqueueType.ENQUEUE_HEAD.ordinal()) goto L7;
        EnqueueType r3 = EnqueueType.ENQUEUE_HEAD;
    L5:
        this.enqueueType = r3;
        return;
    L7:
        if (r2 != EnqueueType.ENQUEUE_TAIL.ordinal()) goto L10;
        r3 = EnqueueType.ENQUEUE_TAIL;
        goto L5
    L10:
        if (r2 != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L13;
        r3 = EnqueueType.NEW_ENQUEUE_NORMAL;
        goto L5
    L13:
        if (r2 != EnqueueType.NEW_ENQUEUE_IMMEDIATE.ordinal()) goto L15;
        r3 = EnqueueType.NEW_ENQUEUE_IMMEDIATE;
        goto L5
    L15:
        r3 = EnqueueType.ENQUEUE_NONE;
        goto L5
    }

    private JSONObject convertStrToJson(String r1) {
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    L3:
        if (TextUtils.isEmpty(r1) == true) goto L12;
        return new JSONObject(r1);
    L12:
        return null;
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
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L13;
        String r1 = r0.getSharedPreferences("sp_download_info", 0).getString(Long.toString(getId()), "");
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

    private int getReserveWifiStatus() {
        ensureSpData();
        return this.spData.optInt("pause_reserve_on_wifi", 0);
    L8:
        return 0;
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
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15 Exception -> L24
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

    private void parseMonitorSetting() {
        unsafeEnsureDBJsonData();
        int r2 = 0;
        this.needSDKMonitor = this.dbJsonData.optBoolean("need_sdk_monitor", false);
        this.monitorScene = this.dbJsonData.optString("monitor_scene", "");
        JSONArray r0 = this.dbJsonData.optJSONArray("extra_monitor_status");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L12;
        this.extraMonitorStatus = new int[r0.length()];
    L8:
        if (r2 >= r0.length()) goto L13;
        this.extraMonitorStatus[r2] = r0.optInt(r2);
        r2 = r2 + 1;
        goto L8
    L13:
        return;
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
        this.backUpUrls.add(this.forbiddenBackupUrls.get(r4));
        r4 = r4 + 1;
        goto L12
    L17:
        return;
    L9:
        r1.clear();
        goto L10
    }

    private void setBackCurBytes(long r2) {
        AtomicLong r0 = this.backCurBytes;
        if (r0 == null) goto L5;
        r0.set(r2);
        return;
    L5:
        this.backCurBytes = new AtomicLong(r2);
    }

    private void setBackUpUrlsStr(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (getStatus() == (-3)) goto L10;
        this.backUpUrlsStr = r3;
        this.backUpUrls = com.ss.android.socialbase.downloader.utils.g.f(r3);
        return;
    }

    private void unsafeEnsureDBJsonData() {
        if (this.dbJsonData == null) goto L14;
        return;
    L14:
    L11:
        this.dbJsonData = new JSONObject();
    L12:
        this.dbJsonDataString = null;
        return;
    L6:
        if (TextUtils.isEmpty(this.dbJsonDataString) == true) goto L9;
        JSONObject r0 = new JSONObject(this.dbJsonDataString);     // Catch: Throwable -> L11
    L8:
        this.dbJsonData = r0;     // Catch: Throwable -> L11
        goto L12
    L9:
        r0 = new JSONObject();     // Catch: Throwable -> L11
        goto L8
    }

    private void unsafePutToDBJsonData(String r1, Object r2) {
        this.dbJsonData.put(r1, r2);     // Catch: Exception -> L4
        return;
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
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r10.bindString(r1, r2);
        int r3 = this.bindValueCount + 1;
        this.bindValueCount = r3;
        String r4 = this.savePath;
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r10.bindString(r3, r4);
        int r5 = this.bindValueCount + 1;
        this.bindValueCount = r5;
        String r6 = this.tempPath;
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r10.bindString(r5, r6);
        int r7 = this.bindValueCount + 1;
        this.bindValueCount = r7;
        String r8 = this.name;
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        r10.bindString(r7, r8);
        int r9 = this.bindValueCount + 1;
        this.bindValueCount = r9;
        r10.bindLong(r9, this.chunkCount);
        int r11 = this.bindValueCount + 1;
        this.bindValueCount = r11;
        r10.bindLong(r11, getStatus());
        int r12 = this.bindValueCount + 1;
        this.bindValueCount = r12;
        r10.bindLong(r12, getCurBytes());
        int r13 = this.bindValueCount + 1;
        this.bindValueCount = r13;
        r10.bindLong(r13, this.totalBytes);
        int r14 = this.bindValueCount + 1;
        this.bindValueCount = r14;
        String r15 = this.eTag;
        if (r15 != null) goto L19;
        r15 = "";
    L19:
        r10.bindString(r14, r15);
        int r16 = this.bindValueCount + 1;
        this.bindValueCount = r16;
        long r17 = 1;
        if (this.onlyWifi == false) goto L22;
        long r18 = 1;
    L23:
        r10.bindLong(r16, r18);
        int r19 = this.bindValueCount + 1;
        this.bindValueCount = r19;
        if (this.force == false) goto L26;
        long r20 = 1;
    L27:
        r10.bindLong(r19, r20);
        int r21 = this.bindValueCount + 1;
        this.bindValueCount = r21;
        r10.bindLong(r21, this.retryCount);
        int r22 = this.bindValueCount + 1;
        this.bindValueCount = r22;
        String r23 = this.extra;
        if (r23 != null) goto L30;
        r23 = "";
    L30:
        r10.bindString(r22, r23);
        int r24 = this.bindValueCount + 1;
        this.bindValueCount = r24;
        String r25 = this.mimeType;
        if (r25 != null) goto L33;
        r25 = "";
    L33:
        r10.bindString(r24, r25);
        int r26 = this.bindValueCount + 1;
        this.bindValueCount = r26;
        String r27 = this.title;
        if (r27 != null) goto L36;
        r27 = "";
    L36:
        r10.bindString(r26, r27);
        int r28 = this.bindValueCount + 1;
        this.bindValueCount = r28;
        if (this.showNotification == false) goto L39;
        long r29 = 1;
    L40:
        r10.bindLong(r28, r29);
        int r30 = this.bindValueCount + 1;
        this.bindValueCount = r30;
        r10.bindLong(r30, this.notificationVisibility);
        int r31 = this.bindValueCount + 1;
        this.bindValueCount = r31;
        if (this.isFirstDownload == false) goto L43;
        long r32 = 1;
    L44:
        r10.bindLong(r31, r32);
        int r33 = this.bindValueCount + 1;
        this.bindValueCount = r33;
        if (this.isFirstSuccess == false) goto L47;
        long r34 = 1;
    L48:
        r10.bindLong(r33, r34);
        int r35 = this.bindValueCount + 1;
        this.bindValueCount = r35;
        if (this.needHttpsToHttpRetry == false) goto L51;
        long r36 = 1;
    L52:
        r10.bindLong(r35, r36);
        int r37 = this.bindValueCount + 1;
        this.bindValueCount = r37;
        r10.bindLong(r37, this.downloadTime);
        int r38 = this.bindValueCount + 1;
        this.bindValueCount = r38;
        String r39 = this.packageName;
        if (r39 != null) goto L55;
        r39 = "";
    L55:
        r10.bindString(r38, r39);
        int r40 = this.bindValueCount + 1;
        this.bindValueCount = r40;
        String r41 = this.md5;
        if (r41 != null) goto L58;
        r41 = "";
    L58:
        r10.bindString(r40, r41);
        int r42 = this.bindValueCount + 1;
        this.bindValueCount = r42;
        r10.bindLong(r42, 0);
        int r43 = this.bindValueCount + 1;
        this.bindValueCount = r43;
        r10.bindLong(r43, this.curRetryTime);
        int r44 = this.bindValueCount + 1;
        this.bindValueCount = r44;
        r10.bindLong(r44, 0);
        int r45 = this.bindValueCount + 1;
        this.bindValueCount = r45;
        if (this.needDefaultHttpServiceBackUp == false) goto L61;
        long r46 = 1;
    L62:
        r10.bindLong(r45, r46);
        int r47 = this.bindValueCount + 1;
        this.bindValueCount = r47;
        r10.bindLong(r47, 0);
        int r48 = this.bindValueCount + 1;
        this.bindValueCount = r48;
        r10.bindString(r48, "");
        int r49 = this.bindValueCount + 1;
        this.bindValueCount = r49;
        r10.bindLong(r49, 0);
        int r50 = this.bindValueCount + 1;
        this.bindValueCount = r50;
        r10.bindString(r50, getBackUpUrlsStr());
        int r51 = this.bindValueCount + 1;
        this.bindValueCount = r51;
        r10.bindLong(r51, this.backUpUrlRetryCount);
        int r52 = this.bindValueCount + 1;
        this.bindValueCount = r52;
        r10.bindLong(r52, this.realDownloadTime);
        int r53 = this.bindValueCount + 1;
        this.bindValueCount = r53;
        r10.bindLong(r53, 0);
        int r54 = this.bindValueCount + 1;
        this.bindValueCount = r54;
        if (this.needIndependentProcess == false) goto L65;
        long r55 = 1;
    L66:
        r10.bindLong(r54, r55);
        int r56 = this.bindValueCount + 1;
        this.bindValueCount = r56;
        r10.bindString(r56, getDBJsonDataString());
        int r57 = this.bindValueCount + 1;
        this.bindValueCount = r57;
        String r58 = this.iconUrl;
        if (r58 != null) goto L69;
        r58 = "";
    L69:
        r10.bindString(r57, r58);
        int r59 = this.bindValueCount + 1;
        this.bindValueCount = r59;
        r10.bindLong(r59, this.appVersionCode);
        int r60 = this.bindValueCount + 1;
        this.bindValueCount = r60;
        r10.bindString(r60, "");
        int r61 = this.bindValueCount + 1;
        this.bindValueCount = r61;
        r10.bindLong(r61, this.downloadStartTimeStamp);
        int r62 = this.bindValueCount + 1;
        this.bindValueCount = r62;
        r10.bindLong(r62, this.downloadFinishTimeStamp);
        int r63 = this.bindValueCount + 1;
        this.bindValueCount = r63;
        r10.bindLong(r63, this.installedTimeStamp);
        int r64 = this.bindValueCount + 1;
        this.bindValueCount = r64;
        if (this.hasDoInstallation == true) goto L73;
        r17 = 0;
    L73:
        r10.bindLong(r64, r17);
        int r65 = this.bindValueCount + 1;
        this.bindValueCount = r65;
        r10.bindLong(r65, this.cacheLifeTimeMax);
        int r66 = this.bindValueCount + 1;
        this.bindValueCount = r66;
        r10.bindString(r66, getPcdnUrlsStr());
        int r67 = this.bindValueCount + 1;
        this.bindValueCount = r67;
        r10.bindString(r67, getCdnUrlsStr());
        int r68 = this.bindValueCount + 1;
        this.bindValueCount = r68;
        r10.bindLong(r68, getBackCurBytes());
        int r69 = this.bindValueCount + 1;
        this.bindValueCount = r69;
        r10.bindLong(r69, this.realBackDownloadTime);
        return;
    L65:
        r55 = 0;
        goto L66
    L61:
        r46 = 0;
        goto L62
    L51:
        r36 = 0;
        goto L52
    L47:
        r34 = 0;
        goto L48
    L43:
        r32 = 0;
        goto L44
    L39:
        r29 = 0;
        goto L40
    L26:
        r20 = 0;
        goto L27
    L22:
        r18 = 0;
        goto L23
    }

    public boolean cacheExpierd() {
        if (isDownloaded() == true) goto L7;
        return true;
    L7:
        return com.ss.android.socialbase.downloader.utils.g.b(this);
    }

    public boolean canNotifyProgress() {
        if (this.lastNotifyProgressTime != 0) goto L5;
    L8:
        return true;
    L5:
        if ((SystemClock.uptimeMillis() - this.lastNotifyProgressTime) > 20) goto L8;
        return false;
    }

    public boolean canReStartAsyncTask() {
        if (getStatus() != (-3)) goto L5;
    L7:
        return false;
    L5:
        if (this.asyncHandleStatus != AsyncHandleStatus.ASYNC_HANDLE_WAITING) goto L7;
        return true;
    }

    public boolean canReplaceHttpForRetry() {
        if (TextUtils.isEmpty(this.url) == false) goto L5;
    L11:
        return false;
    L5:
        if (this.url.startsWith(LocationInfoConst.HTTPS) == false) goto L11;
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

    public boolean canSkipStatusHandler() {
        if (getStatus() != 8) goto L5;
    L12:
        return true;
    L5:
        if (this.asyncHandleStatus == AsyncHandleStatus.ASYNC_HANDLE_WAITING) goto L12;
        if (this.asyncHandleStatus == AsyncHandleStatus.ASYNC_HANDLE_RESTART) goto L12;
        if (this.byteInvalidRetryStatus == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART) goto L12;
        return false;
    }

    public void changeSkipStatus() {
        if (getStatus() != 8) goto L5;
    L8:
        setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING);
    L10:
        if (this.byteInvalidRetryStatus != ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART) goto L13;
        setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        return;
    L13:
        return;
    L5:
        if (this.asyncHandleStatus == AsyncHandleStatus.ASYNC_HANDLE_WAITING) goto L8;
        if (this.asyncHandleStatus != AsyncHandleStatus.ASYNC_HANDLE_RESTART) goto L10;
        goto L8
    }

    public int checkMd5Status() {
        return com.ss.android.socialbase.downloader.utils.g.a(new com.ss.android.socialbase.downloader.d.a(getSavePath(), getName()), this.md5);
    }

    public boolean checkMd5Valid() {
        return com.ss.android.socialbase.downloader.utils.g.b(getSavePath(), getName(), this.md5);
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
        String r3 = this.savePath;
        if (r3 != null) goto L12;
        return false;
    L12:
        if (r3.equals(r4.getSavePath()) == false) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
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

    public List<String> getAccessHttpHeaderKeys() {
        return this.accessHttpHeaderKeys;
    }

    public long getAllConnectTime() {
        ensureDBJsonData();
        if (this.allConnectTime != null) goto L6;
        this.allConnectTime = new AtomicLong(this.dbJsonData.optLong("dbjson_key_all_connect_time"));
    L6:
        return this.allConnectTime.get();
    }

    public int getAntiHijackErrorCode(int r2) {
        ensureDBJsonData();
        return this.dbJsonData.optInt("anti_hijack_error_code", r2);
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public AsyncHandleStatus getAsyncHandleStatus() {
        return this.asyncHandleStatus;
    }

    public long getBackCurBytes() {
        AtomicLong r2 = this.backCurBytes;
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.get();
    }

    public String getBackUpUrl() {
        if (this.backUpUrlUsed == false) goto L15;
        List<String> r0 = this.backUpUrls;
        if (r0 == null) goto L15;
        if (r0.size() <= 0) goto L15;
        int r1 = this.curBackUpUrlIndex;
        if (r1 < 0) goto L15;
        if (r1 >= this.backUpUrls.size()) goto L15;
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.backUpUrls.get(this.curBackUpUrlIndex), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r2) == true) goto L15;
        return r2;
    L15:
        return "";
    }

    public int getBackUpUrlRetryCount() {
        return this.backUpUrlRetryCount;
    }

    public List<String> getBackUpUrls() {
        return this.backUpUrls;
    }

    public String getBackUpUrlsStr() {
        if (this.backUpUrlsStr != null) goto L6;
        this.backUpUrlsStr = com.ss.android.socialbase.downloader.utils.g.b(this.backUpUrls);
    L6:
        return this.backUpUrlsStr;
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public ByteInvalidRetryStatus getByteInvalidRetryStatus() {
        return this.byteInvalidRetryStatus;
    }

    public long getCacheExpiredTime() {
        ensureSpData();
        return this.spData.optLong("cache-control/expired_time", -1);
    L8:
        return -1;
    }

    public long getCacheLifeTimeMax() {
        return this.cacheLifeTimeMax;
    }

    public List<String> getCdnUrls() {
        return this.cdnUrls;
    }

    public String getCdnUrlsStr() {
        if (this.cdnUrlsStr != null) goto L6;
        this.cdnUrlsStr = com.ss.android.socialbase.downloader.utils.g.b(this.cdnUrls);
    L6:
        return this.cdnUrlsStr;
    }

    @Deprecated
    public int getChunkCount() {
        return this.chunkCount;
    }

    public String getConnectionUrl() {
        String r0 = this.url;
        if (getStatus() != 8) goto L12;
        List<String> r1 = this.forbiddenBackupUrls;
        if (r1 == null) goto L12;
        if (r1.isEmpty() == true) goto L12;
        if (this.backUpUrlUsed == true) goto L12;
        return (String) ZeusTransformUtils.preCheckCast(this.forbiddenBackupUrls.get(0), String.class, "com.obric.memorydata.plugin");
    L12:
        if (this.backUpUrlUsed == false) goto L25;
        List<String> r2 = this.backUpUrls;
        if (r2 == null) goto L25;
        if (r2.size() <= 0) goto L25;
        int r3 = this.curBackUpUrlIndex;
        if (r3 < 0) goto L25;
        if (r3 >= this.backUpUrls.size()) goto L25;
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.backUpUrls.get(this.curBackUpUrlIndex), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L36;
        return r0;
    L36:
        return r4;
    L25:
        if (TextUtils.isEmpty(this.url) == false) goto L27;
        return r0;
    L27:
        if (this.url.startsWith(LocationInfoConst.HTTPS) == true) goto L29;
        return r0;
    L29:
        if (this.needHttpsToHttpRetry == true) goto L31;
        return r0;
    L31:
        if (this.httpsToHttpRetryUsed == true) goto L33;
        return r0;
    L33:
        return this.url.replaceFirst(LocationInfoConst.HTTPS, "http");
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public int getCurBackUpUrlIndex() {
        return this.curBackUpUrlIndex;
    }

    public long getCurBytes() {
        AtomicLong r2 = this.curBytes;
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.get();
    }

    public int getCurNetworkRetryCount() {
        return this.curNetworkRetryCount;
    }

    public int getCurRetryTime() {
        return this.curRetryTime;
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

    public int getDBInitStatus() {
        return this.mDBInitStatus;
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

    public int getDBJsonInt(String r1) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(r1);
    }

    public String getDBJsonString(String r1) {
        ensureDBJsonData();
        return this.dbJsonData.optString(r1);
    }

    public long getDownloadFinishTimeStamp() {
        return this.downloadFinishTimeStamp;
    }

    public long getDownloadPrepareTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_download_prepare_time");
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

    public long getDownloadStartTimeStamp() {
        return this.downloadStartTimeStamp;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public long getEndOffset() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("end_offset", -1);
    }

    public EnqueueType getEnqueueType() {
        return this.enqueueType;
    }

    public int getExecutorGroup() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("executor_group", 2);
    }

    public long getExpectFileLength() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_expect_file_length");
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

    public int getFailedResumeCount() {
        ensureSpData();
        return this.spData.optInt("failed_resume_count", 0);
    }

    public String getFilePackageName() {
        return this.filePackageName;
    }

    public long getFirstSpeedTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_first_speed_time");
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

    public int getId() {
        if (this.id != 0) goto L6;
        this.id = ((n) ZeusTransformUtils.preCheckCast(k.a(n.class), n.class, "com.obric.memorydata.plugin")).a(this);
    L6:
        return this.id;
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
        return this.spData.optString("last-modified", null);
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

    public long getMinByteIntervalForPostToMainThread(long r3) {
        int r2 = this.maxProgressCount;
        if (r2 > 0) goto L5;
        r2 = 100;
    L5:
        long r4 = r3 / ((long) (r2 + 1));
        if (r4 > 0) goto L9;
        return 1048576;
    L9:
        return r4;
    }

    public int getMinProgressTimeMsInterval() {
        int r1 = this.minProgressTimeMsInterval;
        if (r1 < 1000) goto L5;
        return r1;
    L5:
        return 1000;
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

    public PackageInfo getPackageInfo() {
        SoftReference<PackageInfo> r2 = this.packageInfoRef;
        if (r2 != null) goto L6;
        return null;
    L6:
        return (PackageInfo) ZeusTransformUtils.preCheckCast(r2.get(), PackageInfo.class, "com.obric.memorydata.plugin");
    }

    public PackageInfo getPackageInfoWithCache() {
        ensureDBJsonData();
        String r3 = this.dbJsonData.optString("app_package_info");
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return null;
    L10:
        String[] r4 = r3.split(",");     // Catch: Throwable -> L7
        PackageInfo r0 = new PackageInfo();     // Catch: Throwable -> L7
        r0.packageName = r4[0];     // Catch: Throwable -> L7
        r0.versionName = r4[1];     // Catch: Throwable -> L7
        r0.versionCode = Integer.parseInt(r4[2]);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getPausedResumeCount() {
        ensureSpData();
        return this.spData.optInt("paused_resume_count", 0);
    }

    public JSONObject getPcdnStats() {
        return this.pcdnStats;
    }

    public List<String> getPcdnUrls() {
        return this.pcdnUrls;
    }

    public String getPcdnUrlsStr() {
        if (this.pcdnUrlsStr != null) goto L6;
        this.pcdnUrlsStr = com.ss.android.socialbase.downloader.utils.g.b(this.pcdnUrls);
    L6:
        return this.pcdnUrlsStr;
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

    public String getRedirectPartialUrlResults() {
        ensureDBJsonData();
        return this.dbJsonData.optString("redirect_partial_url_results");
    }

    public String getRequestLog() {
        return this.requestLog;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public int getRetryScheduleCount() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("retry_schedule_count", 0);
    }

    public String getSavePath() {
        return this.savePath;
    }

    public int getSpIntVal(String r2) {
        ensureSpData();
        return this.spData.optInt(r2, 0);
    }

    public long getSpLongVal(String r3) {
        ensureSpData();
        return this.spData.optLong(r3, 0);
    }

    public String getSpStringVal(String r2) {
        ensureSpData();
        return this.spData.optString(r2, null);
    }

    public long getStartOffset() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("start_offset");
    }

    public int getStatus() {
        AtomicInteger r1 = this.status;
        if (r1 == null) goto L8;
        int r2 = r1.get();
        if (r2 != (-5)) goto L10;
        return -2;
    L10:
        return r2;
    L8:
        return 0;
    }

    public int getStatusAtDbInit() {
        return this.statusAtDbInit;
    }

    public int getTTMd5CheckStatus() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("ttmd5_check_status", -1);
    }

    public String getTargetFilePath() {
        return com.ss.android.socialbase.downloader.utils.g.b(this.savePath, this.name);
    }

    public String getTaskKey() {
        ensureDBJsonData();
        return this.dbJsonData.optString("task_key");
    }

    public ConcurrentHashMap<String, Object> getTempCacheData() {
        ensureTempCacheData();
        return this.tempCacheData;
    }

    public String getTempFilePath() {
        return com.ss.android.socialbase.downloader.utils.g.a(this.savePath, this.tempPath, this.name);
    }

    public String getTempName() {
        return com.ss.android.socialbase.downloader.utils.g.b(this.name);
    }

    public String getTempPath() {
        return com.ss.android.socialbase.downloader.utils.g.c(this.savePath, this.tempPath);
    }

    public long getThrottleNetSpeed() {
        return this.throttleNetSpeed;
    }

    public int getThrottleSmoothness() {
        return this.throttleSmoothness;
    }

    public String getTitle() {
        if (TextUtils.isEmpty(this.title) == false) goto L7;
        return this.name;
    L7:
        return this.title;
    }

    public long getTotalBytes() {
        return this.totalBytes;
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

    public long getTtnetProtectTimeout() {
        return this.ttnetProtectTimeout;
    }

    public int getUninstallResumeCount() {
        ensureSpData();
        return this.spData.optInt("unins_resume_count", 0);
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

    public boolean hasPauseReservedOnWifi() {
        if ((getReserveWifiStatus() & 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public void increaseAllConnectTime(long r3) {
        if (r3 <= 0) goto L6;
        getAllConnectTime();
        safePutToDBJsonData("dbjson_key_all_connect_time", Long.valueOf(this.allConnectTime.addAndGet(r3)));
        return;
    }

    public void increaseCurBytes(long r2) {
        this.curBytes.addAndGet(r2);
        if (this.fastDownload == false) goto L5;
        return;
    L5:
        if (com.ss.android.socialbase.downloader.a.a.a().c() == false) goto L9;
        this.backCurBytes.addAndGet(r2);
        return;
    }

    public void increaseDownloadPrepareTime(long r3) {
        if (this.fastDownload == false) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis() - r3;
        if (r0 <= 0) goto L9;
        safePutToDBJsonData("dbjson_key_download_prepare_time", Long.valueOf(getDownloadPrepareTime() + r0));
        return;
    }

    public boolean isAddListenerToSameTask() {
        return this.addListenerToSameTask;
    }

    public boolean isAddTTNetCommonParam() {
        return this.addTTNetCommonParam;
    }

    public boolean isAutoInstall() {
        ensureDBJsonData();
        if (this.dbJsonData.optInt("auto_install", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isAutoInstallWithoutNotification() {
        if (this.isAutoInstallWithoutNotification != null) goto L10;
        if (TextUtils.isEmpty(this.extra) == false) goto L12;
    L8:
        this.isAutoInstallWithoutNotification = false;
        goto L10
    L12:
        this.isAutoInstallWithoutNotification = Boolean.valueOf(new JSONObject(this.extra).optBoolean("auto_install_without_notification", false));     // Catch: JSONException -> L11
    L10:
        return this.isAutoInstallWithoutNotification.booleanValue();
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

    public boolean isChunked() {
        return com.ss.android.socialbase.downloader.utils.g.a(this.totalBytes);
    }

    public boolean isDeleteCacheIfCheckFailed() {
        return this.deleteCacheIfCheckFailed;
    }

    public boolean isDownloadFromReserveWifi() {
        return this.mDownloadFromReserveWifi;
    }

    public boolean isDownloadOverStatus() {
        return DownloadStatus.isDownloadOver(getStatus());
    }

    public boolean isDownloadWithWifiValid() {
        if (isOnlyWifi() == true) goto L5;
    L8:
        return true;
    L5:
        if (com.ss.android.socialbase.downloader.utils.g.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L8;
        return false;
    }

    public boolean isDownloaded() {
        return com.ss.android.socialbase.downloader.utils.g.a(this);
    }

    public boolean isDownloadingStatus() {
        return DownloadStatus.isDownloading(getStatus());
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

    public boolean isExpiredHttpCheck() {
        return this.expiredHttpCheck;
    }

    public boolean isExpiredRedownload() {
        return this.expiredRedownload;
    }

    public boolean isFastDownload() {
        return this.fastDownload;
    }

    public boolean isFileDataExists() {
        if (isEntityInvalid() == false) goto L5;
        return false;
    L5:
        File r0 = new File(getTempPath(), getTempName());
        boolean r3 = r0.exists();
        boolean r1 = r0.isDirectory();
        if (r3 == false) goto L11;
        if (r1 == true) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean isFileDataValid() {
        if (isEntityInvalid() == false) goto L5;
        return false;
    L5:
        File r0 = new File(getTempPath(), getTempName());
        boolean r2 = r0.exists();
        boolean r3 = r0.isDirectory();
        if (com.ss.android.socialbase.downloader.e.a.a(this) == false) goto L8;
        com.ss.android.socialbase.downloader.e.a.a(TAG, this, "isFileDataValid", "Temp file:" + r0 + "IsExists:" + r2 + " isDirectory: " + r3);
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
        if (com.ss.android.socialbase.downloader.e.a.a(this) == false) goto L31;
        com.ss.android.socialbase.downloader.e.a.a(TAG, this, "isFileDataValid", "Valid, FileLength+" + r4 + " curBytes:" + r7);
        return true;
    L31:
        return true;
    L28:
        if (com.ss.android.socialbase.downloader.e.a.a(this) == false) goto L30;
        com.ss.android.socialbase.downloader.e.a.a(TAG, this, "isFileDataValid", "Invalid, Cur = " + r7 + ",totalBytes =" + this.totalBytes + ",fileLength=" + r4 + ", chunkCount:" + this.chunkCount);
    L30:
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
        return !new File(getTempPath(), getTempName()).exists();
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

    public boolean isNewTask() {
        if (getStatus() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOnlyWifi() {
        return this.onlyWifi;
    }

    public boolean isPauseByNotification() {
        if (TextUtils.isEmpty(this.extra) == true) goto L12;
        return new JSONObject(this.extra).optBoolean("pause_by_notification");
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    L12:
        return false;
    }

    public boolean isPauseReserveOnWifi() {
        if ((getReserveWifiStatus() & 2) <= 0) goto L5;
        return true;
    L5:
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
        if (com.ss.android.socialbase.downloader.utils.g.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L9;
        return true;
    }

    public boolean isSavePathRedirected() {
        ensureDBJsonData();
        return this.dbJsonData.optBoolean("is_save_path_redirected", false);
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

    public boolean isWaitingWifiStatus() {
        BaseException r1 = this.failedException;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.getErrorCode() != 1013) goto L7;
        return true;
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
        this.failedException = (BaseException) ZeusTransformUtils.preCheckCast(r6.readParcelable(BaseException.class.getClassLoader()), BaseException.class, "com.obric.memorydata.plugin");
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
        if (r6.readByte() != 0) goto L98;
        r1 = false;
    L98:
        this.needCurrentProcess = r1;
        parseMonitorSetting();
        return;
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

    public void resetRealStartDownloadTime() {
        this.realStartDownloadTime = 0;
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

    public void setCurBytes(long r3, boolean r5) {
        if (r5 == false) goto L5;
    L3:
        setCurBytes(r3);
        return;
    L5:
        if (r3 > getCurBytes()) goto L3;
    }

    public void setCurNetworkRetryCount(int r1) {
        this.curNetworkRetryCount = r1;
    }

    public void setDBInitStatus(int r1) {
        this.mDBInitStatus = r1;
    }

    public void setDeleteCacheIfCheckFailed() {
        this.deleteCacheIfCheckFailed = true;
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

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setFailedException(BaseException r1) {
        this.failedException = r1;
    }

    public void setFailedResumeCount(int r2) {
        ensureSpData();
        this.spData.put("failed_resume_count", r2);     // Catch: Exception -> L5
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

    public void setFirstSpeedTime(long r1) {
        safePutToDBJsonData("dbjson_key_first_speed_time", Long.valueOf(r1));
    }

    public void setFirstSuccess(boolean r1) {
        this.isFirstSuccess = r1;
    }

    public void setForbiddenBackupUrls(List<String> r3, boolean r4) {
        this.forbiddenBackupUrls = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        refreshBackupUrls(r4);
    }

    public void setForbiddenRetryed() {
        this.isForbiddenRetryed = true;
    }

    public void setHasDoInstallation(boolean r1) {
        this.hasDoInstallation = r1;
    }

    public void setHttpHeaders(Map<String, String> r3) {
        this.httpHeaders = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
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

    public void setInstalledTimeStamp(long r1) {
        this.installedTimeStamp = r1;
    }

    public void setInterceptFlag(int r1) {
        this.interceptFlag = r1;
    }

    public void setLastFailedResumeTime(long r2) {
        ensureSpData();
        this.spData.put("last_failed_resume_time", r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setLastModified(String r3) {
        ensureSpData();
        this.spData.put("last-modified", r3);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    }

    public void setLastNotifyProgressTime() {
        this.lastNotifyProgressTime = SystemClock.uptimeMillis();
    }

    public void setLastUninstallResumeTime(long r2) {
        ensureSpData();
        this.spData.put("last_unins_resume_time", r2);     // Catch: Exception -> L5
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

    public void setName(String r1) {
        this.name = r1;
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
        r0.put("pause_by_notification", r3);     // Catch: JSONException -> L8
        this.extra = r0.toString();     // Catch: JSONException -> L8
        return;
    L5:
        r0 = new JSONObject(this.extra);     // Catch: JSONException -> L8
        goto L6
    }

    public void setPausedResumeCount(int r2) {
        ensureSpData();
        this.spData.put("paused_resume_count", r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setPcdnStats(JSONObject r1) {
        this.pcdnStats = r1;
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

    public void setSpValue(String r2, String r3) {
        ensureSpData();
        this.spData.put(r2, r3);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
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

    public void setThrottleNetSpeed(long r2) {
        setThrottleNetSpeed(r2, -1);
    }

    public void setThrottleNetSpeed(long r1, int r3) {
        this.throttleNetSpeed = r1;
        this.throttleSmoothness = r3;
    }

    public void setTotalBytes(long r1) {
        this.totalBytes = r1;
    }

    public void setUninstallResumeCount(int r2) {
        ensureSpData();
        this.spData.put("unins_resume_count", r2);     // Catch: Exception -> L5
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

    public String toDetailString() {
        return "DownloadInfo{id=" + this.id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "', tempPath='" + this.tempPath + "', onlyWifi=" + this.onlyWifi + ", extra='" + this.extra + "', extraHeaders=" + this.extraHeaders + ", maxBytes=" + this.maxBytes + ", outIp=" + Arrays.toString(this.outIp) + ", outSize=" + Arrays.toString(this.outSize) + ", retryCount=" + this.retryCount + ", backUpUrlRetryCount=" + this.backUpUrlRetryCount + ", force=" + this.force + ", needPostProgress=" + this.needPostProgress + ", maxProgressCount=" + this.maxProgressCount + ", minProgressTimeMsInterval=" + this.minProgressTimeMsInterval + ", backUpUrls=" + this.backUpUrls + ", showNotification=" + this.showNotification + ", mimeType='" + this.mimeType + "', needHttpsToHttpRetry=" + this.needHttpsToHttpRetry + ", cacheLifeTimeMax=" + this.cacheLifeTimeMax + ", pcdnUrls=" + this.pcdnUrls + ", cdnUrls=" + this.cdnUrls + ", pcdnUrlsStr='" + this.pcdnUrlsStr + "', cdnUrlsStr='" + this.cdnUrlsStr + "', packageName='" + this.packageName + "', filePackageName='" + this.filePackageName + "', md5='" + this.md5 + "', allConnectTime=" + this.allConnectTime + ", needDefaultHttpServiceBackUp=" + this.needDefaultHttpServiceBackUp + ", eTag='" + this.eTag + "', curRetryTime=" + this.curRetryTime + ", asyncHandleStatus=" + this.asyncHandleStatus + ", ignoreDataVerify=" + this.ignoreDataVerify + ", needIndependentProcess=" + this.needIndependentProcess + ", needCurrentProcess=" + this.needCurrentProcess + ", supportPartial=" + this.supportPartial + ", iconUrl='" + this.iconUrl + "', curNetworkRetryCount=" + this.curNetworkRetryCount + ", needSDKMonitor=" + this.needSDKMonitor + ", monitorScene='" + this.monitorScene + "', extraMonitorStatus=" + Arrays.toString(this.extraMonitorStatus) + ", expiredRedownload=" + this.expiredRedownload + ", expiredHttpCheck=" + this.expiredHttpCheck + ", deleteCacheIfCheckFailed=" + this.deleteCacheIfCheckFailed + ", successByCache=" + this.successByCache + ", ignoreInterceptor=" + this.ignoreInterceptor + ", interceptFlag=" + this.interceptFlag + ", downloadStartTimeStamp=" + this.downloadStartTimeStamp + ", downloadFinishTimeStamp=" + this.downloadFinishTimeStamp + ", installedTimeStamp=" + this.installedTimeStamp + ", hasDoInstallation=" + this.hasDoInstallation + ", networkQuality='" + this.networkQuality + "', curBackUpUrlIndex=" + this.curBackUpUrlIndex + ", notificationVisibility=" + this.notificationVisibility + ", chunkCount=" + this.chunkCount + ", curBytes=" + this.curBytes + ", totalBytes=" + this.totalBytes + ", xTotalBytes=" + this.xTotalBytes + ", status=" + this.status + ", isFirstDownload=" + this.isFirstDownload + ", isFirstSuccess=" + this.isFirstSuccess + ", downloadTime=" + this.downloadTime + ", realDownloadTime=" + this.realDownloadTime + ", backUpUrlUsed=" + this.backUpUrlUsed + ", httpsToHttpRetryUsed=" + this.httpsToHttpRetryUsed + ", startDownloadTime=" + this.startDownloadTime + ", realStartDownloadTime=" + this.realStartDownloadTime + ", bindValueCount=" + this.bindValueCount + ", autoResumed=" + this.autoResumed + ", showNotificationForAutoResumed=" + this.showNotificationForAutoResumed + ", showNotificationForNetworkResumed=" + this.showNotificationForNetworkResumed + ", forbiddenBackupUrls=" + this.forbiddenBackupUrls + ", byteInvalidRetryStatus=" + this.byteInvalidRetryStatus + ", enqueueType=" + this.enqueueType + ", httpStatusCode=" + this.httpStatusCode + ", httpStatusMessage='" + this.httpStatusMessage + "', lastNotifyProgressTime=" + this.lastNotifyProgressTime + ", isForbiddenRetryed=" + this.isForbiddenRetryed + ", appVersionCode=" + this.appVersionCode + ", throttleNetSpeed=" + this.throttleNetSpeed + ", throttleSmoothness=" + this.throttleSmoothness + ", openLimitSpeed=" + this.openLimitSpeed + ", isCacheExistsInDownloading=" + this.isCacheExistsInDownloading + ", contentEncoding='" + this.contentEncoding + "', addListenerToSameTask=" + this.addListenerToSameTask + ", backUpUrlsStr='" + this.backUpUrlsStr + "', failedException=" + this.failedException + ", pcdnStats=" + this.pcdnStats + ", spData=" + this.spData + ", dbJsonData=" + this.dbJsonData + ", dbJsonDataString='" + this.dbJsonDataString + "', tempCacheData=" + this.tempCacheData + ", statusAtDbInit=" + this.statusAtDbInit + ", mDownloadFromReserveWifi=" + this.mDownloadFromReserveWifi + ", packageInfoRef=" + this.packageInfoRef + ", ttnetProtectTimeout=" + this.ttnetProtectTimeout + ", addTTNetCommonParam=" + this.addTTNetCommonParam + ", accessHttpHeaderKeys=" + this.accessHttpHeaderKeys + ", httpHeaders=" + this.httpHeaders + ", isAutoInstallWithoutNotification=" + this.isAutoInstallWithoutNotification + '}';
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
        if (TextUtils.isEmpty((String) ZeusTransformUtils.preCheckCast(this.backUpUrls.get(this.curBackUpUrlIndex), String.class, "com.obric.memorydata.plugin")) == false) goto L16;
        this.curBackUpUrlIndex++;
        goto L13
    L16:
        this.backUpUrlUsed = true;
        return true;
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
        if (com.ss.android.socialbase.downloader.a.a.a().c() == false) goto L22;
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

    public void updateRealStartDownloadTime() {
        if (this.realStartDownloadTime != 0) goto L6;
        this.realStartDownloadTime = System.nanoTime();
        return;
    }

    public void updateSpData() {
        if (this.spData != null) goto L5;
        return;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        r0.getSharedPreferences("sp_download_info", 0).edit().putString(Integer.toString(getId()), this.spData.toString()).apply();
        return;
    }

    public void updateStartDownloadTime() {
        this.startDownloadTime = SystemClock.uptimeMillis();
        if (this.fastDownload == false) goto L5;
        return;
    L5:
        safePutToDBJsonData("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
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
    }
}
