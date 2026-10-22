package com.bytedance.ai.bridge.method.device.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.phone.AbsMakePhoneCallMethodIDL;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/phone/MakePhoneCallMethod;", "Lcom/bytedance/ai/bridge/device/phone/AbsMakePhoneCallMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/phone/AbsMakePhoneCallMethodIDL$MakePhoneCallParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/phone/AbsMakePhoneCallMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MakePhoneCallMethod extends AbsMakePhoneCallMethodIDL {

    public static final class a {
    }

    static {
    }

    public MakePhoneCallMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsMakePhoneCallMethodIDL.b r13 = (AbsMakePhoneCallMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r1 = g.a;
        StringBuilder r14 = new StringBuilder("call start, hasPhoneNumber=");
        boolean r15 = true;
        if (r13.getPhoneNumber().length() <= 0) goto L5;
        boolean r16 = true;
    L6:
        r14.append(r16);
        r14.append(", appletId=");
        a0 r17 = r10.getContainerContext();
        if (r17 == null) goto L9;
        String r18 = r17.getAppletId();
    L10:
        r14.append(r18);
        r1.i("AISDK_JSB_MakePhoneCallMethod", r14.toString());
        String r19 = r13.getPhoneNumber();
        if (r19.length() == 0) goto L15;
        r15 = false;
    L15:
        if (r15 == false) goto L17;
        StringBuilder r20 = new StringBuilder("call failed, errNo=");
        f3.a r21 = f3.a.h;
        r20.append(r21.a);
        r20.append(", msg=phoneNumber is empty");
        r1.e("AISDK_JSB_MakePhoneCallMethod", r20.toString());
        h.a.a(r12, "The phoneNumber parameter should not be empty.", r21, null, 10);
        return;
    L17:
        Activity r22 = r10.getOwnerActivity();
        if (r22 != null) goto L27;
        r22 = k.b();
        if (r22 != null) goto L27;
        StringBuilder r23 = new StringBuilder("call failed, errNo=");
        f3.a r24 = f3.a.f;
        r23.append(r24.a);
        r23.append(", msg=context is null");
        r1.e("AISDK_JSB_MakePhoneCallMethod", r23.toString());
        h.a.a(r12, "context is null", r24, null, 10);
        return;
    L27:
        r22.startActivity(new Intent("android.intent.action.DIAL", UriProtector.parse("tel:" + Uri.encode(r19))));     // Catch: Exception -> L24
        r1.i("AISDK_JSB_MakePhoneCallMethod", "call success");     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(AbsMakePhoneCallMethodIDL.a.class, "<this>");     // Catch: Exception -> L24
        r12.b((ResultModel) c.a(AbsMakePhoneCallMethodIDL.a.class), "");     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        g r25 = g.a;
        StringBuilder r0 = new StringBuilder("call failed, errNo=");
        f3.a r26 = f3.a.f;
        r0.append(r26.a);
        r0.append(", msg=makePhoneCall failed: ");
        r0.append(e.getMessage());
        r25.e("AISDK_JSB_MakePhoneCallMethod", r0.toString());
        h.a.a(r12, "makePhoneCall failed: " + e.getMessage(), r26, null, 10);
        return;
    L9:
        r18 = null;
        goto L10
    L5:
        r16 = false;
        goto L6
    }
}
