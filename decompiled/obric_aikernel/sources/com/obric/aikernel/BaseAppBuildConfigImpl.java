package com.obric.aikernel;

import com.obric.aikernel.middleware.api.appcontext.IAppConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class BaseAppBuildConfigImpl implements BaseAppBuildConfig {
    public static final BaseAppBuildConfigImpl INSTANCE = null;

    static {
        INSTANCE = new BaseAppBuildConfigImpl();
    }

    private BaseAppBuildConfigImpl() {
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String appEnv() {
        return BaseAppBuildConfig.a.a(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String defaultTTEnvHeader() {
        return BaseAppBuildConfig.a.b(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String defaultWebEnvHeader() {
        return BaseAppBuildConfig.a.c(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getAIKBizType() {
        return BaseAppBuildConfig.a.d(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getAIKTargetSoC() {
        return BaseAppBuildConfig.a.e(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public int getAid() {
        return BaseAppBuildConfig.a.f(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getAppName() {
        return BaseAppBuildConfig.a.g(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getAppTrackerTag() {
        return BaseAppBuildConfig.a.h(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getBuildInfo() {
        return BaseAppBuildConfig.a.i(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getChannel() {
        return BaseAppBuildConfig.a.j(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getDistributePath() {
        return BaseAppBuildConfig.a.l(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getHost(IAppConfig.HOST_TYPE r10) {
        return BaseAppBuildConfig.a.m(this, r10);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getModelDistPath() {
        return BaseAppBuildConfig.a.n(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public Map<String, Object> getSlardarExtras() {
        return BaseAppBuildConfig.a.o(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public int getUpdateVersionCode() {
        return BaseAppBuildConfig.a.p(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public int getVersionCode() {
        return BaseAppBuildConfig.a.q(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public String getVersionName() {
        return BaseAppBuildConfig.a.r(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public boolean isAdminMode() {
        return BaseAppBuildConfig.a.s(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public boolean isDebug() {
        return BaseAppBuildConfig.a.t(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public boolean isGlobalVersion() {
        return BaseAppBuildConfig.a.u(this);
    }

    @Override // com.obric.aikernel.BaseAppBuildConfig, com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig
    public boolean testStubApp() {
        return BaseAppBuildConfig.a.v(this);
    }
}
