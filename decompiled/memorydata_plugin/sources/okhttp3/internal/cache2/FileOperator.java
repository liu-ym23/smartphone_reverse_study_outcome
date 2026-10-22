package okhttp3.internal.cache2;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "fileChannel", "Ljava/nio/channels/FileChannel;", "(Ljava/nio/channels/FileChannel;)V", "read", "", "pos", "", "sink", "Lokio/Buffer;", "byteCount", "write", AILabCheckPermissionTask.KEY_SOURCE, "okhttp"}, k = 1, mv = {1, 1, 15})
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel r2) {
        Intrinsics.checkParameterIsNotNull(r2, "fileChannel");
        this.fileChannel = r2;
    }

    public final void read(long r11, Buffer r13, long r14) {
        Intrinsics.checkParameterIsNotNull(r13, "sink");
        if (r14 < 0) goto L9;
    L5:
        if (r14 <= 0) goto L7;
        long r5 = r11;
        long r7 = r14;
        long r4 = this.fileChannel.transferTo(r5, r7, (WritableByteChannel) ZeusTransformUtils.preCheckCast(r13, WritableByteChannel.class, "com.obric.memorydata.plugin"));
        r11 = r11 + r4;
        r14 = r14 - r4;
        goto L5
    L7:
        return;
    L9:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IndexOutOfBoundsException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void write(long r11, Buffer r13, long r14) {
        Intrinsics.checkParameterIsNotNull(r13, AILabCheckPermissionTask.KEY_SOURCE);
        if (r14 < 0) goto L11;
        if (r14 > r13.size()) goto L11;
    L7:
        if (r14 <= 0) goto L9;
        long r4 = this.fileChannel.transferFrom((ReadableByteChannel) ZeusTransformUtils.preCheckCast(r13, ReadableByteChannel.class, "com.obric.memorydata.plugin"), r11, r14);
        r11 = r11 + r4;
        r14 = r14 - r4;
        goto L7
    L9:
        return;
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IndexOutOfBoundsException(), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
