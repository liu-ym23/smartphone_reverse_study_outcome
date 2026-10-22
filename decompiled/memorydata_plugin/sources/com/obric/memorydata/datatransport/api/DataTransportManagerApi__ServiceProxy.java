package com.obric.memorydata.datatransport.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.datatransport.impl.DataTransportManagerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class DataTransportManagerApi__ServiceProxy implements IServiceProxy<DataTransportManagerApi> {
    public DataTransportManagerApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.datatransport.api.DataTransportManagerApi", "com.obric.memorydata.datatransport.impl.DataTransportManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public DataTransportManagerApi newInstance() {
        return DataTransportManagerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ DataTransportManagerApi newInstance() {
        return newInstance();
    }
}
