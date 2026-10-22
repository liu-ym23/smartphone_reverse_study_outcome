package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenLiveMicroAppResultModel;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openLiveMicroApp")
public final class v8 extends w20.m4<w20.lc, OpenLiveMicroAppResultModel> {
    public v8() {
    }

    public final void invoke(Object r5, CallContext r6) {
        w20.lc r7 = (w20.lc) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L9;
        com.bytedance.live.datacontext.i r9 = r8.isAnchor();
        if (r9 == null) goto L9;
        Boolean r11 = (Boolean) r9.getValue();
        if (r11 == null) goto L9;
        boolean r12 = r11.booleanValue();
    L10:
        String r0 = "";
        if (r12 == false) goto L17;
        IOpenPlatformAnchorService r13 = jc1.k.n(IOpenPlatformAnchorService.class);
        String r1 = r7.b();
        if (r1 == null) goto L16;
        r0 = r1;
    L16:
        r13.openLiveMicroApp(r0, r7.a());
    L22:
        finishWithSuccess();
        return;
    L17:
        IOpenPlatformAudienceService r14 = jc1.k.n(IOpenPlatformAudienceService.class);
        String r2 = r7.b();
        if (r2 == null) goto L21;
        r0 = r2;
    L21:
        r14.openLiveMicroApp(r0, r7.a());
    L9:
        r12 = true;
        goto L10
    }
}
