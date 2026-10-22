package w6;

import com.bytedance.retrofit2.client.SsCall;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f13018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SsCall f13019b;

    public d(InputStream r8, SsCall r10) {
        this.f13018a = r8;
        this.f13019b = r10;
    }

    @Override // java.io.InputStream
    public final int available() {
        InputStream r8 = this.f13018a;
        if (r8 == null) goto L7;
        return r8.available();
    L7:
        return super.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream r8 = this.f13018a;     // Catch: Throwable -> L9
        if (r8 == null) goto L5;
        r8.close();     // Catch: Throwable -> L9
    L5:
        SsCall r10 = this.f13019b;     // Catch: Throwable -> L9
        if (r10 == null) goto L11;
        r10.cancel();     // Catch: Throwable -> L9
    L11:
        super.close();
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int r8) {
        monitor-enter(this);
        InputStream r10 = this.f13018a;     // Catch: Throwable -> L9
        if (r10 == null) goto L6;
        r10.mark(r8);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.mark(r8);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        InputStream r8 = this.f13018a;
        if (r8 == null) goto L7;
        return r8.markSupported();
    L7:
        return super.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() {
        InputStream r8 = this.f13018a;
        if (r8 != null) goto L5;
        return -1;
    L5:
        return r8.read();
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        monitor-enter(this);
        InputStream r8 = this.f13018a;     // Catch: Throwable -> L9
        if (r8 == null) goto L6;
        r8.reset();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.reset();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final long skip(long r8) {
        InputStream r10 = this.f13018a;
        if (r10 == null) goto L7;
        return r10.skip(r8);
    L7:
        return super.skip(r8);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r8) {
        InputStream r10 = this.f13018a;
        if (r10 == null) goto L7;
        return r10.read(r8);
    L7:
        return super.read(r8);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r8, int r10, int r11) {
        InputStream r12 = this.f13018a;
        if (r12 == null) goto L7;
        return r12.read(r8, r10, r11);
    L7:
        return super.read(r8, r10, r11);
    }
}
