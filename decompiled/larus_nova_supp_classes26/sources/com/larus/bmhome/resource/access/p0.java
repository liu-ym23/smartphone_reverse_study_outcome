package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(f r10, h0 r11, List r12, b r13, ContinuationImpl r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "builtinNodes");
        HashSet r0 = new HashSet();
        ArrayList r1 = new ArrayList();
        Iterator r15 = r12.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        Object r2 = r15.next();
        if (r0.add(((l0) r2).getKey()) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        List r16 = CollectionsKt.sortedWith(r1, new o0(new n0()));
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r4 = r16.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        r3.add(((l0) r4.next()).getKey());
        goto L10
    L12:
        Set r5 = CollectionsKt.toSet(r3);
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r17 = r16.iterator();
    L14:
        if (r17.hasNext() == false) goto L16;
        l0 r7 = (l0) r17.next();
        r6.put(r7.getKey(), r7);
        goto L14
    L16:
        LinkedHashSet r18 = new LinkedHashSet();
        ArrayList r8 = new ArrayList();
    L18:
        if ((!r6.isEmpty()) == false) goto L48;
        Iterator r9 = r6.values().iterator();
    L21:
        if (r9.hasNext() == false) goto L42;
        Object r19 = r9.next();
        List<String> r20 = ((l0) r19).f();
        if ((r20 instanceof Collection) == true) goto L25;
    L27:
        Iterator<T> r21 = r20.iterator();
    L29:
        if (r21.hasNext() == false) goto L39;
        String r22 = (String) r21.next();
        boolean r23 = false;
        if (r5.contains(r22) == true) goto L33;
    L36:
        boolean r24 = true;
    L37:
        if (r24 == true) goto L29;
    L40:
        if (r23 == false) goto L21;
    L43:
        l0 r25 = (l0) r19;
        if (r25 == null) goto L45;
        r6.remove(r25.getKey());
        r18.add(r25.getKey());
        r8.add(r25);
        goto L18
    L45:
        FLogger.a.w("ResourceAccessPipeline", "[sortByDependency] cyclic dependency, append remaining nodes");
        r8.addAll(r6.values());
        goto L48
    L33:
        if (r18.contains(r22) == true) goto L36;
        r24 = false;
    L39:
        r23 = true;
        goto L40
    L25:
        if (r20.isEmpty() == false) goto L27;
    L42:
        r19 = null;
    L48:
        return r13.a(r10, r11, r8, r14);
    }
}
