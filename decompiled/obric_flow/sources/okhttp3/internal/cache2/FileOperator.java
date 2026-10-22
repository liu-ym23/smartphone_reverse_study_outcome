package okhttp3.internal.cache2;

import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nu.j;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "Ljava/nio/channels/FileChannel;", "fileChannel", "<init>", "(Ljava/nio/channels/FileChannel;)V", "", OpenPageMethod.KEY_POS, "Lnu/j;", "source", "byteCount", "", "write", "(JLnu/j;J)V", "sink", "read", "Ljava/nio/channels/FileChannel;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel r5) {
        Intrinsics.checkNotNullParameter(r5, "fileChannel");
        this.fileChannel = r5;
    }

    public final void read(long r10, j r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "sink");
        if (r13 < 0) goto L9;
    L5:
        if (r13 <= 0) goto L7;
        long r5 = this.fileChannel.transferTo(r10, r13, r12);
        r10 = r10 + r5;
        r13 = r13 - r5;
        goto L5
    L7:
        return;
    L9:
        throw new IndexOutOfBoundsException();
    }

    public final void write(long r10, j r12, long r13) throws IOException {
        Intrinsics.checkNotNullParameter(r12, "source");
        if (r13 < 0) goto L11;
        if (r13 > r12.f20328b) goto L11;
    L7:
        if (r13 <= 0) goto L9;
        long r5 = this.fileChannel.transferFrom(r12, r10, r13);
        r10 = r10 + r5;
        r13 = r13 - r5;
        goto L7
    L9:
        return;
    L11:
        throw new IndexOutOfBoundsException();
    }
}
