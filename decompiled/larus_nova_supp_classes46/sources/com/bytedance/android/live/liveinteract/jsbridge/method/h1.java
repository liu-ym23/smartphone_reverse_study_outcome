package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.SendQuickInteractResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import w20.c6;
import w20.ie;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "sendQuickInteract")
public final class h1 extends c6<ie, SendQuickInteractResultModel> {
    public h1() {
    }

    public final void invoke(Object r8, CallContext r9) {
        ie r10 = (ie) r8;
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        final SendQuickInteractResultModel r11 = new SendQuickInteractResultModel();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r1 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r1 == null) goto L17;
        String r0 = r10.c();
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        String r3 = r10.a();
        if (r3 == null) goto L10;
        long r4 = CastLongProtector.parseLong(r3);
    L11:
        String r12 = r10.b();
        if (r12 != null) goto L14;
        String r5 = "";
    L15:
        String r2 = r0;
        r1.aj(r2, r4, r5, new SendQuickInteractMethod$invoke$1(this, r11));
        return;
    L14:
        r5 = r12;
        goto L15
    L10:
        r4 = 0;
        goto L11
    }
}
