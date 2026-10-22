package a0;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    public static class a {
        public static ParcelFileDescriptor a(ContentResolver r8, Uri r10, String r11, CancellationSignal r12) {
            return r8.openFileDescriptor(r10, r11, r12);
        }
    }

    public static MappedByteBuffer a(Context r8, Uri r10) {
        ParcelFileDescriptor r11 = a.a(r8.getContentResolver(), r10, "r", null);     // Catch: IOException -> L25
        if (r11 != null) goto L33;
        if (r11 == null) goto L7;
        r11.close();     // Catch: IOException -> L25
    L7:
        return null;
    L33:
        FileInputStream r12 = new FileInputStream(r11.getFileDescriptor());     // Catch: Throwable -> L19
        FileChannel r13 = r12.getChannel();     // Catch: Throwable -> L13
        long r14 = r13.size();     // Catch: Throwable -> L13
        MappedByteBuffer r15 = r13.map(FileChannel.MapMode.READ_ONLY, 0, r14);     // Catch: Throwable -> L13
        r12.close();     // Catch: Throwable -> L19
        r11.close();     // Catch: IOException -> L25
        return r15;
    L13:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: IOException -> L25
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L25
    L25:
        return null;
    }
}
