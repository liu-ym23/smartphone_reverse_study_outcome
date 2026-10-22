package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.provider.FontsContractCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static ParcelFileDescriptor openFileDescriptor(ContentResolver r10, Uri r11, String r12, CancellationSignal r13) {
            return r10.openFileDescriptor(r11, r12, r13);
        }
    }

    private TypefaceCompatUtil() {
    }

    public static void closeQuietly(@Nullable Closeable r10) {
        if (r10 == null) goto L8;
        r10.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    @Nullable
    @RequiresApi(19)
    public static ByteBuffer copyToDirectBuffer(@NonNull Context r10, @NonNull Resources r11, int r12) {
        File r13 = getTempFile(r10);
        if (r13 != null) goto L15;
        return null;
    L15:
    L12:
        th = move-exception;
        r13.delete();
        throw th;
    L6:
        if (copyToFile(r13, r11, r12) == true) goto L9;
        r13.delete();
        return null;
    L9:
        ByteBuffer r14 = mmap(r13);     // Catch: Throwable -> L12
        r13.delete();
        return r14;
    }

    public static boolean copyToFile(@NonNull File r10, @NonNull Resources r11, int r12) {
        InputStream r13 = r11.openRawResource(r12);     // Catch: Throwable -> L8
        boolean r14 = copyToFile(r10, r13);     // Catch: Throwable -> L6
        closeQuietly(r13);
        return r14;
    L6:
        th = th;
    L10:
        closeQuietly(r13);
        throw th;
    L8:
        th = th;
        r13 = null;
        goto L10
    }

    public static boolean copyToFile(@NonNull File r10, @NonNull InputStream r11) {
        StrictMode.ThreadPolicy r12 = StrictMode.allowThreadDiskWrites();
        FileOutputStream r13 = null;
        FileOutputStream r14 = new FileOutputStream(r10, false);     // Catch: Throwable -> L16 IOException -> L18
        byte[] r15 = new byte[1024];     // Catch: Throwable -> L12 IOException -> L14
    L6:
        int r16 = r11.read(r15);     // Catch: Throwable -> L12 IOException -> L14
        if (r16 == (-1)) goto L10;
        r14.write(r15, 0, r16);     // Catch: Throwable -> L12 IOException -> L14
    L10:
        closeQuietly(r14);
        StrictMode.setThreadPolicy(r12);
        return true;
    L14:
        e = e;
        r13 = r14;
    L19:
        Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());     // Catch: Throwable -> L16
        closeQuietly(r13);
        StrictMode.setThreadPolicy(r12);
        return false;
    L12:
        th = th;
        r13 = r14;
    L22:
        closeQuietly(r13);
        StrictMode.setThreadPolicy(r12);
        throw th;
    L18:
        e = e;
    L16:
        th = th;
        goto L22
    }

    @Nullable
    public static File getTempFile(@NonNull Context r10) {
        File r11 = r10.getCacheDir();
        if (r11 != null) goto L5;
        return null;
    L5:
        String r12 = CACHE_FILE_PREFIX + Process.myPid() + "-" + Process.myTid() + "-";
        int r13 = 0;
    L7:
        if (r13 >= 100) goto L13;
        File r14 = new File(r11, r12 + r13);
        if (r14.createNewFile() == false) goto L12;
        return r14;
    L12:
        r13 = r13 + 1;
        goto L7
    L13:
        return null;
    }

    @Nullable
    @RequiresApi(19)
    public static ByteBuffer mmap(@NonNull Context r10, @Nullable CancellationSignal r11, @NonNull Uri r12) {
        ParcelFileDescriptor r13 = Api19Impl.openFileDescriptor(r10.getContentResolver(), r12, "r", r11);     // Catch: IOException -> L25
        if (r13 != null) goto L33;
        if (r13 == null) goto L7;
        r13.close();     // Catch: IOException -> L25
    L7:
        return null;
    L33:
        FileInputStream r14 = new FileInputStream(r13.getFileDescriptor());     // Catch: Throwable -> L19
        FileChannel r15 = r14.getChannel();     // Catch: Throwable -> L13
        long r16 = r15.size();     // Catch: Throwable -> L13
        MappedByteBuffer r17 = r15.map(FileChannel.MapMode.READ_ONLY, 0, r16);     // Catch: Throwable -> L13
        r14.close();     // Catch: Throwable -> L19
        r13.close();     // Catch: IOException -> L25
        return r17;
    L13:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: IOException -> L25
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L25
    L25:
        return null;
    }

    @Nullable
    @RequiresApi(19)
    private static ByteBuffer mmap(File r10) {
        FileInputStream r11 = new FileInputStream(r10);     // Catch: IOException -> L12
        FileChannel r12 = r11.getChannel();     // Catch: Throwable -> L6
        long r13 = r12.size();     // Catch: Throwable -> L6
        MappedByteBuffer r14 = r12.map(FileChannel.MapMode.READ_ONLY, 0, r13);     // Catch: Throwable -> L6
        r11.close();     // Catch: IOException -> L12
        return r14;
    L6:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L9
    L11:
        throw th;     // Catch: IOException -> L12
    L9:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L12
    L12:
        return null;
    }

    @NonNull
    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Map<Uri, ByteBuffer> readFontInfoIntoByteBuffer(@NonNull Context r10, @NonNull FontsContractCompat.FontInfo[] r11, @Nullable CancellationSignal r12) {
        HashMap r13 = new HashMap();
        int r14 = r11.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L13;
        FontsContractCompat.FontInfo r16 = r11[r15];
        if (r16.getResultCode() != 0) goto L11;
        Uri r17 = r16.getUri();
        if (r13.containsKey(r17) == true) goto L11;
        r13.put(r17, mmap(r10, r12, r17));
    L11:
        r15 = r15 + 1;
        goto L3
    L13:
        return Collections.unmodifiableMap(r13);
    }
}
