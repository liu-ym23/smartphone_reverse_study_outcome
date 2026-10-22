package com.bytedance.ai.bridge.method.device;

import android.app.Activity;
import android.content.ClipData;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.clipboard.AbsGetClipboardDataMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/GetClipboardDataMethod;", "Lcom/bytedance/ai/bridge/device/clipboard/AbsGetClipboardDataMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/clipboard/AbsGetClipboardDataMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/clipboard/AbsGetClipboardDataMethodIDL$GetClipboardDataResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetClipboardDataMethod extends AbsGetClipboardDataMethodIDL {

    public static final class a {
    }

    static {
    }

    public GetClipboardDataMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetClipboardDataMethodIDL.a) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r13 = g.a;
        StringBuilder r0 = new StringBuilder("call start, appletId=");
        a0 r1 = r10.getContainerContext();
        String r14 = null;
        if (r1 == null) goto L5;
        String r15 = r1.getAppletId();
    L6:
        r0.append(r15);
        r13.i("AISDK_JSB_GetClipboardDataMethod", r0.toString());
        Activity r16 = r10.getOwnerActivity();
        if (r16 != null) goto L11;
        r16 = k.b();
        if (r16 != null) goto L11;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a r18 = f3.a.f;
        r17.append(r18.a);
        r17.append(", msg=context is null");
        r13.e("AISDK_JSB_GetClipboardDataMethod", r17.toString());
        h.a.a(r12, "context is null", r18, null, 10);
        return;
    L11:
        r4.k r19 = r4.a.k;
        if (r19 != null) goto L14;
        StringBuilder r20 = new StringBuilder("call failed, errNo=");
        f3.a r21 = f3.a.g;
        r20.append(r21.a);
        r20.append(", msg=system action depend is null");
        r13.e("AISDK_JSB_GetClipboardDataMethod", r20.toString());
        h.a.a(r12, "system action depend is null", r21, null, 10);
        return;
    L14:
        ClipData r22 = r19.c(r16, r10, this.a);
        if (r22 != null) goto L17;
    L22:
        r14 = "";
    L23:
        r13.i("AISDK_JSB_GetClipboardDataMethod", "call success, dataLen=" + r14.length());
        Intrinsics.checkNotNullParameter(AbsGetClipboardDataMethodIDL.b.class, "<this>");
        BaseModel r23 = c.a(AbsGetClipboardDataMethodIDL.b.class);
        ((AbsGetClipboardDataMethodIDL.b) r23).setData(r14);
        r12.b((ResultModel) r23, "");
        return;
    L17:
        if (r22.getItemCount() <= 0) goto L22;
        CharSequence r24 = r22.getItemAt(0).coerceToText(r16);
        if (r24 == null) goto L21;
        r14 = r24.toString();
    L21:
        if (r14 != null) goto L23;
    L5:
        r15 = null;
        goto L6
    }
}
