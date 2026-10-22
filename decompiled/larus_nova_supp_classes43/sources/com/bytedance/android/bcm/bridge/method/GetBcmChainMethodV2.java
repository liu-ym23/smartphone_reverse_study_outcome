package com.bytedance.android.bcm.bridge.method;

import android.view.View;
import com.bytedance.android.bcm.api.b;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.method.j;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import g66.c;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "getBcmChainV2")
public final class GetBcmChainMethodV2 extends XCoreBridgeMethod implements h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public GetBcmChainMethodV2() {
        this.a = "getBcmChainV2";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final XReadableMap r11, com.bytedance.ies.xbridge.XBridgeMethod.Callback r12, XBridgePlatformType r13) {
        ALogger.c(ALogger.d, "FE_GetBcmChainV2", new AnonymousClass1(r11));
        int r14 = r11.getInt("chain_length");
        boolean r0 = r11.getBoolean("is_domain_standard");
        final String r1 = r11.getString("btm");
        final XReadableMap r15 = r11.getMap("bcm");
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        JSONObject r16 = null;
        r10.element = null;
        c r17 = getContextProviderFactory();
        if (r17 == null) goto L6;
        r10.element = HybridContainerContextManager.c(r17);
    L6:
        if (((View) r10.element) != null) goto L8;
        g$a.a(BtmSDK.INSTANCE.getService().getMonitor(), 2025, null, null, AnonymousClass4.INSTANCE, 30);
    L11:
        if (r16 != null) goto L13;
        j.a(this, r12, "chain is null");
        return;
    L13:
        int r18 = j.a;
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put("content", r16);
        j.b(this, r12, r19);
        return;
    L8:
        Function1<d, Unit> r20 = new GetBcmChainMethodV2$handle$btmModel$1(r10, r1, r15);
        d r110 = new d();
        r20.invoke(r110);
        kc.a r111 = b.a.getBcmChainByBtmModel(r110, CollectionsKt.listOf("ecom_entrance"), r14, r0);
        if (r111 == null) goto L11;
        r16 = r111.a();
        goto L11
    }
}
