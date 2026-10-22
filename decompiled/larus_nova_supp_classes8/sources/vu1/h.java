package vu1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ju1.l;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements a.InterfaceC0425a {
    public final /* synthetic */ g a;

    public h(g r1) {
        this.a = r1;
    }

    @Override // vu1.a.InterfaceC0425a
    public final void a(List<ju1.c<Object>> r8) {
        Intrinsics.checkNotNullParameter(r8, "factorList");
        if (this.a.h == true) goto L9;
        Iterator<T> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        ju1.c r0 = (ju1.c) r9.next();
        ((ConcurrentHashMap) this.a.a).put(r0.a, r0.b);
        goto L6
    L8:
        return;
    L9:
        HashMap r1 = new HashMap();
        HashMap r2 = new HashMap();
        HashMap r3 = new HashMap();
        Iterator<T> r10 = r8.iterator();
    L11:
        if (r10.hasNext() == false) goto L24;
        ju1.c<? extends Object> r4 = (ju1.c) r10.next();
        if ((!((ConcurrentHashMap) this.a.a).containsKey(r4.a)) == true) goto L15;
        r1.put(r4.a, r4);
    L16:
        List<l> r5 = this.a.j.f(r4.a);
        List<ju1.h> r6 = this.a.a(r4, r5);
        Iterator<T> r7 = r5.iterator();
    L18:
        if (r7.hasNext() == false) goto L20;
        l r11 = (l) r7.next();
        r2.put(r11.b(), r11);
        goto L18
    L20:
        Iterator r12 = ((ArrayList) r6).iterator();
    L22:
        if (r12.hasNext() == false) goto L11;
        ju1.h r13 = (ju1.h) r12.next();
        r3.put(r13.b(), r13);
        goto L22
    L15:
        ((ConcurrentHashMap) this.a.a).put(r4.a, r4.b);
        goto L16
    L24:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r1.entrySet().iterator();
    L26:
        if (r15.hasNext() == false) goto L30;
        Map.Entry r16 = (Map.Entry) r15.next();
        g.a r17 = this.a.b((ju1.c) r16.getValue(), ((ju1.c) r16.getValue()).b);
        if (r17 == null) goto L26;
        r14.add(r17);
        goto L26
    L30:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r2.entrySet().iterator();
    L32:
        if (r19.hasNext() == false) goto L36;
        g.b r20 = this.a.d((l) ((Map.Entry) r19.next()).getValue());
        if (r20 == null) goto L32;
        r18.add(r20);
        goto L32
    L36:
        List r21 = CollectionsKt.toList(r18);
        ArrayList r22 = new ArrayList();
        Iterator r23 = r3.entrySet().iterator();
    L38:
        if (r23.hasNext() == false) goto L42;
        g.c r24 = this.a.e((ju1.h) ((Map.Entry) r23.next()).getValue());
        if (r24 == null) goto L38;
        r22.add(r24);
        goto L38
    L42:
        List r25 = CollectionsKt.toList(r22);
        b r26 = this.a.e;
        if (r26 == null) goto L56;
        Iterator r27 = r14.iterator();
    L46:
        if (r27.hasNext() == false) goto L48;
        g.a r28 = (g.a) r27.next();
        int r29 = k.a;
        k.c(r28.a, r28.b, r28.c);
        r26.d(r28.a, r28.b, r28.c);
        goto L46
    L48:
        Iterator r30 = r21.iterator();
    L50:
        if (r30.hasNext() == false) goto L52;
        g.b r31 = (g.b) r30.next();
        int r32 = k.a;
        k.d(r31.a, r31.b, r31.c);
        r26.n(r31.a);
        goto L50
    L52:
        Iterator r33 = r25.iterator();
    L54:
        if (r33.hasNext() == false) goto L79;
        g.c r34 = (g.c) r33.next();
        int r35 = k.a;
        k.e(r34.a, r34.b, r34.c, r34.d);
        r26.l(r34.a, r34.c, r34.d);
        goto L54
    L79:
        return;
    }
}
