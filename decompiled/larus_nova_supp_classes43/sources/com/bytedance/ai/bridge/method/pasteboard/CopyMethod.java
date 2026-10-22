package com.bytedance.ai.bridge.method.pasteboard;

import android.app.Activity;
import android.content.ClipData;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import e3.d;
import f2.k;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/pasteboard/CopyMethod;", "Lcom/bytedance/ai/bridge/method/pasteboard/AbsCopyMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/pasteboard/AbsCopyMethodIDL$CopyParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/pasteboard/AbsCopyMethodIDL$CopyResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CopyMethod extends AbsCopyMethodIDL {
    public CopyMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsCopyMethodIDL.a r13 = (AbsCopyMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r14 = r13.getContent();
        if (r14.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        h.a.a(r12, "The content parameter should not be empty.", null, null, 14);
        return;
    L9:
        Activity r1 = r10.getOwnerActivity();
        if (r1 != null) goto L14;
        r1 = k.b();
        if (r1 != null) goto L14;
        h.a.a(r12, "context is null", null, null, 14);
        return;
    L14:
        r4.k r15 = a.k;
        if (r15 != null) goto L17;
        h.a.a(r12, "system action depend is null", null, null, 14);
        return;
    L17:
        r15.b(r1, r10, this.a, ClipData.newPlainText(r14, r14));
        if (r15.a(r1, r10, this.a) == true) goto L20;
        h.a.a(r12, "no permission to copy", null, null, 14);
        return;
    L20:
        Intrinsics.checkNotNullParameter(AbsCopyMethodIDL.b.class, "<this>");
        r12.b((ResultModel) c.a(AbsCopyMethodIDL.b.class), "");
        return;
    L5:
        r0 = false;
        goto L7
    }
}
