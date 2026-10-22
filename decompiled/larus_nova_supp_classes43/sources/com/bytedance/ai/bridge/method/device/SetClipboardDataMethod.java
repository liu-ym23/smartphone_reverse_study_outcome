package com.bytedance.ai.bridge.method.device;

import android.app.Activity;
import android.content.ClipData;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.clipboard.AbsSetClipboardDataMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/SetClipboardDataMethod;", "Lcom/bytedance/ai/bridge/device/clipboard/AbsSetClipboardDataMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/clipboard/AbsSetClipboardDataMethodIDL$SetClipboardDataParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/clipboard/AbsSetClipboardDataMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetClipboardDataMethod extends AbsSetClipboardDataMethodIDL {

    public static final class a {
    }

    static {
    }

    public SetClipboardDataMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsSetClipboardDataMethodIDL.b r13 = (AbsSetClipboardDataMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, dataLen=");
        r1.append(r13.getData().length());
        r1.append(", appletId=");
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L5;
        String r15 = r14.getAppletId();
    L6:
        r1.append(r15);
        r0.i("AISDK_JSB_SetClipboardDataMethod", r1.toString());
        Activity r16 = r10.getOwnerActivity();
        if (r16 != null) goto L11;
        r16 = k.b();
        if (r16 != null) goto L11;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a r18 = f3.a.f;
        r17.append(r18.a);
        r17.append(", msg=context is null");
        r0.e("AISDK_JSB_SetClipboardDataMethod", r17.toString());
        h.a.a(r12, "context is null", r18, null, 10);
        return;
    L11:
        ClipData r19 = ClipData.newPlainText(r13.getData(), r13.getData());
        r4.k r20 = r4.a.k;
        if (r20 != null) goto L23;
        StringBuilder r21 = new StringBuilder("call failed, errNo=");
        f3.a r110 = f3.a.g;
        r21.append(r110.a);
        r21.append(", msg=system action depend is null");
        r0.e("AISDK_JSB_SetClipboardDataMethod", r21.toString());
        h.a.a(r12, "system action depend is null", r110, null, 10);
        return;
    L23:
        String r22 = this.a;     // Catch: Exception -> L19
        Intrinsics.checkNotNull(r19);     // Catch: Exception -> L19
        r20.b(r16, r10, r22, r19);     // Catch: Exception -> L19
        if (r20.a(r16, r10, this.a) == true) goto L17;
        StringBuilder r23 = new StringBuilder("call failed, errNo=");     // Catch: Exception -> L19
        f3.a r111 = f3.a.j;     // Catch: Exception -> L19
        r23.append(r111.a);     // Catch: Exception -> L19
        r23.append(", msg=no permission to access clipboard");     // Catch: Exception -> L19
        r0.e("AISDK_JSB_SetClipboardDataMethod", r23.toString());     // Catch: Exception -> L19
        h.a.a(r12, "no permission to access clipboard", r111, null, 10);     // Catch: Exception -> L19
    L22:
        return;
    L17:
        r0.i("AISDK_JSB_SetClipboardDataMethod", "call success");     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(AbsSetClipboardDataMethodIDL.a.class, "<this>");     // Catch: Exception -> L19
        r12.b((ResultModel) c.a(AbsSetClipboardDataMethodIDL.a.class), "");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        g r112 = g.a;
        StringBuilder r24 = new StringBuilder("call failed, errNo=");
        f3.a r25 = f3.a.f;
        r24.append(r25.a);
        r24.append(", msg=setClipboardData failed: ");
        r24.append(e.getMessage());
        r112.e("AISDK_JSB_SetClipboardDataMethod", r24.toString());
        h.a.a(r12, "setClipboardData failed: " + e.getMessage(), r25, null, 10);
        return;
    L5:
        r15 = null;
        goto L6
    }
}
