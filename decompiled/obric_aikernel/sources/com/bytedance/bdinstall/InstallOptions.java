package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.bdinstall.util.DeviceCategory;
import com.bytedance.bdinstall.util.LocalConstants;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InstallOptions {
    private static final String DEFAULT_SP_NAME = "applog_stats";
    private final IAbContext abContext;
    private Account account;
    private final IExtraParams activeExtraParam;
    private final IAdIdConfig adidConfig;
    private final int aid;
    private final String appLanguage;
    private final String appName;
    private final String appRegion;
    private final JSONObject appTrack;
    private final IAppTraitCallback appTraitCallback;
    private final boolean autoActive;
    private final String channel;
    private final boolean checkPermissionBeforeCallSensitiveApi;
    private final Map<String, Object> commonHeaders;
    private final Context context;
    private final ICustomExtraHeader customHeaders;
    private final boolean debuggable;
    private final DefaultSensitiveInterceptor defaultSensitiveInterceptor;
    private final boolean deleteSharedStorage;
    private final DeviceCategory deviceCategory;
    private final boolean enableGetIPV6;
    private final boolean enableListenNetChange;
    private final boolean enableLoadSN;
    private final boolean enableMediaID;
    private final boolean enableNetCommOpt;
    private final boolean enableOneKeyMigrateDetect;
    private final boolean encryptAndCompress;
    private final IEncryptor encryptor;
    private final IEventDepend eventDepend;
    private final String googleAid;
    private final boolean isAnonymous;
    private final boolean isDirectActive;
    private final boolean isLocalTest;
    boolean isMainInstance;
    private final boolean isMigrating;
    private final ILogger logger;
    private final AppVersionCompat mAppVersionCompat;
    TelephonyManager mgr;
    private final boolean needSharedStorage;
    private final INetworkClient networkClient;
    private final IParamFilter paramFilter;
    private final PreInstallChannelCallback preInstallChannelCallback;
    private final String releaseBuild;
    private final boolean reportPhoneDetailInfo;
    private final DefaultSensitiveInterceptor sensitiveInterceptor;
    private final boolean silenceInBackground;
    private SharedPreferences sp;
    private final String spFileName;
    private final ISstInfoProvider sstInfoProvider;
    private final boolean touristMode;
    private final String tweakedChannel;
    private final String userAgent;
    private final String zijiePackage;

    InstallOptions(Builder r10) {
        this.sp = null;
        this.context = r10.context;
        this.aid = r10.aid;
        INetworkClient r11 = r10.networkClient;
        if (r11 != null) goto L6;
        r11 = new DefaultClient();
    L6:
        this.networkClient = r11;
        if (TextUtils.isEmpty(r10.spFileName) == false) goto L9;
        String r12 = DEFAULT_SP_NAME;
    L10:
        this.spFileName = r12;
        this.zijiePackage = r10.zijiePackage;
        this.appName = r10.appName;
        this.channel = r10.channel;
        this.tweakedChannel = r10.tweakedChannel;
        this.releaseBuild = r10.releaseBuild;
        this.abContext = r10.abContext;
        this.userAgent = r10.userAgent;
        this.googleAid = r10.googleAid;
        this.appLanguage = r10.appLanguage;
        this.appRegion = r10.appRegion;
        this.appTrack = r10.appTrack;
        this.commonHeaders = r10.customInfo;
        this.customHeaders = r10.customHeaders;
        this.encryptAndCompress = r10.encryptAndCompress;
        this.isLocalTest = r10.isLocalTest;
        this.autoActive = r10.autoActive;
        this.silenceInBackground = r10.silenceInBackground;
        this.reportPhoneDetailInfo = r10.reportPhoneDetailInfo;
        this.eventDepend = r10.eventDepend;
        this.isAnonymous = r10.isAnonymous;
        this.preInstallChannelCallback = r10.preInstallChannelCallback;
        this.mAppVersionCompat = new AppVersionCompat(r10);
        this.account = r10.account;
        this.debuggable = r10.debuggable;
        this.logger = r10.logger;
        IEncryptor r13 = r10.encryptor;
        if (r13 != null) goto L14;
        r13 = new IEncryptor.DefaultEncryptor();
    L14:
        this.encryptor = r13;
        this.isMigrating = r10.isMigrating;
        this.sstInfoProvider = r10.sstInfoProvider;
        this.touristMode = r10.touristMode;
        this.appTraitCallback = r10.appTraitCallback;
        this.needSharedStorage = r10.needSharedStorage;
        this.deleteSharedStorage = r10.deleteSharedStorage;
        this.paramFilter = r10.paramFilter;
        this.adidConfig = r10.adidConfig;
        this.activeExtraParam = r10.activeExtraParam;
        this.enableOneKeyMigrateDetect = r10.enableOneKeyMigrateDetect;
        this.enableListenNetChange = r10.enableListenNetChange;
        this.checkPermissionBeforeCallSensitiveApi = r10.checkPermissionBeforeCallSensitiveApi;
        this.enableGetIPV6 = r10.enableGetIPV6;
        this.isDirectActive = r10.isDirectActive;
        this.enableLoadSN = r10.enableLoadSN;
        this.enableNetCommOpt = r10.enableNetCommOpt;
        this.deviceCategory = r10.deviceCategory;
        DefaultSensitiveInterceptor r14 = r10.sensitiveInterceptor;
        this.sensitiveInterceptor = r14;
        this.enableMediaID = r10.enableMediaID;
        this.mgr = r10.mgr;
        if (r14 == null) goto L17;
        this.defaultSensitiveInterceptor = r14;
        r14.setOptions(this);
        return;
    L17:
        DefaultSensitiveInterceptor r15 = new DefaultSensitiveInterceptor();
        this.defaultSensitiveInterceptor = r15;
        r15.setOptions(this);
        return;
    L9:
        r12 = r10.spFileName;
        goto L10
    }

    public boolean deleteSharedStorage() {
        return this.deleteSharedStorage;
    }

    public boolean enableOneKeyMigrateDetect() {
        return this.enableOneKeyMigrateDetect;
    }

    public boolean encryptAndCompress() {
        if (isDebuggable() == true) goto L5;
        return true;
    L5:
        return this.encryptAndCompress;
    }

    public IAbContext getAbContext() {
        return this.abContext;
    }

    public String getAbVersion() {
        IAbContext r10 = this.abContext;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getAbVersion();
    }

    public Account getAccount() {
        return this.account;
    }

    public IExtraParams getActiveParam() {
        return this.activeExtraParam;
    }

    public IAdIdConfig getAdIdConfig() {
        return this.adidConfig;
    }

    public int getAid() {
        return this.aid;
    }

    public String getAidString() {
        return String.valueOf(this.aid);
    }

    public String getAppLanguage() {
        if (TextUtils.isEmpty(this.appLanguage) == true) goto L7;
        return this.appLanguage;
    L7:
        return LocalConstants.getCommonSp(this.context, this).getString(Api.KEY_APP_LANGUAGE, null);
    }

    public String getAppLanguageFromSp() {
        return getSp().getString(Api.KEY_APP_LANGUAGE, null);
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppRegion() {
        if (TextUtils.isEmpty(this.appRegion) == true) goto L7;
        return this.appRegion;
    L7:
        return LocalConstants.getCommonSp(this.context, this).getString(Api.KEY_APP_REGION, null);
    }

    public String getAppRegionFromSp() {
        return getSp().getString(Api.KEY_APP_REGION, null);
    }

    public JSONObject getAppTrack() {
        JSONObject r10 = this.appTrack;
        if (r10 == null) goto L5;
        return r10;
    L5:
        String r11 = LocalConstants.getCommonSp(this.context, this).getString(Api.KEY_APP_TRACK, null);
        if (r11 != null) goto L11;
    L9:
        return null;
    L11:
        return new JSONObject(r11);
    }

    public IAppTraitCallback getAppTraitCallback() {
        return this.appTraitCallback;
    }

    public String getChannel() {
        return this.channel;
    }

    public Map<String, Object> getCommonHeader() {
        return this.commonHeaders;
    }

    public Context getContext() {
        return this.context;
    }

    public Map<String, Object> getCustomHeader() {
        ICustomExtraHeader r10 = this.customHeaders;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getExtraParams();
    }

    public String getDeviceCategory() {
        DeviceCategory r10 = this.deviceCategory;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getLower();
    }

    IEncryptor getEncryptor() {
        return this.encryptor;
    }

    public IEventDepend getEventDepend() {
        return this.eventDepend;
    }

    public String getGoogleAid() {
        return this.googleAid;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public long getManifestVersionCode() {
        return this.mAppVersionCompat.getManifestVersionCode();
    }

    public INetworkClient getNetworkClient() {
        return this.networkClient;
    }

    public IParamFilter getParamFilter() {
        return this.paramFilter;
    }

    public PreInstallChannelCallback getPreInstallChannelCallback() {
        return this.preInstallChannelCallback;
    }

    public String getReleaseBuild() {
        return this.releaseBuild;
    }

    public DefaultSensitiveInterceptor getSensitiveInterceptor() {
        return this.defaultSensitiveInterceptor;
    }

    public SharedPreferences getSp() {
        if (this.sp != null) goto L10;
        if (this.isMainInstance == false) goto L7;
        String r10 = this.spFileName;
    L8:
        this.sp = this.context.getSharedPreferences(r10, 0);
        goto L10
    L7:
        r10 = this.spFileName + "_" + this.aid;
    L10:
        return this.sp;
    }

    public ISstInfoProvider getSstInfoProvider() {
        return this.sstInfoProvider;
    }

    public TelephonyManager getTelephonyManager() {
        return this.mgr;
    }

    public String getTweakedChannel() {
        return this.tweakedChannel;
    }

    public long getUpdateVersionCode() {
        return this.mAppVersionCompat.getUpdateVersionCode();
    }

    public String getUserAgent() {
        if (TextUtils.isEmpty(this.userAgent) == true) goto L7;
        return this.userAgent;
    L7:
        return LocalConstants.getCommonSp(this.context, this).getString(Api.KEY_USER_AGENT, null);
    }

    public String getUserUniqueId(Context r10) {
        String r11 = LocalConstants.getCommonSp(r10, this).getString(Api.KEY_USER_UNIQUE_ID, null);
        if (TextUtils.isEmpty(r11) == true) goto L5;
        return r11;
    L5:
        return r10.getSharedPreferences("header_custom", 0).getString(Api.KEY_USER_UNIQUE_ID, null);
    }

    public String getVersion() {
        return this.mAppVersionCompat.getVersion();
    }

    public long getVersionCode() {
        return this.mAppVersionCompat.getVersionCode();
    }

    public String getVersionMinor() {
        return this.mAppVersionCompat.getVersionMinor();
    }

    public String getZijiePackage() {
        return this.zijiePackage;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean isAutoActive() {
        return this.autoActive;
    }

    public boolean isCheckPermissionBeforeCallSensitiveApi() {
        return this.checkPermissionBeforeCallSensitiveApi;
    }

    public boolean isDebuggable() {
        return this.debuggable;
    }

    public boolean isDirectActive() {
        return this.isDirectActive;
    }

    public boolean isEnableGetIPV6() {
        return this.enableGetIPV6;
    }

    public boolean isEnableGetMediaId() {
        return this.enableMediaID;
    }

    public boolean isEnableListenNetChange() {
        return this.enableListenNetChange;
    }

    public boolean isEnableLoadSN() {
        return this.enableLoadSN;
    }

    public boolean isEnableNetCommOpt() {
        return this.enableNetCommOpt;
    }

    public boolean isLocalTest() {
        return this.isLocalTest;
    }

    public boolean isMainInstance() {
        return this.isMainInstance;
    }

    public boolean isNeedSharedStorage() {
        return this.needSharedStorage;
    }

    public boolean isSilenceInBackground() {
        return this.silenceInBackground;
    }

    public boolean isTouristMode() {
        return this.touristMode;
    }

    public boolean reportPhoneDetailInfo() {
        return this.reportPhoneDetailInfo;
    }

    public void saveConfigAfterRegister(SharedPreferences.Editor r10) {
        String r11 = getAppLanguage();
        String r12 = getAppRegion();
        if (TextUtils.isEmpty(r11) == true) goto L6;
        r10.putString(Api.KEY_APP_LANGUAGE, r11);
    L6:
        if (TextUtils.isEmpty(r12) == true) goto L9;
        r10.putString(Api.KEY_APP_REGION, r12);
        return;
    }

    void setAccount(Account r10) {
        this.account = r10;
    }

    void setIsMainInstance(boolean r10) {
        this.isMainInstance = r10;
    }
}
