package com.bytedance.android.bst.bridge;

import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.google.gson.Gson;
import g66.c;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "sendBstExposureMethod")
public final class SendBstExposureMethod extends XCoreBridgeMethod implements h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public static final class a {
    }

    static {
    }

    public SendBstExposureMethod() {
        this.a = "sendBstExposureMethod";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r10, final com.bytedance.ies.xbridge.XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        final JSONObject r0 = new JSONObject(new Gson().toJson(s.h(r10)));     // Catch: Exception -> L8
        Function0<String> r13 = new AnonymousClass1(r0);     // Catch: Exception -> L8
        ALogger r1 = ALogger.d;     // Catch: Exception -> L8
        r1.getClass();     // Catch: Exception -> L8
        View r14 = null;
        r1.o("BTMSDK_BST_".concat("SendBstExposureMethod"), false, r13, null);     // Catch: Exception -> L8
        c r15 = getContextProviderFactory();     // Catch: Exception -> L8
        if (r15 == null) goto L6;
        r14 = HybridContainerContextManager.c(r15);     // Catch: Exception -> L8
    L6:
        int r16 = com.bytedance.android.bst.bridge.a.a;     // Catch: Exception -> L8
        com.bytedance.android.bst.bridge.a.a(r0, r14, new AnonymousClass2(this, r11));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        ExtKt.b("SendBstExposureMethod", ExtKt.c(e));
    }
}
