package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.MuteLiveRoomResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "muteLiveRoom")
public final class b8 extends w20.z3<w20.vb, MuteLiveRoomResultModel> {
    public final com.bytedance.android.live.browser.webview.fragment.m a;

    public b8(m16.b r2) {
        Intrinsics.checkNotNullParameter(r2, "contextProviderFactory");
        this.a = (com.bytedance.android.live.browser.webview.fragment.m) r2.c(com.bytedance.android.live.browser.webview.fragment.m.class);
    }

    public b8(com.bytedance.android.live.browser.webview.fragment.m r2) {
        Intrinsics.checkNotNullParameter(r2, "control");
        this.a = r2;
    }

    public final void invoke(Object r3, CallContext r4) {
        w20.vb r5 = (w20.vb) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r5.b() != null) goto L5;
        MuteLiveRoomResultModel r6 = new MuteLiveRoomResultModel();
        r6.a(MuteLiveRoomResultModel.Code.Failed);
        Unit r7 = Unit.INSTANCE;
        finishWithResult(r6);
        return;
    L5:
        com.bytedance.android.live.browser.webview.fragment.m r8 = this.a;
        if (r8 == null) goto L15;
        Boolean r0 = r5.b();
        boolean r1 = false;
        if (r0 == null) goto L10;
        boolean r2 = r0.booleanValue();
    L11:
        Boolean r9 = r5.a();
        if (r9 == null) goto L14;
        r1 = r9.booleanValue();
    L14:
        r8.setMuteStatus(r2, r1);
        goto L15
    L10:
        r2 = false;
    L15:
        MuteLiveRoomResultModel r11 = new MuteLiveRoomResultModel();
        r11.a(MuteLiveRoomResultModel.Code.Success);
        Unit r12 = Unit.INSTANCE;
        finishWithResult(r11);
    }
}
