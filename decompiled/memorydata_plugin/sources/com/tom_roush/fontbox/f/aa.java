package com.tom_roush.fontbox.f;

import java.io.File;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes6.dex */
class aa extends ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RandomAccessFile f15967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f15968b;

    aa(File r3, String r4) {
        this.f15967a = null;
        this.f15968b = null;
        this.f15967a = new a(r3, r4, 16384);
        this.f15968b = r3;
    }

    @Override // com.tom_roush.fontbox.f.ad
    public int a(byte[] r1, int r2, int r3) {
        return this.f15967a.read(r1, r2, r3);
    }

    @Override // com.tom_roush.fontbox.f.ad
    public long a() {
        return this.f15967a.readLong();
    }

    @Override // com.tom_roush.fontbox.f.ad
    public void a(long r1) {
        this.f15967a.seek(r1);
    }

    @Override // com.tom_roush.fontbox.f.ad
    public int c() {
        return this.f15967a.read();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        RandomAccessFile r0 = this.f15967a;
        if (r0 == null) goto L6;
        r0.close();
        this.f15967a = null;
        return;
    }

    @Override // com.tom_roush.fontbox.f.ad
    public int d() {
        return this.f15967a.readUnsignedShort();
    }

    @Override // com.tom_roush.fontbox.f.ad
    public short e() {
        return this.f15967a.readShort();
    }

    @Override // com.tom_roush.fontbox.f.ad
    public long f() {
        return this.f15967a.getFilePointer();
    }

    @Override // com.tom_roush.fontbox.f.ad
    public long g() {
        return this.f15968b.length();
    }
}
