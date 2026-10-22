package com.bytedance.android.anniex.ability;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r16, Object r17, LynxView r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r16, "eventName");
        Intrinsics.checkNotNullParameter(r18, "lynxView");
        Intrinsics.checkNotNullParameter(r19, "bid");
        Intrinsics.checkNotNullParameter(r20, "sessionId");
        boolean r10 = true;
        boolean r11 = false;
        if (Intrinsics.areEqual(r16, "__updateData") == false) goto L46;
        if (r17 != null) goto L6;
        String r12 = null;
    L43:
        if (r12 == null) goto L136;
        r18.updateData(r12);
        return;
    L136:
        return;
    L6:
        if ((r17 instanceof CharSequence) == false) goto L10;
        String r0 = String.valueOf(r17);
    L8:
        r12 = r0;
        goto L43
    L10:
        if ((r17 instanceof JSONObject) == false) goto L13;
        r0 = String.valueOf(((JSONObject) r17).put("bullet_update_type", 1));
        goto L8
    L13:
        if ((r17 instanceof JSONArray) == false) goto L16;
        r0 = String.valueOf(r17);
        goto L8
    L16:
        if ((r17 instanceof ReadableMap) == false) goto L19;
        h26.c.a.getClass();
        r0 = String.valueOf(h26.c.f((ReadableMap) r17).put("bullet_update_type", 1));
        goto L8
    L19:
        if ((r17 instanceof ReadableArray) == false) goto L22;
        h26.c.a.getClass();
        r0 = String.valueOf(h26.c.e((ReadableArray) r17));
        goto L8
    L22:
        if ((r17 instanceof JsonObject) == true) goto L24;
    L31:
        r12 = null;
    L33:
        if ((r17 instanceof JsonArray) == false) goto L43;
        if (Intrinsics.areEqual(r19, "webcast") == true) goto L37;
    L39:
        r10 = false;
    L40:
        if (r10 == false) goto L43;
        r0 = String.valueOf(r17);
        goto L8
    L37:
        if (com.bytedance.ies.bullet.service.base.h.S() == false) goto L39;
    L24:
        if (Intrinsics.areEqual(r19, "webcast") == true) goto L26;
    L28:
        boolean r1 = false;
    L29:
        if (r1 == false) goto L31;
        ((JsonObject) r17).addProperty("bullet_update_type", 1);
        r12 = String.valueOf(r17);
        goto L33
    L26:
        if (com.bytedance.ies.bullet.service.base.h.S() == false) goto L28;
        r1 = true;
        goto L29
    L46:
        if (Intrinsics.areEqual("__updateTemplateData", r16) == false) goto L65;
        if (r17 != null) goto L49;
    L60:
        TemplateData r13 = null;
    L61:
        if (r13 == null) goto L63;
        r13.put("bullet_update_type", 1);
    L63:
        r18.updateData(r13);
        return;
    L49:
        if ((r17 instanceof p46.f) == false) goto L60;
        p46.f r14 = (p46.f) r17;
        String r15 = r14.b;
        if (r15 == null) goto L59;
        TemplateData r21 = TemplateData.fromString(r15);
        Iterator r22 = r14.a.entrySet().iterator();
    L54:
        if (r22.hasNext() == false) goto L58;
        Map.Entry r23 = (Map.Entry) r22.next();
        if (r21 == null) goto L54;
        r21.put((String) r23.getKey(), r23.getValue());
        goto L54
    L58:
        r13 = r21;
        goto L61
    L59:
        r13 = TemplateData.fromMap(r14.a);
        goto L61
    L65:
        if (Intrinsics.areEqual(r19, "webcast") == false) goto L70;
        if (com.bytedance.ies.bullet.service.base.h.S() == false) goto L70;
        r11 = true;
    L70:
        if (r11 == true) goto L72;
    L90:
        JavaOnlyArray r24 = new JavaOnlyArray();
        JSONObject r25 = new JSONObject();
        if (r17 != null) goto L93;
    L115:
        g26.a r26 = new g26.a(r20);
        Intrinsics.checkNotNullParameter(r25, "<this>");
        Intrinsics.checkNotNullParameter(r26, "data");
        r25.put("containerID", r26.a);
        r25.put("protocolVersion", r26.b);
        if (Intrinsics.areEqual(r19, "webcast") == false) goto L129;
        r25.put("code", 1);
    L129:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L120
        h26.c.a.getClass();     // Catch: Throwable -> L120
        r24.pushMap(h26.c.d(r25));     // Catch: Throwable -> L120
        Object r28 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L120
    L122:
        Throwable r29 = Result.exceptionOrNull-impl(r28);
        if (r29 == null) goto L125;
        HybridLogger r30 = HybridLogger.a;
        HybridLogger.i("EventHelper", "error===>" + r29.getMessage(), null, 12);
    L125:
        Unit r31 = Unit.INSTANCE;
        com.bytedance.android.anniex.utils.g.d(r18, r16, r24);
        return;
    L120:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L122
    L93:
        if ((r17 instanceof CharSequence) == false) goto L95;
        boolean r110 = true;
    L96:
        if (r110 == false) goto L98;
        boolean r111 = true;
    L99:
        if (r111 == false) goto L102;
        r25.put("data", r17);
        goto L115
    L102:
        if ((r17 instanceof ReadableMap) == false) goto L105;
        h26.c.a.getClass();
        r25.put("data", h26.c.f((ReadableMap) r17));
        goto L115
    L105:
        if ((r17 instanceof ReadableArray) == false) goto L107;
        h26.c.a.getClass();
        r25.put("data", h26.c.e((ReadableArray) r17));
        goto L115
    L107:
        boolean r112 = r17 instanceof Map;
        if (r112 == false) goto L114;
        if (r112 == false) goto L111;
        Map r33 = (Map) r17;
    L112:
        if (r33 == null) goto L115;
        r25.put("data", com.bytedance.ies.xbridge.utils.e.d(r33));
        goto L115
    L111:
        r33 = null;
        goto L112
    L114:
        r25.put("data", new JSONObject());
        goto L115
    L98:
        r111 = r17 instanceof JSONArray;
        goto L99
    L95:
        r110 = r17 instanceof JSONObject;
        goto L96
    L72:
        if ((r17 instanceof JsonObject) == false) goto L74;
    L75:
        JavaOnlyArray r34 = new JavaOnlyArray();
        JsonObject r113 = new JsonObject();
        if ((r17 instanceof JsonElement) == false) goto L78;
        JsonElement r35 = (JsonElement) r17;
    L79:
        r113.add("data", r35);
        g26.a r36 = new g26.a(r20);
        Intrinsics.checkNotNullParameter(r113, "<this>");
        Intrinsics.checkNotNullParameter(r36, "data");
        r113.addProperty("containerID", r36.a);
        r113.addProperty("protocolVersion", r36.b);
        if (Intrinsics.areEqual(r19, "webcast") == false) goto L127;
        r113.addProperty("code", 1);
    L127:
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L84
        h26.c.a.getClass();     // Catch: Throwable -> L84
        r34.pushMap(h26.c.c(r113));     // Catch: Throwable -> L84
        Object r38 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L84
    L86:
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L89;
        HybridLogger r40 = HybridLogger.a;
        HybridLogger.i("EventHelper", "error===>" + r39.getMessage(), null, 12);
    L89:
        Unit r41 = Unit.INSTANCE;
        com.bytedance.android.anniex.utils.g.d(r18, r16, r34);
        return;
    L84:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r38 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L78:
        r35 = null;
        goto L79
    L74:
        if ((r17 instanceof JsonArray) == false) goto L90;
        goto L75
    }
}
