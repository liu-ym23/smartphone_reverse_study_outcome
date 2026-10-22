package com.obric.memorydata;

import com.bytedance.crash.util.RomUtils;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.appcontext.IAppBuildConfig;
import com.obric.memorydata.middleware.api.appcontext.IAppConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0000H\u0007J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\u0014\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0-H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0012\u0010\u000f¨\u0006/"}, d2 = {"Lcom/obric/memorydata/AppBuildConfigImpl;", "Lcom/obric/memorydata/middleware/api/appcontext/IAppBuildConfig;", "<init>", "()V", "TAG", "", "doubaoChannel", "versionNameCache", "getVersionNameCache", "()Ljava/lang/String;", "versionNameCache$delegate", "Lkotlin/Lazy;", "versionCodeCache", "", "getVersionCodeCache", "()I", "versionCodeCache$delegate", "updateVersionCodeCache", "getUpdateVersionCodeCache", "updateVersionCodeCache$delegate", "getInst", "getVersionCode", "getVersionName", "getPluginVersionName", "getChannel", "getPluginPkgName", "getHostPkgName", "getUpdateVersionCode", "isDebug", "", "isAdminMode", "getAid", "getApkId", "", "getHost", "hostType", "Lcom/obric/memorydata/middleware/api/appcontext/IAppConfig$HOST_TYPE;", "getAppName", "getBuildInfo", "appEnv", "defaultTTEnvHeader", "defaultWebEnvHeader", "getAppTrackerTag", "isHostApp", "getSlardarExtras", "", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppBuildConfigImpl implements IAppBuildConfig {
    public static final AppBuildConfigImpl INSTANCE = null;
    private static final String TAG = "AppBuildConfigImpl";
    private static String doubaoChannel;
    private static final Lazy updateVersionCodeCache$delegate = null;
    private static final Lazy versionCodeCache$delegate = null;
    private static final Lazy versionNameCache$delegate = null;

    static {
        INSTANCE = new AppBuildConfigImpl();
        versionNameCache$delegate = LazyKt.lazy($$Lambda$AppBuildConfigImpl$vObd2tOvOgZnRtess2IGp9L514.INSTANCE);
        versionCodeCache$delegate = LazyKt.lazy($$Lambda$AppBuildConfigImpl$OIMu1Iqd9DwnYANAFLvZkHVX3Qc.INSTANCE);
        updateVersionCodeCache$delegate = LazyKt.lazy($$Lambda$AppBuildConfigImpl$4rlnQm4ZLyc3MDMhtQX96Tg0HfI.INSTANCE);
    }

    private AppBuildConfigImpl() {
    }

    @JvmStatic
    public static final AppBuildConfigImpl getInst() {
        return INSTANCE;
    }

    private final int getUpdateVersionCodeCache() {
        return ((Number) ZeusTransformUtils.preCheckCast(updateVersionCodeCache$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final int getVersionCodeCache() {
        return ((Number) ZeusTransformUtils.preCheckCast(versionCodeCache$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final String getVersionNameCache() {
        return (String) ZeusTransformUtils.preCheckCast(versionNameCache$delegate.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ int lambda$4rlnQm4ZLyc3MDMhtQX96Tg0HfI() {
        return updateVersionCodeCache_delegate$lambda$2();
    }

    public static /* synthetic */ int lambda$OIMu1Iqd9DwnYANAFLvZkHVX3Qc() {
        return versionCodeCache_delegate$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$vObd2tOvOgZnRt-ess2IGp9L514, reason: not valid java name */
    public static /* synthetic */ String m427lambda$vObd2tOvOgZnRtess2IGp9L514() {
        return versionNameCache_delegate$lambda$0();
    }

    private static final int updateVersionCodeCache_delegate$lambda$2() {
        return SharedState.INSTANCE.getInt("doubao_update_version_code", BuildConfig.UPDATE_VERSION_CODE);
    }

    private static final int versionCodeCache_delegate$lambda$1() {
        return SharedState.INSTANCE.getInt("doubao_version_code", BuildConfig.VERSION_CODE);
    }

    private static final String versionNameCache_delegate$lambda$0() {
        SharedState r0 = SharedState.INSTANCE;
        String r1 = BuildConfig.VERSION_NAME;
        Intrinsics.checkNotNullExpressionValue(r1, "VERSION_NAME");
        return r0.getString("doubao_version_name", r1);
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppBuildConfig, com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String appEnv() {
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppBuildConfig, com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String defaultTTEnvHeader() {
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppBuildConfig, com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String defaultWebEnvHeader() {
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public int getAid() {
        return BuildConfig.APP_ID;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public long getApkId() {
        return -1;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getAppName() {
        return "memorydata";
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppBuildConfig, com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getAppTrackerTag() {
        return AppContext.INSTANCE.getPackageName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppBuildConfig, com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getBuildInfo() {
        return BuildConfig.BUILD_INFO;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getChannel() {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(doubaoChannel, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        doubaoChannel = SharedState.INSTANCE.getString("doubao_channel", "");
    L11:
        String r7 = doubaoChannel;
        if (r7 != null) goto L14;
    L19:
        if (r0 == false) goto L22;
        String r8 = doubaoChannel;
        Intrinsics.checkNotNull(r8);
        return r8;
    L22:
        return BuildConfig.CHANNEL;
    L14:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 != true) goto L19;
        r0 = true;
        goto L19
    L16:
        r9 = false;
        goto L17
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getHost(IAppConfig.HOST_TYPE r1) {
        Intrinsics.checkNotNullParameter(r1, "hostType");
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getHostPkgName() {
        return AppContext.INSTANCE.getPackageName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getPluginPkgName() {
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getPluginVersionName() {
        String r1 = BuildConfig.VERSION_NAME;
        Intrinsics.checkNotNullExpressionValue(r1, "VERSION_NAME");
        return r1;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public Map<String, Object> getSlardarExtras() {
        Map<String, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r0.put("build_info", getBuildInfo());
        r0.put("rom_version", RomUtils.getSystemProperty("ro.os.ota.version"));
        r0.put("rom_build_time", RomUtils.getSystemProperty("ro.build.date"));
        return r0;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppBuildConfig, com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public int getUpdateVersionCode() {
        return getUpdateVersionCodeCache();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public int getVersionCode() {
        return getVersionCodeCache();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getVersionName() {
        return getVersionNameCache();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppBuildConfig, com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isAdminMode() {
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isDebug() {
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppBuildConfig, com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isHostApp() {
        return true;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppBuildConfig, com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isPureAndroid() {
        return IAppBuildConfig.a.a(this);
    }
}
