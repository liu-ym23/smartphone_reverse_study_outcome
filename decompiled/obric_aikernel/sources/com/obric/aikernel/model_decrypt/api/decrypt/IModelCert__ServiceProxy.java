package com.obric.aikernel.model_decrypt.api.decrypt;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.model_decrypt.impl.decrypt.ModelCertImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IModelCert__ServiceProxy implements IServiceProxy<IModelCert> {
    public IModelCert__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.model_decrypt.api.decrypt.IModelCert", "com.obric.aikernel.model_decrypt.impl.decrypt.ModelCertImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IModelCert newInstance() {
        return ModelCertImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IModelCert newInstance() {
        return newInstance();
    }
}
