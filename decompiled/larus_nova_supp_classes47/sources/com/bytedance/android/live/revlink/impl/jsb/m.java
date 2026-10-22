package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.HidePKPanelResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m extends wy0.a<Object, HidePKPanelResultModel> {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public final void onTerminate() {
    }

    public m(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.a = r1;
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callContext");
        com.bytedance.android.live.revlink.impl.global.c r4 = this.a;
        if (r4 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r5 = r4.Do();
    L6:
        if (r5 == null) goto L8;
        r5.m();
    L8:
        HidePKPanelResultModel r6 = new HidePKPanelResultModel();
        r6.a(HidePKPanelResultModel.Code.Success);
        j(r6);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
