package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.browser.jsbridge.base.LiveRunAiServiceResultModel;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import w20.db;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "live.runAiService")
public final class j1 extends w20.j3<db, LiveRunAiServiceResultModel> {
    public final String a;

    public j1() {
        this.a = "LAI-LiveRunAiServiceMethod";
    }

    public final JsonArray k(JSONArray r8) {
        JsonArray r0 = new JsonArray();
        int r1 = r8.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L28;
        Object r3 = r8.get(r2);     // Catch: Exception -> L25
        if ((r3 instanceof JSONObject) == false) goto L8;
        r0.add(l((JSONObject) r3));     // Catch: Exception -> L25
    L27:
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r3 instanceof JSONArray) == false) goto L11;
        r0.add(k((JSONArray) r3));     // Catch: Exception -> L25
        goto L27
    L11:
        if ((r3 instanceof Boolean) == false) goto L14;
        r0.add(new JsonPrimitive((Boolean) r3));     // Catch: Exception -> L25
        goto L27
    L14:
        if ((r3 instanceof Number) == false) goto L17;
        r0.add(new JsonPrimitive((Number) r3));     // Catch: Exception -> L25
        goto L27
    L17:
        if ((r3 instanceof String) == false) goto L19;
        r0.add(new JsonPrimitive((String) r3));     // Catch: Exception -> L25
        goto L27
    L19:
        String r4 = this.a;     // Catch: Exception -> L25
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L25
        r5.append("Skipped array element at index ");     // Catch: Exception -> L25
        r5.append(r2);     // Catch: Exception -> L25
        r5.append(": Unsupported type ");     // Catch: Exception -> L25
        if (r3 == null) goto L22;
        String r6 = r3.getClass().getName();     // Catch: Exception -> L25
    L23:
        r5.append(r6);     // Catch: Exception -> L25
        Logger.e(r4, r5.toString());     // Catch: Exception -> L25
        goto L27
    L22:
        r6 = null;
    L25:
        e = move-exception;
        Logger.e(this.a, "Failed to process array element at index " + r2 + ": " + e.getMessage());
        goto L27
    L28:
        return r0;
    }

    public final JsonObject l(JSONObject r8) {
        JsonObject r0 = new JsonObject();
        Iterator<String> r1 = r8.keys();
    L4:
        if (r1.hasNext() == false) goto L29;
        String r2 = r1.next();
        Object r3 = r8.get(r2);     // Catch: Exception -> L27
        if ((r3 instanceof JSONObject) == true) goto L8;
        if ((r3 instanceof JSONArray) == true) goto L11;
        if ((r3 instanceof Boolean) == true) goto L14;
        if ((r3 instanceof Number) == true) goto L17;
        if ((r3 instanceof String) == true) goto L20;
        String r4 = this.a;     // Catch: Exception -> L27
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L27
        r5.append("Skipped key '");     // Catch: Exception -> L27
        r5.append(r2);     // Catch: Exception -> L27
        r5.append("': Unsupported type ");     // Catch: Exception -> L27
        if (r3 == null) goto L24;
        String r6 = r3.getClass().getName();     // Catch: Exception -> L27
    L25:
        r5.append(r6);     // Catch: Exception -> L27
        Logger.e(r4, r5.toString());     // Catch: Exception -> L27
        goto L4
    L24:
        r6 = null;
        goto L25
    L20:
        r0.addProperty(r2, (String) r3);     // Catch: Exception -> L27
        goto L4
    L17:
        r0.addProperty(r2, (Number) r3);     // Catch: Exception -> L27
        goto L4
    L14:
        r0.addProperty(r2, (Boolean) r3);     // Catch: Exception -> L27
        goto L4
    L11:
        r0.add(r2, k((JSONArray) r3));     // Catch: Exception -> L27
        goto L4
    L8:
        r0.add(r2, l((JSONObject) r3));     // Catch: Exception -> L27
    L27:
        e = move-exception;
        Logger.e(this.a, "Failed to process key '" + r2 + "': " + e.getMessage());
        goto L4
    L29:
        return r0;
    }

    public static void j(String r3, String r4) {
        IHostGameCP r0 = jc1.k.f(IHostGameCP.class);
        if (r0 == null) goto L11;
        IGameCpLiveService r1 = r0.getGameCpLiveService();
        if (r1 == null) goto L12;
        HashMap r2 = new HashMap();
        r2.put("status", r3);
        r2.put("from", "jsb");
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r4) == false) goto L9;
        Intrinsics.checkNotNull(r4);
        r2.put("reason", r4);
    L9:
        Unit r5 = Unit.INSTANCE;
        r1.reportCardDynamicEvent(r2);
        return;
    L12:
        return;
    }

    public final void invoke(Object r5, CallContext r6) {
        db r7 = (db) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        LiveRunAiServiceResultModel r8 = new LiveRunAiServiceResultModel();
        JSONObject r1 = null;
        j("ai invoke", null);
        Logger.d(this.a, "LiveRunAiServiceMethod invoke : action=" + r7.a() + ", params=" + r7.b());
        Integer r0 = r7.a();
        if (r0 == null) goto L10;
        r0.intValue();
        IAiService r2 = jc1.k.f(IAiService.class);
        if (r2 == null) goto L12;
        Integer r3 = r7.a();
        Intrinsics.checkNotNull(r3);
        int r4 = r3.intValue();
        JsonObject r9 = r7.b();
        if (r9 == null) goto L9;
        int r10 = com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a;
        Intrinsics.checkNotNullParameter(r9, "$this$toJSONObject");
        r1 = tv5.a.b(r9);
    L9:
        r2.handleAction(r4, r1, new i1(this, r8));
        return;
    L12:
        return;
    L10:
        r8.c(LiveRunAiServiceResultModel.Code.Failed);
        finishWithResult(r8);
        Logger.w(this.a, "finish with error: action is null");
    }
}
