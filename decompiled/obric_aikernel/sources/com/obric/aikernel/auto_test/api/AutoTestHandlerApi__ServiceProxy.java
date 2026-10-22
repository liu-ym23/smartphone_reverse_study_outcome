package com.obric.aikernel.auto_test.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.auto_test.impl.AutoTestHandlerImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AutoTestHandlerApi__ServiceProxy implements IServiceProxy<AutoTestHandlerApi> {
    public AutoTestHandlerApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.auto_test.api.AutoTestHandlerApi", "com.obric.aikernel.auto_test.impl.AutoTestHandlerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public AutoTestHandlerApi newInstance() {
        return AutoTestHandlerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ AutoTestHandlerApi newInstance() {
        return newInstance();
    }
}
