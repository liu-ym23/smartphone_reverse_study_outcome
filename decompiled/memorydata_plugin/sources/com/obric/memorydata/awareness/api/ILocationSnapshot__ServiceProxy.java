package com.obric.memorydata.awareness.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ILocationSnapshot__ServiceProxy implements IServiceProxy<ILocationSnapshot> {
    public ILocationSnapshot__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.awareness.api.ILocationSnapshot", "com.obric.memorydata.awareness.LocationSnapshot");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ILocationSnapshot newInstance() {
        return com.obric.memorydata.awareness.LocationSnapshot.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ILocationSnapshot newInstance() {
        return newInstance();
    }
}
