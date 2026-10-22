package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import nu.g;
import nu.j;
import nu.n;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "", "noContextTakeover", "<init>", "(Z)V", "Lnu/j;", "Lokio/ByteString;", "suffix", "endsWith", "(Lnu/j;Lokio/ByteString;)Z", "buffer", "", "deflate", "(Lnu/j;)V", "close", "()V", "deflatedBytes", "Lnu/j;", "Ljava/util/zip/Deflater;", "deflater", "Ljava/util/zip/Deflater;", "Lnu/n;", "deflaterSink", "Lnu/n;", "Z", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class MessageDeflater implements Closeable {
    private final j deflatedBytes;
    private final Deflater deflater;
    private final n deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean r5) {
        this.noContextTakeover = r5;
        j r10 = new j();
        this.deflatedBytes = r10;
        Deflater r11 = new Deflater(-1, true);
        this.deflater = r11;
        this.deflaterSink = new n(r10, r11);
    }

    private final boolean endsWith(j r10, ByteString r11) {
        long r5 = r10.f20328b - ((long) r11.size());
        Intrinsics.checkNotNullParameter(r11, "bytes");
        int r12 = r11.size();
        Intrinsics.checkNotNullParameter(r11, "bytes");
        if (r5 < 0) goto L20;
        if (r12 >= 0) goto L6;
        return false;
    L6:
        if ((r10.f20328b - r5) >= r12) goto L8;
        return false;
    L8:
        if (r11.size() < r12) goto L23;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L16;
        if (r10.m(((long) r13) + r5) != r11.getByte(r13)) goto L24;
        r13 = r13 + 1;
        goto L11
    L24:
        return false;
    L16:
        return true;
    L23:
        return false;
    L20:
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.deflaterSink.close();
    }

    public final void deflate(j r10) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "buffer");
        if (this.deflatedBytes.f20328b != 0) goto L21;
        if (this.noContextTakeover == false) goto L7;
        this.deflater.reset();
    L7:
        this.deflaterSink.write(r10, r10.f20328b);
        this.deflaterSink.flush();
        if (endsWith(this.deflatedBytes, MessageDeflaterKt.access$getEMPTY_DEFLATE_BLOCK$p()) == false) goto L17;
        j r5 = this.deflatedBytes;
        long r11 = r5.f20328b - ((long) 4);
        g r12 = new g();
        r5.J(r12);
        r12.b(r11);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r12, null);
    L18:
        j r13 = this.deflatedBytes;
        r10.write(r13, r13.f20328b);
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L17:
        this.deflatedBytes.T(0);
        goto L18
    L21:
        throw new IllegalArgumentException("Failed requirement.");
    }
}
