package com.obric.memorydata.middleware.api.device;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.middleware.impl.device.DeviceInfoStateImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IDeviceInfoState__ServiceProxy implements IServiceProxy<IDeviceInfoState> {
    public IDeviceInfoState__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.device.IDeviceInfoState", "com.obric.memorydata.middleware.impl.device.DeviceInfoStateImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IDeviceInfoState newInstance() {
        return DeviceInfoStateImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IDeviceInfoState newInstance() {
        return newInstance();
    }
}
