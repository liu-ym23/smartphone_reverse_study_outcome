package com.bytedance.ai.bridge.method.device.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.phone.AbsSendSmsMethodIDL;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/phone/SendSmsMethod;", "Lcom/bytedance/ai/bridge/device/phone/AbsSendSmsMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/phone/AbsSendSmsMethodIDL$SendSmsParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/phone/AbsSendSmsMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendSmsMethod extends AbsSendSmsMethodIDL {

    public static final class a {
    }

    static {
    }

    public SendSmsMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r13, ParamModel r14, h r15) {
        AbsSendSmsMethodIDL.b r16 = (AbsSendSmsMethodIDL.b) r14;
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "callback");
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, hasPhoneNumber=");
        String r10 = r16.getPhoneNumber();
        boolean r11 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        r1.append(!r12);
        r1.append(", hasMessage=");
        String r17 = r16.getMessage();
        if (r17 != null) goto L12;
    L15:
        boolean r18 = true;
    L16:
        r1.append(!r18);
        r1.append(", appletId=");
        a0 r19 = r13.getContainerContext();
        if (r19 == null) goto L19;
        String r20 = r19.getAppletId();
    L20:
        r1.append(r20);
        r0.i("AISDK_JSB_SendSmsMethod", r1.toString());
        Activity r110 = r13.getOwnerActivity();
        if (r110 != null) goto L25;
        r110 = k.b();
        if (r110 != null) goto L25;
        StringBuilder r111 = new StringBuilder("call failed, errNo=");
        f3.a r112 = f3.a.f;
        r111.append(r112.a);
        r111.append(", msg=context is null");
        r0.e("AISDK_JSB_SendSmsMethod", r111.toString());
        h.a.a(r15, "context is null", r112, null, 10);
        return;
    L25:
        String r21 = r16.getPhoneNumber();
        if (r21 == null) goto L28;
        String r22 = StringsKt.trim(r21).toString();
    L30:
        if (r22 != null) goto L32;
        r22 = "";
    L32:
        Intent r23 = new Intent("android.intent.action.SENDTO", UriProtector.parse("smsto:" + Uri.encode(r22)));
        String r24 = r16.getMessage();
        if (r24 != null) goto L35;
    L36:
        r11 = true;
    L37:
        if (r11 == true) goto L44;
        r23.putExtra("sms_body", r16.getMessage());
    L44:
        r110.startActivity(r23);     // Catch: Exception -> L41
        r0.i("AISDK_JSB_SendSmsMethod", "call success");     // Catch: Exception -> L41
        Intrinsics.checkNotNullParameter(AbsSendSmsMethodIDL.a.class, "<this>");     // Catch: Exception -> L41
        r15.b((ResultModel) c.a(AbsSendSmsMethodIDL.a.class), "");     // Catch: Exception -> L41
        return;
    L41:
        e = move-exception;
        g r113 = g.a;
        StringBuilder r25 = new StringBuilder("call failed, errNo=");
        f3.a r26 = f3.a.f;
        r25.append(r26.a);
        r25.append(", msg=sendSms failed: ");
        r25.append(e.getMessage());
        r113.e("AISDK_JSB_SendSmsMethod", r25.toString());
        h.a.a(r15, "sendSms failed: " + e.getMessage(), r26, null, 10);
        return;
    L35:
        if (r24.length() != 0) goto L37;
    L28:
        r22 = null;
        goto L30
    L19:
        r20 = null;
        goto L20
    L12:
        if (r17.length() == 0) goto L15;
        r18 = false;
        goto L16
    L5:
        if (r10.length() == 0) goto L8;
        r12 = false;
        goto L9
    }
}
