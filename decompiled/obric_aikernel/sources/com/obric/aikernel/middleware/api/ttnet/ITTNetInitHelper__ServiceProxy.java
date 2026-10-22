package com.obric.aikernel.middleware.api.ttnet;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ITTNetInitHelper__ServiceProxy implements IServiceProxy<ITTNetInitHelper> {
    public ITTNetInitHelper__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.ttnet.ITTNetInitHelper", "com.obric.aikernel.middleware.impl.ttnet.TTNetInitHelper");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ITTNetInitHelper newInstance() {
        return new com.obric.aikernel.middleware.impl.ttnet.TTNetInitHelper();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ITTNetInitHelper newInstance() {
        return newInstance();
    }
}
