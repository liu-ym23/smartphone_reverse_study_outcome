package com.bytedance.android.live.anchormodelink.handlers;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;
import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import iy.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements iy.e {
    public final Map<String, String> a;
    public final CompositeDisposable b;
    public Disposable c;
    public long d;
    public final Set<String> e;
    public JSONObject f;
    public final JsonObject g;
    public boolean h;
    public Integer i;
    public h j;
    public final List<String> k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            Set<String> r7 = CollectionsKt.toSet(this.a.e);
            this.a.e.clear();
            d r0 = this.a;
            JSONObject r1 = r0.d(r0.k);
            boolean r2 = true;
            d r3 = this.a;     // Catch: Exception -> L11
            if (r3.f != null) goto L7;
        L21:
            goto L16
        L7:
            if (r3.g.keySet().size() <= 0) goto L12;
            JSONObject r4 = this.a.f;     // Catch: Exception -> L11
            Intrinsics.checkNotNull(r4);     // Catch: Exception -> L11
            if (d.f(r1, r4, this.a.g) == false) goto L21;
        L15:
            r2 = false;
            goto L21
        L12:
            JSONObject r8 = this.a.f;     // Catch: Exception -> L11
            Intrinsics.checkNotNull(r8);     // Catch: Exception -> L11
            if (d.f(r1, r8, 1) == true) goto L15;
        L16:
            if (r2 == false) goto L18;
            this.a.i(r7);
            d r9 = this.a;
            i97.a r11 = i97.a.a;
            r9.d = System.currentTimeMillis();
        L19:
            this.a.c = null;
            return;
        L18:
            jy0.b.a("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] 窗口结束 diff 无变化，取消发送");
            goto L19
        }
    }

    static {
    }

    @Override // iy.e
    public final void onStart() {
    }

    @Override // iy.e
    public final void onStop() {
        ((LinkedHashMap) this.a).clear();
        this.f = null;
        this.d = 0;
    }

    public d(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "cacheKeys");
        this.k = r3;
        this.a = new LinkedHashMap();
        this.b = new CompositeDisposable();
        this.d = 0;
        this.e = new LinkedHashSet();
        this.g = new JsonObject();
    }

    @Override // iy.e
    public final JsonObject C(my.b r3) {
        Intrinsics.checkNotNullParameter(r3, "getStatusData");
        DynamicCenterGetType r0 = r3.getType();
        if (e.b[r0.ordinal()] == 1) goto L6;
        return null;
    L6:
        JsonObject r4 = r3.b;
        if (r4 == null) goto L12;
        JsonElement r5 = r4.get("keys");
        if (r5 == null) goto L12;
        JsonArray r6 = r5.getAsJsonArray();
        if (r6 == null) goto L12;
    L14:
        return e(r6);
    L12:
        r6 = new JsonArray();
        goto L14
    }

    @Override // iy.e
    public final boolean a(DynamicCenterUpdateType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r2 != DynamicCenterUpdateType.registerSEI) goto L5;
    L8:
        return true;
    L5:
        if (r2 == DynamicCenterUpdateType.videoLinkmicAction) goto L8;
        return false;
    }

    @Override // iy.e
    public final boolean c(DynamicCenterGetType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r2 != DynamicCenterGetType.latestSEI) goto L5;
        return true;
    L5:
        return false;
    }

    public final JSONObject d(Collection<String> r5) {
        JSONObject r0 = new JSONObject();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        String r1 = (String) r6.next();
        String r2 = (String) ((LinkedHashMap) this.a).get(r1);
        if (r2 == null) goto L4;
        r0.put(r1, new JSONObject(r2));     // Catch: Exception -> L9
    L9:
        r0.put(r1, r2);
        goto L4
    L10:
        return r0;
    }

    public final JsonObject e(JsonArray r9) {
        JsonObject r0 = new JsonObject();
        int r1 = r9.size();
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L20;
        String r5 = r9.get(r3).toString();     // Catch: Exception -> L17
        if (r5.length() <= 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L19;
        if ((!Intrinsics.areEqual(r5, "null")) == false) goto L19;
        String r7 = (String) ((LinkedHashMap) this.a).get(r5);     // Catch: Exception -> L17
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        r0.addProperty(r5, r7);     // Catch: Exception -> L17
    L19:
        r3 = r3 + 1;
        goto L4
    L8:
        r6 = false;
    L17:
        e = move-exception;
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] error getting key at index " + r3 + ": " + e.getMessage());
        goto L19
    L20:
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] getLatestSeiData :" + r0);
        return r0;
    }

    public final void g(Set<String> r9) {
        this.e.addAll(r9);
        JSONObject r1 = d(this.k);
        boolean r2 = true;
    L15:
        e = move-exception;
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] diff compare error: " + e.getMessage());
    L17:
        if (r2 == true) goto L20;
        jy0.b.a("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] diff no change, skip");
        return;
    L20:
        i97.a r3 = i97.a.a;
        long r4 = System.currentTimeMillis();
        long r5 = r4 - this.d;
        if (r5 < 500) goto L26;
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] 时间窗已过/首次，直接发送 changedKeys=" + r9);
        i(r9);
        this.d = r4;
        Disposable r11 = this.c;
        if (r11 == null) goto L25;
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] cancelSeiSendTask sendSeiTask is not null remove");
        this.b.remove(r11);
        this.c = null;
    L25:
        this.e.clear();
        return;
    L26:
        long r6 = 500 - r5;
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] 时间窗未过，延迟" + r6 + "ms发送 changedKeys=" + r9);
        if (this.c != null) goto L37;
        l r12 = l.a;
        int r13 = p.a;
        Disposable r14 = Observable.timer(r6, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        this.c = r14;
        if (r14 == null) goto L31;
        com.bytedance.revenue.platform.api.core.rx.f.a(r14, this.b);
    L31:
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] schedule delayed send in " + r6 + "ms, keys=" + this.e);
        return;
    L37:
        return;
    L4:
        if (this.f != null) goto L7;
    L33:
        goto L17
    L7:
        if (this.g.keySet().size() <= 0) goto L11;
        JSONObject r7 = this.f;     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L15
        if (f(r1, r7, this.g) == false) goto L33;
    L14:
        r2 = false;
        goto L33
    L11:
        JSONObject r8 = this.f;     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L15
        if (f(r1, r8, 1) == true) goto L14;
        goto L14
    }

    public final void i(Set<String> r4) {
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r0 = d(r4);
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] sendKeys keys=" + r4 + " payload=" + r0);
        this.f = d(this.k);
        h r5 = this.j;
        if (r5 == null) goto L9;
        r5.s4(r0);
        return;
    }

    public final void j(String r9) {
        Intrinsics.checkNotNullParameter(r9, "sei");
        JSONObject r1 = new JSONObject(r9);     // Catch: Exception -> L23
        LinkedHashSet r11 = new LinkedHashSet();     // Catch: Exception -> L23
        Iterator<T> r2 = this.k.iterator();     // Catch: Exception -> L23
    L5:
        if (r2.hasNext() == false) goto L16;
        String r3 = (String) r2.next();     // Catch: Exception -> L23
        if (r1.has(r3) == true) goto L9;
        Object r4 = h(r1, r3);     // Catch: Exception -> L23
        if (r4 == null) goto L5;
        this.a.put(r3, r4.toString());     // Catch: Exception -> L23
        jy0.b.a("DynamicCenterScopeService", "[AnchorModeSeiCacheHelper] updateSei cached nested key: " + r3 + "， value:" + r4);     // Catch: Exception -> L23
        r11.add(r3);     // Catch: Exception -> L23
        goto L5
    L9:
        Object r5 = r1.opt(r3);     // Catch: Exception -> L23
        if (r5 == null) goto L5;
        this.a.put(r3, r5.toString());     // Catch: Exception -> L23
        jy0.b.a("DynamicCenterScopeService", "[AnchorModeSeiCacheHelper] updateSei cached with key: " + r3 + "， value:" + r5.toString());     // Catch: Exception -> L23
        r11.add(r3);     // Catch: Exception -> L23
        goto L5
    L16:
        if ((!r11.isEmpty()) == false) goto L37;
        boolean r6 = this.h;     // Catch: Exception -> L23
        if (r6 == false) goto L38;
        if (r6 == false) goto L21;
        g(r11);     // Catch: Exception -> L23
        return;
    L21:
        jy0.b.a("DynamicCenterScopeService", "[AnchorModeSeiCacheHelper] no hasRegisterSei not send");     // Catch: Exception -> L23
        return;
    L38:
        return;
    L37:
        return;
    L23:
        e = move-exception;
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeSeiCacheHelper] Error parsing SEI JSON: " + e.getMessage());
    }

    public static Object h(JSONObject r3, String r4) {
        Iterator<String> r0 = r3.keys();
    L4:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();
        Object r2 = r3.opt(r1);
        if (Intrinsics.areEqual(r1, r4) == true) goto L7;
        if ((r2 instanceof JSONObject) == false) goto L4;
        Object r5 = h((JSONObject) r2, r4);
        if (r5 == null) goto L4;
        return r5;
    L7:
        return r2;
    L13:
        return null;
    }

    @Override // iy.e
    public final void b(my.c r7, k r8) {
        Intrinsics.checkNotNullParameter(r7, "updateStatus");
        Intrinsics.checkNotNullParameter(r8, "updateCallback");
        int r0 = e.a[r7.getType().ordinal()];
        JsonObject r3 = null;
        if (r0 != 1) goto L5;
        JsonObject r9 = r7.b;
        if (r9 == null) goto L42;
        JsonObject r11 = r9.get("diff");
    L44:
        if ((r11 instanceof JsonObject) == false) goto L47;
        r3 = r11;
    L47:
        JsonObject r4 = r3;
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] registerSEI received, diff: " + r4);
        if (r4 == null) goto L54;
        Iterator r12 = CollectionsKt.asSequence(r4.keySet()).iterator();
    L51:
        if (r12.hasNext() == false) goto L53;
        String r1 = (String) r12.next();
        this.g.add(r1, r4.get(r1));
        goto L51
    L53:
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] diffConfig merged: " + this.g);
    L54:
        JsonArray r13 = new JsonArray();
        if (r4 == null) goto L60;
        Iterator r2 = CollectionsKt.asSequence(r4.keySet()).iterator();
    L58:
        if (r2.hasNext() == false) goto L60;
        r13.add((String) r2.next());
    L60:
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] registerSEI diffKeys:" + r13);
        r8.a(1, "", e(r13));
        this.h = true;
        return;
    L42:
        r11 = null;
        goto L44
    L5:
        if (r0 != 2) goto L68;
        JsonObject r14 = r7.b;
        if (r14 == null) goto L12;
        JsonElement r15 = r14.get("method");
        if (r15 == null) goto L12;
        String r16 = r15.getAsString();
    L13:
        if (r16 != null) goto L16;
        return;
    L16:
        if (r16.hashCode() == 1829764357) goto L19;
        return;
    L19:
        if (r16.equals("layoutDidChange") == false) goto L64;
        JsonObject r17 = r7.b;
        if (r17 == null) goto L29;
        JsonElement r18 = r17.get("params");
        if (r18 == null) goto L29;
        JsonObject r19 = r18.getAsJsonObject();
        if (r19 == null) goto L29;
        JsonElement r21 = r19.get("to");
        if (r21 == null) goto L29;
        r3 = r21.getAsJsonObject();
    L29:
        if (r3 == null) goto L33;
        JsonElement r22 = r3.get("uiLayout");
        if (r22 == null) goto L33;
        int r23 = r22.getAsInt();
    L34:
        this.i = Integer.valueOf(r23);
        jy0.b.d("DynamicCenterScopeService", "[AnchorModeLinkSeiHandler] layoutDidChange lastUILayout :" + this.i);
        JsonObject r24 = r7.b;
        if (r24 == null) goto L65;
        h r25 = this.j;
        if (r25 == null) goto L66;
        r25.A4(r24);
        return;
    L66:
        return;
    L65:
        return;
    L33:
        r23 = 0;
        goto L34
    L64:
        return;
    L12:
        r16 = null;
        goto L13
    }

    public static boolean f(Object r7, Object r8, Object r9) {
        if (r9 != null) goto L6;
        return true;
    L6:
        if ((r9 instanceof String) == true) goto L8;
        if (r7 != null) goto L13;
        if (r8 != null) goto L13;
        return true;
    L13:
        if (r7 == null) goto L107;
        if (r8 == null) goto L107;
        if ((!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r7.getClass()), Reflection.getOrCreateKotlinClass(r8.getClass()))) == false) goto L20;
        return false;
    L20:
        if ((r9 instanceof JsonObject) == false) goto L35;
        if ((r7 instanceof JSONObject) == true) goto L24;
    L33:
        return false;
    L24:
        if ((r8 instanceof JSONObject) == false) goto L33;
        JsonObject r11 = (JsonObject) r9;
        Iterator r1 = CollectionsKt.asSequence(r11.keySet()).iterator();
    L28:
        if (r1.hasNext() == false) goto L32;
        String r3 = (String) r1.next();
        if (f(((JSONObject) r7).opt(r3), ((JSONObject) r8).opt(r3), r11.get(r3)) == true) goto L28;
        return false;
    L32:
        return true;
    L35:
        if ((r9 instanceof JsonArray) == false) goto L57;
        if ((r7 instanceof JSONArray) == true) goto L39;
    L55:
        return false;
    L39:
        if ((r8 instanceof JSONArray) == false) goto L55;
        JSONArray r4 = (JSONArray) r7;
        JSONArray r5 = (JSONArray) r8;
        if (r4.length() == r5.length()) goto L44;
        return false;
    L44:
        JsonArray r12 = (JsonArray) r9;
        if (r12.size() == 0) goto L47;
        int r13 = r4.length();
        int r14 = 0;
    L49:
        if (r14 >= r13) goto L54;
        if (f(r4.get(r14), r5.get(r14), r12.get(0)) == false) goto L52;
        r14 = r14 + 1;
        goto L49
    L52:
        return false;
    L54:
        return true;
    L47:
        return f(r7, r8, 1);
    L57:
        if ((r9 instanceof Integer) == true) goto L64;
        if ((r9 instanceof Number) == true) goto L64;
        return Intrinsics.areEqual(r7.toString(), r8.toString());
    L64:
        if ((r7 instanceof JSONObject) == false) goto L89;
        if ((r8 instanceof JSONObject) == false) goto L89;
        JSONObject r15 = (JSONObject) r7;
        Iterator<String> r16 = r15.keys();
        JSONObject r17 = (JSONObject) r8;
        Iterator<String> r6 = r17.keys();
        LinkedHashSet r18 = new LinkedHashSet();
    L69:
        if (r16.hasNext() == false) goto L71;
        r18.add(r16.next());
        goto L69
    L71:
        LinkedHashSet r19 = new LinkedHashSet();
    L73:
        if (r6.hasNext() == false) goto L76;
        r19.add(r6.next());
        goto L73
    L76:
        if (r18.size() == r19.size()) goto L78;
        return false;
    L78:
        Iterator r21 = r18.iterator();
    L80:
        if (r21.hasNext() == false) goto L87;
        String r22 = (String) r21.next();
        if (r19.contains(r22) == false) goto L83;
        if (f(r15.opt(r22), r17.opt(r22), 1) == true) goto L80;
        return false;
    L83:
        return false;
    L87:
        return true;
    L89:
        if ((r7 instanceof JSONArray) == false) goto L106;
        if ((r8 instanceof JSONArray) == false) goto L106;
        JSONArray r23 = (JSONArray) r7;
        JSONArray r24 = (JSONArray) r8;
        if (r23.length() == r24.length()) goto L95;
        return false;
    L95:
        int r25 = r23.length();
        int r26 = 0;
    L96:
        if (r26 >= r25) goto L104;
        if (f(r23.get(r26), r24.get(r26), 1) == false) goto L100;
        r26 = r26 + 1;
        goto L96
    L100:
        return false;
    L102:
        th = move-exception;
        throw th;
    L104:
        return true;
    L106:
        return Intrinsics.areEqual(r7.toString(), r8.toString());
    L107:
        return false;
    L8:
        return f(r7, r8, Integer.valueOf(CastIntegerProtector.parseInt((String) r9)));
    }
}
