package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.ShareItemResultModel;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import w20.re;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "shareItem")
public final class mc extends w20.j6<re, ShareItemResultModel> {
    public mc() {
    }

    public final void invoke(Object r9, CallContext r11) {
        re r12 = (re) r9;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r0 = r12.b();
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        String r1 = r12.c();
        if (r1 != null) goto L9;
        String r3 = "";
    L10:
        w22.a r13 = new w22.a(r2, r3, r12.a(), r12.d(), null, 16);
        ICommentService r14 = jc1.k.f(ICommentService.class);
        if (r14 == null) goto L14;
        r14.startInteractivityShare(r13, new lc(this));
        return;
    L14:
        return;
    L9:
        r3 = r1;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }
}
