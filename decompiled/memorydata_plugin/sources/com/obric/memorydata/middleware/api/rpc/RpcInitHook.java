package com.obric.memorydata.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.rpc.callback.RpcInterceptor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/middleware/api/rpc/RpcInitHook;", "Lcom/bytedance/news/common/service/manager/IService;", "beforeInitRpc", "", "rpcBaseUrl", "", "addRpcCommonQuery", "", "addRpcHeader", "addRpcInterceptors", "", "Lcom/bytedance/rpc/callback/RpcInterceptor;", "afterInitRpc", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RpcInitHook extends IService {
    Map<String, String> addRpcCommonQuery();

    Map<String, String> addRpcHeader();

    List<RpcInterceptor> addRpcInterceptors();

    void afterInitRpc();

    void beforeInitRpc();

    String rpcBaseUrl();
}
