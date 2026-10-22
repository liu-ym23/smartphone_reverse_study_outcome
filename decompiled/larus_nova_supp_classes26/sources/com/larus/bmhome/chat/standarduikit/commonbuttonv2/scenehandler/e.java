package com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final Map<String, d> a = null;
    public static final ConcurrentHashMap<String, d> b = null;

    static {
        List r0 = CollectionsKt.listOf(new c[]{new l(), new DocApplyPermissionSceneHandler(), new g(), new i(), new b()});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r3 = r1.next();
        r2.put(((c) r3).getScene(), r3);
        goto L4
    L6:
        a = r2;
        b = new ConcurrentHashMap();
    }

    public static d a(String r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return null;
    L12:
        d r3 = (d) ((LinkedHashMap) a).get(r4);
        if (r3 == null) goto L15;
        return r3;
    L15:
        int r5 = wj8.a.a;
        if (r4 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == true) goto L30;
        String r7 = wj8.a.a(r4);
        if (r7 != null) goto L27;
    L28:
        r0 = true;
    L29:
        r0 = !r0;
        goto L30
    L27:
        if (r7.length() != 0) goto L29;
    L30:
        if (r0 == false) goto L39;
        ConcurrentHashMap<String, d> r1 = b;
        d r8 = r1.get(r4);
        if (r8 != null) goto L38;
        r8 = new k(r4);
        d r9 = r1.putIfAbsent(r4, r8);
        if (r9 == null) goto L38;
        r8 = r9;
    L38:
        return r8;
    L39:
        return null;
    L18:
        if (r4.length() == 0) goto L21;
        r6 = false;
        goto L22
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L10
    }
}
