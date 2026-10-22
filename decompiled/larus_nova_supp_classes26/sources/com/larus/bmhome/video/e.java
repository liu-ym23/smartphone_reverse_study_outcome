package com.larus.bmhome.video;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final Map<String, CopyOnWriteArrayList<g>> a = null;
    public static final Map<String, CopyOnWriteArrayList<String>> b = null;
    public static final Map<String, CopyOnWriteArraySet<String>> c = null;
    public static final CopyOnWriteArraySet<String> d = null;

    static {
        a = new LinkedHashMap();
        b = new LinkedHashMap();
        c = new LinkedHashMap();
        d = new CopyOnWriteArraySet();
    }

    public static void d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        Map<String, CopyOnWriteArrayList<g>> r0 = a;
        CopyOnWriteArrayList r1 = (CopyOnWriteArrayList) ((LinkedHashMap) r0).get(r10);
        if (r1 == null) goto L5;
        r1.clear();
    L5:
        r0.remove(r10);
        Map<String, CopyOnWriteArrayList<String>> r2 = b;
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) ((LinkedHashMap) r2).get(r10);
        if (r3 == null) goto L8;
        r3.clear();
    L8:
        r2.remove(r10);
        d.clear();
        CopyOnWriteArraySet r4 = (CopyOnWriteArraySet) ((LinkedHashMap) c).get(r10);
        if (r4 == null) goto L11;
        r4.clear();
    L11:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("clear cache of ");
        r6.append(r10);
        r6.append(", ");
        StringBuilder r7 = new StringBuilder("mobParamsCache: [");
        Iterator r8 = ((LinkedHashMap) r0).keySet().iterator();
        int r9 = 0;
        int r11 = 0;
    L12:
        Integer r12 = null;
        if (r8.hasNext() == false) goto L24;
        Object r13 = r8.next();
        int r14 = r11 + 1;
        if (r11 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        String r15 = (String) r13;
        if (r11 == 0) goto L20;
        r7.append(", ");
    L20:
        r7.append(r15);
        r7.append(": size-");
        CopyOnWriteArrayList r16 = (CopyOnWriteArrayList) ((LinkedHashMap) a).get(r15);
        if (r16 == null) goto L23;
        r12 = Integer.valueOf(r16.size());
    L23:
        r7.append(r12);
        r11 = r14;
        goto L12
    L24:
        r7.append("], innerStreamPlayList: [");
        Iterator r17 = ((LinkedHashMap) b).keySet().iterator();
    L26:
        if (r17.hasNext() == false) goto L38;
        Object r18 = r17.next();
        int r19 = r9 + 1;
        if (r9 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        String r20 = (String) r18;
        if (r9 == 0) goto L33;
        r7.append(", ");
    L33:
        r7.append(r20);
        r7.append(": size-");
        CopyOnWriteArrayList r21 = (CopyOnWriteArrayList) ((LinkedHashMap) b).get(r20);
        if (r21 == null) goto L36;
        Integer r22 = Integer.valueOf(r21.size());
    L37:
        r7.append(r22);
        r9 = r19;
        goto L26
    L36:
        r22 = null;
        goto L37
    L38:
        r7.append("]");
        r6.append(r7.toString());
        r5.i("InnerStreamCache", r6.toString());
    }

    public static void a(String r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "itemIdList");
        Map<String, CopyOnWriteArraySet<String>> r0 = c;
        if (r0.containsKey(r2) == false) goto L7;
        CopyOnWriteArraySet r4 = (CopyOnWriteArraySet) ((LinkedHashMap) r0).get(r2);
        if (r4 == null) goto L9;
        r4.addAll(r3);
        return;
    L9:
        return;
    L7:
        CopyOnWriteArraySet<String> r1 = new CopyOnWriteArraySet();
        r1.addAll(r3);
        r0.put(r2, r1);
    }

    public static void b(String r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "mobParamsList");
        Map<String, CopyOnWriteArrayList<g>> r0 = a;
        if (r0.containsKey(r2) == false) goto L7;
        CopyOnWriteArrayList r4 = (CopyOnWriteArrayList) ((LinkedHashMap) r0).get(r2);
        if (r4 == null) goto L9;
        r4.addAll(r3);
        return;
    L9:
        return;
    L7:
        CopyOnWriteArrayList<g> r1 = new CopyOnWriteArrayList();
        r1.addAll(r3);
        r0.put(r2, r1);
    }

    public static void c(String r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "itemIdList");
        Map<String, CopyOnWriteArrayList<String>> r0 = b;
        if (r0.containsKey(r2) == false) goto L7;
        CopyOnWriteArrayList r4 = (CopyOnWriteArrayList) ((LinkedHashMap) r0).get(r2);
        if (r4 == null) goto L9;
        r4.addAll(r3);
        return;
    L9:
        return;
    L7:
        CopyOnWriteArrayList<String> r1 = new CopyOnWriteArrayList();
        r1.addAll(r3);
        r0.put(r2, r1);
    }

    public static g e(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "itemId");
        CopyOnWriteArrayList r5 = (CopyOnWriteArrayList) ((LinkedHashMap) a).get(r3);
        Object r0 = null;
        if (r5 == null) goto L15;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        Object r1 = r6.next();
        if (Intrinsics.areEqual(((g) r1).a, r4) == false) goto L6;
        r0 = r1;
    L11:
        return (g) r0;
    L15:
        return null;
    }
}
