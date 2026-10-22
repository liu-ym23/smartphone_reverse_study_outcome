package kotlinx.metadata.internal.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19146b;

    public a(q0.d r5) {
        this.f19145a = 1;
        super(r5);
        this.f19146b = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        switch(this.f19145a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        int r5 = this.f19146b;
        if (r5 != Integer.MIN_VALUE) goto L8;
        return super.available();
    L8:
        return Math.min(r5, super.available());
    L10:
        return Math.min(super.available(), this.f19146b);
    }

    public long b(long r5) {
        int r10 = this.f19146b;
        if (r10 != 0) goto L7;
        return -1;
    L7:
        if (r10 != Integer.MIN_VALUE) goto L9;
    L12:
        return r5;
    L9:
        if (r5 <= r10) goto L12;
        return r10;
    }

    public void d(long r5) {
        int r10 = this.f19146b;
        if (r10 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (r5 == (-1)) goto L9;
        this.f19146b = (int) (((long) r10) - r5);
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r5) {
        switch(this.f19145a) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.mark(r5);
        return;
    L6:
        monitor-enter(this);
        super.mark(r5);     // Catch: Throwable -> L10
        this.f19146b = r5;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        switch(this.f19145a) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (b(1) != (-1)) goto L7;
        return -1;
    L7:
        int r5 = super.read();
        d(1);
        return r5;
    L10:
        if (this.f19146b > 0) goto L12;
        return -1;
    L12:
        int r10 = super.read();
        if (r10 < 0) goto L16;
        this.f19146b--;
    L16:
        return r10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        switch(this.f19145a) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.reset();
        return;
    L6:
        monitor-enter(this);
        super.reset();     // Catch: Throwable -> L10
        this.f19146b = Integer.MIN_VALUE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long r5) {
        switch(this.f19145a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        long r10 = b(r5);
        if (r10 != (-1)) goto L7;
        return 0;
    L7:
        long r11 = super.skip(r10);
        d(r11);
        return r11;
    L9:
        long r12 = super.skip(Math.min(r5, this.f19146b));
        if (r12 < 0) goto L12;
        this.f19146b = (int) (((long) this.f19146b) - r12);
    L12:
        return r12;
    }

    public a(InputStream r5, int r10) {
        this.f19145a = 0;
        super(r5);
        this.f19146b = r10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
        switch(this.f19145a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        int r12 = (int) b(r11);
        if (r12 == (-1)) goto L17;
        int r13 = super.read(r5, r10, r12);
        d(r13);
        return r13;
    L17:
        return -1;
    L9:
        int r14 = this.f19146b;
        if (r14 > 0) goto L12;
        return -1;
    L12:
        int r15 = super.read(r5, r10, Math.min(r11, r14));
        if (r15 < 0) goto L16;
        this.f19146b -= r15;
    L16:
        return r15;
    }
}
