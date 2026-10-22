package com.larus.dora.impl.bridge;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.ota.DoraOTAManagement;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.debug.clearSilentOtaCount")
public final class e extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "dora.debug.clearSilentOtaCount")
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

    public e() {
        this.a = "dora.debug.clearSilentOtaCount";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r6, XBaseParamModel r7, CompletionBlock r8) {
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter((b) r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        DoraDevice r9 = DoraAdapterExtKt.h(kj4.a.g());
        if (r9 == null) goto L5;
        DoraOTAManagement r2 = DoraOTAManagement.a;
        Intrinsics.checkNotNullParameter(r9, "device");
        DoraOTAManagement.p().storeInt(r9.mac + "_dora_ota_todayAutoOtaCount", 0);
        DoraOTAManagement.p().storeLong(r9.mac + "_dora_ota_lastAutoOtaTime", 0);
        FLogger.a.i("DoraClearSilentOtaCountMethod", "dora.debug.clearSilentOtaCount cleared silent OTA count for device: " + r9.mac);
        CompletionBlock.DefaultImpls.onSuccess$default(r8, ne7.e.b(c.class), null, 2, null);
        return;
    L5:
        FLogger.a.w("DoraClearSilentOtaCountMethod", "dora.debug.clearSilentOtaCount failed: no connected or history device found");
        r8.onFailure(0, "No connected or history device found", null);
    }
}
