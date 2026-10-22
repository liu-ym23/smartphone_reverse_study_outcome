package com.obric.aikernel.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class AppNetConfig implements IAppNetConfig {
    public static final AppNetConfig INSTANCE = null;
    private final /* synthetic */ IAppNetConfig $$delegate_0;

    static {
        INSTANCE = new AppNetConfig();
    }

    private AppNetConfig() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IAppNetConfig.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IAppNetConfig) r10;
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IAppNetConfig
    public String getBaseHost() {
        return this.$$delegate_0.getBaseHost();
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IAppNetConfig
    public String getBaseUrl() {
        return this.$$delegate_0.getBaseUrl();
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IAppNetConfig
    public Map<String, String> getEnvHeaders(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        return this.$$delegate_0.getEnvHeaders(r10);
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IAppNetConfig
    public List<q4.a> getInterceptors() {
        return this.$$delegate_0.getInterceptors();
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IAppNetConfig
    public String getReleaseUrl() {
        return this.$$delegate_0.getReleaseUrl();
    }
}
