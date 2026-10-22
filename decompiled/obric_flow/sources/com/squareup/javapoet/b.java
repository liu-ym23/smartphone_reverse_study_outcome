package com.squareup.javapoet;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f14953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f14954b;

    public b(a r5) {
        this.f14953a = r5.f14948a;
        LinkedHashMap r10 = r5.f14949b;
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (((List) r13.getValue()).isEmpty() == true) goto L4;
        r11.put(r13.getKey(), com.bytedance.android.anniex.base.service.f.x((Collection) r13.getValue()));
        goto L4
    L9:
        this.f14954b = Collections.unmodifiableMap(r11);
    }

    public static a a(e r5) {
        com.bytedance.android.anniex.base.service.f.s(r5, "type == null", new Object[0]);
        return new a(r5);
    }

    public static void c(k r5, String r10, String r11, List r12) {
        boolean r13 = true;
        if (r12.size() != 1) goto L6;
        r5.m(2);
        r5.c((i) r12.get(0), false);
        r5.r(2);
        return;
    L6:
        r5.e("{".concat(r10));
        r5.m(2);
        Iterator r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L13;
        i r15 = (i) r14.next();
        if (r13 == true) goto L12;
        r5.e(r11);
    L12:
        r5.c(r15, false);
        r13 = false;
        goto L8
    L13:
        r5.r(2);
        r5.e(r10.concat("}"));
    }

    public final void b(k r10, boolean r11) {
        if (r11 == false) goto L4;
        String r5 = "";
    L5:
        if (r11 == false) goto L7;
        String r12 = ", ";
    L8:
        Map r13 = this.f14954b;
        boolean r14 = r13.isEmpty();
        e r15 = this.f14953a;
        if (r14 == false) goto L12;
        r10.b("@$T", new Object[]{r15});
        return;
    L12:
        if (r13.size() == 1) goto L14;
    L16:
        r10.b("@$T(".concat(r5), new Object[]{r15});
        r10.m(2);
        Iterator r16 = r13.entrySet().iterator();
    L18:
        if (r16.hasNext() == false) goto L22;
        Map.Entry r17 = (Map.Entry) r16.next();
        r10.b("$L = ", new Object[]{r17.getKey()});
        c(r10, r5, r12, (List) r17.getValue());
        if (r16.hasNext() == false) goto L18;
        r10.e(r12);
        goto L18
    L22:
        r10.r(2);
        r10.e(r5.concat(")"));
        return;
    L14:
        if (r13.containsKey("value") == false) goto L16;
        r10.b("@$T(", new Object[]{r15});
        c(r10, r5, r12, (List) r13.get("value"));
        r10.e(")");
        return;
    L7:
        r12 = ",\n";
        goto L8
    L4:
        r5 = "\n";
        goto L5
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (b.class == r5.getClass()) goto L12;
        return false;
    L12:
        return toString().equals(r5.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        new k(r5).b("$L", new Object[]{this});     // Catch: IOException -> L5
        return r5.toString();
    L6:
        throw new AssertionError();
    }
}
