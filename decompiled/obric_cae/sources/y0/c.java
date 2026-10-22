package y0;

import android.annotation.SuppressLint;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    @SuppressLint({"LambdaLast"})
    public static final void a(ReadableByteChannel r8, FileChannel r10) {
        r10.transferFrom(r8, 0, Long.MAX_VALUE);     // Catch: Throwable -> L6
        r10.force(false);     // Catch: Throwable -> L6
        r8.close();
        r10.close();
        return;
    L6:
        th = move-exception;
        r8.close();
        r10.close();
        throw th;
    }
}
