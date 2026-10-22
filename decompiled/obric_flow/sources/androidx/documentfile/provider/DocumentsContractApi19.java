package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    private DocumentsContractApi19() {
    }

    public static boolean canRead(Context r5, Uri r10) {
        if (r5.checkCallingOrSelfUriPermission(r10, 1) == 0) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(getRawType(r5, r10)) == false) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean canWrite(Context r5, Uri r10) {
        if (r5.checkCallingOrSelfUriPermission(r10, 2) == 0) goto L5;
        return false;
    L5:
        String r11 = getRawType(r5, r10);
        int r12 = queryForInt(r5, r10, "flags", 0);
        if (TextUtils.isEmpty(r11) == false) goto L9;
        return false;
    L9:
        if ((r12 & 4) == 0) goto L12;
        return true;
    L12:
        if ("vnd.android.document/directory".equals(r11) == false) goto L17;
        if ((r12 & 8) == 0) goto L17;
        return true;
    L17:
        if (TextUtils.isEmpty(r11) == false) goto L19;
    L21:
        return false;
    L19:
        if ((r12 & 2) == 0) goto L21;
        return true;
    }

    private static void closeQuietly(@Nullable AutoCloseable r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        r5.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static boolean exists(Context r10, Uri r11) {
        ContentResolver r5 = r10.getContentResolver();
        boolean r12 = false;
        Cursor r13 = null;
        r13 = r5.query(r11, new String[]{"document_id"}, null, null, null);     // Catch: Throwable -> L8 Exception -> L10
        if (r13.getCount() <= 0) goto L6;
        r12 = true;
    L6:
        closeQuietly(r13);
        return r12;
    L8:
        th = move-exception;
        closeQuietly(r13);
        throw th;
    L10:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L8
        closeQuietly(r13);
        return false;
    }

    public static long getFlags(Context r5, Uri r10) {
        return queryForLong(r5, r10, "flags", 0);
    }

    @Nullable
    public static String getName(Context r5, Uri r10) {
        return queryForString(r5, r10, "_display_name", null);
    }

    @Nullable
    private static String getRawType(Context r5, Uri r10) {
        return queryForString(r5, r10, "mime_type", null);
    }

    @Nullable
    public static String getType(Context r5, Uri r10) {
        String r11 = getRawType(r5, r10);
        if ("vnd.android.document/directory".equals(r11) == false) goto L6;
        return null;
    L6:
        return r11;
    }

    public static boolean isDirectory(Context r5, Uri r10) {
        return "vnd.android.document/directory".equals(getRawType(r5, r10));
    }

    public static boolean isFile(Context r5, Uri r10) {
        String r11 = getRawType(r5, r10);
        if ("vnd.android.document/directory".equals(r11) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean isVirtual(Context r5, Uri r10) {
        if (DocumentsContract.isDocumentUri(r5, r10) == true) goto L6;
        return false;
    L6:
        if ((getFlags(r5, r10) & 512) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static long lastModified(Context r5, Uri r10) {
        return queryForLong(r5, r10, "last_modified", 0);
    }

    public static long length(Context r5, Uri r10) {
        return queryForLong(r5, r10, "_size", 0);
    }

    private static int queryForInt(Context r5, Uri r10, String r11, int r12) {
        return (int) queryForLong(r5, r10, r11, r12);
    }

    private static long queryForLong(Context r10, Uri r11, String r12, long r13) {
        ContentResolver r5 = r10.getContentResolver();
        Cursor r14 = null;
        r14 = r5.query(r11, new String[]{r12}, null, null, null);     // Catch: Throwable -> L10 Exception -> L12
        if (r14.moveToFirst() == true) goto L6;
    L14:
        closeQuietly(r14);
        return r13;
    L6:
        if (r14.isNull(0) == true) goto L14;
        long r15 = r14.getLong(0);     // Catch: Throwable -> L10 Exception -> L12
        closeQuietly(r14);
        return r15;
    L12:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L10
        closeQuietly(r14);
        return r13;
    L10:
        th = move-exception;
        closeQuietly(r14);
        throw th;
    }

    @Nullable
    private static String queryForString(Context r10, Uri r11, String r12, @Nullable String r13) {
        ContentResolver r5 = r10.getContentResolver();
        Cursor r14 = null;
        r14 = r5.query(r11, new String[]{r12}, null, null, null);     // Catch: Throwable -> L10 Exception -> L12
        if (r14.moveToFirst() == true) goto L6;
    L14:
        closeQuietly(r14);
        return r13;
    L6:
        if (r14.isNull(0) == true) goto L14;
        String r15 = r14.getString(0);     // Catch: Throwable -> L10 Exception -> L12
        closeQuietly(r14);
        return r15;
    L12:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L10
        closeQuietly(r14);
        return r13;
    L10:
        th = move-exception;
        closeQuietly(r14);
        throw th;
    }
}
