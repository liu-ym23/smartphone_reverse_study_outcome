package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.container.dialog.BaseDialogFragment;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "pull_down_height")
public final class g2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public final HybridDialog a;

    public g2(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        HybridDialog r11 = (HybridDialog) r10.c(HybridDialog.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public g2(HybridDialog r10) {
        Intrinsics.checkNotNullParameter(r10, "dialogFragment");
        this.a = r10;
    }

    public final Object invoke(Object r10, CallContext r11) {
        JSONObject r12 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        JSONObject r13 = r12.optJSONObject("args");
        int r0 = 0;
        if (r13 == null) goto L5;
        r0 = r13.optInt("pull_down_height", 0);
    L5:
        HybridDialog r14 = this.a;
        if ((r14 instanceof BaseDialogFragment) == false) goto L8;
        BaseDialogFragment r15 = (BaseDialogFragment) r14;
    L9:
        if (r15 == null) goto L11;
        com.bytedance.android.annie.scheme.helper.a.d(r15.e, "pull_down_height", Integer.valueOf(r0));
    L11:
        return null;
    L8:
        r15 = null;
        goto L9
    }
}
