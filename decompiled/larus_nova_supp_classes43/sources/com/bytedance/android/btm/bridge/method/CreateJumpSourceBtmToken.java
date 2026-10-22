package com.bytedance.android.btm.bridge.method;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "btm.createJumpSourceBtmToken")
public final class CreateJumpSourceBtmToken extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public final void release() {
    }

    public CreateJumpSourceBtmToken() {
        this.a = "btm.createJumpSourceBtmToken";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r10, com.bytedance.ies.xbridge.XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        final String r13 = s.f(r10, "btm", "");
        final XReadableMap r14 = s.e(r10, "bcm");
        ALogger.c(ALogger.d, "FE_createJumpSourceBtmToken", new AnonymousClass1(r13, r14));
        g66.c r0 = getContextProviderFactory();
        if (r0 == null) goto L5;
        final View r1 = HybridContainerContextManager.c(r0);
    L6:
        if (r1 != null) goto L9;
        g$a.a(BtmSDK.INSTANCE.getService().getMonitor(), 2024, r13, null, new AnonymousClass2(r13), 28);
        j.a(this, r11, "Cannot find view");
        return;
    L9:
        XReadableMap r15 = s.e(r10, "options");
        if (r15 == null) goto L12;
        s.b(r15, "cache_btm_token", false);
    L12:
        BtmSDK r16 = BtmSDK.INSTANCE;
        Function1<com.bytedance.android.btm.api.model.d, Unit> r17 = new CreateJumpSourceBtmToken$handle$sourceBtmToken$1(r13, r14, r1);
        com.bytedance.android.btm.api.model.d r18 = new com.bytedance.android.btm.api.model.d();
        r17.invoke(r18);
        String r19 = r16.createJumpSourceBtmTokenForJSB(r18);
        if (r19 != null) goto L15;
    L18:
        boolean r20 = true;
    L19:
        if (r20 == false) goto L21;
        j.a(this, r11, "createJumpSourceBtmToken Fail.");
        return;
    L21:
        int r21 = j.a;
        j.b(this, r11, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("source_btm_token", r19)}));
        return;
    L15:
        if (r19.length() == 0) goto L18;
        r20 = false;
        goto L19
    L5:
        r1 = null;
        goto L6
    }
}
