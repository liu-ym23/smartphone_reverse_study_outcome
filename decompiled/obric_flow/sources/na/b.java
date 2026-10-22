package na;

import com.bytedance.geckox.n;
import com.bytedance.geckox.o;
import com.bytedance.geckox.utils.c;
import com.bytedance.iesgurd.meta.PrepareMeta;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ta.a f20222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f20223c;
    public final la.a d;
    public final n e;
    public final PrepareMeta f;
    public final long g;

    public b(la.a r5, n r10, PrepareMeta r11, long r12) {
        this.d = r5;
        this.e = r10;
        this.f = r11;
        this.g = r12;
    }

    public final void b(int r10) {
        this.f20221a += (long) r10;
        long r5 = System.currentTimeMillis();
        if ((r5 - this.f20223c) < 100) goto L5;
    L7:
        this.f20223c = r5;
        this.f.getPack();
        n r11 = this.e;
        if (r11.f4760c == null) goto L12;
        ((Executor) c.e.getValue()).execute(new o(r11, 1));
        return;
    L12:
        return;
    L5:
        if (this.f20221a >= this.g) goto L7;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }

    @Override // java.io.OutputStream
    public final void write(int r5) {
        this.d.write(r5);
        b(4);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r5) {
        this.d.write(r5);
        b(r5.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r5, int r10, int r11) {
        this.d.write(r5, r10, r11);
        b(r11);
    }
}
