package com.bytedance.gkfs.storage;

import ai.j0;
import com.bytedance.gkfs.UtilsKt$traceTime$1$1;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f4934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f4935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.gkfs.d f4936c;

    public h(com.bytedance.gkfs.d r5) {
        this.f4936c = r5;
        this.f4934a = LazyKt.lazy(GkFSCombinedChunkIndexing$chunkIndexingRepo$2.f4912a);
        this.f4935b = new LinkedHashMap();
    }

    public static JSONObject i(b r5) {
        JSONObject r10 = new JSONObject();
        r10.put("block_id", r5.f4917c.f4853a);
        r10.put("reference", new JSONArray(r5.d));
        return r10;
    }

    public final b a(com.bytedance.gkfs.io.c r10) {
        UtilsKt$traceTime$1$1 r5 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        Object r11 = null;
        String r12 = c().getStringJustDisk(r10.f4858a, null);
        if (r12 != null) goto L5;
    L28:
        return null;
    L5:
        if (r12.length() > 0) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L28;
        JSONObject r13 = new JSONObject(r12);
        long r14 = ((Number) r5.invoke()).longValue();
        com.bytedance.gkfs.io.a r15 = new com.bytedance.gkfs.io.a(r13.getInt("block_id"));
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L13
        JSONArray r17 = r13.getJSONArray("reference");     // Catch: Throwable -> L13
        int r18 = r17.length();     // Catch: Throwable -> L13
        String[] r19 = new String[r18];     // Catch: Throwable -> L13
        int r20 = 0;
    L11:
        if (r20 >= r18) goto L15;
        r19[r20] = r17.getString(r20);     // Catch: Throwable -> L13
        r20 = r20 + 1;     // Catch: Throwable -> L13
        goto L11
    L15:
        Object r21 = Result.m124constructorimpl(r19);     // Catch: Throwable -> L13
    L19:
        if (Result.m130isFailureimpl(r21) == true) goto L22;
        r11 = r21;
    L22:
        String[] r22 = (String[]) r11;
        if (r22 == null) goto L25;
        String[] r23 = r22;
    L27:
        return new b(r10, r15, r23, r14);
    L25:
        r23 = new String[0];
    L13:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r21 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public final b b(com.bytedance.gkfs.io.c r13, File r14) {
        UtilsKt$traceTime$1$1 r5 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        b r10 = a(r13);
        if (r10 == null) goto L25;
        String r15 = r14.getAbsolutePath();
        Set r11 = ArraysKt.toMutableSet(r10.d);
        boolean r12 = r11.remove(r15);
        com.bytedance.gkfs.d r16 = this.f4936c;
        if (r12 == false) goto L7;
        com.bytedance.gkfs.d.c(r16, "ChunkIndexing", "Remove reference " + r15 + " from chunk " + r13, 0, 12);
    L7:
        boolean r17 = r11.isEmpty();
        String r18 = r13.f4858a;
        if (r17 == false) goto L10;
        c().erase(r18);
        com.bytedance.gkfs.d.c(r16, "ChunkIndexing", "Remove chunk " + r13 + " indexing info cause no references", 0, 12);
    L13:
        f(r13, r10.f4917c);
        UtilsKt$traceTime$1$1 r19 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        b r20 = a(r13);
        if (r20 == null) goto L18;
        a r21 = h(r13, r20.f4917c);
        if (r21 == null) goto L18;
        b r22 = b.a(r20, r13, null, r21, ((Number) r19.invoke()).longValue(), 6);
    L19:
        if (r22 != null) goto L21;
        return null;
    L21:
        return b.a(r22, null, null, null, ((Number) r5.invoke()).longValue(), 15);
    L18:
        r22 = null;
        goto L19
    L10:
        Keva r110 = c();
        Object[] r23 = r11.toArray(new String[0]);
        if (r23 == null) goto L24;
        r110.storeStringJustDisk(r18, i(b.a(r10, null, (String[]) r23, null, 0, 27)).toString());
        goto L13
    L24:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L25:
        return null;
    }

    public final Keva c() {
        return (Keva) this.f4934a.getValue();
    }

    public final Keva d(com.bytedance.gkfs.io.a r5) {
        LinkedHashMap r10 = this.f4935b;
        Keva r11 = (Keva) r10.get(r5);
        if (r11 == null) goto L5;
        return r11;
    L5:
        Keva r12 = Keva.getRepo("gkfs_block_indexing_" + r5.f4853a, 1);
        r10.put(r5, r12);
        return r12;
    }

    public final Map e(com.bytedance.gkfs.io.a[] r25) {
        h this = this;
        LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r25.length), 16));
        int r10 = r25.length;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        Pair r13 = TuplesKt.to(r25[r12], new LinkedHashMap());
        r5.put(r13.getFirst(), r13.getSecond());
        r12 = r12 + 1;
        goto L3
    L5:
        Map r14 = MapsKt.toMutableMap(r5);
        Keva r15 = c();
        r15.count();
        Iterator r16 = r15.buildNewMap(KevaConstants.FLAG_CURRENT_KEY_MAP).keySet().iterator();
    L7:
        if (r16.hasNext() == false) goto L59;
        String r17 = (String) r16.next();
        com.bytedance.gkfs.io.c r18 = new com.bytedance.gkfs.io.c(r17);
        b r19 = this.a(r18);
        if (r19 == null) goto L10;
        String[] r20 = r19.d;
        Set r110 = ArraysKt.toSet(r20);
        ArrayList r111 = new ArrayList();
        Iterator r112 = r110.iterator();
    L13:
        if (r112.hasNext() == false) goto L17;
        Object r113 = r112.next();
        if (new File((String) r113).exists() == false) goto L13;
        r111.add(r113);
        goto L13
    L17:
        List r114 = CollectionsKt.toMutableList(r111);
        a r115 = this.h(r18, r19.f4917c);
        UtilsKt$traceTime$1$1 r116 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        if (r115 != null) goto L20;
    L21:
        List r117 = r114;
        b r21 = r19;
        com.bytedance.gkfs.d.d(this.f4936c, "ChunkIndexing", j0.q(new StringBuilder("can not find block relative data(info or file) for chunk "), r18.f4858a, " when tidyUp"), null, false, 28);
        c().erase(r18.f4858a);
        this.f(r18, r21.f4917c);
        Iterator r22 = r117.iterator();
    L35:
        if (r22.hasNext() == false) goto L37;
        String r23 = (String) r22.next();
        new File(r23).delete();
        com.bytedance.gkfs.d.f(this.f4936c, "ChunkIndexing", j0.q(com.lynx.tasm.utils.e.b("delete ", r23, " cause chunk "), r18.f4858a, " stale"), 0, 28);
        goto L35
    L37:
        r117.clear();
        long r24 = ((Number) r116.invoke()).longValue();
    L38:
        Map r26 = (Map) r14.get(r21.f4917c);
        if (r26 != null) goto L42;
        r26 = new LinkedHashMap();
        r14.put(r21.f4917c, r26);
        Unit r27 = Unit.INSTANCE;
    L42:
        String[] r118 = new String[0];
        if (r115 == null) goto L45;
        a r119 = r115;
    L46:
        Long r28 = Long.valueOf(r24);
        if (r24 != Long.MIN_VALUE) goto L50;
        r28 = null;
    L50:
        if (r28 == null) goto L53;
        long r29 = r28.longValue();
    L54:
        b r30 = b.a(r21, null, r118, r119, r29, 3);
        if (r24 == Long.MIN_VALUE) goto L57;
        boolean r31 = true;
    L58:
        r26.put(r18, new c(r30, r31, r117.isEmpty()));
        Unit r32 = Unit.INSTANCE;
        goto L7
    L57:
        r31 = false;
        goto L58
    L53:
        r29 = 0;
        goto L54
    L45:
        r119 = new a();
        goto L46
    L20:
        if (ArraysKt.contains(r25, r19.f4917c) == false) goto L21;
        if (r114.isEmpty() == false) goto L26;
        c().erase(r18.f4858a);
        this.f(r18, r19.f4917c);
        r24 = ((Number) r116.invoke()).longValue();
        r117 = r114;
        r21 = r19;
        goto L38
    L26:
        if (r114.size() == r20.length) goto L32;
        Keva r120 = c();
        Object[] r33 = r114.toArray(new String[0]);
        if (r33 == null) goto L31;
        r117 = r114;
        r21 = r19;
        r120.storeStringJustDisk(r17, i(b.a(r19, null, (String[]) r33, null, 0, 27)).toString());
        r24 = ((Number) r116.invoke()).longValue();
        goto L38
    L31:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L32:
        r117 = r114;
        r21 = r19;
        r24 = Long.MIN_VALUE;
        goto L38
    L10:
        c().erase(r17);
        goto L7
    L59:
        int r34 = r25.length;
        int r35 = 0;
    L60:
        if (r35 >= r34) goto L80;
        com.bytedance.gkfs.io.a r121 = r25[r35];
        Keva r36 = this.d(r121);
        r36.count();
        Iterator r122 = r36.buildNewMap(KevaConstants.FLAG_CURRENT_KEY_MAP).keySet().iterator();
    L63:
        if (r122.hasNext() == false) goto L79;
        com.bytedance.gkfs.io.c r123 = new com.bytedance.gkfs.io.c((String) r122.next());
        Map r37 = (Map) r14.get(r121);
        if (r37 == null) goto L67;
        c r38 = (c) r37.get(r123);
    L68:
        if (r38 != null) goto L63;
        a r39 = this.h(r123, r121);
        this.f(r123, r121);
        Map r40 = (Map) r14.get(r121);
        if (r40 == null) goto L72;
    L71:
        Map r124 = r40;
        String[] r41 = new String[r11];
        if (r39 != null) goto L77;
        r39 = new a();
    L77:
        r124.put(r123, new c(new b(r123, r121, r41, r39, 0), true, true));
        r11 = 0;
        goto L63
    L72:
        r40 = new LinkedHashMap();
        r14.put(r121, r40);
        Unit r42 = Unit.INSTANCE;
        goto L71
    L67:
        r38 = null;
        goto L68
    L79:
        r35 = r35 + 1;
        this = this;
        r11 = 0;
        goto L60
    L80:
        return r14;
    }

    public final void f(com.bytedance.gkfs.io.c r5, com.bytedance.gkfs.io.a r10) {
        d(r10).erase(r5.f4858a);
    }

    public final void g(com.bytedance.gkfs.io.c r10, com.bytedance.gkfs.io.a r11, a r12) {
        Keva r5 = d(r11);
        String r13 = r10.f4858a;
        JSONObject r14 = new JSONObject();
        r14.put("offset", r12.f4913a);
        r14.put("size", r12.f4914b);
        r5.storeStringJustDisk(r13, r14.toString());
        a r15 = h(r10, r11);
        if (r15 != null) goto L5;
    L10:
        StringBuilder r16 = new StringBuilder("can not insert or cover block indexing of [");
        r16.append(r10.f4858a);
        r16.append(" : ");
        throw new IOException(j0.n(r16, r11.f4853a, ']'));
    L5:
        if (Intrinsics.areEqual(r15, r12) == true) goto L8;
        r15 = null;
    L8:
        if (r15 == null) goto L10;
    }

    public final a h(com.bytedance.gkfs.io.c r5, com.bytedance.gkfs.io.a r10) {
        String r11 = d(r10).getStringJustDisk(r5.f4858a, null);
        if (r11 != null) goto L5;
    L11:
        return null;
    L5:
        if (r11.length() > 0) goto L8;
        r11 = null;
    L8:
        if (r11 == null) goto L11;
        JSONObject r12 = new JSONObject(r11);
        return new a(r12.getInt("size"), r12.getLong("offset"));
    }
}
