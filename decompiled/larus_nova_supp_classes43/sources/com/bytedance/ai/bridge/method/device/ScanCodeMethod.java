package com.bytedance.ai.bridge.method.device;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.scan.AbsScanCodeMethodIDL;
import com.bytedance.ai.bridge.service.IHostScanCodeDepend;
import com.bytedance.ai.bridge.service.ScanCodeRequest;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t3.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/ScanCodeMethod;", "Lcom/bytedance/ai/bridge/device/scan/AbsScanCodeMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/scan/AbsScanCodeMethodIDL$ScanCodeParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/scan/AbsScanCodeMethodIDL$ScanCodeResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanCodeMethod extends AbsScanCodeMethodIDL {

    public static final class a {
    }

    static {
    }

    public ScanCodeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsScanCodeMethodIDL.a r13 = (AbsScanCodeMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, onlyFromCamera=");
        r1.append(r13.getOnlyFromCamera());
        r1.append(", appletId=");
        a0 r14 = r10.getContainerContext();
        List r15 = null;
        if (r14 == null) goto L5;
        String r16 = r14.getAppletId();
    L6:
        r1.append(r16);
        r0.i("AISDK_JSB_ScanCodeMethod", r1.toString());
        IHostScanCodeDepend r17 = r4.a.o;
        if (r17 != null) goto L9;
        StringBuilder r18 = new StringBuilder("call failed, errNo=");
        f3.a r19 = f3.a.g;
        r18.append(r19.a);
        r18.append(", msg=HostScanCodeDepend is null");
        r0.e("AISDK_JSB_ScanCodeMethod", r18.toString());
        h.a.a(r12, "HostScanCodeDepend is null", r19, null, 10);
        return;
    L9:
        String r20 = this.a;
        Boolean r21 = r13.getOnlyFromCamera();
        List<String> r22 = r13.getScanType();
        if (r22 == null) goto L12;
        r15 = CollectionsKt.toList(r22);
    L12:
        if (r15 != null) goto L14;
        r15 = CollectionsKt.emptyList();
    L14:
        r17.scanCode(new ScanCodeRequest(r10, r20, r21, r15), new a2(r12));
        return;
    L5:
        r16 = null;
        goto L6
    }
}
