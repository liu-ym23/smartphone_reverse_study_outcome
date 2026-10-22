package com.obric.miniapp.aibridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.obric.miniapp.utils.MiniAppUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/SendSmsMethod;", "Lcom/obric/miniapp/aibridge/AbsSendSmsMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsSendSmsMethodIDL$SendSmsParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsSendSmsMethodIDL$SendSmsResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendSmsMethod extends AbsSendSmsMethodIDL {
    public SendSmsMethod() {
    }

    public final void handle(e3.d r6, ParamModel r7, f3.h r8) {
        AbsSendSmsMethodIDL.a r9 = (AbsSendSmsMethodIDL.a) r7;
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        Activity r10 = AppHost.a.a().getCurrentActivity();
        if ((r10 instanceof Context) == true) goto L7;
        r10 = null;
    L7:
        if (r10 != null) goto L10;
        f3.h.a.a(r8, "No available activity context", null, null, 14);
        return;
    L10:
        if (r9.getPhoneNumber().length() != 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        f3.h.a.a(r8, "phoneNumber is empty", null, null, 14);
        return;
    L15:
        MiniAppUtils r0 = MiniAppUtils.a;
        String r1 = r9.getPhoneNumber();
        String r11 = r9.getMessage();
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r1, "phoneNumber");
        Intrinsics.checkNotNullParameter(r11, "message");
        Intent r3 = new Intent("android.intent.action.SENDTO");
        r3.setData(UriProtector.parse("smsto:" + r1));
        r3.putExtra("sms_body", r11);
        r3.addFlags(268435456);
        r10.startActivity(r3);
        Intrinsics.checkNotNullParameter(AbsSendSmsMethodIDL.b.class, "<this>");
        r8.b(k3.c.a(AbsSendSmsMethodIDL.b.class), "");
        return;
    L12:
        r2 = false;
        goto L13
    }
}
