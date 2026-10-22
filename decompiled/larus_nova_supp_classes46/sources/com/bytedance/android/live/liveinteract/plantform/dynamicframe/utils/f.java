package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.LayerIndex;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.StageUpdateType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final Map c() {
        new LinkedHashMap();
        return MapsKt.toMutableMap(((nh0.g) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), "{\n  \"config_map\" : {\n    \"11\" : {\n      \"regions\" : [ {\n        \"p\" : 0,\n        \"w\" : -12,\n        \"h\" : 40,\n        \"x\" : 0,\n        \"y\" : 0,\n        \"z\" : 0\n      }, {\n        \"p\" : 1,\n        \"w\" : 12,\n        \"h\" : 13.333,\n        \"x\" : -12,\n        \"y\" : 0,\n        \"z\" : 0\n      }, {\n        \"p\" : 2,\n        \"w\" : 12,\n        \"h\" : 13.333,\n        \"x\" : -12,\n        \"y\" : 13.333,\n        \"z\" : 0\n      }, {\n        \"p\" : 3,\n        \"w\" : 12,\n        \"h\" : 13.333,\n        \"x\" : -12,\n        \"y\" : 26.666,\n        \"z\" : 0\n      } ],\n      \"scale\" : -1,\n      \"align\" : -1,\n      \"content\" : {\n        \"h\" : 40\n      }\n    },\n    \"12\" : {\n      \"regions\" : [ {\n        \"p\" : 0,\n        \"w\" : 20,\n        \"h\" : 40,\n        \"x\" : 0,\n        \"y\" : 0,\n        \"z\" : 0\n      }, {\n        \"p\" : 1,\n        \"w\" : -10,\n        \"h\" : 13.333,\n        \"x\" : 20,\n        \"y\" : 0,\n        \"z\" : 0\n      }, {\n        \"p\" : 2,\n        \"w\" : -10,\n        \"h\" : 13.333,\n        \"x\" : 10,\n        \"y\" : 0,\n        \"z\" : 0\n      }, {\n        \"p\" : 3,\n        \"w\" : -10,\n        \"h\" : 13.333,\n        \"x\" : 20,\n        \"y\" : 13.333,\n        \"z\" : 0\n      }, {\n        \"p\" : 4,\n        \"w\" : -10,\n        \"h\" : 13.333,\n        \"x\" : 10,\n        \"y\" : 13.333,\n        \"z\" : 0\n      }, {\n        \"p\" : 5,\n        \"w\" : -10,\n        \"h\" : 13.333,\n        \"x\" : 20,\n        \"y\" : 26.666,\n        \"z\" : 0\n      }, {\n        \"p\" : 6,\n        \"w\" : -10,\n        \"h\" : 13.333,\n        \"x\" : 10,\n        \"y\" : 26.666,\n        \"z\" : 0\n      } ],\n      \"scale\" : -1,\n      \"align\" : -1,\n      \"content\" : {\n        \"h\" : 40\n      }\n    },\n    \"3\" : {\n      \"regions\" : [ {\n        \"p\" : 0,\n        \"w\" : 20,\n        \"h\" : 40,\n        \"x\" : 0,\n        \"y\" : 0,\n        \"z\" : 0\n      }, {\n        \"p\" : 1,\n        \"w\" : -10,\n        \"h\" : 10,\n        \"x\" : 20,\n        \"y\" : 0,\n        \"z\" : 0\n      }, {\n        \"p\" : 2,\n        \"w\" : -10,\n        \"h\" : 10,\n        \"x\" : 10,\n        \"y\" : 0,\n        \"z\" : 0\n      }, {\n        \"p\" : 3,\n        \"w\" : -10,\n        \"h\" : 10,\n        \"x\" : 20,\n        \"y\" : 10,\n        \"z\" : 0\n      }, {\n        \"p\" : 4,\n        \"w\" : -10,\n        \"h\" : 10,\n        \"x\" : 10,\n        \"y\" : 10,\n        \"z\" : 0\n      }, {\n        \"p\" : 5,\n        \"w\" : -10,\n        \"h\" : 10,\n        \"x\" : 20,\n        \"y\" : 20,\n        \"z\" : 0\n      }, {\n        \"p\" : 6,\n        \"w\" : -10,\n        \"h\" : 10,\n        \"x\" : 10,\n        \"y\" : 20,\n        \"z\" : 0\n      }, {\n        \"p\" : 7,\n        \"w\" : -10,\n        \"h\" : 10,\n        \"x\" : 20,\n        \"y\" : 30,\n        \"z\" : 0\n      }, {\n        \"p\" : 8,\n        \"w\" : -10,\n        \"h\" : 10,\n        \"x\" : 10,\n        \"y\" : 30,\n        \"z\" : 0\n      } ],\n      \"scale\" : -1,\n      \"align\" : -1,\n      \"content\" : {\n        \"h\" : 40\n      }\n    },\n    \"103\" : {\n      \"regions\" : [ {\n        \"p\" : 0,\n        \"w\" : 20,\n        \"h\" : 40,\n        \"x\" : 0,\n        \"y\" : 0,\n        \"z\" : 0\n      }, {\n        \"p\" : 1,\n        \"w\" : -20,\n        \"h\" : 20,\n        \"x\" : 20,\n        \"y\" : 0,\n        \"z\" : 0\n      }, {\n        \"p\" : 2,\n        \"w\" : -20,\n        \"h\" : 20,\n        \"x\" : 20,\n        \"y\" : 20,\n        \"z\" : 0\n      } ],\n      \"scale\" : -1,\n      \"align\" : -1,\n      \"content\" : {\n        \"h\" : 40\n      }\n    },\n    \"5\" : {\n      \"regions\" : [ {\n        \"p\" : 0,\n        \"h\" : 13.3333,\n        \"y\" : 0\n      }, {\n        \"p\" : 1,\n        \"h\" : 13.3333,\n        \"y\" : 0\n      }, {\n        \"p\" : 2,\n        \"h\" : 13.3333,\n        \"y\" : 0\n      }, {\n        \"p\" : 3,\n        \"h\" : 13.3333,\n        \"y\" : 13.333\n      }, {\n        \"p\" : 4,\n        \"h\" : 13.3333,\n        \"y\" : 13.333\n      }, {\n        \"p\" : 5,\n        \"h\" : 13.3333,\n        \"y\" : 13.333\n      }, {\n        \"p\" : 6,\n        \"h\" : 13.3333,\n        \"y\" : 26.666\n      }, {\n        \"p\" : 7,\n        \"h\" : 13.3333,\n        \"y\" : 26.666\n      }, {\n        \"p\" : 8,\n        \"h\" : 13.3333,\n        \"y\" : 26.666\n      } ],\n      \"scale\" : -1,\n      \"align\" : -1,\n      \"content\" : {\n        \"h\" : 40\n      }\n    },\n    \"104\" : {\n      \"regions\" : [ {\n        \"p\" : 0,\n        \"h\" : 20,\n        \"y\" : 0\n      }, {\n        \"p\" : 1,\n        \"h\" : 20,\n        \"y\" : 0\n      }, {\n        \"p\" : 2,\n        \"h\" : 20,\n        \"y\" : 20\n      }, {\n        \"p\" : 3,\n        \"h\" : 20,\n        \"y\" : 20\n      } ],\n      \"scale\" : -1,\n      \"align\" : -1,\n      \"content\" : {\n        \"h\" : 40\n      }\n    },\n    \"105\" : {\n      \"regions\" : [ {\n        \"p\" : 0,\n        \"h\" : 20,\n        \"y\" : 0\n      }, {\n        \"p\" : 1,\n        \"h\" : 20,\n        \"y\" : 0\n      }, {\n        \"p\" : 2,\n        \"h\" : 20,\n        \"y\" : 0\n      }, {\n        \"p\" : 3,\n        \"h\" : 20,\n        \"y\" : 20\n      }, {\n        \"p\" : 4,\n        \"h\" : 20,\n        \"y\" : 20\n      } ],\n      \"scale\" : -1,\n      \"align\" : -1,\n      \"content\" : {\n        \"h\" : 40\n      }\n    },\n    \"106\" : {\n      \"regions\" : [ {\n        \"p\" : 0,\n        \"h\" : 20,\n        \"y\" : 0\n      }, {\n        \"p\" : 1,\n        \"h\" : 20,\n        \"y\" : 0\n      }, {\n        \"p\" : 2,\n        \"h\" : 20,\n        \"y\" : 0\n      }, {\n        \"p\" : 3,\n        \"h\" : 20,\n        \"y\" : 20\n      }, {\n        \"p\" : 4,\n        \"h\" : 20,\n        \"y\" : 20\n      }, {\n        \"p\" : 5,\n        \"h\" : 20,\n        \"y\" : 20\n      } ],\n      \"scale\" : -1,\n      \"align\" : -1,\n      \"content\" : {\n        \"h\" : 40\n      }\n    },\n    \"107\" : {\n      \"regions\" : [ {\n        \"p\" : 0,\n        \"h\" : 13.3333,\n        \"y\" : 0\n      }, {\n        \"p\" : 1,\n        \"h\" : 13.3333,\n        \"y\" : 0\n      }, {\n        \"p\" : 2,\n        \"h\" : 13.3333,\n        \"y\" : 0\n      }, {\n        \"p\" : 3,\n        \"h\" : 13.3333,\n        \"y\" : 13.3333\n      }, {\n        \"p\" : 4,\n        \"h\" : 13.3333,\n        \"y\" : 13.3333\n      }, {\n        \"p\" : 5,\n        \"h\" : 13.3333,\n        \"y\" : 13.3333\n      }, {\n        \"p\" : 6,\n        \"h\" : 13.3333,\n        \"y\" : 26.6666\n      } ],\n      \"scale\" : -1,\n      \"align\" : -1,\n      \"content\" : {\n        \"h\" : 40\n      }\n    },\n    \"108\" : {\n      \"regions\" : [ {\n        \"p\" : 0,\n        \"h\" : 13.3333,\n        \"y\" : 0\n      }, {\n        \"p\" : 1,\n        \"h\" : 13.3333,\n        \"y\" : 0\n      }, {\n        \"p\" : 2,\n        \"h\" : 13.3333,\n        \"y\" : 0\n      }, {\n        \"p\" : 3,\n        \"h\" : 13.3333,\n        \"y\" : 13.3333\n      }, {\n        \"p\" : 4,\n        \"h\" : 13.3333,\n        \"y\" : 13.3333\n      }, {\n        \"p\" : 5,\n        \"h\" : 13.3333,\n        \"y\" : 13.3333\n      }, {\n        \"p\" : 6,\n        \"h\" : 13.3333,\n        \"y\" : 26.6666\n      }, {\n        \"p\" : 7,\n        \"h\" : 13.3333,\n        \"y\" : 26.6666\n      } ],\n      \"scale\" : -1,\n      \"align\" : -1,\n      \"content\" : {\n        \"h\" : 40\n      }\n    }\n  }\n}", nh0.g.class)).a());
    }

    public static final Map d() {
        new LinkedHashMap();
        return MapsKt.toMutableMap(((nh0.h) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), "{\n  \"dynamic_ui_features_map\" : {\n    \"11\" : [ 1002 ],\n    \"12\" : [ 1002 ],\n    \"3\" : [ 1002 ],\n    \"103\" : [ 1002 ],\n    \"5\" : [ 1002 ],\n    \"104\" : [ 1002 ],\n    \"105\" : [ 1002 ],\n    \"106\" : [ 1002 ],\n    \"107\" : [ 1002 ],\n    \"108\" : [ 1002 ]\n  }\n}", nh0.h.class)).a());
    }

    public static final boolean a(JsonObject r3) {
        if (r3 == null) goto L12;
        JsonObject r4 = r3.get("extra").getAsJsonObject();     // Catch: Exception -> L9
        if (r4.has("isOrderSingSetEnlarge") == false) goto L13;
        return r4.get("isOrderSingSetEnlarge").getAsBoolean();
    L13:
        return false;
    L14:
        return false;
    L12:
        return false;
    }

    public static final nh0.o b(JsonObject r14) {
        if (r14 != null) goto L29;
    L28:
        return null;
    L29:
        String r1 = r14.get("type").getAsString();     // Catch: Exception -> L26
        Locale r2 = Locale.ROOT;     // Catch: Exception -> L26
        if (r1 == null) goto L25;
        StageUpdateType r3 = StageUpdateType.valueOf(r1.toUpperCase(r2));     // Catch: Exception -> L26
        String r4 = r14.get("item_id").getAsString();     // Catch: Exception -> L26
        JsonElement r5 = r14.get("extra");     // Catch: Exception -> L26
        if (r5 == null) goto L23;
        JsonObject r6 = r5.getAsJsonObject();     // Catch: Exception -> L26
        String r7 = r6.get("schema").getAsString();     // Catch: Exception -> L26
        String r8 = r6.get("url").getAsString();     // Catch: Exception -> L26
        LayerIndex r9 = LayerIndex.values()[r6.get("layer").getAsInt()];     // Catch: Exception -> L26
        JsonObject r10 = r6.get("frame").getAsJsonObject();     // Catch: Exception -> L26
        nh0.n r11 = new nh0.n(r10.get("x").getAsInt(), r10.get("y").getAsInt(), r10.get("w").getAsInt(), r10.get("h").getAsInt());     // Catch: Exception -> L26
        JsonElement r12 = r6.get("time");     // Catch: Exception -> L26
        if (r12 == null) goto L11;
        long r13 = r12.getAsLong();     // Catch: Exception -> L26
    L12:
        JsonElement r15 = r6.get("use_schema");     // Catch: Exception -> L26
        if (r15 == null) goto L15;
        boolean r16 = r15.getAsBoolean();     // Catch: Exception -> L26
    L16:
        JsonElement r17 = r6.get("need_send_event");     // Catch: Exception -> L26
        if (r17 == null) goto L19;
        boolean r18 = r17.getAsBoolean();     // Catch: Exception -> L26
    L21:
        return new nh0.o(r3, r4, r7, r8, r9, r11, r13, r16, r18);
    L19:
        r18 = false;
        goto L21
    L15:
        r16 = false;
        goto L16
    L11:
        r13 = 0;
        goto L12
    L23:
        return new nh0.o(r3, r4, "", "", LayerIndex.Biz, null, 0, false, false);
    L25:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L26
    L26:
        e = move-exception;
        ALogger.e("MultiLinkDynamicWidget", "parseToStageExtraObject: " + r14, e);
        goto L28
    }
}
