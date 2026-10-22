package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.OpenMvSelectPanelResultModel;
import com.bytedance.android.live.liveinteract.interactivesong.panel.MvSelectDialog;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import w20.oc;
import w20.p4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "openMvSelectPanel")
public final class u0 extends p4<oc, OpenMvSelectPanelResultModel> {
    public u0() {
    }

    public final void invoke(Object r3, CallContext r4) {
        oc r5 = (oc) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r6 = r5.a();
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        MvSelectDialog r0 = new MvSelectDialog();
        Intrinsics.checkNotNullParameter(r6, "itemId");
        r0.v = r6;
        r0.U90(r4.getContext());
    }
}
