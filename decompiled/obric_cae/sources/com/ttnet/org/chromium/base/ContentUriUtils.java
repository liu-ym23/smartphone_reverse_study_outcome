package com.ttnet.org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ContentUriUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ContentUriUtils";
    private static FileProviderUtil sFileProviderUtil;
    private static final Object sLock = null;

    public interface FileProviderUtil {
        Uri getContentUriFromFile(File r8);
    }

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

    static {
        sLock = new Object();
    }

    private ContentUriUtils() {
    }

    @CalledByNative
    public static boolean contentUriExists(String r8) {
        AssetFileDescriptor r10 = getAssetFileDescriptor(r8);
        if (r10 == null) goto L5;
        boolean r11 = true;
    L6:
        if (r10 != null) goto L10;
    L8:
        return r11;
    L10:
        r10.close();     // Catch: IOException -> L9
        goto L8
    L5:
        r11 = false;
        goto L6
    }

    @CalledByNative
    public static boolean delete(String r8) {
        Uri r10 = Uri.parse(r8);
        if (ContextUtils.getApplicationContext().getContentResolver().delete(r10, null, null) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static AssetFileDescriptor getAssetFileDescriptor(String r11) {
        ContentResolver r8 = ContextUtils.getApplicationContext().getContentResolver();
        Uri r10 = Uri.parse(r11);
    L27:
        e = e;
        StringBuilder r12 = new StringBuilder("Cannot find content uri: ");
    L29:
        r12.append(r11);
        android.util.Log.w(TAG, r12.toString(), e);
    L30:
        return null;
    L25:
        e = e;
        r12 = new StringBuilder("Cannot open content uri: ");
    L23:
        e = e;
        r12 = new StringBuilder("Unknown content uri: ");
        goto L29
    L4:
        if (isVirtualDocument(r10) == false) goto L19;
        String[] r13 = r8.getStreamTypes(r10, "*/*");     // Catch: Exception -> L23 SecurityException -> L25 FileNotFoundException -> L27
        if (r13 == null) goto L30;
        if (r13.length <= 0) goto L30;
        AssetFileDescriptor r14 = r8.openTypedAssetFileDescriptor(r10, r13[0], null);     // Catch: Exception -> L23 SecurityException -> L25 FileNotFoundException -> L27
        if (r14 != null) goto L13;
    L18:
        return r14;
    L13:
        if (r14.getStartOffset() == 0) goto L18;
        r14.close();     // Catch: IOException -> L31 Exception -> L23 SecurityException -> L25
    L17:
        throw new SecurityException("Cannot open files with non-zero offset type.");     // Catch: Exception -> L23 SecurityException -> L25 FileNotFoundException -> L27
    L19:
        ParcelFileDescriptor r15 = r8.openFileDescriptor(r10, "r");     // Catch: Exception -> L23 SecurityException -> L25 FileNotFoundException -> L27
        if (r15 == null) goto L30;
        return new AssetFileDescriptor(r15, 0, -1);
    }

    public static Uri getContentUriFromFile(File r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        FileProviderUtil r11 = sFileProviderUtil;     // Catch: Throwable -> L12
        if (r11 == null) goto L9;
        Uri r12 = r11.getContentUriFromFile(r8);     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r12;
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public static String getDisplayName(Uri r8, Context r10, String r11) {
        if (r8 != null) goto L5;
        return "";
    L5:
        ContentResolver r12 = r10.getContentResolver();
        Cursor r13 = r12.query(r8, null, null, null, null);     // Catch: NullPointerException -> L35
        if (r13 != null) goto L36;
    L32:
        if (r13 == null) goto L34;
        $closeResource(null, r13);     // Catch: NullPointerException -> L35
        goto L34
    L36:
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        $closeResource(th, r13);     // Catch: NullPointerException -> L35
        throw th;     // Catch: NullPointerException -> L35
    L10:
        if (r13.getCount() < 1) goto L32;
        r13.moveToFirst();     // Catch: Throwable -> L27
        int r14 = r13.getColumnIndex(r11);     // Catch: Throwable -> L27
        if (r14 != (-1)) goto L16;
        $closeResource(null, r13);     // Catch: NullPointerException -> L35
        return "";
    L16:
        String r15 = r13.getString(r14);     // Catch: Throwable -> L27
        if (hasVirtualFlag(r13) == false) goto L25;
        String[] r16 = r12.getStreamTypes(r8, "*/*");     // Catch: Throwable -> L27
        if (r16 == null) goto L25;
        if (r16.length <= 0) goto L25;
        String r17 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r16[0]);     // Catch: Throwable -> L27
        if (r17 == null) goto L25;
        r15 = r15 + "." + r17;     // Catch: Throwable -> L27
    L25:
        $closeResource(null, r13);     // Catch: NullPointerException -> L35
        return r15;
    L34:
        return "";
    }

    @CalledByNative
    public static String getMimeType(String r8) {
        ContentResolver r10 = ContextUtils.getApplicationContext().getContentResolver();
        Uri r11 = Uri.parse(r8);
        if (isVirtualDocument(r11) == false) goto L12;
        String[] r12 = r10.getStreamTypes(r11, "*/*");
        if (r12 != null) goto L7;
    L9:
        return null;
    L7:
        if (r12.length <= 0) goto L9;
        return r12[0];
    L12:
        return r10.getType(r11);
    }

    private static boolean hasVirtualFlag(Cursor r8) {
        int r10 = r8.getColumnIndex("flags");
        if (r10 > (-1)) goto L5;
    L7:
        return false;
    L5:
        if ((r8.getLong(r10) & 512) == 0) goto L7;
        return true;
    }

    public static boolean isContentUri(String r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        Uri r10 = Uri.parse(r8);
        if (r10 != null) goto L8;
        return false;
    L8:
        if ("content".equals(r10.getScheme()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isVirtualDocument(Uri r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (DocumentsContract.isDocumentUri(ContextUtils.getApplicationContext(), r8) == true) goto L28;
        return false;
    L28:
        Cursor r10 = ContextUtils.getApplicationContext().getContentResolver().query(r8, null, null, null, null);     // Catch: NullPointerException -> L25
        if (r10 != null) goto L26;
    L22:
        if (r10 == null) goto L24;
        $closeResource(null, r10);     // Catch: NullPointerException -> L25
        goto L24
    L26:
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        $closeResource(th, r10);     // Catch: NullPointerException -> L25
        throw th;     // Catch: NullPointerException -> L25
    L13:
        if (r10.getCount() < 1) goto L22;
        r10.moveToFirst();     // Catch: Throwable -> L17
        boolean r11 = hasVirtualFlag(r10);     // Catch: Throwable -> L17
        $closeResource(null, r10);     // Catch: NullPointerException -> L25
        return r11;
    L24:
        return false;
    }

    @CalledByNative
    public static String maybeGetDisplayName(String r8) {
        String r10 = getDisplayName(Uri.parse(r8), ContextUtils.getApplicationContext(), "_display_name");     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return null;
    L7:
        return r10;
    L8:
        e = move-exception;
        android.util.Log.w(TAG, "Cannot open content uri: " + r8, e);
        return null;
    }

    @CalledByNative
    public static int openContentUriForRead(String r8) {
        AssetFileDescriptor r10 = getAssetFileDescriptor(r8);
        if (r10 != null) goto L5;
        return -1;
    L5:
        return r10.getParcelFileDescriptor().detachFd();
    }

    public static void setFileProviderUtil(FileProviderUtil r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        sFileProviderUtil = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
