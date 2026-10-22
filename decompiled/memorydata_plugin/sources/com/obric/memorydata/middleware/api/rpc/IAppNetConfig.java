package com.obric.memorydata.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/middleware/api/rpc/IAppNetConfig;", "Lcom/bytedance/news/common/service/manager/IService;", "getBaseUrl", "", "getBaseHost", "getEnvHeaders", "", "url", "getReleaseUrl", "getInterceptors", "", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAppNetConfig extends IService {
    String getBaseHost();

    String getBaseUrl();

    Map<String, String> getEnvHeaders(String r1);

    List<Interceptor> getInterceptors();

    String getReleaseUrl();
}
