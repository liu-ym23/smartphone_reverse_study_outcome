package com.tom_roush.pdfbox.pdfparser;

import java.io.EOFException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: loaded from: classes6.dex */
final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PushbackInputStream f16134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16135b;

    d(InputStream r3) {
        this.f16134a = new PushbackInputStream(r3, 32767);
        this.f16135b = 0;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public int a() {
        int r0 = this.f16134a.read();
        this.f16135b++;
        return r0;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public int a(byte[] r2) {
        int r3 = this.f16134a.read(r2);
        if (r3 <= 0) goto L6;
        this.f16135b += r3;
        return r3;
    L6:
        return -1;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public int a(byte[] r2, int r3, int r4) {
        int r5 = this.f16134a.read(r2, r3, r4);
        if (r5 <= 0) goto L6;
        this.f16135b += r5;
        return r5;
    L6:
        return -1;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public void a(int r2) {
        this.f16134a.unread(r2);
        this.f16135b--;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public long b() {
        return this.f16135b;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public void b(byte[] r2) {
        this.f16134a.unread(r2);
        this.f16135b -= r2.length;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public void b(byte[] r2, int r3, int r4) {
        this.f16134a.unread(r2, r3, r4);
        this.f16135b -= r4;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public byte[] b(int r4) {
        byte[] r0 = new byte[r4];
        int r1 = 0;
    L3:
        int r2 = a(r0, r1, r4 - r1);
        if (r2 < 0) goto L9;
        r1 = r1 + r2;
        if (r1 < r4) goto L3;
        return r0;
    L9:
        throw new EOFException();
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public int c() {
        int r0 = this.f16134a.read();
        if (r0 == (-1)) goto L5;
        this.f16134a.unread(r0);
    L5:
        return r0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f16134a.close();
    }

    @Override // com.tom_roush.pdfbox.pdfparser.j
    public boolean d() {
        if (c() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
