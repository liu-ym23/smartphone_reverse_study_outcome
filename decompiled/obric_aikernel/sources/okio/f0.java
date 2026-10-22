package okio;

import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public interface f0 extends Closeable {
    long S(d r10, long r11);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    g0 timeout();
}
