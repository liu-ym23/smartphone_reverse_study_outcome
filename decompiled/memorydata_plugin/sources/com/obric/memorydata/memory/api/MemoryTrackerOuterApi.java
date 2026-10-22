package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryTrackerOuterApi;", "Lcom/bytedance/news/common/service/manager/IService;", "batchUploadOnce", "", "trackScreenMemorySwitch", "enabled", "", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryTrackerOuterApi extends IService {
    void batchUploadOnce();

    void trackScreenMemorySwitch(boolean r1);
}
