package com.google.common.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f8953a;

    public e4() {
        int r5 = h8.f9015a;
        this.f8953a = new LinkedHashMap();
    }

    public final void a(e4 r10) {
        Iterator r11 = r10.f8953a.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L27;
        Map.Entry r5 = (Map.Entry) r11.next();
        Object r12 = r5.getKey();
        Iterable r13 = (Iterable) r5.getValue();
        if (r12 == null) goto L7;
        LinkedHashMap r14 = this.f8953a;
        Collection r15 = (Collection) r14.get(r12);
        if (r15 != null) goto L15;
        Iterator r16 = r13.iterator();
        if (r16.hasNext() == false) goto L4;
        Collection r17 = b();
    L24:
        if (r16.hasNext() == false) goto L26;
        Object r18 = r16.next();
        p7.p(r12, r18);
        r17.add(r18);
        goto L24
    L26:
        r14.put(r12, r17);
        goto L4
    L15:
        Iterator r19 = r13.iterator();
    L17:
        if (r19.hasNext() == false) goto L4;
        Object r20 = r19.next();
        p7.p(r12, r20);
        r15.add(r20);
        goto L17
    L7:
        String r21 = String.valueOf(p7.u0(r13));
        if (r21.length() == 0) goto L10;
        String r22 = "null key in entry: null=".concat(r21);
    L12:
        throw new NullPointerException(r22);
    L10:
        r22 = new String("null key in entry: null=");
        goto L12
    }

    public Collection b() {
        return new ArrayList();
    }

    public e4 c(Object r5, Object r10) {
        p7.p(r5, r10);
        LinkedHashMap r11 = this.f8953a;
        Collection r12 = (Collection) r11.get(r5);
        if (r12 != null) goto L5;
        r12 = b();
        r11.put(r5, r12);
    L5:
        r12.add(r10);
        return this;
    }

    public void d(Map.Entry r5) {
        c(r5.getKey(), r5.getValue());
    }
}
