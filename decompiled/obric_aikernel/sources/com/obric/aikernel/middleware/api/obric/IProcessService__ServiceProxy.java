package com.obric.aikernel.middleware.api.obric;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IProcessService__ServiceProxy implements IServiceProxy<IProcessService> {
    public IProcessService__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.obric.IProcessService", "com.obric.aikernel.middleware.impl.obric.ProcessService");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IProcessService newInstance() {
        return com.obric.aikernel.middleware.impl.obric.ProcessService.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IProcessService newInstance() {
        return newInstance();
    }
}
