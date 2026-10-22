package androidx.room.util;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"copy", "", "input", "Ljava/nio/channels/ReadableByteChannel;", "output", "Ljava/nio/channels/FileChannel;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FileUtil {
    public static final void copy(ReadableByteChannel r9, FileChannel r10) {
        ReadableByteChannel r11 = (ReadableByteChannel) ZeusTransformUtils.wrapperContextForParams(r9, ReadableByteChannel.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "input");
        Intrinsics.checkNotNullParameter(r10, "output");
    L13:
        th = move-exception;
        r11.close();
        r10.close();
        throw th;
    L4:
        if (Build.VERSION.SDK_INT <= 23) goto L6;
        r10.transferFrom(r11, 0, Long.MAX_VALUE);     // Catch: Throwable -> L13
    L10:
        r10.force(false);     // Catch: Throwable -> L13
        r11.close();
        r10.close();
        return;
    L6:
        InputStream r0 = Channels.newInputStream(r11);     // Catch: Throwable -> L13
        OutputStream r1 = Channels.newOutputStream((WritableByteChannel) ZeusTransformUtils.preCheckCast(r10, WritableByteChannel.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
        byte[] r2 = new byte[4096];     // Catch: Throwable -> L13
    L7:
        int r3 = r0.read(r2);     // Catch: Throwable -> L13
        if (r3 <= 0) goto L10;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L13
        goto L7
    }
}
