package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    private DocumentsContractApi19() {
    }

    public static boolean canRead(Context r3, Uri r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5.checkCallingOrSelfUriPermission(r4, 1) == 0) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(getRawType(r5, r4)) == false) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean canWrite(Context r4, Uri r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r6.checkCallingOrSelfUriPermission(r5, 2) == 0) goto L5;
        return false;
    L5:
        String r1 = getRawType(r6, r5);
        int r7 = queryForInt(r6, r5, "flags", 0);
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return false;
    L9:
        if ((r7 & 4) == 0) goto L12;
        return true;
    L12:
        if ("vnd.android.document/directory".equals(r1) == false) goto L17;
        if ((r7 & 8) == 0) goto L17;
        return true;
    L17:
        if (TextUtils.isEmpty(r1) == false) goto L19;
    L21:
        return false;
    L19:
        if ((r7 & 2) == 0) goto L21;
        return true;
    }

    private static void closeQuietly(AutoCloseable r2) {
        AutoCloseable r3 = (AutoCloseable) ZeusTransformUtils.wrapperContextForParams(r2, AutoCloseable.class, "com.obric.memorydata.plugin");
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

    public static boolean exists(Context r8, Uri r9) {
        ContentResolver r0 = ((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        boolean r10 = false;
        Cursor r7 = null;
        r7 = ZeusProviderTransform.query(r0, r9, new String[]{"document_id"}, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8 Exception -> L10
        if (r7.getCount() <= 0) goto L6;
        r10 = true;
    L6:
        closeQuietly(r7);
        return r10;
    L10:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L8
        closeQuietly(r7);
        return false;
    L8:
        th = move-exception;
        closeQuietly(r7);
        throw th;
    }

    public static long getFlags(Context r3, Uri r4) {
        return queryForLong((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, "flags", 0);
    }

    public static String getName(Context r2, Uri r3) {
        return queryForString((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, "_display_name", null);
    }

    private static String getRawType(Context r2, Uri r3) {
        return queryForString((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, "mime_type", null);
    }

    public static String getType(Context r2, Uri r3) {
        String r4 = getRawType((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
        if ("vnd.android.document/directory".equals(r4) == false) goto L6;
        return null;
    L6:
        return r4;
    }

    public static boolean isDirectory(Context r2, Uri r3) {
        return "vnd.android.document/directory".equals(getRawType((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3));
    }

    public static boolean isFile(Context r2, Uri r3) {
        String r4 = getRawType((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
        if ("vnd.android.document/directory".equals(r4) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean isVirtual(Context r4, Uri r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (DocumentsContract.isDocumentUri(r6, r5) == true) goto L6;
        return false;
    L6:
        if ((getFlags(r6, r5) & 512) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static long lastModified(Context r3, Uri r4) {
        return queryForLong((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, "last_modified", 0);
    }

    public static long length(Context r3, Uri r4) {
        return queryForLong((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, "_size", 0);
    }

    private static int queryForInt(Context r2, Uri r3, String r4, int r5) {
        return (int) queryForLong((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    private static long queryForLong(Context r8, Uri r9, String r10, long r11) {
        Cursor r7 = null;
        r7 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r9, new String[]{r10}, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12 Exception -> L14
        if (r7.moveToFirst() == true) goto L6;
    L10:
        closeQuietly(r7);
        return r11;
    L6:
        if (r7.isNull(0) == true) goto L10;
        long r12 = r7.getLong(0);     // Catch: Throwable -> L12 Exception -> L14
        closeQuietly(r7);
        return r12;
    L14:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L12
        closeQuietly(r7);
        return r11;
    L12:
        th = move-exception;
        closeQuietly(r7);
        throw th;
    }

    private static String queryForString(Context r8, Uri r9, String r10, String r11) {
        Cursor r7 = null;
        r7 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r9, new String[]{r10}, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12 Exception -> L14
        if (r7.moveToFirst() == true) goto L6;
    L10:
        closeQuietly(r7);
        return r11;
    L6:
        if (r7.isNull(0) == true) goto L10;
        String r12 = r7.getString(0);     // Catch: Throwable -> L12 Exception -> L14
        closeQuietly(r7);
        return r12;
    L14:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L12
        closeQuietly(r7);
        return r11;
    L12:
        th = move-exception;
        closeQuietly(r7);
        throw th;
    }
}
