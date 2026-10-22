package id;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends InputStream {
    public final int a;
    public final InputStream b;
    public int c;
    public long d;

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.c < this.a) goto L6;
        return -1;
    L6:
        long r0 = System.nanoTime();
        int r10 = this.b.read();
        this.d += System.nanoTime() - r0;
        if (r10 < 0) goto L9;
        this.c++;
    L9:
        return r10;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r10) throws IOException {
        return read(r10, 0, r10.length);
    }

    public d(int r10, InputStream r11) {
        this.c = 0;
        this.a = r10;
        this.b = r11;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r10, int r11, int r12) throws IOException {
        int r0 = this.a - this.c;
        if (r0 > 0) goto L6;
        return -1;
    L6:
        if (r0 >= r12) goto L8;
        r12 = r0;
    L8:
        long r1 = System.nanoTime();
        int r13 = this.b.read(r10, r11, r12);
        this.d += System.nanoTime() - r1;
        if (r13 < 0) goto L11;
        this.c += r13;
    L11:
        return r13;
    }
}
