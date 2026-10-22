package org.ehcache.shadow.org.terracotta.offheapstore.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.Stack;

/* JADX INFO: loaded from: classes7.dex */
public class a<T extends Comparable<? super T>> extends AbstractSet<T> implements SortedSet<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b<T> f18129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18130b;
    private boolean c;
    private b<T> d;
    private b<T> e;
    private T f;

    /* JADX INFO: renamed from: org.ehcache.shadow.org.terracotta.offheapstore.util.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: org.ehcache.shadow.org.terracotta.offheapstore.util.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0895a<E extends Comparable<? super E>> implements b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b<E> f18131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b<E> f18132b;
        private int c;

        public AbstractC0895a() {
            this(1);
        }

        private AbstractC0895a(int r2) {
            this.f18131a = e.a();
            this.f18132b = e.a();
            this.c = r2;
        }

        /* synthetic */ AbstractC0895a(int r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public void a(int r1) {
            this.c = r1;
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public void a(b<E> r3) {
            this.f18131a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public void b(b<E> r3) {
            this.f18132b = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public b<E> g() {
            return this.f18131a;
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public b<E> h() {
            return this.f18132b;
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public int i() {
            return this.c;
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public int j() {
            int r0 = this.c - 1;
            this.c = r0;
            return r0;
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public int k() {
            int r0 = this.c + 1;
            this.c = r0;
            return r0;
        }
    }

    public interface b<E extends Comparable<? super E>> {
        void a(int r1);

        void a(b<E> r1);

        void b(b<E> r1);

        void c(b<E> r1);

        E f();

        b<E> g();

        b<E> h();

        int i();

        int j();

        int k();
    }

    class c extends AbstractSet<T> implements SortedSet<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f18133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f18134b;
        private final T c;

        c(a r3, T r4, T r5) {
            T r6 = (T) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            T r7 = (T) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
            this.f18133a = r3;
            this.f18134b = r6;
            this.c = r7;
        }

        private boolean d(T r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            T r0 = this.f18134b;
            if (r0 != null) goto L5;
        L6:
            T r2 = this.c;
            if (r2 != null) goto L9;
        L12:
            return true;
        L9:
            if (r2.compareTo(r4) > 0) goto L12;
        L11:
            return false;
        L5:
            if (r0.compareTo(r4) > 0) goto L11;
            goto L6
        }

        private boolean e(T r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            T r0 = this.f18134b;
            if (r0 != null) goto L5;
        L6:
            T r2 = this.c;
            if (r2 != null) goto L9;
        L12:
            return true;
        L9:
            if (r2.compareTo(r4) >= 0) goto L12;
        L11:
            return false;
        L5:
            if (r0.compareTo(r4) > 0) goto L11;
            goto L6
        }

        public T a() {
            if (this.f18134b != null) goto L7;
            return (T) this.f18133a.b();
        L7:
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SortedSet<T> a(T r3, T r4) {
            Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            if (e(r5) == false) goto L9;
            if (e(r6) == false) goto L9;
            return new c(this.f18133a, r5, r6);
        L9:
            throw new IllegalArgumentException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(T r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            if (d(r4) == false) goto L7;
            return this.f18133a.a(r4);
        L7:
            throw new IllegalArgumentException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* synthetic */ boolean add(Object r3) {
            return a((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
        }

        public T b() {
            if (this.c != null) goto L7;
            return (T) this.f18133a.c();
        L7:
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SortedSet<T> b(T r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            if (e(r4) == false) goto L7;
            return new c(this.f18133a, this.f18134b, r4);
        L7:
            throw new IllegalArgumentException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SortedSet<T> c(T r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            if (e(r4) == false) goto L7;
            return new c(this.f18133a, r4, this.c);
        L7:
            throw new IllegalArgumentException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public Comparator<? super T> comparator() {
            return null;
        }

        @Override // java.util.SortedSet
        public /* synthetic */ Object first() {
            return a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedSet
        public /* synthetic */ SortedSet headSet(Object r3) {
            return b((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !iterator().hasNext();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            if (this.c != null) goto L7;
            return new d(this.f18133a, this.f18134b);
        L7:
            throw new UnsupportedOperationException();
        }

        @Override // java.util.SortedSet
        public /* synthetic */ Object last() {
            return b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if (d((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin")) == true) goto L5;
        L7:
            return false;
        L5:
            if (remove(r3) == false) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedSet
        public /* synthetic */ SortedSet subSet(Object r3, Object r4) {
            return a((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedSet
        public /* synthetic */ SortedSet tailSet(Object r3) {
            return c((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    class d extends a<T>.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f18135a;

        public d(a r3, T r4) {
            Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            this.f18135a = r3;
            super(r3, r5);
        }
    }

    private static final class e extends AbstractC0895a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b<?> f18136a = null;

        static {
            f18136a = new e();
        }

        private e() {
            super(0, null);
            super.a(this);
            super.b(this);
        }

        public static <T extends Comparable<? super T>> b<T> a() {
            return (b<T>) f18136a;
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.AbstractC0895a, org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public void a(int r1) {
            throw new AssertionError();
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.AbstractC0895a, org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public void a(b r2) {
            if (((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin")) != f18136a) goto L6;
            return;
        L6:
            throw new AssertionError();
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.AbstractC0895a, org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public void b(b r2) {
            if (((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin")) != f18136a) goto L6;
            return;
        L6:
            throw new AssertionError();
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public void c(b r2) {
            b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            throw new AssertionError();
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public Comparable f() {
            return null;
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.AbstractC0895a, org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public int j() {
            throw new AssertionError();
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.AbstractC0895a, org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public int k() {
            throw new AssertionError();
        }
    }

    class f implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Stack<b<T>> f18137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f18138b;
        private b<T> c;

        f(a r3) {
            this.f18138b = r3;
            Stack<b<T>> r0 = new Stack();
            this.f18137a = r0;
            r0.push(e.a());
            b<T> r4 = a.a(r3);
        L4:
            if (r4.g() == e.a()) goto L6;
            this.f18137a.push(r4);
            r4 = r4.g();
            goto L4
        L6:
            this.c = r4;
        }

        f(a r4, T r5) {
            Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
            this.f18138b = r4;
            Stack<b<T>> r0 = new Stack();
            this.f18137a = r0;
            r0.push(e.a());
            b<T> r7 = a.a(r4);
        L3:
            int r1 = r7.f().compareTo(r6);
            if (r1 > 0) goto L6;
            if (r1 >= 0) goto L14;
            if (r7.h() == e.a()) goto L12;
            r7 = r7.h();
            goto L3
        L12:
            r7 = (b) ZeusTransformUtils.preCheckCast(this.f18137a.pop(), b.class, "com.obric.memorydata.plugin");
        L14:
            this.c = r7;
            return;
        L6:
            if (r7.g() == e.a()) goto L14;
            this.f18137a.push(r7);
            r7 = r7.g();
            goto L3
        }

        private void b() {
            b r0 = this.c.h();
            if (r0 != e.a()) goto L5;
            r0 = (b) ZeusTransformUtils.preCheckCast(this.f18137a.pop(), b.class, "com.obric.memorydata.plugin");
        L8:
            this.c = r0;
            return;
        L5:
            if (r0.g() == e.a()) goto L8;
            this.f18137a.push((b<T>) r0);
            r0 = r0.g();
            goto L5
        }

        public T a() {
            b<T> r0 = this.c;
            b();
            return (T) r0.f();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.c == e.a()) goto L5;
            return true;
        L5:
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

    private static final class g<E extends Comparable<? super E>> extends AbstractC0895a<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private E f18139a;

        public g(E r3) {
            this.f18139a = (E) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public void c(b<E> r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, g.class) == false) goto L7;
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
            E r0 = r6.f18139a;
            r6.f18139a = this.f18139a;
            this.f18139a = r0;
            return;
        L7:
            throw new IllegalArgumentException();
        }

        @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
        public E f() {
            return this.f18139a;
        }
    }

    private static <T extends Comparable<? super T>> b<T> a(b<T> r2) {
        b<T> r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        if (r3.g().i() == r3.i()) goto L5;
        return r3;
    L5:
        if (r3.i() == 0) goto L9;
        b<T> r0 = (b<T>) r3.g();
        r3.a(r0.h());
        r0.b(r3);
        return r0;
    L9:
        return r3;
    }

    private b<T> a(b<T> r4, T r5) {
        b<T> r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        if (r6 == e.a()) goto L24;
        int r0 = r6.f().compareTo(r7);
        this.e = r6;
        if (r0 <= 0) goto L7;
        r6.a(a(r6.g(), r7));
    L9:
        if (r6 != this.e) goto L16;
        if (this.d != e.a()) goto L13;
        return r6;
    L13:
        if (this.d.f().compareTo(r7) != 0) goto L26;
        this.c = true;
        this.d.c(r6);
        this.f = (T) r6.f();
        return (b<T>) r6.h();
    L26:
        return r6;
    L16:
        if (r6.g().i() < (r6.i() - 1)) goto L20;
        if (r6.h().i() < (r6.i() - 1)) goto L20;
        return r6;
    L20:
        if (r6.h().i() <= r6.j()) goto L22;
        r6.h().a(r6.i());
    L22:
        b r3 = a(r6);
        r3.b(a(r3.h()));
        r3.h().b(a(r3.h().h()));
        b<T> r8 = b(r3);
        r8.b(b(r8.h()));
        return r8;
    L7:
        this.d = r6;
        r6.b(a(r6.h(), r7));
        goto L9
    L24:
        return r6;
    }

    static /* synthetic */ b a(a r0) {
        return r0.f18129a;
    }

    private static <T extends Comparable<? super T>> b<T> b(b<T> r2) {
        b<T> r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        if (r3.h().h().i() == r3.i()) goto L5;
        return r3;
    L5:
        if (r3.i() == 0) goto L9;
        b<T> r0 = (b<T>) r3.h();
        r3.b(r0.g());
        r0.a(r3);
        r0.k();
        return r0;
    L9:
        return r3;
    }

    private b<T> d(T r2) {
        Comparable r1 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, b.class) == false) goto L7;
        return (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin");
    L7:
        return new g(r1);
    }

    private b<T> insert(b<T> r3, T r4) {
        b<T> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        if (r5 != e.a()) goto L6;
        this.c = true;
        return d(r6);
    L6:
        int r0 = r5.f().compareTo(r6);
        if (r0 <= 0) goto L9;
        r5.a(insert(r5.g(), r6));
    L12:
        return b(a(r5));
    L9:
        if (r0 >= 0) goto L13;
        r5.b(insert(r5.h(), r6));
        goto L12
    L13:
        return r5;
    }

    public SortedSet<T> a(T r3, T r4) {
        return new c(this, (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public boolean a(T r3) {
        this.f18129a = insert(this.f18129a, (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        boolean r4 = this.c;     // Catch: Throwable -> L8
        if (r4 == false) goto L6;
        this.f18130b++;     // Catch: Throwable -> L8
    L6:
        this.c = false;
        return r4;
    L8:
        th = move-exception;
        this.c = false;
        throw th;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(Object r3) {
        return a((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public T b() {
        b<T> r2 = this.f18129a;
    L4:
        if (r2.g() == e.a()) goto L7;
        r2 = r2.g();
        goto L4
    L7:
        return (T) r2.f();
    }

    public SortedSet<T> b(T r3) {
        return new c(this, null, (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public T c() {
        b<T> r2 = this.f18129a;
    L4:
        if (r2.h() == e.a()) goto L7;
        r2 = r2.h();
        goto L4
    L7:
        return (T) r2.f();
    }

    public SortedSet<T> c(T r3) {
        return new c(this, (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f18129a = e.a();
        this.f18130b = 0;
    }

    @Override // java.util.SortedSet
    public Comparator<? super T> comparator() {
        return null;
    }

    public final b<T> d() {
        return this.f18129a;
    }

    @Override // java.util.SortedSet
    public /* synthetic */ Object first() {
        return b();
    }

    @Override // java.util.SortedSet
    public /* synthetic */ SortedSet headSet(Object r3) {
        return b((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.f18129a != e.a()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        return new f(this);
    }

    @Override // java.util.SortedSet
    public /* synthetic */ Object last() {
        return c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r6) {
        this.f18129a = a(this.f18129a, (Comparable) ZeusTransformUtils.preCheckCast(r6, Comparable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        boolean r7 = this.c;     // Catch: Throwable -> L8
        if (r7 == false) goto L6;
        this.f18130b--;     // Catch: Throwable -> L8
    L6:
        this.e = e.a();
        this.d = e.a();
        this.c = false;
        this.f = null;
        return r7;
    L8:
        th = move-exception;
        this.e = e.a();
        this.d = e.a();
        this.c = false;
        this.f = null;
        throw th;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f18130b;
    }

    @Override // java.util.SortedSet
    public /* synthetic */ SortedSet subSet(Object r3, Object r4) {
        return a((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.SortedSet
    public /* synthetic */ SortedSet tailSet(Object r3) {
        return c((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }
}
