package com.google.common.collect;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final class TreeMultiset<E> extends h<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient a<E> header;
    private final transient GeneralRange<E> range;
    private final transient b<a<E>> rootReference;

    /* JADX INFO: renamed from: com.google.common.collect.TreeMultiset$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4631a = null;

        static {
            int[] r0 = new int[BoundType.values().length];
            f4631a = r0;
            r0[BoundType.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f4631a[BoundType.CLOSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static abstract enum Aggregate extends Enum<Aggregate> {
        private static final /* synthetic */ Aggregate[] $VALUES = null;
        public static final Aggregate DISTINCT = null;
        public static final Aggregate SIZE = null;

        private static /* synthetic */ Aggregate[] $values() {
            return new Aggregate[]{SIZE, DISTINCT};
        }

        static {
            final String r1 = "SIZE";
            final int r2 = 0;
            SIZE = new AnonymousClass1(r1, r2);
            final String r3 = "DISTINCT";
            final int r4 = 1;
            DISTINCT = new AnonymousClass2(r3, r4);
            $VALUES = $values();
        }

        private Aggregate(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Aggregate(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Aggregate valueOf(String r2) {
            return (Aggregate) ZeusTransformUtils.preCheckCast(Enum.valueOf(Aggregate.class, r2), Aggregate.class, "com.obric.memorydata.plugin");
        }

        public static Aggregate[] values() {
            return (Aggregate[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Aggregate[].class, "com.obric.memorydata.plugin");
        }

        abstract int nodeAggregate(a<?> r1);

        abstract long treeAggregate(a<?> r1);
    }

    private static final class a<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final E f4632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4633b;
        private int c;
        private long d;
        private int e;
        private a<E> f;
        private a<E> g;
        private a<E> h;
        private a<E> i;

        a() {
            this.f4632a = null;
            this.f4633b = 1;
        }

        a(E r3, int r4) {
            if (r4 <= 0) goto L5;
            boolean r1 = true;
        L6:
            com.google.common.base.n.a(r1);
            this.f4632a = r3;
            this.f4633b = r4;
            this.d = r4;
            this.c = 1;
            this.e = 1;
            this.f = null;
            this.g = null;
            return;
        L5:
            r1 = false;
            goto L6
        }

        static /* synthetic */ int a(a r0) {
            return r0.f4633b;
        }

        static /* synthetic */ int a(a r0, int r1) {
            r0.f4633b = r1;
            return r1;
        }

        static /* synthetic */ a a(a r0, a r1) {
            r0.f = r1;
            return r1;
        }

        static /* synthetic */ a a(a r2, Comparator r3, Object r4) {
            return r2.b((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"), r4);
        }

        private a<E> a(E r3, int r4) {
            a<E> r0 = new a(r3, r4);
            this.g = r0;
            TreeMultiset.access$1800(this, r0, d());
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += (long) r4;
            return this;
        }

        static /* synthetic */ long b(a r2) {
            return r2.d;
        }

        static /* synthetic */ a b(a r0, a r1) {
            r0.g = r1;
            return r1;
        }

        static /* synthetic */ a b(a r2, Comparator r3, Object r4) {
            return r2.c((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"), r4);
        }

        private a<E> b(E r3, int r4) {
            this.f = new a(r3, r4);
            TreeMultiset.access$1800(c(), this.f, this);
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += (long) r4;
            return this;
        }

        private a<E> b(Comparator<? super E> r3, E r4) {
            Comparator<? super E> r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
            int r0 = r5.compare(r4, a());
            if (r0 >= 0) goto L9;
            a<E> r1 = this.f;
            if (r1 != null) goto L8;
            return this;
        L8:
            return (a) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(r1.b(r5, r4), this), a.class, "com.obric.memorydata.plugin");
        L9:
            if (r0 != 0) goto L11;
            return this;
        L11:
            a<E> r2 = this.g;
            if (r2 != null) goto L15;
            return null;
        L15:
            return r2.b(r5, r4);
        }

        static /* synthetic */ int c(a r0) {
            return r0.c;
        }

        private a<E> c() {
            return (a) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.h), a.class, "com.obric.memorydata.plugin");
        }

        static /* synthetic */ a c(a r0, a r1) {
            r0.h = r1;
            return r1;
        }

        private a<E> c(Comparator<? super E> r3, E r4) {
            Comparator<? super E> r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
            int r0 = r5.compare(r4, a());
            if (r0 <= 0) goto L9;
            a<E> r1 = this.g;
            if (r1 != null) goto L8;
            return this;
        L8:
            return (a) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(r1.c(r5, r4), this), a.class, "com.obric.memorydata.plugin");
        L9:
            if (r0 != 0) goto L11;
            return this;
        L11:
            a<E> r2 = this.f;
            if (r2 != null) goto L15;
            return null;
        L15:
            return r2.c(r5, r4);
        }

        private a<E> d() {
            return (a) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.i), a.class, "com.obric.memorydata.plugin");
        }

        static /* synthetic */ a d(a r0) {
            return r0.f;
        }

        static /* synthetic */ a d(a r0, a r1) {
            r0.i = r1;
            return r1;
        }

        private a<E> e() {
            int r0 = this.f4633b;
            this.f4633b = 0;
            TreeMultiset.access$1900(c(), d());
            a<E> r1 = this.f;
            if (r1 == null) goto L5;
            a<E> r2 = this.g;
            if (r2 != null) goto L10;
            return r1;
        L10:
            if (r1.e < r2.e) goto L14;
            a<E> r3 = c();
            r3.f = this.f.i(r3);
            r3.g = this.g;
        L12:
            r3.c = this.c - 1;
            r3.d = this.d - ((long) r0);
            return r3.i();
        L14:
            r3 = d();
            r3.g = this.g.h(r3);
            r3.f = this.f;
            goto L12
        L5:
            return this.g;
        }

        static /* synthetic */ a e(a r0) {
            return r0.g;
        }

        static /* synthetic */ a f(a r0) {
            return r0.d();
        }

        private void f() {
            this.c = (TreeMultiset.distinctElements(this.f) + 1) + TreeMultiset.distinctElements(this.g);
            this.d = (((long) this.f4633b) + j(this.f)) + j(this.g);
        }

        static /* synthetic */ a g(a r0) {
            return r0.c();
        }

        private void g() {
            this.e = Math.max(k(this.f), k(this.g)) + 1;
        }

        private a<E> h(a<E> r5) {
            a<E> r0 = this.f;
            if (r0 == null) goto L5;
            this.f = r0.h(r5);
            this.c--;
            this.d -= (long) r5.f4633b;
            return i();
        L5:
            return this.g;
        }

        private void h() {
            f();
            g();
        }

        private a<E> i() {
            int r0 = j();
            if (r0 != (-2)) goto L5;
            Objects.requireNonNull(this.g);
            if (this.g.j() <= 0) goto L17;
            this.g = this.g.l();
        L17:
            return k();
        L5:
            if (r0 == 2) goto L8;
            g();
            return this;
        L8:
            Objects.requireNonNull(this.f);
            if (this.f.j() >= 0) goto L12;
            this.f = this.f.k();
        L12:
            return l();
        }

        private a<E> i(a<E> r5) {
            a<E> r0 = this.g;
            if (r0 == null) goto L5;
            this.g = r0.i(r5);
            this.c--;
            this.d -= (long) r5.f4633b;
            return i();
        L5:
            return this.f;
        }

        private int j() {
            return k(this.f) - k(this.g);
        }

        private static long j(a<?> r2) {
            if (r2 != null) goto L5;
            return 0;
        L5:
            return ((a) r2).d;
        }

        private static int k(a<?> r0) {
            if (r0 != null) goto L5;
            return 0;
        L5:
            return ((a) r0).e;
        }

        private a<E> k() {
            if (this.g == null) goto L5;
            boolean r0 = true;
        L6:
            com.google.common.base.n.b(r0);
            a<E> r1 = this.g;
            this.g = r1.f;
            r1.f = this;
            r1.d = this.d;
            r1.c = this.c;
            h();
            r1.g();
            return r1;
        L5:
            r0 = false;
            goto L6
        }

        private a<E> l() {
            if (this.f == null) goto L5;
            boolean r0 = true;
        L6:
            com.google.common.base.n.b(r0);
            a<E> r1 = this.f;
            this.f = r1.g;
            r1.g = this;
            r1.d = this.d;
            r1.c = this.c;
            h();
            r1.g();
            return r1;
        L5:
            r0 = false;
            goto L6
        }

        int a(Comparator<? super E> r3, E r4) {
            Comparator<? super E> r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
            int r0 = r5.compare(r4, a());
            if (r0 >= 0) goto L9;
            a<E> r2 = this.f;
            if (r2 != null) goto L8;
            return 0;
        L8:
            return r2.a(r5, r4);
        L9:
            if (r0 <= 0) goto L16;
            a<E> r6 = this.g;
            if (r6 != null) goto L14;
            return 0;
        L14:
            return r6.a(r5, r4);
        L16:
            return this.f4633b;
        }

        a<E> a(Comparator<? super E> r8, E r9, int r10, int r11, int[] r12) {
            Comparator<? super E> r1 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r8, Comparator.class, "com.obric.memorydata.plugin");
            int r13 = r1.compare(r9, a());
            if (r13 >= 0) goto L25;
            a<E> r0 = this.f;
            if (r0 != null) goto L11;
            r12[0] = 0;
            if (r10 != 0) goto L54;
            if (r11 > 0) goto L10;
            return this;
        L10:
            return b(r9, r11);
        L54:
            return this;
        L11:
            this.f = r0.a(r1, r9, r10, r11, r12);
            if (r12[0] != r10) goto L24;
            if (r11 == 0) goto L15;
        L18:
            if (r11 > 0) goto L20;
        L22:
            this.d += (long) (r11 - r12[0]);
            goto L24
        L20:
            if (r12[0] != 0) goto L22;
            int r14 = this.c + 1;
        L17:
            this.c = r14;
            goto L22
        L15:
            if (r12[0] == 0) goto L18;
            r14 = this.c - 1;
        L24:
            return i();
        L25:
            if (r13 <= 0) goto L47;
            a<E> r2 = this.g;
            if (r2 != null) goto L33;
            r12[0] = 0;
            if (r10 != 0) goto L56;
            if (r11 > 0) goto L32;
            return this;
        L32:
            return a(r9, r11);
        L56:
            return this;
        L33:
            this.g = r2.a(r1, r9, r10, r11, r12);
            if (r12[0] != r10) goto L46;
            if (r11 == 0) goto L37;
        L40:
            if (r11 > 0) goto L42;
        L44:
            this.d += (long) (r11 - r12[0]);
            goto L46
        L42:
            if (r12[0] != 0) goto L44;
            int r15 = this.c + 1;
        L39:
            this.c = r15;
            goto L44
        L37:
            if (r12[0] == 0) goto L40;
            r15 = this.c - 1;
        L46:
            return i();
        L47:
            int r16 = this.f4633b;
            r12[0] = r16;
            if (r10 != r16) goto L53;
            if (r11 == 0) goto L51;
            this.d += (long) (r11 - r16);
            this.f4633b = r11;
            goto L53
        L51:
            return e();
        L53:
            return this;
        }

        a<E> a(Comparator<? super E> r8, E r9, int r10, int[] r11) {
            Comparator<? super E> r12 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r8, Comparator.class, "com.obric.memorydata.plugin");
            int r0 = r12.compare(r9, a());
            boolean r1 = true;
            if (r0 >= 0) goto L16;
            a<E> r2 = this.f;
            if (r2 != null) goto L8;
            r11[0] = 0;
            return b(r9, r10);
        L8:
            int r3 = r2.e;
            a<E> r13 = r2.a(r12, r9, r10, r11);
            this.f = r13;
            if (r11[0] != 0) goto L11;
            this.c++;
        L11:
            this.d += (long) r10;
            if (r13.e != r3) goto L15;
            return this;
        L15:
            return i();
        L16:
            if (r0 <= 0) goto L29;
            a<E> r4 = this.g;
            if (r4 != null) goto L21;
            r11[0] = 0;
            return a(r9, r10);
        L21:
            int r5 = r4.e;
            a<E> r14 = r4.a(r12, r9, r10, r11);
            this.g = r14;
            if (r11[0] != 0) goto L24;
            this.c++;
        L24:
            this.d += (long) r10;
            if (r14.e != r5) goto L28;
            return this;
        L28:
            return i();
        L29:
            int r15 = this.f4633b;
            r11[0] = r15;
            long r6 = r10;
            if ((((long) r15) + r6) <= 2147483647L) goto L33;
            r1 = false;
        L33:
            com.google.common.base.n.a(r1);
            this.f4633b += r10;
            this.d += r6;
            return this;
        }

        E a() {
            return (E) ao.a(this.f4632a);
        }

        int b() {
            return this.f4633b;
        }

        a<E> b(Comparator<? super E> r5, E r6, int r7, int[] r8) {
            Comparator<? super E> r9 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r5, Comparator.class, "com.obric.memorydata.plugin");
            int r0 = r9.compare(r6, a());
            if (r0 >= 0) goto L20;
            a<E> r1 = this.f;
            if (r1 != null) goto L8;
            r8[0] = 0;
            return this;
        L8:
            this.f = r1.b(r9, r6, r7, r8);
            if (r8[0] <= 0) goto L16;
            if (r7 < r8[0]) goto L13;
            this.c--;
            long r10 = this.d;
            r7 = r8[0];
        L14:
            this.d = r10 - ((long) r7);
            goto L16
        L13:
            r10 = this.d;
        L16:
            if (r8[0] != 0) goto L19;
            return this;
        L19:
            return i();
        L20:
            if (r0 <= 0) goto L34;
            a<E> r2 = this.g;
            if (r2 != null) goto L25;
            r8[0] = 0;
            return this;
        L25:
            this.g = r2.b(r9, r6, r7, r8);
            if (r8[0] <= 0) goto L33;
            if (r7 < r8[0]) goto L30;
            this.c--;
            long r11 = this.d;
            r7 = r8[0];
        L31:
            this.d = r11 - ((long) r7);
            goto L33
        L30:
            r11 = this.d;
        L33:
            return i();
        L34:
            int r12 = this.f4633b;
            r8[0] = r12;
            if (r7 >= r12) goto L37;
            this.f4633b = r12 - r7;
            this.d -= (long) r7;
            return this;
        L37:
            return e();
        }

        a<E> c(Comparator<? super E> r3, E r4, int r5, int[] r6) {
            Comparator<? super E> r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
            int r0 = r7.compare(r4, a());
            if (r0 >= 0) goto L22;
            a<E> r1 = this.f;
            if (r1 != null) goto L10;
            r6[0] = 0;
            if (r5 > 0) goto L9;
            return this;
        L9:
            return b(r4, r5);
        L10:
            this.f = r1.c(r7, r4, r5, r6);
            if (r5 == 0) goto L13;
        L16:
            if (r5 > 0) goto L18;
        L20:
            this.d += (long) (r5 - r6[0]);
            return i();
        L18:
            if (r6[0] != 0) goto L20;
            int r8 = this.c + 1;
        L15:
            this.c = r8;
            goto L20
        L13:
            if (r6[0] == 0) goto L16;
            r8 = this.c - 1;
            goto L15
        L22:
            if (r0 <= 0) goto L41;
            a<E> r2 = this.g;
            if (r2 != null) goto L29;
            r6[0] = 0;
            if (r5 > 0) goto L28;
            return this;
        L28:
            return a(r4, r5);
        L29:
            this.g = r2.c(r7, r4, r5, r6);
            if (r5 == 0) goto L32;
        L35:
            if (r5 > 0) goto L37;
        L39:
            this.d += (long) (r5 - r6[0]);
            return i();
        L37:
            if (r6[0] != 0) goto L39;
            int r9 = this.c + 1;
        L34:
            this.c = r9;
            goto L39
        L32:
            if (r6[0] == 0) goto L35;
            r9 = this.c - 1;
            goto L34
        L41:
            int r10 = this.f4633b;
            r6[0] = r10;
            if (r5 == 0) goto L44;
            this.d += (long) (r5 - r10);
            this.f4633b = r5;
            return this;
        L44:
            return e();
        }

        public String toString() {
            return Multisets.a(a(), b()).toString();
        }
    }

    private static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private T f4634a;

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        public T a() {
            return this.f4634a;
        }

        public void a(T r2, T r3) {
            if (this.f4634a != r2) goto L7;
            this.f4634a = r3;
            return;
        L7:
            throw new ConcurrentModificationException();
        }

        void b() {
            this.f4634a = null;
        }
    }

    TreeMultiset(b<a<E>> r2, GeneralRange<E> r3, a<E> r4) {
        super(r3.comparator());
        this.rootReference = r2;
        this.range = r3;
        this.header = r4;
    }

    TreeMultiset(Comparator<? super E> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        super(r4);
        this.range = GeneralRange.all(r4);
        a<E> r5 = new a();
        this.header = r5;
        successor(r5, r5);
        this.rootReference = new b(null);
    }

    static /* synthetic */ a access$1300(TreeMultiset r0) {
        return r0.firstNode();
    }

    static /* synthetic */ GeneralRange access$1400(TreeMultiset r0) {
        return r0.range;
    }

    static /* synthetic */ an.a access$1500(TreeMultiset r0, a r1) {
        return r0.wrapEntry(r1);
    }

    static /* synthetic */ a access$1600(TreeMultiset r0) {
        return r0.header;
    }

    static /* synthetic */ a access$1700(TreeMultiset r0) {
        return r0.lastNode();
    }

    static /* synthetic */ void access$1800(a r0, a r1, a r2) {
        successor(r0, r1, r2);
    }

    static /* synthetic */ void access$1900(a r0, a r1) {
        successor(r0, r1);
    }

    private long aggregateAboveRange(Aggregate r5, a<E> r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r0 = comparator().compare(ao.a(this.range.getUpperEndpoint()), r6.a());
        if (r0 > 0) goto L8;
        if (r0 != 0) goto L21;
        int r4 = AnonymousClass4.f4631a[this.range.getUpperBoundType().ordinal()];
        if (r4 != 1) goto L13;
        long r1 = r5.nodeAggregate(r6);
        long r7 = r5.treeAggregate(a.e(r6));
    L20:
        return r1 + r7;
    L13:
        if (r4 != 2) goto L17;
        return r5.treeAggregate(a.e(r6));
    L17:
        throw new AssertionError();
    L21:
        r1 = r5.treeAggregate(a.e(r6)) + ((long) r5.nodeAggregate(r6));
        r7 = aggregateAboveRange(r5, a.d(r6));
        goto L20
    L8:
        return aggregateAboveRange(r5, a.e(r6));
    }

    private long aggregateBelowRange(Aggregate r5, a<E> r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r0 = comparator().compare(ao.a(this.range.getLowerEndpoint()), r6.a());
        if (r0 < 0) goto L8;
        if (r0 != 0) goto L21;
        int r4 = AnonymousClass4.f4631a[this.range.getLowerBoundType().ordinal()];
        if (r4 != 1) goto L13;
        long r1 = r5.nodeAggregate(r6);
        long r7 = r5.treeAggregate(a.d(r6));
    L20:
        return r1 + r7;
    L13:
        if (r4 != 2) goto L17;
        return r5.treeAggregate(a.d(r6));
    L17:
        throw new AssertionError();
    L21:
        r1 = r5.treeAggregate(a.d(r6)) + ((long) r5.nodeAggregate(r6));
        r7 = aggregateBelowRange(r5, a.e(r6));
        goto L20
    L8:
        return aggregateBelowRange(r5, a.d(r6));
    }

    private long aggregateForEntries(Aggregate r6) {
        a<E> r0 = (a) ZeusTransformUtils.preCheckCast(this.rootReference.a(), a.class, "com.obric.memorydata.plugin");
        long r1 = r6.treeAggregate(r0);
        if (this.range.hasLowerBound() == false) goto L6;
        r1 = r1 - aggregateBelowRange(r6, r0);
    L6:
        if (this.range.hasUpperBound() == true) goto L8;
        return r1;
    L8:
        return r1 - aggregateAboveRange(r6, r0);
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset(Ordering.natural());
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        TreeMultiset<E> r0 = create();
        aj.a(r0, r3);
        return r0;
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> r2) {
        Comparator r3 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return new TreeMultiset(Ordering.natural());
    L6:
        return new TreeMultiset(r3);
    }

    static int distinctElements(a<?> r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return a.c(r0);
    }

    private a<E> firstNode() {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.rootReference.a(), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.range.hasLowerBound() == false) goto L15;
        Object r2 = ao.a(this.range.getLowerEndpoint());
        a<E> r1 = a.a(r0, comparator(), r2);
        if (r1 != null) goto L11;
        return null;
    L11:
        if (this.range.getLowerBoundType() != BoundType.OPEN) goto L18;
        if (comparator().compare(r2, r1.a()) != 0) goto L18;
    L16:
        r1 = a.f(r1);
    L18:
        if (r1 != this.header) goto L20;
        return null;
    L20:
        if (this.range.contains(r1.a()) == true) goto L23;
        return null;
    L23:
        return r1;
    L15:
        r1 = this.header;
        goto L16
    }

    private a<E> lastNode() {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.rootReference.a(), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.range.hasUpperBound() == false) goto L15;
        Object r2 = ao.a(this.range.getUpperEndpoint());
        a<E> r1 = a.b(r0, comparator(), r2);
        if (r1 != null) goto L11;
        return null;
    L11:
        if (this.range.getUpperBoundType() != BoundType.OPEN) goto L18;
        if (comparator().compare(r2, r1.a()) != 0) goto L18;
    L16:
        r1 = a.g(r1);
    L18:
        if (r1 != this.header) goto L20;
        return null;
    L20:
        if (this.range.contains(r1.a()) == true) goto L23;
        return null;
    L23:
        return r1;
    L15:
        r1 = this.header;
        goto L16
    }

    private void readObject(ObjectInputStream r5) {
        r5.defaultReadObject();
        Comparator r1 = (Comparator) ZeusTransformUtils.preCheckCast(r5.readObject(), Comparator.class, "com.obric.memorydata.plugin");
        av.a(h.class, "comparator").a(this, r1);
        av.a(TreeMultiset.class, "range").a(this, GeneralRange.all(r1));
        av.a(TreeMultiset.class, "rootReference").a(this, new b(null));
        a r2 = new a();
        av.a(TreeMultiset.class, "header").a(this, r2);
        successor(r2, r2);
        av.a(this, r5);
    }

    private static <T> void successor(a<T> r0, a<T> r1) {
        a.d(r0, r1);
        a.c(r1, r0);
    }

    private static <T> void successor(a<T> r0, a<T> r1, a<T> r2) {
        successor(r0, r1);
        successor(r1, r2);
    }

    private an.a<E> wrapEntry(final a<E> r2) {
        return new AnonymousClass1(this, r2);
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeObject(elementSet().comparator());
        av.a(this, r2);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public int add(E r5, int r6) {
        o.a(r6, "occurrences");
        if (r6 == 0) goto L5;
        com.google.common.base.n.a(this.range.contains(r5));
        a<E> r0 = (a) ZeusTransformUtils.preCheckCast(this.rootReference.a(), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        comparator().compare(r5, r5);
        a<E> r2 = new a(r5, r6);
        a<E> r7 = this.header;
        successor(r7, r2, r7);
        this.rootReference.a(r0, r2);
        return 0;
    L10:
        int[] r3 = new int[1];
        a<E> r8 = r0.a(comparator(), r5, r6, r3);
        this.rootReference.a(r0, r8);
        return r3[0];
    L5:
        return count(r5);
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.hasLowerBound() == false) goto L5;
    L11:
        Iterators.h(entryIterator());
        return;
    L5:
        if (this.range.hasUpperBound() == true) goto L11;
        a<E> r0 = a.f(this.header);
    L7:
        a<E> r1 = this.header;
        if (r0 == r1) goto L10;
        a<E> r2 = a.f(r0);
        a.a(r0, 0);
        a.a(r0, null);
        a.b(r0, null);
        a.c(r0, null);
        a.d(r0, null);
        r0 = r2;
        goto L7
    L10:
        successor(r1, r1);
        this.rootReference.b();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.az, com.google.common.collect.ax
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public /* bridge */ /* synthetic */ boolean contains(Object r1) {
        return super.contains(r1);
    }

    @Override // com.google.common.collect.an
    public int count(Object r5) {
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.rootReference.a(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (this.range.contains(r5) == false) goto L9;
        if (r1 == null) goto L9;
        return r1.a(comparator(), r5);
    L9:
        return 0;
    }

    @Override // com.google.common.collect.h
    Iterator<an.a<E>> descendingEntryIterator() {
        return new AnonymousClass3(this);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.az
    public /* bridge */ /* synthetic */ az descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.d
    int distinctElements() {
        return Ints.b(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.d
    Iterator<E> elementIterator() {
        return Multisets.a(entryIterator());
    }

    @Override // com.google.common.collect.h, com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.d
    Iterator<an.a<E>> entryIterator() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.az
    public /* bridge */ /* synthetic */ an.a firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.an
    public void forEachEntry(ObjIntConsumer<? super E> r4) {
        ObjIntConsumer r5 = (ObjIntConsumer) ZeusTransformUtils.wrapperContextForParams(r4, ObjIntConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        a<E> r0 = firstNode();
    L4:
        if (r0 == this.header) goto L9;
        if (r0 == null) goto L13;
        if (this.range.tooHigh(r0.a()) == true) goto L14;
        r5.accept(r0.a(), r0.b());
        r0 = a.f(r0);
        goto L4
    L14:
        return;
    L13:
        return;
    }

    @Override // com.google.common.collect.az
    public az<E> headMultiset(E r5, BoundType r6) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), r5, r6)), this.header);
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.an
    public Iterator<E> iterator() {
        return Multisets.b(this);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.az
    public /* bridge */ /* synthetic */ an.a lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.az
    public /* bridge */ /* synthetic */ an.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.az
    public /* bridge */ /* synthetic */ an.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public int remove(Object r5, int r6) {
        o.a(r6, "occurrences");
        if (r6 == 0) goto L5;
        a<E> r0 = (a) ZeusTransformUtils.preCheckCast(this.rootReference.a(), a.class, "com.obric.memorydata.plugin");
        int[] r1 = new int[1];
        if (this.range.contains(r5) == false) goto L14;
        if (r0 == null) goto L14;
        a<E> r7 = r0.b(comparator(), r5, r6, r1);     // Catch: Throwable -> L15
        this.rootReference.a(r0, r7);
        return r1[0];
    L14:
        return 0;
    L5:
        return count(r5);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public int setCount(E r6, int r7) {
        o.a(r7, CommonConsts.COUNT_TYPE);
        boolean r1 = true;
        if (this.range.contains(r6) == true) goto L9;
        if (r7 == 0) goto L7;
        r1 = false;
    L7:
        com.google.common.base.n.a(r1);
        return 0;
    L9:
        a<E> r0 = (a) ZeusTransformUtils.preCheckCast(this.rootReference.a(), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L14;
        if (r7 <= 0) goto L13;
        add(r6, r7);
    L13:
        return 0;
    L14:
        int[] r2 = new int[1];
        this.rootReference.a(r0, r0.c(comparator(), r6, r7, r2));
        return r2[0];
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public boolean setCount(E r11, int r12, int r13) {
        o.a(r13, "newCount");
        o.a(r12, "oldCount");
        com.google.common.base.n.a(this.range.contains(r11));
        a<E> r0 = (a) ZeusTransformUtils.preCheckCast(this.rootReference.a(), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        if (r12 != 0) goto L8;
        if (r13 <= 0) goto L7;
        add(r11, r13);
    L7:
        return true;
    L8:
        return false;
    L9:
        int[] r9 = new int[1];
        a<E> r14 = r0.a(comparator(), r11, r12, r13, r9);
        this.rootReference.a(r0, r14);
        if (r9[0] == r12) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public int size() {
        return Ints.b(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.h, com.google.common.collect.az
    public /* bridge */ /* synthetic */ az subMultiset(Object r1, BoundType r2, Object r3, BoundType r4) {
        return super.subMultiset(r1, r2, r3, r4);
    }

    @Override // com.google.common.collect.az
    public az<E> tailMultiset(E r5, BoundType r6) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), r5, r6)), this.header);
    }
}
