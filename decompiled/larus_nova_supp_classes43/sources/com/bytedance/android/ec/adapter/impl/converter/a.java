package com.bytedance.android.ec.adapter.impl.converter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a<Source, Target> implements i<Source, Target> {
    public final HashMap<Source, Target> a;

    public abstract Target c(Source r1);

    @Override // com.bytedance.android.ec.adapter.impl.converter.i
    public final void clear() {
        this.a.clear();
    }

    public a() {
        LinkedHashSet<i<?, ?>> r0 = c.a;
        c.a.add(this);
        this.a = new LinkedHashMap();
    }

    public Target a(Source r10) {
        HashMap<Source, Target> r0 = this.a;
        Target r1 = r0.get(r10);
        if (r1 != null) goto L6;
        Target r11 = c(r10);
        r0.put(r10, r11);
        return r11;
    L6:
        return r1;
    }

    public final synchronized Target b(Source r10) {
        monitor-enter(this);
        Target r0 = this.a.get(r10);     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        r0 = a(r10);     // Catch: Throwable -> L9
    L6:
        this.a.remove(r10);     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public final Source d(Target r10) {
        HashMap<Source, Target> r0 = this.a;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<Source, Target>> r11 = r0.entrySet().iterator();
    L3:
        boolean r12 = true;
        if (r11.hasNext() == false) goto L11;
        Map.Entry<Source, Target> r13 = r11.next();
        if (r13.getValue() == r10) goto L9;
        r12 = false;
    L9:
        if (r12 == false) goto L3;
        r1.put(r13.getKey(), r13.getValue());
        goto L3
    L11:
        Set r14 = r1.entrySet();
        if ((!r14.isEmpty()) == false) goto L18;
        Iterator r15 = r14.iterator();
        if (r15.hasNext() == false) goto L18;
        return (Source) ((Map.Entry) r15.next()).getKey();
    L18:
        throw new Exception("not track " + r10);
    }
}
