package com.bytedance.android.anniex.ability;

import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements XBridgeMethod.b {
    public final /* synthetic */ AnnieXWebKit a;

    public o(AnnieXWebKit r1) {
        this.a = r1;
    }

    public final void sendJsEvent(String r10, XReadableMap r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        AnnieXWebKit r0 = this.a;
        if (r11 == null) goto L5;
        JSONObject r12 = com.bytedance.ies.xbridge.utils.j.d(r11);
    L6:
        r0.p(r10, r12);
        return;
    L5:
        r12 = new JSONObject();
        goto L6
    }
}
