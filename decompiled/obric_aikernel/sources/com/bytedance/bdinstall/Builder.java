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
        this.enableMediaID = true;
    }

    public Builder(Context r10, int r11, String r12, boolean r13) {
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
        this.enableMediaID = true;
        this.context = r10;
        this.aid = r11;
        this.appName = r12;
        this.autoActive = r13;
    }

    public InstallOptions build() {
        if (this.context != null) goto L5;
    L32:
        StringBuilder r10 = new StringBuilder();
        r10.append("parameters error:");
        if (this.context != null) goto L35;
        boolean r11 = true;
    L36:
        r10.append(r11);
        r10.append(", ");
        r10.append(this.aid);
        r10.append(", ");
        r10.append(this.channel);
        throw new IllegalArgumentException(r10.toString());
    L35:
        r11 = false;
        goto L36
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
        this.mgr = (TelephonyManager) this.context.getSystemService("phone");
    L28:
        EventUtils.getInstance().setMonitors(this.aid);
        return new InstallOptions(this);
    L31:
        throw new IllegalArgumentException("appName is empty");
    }

    public Builder checkPermissionBeforeCallSensitiveApi(boolean r10) {
        this.checkPermissionBeforeCallSensitiveApi = r10;
        return this;
    }

    public Builder enableGetIPV6(boolean r10) {
        this.enableGetIPV6 = r10;
        return this;
    }

    public Builder enableListenNetChange(boolean r10) {
        this.enableListenNetChange = r10;
        return this;
    }

    public Builder enableMediaID(boolean r10) {
        this.enableMediaID = r10;
        return this;
    }

    public Builder enableOneKeyMigrateDetect(boolean r10) {
        this.enableOneKeyMigrateDetect = r10;
        return this;
    }

    public Builder isAb(boolean r10) {
        this.isMigrating = r10;
        return this;
    }

    public Builder isMainProcess(boolean r10) {
        Utils.setIsMainProcess(r10);
        return this;
    }

    public Builder needDeleteShardStorage(boolean r10) {
        this.deleteSharedStorage = r10;
        return this;
    }

    public Builder needSharedStorage(boolean r10) {
        this.needSharedStorage = r10;
        return this;
    }

    public Builder setAbContext(IAbContext r10) {
        this.abContext = r10;
        return this;
    }

    public Builder setAccount(Account r10) {
        this.account = r10;
        return this;
    }

    public Builder setActiveExtraParam(IExtraParams r10) {
        this.activeExtraParam = r10;
        return this;
    }

    public Builder setAdIdConfig(IAdIdConfig r10) {
        if (r10 == null) goto L4;
        this.adidConfig = r10;
    L4:
        return this;
    }

    public Builder setAid(int r10) {
        this.aid = r10;
        return this;
    }

    public Builder setAnonymous(boolean r10) {
        this.isAnonymous = r10;
        return this;
    }

    @Deprecated
    public Builder setAntiCheatingEnable(boolean r10) {
        return this;
    }

    public Builder setAppLanguage(String r10) {
        this.appLanguage = r10;
        return this;
    }

    public Builder setAppName(String r10) {
        this.appName = r10;
        return this;
    }

    public Builder setAppRegion(String r10) {
        this.appRegion = r10;
        return this;
    }

    public Builder setAppTrack(JSONObject r10) {
        this.appTrack = r10;
        return this;
    }

    public Builder setAppTraitCallback(IAppTraitCallback r10) {
        this.appTraitCallback = r10;
        return this;
    }

    public Builder setAutoActive(boolean r10) {
        this.autoActive = r10;
        return this;
    }

    public Builder setBDTrackerDepend(IEventDepend r10) {
        this.eventDepend = r10;
        return this;
    }

    public Builder setChannel(String r10) {
        this.channel = r10;
        return this;
    }

    public Builder setContext(Context r10) {
        this.context = r10;
        return this;
    }

    public Builder setCustomHeaders(ICustomExtraHeader r10) {
        this.customHeaders = r10;
        return this;
    }

    public Builder setCustomInfo(Map<String, Object> r10) {
        this.customInfo = r10;
        return this;
    }

    public Builder setDebug(boolean r10) {
        this.debuggable = r10;
        return this;
    }

    public Builder setDeviceCategory(DeviceCategory r10) {
        this.deviceCategory = r10;
        return this;
    }

    public Builder setDirectActive(boolean r10) {
        this.isDirectActive = r10;
        return this;
    }

    public Builder setEnableLoadSN(boolean r10) {
        this.enableLoadSN = r10;
        return this;
    }

    public Builder setEnableNetCommOpt(boolean r10) {
        this.enableNetCommOpt = r10;
        return this;
    }

    public Builder setEncryptAndCompress(boolean r10) {
        this.encryptAndCompress = r10;
        return this;
    }

    public Builder setEncryptor(IEncryptor r10) {
        this.encryptor = r10;
        return this;
    }

    public Builder setGoogleAid(String r10) {
        this.googleAid = r10;
        return this;
    }

    public Builder setIsLocalTest(boolean r10) {
        this.isLocalTest = r10;
        return this;
    }

    public Builder setLogger(ILogger r10) {
        this.logger = r10;
        return this;
    }

    public Builder setManifestVersionCode(long r10) {
        this.manifestVersionCode = r10;
        return this;
    }

    public Builder setNetworkClient(INetworkClient r10) {
        this.networkClient = r10;
        return this;
    }

    public Builder setOpenBpea(boolean r10) {
        this.isOpenBpea = r10;
        return this;
    }

    public Builder setParamFilter(IParamFilter r10) {
        this.paramFilter = r10;
        return this;
    }

    public Builder setPreInstallChannelCallback(PreInstallChannelCallback r10) {
        this.preInstallChannelCallback = r10;
        return this;
    }

    public Builder setReleaseBuild(String r10) {
        this.releaseBuild = r10;
        return this;
    }

    public Builder setReportPhoneDetailInfo(boolean r10) {
        this.reportPhoneDetailInfo = r10;
        return this;
    }

    public Builder setSSTInfoProvider(ISstInfoProvider r10) {
        this.sstInfoProvider = r10;
        return this;
    }

    public Builder setSensitiveInterceptor(DefaultSensitiveInterceptor r10) {
        this.sensitiveInterceptor = r10;
        return this;
    }

    public Builder setSilenceInBackground(boolean r10) {
        this.silenceInBackground = r10;
        return this;
    }

    public Builder setSpFileName(String r10) {
        this.spFileName = r10;
        return this;
    }

    public Builder setTouristMode(boolean r10) {
        this.touristMode = r10;
        return this;
    }

    @Deprecated
    public Builder setTweakedChannel(String r10) {
        this.tweakedChannel = r10;
        return this;
    }

    public Builder setUpdateVersionCode(long r10) {
        this.updateVersionCode = r10;
        return this;
    }

    public Builder setUpdateVersionName(String r10) {
        this.versionMinor = r10;
        return this;
    }

    public Builder setUserAgent(String r10) {
        this.userAgent = r10;
        return this;
    }

    public Builder setVersionCode(long r10) {
        this.versionCode = r10;
        return this;
    }

    public Builder setVersionName(String r10) {
        this.version = r10;
        return this;
    }

    public Builder setZijiePackage(String r10) {
        this.zijiePackage = r10;
        return this;
    }
}
