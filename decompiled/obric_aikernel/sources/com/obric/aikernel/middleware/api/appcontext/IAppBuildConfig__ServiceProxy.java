package com.obric.aikernel.middleware.api.appcontext;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.AppBuildConfigImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IAppBuildConfig__ServiceProxy implements IServiceProxy<IAppBuildConfig> {
    public IAppBuildConfig__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig", "com.obric.aikernel.AppBuildConfigImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAppBuildConfig newInstance() {
        return AppBuildConfigImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAppBuildConfig newInstance() {
        return newInstance();
    }
}
