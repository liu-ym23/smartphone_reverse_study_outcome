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
import com.larus.utils.logger.FLogger;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.debug.clearHistory")
public final class h extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "dora.debug.clearHistory")
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

    public h() {
        this.a = "dora.debug.clearHistory";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r3, XBaseParamModel r4, CompletionBlock r5) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter((b) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        pk4.i r6 = pk4.i.a.a;
        HashSet r7 = (HashSet) r6.c();
        Iterator r0 = r7.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r6.g((DoraDevice) r0.next());
        goto L4
    L6:
        FLogger.a.i("DoraDeviceClearHistoryMethod", "dora.debug.clearHistory cleared " + r7.size() + " history devices");
        CompletionBlock.DefaultImpls.onSuccess$default(r5, ne7.e.b(c.class), null, 2, null);
    }
}
