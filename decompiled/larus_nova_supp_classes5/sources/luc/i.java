package luc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import nuc.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i implements f, nuc.n {
    public final String a;
    public final o b;
    public final int c;
    public final List<Annotation> d;
    public final Set<String> e;
    public final String[] f;
    public final f[] g;
    public final List<Annotation>[] h;
    public final boolean[] i;
    public final Map<String, Integer> j;
    public final f[] k;
    public final Lazy l;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final int hashCode() {
        return ((Number) this.l.getValue()).intValue();
    }

    public final String toString() {
        return CollectionsKt.joinToString$default(RangesKt.until(0, this.c), ", ", this.a + '(', ")", 0, null, new h(this), 24, null);
    }

    @Override // nuc.n
    public final Set<String> c() {
        return this.e;
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
    public final List<Annotation> getAnnotations() {
        return this.d;
    }

    @Override // luc.f
    public final o getKind() {
        return this.b;
    }

    @Override // luc.f
    public final String b(int r2) {
        return this.f[r2];
    }

    @Override // luc.f
    public final List<Annotation> e(int r2) {
        return this.h[r2];
    }

    public final boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if ((r7 instanceof i) == true) goto L8;
    L7:
        return false;
    L8:
        f r3 = (f) r7;
        if (Intrinsics.areEqual(f(), r3.f()) == false) goto L7;
        if (Arrays.equals(this.k, ((i) r7).k) == false) goto L7;
        if (d() != r3.d()) goto L7;
        int r8 = d();
        int r1 = 0;
    L18:
        if (r1 >= r8) goto L31;
        if (Intrinsics.areEqual(h(r1).f(), r3.h(r1).f()) == false) goto L7;
        if (Intrinsics.areEqual(h(r1).getKind(), r3.h(r1).getKind()) == false) goto L7;
        r1 = r1 + 1;
        goto L18
    L31:
        return true;
    }

    @Override // luc.f
    public final int g(String r2) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Integer r3 = this.j.get(r2);
        if (r3 != null) goto L7;
        return -3;
    L7:
        return r3.intValue();
    }

    @Override // luc.f
    public final f h(int r2) {
        return this.g[r2];
    }

    @Override // luc.f
    public final boolean i(int r2) {
        return this.i[r2];
    }

    public i(String r2, o r3, int r4, List<? extends f> r5, a r6) {
        Intrinsics.checkNotNullParameter(r2, "serialName");
        Intrinsics.checkNotNullParameter(r3, "kind");
        Intrinsics.checkNotNullParameter(r5, "typeParameters");
        Intrinsics.checkNotNullParameter(r6, "builder");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6.b;
        this.e = CollectionsKt.toHashSet(r6.c);
        ArrayList r7 = (ArrayList) r6.c;
        String[] r8 = (String[]) r7.toArray(new String[0]);
        this.f = r8;
        this.g = a2.b(r6.e);
        ArrayList r9 = (ArrayList) r6.f;
        this.h = (List[]) r9.toArray(new List[0]);
        this.i = CollectionsKt.toBooleanArray(r6.g);
        Iterable r10 = ArraysKt.withIndex(r8);
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        IndexedValue r13 = (IndexedValue) r12.next();
        r11.add(TuplesKt.to(r13.getValue(), Integer.valueOf(r13.getIndex())));
        goto L4
    L6:
        this.j = MapsKt.toMap(r11);
        this.k = a2.b(r5);
        this.l = LazyKt.lazy(new g(this));
    }
}
