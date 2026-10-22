package com.ss.android.ttmd5;

import java.io.File;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes6.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RandomAccessFile f15732a;

    public a(File r3) {
        this.f15732a = new RandomAccessFile(r3, "r");
    }

    @Override // com.ss.android.ttmd5.b
    public int a(byte[] r1, int r2, int r3) {
        return this.f15732a.read(r1, r2, r3);
    }

    @Override // com.ss.android.ttmd5.b
    public long a() {
        return this.f15732a.length();
    }

    @Override // com.ss.android.ttmd5.b
    public void a(long r1, long r3) {
        this.f15732a.seek(r1);
    }

    @Override // com.ss.android.ttmd5.b
    public void b() {
        this.f15732a.close();
    }
}
