package com.bytedance.android.btm.bridge.method;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.HybridSchemaHelper;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "registerBtmPage")
public final class m extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public m() {
        this.a = "registerBtmPage";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final XReadableMap r11, com.bytedance.ies.xbridge.XBridgeMethod.Callback r12, XBridgePlatformType r13) {
        int r14 = l.a;
        ALogger.c(ALogger.d, "FE_registerBtmPage", new RegisterBtmPageBridgeHelper$handle$1(r11));
        final String r15 = s.f(r11, "btm", "");
        XReadableMap r16 = s.e(r11, "page_event_params");
        Uri r0 = null;
        if (r16 == null) goto L5;
        Map r17 = r16.toMap();
    L6:
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = null;
        g66.c r1 = getContextProviderFactory();
        if (r1 == null) goto L9;
        r10.element = HybridContainerContextManager.c(r1);
    L9:
        Lazy r18 = HybridContainerContextManager.a;
        final String r19 = HybridContainerContextManager.b(getContextProviderFactory());
        View r20 = (View) r10.element;
        if (r20 == null) goto L21;
        Map<View, String> r21 = HybridSchemaHelper.a;
        if (r19 == null) goto L14;
        r0 = UriProtector.parse(r19);
    L14:
        String r22 = HybridSchemaHelper.b(r20, r0);
        BtmSDK r23 = BtmSDK.INSTANCE;
        r23.getService().checkPageBtmFormat(r15, r22, true, null, r19);
        com.bytedance.android.btm.api.inner.e r24 = r23.getService();
        View r25 = (View) r10.element;
        if (r25 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        if (r24.registerBtmPage(r25, r15, r22, r17) == false) goto L20;
        j.b(this, r12, new LinkedHashMap());
        return;
    L20:
        j.a(this, r12, "register btm page failed");
        g$a.a(r23.getService().getMonitor(), 2024, null, null, new RegisterBtmPageBridgeHelper$handle$3(r15, r19, r10), 30);
        return;
    L21:
        j.a(this, r12, "Hybrid view is null");
        g$a.a(BtmSDK.INSTANCE.getService().getMonitor(), 2025, "registerBtmPage", null, new RegisterBtmPageBridgeHelper$handle$4(r15, r19), 28);
        return;
    L5:
        r17 = null;
        goto L6
    }
}
