package q0;

import com.bumptech.glide.load.resource.bitmap.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class d extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayDeque f21448c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f21449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IOException f21450b;

    static {
        char[] r5 = i.f21459a;
        f21448c = new ArrayDeque(0);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f21449a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f21449a.close();
    }

    @Override // java.io.InputStream
    public final void mark(int r5) {
        this.f21449a.mark(r5);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        this.f21449a.getClass();
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5) {
        return this.f21449a.read(r5);
    L4:
        e = move-exception;
        this.f21450b = e;
        return -1;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        monitor-enter(this);
        this.f21449a.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final long skip(long r5) {
        return this.f21449a.skip(r5);
    L4:
        e = move-exception;
        this.f21450b = e;
        return 0;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
        return this.f21449a.read(r5, r10, r11);
    L4:
        e = move-exception;
        this.f21450b = e;
        return -1;
    }

    @Override // java.io.InputStream
    public final int read() {
        return this.f21449a.read();
    L4:
        e = move-exception;
        this.f21450b = e;
        return -1;
    }
}
