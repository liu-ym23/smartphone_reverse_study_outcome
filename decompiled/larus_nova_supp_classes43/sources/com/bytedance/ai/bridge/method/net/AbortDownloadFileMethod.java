package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.net.download.n;
import com.bytedance.ai.bridge.network.AbsAbortDownloadFileMethodIDL;
import d3.a0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbortDownloadFileMethod;", "Lcom/bytedance/ai/bridge/network/AbsAbortDownloadFileMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsAbortDownloadFileMethodIDL$AbortDownloadFileParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsAbortDownloadFileMethodIDL$AbortDownloadFileResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AbortDownloadFileMethod extends AbsAbortDownloadFileMethodIDL {
    public AbortDownloadFileMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, f3.h r12) {
        AbsAbortDownloadFileMethodIDL.a r13 = (AbsAbortDownloadFileMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (StringsKt.isBlank(r13.getDownloadTaskId()) == false) goto L5;
        f3.h.a.a(r12, "downloadFile:fail downloadTaskId is invalid", null, null, 14);
        return;
    L5:
        com.bytedance.ai.bridge.method.net.download.a r0 = n.a(r10);
        if (r0 != null) goto L8;
        f3.h.a.a(r12, "downloadFile:fail download manager is unavailable", null, null, 14);
        return;
    L8:
        String r14 = r13.getDownloadTaskId();
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "downloadTaskId");
        int r15 = com.bytedance.ai.bridge.method.net.download.a.f.c;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        a0 r16 = r10.getContainerContext();
        if (r16 == null) goto L14;
        Intrinsics.checkNotNullParameter(r16, "containerContext");
        String r17 = r16.getAppletId();
        if (r17 != null) goto L13;
        r17 = "";
    L13:
        com.bytedance.ai.bridge.method.net.download.a.f r18 = new com.bytedance.ai.bridge.method.net.download.a.f(r17, r16.getContainerId());
    L15:
        if (r18 != null) goto L17;
        String r19 = "The downloadTaskId doesn't exist";
    L28:
        if (r19 == null) goto L30;
        f3.h.a.a(r12, r19, null, null, 14);
        return;
    L30:
        Intrinsics.checkNotNullParameter(AbsAbortDownloadFileMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsAbortDownloadFileMethodIDL.b.class), "");
        return;
    L17:
        Object r20 = r0.a;
        monitor-enter(r20);
        Map r1 = (Map) ((LinkedHashMap) r0.b).get(r18);     // Catch: Throwable -> L32
        if (r1 == null) goto L23;
        com.bytedance.ai.bridge.method.net.download.a.b r21 = (com.bytedance.ai.bridge.method.net.download.a.b) r1.get(r14);     // Catch: Throwable -> L32
    L24:
        monitor-exit(r20);
        if (r21 != null) goto L27;
        r19 = "The downloadTaskId doesn't exist";
        goto L28
    L27:
        r19 = r21.b();
        goto L28
    L23:
        r21 = null;
    L32:
        th = move-exception;
        throw th;
    L14:
        r18 = null;
        goto L15
    }
}
