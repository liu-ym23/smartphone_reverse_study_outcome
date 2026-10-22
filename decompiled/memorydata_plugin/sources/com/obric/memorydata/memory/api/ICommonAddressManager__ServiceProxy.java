package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.memory.ui.address.edit.AddressManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ICommonAddressManager__ServiceProxy implements IServiceProxy<ICommonAddressManager> {
    public ICommonAddressManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.memory.api.ICommonAddressManager", "com.obric.memorydata.memory.ui.address.edit.AddressManager");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ICommonAddressManager newInstance() {
        return AddressManager.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ICommonAddressManager newInstance() {
        return newInstance();
    }
}
