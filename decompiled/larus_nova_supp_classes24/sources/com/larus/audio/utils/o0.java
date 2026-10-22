package com.larus.audio.utils;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o0 implements Closeable {
    public static final Pattern p = null;
    public static final b q = null;
    public final File a;
    public final PolarisFileWrapper b;
    public final PolarisFileWrapper c;
    public final PolarisFileWrapper d;
    public final int e;
    public final long f;
    public final int g;
    public final int h;
    public long i;
    public Writer j;
    public final LinkedHashMap<String, d> k;
    public int l;
    public long m;
    public final PThreadPoolExecutor n;
    public final a o;

    public class a implements Callable<Void> {
        public final /* synthetic */ o0 a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            o0 r0 = this.a;
            monitor-enter(r0);
            o0 r1 = this.a;     // Catch: Throwable -> L16
            if (r1.j != null) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L16
            return null;
        L8:
            r1.n();     // Catch: Throwable -> L16
            this.a.m();     // Catch: Throwable -> L16
            o0 r2 = this.a;     // Catch: Throwable -> L16
            if (r2.l < 2000) goto L11;
            boolean r3 = true;
        L12:
            if (r3 == false) goto L14;
            r2.j();     // Catch: Throwable -> L16
            this.a.l = 0;     // Catch: Throwable -> L16
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return null;
        L11:
            r3 = false;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        public a(o0 r1) {
            this.a = r1;
        }
    }

    public class b extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int r1) throws IOException {
        }

        public b() {
        }
    }

    public final class c {
        public final d a;
        public final boolean[] b;
        public boolean c;
        public final /* synthetic */ o0 d;

        public final class a extends FilterOutputStream {
            public final /* synthetic */ c a;

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

            public a(c r1, PolarisFileOutputStreamWrapper r2) {
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

        public final void a() throws IOException {
            o0.a(this.d, this, false);
        }

        public final OutputStream b() throws IOException {
            o0 r0 = this.d;
            if (r0.h <= 0) goto L27;
            monitor-enter(r0);
            d r1 = this.a;     // Catch: Throwable -> L23
            if (r1.d != this) goto L22;
            if (r1.c == true) goto L10;
            this.b[0] = true;     // Catch: Throwable -> L23
        L10:
            PolarisFileWrapper r2 = r1.b(0);     // Catch: Throwable -> L23
            PolarisFileOutputStreamWrapper r3 = new PolarisFileOutputStreamWrapper(r2, true);     // Catch: FileNotFoundException -> L13 Throwable -> L23
        L15:
            a r4 = new a(this, r3);     // Catch: Throwable -> L23
            monitor-exit(r0);     // Catch: Throwable -> L23
            return r4;
        L13:
            this.d.a.mkdirs();     // Catch: Throwable -> L23
            r3 = new PolarisFileOutputStreamWrapper(r2, true);     // Catch: FileNotFoundException -> L18 Throwable -> L23
        L20:
            return o0.q;
        L22:
            throw new IOException("currentEditor changed");     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            throw th;
        L27:
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.d.h);
        }

        public c(o0 r1, d r2) {
            this.d = r1;
            this.a = r2;
            if (r2.c == false) goto L5;
            boolean[] r3 = null;
        L6:
            this.b = r3;
            return;
        L5:
            r3 = new boolean[r1.h];
            goto L6
        }
    }

    public final class d {
        public final String a;
        public final long[] b;
        public boolean c;
        public c d;
        public final /* synthetic */ o0 e;

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

        public final PolarisFileWrapper a(int r6) {
            File r1 = this.e.a;
            StringBuilder r2 = new StringBuilder();
            r2.append(this.a);
            if (r6 <= 1) goto L5;
            String r7 = "." + r6;
        L6:
            r2.append(r7);
            return new PolarisFileWrapper(r1, r2.toString());
        L5:
            r7 = "";
            goto L6
        }

        public final PolarisFileWrapper b(int r7) {
            File r1 = this.e.a;
            StringBuilder r2 = new StringBuilder();
            r2.append(this.a);
            String r4 = ".tmp";
            if (r7 <= 1) goto L5;
            r4 = "." + r7 + ".tmp";
        L5:
            r2.append(r4);
            return new PolarisFileWrapper(r1, r2.toString());
        }

        public d(o0 r1, String r2) {
            this.e = r1;
            this.a = r2;
            this.b = new long[r1.h];
        }
    }

    public final class e implements Closeable {
        public final InputStream[] a;
        public final File[] b;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r0 = this.a;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            k0.a(r0[r2]);
            r2 = r2 + 1;
            goto L3
        }

        public e(InputStream[] r1, File[] r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.j != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r0 = new ArrayList(this.k.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r0.hasNext() == false) goto L13;
        c r1 = ((d) r0.next()).d;     // Catch: Throwable -> L16
        if (r1 == null) goto L9;
        r1.a();     // Catch: Throwable -> L16
        goto L9
    L13:
        n();     // Catch: Throwable -> L16
        m();     // Catch: Throwable -> L16
        this.j.close();     // Catch: Throwable -> L16
        this.j = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public void delete() throws IOException {
        delete(false);
    }

    public final synchronized void j() throws IOException {
        monitor-enter(this);
        Writer r0 = this.j;     // Catch: Throwable -> L24
        if (r0 == null) goto L6;
        r0.close();     // Catch: Throwable -> L24
    L6:
        BufferedWriter r1 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.c), StandardCharsets.US_ASCII));     // Catch: Throwable -> L24
        r1.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write("1");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write(Integer.toString(this.e));     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write(Integer.toString(this.h));     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        Iterator<d> r2 = this.k.values().iterator();     // Catch: Throwable -> L21
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
        l(this.b, this.d, true);     // Catch: Throwable -> L24
    L18:
        l(this.c, this.b, false);     // Catch: Throwable -> L24
        this.d.delete();     // Catch: Throwable -> L24
        this.j = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.b, true), StandardCharsets.US_ASCII));     // Catch: Throwable -> L24
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
        p = PatternProtector.compile("[a-zA-Z0-9\\._-]+");
        q = new b();
    }

    public final void b() {
        if (this.j == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    public final void g() throws IOException {
        c(this.c);
        Iterator<d> r0 = this.k.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        d r1 = r0.next();
        int r3 = 0;
        if (r1.d == null) goto L8;
        r1.d = null;
    L12:
        if (r3 >= this.h) goto L14;
        c(r1.a(r3));
        c(r1.b(r3));
        r3 = r3 + 1;
        goto L12
    L14:
        r0.remove();
    L8:
        if (r3 >= this.h) goto L4;
        this.i += r1.b[r3];
        r3 = r3 + 1;
        goto L8
    }

    public final void h() throws IOException {
        b1 r2 = new b1(new PolarisFileInputStreamWrapper(this.b), StandardCharsets.US_ASCII);
        String r3 = r2.a();     // Catch: Throwable -> L26
        String r4 = r2.a();     // Catch: Throwable -> L26
        String r5 = r2.a();     // Catch: Throwable -> L26
        String r6 = r2.a();     // Catch: Throwable -> L26
        String r7 = r2.a();     // Catch: Throwable -> L26
        if ("libcore.io.DiskLruCache".equals(r3) == false) goto L25;
        if ("1".equals(r4) == false) goto L25;
        if (Integer.toString(this.e).equals(r5) == false) goto L25;
        if (Integer.toString(this.h).equals(r6) == false) goto L25;
        if ("".equals(r7) == false) goto L25;
        boolean r0 = false;
        int r1 = 0;
    L29:
        i(r2.a());     // Catch: EOFException -> L16 Throwable -> L26
        r1 = r1 + 1;
        goto L29
    L16:
        this.l = r1 - this.k.size();     // Catch: Throwable -> L26
        if (r2.e != (-1)) goto L19;
        r0 = true;
    L19:
        if (r0 == false) goto L21;
        j();     // Catch: Throwable -> L26
    L22:
        k0.a(r2);
        return;
    L21:
        this.j = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.b, true), StandardCharsets.US_ASCII));     // Catch: Throwable -> L26
    L25:
        throw new IOException("unexpected journal header: [" + r3 + ", " + r4 + ", " + r6 + ", " + r7 + "]");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        k0.a(r2);
        throw th;
    }

    public final void m() throws IOException {
    L3:
        if (this.k.size() <= this.g) goto L5;
        k(this.k.entrySet().iterator().next().getKey());
        goto L3
    }

    public final void n() throws IOException {
    L3:
        if (this.i <= this.f) goto L5;
        k(this.k.entrySet().iterator().next().getKey());
        goto L3
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

    public static void p(String r3) {
        if (p.matcher(r3).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-zA-Z0-9\\._-]+: \"" + r3 + "\"");
    }

    public final c d(String r5) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L14
        p(r5);     // Catch: Throwable -> L14
        d r1 = this.k.get(r5);     // Catch: Throwable -> L14
        if (r1 != null) goto L7;
        r1 = new d(this, r5);     // Catch: Throwable -> L14
        this.k.put(r5, r1);     // Catch: Throwable -> L14
    L11:
        c r2 = new c(this, r1);     // Catch: Throwable -> L14
        r1.d = r2;     // Catch: Throwable -> L14
        this.j.write("DIRTY " + r5 + '\n');     // Catch: Throwable -> L14
        this.j.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
    L13:
        return r2;
    L7:
        r2 = r1.d;     // Catch: Throwable -> L14
        if (r2 == null) goto L11;
        monitor-exit(this);
    L14:
        th = move-exception;
        throw th;
    }

    public void delete(boolean r2) throws IOException {
        close();
        p0.b(this.a, r2);
    }

    public final synchronized e e(String r9) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L34
        p(r9);     // Catch: Throwable -> L34
        d r0 = this.k.get(r9);     // Catch: Throwable -> L34
        if (r0 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (r0.c == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        int r2 = this.h;     // Catch: Throwable -> L34
        InputStream[] r3 = new InputStream[r2];     // Catch: Throwable -> L34
        File[] r4 = new File[r2];     // Catch: Throwable -> L34
        int r5 = 0;
        int r6 = 0;
    L39:
        if (r6 >= this.h) goto L18;
        r3[r6] = new PolarisFileInputStreamWrapper(r0.a(r6));     // Catch: FileNotFoundException -> L37 Throwable -> L34
        r4[r6] = r0.a(r6);     // Catch: FileNotFoundException -> L37 Throwable -> L34
        r6 = r6 + 1;
        goto L39
    L18:
        this.l++;     // Catch: Throwable -> L34
        this.j.append("READ " + r9 + '\n');     // Catch: Throwable -> L34
        if (this.l < 2000) goto L21;
        r5 = 1;
    L21:
        if (r5 == 0) goto L23;
        this.n.submit(this.o);     // Catch: Throwable -> L34
    L23:
        e r10 = new e(r3, r4);     // Catch: Throwable -> L34
        monitor-exit(this);
        return r10;
    L27:
        if (r5 >= this.h) goto L32;
        InputStream r11 = r3[r5];     // Catch: Throwable -> L34
        if (r11 == null) goto L32;
        k0.a(r11);     // Catch: Throwable -> L34
        r5 = r5 + 1;
    L32:
        monitor-exit(this);
        return null;
    L34:
        th = move-exception;
        throw th;
    }

    public final void i(String r8) throws IOException {
        int r1 = r8.indexOf(32);
        if (r1 == (-1)) goto L47;
        int r4 = r1 + 1;
        int r0 = r8.indexOf(32, r4);
        if (r0 != (-1)) goto L12;
        String r5 = r8.substring(r4);
        if (r1 == 6) goto L9;
    L13:
        d r6 = this.k.get(r5);
        if (r6 != null) goto L17;
        r6 = new d(this, r5);
        this.k.put(r5, r6);
    L17:
        if (r0 == (-1)) goto L32;
        if (r1 != 5) goto L32;
        if (r8.startsWith("CLEAN") == false) goto L32;
        String[] r9 = r8.substring(r0 + 1).split(" ");
        r6.c = true;
        r6.d = null;
        if (r9.length != r6.e.h) goto L31;
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
        c68.b.a("AudioDiskLruCache", "This work was already done by calling lruEntries.get()");
        return;
    L45:
        throw new IOException("unexpected journal line: ".concat(r8));
    L9:
        if (r8.startsWith("REMOVE") == false) goto L13;
        this.k.remove(r5);
        return;
    L12:
        r5 = r8.substring(r4, r0);
        goto L13
    L47:
        throw new IOException("unexpected journal line: ".concat(r8));
    }

    public final synchronized void k(String r9) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L28
        p(r9);     // Catch: Throwable -> L28
        d r0 = this.k.get(r9);     // Catch: Throwable -> L28
        if (r0 != null) goto L6;
    L26:
        monitor-exit(this);
        return;
    L6:
        if (r0.d != null) goto L26;
        boolean r1 = false;
        int r2 = 0;
    L10:
        if (r2 >= this.h) goto L19;
        PolarisFileWrapper r3 = r0.a(r2);     // Catch: Throwable -> L28
        if (r3.exists() == false) goto L18;
        if (r3.delete() == true) goto L18;
        throw new IOException("failed to delete " + r3);     // Catch: Throwable -> L28
    L18:
        long r4 = this.i;     // Catch: Throwable -> L28
        long[] r5 = r0.b;     // Catch: Throwable -> L28
        this.i = r4 - r5[r2];     // Catch: Throwable -> L28
        r5[r2] = 0;     // Catch: Throwable -> L28
        r2 = r2 + 1;     // Catch: Throwable -> L28
        goto L10
    L19:
        this.l++;     // Catch: Throwable -> L28
        this.j.append("REMOVE " + r9 + '\n');     // Catch: Throwable -> L28
        this.k.remove(r9);     // Catch: Throwable -> L28
        if (this.l < 2000) goto L22;
        r1 = true;
    L22:
        if (r1 == false) goto L24;
        this.n.submit(this.o);     // Catch: Throwable -> L28
    L24:
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public o0(PolarisFileWrapper r17, int r19) {
        this.i = 0;
        this.k = new LinkedHashMap(0, 0.75f, true);
        this.m = 0;
        this.o = new a(this);
        this.a = r17;
        this.e = 0;
        this.b = new PolarisFileWrapper(r17, "journal");
        this.c = new PolarisFileWrapper(r17, "journal.tmp");
        this.d = new PolarisFileWrapper(r17, "journal.bkp");
        this.h = 1;
        this.f = 52428800;
        this.g = r19;
        PThreadPoolExecutor r1 = new PThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new n0());
        this.n = r1;
        r1.allowCoreThreadTimeOut(true);
    }

    public static o0 f(PolarisFileWrapper r4, int r5) throws IOException {
        if (r5 <= 0) goto L18;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r4, "journal.bkp");
        if (r0.exists() == false) goto L9;
        PolarisFileWrapper r1 = new PolarisFileWrapper(r4, "journal");
        if (r1.exists() == false) goto L8;
        r0.delete();
        goto L9
    L8:
        l(r0, r1, false);
    L9:
        o0 r2 = new o0(r4, r5);
        if (r2.b.exists() == true) goto L19;
    L15:
        r4.mkdirs();
        o0 r3 = new o0(r4, r5);
        r3.j();
        return r3;
    L19:
        r2.h();     // Catch: IOException -> L13
        r2.g();     // Catch: IOException -> L13
        return r2;
    L13:
        e = move-exception;
        int r6 = c68.b.a;
        c68.b.b("AudioDiskLruCache", "DiskLruCache " + r4 + " is corrupt: " + e.getMessage() + ", removing");
        r2.delete();
        goto L15
    L18:
        throw new IllegalArgumentException("maxItemSize <= 0");
    }

    public static void a(o0 r8, c r9, boolean r10) throws IOException {
        monitor-enter(r8);
        d r0 = r9.a;     // Catch: Throwable -> L51
        if (r0.d != r9) goto L50;
        boolean r1 = false;
        if (r10 == true) goto L8;
    L22:
        int r11 = 0;
    L24:
        if (r11 >= r8.h) goto L32;
        PolarisFileWrapper r2 = r0.b(r11);     // Catch: Throwable -> L51
        if (r10 == true) goto L28;
        c(r2);     // Catch: Throwable -> L51
    L31:
        r11 = r11 + 1;     // Catch: Throwable -> L51
        goto L24
    L28:
        if (r2.exists() == false) goto L31;
        PolarisFileWrapper r3 = r0.a(r11);     // Catch: Throwable -> L51
        p0.c(r2, r3);     // Catch: Throwable -> L51
        long r4 = r0.b[r11];     // Catch: Throwable -> L51
        long r5 = r3.length();     // Catch: Throwable -> L51
        r0.b[r11] = r5;     // Catch: Throwable -> L51
        r8.i = (r8.i - r4) + r5;     // Catch: Throwable -> L51
        goto L31
    L32:
        r8.l++;     // Catch: Throwable -> L51
        r0.d = null;     // Catch: Throwable -> L51
        if ((r0.c | r10) == false) goto L37;
        r0.c = true;     // Catch: Throwable -> L51
        r8.j.write("CLEAN " + r0.a + r0.c() + '\n');     // Catch: Throwable -> L51
        if (r10 == false) goto L38;
        r8.m++;     // Catch: Throwable -> L51
        r0.getClass();     // Catch: Throwable -> L51
    L38:
        r8.j.flush();     // Catch: Throwable -> L51
        if (r8.i <= r8.f) goto L41;
    L46:
        r8.n.submit(r8.o);     // Catch: Throwable -> L51
    L47:
        monitor-exit(r8);
        return;
    L41:
        if (r8.l < 2000) goto L43;
        r1 = true;
    L43:
        if (r1 == true) goto L46;
        if (r8.k.size() <= r8.g) goto L47;
    L37:
        r8.k.remove(r0.a);     // Catch: Throwable -> L51
        r8.j.write("REMOVE " + r0.a + '\n');     // Catch: Throwable -> L51
        goto L38
    L8:
        if (r0.c == true) goto L22;
        int r6 = 0;
    L11:
        if (r6 >= r8.h) goto L22;
        if (r9.b[r6] == false) goto L20;
        if (r0.b(r6).exists() == false) goto L16;
        r6 = r6 + 1;
        goto L11
    L16:
        r9.a();     // Catch: Throwable -> L51
        monitor-exit(r8);
        return;
    L20:
        r9.a();     // Catch: Throwable -> L51
        throw new IOException("Newly created entry didn't create value for index " + r6);     // Catch: Throwable -> L51
    L50:
        throw new IOException();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    }

    public static void l(PolarisFileWrapper r0, PolarisFileWrapper r1, boolean r2) throws IOException {
        if (r2 == false) goto L5;
        c(r1);
    L5:
        if (p0.c(r0, r1) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }
}
