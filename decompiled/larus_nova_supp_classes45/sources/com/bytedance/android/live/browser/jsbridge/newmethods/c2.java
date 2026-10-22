package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "closeAnchorStatusCenterPanel")
public final class c2 extends w20.v<JsonObject, JsonObject> {
    public c2() {
    }

    public final void invoke(Object r4, CallContext r5) {
        Intrinsics.checkNotNullParameter((JsonObject) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L10;
        com.bytedance.live.datacontext.j r7 = r6.getAnchorStatusPanelViewModel();
        if (r7 == null) goto L11;
        nz.f r8 = (nz.f) r7.getValue();
        if (r8 == null) goto L12;
        r8.a();
        return;
    L12:
        return;
    L11:
        return;
    }
}
