package com.obric.memorydata.middleware.api.store;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.middleware.impl.store.keva.StoreManagerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IStoreManager__ServiceProxy implements IServiceProxy<IStoreManager> {
    public IStoreManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.store.IStoreManager", "com.obric.memorydata.middleware.impl.store.keva.StoreManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IStoreManager newInstance() {
        return StoreManagerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IStoreManager newInstance() {
        return newInstance();
    }
}
