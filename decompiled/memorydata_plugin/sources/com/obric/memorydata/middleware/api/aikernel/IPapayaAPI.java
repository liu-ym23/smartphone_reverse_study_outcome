package com.obric.memorydata.middleware.api.aikernel;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/api/aikernel/IPapayaAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "setInitState", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "isInit", "getPythonThreadTrace", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IPapayaAPI extends IService {
    String getPythonThreadTrace();

    boolean isInit();

    void setInitState(boolean r1);
}
