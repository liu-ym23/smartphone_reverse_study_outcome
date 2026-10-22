package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.livehostapi.platform.ISaasHostWebView;
import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i0 {
    public static final /* synthetic */ int a = 0;

    public static void b() {
        Map r0 = XBridge.INSTANCE.getMethodList(XBridgePlatformType.LYNX, "DEFAULT");
        if (r0 == null) goto L8;
        Iterator r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r1.next();
        ArrayList<Class<? extends Object>> r3 = com.bytedance.android.live.browser.b0.a;
        com.bytedance.android.live.browser.b0.a((Class) r2.getValue());
    L8:
        ISaasHostWebView r4 = jc1.k.f(ISaasHostWebView.class);
        if (r4 == null) goto L15;
        ArrayList r5 = r4.getXBridgeMethods();
        if (r5 == null) goto L16;
        com.bytedance.android.live.browser.b0.b(r5);
        return;
    L16:
        return;
    }

    static {
    }

    public static void a(JSONObject r2, Object r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        if (r2.opt("__code") != null) goto L11;
        Object r4 = r2.opt("code");     // Catch: Throwable -> L13
        if (r4 == null) goto L9;
        r3 = r4;
    L9:
        if (r3 == null) goto L11;
        r2.put("__code", r3);     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
