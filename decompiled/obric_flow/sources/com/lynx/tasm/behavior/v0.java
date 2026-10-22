package com.lynx.tasm.behavior;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.GeckoSource;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.postprocessor.PostProcessRequest;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.android.material.timepicker.TimeModel;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.obric.clockwidgets.R$array;
import com.obric.clockwidgets.R$string;
import com.obric.clockwidgets.data.WidgetClockCity;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v0 {
    public static void A(Context r11, ArrayList r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "list");
        JSONArray r5 = new JSONArray();
        Iterator r14 = r12.iterator();
    L3:
        int r10 = 0;
        if (r14.hasNext() == false) goto L30;
        WidgetClockCity r15 = (WidgetClockCity) r14.next();
        JSONObject r16 = new JSONObject();
        r16.put("cityId", r15.f11257a);
        String r17 = r15.f11259c;
        if (r17 != null) goto L29;
        TimeZone r18 = r15.e;
        if (r18 == null) goto L10;
        r17 = r18.getID();
    L11:
        if (r17 != null) goto L29;
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r19 = r15.f11257a;
        int r20 = -1;
        if (r19 != null) goto L15;
    L23:
        if (r20 >= 0) goto L25;
    L24:
        r17 = null;
        goto L29
    L25:
        String[] r21 = r11.getResources().getStringArray(R$array.cities_tz);
        if (r20 >= r21.length) goto L24;
        r17 = r21[r20];
        goto L29
    L15:
        if (r19.length() == 0) goto L23;
        String[] r22 = r11.getResources().getStringArray(R$array.cities_id);
        int r23 = r22.length;
    L18:
        if (r10 >= r23) goto L23;
        if (Intrinsics.areEqual(r19, r22[r10]) == true) goto L21;
        r10 = r10 + 1;
        goto L18
    L21:
        r20 = r10;
        goto L23
    L10:
        r17 = null;
    L29:
        r16.put("cityTimeZone", r17);
        r16.put("time", r15.d);
        r5.put(r16);
        goto L3
    L30:
        SharedPreferences r110 = r11.getApplicationContext().getSharedPreferences("widget_clock_prefs", 0);
        r110.edit().putString(ai.j0.g(r13, "city_list_json_"), r5.toString()).apply();
        r110.edit().remove("city_order_" + r13).apply();
    }

    public static int a(int r5, long r10) {
        return androidx.room.jarjarred.org.antlr.runtime.a.e(r5, r10, 31);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Request b(String r43, Forest r44, com.bytedance.forest.model.t r45, boolean r46, com.bytedance.forest.utils.e r47) {
        com.bytedance.forest.utils.d.b(r47.g, 4, "buildRequest", "build request start. ", true, null, "req_build_start", 16);
        Map r5 = (Map) r45.f4421v.getValue();
        String r10 = r45.f4406b;
        if (r10.length() != 0) goto L10;
        com.bytedance.forest.model.l r11 = r44.getConfig().f4382i;
        if (r11 == null) goto L9;
        r10 = r11.f4386b;
        if (r10 != null) goto L10;
    L9:
        r10 = "";
    L10:
        com.bytedance.forest.model.m r12 = new com.bytedance.forest.model.m(r10, "", "");
        boolean r13 = r45.f;
        boolean r14 = r45.f4415o;
        if (r45.f4417q == true) goto L21;
        if (r14 == true) goto L21;
        Scene r15 = r45.H;
        if (r15 == Scene.f) goto L21;
        if (r15 == Scene.d) goto L21;
        if (r15 == Scene.f4348h) goto L21;
        boolean r28 = false;
    L23:
        if (r45.f4411k == false) goto L25;
    L32:
        boolean r16 = true;
    L33:
        boolean r17 = r45.f4412l;
        boolean r18 = r45.f4413m;
        boolean r19 = r45.f4414n;
        boolean r20 = r45.f4408h;
        boolean r21 = r45.g;
        if (r21 == true) goto L36;
    L45:
        boolean r110 = false;
    L46:
        boolean r111 = r45.f4409i;
        if (r21 == false) goto L49;
        boolean r112 = false;
    L50:
        Scene r113 = r45.H;
        String r22 = r45.f4419t;
        boolean r23 = r44.getConfig().f;
        Boolean r24 = r45.f4418r;
        if (r24 == null) goto L53;
        boolean r25 = r24.booleanValue();
    L54:
        Boolean r26 = r45.s;
        if (r26 == null) goto L58;
        boolean r27 = r26.booleanValue();
    L59:
        Request r29 = new Request(r43, r44, r5, r12, r13, r14, r16, r17, r18, r19, r110, r20, r111, r112, 0, r113, r46, r22, r23, r25, r27, CollectionsKt.toMutableList(r45.f4405a), r45.f4422w, r45.f4423x, r45.f4424y, r45.f4420u, r45.f4425z, r28, r45.B, r45.C, r45.D, r45.E, r45.F, r45.G, false, null);
        r29.setOnlyOnline(r45.f4416p);
        NetWorker r30 = NetWorker.f4466b;
        Boolean r31 = null;
        if (r29.getNeedLocalFile() == true) goto L63;
        r30 = null;
    L63:
        if (r30 != null) goto L66;
        r30 = r45.A;
    L66:
        if (r30 != null) goto L69;
        r30 = r44.getConfig().f4378a;
    L69:
        int r32 = r30.ordinal();
        if (r32 == 0) goto L76;
        int r33 = 1;
        if (r32 != 1) goto L75;
        com.bytedance.forest.pollyfill.m r34 = new com.bytedance.forest.pollyfill.i(r47);
    L77:
        r29.setNetDepender$forest_release(r34);
        Unit r35 = Unit.INSTANCE;
        if ((r45 instanceof com.bytedance.forest.postprocessor.e) == true) goto L80;
        Request r36 = r29;
    L81:
        if (r36 != null) goto L84;
        r36 = new PostProcessRequest(r29, ((com.bytedance.forest.postprocessor.e) r45).I);
    L84:
        Uri r37 = r36.getOriginUri();
        if (r37.isHierarchical() == false) goto L164;
        r44.getGeckoXAdapter().isGeckoCDNAndMergeConfig(r37, r43, r36);
        if (r36.getGeckoModel().a() == false) goto L116;
        String r38 = com.lynx.tasm.utils.b.g(r37, "gecko_channel");
        if (r38 != null) goto L93;
        r38 = com.lynx.tasm.utils.b.g(r37, LynxMonitorService.KEY_CHANNEL);
    L93:
        String r39 = com.lynx.tasm.utils.b.g(r37, "gecko_bundle");
        if (r39 != null) goto L98;
        r39 = com.lynx.tasm.utils.b.g(r37, "bundle");
    L98:
        if (com.lynx.tasm.behavior.utils.d.g(r38) == false) goto L116;
        if (com.lynx.tasm.behavior.utils.d.g(r39) == false) goto L116;
        com.bytedance.forest.model.m r40 = r36.getGeckoModel();
        if (r38 != null) goto L104;
        Intrinsics.throwNpe();
    L104:
        r40.getClass();
        r40.f4390b = r38;
        com.bytedance.forest.model.m r41 = r36.getGeckoModel();
        if (r39 != null) goto L107;
        Intrinsics.throwNpe();
    L107:
        r41.getClass();
        r41.f4391c = r39;
        String r42 = r37.getQueryParameter("accessKey");
        if (r42 != null) goto L112;
        r42 = r37.getQueryParameter("gecko_access_key");
    L112:
        if (com.lynx.tasm.behavior.utils.d.g(r42) == false) goto L114;
        com.bytedance.forest.model.m r48 = r36.getGeckoModel();
        r48.getClass();
        r48.f4389a = r42;
    L114:
        r36.setGeckoSource(GeckoSource.f4323c);
    L116:
        if (r36.getGeckoModel().a() == false) goto L123;
        String r114 = r37.getQueryParameter("prefix");
        if (r114 != null) goto L121;
        r114 = "";
    L121:
        q(r43, r36, CollectionsKt.listOf(r114), GeckoSource.d);
    L123:
        if (r36.getGeckoModel().a() == false) goto L134;
        com.bytedance.forest.model.m r49 = r36.getGeckoModel();
        String r115 = r45.f4407c;
        if (r115 != null) goto L128;
        r115 = "";
    L128:
        r49.getClass();
        r49.f4390b = r115;
        com.bytedance.forest.model.m r50 = r36.getGeckoModel();
        String r116 = r45.d;
        if (r116 != null) goto L132;
        r116 = "";
    L132:
        r50.getClass();
        r50.f4391c = r116;
    L134:
        if (r36.getGeckoModel().a() == false) goto L140;
        List r51 = r45.e;
        if (r51 != null) goto L139;
        r51 = CollectionsKt.emptyList();
    L139:
        q(r43, r36, r51, GeckoSource.e);
    L140:
        Uri r52 = r36.getOriginUri();
        String r53 = com.lynx.tasm.utils.b.g(r52, "only_online");
        if (r53 == null) goto L144;
        r36.setOnlyOnline(Intrinsics.areEqual(r53, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST));
    L144:
        if (r36.getGeckoSource() == GeckoSource.f4321a) goto L164;
        String r54 = com.lynx.tasm.utils.b.g(r52, "wait_gecko_update");
        if (r54 == null) goto L148;
        r31 = Boolean.valueOf(Intrinsics.areEqual(r54, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST));
    L160:
        if (r31 == null) goto L162;
        boolean r55 = r31.booleanValue();
    L163:
        r36.setWaitGeckoUpdate(r55);
        goto L164
    L162:
        r55 = r36.getWaitGeckoUpdate();
        goto L163
    L148:
        String r56 = com.lynx.tasm.utils.b.g(r52, "dynamic");
        if (r56 == null) goto L160;
        Integer r57 = StringsKt.toIntOrNull(r56);
        if (r57 == null) goto L160;
        int r58 = r57.intValue();
        if (r58 != r33) goto L155;
    L158:
        boolean r117 = r33;
    L159:
        r31 = Boolean.valueOf(r117);
        goto L160
    L155:
        if (r58 == 2) goto L158;
        r117 = 0;
    L164:
        return r36;
    L80:
        r36 = null;
        goto L81
    L75:
        throw new NoWhenBranchMatchedException();
    L76:
        r33 = 1;
        r34 = new com.bytedance.forest.pollyfill.q(r47);
        goto L77
    L58:
        r27 = r44.getConfig().g;
        goto L59
    L53:
        r44.getConfig().getClass();
        r25 = false;
        goto L54
    L49:
        r112 = r45.f4410j;
        goto L50
    L36:
        if (r45.B == false) goto L38;
        if (r20 == false) goto L45;
    L38:
        Scene r118 = r45.H;
        if (r118 == Scene.f) goto L45;
        if (r118 == Scene.d) goto L45;
        if (r118 == Scene.f4348h) goto L45;
        r110 = true;
        goto L46
    L25:
        if (StringsKt.P(r43, "http://") == true) goto L29;
        if (StringsKt.P(r43, "https://") == false) goto L32;
    L29:
        if (r45.H == Scene.f) goto L32;
        r16 = false;
    L21:
        r28 = true;
        goto L23
    }

    public static final JavaOnlyArray c(List r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "sourceArray");
        JavaOnlyArray r5 = new JavaOnlyArray();
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L41;
        Object r14 = r10.get(r13);
        if ((r14 instanceof Map) == false) goto L9;
        r5.pushMap(f(r11, (Map) r14));     // Catch: Exception -> L42
    L40:
        r13 = r13 + 1;
        goto L3
    L9:
        if ((r14 instanceof List) == false) goto L13;
        r5.pushArray(c((List) r14, r11));     // Catch: Exception -> L42
        goto L40
    L13:
        if ((r14 instanceof Boolean) == false) goto L16;
        r5.pushBoolean(((Boolean) r14).booleanValue());
        goto L40
    L16:
        if ((r14 instanceof Integer) == false) goto L19;
        r5.pushInt(((Number) r14).intValue());
        goto L40
    L19:
        if ((r14 instanceof Long) == false) goto L31;
        long r15 = ((Number) r14).longValue();
        if (r11 != 0) goto L23;
        r5.pushDouble(r15);
        goto L40
    L23:
        if (r11 != 1) goto L25;
        r5.pushString(String.valueOf(r15));
        goto L40
    L25:
        if (r11 != 2) goto L40;
        r5.pushLong(r15);
        goto L40
    L31:
        if ((r14 instanceof Float) == false) goto L34;
        r5.pushDouble(((Number) r14).floatValue());
        goto L40
    L34:
        if ((r14 instanceof Double) == false) goto L37;
        r5.pushDouble(((Number) r14).doubleValue());
        goto L40
    L37:
        if ((r14 instanceof String) == false) goto L39;
        r5.pushString((String) r14);
        goto L40
    L39:
        r5.pushString(r14.toString());
        goto L40
    L41:
        return r5;
    }

    public static JavaOnlyArray d(JSONArray r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonArray");
        JavaOnlyArray r10 = new JavaOnlyArray();
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L32;
        Object r13 = r5.get(r12);
        if ((r13 instanceof Float) == false) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == false) goto L11;
        r10.pushDouble(r5.getDouble(r12));
    L31:
        r12 = r12 + 1;
        goto L3
    L11:
        if ((r13 instanceof Long) == false) goto L14;
        r10.pushDouble(r5.getLong(r12));
        goto L31
    L14:
        if ((r13 instanceof Number) == false) goto L17;
        r10.pushInt(r5.getInt(r12));
        goto L31
    L17:
        if ((r13 instanceof String) == false) goto L20;
        r10.pushString(r5.getString(r12));
        goto L31
    L20:
        if ((r13 instanceof Boolean) == false) goto L23;
        r10.pushBoolean(r5.getBoolean(r12));
        goto L31
    L23:
        if ((r13 instanceof JSONObject) == false) goto L26;
        r10.pushMap(g(r5.getJSONObject(r12)));
        goto L31
    L26:
        if ((r13 instanceof JSONArray) == false) goto L29;
        r10.pushArray(d(r5.getJSONArray(r12)));
        goto L31
    L29:
        if (Intrinsics.areEqual(r13, JSONObject.NULL) == false) goto L31;
        r10.pushNull();
        goto L31
    L7:
        r14 = r13 instanceof Double;
        goto L8
    L32:
        return r10;
    }

    public static final JavaOnlyArray e(JSONArray r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "jsonArray");
        JavaOnlyArray r5 = new JavaOnlyArray();
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L39;
        Object r14 = r10.get(r13);
        if ((r14 instanceof JSONObject) == false) goto L8;
        r5.pushMap(h((JSONObject) r14, r11));
    L38:
        r13 = r13 + 1;
        goto L3
    L8:
        if ((r14 instanceof JSONArray) == false) goto L11;
        r5.pushArray(e((JSONArray) r14, r11));
        goto L38
    L11:
        if ((r14 instanceof Boolean) == false) goto L14;
        r5.pushBoolean(((Boolean) r14).booleanValue());
        goto L38
    L14:
        if ((r14 instanceof Integer) == false) goto L17;
        r5.pushInt(((Number) r14).intValue());
        goto L38
    L17:
        if ((r14 instanceof Long) == false) goto L29;
        long r15 = ((Number) r14).longValue();
        if (r11 != 0) goto L21;
        r5.pushDouble(r15);
        goto L38
    L21:
        if (r11 != 1) goto L23;
        r5.pushString(String.valueOf(r15));
        goto L38
    L23:
        if (r11 != 2) goto L38;
        r5.pushLong(r15);
        goto L38
    L29:
        if ((r14 instanceof Float) == false) goto L32;
        r5.pushDouble(((Number) r14).floatValue());
        goto L38
    L32:
        if ((r14 instanceof Double) == false) goto L35;
        r5.pushDouble(((Number) r14).doubleValue());
        goto L38
    L35:
        if ((r14 instanceof String) == false) goto L37;
        r5.pushString((String) r14);
        goto L38
    L37:
        r5.pushString(r14.toString());
        goto L38
    L39:
        return r5;
    }

    public static final JavaOnlyMap f(int r5, Map r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        JavaOnlyMap r11 = new JavaOnlyMap();
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L52;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        Object r15 = r13.getValue();
        if ((r15 instanceof Map) == false) goto L10;
        r11.putMap(r14, f(r5, (Map) r15));     // Catch: Exception -> L53
        goto L4
    L10:
        if ((r15 instanceof List) == true) goto L11;
        if ((r15 instanceof Boolean) == true) goto L15;
        if ((r15 instanceof Integer) == true) goto L18;
        if ((r15 instanceof Long) == true) goto L21;
        if ((r15 instanceof Float) == true) goto L33;
        if ((r15 instanceof Double) == true) goto L36;
        if ((r15 instanceof String) == true) goto L39;
        if ((r15 instanceof JSONObject) == true) goto L42;
        if ((r15 instanceof JSONArray) == true) goto L45;
        if (r15 == null) goto L51;
        if (Intrinsics.areEqual(r15, JSONObject.NULL) == true) goto L51;
        r11.putString(r14, r15.toString());
    L51:
        r11.putNull(r14);
        goto L4
    L45:
        r11.putArray(r14, e((JSONArray) r15, r5));
        goto L4
    L42:
        r11.putMap(r14, h((JSONObject) r15, r5));
        goto L4
    L39:
        r11.putString(r14, (String) r15);
        goto L4
    L36:
        r11.putDouble(r14, ((Number) r15).doubleValue());
        goto L4
    L33:
        r11.putDouble(r14, ((Number) r15).floatValue());
        goto L4
    L21:
        long r16 = ((Number) r15).longValue();
        if (r5 != 0) goto L24;
        r11.putDouble(r14, r16);
        goto L4
    L24:
        if (r5 != 1) goto L26;
        r11.putString(r14, String.valueOf(r16));
        goto L4
    L26:
        if (r5 != 2) goto L4;
        r11.putLong(r14, r16);
        goto L4
    L18:
        r11.putInt(r14, ((Number) r15).intValue());
        goto L4
    L15:
        r11.putBoolean(r14, ((Boolean) r15).booleanValue());
        goto L4
    L11:
        r11.putArray(r14, c((List) r15, r5));     // Catch: Exception -> L53
        goto L4
    L52:
        return r11;
    }

    public static JavaOnlyMap g(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        JavaOnlyMap r10 = new JavaOnlyMap();
        Iterator<String> r11 = r5.keys();
    L4:
        if (r11.hasNext() == false) goto L32;
        String r12 = r11.next();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.String");
        String r13 = r12;
        Object r14 = r5.get(r13);
        if ((r14 instanceof Float) == false) goto L8;
        boolean r15 = true;
    L9:
        if (r15 == true) goto L10;
        if ((r14 instanceof Long) == true) goto L13;
        if ((r14 instanceof Number) == true) goto L16;
        if ((r14 instanceof String) == true) goto L19;
        if ((r14 instanceof Boolean) == true) goto L22;
        if ((r14 instanceof JSONObject) == true) goto L25;
        if ((r14 instanceof JSONArray) == true) goto L28;
        if (Intrinsics.areEqual(r14, JSONObject.NULL) == false) goto L4;
        r10.putNull(r13);
        goto L4
    L28:
        r10.putArray(r13, d(r5.getJSONArray(r13)));
        goto L4
    L25:
        r10.putMap(r13, g(r5.getJSONObject(r13)));
        goto L4
    L22:
        r10.putBoolean(r13, r5.getBoolean(r13));
        goto L4
    L19:
        r10.putString(r13, r5.getString(r13));
        goto L4
    L16:
        r10.putInt(r13, r5.getInt(r13));
        goto L4
    L13:
        r10.putDouble(r13, r5.getLong(r13));
        goto L4
    L10:
        r10.putDouble(r13, r5.getDouble(r13));
        goto L4
    L8:
        r15 = r14 instanceof Double;
        goto L9
    L32:
        return r10;
    }

    public static final JavaOnlyMap h(JSONObject r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        JavaOnlyMap r5 = new JavaOnlyMap();
        Iterator<String> r12 = r10.keys();
    L4:
        if (r12.hasNext() == false) goto L42;
        String r13 = r12.next();
        Object r14 = r10.get(r13);
        if ((r14 instanceof JSONObject) == true) goto L7;
        if (Intrinsics.areEqual(r14, JSONObject.NULL) == true) goto L10;
        if ((r14 instanceof JSONArray) == true) goto L13;
        if ((r14 instanceof Boolean) == true) goto L16;
        if ((r14 instanceof Integer) == true) goto L19;
        if ((r14 instanceof Long) == true) goto L22;
        if ((r14 instanceof Float) == true) goto L34;
        if ((r14 instanceof Double) == true) goto L37;
        if ((r14 instanceof String) == true) goto L40;
        r5.putString(r13, r14.toString());
        goto L4
    L40:
        r5.putString(r13, (String) r14);
        goto L4
    L37:
        r5.putDouble(r13, ((Number) r14).doubleValue());
        goto L4
    L34:
        r5.putDouble(r13, ((Number) r14).floatValue());
        goto L4
    L22:
        long r15 = ((Number) r14).longValue();
        if (r11 != 0) goto L25;
        r5.putDouble(r13, r15);
        goto L4
    L25:
        if (r11 != 1) goto L27;
        r5.putString(r13, String.valueOf(r15));
        goto L4
    L27:
        if (r11 != 2) goto L4;
        r5.putLong(r13, r15);
        goto L4
    L19:
        r5.putInt(r13, ((Number) r14).intValue());
        goto L4
    L16:
        r5.putBoolean(r13, ((Boolean) r14).booleanValue());
        goto L4
    L13:
        r5.putArray(r13, e((JSONArray) r14, r11));
        goto L4
    L10:
        r5.putMap(r13, null);
        goto L4
    L7:
        r5.putMap(r13, h((JSONObject) r14, r11));
        goto L4
    L42:
        return r5;
    }

    public static com.lynx.tasm.u i(String r10, boolean r11, boolean r12, String[] r13, boolean r14, boolean r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r10, "groupName");
        if (r16 == true) goto L5;
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r17 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r17 == null) goto L13;
        xc.d r18 = (xc.d) r17.a(xc.d.class);
        if (r18 == null) goto L13;
        Boolean r19 = r18.v0();
        if (r19 == null) goto L13;
        boolean r20 = r19.booleanValue();
    L14:
        if (r20 == false) goto L18;
        return com.bytedance.ies.bullet.lynx.init.d.a(r10, r11, r12, r13, r14, r15);
    L18:
        if (Intrinsics.areEqual(r10, "-1") == false) goto L26;
        if (r12 == true) goto L23;
        if (r15 == true) goto L23;
        boolean r21 = false;
    L25:
        return new com.lynx.tasm.u(r10, r10, r13, r21, r14, Boolean.FALSE, false);
    L23:
        r21 = true;
        goto L25
    L26:
        if (r11 == true) goto L28;
        String r22 = String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(com.lynx.tasm.u.g)});
        com.lynx.tasm.u.g++;
        if (r12 == true) goto L34;
        if (r15 == true) goto L34;
        boolean r23 = false;
    L36:
        return new com.lynx.tasm.u(r10, r22, r13, r23, r14, Boolean.FALSE, false);
    L34:
        r23 = true;
        goto L36
    L28:
        return com.bytedance.ies.bullet.lynx.init.d.c(r10, r13, r12, r14, r15, false);
    L13:
        r20 = false;
        goto L14
    L5:
        return com.bytedance.ies.bullet.lynx.init.d.c(r10, r13, r12, r14, r15, true);
    }

    public static Number j(Number r10) {
        Intrinsics.checkNotNullParameter(r10, "rawNumber");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(Integer.valueOf(r10.intValue()));     // Catch: Throwable -> L5
    L7:
        Object r12 = null;
        if (Result.m130isFailureimpl(r11) == false) goto L10;
        r11 = null;
    L10:
        Integer r13 = (Integer) r11;
        if (r13 == null) goto L13;
        int r14 = r13.intValue();
    L38:
        Object r15 = Result.m124constructorimpl(Double.valueOf(r10.doubleValue()));     // Catch: Throwable -> L16
    L19:
        if (Result.m130isFailureimpl(r15) == true) goto L22;
        r12 = r15;
    L22:
        Double r16 = (Double) r12;
        if (r16 == null) goto L25;
        double r17 = r16.doubleValue();
    L27:
        if (Double.compare(r14, r17) == 0) goto L29;
        long r18 = (long) r17;
        if (Double.compare(r17, r18) != 0) goto L35;
        return Long.valueOf(r18);
    L35:
        return Double.valueOf(r17);
    L29:
        return Integer.valueOf(r14);
    L25:
        r17 = 0.0d;
    L16:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    L13:
        r14 = 0;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static Object k(Object r5) {
        if ((r5 instanceof ReadableArray) == false) goto L9;
        ReadableArray r10 = (ReadableArray) r5;
        int r11 = r10.size();
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L5:
        if (r13 >= r11) goto L7;
        r12.add(k(l(r10.getDynamic(r13))));
        r13 = r13 + 1;
        goto L5
    L7:
        return r12;
    L9:
        if ((r5 instanceof ReadableMap) == false) goto L16;
        ReadableMap r14 = (ReadableMap) r5;
        Intrinsics.checkNotNullParameter(r14, "value");
        ReadableMapKeySetIterator r15 = r14.keySetIterator();
        HashMap r16 = new HashMap();
    L12:
        if (r15.hasNextKey() == false) goto L14;
        String r17 = r15.nextKey();
        r16.put(r17, k(l(r14.getDynamic(r17))));
        goto L12
    L14:
        return r16;
    L16:
        if ((r5 instanceof Number) == true) goto L18;
        return r5;
    L18:
        return j((Number) r5);
    }

    public static Object l(pm.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r10 = -1;
        if (ki.a.e == false) goto L24;
        ReadableType r11 = r5.getType();
        if (r11 == null) goto L8;
        r10 = com.bytedance.sdk.xbridge.cn.platform.lynx.d.f7367a[r11.ordinal()];
    L8:
        switch(r10) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            default: goto L9;
        };
    L9:
        return null;
    L11:
        return r5.asArray();
    L13:
        return r5.asMap();
    L15:
        return Boolean.valueOf(r5.asBoolean());
    L17:
        return j(Integer.valueOf(r5.asInt()));
    L19:
        return j(Long.valueOf(r5.asLong()));
    L21:
        return j(Double.valueOf(r5.asDouble()));
    L23:
        return r5.asString();
    L24:
        ReadableType r12 = r5.getType();
        if (r12 == null) goto L29;
        r10 = com.bytedance.sdk.xbridge.cn.platform.lynx.d.f7367a[r12.ordinal()];
    L29:
        if (r10 == 1) goto L48;
        if (r10 == 2) goto L46;
        if (r10 == 5) goto L44;
        if (r10 == 6) goto L42;
        if (r10 == 7) goto L40;
        return null;
    L40:
        return r5.asArray();
    L42:
        return r5.asMap();
    L44:
        return Boolean.valueOf(r5.asBoolean());
    L46:
        return j(Double.valueOf(r5.asDouble()));
    L48:
        return r5.asString();
    }

    public static String m(String r5) {
        ArrayList r10 = com.lynx.tasm.base.a.f(r5.replace("：", ":"));     // Catch: Exception -> L7
        if (r10.isEmpty() == true) goto L13;
        return m.t.a(((m.c) r10.get(r10.size() - 1)).d, "yyyy-MM-dd");
    L13:
        return null;
    L7:
        e = move-exception;
        Log.d("l", "parse text to datetime error: " + e.getMessage());
        return null;
    }

    public static final ArrayList n(JavaOnlyArray r10) {
        ArrayList r5 = new ArrayList();
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L24;
        Object r13 = r10.get(r12);
        ReadableType r14 = r10.getType(r12);     // Catch: Throwable -> L16
        if (r14 != null) goto L8;
        int r15 = -1;
    L10:
        if (r15 != 2) goto L12;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L16
        r5.add(j((Number) r13));     // Catch: Throwable -> L16
    L23:
        r12 = r12 + 1;
        goto L3
    L12:
        if (r15 != 6) goto L14;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyMap");     // Catch: Throwable -> L16
        r5.add(o((JavaOnlyMap) r13));     // Catch: Throwable -> L16
        goto L23
    L14:
        if (r15 == 7) goto L18;
        r5.add(r13);     // Catch: Throwable -> L16
        goto L23
    L18:
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyArray");     // Catch: Throwable -> L16
        r5.add(n((JavaOnlyArray) r13));     // Catch: Throwable -> L16
        goto L23
    L8:
        r15 = com.bytedance.sdk.xbridge.cn.platform.lynx.d.f7367a[r14.ordinal()];     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        ki.a.a("convertJavaOnlyArrayToList " + th);
        goto L23
    L24:
        return r5;
    }

    public static final LinkedHashMap o(JavaOnlyMap r10) {
        Intrinsics.checkNotNullParameter(r10, "map");
        LinkedHashMap r5 = new LinkedHashMap();
        if (r10.isEmpty() == true) goto L27;
        ReadableMapKeySetIterator r11 = r10.keySetIterator();
    L7:
        if (r11.hasNextKey() == false) goto L27;
        String r12 = r11.nextKey();
        Object r13 = r10.get(r12);
        ReadableType r14 = r10.getType(r12);     // Catch: Throwable -> L20
        if (r14 != null) goto L12;
        int r15 = -1;
    L14:
        if (r15 != 2) goto L16;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L20
        r5.put(r12, j((Number) r13));     // Catch: Throwable -> L20
        goto L7
    L16:
        if (r15 != 6) goto L18;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyMap");     // Catch: Throwable -> L20
        r5.put(r12, o((JavaOnlyMap) r13));     // Catch: Throwable -> L20
        goto L7
    L18:
        if (r15 != 7) goto L19;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyArray");     // Catch: Throwable -> L20
        r5.put(r12, n((JavaOnlyArray) r13));     // Catch: Throwable -> L20
        goto L7
    L19:
        r5.put(r12, r13);     // Catch: Throwable -> L20
        goto L7
    L12:
        r15 = com.bytedance.sdk.xbridge.cn.platform.lynx.d.f7367a[r14.ordinal()];     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        ki.a.a("convertJavaOnlyMapToMap " + th);
    L27:
        return r5;
    }

    public static xd.d p(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        Object r12 = r5.getSystemService("window");     // Catch: Throwable -> L8
        if (r12 != null) goto L6;
    L16:
        DisplayMetrics r13 = r5.getResources().getDisplayMetrics();     // Catch: Throwable -> L8
        return new xd.d(r13.widthPixels, r13.heightPixels);
    L6:
        if ((r12 instanceof WindowManager) == false) goto L10;
        WindowManager r14 = (WindowManager) r12;     // Catch: Throwable -> L8
    L11:
        if (r14 == null) goto L16;
        Display r15 = r14.getDefaultDisplay();     // Catch: Throwable -> L8
        if (r15 == null) goto L16;
        Point r16 = new Point();     // Catch: Throwable -> L8
        r15.getRealSize(r16);     // Catch: Throwable -> L8
        return new xd.d(r16.x, r16.y);
    L10:
        r14 = null;
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Object r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
        if (Result.m130isFailureimpl(r18) == true) goto L23;
        r10 = r18;
    L23:
        return (xd.d) r10;
    }

    public static void q(String r5, Request r10, List r11, GeckoSource r12) {
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L12;
        com.bytedance.forest.model.m r14 = com.lynx.tasm.utils.a.c(r5, (String) r13.next());
        if (r14 == null) goto L4;
        r10.setGeckoSource(r12);
        com.bytedance.forest.model.m r15 = r10.getGeckoModel();
        String r16 = r14.f4390b;
        r15.getClass();
        r15.f4390b = r16;
        com.bytedance.forest.model.m r17 = r10.getGeckoModel();
        String r18 = r14.f4391c;
        r17.getClass();
        r17.f4391c = r18;
        return;
    }

    public static long r(AtomicLong r5, long r10) {
    L2:
        long r11 = r5.get();
        if (r11 == Long.MAX_VALUE) goto L4;
        if (r5.compareAndSet(r11, t(r11, r10)) == false) goto L2;
        return r11;
    L4:
        return Long.MAX_VALUE;
    }

    public static long s(AtomicLong r5, long r10) {
    L2:
        long r11 = r5.get();
        if (r11 == Long.MIN_VALUE) goto L4;
        if (r11 == Long.MAX_VALUE) goto L7;
        if (r5.compareAndSet(r11, t(r11, r10)) == false) goto L2;
        return r11;
    L7:
        return Long.MAX_VALUE;
    L4:
        return Long.MIN_VALUE;
    }

    public static long t(long r5, long r10) {
        long r11 = r5 + r10;
        if (r11 >= 0) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r11;
    }

    public static ArrayList u(Context r12) {
        long r10 = System.currentTimeMillis();
        String r5 = r12.getString(R$string.widget_clock_city_beijing);
        String r11 = r12.getString(R$string.timezone_cn);
        TimeZone r13 = TimeZone.getTimeZone(r12.getString(R$string.timezone_cn));
        String r14 = r12.getString(R$string.widget_clock_country_cn);
        WidgetClockCity r15 = new WidgetClockCity(r12.getString(R$string.widget_clock_city_beijing_id), r5, r11, r10, r13, r14);
        String r16 = r12.getString(R$string.widget_clock_city_new_york);
        String r17 = r12.getString(R$string.timezone_us);
        TimeZone r18 = TimeZone.getTimeZone(r12.getString(R$string.timezone_us));
        String r19 = r12.getString(R$string.widget_clock_country_usa);
        WidgetClockCity r110 = new WidgetClockCity(r12.getString(R$string.widget_clock_city_new_york_id), r16, r17, r10, r18, r19);
        String r20 = r12.getString(R$string.widget_clock_city_london);
        String r21 = r12.getString(R$string.timezone_uk);
        TimeZone r22 = TimeZone.getTimeZone(r12.getString(R$string.timezone_uk));
        String r23 = r12.getString(R$string.widget_clock_country_uk);
        return CollectionsKt.arrayListOf(new WidgetClockCity[]{r15, r110, new WidgetClockCity(r12.getString(R$string.widget_clock_city_london_id), r20, r21, r10, r22, r23)});
    }

    public static ArrayList v(int r12, Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        int r5 = 0;
        SharedPreferences r10 = r13.getApplicationContext().getSharedPreferences("widget_clock_prefs", 0);
        String r11 = r10.getString("city_list_json_" + r12, null);
        if (r11 != null) goto L5;
    L28:
        String r14 = r10.getString("city_order_" + r12, null);
        if (r14 == null) goto L61;
        if (r14.length() == 0) goto L61;
        List r15 = StringsKt.K(r14, new String[]{"|"}, 0, 6);
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator r17 = r15.iterator();
    L35:
        if (r17.hasNext() == false) goto L37;
        r16.add(StringsKt.trim((String) r17.next()).toString());
        goto L35
    L37:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r16.iterator();
    L39:
        if (r19.hasNext() == false) goto L43;
        Object r20 = r19.next();
        if (((String) r20).length() <= 0) goto L39;
        r18.add(r20);
        goto L39
    L43:
        ArrayList r110 = u(r13);
        LinkedHashMap r21 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r110)), 16));
        Iterator r111 = r110.iterator();
    L45:
        if (r111.hasNext() == false) goto L50;
        Object r22 = r111.next();
        String r23 = ((WidgetClockCity) r22).f11258b;
        if (r23 != null) goto L49;
        r23 = "";
    L49:
        r21.put(r23, r22);
        goto L45
    L50:
        Map r112 = MapsKt.toMutableMap(r21);
        ArrayList r24 = new ArrayList(r112.size());
        Iterator r113 = r18.iterator();
    L52:
        if (r113.hasNext() == false) goto L57;
        WidgetClockCity r25 = (WidgetClockCity) r112.remove((String) r113.next());
        if (r25 == null) goto L52;
        r24.add(r25);
        goto L52
    L57:
        if (r112.isEmpty() == true) goto L59;
        r24.addAll(r112.values());
    L59:
        return r24;
    L61:
        return u(r13);
    L5:
        if (r11.length() == 0) goto L28;
        ArrayList r114 = new ArrayList();
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L16
        JSONArray r27 = new JSONArray(r11);     // Catch: Throwable -> L16
        int r28 = r27.length();     // Catch: Throwable -> L16
    L9:
        if (r5 >= r28) goto L21;
        JSONObject r29 = r27.optJSONObject(r5);     // Catch: Throwable -> L16
        if (r29 == null) goto L20;
        String r30 = r29.optString("cityTimeZone", null);     // Catch: Throwable -> L16
        String r31 = r29.optString("cityId", null);     // Catch: Throwable -> L16
        long r32 = r29.optLong("time", System.currentTimeMillis());     // Catch: Throwable -> L16
        if (r30 == null) goto L18;
        TimeZone r115 = TimeZone.getTimeZone(r30);     // Catch: Throwable -> L16
    L19:
        r114.add(new WidgetClockCity(r31, r30, r32, r115));     // Catch: Throwable -> L16
        goto L20
    L18:
        r115 = null;
    L20:
        r5 = r5 + 1;     // Catch: Throwable -> L16
        goto L9
    L21:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L25:
        if (r114.isEmpty() == false) goto L27;
        r114.addAll(u(r13));
    L27:
        return r114;
    L16:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    public static String w(String r10) {
        Charset r5 = StandardCharsets.UTF_8;
        if (r10 != null) goto L5;
        byte[] r11 = null;
    L16:
        byte[] r12 = MessageDigest.getInstance("MD5").digest(r11);
        char[] r13 = pu.a.f21390a;
        char[] r14 = new char[r12.length << 1];
        int r15 = r12.length;
        int r16 = 0;
        int r17 = 0;
    L9:
        if (r16 >= r15) goto L12;
        int r18 = r17 + 1;
        byte r19 = r12[r16];
        char[] r20 = pu.a.f21390a;
        r14[r17] = r20[(r19 & 240) >>> 4];
        r17 = r17 + 2;
        r14[r18] = r20[r19 & 15];
        r16 = r16 + 1;
        goto L9
    L12:
        return new String(r14);
    L13:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L5:
        r11 = r10.getBytes(r5);
        goto L16
    }

    public static long x(long r10, long r11) {
        long r5 = r10 * r11;
        if (((r10 | r11) >>> 31) != 0) goto L5;
    L8:
        return r5;
    L5:
        if ((r5 / r10) == r11) goto L8;
        return Long.MAX_VALUE;
    }

    public static void y(AtomicLong r10, long r11) {
    L2:
        long r5 = r10.get();
        if (r5 == Long.MAX_VALUE) goto L4;
        long r12 = r5 - r11;
        if (r12 >= 0) goto L9;
        wn.f.k(new IllegalStateException(androidx.constraintlayout.motion.widget.a.j(r12, "More produced than requested: ")));
        r12 = 0;
    L9:
        if (r10.compareAndSet(r5, r12) == false) goto L2;
        return;
    }

    public static long z(AtomicLong r10, long r11) {
    L2:
        long r5 = r10.get();
        if (r5 == Long.MIN_VALUE) goto L4;
        if (r5 == Long.MAX_VALUE) goto L7;
        long r12 = r5 - r11;
        if (r12 >= 0) goto L12;
        wn.f.k(new IllegalStateException(androidx.constraintlayout.motion.widget.a.j(r12, "More produced than requested: ")));
        r12 = 0;
    L12:
        if (r10.compareAndSet(r5, r12) == false) goto L2;
        return r12;
    L7:
        return Long.MAX_VALUE;
    L4:
        return Long.MIN_VALUE;
    }
}
