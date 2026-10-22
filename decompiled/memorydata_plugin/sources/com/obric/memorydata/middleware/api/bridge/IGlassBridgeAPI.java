package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IGlassBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "isConnected", "", "isWearing", "isConnectedGeneration", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IGlassBridgeAPI extends IService {
    boolean isConnected();

    boolean isConnectedGeneration(long r1);

    boolean isWearing();
}
