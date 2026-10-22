package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.browser.jsbridge.base.LiveShortTouchFeatureUpdateResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.google.gson.internal.LazilyParsedNumber;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.shortTouchFeatureUpdate")
public final class y6 extends w20.l3<w20.gb, LiveShortTouchFeatureUpdateResultModel> {
    public y6() {
    }

    public final void invoke(Object r7, CallContext r8) {
        w20.gb r9 = (w20.gb) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L29
        JsonObject r12 = r9.a();     // Catch: Throwable -> L29
        if (r12 == null) goto L7;
        String r13 = r12.toString();     // Catch: Throwable -> L29
        if (r13 == null) goto L7;
    L8:
        ALogger.i("HOT_PACKAGE_TERM", "LiveShortTouchFeatureUpdateMethod params ".concat(r13));     // Catch: Throwable -> L29
        JsonObject r14 = r9.a();     // Catch: Throwable -> L29
        if (r14 == null) goto L11;
        Map r15 = UtilsKt.i(r14);     // Catch: Throwable -> L29
    L12:
        ALogger.d("HOT_PACKAGE_TERM", new x6(r15));     // Catch: Throwable -> L29
        HashMap r16 = new HashMap();     // Catch: Throwable -> L29
        if (r15 != null) goto L34;
    L23:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        xs2.b.a().post(new y90.a(r16));     // Catch: Throwable -> L29
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
        return;
    L25:
        th = move-exception;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L29
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L29
        goto L27
    L34:
        Iterator r17 = r15.entrySet().iterator();     // Catch: Throwable -> L25
    L16:
        if (r17.hasNext() == false) goto L23;
        Map.Entry r1 = (Map.Entry) r17.next();     // Catch: Throwable -> L25
        Object r2 = r1.getValue();     // Catch: Throwable -> L25
        if (r2 == null) goto L16;
        if ((r2 instanceof LazilyParsedNumber) == true) goto L21;
        r16.put(r1.getKey(), r2);     // Catch: Throwable -> L25
        goto L16
    L21:
        r16.put(r1.getKey(), Long.valueOf(((LazilyParsedNumber) r2).longValue()));     // Catch: Throwable -> L25
        ALogger.d("HOT_PACKAGE_TERM", "存在类型非Int类型的数据 key = " + ((String) r1.getKey()) + "   value = " + r2);     // Catch: Throwable -> L25
        goto L16
    L11:
        r15 = MapsKt.emptyMap();     // Catch: Throwable -> L29
    L7:
        r13 = "";
    L29:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
