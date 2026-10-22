package n4a;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
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
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h0 implements Closeable {
    public static final Pattern o = null;
    public static final Charset p = null;
    public static final a q = null;
    public static PThreadPoolExecutor r;
    public static final c s = null;
    public final File a;
    public final PolarisFileWrapper b;
    public final PolarisFileWrapper c;
    public final PolarisFileWrapper d;
    public final int e;
    public final long f;
    public final int g;
    public long h;
    public Writer i;
    public int j;
    public final LinkedHashMap<String, f> k;
    public int l;
    public long m;
    public final b n;

    public class a implements ThreadFactory {
        public final AtomicInteger a;

        public a() {
            this.a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r4) {
            return new PthreadThreadV2(r4, "disklrucache#" + this.a.getAndIncrement());
        }
    }

    public class b implements Callable<Void> {
        public final /* synthetic */ h0 a;

        public b(h0 r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final Void call() throws Exception {
            h0 r0 = this.a;
            monitor-enter(r0);
            h0 r1 = this.a;     // Catch: Throwable -> L13
            if (r1.i != null) goto L8;
        L6:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return null;
        L8:
            r1.q();     // Catch: Throwable -> L13
            if (this.a.n() == false) goto L6;
            this.a.m();     // Catch: Throwable -> L13
            this.a.l = 0;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }
    }

    public class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream
        public final void write(int r1) throws IOException {
        }
    }

    public final class d {
        public final f a;
        public final boolean[] b;
        public boolean c;
        public final /* synthetic */ h0 d;

        public class a extends FilterOutputStream {
            public final /* synthetic */ d a;

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
                return;
            L4:
                this.a.c = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                this.a.c = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int r2) {
                ((FilterOutputStream) this).out.write(r2);     // Catch: IOException -> L4
                return;
            L4:
                this.a.c = true;
            }

            public a(d r1, PolarisFileOutputStreamWrapper r2) {
                this.a = r1;
                super(r2);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] r2, int r3, int r4) {
                ((FilterOutputStream) this).out.write(r2, r3, r4);     // Catch: IOException -> L4
                return;
            L4:
                this.a.c = true;
            }
        }

        public final OutputStream a() throws IOException {
            h0 r0 = this.d;
            if (r0.g <= 0) goto L27;
            monitor-enter(r0);
            f r1 = this.a;     // Catch: Throwable -> L23
            if (r1.d != this) goto L22;
            if (r1.c == true) goto L10;
            this.b[0] = true;     // Catch: Throwable -> L23
        L10:
            PolarisFileWrapper r2 = r1.d(0);     // Catch: Throwable -> L23
            PolarisFileOutputStreamWrapper r3 = new PolarisFileOutputStreamWrapper(r2);     // Catch: FileNotFoundException -> L13 Throwable -> L23
        L15:
            a r4 = new a(this, r3);     // Catch: Throwable -> L23
            monitor-exit(r0);     // Catch: Throwable -> L23
            return r4;
        L13:
            this.d.a.mkdirs();     // Catch: Throwable -> L23
            r3 = new PolarisFileOutputStreamWrapper(r2);     // Catch: FileNotFoundException -> L18 Throwable -> L23
        L20:
            return h0.s;
        L22:
            throw new IllegalStateException();     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            throw th;
        L27:
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.d.g);
        }

        public d(h0 r1, f r2) {
            this.d = r1;
            this.a = r2;
            if (r2.c == false) goto L5;
            boolean[] r3 = null;
        L6:
            this.b = r3;
            return;
        L5:
            r3 = new boolean[r1.g];
            goto L6
        }
    }

    public final class e implements Closeable {
        public final InputStream[] a;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r0 = this.a;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L11;
            InputStream r3 = r0[r2];
            if (r3 == null) goto L10;
            r3.close();     // Catch: RuntimeException -> L8 Exception -> L12
        L8:
            e = move-exception;
            throw e;
        L10:
            r2 = r2 + 1;
            goto L3
        }

        public e(InputStream[] r1) {
            this.a = r1;
        }
    }

    public final class f {
        public final String a;
        public final long[] b;
        public boolean c;
        public d d;
        public final /* synthetic */ h0 e;

        public final String b() throws IOException {
            StringBuilder r0 = new StringBuilder();
            long[] r1 = this.b;
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L6;
            long r4 = r1[r3];
            r0.append(' ');
            r0.append(r4);
            r3 = r3 + 1;
            goto L3
        L6:
            return r0.toString();
        }

        public final PolarisFileWrapper a(int r5) {
            return new PolarisFileWrapper(this.e.a, this.a + "." + r5);
        }

        public final PolarisFileWrapper d(int r5) {
            return new PolarisFileWrapper(this.e.a, this.a + "." + r5 + ".tmp");
        }

        public f(h0 r1, String r2) {
            this.e = r1;
            this.a = r2;
            this.b = new long[r1.g];
        }

        public static void c(f r5, String[] r6) throws IOException {
            if (r6.length != r5.e.g) goto L13;
            int r0 = 0;
        L14:
            if (r0 >= r6.length) goto L9;
            r5.b[r0] = CastLongProtector.parseLong(r6[r0]);     // Catch: NumberFormatException -> L10
            r0 = r0 + 1;
            goto L14
        L9:
            return;
        L11:
            throw new IOException("unexpected journal line: " + Arrays.toString(r6));
        L13:
            throw new IOException("unexpected journal line: " + Arrays.toString(r6));
        }
    }

    static {
        o = PatternProtector.compile("[a-z0-9_-]{1,120}");
        p = Charset.forName("US-ASCII");
        Charset.forName("UTF-8");
        a r8 = new a();
        q = r8;
        r = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r8);
        s = new c();
    }

    public h0(PolarisFileWrapper r7, long r8) {
        this.h = 0;
        this.j = 1000;
        this.k = new LinkedHashMap(0, 0.75f, true);
        this.m = 0;
        this.n = new b(this);
        this.a = r7;
        this.e = 1;
        this.b = new PolarisFileWrapper(r7, "journal");
        this.c = new PolarisFileWrapper(r7, "journal.tmp");
        this.d = new PolarisFileWrapper(r7, "journal.bkp");
        this.g = 1;
        this.f = r8;
    }

    public static void c(PolarisFileWrapper r1) throws IOException {
        if (r1.exists() == true) goto L5;
        return;
    L5:
        if (r1.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static void d(PolarisFileWrapper r0, PolarisFileWrapper r1, boolean r2) throws IOException {
        if (r2 == false) goto L5;
        c(r1);
    L5:
        if (r0.renameTo(r1) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static void g(File r4) throws IOException {
        File[] r0 = r4.listFiles();
        if (r0 == null) goto L16;
        int r5 = r0.length;
        int r1 = 0;
    L5:
        if (r1 >= r5) goto L14;
        File r2 = r0[r1];
        if (r2.isDirectory() == false) goto L10;
        g(r2);
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

    public static void i(String r3) {
        if (o.matcher(r3).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r3 + "\"");
    }

    public static ThreadPoolExecutor j() {
        PThreadPoolExecutor r0 = r;     // Catch: Throwable -> L8
        if (r0 != null) goto L5;
    L6:
        r = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), q);     // Catch: Throwable -> L8
    L11:
        return r;
    L5:
        if (r0.isShutdown() == false) goto L11;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.i != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r0 = new ArrayList(this.k.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r0.hasNext() == false) goto L13;
        d r1 = ((f) r0.next()).d;     // Catch: Throwable -> L16
        if (r1 == null) goto L9;
        e(r1.d, r1, false);     // Catch: Throwable -> L16
        goto L9
    L13:
        q();     // Catch: Throwable -> L16
        this.i.close();     // Catch: Throwable -> L16
        this.i = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final synchronized void m() throws IOException {
        monitor-enter(this);
        Writer r0 = this.i;     // Catch: Throwable -> L26
        if (r0 == null) goto L6;
        r0.close();     // Catch: Throwable -> L26
    L6:
        BufferedWriter r1 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.c), p));     // Catch: Throwable -> L26
        r1.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L23
        r1.write("\n");     // Catch: Throwable -> L23
        r1.write("1");     // Catch: Throwable -> L23
        r1.write("\n");     // Catch: Throwable -> L23
        r1.write(Integer.toString(this.e));     // Catch: Throwable -> L23
        r1.write("\n");     // Catch: Throwable -> L23
        r1.write(Integer.toString(this.g));     // Catch: Throwable -> L23
        r1.write("\n");     // Catch: Throwable -> L23
        r1.write("\n");     // Catch: Throwable -> L23
        Iterator<f> r2 = this.k.values().iterator();     // Catch: Throwable -> L23
    L8:
        if (r2.hasNext() == false) goto L17;
        f r3 = r2.next();     // Catch: Throwable -> L23
        if (r3.d == null) goto L14;
        StringBuilder r4 = new StringBuilder("DIRTY ");     // Catch: Throwable -> L23
        r4.append(r3.a);     // Catch: Throwable -> L23
        r4.append('\n');     // Catch: Throwable -> L23
    L15:
        r1.write(r4.toString());     // Catch: Throwable -> L23
        goto L8
    L14:
        r4 = new StringBuilder("CLEAN ");     // Catch: Throwable -> L23
        r4.append(r3.a);     // Catch: Throwable -> L23
        r4.append(r3.b());     // Catch: Throwable -> L23
        r4.append('\n');     // Catch: Throwable -> L23
        goto L15
    L17:
        r1.close();     // Catch: Throwable -> L26
        if (this.b.exists() == false) goto L20;
        d(this.b, this.d, true);     // Catch: Throwable -> L26
    L20:
        d(this.c, this.b, false);     // Catch: Throwable -> L26
        this.d.delete();     // Catch: Throwable -> L26
        this.i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.b, true), p));     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public final boolean n() {
        int r0 = this.l;
        if (r0 >= 2000) goto L5;
        return false;
    L5:
        if (r0 < this.k.size()) goto L10;
        return true;
    L10:
        return false;
    }

    public final void p() {
        if (this.i == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    public final void q() throws IOException {
    L3:
        if (this.h > this.f) goto L8;
        if (this.k.size() > this.j) goto L8;
        return;
    L8:
        h(this.k.entrySet().iterator().next().getKey());
        goto L3
    }

    public final void k() throws IOException {
        i0 r1 = new i0(new PolarisFileInputStreamWrapper(this.b), p);
        String r2 = r1.a();     // Catch: Throwable -> L57
        String r3 = r1.a();     // Catch: Throwable -> L57
        String r4 = r1.a();     // Catch: Throwable -> L57
        String r5 = r1.a();     // Catch: Throwable -> L57
        String r6 = r1.a();     // Catch: Throwable -> L57
        if ("libcore.io.DiskLruCache".equals(r2) == false) goto L56;
        if ("1".equals(r3) == false) goto L56;
        if (Integer.toString(this.e).equals(r4) == false) goto L56;
        if (Integer.toString(this.g).equals(r5) == false) goto L56;
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r6) == false) goto L56;
        int r0 = 0;
    L65:
        String r7 = r1.a();     // Catch: EOFException -> L50 Throwable -> L57
        int r8 = r7.indexOf(32);     // Catch: EOFException -> L50 Throwable -> L57
        if (r8 == (-1)) goto L49;
        int r9 = r8 + 1;
        int r10 = r7.indexOf(32, r9);     // Catch: EOFException -> L50 Throwable -> L57
        if (r10 != (-1)) goto L25;
        String r11 = r7.substring(r9);     // Catch: EOFException -> L50 Throwable -> L57
        if (r8 == 6) goto L23;
    L26:
        f r12 = this.k.get(r11);     // Catch: EOFException -> L50 Throwable -> L57
        if (r12 != null) goto L30;
        r12 = new f(this, r11);     // Catch: EOFException -> L50 Throwable -> L57
        this.k.put(r11, r12);     // Catch: EOFException -> L50 Throwable -> L57
    L30:
        if (r10 == (-1)) goto L35;
        if (r8 != 5) goto L35;
        if (r7.startsWith("CLEAN") == false) goto L35;
        String[] r13 = r7.substring(r10 + 1).split(" ");     // Catch: EOFException -> L50 Throwable -> L57
        r12.c = true;     // Catch: EOFException -> L50 Throwable -> L57
        r12.d = null;     // Catch: EOFException -> L50 Throwable -> L57
        f.c(r12, r13);     // Catch: EOFException -> L50 Throwable -> L57
    L45:
        r0 = r0 + 1;     // Catch: EOFException -> L50 Throwable -> L57
    L35:
        if (r10 != (-1)) goto L40;
        if (r8 != 5) goto L40;
        if (r7.startsWith("DIRTY") == false) goto L40;
        r12.d = new d(this, r12);     // Catch: EOFException -> L50 Throwable -> L57
    L40:
        if (r10 != (-1)) goto L47;
        if (r8 != 4) goto L47;
        if (r7.startsWith("READ") == true) goto L45;
    L47:
        throw new IOException("unexpected journal line: ".concat(r7));     // Catch: EOFException -> L50 Throwable -> L57
    L23:
        if (r7.startsWith("REMOVE") == false) goto L26;
        this.k.remove(r11);     // Catch: EOFException -> L50 Throwable -> L57
        goto L45
    L25:
        r11 = r7.substring(r9, r10);     // Catch: EOFException -> L50 Throwable -> L57
        goto L26
    L49:
        throw new IOException("unexpected journal line: ".concat(r7));     // Catch: EOFException -> L50 Throwable -> L57
    L50:
        this.l = r0 - this.k.size();     // Catch: Throwable -> L57
        r1.close();     // Catch: Exception -> L62 RuntimeException -> L53
        return;
    L53:
        e = move-exception;
        throw e;
    L78:
        return;
    L56:
        throw new IOException("unexpected journal header: [" + r2 + ", " + r3 + ", " + r5 + ", " + r6 + "]");     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        r1.close();     // Catch: Exception -> L63 RuntimeException -> L60
    L60:
        e = move-exception;
        throw e;
    L59:
        throw th;
    }

    public final void l() throws IOException {
        c(this.c);
        Iterator<f> r0 = this.k.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        f r1 = r0.next();
        int r3 = 0;
        if (r1.d == null) goto L8;
        r1.d = null;
    L12:
        if (r3 >= this.g) goto L14;
        c(r1.a(r3));
        c(r1.d(r3));
        r3 = r3 + 1;
        goto L12
    L14:
        r0.remove();
    L8:
        if (r3 >= this.g) goto L4;
        this.h += r1.b[r3];
        r3 = r3 + 1;
        goto L8
    }

    public final synchronized e a(String r8) throws IOException {
        monitor-enter(this);
        p();     // Catch: Throwable -> L34
        i(r8);     // Catch: Throwable -> L34
        f r0 = this.k.get(r8);     // Catch: Throwable -> L34
        if (r0 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (r0.c == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        InputStream[] r2 = new InputStream[this.g];     // Catch: Throwable -> L34
        int r3 = 0;
        int r4 = 0;
    L40:
        if (r4 >= this.g) goto L18;
        r2[r4] = new PolarisFileInputStreamWrapper(r0.a(r4));     // Catch: FileNotFoundException -> L37 Throwable -> L34
        r4 = r4 + 1;
        goto L40
    L18:
        this.l++;     // Catch: Throwable -> L34
        this.i.append("READ " + r8 + '\n');     // Catch: Throwable -> L34
        if (n() == false) goto L21;
        j().submit(this.n);     // Catch: Throwable -> L34
    L21:
        e r9 = new e(r2);     // Catch: Throwable -> L34
        monitor-exit(this);
        return r9;
    L25:
        if (r3 >= this.g) goto L32;
        InputStream r10 = r2[r3];     // Catch: Throwable -> L34
        if (r10 == null) goto L32;
        r10.close();     // Catch: Exception -> L38 RuntimeException -> L30 Throwable -> L34
    L30:
        e = move-exception;
        throw e;     // Catch: Throwable -> L34
    L29:
        r3 = r3 + 1;
    L32:
        monitor-exit(this);
        return null;
    L34:
        th = move-exception;
        throw th;
    }

    public final d f(String r5) throws IOException {
        monitor-enter(this);
        p();     // Catch: Throwable -> L14
        i(r5);     // Catch: Throwable -> L14
        f r0 = this.k.get(r5);     // Catch: Throwable -> L14
        if (r0 != null) goto L7;
        r0 = new f(this, r5);     // Catch: Throwable -> L14
        this.k.put(r5, r0);     // Catch: Throwable -> L14
    L10:
        d r1 = new d(this, r0);     // Catch: Throwable -> L14
        r0.d = r1;     // Catch: Throwable -> L14
        this.i.write("DIRTY " + r5 + '\n');     // Catch: Throwable -> L14
        this.i.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r1;
    L7:
        if (r0.d == null) goto L10;
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void h(String r8) throws IOException {
        monitor-enter(this);
        p();     // Catch: Throwable -> L26
        i(r8);     // Catch: Throwable -> L26
        f r0 = this.k.get(r8);     // Catch: Throwable -> L26
        if (r0 != null) goto L6;
    L24:
        monitor-exit(this);
        return;
    L6:
        if (r0.d != null) goto L24;
        int r1 = 0;
    L10:
        if (r1 >= this.g) goto L19;
        PolarisFileWrapper r2 = r0.a(r1);     // Catch: Throwable -> L26
        if (r2.exists() == false) goto L18;
        if (r2.delete() == true) goto L18;
        throw new IOException("failed to delete ".concat(String.valueOf(r2)));     // Catch: Throwable -> L26
    L18:
        long r3 = this.h;     // Catch: Throwable -> L26
        long[] r4 = r0.b;     // Catch: Throwable -> L26
        this.h = r3 - r4[r1];     // Catch: Throwable -> L26
        r4[r1] = 0;     // Catch: Throwable -> L26
        r1 = r1 + 1;     // Catch: Throwable -> L26
        goto L10
    L19:
        this.l++;     // Catch: Throwable -> L26
        this.i.append("REMOVE " + r8 + '\n');     // Catch: Throwable -> L26
        this.k.remove(r8);     // Catch: Throwable -> L26
        if (n() == false) goto L22;
        j().submit(this.n);     // Catch: Throwable -> L26
    L22:
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public static h0 b(PolarisFileWrapper r6, long r7) throws IOException {
        if (r7 <= 0) goto L18;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6, "journal.bkp");
        if (r0.exists() == false) goto L10;
        PolarisFileWrapper r1 = new PolarisFileWrapper(r6, "journal");
        if (r1.exists() == false) goto L9;
        r0.delete();
        goto L10
    L9:
        d(r0, r1, false);
    L10:
        h0 r2 = new h0(r6, r7);
        if (r2.b.exists() == true) goto L19;
    L15:
        r6.mkdirs();
        h0 r3 = new h0(r6, r7);
        r3.m();
        return r3;
    L19:
        r2.k();     // Catch: Throwable -> L14
        r2.l();     // Catch: Throwable -> L14
        r2.i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r2.b, true), p));     // Catch: Throwable -> L14
        return r2;
    L14:
        r2.close();
        g(r2.a);
        goto L15
    L18:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void e(h0 r9, d r10, boolean r11) throws IOException {
        monitor-enter(r9);
        f r0 = r10.a;     // Catch: Throwable -> L44
        if (r0.d != r10) goto L43;
        int r1 = 0;
        if (r11 == false) goto L21;
        if (r0.c == true) goto L21;
        int r2 = 0;
    L11:
        if (r2 >= r9.g) goto L21;
        if (r10.b[r2] == false) goto L18;
        if (r0.d(r2).exists() == false) goto L16;
        r2 = r2 + 1;     // Catch: Throwable -> L44
        goto L11
    L16:
        e(r10.d, r10, false);     // Catch: Throwable -> L44
    L40:
        monitor-exit(r9);
        return;
    L18:
        e(r10.d, r10, false);     // Catch: Throwable -> L44
        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(r2)));     // Catch: Throwable -> L44
    L21:
        if (r1 >= r9.g) goto L29;
        PolarisFileWrapper r12 = r0.d(r1);     // Catch: Throwable -> L44
        if (r11 == true) goto L25;
        c(r12);     // Catch: Throwable -> L44
    L28:
        r1 = r1 + 1;     // Catch: Throwable -> L44
        goto L21
    L25:
        if (r12.exists() == false) goto L28;
        PolarisFileWrapper r3 = r0.a(r1);     // Catch: Throwable -> L44
        r12.renameTo(r3);     // Catch: Throwable -> L44
        long r4 = r0.b[r1];     // Catch: Throwable -> L44
        long r5 = r3.length();     // Catch: Throwable -> L44
        r0.b[r1] = r5;     // Catch: Throwable -> L44
        r9.h = (r9.h - r4) + r5;     // Catch: Throwable -> L44
        goto L28
    L29:
        r9.l++;     // Catch: Throwable -> L44
        r0.d = null;     // Catch: Throwable -> L44
        if ((r0.c | r11) == false) goto L34;
        r0.c = true;     // Catch: Throwable -> L44
        r9.i.write("CLEAN " + r0.a + r0.b() + '\n');     // Catch: Throwable -> L44
        if (r11 == false) goto L35;
        r9.m++;     // Catch: Throwable -> L44
        r0.getClass();     // Catch: Throwable -> L44
    L35:
        r9.i.flush();     // Catch: Throwable -> L44
        if (r9.h <= r9.f) goto L38;
    L39:
        j().submit(r9.n);     // Catch: Throwable -> L44
        goto L40
    L38:
        if (r9.n() == false) goto L40;
    L34:
        r9.k.remove(r0.a);     // Catch: Throwable -> L44
        r9.i.write("REMOVE " + r0.a + '\n');     // Catch: Throwable -> L44
        goto L35
    L43:
        throw new IllegalStateException();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }
}
