package kotlinx.metadata.internal.protobuf;

import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.google.common.base.k f19155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x f19156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19157c;
    public int d;
    public int e;
    public int f;
    public final /* synthetic */ f0 g;

    public e0(f0 r5) {
        this.g = r5;
        com.google.common.base.k r10 = new com.google.common.base.k(r5);
        this.f19155a = r10;
        x r11 = r10.a();
        this.f19156b = r11;
        this.f19157c = r11.f19212b.length;
        this.d = 0;
        this.e = 0;
    }

    @Override // java.io.InputStream
    public final int available() {
        int r5 = this.e + this.d;
        return this.g.f19164b - r5;
    }

    public final void b() {
        if (this.f19156b == null) goto L11;
        int r5 = this.d;
        int r10 = this.f19157c;
        if (r5 != r10) goto L12;
        this.e += r10;
        this.d = 0;
        if (this.f19155a.hasNext() == false) goto L9;
        x r11 = this.f19155a.a();
        this.f19156b = r11;
        this.f19157c = r11.f19212b.length;
        return;
    L9:
        this.f19156b = null;
        this.f19157c = 0;
        return;
    L12:
        return;
    }

    public final int d(byte[] r5, int r10, int r11) {
        int r12 = r11;
    L3:
        if (r12 <= 0) goto L14;
        b();
        if (this.f19156b == null) goto L6;
        int r13 = Math.min(this.f19157c - this.d, r12);
        if (r5 == null) goto L12;
        this.f19156b.e(r5, this.d, r10, r13);
        r10 = r10 + r13;
    L12:
        this.d += r13;
        r12 = r12 - r13;
        goto L3
    L6:
        if (r12 != r11) goto L14;
        return -1;
    L14:
        return r11 - r12;
    }

    @Override // java.io.InputStream
    public final void mark(int r5) {
        this.f = this.e + this.d;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
        r5.getClass();
        if (r10 < 0) goto L10;
        if (r11 < 0) goto L10;
        if (r11 > (r5.length - r10)) goto L10;
        return d(r5, r10, r11);
    L10:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        monitor-enter(this);
        com.google.common.base.k r5 = new com.google.common.base.k(this.g);     // Catch: Throwable -> L6
        this.f19155a = r5;     // Catch: Throwable -> L6
        x r10 = r5.a();     // Catch: Throwable -> L6
        this.f19156b = r10;     // Catch: Throwable -> L6
        this.f19157c = r10.f19212b.length;     // Catch: Throwable -> L6
        this.d = 0;     // Catch: Throwable -> L6
        this.e = 0;     // Catch: Throwable -> L6
        d(null, 0, this.f);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final long skip(long r5) {
        if (r5 < 0) goto L10;
        if (r5 <= 2147483647L) goto L8;
        r5 = 2147483647L;
    L8:
        return d(null, 0, (int) r5);
    L10:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public final int read() {
        b();
        x r5 = this.f19156b;
        if (r5 != null) goto L6;
        return -1;
    L6:
        int r10 = this.d;
        this.d = r10 + 1;
        return r5.f19212b[r10] & UByte.MAX_VALUE;
    }
}
