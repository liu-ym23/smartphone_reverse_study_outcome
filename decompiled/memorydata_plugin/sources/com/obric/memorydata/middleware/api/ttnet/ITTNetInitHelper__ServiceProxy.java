package com.obric.memorydata.middleware.api.ttnet;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ITTNetInitHelper__ServiceProxy implements IServiceProxy<ITTNetInitHelper> {
    public ITTNetInitHelper__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.ttnet.ITTNetInitHelper", "com.obric.memorydata.middleware.impl.ttnet.TTNetInitHelper");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ITTNetInitHelper newInstance() {
        return new com.obric.memorydata.middleware.impl.ttnet.TTNetInitHelper();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ITTNetInitHelper newInstance() {
        return newInstance();
    }
}
