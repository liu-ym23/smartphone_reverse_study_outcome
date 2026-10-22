package com.google.crypto.tink.shaded.protobuf;

import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class bx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long f5008a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final boolean f5009b = false;
    private static final Unsafe c = null;
    private static final Class<?> d = null;
    private static final boolean e = false;
    private static final boolean f = false;
    private static final d g = null;
    private static final boolean h = false;
    private static final boolean i = false;
    private static final long j = 0;
    private static final long k = 0;
    private static final long l = 0;
    private static final long m = 0;
    private static final long n = 0;
    private static final long o = 0;
    private static final long p = 0;
    private static final long q = 0;
    private static final long r = 0;
    private static final long s = 0;
    private static final long t = 0;
    private static final long u = 0;
    private static final long v = 0;
    private static final int w = 0;

    private static final class a extends d {
        a(Unsafe r3) {
            super((Unsafe) ZeusTransformUtils.wrapperContextForParams(r3, Unsafe.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public byte a(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public byte a(Object r1, long r2) {
            if (bx.f5009b == false) goto L7;
            return bx.g(r1, r2);
        L7:
            return bx.h(r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(long r1, byte[] r3, long r4, long r6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r1, long r2, byte r4) {
            if (bx.f5009b == false) goto L5;
            bx.a(r1, r2, r4);
            return;
        L5:
            bx.b(r1, r2, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r7, long r8, double r10) {
            a(r7, r8, Double.doubleToLongBits(r10));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r1, long r2, float r4) {
            a(r1, r2, Float.floatToIntBits(r4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r1, long r2, boolean r4) {
            if (bx.f5009b == false) goto L5;
            bx.b(r1, r2, r4);
            return;
        L5:
            bx.c(r1, r2, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public boolean a() {
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public long b(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public boolean b(Object r1, long r2) {
            if (bx.f5009b == false) goto L7;
            return bx.i(r1, r2);
        L7:
            return bx.j(r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public float c(Object r1, long r2) {
            return Float.intBitsToFloat(e(r1, r2));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public double d(Object r1, long r2) {
            return Double.longBitsToDouble(f(r1, r2));
        }
    }

    private static final class b extends d {
        b(Unsafe r3) {
            super((Unsafe) ZeusTransformUtils.wrapperContextForParams(r3, Unsafe.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public byte a(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public byte a(Object r1, long r2) {
            if (bx.f5009b == false) goto L7;
            return bx.g(r1, r2);
        L7:
            return bx.h(r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(long r1, byte[] r3, long r4, long r6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r1, long r2, byte r4) {
            if (bx.f5009b == false) goto L5;
            bx.a(r1, r2, r4);
            return;
        L5:
            bx.b(r1, r2, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r7, long r8, double r10) {
            a(r7, r8, Double.doubleToLongBits(r10));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r1, long r2, float r4) {
            a(r1, r2, Float.floatToIntBits(r4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r1, long r2, boolean r4) {
            if (bx.f5009b == false) goto L5;
            bx.b(r1, r2, r4);
            return;
        L5:
            bx.c(r1, r2, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public boolean a() {
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public long b(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public boolean b(Object r1, long r2) {
            if (bx.f5009b == false) goto L7;
            return bx.i(r1, r2);
        L7:
            return bx.j(r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public float c(Object r1, long r2) {
            return Float.intBitsToFloat(e(r1, r2));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public double d(Object r1, long r2) {
            return Double.longBitsToDouble(f(r1, r2));
        }
    }

    private static final class c extends d {
        c(Unsafe r3) {
            super((Unsafe) ZeusTransformUtils.wrapperContextForParams(r3, Unsafe.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public byte a(long r1) {
            return this.f5010a.getByte(r1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public byte a(Object r1, long r2) {
            return this.f5010a.getByte(r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(long r10, byte[] r12, long r13, long r15) {
            this.f5010a.copyMemory(null, r10, r12, bx.f5008a + r13, r15);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r1, long r2, byte r4) {
            this.f5010a.putByte(r1, r2, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r7, long r8, double r10) {
            this.f5010a.putDouble(r7, r8, r10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r1, long r2, float r4) {
            this.f5010a.putFloat(r1, r2, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public void a(Object r1, long r2, boolean r4) {
            this.f5010a.putBoolean(r1, r2, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public boolean a() {
            if (super.a() == true) goto L10;
            return false;
        L10:
            Class<?> r7 = this.f5010a.getClass();     // Catch: Throwable -> L7
            r7.getMethod("getByte", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getInt", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getLong", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            bx.a(th);
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public long b(long r1) {
            return this.f5010a.getLong(r1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public boolean b() {
            if (super.b() == true) goto L10;
            return false;
        L10:
            Class<?> r7 = this.f5010a.getClass();     // Catch: Throwable -> L7
            r7.getMethod("getByte", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            bx.a(th);
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public boolean b(Object r1, long r2) {
            return this.f5010a.getBoolean(r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public float c(Object r1, long r2) {
            return this.f5010a.getFloat(r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.bx.d
        public double d(Object r1, long r2) {
            return this.f5010a.getDouble(r1, r2);
        }
    }

    private static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Unsafe f5010a;

        d(Unsafe r3) {
            this.f5010a = (Unsafe) ZeusTransformUtils.wrapperContextForParams(r3, Unsafe.class, "com.obric.memorydata.plugin");
        }

        public abstract byte a(long r1);

        public abstract byte a(Object r1, long r2);

        public final int a(Class<?> r1) {
            return this.f5010a.arrayBaseOffset(r1);
        }

        public final long a(java.lang.reflect.Field r1) {
            return this.f5010a.objectFieldOffset(r1);
        }

        public abstract void a(long r1, byte[] r3, long r4, long r6);

        public abstract void a(Object r1, long r2, byte r4);

        public abstract void a(Object r1, long r2, double r4);

        public abstract void a(Object r1, long r2, float r4);

        public final void a(Object r1, long r2, int r4) {
            this.f5010a.putInt(r1, r2, r4);
        }

        public final void a(Object r7, long r8, long r10) {
            this.f5010a.putLong(r7, r8, r10);
        }

        public final void a(Object r1, long r2, Object r4) {
            this.f5010a.putObject(r1, r2, r4);
        }

        public abstract void a(Object r1, long r2, boolean r4);

        public boolean a() {
            Unsafe r5 = this.f5010a;
            if (r5 != null) goto L12;
            return false;
        L12:
            Class<?> r6 = r5.getClass();     // Catch: Throwable -> L9
            r6.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L9
            r6.getMethod("getLong", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L9
            if (bx.d() != null) goto L8;
            return false;
        L8:
            return true;
        L9:
            th = move-exception;
            bx.a(th);
            return false;
        }

        public final int b(Class<?> r1) {
            return this.f5010a.arrayIndexScale(r1);
        }

        public abstract long b(long r1);

        public boolean b() {
            Unsafe r7 = this.f5010a;
            if (r7 != null) goto L10;
            return false;
        L10:
            Class<?> r8 = r7.getClass();     // Catch: Throwable -> L7
            r8.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L7
            r8.getMethod("arrayBaseOffset", new Class[]{Class.class});     // Catch: Throwable -> L7
            r8.getMethod("arrayIndexScale", new Class[]{Class.class});     // Catch: Throwable -> L7
            r8.getMethod("getInt", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("getLong", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("getObject", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            bx.a(th);
            return false;
        }

        public abstract boolean b(Object r1, long r2);

        public abstract float c(Object r1, long r2);

        public abstract double d(Object r1, long r2);

        public final int e(Object r1, long r2) {
            return this.f5010a.getInt(r1, r2);
        }

        public final long f(Object r1, long r2) {
            return this.f5010a.getLong(r1, r2);
        }

        public final Object g(Object r1, long r2) {
            return this.f5010a.getObject(r1, r2);
        }
    }

    static {
        c = c();
        d = com.google.crypto.tink.shaded.protobuf.d.b();
        e = b(Long.TYPE);
        f = b(Integer.TYPE);
        g = e();
        h = g();
        i = f();
        long r5 = c(byte[].class);
        f5008a = r5;
        j = c(boolean[].class);
        k = d(boolean[].class);
        l = c(int[].class);
        m = d(int[].class);
        n = c(long[].class);
        o = d(long[].class);
        p = c(float[].class);
        q = d(float[].class);
        r = c(double[].class);
        s = d(double[].class);
        t = c(Object[].class);
        u = d(Object[].class);
        v = b(h());
        w = (int) (7 & r5);
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) goto L5;
        boolean r0 = true;
    L6:
        f5009b = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private bx() {
    }

    static byte a(long r1) {
        return g.a(r1);
    }

    static byte a(byte[] r3, long r4) {
        return g.a(r3, f5008a + r4);
    }

    static int a(Object r1, long r2) {
        return g.e(r1, r2);
    }

    static long a(java.lang.reflect.Field r2) {
        return g.a(r2);
    }

    static long a(ByteBuffer r3) {
        return g.f(r3, v);
    }

    static <T> T a(Class<T> r1) {
        return (T) c.allocateInstance(r1);
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private static java.lang.reflect.Field a(Class<?> r0, String r1) {
        return r0.getDeclaredField(r1);
    L4:
        return null;
    }

    static void a(long r8, byte[] r10, long r11, long r13) {
        g.a(r8, r10, r11, r13);
    }

    static /* synthetic */ void a(Object r0, long r1, byte r3) {
        c(r0, r1, r3);
    }

    static void a(Object r6, long r7, double r9) {
        g.a(r6, r7, r9);
    }

    static void a(Object r1, long r2, float r4) {
        g.a(r1, r2, r4);
    }

    static void a(Object r1, long r2, int r4) {
        g.a(r1, r2, r4);
    }

    static void a(Object r6, long r7, long r9) {
        g.a(r6, r7, r9);
    }

    static void a(Object r1, long r2, Object r4) {
        g.a(r1, r2, r4);
    }

    static void a(Object r1, long r2, boolean r4) {
        g.a(r1, r2, r4);
    }

    static /* synthetic */ void a(Throwable r0) {
        b(r0);
    }

    static void a(byte[] r3, long r4, byte r6) {
        g.a(r3, f5008a + r4, r6);
    }

    static boolean a() {
        return i;
    }

    static long b(long r1) {
        return g.b(r1);
    }

    static long b(Object r1, long r2) {
        return g.f(r1, r2);
    }

    private static long b(java.lang.reflect.Field r2) {
        if (r2 == null) goto L7;
        d r0 = g;
        if (r0 == null) goto L7;
        return r0.a(r2);
    L7:
        return -1;
    }

    static /* synthetic */ void b(Object r0, long r1, byte r3) {
        d(r0, r1, r3);
    }

    static /* synthetic */ void b(Object r0, long r1, boolean r3) {
        d(r0, r1, r3);
    }

    private static void b(Throwable r4) {
        Logger.getLogger(bx.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + r4);
    }

    static boolean b() {
        return h;
    }

    static boolean b(Class<?> r10) {
        if (com.google.crypto.tink.shaded.protobuf.d.a() == true) goto L8;
        return false;
    L8:
        Class<?> r1 = d;     // Catch: Throwable -> L7
        r1.getMethod("peekLong", new Class[]{r10, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("pokeLong", new Class[]{r10, Long.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("pokeInt", new Class[]{r10, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("peekInt", new Class[]{r10, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("pokeByte", new Class[]{r10, Byte.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("peekByte", new Class[]{r10});     // Catch: Throwable -> L7
        r1.getMethod("pokeByteArray", new Class[]{r10, byte[].class, Integer.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("peekByteArray", new Class[]{r10, byte[].class, Integer.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
        return true;
    L7:
        return false;
    }

    private static int c(Class<?> r1) {
        if (i == true) goto L7;
        return -1;
    L7:
        return g.a(r1);
    }

    static Unsafe c() {
        return (Unsafe) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass1()), Unsafe.class, "com.obric.memorydata.plugin");
    L4:
        return null;
    }

    private static void c(Object r4, long r5, byte r7) {
        long r0 = (-4) & r5;
        int r2 = a(r4, r0);
        int r6 = ((~((int) r5)) & 3) << 3;
        int r3 = r2 & (~(255 << r6));
        a(r4, r0, ((255 & r7) << r6) | r3);
    }

    static /* synthetic */ void c(Object r0, long r1, boolean r3) {
        e(r0, r1, r3);
    }

    static boolean c(Object r1, long r2) {
        return g.b(r1, r2);
    }

    static float d(Object r1, long r2) {
        return g.c(r1, r2);
    }

    private static int d(Class<?> r1) {
        if (i == true) goto L7;
        return -1;
    L7:
        return g.b(r1);
    }

    static /* synthetic */ java.lang.reflect.Field d() {
        return h();
    }

    private static void d(Object r4, long r5, byte r7) {
        long r0 = (-4) & r5;
        int r6 = (((int) r5) & 3) << 3;
        int r2 = a(r4, r0) & (~(255 << r6));
        a(r4, r0, ((255 & r7) << r6) | r2);
    }

    private static void d(Object r0, long r1, boolean r3) {
        c(r0, r1, r3 ? 1 : 0);
    }

    static double e(Object r1, long r2) {
        return g.d(r1, r2);
    }

    private static d e() {
        Unsafe r0 = c;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (com.google.crypto.tink.shaded.protobuf.d.a() == false) goto L16;
        if (e == false) goto L12;
        return new b(r0);
    L12:
        if (f == true) goto L14;
        return null;
    L14:
        return new a(r0);
    L16:
        return new c(r0);
    }

    private static void e(Object r0, long r1, boolean r3) {
        d(r0, r1, r3 ? 1 : 0);
    }

    static Object f(Object r1, long r2) {
        return g.g(r1, r2);
    }

    private static boolean f() {
        d r0 = g;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b();
    }

    static /* synthetic */ byte g(Object r0, long r1) {
        return k(r0, r1);
    }

    private static boolean g() {
        d r0 = g;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    static /* synthetic */ byte h(Object r0, long r1) {
        return l(r0, r1);
    }

    private static java.lang.reflect.Field h() {
        if (com.google.crypto.tink.shaded.protobuf.d.a() == false) goto L7;
        java.lang.reflect.Field r0 = a(Buffer.class, "effectiveDirectAddress");
        if (r0 == null) goto L7;
        return r0;
    L7:
        java.lang.reflect.Field r1 = a(Buffer.class, MemoryKeyInfoEntity.KEY_ADDRESS);
        if (r1 != null) goto L10;
    L12:
        return null;
    L10:
        if (r1.getType() != Long.TYPE) goto L12;
        return r1;
    }

    static /* synthetic */ boolean i(Object r0, long r1) {
        return m(r0, r1);
    }

    static /* synthetic */ boolean j(Object r0, long r1) {
        return n(r0, r1);
    }

    private static byte k(Object r2, long r3) {
        return (byte) ((a(r2, (-4) & r3) >>> ((int) (((~r3) & 3) << 3))) & 255);
    }

    private static byte l(Object r2, long r3) {
        return (byte) ((a(r2, (-4) & r3) >>> ((int) ((r3 & 3) << 3))) & 255);
    }

    private static boolean m(Object r0, long r1) {
        if (k(r0, r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean n(Object r0, long r1) {
        if (l(r0, r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
