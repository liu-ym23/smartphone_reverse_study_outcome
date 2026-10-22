package com.obric.memorydata.middleware.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.middleware.impl.DataInterceptorImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IDataInterceptor__ServiceProxy implements IServiceProxy<IDataInterceptor> {
    public IDataInterceptor__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.IDataInterceptor", "com.obric.memorydata.middleware.impl.DataInterceptorImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IDataInterceptor newInstance() {
        return DataInterceptorImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IDataInterceptor newInstance() {
        return newInstance();
    }
}
