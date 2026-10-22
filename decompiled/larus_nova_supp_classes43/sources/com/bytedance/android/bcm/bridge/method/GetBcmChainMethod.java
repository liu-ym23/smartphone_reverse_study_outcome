package com.bytedance.android.bcm.bridge.method;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.bcm.api.b;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.method.j;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import g66.c;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "getBcmChain")
public final class GetBcmChainMethod extends XCoreBridgeMethod implements h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public GetBcmChainMethod() {
        this.a = "getBcmChain";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final XReadableMap r10, com.bytedance.ies.xbridge.XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        ALogger.c(ALogger.d, "FE_getBcmChain", new AnonymousClass1(r10));
        String r13 = r10.getString("biz");
        int r14 = r10.getInt("chain_length");
        JSONObject r15 = null;
        if (TextUtils.isEmpty(r13) == true) goto L14;
        c r16 = getContextProviderFactory();
        if (r16 == null) goto L8;
        View r17 = HybridContainerContextManager.c(r16);
    L9:
        if (r17 != null) goto L11;
        g$a.a(BtmSDK.INSTANCE.getService().getMonitor(), 2025, r13, null, AnonymousClass4.INSTANCE, 28);
        goto L14
    L11:
        kc.a r18 = b.b(PageFinder.via(r17), CollectionsKt.listOf(r13), r14);
        if (r18 == null) goto L14;
        r15 = r18.a();
        goto L14
    L8:
        r17 = null;
    L14:
        if (r15 != null) goto L16;
        j.a(this, r11, "chain is null");
        return;
    L16:
        int r19 = j.a;
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put("content", r15);
        j.b(this, r11, r20);
    }
}
