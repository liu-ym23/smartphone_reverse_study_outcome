package com.tom_roush.fontbox.f;

import java.io.File;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes6.dex */
public class a extends RandomAccessFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f15965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15966b;
    private int c;
    private long d;

    public a(File r1, String r2, int r3) {
        super(r1, r2);
        this.f15966b = 0;
        this.c = 0;
        this.d = 0;
        this.f15965a = new byte[r3];
    }

    private int a() {
        int r0 = super.read(this.f15965a);
        if (r0 < 0) goto L5;
        this.d += (long) r0;
        this.f15966b = r0;
        this.c = 0;
    L5:
        return r0;
    }

    private void b() {
        this.f15966b = 0;
        this.c = 0;
        this.d = super.getFilePointer();
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() {
        return (this.d - ((long) this.f15966b)) + ((long) this.c);
    }

    @Override // java.io.RandomAccessFile
    public final int read() {
        if (this.c < this.f15966b) goto L8;
        if (a() >= 0) goto L8;
        return -1;
    L8:
        if (this.f15966b != 0) goto L10;
        return -1;
    L10:
        byte[] r0 = this.f15965a;
        int r1 = this.c;
        this.c = r1 + 1;
        return (r0[r1] + 256) & 255;
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] r5, int r6, int r7) {
        int r0 = 0;
    L3:
        int r1 = this.f15966b;
        int r2 = this.c;
        int r3 = r1 - r2;
        if (r7 <= r3) goto L5;
        System.arraycopy(this.f15965a, r2, r5, r6, r3);
        r0 = r0 + r3;
        this.c += r3;
        if (a() <= 0) goto L10;
        r6 = r6 + r3;
        r7 = r7 - r3;
        goto L3
    L10:
        if (r0 != 0) goto L13;
        return -1;
    L13:
        return r0;
    L5:
        System.arraycopy(this.f15965a, r2, r5, r6, r7);
        this.c += r7;
        return r0 + r7;
    }

    @Override // java.io.RandomAccessFile
    public void seek(long r3) {
        int r0 = (int) (this.d - r3);
        if (r0 < 0) goto L7;
        int r1 = this.f15966b;
        if (r0 > r1) goto L7;
        this.c = r1 - r0;
        return;
    L7:
        super.seek(r3);
        b();
    }
}
