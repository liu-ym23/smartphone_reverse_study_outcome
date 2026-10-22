package com.bytedance.android.livesdk.jsbridge.methods;

import android.view.View;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "registerLiveLifeMsgCenter")
public final class n3 extends q<o3, RegisterLiveLifeMsgCenterResultModel> {
    public n3() {
    }

    public final void invoke(Object r6, final CallContext r7) {
        o3 r8 = (o3) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        IHostLiveLocalLife r0 = jc1.k.n(IHostLiveLocalLife.class);
        String r1 = r8.a();
        JsonObject r9 = r8.b();
        if (r9 == null) goto L9;
        View r3 = r7.d;
        if (r3 == null) goto L7;
        int r4 = r3.hashCode();
    L8:
        r9.addProperty("containerID", String.valueOf(r4));
        Unit r5 = Unit.INSTANCE;
    L10:
        int r10 = r0.registerLiveLifeMsgCenter(r1, r9, new RegisterLiveLifeMsgCenterMethod$invoke$result$2(r7));
        RegisterLiveLifeMsgCenterResultModel r11 = new RegisterLiveLifeMsgCenterResultModel();
        if (r10 != 1) goto L13;
        RegisterLiveLifeMsgCenterResultModel.Code r13 = RegisterLiveLifeMsgCenterResultModel.Code.Success;
    L14:
        r11.a(r13);
        r11.b(null);
        Unit r14 = Unit.INSTANCE;
        finishWithResult(r11);
        return;
    L13:
        r13 = RegisterLiveLifeMsgCenterResultModel.Code.Failed;
        goto L14
    L7:
        r4 = 0;
        goto L8
    L9:
        r9 = null;
        goto L10
    }
}
