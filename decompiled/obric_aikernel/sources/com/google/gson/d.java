package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
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
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final String f4192o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final com.google.gson.c f4193p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final p f4194q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final p f4195r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadLocal<Map<TypeToken<?>, q<?>>> f4196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<TypeToken<?>, q<?>> f4197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.gson.internal.b f4198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e6.e f4199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<r> f4200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Map<Type, com.google.gson.e<?>> f4201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f4202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f4203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f4204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f4205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f4206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final List<r> f4207l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final List<r> f4208m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final List<ReflectionAccessFilter> f4209n;

    class a extends q<Number> {
        a(d r10) {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Number b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Number r11) {
            f(r10, r11);
        }

        public Double e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            return Double.valueOf(r10.D());
        }

        public void f(com.google.gson.stream.a r10, Number r11) {
            if (r11 != null) goto L5;
            r10.B();
            return;
        L5:
            double r12 = r11.doubleValue();
            d.d(r12);
            r10.P(r12);
        }
    }

    class b extends q<Number> {
        b(d r10) {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Number b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Number r11) {
            f(r10, r11);
        }

        public Float e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            return Float.valueOf((float) r10.D());
        }

        public void f(com.google.gson.stream.a r10, Number r11) {
            if (r11 != null) goto L5;
            r10.B();
            return;
        L5:
            float r12 = r11.floatValue();
            d.d(r12);
            if ((r11 instanceof Float) == true) goto L9;
            r11 = Float.valueOf(r12);
        L9:
            r10.X(r11);
        }
    }

    class c extends q<Number> {
        c() {
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Number b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Number r11) {
            f(r10, r11);
        }

        public Number e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            return Long.valueOf(r10.G());
        }

        public void f(com.google.gson.stream.a r10, Number r11) {
            if (r11 != null) goto L5;
            r10.B();
            return;
        L5:
            r10.a0(r11.toString());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.d$d, reason: collision with other inner class name */
    class C0090d extends q<AtomicLong> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f4210a;

        C0090d(q r10) {
            this.f4210a = r10;
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ AtomicLong b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, AtomicLong r11) {
            f(r10, r11);
        }

        public AtomicLong e(i6.a r10) {
            return new AtomicLong(((Number) this.f4210a.b(r10)).longValue());
        }

        public void f(com.google.gson.stream.a r10, AtomicLong r11) {
            this.f4210a.d(r10, Long.valueOf(r11.get()));
        }
    }

    class e extends q<AtomicLongArray> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f4211a;

        e(q r10) {
            this.f4211a = r10;
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ AtomicLongArray b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, AtomicLongArray r11) {
            f(r10, r11);
        }

        public AtomicLongArray e(i6.a r10) {
            ArrayList r11 = new ArrayList();
            r10.a();
        L4:
            if (r10.u() == false) goto L6;
            r11.add(Long.valueOf(((Number) this.f4211a.b(r10)).longValue()));
            goto L4
        L6:
            r10.l();
            int r12 = r11.size();
            AtomicLongArray r13 = new AtomicLongArray(r12);
            int r14 = 0;
        L7:
            if (r14 >= r12) goto L9;
            r13.set(r14, ((Long) r11.get(r14)).longValue());
            r14 = r14 + 1;
            goto L7
        L9:
            return r13;
        }

        public void f(com.google.gson.stream.a r10, AtomicLongArray r11) {
            r10.f();
            int r12 = r11.length();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            this.f4211a.d(r10, Long.valueOf(r11.get(r13)));
            r13 = r13 + 1;
            goto L3
        L5:
            r10.l();
        }
    }

    static class f<T> extends e6.l<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private q<T> f4212a;

        f() {
            this.f4212a = null;
        }

        private q<T> f() {
            q<T> r10 = this.f4212a;
            if (r10 == null) goto L6;
            return r10;
        L6:
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.q
        public T b(i6.a r10) {
            return f().b(r10);
        }

        @Override // com.google.gson.q
        public void d(com.google.gson.stream.a r10, T r11) {
            f().d(r10, r11);
        }

        @Override // e6.l
        public q<T> e() {
            return f();
        }

        public void g(q<T> r10) {
            if (this.f4212a != null) goto L7;
            this.f4212a = r10;
            return;
        L7:
            throw new AssertionError("Delegate is already set");
        }
    }

    static {
        f4193p = FieldNamingPolicy.IDENTITY;
        f4194q = ToNumberPolicy.DOUBLE;
        f4195r = ToNumberPolicy.LAZILY_PARSED_NUMBER;
    }

    public d() {
        this(com.google.gson.internal.c.f4246l, f4193p, Collections.emptyMap(), false, false, false, true, false, false, false, true, LongSerializationPolicy.DEFAULT, f4192o, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), f4194q, f4195r, Collections.emptyList());
    }

    d(com.google.gson.internal.c r11, com.google.gson.c r12, Map<Type, com.google.gson.e<?>> r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, LongSerializationPolicy r22, String r23, int r24, int r25, List<r> r26, List<r> r27, List<r> r28, p r29, p r30, List<ReflectionAccessFilter> r31) {
        this.f4196a = new ThreadLocal();
        this.f4197b = new ConcurrentHashMap();
        this.f4201f = r13;
        com.google.gson.internal.b r10 = new com.google.gson.internal.b(r13, r21, r31);
        this.f4198c = r10;
        this.f4202g = r14;
        this.f4203h = r16;
        this.f4204i = r17;
        this.f4205j = r18;
        this.f4206k = r19;
        this.f4207l = r26;
        this.f4208m = r27;
        this.f4209n = r31;
        ArrayList r32 = new ArrayList();
        r32.add(e6.o.W);
        r32.add(e6.j.e(r29));
        r32.add(r11);
        r32.addAll(r28);
        r32.add(e6.o.C);
        r32.add(e6.o.f8721m);
        r32.add(e6.o.f8715g);
        r32.add(e6.o.f8717i);
        r32.add(e6.o.f8719k);
        q<Number> r33 = p(r22);
        r32.add(e6.o.b(Long.TYPE, Long.class, r33));
        r32.add(e6.o.b(Double.TYPE, Double.class, e(r20)));
        r32.add(e6.o.b(Float.TYPE, Float.class, f(r20)));
        r32.add(e6.i.e(r30));
        r32.add(e6.o.f8723o);
        r32.add(e6.o.f8725q);
        r32.add(e6.o.a(AtomicLong.class, b(r33)));
        r32.add(e6.o.a(AtomicLongArray.class, c(r33)));
        r32.add(e6.o.f8727s);
        r32.add(e6.o.f8732x);
        r32.add(e6.o.E);
        r32.add(e6.o.G);
        r32.add(e6.o.a(BigDecimal.class, e6.o.f8734z));
        r32.add(e6.o.a(BigInteger.class, e6.o.A));
        r32.add(e6.o.a(LazilyParsedNumber.class, e6.o.B));
        r32.add(e6.o.I);
        r32.add(e6.o.K);
        r32.add(e6.o.O);
        r32.add(e6.o.Q);
        r32.add(e6.o.U);
        r32.add(e6.o.M);
        r32.add(e6.o.f8712d);
        r32.add(e6.c.f8644b);
        r32.add(e6.o.S);
        if (h6.d.f9190a == false) goto L5;
        r32.add(h6.d.f9192c);
        r32.add(h6.d.f9191b);
        r32.add(h6.d.f9193d);
    L5:
        r32.add(e6.a.f8638c);
        r32.add(e6.o.f8710b);
        r32.add(new e6.b(r10));
        r32.add(new e6.h(r10, r15));
        e6.e r34 = new e6.e(r10);
        this.f4199d = r34;
        r32.add(r34);
        r32.add(e6.o.X);
        r32.add(new e6.k(r10, r12, r11, r34, r31));
        this.f4200e = Collections.unmodifiableList(r32);
    }

    private static void a(Object r10, i6.a r11) {
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
            if (r0 == 0) goto L21
            com.google.gson.stream.JsonToken r0 = r1.Q()     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            if (r0 != r1) goto Lb
            goto L21
        Lb:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            java.lang.String r1 = "JSON document was not fully consumed."
            r0.<init>(r1)     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            throw r0     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
        L13:
            r0 = move-exception
            com.google.gson.JsonIOException r1 = new com.google.gson.JsonIOException
            r1.<init>(r0)
            throw r1
        L1a:
            r0 = move-exception
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException
            r1.<init>(r0)
            throw r1
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.d.a(java.lang.Object, i6.a):void");
    }

    private static q<AtomicLong> b(q<Number> r10) {
        return new C0090d(r10).a();
    }

    private static q<AtomicLongArray> c(q<Number> r10) {
        return new e(r10).a();
    }

    static void d(double r10) {
        if (Double.isNaN(r10) == true) goto L8;
        if (Double.isInfinite(r10) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    private q<Number> e(boolean r10) {
        if (r10 == false) goto L6;
        return e6.o.f8730v;
    L6:
        return new a(this);
    }

    private q<Number> f(boolean r10) {
        if (r10 == false) goto L6;
        return e6.o.f8729u;
    L6:
        return new b(this);
    }

    private static q<Number> p(LongSerializationPolicy r10) {
        if (r10 != LongSerializationPolicy.DEFAULT) goto L7;
        return e6.o.f8728t;
    L7:
        return new c();
    }

    public i A(Object r10, Type r11) {
        e6.g r12 = new e6.g();
        x(r10, r11, r12);
        return r12.e0();
    }

    public <T> T g(i6.a r10, TypeToken<T> r11) {
        boolean r12 = r10.v();
        boolean r13 = true;
        r10.d0(true);
        r10.Q();     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11 IllegalStateException -> L14 EOFException -> L17
        r13 = false;
        T r14 = m(r11).b(r10);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11 IllegalStateException -> L14 EOFException -> L17
        r10.d0(r12);
        return r14;
    L6:
        th = move-exception;
        r10.d0(r12);
        throw th;
    L17:
        e = move-exception;
        if (r13 == false) goto L22;
        r10.d0(r12);
        return null;
    L22:
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L14:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    }

    public <T> T h(Reader r10, TypeToken<T> r11) {
        i6.a r12 = q(r10);
        T r13 = (T) g(r12, r11);
        a(r13, r12);
        return r13;
    }

    public <T> T i(Reader r10, Class<T> r11) {
        Object r12 = h(r10, TypeToken.get(r11));
        return (T) com.google.gson.internal.h.b(r11).cast(r12);
    }

    public <T> T j(String r10, TypeToken<T> r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return (T) h(new StringReader(r10), r11);
    }

    public <T> T k(String r10, Class<T> r11) {
        Object r12 = j(r10, TypeToken.get(r11));
        return (T) com.google.gson.internal.h.b(r11).cast(r12);
    }

    public <T> T l(String r10, Type r11) {
        return (T) j(r10, TypeToken.get(r11));
    }

    public <T> q<T> m(TypeToken<T> r10) {
        Objects.requireNonNull(r10, "type must not be null");
        q<T> r11 = (q) this.f4197b.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        Map<? extends TypeToken<?>, ? extends q<?>> r12 = this.f4196a.get();
        boolean r13 = false;
        if (r12 != null) goto L8;
        r12 = new HashMap();
        this.f4196a.set((Map<TypeToken<?>, q<?>>) r12);
        r13 = true;
    L11:
        q<T> r14 = null;
        f r15 = new f();     // Catch: Throwable -> L26
        r12.put(r10, r15);     // Catch: Throwable -> L26
        Iterator<r> r16 = this.f4200e.iterator();     // Catch: Throwable -> L26
    L14:
        if (r16.hasNext() == false) goto L18;
        r14 = r16.next().b(this, r10);     // Catch: Throwable -> L26
        if (r14 == null) goto L14;
        r15.g(r14);     // Catch: Throwable -> L26
        r12.put(r10, r14);     // Catch: Throwable -> L26
    L18:
        if (r13 == false) goto L20;
        this.f4196a.remove();
    L20:
        if (r14 == null) goto L25;
        if (r13 == false) goto L23;
        this.f4197b.putAll(r12);
    L23:
        return r14;
    L25:
        throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + r10);
    L26:
        th = move-exception;
        if (r13 == false) goto L29;
        this.f4196a.remove();
    L29:
        throw th;
    L8:
        q<T> r17 = (q) r12.get(r10);
        if (r17 == null) goto L11;
        return r17;
    }

    public <T> q<T> n(Class<T> r10) {
        return m(TypeToken.get(r10));
    }

    public <T> q<T> o(r r10, TypeToken<T> r11) {
        if (this.f4200e.contains(r10) == true) goto L5;
        r10 = this.f4199d;
    L5:
        boolean r12 = false;
        Iterator<r> r13 = this.f4200e.iterator();
    L7:
        if (r13.hasNext() == false) goto L16;
        r r14 = r13.next();
        if (r12 == false) goto L10;
        q<T> r15 = r14.b(this, r11);
        if (r15 == null) goto L7;
        return r15;
    L10:
        if (r14 != r10) goto L7;
        r12 = true;
        goto L7
    L16:
        throw new IllegalArgumentException("GSON cannot serialize " + r11);
    }

    public i6.a q(Reader r10) {
        i6.a r11 = new i6.a(r10);
        r11.d0(this.f4206k);
        return r11;
    }

    public com.google.gson.stream.a r(Writer r10) {
        if (this.f4203h == false) goto L5;
        r10.write(")]}'\n");
    L5:
        com.google.gson.stream.a r11 = new com.google.gson.stream.a(r10);
        if (this.f4205j == false) goto L8;
        r11.J("  ");
    L8:
        r11.I(this.f4204i);
        r11.K(this.f4206k);
        r11.M(this.f4202g);
        return r11;
    }

    public String s(i r10) {
        StringWriter r11 = new StringWriter();
        w(r10, r11);
        return r11.toString();
    }

    public String t(Object r10) {
        if (r10 != null) goto L6;
        return s(j.f4273a);
    L6:
        return u(r10, r10.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.f4202g + ",factories:" + this.f4200e + ",instanceCreators:" + this.f4198c + "}";
    }

    public String u(Object r10, Type r11) {
        StringWriter r12 = new StringWriter();
        y(r10, r11, r12);
        return r12.toString();
    }

    public void v(i r10, com.google.gson.stream.a r11) {
        boolean r12 = r11.s();
        r11.K(true);
        boolean r13 = r11.r();
        r11.I(this.f4204i);
        boolean r14 = r11.p();
        r11.M(this.f4202g);
        com.google.gson.internal.j.b(r10, r11);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r11.K(r12);
        r11.I(r13);
        r11.M(r14);
        return;
    L6:
        th = move-exception;
        r11.K(r12);
        r11.I(r13);
        r11.M(r14);
        throw th;
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public void w(i r10, Appendable r11) {
        v(r10, r(com.google.gson.internal.j.c(r11)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public void x(Object r10, Type r11, com.google.gson.stream.a r12) {
        q r13 = m(TypeToken.get(r11));
        boolean r14 = r12.s();
        r12.K(true);
        boolean r15 = r12.r();
        r12.I(this.f4204i);
        boolean r16 = r12.p();
        r12.M(this.f4202g);
        r13.d(r12, r10);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r12.K(r14);
        r12.I(r15);
        r12.M(r16);
        return;
    L6:
        th = move-exception;
        r12.K(r14);
        r12.I(r15);
        r12.M(r16);
        throw th;
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public void y(Object r10, Type r11, Appendable r12) {
        x(r10, r11, r(com.google.gson.internal.j.c(r12)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public i z(Object r10) {
        if (r10 != null) goto L6;
        return j.f4273a;
    L6:
        return A(r10, r10.getClass());
    }
}
