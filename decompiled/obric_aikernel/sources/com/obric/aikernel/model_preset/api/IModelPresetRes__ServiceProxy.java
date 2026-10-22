package com.obric.aikernel.model_preset.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.model_preset.impl.preset_res.ModelPresetResImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IModelPresetRes__ServiceProxy implements IServiceProxy<IModelPresetRes> {
    public IModelPresetRes__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.model_preset.api.IModelPresetRes", "com.obric.aikernel.model_preset.impl.preset_res.ModelPresetResImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IModelPresetRes newInstance() {
        return ModelPresetResImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IModelPresetRes newInstance() {
        return newInstance();
    }
}
