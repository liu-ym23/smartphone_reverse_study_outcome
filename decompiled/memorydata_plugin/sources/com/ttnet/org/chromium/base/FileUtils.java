package com.ttnet.org.chromium.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("base::android")
public class FileUtils {
    public static Function<String, Boolean> DELETE_ALL = null;
    private static final String TAG = "FileUtils";

    public interface Natives {
        String getAbsoluteFilePath(String r1);
    }

    static {
        DELETE_ALL = $$Lambda$FileUtils$gHgd8VdtzzozDcMj4XTkP4RlVdc.INSTANCE;
    }

    public FileUtils() {
    }

    public static void batchDeleteFiles(List<String> r4, Function<String, Boolean> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r5, Function.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L16;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.apply(r0), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L4;
    L11:
        if (ContentUriUtils.isContentUri(r0) == true) goto L12;
        File r2 = new File(r0);
        if (r2.exists() == false) goto L4;
        recursivelyDeleteFile(r2, r7);
        goto L4
    L12:
        ContentUriUtils.delete(r0);
        goto L4
    }

    public static void copyStream(InputStream r3, OutputStream r4) {
        byte[] r0 = new byte[8192];
    L3:
        int r1 = r3.read(r0);
        if (r1 == (-1)) goto L6;
        r4.write(r0, 0, r1);
        goto L3
    }

    public static void copyStreamToFile(InputStream r6, File r7) {
        File r0 = new File(r7.getPath() + ".tmp");
        FileOutputStream r1 = new FileOutputStream(r0);
        Log.i(TAG, "Writing to %s", new Object[]{r7});     // Catch: Throwable -> L9
        copyStream(r6, r1);     // Catch: Throwable -> L9
        r1.close();
        if (r0.renameTo(r7) == false) goto L8;
        return;
    L8:
        throw new IOException();
    L9:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L12
    L14:
        throw th;
    L12:
        th = move-exception;
        th.addSuppressed(th);
        goto L14
    }

    public static String getAbsoluteFilePath(String r1) {
        return FileUtilsJni.get().getAbsoluteFilePath(r1);
    }

    public static String getExtension(String r2) {
        int r0 = r2.lastIndexOf(47);
        int r1 = r2.lastIndexOf(46);
        if (r0 < r1) goto L7;
        return "";
    L7:
        return r2.substring(r1 + 1).toLowerCase(Locale.US);
    }

    public static long getFileSizeBytes(File r6) {
        long r0 = 0;
        if (r6 != null) goto L6;
        return 0;
    L6:
        if (r6.isDirectory() == false) goto L15;
        File[] r7 = r6.listFiles();
        if (r7 != null) goto L10;
        return 0;
    L10:
        int r2 = r7.length;
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L13;
        r0 = r0 + getFileSizeBytes(r7[r3]);
        r3 = r3 + 1;
        goto L11
    L13:
        return r0;
    L15:
        return r6.length();
    }

    public static Uri getUriForFile(File r3) {
        Uri r0 = ContentUriUtils.getContentUriFromFile(r3);     // Catch: IllegalArgumentException -> L4
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return Uri.fromFile(r3);
    L4:
        e = move-exception;
        Log.e(TAG, "Could not create content uri: " + e, new Object[0]);
        r0 = null;
        goto L6
    }

    static /* synthetic */ Boolean lambda$static$0(String r0) {
        return true;
    }

    public static Bitmap queryBitmapFromContentProvider(Context r5, Uri r6) {
        ParcelFileDescriptor r7 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin")).getContentResolver().openFileDescriptor(r6, "r");     // Catch: IOException -> L31
        if (r7 != null) goto L9;
        Log.w(TAG, "Null ParcelFileDescriptor from uri " + r6, new Object[0]);     // Catch: Throwable -> L24
        if (r7 == null) goto L8;
        r7.close();     // Catch: IOException -> L31
    L8:
        return null;
    L9:
        FileDescriptor r3 = r7.getFileDescriptor();     // Catch: Throwable -> L24
        if (r3 != null) goto L15;
        Log.w(TAG, "Null FileDescriptor from uri " + r6, new Object[0]);     // Catch: Throwable -> L24
        if (r7 == null) goto L14;
        r7.close();     // Catch: IOException -> L31
    L14:
        return null;
    L15:
        Bitmap r4 = BitmapFactory.decodeFileDescriptor(r3);     // Catch: Throwable -> L24
        if (r4 != null) goto L21;
        Log.w(TAG, "Failed to decode image from uri " + r6, new Object[0]);     // Catch: Throwable -> L24
        if (r7 == null) goto L20;
        r7.close();     // Catch: IOException -> L31
    L20:
        return null;
    L21:
        if (r7 == null) goto L23;
        r7.close();     // Catch: IOException -> L31
    L23:
        return r4;
    L24:
        th = move-exception;
        if (r7 != null) goto L35;
    L30:
        throw th;     // Catch: IOException -> L31
    L35:
        r7.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L31
    L31:
        Log.w(TAG, "IO exception when reading uri " + r6, new Object[0]);
        return null;
    }

    public static byte[] readStream(InputStream r1) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        copyStream(r1, r0);
        return r0.toByteArray();
    }

    public static boolean recursivelyDeleteFile(File r6, Function<String, Boolean> r7) {
        Function r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r7, Function.class, "com.obric.memorydata.plugin");
        if (r6.exists() == true) goto L6;
        r6.delete();
        return true;
    L6:
        if (r8 == null) goto L11;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.apply(r6.getPath()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L11;
        return true;
    L11:
        if (r6.isDirectory() == false) goto L17;
        File[] r0 = r6.listFiles();
        if (r0 == null) goto L17;
        int r3 = r0.length;
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L17;
        recursivelyDeleteFile(r0[r4], r8);
        r4 = r4 + 1;
    L17:
        boolean r9 = r6.delete();
        if (r9 == true) goto L20;
        Log.e(TAG, "Failed to delete: %s", new Object[]{r6});
    L20:
        return r9;
    }
}
