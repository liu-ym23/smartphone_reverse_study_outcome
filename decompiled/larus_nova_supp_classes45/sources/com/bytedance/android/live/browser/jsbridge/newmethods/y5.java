package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.browser.jsbridge.base.LiveCEPEventUpdateResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.CEPEventUpdate")
public final class y5 extends w20.k2<w20.la, LiveCEPEventUpdateResultModel> {
    public y5() {
    }

    public final void invoke(Object r4, CallContext r5) {
        w20.la r6 = (w20.la) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        JsonObject r7 = r6.b();
        if (r7 == null) goto L6;
        String r8 = r7.toString();
        if (r8 == null) goto L6;
    L7:
        ALogger.i("HOT_PACKAGE_TERM", "LiveCEPEventUpdateMethod params ".concat(r8));
        String r9 = r6.a();
        JsonObject r11 = r6.b();
        if (r11 == null) goto L10;
        Map r12 = UtilsKt.i(r11);
    L11:
        LinkedHashMap r0 = new LinkedHashMap();
        if (TextUtils.isEmpty(r9) == true) goto L25;
        if (r12 == null) goto L25;
        if (r12.size() <= 0) goto L25;
        if (r9 == null) goto L25;
        Iterator r13 = r12.entrySet().iterator();
    L19:
        if (r13.hasNext() == false) goto L25;
        Map.Entry r1 = (Map.Entry) r13.next();
        if (TextUtils.isEmpty((CharSequence) r1.getKey()) == true) goto L19;
        if (r1.getValue() == null) goto L19;
        r0.put(r1.getKey(), String.valueOf(r1.getValue()));
    L25:
        if (r9 == null) goto L37;
        IDynamicStrategyService r14 = jc1.k.f(IDynamicStrategyService.class);
        if (r14 == null) goto L38;
        r14.sendNfaEvent(r9, r0);
        return;
    L38:
        return;
    L37:
        return;
    L10:
        r12 = MapsKt.emptyMap();
    L6:
        r8 = "";
        goto L7
    }
}
