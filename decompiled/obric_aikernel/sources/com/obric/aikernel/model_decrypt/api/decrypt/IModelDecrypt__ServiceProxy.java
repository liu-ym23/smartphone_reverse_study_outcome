package com.obric.aikernel.model_decrypt.api.decrypt;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.model_decrypt.impl.decrypt.ModelEncryptImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IModelDecrypt__ServiceProxy implements IServiceProxy<IModelDecrypt> {
    public IModelDecrypt__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt", "com.obric.aikernel.model_decrypt.impl.decrypt.ModelEncryptImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IModelDecrypt newInstance() {
        return ModelEncryptImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IModelDecrypt newInstance() {
        return newInstance();
    }
}
