package q0;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21445a = 0;

    static {
        new AtomicReference();
    }

    public static MappedByteBuffer a(File r10) {
        FileChannel r5 = null;
        long r11 = r10.length();     // Catch: Throwable -> L14
        if (r11 > 2147483647L) goto L19;
        if (r11 == 0) goto L17;
        RandomAccessFile r12 = new RandomAccessFile(r10, "r");     // Catch: Throwable -> L14
        r5 = r12.getChannel();     // Catch: Throwable -> L12
        MappedByteBuffer r13 = r5.map(FileChannel.MapMode.READ_ONLY, 0, r11).load();     // Catch: Throwable -> L12
        r5.close();     // Catch: IOException -> L25
    L34:
        r12.close();     // Catch: IOException -> L26
    L11:
        return r13;
    L12:
        th = th;
    L20:
        if (r5 != null) goto L38;
    L22:
        if (r12 == null) goto L40;
        r12.close();     // Catch: IOException -> L28
        throw th;
    L41:
        throw th;
    L40:
        throw th;
    L38:
        r5.close();     // Catch: IOException -> L27
        goto L22
    L17:
        throw new IOException("File unsuitable for memory mapping");     // Catch: Throwable -> L14
    L19:
        throw new IOException("File too large to map into memory");     // Catch: Throwable -> L14
    L14:
        th = th;
        r12 = null;
        goto L20
    }

    public static void b(ByteBuffer r5, File r10) {
        r5.position(0);
        FileChannel r11 = null;
        RandomAccessFile r12 = new RandomAccessFile(r10, "rw");     // Catch: Throwable -> L10
        r11 = r12.getChannel();     // Catch: Throwable -> L8
        r11.write(r5);     // Catch: Throwable -> L8
        r11.force(false);     // Catch: Throwable -> L8
        r11.close();     // Catch: Throwable -> L8
        r12.close();     // Catch: Throwable -> L8
        r11.close();     // Catch: IOException -> L17
    L27:
        r12.close();     // Catch: IOException -> L18
        return;
    L33:
        return;
    L8:
        th = th;
    L12:
        if (r11 != null) goto L31;
    L14:
        if (r12 == null) goto L34;
        r12.close();     // Catch: IOException -> L20
        throw th;
    L35:
        throw th;
    L34:
        throw th;
    L31:
        r11.close();     // Catch: IOException -> L19
    L10:
        th = th;
        r12 = null;
        goto L12
    }
}
