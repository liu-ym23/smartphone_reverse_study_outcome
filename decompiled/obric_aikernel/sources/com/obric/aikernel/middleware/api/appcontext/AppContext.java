package com.obric.aikernel.middleware.api.appcontext;

import android.app.Application;
import android.content.Context;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.IService;
import d4.a;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class AppContext implements IAppContext {
    public static final AppContext INSTANCE = null;
    private final /* synthetic */ IAppContext $$delegate_0;

    static {
        INSTANCE = new AppContext();
    }

    private AppContext() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IAppContext.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IAppContext) r10;
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String appEnv() {
        return this.$$delegate_0.appEnv();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public void cacheDispatchThreadTid(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        this.$$delegate_0.cacheDispatchThreadTid(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String defaultTTEnvHeader() {
        return this.$$delegate_0.defaultTTEnvHeader();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String defaultWebEnvHeader() {
        return this.$$delegate_0.defaultWebEnvHeader();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getAIKBizType() {
        return this.$$delegate_0.getAIKBizType();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getAIKTargetSoC() {
        return this.$$delegate_0.getAIKTargetSoC();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public int getAid() {
        return this.$$delegate_0.getAid();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public t7.a getAikStore() {
        return this.$$delegate_0.getAikStore();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public int getAndroidUserId() {
        return this.$$delegate_0.getAndroidUserId();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getAppName() {
        return this.$$delegate_0.getAppName();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public long getAppStartTime() {
        return this.$$delegate_0.getAppStartTime();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getAppTrackerTag() {
        return this.$$delegate_0.getAppTrackerTag();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public Application getApplication() {
        return this.$$delegate_0.getApplication();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getBuildInfo() {
        return this.$$delegate_0.getBuildInfo();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getChannel() {
        return this.$$delegate_0.getChannel();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public Context getContext() {
        return this.$$delegate_0.getContext();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public Map<String, Long> getDispatchThreadTidSnapshot() {
        return this.$$delegate_0.getDispatchThreadTidSnapshot();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getDistributePath() {
        return this.$$delegate_0.getDistributePath();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getHost(IAppConfig.HOST_TYPE r10) {
        Intrinsics.checkNotNullParameter(r10, "hostType");
        return this.$$delegate_0.getHost(r10);
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getIid() {
        return this.$$delegate_0.getIid();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getModelDistPath() {
        return this.$$delegate_0.getModelDistPath();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getPackageName() {
        return this.$$delegate_0.getPackageName();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public int getPid() {
        return this.$$delegate_0.getPid();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getServerDeviceId() {
        return this.$$delegate_0.getServerDeviceId();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public Map<String, Object> getSlardarExtras() {
        return this.$$delegate_0.getSlardarExtras();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public int getUpdateVersionCode() {
        return this.$$delegate_0.getUpdateVersionCode();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getUserId() {
        return this.$$delegate_0.getUserId();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public int getVersionCode() {
        return this.$$delegate_0.getVersionCode();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getVersionName() {
        return this.$$delegate_0.getVersionName();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean isAdminMode() {
        return this.$$delegate_0.isAdminMode();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean isDebug() {
        return this.$$delegate_0.isDebug();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean isFirstColdBoot() {
        return this.$$delegate_0.isFirstColdBoot();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean isGlobalVersion() {
        return this.$$delegate_0.isGlobalVersion();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean isLocalTest() {
        return this.$$delegate_0.isLocalTest();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public void postRestart(String r10, String r11, long r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "reason");
        this.$$delegate_0.postRestart(r10, r11, r12, r13);
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public void setApplicationContext(Application r10, Context r11) {
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r11, "context");
        this.$$delegate_0.setApplicationContext(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean testStubApp() {
        return this.$$delegate_0.testStubApp();
    }
}
