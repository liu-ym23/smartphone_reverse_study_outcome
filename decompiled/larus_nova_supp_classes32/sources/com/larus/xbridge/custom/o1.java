package com.larus.xbridge.custom;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "app.renderCodeLynxPreviewResult")
public final class o1 extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "app.renderCodeLynxPreviewResult", params = {"success"})
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "success", required = true)
        Boolean getSuccess();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public o1() {
        this.a = "app.renderCodeLynxPreviewResult";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r9, XBaseParamModel r10, CompletionBlock r11) {
        b r12 = (b) r10;
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r13 = r9.getContainerID();
        Boolean r14 = r12.getSuccess();
        boolean r0 = false;
        if (r14 == null) goto L5;
        boolean r15 = r14.booleanValue();
    L6:
        FLogger r1 = FLogger.a;
        r1.i("FlowRenderCodeLynxPreviewResultMethod", "[handle] containerId=" + r13 + ", success=" + r15);
        ConcurrentHashMap r2 = eh8.a.a;
        if (r13 != null) goto L9;
    L12:
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        r1.w("CodeRenderLynxManager", "[dispatchResult] skip empty containerId, success=" + r15);
    L20:
        if (r0 == true) goto L22;
        r1.w("FlowRenderCodeLynxPreviewResultMethod", "[handle] no callback dispatched for containerId=" + r13);
    L22:
        CompletionBlock.DefaultImpls.onSuccess$default(r11, ne7.e.b(c.class), null, 2, null);
        return;
    L16:
        eh8.a.a r6 = (eh8.a.a) eh8.a.a.get(r13);
        if (r6 != null) goto L19;
        r1.w("CodeRenderLynxManager", "[dispatchResult] no callback for containerId=" + r13);
        goto L20
    L19:
        r1.i("CodeRenderLynxManager", "[dispatchResult] containerId=" + r13 + ", success=" + r15);
        r6.onResult(r15);
        r0 = true;
        goto L20
    L9:
        if (r13.length() == 0) goto L12;
        r5 = false;
        goto L14
    L5:
        r15 = false;
        goto L6
    }
}
