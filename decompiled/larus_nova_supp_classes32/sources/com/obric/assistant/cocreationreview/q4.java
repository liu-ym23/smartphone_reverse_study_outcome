package com.obric.assistant.cocreationreview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q4 {
    public List<e4> a;
    public boolean b;
    public boolean c;
    public final LinkedHashMap<String, String> d;
    public final LinkedHashSet<String> e;
    public String f;
    public String g;
    public CocreationTaskFilter h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CocreationTaskFilter.values().length];
            r0[CocreationTaskFilter.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CocreationTaskFilter.PENDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CocreationTaskFilter.RUN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public q4() {
        this.a = CollectionsKt.emptyList();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashSet();
        this.h = CocreationTaskFilter.ALL;
    }

    public final void a(List<e4> r6, Set<String> r7) {
        Intrinsics.checkNotNullParameter(r6, "recommendations");
        Intrinsics.checkNotNullParameter(r7, "persistedRunIds");
        ArrayList r0 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        Object r1 = r8.next();
        e4 r2 = (e4) r1;
        boolean r4 = true;
        if ((!StringsKt.isBlank(r2.a)) == true) goto L8;
    L10:
        r4 = false;
    L11:
        if (r4 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if ((!StringsKt.isBlank(r2.b)) == false) goto L10;
    L13:
        HashSet r9 = new HashSet();
        ArrayList r3 = new ArrayList();
        Iterator r5 = r0.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Object r10 = r5.next();
        if (r9.add(((e4) r10).a) == false) goto L15;
        r3.add(r10);
        goto L15
    L19:
        this.a = r3;
        HashSet r11 = new HashSet();
        Iterator r12 = r3.iterator();
    L21:
        if (r12.hasNext() == false) goto L23;
        r11.add(((e4) r12.next()).a);
        goto L21
    L23:
        this.d.keySet().retainAll(r11);
        this.e.clear();
        this.e.addAll(CollectionsKt.intersect(r7, r11));
        if (CollectionsKt.contains(r11, this.f) == true) goto L38;
        this.f = null;
        return;
    }
}
