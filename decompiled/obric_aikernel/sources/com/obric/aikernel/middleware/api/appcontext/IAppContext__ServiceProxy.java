package com.obric.aikernel.middleware.api.appcontext;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.middleware.impl.appcontext.AppContextImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IAppContext__ServiceProxy implements IServiceProxy<IAppContext> {
    public IAppContext__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.appcontext.IAppContext", "com.obric.aikernel.middleware.impl.appcontext.AppContextImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAppContext newInstance() {
        return AppContextImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAppContext newInstance() {
        return newInstance();
    }
}
