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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    InstallOptions(Builder r3) {
        this.sp = null;
        this.context = ZeusTransformUtils.wrapperContext(r3.context, "com.obric.memorydata.plugin");
        this.aid = r3.aid;
        if (r3.networkClient == null) goto L5;
        INetworkClient r0 = r3.networkClient;
    L6:
        this.networkClient = r0;
        if (TextUtils.isEmpty(r3.spFileName) == false) goto L9;
        String r1 = DEFAULT_SP_NAME;
    L10:
        this.spFileName = r1;
        this.zijiePackage = r3.zijiePackage;
        this.appName = r3.appName;
        this.channel = r3.channel;
        this.tweakedChannel = r3.tweakedChannel;
        this.releaseBuild = r3.releaseBuild;
        this.abContext = r3.abContext;
        this.userAgent = r3.userAgent;
        this.googleAid = r3.googleAid;
        this.appLanguage = r3.appLanguage;
        this.appRegion = r3.appRegion;
        this.appTrack = r3.appTrack;
        this.commonHeaders = r3.customInfo;
        this.customHeaders = r3.customHeaders;
        this.encryptAndCompress = r3.encryptAndCompress;
        this.isLocalTest = r3.isLocalTest;
        this.autoActive = r3.autoActive;
        this.silenceInBackground = r3.silenceInBackground;
        this.reportPhoneDetailInfo = r3.reportPhoneDetailInfo;
        this.eventDepend = r3.eventDepend;
        this.isAnonymous = r3.isAnonymous;
        this.preInstallChannelCallback = r3.preInstallChannelCallback;
        this.mAppVersionCompat = new AppVersionCompat(r3);
        this.account = r3.account;
        this.debuggable = r3.debuggable;
        this.logger = r3.logger;
        if (r3.encryptor == null) goto L13;
        IEncryptor r2 = r3.encryptor;
    L14:
        this.encryptor = r2;
        this.isMigrating = r3.isMigrating;
        this.sstInfoProvider = r3.sstInfoProvider;
        this.touristMode = r3.touristMode;
        this.appTraitCallback = r3.appTraitCallback;
        this.needSharedStorage = r3.needSharedStorage;
        this.deleteSharedStorage = r3.deleteSharedStorage;
        this.paramFilter = r3.paramFilter;
        this.adidConfig = r3.adidConfig;
        this.activeExtraParam = r3.activeExtraParam;
        this.enableOneKeyMigrateDetect = r3.enableOneKeyMigrateDetect;
        this.enableListenNetChange = r3.enableListenNetChange;
        this.checkPermissionBeforeCallSensitiveApi = r3.checkPermissionBeforeCallSensitiveApi;
        this.enableGetIPV6 = r3.enableGetIPV6;
        this.isDirectActive = r3.isDirectActive;
        this.enableLoadSN = r3.enableLoadSN;
        this.enableNetCommOpt = r3.enableNetCommOpt;
        this.deviceCategory = r3.deviceCategory;
        DefaultSensitiveInterceptor r4 = r3.sensitiveInterceptor;
        this.sensitiveInterceptor = r4;
        this.mgr = r3.mgr;
        if (r4 == null) goto L17;
        this.defaultSensitiveInterceptor = r4;
        r4.setOptions(this);
        return;
    L17:
        DefaultSensitiveInterceptor r5 = new DefaultSensitiveInterceptor();
        this.defaultSensitiveInterceptor = r5;
        r5.setOptions(this);
        return;
    L13:
        r2 = new IEncryptor.DefaultEncryptor();
        goto L14
    L9:
        r1 = r3.spFileName;
        goto L10
    L5:
        r0 = new DefaultClient();
        goto L6
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
        IAbContext r0 = this.abContext;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getAbVersion();
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
        JSONObject r0 = this.appTrack;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r2 = LocalConstants.getCommonSp(this.context, this).getString(Api.KEY_APP_TRACK, null);
        if (r2 != null) goto L11;
    L9:
        return null;
    L11:
        return new JSONObject(r2);
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
        ICustomExtraHeader r0 = this.customHeaders;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getExtraParams();
    }

    public String getDeviceCategory() {
        DeviceCategory r0 = this.deviceCategory;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLower();
    }

    public IEncryptor getEncryptor() {
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
        String r0 = this.spFileName;
    L8:
        this.sp = this.context.getSharedPreferences(r0, 0);
        goto L10
    L7:
        r0 = this.spFileName + "_" + this.aid;
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

    public String getUserUniqueId(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        String r3 = LocalConstants.getCommonSp(r5, this).getString(Api.KEY_USER_UNIQUE_ID, null);
        if (TextUtils.isEmpty(r3) == true) goto L5;
        return r3;
    L5:
        return r5.getSharedPreferences("header_custom", 0).getString(Api.KEY_USER_UNIQUE_ID, null);
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

    public void saveConfigAfterRegister(SharedPreferences.Editor r3) {
        SharedPreferences.Editor r4 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        String r0 = getAppLanguage();
        String r2 = getAppRegion();
        if (TextUtils.isEmpty(r0) == true) goto L6;
        r4.putString(Api.KEY_APP_LANGUAGE, r0);
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r4.putString(Api.KEY_APP_REGION, r2);
        return;
    }

    void setAccount(Account r1) {
        this.account = r1;
    }

    void setIsMainInstance(boolean r1) {
        this.isMainInstance = r1;
    }
}
