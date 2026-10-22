package com.obric.memorydata.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/middleware/api/rpc/IRpcApi;", "Lcom/bytedance/news/common/service/manager/IService;", "isRpcReady", "", "rpcReady", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IRpcApi extends IService {
    boolean isRpcReady();

    void rpcReady();
}
