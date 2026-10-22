package com.tom_roush.pdfbox.io;

import android.util.Log;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f16123b;
    private long c;
    private int d;
    private long e;
    private byte[] f;
    private int g;
    private boolean h;
    private int[] i;
    private int j;

    j(i r3) {
        this.c = 0;
        this.h = false;
        this.i = new int[16];
        this.j = 0;
        r3.d();
        this.f16123b = r3;
        this.f16122a = r3.c();
        g();
    }

    private boolean a(boolean r8) {
        if (this.g >= this.f16122a) goto L5;
    L13:
        return true;
    L5:
        if (this.h == false) goto L7;
        this.f16123b.a(this.i[this.d], this.f);
        this.h = false;
    L7:
        int r0 = this.d;
        if ((r0 + 1) >= this.j) goto L10;
        i r9 = this.f16123b;
        int[] r3 = this.i;
        int r1 = r0 + 1;
        this.d = r1;
        this.f = r9.a(r3[r1]);
        this.e = ((long) this.d) * ((long) this.f16122a);
        this.g = 0;
        goto L13
    L10:
        if (r8 == false) goto L12;
        g();
        goto L13
    L12:
        return false;
    }

    private void f() {
        i r1 = this.f16123b;
        if (r1 == null) goto L7;
        r1.d();
        return;
    L7:
        throw new IOException("Buffer already closed");
    }

    private void g() {
        int r0 = this.j;
        int r1 = r0 + 1;
        int[] r2 = this.i;
        if (r1 < r2.length) goto L12;
        int r3 = r2.length * 2;
        if (r3 < r2.length) goto L7;
    L11:
        int[] r4 = new int[r3];
        System.arraycopy(r2, 0, r4, 0, r0);
        this.i = r4;
        goto L12
    L7:
        if (r2.length == Integer.MAX_VALUE) goto L10;
        r3 = Integer.MAX_VALUE;
        goto L11
    L10:
        throw new IOException("Maximum buffer size reached.");
    L12:
        int r5 = this.f16123b.b();
        int[] r6 = this.i;
        int r7 = this.j;
        r6[r7] = r5;
        this.d = r7;
        int r8 = this.f16122a;
        this.e = ((long) r7) * ((long) r8);
        this.j = r7 + 1;
        this.f = new byte[r8];
        this.g = 0;
    }

    @Override // com.tom_roush.pdfbox.io.g
    public long a() {
        f();
        return this.e + ((long) this.g);
    }

    @Override // com.tom_roush.pdfbox.io.g
    public void a(int r5) {
        a((this.e + ((long) this.g)) - ((long) r5));
    }

    @Override // com.tom_roush.pdfbox.io.g
    public void a(long r7) {
        f();
        if (r7 > this.c) goto L25;
        if (r7 < 0) goto L23;
        long r2 = this.e;
        if (r7 < r2) goto L13;
        if (r7 > (((long) this.f16122a) + r2)) goto L13;
        long r8 = r7 - r2;
    L11:
        this.g = (int) r8;
        return;
    L13:
        if (this.h == false) goto L15;
        this.f16123b.a(this.i[this.d], this.f);
        this.h = false;
    L15:
        int r3 = this.f16122a;
        int r4 = (int) (r7 / ((long) r3));
        if ((r7 % ((long) r3)) == 0) goto L18;
    L20:
        this.f = this.f16123b.a(this.i[r4]);
        this.d = r4;
        long r0 = ((long) r4) * ((long) this.f16122a);
        this.e = r0;
        r8 = r7 - r0;
        goto L11
    L18:
        if (r7 != this.c) goto L20;
        r4 = r4 - 1;
        goto L20
    L23:
        throw new IOException("Negative seek offset: " + r7);
    L25:
        throw new EOFException();
    }

    @Override // com.tom_roush.pdfbox.io.h
    public void a(byte[] r3) {
        a(r3, 0, r3.length);
    }

    @Override // com.tom_roush.pdfbox.io.h
    public void a(byte[] r5, int r6, int r7) {
        f();
    L3:
        if (r7 <= 0) goto L5;
        a(true);
        int r1 = Math.min(r7, this.f16122a - this.g);
        System.arraycopy(r5, r6, this.f, this.g, r1);
        this.g += r1;
        this.h = true;
        r6 = r6 + r1;
        r7 = r7 - r1;
        goto L3
    L5:
        long r8 = this.e;
        int r9 = this.g;
        if ((((long) r9) + r8) <= this.c) goto L10;
        this.c = r8 + ((long) r9);
        return;
    }

    @Override // com.tom_roush.pdfbox.io.g
    public long b() {
        return this.c;
    }

    @Override // com.tom_roush.pdfbox.io.g
    public byte[] b(int r4) {
        byte[] r0 = new byte[r4];
        int r1 = 0;
    L3:
        int r2 = read(r0, r1, r4 - r1);
        if (r2 < 0) goto L9;
        r1 = r1 + r2;
        if (r1 < r4) goto L3;
        return r0;
    L9:
        throw new EOFException();
    }

    @Override // com.tom_roush.pdfbox.io.h
    public void c(int r9) {
        f();
        a(true);
        byte[] r1 = this.f;
        int r2 = this.g;
        int r3 = r2 + 1;
        this.g = r3;
        r1[r2] = (byte) r9;
        this.h = true;
        long r0 = this.e;
        if ((((long) r3) + r0) <= this.c) goto L6;
        this.c = r0 + ((long) r3);
        return;
    }

    @Override // com.tom_roush.pdfbox.io.g
    public boolean c() {
        if (this.f16123b != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        i r0 = this.f16123b;
        if (r0 == null) goto L6;
        r0.a(this.i, 0, this.j);
        this.f16123b = null;
        this.i = null;
        this.f = null;
        this.e = 0;
        this.d = -1;
        this.g = 0;
        this.c = 0;
        return;
    }

    @Override // com.tom_roush.pdfbox.io.g
    public int d() {
        int r0 = read();
        if (r0 == (-1)) goto L5;
        a(1);
    L5:
        return r0;
    }

    @Override // com.tom_roush.pdfbox.io.g
    public boolean e() {
        f();
        if ((this.e + ((long) this.g)) < this.c) goto L5;
        return true;
    L5:
        return false;
    }

    public void finalize() {
    L10:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.f16123b != null) goto L5;
    L7:
        close();     // Catch: Throwable -> L10
        super.finalize();
        return;
    L5:
        if (PDFBoxConfig.b() == false) goto L7;
        Log.d("PdfBox-Android", "ScratchFileBuffer not closed!");     // Catch: Throwable -> L10
        goto L7
    }

    @Override // com.tom_roush.pdfbox.io.g
    public int read() {
        f();
        if ((this.e + ((long) this.g)) < this.c) goto L7;
        return -1;
    L7:
        if (a(false) == false) goto L11;
        byte[] r0 = this.f;
        int r1 = this.g;
        this.g = r1 + 1;
        return r0[r1] & 255;
    L11:
        throw new IOException("Unexpectedly no bytes available for read in buffer.");
    }

    @Override // com.tom_roush.pdfbox.io.g
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // com.tom_roush.pdfbox.io.g
    public int read(byte[] r10, int r11, int r12) {
        f();
        long r0 = this.e;
        int r2 = this.g;
        long r3 = ((long) r2) + r0;
        long r5 = this.c;
        if (r3 < r5) goto L6;
        return -1;
    L6:
        int r13 = (int) Math.min(r12, r5 - (r0 + ((long) r2)));
        int r1 = 0;
    L7:
        if (r13 <= 0) goto L13;
        if (a(false) == false) goto L12;
        int r4 = Math.min(r13, this.f16122a - this.g);
        System.arraycopy(this.f, this.g, r10, r11, r4);
        this.g += r4;
        r1 = r1 + r4;
        r11 = r11 + r4;
        r13 = r13 - r4;
        goto L7
    L12:
        throw new IOException("Unexpectedly no bytes available for read in buffer.");
    L13:
        return r1;
    }
}
