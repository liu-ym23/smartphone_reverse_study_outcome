package db;

import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.gkfs.d f16628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16629c;
    public final GkFSBlockBuffer d;

    public b(int r5, GkFSBlockBuffer r10) {
        this.f16629c = r5;
        this.d = r10;
        this.f16628b = new com.bytedance.gkfs.d();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        com.bytedance.gkfs.d.c(this.f16628b, "CombinedChunkOutputStream", "Stream closed, totalWriteSize=" + this.f16627a, 0, 12);
        this.d.flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        this.d.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int r5) {
        write(new byte[r5]);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r5, int r10, int r11) {
        r5.getClass();
        if (r10 < 0) goto L19;
        if (r10 > r5.length) goto L19;
        if (r11 < 0) goto L19;
        int r12 = r10 + r11;
        if (r12 > r5.length) goto L19;
        if (r12 < 0) goto L19;
        if (r11 != 0) goto L13;
        return;
    L13:
        if (this.f16627a >= this.f16629c) goto L17;
        this.d.d(r5, r10, r11);
        this.f16627a += r11;
        return;
    L17:
        throw new IOException("Already write " + this.f16627a);
    L19:
        throw new IndexOutOfBoundsException();
    }
}
