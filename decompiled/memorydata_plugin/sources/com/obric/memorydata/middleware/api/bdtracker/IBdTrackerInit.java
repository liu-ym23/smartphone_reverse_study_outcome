package com.obric.memorydata.middleware.api.bdtracker;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/middleware/api/bdtracker/IBdTrackerInit;", "Lcom/bytedance/news/common/service/manager/IService;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IBdTrackerInit extends IService {
    void init();
}
