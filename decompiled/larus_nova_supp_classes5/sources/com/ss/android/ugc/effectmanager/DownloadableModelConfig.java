package com.ss.android.ugc.effectmanager;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.common.listener.IEffectNetWorker;
import com.ss.android.ugc.effectmanager.common.listener.IJsonConverter;
import com.ss.android.ugc.effectmanager.common.listener.IMonitorService;
import com.ss.android.ugc.effectmanager.knadapt.KNExecutor;
import com.ss.android.ugc.effectmanager.knadapt.KNJsonConverter;
import com.ss.android.ugc.effectmanager.knadapt.KNMonitorService;
import com.ss.android.ugc.effectmanager.knadapt.KNNetworkClient;
import com.ss.android.ugc.effectmanager.knadapt.ModelConverterExtKt;
import com.ss.android.ugc.effectmanager.knadapt.ModelListenerAdaptKt;
import com.ss.android.ugc.effectmanager.link.model.host.Host;
import com.ss.ugc.effectplatform.EffectConfig;
import dlc.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DownloadableModelConfig {
    private final String mAccessKey;
    private final String mAppId;
    private final AssetManager mAssetManager;
    private final Context mContext;
    private final String mDeviceType;
    private final EffectConfiguration mEffectConfiguration;
    private final IEffectNetWorker mEffectNetWorker;
    private final ModelEventListener mEventListener;
    private final Pattern mExclusionPattern;
    private final Executor mExecutor;
    private final FetchModelType mFetchModelType;
    private final List<Host> mHosts;
    private final IJsonConverter mJsonConverter;
    private EffectConfig mKNEffectConfig;
    private final ModelFileEnv mModelFileEnv;
    private final IMonitorService mMonitorService;
    private final String mSdkVersion;
    private final int mThreadCoreSize;
    private final String mWorkspace;

    public static final class Builder {
        String mAccessKey;
        String mAppId;
        AssetManager mAssetManager;
        String mBid;
        Context mContext;
        String mDeviceType;
        EffectConfiguration mEffectConfiguration;
        IEffectNetWorker mEffectNetWorker;
        ModelEventListener mEventListener;
        Pattern mExclusionPattern;
        Executor mExecutor;
        FetchModelType mFetchModelType;
        List<Host> mHosts;
        IJsonConverter mJsonConverter;
        private EffectConfig.Builder mKNEffectConfigBuilder;
        ModelFileEnv mModelFileEnv;
        IMonitorService mMonitorService;
        String mSdkVersion;
        int mThreadCoreSize;
        String mWorkspace;

        private EffectConfig buildKNConfig() {
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.getClass();
            return new EffectConfig(r0);
        }

        public DownloadableModelConfig build() {
            return new DownloadableModelConfig(this, null);
        }

        public Builder() {
            this.mHosts = new ArrayList();
            this.mKNEffectConfigBuilder = new EffectConfig.Builder();
        }

        public static /* synthetic */ EffectConfig access$000(Builder r0) {
            return r0.buildKNConfig();
        }

        public Builder businessBoard(boolean r2) {
            this.mKNEffectConfigBuilder.P = r2;
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

        public Builder extraParams(EffectConfig.b r1) {
            this.mKNEffectConfigBuilder.getClass();
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

        public Builder ignoreModelLruVersion(boolean r2) {
            this.mKNEffectConfigBuilder.T = r2;
            return this;
        }

        public Builder lruCacheVersion(String r2) {
            this.mKNEffectConfigBuilder.I = r2;
            return this;
        }

        public Builder modelMapping(boolean r2) {
            this.mKNEffectConfigBuilder.O = r2;
            return this;
        }

        public Builder networkType(EffectConfig.c r1) {
            this.mKNEffectConfigBuilder.getClass();
            return this;
        }

        public Builder preloadReadEnable(boolean r2) {
            this.mKNEffectConfigBuilder.M = r2;
            return this;
        }

        public Builder setAccessKey(String r2) {
            this.mAccessKey = r2;
            this.mKNEffectConfigBuilder.a = r2;
            return this;
        }

        public Builder setAppId(String r2) {
            this.mAppId = r2;
            this.mKNEffectConfigBuilder.f = r2;
            return this;
        }

        public Builder setAssetManager(AssetManager r1) {
            this.mAssetManager = r1;
            return this;
        }

        public Builder setBid(String r1) {
            this.mBid = r1;
            return this;
        }

        public Builder setContext(Context r2) {
            Context r3 = r2.getApplicationContext();
            this.mContext = r3;
            this.mKNEffectConfigBuilder.B = r3;
            return this;
        }

        public Builder setDeviceType(String r2) {
            this.mDeviceType = r2;
            this.mKNEffectConfigBuilder.k = r2;
            return this;
        }

        public Builder setEffectConfiguration(EffectConfiguration r3) {
            this.mEffectConfiguration = r3;
            if (r3.getContext() == null) goto L8;
            if (this.mContext != null) goto L8;
            setContext(r3.getContext());
        L8:
            if (r3.getAppVersion() == null) goto L11;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.c = r3.getAppVersion();
        L11:
            if (r3.getChannel() == null) goto L14;
            EffectConfig.Builder r1 = this.mKNEffectConfigBuilder;
            r1.i = r3.getChannel();
        L14:
            if (r3.getDeviceId() == null) goto L17;
            EffectConfig.Builder r2 = this.mKNEffectConfigBuilder;
            r2.d = r3.getDeviceId();
        L17:
            if (r3.getPlatform() == null) goto L20;
            EffectConfig.Builder r4 = this.mKNEffectConfigBuilder;
            r4.j = r3.getPlatform();
        L20:
            if (r3.getRegion() == null) goto L23;
            EffectConfig.Builder r5 = this.mKNEffectConfigBuilder;
            r5.e = r3.getRegion();
        L23:
            if (r3.getAppLanguage() == null) goto L26;
            EffectConfig.Builder r6 = this.mKNEffectConfigBuilder;
            r6.q = r3.getAppLanguage();
        L26:
            if (r3.getGpuVersion() == null) goto L29;
            EffectConfig.Builder r7 = this.mKNEffectConfigBuilder;
            r7.v = r3.getGpuVersion();
        L29:
            if (r3.getTestStatus() == null) goto L31;
            EffectConfig.Builder r8 = this.mKNEffectConfigBuilder;
            r8.u = r3.getTestStatus();
        L31:
            EffectConfig.Builder r9 = this.mKNEffectConfigBuilder;
            r9.F = Integer.valueOf(r3.getFilterType());
            EffectConfig.Builder r10 = this.mKNEffectConfigBuilder;
            r10.z = r3.isUnzipNewSolutionEnabled();
            EffectConfig.Builder r11 = this.mKNEffectConfigBuilder;
            r11.m = r3.getEffectDir().getAbsolutePath();
            EffectConfig.Builder r12 = this.mKNEffectConfigBuilder;
            r12.o = r3.getRetryCount();
            return this;
        }

        public Builder setEffectNetWorker(IEffectNetWorker r3) {
            this.mEffectNetWorker = r3;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.g = new KNNetworkClient(r3);
            return this;
        }

        public Builder setEventListener(ModelEventListener r2) {
            this.mEventListener = r2;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            ModelListenerAdaptKt.toKNListener(r2);
            r0.getClass();
            return this;
        }

        public Builder setExclusionPattern(String r2) {
            if (r2 != null) goto L4;
            this.mExclusionPattern = null;
        L5:
            return this;
        L4:
            this.mExclusionPattern = PatternProtector.compile(r2);
            this.mKNEffectConfigBuilder.D = r2;
            goto L5
        }

        public Builder setExecutor(Executor r3) {
            if (this.mExecutor != null) goto L7;
            this.mExecutor = r3;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            KNExecutor r1 = new KNExecutor(r3);
            if (r0.r != null) goto L7;
            r0.r = r1;
        L7:
            return this;
        }

        public Builder setHosts(List<Host> r3) {
            this.mHosts.addAll(r3);
            if (r3.isEmpty() == true) goto L5;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.y = ((Host) ListProtector.get(r3, 0)).getItemName();
        L5:
            return this;
        }

        public Builder setJsonConverter(IJsonConverter r4) {
            this.mJsonConverter = r4;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.h = new a(new KNJsonConverter(r4));
            return this;
        }

        public Builder setModelApiMaxTryCount(int r2) {
            this.mKNEffectConfigBuilder.p = r2;
            return this;
        }

        public Builder setModelFileEnv(ModelFileEnv r2) {
            this.mModelFileEnv = r2;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.E = ModelConverterExtKt.toKNModel(r2);
            return this;
        }

        public Builder setModelType(FetchModelType r2) {
            this.mFetchModelType = r2;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.C = ModelConverterExtKt.toKNFetchModelType(r2);
            return this;
        }

        public Builder setMonitorService(IMonitorService r3) {
            this.mMonitorService = r3;
            EffectConfig.Builder r0 = this.mKNEffectConfigBuilder;
            r0.t = new KNMonitorService(r3);
            return this;
        }

        public Builder setSdkVersion(String r2) {
            this.mSdkVersion = r2;
            this.mKNEffectConfigBuilder.b = r2;
            return this;
        }

        public Builder setThreadCoreSize(int r4) {
            this.mExecutor = glc.a.a(r4, 30000);
            this.mThreadCoreSize = r4;
            EffectConfig.Builder r2 = this.mKNEffectConfigBuilder;
            r2.getClass();
            r2.r = glc.a.a(r4, 30000);
            r2.J = r4;
            return this;
        }

        public Builder setWorkspace(String r2) {
            this.mWorkspace = r2;
            this.mKNEffectConfigBuilder.n = r2;
            return this;
        }
    }

    public static final enum ModelFileEnv extends Enum<ModelFileEnv> {
        private static final /* synthetic */ ModelFileEnv[] $VALUES = null;
        public static final ModelFileEnv ONLINE = null;
        public static final ModelFileEnv TEST = null;

        static {
            ModelFileEnv r0 = new ModelFileEnv("TEST", 0);
            TEST = r0;
            ModelFileEnv r1 = new ModelFileEnv("ONLINE", 1);
            ONLINE = r1;
            $VALUES = new ModelFileEnv[]{r0, r1};
        }

        public static ModelFileEnv[] values() {
            return (ModelFileEnv[]) $VALUES.clone();
        }

        public static ModelFileEnv valueOf(String r1) {
            return (ModelFileEnv) r27.a.a(ModelFileEnv.class, r1);
        }

        private ModelFileEnv(String r1, int r2) {
            super(r1, r2);
        }
    }

    public String getAccessKey() {
        return this.mAccessKey;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public AssetManager getAssetManager() {
        return this.mAssetManager;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDeviceType() {
        return this.mDeviceType;
    }

    public EffectConfiguration getEffectConfiguration() {
        return this.mEffectConfiguration;
    }

    public IEffectNetWorker getEffectNetWorker() {
        return this.mEffectNetWorker;
    }

    public ModelEventListener getEventListener() {
        return this.mEventListener;
    }

    public Pattern getExclusionPattern() {
        return this.mExclusionPattern;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public List<Host> getHosts() {
        return this.mHosts;
    }

    public IJsonConverter getJsonConverter() {
        return this.mJsonConverter;
    }

    public EffectConfig getKNEffectConfig() {
        return this.mKNEffectConfig;
    }

    public ModelFileEnv getModelFileEnv() {
        return this.mModelFileEnv;
    }

    public FetchModelType getModelType() {
        return this.mFetchModelType;
    }

    public IMonitorService getMonitorService() {
        return this.mMonitorService;
    }

    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public int getThreadCoreSize() {
        return this.mThreadCoreSize;
    }

    public String getWorkspace() {
        return this.mWorkspace;
    }

    private DownloadableModelConfig(Builder r2) {
        this.mAssetManager = (AssetManager) checkNotNull(r2.mAssetManager);
        this.mWorkspace = (String) checkNotNull(r2.mWorkspace);
        this.mEffectNetWorker = (IEffectNetWorker) checkNotNull(r2.mEffectNetWorker);
        this.mHosts = Collections.unmodifiableList(r2.mHosts);
        this.mJsonConverter = (IJsonConverter) checkNotNull(r2.mJsonConverter);
        this.mExecutor = r2.mExecutor;
        this.mThreadCoreSize = r2.mThreadCoreSize;
        this.mDeviceType = (String) checkNotNull(r2.mDeviceType);
        this.mSdkVersion = (String) checkNotNull(r2.mSdkVersion);
        this.mAppId = (String) checkNotNull(r2.mAppId);
        this.mAccessKey = (String) checkNotNull(r2.mAccessKey);
        this.mMonitorService = r2.mMonitorService;
        this.mExclusionPattern = r2.mExclusionPattern;
        this.mEventListener = r2.mEventListener;
        ModelFileEnv r0 = r2.mModelFileEnv;
        if (r0 != null) goto L5;
        r0 = ModelFileEnv.ONLINE;
    L5:
        this.mModelFileEnv = r0;
        FetchModelType r1 = r2.mFetchModelType;
        if (r1 != null) goto L8;
        r1 = FetchModelType.ORIGIN;
    L8:
        this.mFetchModelType = r1;
        this.mEffectConfiguration = r2.mEffectConfiguration;
        this.mContext = r2.mContext;
        this.mKNEffectConfig = Builder.access$000(r2);
    }

    private <T> T checkNotNull(T r1) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        throw null;
    }

    public /* synthetic */ DownloadableModelConfig(Builder r1, 1 r2) {
        this(r1);
    }
}
