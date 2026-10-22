package org.threeten.bp.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f21197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f21198b;

    public a0(Map r11) {
        this.f21197a = r11;
        HashMap r5 = new HashMap();
        ArrayList r10 = new ArrayList();
        Iterator r12 = r11.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        TextStyle r13 = (TextStyle) r12.next();
        HashMap r14 = new HashMap();
        Iterator r15 = ((Map) r11.get(r13)).entrySet().iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        Map.Entry r16 = (Map.Entry) r15.next();
        Object r17 = r16.getValue();
        Object r18 = r16.getValue();
        Object r19 = r16.getKey();
        c r20 = b0.d;
        r14.put(r17, new AbstractMap.SimpleImmutableEntry(r18, r19));
        goto L7
    L9:
        ArrayList r21 = new ArrayList(r14.values());
        Collections.sort(r21, b0.d);
        r5.put(r13, r21);
        r10.addAll(r21);
        r5.put(null, r10);
        goto L4
    L10:
        Collections.sort(r10, b0.d);
        this.f21198b = r5;
    }
}
