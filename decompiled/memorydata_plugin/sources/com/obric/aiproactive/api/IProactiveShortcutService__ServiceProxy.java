package com.obric.aiproactive.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.ProactiveShortcutServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class IProactiveShortcutService__ServiceProxy implements IServiceProxy<IProactiveShortcutService> {
    public IProactiveShortcutService__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.aiproactive.api.IProactiveShortcutService", "com.obric.memorydata.ProactiveShortcutServiceImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IProactiveShortcutService newInstance() {
        return ProactiveShortcutServiceImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IProactiveShortcutService newInstance() {
        return newInstance();
    }
}
