package com.larus.video.impl.sdk.prefetch;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.PrefetchVideoProcessStage;
import com.larus.platform.api.w4;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i1 {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static ConcurrentHashMap<String, g> e;
    public static ConcurrentHashMap<String, c> f;
    public static ConcurrentHashMap<String, i> g;
    public static ConcurrentHashMap<String, w4> h;
    public static ConcurrentHashMap<String, a> i;
    public static final Lazy j = null;
    public static final Lazy k = null;

    static {
        a = LazyKt.lazy(new x0());
        b = LazyKt.lazy(new y0());
        c = LazyKt.lazy(new z0());
        d = LazyKt.lazy(new a1());
        j = LazyKt.lazy(new b1());
        k = LazyKt.lazy(new c1());
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

    public static int d() {
        return ((Number) k.getValue()).intValue();
    }

    public static ConcurrentHashMap e() {
        if (g != null) goto L12;
        String r0 = h().getString("user_refresh_count_refine", NameKeys.UnloadStrategy_No_Strategy);
        k r1 = (k) g().fromJson(r0, k.class);     // Catch: Exception -> L9
        if (r1 != null) goto L10;
        r1 = new k(0);     // Catch: Exception -> L9
    L10:
        g = r1.a;
    L9:
        r1 = new k(0);
    L12:
        return g;
    }

    public static Gson g() {
        return (Gson) a.getValue();
    }

    public static Keva h() {
        return (Keva) b.getValue();
    }

    public static int i() {
        return ((Number) j.getValue()).intValue();
    }

    public static ConcurrentHashMap j() {
        if (h != null) goto L12;
        String r0 = h().getString("user_preload_error_reason_refine", NameKeys.UnloadStrategy_No_Strategy);
        f r1 = (f) g().fromJson(r0, f.class);     // Catch: Exception -> L9
        if (r1 != null) goto L10;
        r1 = new f(0);     // Catch: Exception -> L9
    L10:
        h = r1.a;
    L9:
        r1 = new f(0);
    L12:
        return h;
    }

    public static g f(String r1) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
        ConcurrentHashMap r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (g) r0.get(r1);
    }

    public static void k(g r4) {
        Intrinsics.checkNotNullParameter(r4, "cachedPreloadItemIdsData");
        ConcurrentHashMap r0 = a();
        if (r0 == null) goto L5;
        g r1 = (g) r0.put(r4.a, r4);
    L5:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("putCacheVideoData, messageId: ");
        r3.append(r4.a);
        r3.append("===success===currentSize:");
        if (r0 == null) goto L8;
        Integer r5 = Integer.valueOf(r0.size());
    L9:
        r3.append(r5);
        r2.i("InnerVideoListPreloadManager_Cache", r3.toString());
        if (r0 != null) goto L12;
        r0 = new ConcurrentHashMap();
    L12:
        h r6 = new h(r0);
        String r7 = GsonProtectorUtils.toJson(g(), r6, h.class);
        h().storeString("preload_item_ids_refine", r7);
        return;
    L8:
        r5 = null;
        goto L9
    }

    public static void l(ConcurrentHashMap r2) {
        if (r2 != null) goto L5;
        r2 = new ConcurrentHashMap();
    L5:
        k r0 = new k(r2);
        String r3 = GsonProtectorUtils.toJson(g(), r0, k.class);
        h().storeString("user_refresh_count_refine", r3);
    }

    public static void m(ConcurrentHashMap r12) {
        if (r12 != null) goto L5;
        ConcurrentHashMap r1 = new ConcurrentHashMap();
    L6:
        h r0 = new h(r1);
        String r2 = GsonProtectorUtils.toJson(g(), r0, h.class);
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("saveCachedPreloadItemIdsDataMap, kyes: ");
        if (r12 == null) goto L11;
        Set r13 = r12.keySet();
        if (r13 == null) goto L11;
        String r14 = CollectionsKt.joinToString$default(r13, null, null, null, 0, null, null, 63, null);
    L12:
        r4.append(r14);
        r3.i("InnerVideoListPreloadManager_Cache", r4.toString());
        h().storeString("preload_item_ids_refine", r2);
        return;
    L11:
        r14 = null;
        goto L12
    L5:
        r1 = r12;
        goto L6
    }

    public static void n(ConcurrentHashMap r2) {
        b r0 = new b(r2);
        String r3 = GsonProtectorUtils.toJson(g(), r0, b.class);
        h().storeString("user_first_bind_preload_refine", r3);
    }

    public static void o(ConcurrentHashMap r2) {
        if (r2 != null) goto L5;
        r2 = new ConcurrentHashMap();
    L5:
        j r0 = new j(r2);
        String r3 = GsonProtectorUtils.toJson(g(), r0, j.class);
        h().storeString("user_is_first_click_message_video_refine", r3);
    }

    public static void p(ConcurrentHashMap r2) {
        if (r2 != null) goto L5;
        r2 = new ConcurrentHashMap();
    L5:
        f r0 = new f(r2);
        String r3 = GsonProtectorUtils.toJson(g(), r0, f.class);
        h().storeString("user_preload_error_reason_refine", r3);
    }

    public static void r(String r13) {
        FLogger.a.i("InnerVideoListPreloadManager_Cache", "tryClearAllCache, lastMessageId: " + r13);
        ConcurrentHashMap<String, g> r0 = a();
        ConcurrentHashMap<String, g> r1 = null;
        boolean r3 = true;
        if (r0 == null) goto L14;
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<Map.Entry<String, g>> r6 = r0.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L13;
        Map.Entry<String, g> r7 = r6.next();
        if (Math.abs(AppHost.a.getAppClock().currentTimeMillis() - r7.getValue().d) <= ((Number) d.getValue()).intValue()) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == false) goto L6;
        r5.put(r7.getKey(), r7.getValue());
        goto L6
    L10:
        r8 = false;
        goto L11
    L13:
        Set r9 = r5.keySet();
    L15:
        if (r9 != null) goto L17;
        Set r10 = SetsKt.emptySet();
    L19:
        if (r10.isEmpty() == true) goto L28;
        ConcurrentHashMap r11 = j();
        Iterator r12 = r10.iterator();
    L23:
        if (r12.hasNext() == false) goto L27;
        String r14 = (String) r12.next();
        if (r11 == null) goto L23;
        r11.put(r14, new w4(PrefetchVideoProcessStage.EXPIRATION_PROCESS.getValue(), AppHost.a.getAppClock().currentTimeMillis(), 0));
        goto L23
    L27:
        p(r11);
    L28:
        if (r9 == null) goto L35;
        Iterator r15 = r9.iterator();
        boolean r16 = false;
    L31:
        if (r15.hasNext() == false) goto L36;
        String r17 = (String) r15.next();
        if (Intrinsics.areEqual(r17, r13) == false) goto L31;
        r0.remove(r17);
        FLogger.a.i("InnerVideoListPreloadManager_Cache", "clearExpireCache, remove key: " + r17);
        r16 = true;
    L36:
        if (r16 == false) goto L38;
        e = r0;
        m(r0);
    L38:
        ConcurrentHashMap r18 = c();
        if (r18 == null) goto L41;
        int r2 = r18.size();
    L43:
        if (r2 <= i()) goto L64;
        if (r18 != null) goto L46;
    L49:
        boolean r4 = true;
    L50:
        if (r4 == false) goto L52;
        ConcurrentHashMap r19 = null;
    L62:
        if (r19 == null) goto L64;
        o(r19);
        goto L64
    L52:
        List r110 = CollectionsKt.sortedWith(r18.entrySet(), new f1());
        List r20 = CollectionsKt.take(r110, d());
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = r20.iterator();
    L54:
        if (r22.hasNext() == false) goto L56;
        r21.add((String) ((Map.Entry) r22.next()).getKey());
        goto L54
    L56:
        Set r23 = CollectionsKt.toSet(r21);
        r19 = new ConcurrentHashMap();
        Iterator r111 = r110.iterator();
    L58:
        if (r111.hasNext() == false) goto L62;
        Map.Entry r24 = (Map.Entry) r111.next();
        if (r23.contains(r24.getKey()) == false) goto L58;
        r19.put(r24.getKey(), r24.getValue());
        goto L58
    L46:
        if (r18.isEmpty() == true) goto L49;
        r4 = false;
    L64:
        ConcurrentHashMap r112 = e();
        if (r112 == null) goto L67;
        int r25 = r112.size();
    L69:
        if (r25 <= i()) goto L90;
        if (r112 != null) goto L72;
    L75:
        boolean r26 = true;
    L76:
        if (r26 == false) goto L78;
        ConcurrentHashMap r27 = null;
    L88:
        if (r27 == null) goto L90;
        l(r27);
        goto L90
    L78:
        List r113 = CollectionsKt.sortedWith(r112.entrySet(), new h1());
        List r28 = CollectionsKt.take(r113, d());
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r30 = r28.iterator();
    L80:
        if (r30.hasNext() == false) goto L82;
        r29.add((String) ((Map.Entry) r30.next()).getKey());
        goto L80
    L82:
        Set r31 = CollectionsKt.toSet(r29);
        r27 = new ConcurrentHashMap();
        Iterator r114 = r113.iterator();
    L84:
        if (r114.hasNext() == false) goto L88;
        Map.Entry r32 = (Map.Entry) r114.next();
        if (r31.contains(r32.getKey()) == false) goto L84;
        r27.put(r32.getKey(), r32.getValue());
        goto L84
    L72:
        if (r112.isEmpty() == true) goto L75;
        r26 = false;
    L90:
        ConcurrentHashMap r115 = j();
        if (r115 == null) goto L93;
        int r33 = r115.size();
    L95:
        if (r33 <= i()) goto L116;
        if (r115 != null) goto L98;
    L101:
        boolean r34 = true;
    L102:
        if (r34 == false) goto L104;
        ConcurrentHashMap r35 = null;
    L114:
        if (r35 == null) goto L116;
        p(r35);
        goto L116
    L104:
        List r116 = CollectionsKt.sortedWith(r115.entrySet(), new g1());
        List r36 = CollectionsKt.take(r116, d());
        ArrayList r37 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10));
        Iterator r38 = r36.iterator();
    L106:
        if (r38.hasNext() == false) goto L108;
        r37.add((String) ((Map.Entry) r38.next()).getKey());
        goto L106
    L108:
        Set r39 = CollectionsKt.toSet(r37);
        r35 = new ConcurrentHashMap();
        Iterator r117 = r116.iterator();
    L110:
        if (r117.hasNext() == false) goto L114;
        Map.Entry r40 = (Map.Entry) r117.next();
        if (r39.contains(r40.getKey()) == false) goto L110;
        r35.put(r40.getKey(), r40.getValue());
        goto L110
    L98:
        if (r115.isEmpty() == true) goto L101;
        r34 = false;
    L116:
        ConcurrentHashMap r118 = b();
        if (r118 == null) goto L119;
        int r41 = r118.size();
    L121:
        if (r41 <= i()) goto L142;
        if (r118 != null) goto L124;
    L127:
        boolean r42 = true;
    L128:
        if (r42 == false) goto L130;
        ConcurrentHashMap r43 = null;
    L140:
        if (r43 == null) goto L142;
        n(r43);
        goto L142
    L130:
        List r44 = CollectionsKt.take(CollectionsKt.sortedWith(r118.entrySet(), new e1()), d());
        ArrayList r45 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r44, 10));
        Iterator r46 = r44.iterator();
    L132:
        if (r46.hasNext() == false) goto L134;
        r45.add((String) ((Map.Entry) r46.next()).getKey());
        goto L132
    L134:
        r43 = new ConcurrentHashMap();
        Iterator r119 = r118.entrySet().iterator();
    L136:
        if (r119.hasNext() == false) goto L140;
        Map.Entry r47 = (Map.Entry) r119.next();
        String r48 = (String) r47.getKey();
        a r49 = (a) r47.getValue();
        if (r45.contains(r48) == false) goto L136;
        r43.put(r48, r49);
        goto L136
    L124:
        if (r118.isEmpty() == true) goto L127;
        r42 = false;
    L142:
        ConcurrentHashMap r120 = a();
        FLogger r50 = FLogger.a;
        StringBuilder r51 = new StringBuilder("clearExceedMaxSaveItemCountCache, map.size: ");
        if (r120 == null) goto L145;
        Integer r52 = Integer.valueOf(r120.size());
    L146:
        r51.append(r52);
        r51.append("===MAX_SAVE_ITEM_COUNT:");
        r51.append(i());
        r50.i("InnerVideoListPreloadManager_Cache", r51.toString());
        if (r120 == null) goto L149;
        int r53 = r120.size();
    L151:
        if (r53 <= i()) goto L217;
        if (r120 != null) goto L154;
    L157:
        if (r3 == true) goto L170;
        List r54 = CollectionsKt.take(CollectionsKt.sortedWith(r120.entrySet(), new d1()), d());
        ArrayList r55 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r54, 10));
        Iterator r56 = r54.iterator();
    L161:
        if (r56.hasNext() == false) goto L163;
        r55.add((String) ((Map.Entry) r56.next()).getKey());
        goto L161
    L163:
        FLogger.a.i("InnerVideoListPreloadManager_Cache", "trimCachedPreloadItemIdsDataMap, reserve keys: " + r55);
        ConcurrentHashMap<String, g> r57 = new ConcurrentHashMap();
        Iterator r121 = r120.entrySet().iterator();
    L165:
        if (r121.hasNext() == false) goto L169;
        Map.Entry r58 = (Map.Entry) r121.next();
        String r59 = (String) r58.getKey();
        g r60 = (g) r58.getValue();
        if (r55.contains(r59) == false) goto L165;
        r57.put(r59, r60);
        goto L165
    L169:
        r1 = r57;
    L170:
        e = r1;
        m(r1);
        return;
    L154:
        if (r120.isEmpty() == true) goto L157;
        r3 = false;
        goto L157
    L217:
        return;
    L149:
        r53 = 0;
        goto L151
    L145:
        r52 = null;
        goto L146
    L119:
        r41 = 0;
        goto L121
    L93:
        r33 = 0;
        goto L95
    L67:
        r25 = 0;
        goto L69
    L41:
        r2 = 0;
        goto L43
    L35:
        r16 = false;
        goto L36
    L17:
        r10 = r9;
        goto L19
    L14:
        r9 = null;
        goto L15
    }

    public static void q(String r1, w4 r2) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Intrinsics.checkNotNullParameter(r2, "reason");
        ConcurrentHashMap r0 = j();
        if (r0 == null) goto L5;
        w4 r3 = (w4) r0.put(r1, r2);
    L5:
        if (r0 == null) goto L8;
        p(r0);
        return;
    }
}
