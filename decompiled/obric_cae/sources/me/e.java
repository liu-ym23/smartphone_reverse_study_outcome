package me;

import he.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import yd.l;

/* JADX INFO: loaded from: classes2.dex */
public class e extends l6.a {
    public static final b f1(Iterator r8) {
        i.f(r8, "<this>");
        d r10 = new d(r8);
        if ((r10 instanceof a) == false) goto L6;
        return r10;
    L6:
        return new a(r10);
    }

    public static final Map g1(ArrayList r8) {
        l r10 = l.f14120a;
        int r11 = r8.size();
        if (r11 != 0) goto L5;
        return r10;
    L5:
        if (r11 == 1) goto L7;
        LinkedHashMap r12 = new LinkedHashMap(l6.a.n0(r8.size()));
        h1(r8, r12);
        return r12;
    L7:
        xd.d r13 = (xd.d) r8.get(0);
        i.f(r13, "pair");
        Map r14 = Collections.singletonMap(r13.f13867a, r13.f13868b);
        i.e(r14, "singletonMap(pair.first, pair.second)");
        return r14;
    }

    public static final void h1(ArrayList r8, LinkedHashMap r10) {
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        xd.d r12 = (xd.d) r11.next();
        r10.put(r12.f13867a, r12.f13868b);
        goto L4
    }
}
