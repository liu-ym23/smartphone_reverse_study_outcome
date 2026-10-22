package com.bytedance.android.livesdk.jsbridge.methods;

import android.view.View;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "unRegisterLiveLifeMsgCenter")
public final class q4 extends t<r4, UnRegisterLiveLifeMsgCenterResultModel> {
    public q4() {
    }

    public final void invoke(Object r5, final CallContext r6) {
        r4 r7 = (r4) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        IHostLiveLocalLife r0 = jc1.k.n(IHostLiveLocalLife.class);
        String r1 = r7.a();
        JsonObject r8 = r7.b();
        if (r8 == null) goto L9;
        View r2 = r6.d;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        r8.addProperty("containerID", String.valueOf(r3));
        Unit r4 = Unit.INSTANCE;
    L10:
        int r9 = r0.unRegisterLiveLifeMsgCenter(r1, r8, new UnRegisterLiveLifeMsgCenterMethod$invoke$result$2(r6));
        UnRegisterLiveLifeMsgCenterResultModel r10 = new UnRegisterLiveLifeMsgCenterResultModel();
        if (r9 != 1) goto L13;
        UnRegisterLiveLifeMsgCenterResultModel.Code r11 = UnRegisterLiveLifeMsgCenterResultModel.Code.Success;
    L14:
        r10.a(r11);
        Unit r13 = Unit.INSTANCE;
        finishWithResult(r10);
        return;
    L13:
        r11 = UnRegisterLiveLifeMsgCenterResultModel.Code.Failed;
        goto L14
    L7:
        r3 = 0;
        goto L8
    L9:
        r8 = null;
        goto L10
    }
}
