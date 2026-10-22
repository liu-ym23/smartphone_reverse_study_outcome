package com.obric.aikernel.obric_os_feature.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.obric_os_feature.impl.ModelPowerPerfManagerImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IModelPowerPerfManager__ServiceProxy implements IServiceProxy<IModelPowerPerfManager> {
    public IModelPowerPerfManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.obric_os_feature.api.IModelPowerPerfManager", "com.obric.aikernel.obric_os_feature.impl.ModelPowerPerfManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IModelPowerPerfManager newInstance() {
        return ModelPowerPerfManagerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IModelPowerPerfManager newInstance() {
        return newInstance();
    }
}
