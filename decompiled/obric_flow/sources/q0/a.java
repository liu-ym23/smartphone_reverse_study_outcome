package q0;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f21443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21444b;

    public a(ByteBuffer r5) {
        this.f21444b = -1;
        this.f21443a = r5;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f21443a.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int r5) {
        monitor-enter(this);
        this.f21444b = this.f21443a.position();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer r5 = this.f21443a;
        if (r5.hasRemaining() == true) goto L7;
        return -1;
    L7:
        return r5.get() & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        monitor-enter(this);
        int r5 = this.f21444b;     // Catch: Throwable -> L8
        if (r5 == (-1)) goto L11;
        this.f21443a.position(r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("Cannot reset to unset mark position");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final long skip(long r5) {
        ByteBuffer r10 = this.f21443a;
        if (r10.hasRemaining() == true) goto L6;
        return -1;
    L6:
        long r11 = Math.min(r5, r10.remaining());
        r10.position((int) (((long) r10.position()) + r11));
        return r11;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
        ByteBuffer r12 = this.f21443a;
        if (r12.hasRemaining() == true) goto L6;
        return -1;
    L6:
        int r13 = Math.min(r11, r12.remaining());
        r12.get(r5, r10, r13);
        return r13;
    }
}
