package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "bindSourceParams")
public final class t0 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    public static final class a {
    }

    static {
    }

    public t0() {
    }

    public final Object invoke(Object r5, CallContext r6) {
        JSONObject r7 = (JSONObject) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r8 = r7.optString("sourceParams");
        LinkedHashMap r9 = new LinkedHashMap();
        ALogger.i("BindStarGraphMethod", String.valueOf(r8));
        if (TextUtils.isEmpty(r8) == false) goto L5;
        xs2.b.a().post(new b30.b0(r9));
        return new JSONObject();
    L5:
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(2131922639), 0);
        JSONObject r0 = new JSONObject(r8);     // Catch: Throwable -> L13
        Iterator<String> r11 = r0.keys();     // Catch: Throwable -> L13
        if (r11 != null) goto L9;
    L11:
        xs2.b.a().post(new b30.b0(r9));     // Catch: Throwable -> L13
    L16:
        return new JSONObject();
    L9:
        if (r11.hasNext() == false) goto L11;
        String r2 = r11.next();     // Catch: Throwable -> L13
        r9.put(r2, r0.optString(r2, ""));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        ALogger.e("BindStarGraphMethod", "error: " + th);
        goto L16
    }
}
