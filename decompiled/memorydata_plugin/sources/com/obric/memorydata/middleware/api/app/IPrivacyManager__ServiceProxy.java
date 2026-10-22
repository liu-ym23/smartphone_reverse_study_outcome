package com.obric.memorydata.middleware.api.app;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.ui.impl.PrivacyManagerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IPrivacyManager__ServiceProxy implements IServiceProxy<IPrivacyManager> {
    public IPrivacyManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.app.IPrivacyManager", "com.obric.memorydata.ui.impl.PrivacyManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IPrivacyManager newInstance() {
        return PrivacyManagerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IPrivacyManager newInstance() {
        return newInstance();
    }
}
