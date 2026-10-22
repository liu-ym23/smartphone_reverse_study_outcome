package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendAdLog")
public final class qb extends w20.u5<w20.xd, w20.yd> {

    public static final class a {
    }

    static {
    }

    public qb() {
    }

    public final void invoke(Object r12, CallContext r13) {
        w20.xd r14 = (w20.xd) r12;
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "context");
        w20.yd r15 = new w20.yd();
        JsonObject r0 = new JsonObject();
        String r1 = r14.b();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        r15.a(1);
        r0.addProperty(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, "creative_id is invalid");
        r15.b(r0);
        finishWithResult(r15);
        return;
    L12:
        HashMap r3 = new HashMap();
        r3.put("value", r14.b());
        r3.put("log_extra", r14.f());
        if (r14.c() != null) goto L36;
    L21:
        ILiveDouPlusService r5 = jc1.k.n(ILiveDouPlusService.class);
        String r6 = r14.h();
        String r7 = r14.e();
        HashMap r8 = new HashMap();
        if (TextUtils.isEmpty(r14.g()) == true) goto L25;
        r8.put("refer", r14.g());
    L25:
        if (TextUtils.isEmpty(r14.a()) == true) goto L28;
        r8.put("category", r14.a());
    L28:
        if (TextUtils.isEmpty(r14.d()) == true) goto L30;
        r8.put("ext_value", r14.d());
    L30:
        Unit r16 = Unit.INSTANCE;
        if (r3.isEmpty() == true) goto L34;
        r8.putAll(r3);
    L34:
        r5.logEvent(true, r6, r7, r8);
        r15.a(1);
        r0.addProperty(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, "success");
        r15.b(r0);
        finishWithResult(r15);
        return;
    L36:
        JSONObject r9 = tv5.a.a(GsonHelper.get(), r14.c());     // Catch: Exception -> L19
        Iterator<String> r11 = r9.keys();     // Catch: Exception -> L19
    L16:
        if (r11.hasNext() == false) goto L21;
        String r17 = r11.next();     // Catch: Exception -> L19
        r3.put(r17, r9.get(r17).toString());     // Catch: Exception -> L19
    L19:
        e = move-exception;
        ALogger.d("Live-SendAdLogMethod", String.valueOf(e.getMessage()));
        goto L21
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L10
    }
}
