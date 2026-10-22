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
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "flow.refreshMembership", owner = "river.li")
public final class n1 extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "flow.refreshMembership")
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

    public n1() {
        this.a = "flow.refreshMembership";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r2, XBaseParamModel r3, CompletionBlock r4) {
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter((b) r3, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, "callback");
        Activity r5 = r2.getOwnerActivity();
        FLogger r6 = FLogger.a;
        if (r5 == null) goto L6;
        String r7 = r5.getLocalClassName();
        if (r7 == null) goto L6;
    L7:
        r6.i("FlowRefreshMembershipMethod", "[handle] activity=".concat(r7));
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r8 = ICommerceMembershipService.a.a();
        if (r8 == null) goto L10;
        r8.a("refreshMembershipJSB");
    L10:
        ICommerceMembershipService r9 = ICommerceMembershipService.a.a();
        if (r9 == null) goto L13;
        r9.g("REFRESH");
    L13:
        VoiceCallServiceDelegate.a.w("refreshMembershipJSB");
        CompletionBlock.DefaultImpls.onSuccess$default(r4, ne7.e.b(c.class), null, 2, null);
        return;
    L6:
        r7 = NameKeys.UnloadStrategy_No_Strategy;
        goto L7
    }
}
