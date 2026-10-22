package com.larus.dora.impl.bridge;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.IDoraService$c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.debug.downloadEarbudsTrace")
public final class i extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "dora.debug.downloadEarbudsTrace")
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

    public i() {
        this.a = "dora.debug.downloadEarbudsTrace";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r10, XBaseParamModel r11, CompletionBlock r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((b) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        IDoraService r13 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r13 != null) goto L5;
        FLogger.a.w("DoraDeviceDownloadEarbudsTraceMethod", "dora.debug.downloadEarbudsTrace IDoraService is null");
        CompletionBlock.DefaultImpls.onFailure$default(r12, 0, "dora service not found", null, 4, null);
        return;
    L5:
        j r7 = new j(r13, new k());
        IDoraService$c.a(r13, 2, r7, false, false, false, 20);
        IDoraService$c.a(r13, 3, r7, false, false, true, 4);
        CompletionBlock.DefaultImpls.onSuccess$default(r12, ne7.e.b(c.class), null, 2, null);
    }
}
