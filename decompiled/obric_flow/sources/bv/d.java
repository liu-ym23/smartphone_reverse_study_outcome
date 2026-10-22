package bv;

import av.f;
import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.sqlite.SQLiteErrorCode;
import org.sqlite.SQLiteException;
import org.sqlite.core.NativeDB;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f1022c;
    public final AtomicBoolean d;
    public long e;
    public long f;
    public final HashMap g;

    public d(String r5, String r10, f r11) {
        this.d = new AtomicBoolean(true);
        this.e = 0;
        this.f = 0;
        this.g = new HashMap();
        new HashSet();
        new HashSet();
        this.f1020a = r5;
        this.f1021b = r10;
        this.f1022c = r11;
    }

    public static SQLiteException j(int r5, String r10) {
        SQLiteErrorCode r11 = SQLiteErrorCode.getErrorCode(r5);
        return new SQLiteException(r11 + " (" + r10 + ")", r11);
    }

    public abstract String a(int r5, long r10);

    public final synchronized String[] b(long r5) {
        monitor-enter(this);
        int r10 = column_count(r5);     // Catch: Throwable -> L7
        String[] r11 = new String[r10];     // Catch: Throwable -> L7
        int r12 = 0;
    L4:
        if (r12 >= r10) goto L9;
        r11[r12] = a(r12, r5);     // Catch: Throwable -> L7
        r12 = r12 + 1;
        goto L4
    L9:
        monitor-exit(this);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public abstract int bind_blob(long r5, int r10, byte[] r11);

    public abstract int bind_double(long r5, int r10, double r11);

    public abstract int bind_int(long r5, int r10, int r11);

    public abstract int bind_long(long r5, int r10, long r11);

    public abstract int bind_null(long r5, int r10);

    public abstract int bind_parameter_count(long r5);

    public final void c(boolean r5) {
        if (r5 == true) goto L5;
        return;
    L5:
        if (this.e != 0) goto L8;
        this.e = k("begin;");
    L8:
        if (this.f != 0) goto L24;
        this.f = k("commit;");
    L24:
    L21:
        th = move-exception;
        reset(this.e);
        reset(this.f);
        throw th;
    L12:
        if (step(this.e) == 101) goto L15;
        reset(this.e);
        reset(this.f);
        return;
    L15:
        int r10 = step(this.f);     // Catch: Throwable -> L21
        if (r10 != 101) goto L19;
        reset(this.e);
        reset(this.f);
        return;
    L19:
        reset(this.f);     // Catch: Throwable -> L21
        throw i(r10);     // Catch: Throwable -> L21
    }

    public abstract int changes();

    public abstract int column_count(long r5);

    public final synchronized void d(String r5, boolean r10) {
        monitor-enter(this);
        long r11 = k(r5);     // Catch: Throwable -> L21
        int r12 = step(r11);     // Catch: Throwable -> L14
        if (r12 != 100) goto L7;
        finalize(r11);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L7:
        if (r12 != 101) goto L17;
        c(r10);     // Catch: Throwable -> L14
        finalize(r11);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L17:
        throw i(r12);     // Catch: Throwable -> L14
    L14:
        th = th;
    L23:
        finalize(r11);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L21:
        th = th;
        r11 = 0;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean e(dv.f r10, Object[] r11) {
        monitor-enter(this);
        if (r11 != null) goto L43;
    L19:
        int r12 = step(r10.f16721c);     // Catch: Throwable -> L15
        int r5 = r12 & 255;     // Catch: Throwable -> L15
        if (r5 == 5) goto L40;
        if (r5 == 6) goto L40;
        if (r5 == 19) goto L40;
        if (r5 == 21) goto L40;
        if (r5 != 100) goto L30;
        monitor-exit(this);
        return true;
    L30:
        if (r5 != 101) goto L34;
        reset(r10.f16721c);     // Catch: Throwable -> L15
        c(r10.f16719a.getAutoCommit());     // Catch: Throwable -> L15
        monitor-exit(this);
        return false;
    L34:
        h(r10);     // Catch: Throwable -> L15
        throw i(r12);     // Catch: Throwable -> L15
    L40:
        throw i(r12);     // Catch: Throwable -> L15
    L43:
        int r13 = bind_parameter_count(r10.f16721c);     // Catch: Throwable -> L15
        if (r13 > r11.length) goto L18;
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L19;
        int r15 = m(r14, r10.f16721c, r11[r14]);     // Catch: Throwable -> L15
        if (r15 != 0) goto L14;
        r14 = r14 + 1;     // Catch: Throwable -> L15
        goto L9
    L14:
        throw i(r15);     // Catch: Throwable -> L15
    L18:
        throw new SQLException("assertion failure: param count (" + r13 + ") > value count (" + r11.length + ")");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized int[] f(long r10, int r11, Object[] r12, boolean r13) {
        monitor-enter(this);
        if (r11 < 1) goto L36;
        int r5 = bind_parameter_count(r10);     // Catch: Throwable -> L30
        int[] r14 = new int[r11];     // Catch: Throwable -> L30
        int r15 = 0;
    L8:
        if (r15 >= r11) goto L32;
        reset(r10);     // Catch: Throwable -> L16
        int r16 = 0;
    L10:
        if (r16 >= r5) goto L18;
        int r17 = m(r16, r10, r12[(r15 * r5) + r16]);     // Catch: Throwable -> L16
        if (r17 != 0) goto L15;
        r16 = r16 + 1;     // Catch: Throwable -> L16
        goto L10
    L15:
        throw i(r17);     // Catch: Throwable -> L16
    L18:
        int r18 = step(r10);     // Catch: Throwable -> L16
        if (r18 != 101) goto L20;
        r14[r15] = changes();     // Catch: Throwable -> L16
        r15 = r15 + 1;
        goto L8
    L20:
        reset(r10);     // Catch: Throwable -> L16
        if (r18 != 100) goto L25;
        throw new BatchUpdateException("batch entry " + r15 + ": query returns results", r14);     // Catch: Throwable -> L16
    L25:
        throw i(r18);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        c(r13);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L32:
        c(r13);     // Catch: Throwable -> L30
        reset(r10);     // Catch: Throwable -> L30
        monitor-exit(this);
        return r14;
    L36:
        throw new SQLException("count (" + r11 + ") < 1");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public abstract int finalize(long r5);

    public final synchronized int g(dv.f r5, Object[] r10) {
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
            monitor-enter(r4)
            r0 = 0
            boolean r6 = r4.e(r5, r6)     // Catch: java.lang.Throwable -> L23
            if (r6 != 0) goto L1b
            long r5 = r5.f16721c     // Catch: java.lang.Throwable -> L13
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 == 0) goto L15
            r4.reset(r5)     // Catch: java.lang.Throwable -> L13
            goto L15
        L13:
            r5 = move-exception
            goto L2e
        L15:
            int r5 = r4.changes()     // Catch: java.lang.Throwable -> L13
            monitor-exit(r4)
            return r5
        L1b:
            java.sql.SQLException r6 = new java.sql.SQLException     // Catch: java.lang.Throwable -> L23
            java.lang.String r2 = "query returns results"
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L23
            throw r6     // Catch: java.lang.Throwable -> L23
        L23:
            r6 = move-exception
            long r2 = r5.f16721c     // Catch: java.lang.Throwable -> L13
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 == 0) goto L2d
            r4.reset(r2)     // Catch: java.lang.Throwable -> L13
        L2d:
            throw r6     // Catch: java.lang.Throwable -> L13
        L2e:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L13
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bv.d.g(dv.f, java.lang.Object[]):int");
    }

    public final synchronized int h(dv.f r10) {
        monitor-enter(this);
        long r5 = r10.f16721c;     // Catch: Throwable -> L13
        if (r5 != 0) goto L21;
        monitor-exit(this);
        return 0;
    L21:
        int r11 = finalize(r5);     // Catch: Throwable -> L15
        this.g.remove(new Long(r10.f16721c));     // Catch: Throwable -> L13
        r10.f16721c = 0;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r11;
    L15:
        th = move-exception;
        this.g.remove(new Long(r10.f16721c));     // Catch: Throwable -> L13
        r10.f16721c = 0;     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final SQLiteException i(int r5) {
        NativeDB r10 = (NativeDB) this;
        monitor-enter(r10);
        String r11 = NativeDB.p(r10.errmsg_utf8());     // Catch: Throwable -> L8
        monitor-exit(r10);
        return j(r5, r11);
    L8:
        th = move-exception;
        throw th;
    }

    public abstract long k(String r5);

    public final synchronized void l(dv.f r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (r5.d == null) goto L14;
        if (r5.f16721c == 0) goto L10;
        h(r5);     // Catch: Throwable -> L8
    L10:
        long r10 = k(r5.d);     // Catch: Throwable -> L8
        r5.f16721c = r10;     // Catch: Throwable -> L8
        this.g.put(new Long(r10), r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L14:
        throw new NullPointerException();     // Catch: Throwable -> L8
    }

    public final synchronized int m(int r10, long r11, Object r12) {
        monitor-enter(this);
        int r5 = r10 + 1;
        if (r12 != null) goto L12;
        int r13 = bind_null(r11, r5);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r13;
    L12:
        if ((r12 instanceof Integer) == false) goto L17;
        int r14 = bind_int(r11, r5, ((Integer) r12).intValue());     // Catch: Throwable -> L9
        monitor-exit(this);
        return r14;
    L17:
        if ((r12 instanceof Short) == false) goto L22;
        int r15 = bind_int(r11, r5, ((Short) r12).intValue());     // Catch: Throwable -> L9
        monitor-exit(this);
        return r15;
    L22:
        if ((r12 instanceof Long) == false) goto L27;
        int r16 = bind_long(r11, r5, ((Long) r12).longValue());     // Catch: Throwable -> L9
        monitor-exit(this);
        return r16;
    L27:
        if ((r12 instanceof Float) == false) goto L32;
        int r17 = bind_double(r11, r5, ((Float) r12).doubleValue());     // Catch: Throwable -> L9
        monitor-exit(this);
        return r17;
    L32:
        if ((r12 instanceof Double) == false) goto L37;
        int r18 = bind_double(r11, r5, ((Double) r12).doubleValue());     // Catch: Throwable -> L9
        monitor-exit(this);
        return r18;
    L37:
        if ((r12 instanceof String) == false) goto L48;
        String r19 = (String) r12;     // Catch: Throwable -> L9
        NativeDB r20 = (NativeDB) this;     // Catch: Throwable -> L9
        monitor-enter(r20);     // Catch: Throwable -> L9
        int r21 = r20.bind_text_utf8(r11, r5, NativeDB.o(r19));     // Catch: Throwable -> L44
        monitor-exit(r20);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r21;
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L48:
        if ((r12 instanceof byte[]) == false) goto L53;
        int r22 = bind_blob(r11, r5, (byte[]) r12);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r22;
    L53:
        throw new SQLException("unexpected param type: " + r12.getClass());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public abstract int reset(long r5);

    public abstract int step(long r5);
}
