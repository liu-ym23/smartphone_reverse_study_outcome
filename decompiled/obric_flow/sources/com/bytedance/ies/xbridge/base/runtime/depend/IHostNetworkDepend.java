package com.bytedance.ies.xbridge.base.runtime.depend;

import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostNetworkDepend;", "", "createRetrofit", "Lcom/bytedance/ies/xbridge/base/runtime/depend/XIRetrofit;", "baseUrl", "", "isUseOkHttp", "", "getAPIParams", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostNetworkDepend {
    @WorkerThread
    XIRetrofit createRetrofit(String r5, boolean r10);

    Map<String, Object> getAPIParams();
}
