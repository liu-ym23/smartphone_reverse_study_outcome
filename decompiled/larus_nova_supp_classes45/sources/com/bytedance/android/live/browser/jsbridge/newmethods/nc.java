package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.ShareTicketResultModel;
import com.bytedance.android.live.room.api.IMatchShareService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import w20.te;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "shareTicket")
public final class nc extends w20.l6<te, ShareTicketResultModel> {

    public static final class a {
    }

    static {
    }

    public nc() {
    }

    public final void invoke(Object r7, CallContext r8) {
        te r9 = (te) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        Context r11 = r8.getContext();
        if ((r11 instanceof Activity) == true) goto L5;
        r11 = null;
    L5:
        Activity r1 = (Activity) r11;
        if (r1 == null) goto L24;
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L24;
        Boolean r12 = r9.c();
        if (r12 == null) goto L12;
        boolean r2 = r12.booleanValue();
    L13:
        String r13 = r9.a();
        if (r13 != null) goto L16;
        r13 = "";
    L16:
        String r4 = r9.d();
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        String r14 = r9.b();
        if (r14 != null) goto L22;
        String r5 = "";
    L23:
        r0.launchMatchTicketShare(r1, r2, r13, r4, r5);
        goto L24
    L22:
        r5 = r14;
        goto L23
    L12:
        r2 = false;
    L24:
        finishWithSuccess();
    }
}
