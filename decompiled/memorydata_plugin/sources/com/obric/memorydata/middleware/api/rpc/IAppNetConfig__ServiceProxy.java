package com.obric.memorydata.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.middleware.impl.network.AppNetConfigImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IAppNetConfig__ServiceProxy implements IServiceProxy<IAppNetConfig> {
    public IAppNetConfig__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.rpc.IAppNetConfig", "com.obric.memorydata.middleware.impl.network.AppNetConfigImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAppNetConfig newInstance() {
        return AppNetConfigImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAppNetConfig newInstance() {
        return newInstance();
    }
}
