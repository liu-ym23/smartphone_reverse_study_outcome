package com.ttnet.org.chromium.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
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
public class FileUtils {
    private static final String TAG = "FileUtils";

    private static /* synthetic */ void $closeResource(Throwable r8, AutoCloseable r10) {
        if (r8 != null) goto L9;
        r10.close();
        return;
    L9:
        r10.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r8.addSuppressed(th);
    }

    public FileUtils() {
    }

    public static void batchDeleteFiles(List<String> r8) {
        Iterator<String> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        String r11 = r10.next();
        if (ContentUriUtils.isContentUri(r11) == true) goto L7;
        File r12 = new File(r11);
        if (r12.exists() == false) goto L4;
        recursivelyDeleteFile(r12);
        goto L4
    L7:
        ContentUriUtils.delete(r11);
        goto L4
    }

    public static void copyStream(InputStream r8, OutputStream r10) {
        byte[] r11 = new byte[8192];
    L3:
        int r12 = r8.read(r11);
        if (r12 == (-1)) goto L6;
        r10.write(r11, 0, r12);
        goto L3
    }

    public static void copyStreamToFile(InputStream r8, File r10) {
        File r11 = new File(r10.getPath() + ".tmp");
        FileOutputStream r12 = new FileOutputStream(r11);
        Log.i(TAG, "Writing to %s", new Object[]{r10});     // Catch: Throwable -> L9
        copyStream(r8, r12);     // Catch: Throwable -> L9
        $closeResource(null, r12);
        if (r11.renameTo(r10) == false) goto L8;
        return;
    L8:
        throw new IOException();
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        $closeResource(th, r12);
        throw th;
    }

    public static boolean extractAsset(Context r8, String r10, File r11) {
        InputStream r12 = r8.getAssets().open(r10);     // Catch: IOException -> L15
        copyStreamToFile(r12, r11);     // Catch: Throwable -> L9
        if (r12 != null) goto L6;
        return true;
    L6:
        $closeResource(null, r12);     // Catch: IOException -> L15
        return true;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r12 == null) goto L14;
        $closeResource(th, r12);     // Catch: IOException -> L15
    L14:
        throw th;     // Catch: IOException -> L15
    L15:
        return false;
    }

    public static String getExtension(String r8) {
        int r10 = r8.lastIndexOf(46);
        if (r10 != (-1)) goto L7;
        return "";
    L7:
        return r8.substring(r10 + 1).toLowerCase(Locale.US);
    }

    public static Uri getUriForFile(File r8) {
        Uri r10 = ContentUriUtils.getContentUriFromFile(r8);     // Catch: IllegalArgumentException -> L4
    L6:
        if (r10 == null) goto L8;
        return r10;
    L8:
        return Uri.fromFile(r8);
    L4:
        e = move-exception;
        Log.e(TAG, "Could not create content uri: " + e, new Object[0]);
        r10 = null;
        goto L6
    }

    public static Bitmap queryBitmapFromContentProvider(Context r8, Uri r10) {
        ParcelFileDescriptor r11 = r8.getContentResolver().openFileDescriptor(r10, "r");     // Catch: IOException -> L27
        if (r11 != null) goto L9;
        Log.w(TAG, "Null ParcelFileDescriptor from uri " + r10, new Object[0]);     // Catch: Throwable -> L21
        if (r11 == null) goto L8;
        $closeResource(null, r11);     // Catch: IOException -> L27
    L8:
        return null;
    L9:
        FileDescriptor r12 = r11.getFileDescriptor();     // Catch: Throwable -> L21
        if (r12 != null) goto L14;
        Log.w(TAG, "Null FileDescriptor from uri " + r10, new Object[0]);     // Catch: Throwable -> L21
        $closeResource(null, r11);     // Catch: IOException -> L27
        return null;
    L14:
        Bitmap r13 = BitmapFactory.decodeFileDescriptor(r12);     // Catch: Throwable -> L21
        if (r13 != null) goto L19;
        Log.w(TAG, "Failed to decode image from uri " + r10, new Object[0]);     // Catch: Throwable -> L21
        $closeResource(null, r11);     // Catch: IOException -> L27
        return null;
    L19:
        $closeResource(null, r11);     // Catch: IOException -> L27
        return r13;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r11 == null) goto L26;
        $closeResource(th, r11);     // Catch: IOException -> L27
    L26:
        throw th;     // Catch: IOException -> L27
    L27:
        Log.w(TAG, defpackage.b.b("IO exception when reading uri ", r10), new Object[0]);
        return null;
    }

    public static byte[] readStream(InputStream r8) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        copyStream(r8, r10);
        return r10.toByteArray();
    }

    public static boolean recursivelyDeleteFile(File r8) {
        if (r8.exists() == true) goto L7;
        return true;
    L7:
        if (r8.isDirectory() == false) goto L13;
        File[] r10 = r8.listFiles();
        if (r10 == null) goto L13;
        int r11 = r10.length;
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L13;
        recursivelyDeleteFile(r10[r12]);
        r12 = r12 + 1;
    L13:
        boolean r13 = r8.delete();
        if (r13 == true) goto L16;
        Log.e(TAG, "Failed to delete: %s", new Object[]{r8});
    L16:
        return r13;
    }
}
