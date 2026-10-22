package com.obric.aikernel.middleware.api.log;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.middleware.impl.log.LogImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ILog__ServiceProxy implements IServiceProxy<ILog> {
    public ILog__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.log.ILog", "com.obric.aikernel.middleware.impl.log.LogImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ILog newInstance() {
        return LogImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ILog newInstance() {
        return newInstance();
    }
}
