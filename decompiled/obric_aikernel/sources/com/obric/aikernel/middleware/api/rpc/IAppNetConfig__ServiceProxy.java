package com.obric.aikernel.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.middleware.impl.network.AppNetConfigImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IAppNetConfig__ServiceProxy implements IServiceProxy<IAppNetConfig> {
    public IAppNetConfig__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.rpc.IAppNetConfig", "com.obric.aikernel.middleware.impl.network.AppNetConfigImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAppNetConfig newInstance() {
        return AppNetConfigImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAppNetConfig newInstance() {
        return newInstance();
    }
}
