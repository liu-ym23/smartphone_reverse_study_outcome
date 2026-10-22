package vu1;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import ju1.l;
import ju1.n;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public final Map<String, Object> a;
    public final Map<String, Boolean> b;
    public final Map<String, n> c;
    public final Set<String> d;
    public vu1.b e;
    public long f;
    public long g;
    public boolean h;
    public final h i;
    public final vu1.a j;

    public static final class a {
        public final ju1.c<Object> a;
        public final Object b;
        public final Object c;

        public a(ju1.c<Object> r2, Object r3, Object r4) {
            Intrinsics.checkNotNullParameter(r2, "factor");
            Intrinsics.checkNotNullParameter(r3, "oldState");
            Intrinsics.checkNotNullParameter(r4, "newState");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
        public final l a;
        public final boolean b;
        public final boolean c;

        public b(l r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final ju1.h a;
        public final n b;
        public final n c;
        public final Map<String, Object> d;

        public c(ju1.h r2, n r3, n r4, Map<String, ? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r2, "strategy");
            Intrinsics.checkNotNullParameter(r4, "newResult");
            Intrinsics.checkNotNullParameter(r5, "stateMap");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public g(d r2) {
        Intrinsics.checkNotNullParameter(r2, "repoManager");
        this.j = r2;
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new LinkedHashSet();
        this.i = new h(this);
    }

    public final b d(l r7) {
        Map<String, Boolean> r0 = this.b;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        Boolean r2 = (Boolean) r1.get(r7.b());
        if (r2 == null) goto L20;
        boolean r3 = r2.booleanValue();
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator<T> r5 = r7.c().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        String r6 = (String) r5.next();
        Intrinsics.checkNotNullParameter(r6, LiveEndPageData.TAG_NAME);
        Object r8 = ((ConcurrentHashMap) this.a).get(r6);
        if (r8 == null) goto L6;
        r4.put(r6, r8);
        goto L6
    L10:
        boolean r9 = mu1.a.a(r7, r4);
        if (r3 != r9) goto L13;
        return null;
    L13:
        Map<String, Boolean> r10 = this.b;
        ConcurrentHashMap r11 = (ConcurrentHashMap) r10;
        r11.put(r7.b(), Boolean.valueOf(r9));
        return new b(r7, r3, r9);
    L20:
        return null;
    }

    public final c e(ju1.h r10) {
        long r0 = System.currentTimeMillis();
        n r2 = (n) ((ConcurrentHashMap) this.c).get(r10.b());
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<T> r4 = r10.e().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        String r5 = (String) r4.next();
        Intrinsics.checkNotNullParameter(r5, LiveEndPageData.TAG_NAME);
        Object r6 = ((ConcurrentHashMap) this.a).get(r5);
        if (r6 == null) goto L4;
        r3.put(r5, r6);
        goto L4
    L8:
        Iterator<T> r7 = r10.c().iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        String r8 = (String) r7.next();
        Intrinsics.checkNotNullParameter(r8, LiveEndPageData.TAG_NAME);
        Boolean r9 = (Boolean) ((ConcurrentHashMap) this.b).get(r8);
        if (r9 == null) goto L10;
        r3.put(r8, Boolean.valueOf(r9.booleanValue()));
        goto L10
    L14:
        n r11 = mu1.b.b(r10, r3);
        this.f++;
        this.g += System.currentTimeMillis() - r0;
        if (r2 != null) goto L17;
    L20:
        ((ConcurrentHashMap) this.c).put(r10.b(), r11);
        return new c(r10, r2, r11, r3);
    L17:
        if (Intrinsics.areEqual(r2.c(), r11.c()) == false) goto L20;
        return null;
    }

    public final List<ju1.h> a(ju1.c<? extends Object> r4, List<? extends l> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = this.j.e(r4.a).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        ju1.h r1 = (ju1.h) r6.next();
        if (r1.f() == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Iterator<T> r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L17;
        l r8 = (l) r7.next();
        Iterator<T> r9 = this.j.e(r8.b()).iterator();
    L13:
        if (r9.hasNext() == false) goto L10;
        ju1.h r2 = (ju1.h) r9.next();
        if (r2.f() == false) goto L13;
        r0.add(r2);
        goto L13
    L17:
        return r0;
    }

    public final a b(ju1.c<Object> r4, Object r5) {
        Map<String, Object> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        Object r2 = r1.get(r4.a);
        if (r2 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r2, r5) == false) goto L8;
        return null;
    L8:
        Map<String, Object> r3 = this.a;
        ConcurrentHashMap r6 = (ConcurrentHashMap) r3;
        r6.put(r4.a, r5);
        return new a(r4, r2, r5);
    }

    public final void c(String r5, Object r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r6, "newState");
        if (r7 == false) goto L5;
    L7:
        if (r7 == false) goto L9;
        this.d.add(r5);
    L9:
        ju1.c<Object> r8 = this.j.c(r5);
        if (r8 == null) goto L36;
        a r9 = b(r8, r6);
        if (r9 == null) goto L50;
        ju1.c<Object> r10 = r9.a;
        List<l> r11 = this.j.f(r10.a);
        ArrayList r0 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L16:
        if (r12.hasNext() == false) goto L20;
        b r1 = d((l) r12.next());
        if (r1 == null) goto L16;
        r0.add(r1);
        goto L16
    L20:
        List r13 = CollectionsKt.toList(r0);
        List<ju1.h> r14 = a(r9.a, r11);
        ArrayList r2 = new ArrayList();
        Iterator r15 = ((ArrayList) r14).iterator();
    L22:
        if (r15.hasNext() == false) goto L26;
        c r3 = e((ju1.h) r15.next());
        if (r3 == null) goto L22;
        r2.add(r3);
        goto L22
    L26:
        List r16 = CollectionsKt.toList(r2);
        vu1.b r4 = this.e;
        if (r4 == null) goto L49;
        int r17 = k.a;
        k.c(r9.a, r9.b, r9.c);
        r4.d(r9.a, r9.b, r9.c);
        Iterator r18 = r13.iterator();
    L30:
        if (r18.hasNext() == false) goto L32;
        b r19 = (b) r18.next();
        int r20 = k.a;
        k.d(r19.a, r19.b, r19.c);
        r4.n(r19.a);
        goto L30
    L32:
        Iterator r21 = r16.iterator();
    L34:
        if (r21.hasNext() == false) goto L51;
        c r22 = (c) r21.next();
        int r23 = k.a;
        k.e(r22.a, r22.b, r22.c, r22.d);
        r4.l(r22.a, r22.c, r22.d);
        goto L34
    L51:
        return;
    L49:
        return;
    L50:
        return;
    L36:
        return;
    L5:
        if (this.d.contains(r5) == false) goto L7;
    }
}
