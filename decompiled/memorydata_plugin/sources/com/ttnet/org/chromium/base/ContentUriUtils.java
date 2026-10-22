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
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ContentUriUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ContentUriUtils";
    private static FileProviderUtil sFileProviderUtil;
    private static final Object sLock = null;

    public interface FileProviderUtil {
        Uri getContentUriFromFile(File r1);
    }

    static {
        sLock = new Object();
    }

    private ContentUriUtils() {
    }

    public static boolean contentUriExists(String r1) {
        AssetFileDescriptor r2 = getAssetFileDescriptor(r1);     // Catch: Throwable -> L9
        if (r2 == null) goto L5;
        boolean r0 = true;
    L6:
        if (r2 != null) goto L12;
    L8:
        return r0;
    L12:
        r2.close();     // Catch: IOException -> L11
        goto L8
    L5:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean delete(String r3) {
        Uri r4 = Uri.parse(r3);
        if (ZeusProviderTransform.delete(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r4, null, null, "com.obric.memorydata.plugin") <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static AssetFileDescriptor getAssetFileDescriptor(String r11) {
        ContentResolver r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        Uri r1 = Uri.parse(r11);
    L23:
        e = move-exception;
        Log.w(TAG, "Cannot open content uri: %s", new Object[]{r11, e});
    L25:
        return null;
    L4:
        if (isVirtualDocument(r1) == false) goto L19;
        String[] r4 = r0.getStreamTypes(r1, "*/*");     // Catch: Exception -> L23
        if (r4 == null) goto L25;
        if (r4.length <= 0) goto L25;
        AssetFileDescriptor r2 = r0.openTypedAssetFileDescriptor(r1, r4[0], null);     // Catch: Exception -> L23
        if (r2 != null) goto L13;
    L18:
        return r2;
    L13:
        if (r2.getStartOffset() == 0) goto L18;
        r2.close();     // Catch: IOException -> L26 Exception -> L23
    L17:
        throw new SecurityException("Cannot open files with non-zero offset type.");     // Catch: Exception -> L23
    L19:
        ParcelFileDescriptor r6 = r0.openFileDescriptor(r1, "r");     // Catch: Exception -> L23
        if (r6 == null) goto L25;
        return new AssetFileDescriptor(r6, 0, -1);
    }

    public static Uri getContentUriFromFile(File r2) {
        Object r0 = sLock;
        monitor-enter(r0);
        FileProviderUtil r1 = sFileProviderUtil;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        Uri r3 = r1.getContentUriFromFile(r2);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public static String getContentUriFromFilePath(String r3) {
        Uri r0 = getContentUriFromFile(new File(r3));     // Catch: IllegalArgumentException -> L6
        if (r0 == null) goto L12;
        return r0.toString();
    L12:
        return null;
    L6:
        e = move-exception;
        Log.e(TAG, "Cannot retrieve content uri from file: %s", new Object[]{r3, e});
        return null;
    }

    public static String getDisplayName(Uri r8, Context r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return "";
    L5:
        ContentResolver r12 = r11.getContentResolver();
        Cursor r1 = ZeusProviderTransform.query(r12, r8, null, null, null, null, "com.obric.memorydata.plugin");     // Catch: NullPointerException -> L38
        if (r1 != null) goto L39;
    L35:
        if (r1 == null) goto L37;
        r1.close();     // Catch: NullPointerException -> L38
        goto L37
    L39:
    L28:
        th = move-exception;
        if (r1 != null) goto L41;
    L34:
        throw th;     // Catch: NullPointerException -> L38
    L41:
        r1.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L38
        goto L34
    L9:
        if (r1.getCount() < 1) goto L35;
        r1.moveToFirst();     // Catch: Throwable -> L28
        int r13 = r1.getColumnIndex(r10);     // Catch: Throwable -> L28
        if (r13 != (-1)) goto L16;
        if (r1 == null) goto L15;
        r1.close();     // Catch: NullPointerException -> L38
    L15:
        return "";
    L16:
        String r14 = r1.getString(r13);     // Catch: Throwable -> L28
        if (hasVirtualFlag(r1) == false) goto L25;
        String[] r15 = r12.getStreamTypes(r8, "*/*");     // Catch: Throwable -> L28
        if (r15 == null) goto L25;
        if (r15.length <= 0) goto L25;
        String r16 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r15[0]);     // Catch: Throwable -> L28
        if (r16 == null) goto L25;
        r14 = r14 + "." + r16;     // Catch: Throwable -> L28
    L25:
        if (r1 == null) goto L27;
        r1.close();     // Catch: NullPointerException -> L38
    L27:
        return r14;
    L37:
        return "";
    }

    public static String getMimeType(String r3) {
        ContentResolver r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        Uri r4 = Uri.parse(r3);
        if (isVirtualDocument(r4) == false) goto L12;
        String[] r5 = r0.getStreamTypes(r4, "*/*");
        if (r5 != null) goto L7;
    L9:
        return null;
    L7:
        if (r5.length <= 0) goto L9;
        return r5[0];
    L12:
        return ZeusProviderTransform.getType(r0, r4, "com.obric.memorydata.plugin");
    }

    private static boolean hasVirtualFlag(Cursor r6) {
        Cursor r7 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r6, Cursor.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        int r0 = r7.getColumnIndex("flags");
        if (r0 > (-1)) goto L8;
        return false;
    L8:
        if ((r7.getLong(r0) & 512) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isContentUri(String r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        Uri r3 = Uri.parse(r2);
        if (r3 != null) goto L8;
        return false;
    L8:
        if (Params.CONTENT.equals(r3.getScheme()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isVirtualDocument(Uri r9) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        if (r9 != null) goto L8;
        return false;
    L8:
        if (DocumentsContract.isDocumentUri((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9) == true) goto L34;
        return false;
    L34:
        Cursor r10 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r9, null, null, null, null, "com.obric.memorydata.plugin");     // Catch: NullPointerException -> L29
        if (r10 != null) goto L32;
    L26:
        if (r10 == null) goto L28;
        r10.close();     // Catch: NullPointerException -> L29
        goto L28
    L32:
    L19:
        th = move-exception;
        if (r10 != null) goto L30;
    L25:
        throw th;     // Catch: NullPointerException -> L29
    L30:
        r10.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L29
        goto L25
    L14:
        if (r10.getCount() < 1) goto L26;
        r10.moveToFirst();     // Catch: Throwable -> L19
        boolean r0 = hasVirtualFlag(r10);     // Catch: Throwable -> L19
        if (r10 == null) goto L18;
        r10.close();     // Catch: NullPointerException -> L29
    L18:
        return r0;
    L28:
        return false;
    }

    public static String maybeGetDisplayName(String r5) {
        String r0 = getDisplayName(Uri.parse(r5), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "_display_name");     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0;
    L8:
        e = move-exception;
        Log.w(TAG, "Cannot open content uri: %s", new Object[]{r5, e});
        return null;
    }

    public static int openContentUriForRead(String r0) {
        AssetFileDescriptor r1 = getAssetFileDescriptor(r0);
        if (r1 != null) goto L5;
        return -1;
    L5:
        return r1.getParcelFileDescriptor().detachFd();
    }

    public static void setFileProviderUtil(FileProviderUtil r2) {
        FileProviderUtil r3 = (FileProviderUtil) ZeusTransformUtils.wrapperContextForParams(r2, FileProviderUtil.class, "com.obric.memorydata.plugin");
        Object r0 = sLock;
        monitor-enter(r0);
        sFileProviderUtil = r3;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
