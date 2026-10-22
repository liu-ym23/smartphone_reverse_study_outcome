package com.larus.video.impl.sdk.prefetch;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.platform.api.w4;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w0 {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static ConcurrentHashMap<String, g> e;
    public static ConcurrentHashMap<String, c> f;
    public static ConcurrentHashMap<String, w4> g;
    public static ConcurrentHashMap<String, g> h;
    public static ConcurrentHashMap<String, a> i;
    public static ConcurrentHashMap<String, d> j;
    public static final Lazy k = null;
    public static final Lazy l = null;

    static {
        a = LazyKt.lazy(new m0());
        b = LazyKt.lazy(new n0());
        c = LazyKt.lazy(new o0());
        d = LazyKt.lazy(new p0());
        k = LazyKt.lazy(new q0());
        l = LazyKt.lazy(new r0());
    }

    public static ConcurrentHashMap a() {
        if (e != null) goto L12;
        String r0 = h().getString("preload_item_ids_refine", NameKeys.UnloadStrategy_No_Strategy);
        h r1 = (h) g().fromJson(r0, h.class);     // Catch: Exception -> L9
        if (r1 != null) goto L10;
        r1 = new h(0);     // Catch: Exception -> L9
    L10:
        e = r1.a;
    L9:
        r1 = new h(0);
    L12:
        return e;
    }

    public static ConcurrentHashMap b() {
        if (i != null) goto L12;
        String r0 = h().getString("user_first_bind_preload_refine", NameKeys.UnloadStrategy_No_Strategy);
        b r1 = (b) g().fromJson(r0, b.class);     // Catch: Exception -> L9
        if (r1 != null) goto L10;
        r1 = new b(0);     // Catch: Exception -> L9
    L10:
        i = r1.a;
    L9:
        r1 = new b(0);
    L12:
        return i;
    }

    public static ConcurrentHashMap c() {
        if (j != null) goto L12;
        String r0 = h().getString("user_first_screen_data_refine", NameKeys.UnloadStrategy_No_Strategy);
        e r1 = (e) g().fromJson(r0, e.class);     // Catch: Exception -> L9
        if (r1 != null) goto L10;
        r1 = new e(0);     // Catch: Exception -> L9
    L10:
        j = r1.a;
    L9:
        r1 = new e(0);
    L12:
        return j;
    }

    public static ConcurrentHashMap d() {
        if (f != null) goto L12;
        String r0 = h().getString("user_is_first_click_message_video_refine", NameKeys.UnloadStrategy_No_Strategy);
        j r1 = (j) g().fromJson(r0, j.class);     // Catch: Exception -> L9
        if (r1 != null) goto L10;
        r1 = new j(0);     // Catch: Exception -> L9
    L10:
        f = r1.a;
    L9:
        r1 = new j(0);
    L12:
        return f;
    }

    public static int e() {
        return ((Number) l.getValue()).intValue();
    }

    public static Gson g() {
        return (Gson) a.getValue();
    }

    public static Keva h() {
        return (Keva) b.getValue();
    }

    public static int i() {
        return ((Number) k.getValue()).intValue();
    }

    public static ConcurrentHashMap j() {
        if (g != null) goto L12;
        String r0 = h().getString("user_preload_error_reason_refine", NameKeys.UnloadStrategy_No_Strategy);
        f r1 = (f) g().fromJson(r0, f.class);     // Catch: Exception -> L9
        if (r1 != null) goto L10;
        r1 = new f(0);     // Catch: Exception -> L9
    L10:
        g = r1.a;
    L9:
        r1 = new f(0);
    L12:
        return g;
    }

    public static void p() {
        ConcurrentHashMap r0 = d();
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        String r5 = null;
        if (r2 <= i()) goto L28;
        if (r0 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        ConcurrentHashMap r4 = null;
    L26:
        if (r4 == null) goto L28;
        m(r4);
        goto L28
    L16:
        List r6 = CollectionsKt.sortedWith(r0.entrySet(), new u0());
        List r7 = CollectionsKt.take(r6, e());
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L18:
        if (r9.hasNext() == false) goto L20;
        r8.add((String) ((Map.Entry) r9.next()).getKey());
        goto L18
    L20:
        Set r10 = CollectionsKt.toSet(r8);
        r4 = new ConcurrentHashMap();
        Iterator r11 = r6.iterator();
    L22:
        if (r11.hasNext() == false) goto L26;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (r10.contains(r12.getKey()) == false) goto L22;
        r4.put(r12.getKey(), r12.getValue());
        goto L22
    L10:
        if (r0.isEmpty() == true) goto L13;
        r3 = false;
    L28:
        ConcurrentHashMap r13 = j();
        if (r13 == null) goto L31;
        int r14 = r13.size();
    L33:
        if (r14 <= i()) goto L54;
        if (r13 != null) goto L36;
    L39:
        boolean r15 = true;
    L40:
        if (r15 == false) goto L42;
        ConcurrentHashMap r16 = null;
    L52:
        if (r16 == null) goto L54;
        n(r16);
        goto L54
    L42:
        List r17 = CollectionsKt.sortedWith(r13.entrySet(), new v0());
        List r18 = CollectionsKt.take(r17, e());
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r20 = r18.iterator();
    L44:
        if (r20.hasNext() == false) goto L46;
        r19.add((String) ((Map.Entry) r20.next()).getKey());
        goto L44
    L46:
        Set r21 = CollectionsKt.toSet(r19);
        r16 = new ConcurrentHashMap();
        Iterator r22 = r17.iterator();
    L48:
        if (r22.hasNext() == false) goto L52;
        Map.Entry r23 = (Map.Entry) r22.next();
        if (r21.contains(r23.getKey()) == false) goto L48;
        r16.put(r23.getKey(), r23.getValue());
        goto L48
    L36:
        if (r13.isEmpty() == true) goto L39;
        r15 = false;
    L54:
        ConcurrentHashMap r24 = b();
        if (r24 == null) goto L57;
        int r25 = r24.size();
    L59:
        if (r25 <= i()) goto L80;
        if (r24 != null) goto L62;
    L65:
        boolean r26 = true;
    L66:
        if (r26 == false) goto L68;
        ConcurrentHashMap r27 = null;
    L78:
        if (r27 == null) goto L80;
        l(r27);
        goto L80
    L68:
        List r28 = CollectionsKt.take(CollectionsKt.sortedWith(r24.entrySet(), new t0()), e());
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r30 = r28.iterator();
    L70:
        if (r30.hasNext() == false) goto L72;
        r29.add((String) ((Map.Entry) r30.next()).getKey());
        goto L70
    L72:
        r27 = new ConcurrentHashMap();
        Iterator r31 = r24.entrySet().iterator();
    L74:
        if (r31.hasNext() == false) goto L78;
        Map.Entry r32 = (Map.Entry) r31.next();
        String r33 = (String) r32.getKey();
        a r34 = (a) r32.getValue();
        if (r29.contains(r33) == false) goto L74;
        r27.put(r33, r34);
        goto L74
    L62:
        if (r24.isEmpty() == true) goto L65;
        r26 = false;
    L80:
        FLogger r35 = FLogger.a;
        r35.i("RelatedVideoFlowCacheItemsListManager_Cache", "tryClearAllCache, clearExceedMaxSaveItemCountCache");
        ConcurrentHashMap r36 = a();
        StringBuilder r37 = new StringBuilder("clearExceedMaxSaveItemCountCache, map.size: ");
        if (r36 == null) goto L83;
        Integer r38 = Integer.valueOf(r36.size());
    L84:
        r37.append(r38);
        r37.append("===MAX_SAVE_ITEM_COUNT:");
        r37.append(i());
        r35.i("RelatedVideoFlowCacheItemsListManager_Cache", r37.toString());
        if (r36 == null) goto L87;
        int r39 = r36.size();
    L89:
        if (r39 <= i()) goto L141;
        if (r36 != null) goto L92;
    L93:
        r1 = true;
    L94:
        if (r1 == false) goto L96;
        ConcurrentHashMap<String, g> r40 = null;
    L106:
        e = r40;
        if (r40 != null) goto L109;
        ConcurrentHashMap<String, g> r41 = new ConcurrentHashMap();
    L110:
        String r42 = GsonProtectorUtils.toJson(g(), new h(r41), h.class);
        FLogger r43 = FLogger.a;
        StringBuilder r44 = new StringBuilder("saveCachedPreloadItemIdsDataMap, kyes: ");
        if (r40 == null) goto L115;
        Set<String> r45 = r40.keySet();
        if (r45 == null) goto L115;
        r5 = CollectionsKt.joinToString$default(r45, null, null, null, 0, null, null, 63, null);
    L115:
        r44.append(r5);
        r43.i("RelatedVideoFlowCacheItemsListManager_Cache", r44.toString());
        h().storeString("preload_item_ids_refine", r42);
        return;
    L109:
        r41 = r40;
        goto L110
    L96:
        List r46 = CollectionsKt.take(CollectionsKt.sortedWith(r36.entrySet(), new s0()), e());
        ArrayList r47 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r46, 10));
        Iterator r48 = r46.iterator();
    L98:
        if (r48.hasNext() == false) goto L100;
        r47.add((String) ((Map.Entry) r48.next()).getKey());
        goto L98
    L100:
        FLogger.a.i("RelatedVideoFlowCacheItemsListManager_Cache", "trimCachedPreloadItemIdsDataMap, reserve keys: " + r47);
        r40 = new ConcurrentHashMap();
        Iterator r49 = r36.entrySet().iterator();
    L102:
        if (r49.hasNext() == false) goto L106;
        Map.Entry r50 = (Map.Entry) r49.next();
        String r51 = (String) r50.getKey();
        g r52 = (g) r50.getValue();
        if (r47.contains(r51) == false) goto L102;
        r40.put(r51, r52);
        goto L102
    L92:
        if (r36.isEmpty() == false) goto L94;
    L141:
        return;
    L87:
        r39 = 0;
        goto L89
    L83:
        r38 = null;
        goto L84
    L57:
        r25 = 0;
        goto L59
    L31:
        r14 = 0;
        goto L33
    L5:
        r2 = 0;
        goto L6
    }

    public static void k(g r3) {
        Intrinsics.checkNotNullParameter(r3, "cachedPreloadItemIdsData");
        ConcurrentHashMap r0 = a();
        if (r0 == null) goto L6;
        g r4 = (g) r0.put(f(r3.a, r3.g), r3);
    L6:
        if (r0 != null) goto L8;
        r0 = new ConcurrentHashMap();
    L8:
        h r5 = new h(r0);
        String r6 = GsonProtectorUtils.toJson(g(), r5, h.class);
        h().storeString("preload_item_ids_refine", r6);
    }

    public static void l(ConcurrentHashMap r2) {
        b r0 = new b(r2);
        String r3 = GsonProtectorUtils.toJson(g(), r0, b.class);
        h().storeString("user_first_bind_preload_refine", r3);
    }

    public static void m(ConcurrentHashMap r2) {
        if (r2 != null) goto L5;
        r2 = new ConcurrentHashMap();
    L5:
        j r0 = new j(r2);
        String r3 = GsonProtectorUtils.toJson(g(), r0, j.class);
        h().storeString("user_is_first_click_message_video_refine", r3);
    }

    public static void n(ConcurrentHashMap r2) {
        f r0 = new f(r2);
        String r3 = GsonProtectorUtils.toJson(g(), r0, f.class);
        h().storeString("user_preload_error_reason_refine", r3);
    }

    public static String f(String r1, Integer r2) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
        StringBuilder r0 = new StringBuilder();
        r0.append(r1);
        r0.append('_');
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L6:
        r0.append(r3);
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }

    public static void o(String r1, w4 r2) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Intrinsics.checkNotNullParameter(r2, "reason");
        ConcurrentHashMap r0 = j();
        if (r0 == null) goto L5;
        w4 r3 = (w4) r0.put(r1, r2);
    L5:
        if (r0 == null) goto L8;
        n(r0);
        return;
    }
}
