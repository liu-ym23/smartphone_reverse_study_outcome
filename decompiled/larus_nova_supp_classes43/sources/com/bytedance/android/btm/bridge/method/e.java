package com.bytedance.android.btm.bridge.method;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.bridge.BtmBridgeProvider;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "createBtmId")
public final class e extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public e() {
        this.a = "createBtmId";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final XReadableMap r10, com.bytedance.ies.xbridge.XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        int r13 = d.a;
        ALogger.c(ALogger.d, "FE_createBtmId", new CreateBtmIdHelper$handle$1(r10));
        BtmBridgeProvider r14 = BtmBridgeProvider.c;
        g66.c r0 = getContextProviderFactory();
        r14.getClass();
        String r15 = null;
        if (r0 == null) goto L5;
        View r1 = HybridContainerContextManager.c(r0);
    L6:
        BtmItemBuilder r16 = BtmBridgeProvider.a(cd.a.c(r10.toMap()), r1, null);
        if (r16 == null) goto L9;
        r15 = BtmSDK.INSTANCE.createBtmId(r16.build());
    L9:
        if (r15 != null) goto L11;
    L14:
        boolean r17 = true;
    L15:
        if (r17 == false) goto L17;
        g$a.b(BtmSDK.INSTANCE.getService().getMonitor(), 1113, null, null, false, 30);
    L17:
        LinkedHashMap r18 = new LinkedHashMap();
        if (r15 == null) goto L20;
        r18.put("btm_id", r15);
    L20:
        j.b(this, r11, r18);
        return;
    L11:
        if (r15.length() == 0) goto L14;
        r17 = false;
        goto L15
    L5:
        r1 = null;
        goto L6
    }
}
