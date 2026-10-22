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

    public static boolean canRead(Context r10, Uri r11) {
        if (r10.checkCallingOrSelfUriPermission(r11, 1) == 0) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(getRawType(r10, r11)) == false) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean canWrite(Context r10, Uri r11) {
        if (r10.checkCallingOrSelfUriPermission(r11, 2) == 0) goto L5;
        return false;
    L5:
        String r12 = getRawType(r10, r11);
        int r13 = queryForInt(r10, r11, "flags", 0);
        if (TextUtils.isEmpty(r12) == false) goto L9;
        return false;
    L9:
        if ((r13 & 4) == 0) goto L12;
        return true;
    L12:
        if ("vnd.android.document/directory".equals(r12) == false) goto L17;
        if ((r13 & 8) == 0) goto L17;
        return true;
    L17:
        if (TextUtils.isEmpty(r12) == false) goto L19;
    L21:
        return false;
    L19:
        if ((r13 & 2) == 0) goto L21;
        return true;
    }

    private static void closeQuietly(@Nullable AutoCloseable r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        r10.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static boolean exists(Context r10, Uri r11) {
        ContentResolver r12 = r10.getContentResolver();
        boolean r13 = false;
        Cursor r14 = null;
        r14 = r12.query(r11, new String[]{"document_id"}, null, null, null);     // Catch: Throwable -> L8 Exception -> L10
        if (r14.getCount() <= 0) goto L6;
        r13 = true;
    L6:
        closeQuietly(r14);
        return r13;
    L10:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L8
        closeQuietly(r14);
        return false;
    L8:
        th = move-exception;
        closeQuietly(r14);
        throw th;
    }

    public static long getFlags(Context r10, Uri r11) {
        return queryForLong(r10, r11, "flags", 0);
    }

    @Nullable
    public static String getName(Context r10, Uri r11) {
        return queryForString(r10, r11, "_display_name", null);
    }

    @Nullable
    private static String getRawType(Context r10, Uri r11) {
        return queryForString(r10, r11, "mime_type", null);
    }

    @Nullable
    public static String getType(Context r10, Uri r11) {
        String r12 = getRawType(r10, r11);
        if ("vnd.android.document/directory".equals(r12) == false) goto L6;
        return null;
    L6:
        return r12;
    }

    public static boolean isDirectory(Context r10, Uri r11) {
        return "vnd.android.document/directory".equals(getRawType(r10, r11));
    }

    public static boolean isFile(Context r10, Uri r11) {
        String r12 = getRawType(r10, r11);
        if ("vnd.android.document/directory".equals(r12) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean isVirtual(Context r10, Uri r11) {
        if (DocumentsContract.isDocumentUri(r10, r11) == true) goto L6;
        return false;
    L6:
        if ((getFlags(r10, r11) & 512) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static long lastModified(Context r10, Uri r11) {
        return queryForLong(r10, r11, "last_modified", 0);
    }

    public static long length(Context r10, Uri r11) {
        return queryForLong(r10, r11, "_size", 0);
    }

    private static int queryForInt(Context r10, Uri r11, String r12, int r13) {
        return (int) queryForLong(r10, r11, r12, r13);
    }

    private static long queryForLong(Context r10, Uri r11, String r12, long r13) {
        Cursor r14 = null;
        r14 = r10.getContentResolver().query(r11, new String[]{r12}, null, null, null);     // Catch: Throwable -> L12 Exception -> L14
        if (r14.moveToFirst() == true) goto L6;
    L10:
        closeQuietly(r14);
        return r13;
    L6:
        if (r14.isNull(0) == true) goto L10;
        long r15 = r14.getLong(0);     // Catch: Throwable -> L12 Exception -> L14
        closeQuietly(r14);
        return r15;
    L14:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L12
        closeQuietly(r14);
        return r13;
    L12:
        th = move-exception;
        closeQuietly(r14);
        throw th;
    }

    @Nullable
    private static String queryForString(Context r10, Uri r11, String r12, @Nullable String r13) {
        Cursor r14 = null;
        r14 = r10.getContentResolver().query(r11, new String[]{r12}, null, null, null);     // Catch: Throwable -> L12 Exception -> L14
        if (r14.moveToFirst() == true) goto L6;
    L10:
        closeQuietly(r14);
        return r13;
    L6:
        if (r14.isNull(0) == true) goto L10;
        String r15 = r14.getString(0);     // Catch: Throwable -> L12 Exception -> L14
        closeQuietly(r14);
        return r15;
    L14:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L12
        closeQuietly(r14);
        return r13;
    L12:
        th = move-exception;
        closeQuietly(r14);
        throw th;
    }
}
