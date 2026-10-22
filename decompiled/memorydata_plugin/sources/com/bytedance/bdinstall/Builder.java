package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.bdinstall.util.DeviceCategory;
import com.bytedance.bdinstall.util.EventUtils;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Builder {
    IAbContext abContext;
    Account account;
    IExtraParams activeExtraParam;
    IAdIdConfig adidConfig;
    int aid;
    String appLanguage;
    String appName;
    String appRegion;
    JSONObject appTrack;
    IAppTraitCallback appTraitCallback;
    boolean autoActive;
    String channel;
    boolean checkPermissionBeforeCallSensitiveApi;
    Context context;
    ICustomExtraHeader customHeaders;
    Map<String, Object> customInfo;
    boolean debuggable;
    boolean deleteSharedStorage;
    DeviceCategory deviceCategory;
    boolean enableGetIPV6;
    boolean enableListenNetChange;
    boolean enableLoadSN;
    boolean enableMediaID;
    public boolean enableNetCommOpt;
    boolean enableOneKeyMigrateDetect;
    boolean encryptAndCompress;
    IEncryptor encryptor;
    IEventDepend eventDepend;
    String googleAid;
    boolean isAnonymous;
    boolean isDirectActive;
    boolean isLocalTest;
    boolean isMainInstance;
    boolean isMigrating;
    boolean isOpenBpea;
    ILogger logger;
    long manifestVersionCode;
    TelephonyManager mgr;
    boolean needSharedStorage;
    INetworkClient networkClient;
    IParamFilter paramFilter;
    PreInstallChannelCallback preInstallChannelCallback;
    String releaseBuild;
    boolean reportPhoneDetailInfo;
    DefaultSensitiveInterceptor sensitiveInterceptor;
    boolean silenceInBackground;
    String spFileName;
    ISstInfoProvider sstInfoProvider;
    boolean touristMode;
    String tweakedChannel;
    long updateVersionCode;
    String userAgent;
    String version;
    long versionCode;
    String versionMinor;
    String zijiePackage;

    public Builder() {
        this.deleteSharedStorage = true;
        this.needSharedStorage = false;
        this.reportPhoneDetailInfo = true;
        this.debuggable = false;
        this.isMigrating = true;
        this.adidConfig = new IAdIdConfig.AdIdConfig();
        this.enableOneKeyMigrateDetect = true;
        this.enableListenNetChange = false;
        this.checkPermissionBeforeCallSensitiveApi = false;
        this.enableGetIPV6 = true;
        this.isMainInstance = false;
        this.enableLoadSN = true;
        this.enableNetCommOpt = false;
        this.enableMediaID = false;
    }

    public Builder(Context r5, int r6, String r7, boolean r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.deleteSharedStorage = true;
        this.needSharedStorage = false;
        this.reportPhoneDetailInfo = true;
        this.debuggable = false;
        this.isMigrating = true;
        this.adidConfig = new IAdIdConfig.AdIdConfig();
        this.enableOneKeyMigrateDetect = true;
        this.enableListenNetChange = false;
        this.checkPermissionBeforeCallSensitiveApi = false;
        this.enableGetIPV6 = true;
        this.isMainInstance = false;
        this.enableLoadSN = true;
        this.enableNetCommOpt = false;
        this.enableMediaID = false;
        this.context = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.aid = r6;
        this.appName = r7;
        this.autoActive = r8;
    }

    public InstallOptions build() {
        if (this.context != null) goto L5;
    L32:
        StringBuilder r1 = new StringBuilder().append("parameters error:");
        if (this.context != null) goto L35;
        boolean r2 = true;
    L37:
        throw new IllegalArgumentException(r1.append(r2).append(", ").append(this.aid).append(", ").append(this.channel).toString());
    L35:
        r2 = false;
        goto L37
    L5:
        if (this.aid <= 0) goto L32;
        if (TextUtils.isEmpty(this.channel) == true) goto L32;
        if (TextUtils.isEmpty(this.appName) == true) goto L31;
        if (DrLog.debug() == true) goto L23;
        if (this.networkClient == null) goto L21;
        if (this.eventDepend != null) goto L23;
        throw new IllegalArgumentException("please set event depend");
    L21:
        throw new IllegalArgumentException("please set network client");
    L23:
        if (TextUtils.isEmpty(this.tweakedChannel) == false) goto L26;
        this.tweakedChannel = this.channel;
    L26:
        if (this.mgr != null) goto L28;
        this.mgr = (TelephonyManager) ZeusTransformUtils.preCheckCast(this.context.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
    L28:
        EventUtils.getInstance().setMonitors(this.aid);
        return new InstallOptions(this);
    L31:
        throw new IllegalArgumentException("appName is empty");
    }

    public Builder checkPermissionBeforeCallSensitiveApi(boolean r1) {
        this.checkPermissionBeforeCallSensitiveApi = r1;
        return this;
    }

    public Builder enableGetIPV6(boolean r1) {
        this.enableGetIPV6 = r1;
        return this;
    }

    public Builder enableListenNetChange(boolean r1) {
        this.enableListenNetChange = r1;
        return this;
    }

    public Builder enableMediaID(boolean r1) {
        this.enableMediaID = r1;
        return this;
    }

    public Builder enableOneKeyMigrateDetect(boolean r1) {
        this.enableOneKeyMigrateDetect = r1;
        return this;
    }

    public Builder isAb(boolean r1) {
        this.isMigrating = r1;
        return this;
    }

    public Builder isMainProcess(boolean r1) {
        Utils.setIsMainProcess(r1);
        return this;
    }

    public Builder needDeleteShardStorage(boolean r1) {
        this.deleteSharedStorage = r1;
        return this;
    }

    public Builder needSharedStorage(boolean r1) {
        this.needSharedStorage = r1;
        return this;
    }

    public Builder setAbContext(IAbContext r3) {
        this.abContext = (IAbContext) ZeusTransformUtils.wrapperContextForParams(r3, IAbContext.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setAccount(Account r1) {
        this.account = r1;
        return this;
    }

    public Builder setActiveExtraParam(IExtraParams r3) {
        this.activeExtraParam = (IExtraParams) ZeusTransformUtils.wrapperContextForParams(r3, IExtraParams.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setAdIdConfig(IAdIdConfig r3) {
        IAdIdConfig r4 = (IAdIdConfig) ZeusTransformUtils.wrapperContextForParams(r3, IAdIdConfig.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        this.adidConfig = r4;
    L5:
        return this;
    }

    public Builder setAid(int r1) {
        this.aid = r1;
        return this;
    }

    public Builder setAnonymous(boolean r1) {
        this.isAnonymous = r1;
        return this;
    }

    @Deprecated
    public Builder setAntiCheatingEnable(boolean r1) {
        return this;
    }

    public Builder setAppLanguage(String r1) {
        this.appLanguage = r1;
        return this;
    }

    public Builder setAppName(String r1) {
        this.appName = r1;
        return this;
    }

    public Builder setAppRegion(String r1) {
        this.appRegion = r1;
        return this;
    }

    public Builder setAppTrack(JSONObject r1) {
        this.appTrack = r1;
        return this;
    }

    public Builder setAppTraitCallback(IAppTraitCallback r3) {
        this.appTraitCallback = (IAppTraitCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAppTraitCallback.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setAutoActive(boolean r1) {
        this.autoActive = r1;
        return this;
    }

    public Builder setBDTrackerDepend(IEventDepend r3) {
        this.eventDepend = (IEventDepend) ZeusTransformUtils.wrapperContextForParams(r3, IEventDepend.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setChannel(String r1) {
        this.channel = r1;
        return this;
    }

    public Builder setContext(Context r3) {
        this.context = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setCustomHeaders(ICustomExtraHeader r3) {
        this.customHeaders = (ICustomExtraHeader) ZeusTransformUtils.wrapperContextForParams(r3, ICustomExtraHeader.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setCustomInfo(Map<String, Object> r3) {
        this.customInfo = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setDebug(boolean r1) {
        this.debuggable = r1;
        return this;
    }

    public Builder setDeviceCategory(DeviceCategory r1) {
        this.deviceCategory = r1;
        return this;
    }

    public Builder setDirectActive(boolean r1) {
        this.isDirectActive = r1;
        return this;
    }

    public Builder setEnableLoadSN(boolean r1) {
        this.enableLoadSN = r1;
        return this;
    }

    public Builder setEnableNetCommOpt(boolean r1) {
        this.enableNetCommOpt = r1;
        return this;
    }

    public Builder setEncryptAndCompress(boolean r1) {
        this.encryptAndCompress = r1;
        return this;
    }

    public Builder setEncryptor(IEncryptor r3) {
        this.encryptor = (IEncryptor) ZeusTransformUtils.wrapperContextForParams(r3, IEncryptor.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setGoogleAid(String r1) {
        this.googleAid = r1;
        return this;
    }

    public Builder setIsLocalTest(boolean r1) {
        this.isLocalTest = r1;
        return this;
    }

    public Builder setLogger(ILogger r3) {
        this.logger = (ILogger) ZeusTransformUtils.wrapperContextForParams(r3, ILogger.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setManifestVersionCode(long r1) {
        this.manifestVersionCode = r1;
        return this;
    }

    public Builder setNetworkClient(INetworkClient r3) {
        this.networkClient = (INetworkClient) ZeusTransformUtils.wrapperContextForParams(r3, INetworkClient.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setOpenBpea(boolean r1) {
        this.isOpenBpea = r1;
        return this;
    }

    public Builder setParamFilter(IParamFilter r3) {
        this.paramFilter = (IParamFilter) ZeusTransformUtils.wrapperContextForParams(r3, IParamFilter.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setPreInstallChannelCallback(PreInstallChannelCallback r3) {
        this.preInstallChannelCallback = (PreInstallChannelCallback) ZeusTransformUtils.wrapperContextForParams(r3, PreInstallChannelCallback.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setReleaseBuild(String r1) {
        this.releaseBuild = r1;
        return this;
    }

    public Builder setReportPhoneDetailInfo(boolean r1) {
        this.reportPhoneDetailInfo = r1;
        return this;
    }

    public Builder setSSTInfoProvider(ISstInfoProvider r3) {
        this.sstInfoProvider = (ISstInfoProvider) ZeusTransformUtils.wrapperContextForParams(r3, ISstInfoProvider.class, "com.obric.memorydata.plugin");
        return this;
    }

    public Builder setSensitiveInterceptor(DefaultSensitiveInterceptor r1) {
        this.sensitiveInterceptor = r1;
        return this;
    }

    public Builder setSilenceInBackground(boolean r1) {
        this.silenceInBackground = r1;
        return this;
    }

    public Builder setSpFileName(String r1) {
        this.spFileName = r1;
        return this;
    }

    public Builder setTouristMode(boolean r1) {
        this.touristMode = r1;
        return this;
    }

    @Deprecated
    public Builder setTweakedChannel(String r1) {
        this.tweakedChannel = r1;
        return this;
    }

    public Builder setUpdateVersionCode(long r1) {
        this.updateVersionCode = r1;
        return this;
    }

    public Builder setUpdateVersionName(String r1) {
        this.versionMinor = r1;
        return this;
    }

    public Builder setUserAgent(String r1) {
        this.userAgent = r1;
        return this;
    }

    public Builder setVersionCode(long r1) {
        this.versionCode = r1;
        return this;
    }

    public Builder setVersionName(String r1) {
        this.version = r1;
        return this;
    }

    public Builder setZijiePackage(String r1) {
        this.zijiePackage = r1;
        return this;
    }
}
