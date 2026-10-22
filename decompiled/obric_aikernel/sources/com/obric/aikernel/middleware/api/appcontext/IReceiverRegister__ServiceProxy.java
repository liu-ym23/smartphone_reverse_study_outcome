package com.obric.aikernel.middleware.api.appcontext;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.middleware.impl.appcontext.ReceiverRegisterImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IReceiverRegister__ServiceProxy implements IServiceProxy<IReceiverRegister> {
    public IReceiverRegister__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.appcontext.IReceiverRegister", "com.obric.aikernel.middleware.impl.appcontext.ReceiverRegisterImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IReceiverRegister newInstance() {
        return ReceiverRegisterImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IReceiverRegister newInstance() {
        return newInstance();
    }
}
