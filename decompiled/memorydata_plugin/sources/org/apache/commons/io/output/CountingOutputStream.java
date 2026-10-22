package org.apache.commons.io.output;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class CountingOutputStream extends ProxyOutputStream {
    private long count;

    public CountingOutputStream(OutputStream r1) {
        super(r1);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream
    public synchronized void beforeWrite(int r5) {
        monitor-enter(this);
        this.count += (long) r5;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getByteCount() {
        monitor-enter(this);
        long r0 = this.count;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
