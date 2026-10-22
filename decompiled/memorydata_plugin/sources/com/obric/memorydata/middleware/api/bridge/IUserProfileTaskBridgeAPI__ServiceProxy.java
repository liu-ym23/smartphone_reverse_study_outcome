package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.middleware.impl.profile.UserProfileTaskBridgeImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IUserProfileTaskBridgeAPI__ServiceProxy implements IServiceProxy<IUserProfileTaskBridgeAPI> {
    public IUserProfileTaskBridgeAPI__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.IUserProfileTaskBridgeAPI", "com.obric.memorydata.middleware.impl.profile.UserProfileTaskBridgeImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IUserProfileTaskBridgeAPI newInstance() {
        return UserProfileTaskBridgeImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IUserProfileTaskBridgeAPI newInstance() {
        return newInstance();
    }
}
