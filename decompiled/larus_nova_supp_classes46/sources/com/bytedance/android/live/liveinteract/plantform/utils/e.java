package com.bytedance.android.live.liveinteract.plantform.utils;

import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class e {
    public final p0 a;

    public e(p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "processor");
        this.a = r2;
    }

    public final void a(JSONObject r18, int r19, String r20) {
        Intrinsics.checkNotNullParameter(r18, "info");
        Intrinsics.checkNotNullParameter(r20, "strInfo");
        p0 r6 = this.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r18, "info");
        Intrinsics.checkNotNullParameter(r20, "strInfo");
        if ((System.currentTimeMillis() - r6.f) <= r6.e) goto L5;
        r6.b.clear();
    L5:
        r6.f = System.currentTimeMillis();
        Iterator<p> r3 = r6.a.iterator();
    L7:
        if (r3.hasNext() == false) goto L64;
        p r4 = r3.next();
        Pair<String, Integer> r7 = r4.a(r18);
        if (r7 == null) goto L10;
        String r8 = (String) r7.getFirst();
        Integer r9 = r6.b.get(r8);
        if (r9 != null) goto L14;
        r9 = -1;
    L14:
        int r10 = r9.intValue();
        int r11 = ((Number) r7.getSecond()).intValue();
        boolean r13 = false;
        int r14 = 0;
        int r15 = 0;
        if (r6.s == false) goto L49;
        if (r19 == 1) goto L18;
        if (r19 == 2) goto L29;
    L38:
        int r12 = r11 - r6.q;
        if (2 > r12) goto L45;
        if (59 < r12) goto L45;
        r6.r += r12;
    L45:
        if (r6.j != null) goto L47;
        r6.j = Integer.valueOf(r11);
    L47:
        r6.i = r11;
    L52:
        if (r10 < r11) goto L60;
        if ((r10 - r11) > r6.c) goto L60;
        if (r19 == 1) goto L58;
        r6.m++;
        goto L7
    L58:
        r6.n++;
    L60:
        r6.q = r11;
        r6.b.put(r8, Integer.valueOf(r11));
        if (r19 == 2) goto L62;
        r4.b(r18.toString());
        goto L7
    L62:
        r4.b(r20);
        goto L7
    L29:
        if (r11 <= r6.o) goto L37;
        Integer r16 = r6.j;
        if (r16 == null) goto L33;
        r15 = r16.intValue();
    L33:
        if (r11 <= r15) goto L37;
        r6.g++;
        if (r6.k != null) goto L37;
        r6.k = Integer.valueOf(r11);
    L37:
        r6.o = r11;
        goto L38
    L18:
        if (r11 <= r6.p) goto L26;
        Integer r17 = r6.j;
        if (r17 == null) goto L22;
        r14 = r17.intValue();
    L22:
        if (r11 <= r14) goto L26;
        r6.h++;
        if (r6.l != null) goto L26;
        r6.l = Integer.valueOf(r11);
    L26:
        r6.p = r11;
        goto L38
    L49:
        if ((System.currentTimeMillis() - r6.t) <= 5000) goto L51;
        r13 = true;
    L51:
        r6.s = r13;
        goto L52
    L10:
        r4.b(r20);
        goto L7
    }
}
