package com.obric.aikernel.isolate.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.isolate.impl.DebugPssCollectImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IDebugPssCollect__ServiceProxy implements IServiceProxy<IDebugPssCollect> {
    public IDebugPssCollect__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.isolate.api.IDebugPssCollect", "com.obric.aikernel.isolate.impl.DebugPssCollectImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IDebugPssCollect newInstance() {
        return DebugPssCollectImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IDebugPssCollect newInstance() {
        return newInstance();
    }
}
