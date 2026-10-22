package com.ss.android.ugc.effectmanager;

import android.content.Context;
import android.text.TextUtils;
import bytekn.foundation.logger.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.effectmanager.common.listener.IEffectNetWorker;
import com.ss.android.ugc.effectmanager.common.listener.IJsonConverter;
import com.ss.android.ugc.effectmanager.common.listener.IMonitorService;
import com.ss.android.ugc.effectmanager.effect.bridge.EffectFetcher;
import com.ss.android.ugc.effectmanager.knadapt.KNExecutorService;
import com.ss.android.ugc.effectmanager.knadapt.KNJsonConverter;
import com.ss.android.ugc.effectmanager.knadapt.KNLogger;
import com.ss.android.ugc.effectmanager.knadapt.KNMonitorService;
import com.ss.android.ugc.effectmanager.knadapt.KNNetworkClient;
import com.ss.android.ugc.effectmanager.link.model.host.Host;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceManager;
import com.ss.ugc.effectplatform.model.f;
import com.ss.ugc.effectplatform.task.q1;
import dlc.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class EffectConfiguration {
    private static final String API_ADDRESS = "/effect/api";
    public static final int JSON_OPTIMIZE_TYPE_A = 1;
    public static final int JSON_OPTIMIZE_TYPE_B = 2;
    public static final int JSON_OPTIMIZE_TYPE_NONE = 0;
    public static final String KEY_ACCESS_KEY = "access_key";
    public static final String KEY_APP_ID = "aid";
    public static final String KEY_APP_LANGUAGE = "app_language";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_BUSINESS_ID = "bid";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_COUNT = "count";
    public static final String KEY_CURSOR = "cursor";
    public static final String KEY_CY_CODE = "cy_code";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_DEVICE_INFO = "device_info";
    public static final String KEY_DEVICE_PLATFORM = "device_platform";
    public static final String KEY_DEVICE_TYPE = "device_type";
    public static final String KEY_EFFECT_IDS = "effect_ids";
    public static final String KEY_FILTER_TYPE = "filter_type";
    public static final String KEY_GPU_INFO = "gpu";
    public static final String KEY_LX = "lx";
    public static final String KEY_LY = "ly";
    public static final String KEY_PANEL = "panel";
    public static final String KEY_PLATFORM_AB_PARAM = "platform_ab_params";
    public static final String KEY_PLATFORM_SDK_VERSION = "platform_sdk_version";
    public static final String KEY_PROVIDER_NAME = "library";
    public static final String KEY_REGION = "region";
    public static final String KEY_RESOURCE_IDS = "resource_ids";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_SEARCH_KEYWORD = "keyword";
    public static final String KEY_SEARCH_WORD = "word";
    public static final String KEY_SEC_ID = "SecId";
    public static final String KEY_SORTING_POSITION = "sorting_position";
    public static final String KEY_STATUS = "status";
    public static final String KEY_TEST_STATUS = "test_status";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VERSION = "version";
    public static final String KEY_WITH_CATEGORY_EFFECTS = "has_category_effects";
    public static final int STRATEGY_OPTIMIZE_CHECK_UPDATE = 1;
    public static final int STRATEGY_OPTIMIZE_JSON = 2;
    private final Builder mBuilder;
    private final EffectConfig mEffectConfig;

    public static final class Builder {
        private String accessKey;
        private String appID;
        private String appLanguage;
        private String appVersion;
        private String channel;
        private Context context;
        private String deviceId;
        private String deviceType;
        private ArrayList<String> draftList;
        private File effectDir;
        private EffectFetcher effectFetcher;
        private IEffectNetWorker effectNetWorker;
        private int filterType;
        private String gpuVersion;
        private List<Host> hosts;
        private HashMap<String, String> iopInfo;
        private boolean isAbInsertHead;
        private IJsonConverter jsonConverter;
        private ExecutorService mExecutor;
        private EffectConfig.Builder mKNEffectConfigBuilder;
        private int mThreadCoreSize;
        private IMonitorService monitorService;
        private String platform;
        private String region;
        private int requestStrategy;
        private int retryCount;
        private String sdkVersion;
        private String testStatus;
        private boolean unzipNewSolutionEnabled;
        private boolean verifySignature;

        public Builder sysLanguage(String r1) {
            return this;
        }

        public EffectConfiguration build() {
            return new EffectConfiguration(this, null);
        }

        public EffectConfig buildKNEffectConfig() {
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.getClass();
            return new EffectConfig(r0);
        }

        public Builder() {
            this.retryCount = 3;
            this.iopInfo = new HashMap();
            this.verifySignature = false;
            this.mKNEffectConfigBuilder = new EffectConfig.Builder();
        }

        public static /* synthetic */ EffectFetcher access$000(Builder r0) {
            return r0.effectFetcher;
        }

        public static /* synthetic */ boolean access$100(Builder r0) {
            return r0.unzipNewSolutionEnabled;
        }

        public Builder JsonConverter(IJsonConverter r4) {
            this.jsonConverter = r4;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.h = new a(new KNJsonConverter(r4));
            return this;
        }

        public Builder abInsertHead(boolean r2) {
            this.isAbInsertHead = r2;
            this.mKNEffectConfigBuilder.K = r2;
            return this;
        }

        public Builder abInsertHeadPanels(String[] r2) {
            this.mKNEffectConfigBuilder.L = r2;
            return this;
        }

        public Builder accessKey(String r2) {
            this.accessKey = r2;
            this.mKNEffectConfigBuilder.a = r2;
            return this;
        }

        public Builder appID(String r2) {
            this.appID = r2;
            this.mKNEffectConfigBuilder.f = r2;
            return this;
        }

        public Builder appLanguage(String r2) {
            this.appLanguage = r2;
            this.mKNEffectConfigBuilder.q = r2;
            return this;
        }

        public Builder appVersion(String r2) {
            this.appVersion = r2;
            this.mKNEffectConfigBuilder.c = r2;
            return this;
        }

        public Builder channel(String r2) {
            this.channel = r2;
            this.mKNEffectConfigBuilder.i = r2;
            return this;
        }

        public Builder context(Context r2) {
            Context r3 = r2.getApplicationContext();
            this.context = r3;
            this.mKNEffectConfigBuilder.B = r3;
            return this;
        }

        public Builder deviceId(String r2) {
            this.deviceId = r2;
            this.mKNEffectConfigBuilder.d = r2;
            return this;
        }

        public Builder deviceType(String r2) {
            this.deviceType = r2;
            this.mKNEffectConfigBuilder.k = r2;
            return this;
        }

        public Builder draftList(ArrayList<String> r2) {
            this.draftList = r2;
            this.mKNEffectConfigBuilder.A = r2;
            return this;
        }

        public Builder effectDir(File r2) {
            this.effectDir = r2;
            if (r2 != null) goto L6;
            return this;
        L6:
            if (r2.exists() == true) goto L8;
            r2.mkdirs();
        L8:
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.m = r2.getAbsolutePath();
            return this;
        }

        public Builder effectFetcher(EffectFetcher r2) {
            this.effectFetcher = r2;
            EffectConfig.Builder r3 = this.mKNEffectConfigBuilder;
            r3.s = AlgorithmResourceManager.getInstance().getEffectFetcher();
            return this;
        }

        public Builder effectMaxCacheSize(long r5) {
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            if (r5 > 0) goto L5;
            r0.getClass();
        L6:
            return this;
        L5:
            r0.G = r5;
            goto L6
        }

        public Builder effectNetWorker(IEffectNetWorker r3) {
            this.effectNetWorker = r3;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.g = new KNNetworkClient(r3);
            return this;
        }

        public Builder enableAsyncMarkUse(boolean r2) {
            this.mKNEffectConfigBuilder.Q = r2;
            return this;
        }

        public Builder enableCKCache(boolean r2) {
            this.mKNEffectConfigBuilder.V = r2;
            return this;
        }

        public Builder enableEpReadDavCache(boolean r2) {
            this.mKNEffectConfigBuilder.enableEpReadDavCache(r2);
            return this;
        }

        public Builder enablePredictCacheClear(boolean r2) {
            this.mKNEffectConfigBuilder.S = r2;
            return this;
        }

        public Builder executor(ExecutorService r3) {
            this.mExecutor = r3;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            KNExecutorService r1 = new KNExecutorService(r3);
            if (r0.r != null) goto L5;
            r0.r = r1;
        L5:
            return this;
        }

        public Builder extraParams(EffectConfig.b r1) {
            this.mKNEffectConfigBuilder.getClass();
            return this;
        }

        public Builder filterType(int r2) {
            this.filterType = r2;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.F = Integer.valueOf(r2);
            return this;
        }

        public Builder gpuInfo(String r2) {
            this.gpuVersion = r2;
            this.mKNEffectConfigBuilder.v = r2;
            return this;
        }

        public Builder hosts(List<Host> r3) {
            this.hosts = r3;
            if (r3.isEmpty() == true) goto L5;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.y = ((Host) ListProtector.get(r3, 0)).getItemName();
        L5:
            return this;
        }

        public Builder ignoreBuiltInModel(boolean r2) {
            this.mKNEffectConfigBuilder.W = r2;
            return this;
        }

        public Builder ignoreCacheModifiedTime(boolean r2) {
            this.mKNEffectConfigBuilder.R = r2;
            return this;
        }

        public Builder jsonOptimizeType(int r2) {
            this.mKNEffectConfigBuilder.U = r2;
            return this;
        }

        public Builder knEffectFetcher(blc.a r2) {
            this.mKNEffectConfigBuilder.s = r2;
            return this;
        }

        public Builder mobControl(boolean r2) {
            this.mKNEffectConfigBuilder.N = r2;
            return this;
        }

        public Builder modelMapping(boolean r2) {
            this.mKNEffectConfigBuilder.O = r2;
            return this;
        }

        public Builder monitorService(IMonitorService r3) {
            this.monitorService = r3;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.t = new KNMonitorService(r3);
            return this;
        }

        public Builder networkType(EffectConfig.c r1) {
            this.mKNEffectConfigBuilder.getClass();
            return this;
        }

        public Builder objIdConversionConfig(f r1) {
            this.mKNEffectConfigBuilder.getClass();
            return this;
        }

        public Builder osVersion(String r2) {
            this.mKNEffectConfigBuilder.l = r2;
            return this;
        }

        public Builder platform(String r2) {
            this.platform = r2;
            this.mKNEffectConfigBuilder.j = r2;
            return this;
        }

        public Builder preloadReadEnable(boolean r2) {
            this.mKNEffectConfigBuilder.M = r2;
            return this;
        }

        public Builder region(String r2) {
            this.region = r2;
            this.mKNEffectConfigBuilder.e = r2;
            return this;
        }

        public Builder requestStrategy(int r2) {
            this.requestStrategy = r2;
            this.mKNEffectConfigBuilder.x = r2;
            return this;
        }

        public Builder retryCount(int r2) {
            this.retryCount = r2;
            this.mKNEffectConfigBuilder.o = r2;
            return this;
        }

        public Builder sdkVersion(String r2) {
            this.sdkVersion = r2;
            this.mKNEffectConfigBuilder.b = r2;
            return this;
        }

        public Builder setUnzipNewSolution(boolean r2) {
            this.unzipNewSolutionEnabled = r2;
            this.mKNEffectConfigBuilder.z = r2;
            return this;
        }

        public Builder testStatus(String r2) {
            this.testStatus = r2;
            this.mKNEffectConfigBuilder.u = r2;
            return this;
        }

        public Builder threadCoreSize(int r4) {
            this.mThreadCoreSize = r4;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.getClass();
            r0.r = glc.a.a(r4, 30000);
            r0.J = r4;
            return this;
        }

        public Builder verifySignature(boolean r2) {
            this.mKNEffectConfigBuilder.H = r2;
            return this;
        }

        public Builder iop(String r8, String r9, String r10) {
            if (TextUtils.isEmpty(r8) == true) goto L6;
            this.iopInfo.put(EffectConfiguration.KEY_LX, r8);
        L6:
            if (TextUtils.isEmpty(r9) == true) goto L9;
            this.iopInfo.put(EffectConfiguration.KEY_LY, r9);
        L9:
            if (TextUtils.isEmpty(r10) == true) goto L11;
            this.iopInfo.put(EffectConfiguration.KEY_CY_CODE, r10);
        L11:
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.getClass();
            if (r8 != null) goto L14;
        L19:
            if (r9 != null) goto L21;
        L26:
            if (r10 != null) goto L28;
        L33:
            return this;
        L28:
            if ((!Intrinsics.areEqual(r10, "")) == true) goto L31;
            r10 = null;
        L31:
            if (r10 == null) goto L33;
            r0.w.put(EffectConfiguration.KEY_CY_CODE, r10);
            goto L33
        L21:
            if ((!Intrinsics.areEqual(r9, "")) == true) goto L24;
            r9 = null;
        L24:
            if (r9 == null) goto L26;
            r0.w.put(EffectConfiguration.KEY_LY, r9);
            goto L26
        L14:
            if ((!Intrinsics.areEqual(r8, "")) == true) goto L17;
            r8 = null;
        L17:
            if (r8 == null) goto L19;
            r0.w.put(EffectConfiguration.KEY_LX, r8);
            goto L19
        }
    }

    public String getAccessKey() {
        return this.mEffectConfig.a;
    }

    public String getApiAdress() {
        this.mEffectConfig.getClass();
        return API_ADDRESS;
    }

    public String getAppID() {
        return this.mEffectConfig.m;
    }

    public String getAppLanguage() {
        return this.mEffectConfig.n;
    }

    public String getAppVersion() {
        return this.mEffectConfig.c;
    }

    public String getChannel() {
        return this.mEffectConfig.e;
    }

    public Context getContext() {
        return (Context) this.mEffectConfig.G;
    }

    public String getDeviceId() {
        return this.mEffectConfig.d;
    }

    public String getDeviceType() {
        return this.mEffectConfig.g;
    }

    public ArrayList<String> getDraftList() {
        List<String> r0 = this.mEffectConfig.F;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ArrayList) r0;
    }

    public File getEffectDir() {
        return new PolarisFileWrapper(this.mEffectConfig.i);
    }

    public EffectFetcher getEffectFetcher() {
        return Builder.access$000(this.mBuilder);
    }

    public int getFilterType() {
        Integer r0 = this.mEffectConfig.O;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public String getGpuVersion() {
        return this.mEffectConfig.B;
    }

    public HashMap<String, String> getIopInfo() {
        return this.mEffectConfig.o;
    }

    public String getPlatform() {
        return this.mEffectConfig.f;
    }

    public String getRegion() {
        return this.mEffectConfig.l;
    }

    public int getRequestStrategy() {
        return this.mEffectConfig.s;
    }

    public int getRetryCount() {
        return this.mEffectConfig.q;
    }

    public String getSdkVersion() {
        return this.mEffectConfig.b;
    }

    public q1 getTaskManager() {
        return this.mEffectConfig.D;
    }

    public String getTestStatus() {
        return this.mEffectConfig.C;
    }

    public boolean isUnzipNewSolutionEnabled() {
        return Builder.access$100(this.mBuilder);
    }

    public EffectConfig getEffectConfig() {
        return this.mEffectConfig;
    }

    private EffectConfiguration(Builder r2) {
        this.mBuilder = r2;
        EffectConfig r3 = r2.buildKNEffectConfig();
        this.mEffectConfig = r3;
        KNLogger r0 = KNLogger.INSTANCE;
        r3.getClass();
        Logger.INSTANCE.setLogger(r0);
    }

    public void setDeviceId(String r2) {
        this.mEffectConfig.d = r2;
    }

    public void setDraftList(ArrayList<String> r2) {
        EffectConfig r0 = this.mEffectConfig;
        if (r0 == null) goto L6;
        r0.F = r2;
        return;
    }

    public /* synthetic */ EffectConfiguration(Builder r1, 1 r2) {
        this(r1);
    }
}
