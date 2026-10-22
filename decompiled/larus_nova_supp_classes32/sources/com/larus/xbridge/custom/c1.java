package com.larus.xbridge.custom;

import android.app.Activity;
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
import com.larus.common.venue.api.IFlowCommonVenueService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "flow.commonVenueApplyPocket", owner = "daitianji")
public final class c1 extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "flow.commonVenueApplyPocket")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = LynxResourceModule.DATA_KEY, required = true)
        Map<String, Object> getData();

        @XBridgeParamField(isGetter = true, keyPath = "extraInfo", required = false)
        Map<String, Object> getExtra();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public c1() {
        this.a = "flow.commonVenueApplyPocket";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r4, XBaseParamModel r5, CompletionBlock r6) {
        b r7 = (b) r5;
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r6, "callback");
        Activity r8 = r4.getOwnerActivity();
        FLogger r0 = FLogger.a;
        if (r8 == null) goto L6;
        String r1 = r8.getLocalClassName();
        if (r1 == null) goto L6;
    L7:
        r0.i("FlowCommonVenueApplyPocketMethod", "[handle] activity name = ".concat(r1));
        IFlowCommonVenueService.a.b(r8, r7.getData(), r7.getExtra());
        CompletionBlock.DefaultImpls.onSuccess$default(r6, ne7.e.b(c.class), null, 2, null);
        return;
    L6:
        r1 = NameKeys.UnloadStrategy_No_Strategy;
        goto L7
    }
}
