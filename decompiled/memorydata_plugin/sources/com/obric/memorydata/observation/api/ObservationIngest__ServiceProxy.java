package com.obric.memorydata.observation.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.observation.impl.ObservationIngestImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ObservationIngest__ServiceProxy implements IServiceProxy<ObservationIngest> {
    public ObservationIngest__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.observation.api.ObservationIngest", "com.obric.memorydata.observation.impl.ObservationIngestImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ObservationIngest newInstance() {
        return ObservationIngestImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ObservationIngest newInstance() {
        return newInstance();
    }
}
