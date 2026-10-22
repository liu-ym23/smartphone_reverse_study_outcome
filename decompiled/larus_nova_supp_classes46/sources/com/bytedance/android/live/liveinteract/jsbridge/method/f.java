package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.ReportLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w20.i5;
import w20.id;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "reportLinkmicStatus")
public final class f extends i5<id, ReportLinkmicStatusResultModel> {
    public f() {
    }

    public final void invoke(Object r7, CallContext r8) {
        id r9 = (id) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        Integer r10 = r9.b();
        boolean r0 = false;
        if (r10 == null) goto L5;
        int r11 = r10.intValue();
    L6:
        JsonObject r1 = r9.a();
        if (r1 == null) goto L48;
        JsonObject r4 = null;
        if (r11 != 2) goto L30;
        JsonElement r12 = r1.get("eventName");
        if (r12 == null) goto L14;
        String r13 = r12.getAsString();
        if (r13 == null) goto L14;
    L46:
        JsonElement r2 = r1.get("info");     // Catch: Exception -> L19
        if (r2 == null) goto L21;
        r4 = r2.getAsJsonObject();     // Catch: Exception -> L19
    L21:
        if (r4 != null) goto L24;
        r4 = new JsonObject();
    L24:
        if (TextUtils.isEmpty(r13) == true) goto L27;
        Gson r3 = GsonHelper.getDefault();
        Type r5 = new e().getType();
        Map r6 = (Map) GsonProtectorUtils.fromJson(r3, r4.toString(), r5);
        com.bytedance.android.livesdk.log.j0.l().sendLog(r13, r6, new Object[0]);
        r0 = true;
    L27:
        if (r0 == true) goto L49;
        ALogger.e("reportEventDataFail", r9.toString());
        return;
    L49:
        return;
    L19:
        e = move-exception;
        ALogger.e("reportLinkmicStatus", e);
    L14:
        r13 = "";
        goto L46
    L30:
        if (r11 != 3) goto L51;
        JsonElement r14 = r1.get("tag");
        if (r14 == null) goto L44;
        r14.getAsString();
    L44:
        JsonElement r15 = r1.get("info");     // Catch: Exception -> L38
        if (r15 == null) goto L40;
        r4 = r15.getAsJsonObject();     // Catch: Exception -> L38
    L40:
        if (r4 != null) goto L42;
        r4 = new JsonObject();
    L42:
        r4.toString();
        return;
    L38:
        e = move-exception;
        ALogger.e("reportLinkmicStatus", e);
        goto L40
    L51:
        return;
    L48:
        return;
    L5:
        r11 = 0;
        goto L6
    }
}
