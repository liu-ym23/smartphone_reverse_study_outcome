package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.union.build.UnionMemoryBuildBridgeAPIImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IUnionMemoryBuildBridgeAPI__ServiceProxy implements IServiceProxy<IUnionMemoryBuildBridgeAPI> {
    public IUnionMemoryBuildBridgeAPI__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI", "com.obric.memorydata.union.build.UnionMemoryBuildBridgeAPIImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IUnionMemoryBuildBridgeAPI newInstance() {
        return UnionMemoryBuildBridgeAPIImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IUnionMemoryBuildBridgeAPI newInstance() {
        return newInstance();
    }
}
