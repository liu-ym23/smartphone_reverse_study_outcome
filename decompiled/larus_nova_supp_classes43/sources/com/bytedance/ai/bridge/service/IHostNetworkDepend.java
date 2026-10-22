package com.bytedance.ai.bridge.service;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\bg\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostNetworkDepend;", "", "createRetrofit", "Lcom/bytedance/ai/bridge/service/IAppletRetrofit;", "baseUrl", "", "isUseOkHttp", "", "networkConfig", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IHostNetworkDepend {
    IAppletRetrofit createRetrofit(String r1, boolean r10, Map<String, ? extends Object> r11);
}
