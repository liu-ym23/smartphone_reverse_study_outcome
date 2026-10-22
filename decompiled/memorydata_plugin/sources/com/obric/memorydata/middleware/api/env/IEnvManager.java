package com.obric.memorydata.middleware.api.env;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\tH&J\b\u0010\u0015\u001a\u00020\tH&J\b\u0010\u0016\u001a\u00020\tH&J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\tH&J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\tH&¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/middleware/api/env/IEnvManager;", "Lcom/bytedance/news/common/service/manager/IService;", "getAdminNetEnv", "Lcom/obric/memorydata/middleware/api/env/NetEnv;", "saveAdminNetEnv", "", "env", "removeEnv", "getAdminTTEnvHeader", "", "saveAdminTTEnvHeader", "header", "getAdminTTFeatureHeader", "saveAdminTTFeatureHeader", "saveAdminWebViewEnvHeader", "saveAdminSaaSLiveEnvHeader", "saveTikTokLiveSdkDistEnvHeader", "saveAbDebugHeader", "", "getAbDebugHeader", "getTikTokLiveSdkDistEnvHeader", "getAdminWebViewEnvHeader", "getAdminSaaSLiveEnvHeader", "applyAdminWebViewEnvHeader", "url", "getRpcResponseEnvHeader", "saveRpcResponseEnvHeader", "getMockCurrentRegion", "saveMockCurrentRegion", "currentRegion", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IEnvManager extends IService {
    String applyAdminWebViewEnvHeader(String r1);

    int getAbDebugHeader();

    NetEnv getAdminNetEnv();

    String getAdminSaaSLiveEnvHeader();

    String getAdminTTEnvHeader();

    String getAdminTTFeatureHeader();

    String getAdminWebViewEnvHeader();

    String getMockCurrentRegion();

    String getRpcResponseEnvHeader();

    String getTikTokLiveSdkDistEnvHeader();

    void removeEnv();

    void saveAbDebugHeader(int r1);

    void saveAdminNetEnv(NetEnv r1);

    void saveAdminSaaSLiveEnvHeader(String r1);

    void saveAdminTTEnvHeader(String r1);

    void saveAdminTTFeatureHeader(String r1);

    void saveAdminWebViewEnvHeader(String r1);

    void saveMockCurrentRegion(String r1);

    void saveRpcResponseEnvHeader(String r1);

    void saveTikTokLiveSdkDistEnvHeader(String r1);
}
