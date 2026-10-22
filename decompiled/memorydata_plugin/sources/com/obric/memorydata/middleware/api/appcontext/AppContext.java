package com.obric.memorydata.middleware.api.appcontext;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\rH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u0096\u0001J!\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010!H\u0096\u0001J\t\u0010\"\u001a\u00020\u0005H\u0096\u0001J\t\u0010#\u001a\u00020\rH\u0096\u0001J\t\u0010$\u001a\u00020\u0005H\u0096\u0001J\t\u0010%\u001a\u00020\u0005H\u0096\u0001J\t\u0010&\u001a\u00020\u0005H\u0096\u0001J\t\u0010'\u001a\u00020\u0005H\u0096\u0001J\t\u0010(\u001a\u00020\u0005H\u0096\u0001J\t\u0010)\u001a\u00020\u0005H\u0096\u0001J\t\u0010*\u001a\u00020\u0005H\u0096\u0001J\u0015\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020-0,H\u0096\u0001J\t\u0010.\u001a\u00020\u0005H\u0096\u0001J\t\u0010/\u001a\u00020\rH\u0096\u0001J\t\u00100\u001a\u00020\u0005H\u0096\u0001J\t\u00101\u001a\u00020\u0005H\u0096\u0001J\t\u00102\u001a\u00020\rH\u0096\u0001J\t\u00103\u001a\u00020\u0005H\u0096\u0001J\t\u00104\u001a\u00020\u000bH\u0096\u0001J\t\u00105\u001a\u00020\u000bH\u0096\u0001J\t\u00106\u001a\u00020\u000bH\u0096\u0001J\t\u00107\u001a\u00020\u000bH\u0096\u0001J\t\u00108\u001a\u00020\u000bH\u0096\u0001J\t\u00109\u001a\u00020\u000bH\u0096\u0001J\t\u0010:\u001a\u00020\u000bH\u0096\u0001J\t\u0010;\u001a\u00020\u000bH\u0096\u0001J\t\u0010<\u001a\u00020\u000bH\u0096\u0001J\t\u0010=\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u0017H\u0096\u0001R\u001a\u0010A\u001a\u0004\u0018\u00010BX\u0096\u000f¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcom/obric/memorydata/middleware/api/appcontext/AppContext;", "Lcom/obric/memorydata/middleware/api/appcontext/IAppContext;", "<init>", "()V", "appEnv", "", "defaultTTEnvHeader", "defaultWebEnvHeader", "enableDebug", "", "debuggable", "", "getAid", "", "getApkId", "", "getAppName", "getAppTrackerTag", "getApplication", "Landroid/app/Application;", "getBuildInfo", "getChannel", "getContext", "Landroid/content/Context;", "getFlavor", "getHost", "hostType", "Lcom/obric/memorydata/middleware/api/appcontext/IAppConfig$HOST_TYPE;", "getHostPkgName", "getIid", "getLanguage", "getOsDeviceId", "onDidUpdated", "Lkotlin/Function1;", "getPackageName", "getPid", "getPluginPkgName", "getPluginVersionName", "getPuiVersion", "getRegion", "getRomVersion", "getSecurityAid", "getServerDeviceId", "getSlardarExtras", "", "", "getToken", "getUpdateVersionCode", "getUserId", "getUserName", "getVersionCode", "getVersionName", "isAdminMode", "isAllLogEnabled", "isDebug", "isHostApp", "isLocalTest", "isLogin", "isObricFlavor", "isPureAndroid", "isRoot", "isSsFlavor", "setApplicationContext", "application", "context", "topActivity", "Landroid/app/Activity;", "getTopActivity", "()Landroid/app/Activity;", "setTopActivity", "(Landroid/app/Activity;)V", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppContext implements IAppContext {
    public static final AppContext INSTANCE = null;
    private final /* synthetic */ IAppContext $$delegate_0;

    static {
        INSTANCE = new AppContext();
    }

    private AppContext() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IAppContext.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IAppContext) ZeusTransformUtils.preCheckCast(r0, IAppContext.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String appEnv() {
        return this.$$delegate_0.appEnv();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String defaultTTEnvHeader() {
        return this.$$delegate_0.defaultTTEnvHeader();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String defaultWebEnvHeader() {
        return this.$$delegate_0.defaultWebEnvHeader();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public void enableDebug(boolean r1) {
        this.$$delegate_0.enableDebug(r1);
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public int getAid() {
        return this.$$delegate_0.getAid();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public long getApkId() {
        return this.$$delegate_0.getApkId();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getAppName() {
        return this.$$delegate_0.getAppName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getAppTrackerTag() {
        return this.$$delegate_0.getAppTrackerTag();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public Application getApplication() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.$$delegate_0.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getBuildInfo() {
        return this.$$delegate_0.getBuildInfo();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getChannel() {
        return this.$$delegate_0.getChannel();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.$$delegate_0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getFlavor() {
        return this.$$delegate_0.getFlavor();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getHost(IAppConfig.HOST_TYPE r2) {
        Intrinsics.checkNotNullParameter(r2, "hostType");
        return this.$$delegate_0.getHost(r2);
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getHostPkgName() {
        return this.$$delegate_0.getHostPkgName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getIid() {
        return this.$$delegate_0.getIid();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getLanguage() {
        return this.$$delegate_0.getLanguage();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getOsDeviceId(Function1<? super String, Unit> r3) {
        Function1<? super String, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        return this.$$delegate_0.getOsDeviceId(r4);
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getPackageName() {
        return this.$$delegate_0.getPackageName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public int getPid() {
        return this.$$delegate_0.getPid();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getPluginPkgName() {
        return this.$$delegate_0.getPluginPkgName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getPluginVersionName() {
        return this.$$delegate_0.getPluginVersionName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getPuiVersion() {
        return this.$$delegate_0.getPuiVersion();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getRegion() {
        return this.$$delegate_0.getRegion();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getRomVersion() {
        return this.$$delegate_0.getRomVersion();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getSecurityAid() {
        return this.$$delegate_0.getSecurityAid();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getServerDeviceId() {
        return this.$$delegate_0.getServerDeviceId();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public Map<String, Object> getSlardarExtras() {
        return this.$$delegate_0.getSlardarExtras();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getToken() {
        return this.$$delegate_0.getToken();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public Activity getTopActivity() {
        return (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.$$delegate_0.getTopActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public int getUpdateVersionCode() {
        return this.$$delegate_0.getUpdateVersionCode();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getUserId() {
        return this.$$delegate_0.getUserId();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getUserName() {
        return this.$$delegate_0.getUserName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public int getVersionCode() {
        return this.$$delegate_0.getVersionCode();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getVersionName() {
        return this.$$delegate_0.getVersionName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isAdminMode() {
        return this.$$delegate_0.isAdminMode();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isAllLogEnabled() {
        return this.$$delegate_0.isAllLogEnabled();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isDebug() {
        return this.$$delegate_0.isDebug();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isHostApp() {
        return this.$$delegate_0.isHostApp();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isLocalTest() {
        return this.$$delegate_0.isLocalTest();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isLogin() {
        return this.$$delegate_0.isLogin();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isObricFlavor() {
        return this.$$delegate_0.isObricFlavor();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isPureAndroid() {
        return this.$$delegate_0.isPureAndroid();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isRoot() {
        return this.$$delegate_0.isRoot();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isSsFlavor() {
        return this.$$delegate_0.isSsFlavor();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public void setApplicationContext(Application r3, Context r4) {
        Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "application");
        Intrinsics.checkNotNullParameter(r6, "context");
        this.$$delegate_0.setApplicationContext(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public void setTopActivity(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        this.$$delegate_0.setTopActivity(r4);
    }
}
