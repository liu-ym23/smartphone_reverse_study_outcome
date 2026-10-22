package com.bytedance.android.livesdk.jsbridge.methods;

import android.view.View;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "postLiveLifeMsg")
public final class e3 extends p<f3, PostLiveLifeMsgResultModel> {
    public e3() {
    }

    public final void invoke(Object r7, final CallContext r8) {
        f3 r9 = (f3) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        IHostLiveLocalLife r0 = jc1.k.n(IHostLiveLocalLife.class);
        String r1 = r9.a();
        JsonObject r2 = r9.b();
        Integer r3 = null;
        if (r2 == null) goto L9;
        View r4 = r8.d;
        if (r4 == null) goto L7;
        int r5 = r4.hashCode();
    L8:
        r2.addProperty("containerID", String.valueOf(r5));
        Unit r6 = Unit.INSTANCE;
    L10:
        JsonObject r10 = r0.postMsg(r1, r2, r9.c(), new PostLiveLifeMsgMethod$invoke$result$2(r8));
        JsonElement r11 = r10.get("status");
        if (r11 == null) goto L13;
        r3 = Integer.valueOf(r11.getAsInt());
    L13:
        PostLiveLifeMsgResultModel r13 = new PostLiveLifeMsgResultModel();
        if (r3 != null) goto L17;
    L19:
        PostLiveLifeMsgResultModel.Code r14 = PostLiveLifeMsgResultModel.Code.Failed;
    L20:
        r13.a(r14);
        PostLiveLifeMsgResultModel.a r15 = new PostLiveLifeMsgResultModel.a();
        r15.a(r10.get("data"));
        Unit r16 = Unit.INSTANCE;
        r13.b(r15);
        finishWithResult(r13);
        return;
    L17:
        if (r3.intValue() != 1) goto L19;
        r14 = PostLiveLifeMsgResultModel.Code.Success;
        goto L20
    L7:
        r5 = 0;
        goto L8
    L9:
        r2 = null;
        goto L10
    }
}
