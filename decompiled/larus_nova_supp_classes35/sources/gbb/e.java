package gbb;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
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
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class e implements Closeable {
    public static final Pattern o = null;
    public final File a;
    public final PolarisFileWrapper b;
    public final PolarisFileWrapper c;
    public final PolarisFileWrapper d;
    public final int e;
    public final long f;
    public final int g;
    public long h;
    public Writer i;
    public final LinkedHashMap<String, d> j;
    public int k;
    public long l;
    public final PThreadPoolExecutor m;
    public final b n;

    public class a extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int r1) throws IOException {
        }

        public a() {
        }
    }

    public final class b implements Callable<Void> {
        public final long a;
        public final /* synthetic */ e b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            e r0 = this.b;
            monitor-enter(r0);
            e r1 = this.b;     // Catch: Throwable -> L13
            if (r1.i != null) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L13
            return null;
        L8:
            r1.n(this.a);     // Catch: Throwable -> L13
            if (this.b.f() == false) goto L11;
            this.b.k();     // Catch: Throwable -> L13
            this.b.k = 0;     // Catch: Throwable -> L13
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return null;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        public b(e r1, long r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final class c {
        public final d a;
        public final boolean[] b;
        public final /* synthetic */ e c;

        public final void a() throws IOException {
            e.a(this.c, this, false);
        }

        public final PolarisFileWrapper b() throws IOException {
            e r0 = this.c;
            monitor-enter(r0);
            d r1 = this.a;     // Catch: Throwable -> L16
            if (r1.d != this) goto L15;
            if (r1.c == true) goto L9;
            this.b[0] = true;     // Catch: Throwable -> L16
        L9:
            PolarisFileWrapper r2 = r1.b(0);     // Catch: Throwable -> L16
            if (this.c.a.exists() == true) goto L12;
            this.c.a.mkdirs();     // Catch: Throwable -> L16
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return r2;
        L15:
            throw new IllegalStateException();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }

        public c(e r1, d r2) {
            this.c = r1;
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

    public final class d {
        public final String a;
        public final long[] b;
        public boolean c;
        public c d;
        public final /* synthetic */ e e;

        public final String c() throws IOException {
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

        public final PolarisFileWrapper b(int r5) {
            return new PolarisFileWrapper(this.e.a, this.a + "." + r5 + ".tmp");
        }

        public d(e r1, String r2) {
            this.e = r1;
            this.a = r2;
            this.b = new long[r1.g];
        }
    }

    /* JADX INFO: renamed from: gbb.e$e, reason: collision with other inner class name */
    public final class C0226e implements Closeable {
        public final InputStream[] a;
        public final d b;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r0 = this.a;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            g.a(r0[r2]);
            r2 = r2 + 1;
            goto L3
        }

        public C0226e(InputStream[] r1, d r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class f implements Closeable {
        public final InputStream a;
        public final Charset b;
        public byte[] c;
        public int d;
        public int e;

        public class a extends ByteArrayOutputStream {
            public final /* synthetic */ f a;

            @Override // java.io.ByteArrayOutputStream
            public final String toString() {
                int r0 = ((ByteArrayOutputStream) this).count;
                if (r0 > 0) goto L5;
            L12:
                return new String(((ByteArrayOutputStream) this).buf, 0, r0, this.a.b.name());
            L9:
                e = move-exception;
                throw new AssertionError(e);
            L5:
                if (((ByteArrayOutputStream) this).buf[r0 - 1] != 13) goto L12;
                r0 = r0 - 1;
                goto L12
            }

            public a(f r1, int r2) {
                this.a = r1;
                super(r2);
            }
        }

        public final String a() throws IOException {
            InputStream r0 = this.a;
            monitor-enter(r0);
            byte[] r1 = this.c;     // Catch: Throwable -> L47
            if (r1 == null) goto L46;
            if (this.d < this.e) goto L13;
            int r2 = this.a.read(r1, 0, r1.length);     // Catch: Throwable -> L47
            if (r2 == (-1)) goto L12;
            this.d = 0;     // Catch: Throwable -> L47
            this.e = r2;     // Catch: Throwable -> L47
            goto L13
        L12:
            throw new EOFException();     // Catch: Throwable -> L47
        L13:
            int r3 = this.d;     // Catch: Throwable -> L47
        L15:
            if (r3 == this.e) goto L28;
            byte[] r4 = this.c;     // Catch: Throwable -> L47
            if (r4[r3] == 10) goto L18;
            r3 = r3 + 1;     // Catch: Throwable -> L47
            goto L15
        L18:
            int r5 = this.d;     // Catch: Throwable -> L47
            if (r3 == r5) goto L23;
            int r6 = r3 - 1;     // Catch: Throwable -> L47
            if (r4[r6] != 13) goto L23;
        L24:
            String r7 = new String(r4, r5, r6 - r5, this.b.name());     // Catch: Throwable -> L47
            this.d = r3 + 1;     // Catch: Throwable -> L47
            monitor-exit(r0);     // Catch: Throwable -> L47
            return r7;
        L23:
            r6 = r3;
            goto L24
        L28:
            a r8 = new a(this, (this.e - this.d) + 80);     // Catch: Throwable -> L47
        L29:
            byte[] r9 = this.c;     // Catch: Throwable -> L47
            int r10 = this.d;     // Catch: Throwable -> L47
            r8.write(r9, r10, this.e - r10);     // Catch: Throwable -> L47
            this.e = -1;     // Catch: Throwable -> L47
            InputStream r11 = this.a;     // Catch: Throwable -> L47
            byte[] r12 = this.c;     // Catch: Throwable -> L47
            int r13 = r11.read(r12, 0, r12.length);     // Catch: Throwable -> L47
            if (r13 == (-1)) goto L44;
            this.d = 0;     // Catch: Throwable -> L47
            this.e = r13;     // Catch: Throwable -> L47
            int r14 = 0;
        L33:
            if (r14 == this.e) goto L29;
            byte[] r15 = this.c;     // Catch: Throwable -> L47
            if (r15[r14] == 10) goto L36;
            r14 = r14 + 1;     // Catch: Throwable -> L47
            goto L33
        L36:
            int r16 = this.d;     // Catch: Throwable -> L47
            if (r14 == r16) goto L39;
            r8.write(r15, r16, r14 - r16);     // Catch: Throwable -> L47
        L39:
            this.d = r14 + 1;     // Catch: Throwable -> L47
            String r17 = r8.toString();     // Catch: Throwable -> L47
            monitor-exit(r0);     // Catch: Throwable -> L47
            return r17;
        L44:
            throw new EOFException();     // Catch: Throwable -> L47
        L46:
            throw new IOException("LineReader is closed");     // Catch: Throwable -> L47
        L47:
            th = move-exception;
            throw th;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            InputStream r0 = this.a;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.c == null) goto L7;
            this.c = null;     // Catch: Throwable -> L9
            this.a.close();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        public f(PolarisFileInputStreamWrapper r2, Charset r3) {
            if (r3 == null) goto L11;
            if (r3.equals(g.a) == false) goto L9;
            this.a = r2;
            this.b = r3;
            this.c = new byte[8192];
            return;
        L9:
            throw new IllegalArgumentException("Unsupported encoding");
        L11:
            throw null;
        }
    }

    public static final class g {
        public static final Charset a = null;

        static {
            a = Charset.forName("US-ASCII");
            Charset.forName("UTF-8");
        }

        public static void a(Closeable r2) {
            if (r2 != null) goto L10;
            return;
        L10:
            r2.close();     // Catch: Exception -> L5 RuntimeException -> L7
        L13:
            return;
        L7:
            e = move-exception;
            throw e;
        L5:
            e = move-exception;
            Log.d("DiskLruCache", "closeQuietly = " + e);
        }

        public static void b(File r4) throws IOException {
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
            throw new IOException("failed to delete file: " + r2);
        L14:
            return;
        L16:
            throw new IOException("not a readable directory: " + r4);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.i != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r0 = new ArrayList(this.j.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r0.hasNext() == false) goto L13;
        c r1 = ((d) r0.next()).d;     // Catch: Throwable -> L16
        if (r1 == null) goto L9;
        r1.a();     // Catch: Throwable -> L16
        goto L9
    L13:
        n(this.f);     // Catch: Throwable -> L16
        this.i.close();     // Catch: Throwable -> L16
        this.i = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final synchronized void k() throws IOException {
        monitor-enter(this);
        Writer r0 = this.i;     // Catch: Throwable -> L24
        if (r0 == null) goto L6;
        r0.close();     // Catch: Throwable -> L24
    L6:
        BufferedWriter r1 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.c), g.a));     // Catch: Throwable -> L24
        r1.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write("1");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write(Integer.toString(this.e));     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write(Integer.toString(this.g));     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        Iterator<d> r2 = this.j.values().iterator();     // Catch: Throwable -> L21
    L8:
        if (r2.hasNext() == false) goto L15;
        d r3 = r2.next();     // Catch: Throwable -> L21
        if (r3.d != null) goto L12;
        r1.write("CLEAN " + r3.a + r3.c() + '\n');     // Catch: Throwable -> L21
        goto L8
    L12:
        r1.write("DIRTY " + r3.a + '\n');     // Catch: Throwable -> L21
        goto L8
    L15:
        r1.close();     // Catch: Throwable -> L24
        if (this.b.exists() == false) goto L18;
        m(this.b, this.d, true);     // Catch: Throwable -> L24
    L18:
        m(this.c, this.b, false);     // Catch: Throwable -> L24
        this.d.delete();     // Catch: Throwable -> L24
        this.i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.b, true), g.a));     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    static {
        o = PatternProtector.compile("[a-z0-9_-]{1,64}");
        new a();
    }

    public final boolean f() {
        int r0 = this.k;
        if (r0 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r0 < this.j.size()) goto L7;
        return true;
    }

    public final void h() throws IOException {
        b(this.c);
        Iterator<d> r0 = this.j.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        d r1 = r0.next();
        int r3 = 0;
        if (r1.d == null) goto L8;
        r1.d = null;
    L12:
        if (r3 >= this.g) goto L14;
        b(r1.a(r3));
        b(r1.b(r3));
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

    public final void i() throws IOException {
        f r2 = new f(new PolarisFileInputStreamWrapper(this.b), g.a);
        String r3 = r2.a();     // Catch: Throwable -> L21
        String r4 = r2.a();     // Catch: Throwable -> L21
        String r5 = r2.a();     // Catch: Throwable -> L21
        String r6 = r2.a();     // Catch: Throwable -> L21
        String r7 = r2.a();     // Catch: Throwable -> L21
        if ("libcore.io.DiskLruCache".equals(r3) == false) goto L20;
        if ("1".equals(r4) == false) goto L20;
        if (Integer.toString(this.e).equals(r5) == false) goto L20;
        if (Integer.toString(this.g).equals(r6) == false) goto L20;
        if (BuildConfig.FLAVOR.equals(r7) == false) goto L20;
        int r0 = 0;
    L24:
        j(r2.a());     // Catch: EOFException -> L16 Throwable -> L21
        r0 = r0 + 1;
        goto L24
    L16:
        this.k = r0 - this.j.size();     // Catch: Throwable -> L21
        g.a(r2);
        return;
    L20:
        throw new IOException("unexpected journal header: [" + r3 + ", " + r4 + ", " + r6 + ", " + r7 + "]");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        g.a(r2);
        throw th;
    }

    public void delete() throws IOException {
        close();
        g.b(this.a);
    }

    public File e() {
        return this.a;
    }

    public static void b(PolarisFileWrapper r1) throws IOException {
        if (r1.exists() == true) goto L5;
        return;
    L5:
        if (r1.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static void p(String r3) {
        if (o.matcher(r3).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + r3 + "\"");
    }

    public final c c(String r5) throws IOException {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.i == null) goto L21;
        p(r5);     // Catch: Throwable -> L18
        d r2 = this.j.get(r5);     // Catch: Throwable -> L18
        if (r2 != null) goto L10;
        r2 = new d(this, r5);     // Catch: Throwable -> L18
        this.j.put(r5, r2);     // Catch: Throwable -> L18
    L14:
        c r1 = new c(this, r2);     // Catch: Throwable -> L18
        r2.d = r1;     // Catch: Throwable -> L18
        this.i.write("DIRTY " + r5 + '\n');     // Catch: Throwable -> L18
        this.i.flush();     // Catch: Throwable -> L18
        monitor-exit(this);
        return r1;
    L10:
        if (r2.d == null) goto L14;
        Log.e("DiskLruCache", "Another edit is in progress, " + r5);     // Catch: Throwable -> L18
        monitor-exit(this);
        return null;
    L21:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L18
    }

    public synchronized C0226e d(String r8) throws IOException {
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L4:
        if (this.i == null) goto L37;
        p(r8);     // Catch: Throwable -> L34
        d r0 = this.j.get(r8);     // Catch: Throwable -> L34
        if (r0 != null) goto L11;
        monitor-exit(this);
        return null;
    L11:
        if (r0.c == true) goto L14;
        monitor-exit(this);
        return null;
    L14:
        InputStream[] r2 = new InputStream[this.g];     // Catch: Throwable -> L34
        int r3 = 0;
        int r4 = 0;
    L41:
        if (r4 >= this.g) goto L20;
        r2[r4] = new PolarisFileInputStreamWrapper(r0.a(r4));     // Catch: FileNotFoundException -> L40 Throwable -> L34
        r4 = r4 + 1;
        goto L41
    L20:
        this.k++;     // Catch: Throwable -> L34
        this.i.append("READ " + r8 + '\n');     // Catch: Throwable -> L34
        if (f() == false) goto L23;
        this.m.submit(this.n);     // Catch: Throwable -> L34
    L23:
        C0226e r9 = new C0226e(r2, r0);     // Catch: Throwable -> L34
        monitor-exit(this);
        return r9;
    L27:
        if (r3 >= this.g) goto L32;
        InputStream r10 = r2[r3];     // Catch: Throwable -> L34
        if (r10 == null) goto L32;
        g.a(r10);     // Catch: Throwable -> L34
        r3 = r3 + 1;
    L32:
        monitor-exit(this);
        return null;
    L37:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L34
    }

    public final void j(String r8) throws IOException {
        int r1 = r8.indexOf(32);
        if (r1 == (-1)) goto L47;
        int r4 = r1 + 1;
        int r0 = r8.indexOf(32, r4);
        if (r0 != (-1)) goto L12;
        String r5 = r8.substring(r4);
        if (r1 == 6) goto L9;
    L13:
        d r6 = this.j.get(r5);
        if (r6 != null) goto L17;
        r6 = new d(this, r5);
        this.j.put(r5, r6);
    L17:
        if (r0 == (-1)) goto L32;
        if (r1 != 5) goto L32;
        if (r8.startsWith("CLEAN") == false) goto L32;
        String[] r9 = r8.substring(r0 + 1).split(" ");
        r6.c = true;
        r6.d = null;
        if (r9.length != r6.e.g) goto L31;
        int r2 = 0;
    L48:
        if (r2 >= r9.length) goto L52;
        r6.b[r2] = CastLongProtector.parseLong(r9[r2]);     // Catch: NumberFormatException -> L28
        r2 = r2 + 1;
        goto L48
    L52:
        return;
    L29:
        throw new IOException("unexpected journal line: " + Arrays.toString(r9));
    L31:
        throw new IOException("unexpected journal line: " + Arrays.toString(r9));
    L32:
        if (r0 != (-1)) goto L37;
        if (r1 != 5) goto L37;
        if (r8.startsWith("DIRTY") == false) goto L37;
        r6.d = new c(this, r6);
        return;
    L37:
        if (r0 != (-1)) goto L45;
        if (r1 != 4) goto L45;
        if (r8.startsWith("READ") == false) goto L45;
        Log.d("DiskLruCache", "This work was already done by calling lruEntries.get()");
        return;
    L45:
        throw new IOException("unexpected journal line: ".concat(r8));
    L9:
        if (r8.startsWith("REMOVE") == false) goto L13;
        this.j.remove(r5);
        return;
    L12:
        r5 = r8.substring(r4, r0);
        goto L13
    L47:
        throw new IOException("unexpected journal line: ".concat(r8));
    }

    public synchronized void l(String r8) throws IOException {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (this.i == null) goto L31;
        p(r8);     // Catch: Throwable -> L28
        d r0 = this.j.get(r8);     // Catch: Throwable -> L28
        if (r0 != null) goto L8;
    L26:
        monitor-exit(this);
        return;
    L8:
        if (r0.d != null) goto L26;
        int r1 = 0;
    L12:
        if (r1 >= this.g) goto L21;
        PolarisFileWrapper r2 = r0.a(r1);     // Catch: Throwable -> L28
        if (r2.exists() == false) goto L20;
        if (r2.delete() == true) goto L20;
        throw new IOException("failed to delete " + r2);     // Catch: Throwable -> L28
    L20:
        long r3 = this.h;     // Catch: Throwable -> L28
        long[] r4 = r0.b;     // Catch: Throwable -> L28
        this.h = r3 - r4[r1];     // Catch: Throwable -> L28
        r4[r1] = 0;     // Catch: Throwable -> L28
        r1 = r1 + 1;     // Catch: Throwable -> L28
        goto L12
    L21:
        this.k++;     // Catch: Throwable -> L28
        this.i.append("REMOVE " + r8 + '\n');     // Catch: Throwable -> L28
        this.j.remove(r8);     // Catch: Throwable -> L28
        if (f() == false) goto L24;
        this.m.submit(this.n);     // Catch: Throwable -> L28
    L24:
        monitor-exit(this);
        return;
    L31:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L28
    }

    public final void n(long r4) throws IOException {
    L3:
        if (this.h <= r4) goto L5;
        l(this.j.entrySet().iterator().next().getKey());
        goto L3
    }

    public e(File r17, int r18, long r19) {
        this.h = 0;
        this.j = new LinkedHashMap(0, 0.75f, true);
        this.l = 0;
        this.m = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("/DiskLruCache"));
        this.n = new b(this, this.f);
        this.a = r17;
        this.e = r18;
        this.b = new PolarisFileWrapper(r17, "journal");
        this.c = new PolarisFileWrapper(r17, "journal.tmp");
        this.d = new PolarisFileWrapper(r17, "journal.bkp");
        this.g = 1;
        this.f = r19;
    }

    public static void a(e r9, c r10, boolean r11) throws IOException {
        monitor-enter(r9);
        d r0 = r10.a;     // Catch: Throwable -> L46
        if (r0.d != r10) goto L45;
        int r1 = 0;
        if (r11 == false) goto L23;
        if (r0.c == true) goto L23;
        int r2 = 0;
    L11:
        if (r2 >= r9.g) goto L23;
        if (r10.b[r2] == false) goto L20;
        if (r0.b(r2).exists() == false) goto L16;
        r2 = r2 + 1;
        goto L11
    L16:
        r10.a();     // Catch: Throwable -> L46
        monitor-exit(r9);
        return;
    L20:
        r10.a();     // Catch: Throwable -> L46
        throw new IllegalStateException("Newly created entry didn't create value for index " + r2);     // Catch: Throwable -> L46
    L23:
        if (r1 >= r9.g) goto L31;
        PolarisFileWrapper r12 = r0.b(r1);     // Catch: Throwable -> L46
        if (r11 == true) goto L27;
        b(r12);     // Catch: Throwable -> L46
    L30:
        r1 = r1 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (r12.exists() == false) goto L30;
        PolarisFileWrapper r3 = r0.a(r1);     // Catch: Throwable -> L46
        r12.renameTo(r3);     // Catch: Throwable -> L46
        long r4 = r0.b[r1];     // Catch: Throwable -> L46
        long r5 = r3.length();     // Catch: Throwable -> L46
        r0.b[r1] = r5;     // Catch: Throwable -> L46
        r9.h = (r9.h - r4) + r5;     // Catch: Throwable -> L46
        goto L30
    L31:
        r9.k++;     // Catch: Throwable -> L46
        r0.d = null;     // Catch: Throwable -> L46
        if ((r0.c | r11) == false) goto L36;
        r0.c = true;     // Catch: Throwable -> L46
        r9.i.write("CLEAN " + r0.a + r0.c() + '\n');     // Catch: Throwable -> L46
        if (r11 == false) goto L37;
        r9.l++;     // Catch: Throwable -> L46
        r0.getClass();     // Catch: Throwable -> L46
    L37:
        r9.i.flush();     // Catch: Throwable -> L46
        if (r9.h <= r9.f) goto L40;
    L41:
        r9.m.submit(r9.n);     // Catch: Throwable -> L46
    L42:
        monitor-exit(r9);
        return;
    L40:
        if (r9.f() == false) goto L42;
    L36:
        r9.j.remove(r0.a);     // Catch: Throwable -> L46
        r9.i.write("REMOVE " + r0.a + '\n');     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    public static e g(PolarisFileWrapper r6, int r7, long r8) throws IOException {
        if (r8 <= 0) goto L19;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6, "journal.bkp");
        if (r0.exists() == false) goto L10;
        PolarisFileWrapper r1 = new PolarisFileWrapper(r6, "journal");
        if (r1.exists() == false) goto L9;
        r0.delete();
        goto L10
    L9:
        m(r0, r1, false);
    L10:
        e r2 = new e(r6, r7, r8);
        if (r2.b.exists() == true) goto L20;
    L16:
        r6.mkdirs();
        e r3 = new e(r6, r7, r8);
        r3.k();
        return r3;
    L20:
        r2.i();     // Catch: IOException -> L14
        r2.h();     // Catch: IOException -> L14
        r2.i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r2.b, true), g.a));     // Catch: IOException -> L14
        return r2;
    L14:
        e = move-exception;
        Log.e("DiskLruCache " + r6 + " is corrupt: " + e.getMessage() + ", removing");
        r2.delete();
        goto L16
    L19:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void m(PolarisFileWrapper r0, PolarisFileWrapper r1, boolean r2) throws IOException {
        if (r2 == false) goto L5;
        b(r1);
    L5:
        if (r0.renameTo(r1) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }
}
