package com.obric.aikernel;

import com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig;
import com.obric.aikernel.middleware.api.appcontext.IAppConfig;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class AppBuildConfigImpl implements IAppBuildConfig {
    public static final AppBuildConfigImpl INSTANCE = null;
    private final /* synthetic */ BaseAppBuildConfigImpl $$delegate_0;

    static {
        INSTANCE = new AppBuildConfigImpl();
    }

    private AppBuildConfigImpl() {
        this.$$delegate_0 = BaseAppBuildConfigImpl.INSTANCE;
    }

    @JvmStatic
    public static final AppBuildConfigImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String appEnv() {
        return this.$$delegate_0.appEnv();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String defaultTTEnvHeader() {
        return this.$$delegate_0.defaultTTEnvHeader();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String defaultWebEnvHeader() {
        return this.$$delegate_0.defaultWebEnvHeader();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getAIKBizType() {
        return this.$$delegate_0.getAIKBizType();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getAIKTargetSoC() {
        return this.$$delegate_0.getAIKTargetSoC();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public int getAid() {
        return this.$$delegate_0.getAid();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getAppName() {
        return this.$$delegate_0.getAppName();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getAppTrackerTag() {
        return this.$$delegate_0.getAppTrackerTag();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getBuildInfo() {
        return this.$$delegate_0.getBuildInfo();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getChannel() {
        return this.$$delegate_0.getChannel();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getDistributePath() {
        return this.$$delegate_0.getDistributePath();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getHost(IAppConfig.HOST_TYPE r10) {
        Intrinsics.checkNotNullParameter(r10, "hostType");
        return this.$$delegate_0.getHost(r10);
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getModelDistPath() {
        return this.$$delegate_0.getModelDistPath();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public Map<String, Object> getSlardarExtras() {
        return this.$$delegate_0.getSlardarExtras();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public int getUpdateVersionCode() {
        return this.$$delegate_0.getUpdateVersionCode();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public int getVersionCode() {
        return this.$$delegate_0.getVersionCode();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getVersionName() {
        return this.$$delegate_0.getVersionName();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public boolean isAdminMode() {
        return this.$$delegate_0.isAdminMode();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public boolean isDebug() {
        return this.$$delegate_0.isDebug();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public boolean isGlobalVersion() {
        return this.$$delegate_0.isGlobalVersion();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public boolean testStubApp() {
        return this.$$delegate_0.testStubApp();
    }
}
