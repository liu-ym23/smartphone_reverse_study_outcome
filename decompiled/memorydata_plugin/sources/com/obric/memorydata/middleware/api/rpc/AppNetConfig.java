package com.obric.memorydata.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u0005H\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/middleware/api/rpc/AppNetConfig;", "Lcom/obric/memorydata/middleware/api/rpc/IAppNetConfig;", "<init>", "()V", "getBaseHost", "", "getBaseUrl", "getEnvHeaders", "", "url", "getInterceptors", "", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "getReleaseUrl", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppNetConfig implements IAppNetConfig {
    public static final AppNetConfig INSTANCE = null;
    private final /* synthetic */ IAppNetConfig $$delegate_0;

    static {
        INSTANCE = new AppNetConfig();
    }

    private AppNetConfig() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IAppNetConfig.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IAppNetConfig) ZeusTransformUtils.preCheckCast(r0, IAppNetConfig.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IAppNetConfig
    public String getBaseHost() {
        return this.$$delegate_0.getBaseHost();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IAppNetConfig
    public String getBaseUrl() {
        return this.$$delegate_0.getBaseUrl();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IAppNetConfig
    public Map<String, String> getEnvHeaders(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        return this.$$delegate_0.getEnvHeaders(r2);
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IAppNetConfig
    public List<Interceptor> getInterceptors() {
        return this.$$delegate_0.getInterceptors();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IAppNetConfig
    public String getReleaseUrl() {
        return this.$$delegate_0.getReleaseUrl();
    }
}
