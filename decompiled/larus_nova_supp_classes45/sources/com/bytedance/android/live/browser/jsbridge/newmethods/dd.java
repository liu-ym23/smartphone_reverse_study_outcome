package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.StreamBottomOffsetResultModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "streamBottomOffset")
public final class dd extends w20.v6<JsonObject, StreamBottomOffsetResultModel> {
    public dd() {
    }

    public final void invoke(Object r7, CallContext r8) {
        Intrinsics.checkNotNullParameter((JsonObject) r7, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        StreamBottomOffsetResultModel r9 = new StreamBottomOffsetResultModel();
        r9.a(StreamBottomOffsetResultModel.Code.Success);
        StreamBottomOffsetResultModel.a r11 = new StreamBottomOffsetResultModel.a();
        RoomContext.a r0 = RoomContext.Companion;
        Long r1 = null;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        if (r5 == null) goto L10;
        com.bytedance.live.datacontext.m r6 = r5.getVsHybridPanelFirstFrameHeight();
        if (r6 == null) goto L10;
        Long r12 = (Long) r6.getValue();
        if (r12 == null) goto L10;
        r1 = r12;
    L15:
        if (r1 != null) goto L18;
        r1 = 200L;
    L18:
        r11.a(r1);
        Unit r2 = Unit.INSTANCE;
        r9.b(r11);
        finishWithResult(r9);
        return;
    L10:
        RoomContext r3 = RoomContext.a.c(r0, null, 0, 3);
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.m r4 = r3.getVsHybridPanelHeight();
        if (r4 == null) goto L15;
        r1 = (Long) r4.getValue();
        goto L15
    }
}
