package com.obric.memorydata.middleware.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IBuildTypeFlavor__ServiceProxy implements IServiceProxy<IBuildTypeFlavor> {
    public IBuildTypeFlavor__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.IBuildTypeFlavor", "com.obric.memorydata.BuildTypeFlavor");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IBuildTypeFlavor newInstance() {
        return com.obric.memorydata.BuildTypeFlavor.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IBuildTypeFlavor newInstance() {
        return newInstance();
    }
}
