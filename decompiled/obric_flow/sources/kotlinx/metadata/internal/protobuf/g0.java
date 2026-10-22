package kotlinx.metadata.internal.protobuf;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends AbstractMap {
    public static final /* synthetic */ int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f19170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f19171c;
    public boolean d;
    public volatile m0 e;

    public g0(int r5) {
        this.f19169a = r5;
        this.f19170b = Collections.emptyList();
        this.f19171c = Collections.emptyMap();
    }

    public final int a(Comparable r5) {
        int r10 = this.f19170b.size();
        int r11 = r10 - 1;
        if (r11 < 0) goto L11;
        int r12 = r5.compareTo(((k0) this.f19170b.get(r11)).f19183a);
        if (r12 <= 0) goto L9;
        int r13 = r10 + 1;
    L8:
        return -r13;
    L9:
        if (r12 != 0) goto L11;
        return r11;
    L11:
        int r14 = 0;
    L12:
        if (r14 > r11) goto L19;
        int r15 = (r14 + r11) / 2;
        int r16 = r5.compareTo(((k0) this.f19170b.get(r15)).f19183a);
        if (r16 < 0) goto L15;
        if (r16 <= 0) goto L18;
        r14 = r15 + 1;
        goto L12
    L18:
        return r15;
    L15:
        r11 = r15 - 1;
        goto L12
    L19:
        r13 = r14 + 1;
        goto L8
    }

    public final void b() {
        if (this.d == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public final Map.Entry c(int r5) {
        return (Map.Entry) this.f19170b.get(r5);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (this.f19170b.isEmpty() == true) goto L6;
        this.f19170b.clear();
    L6:
        if (this.f19171c.isEmpty() == true) goto L9;
        this.f19171c.clear();
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r5) {
        Comparable r10 = (Comparable) r5;
        if (a(r10) < 0) goto L5;
    L8:
        return true;
    L5:
        if (this.f19171c.containsKey(r10) == true) goto L8;
        return false;
    }

    public final Iterable d() {
        if (this.f19171c.isEmpty() == false) goto L6;
        return j0.f19179b;
    L6:
        return this.f19171c.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f19171c.isEmpty() == false) goto L8;
        if ((this.f19171c instanceof TreeMap) == true) goto L8;
        this.f19171c = new TreeMap();
    L8:
        return (SortedMap) this.f19171c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.e != null) goto L6;
        this.e = new m0(this);
    L6:
        return this.e;
    }

    public final Object f(Comparable r5, Object r10) {
        b();
        int r11 = a(r5);
        if (r11 >= 0) goto L5;
        b();
        boolean r12 = this.f19170b.isEmpty();
        int r13 = this.f19169a;
        if (r12 == true) goto L9;
    L11:
        int r14 = -(r11 + 1);
        if (r14 < r13) goto L16;
        return e().put(r5, r10);
    L16:
        if (this.f19170b.size() != r13) goto L18;
        k0 r15 = (k0) this.f19170b.remove(r13 - 1);
        e().put(r15.f19183a, r15.f19184b);
    L18:
        this.f19170b.add(r14, new k0(this, r5, r10));
        return null;
    L9:
        if ((this.f19170b instanceof ArrayList) == true) goto L11;
        this.f19170b = new ArrayList(r13);
        goto L11
    L5:
        return ((k0) this.f19170b.get(r11)).setValue(r10);
    }

    public final Object g(int r10) {
        b();
        Object r11 = ((k0) this.f19170b.remove(r10)).f19184b;
        if (this.f19171c.isEmpty() == true) goto L5;
        Iterator r5 = e().entrySet().iterator();
        List r12 = this.f19170b;
        Map.Entry r13 = (Map.Entry) r5.next();
        r12.add(new k0(this, (Comparable) r13.getKey(), r13.getValue()));
        r5.remove();
    L5:
        return r11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object r5) {
        Comparable r10 = (Comparable) r5;
        int r11 = a(r10);
        if (r11 < 0) goto L7;
        return ((k0) this.f19170b.get(r11)).f19184b;
    L7:
        return this.f19171c.get(r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object r5, Object r10) {
        return f((p) r5, r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object r5) {
        b();
        Comparable r10 = (Comparable) r5;
        int r11 = a(r10);
        if (r11 < 0) goto L7;
        return g(r11);
    L7:
        if (this.f19171c.isEmpty() == false) goto L11;
        return null;
    L11:
        return this.f19171c.remove(r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        int r5 = this.f19170b.size();
        return this.f19171c.size() + r5;
    }
}
