package com.ttnet.org.chromium.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class FileUtils {
    public static Function<String, Boolean> DELETE_ALL = null;
    private static final String TAG = "FileUtils";

    public interface Natives {
        String getAbsoluteFilePath(String r10);
    }

    static {
        DELETE_ALL = c.f8406a;
    }

    public FileUtils() {
    }

    public static /* synthetic */ Boolean a(String r10) {
        return lambda$static$0(r10);
    }

    public static void batchDeleteFiles(List<String> r10, Function<String, Boolean> r11) {
        Iterator<String> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L16;
        String r13 = r12.next();
        if (r11 == null) goto L11;
        if (r11.apply(r13).booleanValue() == false) goto L4;
    L11:
        if (ContentUriUtils.isContentUri(r13) == true) goto L12;
        File r14 = new File(r13);
        if (r14.exists() == false) goto L4;
        recursivelyDeleteFile(r14, r11);
        goto L4
    L12:
        ContentUriUtils.delete(r13);
        goto L4
    }

    public static void copyStream(InputStream r10, OutputStream r11) {
        byte[] r12 = new byte[8192];
    L3:
        int r13 = r10.read(r12);
        if (r13 == (-1)) goto L6;
        r11.write(r12, 0, r13);
        goto L3
    }

    public static void copyStreamToFile(InputStream r10, File r11) {
        File r12 = new File(r11.getPath() + ".tmp");
        FileOutputStream r13 = new FileOutputStream(r12);
        Log.i(TAG, "Writing to %s", new Object[]{r11});     // Catch: Throwable -> L9
        copyStream(r10, r13);     // Catch: Throwable -> L9
        r13.close();
        if (r12.renameTo(r11) == false) goto L8;
        return;
    L8:
        throw new IOException();
    L9:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L12
    L14:
        throw th;
    L12:
        th = move-exception;
        th.addSuppressed(th);
        goto L14
    }

    public static String getAbsoluteFilePath(String r10) {
        return FileUtilsJni.get().getAbsoluteFilePath(r10);
    }

    public static String getExtension(String r10) {
        int r11 = r10.lastIndexOf(47);
        int r12 = r10.lastIndexOf(46);
        if (r11 < r12) goto L7;
        return "";
    L7:
        return r10.substring(r12 + 1).toLowerCase(Locale.US);
    }

    public static long getFileSizeBytes(File r10) {
        long r11 = 0;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.isDirectory() == false) goto L15;
        File[] r12 = r10.listFiles();
        if (r12 != null) goto L10;
        return 0;
    L10:
        int r13 = r12.length;
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L13;
        r11 = r11 + getFileSizeBytes(r12[r14]);
        r14 = r14 + 1;
        goto L11
    L13:
        return r11;
    L15:
        return r10.length();
    }

    public static Uri getUriForFile(File r10) {
        Uri r11 = ContentUriUtils.getContentUriFromFile(r10);     // Catch: IllegalArgumentException -> L4
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        return Uri.fromFile(r10);
    L4:
        e = move-exception;
        Log.e(TAG, "Could not create content uri: " + e, new Object[0]);
        r11 = null;
        goto L6
    }

    private static /* synthetic */ Boolean lambda$static$0(String r10) {
        return Boolean.TRUE;
    }

    @Nullable
    public static Bitmap queryBitmapFromContentProvider(Context r10, Uri r11) {
        ParcelFileDescriptor r12 = r10.getContentResolver().openFileDescriptor(r11, "r");     // Catch: IOException -> L28
        if (r12 != null) goto L9;
        Log.w(TAG, "Null ParcelFileDescriptor from uri " + r11, new Object[0]);     // Catch: Throwable -> L21
        if (r12 == null) goto L8;
        r12.close();     // Catch: IOException -> L28
    L8:
        return null;
    L9:
        FileDescriptor r13 = r12.getFileDescriptor();     // Catch: Throwable -> L21
        if (r13 != null) goto L14;
        Log.w(TAG, "Null FileDescriptor from uri " + r11, new Object[0]);     // Catch: Throwable -> L21
        r12.close();     // Catch: IOException -> L28
        return null;
    L14:
        Bitmap r14 = BitmapFactory.decodeFileDescriptor(r13);     // Catch: Throwable -> L21
        if (r14 != null) goto L19;
        Log.w(TAG, "Failed to decode image from uri " + r11, new Object[0]);     // Catch: Throwable -> L21
        r12.close();     // Catch: IOException -> L28
        return null;
    L19:
        r12.close();     // Catch: IOException -> L28
        return r14;
    L21:
        th = move-exception;
        if (r12 != null) goto L31;
    L27:
        throw th;     // Catch: IOException -> L28
    L31:
        r12.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L28
    L28:
        Log.w(TAG, "IO exception when reading uri " + r11, new Object[0]);
        return null;
    }

    @NonNull
    public static byte[] readStream(InputStream r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        copyStream(r10, r11);
        return r11.toByteArray();
    }

    public static boolean recursivelyDeleteFile(File r10, Function<String, Boolean> r11) {
        if (r10.exists() == true) goto L6;
        r10.delete();
        return true;
    L6:
        if (r11 == null) goto L11;
        if (r11.apply(r10.getPath()).booleanValue() == true) goto L11;
        return true;
    L11:
        if (r10.isDirectory() == false) goto L17;
        File[] r12 = r10.listFiles();
        if (r12 == null) goto L17;
        int r13 = r12.length;
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L17;
        recursivelyDeleteFile(r12[r14], r11);
        r14 = r14 + 1;
    L17:
        boolean r15 = r10.delete();
        if (r15 == true) goto L20;
        Log.e(TAG, "Failed to delete: %s", new Object[]{r10});
    L20:
        return r15;
    }
}
