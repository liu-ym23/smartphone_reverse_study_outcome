package com.obric.memorydata.middleware.api.device;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&R\u001a\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/middleware/api/device/IDeviceInfoState;", "Lcom/bytedance/news/common/service/manager/IService;", "isObricOsDevice", "", "getSelfCollectionEntitySupport", "Lcom/obric/memorydata/middleware/api/device/SelfCollectionConfig;", "isAIKernelAvailable", "isSupportVLM", "vlmSupportState", "Lkotlinx/coroutines/flow/StateFlow;", "getVlmSupportState", "()Lkotlinx/coroutines/flow/StateFlow;", "getDeviceModel", "", "isSupportVLMEmbedding", "isGlobalMemoryDisabled", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IDeviceInfoState extends IService {
    String getDeviceModel();

    a getSelfCollectionEntitySupport();

    ar<Boolean> getVlmSupportState();

    boolean isAIKernelAvailable();

    boolean isGlobalMemoryDisabled();

    boolean isObricOsDevice();

    boolean isSupportVLM();

    boolean isSupportVLMEmbedding();
}
