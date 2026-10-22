package com.larus.xbridge.custom;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.bmhome.taskskill.service.SkillServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "flow.refreshConnector", owner = "river.li")
public final class l1 extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "flow.refreshConnector")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public l1() {
        this.a = "flow.refreshConnector";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r3, XBaseParamModel r4, CompletionBlock r5) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter((b) r4, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, "callback");
        Activity r6 = r3.getOwnerActivity();
        FLogger r7 = FLogger.a;
        if (r6 == null) goto L5;
        String r8 = r6.getLocalClassName();
    L6:
        if (r8 != null) goto L8;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r7.i("FlowRefreshConnectorMethod", "[handle] activity=".concat(r8));
        SkillServiceDelegate.a.o();
        CompletionBlock.DefaultImpls.onSuccess$default(r5, ne7.e.b(c.class), null, 2, null);
        return;
    L5:
        r8 = null;
        goto L6
    }
}
