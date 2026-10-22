package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateNotifyGiftMessageChannelResultModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.updateNotifyGiftMessageChannel")
public final class x7 extends w20.s3<w20.mb, LiveUpdateNotifyGiftMessageChannelResultModel> {
    public x7() {
    }

    public final void invoke(Object r5, CallContext r6) {
        w20.mb r7 = (w20.mb) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        Boolean r8 = r7.a();
        if (r8 == null) goto L5;
        boolean r9 = r8.booleanValue();
    L6:
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r11 == null) goto L11;
        com.bytedance.live.datacontext.m r12 = r11.getGiftMessageChannelStatus();
        if (r12 == null) goto L11;
        r12.setValue(Boolean.valueOf(r9));
    L11:
        finishWithSuccess();
        return;
    L5:
        r9 = false;
        goto L6
    }
}
