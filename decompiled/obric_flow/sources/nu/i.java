package nu;

import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f20326a;

    public i(j r5) {
        this.f20326a = r5;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }

    public final String toString() {
        return this.f20326a + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int r5) {
        this.f20326a.T(r5);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "data");
        this.f20326a.S(r5, r10, r11);
    }
}
