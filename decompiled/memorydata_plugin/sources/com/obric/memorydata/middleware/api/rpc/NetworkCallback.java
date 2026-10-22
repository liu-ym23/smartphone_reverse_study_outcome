package com.obric.memorydata.middleware.api.rpc;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/middleware/api/rpc/NetworkCallback;", "", "onSuccess", "", "dataJson", "", "onFailed", "errorType", "", "code", InfoRequestQPSOptTraceLogger.REASON, "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface NetworkCallback {
    void onFailed(int r1, int r2, String r3);

    void onSuccess(String r1);
}
