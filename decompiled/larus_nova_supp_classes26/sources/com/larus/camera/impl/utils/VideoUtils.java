package com.larus.camera.impl.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class VideoUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String c(Context r5, Uri r6) {
        Cursor r7 = a(r5.getContentResolver(), r6, new String[]{"relative_path", "_display_name"}, null, null);     // Catch: Exception -> L39
        if (r7 == null) goto L47;
        Cursor r8 = r7;     // Catch: Exception -> L39
        Cursor r9 = r8;     // Catch: Throwable -> L34
        if (r9.moveToFirst() == false) goto L31;
        int r0 = r9.getColumnIndex("relative_path");     // Catch: Throwable -> L34
        int r1 = r9.getColumnIndex("_display_name");     // Catch: Throwable -> L34
        if (r0 < 0) goto L11;
        String r2 = r9.getString(r0);     // Catch: Throwable -> L34
    L12:
        if (r1 < 0) goto L14;
        String r10 = r9.getString(r1);     // Catch: Throwable -> L34
    L15:
        boolean r3 = true;
        if (r2 != null) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == true) goto L31;
        if (r10 != null) goto L25;
    L28:
        if (r3 == true) goto L31;
        String r11 = Environment.getExternalStorageDirectory().getAbsolutePath() + '/' + r2 + r10;     // Catch: Throwable -> L34
    L32:
        CloseableKt.closeFinally(r8, null);     // Catch: Exception -> L39
        return r11;
    L25:
        if (r10.length() == 0) goto L28;
        r3 = false;
        goto L28
    L18:
        if (r2.length() == 0) goto L21;
        r4 = false;
        goto L22
    L14:
        r10 = null;
        goto L15
    L11:
        r2 = null;
    L31:
        r11 = null;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Exception -> L39
        throw th;     // Catch: Exception -> L39
    L47:
        return null;
    L39:
        e = move-exception;
        FLogger.a.e("VideoUriUtils", "Error querying relative path: " + e.getMessage(), e);
        return null;
    }

    public static String d(Context r9, Uri r10) {
        boolean r2 = false;
        if (Intrinsics.areEqual(r10.getAuthority(), "media") == true) goto L5;
    L13:
        boolean r0 = false;
    L15:
        if (r0 == false) goto L41;
        String r7 = b(r9, r10, null, null);     // Catch: Exception -> L37
        if (r7 != null) goto L20;
    L23:
        boolean r8 = true;
    L24:
        if (r8 == true) goto L27;
        FLogger.a.i("VideoUriUtils", "Got video path from _data column: " + r7);     // Catch: Exception -> L37
        return r7;
    L27:
        if (Build.VERSION.SDK_INT < 29) goto L35;
        String r11 = c(r9, r10);     // Catch: Exception -> L37
        if (r11 != null) goto L31;
    L32:
        r2 = true;
    L33:
        if (r2 == true) goto L35;
        FLogger.a.i("VideoUriUtils", "Got video path from relative path: " + r11);     // Catch: Exception -> L37
        return r11;
    L31:
        if (r11.length() != 0) goto L33;
    L35:
        FLogger.a.w("VideoUriUtils", "Failed to get video path from MediaStore URI: " + r10);     // Catch: Exception -> L37
        return null;
    L20:
        if (r7.length() == 0) goto L23;
        r8 = false;
    L37:
        e = move-exception;
        FLogger.a.e("VideoUriUtils", "Error getting video path from MediaStore: " + e.getMessage(), e);
        return null;
    L41:
        return b(r9, r10, null, null);
    L5:
        if (r10.getPathSegments().size() < 4) goto L13;
        if (Intrinsics.areEqual(ListProtector.get(r10.getPathSegments(), 0), "external") == false) goto L13;
        if (Intrinsics.areEqual(ListProtector.get(r10.getPathSegments(), 1), "video") == false) goto L13;
        if (Intrinsics.areEqual(ListProtector.get(r10.getPathSegments(), 2), "media") == false) goto L13;
        r0 = true;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String e(Context r12, Uri r13) {
        if (Intrinsics.areEqual("com.android.externalstorage.documents", r13.getAuthority()) == false) goto L12;
        String r6 = DocumentsContract.getDocumentId(r13);
        Intrinsics.checkNotNull(r6);
        List r14 = StringsKt.split$default(r6, new String[]{":"}, false, 0, 6, null);
        if (StringsKt.equals("primary", (String) ListProtector.get(r14, 0), true) == true) goto L30;
    L29:
        return null;
    L30:
        return Environment.getExternalStorageDirectory() + '/' + ((String) ListProtector.get(r14, 1));
    L8:
        e = move-exception;
        FLogger.a.w("VideoUriUtils", "Failed to get external storage path: " + e.getMessage());
        return null;
    L12:
        if (Intrinsics.areEqual("com.android.providers.downloads.documents", r13.getAuthority()) == false) goto L24;
        String r15 = DocumentsContract.getDocumentId(r13);
        Intrinsics.checkNotNull(r15);
        if (StringsKt.startsWith$default(r15, "raw:", false, 2, null) == true) goto L16;
        Long r0 = StringsKt.toLongOrNull(r15);
        if (r0 != null) goto L20;
        FLogger.a.w("VideoUriUtils", "Unsupported downloads document ID format: " + r15);
        return null;
    L20:
        return b(r12, ContentUris.withAppendedId(UriProtector.parse("content://downloads/public_downloads"), r0.longValue()), null, null);
    L16:
        return StringsKt.removePrefix(r15, "raw:");
    L24:
        if (Intrinsics.areEqual("com.android.providers.media.documents", r13.getAuthority()) == false) goto L29;
        String r7 = DocumentsContract.getDocumentId(r13);
        Intrinsics.checkNotNull(r7);
        List r16 = StringsKt.split$default(r7, new String[]{":"}, false, 0, 6, null);
        if (Intrinsics.areEqual("video", (String) ListProtector.get(r16, 0)) == false) goto L29;
        return b(r12, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{ListProtector.get(r16, 1)});
    }

    public static void f(String r6, CoroutineScope r7, Function1 r8) {
        BuildersKt.launch$default(r7, Dispatchers.getIO(), null, new VideoUtils$saveVideoInternal$1(r6, r8, null), 2, null);
    }

    public static String b(Context r7, Uri r8, String r9, String[] r10) {
        String[] r5 = {"_data"};
        if (r8 == null) goto L38;
        Cursor r11 = a(r7.getContentResolver(), r8, r5, r9, r10);     // Catch: Exception -> L31
        if (r11 == null) goto L39;
        Cursor r12 = r11;     // Catch: Exception -> L31
        Cursor r13 = r12;     // Catch: Throwable -> L26
        if (r13.moveToFirst() == false) goto L22;
        int r14 = r13.getColumnIndex("_data");     // Catch: Throwable -> L26
        if (r14 < 0) goto L21;
        String r15 = r13.getString(r14);     // Catch: Throwable -> L26
        if (r15 != null) goto L14;
    L17:
        boolean r16 = true;
    L18:
        if (r16 == false) goto L24;
        FLogger.a.w("VideoUriUtils", "_data column is null or empty for URI: " + r8);     // Catch: Throwable -> L26
    L23:
        r15 = null;
    L24:
        CloseableKt.closeFinally(r12, null);     // Catch: Exception -> L31
        return r15;
    L14:
        if (r15.length() == 0) goto L17;
        r16 = false;
        goto L18
    L21:
        FLogger.a.w("VideoUriUtils", "_data column not found for URI: " + r8);     // Catch: Throwable -> L26
        goto L23
    L22:
        FLogger.a.w("VideoUriUtils", "No data found for URI: " + r8);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Exception -> L31
        throw th;     // Catch: Exception -> L31
    L39:
        return null;
    L31:
        e = move-exception;
        FLogger.a.e("VideoUriUtils", "Failed to query data column for URI: " + r8 + ", error: " + e.getMessage(), e);
        return null;
    L38:
        return null;
    }

    public static Cursor a(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, null);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}
