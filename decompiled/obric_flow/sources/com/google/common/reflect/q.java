package com.google.common.reflect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.g8;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f9370a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f9371b = null;

    static {
        f9370a = new n(0);
        f9371b = new n(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a(HashMap r5, Object r10) {
        Integer r11 = (Integer) r5.get(r10);
        if (r11 != null) goto L5;
        boolean r12 = d(r10).isInterface();
        Iterator r13 = c(r10).iterator();
        int r14 = r12;
    L8:
        if (r13.hasNext() == false) goto L10;
        r14 = Math.max(r14, a(r5, r13.next()));
        goto L8
    L10:
        Object r15 = e(r10);
        int r16 = r14;
        if (r15 == null) goto L13;
        r16 = Math.max(r14, a(r5, r15));
    L13:
        int r17 = r16 + 1;
        r5.put(r10, Integer.valueOf(r17));
        return r17;
    L5:
        return r11.intValue();
    }

    public ImmutableList b(ImmutableCollection r5) {
        HashMap r10 = new HashMap();
        Iterator<E> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        a(r10, r11.next());
        goto L4
    L7:
        return new p(g8.natural().reverse(), r10).immutableSortedCopy(r10.keySet());
    }

    public abstract Iterable c(Object r5);

    public abstract Class d(Object r5);

    public abstract Object e(Object r5);
}
