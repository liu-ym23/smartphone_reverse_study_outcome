package com.bytedance.ai.bridge.service;

import androidx.annotation.Keep;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostLogDepend;", "", "putCommonParams", "", LynxResourceModule.PARAMS_KEY, "", "", "isApi", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IHostLogDepend {
    void putCommonParams(Map<String, String> r5, boolean r10);
}
