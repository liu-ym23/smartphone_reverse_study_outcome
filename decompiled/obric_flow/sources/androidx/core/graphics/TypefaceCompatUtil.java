package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.provider.FontsContractCompat;
import androidx.room.writer.DaoWriter;
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

    private TypefaceCompatUtil() {
    }

    public static void closeQuietly(@Nullable Closeable r5) {
        if (r5 == null) goto L8;
        r5.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    @Nullable
    public static ByteBuffer copyToDirectBuffer(@NonNull Context r5, @NonNull Resources r10, int r11) {
        File r12 = getTempFile(r5);
        if (r12 != null) goto L15;
        return null;
    L15:
    L12:
        th = move-exception;
        r12.delete();
        throw th;
    L6:
        if (copyToFile(r12, r10, r11) == true) goto L9;
        r12.delete();
        return null;
    L9:
        ByteBuffer r13 = mmap(r12);     // Catch: Throwable -> L12
        r12.delete();
        return r13;
    }

    public static boolean copyToFile(@NonNull File r5, @NonNull InputStream r10) {
        StrictMode.ThreadPolicy r11 = StrictMode.allowThreadDiskWrites();
        FileOutputStream r12 = null;
        FileOutputStream r13 = new FileOutputStream(r5, false);     // Catch: Throwable -> L16 IOException -> L18
        byte[] r14 = new byte[1024];     // Catch: Throwable -> L10 IOException -> L12
    L6:
        int r15 = r10.read(r14);     // Catch: Throwable -> L10 IOException -> L12
        if (r15 == (-1)) goto L14;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L10 IOException -> L12
    L14:
        closeQuietly(r13);
        StrictMode.setThreadPolicy(r11);
        return true;
    L12:
        e = e;
        r12 = r13;
    L19:
        Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());     // Catch: Throwable -> L16
        closeQuietly(r12);
        StrictMode.setThreadPolicy(r11);
        return false;
    L10:
        th = th;
        r12 = r13;
    L22:
        closeQuietly(r12);
        StrictMode.setThreadPolicy(r11);
        throw th;
    L18:
        e = e;
    L16:
        th = th;
        goto L22
    }

    @Nullable
    public static File getTempFile(@NonNull Context r5) {
        File r10 = r5.getCacheDir();
        if (r10 != null) goto L5;
        return null;
    L5:
        String r11 = CACHE_FILE_PREFIX + Process.myPid() + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + Process.myTid() + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
        int r12 = 0;
    L7:
        if (r12 >= 100) goto L13;
        File r13 = new File(r10, r11 + r12);
        if (r13.createNewFile() == false) goto L12;
        return r13;
    L12:
        r12 = r12 + 1;
        goto L7
    L13:
        return null;
    }

    @Nullable
    private static ByteBuffer mmap(File r10) {
        FileInputStream r5 = new FileInputStream(r10);     // Catch: IOException -> L12
        FileChannel r11 = r5.getChannel();     // Catch: Throwable -> L6
        long r12 = r11.size();     // Catch: Throwable -> L6
        MappedByteBuffer r13 = r11.map(FileChannel.MapMode.READ_ONLY, 0, r12);     // Catch: Throwable -> L6
        r5.close();     // Catch: IOException -> L12
        return r13;
    L6:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L9
    L11:
        throw th;     // Catch: IOException -> L12
    L9:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L12
    L12:
        return null;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Map<Uri, ByteBuffer> readFontInfoIntoByteBuffer(@NonNull Context r5, @NonNull FontsContractCompat.FontInfo[] r10, @Nullable CancellationSignal r11) {
        HashMap r12 = new HashMap();
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L13;
        FontsContractCompat.FontInfo r15 = r10[r14];
        if (r15.getResultCode() != 0) goto L11;
        Uri r16 = r15.getUri();
        if (r12.containsKey(r16) == true) goto L11;
        r12.put(r16, mmap(r5, r11, r16));
    L11:
        r14 = r14 + 1;
        goto L3
    L13:
        return Collections.unmodifiableMap(r12);
    }

    @Nullable
    public static ByteBuffer mmap(@NonNull Context r10, @Nullable CancellationSignal r11, @NonNull Uri r12) {
        ParcelFileDescriptor r13 = r10.getContentResolver().openFileDescriptor(r12, "r", r11);     // Catch: IOException -> L26
        if (r13 != null) goto L29;
        if (r13 == null) goto L7;
        r13.close();     // Catch: IOException -> L26
    L7:
        return null;
    L29:
        FileInputStream r14 = new FileInputStream(r13.getFileDescriptor());     // Catch: Throwable -> L13
        FileChannel r5 = r14.getChannel();     // Catch: Throwable -> L15
        long r15 = r5.size();     // Catch: Throwable -> L15
        MappedByteBuffer r16 = r5.map(FileChannel.MapMode.READ_ONLY, 0, r15);     // Catch: Throwable -> L15
        r14.close();     // Catch: Throwable -> L13
        r13.close();     // Catch: IOException -> L26
        return r16;
    L15:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L13
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: IOException -> L26
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L26
    L26:
        return null;
    }

    public static boolean copyToFile(@NonNull File r5, @NonNull Resources r10, int r11) {
        InputStream r12 = r10.openRawResource(r11);     // Catch: Throwable -> L8
        boolean r13 = copyToFile(r5, r12);     // Catch: Throwable -> L6
        closeQuietly(r12);
        return r13;
    L6:
        th = th;
    L10:
        closeQuietly(r12);
        throw th;
    L8:
        th = th;
        r12 = null;
        goto L10
    }
}
