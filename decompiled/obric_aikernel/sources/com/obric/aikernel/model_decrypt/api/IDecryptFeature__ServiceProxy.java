package com.obric.aikernel.model_decrypt.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.model_decrypt.impl.DecryptFeatureImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IDecryptFeature__ServiceProxy implements IServiceProxy<IDecryptFeature> {
    public IDecryptFeature__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.model_decrypt.api.IDecryptFeature", "com.obric.aikernel.model_decrypt.impl.DecryptFeatureImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IDecryptFeature newInstance() {
        return DecryptFeatureImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IDecryptFeature newInstance() {
        return newInstance();
    }
}
