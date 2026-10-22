package com.obric.memorydata.personalcontext.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.personalcontext.impl.PersonalContextAPIImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IPersonalContextAPI__ServiceProxy implements IServiceProxy<IPersonalContextAPI> {
    public IPersonalContextAPI__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.personalcontext.api.IPersonalContextAPI", "com.obric.memorydata.personalcontext.impl.PersonalContextAPIImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IPersonalContextAPI newInstance() {
        return PersonalContextAPIImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IPersonalContextAPI newInstance() {
        return newInstance();
    }
}
