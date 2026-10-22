package nuc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import luc.o;
import luc.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class g2 implements luc.f, n {
    public final String a;
    public final m0<?> b;
    public final int c;
    public int d;
    public final String[] e;
    public final List<Annotation>[] f;
    public List<Annotation> g;
    public final boolean[] h;
    public Map<String, Integer> i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public boolean isInline() {
        return false;
    }

    public String toString() {
        return CollectionsKt.joinToString$default(RangesKt.until(0, this.c), ", ", this.a + '(', ")", 0, null, new f2(this), 24, null);
    }

    @Override // nuc.n
    public final Set<String> c() {
        return this.i.keySet();
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        List<Annotation> r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public int hashCode() {
        return ((Number) this.l.getValue()).intValue();
    }

    @Override // luc.f
    public final int d() {
        return this.c;
    }

    @Override // luc.f
    public final String f() {
        return this.a;
    }

    @Override // luc.f
    public o getKind() {
        return p.a.a;
    }

    @Override // luc.f
    public final String b(int r2) {
        return this.e[r2];
    }

    @Override // luc.f
    public final List<Annotation> e(int r2) {
        List<Annotation> r3 = this.f[r2];
        if (r3 == null) goto L5;
        return r3;
    L5:
        return CollectionsKt.emptyList();
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L5;
    L25:
        return true;
    L5:
        if ((r6 instanceof g2) == false) goto L30;
        luc.f r2 = (luc.f) r6;
        if (Intrinsics.areEqual(this.a, r2.f()) == true) goto L11;
        return false;
    L11:
        if (Arrays.equals((luc.f[]) this.k.getValue(), (luc.f[]) ((g2) r6).k.getValue()) == true) goto L14;
        return false;
    L14:
        if (this.c != r2.d()) goto L33;
        int r7 = this.c;
        int r0 = 0;
    L17:
        if (r0 >= r7) goto L25;
        if (Intrinsics.areEqual(h(r0).f(), r2.h(r0).f()) == false) goto L34;
        if (Intrinsics.areEqual(h(r0).getKind(), r2.h(r0).getKind()) == false) goto L35;
        r0 = r0 + 1;
        goto L17
    L35:
        return false;
    L34:
        return false;
    L33:
        return false;
    L30:
        return false;
    }

    @Override // luc.f
    public final int g(String r2) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Integer r3 = this.i.get(r2);
        if (r3 != null) goto L7;
        return -3;
    L7:
        return r3.intValue();
    }

    @Override // luc.f
    public luc.f h(int r2) {
        return ((d[]) this.j.getValue())[r2].getDescriptor();
    }

    @Override // luc.f
    public final boolean i(int r2) {
        return this.h[r2];
    }

    public final void k(Annotation r4) {
        Intrinsics.checkNotNullParameter(r4, "annotation");
        List<Annotation> r0 = this.f[this.d];
        if (r0 != null) goto L5;
        r0 = new ArrayList(1);
        this.f[this.d] = r0;
    L5:
        r0.add(r4);
    }

    public final void l(Annotation r3) {
        Intrinsics.checkNotNullParameter(r3, "a");
        if (this.g != null) goto L5;
        this.g = new ArrayList(1);
    L5:
        List<Annotation> r0 = this.g;
        Intrinsics.checkNotNull(r0);
        r0.add(r3);
    }

    public final void j(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, DBDefinition.NAME);
        String[] r0 = this.e;
        int r1 = this.d + 1;
        this.d = r1;
        r0[r1] = r4;
        this.h[r1] = r5;
        this.f[r1] = null;
        if (r1 != (this.c - 1)) goto L10;
        HashMap r6 = new HashMap();
        int r7 = this.e.length;
        int r2 = 0;
    L5:
        if (r2 >= r7) goto L7;
        r6.put(this.e[r2], Integer.valueOf(r2));
        r2 = r2 + 1;
        goto L5
    L7:
        this.i = r6;
        return;
    }

    public g2(String r2, m0<?> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "serialName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = -1;
        String[] r5 = new String[r4];
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L5;
        r5[r6] = "[UNINITIALIZED]";
        r6 = r6 + 1;
        goto L3
    L5:
        this.e = r5;
        int r7 = this.c;
        this.f = new List[r7];
        this.h = new boolean[r7];
        this.i = MapsKt.emptyMap();
        LazyThreadSafetyMode r8 = LazyThreadSafetyMode.PUBLICATION;
        this.j = LazyKt.lazy(r8, new c2(this));
        this.k = LazyKt.lazy(r8, new d2(this));
        this.l = LazyKt.lazy(r8, new e2(this));
    }
}
