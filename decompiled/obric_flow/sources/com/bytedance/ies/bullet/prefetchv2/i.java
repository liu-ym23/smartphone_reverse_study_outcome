package com.bytedance.ies.bullet.prefetchv2;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f5857c;
    public final LinkedHashMap d;
    public final LinkedHashMap e;
    public final boolean f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f5858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f5859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f5860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap f5861k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f5862l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f5863m;

    public i(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "json");
        this.f5856b = "GET";
        this.f5857c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.g = new ArrayList();
        boolean r5 = true;
        this.f5858h = true;
        this.f5860j = new LinkedHashMap();
        this.f5861k = new LinkedHashMap();
        this.f5855a = r10.optString("url");
        this.f5856b = r10.optString("method");
        JSONObject r11 = r10.optJSONObject("headers");
        if (r11 == null) goto L13;
        Iterator<String> r12 = r11.keys();
        if (r12 == null) goto L13;
    L7:
        if (r12.hasNext() == false) goto L13;
        String r13 = r12.next();
        JSONObject r14 = r11.optJSONObject(r13);
        LinkedHashMap r15 = this.f5857c;
        if (r14 == null) goto L11;
        g r16 = new g(r14);
    L12:
        r15.put(r13, r16);
        goto L7
    L11:
        r16 = new g(r11.optString(r13));
    L13:
        this.d = new LinkedHashMap();
        JSONObject r17 = r10.optJSONObject(LynxResourceModule.PARAMS_KEY);
        if (r17 == null) goto L20;
        Iterator<String> r18 = r17.keys();
        if (r18 == null) goto L20;
    L18:
        if (r18.hasNext() == false) goto L20;
        String r19 = r18.next();
        this.d.put(r19, new g(r17.optJSONObject(r19)));
    L20:
        this.e = new LinkedHashMap();
        JSONObject r20 = r10.optJSONObject("data");
        if (r20 == null) goto L27;
        Iterator<String> r21 = r20.keys();
        if (r21 == null) goto L27;
    L25:
        if (r21.hasNext() == false) goto L27;
        String r22 = r21.next();
        this.e.put(r22, new g(r20.optJSONObject(r22)));
    L27:
        this.f = r10.optBoolean("needCommonParams", true);
        this.f5862l = r10.optBoolean("isCustomizedCookie", false);
        if (r10.has("expireMs") == false) goto L30;
        r10.optLong("expireMs");
    L30:
        r10.optLong("expireTimestamp", -1);
        r10.optString("globalPropsName");
        JSONArray r23 = r10.optJSONArray("conditions");
        if (r23 == null) goto L37;
        ArrayList r24 = new ArrayList();
        int r25 = r23.length();
        int r26 = 0;
    L33:
        if (r26 >= r25) goto L35;
        r24.add(new e(r23.getJSONObject(r26)));
        r26 = r26 + 1;
        goto L33
    L35:
        this.g = r24;
    L37:
        if (r10.optInt("requestIgnoreCache", 1) != 1) goto L39;
        boolean r27 = true;
    L40:
        this.f5858h = r27;
        if (r10.optInt("clearCacheBeforeRequest", 0) != 1) goto L43;
        boolean r28 = true;
    L44:
        this.f5859i = r28;
        if (r10.optInt("streamLoadType", 0) == 1) goto L48;
        r5 = false;
    L48:
        this.f5863m = r5;
        JSONArray r29 = r10.optJSONArray("appendGlobalProps");
        if (r29 == null) goto L51;
        ym.a.c(r29);
    L51:
        this.f5860j = new LinkedHashMap();
        JSONObject r30 = r10.optJSONObject("extraHeaders");
        if (r30 == null) goto L58;
        Iterator<String> r31 = r30.keys();
        if (r31 == null) goto L58;
    L56:
        if (r31.hasNext() == false) goto L58;
        String r32 = r31.next();
        this.f5860j.put(r32, new g(r30.optJSONObject(r32)));
    L58:
        this.f5861k = new LinkedHashMap();
        JSONObject r33 = r10.optJSONObject("extraParams");
        if (r33 == null) goto L65;
        Iterator<String> r34 = r33.keys();
        if (r34 != null) goto L63;
        return;
    L63:
        if (r34.hasNext() == false) goto L75;
        String r35 = r34.next();
        this.f5861k.put(r35, new g(r33.optJSONObject(r35)));
        goto L63
    L75:
        return;
    L65:
        return;
    L43:
        r28 = false;
        goto L44
    L39:
        r27 = false;
        goto L40
    }

    public final boolean a(r r11) {
        Intrinsics.checkNotNullParameter(r11, "schemaModel");
        Iterator r10 = this.g.iterator();
    L3:
        boolean r5 = true;
        if (r10.hasNext() == false) goto L28;
        e r12 = (e) r10.next();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "schemaModel");
        String r13 = r12.f5842a;
        boolean r14 = Intrinsics.areEqual(r13, "query");
        String r15 = r12.f5843b;
        if (r14 == false) goto L9;
        String r16 = r11.a(r15);
    L12:
        if (r16 != null) goto L14;
        r16 = "null";
    L14:
        String r17 = r12.f5844c;
        boolean r18 = Intrinsics.areEqual(r17, "=");
        ArrayList r19 = r12.d;
        if (r18 == false) goto L18;
        r5 = r19.contains(r16);
    L23:
        StringBuilder r20 = new StringBuilder("检查预取条件, key: ");
        f8.b.e(r20, r15, ", query: ", r16, ", value: ");
        r20.append(r19);
        r20.append(", result: ");
        r20.append(r5);
        String r21 = r20.toString();
        if (r21 == null) goto L26;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPrefetch", r21, null, 12);
    L26:
        if (r5 == true) goto L3;
        return false;
    L18:
        if (Intrinsics.areEqual(r17, "!=") == false) goto L23;
        if (r19.contains(r16) == false) goto L23;
        r5 = false;
        goto L23
    L9:
        if (Intrinsics.areEqual(r13, "queryObject") == false) goto L11;
        r16 = r11.b(r15);
        goto L12
    L11:
        r16 = null;
        goto L12
    L28:
        return true;
    }
}
