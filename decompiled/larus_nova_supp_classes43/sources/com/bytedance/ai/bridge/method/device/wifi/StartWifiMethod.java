package com.bytedance.ai.bridge.method.device.wifi;

import android.content.Context;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.wifi.AbsStartWifiMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v3.b;
import v3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/wifi/StartWifiMethod;", "Lcom/bytedance/ai/bridge/device/wifi/AbsStartWifiMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/wifi/AbsStartWifiMethodIDL$StartWifiParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/wifi/AbsStartWifiMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartWifiMethod extends AbsStartWifiMethodIDL {

    public static final class a {
    }

    static {
    }

    public StartWifiMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsStartWifiMethodIDL.b) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r13 = g.a;
        StringBuilder r1 = new StringBuilder("call start, appletId=");
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L5;
        String r15 = r14.getAppletId();
    L6:
        r1.append(r15);
        r13.i("AISDK_JSB_StartWifiMethod", r1.toString());
        v3.h r16 = j.a(r10);
        Context r0 = r16.j();
        if (r0 != null) goto L9;
        WifiError r17 = new WifiError(f3.a.f, "context is null");
    L23:
        if (r17 != null) goto L25;
        r13.i("AISDK_JSB_StartWifiMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsStartWifiMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsStartWifiMethodIDL.a.class), "");
        return;
    L25:
        r13.e("AISDK_JSB_StartWifiMethod", "call failed, errNo=" + r17.getErrNo().a + ", msg=" + r17.getMessage());
        h.a.a(r12, r17.getMessage(), r17.getErrNo(), null, 10);
        return;
    L9:
        v3.d.a.getClass();
        if (v3.d.g(r0) != null) goto L12;
        r17 = new WifiError(f3.a.g, "wifi is not available");
        goto L23
    L12:
        Object r18 = r16.b;
        monitor-enter(r18);
    L27:
        th = move-exception;
        throw th;
    L15:
        if (r16.e == false) goto L20;
        r17 = new WifiError(f3.a.f, "context is null");     // Catch: Throwable -> L27
        monitor-exit(r18);
    L30:
        goto L23
    L20:
        r16.d = true;     // Catch: Throwable -> L27
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r18);
        b.f(r0);
        r17 = null;
        goto L30
    L5:
        r15 = null;
        goto L6
    }
}
