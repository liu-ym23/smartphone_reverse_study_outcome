package com.obric.memorydata.thirdparty.api.location;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.thirdparty.impl.location.LocationManagerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ILocationManager__ServiceProxy implements IServiceProxy<ILocationManager> {
    public ILocationManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.thirdparty.api.location.ILocationManager", "com.obric.memorydata.thirdparty.impl.location.LocationManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ILocationManager newInstance() {
        return LocationManagerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ILocationManager newInstance() {
        return newInstance();
    }
}
