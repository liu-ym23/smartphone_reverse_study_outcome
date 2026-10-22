package qa;

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

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements Closeable {
    public static final a A = null;
    public static ThreadPoolExecutor B;
    public static final c C = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f10339y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Charset f10340z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f10341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f10342b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final File f10343m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final File f10344n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f10345o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f10346p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f10347q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f10348r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public BufferedWriter f10349s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10350t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinkedHashMap<String, f> f10351u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10352v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f10353w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f10354x;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f10355a;

        public a() {
            this.f10355a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            return new Thread(r8, "disklrucache#" + this.f10355a.getAndIncrement());
        }
    }

    public class b implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f10356a;

        public b(e0 r8) {
            this.f10356a = r8;
        }

        @Override // java.util.concurrent.Callable
        public final Void call() {
            e0 r8 = this.f10356a;
            monitor-enter(r8);
            e0 r10 = this.f10356a;     // Catch: Throwable -> L13
            if (r10.f10349s == null) goto L10;
            r10.H();     // Catch: Throwable -> L13
            if (this.f10356a.E() == false) goto L10;
            this.f10356a.D();     // Catch: Throwable -> L13
            this.f10356a.f10352v = 0;     // Catch: Throwable -> L13
        L10:
            monitor-exit(r8);     // Catch: Throwable -> L13
            return null;
        L13:
            th = move-exception;
            throw th;
        }
    }

    public class c extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int r8) {
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f10357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f10358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e0 f10360d;

        public class a extends FilterOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f10361a;

            public a(d r8, FileOutputStream r10) {
                this.f10361a = r8;
                super(r10);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
                return;
            L4:
                this.f10361a.f10359c = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                this.f10361a.f10359c = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int r8) {
                ((FilterOutputStream) this).out.write(r8);     // Catch: IOException -> L4
                return;
            L4:
                this.f10361a.f10359c = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] r8, int r10, int r11) {
                ((FilterOutputStream) this).out.write(r8, r10, r11);     // Catch: IOException -> L4
                return;
            L4:
                this.f10361a.f10359c = true;
            }
        }

        public d(e0 r8, f r10) {
            this.f10360d = r8;
            this.f10357a = r10;
            if (r10.f10365c == false) goto L5;
            boolean[] r11 = null;
        L6:
            this.f10358b = r11;
            return;
        L5:
            r11 = new boolean[r8.f10347q];
            goto L6
        }

        public final OutputStream a() {
            e0 r8 = this.f10360d;
            if (r8.f10347q <= 0) goto L27;
            monitor-enter(r8);
            f r10 = this.f10357a;     // Catch: Throwable -> L23
            if (r10.f10366d != this) goto L22;
            if (r10.f10365c == true) goto L10;
            this.f10358b[0] = true;     // Catch: Throwable -> L23
        L10:
            File r11 = r10.d(0);     // Catch: Throwable -> L23
            FileOutputStream r12 = new FileOutputStream(r11);     // Catch: FileNotFoundException -> L13 Throwable -> L23
        L15:
            a r13 = new a(this, r12);     // Catch: Throwable -> L23
            monitor-exit(r8);     // Catch: Throwable -> L23
            return r13;
        L13:
            this.f10360d.f10341a.mkdirs();     // Catch: Throwable -> L23
            r12 = new FileOutputStream(r11);     // Catch: FileNotFoundException -> L18 Throwable -> L23
        L20:
            return e0.C;
        L22:
            throw new IllegalStateException();     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            throw th;
        L27:
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.f10360d.f10347q);
        }
    }

    public final class e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream[] f10362a;

        public e(InputStream[] r8) {
            this.f10362a = r8;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r8 = this.f10362a;
            int r10 = r8.length;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L11;
            InputStream r12 = r8[r11];
            if (r12 == null) goto L10;
            r12.close();     // Catch: RuntimeException -> L8 Exception -> L12
        L8:
            e = move-exception;
            throw e;
        L10:
            r11 = r11 + 1;
            goto L3
        }
    }

    public final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f10364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10365c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f10366d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e0 f10367e;

        public f(e0 r8, String r10) {
            this.f10367e = r8;
            this.f10363a = r10;
            this.f10364b = new long[r8.f10347q];
        }

        public static void c(f r8, String[] r10) {
            if (r10.length != r8.f10367e.f10347q) goto L13;
            int r11 = 0;
        L14:
            if (r11 >= r10.length) goto L9;
            r8.f10364b[r11] = Long.parseLong(r10[r11]);     // Catch: NumberFormatException -> L10
            r11 = r11 + 1;
            goto L14
        L9:
            return;
        L11:
            throw new IOException("unexpected journal line: " + Arrays.toString(r10));
        L13:
            throw new IOException("unexpected journal line: " + Arrays.toString(r10));
        }

        public final File a(int r8) {
            return new File(this.f10367e.f10341a, this.f10363a + "." + r8);
        }

        public final String b() {
            StringBuilder r8 = new StringBuilder();
            long[] r10 = this.f10364b;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L6;
            long r13 = r10[r12];
            r8.append(' ');
            r8.append(r13);
            r12 = r12 + 1;
            goto L3
        L6:
            return r8.toString();
        }

        public final File d(int r8) {
            return new File(this.f10367e.f10341a, this.f10363a + "." + r8 + ".tmp");
        }
    }

    static {
        f10339y = Pattern.compile("[a-z0-9_-]{1,120}");
        f10340z = Charset.forName("US-ASCII");
        Charset.forName("UTF-8");
        a r8 = new a();
        A = r8;
        B = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r8);
        C = new c();
    }

    public e0(File r8, long r10) {
        this.f10348r = 0;
        this.f10350t = 1000;
        this.f10351u = new LinkedHashMap(0, 0.75f, true);
        this.f10353w = 0;
        this.f10354x = new b(this);
        this.f10341a = r8;
        this.f10345o = 1;
        this.f10342b = new File(r8, "journal");
        this.f10343m = new File(r8, "journal.tmp");
        this.f10344n = new File(r8, "journal.bkp");
        this.f10347q = 1;
        this.f10346p = r10;
    }

    public static ThreadPoolExecutor A() {
        ThreadPoolExecutor r8 = B;     // Catch: Throwable -> L8
        if (r8 != null) goto L5;
    L6:
        B = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), A);     // Catch: Throwable -> L8
    L11:
        return B;
    L5:
        if (r8.isShutdown() == false) goto L11;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    public static e0 i(File r8, long r10) {
        if (r10 <= 0) goto L18;
        File r11 = new File(r8, "journal.bkp");
        if (r11.exists() == false) goto L10;
        File r12 = new File(r8, "journal");
        if (r12.exists() == false) goto L9;
        r11.delete();
        goto L10
    L9:
        n(r11, r12, false);
    L10:
        e0 r13 = new e0(r8, r10);
        File r14 = r13.f10342b;
        if (r14.exists() == true) goto L19;
    L15:
        r8.mkdirs();
        e0 r15 = new e0(r8, r10);
        r15.D();
        return r15;
    L19:
        r13.B();     // Catch: Throwable -> L14
        r13.C();     // Catch: Throwable -> L14
        r13.f10349s = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r14, true), f10340z));     // Catch: Throwable -> L14
        return r13;
    L14:
        r13.close();
        w(r13.f10341a);
        goto L15
    L18:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void k(File r8) {
        if (r8.exists() == true) goto L5;
        return;
    L5:
        if (r8.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static void n(File r8, File r10, boolean r11) {
        if (r11 == false) goto L5;
        k(r10);
    L5:
        if (r8.renameTo(r10) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static void r(e0 r10, d r11, boolean r12) {
        monitor-enter(r10);
        f r8 = r11.f10357a;     // Catch: Throwable -> L44
        if (r8.f10366d != r11) goto L43;
        int r13 = 0;
        if (r12 == false) goto L21;
        if (r8.f10365c == true) goto L21;
        int r14 = 0;
    L11:
        if (r14 >= r10.f10347q) goto L21;
        if (r11.f10358b[r14] == false) goto L18;
        if (r8.d(r14).exists() == false) goto L16;
        r14 = r14 + 1;     // Catch: Throwable -> L44
        goto L11
    L16:
        r(r11.f10360d, r11, false);     // Catch: Throwable -> L44
    L40:
        monitor-exit(r10);
        return;
    L18:
        r(r11.f10360d, r11, false);     // Catch: Throwable -> L44
        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(r14)));     // Catch: Throwable -> L44
    L21:
        if (r13 >= r10.f10347q) goto L29;
        File r15 = r8.d(r13);     // Catch: Throwable -> L44
        if (r12 == true) goto L25;
        k(r15);     // Catch: Throwable -> L44
    L28:
        r13 = r13 + 1;     // Catch: Throwable -> L44
        goto L21
    L25:
        if (r15.exists() == false) goto L28;
        File r16 = r8.a(r13);     // Catch: Throwable -> L44
        r15.renameTo(r16);     // Catch: Throwable -> L44
        long r17 = r8.f10364b[r13];     // Catch: Throwable -> L44
        long r18 = r16.length();     // Catch: Throwable -> L44
        r8.f10364b[r13] = r18;     // Catch: Throwable -> L44
        r10.f10348r = (r10.f10348r - r17) + r18;     // Catch: Throwable -> L44
        goto L28
    L29:
        r10.f10352v++;     // Catch: Throwable -> L44
        r8.f10366d = null;     // Catch: Throwable -> L44
        if ((r8.f10365c | r12) == false) goto L34;
        r8.f10365c = true;     // Catch: Throwable -> L44
        r10.f10349s.write("CLEAN " + r8.f10363a + r8.b() + '\n');     // Catch: Throwable -> L44
        if (r12 == false) goto L35;
        r10.f10353w++;     // Catch: Throwable -> L44
        r8.getClass();     // Catch: Throwable -> L44
    L35:
        r10.f10349s.flush();     // Catch: Throwable -> L44
        if (r10.f10348r <= r10.f10346p) goto L38;
    L39:
        A().submit(r10.f10354x);     // Catch: Throwable -> L44
        goto L40
    L38:
        if (r10.E() == false) goto L40;
    L34:
        r10.f10351u.remove(r8.f10363a);     // Catch: Throwable -> L44
        r10.f10349s.write("REMOVE " + r8.f10363a + '\n');     // Catch: Throwable -> L44
        goto L35
    L43:
        throw new IllegalStateException();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }

    public static void w(File r8) {
        File[] r10 = r8.listFiles();
        if (r10 == null) goto L16;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L14;
        File r13 = r10[r12];
        if (r13.isDirectory() == false) goto L10;
        w(r13);
    L10:
        if (r13.delete() == false) goto L13;
        r12 = r12 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: ".concat(String.valueOf(r13)));
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: ".concat(String.valueOf(r8)));
    }

    public static void z(String r8) {
        if (f10339y.matcher(r8).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(defpackage.b.d("keys must match regex [a-z0-9_-]{1,120}: \"", r8, "\""));
    }

    public final void B() {
        LinkedHashMap<String, f> r8 = this.f10351u;
        f0 r10 = new f0(new FileInputStream(this.f10342b), f10340z);
        String r11 = r10.a();     // Catch: Throwable -> L57
        String r12 = r10.a();     // Catch: Throwable -> L57
        String r13 = r10.a();     // Catch: Throwable -> L57
        String r14 = r10.a();     // Catch: Throwable -> L57
        String r15 = r10.a();     // Catch: Throwable -> L57
        if ("libcore.io.DiskLruCache".equals(r11) == false) goto L56;
        if ("1".equals(r12) == false) goto L56;
        if (Integer.toString(this.f10345o).equals(r13) == false) goto L56;
        if (Integer.toString(this.f10347q).equals(r14) == false) goto L56;
        if ("".equals(r15) == false) goto L56;
        int r16 = 0;
    L64:
        String r17 = r10.a();     // Catch: EOFException -> L50 Throwable -> L57
        int r18 = r17.indexOf(32);     // Catch: EOFException -> L50 Throwable -> L57
        if (r18 == (-1)) goto L49;
        int r19 = r18 + 1;
        int r20 = r17.indexOf(32, r19);     // Catch: EOFException -> L50 Throwable -> L57
        if (r20 != (-1)) goto L25;
        String r21 = r17.substring(r19);     // Catch: EOFException -> L50 Throwable -> L57
        if (r18 == 6) goto L23;
    L26:
        f r22 = r8.get(r21);     // Catch: EOFException -> L50 Throwable -> L57
        if (r22 != null) goto L30;
        r22 = new f(this, r21);     // Catch: EOFException -> L50 Throwable -> L57
        r8.put(r21, r22);     // Catch: EOFException -> L50 Throwable -> L57
    L30:
        if (r20 == (-1)) goto L35;
        if (r18 != 5) goto L35;
        if (r17.startsWith("CLEAN") == false) goto L35;
        String[] r23 = r17.substring(r20 + 1).split(" ");     // Catch: EOFException -> L50 Throwable -> L57
        r22.f10365c = true;     // Catch: EOFException -> L50 Throwable -> L57
        r22.f10366d = null;     // Catch: EOFException -> L50 Throwable -> L57
        f.c(r22, r23);     // Catch: EOFException -> L50 Throwable -> L57
    L45:
        r16 = r16 + 1;     // Catch: EOFException -> L50 Throwable -> L57
    L35:
        if (r20 != (-1)) goto L40;
        if (r18 != 5) goto L40;
        if (r17.startsWith("DIRTY") == false) goto L40;
        r22.f10366d = new d(this, r22);     // Catch: EOFException -> L50 Throwable -> L57
    L40:
        if (r20 != (-1)) goto L47;
        if (r18 != 4) goto L47;
        if (r17.startsWith("READ") == true) goto L45;
    L47:
        throw new IOException("unexpected journal line: ".concat(r17));     // Catch: EOFException -> L50 Throwable -> L57
    L23:
        if (r17.startsWith("REMOVE") == false) goto L26;
        r8.remove(r21);     // Catch: EOFException -> L50 Throwable -> L57
        goto L45
    L25:
        r21 = r17.substring(r19, r20);     // Catch: EOFException -> L50 Throwable -> L57
        goto L26
    L49:
        throw new IOException("unexpected journal line: ".concat(r17));     // Catch: EOFException -> L50 Throwable -> L57
    L50:
        this.f10352v = r16 - r8.size();     // Catch: Throwable -> L57
        r10.close();     // Catch: Exception -> L62 RuntimeException -> L53
        return;
    L53:
        e = move-exception;
        throw e;
    L78:
        return;
    L56:
        throw new IOException("unexpected journal header: [" + r11 + ", " + r12 + ", " + r14 + ", " + r15 + "]");     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        r10.close();     // Catch: Exception -> L63 RuntimeException -> L60
    L60:
        e = move-exception;
        throw e;
    L59:
        throw th;
    }

    public final void C() {
        k(this.f10343m);
        Iterator<f> r8 = this.f10351u.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        f r10 = r8.next();
        d r11 = r10.f10366d;
        int r12 = this.f10347q;
        int r13 = 0;
        if (r11 == null) goto L7;
        r10.f10366d = null;
    L10:
        if (r13 >= r12) goto L12;
        k(r10.a(r13));
        k(r10.d(r13));
        r13 = r13 + 1;
        goto L10
    L12:
        r8.remove();
    L7:
        if (r13 >= r12) goto L4;
        this.f10348r += r10.f10364b[r13];
        r13 = r13 + 1;
        goto L7
    }

    public final synchronized void D() {
        monitor-enter(this);
        BufferedWriter r8 = this.f10349s;     // Catch: Throwable -> L26
        if (r8 == null) goto L6;
        r8.close();     // Catch: Throwable -> L26
    L6:
        BufferedWriter r10 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10343m), f10340z));     // Catch: Throwable -> L26
        r10.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L23
        r10.write("\n");     // Catch: Throwable -> L23
        r10.write("1");     // Catch: Throwable -> L23
        r10.write("\n");     // Catch: Throwable -> L23
        r10.write(Integer.toString(this.f10345o));     // Catch: Throwable -> L23
        r10.write("\n");     // Catch: Throwable -> L23
        r10.write(Integer.toString(this.f10347q));     // Catch: Throwable -> L23
        r10.write("\n");     // Catch: Throwable -> L23
        r10.write("\n");     // Catch: Throwable -> L23
        Iterator<f> r11 = this.f10351u.values().iterator();     // Catch: Throwable -> L23
    L8:
        if (r11.hasNext() == false) goto L17;
        f r12 = r11.next();     // Catch: Throwable -> L23
        if (r12.f10366d == null) goto L14;
        StringBuilder r13 = new StringBuilder("DIRTY ");     // Catch: Throwable -> L23
        r13.append(r12.f10363a);     // Catch: Throwable -> L23
        r13.append('\n');     // Catch: Throwable -> L23
    L15:
        r10.write(r13.toString());     // Catch: Throwable -> L23
        goto L8
    L14:
        r13 = new StringBuilder("CLEAN ");     // Catch: Throwable -> L23
        r13.append(r12.f10363a);     // Catch: Throwable -> L23
        r13.append(r12.b());     // Catch: Throwable -> L23
        r13.append('\n');     // Catch: Throwable -> L23
        goto L15
    L17:
        r10.close();     // Catch: Throwable -> L26
        if (this.f10342b.exists() == false) goto L20;
        n(this.f10342b, this.f10344n, true);     // Catch: Throwable -> L26
    L20:
        n(this.f10343m, this.f10342b, false);     // Catch: Throwable -> L26
        this.f10344n.delete();     // Catch: Throwable -> L26
        this.f10349s = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10342b, true), f10340z));     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public final boolean E() {
        int r8 = this.f10352v;
        if (r8 >= 2000) goto L5;
        return false;
    L5:
        if (r8 < this.f10351u.size()) goto L10;
        return true;
    L10:
        return false;
    }

    public final void G() {
        if (this.f10349s == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    public final void H() {
    L2:
        long r8 = this.f10348r;
        long r10 = this.f10346p;
        LinkedHashMap<String, f> r11 = this.f10351u;
        if (r8 > r10) goto L8;
        if (r11.size() > this.f10350t) goto L8;
        return;
    L8:
        x(r11.entrySet().iterator().next().getKey());
        goto L2
    }

    public final synchronized e a(String r8) {
        monitor-enter(this);
        G();     // Catch: Throwable -> L34
        z(r8);     // Catch: Throwable -> L34
        f r10 = this.f10351u.get(r8);     // Catch: Throwable -> L34
        if (r10 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (r10.f10365c == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        InputStream[] r11 = new InputStream[this.f10347q];     // Catch: Throwable -> L34
        int r12 = 0;
        int r13 = 0;
    L40:
        if (r13 >= this.f10347q) goto L18;
        r11[r13] = new FileInputStream(r10.a(r13));     // Catch: FileNotFoundException -> L37 Throwable -> L34
        r13 = r13 + 1;
        goto L40
    L18:
        this.f10352v++;     // Catch: Throwable -> L34
        this.f10349s.append("READ " + r8 + '\n');     // Catch: Throwable -> L34
        if (E() == false) goto L21;
        A().submit(this.f10354x);     // Catch: Throwable -> L34
    L21:
        e r14 = new e(r11);     // Catch: Throwable -> L34
        monitor-exit(this);
        return r14;
    L25:
        if (r12 >= this.f10347q) goto L32;
        InputStream r15 = r11[r12];     // Catch: Throwable -> L34
        if (r15 == null) goto L32;
        r15.close();     // Catch: Exception -> L38 RuntimeException -> L30 Throwable -> L34
    L30:
        e = move-exception;
        throw e;     // Catch: Throwable -> L34
    L29:
        r12 = r12 + 1;
    L32:
        monitor-exit(this);
        return null;
    L34:
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
        if (this.f10349s != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r8 = new ArrayList(this.f10351u.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r8.hasNext() == false) goto L13;
        d r10 = ((f) r8.next()).f10366d;     // Catch: Throwable -> L16
        if (r10 == null) goto L9;
        r(r10.f10360d, r10, false);     // Catch: Throwable -> L16
        goto L9
    L13:
        H();     // Catch: Throwable -> L16
        this.f10349s.close();     // Catch: Throwable -> L16
        this.f10349s = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final d v(String r8) {
        monitor-enter(this);
        G();     // Catch: Throwable -> L14
        z(r8);     // Catch: Throwable -> L14
        f r10 = this.f10351u.get(r8);     // Catch: Throwable -> L14
        if (r10 != null) goto L7;
        r10 = new f(this, r8);     // Catch: Throwable -> L14
        this.f10351u.put(r8, r10);     // Catch: Throwable -> L14
    L10:
        d r11 = new d(this, r10);     // Catch: Throwable -> L14
        r10.f10366d = r11;     // Catch: Throwable -> L14
        this.f10349s.write("DIRTY " + r8 + '\n');     // Catch: Throwable -> L14
        this.f10349s.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r11;
    L7:
        if (r10.f10366d == null) goto L10;
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void x(String r8) {
        monitor-enter(this);
        G();     // Catch: Throwable -> L26
        z(r8);     // Catch: Throwable -> L26
        f r10 = this.f10351u.get(r8);     // Catch: Throwable -> L26
        if (r10 != null) goto L6;
    L24:
        monitor-exit(this);
        return;
    L6:
        if (r10.f10366d != null) goto L24;
        int r11 = 0;
    L10:
        if (r11 >= this.f10347q) goto L19;
        File r12 = r10.a(r11);     // Catch: Throwable -> L26
        if (r12.exists() == false) goto L18;
        if (r12.delete() == true) goto L18;
        throw new IOException("failed to delete ".concat(String.valueOf(r12)));     // Catch: Throwable -> L26
    L18:
        long r13 = this.f10348r;     // Catch: Throwable -> L26
        long[] r14 = r10.f10364b;     // Catch: Throwable -> L26
        this.f10348r = r13 - r14[r11];     // Catch: Throwable -> L26
        r14[r11] = 0;     // Catch: Throwable -> L26
        r11 = r11 + 1;     // Catch: Throwable -> L26
        goto L10
    L19:
        this.f10352v++;     // Catch: Throwable -> L26
        this.f10349s.append("REMOVE " + r8 + '\n');     // Catch: Throwable -> L26
        this.f10351u.remove(r8);     // Catch: Throwable -> L26
        if (E() == false) goto L22;
        A().submit(this.f10354x);     // Catch: Throwable -> L26
    L22:
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    }
}
