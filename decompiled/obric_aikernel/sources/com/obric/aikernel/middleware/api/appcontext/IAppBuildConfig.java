package com.obric.aikernel.middleware.api.appcontext;

import com.bytedance.news.common.service.manager.IService;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IAppBuildConfig extends IAppConfig, IService {
    String appEnv();

    String defaultTTEnvHeader();

    String defaultWebEnvHeader();

    /* synthetic */ String getAIKBizType();

    /* synthetic */ String getAIKTargetSoC();

    /* synthetic */ int getAid();

    /* synthetic */ String getAppName();

    String getAppTrackerTag();

    String getBuildInfo();

    String getChannel();

    /* synthetic */ String getDistributePath();

    /* synthetic */ String getHost(IAppConfig.HOST_TYPE r10);

    /* synthetic */ String getModelDistPath();

    /* synthetic */ Map<String, Object> getSlardarExtras();

    int getUpdateVersionCode();

    /* synthetic */ int getVersionCode();

    /* synthetic */ String getVersionName();

    boolean isAdminMode();

    /* synthetic */ boolean isDebug();

    /* synthetic */ boolean isGlobalVersion();

    /* synthetic */ boolean testStubApp();
}
