package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/ITaskConditionBridgeApi;", "Lcom/bytedance/news/common/service/manager/IService;", "isSatisfied", "", "conditionNames", "", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ITaskConditionBridgeApi extends IService {
    boolean isSatisfied(List<String> r1);
}
