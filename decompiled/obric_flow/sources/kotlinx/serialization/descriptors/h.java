package kotlinx.serialization.descriptors;

import ai.j0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
import kotlinx.serialization.internal.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements g, kotlinx.serialization.internal.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f19230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19231c;
    public final List d;
    public final HashSet e;
    public final String[] f;
    public final g[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List[] f19232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean[] f19233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f19234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g[] f19235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f19236l;

    public h(String r5, k r10, int r11, List r12, a r13) {
        Intrinsics.checkNotNullParameter(r5, "serialName");
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r12, "typeParameters");
        Intrinsics.checkNotNullParameter(r13, "builder");
        this.f19229a = r5;
        this.f19230b = r10;
        this.f19231c = r11;
        this.d = r13.f19217b;
        ArrayList r14 = r13.f19218c;
        this.e = CollectionsKt.F(r14);
        String[] r15 = (String[]) r14.toArray(new String[0]);
        this.f = r15;
        this.g = z0.c(r13.e);
        this.f19232h = (List[]) r13.f.toArray(new List[0]);
        this.f19233i = CollectionsKt.toBooleanArray(r13.g);
        Iterable r16 = ArraysKt.withIndex(r15);
        ArrayList r17 = new ArrayList(CollectionsKt.h(r16));
        Iterator r18 = r16.iterator();
    L4:
        if (r18.hasNext() == false) goto L6;
        IndexedValue r19 = (IndexedValue) r18.next();
        r17.add(TuplesKt.to(r19.getValue(), Integer.valueOf(r19.getIndex())));
        goto L4
    L6:
        this.f19234j = MapsKt.toMap(r17);
        this.f19235k = z0.c(r12);
        this.f19236l = LazyKt.lazy(new SerialDescriptorImpl$_hashCode$2(this));
    }

    @Override // kotlinx.serialization.internal.l
    public final Set a() {
        return this.e;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean b() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Integer r10 = (Integer) this.f19234j.get(r5);
        if (r10 != null) goto L7;
        return -3;
    L7:
        return r10.intValue();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final int d() {
        return this.f19231c;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String e(int r5) {
        return this.f[r5];
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == false) goto L26;
        g r5 = (g) r10;
        if (Intrinsics.areEqual(this.f19229a, r5.h()) == false) goto L26;
        if (Arrays.equals(this.f19235k, ((h) r10).f19235k) == false) goto L26;
        int r11 = r5.d();
        int r12 = this.f19231c;
        if (r12 != r11) goto L26;
        int r13 = 0;
    L18:
        if (r13 >= r12) goto L31;
        g[] r14 = this.g;
        if (Intrinsics.areEqual(r14[r13].h(), r5.g(r13).h()) == false) goto L26;
        if (Intrinsics.areEqual(r14[r13].getKind(), r5.g(r13).getKind()) == false) goto L26;
        r13 = r13 + 1;
        goto L18
    L31:
        return true;
    L26:
        return false;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List f(int r5) {
        return this.f19232h[r5];
    }

    @Override // kotlinx.serialization.descriptors.g
    public final g g(int r5) {
        return this.g[r5];
    }

    @Override // kotlinx.serialization.descriptors.g
    public final List getAnnotations() {
        return this.d;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final k getKind() {
        return this.f19230b;
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        return this.f19229a;
    }

    public final int hashCode() {
        return ((Number) this.f19236l.getValue()).intValue();
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean i(int r5) {
        return this.f19233i[r5];
    }

    @Override // kotlinx.serialization.descriptors.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return CollectionsKt.q(RangesKt.until(0, this.f19231c), ", ", j0.p(new StringBuilder(), this.f19229a, '('), ")", 0, null, new SerialDescriptorImpl$toString$1(this), 24);
    }
}
