package com.loc;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class ah implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Pattern f5276a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f5277b = null;
    static final Charset c = null;
    static ThreadPoolExecutor d;
    private static final ThreadFactory r = null;
    private static final OutputStream t = null;
    private final File e;
    private final File f;
    private final File g;
    private final File h;
    private final int i;
    private long j;
    private final int k;
    private long l;
    private Writer m;
    private int n;
    private final LinkedHashMap<String, c> o;
    private int p;
    private long q;
    private final Callable<Void> s;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ah f5280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f5281b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        /* JADX INFO: renamed from: com.loc.ah$a$a, reason: collision with other inner class name */
        private class C0222a extends FilterOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f5282a;

            private C0222a(a r1, OutputStream r2) {
                this.f5282a = r1;
                super(r2);
            }

            /* synthetic */ C0222a(a r1, OutputStream r2, byte r3) {
                this(r1, r2);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                this.out.close();     // Catch: IOException -> L4
                return;
            L4:
                a.c(this.f5282a);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                this.out.flush();     // Catch: IOException -> L4
                return;
            L4:
                a.c(this.f5282a);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int r2) {
                this.out.write(r2);     // Catch: IOException -> L4
                return;
            L4:
                a.c(this.f5282a);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] r2, int r3, int r4) {
                this.out.write(r2, r3, r4);     // Catch: IOException -> L4
                return;
            L4:
                a.c(this.f5282a);
            }
        }

        private a(ah r1, c r2) {
            this.f5280a = r1;
            this.f5281b = r2;
            if (c.e(r2) == false) goto L5;
            boolean[] r3 = null;
        L6:
            this.c = r3;
            return;
        L5:
            r3 = new boolean[ah.f(r1)];
            goto L6
        }

        /* synthetic */ a(ah r1, c r2, byte r3) {
            this(r1, r2);
        }

        static /* synthetic */ c a(a r0) {
            return r0.f5281b;
        }

        static /* synthetic */ boolean[] b(a r0) {
            return r0.c;
        }

        static /* synthetic */ boolean c(a r1) {
            r1.d = true;
            return true;
        }

        public final OutputStream a() {
            if (ah.f(this.f5280a) <= 0) goto L28;
            ah r0 = this.f5280a;
            monitor-enter(r0);
        L24:
            th = move-exception;
            throw th;
        L7:
            if (c.b(this.f5281b) != this) goto L23;
            byte r2 = 0;
            if (c.e(this.f5281b) == true) goto L11;
            this.c[0] = true;     // Catch: Throwable -> L24
        L11:
            File r1 = this.f5281b.b(0);     // Catch: Throwable -> L24
            FileOutputStream r3 = new FileOutputStream(r1);     // Catch: FileNotFoundException -> L14 Throwable -> L24
        L16:
            C0222a r4 = new C0222a(this, r3, r2);     // Catch: Throwable -> L24
            monitor-exit(r0);     // Catch: Throwable -> L24
            return r4;
        L14:
            ah.g(this.f5280a).mkdirs();     // Catch: Throwable -> L24
            r3 = new FileOutputStream(r1);     // Catch: FileNotFoundException -> L19 Throwable -> L24
        L21:
            return ah.e();
        L23:
            throw new IllegalStateException();     // Catch: Throwable -> L24
        L28:
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + ah.f(this.f5280a));
        }

        public final void b() {
            if (this.d == false) goto L5;
            ah.a(this.f5280a, this, false);
            this.f5280a.c(c.d(this.f5281b));
        L6:
            this.e = true;
            return;
        L5:
            ah.a(this.f5280a, this, true);
            goto L6
        }

        public final void c() {
            ah.a(this.f5280a, this, false);
        }
    }

    public final class b implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ah f5283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5284b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        private b(ah r1, String r2, long r3, InputStream[] r5, long[] r6) {
            this.f5283a = r1;
            this.f5284b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        /* synthetic */ b(ah r1, String r2, long r3, InputStream[] r5, long[] r6, byte r7) {
            this(r1, r2, r3, r5, r6);
        }

        public final InputStream a() {
            return this.d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r3 = this.d;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            ah.a(r3[r1]);
            r1 = r1 + 1;
            goto L3
        }
    }

    private final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ah f5285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5286b;
        private final long[] c;
        private boolean d;
        private a e;
        private long f;

        private c(ah r1, String r2) {
            this.f5285a = r1;
            this.f5286b = r2;
            this.c = new long[ah.f(r1)];
        }

        /* synthetic */ c(ah r1, String r2, byte r3) {
            this(r1, r2);
        }

        static /* synthetic */ long a(c r0, long r1) {
            r0.f = r1;
            return r1;
        }

        static /* synthetic */ a a(c r0, a r1) {
            r0.e = r1;
            return r1;
        }

        private static IOException a(String[] r3) {
            throw new IOException("unexpected journal line: " + Arrays.toString(r3));
        }

        static /* synthetic */ void a(c r4, String[] r5) {
            if (r5.length != ah.f(r4.f5285a)) goto L13;
            int r0 = 0;
        L14:
            if (r0 >= r5.length) goto L9;
            r4.c[r0] = Long.parseLong(r5[r0]);     // Catch: NumberFormatException -> L10
            r0 = r0 + 1;
            goto L14
        L9:
            return;
        L11:
            throw a(r5);
        L13:
            throw a(r5);
        }

        static /* synthetic */ boolean a(c r1) {
            r1.d = true;
            return true;
        }

        static /* synthetic */ a b(c r0) {
            return r0.e;
        }

        static /* synthetic */ long[] c(c r0) {
            return r0.c;
        }

        static /* synthetic */ String d(c r0) {
            return r0.f5286b;
        }

        static /* synthetic */ boolean e(c r0) {
            return r0.d;
        }

        static /* synthetic */ long f(c r2) {
            return r2.f;
        }

        public final File a(int r4) {
            return new File(ah.g(this.f5285a), this.f5286b + "." + r4);
        }

        public final String a() {
            StringBuilder r0 = new StringBuilder();
            long[] r6 = this.c;
            int r1 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            long r3 = r6[r2];
            r0.append(' ').append(r3);
            r2 = r2 + 1;
            goto L3
        L6:
            return r0.toString();
        }

        public final File b(int r4) {
            return new File(ah.g(this.f5285a), this.f5286b + "." + r4 + ".tmp");
        }
    }

    static {
        f5276a = Pattern.compile("[a-z0-9_-]{1,120}");
        f5277b = Charset.forName("US-ASCII");
        c = Charset.forName(RpcUtils.CHARSET_UTF8);
        ThreadFactory r8 = new AnonymousClass1();
        r = r8;
        d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r8);
        t = new AnonymousClass3();
    }

    private ah(File r7, long r8) {
        this.l = 0;
        this.n = 1000;
        this.o = new LinkedHashMap(0, 0.75f, true);
        this.q = 0;
        this.s = new AnonymousClass2(this);
        this.e = r7;
        this.i = 1;
        this.f = new File(r7, "journal");
        this.g = new File(r7, "journal.tmp");
        this.h = new File(r7, "journal.bkp");
        this.k = 1;
        this.j = r8;
    }

    public static ah a(File r6, long r7) {
        if (r7 <= 0) goto L18;
        File r0 = new File(r6, "journal.bkp");
        if (r0.exists() == false) goto L10;
        File r1 = new File(r6, "journal");
        if (r1.exists() == false) goto L9;
        r0.delete();
        goto L10
    L9:
        a(r0, r1, false);
    L10:
        ah r2 = new ah(r6, r7);
        if (r2.f.exists() == true) goto L19;
    L15:
        r6.mkdirs();
        ah r3 = new ah(r6, r7);
        r3.i();
        return r3;
    L19:
        r2.g();     // Catch: Throwable -> L14
        r2.h();     // Catch: Throwable -> L14
        r2.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r2.f, true), f5277b));     // Catch: Throwable -> L14
        return r2;
    L14:
        r2.d();
        goto L15
    L18:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    static /* synthetic */ Writer a(ah r0) {
        return r0.m;
    }

    public static void a() {
        ThreadPoolExecutor r0 = d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShutdown() == true) goto L9;
        d.shutdown();
        return;
    }

    private synchronized void a(a r10, boolean r11) {
        monitor-enter(this);
        c r0 = a.a(r10);     // Catch: Throwable -> L46
        if (c.b(r0) != r10) goto L45;
        int r1 = 0;
        if (r11 == false) goto L23;
        if (c.e(r0) == true) goto L23;
        int r2 = 0;
    L11:
        if (r2 >= this.k) goto L23;
        if (a.b(r10)[r2] == false) goto L20;
        if (r0.b(r2).exists() == false) goto L16;
        r2 = r2 + 1;
        goto L11
    L16:
        r10.c();     // Catch: Throwable -> L46
        monitor-exit(this);
        return;
    L20:
        r10.c();     // Catch: Throwable -> L46
        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(r2)));     // Catch: Throwable -> L46
    L23:
        if (r1 >= this.k) goto L31;
        File r12 = r0.b(r1);     // Catch: Throwable -> L46
        if (r11 == true) goto L27;
        a(r12);     // Catch: Throwable -> L46
    L30:
        r1 = r1 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (r12.exists() == false) goto L30;
        File r3 = r0.a(r1);     // Catch: Throwable -> L46
        r12.renameTo(r3);     // Catch: Throwable -> L46
        long r4 = c.c(r0)[r1];     // Catch: Throwable -> L46
        long r5 = r3.length();     // Catch: Throwable -> L46
        c.c(r0)[r1] = r5;     // Catch: Throwable -> L46
        this.l = (this.l - r4) + r5;     // Catch: Throwable -> L46
        goto L30
    L31:
        this.p++;     // Catch: Throwable -> L46
        c.a(r0, null);     // Catch: Throwable -> L46
        if ((c.e(r0) | r11) == false) goto L36;
        c.a(r0);     // Catch: Throwable -> L46
        this.m.write("CLEAN " + c.d(r0) + r0.a() + '\n');     // Catch: Throwable -> L46
        if (r11 == false) goto L37;
        long r13 = this.q;     // Catch: Throwable -> L46
        this.q = 1 + r13;     // Catch: Throwable -> L46
        c.a(r0, r13);     // Catch: Throwable -> L46
    L37:
        this.m.flush();     // Catch: Throwable -> L46
        if (this.l <= this.j) goto L40;
    L41:
        f().submit(this.s);     // Catch: Throwable -> L46
    L42:
        monitor-exit(this);
        return;
    L40:
        if (j() == false) goto L42;
    L36:
        this.o.remove(c.d(r0));     // Catch: Throwable -> L46
        this.m.write("REMOVE " + c.d(r0) + '\n');     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void a(ah r0, a r1, boolean r2) {
        r0.a(r1, r2);
    }

    public static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        return;
    L10:
        r3.close();     // Catch: RuntimeException -> L6 Exception -> L9
        return;
    L6:
        e = move-exception;
        throw e;
    }

    private static void a(File r1) {
        if (r1.exists() == true) goto L5;
        return;
    L5:
        if (r1.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    private static void a(File r0, File r1, boolean r2) {
        if (r2 == false) goto L5;
        a(r1);
    L5:
        if (r0.renameTo(r1) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    static /* synthetic */ void b(ah r0) {
        r0.l();
    }

    private static void b(File r4) {
        File[] r0 = r4.listFiles();
        if (r0 == null) goto L16;
        int r5 = r0.length;
        int r1 = 0;
    L5:
        if (r1 >= r5) goto L14;
        File r2 = r0[r1];
        if (r2.isDirectory() == false) goto L10;
        b(r2);
    L10:
        if (r2.delete() == false) goto L13;
        r1 = r1 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: ".concat(String.valueOf(r2)));
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: ".concat(String.valueOf(r4)));
    }

    static /* synthetic */ boolean c(ah r0) {
        return r0.j();
    }

    private synchronized a d(String r5) {
        monitor-enter(this);
        k();     // Catch: Throwable -> L14
        e(r5);     // Catch: Throwable -> L14
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.o.get(r5), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        byte r1 = 0;
        if (r0 != null) goto L7;
        r0 = new c(this, r5, r1);     // Catch: Throwable -> L14
        this.o.put(r5, r0);     // Catch: Throwable -> L14
    L11:
        a r2 = new a(this, r0, r1);     // Catch: Throwable -> L14
        c.a(r0, r2);     // Catch: Throwable -> L14
        this.m.write("DIRTY " + r5 + '\n');     // Catch: Throwable -> L14
        this.m.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r2;
    L7:
        if (c.b(r0) == null) goto L11;
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void d(ah r0) {
        r0.i();
    }

    static /* synthetic */ int e(ah r1) {
        r1.p = 0;
        return 0;
    }

    static /* synthetic */ OutputStream e() {
        return t;
    }

    private static void e(String r3) {
        if (f5276a.matcher(r3).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r3 + "\"");
    }

    static /* synthetic */ int f(ah r0) {
        return r0.k;
    }

    private static ThreadPoolExecutor f() {
        ThreadPoolExecutor r0 = d;     // Catch: Throwable -> L8
        if (r0 != null) goto L5;
    L6:
        d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), r);     // Catch: Throwable -> L8
    L11:
        return d;
    L5:
        if (r0.isShutdown() == false) goto L11;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    static /* synthetic */ File g(ah r0) {
        return r0.e;
    }

    private void g() {
        ai r1 = new ai(new FileInputStream(this.f), f5277b);
        String r2 = r1.a();     // Catch: Throwable -> L55
        String r3 = r1.a();     // Catch: Throwable -> L55
        String r4 = r1.a();     // Catch: Throwable -> L55
        String r5 = r1.a();     // Catch: Throwable -> L55
        String r6 = r1.a();     // Catch: Throwable -> L55
        if ("libcore.io.DiskLruCache".equals(r2) == false) goto L54;
        if ("1".equals(r3) == false) goto L54;
        if (Integer.toString(this.i).equals(r4) == false) goto L54;
        if (Integer.toString(this.k).equals(r5) == false) goto L54;
        if ("".equals(r6) == false) goto L54;
        byte r0 = 0;
        int r7 = 0;
    L58:
        String r8 = r1.a();     // Catch: EOFException -> L50 Throwable -> L55
        int r9 = r8.indexOf(32);     // Catch: EOFException -> L50 Throwable -> L55
        if (r9 == (-1)) goto L49;
        int r10 = r9 + 1;
        int r11 = r8.indexOf(32, r10);     // Catch: EOFException -> L50 Throwable -> L55
        if (r11 != (-1)) goto L25;
        String r12 = r8.substring(r10);     // Catch: EOFException -> L50 Throwable -> L55
        if (r9 == 6) goto L23;
    L26:
        c r13 = (c) ZeusTransformUtils.preCheckCast(this.o.get(r12), c.class, "com.obric.memorydata.plugin");     // Catch: EOFException -> L50 Throwable -> L55
        if (r13 != null) goto L30;
        r13 = new c(this, r12, r0);     // Catch: EOFException -> L50 Throwable -> L55
        this.o.put(r12, r13);     // Catch: EOFException -> L50 Throwable -> L55
    L30:
        if (r11 == (-1)) goto L35;
        if (r9 != 5) goto L35;
        if (r8.startsWith("CLEAN") == false) goto L35;
        String[] r14 = r8.substring(r11 + 1).split(" ");     // Catch: EOFException -> L50 Throwable -> L55
        c.a(r13);     // Catch: EOFException -> L50 Throwable -> L55
        c.a(r13, null);     // Catch: EOFException -> L50 Throwable -> L55
        c.a(r13, r14);     // Catch: EOFException -> L50 Throwable -> L55
    L45:
        r7 = r7 + 1;     // Catch: EOFException -> L50 Throwable -> L55
    L35:
        if (r11 != (-1)) goto L40;
        if (r9 != 5) goto L40;
        if (r8.startsWith("DIRTY") == false) goto L40;
        c.a(r13, new a(this, r13, r0));     // Catch: EOFException -> L50 Throwable -> L55
    L40:
        if (r11 != (-1)) goto L47;
        if (r9 != 4) goto L47;
        if (r8.startsWith("READ") == true) goto L45;
    L47:
        throw new IOException("unexpected journal line: ".concat(String.valueOf(r8)));     // Catch: EOFException -> L50 Throwable -> L55
    L23:
        if (r8.startsWith("REMOVE") == false) goto L26;
        this.o.remove(r12);     // Catch: EOFException -> L50 Throwable -> L55
        goto L45
    L25:
        r12 = r8.substring(r10, r11);     // Catch: EOFException -> L50 Throwable -> L55
        goto L26
    L49:
        throw new IOException("unexpected journal line: ".concat(String.valueOf(r8)));     // Catch: EOFException -> L50 Throwable -> L55
    L50:
        this.p = r7 - this.o.size();     // Catch: Throwable -> L55
        a(r1);
        return;
    L54:
        throw new IOException("unexpected journal header: [" + r2 + ", " + r3 + ", " + r5 + ", " + r6 + "]");     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        a(r1);
        throw th;
    }

    private void h() {
        a(this.g);
        Iterator<c> r0 = this.o.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        if (c.b(r1) == null) goto L8;
        c.a(r1, null);
    L12:
        if (r3 >= this.k) goto L14;
        a(r1.a(r3));
        a(r1.b(r3));
        r3 = r3 + 1;
        goto L12
    L14:
        r0.remove();
    L8:
        if (r3 >= this.k) goto L4;
        this.l += c.c(r1)[r3];
        r3 = r3 + 1;
        goto L8
    }

    private synchronized void i() {
        monitor-enter(this);
        Writer r0 = this.m;     // Catch: Throwable -> L25
        if (r0 == null) goto L6;
        r0.close();     // Catch: Throwable -> L25
    L6:
        BufferedWriter r1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.g), f5277b));     // Catch: Throwable -> L25
        r1.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L22
        r1.write("\n");     // Catch: Throwable -> L22
        r1.write("1");     // Catch: Throwable -> L22
        r1.write("\n");     // Catch: Throwable -> L22
        r1.write(Integer.toString(this.i));     // Catch: Throwable -> L22
        r1.write("\n");     // Catch: Throwable -> L22
        r1.write(Integer.toString(this.k));     // Catch: Throwable -> L22
        r1.write("\n");     // Catch: Throwable -> L22
        r1.write("\n");     // Catch: Throwable -> L22
        Iterator<c> r2 = this.o.values().iterator();     // Catch: Throwable -> L22
    L8:
        if (r2.hasNext() == false) goto L16;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (c.b(r3) == null) goto L14;
        String r4 = "DIRTY " + c.d(r3) + '\n';     // Catch: Throwable -> L22
    L13:
        r1.write(r4);     // Catch: Throwable -> L22
        goto L8
    L14:
        r4 = "CLEAN " + c.d(r3) + r3.a() + '\n';     // Catch: Throwable -> L22
        goto L13
    L16:
        r1.close();     // Catch: Throwable -> L25
        if (this.f.exists() == false) goto L19;
        a(this.f, this.h, true);     // Catch: Throwable -> L25
    L19:
        a(this.g, this.f, false);     // Catch: Throwable -> L25
        this.h.delete();     // Catch: Throwable -> L25
        this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f, true), f5277b));     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private boolean j() {
        int r0 = this.p;
        if (r0 >= 2000) goto L5;
        return false;
    L5:
        if (r0 < this.o.size()) goto L10;
        return true;
    L10:
        return false;
    }

    private void k() {
        if (this.m == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    private void l() {
    L3:
        if (this.l > this.j) goto L8;
        if (this.o.size() > this.n) goto L8;
        return;
    L8:
        c((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(this.o.entrySet().iterator().next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin"));
        goto L3
    }

    public final synchronized b a(String r12) {
        monitor-enter(this);
        k();     // Catch: Throwable -> L32
        e(r12);     // Catch: Throwable -> L32
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.o.get(r12), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r0 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (c.e(r0) == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        InputStream[] r8 = new InputStream[this.k];     // Catch: Throwable -> L32
        int r2 = 0;
        int r3 = 0;
    L37:
        if (r3 >= this.k) goto L18;
        r8[r3] = new FileInputStream(r0.a(r3));     // Catch: FileNotFoundException -> L35 Throwable -> L32
        r3 = r3 + 1;
        goto L37
    L18:
        this.p++;     // Catch: Throwable -> L32
        this.m.append("READ " + r12 + '\n');     // Catch: Throwable -> L32
        if (j() == false) goto L21;
        f().submit(this.s);     // Catch: Throwable -> L32
    L21:
        b r1 = new b(this, r12, c.f(r0), r8, c.c(r0), 0);     // Catch: Throwable -> L32
        monitor-exit(this);
        return r1;
    L25:
        if (r2 >= this.k) goto L30;
        if (r8[r2] == null) goto L30;
        a(r8[r2]);     // Catch: Throwable -> L32
        r2 = r2 + 1;
    L30:
        monitor-exit(this);
        return null;
    L32:
        th = move-exception;
        throw th;
    }

    public final void a(int r3) {
        if (r3 >= 10) goto L5;
        r3 = 10;
    L7:
        this.n = r3;
        return;
    L5:
        if (r3 <= 10000) goto L7;
        r3 = 10000;
        goto L7
    }

    public final a b(String r1) {
        return d(r1);
    }

    public final File b() {
        return this.e;
    }

    public final synchronized void c() {
        monitor-enter(this);
        k();     // Catch: Throwable -> L6
        l();     // Catch: Throwable -> L6
        this.m.flush();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c(String r7) {
        monitor-enter(this);
        k();     // Catch: Throwable -> L25
        e(r7);     // Catch: Throwable -> L25
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.o.get(r7), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        int r1 = 0;
        if (r0 != null) goto L6;
    L23:
        monitor-exit(this);
        return false;
    L6:
        if (c.b(r0) != null) goto L23;
    L9:
        if (r1 >= this.k) goto L18;
        File r2 = r0.a(r1);     // Catch: Throwable -> L25
        if (r2.exists() == false) goto L17;
        if (r2.delete() == true) goto L17;
        throw new IOException("failed to delete ".concat(String.valueOf(r2)));     // Catch: Throwable -> L25
    L17:
        this.l -= c.c(r0)[r1];     // Catch: Throwable -> L25
        c.c(r0)[r1] = 0;     // Catch: Throwable -> L25
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L9
    L18:
        this.p++;     // Catch: Throwable -> L25
        this.m.append("REMOVE " + r7 + '\n');     // Catch: Throwable -> L25
        this.o.remove(r7);     // Catch: Throwable -> L25
        if (j() == false) goto L21;
        f().submit(this.s);     // Catch: Throwable -> L25
    L21:
        monitor-exit(this);
        return true;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.m != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r0 = new ArrayList(this.o.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r0.hasNext() == false) goto L13;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (c.b(r1) == null) goto L9;
        c.b(r1).c();     // Catch: Throwable -> L16
        goto L9
    L13:
        l();     // Catch: Throwable -> L16
        this.m.close();     // Catch: Throwable -> L16
        this.m = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final void d() {
        close();
        b(this.e);
    }
}
