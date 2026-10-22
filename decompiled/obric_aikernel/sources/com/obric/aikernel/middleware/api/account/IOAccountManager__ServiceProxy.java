package com.obric.aikernel.middleware.api.account;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IOAccountManager__ServiceProxy implements IServiceProxy<IOAccountManager> {
    public IOAccountManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.account.IOAccountManager", "com.obric.aikernel.middleware.impl.account.OAccountInitManager");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IOAccountManager newInstance() {
        return com.obric.aikernel.middleware.impl.account.OAccountInitManager.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IOAccountManager newInstance() {
        return newInstance();
    }
}
