package com.ttnet.org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ContentUriUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ContentUriUtils";
    private static FileProviderUtil sFileProviderUtil;
    private static final Object sLock = null;

    public interface FileProviderUtil {
        Uri getContentUriFromFile(File r10);
    }

    static {
        sLock = new Object();
    }

    private ContentUriUtils() {
    }

    @CalledByNative
    public static boolean contentUriExists(String r10) {
        AssetFileDescriptor r11 = getAssetFileDescriptor(r10);     // Catch: Throwable -> L9
        if (r11 == null) goto L5;
        boolean r12 = true;
    L6:
        if (r11 != null) goto L12;
    L8:
        return r12;
    L12:
        r11.close();     // Catch: IOException -> L11
        goto L8
    L5:
        r12 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    public static boolean delete(String r10) {
        Uri r11 = Uri.parse(r10);
        if (ContextUtils.getApplicationContext().getContentResolver().delete(r11, null, null) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static AssetFileDescriptor getAssetFileDescriptor(String r11) {
        ContentResolver r10 = ContextUtils.getApplicationContext().getContentResolver();
        Uri r12 = Uri.parse(r11);
    L23:
        e = move-exception;
        Log.w(TAG, "Cannot open content uri: %s", new Object[]{r11, e});
    L25:
        return null;
    L4:
        if (isVirtualDocument(r12) == false) goto L19;
        String[] r13 = r10.getStreamTypes(r12, "*/*");     // Catch: Exception -> L23
        if (r13 == null) goto L25;
        if (r13.length <= 0) goto L25;
        AssetFileDescriptor r14 = r10.openTypedAssetFileDescriptor(r12, r13[0], null);     // Catch: Exception -> L23
        if (r14 != null) goto L13;
    L18:
        return r14;
    L13:
        if (r14.getStartOffset() == 0) goto L18;
        r14.close();     // Catch: IOException -> L26 Exception -> L23
    L17:
        throw new SecurityException("Cannot open files with non-zero offset type.");     // Catch: Exception -> L23
    L19:
        ParcelFileDescriptor r15 = r10.openFileDescriptor(r12, "r");     // Catch: Exception -> L23
        if (r15 == null) goto L25;
        return new AssetFileDescriptor(r15, 0, -1);
    }

    public static Uri getContentUriFromFile(File r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        FileProviderUtil r12 = sFileProviderUtil;     // Catch: Throwable -> L12
        if (r12 == null) goto L9;
        Uri r13 = r12.getContentUriFromFile(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r13;
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    public static String getContentUriFromFilePath(String r10) {
        Uri r11 = getContentUriFromFile(new File(r10));     // Catch: IllegalArgumentException -> L6
        if (r11 == null) goto L12;
        return r11.toString();
    L12:
        return null;
    L6:
        e = move-exception;
        Log.e(TAG, "Cannot retrieve content uri from file: %s", new Object[]{r10, e});
        return null;
    }

    public static String getDisplayName(Uri r10, Context r11, String r12) {
        if (r10 != null) goto L5;
        return "";
    L5:
        ContentResolver r13 = r11.getContentResolver();
        Cursor r14 = r13.query(r10, null, null, null, null);     // Catch: NullPointerException -> L35
        if (r14 != null) goto L36;
    L32:
        if (r14 == null) goto L34;
        r14.close();     // Catch: NullPointerException -> L35
        goto L34
    L36:
    L26:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: NullPointerException -> L35
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L35
        goto L31
    L9:
        if (r14.getCount() < 1) goto L32;
        r14.moveToFirst();     // Catch: Throwable -> L26
        int r15 = r14.getColumnIndex(r12);     // Catch: Throwable -> L26
        if (r15 != (-1)) goto L15;
        r14.close();     // Catch: NullPointerException -> L35
        return "";
    L15:
        String r16 = r14.getString(r15);     // Catch: Throwable -> L26
        if (hasVirtualFlag(r14) == false) goto L24;
        String[] r17 = r13.getStreamTypes(r10, "*/*");     // Catch: Throwable -> L26
        if (r17 == null) goto L24;
        if (r17.length <= 0) goto L24;
        String r18 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r17[0]);     // Catch: Throwable -> L26
        if (r18 == null) goto L24;
        r16 = r16 + "." + r18;     // Catch: Throwable -> L26
    L24:
        r14.close();     // Catch: NullPointerException -> L35
        return r16;
    L34:
        return "";
    }

    @CalledByNative
    public static String getMimeType(String r10) {
        ContentResolver r11 = ContextUtils.getApplicationContext().getContentResolver();
        Uri r12 = Uri.parse(r10);
        if (isVirtualDocument(r12) == false) goto L12;
        String[] r13 = r11.getStreamTypes(r12, "*/*");
        if (r13 != null) goto L7;
    L9:
        return null;
    L7:
        if (r13.length <= 0) goto L9;
        return r13[0];
    L12:
        return r11.getType(r12);
    }

    private static boolean hasVirtualFlag(Cursor r10) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        int r11 = r10.getColumnIndex("flags");
        if (r11 > (-1)) goto L8;
        return false;
    L8:
        if ((r10.getLong(r11) & 512) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isContentUri(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Uri r11 = Uri.parse(r10);
        if (r11 != null) goto L8;
        return false;
    L8:
        if ("content".equals(r11.getScheme()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isVirtualDocument(Uri r10) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        if (r10 != null) goto L8;
        return false;
    L8:
        if (DocumentsContract.isDocumentUri(ContextUtils.getApplicationContext(), r10) == true) goto L32;
        return false;
    L32:
        Cursor r11 = ContextUtils.getApplicationContext().getContentResolver().query(r10, null, null, null, null);     // Catch: NullPointerException -> L27
        if (r11 != null) goto L30;
    L24:
        if (r11 == null) goto L26;
        r11.close();     // Catch: NullPointerException -> L27
        goto L26
    L30:
    L18:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: NullPointerException -> L27
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L27
        goto L23
    L14:
        if (r11.getCount() < 1) goto L24;
        r11.moveToFirst();     // Catch: Throwable -> L18
        boolean r12 = hasVirtualFlag(r11);     // Catch: Throwable -> L18
        r11.close();     // Catch: NullPointerException -> L27
        return r12;
    L26:
        return false;
    }

    @Nullable
    @CalledByNative
    public static String maybeGetDisplayName(String r10) {
        String r11 = getDisplayName(Uri.parse(r10), ContextUtils.getApplicationContext(), "_display_name");     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return null;
    L7:
        return r11;
    L8:
        e = move-exception;
        Log.w(TAG, "Cannot open content uri: %s", new Object[]{r10, e});
        return null;
    }

    @CalledByNative
    public static int openContentUriForRead(String r10) {
        AssetFileDescriptor r11 = getAssetFileDescriptor(r10);
        if (r11 != null) goto L5;
        return -1;
    L5:
        return r11.getParcelFileDescriptor().detachFd();
    }

    public static void setFileProviderUtil(FileProviderUtil r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        sFileProviderUtil = r10;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
