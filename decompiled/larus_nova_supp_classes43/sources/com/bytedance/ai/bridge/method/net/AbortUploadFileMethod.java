package com.bytedance.ai.bridge.method.net;

import android.text.TextUtils;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.network.AbsAbortUploadFileMethodIDL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbortUploadFileMethod;", "Lcom/bytedance/ai/bridge/network/AbsAbortUploadFileMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsAbortUploadFileMethodIDL$AbortUploadFileParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsAbortUploadFileMethodIDL$AbortUploadFileResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AbortUploadFileMethod extends AbsAbortUploadFileMethodIDL {
    public AbortUploadFileMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, f3.h r12) {
        AbsAbortUploadFileMethodIDL.a r13 = (AbsAbortUploadFileMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r14 = r13.getUploadTaskId();
        if (TextUtils.isEmpty(r14) == false) goto L5;
        f3.h.a.a(r12, "uploadTaskId is empty", null, null, 14);
        return;
    L5:
        d4.b r0 = d4.c.c(r10);
        if (r0 != null) goto L8;
        f3.h.a.a(r12, "upload manager is unavailable", null, null, 14);
        return;
    L8:
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "uploadTaskId");
        int r15 = d4.b.c.c;
        d4.b.c r16 = d4.b.c.a.a(r10);
        if (r16 != null) goto L11;
        String r17 = "The uploadTaskId doesn't exist";
    L39:
        if (r17 == null) goto L41;
        f3.h.a.a(r12, r17, null, null, 14);
        return;
    L41:
        Intrinsics.checkNotNullParameter(AbsAbortUploadFileMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsAbortUploadFileMethodIDL.b.class), "");
        return;
    L11:
        Object r18 = r0.a;
        monitor-enter(r18);
        d4.b.i r19 = r0.i(r14, r16, null);     // Catch: Throwable -> L43
        if (r19 == null) goto L16;
        Pair r20 = TuplesKt.to(r19, Boolean.TRUE);     // Catch: Throwable -> L43
    L31:
        monitor-exit(r18);
        d4.b.i r21 = (d4.b.i) r20.getFirst();
        if (r21 == null) goto L36;
        r21.a();
    L36:
        if (((Boolean) r20.getSecond()).booleanValue() == false) goto L38;
        r17 = null;
        goto L39
    L38:
        r17 = "The uploadTaskId doesn't exist";
        goto L39
    L16:
        Map r22 = (Map) ((LinkedHashMap) r0.c).get(r16);     // Catch: Throwable -> L43
        if (r22 == null) goto L19;
        d4.b.e r23 = (d4.b.e) r22.remove(r14);     // Catch: Throwable -> L43
    L21:
        if (r22 != null) goto L23;
    L25:
        boolean r24 = false;
    L26:
        if (r24 == false) goto L28;
        r0.c.remove(r16);     // Catch: Throwable -> L43
    L28:
        if (r23 == null) goto L30;
        r23.a = true;     // Catch: Throwable -> L43
        r20 = TuplesKt.to(null, Boolean.TRUE);     // Catch: Throwable -> L43
        goto L31
    L30:
        r20 = TuplesKt.to(null, Boolean.FALSE);     // Catch: Throwable -> L43
        goto L31
    L23:
        if (r22.isEmpty() != true) goto L25;
        r24 = true;
        goto L26
    L19:
        r23 = null;
    L43:
        th = move-exception;
        throw th;
    }
}
