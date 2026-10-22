package com.bytedance.android.live.browser.utils;

import com.bytedance.android.live.browser.IH5AssistService;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m extends s26.a implements ga.c {
    public m() {
    }

    public final Map<String, IDLXBridgeMethod> providerMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bid");
        IH5AssistService r0 = (IH5AssistService) jc1.k.f(IH5AssistService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.providerMethod(r2);
    }
}
