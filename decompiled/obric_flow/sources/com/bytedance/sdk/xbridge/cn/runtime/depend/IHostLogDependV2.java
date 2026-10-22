package com.bytedance.sdk.xbridge.cn.runtime.depend;

import androidx.annotation.Keep;
import cj.d;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J7\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLogDependV2;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLogDepend;", "", "eventName", "", "map", "Lcj/d;", "bridgeContext", "", "onEventV3Map", "(Ljava/lang/String;Ljava/util/Map;Lcj/d;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostLogDependV2 extends IHostLogDepend {
    void onEventV3Map(String r5, Map<String, String> r10, d r11);
}
