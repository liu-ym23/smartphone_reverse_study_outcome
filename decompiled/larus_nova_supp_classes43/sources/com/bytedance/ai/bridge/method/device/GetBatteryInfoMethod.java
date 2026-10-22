package com.bytedance.ai.bridge.method.device;

import android.content.Context;
import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.battery.AbsGetBatteryInfoMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import e3.e;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import t3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/GetBatteryInfoMethod;", "Lcom/bytedance/ai/bridge/device/battery/AbsGetBatteryInfoMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/device/battery/AbsGetBatteryInfoMethodIDL$GetBatteryInfoResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/battery/AbsGetBatteryInfoMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetBatteryInfoMethod extends AbsGetBatteryInfoMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public GetBatteryInfoMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsGetBatteryInfoMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        g r12 = g.a;
        StringBuilder r1 = new StringBuilder("call start, appletId=");
        a0 r13 = r10.getContainerContext();
        if (r13 == null) goto L5;
        String r14 = r13.getAppletId();
    L6:
        r1.append(r14);
        r12.i("AISDK_JSB_GetBatteryInfoMethod", r1.toString());
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L17
        Context r16 = e.b(r10);     // Catch: Throwable -> L17
        if (r16 != null) goto L11;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");     // Catch: Throwable -> L17
        f3.a r18 = f3.a.f;     // Catch: Throwable -> L17
        r17.append(r18.a);     // Catch: Throwable -> L17
        r17.append(", msg=context is null");     // Catch: Throwable -> L17
        r12.e("AISDK_JSB_GetBatteryInfoMethod", r17.toString());     // Catch: Throwable -> L17
        return new com.bytedance.ai.bridge.core.a.b(0, "context is null", null, r18, 21);
    L11:
        t3.g r19 = f.a(r16);     // Catch: Throwable -> L17
        if (r19 != null) goto L15;
        StringBuilder r20 = new StringBuilder("call failed, errNo=");     // Catch: Throwable -> L17
        f3.a r21 = f3.a.f;     // Catch: Throwable -> L17
        r20.append(r21.a);     // Catch: Throwable -> L17
        r20.append(", msg=battery info is unavailable");     // Catch: Throwable -> L17
        r12.e("AISDK_JSB_GetBatteryInfoMethod", r20.toString());     // Catch: Throwable -> L17
        return new com.bytedance.ai.bridge.core.a.b(0, "battery info is unavailable", null, r21, 21);
    L15:
        r12.i("AISDK_JSB_GetBatteryInfoMethod", "call success");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(AbsGetBatteryInfoMethodIDL.b.class, "<this>");     // Catch: Throwable -> L17
        BaseModel r110 = c.a(AbsGetBatteryInfoMethodIDL.b.class);     // Catch: Throwable -> L17
        AbsGetBatteryInfoMethodIDL.b r22 = (AbsGetBatteryInfoMethodIDL.b) r110;     // Catch: Throwable -> L17
        r22.setLevel(r19.a);     // Catch: Throwable -> L17
        r22.setCharging(r19.b);     // Catch: Throwable -> L17
        Object r23 = Result.constructor-impl(new com.bytedance.ai.bridge.core.a.c(r110));     // Catch: Throwable -> L17
    L19:
        Throwable r111 = Result.exceptionOrNull-impl(r23);
        if (r111 == null) goto L27;
        String r24 = r111.getMessage();
        if (r24 != null) goto L25;
        r24 = "get battery info failed";
    L25:
        String r25 = r24;
        g r26 = g.a;
        StringBuilder r27 = new StringBuilder("call failed, errNo=");
        f3.a r28 = f3.a.f;
        r27.append(r28.a);
        r27.append(", msg=");
        r27.append(r25);
        r26.e("AISDK_JSB_GetBatteryInfoMethod", r27.toString(), r111);
        r23 = new com.bytedance.ai.bridge.core.a.b(0, r25, null, r28, 21);
    L27:
        return (com.bytedance.ai.bridge.core.a) r23;
    L17:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsGetBatteryInfoMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetBatteryInfoMethodIDL.a r13 = (AbsGetBatteryInfoMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
