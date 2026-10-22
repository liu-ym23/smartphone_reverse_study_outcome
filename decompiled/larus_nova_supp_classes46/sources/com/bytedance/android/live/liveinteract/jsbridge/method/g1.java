package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.SendJoinMatrixInvitationResultModel;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import w20.fe;
import w20.z5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "sendJoinMatrixInvitation")
public final class g1 extends z5<fe, SendJoinMatrixInvitationResultModel> {
    public g1() {
    }

    public final void invoke(Object r4, CallContext r5) {
        fe r6 = (fe) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r7 = r6.c();
        String r0 = "";
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        String r1 = r6.a();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r8 = r6.b();
        if (r8 == null) goto L12;
        r0 = r8;
    L12:
        jc1.k.n(IMiddlewareHostAction.class).sendLiveMatrixInvitation(r7, r0, r1, new f1(this));
    }
}
