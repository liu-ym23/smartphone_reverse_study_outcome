package com.obric.aikernel.middleware.api.store;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.middleware.impl.store.keva.StoreManagerImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IStoreManager__ServiceProxy implements IServiceProxy<IStoreManager> {
    public IStoreManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.store.IStoreManager", "com.obric.aikernel.middleware.impl.store.keva.StoreManagerImpl");
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
