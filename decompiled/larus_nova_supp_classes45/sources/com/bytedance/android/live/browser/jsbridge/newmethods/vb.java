package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendPublicScreenTextMessage")
public final class vb extends t<wb, SendPublicScreenTextMessageResultModel> {
    public vb() {
    }

    public final void invoke(Object r3, CallContext r4) {
        final wb r5 = (wb) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.m.a(null) != null) goto L5;
        finishWithFailure();
    L5:
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.livesdk.chatroom.utils.o3.f();
        if (r0 == null) goto L10;
        Boolean r1 = r0.isMatchRoom();
        if (r1 == null) goto L10;
        final boolean r2 = r1.booleanValue();
    L11:
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.livesdk.interactivity.api.publicscreen.m.a(null);
        if (r6 == null) goto L15;
        r6.c(new SendPublicScreenTextMessageMethod$invoke$1(this, r5, r2));
        return;
    L15:
        return;
    L10:
        r2 = false;
        goto L11
    }
}
