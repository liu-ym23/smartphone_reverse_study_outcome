package androidx.room.util;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RestrictTo;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "FileUtil")
public final class FileUtil {
    @SuppressLint({"LambdaLast"})
    public static final void copy(ReadableByteChannel r10, FileChannel r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r11, "output");
    L13:
        th = move-exception;
        r10.close();
        r11.close();
        throw th;
    L4:
        if (Build.VERSION.SDK_INT <= 23) goto L6;
        r11.transferFrom(r10, 0, Long.MAX_VALUE);     // Catch: Throwable -> L13
    L10:
        r11.force(false);     // Catch: Throwable -> L13
        r10.close();
        r11.close();
        return;
    L6:
        InputStream r12 = Channels.newInputStream(r10);     // Catch: Throwable -> L13
        OutputStream r13 = Channels.newOutputStream(r11);     // Catch: Throwable -> L13
        byte[] r14 = new byte[4096];     // Catch: Throwable -> L13
    L7:
        int r15 = r12.read(r14);     // Catch: Throwable -> L13
        if (r15 <= 0) goto L10;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L13
        goto L7
    }
}
