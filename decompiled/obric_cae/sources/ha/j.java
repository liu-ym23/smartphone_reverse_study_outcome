package ha;

import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c.a f7968o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final z.a f7969p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final z.b f7970q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal<Map<oa.a<?>, c0<?>>> f7971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f7972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ja.i f7973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ka.e f7974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d0> f7975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Type, l<?>> f7976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f7978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f7979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f7980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f7981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<d0> f7982l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<d0> f7983m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<y> f7984n;

    public static class a<T> extends ka.o<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0<T> f7985a;

        public a() {
            this.f7985a = null;
        }

        @Override // ha.c0
        public final T a(pa.a r8) {
            c0<T> r10 = this.f7985a;
            if (r10 == null) goto L7;
            return r10.a(r8);
        L7:
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // ha.c0
        public final void b(pa.c r8, T r10) {
            c0<T> r11 = this.f7985a;
            if (r11 == null) goto L7;
            r11.b(r8, r10);
            return;
        L7:
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // ka.o
        public final c0<T> c() {
            c0<T> r8 = this.f7985a;
            if (r8 == null) goto L6;
            return r8;
        L6:
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public final void d(c0<T> r8) {
            if (this.f7985a != null) goto L7;
            this.f7985a = r8;
            return;
        L7:
            throw new AssertionError("Delegate is already set");
        }
    }

    static {
        f7968o = c.f7964a;
        f7969p = z.f8012a;
        f7970q = z.f8013b;
    }

    public j() {
        this(ja.p.f8770p, f7968o, Collections.emptyMap(), true, false, false, true, x.f8005a, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), f7969p, f7970q, Collections.emptyList());
    }

    public static void a(double r8) {
        if (Double.isNaN(r8) == true) goto L8;
        if (Double.isInfinite(r8) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r8 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    public final <T> T b(p r8, Class<T> r10) {
        oa.a<T> r11 = oa.a.get(r10);
        if (r8 != null) goto L5;
        Object r12 = null;
    L7:
        return (T) defpackage.c.p0(r10).cast(r12);
    L5:
        r12 = e(new ka.f(r8), r11);
        goto L7
    }

    public final Object c(Class r8, String r10) {
        Object r11 = d(r10, oa.a.get(r8));
        return defpackage.c.p0(r8).cast(r11);
    }

    public final <T> T d(String r8, oa.a<T> r10) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            if (r2 != 0) goto L4
            r1 = 0
            return r1
        L4:
            java.io.StringReader r0 = new java.io.StringReader
            r0.<init>(r2)
            pa.a r2 = new pa.a
            r2.<init>(r0)
            boolean r0 = r1.f7981k
            r2.f9952b = r0
            java.lang.Object r1 = r1.e(r2, r3)
            if (r1 == 0) goto L37
            pa.b r2 = r2.h0()     // Catch: java.io.IOException -> L29 pa.d -> L30
            pa.b r3 = pa.b.f9975t     // Catch: java.io.IOException -> L29 pa.d -> L30
            if (r2 != r3) goto L21
            goto L37
        L21:
            ha.q r1 = new ha.q     // Catch: java.io.IOException -> L29 pa.d -> L30
            java.lang.String r2 = "JSON document was not fully consumed."
            r1.<init>(r2)     // Catch: java.io.IOException -> L29 pa.d -> L30
            throw r1     // Catch: java.io.IOException -> L29 pa.d -> L30
        L29:
            r1 = move-exception
            ha.q r2 = new ha.q
            r2.<init>(r1)
            throw r2
        L30:
            r1 = move-exception
            ha.q r2 = new ha.q
            r2.<init>(r1)
            throw r2
        L37:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ha.j.d(java.lang.String, oa.a):java.lang.Object");
    }

    public final <T> T e(pa.a r8, oa.a<T> r10) {
        boolean r11 = r8.f9952b;
        boolean r12 = true;
        r8.f9952b = true;
        r8.h0();     // Catch: AssertionError -> L6 IOException -> L9 Throwable -> L12 IllegalStateException -> L14 EOFException -> L17
        r12 = false;
        T r13 = f(r10).a(r8);     // Catch: AssertionError -> L6 IOException -> L9 Throwable -> L12 IllegalStateException -> L14 EOFException -> L17
        r8.f9952b = r11;
        return r13;
    L12:
        th = move-exception;
        r8.f9952b = r11;
        throw th;
    L17:
        e = move-exception;
        if (r12 == false) goto L22;
        r8.f9952b = r11;
        return null;
    L22:
        throw new q(e);     // Catch: Throwable -> L12
    L14:
        e = move-exception;
        throw new q(e);     // Catch: Throwable -> L12
    L9:
        e = move-exception;
        throw new q(e);     // Catch: Throwable -> L12
    L6:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L12
    }

    public final <T> c0<T> f(oa.a<T> r10) {
        Objects.requireNonNull(r10, "type must not be null");
        ConcurrentHashMap r8 = this.f7972b;
        c0<T> r11 = (c0) r8.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        ThreadLocal<Map<oa.a<?>, c0<?>>> r12 = this.f7971a;
        Map r13 = r12.get();
        if (r13 != null) goto L8;
        r13 = new HashMap();
        r12.set((Map<oa.a<?>, c0<?>>) r13);
        boolean r14 = true;
    L30:
        a r15 = new a();     // Catch: Throwable -> L26
        r13.put(r10, r15);     // Catch: Throwable -> L26
        Iterator<d0> r16 = this.f7975e.iterator();     // Catch: Throwable -> L26
        c0<T> r17 = null;
    L14:
        if (r16.hasNext() == false) goto L18;
        r17 = r16.next().a(this, r10);     // Catch: Throwable -> L26
        if (r17 == null) goto L14;
        r15.d(r17);     // Catch: Throwable -> L26
        r13.put(r10, r17);     // Catch: Throwable -> L26
    L18:
        if (r14 == false) goto L20;
        r12.remove();
    L20:
        if (r17 == null) goto L25;
        if (r14 == false) goto L23;
        r8.putAll(r13);
    L23:
        return r17;
    L25:
        throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + r10);
    L26:
        th = move-exception;
        if (r14 == false) goto L29;
        r12.remove();
    L29:
        throw th;
    L8:
        c0<T> r18 = (c0) r13.get(r10);
        if (r18 == null) goto L11;
        return r18;
    L11:
        r14 = false;
        goto L30
    }

    public final <T> c0<T> g(d0 r8, oa.a<T> r10) {
        List<d0> r11 = this.f7975e;
        if (r11.contains(r8) == true) goto L5;
        r8 = this.f7974d;
    L5:
        Iterator<d0> r12 = r11.iterator();
        boolean r13 = false;
    L7:
        if (r12.hasNext() == false) goto L16;
        d0 r14 = r12.next();
        if (r13 == false) goto L10;
        c0<T> r15 = r14.a(this, r10);
        if (r15 == null) goto L7;
        return r15;
    L10:
        if (r14 != r8) goto L7;
        r13 = true;
        goto L7
    L16:
        throw new IllegalArgumentException("GSON cannot serialize " + r10);
    }

    public final pa.c h(Writer r8) {
        if (this.f7978h == false) goto L5;
        r8.write(")]}'\n");
    L5:
        pa.c r10 = new pa.c(r8);
        if (this.f7980j == false) goto L8;
        r10.f9983n = "  ";
        r10.f9984o = ": ";
    L8:
        r10.f9986q = this.f7979i;
        r10.f9985p = this.f7981k;
        r10.f9988s = this.f7977g;
        return r10;
    }

    public final String i(p r8) {
        StringWriter r10 = new StringWriter();
        k(r8, h(r10));     // Catch: IOException -> L6
        return r10.toString();
    L6:
        e = move-exception;
        throw new q(e);
    }

    public final String j(Object r8) {
        if (r8 == null) goto L4;
        Type r10 = r8.getClass();
        StringWriter r11 = new StringWriter();
        l(r8, r10, h(r11));     // Catch: IOException -> L9
        return r11.toString();
    L9:
        e = move-exception;
        throw new q(e);
    L4:
        return i(r.f8002a);
    }

    public final void k(p r8, pa.c r10) {
        boolean r11 = r10.f9985p;
        r10.f9985p = true;
        boolean r12 = r10.f9986q;
        r10.f9986q = this.f7979i;
        boolean r13 = r10.f9988s;
        r10.f9988s = this.f7977g;
        ka.r.f9079z.b(r10, r8);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L10
        r10.f9985p = r11;
        r10.f9986q = r12;
        r10.f9988s = r13;
        return;
    L6:
        th = move-exception;
        r10.f9985p = r11;
        r10.f9986q = r12;
        r10.f9988s = r13;
        throw th;
    L10:
        e = move-exception;
        throw new q(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public final void l(Object r8, Type r10, pa.c r11) {
        c0 r12 = f(oa.a.get(r10));
        boolean r13 = r11.f9985p;
        r11.f9985p = true;
        boolean r14 = r11.f9986q;
        r11.f9986q = this.f7979i;
        boolean r15 = r11.f9988s;
        r11.f9988s = this.f7977g;
        r12.b(r11, r8);     // Catch: AssertionError -> L6 IOException -> L9 Throwable -> L12
        r11.f9985p = r13;
        r11.f9986q = r14;
        r11.f9988s = r15;
        return;
    L12:
        th = move-exception;
        r11.f9985p = r13;
        r11.f9986q = r14;
        r11.f9988s = r15;
        throw th;
    L9:
        e = move-exception;
        throw new q(e);     // Catch: Throwable -> L12
    L6:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L12
    }

    public final String toString() {
        return "{serializeNulls:" + this.f7977g + ",factories:" + this.f7975e + ",instanceCreators:" + this.f7973c + "}";
    }

    public j(ja.p r8, c.a r10, Map r11, boolean r12, boolean r13, boolean r14, boolean r15, x.a r16, List r17, List r18, List r19, z.a r110, z.b r111, List r112) {
        this.f7971a = new ThreadLocal();
        this.f7972b = new ConcurrentHashMap();
        this.f7976f = r11;
        ja.i r20 = new ja.i(r15, r112, r11);
        this.f7973c = r20;
        this.f7977g = false;
        this.f7978h = false;
        this.f7979i = r12;
        this.f7980j = r13;
        this.f7981k = r14;
        this.f7982l = r17;
        this.f7983m = r18;
        this.f7984n = r112;
        ArrayList r113 = new ArrayList();
        r113.add(ka.r.A);
        ka.k r21 = ka.l.f9011c;
        if (r110 != z.f8012a) goto L5;
        ka.k r22 = ka.l.f9011c;
    L6:
        r113.add(r22);
        r113.add(r8);
        r113.addAll(r19);
        r113.add(ka.r.f9069p);
        r113.add(ka.r.f9060g);
        r113.add(ka.r.f9057d);
        r113.add(ka.r.f9058e);
        r113.add(ka.r.f9059f);
        if (r16 != x.f8005a) goto L9;
        c0 r23 = ka.r.f9064k;
    L10:
        r113.add(new ka.t(Long.TYPE, Long.class, r23));
        r113.add(new ka.t(Double.TYPE, Double.class, new e()));
        r113.add(new ka.t(Float.TYPE, Float.class, new f()));
        ka.i r24 = ka.j.f9008b;
        if (r111 != z.f8013b) goto L13;
        ka.i r25 = ka.j.f9008b;
    L14:
        r113.add(r25);
        r113.add(ka.r.f9061h);
        r113.add(ka.r.f9062i);
        r113.add(new ka.s(AtomicLong.class, new b0(new h(r23))));
        r113.add(new ka.s(AtomicLongArray.class, new b0(new i(r23))));
        r113.add(ka.r.f9063j);
        r113.add(ka.r.f9065l);
        r113.add(ka.r.f9070q);
        r113.add(ka.r.f9071r);
        r113.add(new ka.s(BigDecimal.class, ka.r.f9066m));
        r113.add(new ka.s(BigInteger.class, ka.r.f9067n));
        r113.add(new ka.s(ja.r.class, ka.r.f9068o));
        r113.add(ka.r.f9072s);
        r113.add(ka.r.f9073t);
        r113.add(ka.r.f9075v);
        r113.add(ka.r.f9076w);
        r113.add(ka.r.f9078y);
        r113.add(ka.r.f9074u);
        r113.add(ka.r.f9055b);
        r113.add(ka.c.f8989b);
        r113.add(ka.r.f9077x);
        if (na.d.f9481a == false) goto L17;
        r113.add(na.d.f9485e);
        r113.add(na.d.f9484d);
        r113.add(na.d.f9486f);
    L17:
        r113.add(ka.a.f8983c);
        r113.add(ka.r.f9054a);
        r113.add(new ka.b(r20));
        r113.add(new ka.h(r20));
        ka.e r26 = new ka.e(r20);
        this.f7974d = r26;
        r113.add(r26);
        r113.add(ka.r.B);
        r113.add(new ka.n(r20, r10, r8, r26, r112));
        this.f7975e = Collections.unmodifiableList(r113);
        return;
    L13:
        r25 = new ka.i(new ka.j(r111));
        goto L14
    L9:
        r23 = new g();
        goto L10
    L5:
        r22 = new ka.k(r110);
        goto L6
    }
}
