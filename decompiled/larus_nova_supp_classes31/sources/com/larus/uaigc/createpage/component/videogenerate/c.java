package com.larus.uaigc.createpage.component.videogenerate;

import com.larus.bmhome.actionbar.model.w;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements hy9.c {
    public List<w> a;
    public final Map<Double, Long> b;

    public static final class a {
    }

    static {
    }

    public c() {
        this.a = CollectionsKt.emptyList();
        this.b = new LinkedHashMap();
    }

    @Override // hy9.c
    public final void a(List<w> r11) {
        Intrinsics.checkNotNullParameter(r11, "optionList");
        this.a = r11;
        ((LinkedHashMap) this.b).clear();
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L33;
        w r0 = (w) r12.next();
        Map r1 = r0.q;
        if (r1 == null) goto L12;
        String r2 = (String) r1.get("aspect_ratio_width");
        if (r2 == null) goto L12;
        Double r3 = StringsKt.toDoubleOrNull(r2);
        if (r3 == null) goto L12;
        double r4 = r3.doubleValue();
    L13:
        Map r5 = r0.q;
        if (r5 == null) goto L20;
        String r6 = (String) r5.get("aspect_ratio_height");
        if (r6 == null) goto L20;
        Double r7 = StringsKt.toDoubleOrNull(r6);
        if (r7 == null) goto L20;
        double r8 = r7.doubleValue();
    L21:
        Long r9 = r0.a;
        boolean r10 = true;
        if (r4 != 0.0d) goto L24;
        boolean r13 = true;
    L25:
        if (r13 == true) goto L4;
        if (r8 == 0.0d) goto L30;
        r10 = false;
    L30:
        if (r10 == true) goto L4;
        if (r9 == null) goto L4;
        this.b.put(Double.valueOf(r4 / r8), r9);
        goto L4
    L24:
        r13 = false;
    L20:
        r8 = 0.0d;
    L12:
        r4 = 0.0d;
        goto L13
    }

    @Override // hy9.c
    public final Long b(double r11) {
        if (this.b.isEmpty() == false) goto L6;
        return null;
    L6:
        List r0 = CollectionsKt.toList(((LinkedHashMap) this.b).keySet());
        double r1 = ((Number) CollectionsKt.first(r0)).doubleValue();
        double r3 = Math.abs(r11 - ((Number) CollectionsKt.first(r0)).doubleValue());
        Iterator r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        double r5 = ((Number) r2.next()).doubleValue();
        double r7 = Math.abs(r11 - r5);
        if (r7 >= r3) goto L8;
        r1 = r5;
        r3 = r7;
        goto L8
    L12:
        Map<Double, Long> r12 = this.b;
        LinkedHashMap r13 = (LinkedHashMap) r12;
        return (Long) r13.get(Double.valueOf(r1));
    }
}
