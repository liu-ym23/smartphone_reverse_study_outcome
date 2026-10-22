package com.obric.memorydata.awareness.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class IAwarenessManager__ServiceProxy implements IServiceProxy<IAwarenessManager> {
    public IAwarenessManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.awareness.api.IAwarenessManager", "com.obric.memorydata.awareness.impl.AwarenessManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAwarenessManager newInstance() {
        return AwarenessManagerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAwarenessManager newInstance() {
        return newInstance();
    }
}
