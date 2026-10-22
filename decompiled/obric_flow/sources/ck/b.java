package ck;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends BufferedInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1214b;

    public b(InputStream r5) {
        super(r5, 1024);
    }

    public final synchronized a b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f1213a == true) goto L16;
        if (this.f1214b == true) goto L14;
        this.f1213a = true;     // Catch: Throwable -> L11
        int r5 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;     // Catch: Throwable -> L11
        byte[] r10 = new byte[r5];     // Catch: Throwable -> L11
        System.arraycopy(((BufferedInputStream) this).buf, ((BufferedInputStream) this).pos, r10, 0, r5);     // Catch: Throwable -> L11
        ((BufferedInputStream) this).pos = 0;     // Catch: Throwable -> L11
        ((BufferedInputStream) this).count = 0;     // Catch: Throwable -> L11
        a r11 = new a(new InputStream[]{new ByteArrayInputStream(r10), ((BufferedInputStream) this).in});     // Catch: Throwable -> L11
        monitor-exit(this);
        return r11;
    L14:
        throw new IllegalStateException();     // Catch: Throwable -> L11
    L16:
        throw new IllegalStateException();     // Catch: Throwable -> L11
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f1213a == true) goto L11;
        this.f1214b = true;     // Catch: Throwable -> L8
        super.mark(r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L8
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f1213a == true) goto L11;
        this.f1214b = false;     // Catch: Throwable -> L8
        super.reset();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException();     // Catch: Throwable -> L8
    }
}
