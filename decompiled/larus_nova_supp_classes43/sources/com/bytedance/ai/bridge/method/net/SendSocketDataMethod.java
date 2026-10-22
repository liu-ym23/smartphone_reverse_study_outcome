package com.bytedance.ai.bridge.method.net;

import android.util.Base64;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.network.AbsSendSocketDataMethodIDL;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/SendSocketDataMethod;", "Lcom/bytedance/ai/bridge/network/AbsSendSocketDataMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsSendSocketDataMethodIDL$SendSocketDataParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsSendSocketDataMethodIDL$SendSocketDataResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendSocketDataMethod extends AbsSendSocketDataMethodIDL {

    public static final class a {
    }

    static {
    }

    public SendSocketDataMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r12, ParamModel r13, f3.h r14) {
        AbsSendSocketDataMethodIDL.a r15 = (AbsSendSocketDataMethodIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        long r1 = r15.getSocketTaskId();
        com.bytedance.ai.utils.g r10 = com.bytedance.ai.utils.g.a;
        r10.d("AISDK_JSB_SendSocketDataMethod", "call start, socketTaskId=" + r1 + ", dataType=" + r15.getDataType() + ", dataSize=" + r15.getData().length());
        c4.a r11 = c4.b.a(r12);
        if (r11 != null) goto L5;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.q;
        r16.append(r17.a);
        r16.append(", msg=The socketTaskId doesn't exist");
        r10.e("AISDK_JSB_SendSocketDataMethod", r16.toString());
        f3.h.a.a(r14, "The socketTaskId doesn't exist", r17, null, 10);
        return;
    L5:
        String r18 = r15.getDataType();
        if (Intrinsics.areEqual(r18, "string") == false) goto L12;
        String r19 = r15.getData();
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r19, "text");
        c4.a.e r110 = r11.j(r12, r1);
        if (r110 != null) goto L10;
        c4.a.d r111 = new c4.a.d("The socketTaskId doesn't exist", f3.a.q);
    L28:
        if (r111 == null) goto L30;
        com.bytedance.ai.utils.g.a.e("AISDK_JSB_SendSocketDataMethod", "call failed, errNo=" + r111.b.a + ", msg=" + r111.a);
        f3.h.a.a(r14, r111.a, r111.b, null, 10);
        return;
    L30:
        com.bytedance.ai.utils.g.a.d("AISDK_JSB_SendSocketDataMethod", "call success, socketTaskId=" + r1);
        Intrinsics.checkNotNullParameter(AbsSendSocketDataMethodIDL.b.class, "<this>");
        r14.b((ResultModel) k3.c.a(AbsSendSocketDataMethodIDL.b.class), "");
        return;
    L10:
        Intrinsics.checkNotNullParameter(r19, "text");
        r111 = r110.c(r19.getBytes(Charsets.UTF_8), 1, "text");
        goto L28
    L12:
        if (Intrinsics.areEqual(r18, "base64") == true) goto L32;
        r111 = new c4.a.d("unsupported dataType " + r15.getDataType(), f3.a.h);
        goto L28
    L32:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L15
        Object r112 = Result.constructor-impl(Base64.decode(r15.getData(), 0));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r112) == false) goto L20;
        r112 = null;
    L20:
        byte[] r113 = (byte[]) r112;
        if (r113 != null) goto L23;
        r111 = new c4.a.d("invalid base64 data", f3.a.h);
        goto L28
    L23:
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "bytes");
        c4.a.e r114 = r11.j(r12, r1);
        if (r114 != null) goto L26;
        r111 = new c4.a.d("The socketTaskId doesn't exist", f3.a.q);
        goto L28
    L26:
        Intrinsics.checkNotNullParameter(r113, "bytes");
        r111 = r114.c(r113, 2, "bytes");
    L15:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
