package com.bytedance.ai.bridge.method.net;

import android.text.TextUtils;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.method.net.download.n;
import com.bytedance.ai.bridge.network.AbsDownloadFileMethodIDL;
import d3.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/DownloadFileMethod;", "Lcom/bytedance/ai/bridge/network/AbsDownloadFileMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsDownloadFileMethodIDL$DownloadFileParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsDownloadFileMethodIDL$DownloadFileResultModel;", "logRejection", "downloadTaskId", "", "reason", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DownloadFileMethod extends AbsDownloadFileMethodIDL {

    public static final class a {
    }

    static {
    }

    public DownloadFileMethod() {
    }

    public static void b(e3.d r10, String r11, String r12) {
        a0 r13 = r10.getContainerContext();
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        StringBuilder r1 = new StringBuilder("[AppletDownload] applet=");
        if (r13 == null) goto L5;
        String r14 = r13.getAppletId();
    L6:
        if (r14 != null) goto L8;
        r14 = "";
    L8:
        r1.append(r14);
        r1.append(" containerType=");
        if (r13 == null) goto L14;
        ContainerType r15 = r13.getContainerType();
        if (r15 == null) goto L14;
        String r16 = r15.getTypeName();
        if (r16 == null) goto L14;
    L15:
        r1.append(r16);
        r1.append(" task=");
        if (StringsKt.isBlank(r11) == false) goto L18;
        r11 = "unknown";
    L18:
        r1.append(r11);
        r1.append(" reason=");
        r1.append(r12);
        r0.w("DownloadFileMethod", r1.toString());
        return;
    L14:
        r16 = "unknown";
        goto L15
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r12, ParamModel r13, f3.h r14) {
        AbsDownloadFileMethodIDL.a r15 = (AbsDownloadFileMethodIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        String r10 = r15.getUrl();
        if (TextUtils.isEmpty(r10) == false) goto L6;
        b(r12, r15.getDownloadTaskId(), "url is invalid");
        f3.h.a.a(r14, "downloadFile:fail url is invalid", null, null, 14);
        return;
    L6:
        if (StringsKt.isBlank(r15.getDownloadTaskId()) == false) goto L8;
        b(r12, r15.getDownloadTaskId(), "downloadTaskId is invalid");
        f3.h.a.a(r14, "downloadFile:fail downloadTaskId is invalid", null, null, 14);
        return;
    L8:
        com.bytedance.ai.bridge.method.net.download.a r1 = n.a(r12);
        if (r1 != null) goto L11;
        b(r12, r15.getDownloadTaskId(), "download manager is unavailable");
        f3.h.a.a(r14, "downloadFile:fail download manager is unavailable", null, null, 14);
        return;
    L11:
        String r16 = r1.f(r12, r10, r15.getHeader(), r15.getTimeout(), r15.getFilePath(), r15.getDownloadTaskId(), r14);
        if (r16 == null) goto L18;
        f3.h.a.a(r14, r16, null, null, 14);
        return;
    }
}
