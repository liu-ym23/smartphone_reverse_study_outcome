package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.system.ui.AbsHideToastMethodIDL;
import com.bytedance.ai.utils.g;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/HideToastMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsHideToastMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/ui/AbsHideToastMethodIDL$HideInteractionParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/ui/AbsHideToastMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HideToastMethod extends AbsHideToastMethodIDL {

    public static final class a {
    }

    static {
    }

    public HideToastMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsHideToastMethodIDL.b) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r13 = g.a;
        r13.i("AISDK_JSB_HideToastMethod", "call start");
        if ((r10 instanceof e3.a) == false) goto L5;
        e3.a r14 = (e3.a) r10;
    L32:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        IHostStyleUIDepend r1 = r4.a.e;     // Catch: Throwable -> L16
        if (r1 == null) goto L9;
        Boolean r15 = r1.hideToast(r14);     // Catch: Throwable -> L16
    L10:
        Boolean r16 = Boolean.TRUE;     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(r15, r16) == false) goto L13;
        boolean r17 = true;
    L14:
        Object r18 = Result.constructor-impl(Boolean.valueOf(r17));     // Catch: Throwable -> L16
    L18:
        String r19 = "failed to hide toast";
        if (Result.isSuccess-impl(r18) == true) goto L21;
    L24:
        Throwable r20 = Result.exceptionOrNull-impl(r18);
        if (r20 == null) goto L35;
        String r21 = r20.getMessage();
        if (r21 == null) goto L30;
        r19 = r21;
    L30:
        g r22 = g.a;
        StringBuilder r23 = new StringBuilder("call failed, errNo=");
        f3.a r24 = f3.a.f;
        r23.append(r24.a);
        r23.append(", msg=");
        r23.append(r19);
        r22.e("AISDK_JSB_HideToastMethod", r23.toString(), r20);
        h.a.a(r12, r19, r24, null, 10);
        return;
    L35:
        return;
    L21:
        if (((Boolean) r18).booleanValue() == true) goto L23;
        g r25 = g.a;
        StringBuilder r26 = new StringBuilder("call failed, errNo=");
        f3.a r27 = f3.a.g;
        r26.append(r27.a);
        r26.append(", msg=failed to hide toast");
        r25.e("AISDK_JSB_HideToastMethod", r26.toString());
        h.a.a(r12, "failed to hide toast", r27, null, 10);
        return;
    L23:
        g.a.i("AISDK_JSB_HideToastMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsHideToastMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsHideToastMethodIDL.a.class), "");
        goto L24
    L13:
        r13.w("AISDK_JSB_HideToastMethod", "host hideToast unavailable or returned false, fallback to default");     // Catch: Throwable -> L16
        r17 = Intrinsics.areEqual(new i4.c().hideToast(r14), r16);     // Catch: Throwable -> L16
        goto L14
    L9:
        r15 = null;
    L16:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        r14 = null;
        goto L32
    }
}
