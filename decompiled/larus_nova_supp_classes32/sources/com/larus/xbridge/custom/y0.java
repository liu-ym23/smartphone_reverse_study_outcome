package com.larus.xbridge.custom;

import android.view.View;
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
import com.larus.btm.api.IBTMService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "btm.createJumpSourceBtmToken")
public final class y0 extends XCoreIDLBridgeMethod<a, b> {
    public final String a;

    @XBridgeMethodName(name = "btm.createJumpSourceBtmToken", params = {"btm", "bcm", "options"})
    public final String b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "bcm", required = false)
        Map<String, Object> getBcm();

        @XBridgeParamField(isGetter = true, keyPath = "btm", required = true)
        String getBtm();

        @XBridgeParamField(isGetter = true, keyPath = "options", required = false)
        Map<String, Object> getOptions();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = LynxResourceModule.DATA_KEY, required = true)
        Map<String, Object> getData();

        @XBridgeParamField(isGetter = false, keyPath = LynxResourceModule.DATA_KEY, required = true)
        void setData(Map<String, ? extends Object> r1);
    }

    public y0() {
        this.a = "BtmCreateJumpSourceBtmToken";
        this.b = "btm.createJumpSourceBtmToken";
    }

    public final String getName() {
        return this.b;
    }

    public final void handle(IBDXBridgeContext r9, XBaseParamModel r10, CompletionBlock r11) {
        a r12 = (a) r10;
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r0 = r12.getBtm();
        if (StringsKt.isBlank(r0) == false) goto L5;
        FLogger.a.e(this.a, "[handle] invalid btm");
        CompletionBlock.DefaultImpls.onFailure$default(r11, 0, "invalid btm", null, 4, null);
        return;
    L5:
        FLogger r1 = FLogger.a;
        String r2 = this.a;
        StringBuilder r3 = new StringBuilder("[handle] start, btm=");
        r3.append(r0);
        r3.append(", bcmKeys=");
        Map<String, Object> r4 = r12.getBcm();
        if (r4 == null) goto L8;
        Set<String> r5 = r4.keySet();
    L9:
        r3.append(r5);
        r3.append(", optionsKeys=");
        Map<String, Object> r6 = r12.getOptions();
        if (r6 == null) goto L12;
        Set<String> r7 = r6.keySet();
    L13:
        r3.append(r7);
        r1.i(r2, r3.toString());
        Map<String, Object> r8 = r12.getBcm();
        r12.getOptions();
        View r13 = r9.getEngineView();
        if (r13 == null) goto L18;
        IBTMService r14 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r14 == null) goto L18;
        String r15 = r14.d(r0, r8, r13);
    L19:
        if (r15 != null) goto L21;
    L24:
        boolean r16 = true;
    L25:
        if (r16 == false) goto L27;
        r1.e(this.a, "[handle] create token failed, btm=" + r0);
        CompletionBlock.DefaultImpls.onFailure$default(r11, 0, "create token failed", null, 4, null);
        return;
    L27:
        b r17 = ne7.e.b(b.class);
        r17.setData(MapsKt.mapOf(TuplesKt.to("source_btm_token", r15)));
        CompletionBlock.DefaultImpls.onSuccess$default(r11, r17, null, 2, null);
        r1.i(this.a, "handle success " + r15);
        return;
    L21:
        if (StringsKt.isBlank(r15) == true) goto L24;
        r16 = false;
    L18:
        r15 = null;
        goto L19
    L12:
        r7 = null;
        goto L13
    L8:
        r5 = null;
        goto L9
    }
}
