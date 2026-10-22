package com.obric.aikernel.middleware.api.env;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.middleware.impl.env.EnvManagerImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IEnvManager__ServiceProxy implements IServiceProxy<IEnvManager> {
    public IEnvManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.env.IEnvManager", "com.obric.aikernel.middleware.impl.env.EnvManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IEnvManager newInstance() {
        return EnvManagerImpl.getInstance();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IEnvManager newInstance() {
        return newInstance();
    }
}
