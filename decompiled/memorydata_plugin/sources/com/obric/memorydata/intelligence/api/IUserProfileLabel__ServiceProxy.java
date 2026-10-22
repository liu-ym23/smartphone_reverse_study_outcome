package com.obric.memorydata.intelligence.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.intelligence.datalearning.service.UserProfileLabelQuery;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class IUserProfileLabel__ServiceProxy implements IServiceProxy<IUserProfileLabel> {
    public IUserProfileLabel__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.intelligence.api.IUserProfileLabel", "com.obric.memorydata.intelligence.datalearning.service.UserProfileLabelQuery");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IUserProfileLabel newInstance() {
        return UserProfileLabelQuery.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IUserProfileLabel newInstance() {
        return newInstance();
    }
}
