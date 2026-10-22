package com.obric.aikernel.middleware.api.env;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes2.dex */
public interface IEnvManager extends IService {
    String applyAdminWebViewEnvHeader(String r10);

    int getAbDebugHeader();

    NetEnv getAdminNetEnv();

    String getAdminSaaSLiveEnvHeader();

    String getAdminTTEnvHeader();

    String getAdminTTFeatureHeader();

    String getAdminWebViewEnvHeader();

    String getMockCurrentRegion();

    String getRpcResponseEnvHeader();

    String getTikTokLiveSdkDistEnvHeader();

    void saveAbDebugHeader(int r10);

    void saveAdminNetEnv(NetEnv r10);

    void saveAdminSaaSLiveEnvHeader(String r10);

    void saveAdminTTEnvHeader(String r10);

    void saveAdminTTFeatureHeader(String r10);

    void saveAdminWebViewEnvHeader(String r10);

    void saveMockCurrentRegion(String r10);

    void saveRpcResponseEnvHeader(String r10);

    void saveTikTokLiveSdkDistEnvHeader(String r10);
}
