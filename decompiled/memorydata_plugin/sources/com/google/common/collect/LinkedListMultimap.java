package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class LinkedListMultimap<K, V> extends com.google.common.collect.c<K, V> implements ak<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient f<K, V> head;
    private transient Map<K, e<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;
    private transient f<K, V> tail;

    class a extends AbstractSequentialList<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinkedListMultimap f4501a;

        a(LinkedListMultimap r1) {
            this.f4501a = r1;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Map.Entry<K, V>> r3) {
            Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            f<K, V> r2 = LinkedListMultimap.access$200(this.f4501a);
        L3:
            if (r2 == null) goto L5;
            r4.accept(r2);
            r2 = r2.c;
            goto L3
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int r2) {
            return new g(this.f4501a, r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.access$800(this.f4501a);
        }
    }

    class b extends Sets.b<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinkedListMultimap f4502a;

        b(LinkedListMultimap r1) {
            this.f4502a = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.f4502a.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new d(this.f4502a, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            return !this.f4502a.removeAll(r1).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.access$500(this.f4502a).size();
        }
    }

    class c extends AbstractSequentialList<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinkedListMultimap f4503a;

        c(LinkedListMultimap r1) {
            this.f4503a = r1;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int r3) {
            final g r0 = new g(this.f4503a, r3);
            return new AnonymousClass1(this, r0, r0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.access$800(this.f4503a);
        }
    }

    private class d implements Iterator<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Set<K> f4505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        f<K, V> f4506b;
        f<K, V> c;
        int d;
        final /* synthetic */ LinkedListMultimap e;

        private d(LinkedListMultimap r2) {
            this.e = r2;
            this.f4505a = Sets.a(r2.keySet().size());
            this.f4506b = LinkedListMultimap.access$200(r2);
            this.d = LinkedListMultimap.access$000(r2);
        }

        /* synthetic */ d(LinkedListMultimap r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void a() {
            if (LinkedListMultimap.access$000(this.e) != this.d) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            if (this.f4506b == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public K next() {
            a();
            f<K, V> r0 = this.f4506b;
            if (r0 == null) goto L12;
            this.c = r0;
            this.f4505a.add(r0.f4509a);
        L5:
            f<K, V> r1 = this.f4506b.c;
            this.f4506b = r1;
            if (r1 == null) goto L10;
            if (this.f4505a.add(r1.f4509a) == false) goto L5;
        L10:
            return this.c.f4509a;
        L12:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            if (this.c == null) goto L5;
            boolean r0 = true;
        L6:
            com.google.common.base.n.b(r0, "no calls to next() since the last call to remove()");
            LinkedListMultimap.access$400(this.e, this.c.f4509a);
            this.c = null;
            this.d = LinkedListMultimap.access$000(this.e);
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    private static class e<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        f<K, V> f4507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        f<K, V> f4508b;
        int c;

        e(f<K, V> r2) {
            this.f4507a = r2;
            this.f4508b = r2;
            r2.f = null;
            r2.e = null;
            this.c = 1;
        }
    }

    private static final class f<K, V> extends com.google.common.collect.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f4509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        V f4510b;
        f<K, V> c;
        f<K, V> d;
        f<K, V> e;
        f<K, V> f;

        f(K r1, V r2) {
            this.f4509a = r1;
            this.f4510b = r2;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f4509a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return this.f4510b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V r2) {
            V r0 = this.f4510b;
            this.f4510b = r2;
            return r0;
        }
    }

    private class g implements ListIterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        f<K, V> f4512b;
        f<K, V> c;
        f<K, V> d;
        int e;
        final /* synthetic */ LinkedListMultimap f;

        g(LinkedListMultimap r3, int r4) {
            this.f = r3;
            this.e = LinkedListMultimap.access$000(r3);
            int r0 = r3.size();
            com.google.common.base.n.b(r4, r0);
            if (r4 < (r0 / 2)) goto L8;
            this.d = LinkedListMultimap.access$100(r3);
            this.f4511a = r0;
        L5:
            int r5 = r4 + 1;
            if (r4 >= r0) goto L12;
            b();
            r4 = r5;
        L12:
            this.c = null;
            return;
        L8:
            this.f4512b = LinkedListMultimap.access$200(r3);
        L9:
            int r6 = r4 - 1;
            if (r4 <= 0) goto L12;
            a();
            r4 = r6;
            goto L9
        }

        private void c() {
            if (LinkedListMultimap.access$000(this.f) != this.e) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        public f<K, V> a() {
            c();
            f<K, V> r0 = this.f4512b;
            if (r0 == null) goto L7;
            this.c = r0;
            this.d = r0;
            this.f4512b = r0.c;
            this.f4511a++;
            return this.c;
        L7:
            throw new NoSuchElementException();
        }

        void a(V r2) {
            if (this.c == null) goto L5;
            boolean r0 = true;
        L6:
            com.google.common.base.n.b(r0);
            this.c.f4510b = r2;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void a(Map.Entry<K, V> r2) {
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public /* synthetic */ void add(Object r3) {
            b((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
        }

        public f<K, V> b() {
            c();
            f<K, V> r0 = this.d;
            if (r0 == null) goto L7;
            this.c = r0;
            this.f4512b = r0;
            this.d = r0.d;
            this.f4511a--;
            return this.c;
        L7:
            throw new NoSuchElementException();
        }

        public void b(Map.Entry<K, V> r2) {
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            c();
            if (this.f4512b == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            c();
            if (this.d == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f4511a;
        }

        @Override // java.util.ListIterator
        public /* synthetic */ Object previous() {
            return b();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f4511a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            c();
            if (this.c == null) goto L5;
            boolean r0 = true;
        L6:
            com.google.common.base.n.b(r0, "no calls to next() since the last call to remove()");
            f<K, V> r1 = this.c;
            if (r1 == this.f4512b) goto L9;
            this.d = r1.d;
            this.f4511a--;
        L10:
            LinkedListMultimap.access$300(this.f, this.c);
            this.c = null;
            this.e = LinkedListMultimap.access$000(this.f);
            return;
        L9:
            this.f4512b = r1.c;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public /* synthetic */ void set(Object r3) {
            a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
        }
    }

    private class h implements ListIterator<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f4513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4514b;
        f<K, V> c;
        f<K, V> d;
        f<K, V> e;
        final /* synthetic */ LinkedListMultimap f;

        h(LinkedListMultimap r2, K r3) {
            this.f = r2;
            this.f4513a = r3;
            e r4 = (e) ZeusTransformUtils.preCheckCast(LinkedListMultimap.access$500(r2).get(r3), e.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
            f<K, V> r5 = null;
        L6:
            this.c = r5;
            return;
        L5:
            r5 = r4.f4507a;
            goto L6
        }

        public h(LinkedListMultimap r4, K r5, int r6) {
            this.f = r4;
            e r7 = (e) ZeusTransformUtils.preCheckCast(LinkedListMultimap.access$500(r4).get(r5), e.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L5;
            int r0 = 0;
        L6:
            com.google.common.base.n.b(r6, r0);
            if (r6 < (r0 / 2)) goto L15;
            if (r7 != null) goto L10;
            f<K, V> r8 = null;
        L11:
            this.e = r8;
            this.f4514b = r0;
        L12:
            int r9 = r6 + 1;
            if (r6 >= r0) goto L22;
            previous();
            r6 = r9;
        L22:
            this.f4513a = r5;
            this.d = null;
            return;
        L10:
            r8 = r7.f4508b;
            goto L11
        L15:
            if (r7 != null) goto L17;
            f<K, V> r10 = null;
        L18:
            this.c = r10;
        L19:
            int r11 = r6 - 1;
            if (r6 <= 0) goto L22;
            next();
            r6 = r11;
            goto L19
        L17:
            r10 = r7.f4507a;
            goto L18
        L5:
            r0 = r7.c;
            goto L6
        }

        @Override // java.util.ListIterator
        public void add(V r4) {
            this.e = LinkedListMultimap.access$600(this.f, this.f4513a, r4, this.c);
            this.f4514b++;
            this.d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.c == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.e == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            f<K, V> r0 = this.c;
            if (r0 == null) goto L7;
            this.d = r0;
            this.e = r0;
            this.c = r0.e;
            this.f4514b++;
            return this.d.f4510b;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f4514b;
        }

        @Override // java.util.ListIterator
        public V previous() {
            f<K, V> r0 = this.e;
            if (r0 == null) goto L7;
            this.d = r0;
            this.c = r0;
            this.e = r0.f;
            this.f4514b--;
            return this.d.f4510b;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f4514b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (this.d == null) goto L5;
            boolean r0 = true;
        L6:
            com.google.common.base.n.b(r0, "no calls to next() since the last call to remove()");
            f<K, V> r1 = this.d;
            if (r1 == this.c) goto L9;
            this.e = r1.f;
            this.f4514b--;
        L10:
            LinkedListMultimap.access$300(this.f, this.d);
            this.d = null;
            return;
        L9:
            this.c = r1.e;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public void set(V r2) {
            if (this.d == null) goto L5;
            boolean r0 = true;
        L6:
            com.google.common.base.n.b(r0);
            this.d.f4510b = r2;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    LinkedListMultimap() {
        this(12);
    }

    private LinkedListMultimap(int r1) {
        this.keyToKeyList = ar.a(r1);
    }

    private LinkedListMultimap(am<? extends K, ? extends V> r3) {
        am r4 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin");
        this(r4.keySet().size());
        putAll(r4);
    }

    static /* synthetic */ int access$000(LinkedListMultimap r0) {
        return r0.modCount;
    }

    static /* synthetic */ f access$100(LinkedListMultimap r0) {
        return r0.tail;
    }

    static /* synthetic */ f access$200(LinkedListMultimap r0) {
        return r0.head;
    }

    static /* synthetic */ void access$300(LinkedListMultimap r0, f r1) {
        r0.removeNode(r1);
    }

    static /* synthetic */ void access$400(LinkedListMultimap r0, Object r1) {
        r0.removeAllNodes(r1);
    }

    static /* synthetic */ Map access$500(LinkedListMultimap r0) {
        return r0.keyToKeyList;
    }

    static /* synthetic */ f access$600(LinkedListMultimap r0, Object r1, Object r2, f r3) {
        return r0.addNode(r1, r2, r3);
    }

    static /* synthetic */ int access$800(LinkedListMultimap r0) {
        return r0.size;
    }

    private f<K, V> addNode(K r3, V r4, f<K, V> r5) {
        f<K, V> r0 = new f(r3, r4);
        if (this.head != null) goto L7;
        this.tail = r0;
        this.head = r0;
        Map<K, e<K, V>> r6 = this.keyToKeyList;
        e<K, V> r7 = new e(r0);
    L5:
        r6.put(r3, r7);
        this.modCount++;
    L21:
        this.size++;
        return r0;
    L7:
        if (r5 != null) goto L12;
        ((f) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.tail), f.class, "com.obric.memorydata.plugin")).c = r0;
        r0.d = this.tail;
        this.tail = r0;
        e r8 = (e) ZeusTransformUtils.preCheckCast(this.keyToKeyList.get(r3), e.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L11;
        r6 = this.keyToKeyList;
        r7 = new e(r0);
        goto L5
    L11:
        r8.c++;
        f<K, V> r9 = r8.f4508b;
        r9.e = r0;
        r0.f = r9;
        r8.f4508b = r0;
        goto L21
    L12:
        e r10 = (e) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((e) ZeusTransformUtils.preCheckCast(this.keyToKeyList.get(r3), e.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
        r10.c++;
        r0.d = r5.d;
        r0.f = r5.f;
        r0.c = r5;
        r0.e = r5;
        if (r5.f != null) goto L15;
        r10.f4507a = r0;
    L17:
        if (r5.d != null) goto L19;
        this.head = r0;
    L20:
        r5.d = r0;
        r5.f = r0;
        goto L21
    L19:
        r5.d.c = r0;
        goto L20
    L15:
        r5.f.e = r0;
        goto L17
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int r1) {
        return new LinkedListMultimap(r1);
    }

    public static <K, V> LinkedListMultimap<K, V> create(am<? extends K, ? extends V> r2) {
        return new LinkedListMultimap((am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.memorydata.plugin"));
    }

    private List<V> getCopy(K r2) {
        return Collections.unmodifiableList(Lists.a(new h(this, r2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r5) {
        r5.defaultReadObject();
        this.keyToKeyList = Maps.d();
        int r0 = r5.readInt();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        put(r5.readObject(), r5.readObject());
        r1 = r1 + 1;
        goto L3
    }

    private void removeAllNodes(K r2) {
        Iterators.h(new h(this, r2));
    }

    private void removeNode(f<K, V> r5) {
        if (r5.d == null) goto L5;
        r5.d.c = r5.c;
    L7:
        if (r5.c == null) goto L9;
        r5.c.d = r5.d;
    L11:
        if (r5.f == null) goto L13;
    L15:
        e r0 = (e) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((e) ZeusTransformUtils.preCheckCast(this.keyToKeyList.get(r5.f4509a), e.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
        r0.c--;
        if (r5.f != null) goto L18;
        r0.f4507a = (f) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r5.e), f.class, "com.obric.memorydata.plugin");
    L20:
        if (r5.e != null) goto L22;
        r0.f4508b = (f) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r5.f), f.class, "com.obric.memorydata.plugin");
    L23:
        this.size--;
        return;
    L22:
        r5.e.f = r5.f;
        goto L23
    L18:
        r5.f.e = r5.e;
        goto L20
    L13:
        if (r5.e != null) goto L15;
        ((e) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((e) ZeusTransformUtils.preCheckCast(this.keyToKeyList.remove(r5.f4509a), e.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin")).c = 0;
        this.modCount++;
        goto L23
    L9:
        this.tail = r5.d;
        goto L11
    L5:
        this.head = r5.c;
        goto L7
    }

    private void writeObject(ObjectOutputStream r4) {
        r4.defaultWriteObject();
        r4.writeInt(size());
        Iterator<Map.Entry<K, V>> r3 = entries().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.writeObject(r0.getKey());
        r4.writeObject(r0.getValue());
        goto L4
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.am
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean containsEntry(Object r1, Object r2) {
        return super.containsEntry(r1, r2);
    }

    @Override // com.google.common.collect.am
    public boolean containsKey(Object r1) {
        return this.keyToKeyList.containsKey(r1);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public boolean containsValue(Object r1) {
        return values().contains(r1);
    }

    @Override // com.google.common.collect.c
    Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    @Override // com.google.common.collect.c
    /* bridge */ /* synthetic */ Collection createEntries() {
        return createEntries();
    }

    @Override // com.google.common.collect.c
    List<Map.Entry<K, V>> createEntries() {
        return new a(this);
    }

    @Override // com.google.common.collect.c
    Set<K> createKeySet() {
        return new b(this);
    }

    @Override // com.google.common.collect.c
    an<K> createKeys() {
        return new Multimaps.c(this);
    }

    @Override // com.google.common.collect.c
    /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.c
    List<V> createValues() {
        return new c(this);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public List<Map.Entry<K, V>> entries() {
        return (List) ZeusTransformUtils.preCheckCast(super.entries(), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.c
    Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Collection get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    public List<V> get(final K r2) {
        return new AnonymousClass1(this, r2);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public boolean isEmpty() {
        if (this.head != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ an keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public boolean put(K r2, V r3) {
        addNode(r2, r3, null);
        return true;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* synthetic */ boolean putAll(am r3) {
        return super.putAll((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* synthetic */ boolean putAll(Object r3, Iterable r4) {
        return super.putAll(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean remove(Object r1, Object r2) {
        return super.remove(r1, r2);
    }

    @Override // com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
        return removeAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.am, com.google.common.collect.ak
    public List<V> removeAll(Object r2) {
        List<V> r0 = getCopy(r2);
        removeAllNodes(r2);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    public List<V> replaceValues(K r3, Iterable<? extends V> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        List<V> r0 = getCopy(r3);
        h r1 = new h(this, r3);
        Iterator r2 = r5.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r2.hasNext() == false) goto L9;
        r1.next();
        r1.set(r2.next());
    L9:
        if (r1.hasNext() == false) goto L12;
        r1.next();
        r1.remove();
    L12:
        if (r2.hasNext() == false) goto L14;
        r1.add(r2.next());
        goto L12
    L14:
        return r0;
    }

    @Override // com.google.common.collect.am
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public List<V> values() {
        return (List) ZeusTransformUtils.preCheckCast(super.values(), List.class, "com.obric.memorydata.plugin");
    }
}
