package androidx.exifinterface.media;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
class ExifInterfaceUtils {
    private static final String TAG = "ExifInterfaceUtils";

    static class Api21Impl {
        private Api21Impl() {
        }

        static void close(FileDescriptor r0) {
            Os.close(r0);
        }

        static FileDescriptor dup(FileDescriptor r0) {
            return Os.dup(r0);
        }

        static long lseek(FileDescriptor r0, long r1, int r3) {
            return Os.lseek(r0, r1, r3);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static void setDataSource(MediaMetadataRetriever r0, MediaDataSource r1) {
            r0.setDataSource(r1);
        }
    }

    private ExifInterfaceUtils() {
    }

    static String byteArrayToHexString(byte[] r5) {
        StringBuilder r0 = new StringBuilder(r5.length * 2);
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L7;
        r0.append(String.format("%02x", new Object[]{Byte.valueOf(r5[r2])}));
        r2 = r2 + 1;
        goto L4
    L7:
        return r0.toString();
    }

    static void closeFileDescriptor(FileDescriptor r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L10;
        String r4 = "closeFileDescriptor is called in API < 21, which must be wrong.";
    L8:
        Log.e(TAG, r4);
        return;
    L10:
        Api21Impl.close(r3);     // Catch: Exception -> L6
        return;
    L6:
        r4 = "Error closing fd.";
        goto L8
    }

    static void closeQuietly(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        return;
    L10:
        r3.close();     // Catch: RuntimeException -> L6 Exception -> L9
        goto L13
    L12:
        return;
    L6:
        e = move-exception;
        throw e;
    }

    static long[] convertToLongArray(Object r4) {
        if ((r4 instanceof int[]) == false) goto L10;
        int[] r5 = (int[]) ZeusTransformUtils.preCheckCast(r4, int[].class, "com.obric.memorydata.plugin");
        long[] r0 = new long[r5.length];
        int r1 = 0;
    L6:
        if (r1 >= r5.length) goto L8;
        r0[r1] = r5[r1];
        r1 = r1 + 1;
        goto L6
    L8:
        return r0;
    L10:
        if ((r4 instanceof long[]) == true) goto L12;
        return null;
    L12:
        return (long[]) ZeusTransformUtils.preCheckCast(r4, long[].class, "com.obric.memorydata.plugin");
    }

    static int copy(InputStream r5, OutputStream r6) {
        byte[] r0 = new byte[8192];
        int r2 = 0;
    L3:
        int r3 = r5.read(r0);
        if (r3 == (-1)) goto L6;
        r2 = r2 + r3;
        r6.write(r0, 0, r3);
        goto L3
    L6:
        return r2;
    }

    static void copy(InputStream r5, OutputStream r6, int r7) {
        byte[] r1 = new byte[8192];
    L3:
        if (r7 <= 0) goto L9;
        int r2 = Math.min(r7, 8192);
        int r4 = r5.read(r1, 0, r2);
        if (r4 != r2) goto L8;
        r7 = r7 - r4;
        r6.write(r1, 0, r4);
        goto L3
    L8:
        throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
    }

    static long parseSubSeconds(String r6) {
        int r0 = Math.min(r6.length(), 3);     // Catch: NumberFormatException -> L6
        long r2 = Long.parseLong(r6.substring(0, r0));     // Catch: NumberFormatException -> L6
    L3:
        if (r0 >= 3) goto L5;
        r2 = r2 * 10;
        r0 = r0 + 1;
        goto L3
    L5:
        return r2;
    L6:
        return 0;
    }

    static boolean startsWith(byte[] r4, byte[] r5) {
        if (r4 == null) goto L18;
        if (r5 == null) goto L18;
        if (r4.length >= r5.length) goto L9;
        return false;
    L9:
        int r1 = 0;
    L11:
        if (r1 >= r5.length) goto L16;
        if (r4[r1] != r5[r1]) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }
}
