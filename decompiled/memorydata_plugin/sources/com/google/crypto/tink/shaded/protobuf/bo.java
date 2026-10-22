package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
class bo<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<bo<K, V>.d> f4985b;
    private Map<K, V> c;
    private boolean d;
    private volatile bo<K, V>.f e;
    private Map<K, V> f;
    private volatile bo<K, V>.b g;

    private class a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bo f4986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4987b;
        private Iterator<Map.Entry<K, V>> c;

        private a(bo r1) {
            this.f4986a = r1;
            this.f4987b = bo.b(r1).size();
        }

        /* synthetic */ a(bo r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.c != null) goto L6;
            this.c = bo.d(this.f4986a).entrySet().iterator();
        L6:
            return this.c;
        }

        public Map.Entry<K, V> a() {
            if (b().hasNext() == false) goto L7;
            Object r3 = b().next();
        L6:
            return (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        L7:
            List r0 = bo.b(this.f4986a);
            int r2 = this.f4987b - 1;
            this.f4987b = r2;
            r3 = r0.get(r2);
            goto L6
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int r0 = this.f4987b;
            if (r0 <= 0) goto L7;
            if (r0 > bo.b(this.f4986a).size()) goto L7;
        L8:
            return true;
        L7:
            if (b().hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class b extends bo<K, V>.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bo f4988a;

        private b(bo r2) {
            this.f4988a = r2;
            super(r2, null);
        }

        /* synthetic */ b(bo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bo.f, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this.f4988a, null);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Iterator<Object> f4989a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Iterable<Object> f4990b = null;

        static {
            f4989a = new AnonymousClass1();
            f4990b = new AnonymousClass2();
        }

        static <T> Iterable<T> a() {
            return (Iterable<T>) f4990b;
        }

        static /* synthetic */ Iterator b() {
            return f4989a;
        }
    }

    private class d implements Comparable<bo<K, V>.d>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bo f4991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final K f4992b;
        private V c;

        d(bo r3, K r4, V r5) {
            K r6 = (K) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            this.f4991a = r3;
            this.f4992b = r6;
            this.c = r5;
        }

        d(bo r4, Map.Entry<K, V> r5) {
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r5, Map.Entry.class, "com.obric.memorydata.plugin");
            this(r4, (Comparable) ZeusTransformUtils.preCheckCast(r6.getKey(), Comparable.class, "com.obric.memorydata.plugin"), r6.getValue());
        }

        private boolean a(Object r1, Object r2) {
            if (r1 != null) goto L7;
            if (r2 != null) goto L5;
            return true;
        L5:
            return false;
        L7:
            return r1.equals(r2);
        }

        public int a(bo<K, V>.d r1) {
            return a().compareTo(r1.a());
        }

        public K a() {
            return this.f4992b;
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(Object r3) {
            return a((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Map.Entry.class) == true) goto L8;
            return false;
        L8:
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin");
            if (a(this.f4992b, r6.getKey()) == false) goto L14;
            if (a(this.c, r6.getValue()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        public /* synthetic */ Object getKey() {
            return a();
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r0 = this.f4992b;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            V r3 = this.c;
            if (r3 == null) goto L11;
            r1 = r3.hashCode();
        L11:
            return r2 ^ r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        @Override // java.util.Map.Entry
        public V setValue(V r2) {
            bo.a(this.f4991a);
            V r0 = this.c;
            this.c = r2;
            return r0;
        }

        public String toString() {
            return this.f4992b + "=" + this.c;
        }
    }

    private class e implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bo f4993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4994b;
        private boolean c;
        private Iterator<Map.Entry<K, V>> d;

        private e(bo r1) {
            this.f4993a = r1;
            this.f4994b = -1;
        }

        /* synthetic */ e(bo r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.d != null) goto L6;
            this.d = bo.c(this.f4993a).entrySet().iterator();
        L6:
            return this.d;
        }

        public Map.Entry<K, V> a() {
            this.c = true;
            int r1 = this.f4994b + 1;
            this.f4994b = r1;
            if (r1 >= bo.b(this.f4993a).size()) goto L7;
            Object r3 = bo.b(this.f4993a).get(this.f4994b);
        L6:
            return (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        L7:
            r3 = b().next();
            goto L6
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if ((this.f4994b + 1) >= bo.b(this.f4993a).size()) goto L5;
            return true;
        L5:
            if (bo.c(this.f4993a).isEmpty() == false) goto L7;
        L9:
            return false;
        L7:
            if (b().hasNext() == false) goto L9;
            return true;
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.c == false) goto L10;
            this.c = false;
            bo.a(this.f4993a);
            if (this.f4994b >= bo.b(this.f4993a).size()) goto L7;
            bo r0 = this.f4993a;
            int r1 = this.f4994b;
            this.f4994b = r1 - 1;
            bo.a(r0, r1);
            return;
        L7:
            b().remove();
            return;
        L10:
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    private class f extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bo f4995b;

        private f(bo r1) {
            this.f4995b = r1;
        }

        /* synthetic */ f(bo r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(Map.Entry<K, V> r4) {
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            if (contains(r5) == true) goto L6;
            this.f4995b.a((Comparable) ZeusTransformUtils.preCheckCast(r5.getKey(), Comparable.class, "com.obric.memorydata.plugin"), r5.getValue());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* synthetic */ boolean add(Object r3) {
            return a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f4995b.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r2 = this.f4995b.get(r4.getKey());
            Object r5 = r4.getValue();
            if (r2 == r5) goto L9;
            if (r2 != null) goto L6;
        L8:
            return false;
        L6:
            if (r2.equals(r5) == false) goto L8;
        L9:
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e(this.f4995b, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            if (contains(r4) == false) goto L6;
            this.f4995b.remove(r4.getKey());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4995b.size();
        }
    }

    private bo(int r1) {
        this.f4984a = r1;
        this.f4985b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }

    /* synthetic */ bo(int r1, AnonymousClass1 r2) {
        this(r1);
    }

    private int a(K r7) {
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.memorydata.plugin");
        int r0 = this.f4985b.size() - 1;
        if (r0 < 0) goto L10;
        int r2 = r8.compareTo(((d) ZeusTransformUtils.preCheckCast(this.f4985b.get(r0), d.class, "com.obric.memorydata.plugin")).a());
        if (r2 > 0) goto L7;
        if (r2 != 0) goto L10;
        return r0;
    L7:
        return -(r0 + 2);
    L10:
        int r3 = 0;
    L11:
        if (r3 > r0) goto L19;
        int r4 = (r3 + r0) / 2;
        int r5 = r8.compareTo(((d) ZeusTransformUtils.preCheckCast(this.f4985b.get(r4), d.class, "com.obric.memorydata.plugin")).a());
        if (r5 < 0) goto L14;
        if (r5 <= 0) goto L17;
        r3 = r4 + 1;
        goto L11
    L17:
        return r4;
    L14:
        r0 = r4 - 1;
        goto L11
    L19:
        return -(r3 + 1);
    }

    static <FieldDescriptorType extends w.a<FieldDescriptorType>> bo<FieldDescriptorType, Object> a(final int r1) {
        return (bo<FieldDescriptorType, Object>) new AnonymousClass1(r1);
    }

    static /* synthetic */ Object a(bo r0, int r1) {
        return r0.c(r1);
    }

    static /* synthetic */ void a(bo r0) {
        r0.g();
    }

    static /* synthetic */ List b(bo r0) {
        return r0.f4985b;
    }

    private V c(int r7) {
        g();
        V r8 = (V) ((d) ZeusTransformUtils.preCheckCast(this.f4985b.remove(r7), d.class, "com.obric.memorydata.plugin")).getValue();
        if (this.c.isEmpty() == true) goto L5;
        Iterator<Map.Entry<K, V>> r0 = h().entrySet().iterator();
        this.f4985b.add(new d(this, (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")));
        r0.remove();
    L5:
        return r8;
    }

    static /* synthetic */ Map c(bo r0) {
        return r0.c;
    }

    static /* synthetic */ Map d(bo r0) {
        return r0.f;
    }

    private void g() {
        if (this.d == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private SortedMap<K, V> h() {
        g();
        if (this.c.isEmpty() == false) goto L8;
        if (ZeusTransformUtils.instanceOf(this.c, TreeMap.class) == true) goto L8;
        TreeMap r0 = new TreeMap();
        this.c = r0;
        this.f = ((TreeMap) ZeusTransformUtils.preCheckCast(r0, TreeMap.class, "com.obric.memorydata.plugin")).descendingMap();
    L8:
        return (SortedMap) ZeusTransformUtils.preCheckCast(this.c, SortedMap.class, "com.obric.memorydata.plugin");
    }

    private void i() {
        g();
        if (this.f4985b.isEmpty() == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(this.f4985b, ArrayList.class) == true) goto L9;
        this.f4985b = new ArrayList(this.f4984a);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V a(K r5, V r6) {
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        g();
        int r0 = a(r7);
        if (r0 >= 0) goto L5;
        i();
        int r1 = -(r0 + 1);
        if (r1 >= this.f4984a) goto L9;
        int r2 = this.f4985b.size();
        int r3 = this.f4984a;
        if (r2 != r3) goto L13;
        d r4 = (d) ZeusTransformUtils.preCheckCast(this.f4985b.remove(r3 - 1), d.class, "com.obric.memorydata.plugin");
        h().put(r4.a(), r4.getValue());
    L13:
        this.f4985b.add(r1, new d(this, r7, r6));
        return null;
    L9:
        return (V) h().put(r7, r6);
    L5:
        return (V) ((d) ZeusTransformUtils.preCheckCast(this.f4985b.get(r0), d.class, "com.obric.memorydata.plugin")).setValue(r6);
    }

    public void a() {
        if (this.d == false) goto L5;
        return;
    L5:
        if (this.c.isEmpty() == false) goto L7;
        Map<K, V> r0 = Collections.emptyMap();
    L8:
        this.c = r0;
        if (this.f.isEmpty() == false) goto L11;
        Map<K, V> r1 = Collections.emptyMap();
    L12:
        this.f = r1;
        this.d = true;
        return;
    L11:
        r1 = Collections.unmodifiableMap(this.f);
        goto L12
    L7:
        r0 = Collections.unmodifiableMap(this.c);
        goto L8
    }

    public Map.Entry<K, V> b(int r2) {
        return (Map.Entry) ZeusTransformUtils.preCheckCast(this.f4985b.get(r2), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    public boolean b() {
        return this.d;
    }

    public int c() {
        return this.f4985b.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (this.f4985b.isEmpty() == true) goto L6;
        this.f4985b.clear();
    L6:
        if (this.c.isEmpty() == true) goto L9;
        this.c.clear();
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin");
        if (a(r4) < 0) goto L5;
    L8:
        return true;
    L5:
        if (this.c.containsKey(r4) == true) goto L8;
        return false;
    }

    public int d() {
        return this.c.size();
    }

    public Iterable<Map.Entry<K, V>> e() {
        if (this.c.isEmpty() == false) goto L6;
        return c.a();
    L6:
        return this.c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.e != null) goto L6;
        this.e = new f(this, null);
    L6:
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, bo.class) == false) goto L8;
        bo r9 = (bo) ZeusTransformUtils.preCheckCast(r8, bo.class, "com.obric.memorydata.plugin");
        int r0 = size();
        if (r0 == r9.size()) goto L12;
        return false;
    L12:
        int r2 = c();
        if (r2 != r9.c()) goto L15;
        int r4 = 0;
    L17:
        if (r4 >= r2) goto L22;
        if (b(r4).equals(r9.b(r4)) == false) goto L20;
        r4 = r4 + 1;
        goto L17
    L20:
        return false;
    L22:
        if (r2 != r0) goto L24;
        return true;
    L24:
        return this.c.equals(r9.c);
    L15:
        return entrySet().equals(r9.entrySet());
    L8:
        return super.equals(r8);
    }

    Set<Map.Entry<K, V>> f() {
        if (this.g != null) goto L6;
        this.g = new b(this, null);
    L6:
        return this.g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin");
        int r0 = a(r4);
        if (r0 < 0) goto L7;
        return (V) ((d) ZeusTransformUtils.preCheckCast(this.f4985b.get(r0), d.class, "com.obric.memorydata.plugin")).getValue();
    L7:
        return this.c.get(r4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int r0 = c();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r2 = r2 + ((d) ZeusTransformUtils.preCheckCast(this.f4985b.get(r1), d.class, "com.obric.memorydata.plugin")).hashCode();
        r1 = r1 + 1;
        goto L3
    L6:
        if (d() > 0) goto L8;
        return r2;
    L8:
        return r2 + this.c.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object r3, Object r4) {
        return a((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r3) {
        g();
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin");
        int r0 = a(r4);
        if (r0 < 0) goto L7;
        return c(r0);
    L7:
        if (this.c.isEmpty() == false) goto L11;
        return null;
    L11:
        return this.c.remove(r4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f4985b.size() + this.c.size();
    }
}
