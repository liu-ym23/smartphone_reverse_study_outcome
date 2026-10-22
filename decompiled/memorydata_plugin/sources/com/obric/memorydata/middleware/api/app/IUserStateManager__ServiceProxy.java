package com.obric.memorydata.middleware.api.app;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.ui.impl.UserStateManagerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IUserStateManager__ServiceProxy implements IServiceProxy<IUserStateManager> {
    public IUserStateManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.app.IUserStateManager", "com.obric.memorydata.ui.impl.UserStateManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IUserStateManager newInstance() {
        return UserStateManagerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IUserStateManager newInstance() {
        return newInstance();
    }
}
