package com.obric.aikernel.model_decrypt.api.filemeta;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.model_decrypt.impl.filemeta.ModelFileMetaDataManagerImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IModelFileMetaDataManager__ServiceProxy implements IServiceProxy<IModelFileMetaDataManager> {
    public IModelFileMetaDataManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager", "com.obric.aikernel.model_decrypt.impl.filemeta.ModelFileMetaDataManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IModelFileMetaDataManager newInstance() {
        return ModelFileMetaDataManagerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IModelFileMetaDataManager newInstance() {
        return newInstance();
    }
}
