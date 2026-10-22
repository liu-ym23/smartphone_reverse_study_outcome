package com.bytedance.android.btm.bridge.method;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "btm.getBTMEventParams")
public final class g extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public g() {
        this.a = "btm.getBTMEventParams";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final XReadableMap r10, com.bytedance.ies.xbridge.XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        int r13 = f.a;
        ALogger.c(ALogger.d, "FE_getBtmEventParams", new GetBtmParamsHelper$handle$1(r10));
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        BtmSDK r0 = BtmSDK.INSTANCE;
        String r1 = r0.getService().getLastPageBtm();
        String r15 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        String r16 = s.f(r10, "btm", r1);
        r14.element = r16;
        if (r16.length() != 0) goto L9;
        boolean r17 = true;
    L10:
        if (r17 == false) goto L16;
        String r18 = r0.getService().getLastPageBtm();
        if (r18 == null) goto L14;
        r15 = r18;
    L14:
        r14.element = r15;
        g$a.a(r0.getService().getMonitor(), 1019, null, null, new GetBtmParamsHelper$handle$2(r14, this), 30);
    L16:
        if (getContextProviderFactory() == null) goto L21;
        Lazy r19 = HybridContainerContextManager.a;
        g66.c r20 = getContextProviderFactory();
        if (r20 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        View r21 = HybridContainerContextManager.c(r20);
    L22:
        LinkedHashMap r22 = new LinkedHashMap();
        Iterator r23 = r0.createFullyReportParams((String) r14.element, PageFinder.via(r21)).entrySet().iterator();
    L24:
        if (r23.hasNext() == false) goto L28;
        Map.Entry r110 = (Map.Entry) r23.next();
        Object r24 = r110.getValue();
        if (r24 == null) goto L24;
        r22.put(r110.getKey(), r24);
        goto L24
    L28:
        j.b(this, r11, r22);
        return;
    L21:
        r21 = null;
        goto L22
    L9:
        r17 = false;
        goto L10
    }
}
