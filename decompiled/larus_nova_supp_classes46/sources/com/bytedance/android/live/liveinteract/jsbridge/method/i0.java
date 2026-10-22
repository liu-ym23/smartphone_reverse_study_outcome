package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.SendGiftPlayerEventResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import w20.de;
import w20.x5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i0 extends x5<de, SendGiftPlayerEventResultModel> {
    public i0() {
    }

    public final void invoke(Object r3, CallContext r4) {
        de r5 = (de) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r6 = r5.getType();
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        JsonObject r7 = r5.a();
        ALogger.i("MultiLinkSendGiftPlayerEventMethod", "sendGiftPlayerEvent: " + r6 + ", " + r7);
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r0 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r7 == null) goto L9;
        if (r0 == null) goto L9;
        r0.Le(r6, r7, new h0(this));
        return;
    L9:
        finishWithFailure();
    }
}
