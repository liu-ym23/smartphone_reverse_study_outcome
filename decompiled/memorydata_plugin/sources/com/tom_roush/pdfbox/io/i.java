package com.tom_roush.pdfbox.io;

import android.util.Log;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.BitSet;

/* JADX INFO: loaded from: classes6.dex */
public class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f16120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f16121b;
    private File c;
    private RandomAccessFile d;
    private volatile int e;
    private final BitSet f;
    private volatile byte[][] g;
    private final int h;
    private final int i;
    private final boolean j;
    private final boolean k;
    private volatile boolean l;

    public i(b r12) {
        this.f16120a = new Object();
        this.e = 0;
        BitSet r1 = new BitSet();
        this.f = r1;
        this.l = false;
        boolean r3 = true;
        if (r12.b() == true) goto L5;
    L8:
        boolean r2 = true;
    L9:
        this.k = r2;
        if (r2 == true) goto L12;
    L14:
        r3 = false;
    L15:
        this.j = r3;
        if (r3 == false) goto L18;
        File r4 = r12.h();
    L19:
        this.f16121b = r4;
        if (r4 != null) goto L22;
    L26:
        int r8 = Integer.MAX_VALUE;
        if (r12.e() == false) goto L29;
        int r5 = (int) Math.min(2147483647L, r12.g() / 4096);
    L30:
        this.i = r5;
        if (r12.b() == true) goto L33;
        r8 = 0;
    L36:
        this.h = r8;
        if (r2 == true) goto L40;
        r8 = 100000;
    L40:
        this.g = new byte[r8][];
        r1.set(0, this.g.length);
        return;
    L33:
        if (r12.d() == false) goto L36;
        r8 = (int) Math.min(2147483647L, r12.f() / 4096);
        goto L36
    L29:
        r5 = Integer.MAX_VALUE;
        goto L30
    L22:
        if (r4.isDirectory() == true) goto L26;
        throw new IOException("Scratch file directory does not exist: " + r4);
    L18:
        r4 = null;
        goto L19
    L12:
        if (r12.c() == false) goto L14;
    L5:
        if (r12.d() == true) goto L8;
        r2 = false;
        goto L9
    }

    public static i a() {
        return new i(b.a());
    L4:
        e = move-exception;
        Log.e("PdfBox-Android", "Unexpected exception occurred creating main memory scratch file instance: " + e.getMessage());
        return null;
    }

    private void f() {
        Object r0 = this.f16120a;
        monitor-enter(r0);
        d();     // Catch: Throwable -> L43
        if (this.e < this.i) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L43
        return;
    L9:
        if (this.j == false) goto L37;
        if (this.d != null) goto L20;
        this.c = File.createTempFile("PDFBox", ".tmp", this.f16121b);     // Catch: Throwable -> L43
        this.d = new RandomAccessFile(this.c, "rw");     // Catch: IOException -> L15 Throwable -> L43
    L15:
        e = move-exception;
        if (this.c.delete() == true) goto L19;
        Log.w("PdfBox-Android", "Error deleting scratch file: " + this.c.getAbsolutePath());     // Catch: Throwable -> L43
    L19:
        throw e;     // Catch: Throwable -> L43
    L20:
        long r3 = this.d.length();     // Catch: Throwable -> L43
        long r5 = (((long) this.e) - ((long) this.h)) * 4096;     // Catch: Throwable -> L43
        if (r5 != r3) goto L35;
        if ((this.e + 16) > this.e) goto L25;
    L41:
        monitor-exit(r0);     // Catch: Throwable -> L43
        return;
    L25:
        if (PDFBoxConfig.b() == false) goto L27;
        Log.d("PdfBox-Android", "file: " + this.c);     // Catch: Throwable -> L43
        Log.d("PdfBox-Android", "fileLen before: " + r3 + ", raf length: " + this.d.length() + ", file length: " + this.c.length());     // Catch: Throwable -> L43
    L27:
        long r4 = r3 + 65536;     // Catch: Throwable -> L43
        this.d.setLength(r4);     // Catch: Throwable -> L43
        if (PDFBoxConfig.b() == false) goto L31;
        Log.d("PdfBox-Android", "fileLen after1: " + r4 + ", raf length: " + this.d.length() + ", file length: " + this.c.length());     // Catch: Throwable -> L43
    L31:
        if (r4 == this.d.length()) goto L33;
        long r6 = this.d.getFilePointer();     // Catch: Throwable -> L43
        this.d.seek(r4 - 1);     // Catch: Throwable -> L43
        this.d.write(0);     // Catch: Throwable -> L43
        this.d.seek(r6);     // Catch: Throwable -> L43
        Log.d("PdfBox-Android", "fileLen after2:  " + r4 + ", raf length: " + this.d.length() + ", file length: " + this.c.length());     // Catch: Throwable -> L43
    L33:
        this.f.set(this.e, this.e + 16);     // Catch: Throwable -> L43
        goto L41
    L35:
        throw new IOException("Expected scratch file size of " + r5 + " but found " + r3 + " in file " + this.c);     // Catch: Throwable -> L43
    L37:
        if (this.k == true) goto L41;
        int r1 = this.g.length;     // Catch: Throwable -> L43
        int r7 = (int) Math.min(((long) r1) * 2, 2147483647L);     // Catch: Throwable -> L43
        if (r7 <= r1) goto L41;
        byte[][] r8 = new byte[r7][];     // Catch: Throwable -> L43
        System.arraycopy(this.g, 0, r8, 0, r1);     // Catch: Throwable -> L43
        this.g = r8;     // Catch: Throwable -> L43
        this.f.set(r1, r7);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    }

    public c a(InputStream r4) {
        j r0 = new j(this);
        byte[] r3 = new byte[8192];
    L3:
        int r1 = r4.read(r3);
        if (r1 <= (-1)) goto L6;
        r0.a(r3, 0, r1);
        goto L3
    L6:
        r0.a(0);
        return r0;
    }

    void a(int r7, byte[] r8) {
        if (r7 >= 0) goto L4;
    L30:
        d();
        throw new IOException("Page index out of range: " + r7 + ". Max value: " + (this.e - 1));
    L4:
        if (r7 >= this.e) goto L30;
        if (r8.length != 4096) goto L29;
        if (r7 < this.h) goto L10;
        Object r0 = this.f16120a;
        monitor-enter(r0);
        d();     // Catch: Throwable -> L25
        this.d.seek((((long) r7) - ((long) this.h)) * 4096);     // Catch: Throwable -> L25
        this.d.write(r8);     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L10:
        if (this.k == false) goto L12;
        this.g[r7] = r8;
    L16:
        d();
        return;
    L12:
        Object r1 = this.f16120a;
        monitor-enter(r1);
        this.g[r7] = r8;     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L29:
        throw new IOException("Wrong page size to write: " + r8.length + ". Expected: 4096");
    }

    void a(int[] r5, int r6, int r7) {
        BitSet r0 = this.f;
        monitor-enter(r0);
    L4:
        if (r6 >= r7) goto L15;
        int r1 = r5[r6];     // Catch: Throwable -> L17
        if (r1 < 0) goto L14;
        if (r1 >= this.e) goto L14;
        if (this.f.get(r1) == true) goto L14;
        this.f.set(r1);     // Catch: Throwable -> L17
        if (r1 >= this.h) goto L14;
        this.g[r1] = null;     // Catch: Throwable -> L17
    L14:
        r6 = r6 + 1;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
    }

    byte[] a(int r8) {
        if (r8 >= 0) goto L4;
    L24:
        d();
        throw new IOException("Page index out of range: " + r8 + ". Max value: " + (this.e - 1));
    L4:
        if (r8 >= this.e) goto L24;
        if (r8 >= this.h) goto L12;
        byte[] r0 = this.g[r8];
        if (r0 == null) goto L10;
        return r0;
    L10:
        d();
        throw new IOException("Requested page with index " + r8 + " was not written before.");
    L12:
        Object r1 = this.f16120a;
        monitor-enter(r1);
        RandomAccessFile r2 = this.d;     // Catch: Throwable -> L21
        if (r2 == null) goto L19;
        byte[] r3 = new byte[4096];     // Catch: Throwable -> L21
        r2.seek((((long) r8) - ((long) this.h)) * 4096);     // Catch: Throwable -> L21
        this.d.readFully(r3);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r3;
    L19:
        d();     // Catch: Throwable -> L21
        throw new IOException("Missing scratch file to read page with index " + r8 + " from.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    int b() {
        BitSet r0 = this.f;
        monitor-enter(r0);
        int r1 = this.f.nextSetBit(0);     // Catch: Throwable -> L16
        if (r1 >= 0) goto L11;
        f();     // Catch: Throwable -> L16
        r1 = this.f.nextSetBit(0);     // Catch: Throwable -> L16
        if (r1 >= 0) goto L11;
        throw new IOException("Maximum allowed scratch file memory exceeded.");     // Catch: Throwable -> L16
    L11:
        this.f.clear(r1);     // Catch: Throwable -> L16
        if (r1 < this.e) goto L14;
        this.e = r1 + 1;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r1;
    L16:
        th = move-exception;
        throw th;
    }

    int c() {
        return 4096;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Object r0 = this.f16120a;
        monitor-enter(r0);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (this.l == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L8:
        this.l = true;     // Catch: Throwable -> L34
        RandomAccessFile r1 = this.d;     // Catch: Throwable -> L34
        if (r1 != null) goto L37;
    L14:
        e = null;
    L15:
        File r2 = this.c;     // Catch: Throwable -> L34
        if (r2 != null) goto L18;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L34
        BitSet r3 = this.f;
        monitor-enter(r3);
        this.f.clear();     // Catch: Throwable -> L31
        this.e = 0;     // Catch: Throwable -> L31
        monitor-exit(r3);     // Catch: Throwable -> L31
        if (e != null) goto L30;
        return;
    L30:
        throw e;
    L31:
        th = move-exception;
        throw th;
    L18:
        if (r2.delete() == true) goto L23;
        if (this.c.exists() == false) goto L23;
        if (e != null) goto L23;
        e = new IOException("Error deleting scratch file: " + this.c.getAbsolutePath());     // Catch: Throwable -> L34
        goto L23
    L37:
        r1.close();     // Catch: IOException -> L12 Throwable -> L34
    L12:
        e = e;
        goto L15
    }

    void d() {
        if (this.l == true) goto L6;
        return;
    L6:
        throw new IOException("Scratch file already closed");
    }

    public c e() {
        return new j(this);
    }
}
