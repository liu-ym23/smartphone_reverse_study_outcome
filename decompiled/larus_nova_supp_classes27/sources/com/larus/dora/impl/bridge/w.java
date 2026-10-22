package com.larus.dora.impl.bridge;

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
import com.larus.doc.sdk.impl.BuildConfig;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.base.tracker")
public final class w extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "dora.base.tracker")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "event", required = true)
        String getEvent();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = BuildConfig.DEBUG)
        Map<String, Object> getParams();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public w() {
        this.a = "dora.base.tracker";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r4, XBaseParamModel r5, CompletionBlock r6) {
        b r7 = (b) r5;
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        String r8 = r7.getEvent();
        if (r8 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        r6.onFailure(-3, "event is empty", ne7.e.b(c.class));
        return;
    L11:
        Map<String, Object> r9 = r7.getParams();
        if (r9 != null) goto L14;
        r9 = MapsKt.emptyMap();
    L14:
        FLogger.a.i("DoraTrackerMethod", "dora.base.tracker report event=" + r8 + ", params=" + r9);
        DoraBuryPointManager.a.L(r8, r9);
        CompletionBlock.DefaultImpls.onSuccess$default(r6, ne7.e.b(c.class), null, 2, null);
        return;
    L5:
        if (StringsKt.isBlank(r8) == true) goto L8;
        r0 = false;
        goto L9
    }
}
