package com.facebook.common.memory;

import androidx.room.jarjarred.org.antlr.runtime.a;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class PooledByteBufferInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PooledByteBuffer f7666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7668c;

    public PooledByteBufferInputStream(PooledByteBuffer r5) {
        if (r5.a() == true) goto L7;
        this.f7666a = r5;
        this.f7667b = 0;
        this.f7668c = 0;
        return;
    L7:
        throw new IllegalArgumentException();
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f7666a.size() - this.f7667b;
    }

    @Override // java.io.InputStream
    public final void mark(int r5) {
        this.f7668c = this.f7667b;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        int r5 = this.f7666a.size();
        int r10 = this.f7667b;
        if ((r5 - r10) > 0) goto L6;
        return -1;
    L6:
        PooledByteBuffer r11 = this.f7666a;
        this.f7667b = r10 + 1;
        return r11.a(r10) & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public final void reset() {
        this.f7667b = this.f7668c;
    }

    @Override // java.io.InputStream
    public final long skip(long r5) {
        if (r5 < 0) goto L7;
        int r10 = Math.min((int) r5, this.f7666a.size() - this.f7667b);
        this.f7667b += r10;
        return r10;
    L7:
        throw new IllegalArgumentException();
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5) {
        return read(r5, 0, r5.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
        if (r10 < 0) goto L15;
        if (r11 < 0) goto L15;
        if ((r10 + r11) > r5.length) goto L15;
        int r12 = this.f7666a.size() - this.f7667b;
        if (r12 > 0) goto L10;
        return -1;
    L10:
        if (r11 > 0) goto L13;
        return 0;
    L13:
        int r13 = Math.min(r12, r11);
        this.f7666a.a(this.f7667b, r5, r10, r13);
        this.f7667b += r13;
        return r13;
    L15:
        StringBuilder r14 = new StringBuilder("length=");
        a.C(r14, r5.length, "; regionStart=", r10, "; regionLength=");
        r14.append(r11);
        throw new ArrayIndexOutOfBoundsException(r14.toString());
    }
}
