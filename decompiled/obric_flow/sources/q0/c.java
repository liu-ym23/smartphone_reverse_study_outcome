package q0;

import ai.j0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21447b;

    public c(InputStream r5, long r10) {
        super(r5);
        this.f21446a = r10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        monitor-enter(this);
        int r5 = (int) Math.max(this.f21446a - ((long) this.f21447b), ((FilterInputStream) this).in.available());
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(int r10) {
        if (r10 < 0) goto L4;
        this.f21447b += r10;
        return;
    L4:
        long r5 = this.f21447b;
        long r11 = this.f21446a;
        if ((r11 - r5) <= 0) goto L9;
        StringBuilder r12 = j0.t(r11, "Failed to read all expected data, expected: ", ", but read: ");
        r12.append(this.f21447b);
        throw new IOException(r12.toString());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        monitor-enter(this);
        int r5 = super.read();     // Catch: Throwable -> L10
        if (r5 < 0) goto L6;
        int r10 = 1;
    L7:
        b(r10);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r5;
    L6:
        r10 = -1;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r5) {
        return read(r5, 0, r5.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] r5, int r10, int r11) {
        monitor-enter(this);
        int r12 = super.read(r5, r10, r11);     // Catch: Throwable -> L6
        b(r12);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }
}
