package com.ss.android.socialbase.downloader.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.exception.BaseException;
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
import qb.k;
import qb.l;
import qb.n;
import qb.t;

/* JADX INFO: loaded from: classes2.dex */
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
    private boolean isDynamicThrottleEnable;
    private boolean isFirstDownload;
    private boolean isFirstSuccess;
    private boolean isForbiddenRetryed;
    private long lastNotifyProgressTime;
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

    static class a implements Parcelable.Creator<DownloadInfo> {
        a() {
        }

        public DownloadInfo a(Parcel r10) {
            return new DownloadInfo(r10);
        }

        public DownloadInfo[] b(int r10) {
            return new DownloadInfo[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DownloadInfo createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DownloadInfo[] newArray(int r10) {
            return b(r10);
        }
    }

    public static class b {
        protected boolean A;
        private boolean B;
        protected boolean C;
        protected String D;
        protected String E;
        private long F;
        protected boolean G;
        protected boolean H;
        private EnqueueType I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private boolean f8088J;
        protected String K;
        protected int L;
        private long M;
        private long N;
        private long O;
        private int P;
        private boolean Q;
        private boolean R;
        private JSONObject S;
        private boolean T;
        private String U;
        private int[] V;
        private int W;
        private boolean X;
        private boolean Y;
        private boolean Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected String f8089a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        private long f8090a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f8091b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        private boolean f8092b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected String f8093c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        private boolean f8094c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected List<String> f8095d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        private String f8096d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected List<String> f8097e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        private boolean f8098e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected String f8099f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        private List<String> f8100f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected String f8101g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        private boolean f8102g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected boolean f8103h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        private boolean f8104h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected String f8105i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<HttpHeader> f8106j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f8107k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String[] f8108l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int[] f8109m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        protected int f8110n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        protected int f8111o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        protected boolean f8112p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f8113q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f8114r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f8115s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private List<String> f8116t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        protected boolean f8117u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private boolean f8118v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        protected String f8119w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        protected boolean f8120x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        protected long f8121y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private boolean f8122z;

        public b() {
            this.f8113q = true;
            this.f8118v = true;
            this.C = true;
            this.I = EnqueueType.ENQUEUE_NONE;
            this.M = 0;
            this.N = -1;
            this.T = true;
        }

        static /* synthetic */ boolean A(b r10) {
            return r10.f8098e0;
        }

        static /* synthetic */ List B(b r10) {
            return r10.f8100f0;
        }

        static /* synthetic */ long C(b r10) {
            return r10.M;
        }

        static /* synthetic */ long D(b r10) {
            return r10.N;
        }

        static /* synthetic */ boolean E(b r10) {
            return r10.f8094c0;
        }

        static /* synthetic */ List F(b r10) {
            return r10.f8106j;
        }

        static /* synthetic */ int G(b r10) {
            return r10.f8107k;
        }

        static /* synthetic */ String[] H(b r10) {
            return r10.f8108l;
        }

        static /* synthetic */ int[] I(b r10) {
            return r10.f8109m;
        }

        static /* synthetic */ boolean J(b r10) {
            return r10.f8113q;
        }

        static /* synthetic */ String a(b r10) {
            return r10.U;
        }

        static /* synthetic */ boolean b(b r10) {
            return r10.f8102g0;
        }

        static /* synthetic */ int c(b r10) {
            return r10.f8114r;
        }

        static /* synthetic */ int d(b r10) {
            return r10.f8115s;
        }

        static /* synthetic */ List e(b r10) {
            return r10.f8116t;
        }

        static /* synthetic */ boolean f(b r10) {
            return r10.f8122z;
        }

        static /* synthetic */ boolean g(b r10) {
            return r10.B;
        }

        static /* synthetic */ EnqueueType h(b r10) {
            return r10.I;
        }

        static /* synthetic */ boolean i(b r10) {
            return r10.f8088J;
        }

        static /* synthetic */ boolean j(b r10) {
            return r10.R;
        }

        static /* synthetic */ long k(b r10) {
            return r10.O;
        }

        static /* synthetic */ int l(b r10) {
            return r10.P;
        }

        static /* synthetic */ boolean m(b r10) {
            return r10.f8104h0;
        }

        static /* synthetic */ boolean n(b r10) {
            return r10.Q;
        }

        static /* synthetic */ JSONObject o(b r10) {
            return r10.S;
        }

        static /* synthetic */ long p(b r10) {
            return r10.F;
        }

        static /* synthetic */ int q(b r10) {
            return r10.W;
        }

        static /* synthetic */ boolean r(b r10) {
            return r10.f8118v;
        }

        static /* synthetic */ boolean s(b r10) {
            return r10.T;
        }

        static /* synthetic */ int[] t(b r10) {
            return r10.V;
        }

        static /* synthetic */ boolean u(b r10) {
            return r10.X;
        }

        static /* synthetic */ boolean v(b r10) {
            return r10.Y;
        }

        static /* synthetic */ boolean w(b r10) {
            return r10.Z;
        }

        static /* synthetic */ String x(b r10) {
            return r10.f8096d0;
        }

        static /* synthetic */ long y(b r10) {
            return r10.f8090a0;
        }

        static /* synthetic */ boolean z(b r10) {
            return r10.f8092b0;
        }

        public b K(int r10) {
            this.L = r10;
            return this;
        }

        public b L(boolean r10) {
            this.f8122z = r10;
            return this;
        }

        public b M(int r10) {
            this.f8111o = r10;
            return this;
        }

        public DownloadInfo N() {
            return new DownloadInfo(this, null);
        }

        public b O(long r10) {
            this.f8121y = r10;
            return this;
        }

        public b P(JSONObject r10) {
            this.S = r10;
            return this;
        }

        public b Q(String r10) {
            this.f8105i = r10;
            return this;
        }

        public b R(boolean r10) {
            this.f8112p = r10;
            return this;
        }

        public b S(String r10) {
            this.K = r10;
            return this;
        }

        public b T(String r10) {
            this.E = r10;
            return this;
        }

        public b U(String r10) {
            this.f8119w = r10;
            return this;
        }

        public b V(String r10) {
            this.f8089a = r10;
            return this;
        }

        public b W(boolean r10) {
            this.H = r10;
            return this;
        }

        public b X(boolean r10) {
            this.C = r10;
            return this;
        }

        public b Y(boolean r10) {
            this.f8120x = r10;
            return this;
        }

        public b Z(boolean r10) {
            this.G = r10;
            return this;
        }

        public b a0(boolean r10) {
            this.f8103h = r10;
            return this;
        }

        public b b0(String r10) {
            this.D = r10;
            return this;
        }

        public b c0(int r10) {
            this.f8110n = r10;
            return this;
        }

        public b d0(String r10) {
            this.f8099f = r10;
            return this;
        }

        public b e0(boolean r10) {
            this.f8117u = r10;
            return this;
        }

        public b f0(String r10) {
            this.f8101g = r10;
            return this;
        }

        public b g0(String r10) {
            this.f8091b = r10;
            return this;
        }

        public b h0(String r10) {
            this.f8093c = r10;
            return this;
        }
    }

    public static class c extends b {
        public long A0;
        public boolean B0;
        public String C0;
        public String D0;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f8123i0;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f8124j0;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int f8125k0;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public long f8126l0;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public long f8127m0;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public long f8128n0;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public int f8129o0;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public boolean f8130p0;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public boolean f8131q0;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public long f8132r0;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public long f8133s0;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public int f8134t0;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public String f8135u0;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public long f8136v0;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public String f8137w0;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public String f8138x0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public long f8139y0;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public long f8140z0;

        public c() {
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadInfo.b
        public DownloadInfo N() {
            return new DownloadInfo(this, null);
        }
    }

    static {
        CREATOR = new a();
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
    public DownloadInfo(Cursor r10) {
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

    protected DownloadInfo(Parcel r10) {
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
        readFromParcel(r10);
    }

    private DownloadInfo(b r10) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        int r11 = 0;
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
        if (r10 != null) goto L5;
        return;
    L5:
        this.status = new AtomicInteger(0);
        this.curBytes = new AtomicLong(0);
        this.monitorScene = b.a(r10);
        this.fastDownload = b.b(r10);
        this.name = r10.f8089a;
        this.url = r10.f8093c;
        String r12 = r10.f8099f;
        if (TextUtils.isEmpty(r12) == true) goto L46;
    L11:
        this.savePath = r12;
        this.handleRequest = b.m(r10);
        if (b.b(r10) == false) goto L15;
        this.tempPath = com.ss.android.socialbase.downloader.utils.a.d();
        return;
    L15:
        this.backCurBytes = new AtomicLong(0);
        this.tempPath = r10.f8101g;
        unsafeEnsureDBJsonData();
        unsafePutToDBJsonData("task_key", b.x(r10));
        if (TextUtils.isEmpty(this.tempPath) == false) goto L21;
        if (com.ss.android.socialbase.downloader.utils.a.p(r12) == true) goto L21;
        this.tempPath = com.ss.android.socialbase.downloader.utils.a.f();
    L21:
        if (b.E(r10) == true) goto L23;
    L25:
        this.extra = r10.f8105i;
        this.onlyWifi = r10.f8103h;
        this.extraHeaders = b.F(r10);
        this.maxBytes = b.G(r10);
        this.retryCount = r10.f8110n;
        this.backUpUrlRetryCount = r10.f8111o;
        this.force = r10.f8112p;
        this.outIp = b.H(r10);
        this.outSize = b.I(r10);
        this.needPostProgress = b.J(r10);
        this.maxProgressCount = b.c(r10);
        this.minProgressTimeMsInterval = b.d(r10);
        this.backUpUrls = b.e(r10);
        this.showNotification = r10.f8117u;
        this.mimeType = r10.f8119w;
        this.needHttpsToHttpRetry = r10.f8120x;
        this.autoResumed = b.f(r10);
        this.showNotificationForAutoResumed = b.g(r10);
        this.needDefaultHttpServiceBackUp = r10.C;
        this.packageName = r10.D;
        this.md5 = r10.E;
        this.needIndependentProcess = r10.G;
        this.needCurrentProcess = r10.H;
        this.enqueueType = b.h(r10);
        this.ignoreDataVerify = b.i(r10);
        this.addListenerToSameTask = b.j(r10);
        this.iconUrl = r10.K;
        this.throttleNetSpeed = b.k(r10);
        this.throttleSmoothness = b.l(r10);
        this.openLimitSpeed = b.n(r10);
        this.title = r10.f8091b;
        JSONObject r13 = b.o(r10);
        if (r13 == null) goto L28;
        rb.a.a(getId(), r13);
        unsafePutToDBJsonData("download_setting", r13.toString());
    L28:
        unsafePutToDBJsonData("dbjson_key_expect_file_length", Long.valueOf(b.p(r10)));
        unsafePutToDBJsonData("executor_group", Integer.valueOf(b.q(r10)));
        unsafePutToDBJsonData("auto_install", Integer.valueOf(b.r(r10) ? 1 : 0));
        this.needSDKMonitor = b.s(r10);
        this.extraMonitorStatus = b.t(r10);
        this.expiredRedownload = b.u(r10);
        this.expiredHttpCheck = b.v(r10);
        this.deleteCacheIfCheckFailed = b.w(r10);
        this.ttnetProtectTimeout = b.y(r10);
        this.addTTNetCommonParam = b.z(r10);
        Boolean r14 = Boolean.valueOf(b.A(r10));
        this.ignoreInterceptor = r14;
        if (r14.booleanValue() == false) goto L31;
    L32:
        this.interceptFlag = 0;
    L33:
        this.accessHttpHeaderKeys = b.B(r10);
        this.pcdnUrls = r10.f8095d;
        this.cdnUrls = r10.f8097e;
        this.cacheLifeTimeMax = r10.f8121y;
        this.isDynamicThrottleEnable = r10.A;
        unsafePutToDBJsonData("ignore_intercept", Integer.valueOf(b.A(r10) ? 1 : 0));
        unsafePutToDBJsonData("start_offset", Long.valueOf(b.C(r10)));
        unsafePutToDBJsonData("end_offset", Long.valueOf(b.D(r10)));
        unsafePutToDBJsonData("need_sdk_monitor", Boolean.valueOf(this.needSDKMonitor));
        unsafePutToDBJsonData("monitor_scene", this.monitorScene);
        JSONArray r15 = new JSONArray();     // Catch: Throwable -> L43
        int[] r16 = this.extraMonitorStatus;     // Catch: Throwable -> L43
        if (r16 != null) goto L37;
    L41:
        unsafePutToDBJsonData("extra_monitor_status", r15);     // Catch: Throwable -> L43
        return;
    L37:
        if (r16.length <= 0) goto L41;
    L38:
        int[] r17 = this.extraMonitorStatus;     // Catch: Throwable -> L43
        if (r11 >= r17.length) goto L41;
        r15.put(r17[r11]);     // Catch: Throwable -> L43
        r11 = r11 + 1;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        if (((l) k.a(l.class)).h() != null) goto L33;
    L23:
        if (((t) k.a(t.class)).a(getId()) != null) goto L25;
        this.savePath = com.ss.android.socialbase.downloader.utils.g.m(this.savePath, this.url);
        this.tempPath = com.ss.android.socialbase.downloader.utils.g.m(this.tempPath, this.url);
        goto L25
    L46:
        r12 = com.ss.android.socialbase.downloader.utils.a.e();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    /* synthetic */ DownloadInfo(b r10, a r11) {
        this(r10);
    }

    private DownloadInfo(c r10) {
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
        this.id = r10.f8123i0;
        this.name = r10.f8089a;
        this.title = r10.f8091b;
        this.url = r10.f8093c;
        this.savePath = r10.f8099f;
        this.tempPath = r10.f8101g;
        this.chunkCount = r10.f8124j0;
        setStatus(r10.f8125k0);
        setCurBytes(r10.f8126l0);
        setBackCurBytes(r10.f8127m0);
        this.totalBytes = r10.f8128n0;
        this.eTag = r10.f8138x0;
        this.onlyWifi = r10.f8103h;
        this.force = r10.f8112p;
        this.retryCount = r10.f8110n;
        this.extra = r10.f8105i;
        this.mimeType = r10.f8119w;
        this.showNotification = r10.f8117u;
        this.notificationVisibility = r10.f8129o0;
        this.isFirstDownload = r10.f8130p0;
        this.isFirstSuccess = r10.f8131q0;
        this.needHttpsToHttpRetry = r10.f8120x;
        this.downloadTime = r10.f8132r0;
        this.packageName = r10.D;
        this.md5 = r10.E;
        this.curRetryTime = r10.f8134t0;
        this.needDefaultHttpServiceBackUp = r10.C;
        this.backUpUrlsStr = r10.f8135u0;
        this.backUpUrlRetryCount = r10.f8111o;
        this.realDownloadTime = r10.f8136v0;
        this.realBackDownloadTime = r10.f8133s0;
        this.needIndependentProcess = r10.G;
        this.needCurrentProcess = r10.H;
        this.dbJsonDataString = r10.f8137w0;
        this.iconUrl = r10.K;
        this.appVersionCode = r10.L;
        this.downloadStartTimeStamp = r10.f8139y0;
        this.downloadFinishTimeStamp = r10.f8140z0;
        this.installedTimeStamp = r10.A0;
        this.hasDoInstallation = r10.B0;
        this.pcdnUrlsStr = r10.C0;
        this.cdnUrlsStr = r10.D0;
        this.cacheLifeTimeMax = r10.f8121y;
        parseMonitorSetting();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    /* synthetic */ DownloadInfo(c r10, a r11) {
        this(r10);
    }

    private void convertEnqueueType(int r10) {
        EnqueueType r11 = EnqueueType.ENQUEUE_HEAD;
        if (r10 != r11.ordinal()) goto L5;
    L4:
        this.enqueueType = r11;
        return;
    L5:
        r11 = EnqueueType.ENQUEUE_TAIL;
        if (r10 == r11.ordinal()) goto L4;
        r11 = EnqueueType.NEW_ENQUEUE_NORMAL;
        if (r10 == r11.ordinal()) goto L4;
        r11 = EnqueueType.NEW_ENQUEUE_IMMEDIATE;
        if (r10 == r11.ordinal()) goto L4;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
    }

    private JSONObject convertStrToJson(String r10) {
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    L3:
        if (TextUtils.isEmpty(r10) == true) goto L12;
        return new JSONObject(r10);
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
        Context r10 = ((l) k.a(l.class)).getAppContext();
        if (r10 == null) goto L13;
        String r11 = r10.getSharedPreferences("sp_download_info", 0).getString(Long.toString(getId()), "");
        if (TextUtils.isEmpty(r11) == true) goto L13;
        this.spData = new JSONObject(r11);     // Catch: JSONException -> L10
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

    private void mergeAuxiliaryJSONObject(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ensureDBJsonData();
        JSONObject r11 = this.dbJsonData;
        monitor-enter(r11);
        Iterator<String> r12 = r10.keys();     // Catch: Throwable -> L15 Exception -> L24
    L8:
        if (r12.hasNext() == false) goto L18;
        String r13 = r12.next();     // Catch: Throwable -> L15 Exception -> L24
        Object r14 = r10.opt(r13);     // Catch: Throwable -> L15 Exception -> L24
        if (this.dbJsonData.has(r13) == true) goto L8;
        if (r14 == null) goto L8;
        this.dbJsonData.put(r13, r14);     // Catch: Throwable -> L15 Exception -> L24
    L15:
        th = move-exception;
        throw th;
    L18:
        this.dbJsonDataString = null;     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        parseMonitorSetting();
    }

    private void parseMonitorSetting() {
        unsafeEnsureDBJsonData();
        int r10 = 0;
        this.needSDKMonitor = this.dbJsonData.optBoolean("need_sdk_monitor", false);
        this.monitorScene = this.dbJsonData.optString("monitor_scene", "");
        JSONArray r11 = this.dbJsonData.optJSONArray("extra_monitor_status");
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length() <= 0) goto L12;
        this.extraMonitorStatus = new int[r11.length()];
    L8:
        if (r10 >= r11.length()) goto L13;
        this.extraMonitorStatus[r10] = r11.optInt(r10);
        r10 = r10 + 1;
        goto L8
    L13:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    private void refreshBackupUrls(boolean r10) {
        List<String> r11 = this.forbiddenBackupUrls;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.size() <= r10) goto L16;
        List<String> r12 = this.backUpUrls;
        if (r12 != null) goto L9;
        this.backUpUrls = new ArrayList();
    L10:
        this.backUpUrlUsed = false;
        this.curBackUpUrlIndex = 0;
        ?? r13 = r10;
    L12:
        if (r13 >= this.forbiddenBackupUrls.size()) goto L17;
        this.backUpUrls.add(this.forbiddenBackupUrls.get(r13));
        r13 = r13 + 1;
        goto L12
    L17:
        return;
    L9:
        r12.clear();
        goto L10
    }

    private void setBackCurBytes(long r10) {
        AtomicLong r11 = this.backCurBytes;
        if (r11 == null) goto L5;
        r11.set(r10);
        return;
    L5:
        this.backCurBytes = new AtomicLong(r10);
    }

    private void setBackUpUrlsStr(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (getStatus() == (-3)) goto L10;
        this.backUpUrlsStr = r10;
        this.backUpUrls = com.ss.android.socialbase.downloader.utils.g.U(r10);
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
        JSONObject r10 = new JSONObject(this.dbJsonDataString);     // Catch: Throwable -> L11
    L8:
        this.dbJsonData = r10;     // Catch: Throwable -> L11
        goto L12
    L9:
        r10 = new JSONObject();     // Catch: Throwable -> L11
        goto L8
    }

    private void unsafePutToDBJsonData(String r10, Object r11) {
        this.dbJsonData.put(r10, r11);     // Catch: Exception -> L4
        return;
    }

    public void bindValue(SQLiteStatement r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.bindValueCount = 0;
        r10.clearBindings();
        int r11 = this.bindValueCount + 1;
        this.bindValueCount = r11;
        r10.bindLong(r11, this.id);
        int r12 = this.bindValueCount + 1;
        this.bindValueCount = r12;
        String r13 = this.url;
        if (r13 != null) goto L7;
        r13 = "";
    L7:
        r10.bindString(r12, r13);
        int r14 = this.bindValueCount + 1;
        this.bindValueCount = r14;
        String r15 = this.savePath;
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        r10.bindString(r14, r15);
        int r16 = this.bindValueCount + 1;
        this.bindValueCount = r16;
        String r17 = this.tempPath;
        if (r17 != null) goto L13;
        r17 = "";
    L13:
        r10.bindString(r16, r17);
        int r18 = this.bindValueCount + 1;
        this.bindValueCount = r18;
        String r19 = this.name;
        if (r19 != null) goto L16;
        r19 = "";
    L16:
        r10.bindString(r18, r19);
        int r20 = this.bindValueCount + 1;
        this.bindValueCount = r20;
        r10.bindLong(r20, this.chunkCount);
        int r21 = this.bindValueCount + 1;
        this.bindValueCount = r21;
        r10.bindLong(r21, getStatus());
        int r22 = this.bindValueCount + 1;
        this.bindValueCount = r22;
        r10.bindLong(r22, getCurBytes());
        int r23 = this.bindValueCount + 1;
        this.bindValueCount = r23;
        r10.bindLong(r23, this.totalBytes);
        int r24 = this.bindValueCount + 1;
        this.bindValueCount = r24;
        String r25 = this.eTag;
        if (r25 != null) goto L19;
        r25 = "";
    L19:
        r10.bindString(r24, r25);
        int r26 = this.bindValueCount + 1;
        this.bindValueCount = r26;
        long r27 = 1;
        if (this.onlyWifi == false) goto L22;
        long r28 = 1;
    L23:
        r10.bindLong(r26, r28);
        int r29 = this.bindValueCount + 1;
        this.bindValueCount = r29;
        if (this.force == false) goto L26;
        long r30 = 1;
    L27:
        r10.bindLong(r29, r30);
        int r31 = this.bindValueCount + 1;
        this.bindValueCount = r31;
        r10.bindLong(r31, this.retryCount);
        int r32 = this.bindValueCount + 1;
        this.bindValueCount = r32;
        String r33 = this.extra;
        if (r33 != null) goto L30;
        r33 = "";
    L30:
        r10.bindString(r32, r33);
        int r34 = this.bindValueCount + 1;
        this.bindValueCount = r34;
        String r35 = this.mimeType;
        if (r35 != null) goto L33;
        r35 = "";
    L33:
        r10.bindString(r34, r35);
        int r36 = this.bindValueCount + 1;
        this.bindValueCount = r36;
        String r37 = this.title;
        if (r37 != null) goto L36;
        r37 = "";
    L36:
        r10.bindString(r36, r37);
        int r38 = this.bindValueCount + 1;
        this.bindValueCount = r38;
        if (this.showNotification == false) goto L39;
        long r39 = 1;
    L40:
        r10.bindLong(r38, r39);
        int r40 = this.bindValueCount + 1;
        this.bindValueCount = r40;
        r10.bindLong(r40, this.notificationVisibility);
        int r41 = this.bindValueCount + 1;
        this.bindValueCount = r41;
        if (this.isFirstDownload == false) goto L43;
        long r42 = 1;
    L44:
        r10.bindLong(r41, r42);
        int r43 = this.bindValueCount + 1;
        this.bindValueCount = r43;
        if (this.isFirstSuccess == false) goto L47;
        long r44 = 1;
    L48:
        r10.bindLong(r43, r44);
        int r45 = this.bindValueCount + 1;
        this.bindValueCount = r45;
        if (this.needHttpsToHttpRetry == false) goto L51;
        long r46 = 1;
    L52:
        r10.bindLong(r45, r46);
        int r47 = this.bindValueCount + 1;
        this.bindValueCount = r47;
        r10.bindLong(r47, this.downloadTime);
        int r48 = this.bindValueCount + 1;
        this.bindValueCount = r48;
        String r49 = this.packageName;
        if (r49 != null) goto L55;
        r49 = "";
    L55:
        r10.bindString(r48, r49);
        int r50 = this.bindValueCount + 1;
        this.bindValueCount = r50;
        String r51 = this.md5;
        if (r51 != null) goto L58;
        r51 = "";
    L58:
        r10.bindString(r50, r51);
        int r52 = this.bindValueCount + 1;
        this.bindValueCount = r52;
        r10.bindLong(r52, 0);
        int r53 = this.bindValueCount + 1;
        this.bindValueCount = r53;
        r10.bindLong(r53, this.curRetryTime);
        int r54 = this.bindValueCount + 1;
        this.bindValueCount = r54;
        r10.bindLong(r54, 0);
        int r55 = this.bindValueCount + 1;
        this.bindValueCount = r55;
        if (this.needDefaultHttpServiceBackUp == false) goto L61;
        long r56 = 1;
    L62:
        r10.bindLong(r55, r56);
        int r57 = this.bindValueCount + 1;
        this.bindValueCount = r57;
        r10.bindLong(r57, 0);
        int r58 = this.bindValueCount + 1;
        this.bindValueCount = r58;
        r10.bindString(r58, "");
        int r59 = this.bindValueCount + 1;
        this.bindValueCount = r59;
        r10.bindLong(r59, 0);
        int r60 = this.bindValueCount + 1;
        this.bindValueCount = r60;
        r10.bindString(r60, getBackUpUrlsStr());
        int r61 = this.bindValueCount + 1;
        this.bindValueCount = r61;
        r10.bindLong(r61, this.backUpUrlRetryCount);
        int r62 = this.bindValueCount + 1;
        this.bindValueCount = r62;
        r10.bindLong(r62, this.realDownloadTime);
        int r63 = this.bindValueCount + 1;
        this.bindValueCount = r63;
        r10.bindLong(r63, 0);
        int r64 = this.bindValueCount + 1;
        this.bindValueCount = r64;
        if (this.needIndependentProcess == false) goto L65;
        long r65 = 1;
    L66:
        r10.bindLong(r64, r65);
        int r66 = this.bindValueCount + 1;
        this.bindValueCount = r66;
        r10.bindString(r66, getDBJsonDataString());
        int r67 = this.bindValueCount + 1;
        this.bindValueCount = r67;
        String r68 = this.iconUrl;
        if (r68 != null) goto L69;
        r68 = "";
    L69:
        r10.bindString(r67, r68);
        int r69 = this.bindValueCount + 1;
        this.bindValueCount = r69;
        r10.bindLong(r69, this.appVersionCode);
        int r70 = this.bindValueCount + 1;
        this.bindValueCount = r70;
        r10.bindString(r70, "");
        int r71 = this.bindValueCount + 1;
        this.bindValueCount = r71;
        r10.bindLong(r71, this.downloadStartTimeStamp);
        int r72 = this.bindValueCount + 1;
        this.bindValueCount = r72;
        r10.bindLong(r72, this.downloadFinishTimeStamp);
        int r73 = this.bindValueCount + 1;
        this.bindValueCount = r73;
        r10.bindLong(r73, this.installedTimeStamp);
        int r74 = this.bindValueCount + 1;
        this.bindValueCount = r74;
        if (this.hasDoInstallation == true) goto L73;
        r27 = 0;
    L73:
        r10.bindLong(r74, r27);
        int r75 = this.bindValueCount + 1;
        this.bindValueCount = r75;
        r10.bindLong(r75, this.cacheLifeTimeMax);
        int r76 = this.bindValueCount + 1;
        this.bindValueCount = r76;
        r10.bindString(r76, getPcdnUrlsStr());
        int r77 = this.bindValueCount + 1;
        this.bindValueCount = r77;
        r10.bindString(r77, getCdnUrlsStr());
        int r78 = this.bindValueCount + 1;
        this.bindValueCount = r78;
        r10.bindLong(r78, getBackCurBytes());
        int r79 = this.bindValueCount + 1;
        this.bindValueCount = r79;
        r10.bindLong(r79, this.realBackDownloadTime);
        return;
    L65:
        r65 = 0;
        goto L66
    L61:
        r56 = 0;
        goto L62
    L51:
        r46 = 0;
        goto L52
    L47:
        r44 = 0;
        goto L48
    L43:
        r42 = 0;
        goto L44
    L39:
        r39 = 0;
        goto L40
    L26:
        r30 = 0;
        goto L27
    L22:
        r28 = 0;
        goto L23
    }

    public boolean cacheExpierd() {
        if (isDownloaded() == true) goto L7;
        return true;
    L7:
        return com.ss.android.socialbase.downloader.utils.g.a(this);
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
        if (this.url.startsWith("https") == false) goto L11;
        if (this.needHttpsToHttpRetry == false) goto L11;
        if (this.httpsToHttpRetryUsed == true) goto L11;
        return true;
    }

    public boolean canShowNotification() {
        boolean r10 = this.autoResumed;
        if (r10 == false) goto L5;
    L6:
        if (r10 == true) goto L8;
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
        if (getStatus() == 8) goto L12;
        AsyncHandleStatus r10 = this.asyncHandleStatus;
        if (r10 == AsyncHandleStatus.ASYNC_HANDLE_WAITING) goto L12;
        if (r10 == AsyncHandleStatus.ASYNC_HANDLE_RESTART) goto L12;
        if (this.byteInvalidRetryStatus == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART) goto L12;
        return false;
    L12:
        return true;
    }

    public void changeSkipStatus() {
        if (getStatus() == 8) goto L8;
        AsyncHandleStatus r10 = this.asyncHandleStatus;
        if (r10 == AsyncHandleStatus.ASYNC_HANDLE_WAITING) goto L8;
        if (r10 == AsyncHandleStatus.ASYNC_HANDLE_RESTART) goto L8;
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

    public int checkMd5Status() {
        return com.ss.android.socialbase.downloader.utils.g.d(new kb.a(getSavePath(), getName()), this.md5);
    }

    public boolean checkMd5Valid() {
        return com.ss.android.socialbase.downloader.utils.g.e(getSavePath(), getName(), this.md5);
    }

    public void copyFromCacheData(DownloadInfo r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        setChunkCount(r10.getChunkCount());
        setTotalBytes(r10.getTotalBytes());
        setCurBytes(r10.getCurBytes(), true);
        setBackCurBytes(r10.getBackCurBytes());
        this.realDownloadTime = r10.realDownloadTime;
        this.realBackDownloadTime = r10.realBackDownloadTime;
        if (r10.canSkipStatusHandler() == false) goto L7;
    L9:
        this.curRetryTime = r10.getCurRetryTime();
    L10:
        seteTag(r10.geteTag());
        setMimeType(r10.getMimeType());
        if (r11 == false) goto L13;
        setStatus(r10.getStatus());
    L13:
        this.isFirstDownload = r10.getIsFirstDownload();
        this.isFirstSuccess = r10.isFirstSuccess();
        this.downloadStartTimeStamp = r10.getDownloadStartTimeStamp();
        this.downloadFinishTimeStamp = r10.getDownloadFinishTimeStamp();
        this.installedTimeStamp = r10.getInstalledTimeStamp();
        this.hasDoInstallation = r10.hasDoInstallation;
        mergeAuxiliaryJSONObject(r10.dbJsonData);
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

    public boolean equalsTask(DownloadInfo r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        String r11 = this.url;
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r11.equals(r10.getUrl()) == false) goto L16;
        String r12 = this.savePath;
        if (r12 != null) goto L12;
        return false;
    L12:
        if (r12.equals(r10.getSavePath()) == false) goto L18;
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

    public int getAntiHijackErrorCode(int r10) {
        ensureDBJsonData();
        return this.dbJsonData.optInt("anti_hijack_error_code", r10);
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public AsyncHandleStatus getAsyncHandleStatus() {
        return this.asyncHandleStatus;
    }

    public long getBackCurBytes() {
        AtomicLong r10 = this.backCurBytes;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.get();
    }

    public String getBackUpUrl() {
        if (this.backUpUrlUsed == false) goto L15;
        List<String> r10 = this.backUpUrls;
        if (r10 == null) goto L15;
        if (r10.size() <= 0) goto L15;
        int r11 = this.curBackUpUrlIndex;
        if (r11 < 0) goto L15;
        if (r11 >= this.backUpUrls.size()) goto L15;
        String r12 = this.backUpUrls.get(this.curBackUpUrlIndex);
        if (TextUtils.isEmpty(r12) == true) goto L15;
        return r12;
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
        this.backUpUrlsStr = com.ss.android.socialbase.downloader.utils.g.V(this.backUpUrls);
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
        this.cdnUrlsStr = com.ss.android.socialbase.downloader.utils.g.V(this.cdnUrls);
    L6:
        return this.cdnUrlsStr;
    }

    @Deprecated
    public int getChunkCount() {
        return this.chunkCount;
    }

    public String getConnectionUrl() {
        String r10 = this.url;
        if (getStatus() != 8) goto L12;
        List<String> r11 = this.forbiddenBackupUrls;
        if (r11 == null) goto L12;
        if (r11.isEmpty() == true) goto L12;
        if (this.backUpUrlUsed == true) goto L12;
        return this.forbiddenBackupUrls.get(0);
    L12:
        if (this.backUpUrlUsed == false) goto L25;
        List<String> r12 = this.backUpUrls;
        if (r12 == null) goto L25;
        if (r12.size() <= 0) goto L25;
        int r13 = this.curBackUpUrlIndex;
        if (r13 < 0) goto L25;
        if (r13 >= this.backUpUrls.size()) goto L25;
        String r14 = this.backUpUrls.get(this.curBackUpUrlIndex);
        if (TextUtils.isEmpty(r14) == false) goto L36;
        return r10;
    L36:
        return r14;
    L25:
        if (TextUtils.isEmpty(this.url) == false) goto L27;
        return r10;
    L27:
        if (this.url.startsWith("https") == true) goto L29;
        return r10;
    L29:
        if (this.needHttpsToHttpRetry == true) goto L31;
        return r10;
    L31:
        if (this.httpsToHttpRetryUsed == true) goto L33;
        return r10;
    L33:
        return this.url.replaceFirst("https", "http");
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public int getCurBackUpUrlIndex() {
        return this.curBackUpUrlIndex;
    }

    public long getCurBytes() {
        AtomicLong r10 = this.curBytes;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.get();
    }

    public int getCurNetworkRetryCount() {
        return this.curNetworkRetryCount;
    }

    public int getCurRetryTime() {
        return this.curRetryTime;
    }

    public int getCurRetryTimeInTotal() {
        int r10 = this.curRetryTime;
        if (this.backUpUrlUsed == false) goto L8;
        int r11 = r10 + this.retryCount;
        int r12 = this.curBackUpUrlIndex;
        if (r12 > 0) goto L7;
        return r11;
    L7:
        return r11 + (r12 * this.backUpUrlRetryCount);
    L8:
        return r10;
    }

    public String getDBJsonDataString() {
        String r10 = this.dbJsonDataString;
        if (r10 == null) goto L5;
        return r10;
    L5:
        ensureDBJsonData();
        JSONObject r11 = this.dbJsonData;
        monitor-enter(r11);
        String r12 = this.dbJsonData.toString();     // Catch: Throwable -> L10
        this.dbJsonDataString = r12;     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r12;
    L10:
        th = move-exception;
        throw th;
    }

    public int getDBJsonInt(String r10) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(r10);
    }

    public String getDBJsonString(String r10) {
        ensureDBJsonData();
        return this.dbJsonData.optString(r10);
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
        double r10 = getCurBytes() / 1048576.0d;
        double r11 = getRealDownloadTime() / 1000.0d;
        if (r10 > 0.0d) goto L5;
    L7:
        return -1.0d;
    L5:
        if (r11 <= 0.0d) goto L7;
        return r10 / r11;
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
        this.id = ((n) k.a(n.class)).c(this);
    L6:
        return this.id;
    }

    public long getInstalledTimeStamp() {
        return this.installedTimeStamp;
    }

    public int getInterceptFlag() {
        return this.interceptFlag;
    }

    public boolean getIsDynamicThrottleEnable() {
        return this.isDynamicThrottleEnable;
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

    public long getMinByteIntervalForPostToMainThread(long r10) {
        int r11 = this.maxProgressCount;
        if (r11 > 0) goto L5;
        r11 = 100;
    L5:
        long r12 = r10 / ((long) (r11 + 1));
        if (r12 > 0) goto L9;
        return 1048576;
    L9:
        return r12;
    }

    public int getMinProgressTimeMsInterval() {
        int r10 = this.minProgressTimeMsInterval;
        if (r10 < 1000) goto L5;
        return r10;
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
        SoftReference<PackageInfo> r10 = this.packageInfoRef;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.get();
    }

    public PackageInfo getPackageInfoWithCache() {
        ensureDBJsonData();
        String r10 = this.dbJsonData.optString("app_package_info");
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return null;
    L10:
        String[] r11 = r10.split(",");     // Catch: Throwable -> L7
        PackageInfo r12 = new PackageInfo();     // Catch: Throwable -> L7
        r12.packageName = r11[0];     // Catch: Throwable -> L7
        r12.versionName = r11[1];     // Catch: Throwable -> L7
        r12.versionCode = Integer.parseInt(r11[2]);     // Catch: Throwable -> L7
        return r12;
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
        this.pcdnUrlsStr = com.ss.android.socialbase.downloader.utils.g.V(this.pcdnUrls);
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
        AtomicInteger r10 = this.status;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.get();
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

    public int getSpIntVal(String r10) {
        ensureSpData();
        return this.spData.optInt(r10, 0);
    }

    public long getSpLongVal(String r10) {
        ensureSpData();
        return this.spData.optLong(r10, 0);
    }

    public String getSpStringVal(String r10) {
        ensureSpData();
        return this.spData.optString(r10, null);
    }

    public long getStartOffset() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("start_offset");
    }

    public int getStatus() {
        AtomicInteger r10 = this.status;
        if (r10 == null) goto L8;
        int r11 = r10.get();
        if (r11 != (-5)) goto L10;
        return -2;
    L10:
        return r11;
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
        return com.ss.android.socialbase.downloader.utils.g.C(this.savePath, this.name);
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
        return com.ss.android.socialbase.downloader.utils.g.E(this.savePath, this.tempPath, this.name);
    }

    public String getTempName() {
        return com.ss.android.socialbase.downloader.utils.g.D(this.name);
    }

    public String getTempPath() {
        return com.ss.android.socialbase.downloader.utils.g.F(this.savePath, this.tempPath);
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
        int r10 = this.retryCount;
        List<String> r11 = this.backUpUrls;
        if (r11 != null) goto L5;
        return r10;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return r10;
    L7:
        return r10 + (this.backUpUrlRetryCount * this.backUpUrls.size());
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
        List<String> r10 = this.backUpUrls;
        if (r10 != null) goto L5;
    L13:
        return false;
    L5:
        if (r10.size() <= 0) goto L13;
        if (this.backUpUrlUsed == false) goto L15;
        int r11 = this.curBackUpUrlIndex;
        if (r11 < 0) goto L13;
        if (r11 >= (this.backUpUrls.size() - 1)) goto L13;
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

    public void increaseAllConnectTime(long r10) {
        if (r10 <= 0) goto L6;
        getAllConnectTime();
        safePutToDBJsonData("dbjson_key_all_connect_time", Long.valueOf(this.allConnectTime.addAndGet(r10)));
        return;
    }

    public void increaseCurBytes(long r10) {
        this.curBytes.addAndGet(r10);
        if (this.fastDownload == false) goto L5;
        return;
    L5:
        if (za.a.k().n() == false) goto L9;
        this.backCurBytes.addAndGet(r10);
        return;
    }

    public void increaseDownloadPrepareTime(long r10) {
        if (this.fastDownload == false) goto L5;
        return;
    L5:
        long r11 = System.currentTimeMillis() - r10;
        if (r11 <= 0) goto L9;
        safePutToDBJsonData("dbjson_key_download_prepare_time", Long.valueOf(getDownloadPrepareTime() + r11));
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
        this.isAutoInstallWithoutNotification = Boolean.FALSE;
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
        int r10 = getStatus();
        if (r10 != 4) goto L5;
        return true;
    L5:
        if (r10 != 3) goto L7;
        return true;
    L7:
        if (r10 != (-1)) goto L9;
        return true;
    L9:
        if (r10 != 5) goto L11;
        return true;
    L11:
        if (r10 == 8) goto L24;
        if (r10 == 1) goto L16;
        if (r10 == 2) goto L16;
    L18:
        return false;
    L16:
        if (getCurBytes() <= 0) goto L18;
        return true;
    L24:
        return true;
    }

    public boolean isChunked() {
        return com.ss.android.socialbase.downloader.utils.g.I(this.totalBytes);
    }

    public boolean isDeleteCacheIfCheckFailed() {
        return this.deleteCacheIfCheckFailed;
    }

    public boolean isDownloadFromReserveWifi() {
        return this.mDownloadFromReserveWifi;
    }

    public boolean isDownloadOverStatus() {
        return ab.d.a(getStatus());
    }

    public boolean isDownloadWithWifiValid() {
        if (isOnlyWifi() == true) goto L5;
    L8:
        return true;
    L5:
        if (com.ss.android.socialbase.downloader.utils.g.T(((l) k.a(l.class)).getAppContext()) == true) goto L8;
        return false;
    }

    public boolean isDownloaded() {
        return com.ss.android.socialbase.downloader.utils.g.K(this);
    }

    public boolean isDownloadingStatus() {
        return ab.d.b(getStatus());
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
        File r10 = new File(getTempPath(), getTempName());
        boolean r11 = r10.exists();
        boolean r12 = r10.isDirectory();
        if (r11 == false) goto L11;
        if (r12 == true) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean isFileDataValid() {
        if (isEntityInvalid() == false) goto L5;
        return false;
    L5:
        File r10 = new File(getTempPath(), getTempName());
        boolean r11 = r10.exists();
        boolean r12 = r10.isDirectory();
        if (lb.a.a() == false) goto L8;
        lb.a.g(TAG, this.id, "isFileDataValid", "Temp file:" + r10 + "IsExists:" + r11 + " isDirectory: " + r12);
    L8:
        if (r11 == false) goto L30;
        if (r12 == true) goto L30;
        long r13 = r10.length();
        long r14 = getCurBytes();
        if (r14 <= 0) goto L28;
        long r15 = this.totalBytes;
        if (r15 <= 0) goto L28;
        if (this.chunkCount <= 0) goto L28;
        if (r13 < r14) goto L28;
        if (r13 > r15) goto L28;
        if (lb.a.a() == false) goto L31;
        lb.a.g(TAG, this.id, "isFileDataValid", "Valid, FileLength+" + r13 + " curBytes:" + r14);
        return true;
    L31:
        return true;
    L28:
        if (lb.a.a() == false) goto L30;
        lb.a.g(TAG, this.id, "isFileDataValid", "Invalid, Cur = " + r14 + ",totalBytes =" + this.totalBytes + ",fileLength=" + r13 + ", chunkCount:" + this.chunkCount);
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
        boolean r10 = false;
        if (this.dbJsonData.optInt("ignore_intercept", 0) != 1) goto L7;
        r10 = true;
    L7:
        this.ignoreInterceptor = Boolean.valueOf(r10);
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
        if (com.ss.android.socialbase.downloader.utils.g.T(((l) k.a(l.class)).getAppContext()) == false) goto L9;
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
        BaseException r10 = this.failedException;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getErrorCode() != 1013) goto L7;
        return true;
    }

    public void readFromParcel(Parcel r10) {
        this.id = r10.readInt();
        this.name = r10.readString();
        this.title = r10.readString();
        this.url = r10.readString();
        this.savePath = r10.readString();
        this.tempPath = r10.readString();
        boolean r11 = true;
        if (r10.readByte() == 0) goto L5;
        boolean r12 = true;
    L6:
        this.onlyWifi = r12;
        this.extra = r10.readString();
        this.extraHeaders = r10.createTypedArrayList(HttpHeader.CREATOR);
        this.maxBytes = r10.readInt();
        this.outIp = r10.createStringArray();
        this.outSize = r10.createIntArray();
        this.retryCount = r10.readInt();
        this.backUpUrlRetryCount = r10.readInt();
        if (r10.readByte() == 0) goto L9;
        boolean r13 = true;
    L10:
        this.force = r13;
        if (r10.readByte() == 0) goto L13;
        boolean r14 = true;
    L14:
        this.needPostProgress = r14;
        this.maxProgressCount = r10.readInt();
        this.minProgressTimeMsInterval = r10.readInt();
        this.backUpUrls = r10.createStringArrayList();
        if (r10.readByte() == 0) goto L17;
        boolean r15 = true;
    L18:
        this.showNotification = r15;
        this.mimeType = r10.readString();
        if (r10.readByte() == 0) goto L21;
        boolean r16 = true;
    L22:
        this.needHttpsToHttpRetry = r16;
        this.packageName = r10.readString();
        this.md5 = r10.readString();
        if (r10.readByte() == 0) goto L25;
        boolean r17 = true;
    L26:
        this.needDefaultHttpServiceBackUp = r17;
        this.eTag = r10.readString();
        this.curRetryTime = r10.readInt();
        this.networkQuality = r10.readString();
        this.curBackUpUrlIndex = r10.readInt();
        this.notificationVisibility = r10.readInt();
        this.chunkCount = r10.readInt();
        setCurBytes(r10.readLong());
        setBackCurBytes(r10.readLong());
        this.totalBytes = r10.readLong();
        setStatus(r10.readInt());
        this.downloadTime = r10.readLong();
        this.realDownloadTime = r10.readLong();
        this.realBackDownloadTime = r10.readLong();
        if (r10.readByte() == 0) goto L29;
        boolean r18 = true;
    L30:
        this.backUpUrlUsed = r18;
        if (r10.readByte() == 0) goto L33;
        boolean r19 = true;
    L34:
        this.httpsToHttpRetryUsed = r19;
        if (r10.readByte() == 0) goto L37;
        boolean r20 = true;
    L38:
        this.autoResumed = r20;
        if (r10.readByte() == 0) goto L41;
        boolean r21 = true;
    L42:
        this.showNotificationForAutoResumed = r21;
        if (r10.readByte() == 0) goto L45;
        boolean r22 = true;
    L46:
        this.showNotificationForNetworkResumed = r22;
        this.forbiddenBackupUrls = r10.createStringArrayList();
        if (r10.readByte() == 0) goto L49;
        boolean r23 = true;
    L50:
        this.needIndependentProcess = r23;
        convertEnqueueType(r10.readInt());
        this.httpStatusCode = r10.readInt();
        this.httpStatusMessage = r10.readString();
        if (r10.readByte() == 0) goto L53;
        boolean r24 = true;
    L54:
        this.isForbiddenRetryed = r24;
        if (r10.readByte() == 0) goto L57;
        boolean r25 = true;
    L58:
        this.addListenerToSameTask = r25;
        this.failedException = (BaseException) r10.readParcelable(BaseException.class.getClassLoader());
        this.dbJsonDataString = r10.readString();
        if (r10.readByte() == 0) goto L61;
        boolean r26 = true;
    L62:
        this.supportPartial = r26;
        this.iconUrl = r10.readString();
        this.appVersionCode = r10.readInt();
        if (r10.readByte() == 0) goto L65;
        boolean r27 = true;
    L66:
        this.expiredRedownload = r27;
        if (r10.readByte() == 0) goto L69;
        boolean r28 = true;
    L70:
        this.deleteCacheIfCheckFailed = r28;
        if (r10.readByte() == 0) goto L73;
        boolean r29 = true;
    L74:
        this.successByCache = r29;
        if (r10.readByte() == 0) goto L77;
        boolean r30 = true;
    L78:
        this.expiredHttpCheck = r30;
        this.xTotalBytes = r10.readLong();
        this.interceptFlag = r10.readInt();
        this.accessHttpHeaderKeys = r10.createStringArrayList();
        this.httpHeaders = r10.readHashMap(getClass().getClassLoader());
        this.downloadStartTimeStamp = r10.readLong();
        this.downloadFinishTimeStamp = r10.readLong();
        this.installedTimeStamp = r10.readLong();
        if (r10.readByte() == 0) goto L81;
        boolean r31 = true;
    L82:
        this.hasDoInstallation = r31;
        if (r10.readByte() == 0) goto L85;
        boolean r32 = true;
    L86:
        this.isCacheExistsInDownloading = r32;
        this.cacheLifeTimeMax = r10.readLong();
        this.pcdnUrls = r10.createStringArrayList();
        this.cdnUrls = r10.createStringArrayList();
        this.contentEncoding = r10.readString();
        if (r10.readByte() == 0) goto L89;
        boolean r33 = true;
    L90:
        this.fastDownload = r33;
        if (r10.readByte() == 0) goto L93;
        boolean r34 = true;
    L94:
        this.handleRequest = r34;
        this.md5Time = r10.readLong();
        this.httpRequestHeader = r10.readString();
        this.httpResponseHeader = r10.readString();
        this.requestLog = r10.readString();
        this.verifyCurBytes = r10.readLong();
        if (r10.readByte() != 0) goto L98;
        r11 = false;
    L98:
        this.needCurrentProcess = r11;
        parseMonitorSetting();
        return;
    L93:
        r34 = false;
        goto L94
    L89:
        r33 = false;
        goto L90
    L85:
        r32 = false;
        goto L86
    L81:
        r31 = false;
        goto L82
    L77:
        r30 = false;
        goto L78
    L73:
        r29 = false;
        goto L74
    L69:
        r28 = false;
        goto L70
    L65:
        r27 = false;
        goto L66
    L61:
        r26 = false;
        goto L62
    L57:
        r25 = false;
        goto L58
    L53:
        r24 = false;
        goto L54
    L49:
        r23 = false;
        goto L50
    L45:
        r22 = false;
        goto L46
    L41:
        r21 = false;
        goto L42
    L37:
        r20 = false;
        goto L38
    L33:
        r19 = false;
        goto L34
    L29:
        r18 = false;
        goto L30
    L25:
        r17 = false;
        goto L26
    L21:
        r16 = false;
        goto L22
    L17:
        r15 = false;
        goto L18
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
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

    public void resetDataForEtagEndure(String r10) {
        setCurBytes(0, true);
        setBackCurBytes(0);
        setTotalBytes(0);
        seteTag(r10);
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

    public void safePutToDBJsonData(String r10, Object r11) {
        ensureDBJsonData();
        JSONObject r12 = this.dbJsonData;
        monitor-enter(r12);
        this.dbJsonData.put(r10, r11);     // Catch: Throwable -> L6 Exception -> L14
    L6:
        th = move-exception;
        throw th;
    L9:
        this.dbJsonDataString = null;     // Catch: Throwable -> L6
        monitor-exit(r12);     // Catch: Throwable -> L6
    }

    public void setAddListenerToSameTask(boolean r10) {
        this.addListenerToSameTask = r10;
    }

    public void setAntiHijackErrorCode(int r10) {
        safePutToDBJsonData("anti_hijack_error_code", Integer.valueOf(r10));
    }

    public void setAppVersionCode(int r10) {
        this.appVersionCode = r10;
    }

    public void setAsyncHandleStatus(AsyncHandleStatus r10) {
        this.asyncHandleStatus = r10;
    }

    public void setAutoResumed(boolean r10) {
        this.autoResumed = r10;
    }

    public void setByteInvalidRetryStatus(ByteInvalidRetryStatus r10) {
        this.byteInvalidRetryStatus = r10;
    }

    public void setCacheExistsInDownloading(boolean r10) {
        this.isCacheExistsInDownloading = r10;
    }

    public void setCacheExpiredTime(long r10) {
        ensureSpData();
        this.spData.put("cache-control/expired_time", r10);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    }

    public void setChunkCount(int r10) {
        this.chunkCount = r10;
    }

    public void setContentEncoding(String r10) {
        this.contentEncoding = r10;
    }

    public void setCurBytes(long r10) {
        AtomicLong r11 = this.curBytes;
        if (r11 == null) goto L5;
        r11.set(r10);
        return;
    L5:
        this.curBytes = new AtomicLong(r10);
    }

    public void setCurBytes(long r10, boolean r11) {
        if (r11 == false) goto L5;
    L3:
        setCurBytes(r10);
        return;
    L5:
        if (r10 > getCurBytes()) goto L3;
    }

    public void setCurNetworkRetryCount(int r10) {
        this.curNetworkRetryCount = r10;
    }

    public void setDeleteCacheIfCheckFailed() {
        this.deleteCacheIfCheckFailed = true;
    }

    public void setDownloadFinishTimeStamp(long r10) {
        this.downloadFinishTimeStamp = r10;
    }

    public void setDownloadFromReserveWifi(boolean r10) {
        this.mDownloadFromReserveWifi = r10;
    }

    public void setDownloadStartTimeStamp(long r10) {
        this.downloadStartTimeStamp = r10;
    }

    public void setDynamicThrottleEnable(boolean r10) {
        this.isDynamicThrottleEnable = r10;
    }

    public void setExtra(String r10) {
        this.extra = r10;
    }

    public void setFailedException(BaseException r10) {
        this.failedException = r10;
    }

    public void setFailedResumeCount(int r10) {
        ensureSpData();
        this.spData.put("failed_resume_count", r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setFilePackageName(String r10) {
        this.filePackageName = r10;
    }

    public void setFirstDownload(boolean r10) {
        this.isFirstDownload = r10;
    }

    public void setFirstSpeedTime(long r10) {
        safePutToDBJsonData("dbjson_key_first_speed_time", Long.valueOf(r10));
    }

    public void setFirstSuccess(boolean r10) {
        this.isFirstSuccess = r10;
    }

    public void setForbiddenBackupUrls(List<String> r10, boolean r11) {
        this.forbiddenBackupUrls = r10;
        refreshBackupUrls(r11);
    }

    public void setForbiddenRetryed() {
        this.isForbiddenRetryed = true;
    }

    public void setHasDoInstallation(boolean r10) {
        this.hasDoInstallation = r10;
    }

    public void setHttpHeaders(Map<String, String> r10) {
        this.httpHeaders = r10;
    }

    public void setHttpRequestHeader(String r10) {
        this.httpRequestHeader = r10;
    }

    public void setHttpResponseHeader(String r10) {
        this.httpResponseHeader = r10;
    }

    public void setHttpStatusCode(int r10) {
        this.httpStatusCode = r10;
    }

    public void setHttpStatusMessage(String r10) {
        this.httpStatusMessage = r10;
    }

    public void setHttpsToHttpRetryUsed(boolean r10) {
        this.httpsToHttpRetryUsed = r10;
    }

    public void setIconUrl(String r10) {
        this.iconUrl = r10;
    }

    public void setId(int r10) {
        this.id = r10;
    }

    public void setIgnoreDataVerify(boolean r10) {
        this.ignoreDataVerify = r10;
    }

    public void setInstalledTimeStamp(long r10) {
        this.installedTimeStamp = r10;
    }

    public void setInterceptFlag(int r10) {
        this.interceptFlag = r10;
    }

    public void setLastFailedResumeTime(long r10) {
        ensureSpData();
        this.spData.put("last_failed_resume_time", r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setLastModified(String r10) {
        ensureSpData();
        this.spData.put("last-modified", r10);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    }

    public void setLastNotifyProgressTime() {
        this.lastNotifyProgressTime = SystemClock.uptimeMillis();
    }

    public void setLastUninstallResumeTime(long r10) {
        ensureSpData();
        this.spData.put("last_unins_resume_time", r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setLinkMode(int r10) {
        safePutToDBJsonData("link_mode", Integer.valueOf(r10));
    }

    public void setMd5(String r10) {
        this.md5 = r10;
    }

    public void setMd5Time(long r10) {
        this.md5Time = r10;
    }

    public void setMimeType(String r10) {
        this.mimeType = r10;
    }

    public void setName(String r10) {
        this.name = r10;
    }

    public void setNetworkQuality(String r10) {
        this.networkQuality = r10;
    }

    public void setNotificationVisibility(int r10) {
        this.notificationVisibility = r10;
    }

    public void setOnlyWifi(boolean r10) {
        this.onlyWifi = r10;
    }

    public void setOpenLimitSpeed(boolean r10) {
        this.openLimitSpeed = r10;
    }

    public void setPackageInfo(PackageInfo r10) {
        this.packageInfoRef = new SoftReference(r10);
    }

    public void setPackageInfoToCache(PackageInfo r10) {
        safePutToDBJsonData("app_package_info", r10.packageName + "," + r10.versionName + "," + r10.versionCode);
    }

    public void setPackageName(String r10) {
        this.packageName = r10;
    }

    public void setPauseByNotification(boolean r10) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (TextUtils.isEmpty(this.extra) == false) goto L5;
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L8
    L6:
        r11.put("pause_by_notification", r10);     // Catch: JSONException -> L8
        this.extra = r11.toString();     // Catch: JSONException -> L8
        return;
    L5:
        r11 = new JSONObject(this.extra);     // Catch: JSONException -> L8
        goto L6
    }

    public void setPausedResumeCount(int r10) {
        ensureSpData();
        this.spData.put("paused_resume_count", r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setPcdnStats(JSONObject r10) {
        this.pcdnStats = r10;
    }

    public void setRedirectPartialUrlResults(String r10) {
        safePutToDBJsonData("redirect_partial_url_results", r10);
    }

    public void setRequestLog(String r10) {
        this.requestLog = r10;
    }

    public void setRetryCount(int r10) {
        this.retryCount = r10;
    }

    public void setRetryScheduleCount(int r10) {
        safePutToDBJsonData("retry_schedule_count", Integer.valueOf(r10));
    }

    public void setSavePath(String r10) {
        this.savePath = r10;
    }

    public void setSavePathRedirected(boolean r10) {
        safePutToDBJsonData("is_save_path_redirected", Boolean.valueOf(r10));
    }

    public void setShowNotification(boolean r10) {
        this.showNotification = r10;
    }

    public void setShowNotificationForAutoResumed(boolean r10) {
        this.showNotificationForAutoResumed = r10;
    }

    public void setShowNotificationForNetworkResumed(boolean r10) {
        this.showNotificationForNetworkResumed = r10;
    }

    public void setSpValue(String r10, String r11) {
        ensureSpData();
        this.spData.put(r10, r11);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setStatus(int r10) {
        AtomicInteger r11 = this.status;
        if (r11 == null) goto L5;
        r11.set(r10);
        return;
    L5:
        this.status = new AtomicInteger(r10);
    }

    public void setStatusAtDbInit(int r10) {
        this.statusAtDbInit = r10;
    }

    public void setSuccessByCache(boolean r10) {
        this.successByCache = r10;
    }

    public void setSupportPartial(boolean r10) {
        this.supportPartial = r10;
    }

    public void setTTMd5CheckStatus(int r10) {
        safePutToDBJsonData("ttmd5_check_status", Integer.valueOf(r10));
    }

    public void setThrottleNetSpeed(long r10) {
        setThrottleNetSpeed(r10, -1);
    }

    public void setThrottleNetSpeed(long r10, int r11) {
        this.throttleNetSpeed = r10;
        this.throttleSmoothness = r11;
    }

    public void setTotalBytes(long r10) {
        this.totalBytes = r10;
    }

    public void setUninstallResumeCount(int r10) {
        ensureSpData();
        this.spData.put("unins_resume_count", r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setUrl(String r10) {
        this.url = r10;
    }

    public void setVerifyCurBytes(long r10) {
        this.verifyCurBytes = r10;
    }

    public void setXTotalBytes(long r10) {
        this.xTotalBytes = r10;
    }

    public void seteTag(String r10) {
        this.eTag = r10;
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
        List<String> r10 = this.backUpUrls;
        if (r10 != null) goto L8;
    L19:
        return false;
    L8:
        if (r10.size() == 0) goto L19;
        if (this.curBackUpUrlIndex < 0) goto L19;
    L13:
        if (this.curBackUpUrlIndex >= this.backUpUrls.size()) goto L19;
        if (TextUtils.isEmpty(this.backUpUrls.get(this.curBackUpUrlIndex)) == false) goto L16;
        this.curBackUpUrlIndex++;
        goto L13
    L16:
        this.backUpUrlUsed = true;
        return true;
    }

    public void updateCurRetryTime(int r10) {
        if (this.backUpUrlUsed == false) goto L5;
        int r11 = this.backUpUrlRetryCount;
    L6:
        int r12 = r11 - r10;
        this.curRetryTime = r12;
        if (r12 >= 0) goto L10;
        this.curRetryTime = 0;
        return;
    L10:
        return;
    L5:
        r11 = this.retryCount;
        goto L6
    }

    public void updateDownloadTime() {
        if (this.startDownloadTime != 0) goto L5;
        return;
    L5:
        long r10 = SystemClock.uptimeMillis() - this.startDownloadTime;
        if (this.downloadTime >= 0) goto L9;
        this.downloadTime = 0;
    L9:
        if (r10 <= 0) goto L12;
        this.downloadTime = r10;
        return;
    }

    public void updateRealDownloadTime(boolean r10) {
        long r11 = System.nanoTime();
        long r12 = this.realStartDownloadTime;
        if (r12 > 0) goto L7;
        if (r10 == false) goto L19;
        this.realStartDownloadTime = r11;
        return;
    L19:
        return;
    L7:
        long r13 = r11 - r12;
        if (r10 == false) goto L10;
        this.realStartDownloadTime = r11;
    L12:
        if (r13 <= 0) goto L20;
        this.realDownloadTime += r13;
        if (this.fastDownload == false) goto L16;
        return;
    L16:
        if (za.a.k().n() == false) goto L22;
        this.realBackDownloadTime += r13;
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
        Context r10 = ((l) k.a(l.class)).getAppContext();
        if (r10 == null) goto L9;
        r10.getSharedPreferences("sp_download_info", 0).edit().putString(Integer.toString(getId()), this.spData.toString()).apply();
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
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.id);
        r10.writeString(this.name);
        r10.writeString(this.title);
        r10.writeString(this.url);
        r10.writeString(this.savePath);
        r10.writeString(this.tempPath);
        r10.writeByte(this.onlyWifi ? 1 : 0);
        r10.writeString(this.extra);
        r10.writeTypedList(this.extraHeaders);
        r10.writeInt(this.maxBytes);
        r10.writeStringArray(this.outIp);
        r10.writeIntArray(this.outSize);
        r10.writeInt(this.retryCount);
        r10.writeInt(this.backUpUrlRetryCount);
        r10.writeByte(this.force ? 1 : 0);
        r10.writeByte(this.needPostProgress ? 1 : 0);
        r10.writeInt(this.maxProgressCount);
        r10.writeInt(this.minProgressTimeMsInterval);
        r10.writeStringList(this.backUpUrls);
        r10.writeByte(this.showNotification ? 1 : 0);
        r10.writeString(this.mimeType);
        r10.writeByte(this.needHttpsToHttpRetry ? 1 : 0);
        r10.writeString(this.packageName);
        r10.writeString(this.md5);
        r10.writeByte(this.needDefaultHttpServiceBackUp ? 1 : 0);
        r10.writeString(this.eTag);
        r10.writeInt(this.curRetryTime);
        r10.writeString(this.networkQuality);
        r10.writeInt(this.curBackUpUrlIndex);
        r10.writeInt(this.notificationVisibility);
        r10.writeInt(this.chunkCount);
        r10.writeLong(getCurBytes());
        r10.writeLong(getBackCurBytes());
        r10.writeLong(this.totalBytes);
        r10.writeInt(getRealStatus());
        r10.writeLong(this.downloadTime);
        r10.writeLong(this.realDownloadTime);
        r10.writeLong(this.realBackDownloadTime);
        r10.writeByte(this.backUpUrlUsed ? 1 : 0);
        r10.writeByte(this.httpsToHttpRetryUsed ? 1 : 0);
        r10.writeByte(this.autoResumed ? 1 : 0);
        r10.writeByte(this.showNotificationForAutoResumed ? 1 : 0);
        r10.writeByte(this.showNotificationForNetworkResumed ? 1 : 0);
        r10.writeStringList(this.forbiddenBackupUrls);
        r10.writeByte(this.needIndependentProcess ? 1 : 0);
        r10.writeInt(this.enqueueType.ordinal());
        r10.writeInt(this.httpStatusCode);
        r10.writeString(this.httpStatusMessage);
        r10.writeByte(this.isForbiddenRetryed ? 1 : 0);
        r10.writeByte(this.addListenerToSameTask ? 1 : 0);
        r10.writeParcelable(this.failedException, r11);
        r10.writeString(getDBJsonDataString());
        r10.writeByte(this.supportPartial ? 1 : 0);
        r10.writeString(this.iconUrl);
        r10.writeInt(this.appVersionCode);
        r10.writeByte(this.expiredRedownload ? 1 : 0);
        r10.writeByte(this.deleteCacheIfCheckFailed ? 1 : 0);
        r10.writeByte(this.successByCache ? 1 : 0);
        r10.writeByte(this.expiredHttpCheck ? 1 : 0);
        r10.writeLong(this.xTotalBytes);
        r10.writeInt(this.interceptFlag);
        r10.writeStringList(this.accessHttpHeaderKeys);
        r10.writeMap(this.httpHeaders);
        r10.writeLong(this.downloadStartTimeStamp);
        r10.writeLong(this.downloadFinishTimeStamp);
        r10.writeLong(this.installedTimeStamp);
        r10.writeByte(this.hasDoInstallation ? 1 : 0);
        r10.writeByte(this.isCacheExistsInDownloading ? 1 : 0);
        r10.writeLong(this.cacheLifeTimeMax);
        r10.writeStringList(this.pcdnUrls);
        r10.writeStringList(this.cdnUrls);
        r10.writeString(this.contentEncoding);
        r10.writeByte(this.fastDownload ? 1 : 0);
        r10.writeByte(this.handleRequest ? 1 : 0);
        r10.writeLong(this.md5Time);
        r10.writeString(this.httpRequestHeader);
        r10.writeString(this.httpResponseHeader);
        r10.writeString(this.requestLog);
        r10.writeLong(this.verifyCurBytes);
        r10.writeByte(this.needCurrentProcess ? 1 : 0);
    }
}
