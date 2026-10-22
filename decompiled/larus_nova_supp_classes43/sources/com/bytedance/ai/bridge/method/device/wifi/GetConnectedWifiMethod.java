package com.bytedance.ai.bridge.method.device.wifi;

import android.content.Context;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.wifi.AbsGetConnectedWifiMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.b;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import v3.e;
import v3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/wifi/GetConnectedWifiMethod;", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL$GetConnectedWifiParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL$GetConnectedWifiResultModel;", "toModel", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL$WifiInfo;", "Lcom/bytedance/ai/bridge/method/device/wifi/WifiInfoSnapshot;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetConnectedWifiMethod extends AbsGetConnectedWifiMethodIDL {

    public static final class a {
    }

    static {
    }

    public GetConnectedWifiMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r13, ParamModel r14, h r15) {
        AbsGetConnectedWifiMethodIDL.a r16 = (AbsGetConnectedWifiMethodIDL.a) r14;
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "callback");
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, partialInfo=");
        Boolean r10 = r16.getPartialInfo();
        Boolean r11 = Boolean.TRUE;
        r1.append(Intrinsics.areEqual(r10, r11));
        r1.append(", appletId=");
        a0 r12 = r13.getContainerContext();
        if (r12 == null) goto L5;
        String r17 = r12.getAppletId();
    L6:
        r1.append(r17);
        r0.i("AISDK_JSB_GetConnectedWifiMethod", r1.toString());
        v3.h r18 = j.a(r13);
        boolean r19 = Intrinsics.areEqual(r16.getPartialInfo(), r11);
        WifiError r20 = r18.h();
        if (r20 == null) goto L9;
        Result.Companion r110 = Result.Companion;
        Object r111 = Result.constructor-impl(ResultKt.createFailure(r20));
    L17:
        if (Result.isSuccess-impl(r111) == false) goto L19;
        e r112 = (e) r111;
        r0.i("AISDK_JSB_GetConnectedWifiMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsGetConnectedWifiMethodIDL.b.class, "<this>");
        BaseModel r21 = c.a(AbsGetConnectedWifiMethodIDL.b.class);
        ((AbsGetConnectedWifiMethodIDL.b) r21).setWifi(new AbsGetConnectedWifiMethodIDL.WifiInfo(r112.a, r112.b, r112.c, r112.d, r112.e));
        r15.b((ResultModel) r21, "");
    L19:
        Throwable r113 = Result.exceptionOrNull-impl(r111);
        if (r113 != null) goto L22;
        return;
    L22:
        if ((r113 instanceof WifiError) == false) goto L24;
        WifiError r114 = (WifiError) r113;
    L25:
        if (r114 == null) goto L28;
        f3.a r115 = r114.getErrNo();
        if (r115 == null) goto L28;
    L29:
        String r116 = r113.getMessage();
        if (r116 != null) goto L32;
        r116 = "get connected wifi failed";
    L32:
        r0.e("AISDK_JSB_GetConnectedWifiMethod", "call failed, errNo=" + r115.a + ", msg=" + r116);
        h.a.a(r15, r116, r115, null, 10);
        return;
    L28:
        r115 = f3.a.f;
        goto L29
    L24:
        r114 = null;
        goto L25
    L9:
        Context r117 = r18.j();
        if (r117 != null) goto L12;
        Result.Companion r118 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(new WifiError(f3.a.f, "context is null")));
        goto L17
    L12:
        v3.d.a.getClass();
        e r119 = v3.d.f(r117, r19);
        if (r119 != null) goto L15;
        Result.Companion r120 = Result.Companion;
        f3.a.C0156a r121 = f3.a.c;
        f3.a r22 = b.a;
        Intrinsics.checkNotNullParameter(r121, "<this>");
        r111 = Result.constructor-impl(ResultKt.createFailure(new WifiError(b.f, "wifi is not connected")));
        goto L17
    L15:
        r111 = Result.constructor-impl(r119);
        goto L17
    L5:
        r17 = null;
        goto L6
    }
}
