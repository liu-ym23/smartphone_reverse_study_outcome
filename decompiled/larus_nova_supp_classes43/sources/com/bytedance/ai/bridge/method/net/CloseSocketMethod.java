package com.bytedance.ai.bridge.method.net;

import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.network.AbsCloseSocketMethodIDL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/CloseSocketMethod;", "Lcom/bytedance/ai/bridge/network/AbsCloseSocketMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsCloseSocketMethodIDL$CloseSocketParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsCloseSocketMethodIDL$CloseSocketResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloseSocketMethod extends AbsCloseSocketMethodIDL {

    public static final class a {
    }

    static {
    }

    public CloseSocketMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, f3.h r12) {
        AbsCloseSocketMethodIDL.a r13 = (AbsCloseSocketMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Integer r0 = r13.getCode();
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;
        StringBuilder r15 = new StringBuilder("call start, socketTaskId=");
        r15.append(r13.getSocketTaskId());
        r15.append(", code=");
        r15.append(r1);
        r15.append(", hasReason=");
        String r16 = r13.getReason();
        if (r16 != null) goto L9;
    L12:
        boolean r17 = true;
    L13:
        r15.append(!r17);
        r14.i("AISDK_JSB_CloseSocketMethod", r15.toString());
        c4.a r18 = c4.b.a(r10);
        if (r18 != null) goto L16;
        StringBuilder r19 = new StringBuilder("call failed, errNo=");
        f3.a r20 = f3.a.q;
        r19.append(r20.a);
        r19.append(", msg=The socketTaskId doesn't exist");
        r14.e("AISDK_JSB_CloseSocketMethod", r19.toString());
        f3.h.a.a(r12, "The socketTaskId doesn't exist", r20, null, 10);
        return;
    L16:
        long r21 = r13.getSocketTaskId();
        String r22 = r13.getReason();
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        int r23 = c4.a.c.c;
        c4.a.c r110 = c4.a.c.C0009a.a(r10);
        if (r110 != null) goto L19;
        int r111 = c4.a.d;
        c4.a.d r112 = new c4.a.d("The socketTaskId doesn't exist", f3.a.q);
    L26:
        if (r112 == null) goto L28;
        r14.e("AISDK_JSB_CloseSocketMethod", "call failed, errNo=" + r112.b.a + ", msg=" + r112.a);
        f3.h.a.a(r12, r112.a, r112.b, null, 10);
        return;
    L28:
        r14.i("AISDK_JSB_CloseSocketMethod", "call success, socketTaskId=" + r13.getSocketTaskId());
        Intrinsics.checkNotNullParameter(AbsCloseSocketMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsCloseSocketMethodIDL.b.class), "");
        return;
    L19:
        Object r24 = r18.b;
        monitor-enter(r24);
        c4.a.e r113 = r18.i(r21, r110, null);     // Catch: Throwable -> L30
        monitor-exit(r24);
        if (r113 != null) goto L25;
        r112 = new c4.a.d("The socketTaskId doesn't exist", f3.a.q);
        goto L26
    L25:
        r112 = r113.a(r1, r22);
    L30:
        th = move-exception;
        throw th;
    L9:
        if (r16.length() == 0) goto L12;
        r17 = false;
        goto L13
    L5:
        r1 = IServerListener.WHAT_BYTELINK_SINK_ERROR;
        goto L6
    }
}
