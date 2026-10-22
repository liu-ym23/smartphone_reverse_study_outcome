package com.obric.memorydata.middleware.api.device;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\t\u0010\u000b\u001a\u00020\tH\u0096\u0001J\t\u0010\f\u001a\u00020\tH\u0096\u0001J\t\u0010\r\u001a\u00020\tH\u0096\u0001R\u001a\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/api/device/DeviceInfoState;", "Lcom/obric/memorydata/middleware/api/device/IDeviceInfoState;", "<init>", "()V", "getDeviceModel", "", "getSelfCollectionEntitySupport", "Lcom/obric/memorydata/middleware/api/device/SelfCollectionConfig;", "isAIKernelAvailable", "", "isGlobalMemoryDisabled", "isObricOsDevice", "isSupportVLM", "isSupportVLMEmbedding", "vlmSupportState", "Lkotlinx/coroutines/flow/StateFlow;", "getVlmSupportState", "()Lkotlinx/coroutines/flow/StateFlow;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceInfoState implements IDeviceInfoState {
    public static final DeviceInfoState INSTANCE = null;
    private final /* synthetic */ IDeviceInfoState $$delegate_0;

    static {
        INSTANCE = new DeviceInfoState();
    }

    private DeviceInfoState() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IDeviceInfoState.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IDeviceInfoState) ZeusTransformUtils.preCheckCast(r0, IDeviceInfoState.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public String getDeviceModel() {
        return this.$$delegate_0.getDeviceModel();
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public a getSelfCollectionEntitySupport() {
        return this.$$delegate_0.getSelfCollectionEntitySupport();
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public ar<Boolean> getVlmSupportState() {
        return this.$$delegate_0.getVlmSupportState();
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public boolean isAIKernelAvailable() {
        return this.$$delegate_0.isAIKernelAvailable();
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public boolean isGlobalMemoryDisabled() {
        return this.$$delegate_0.isGlobalMemoryDisabled();
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public boolean isObricOsDevice() {
        return this.$$delegate_0.isObricOsDevice();
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public boolean isSupportVLM() {
        return this.$$delegate_0.isSupportVLM();
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public boolean isSupportVLMEmbedding() {
        return this.$$delegate_0.isSupportVLMEmbedding();
    }
}
