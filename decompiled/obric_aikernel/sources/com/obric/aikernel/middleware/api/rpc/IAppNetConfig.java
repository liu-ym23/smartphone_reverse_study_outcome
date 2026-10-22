package com.obric.aikernel.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import java.util.Map;
import q4.a;

/* JADX INFO: loaded from: classes2.dex */
public interface IAppNetConfig extends IService {
    String getBaseHost();

    String getBaseUrl();

    Map<String, String> getEnvHeaders(String r10);

    List<a> getInterceptors();

    String getReleaseUrl();
}
