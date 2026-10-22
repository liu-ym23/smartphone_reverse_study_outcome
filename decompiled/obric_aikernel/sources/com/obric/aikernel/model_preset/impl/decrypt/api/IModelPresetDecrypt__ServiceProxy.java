package com.obric.aikernel.model_preset.impl.decrypt.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IModelPresetDecrypt__ServiceProxy implements IServiceProxy<IModelPresetDecrypt> {
    public IModelPresetDecrypt__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.model_preset.impl.decrypt.api.IModelPresetDecrypt", "com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IModelPresetDecrypt newInstance() {
        return PresetModelDecryptImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IModelPresetDecrypt newInstance() {
        return newInstance();
    }
}
