package okhttp3.internal.ws;

import f4.b;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nu.j;
import nu.s;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/ws/MessageInflater;", "Ljava/io/Closeable;", "", "noContextTakeover", "<init>", "(Z)V", "Lnu/j;", "buffer", "", "inflate", "(Lnu/j;)V", "close", "()V", "deflatedBytes", "Lnu/j;", "Ljava/util/zip/Inflater;", "inflater", "Ljava/util/zip/Inflater;", "Lnu/s;", "inflaterSource", "Lnu/s;", "Z", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class MessageInflater implements Closeable {
    private final j deflatedBytes;
    private final Inflater inflater;
    private final s inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean r5) {
        this.noContextTakeover = r5;
        j r10 = new j();
        this.deflatedBytes = r10;
        Inflater r11 = new Inflater(true);
        this.inflater = r11;
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "inflater");
        this.inflaterSource = new s(b.e(r10), r11);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public final void inflate(j r10) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "buffer");
        if (this.deflatedBytes.f20328b != 0) goto L12;
        if (this.noContextTakeover == false) goto L7;
        this.inflater.reset();
    L7:
        this.deflatedBytes.G(r10);
        this.deflatedBytes.W(65535);
        long r5 = this.inflater.getBytesRead() + this.deflatedBytes.f20328b;
    L8:
        this.inflaterSource.b(r10, Long.MAX_VALUE);
        if (this.inflater.getBytesRead() < r5) goto L8;
        return;
    L12:
        throw new IllegalArgumentException("Failed requirement.");
    }
}
