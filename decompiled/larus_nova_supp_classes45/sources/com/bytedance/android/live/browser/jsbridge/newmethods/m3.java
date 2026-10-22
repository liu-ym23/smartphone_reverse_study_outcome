package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.format.service.IFormatSDKService;
import com.bytedance.android.live.browser.jsbridge.base.FormatSendLogResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "format.sendLog")
public final class m3 extends w20.r0<w20.w8, FormatSendLogResultModel> {
    public final void onTerminate() {
    }

    public m3() {
    }

    public final void invoke(Object r7, CallContext r8) {
        w20.w8 r9 = (w20.w8) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        JsonObject r11 = r9.b();
        String r0 = r9.a();
        if (r11 == null) goto L26;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L29;
        HashMap r2 = new HashMap();
        Set r3 = r11.keySet();
        if (r3.size() <= 0) goto L18;
        Iterator r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L18;
        String r5 = (String) r4.next();
        r2.put(r5, r11.get(r5).getAsString());
    L18:
        if (r9.c() != null) goto L20;
    L23:
        com.bytedance.android.livesdk.log.u.l().h(r9.a(), r2, new Object[0]);
        return;
    L20:
        if (Intrinsics.areEqual(r9.c(), Boolean.FALSE) == true) goto L23;
        jc1.k.n(IFormatSDKService.class).sendLog(r0, r2);
        return;
    L29:
        return;
    L8:
        r1 = false;
        goto L9
    }
}
