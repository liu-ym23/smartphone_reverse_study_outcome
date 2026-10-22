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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/MakePhoneCallMethod;", "Lcom/obric/miniapp/aibridge/AbsMakePhoneCallMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsMakePhoneCallMethodIDL$MakePhoneCallParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsMakePhoneCallMethodIDL$MakePhoneCallResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MakePhoneCallMethod extends AbsMakePhoneCallMethodIDL {
    public MakePhoneCallMethod() {
    }

    public final void handle(e3.d r4, ParamModel r5, f3.h r6) {
        AbsMakePhoneCallMethodIDL.a r7 = (AbsMakePhoneCallMethodIDL.a) r5;
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Activity r8 = AppHost.a.a().getCurrentActivity();
        if ((r8 instanceof Context) == true) goto L7;
        r8 = null;
    L7:
        if (r8 != null) goto L10;
        f3.h.a.a(r6, "No available activity context", null, null, 14);
        return;
    L10:
        if (r7.getPhoneNumber().length() != 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        f3.h.a.a(r6, "phoneNumber is empty", null, null, 14);
        return;
    L15:
        MiniAppUtils r0 = MiniAppUtils.a;
        String r9 = r7.getPhoneNumber();
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "phoneNumber");
        Intent r1 = new Intent("android.intent.action.DIAL");
        r1.setData(UriProtector.parse("tel:" + r9));
        r1.addFlags(268435456);
        r8.startActivity(r1);
        Intrinsics.checkNotNullParameter(AbsMakePhoneCallMethodIDL.b.class, "<this>");
        r6.b(k3.c.a(AbsMakePhoneCallMethodIDL.b.class), "");
        return;
    L12:
        r2 = false;
        goto L13
    }
}
