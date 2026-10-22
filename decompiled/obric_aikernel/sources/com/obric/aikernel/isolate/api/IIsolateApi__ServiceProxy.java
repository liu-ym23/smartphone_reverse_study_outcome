package com.obric.aikernel.isolate.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.isolate.impl.IsolateImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IIsolateApi__ServiceProxy implements IServiceProxy<IIsolateApi> {
    public IIsolateApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.isolate.api.IIsolateApi", "com.obric.aikernel.isolate.impl.IsolateImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IIsolateApi newInstance() {
        return IsolateImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IIsolateApi newInstance() {
        return newInstance();
    }
}
