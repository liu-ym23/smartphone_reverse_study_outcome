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
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "app.sendEventToApplet")
public final class a0 extends XCoreIDLBridgeMethod<b, c> {
    public static final Gson b = null;

    @XBridgeMethodName(name = "app.sendEventToApplet", params = {"appId", "eventName", LynxResourceModule.PARAMS_KEY})
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "appId", required = false)
        String getAppId();

        @XBridgeParamField(isGetter = true, keyPath = "eventName", required = true)
        String getEventName();

        @XBridgeParamField(isGetter = true, keyPath = LynxResourceModule.PARAMS_KEY, required = false)
        Map<String, Object> getParams();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        b = new Gson();
    }

    public a0() {
        this.a = "app.sendEventToApplet";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r7, XBaseParamModel r8, CompletionBlock r9) {
        b r10 = (b) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r9, "callback");
        if (StringsKt.isBlank(r10.getEventName()) == false) goto L25;
        CompletionBlock.DefaultImpls.onFailure$default(r9, -3, "eventName is empty", null, 4, null);
        return;
    L25:
        Map<String, Object> r11 = r10.getParams();     // Catch: Throwable -> L22
        if (r11 == null) goto L9;
        JsonObject r12 = b.toJsonTree(r11).getAsJsonObject();     // Catch: Throwable -> L22
    L10:
        l3.a r1 = new l3.a(r10.getEventName(), r12, 4);
        String r13 = r10.getAppId();
        if (r13 != null) goto L13;
    L21:
        l3.d.c(r1);
        CompletionBlock.DefaultImpls.onSuccess$default(r9, ne7.e.b(c.class), null, 2, null);
        return;
    L13:
        if (r13.length() <= 0) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == true) goto L19;
        r13 = null;
    L19:
        if (r13 == null) goto L21;
        r1.d = r13;
        goto L21
    L15:
        r14 = false;
        goto L16
    L9:
        r12 = null;
    L22:
        th = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r9, -3, "params serialize failed: " + th.getMessage(), null, 4, null);
    }
}
