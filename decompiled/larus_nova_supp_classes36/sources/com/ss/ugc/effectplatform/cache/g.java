package com.ss.ugc.effectplatform.cache;

import com.ss.ugc.effectplatform.EffectConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import klc.a;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public final EffectConfig a;

    public g(EffectConfig r1) {
        this.a = r1;
    }

    public static final void a(g r19, String r20) {
        r19.getClass();
        l.a r2 = l.c;
        Object r3 = r19.a.G;
        r2.getClass();
        if (l.a.a(r3) == null) goto L25;
        Pair r4 = l.a();
        a r5 = (a) r19.a.v.a;
        int r6 = 4;
        float r7 = 1024.0f;
        if (r5 == null) goto L7;
        r5.monitorStatusRate("ep_effect_storage_info", 0, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("count", Integer.valueOf(((Number) r4.getFirst()).intValue())), TuplesKt.to("lru_max_size", Integer.valueOf((int) (r19.a.L / 1024.0f))), TuplesKt.to("size", Float.valueOf(((Number) r4.getSecond()).floatValue() / 1024.0f)), TuplesKt.to("source", r20)}));
    L7:
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r9 = new ArrayList().iterator();
    L9:
        if (r9.hasNext() == false) goto L15;
        k r13 = (k) r9.next();
        Object r14 = r8.get(r13.d);
        if (r14 != null) goto L14;
        r14 = TuplesKt.to(0, 0L);
    L14:
        Pair r15 = (Pair) r14;
        r8.put(r13.d, TuplesKt.to(Integer.valueOf(((Number) r15.getFirst()).intValue() + 1), Long.valueOf(((Number) r15.getSecond()).longValue() + r13.j)));
        goto L9
    L15:
        List r10 = CollectionsKt.sortedWith(r8.keySet(), new f(r8));
        Iterator r11 = r10.subList(0, Math.min(10, r10.size())).iterator();
    L17:
        if (r11.hasNext() == false) goto L32;
        String r12 = (String) r11.next();
        Pair r16 = (Pair) r8.get(r12);
        if (r16 == null) goto L24;
        a r17 = (a) r19.a.v.a;
        if (r17 == null) goto L24;
        int r18 = ((Number) r16.getFirst()).intValue();
        float r110 = ((Number) r16.getSecond()).floatValue() / r7;
        Pair[] r21 = new Pair[r6];
        r21[0] = TuplesKt.to("panel", r12);
        r21[1] = TuplesKt.to("count", Integer.valueOf(r18));
        r21[2] = TuplesKt.to("size", Float.valueOf(r110));
        r21[3] = TuplesKt.to("source", r20);
        r17.monitorStatusRate("ep_effect_storage_panel_info", 0, MapsKt.mutableMapOf(r21));
    L24:
        r6 = 4;
        r7 = 1024.0f;
        goto L17
    L32:
        return;
    }
}
