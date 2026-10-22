package com.bytedance.ies.bullet.lynx.impl;

import android.view.View;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.bytedance.ies.bullet.service.base.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f5652a;

    public c(e r5) {
        this.f5652a = r5;
    }

    @Override // com.bytedance.ies.bullet.service.base.g
    public final void a(Object r10, String r11, View r12) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        if ((r12 instanceof LynxView) == false) goto L164;
        LynxView r13 = (LynxView) r12;
        b r5 = new b(0, r11, r10);
        e r14 = this.f5652a;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r5, "event");
        TemplateData r15 = null;
        String r16 = null;
        r16 = null;
        r15 = null;
        if (Intrinsics.areEqual(r11, "__updateData") == false) goto L27;
        if (r10 != null) goto L9;
    L23:
        if (r16 == null) goto L161;
        r13.updateData(r16);
        return;
    L161:
        return;
    L9:
        if ((r10 instanceof CharSequence) == false) goto L12;
        r16 = String.valueOf(r10);
        goto L23
    L12:
        if ((r10 instanceof JSONObject) == false) goto L15;
        r16 = String.valueOf(((JSONObject) r10).put("bullet_update_type", 1));
        goto L23
    L15:
        if ((r10 instanceof JSONArray) == false) goto L18;
        r16 = String.valueOf(r10);
        goto L23
    L18:
        if ((r10 instanceof ReadableMap) == false) goto L21;
        r16 = String.valueOf(com.lynx.tasm.utils.b.m((ReadableMap) r10).put("bullet_update_type", 1));
        goto L23
    L21:
        if ((r10 instanceof ReadableArray) == false) goto L23;
        r16 = String.valueOf(com.lynx.tasm.utils.b.l((ReadableArray) r10));
        goto L23
    L27:
        if (Intrinsics.areEqual(r11, "__updateGlobalProps") == false) goto L59;
        if (r14.f5660j == null) goto L59;
        if (r10 != null) goto L32;
        return;
    L32:
        if ((r10 instanceof Map) == false) goto L163;
        Map r17 = (Map) r10;
        if (r17.isEmpty() == true) goto L165;
        LinkedHashMap r18 = r14.f5660j;
        if (r18 == null) goto L56;
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r110 = r17.entrySet().iterator();
    L40:
        if (r110.hasNext() == false) goto L56;
        Map.Entry r20 = (Map.Entry) r110.next();
        Object r21 = r20.getKey();
        if (r21 != null) goto L44;
    L49:
        String r22 = null;
    L50:
        if (r22 == null) goto L40;
        if (r22.length() <= 0) goto L40;
        if (r20.getValue() == null) goto L40;
        r19.put(STGroup.DICT_KEY, MapsKt.mapOf(new Pair[]{TuplesKt.to("old_value", String.valueOf(r18.get(r22))), TuplesKt.to("new_value", String.valueOf(r20.getValue()))}));
        Object r23 = r20.getValue();
        Intrinsics.checkNotNull(r23);
        r18.put(r22, r23);
        goto L40
    L44:
        if ((r21 instanceof String) == true) goto L47;
        r21 = null;
    L47:
        if (r21 == null) goto L49;
        r22 = (String) r21;
    L56:
        LinkedHashMap r111 = new LinkedHashMap();
        LinkedHashMap r24 = r14.f5660j;
        Intrinsics.checkNotNull(r24);
        r111.put("__globalProps", r24);
        r111.put("bullet_update_type", 1);
        r13.updateData(r111);
        return;
    L165:
        return;
    L163:
        return;
    L59:
        if (Intrinsics.areEqual("__updateTemplateData", r11) == false) goto L74;
        if (r10 != null) goto L62;
    L70:
        if (r15 == null) goto L72;
        r15.i("bullet_update_type", 1);
    L72:
        r13.updateData(r15);
        return;
    L62:
        if ((r10 instanceof ae.a) == false) goto L70;
        ae.a r112 = (ae.a) r10;
        String r25 = r112.f161b;
        if (r25 == null) goto L69;
        r15 = TemplateData.b(r25);
        Iterator r26 = r112.f160a.entrySet().iterator();
    L67:
        if (r26.hasNext() == false) goto L70;
        Map.Entry r113 = (Map.Entry) r26.next();
        r15.i((String) r113.getKey(), r113.getValue());
        goto L67
    L69:
        r15 = TemplateData.c(r112.f160a);
        goto L70
    L74:
        JavaOnlyArray r27 = new JavaOnlyArray();
        JSONObject r28 = new JSONObject();
        if (r10 != null) goto L77;
    L122:
        com.bytedance.ies.bullet.core.e r29 = r14.f;
        if (r29 == null) goto L126;
        String r30 = r29.getSessionId();
        if (r30 == null) goto L126;
    L127:
        lc.a r114 = new lc.a(r30);
        Intrinsics.checkNotNullParameter(r28, "<this>");
        Intrinsics.checkNotNullParameter(r114, "data");
        r28.put("containerID", r30);
        r28.put("protocolVersion", "1.0");
        com.bytedance.ies.bullet.core.e r31 = r14.f;
        if (r31 == null) goto L130;
        String r32 = r31.f;
    L132:
        if (Intrinsics.areEqual(r32, "webcast") == false) goto L145;
        r28.put("code", 1);
    L145:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L136
        r27.pushMap(com.lynx.tasm.utils.b.e(r28));     // Catch: Throwable -> L136
        Object r34 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L136
    L138:
        Throwable r35 = Result.m127exceptionOrNullimpl(r34);
        if (r35 == null) goto L141;
        int r115 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("DefaultLynxDelegate", "error===>" + r35.getMessage(), null, 12);
    L141:
        Unit r36 = Unit.INSTANCE;
        r13.sendGlobalEvent(r11, r27);
        return;
    L136:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r34 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L138
    L130:
        r32 = null;
    L126:
        r30 = "";
        goto L127
    L77:
        if ((r10 instanceof CharSequence) == false) goto L79;
        boolean r37 = true;
    L80:
        if (r37 == false) goto L82;
        boolean r38 = true;
    L83:
        if (r38 == false) goto L86;
        r28.put("data", r10);
        goto L122
    L86:
        if ((r10 instanceof JsonObject) == false) goto L96;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L89
        Object r117 = Result.m124constructorimpl(r28.put("data", new JSONObject(r10.toString())));     // Catch: Throwable -> L89
    L92:
        if (Result.m127exceptionOrNullimpl(r117) == null) goto L94;
        Object r40 = com.lynx.tasm.utils.d.k("error", "JsonObject convert JSONObject error");
        Unit r41 = Unit.INSTANCE;
        r28.put("data", r40);
    L94:
        Result.m123boximpl(r117);
    L89:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r117 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L92
    L96:
        if ((r10 instanceof JsonArray) == false) goto L106;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L99
        Object r118 = Result.m124constructorimpl(r28.put("data", new JSONArray(r10.toString())));     // Catch: Throwable -> L99
    L102:
        if (Result.m127exceptionOrNullimpl(r118) == null) goto L104;
        Object r44 = com.lynx.tasm.utils.d.k("error", "JsonArray convert JSONObject error");
        Unit r45 = Unit.INSTANCE;
        r28.put("data", r44);
    L104:
        Result.m123boximpl(r118);
    L99:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r118 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L102
    L106:
        if ((r10 instanceof Map) == false) goto L116;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L109
        Object r119 = Result.m124constructorimpl(r28.put("data", new JSONObject((Map) r10)));     // Catch: Throwable -> L109
    L112:
        if (Result.m127exceptionOrNullimpl(r119) == null) goto L114;
        Object r48 = com.lynx.tasm.utils.d.k("error", "Map convert JSONObject error");
        Unit r49 = Unit.INSTANCE;
        r28.put("data", r48);
    L114:
        Result.m123boximpl(r119);
    L109:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r119 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L112
    L116:
        if ((r10 instanceof ReadableMap) == false) goto L119;
        r28.put("data", com.lynx.tasm.utils.b.m((ReadableMap) r10));
        goto L122
    L119:
        if ((r10 instanceof ReadableArray) == false) goto L121;
        r28.put("data", com.lynx.tasm.utils.b.l((ReadableArray) r10));
        goto L122
    L121:
        r28.put("data", new JSONObject());
        goto L122
    L82:
        r38 = r10 instanceof JSONArray;
        goto L83
    L79:
        r37 = r10 instanceof JSONObject;
        goto L80
    }
}
