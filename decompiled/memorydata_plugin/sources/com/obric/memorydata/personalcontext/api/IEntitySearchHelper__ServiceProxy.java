package com.obric.memorydata.personalcontext.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IEntitySearchHelper__ServiceProxy implements IServiceProxy<IEntitySearchHelper> {
    public IEntitySearchHelper__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.personalcontext.api.IEntitySearchHelper", "com.obric.memorydata.personalcontext.EntitySearchHelper");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IEntitySearchHelper newInstance() {
        return com.obric.memorydata.personalcontext.EntitySearchHelper.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IEntitySearchHelper newInstance() {
        return newInstance();
    }
}
