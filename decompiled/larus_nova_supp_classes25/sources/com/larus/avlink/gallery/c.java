package com.larus.avlink.gallery;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final String c(double r7) {
        double r8 = Math.abs(r7);
        int r0 = (int) r8;
        double r2 = 60;
        double r9 = (r8 - ((double) r0)) * r2;
        int r4 = (int) r9;
        int r10 = (int) Math.rint(((r9 - ((double) r4)) * r2) * ((double) 10000));
        if (r10 < 600000) goto L5;
        r10 = r10 - 600000;
        r4 = r4 + 1;
    L5:
        if (r4 < 60) goto L8;
        r4 = r4 - 60;
        r0 = r0 + 1;
    L8:
        return r0 + "/1," + r4 + "/1," + r10 + "/10000";
    }

    public static final boolean k(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r5 = r4.toLowerCase(Locale.getDefault());
        if (StringsKt.endsWith$default(r5, ".mp4", false, 2, null) == false) goto L5;
    L10:
        return true;
    L5:
        if (StringsKt.endsWith$default(r5, ".mkv", false, 2, null) == true) goto L10;
        if (StringsKt.endsWith$default(r5, ".avi", false, 2, null) == true) goto L10;
        if (StringsKt.endsWith$default(r5, ".mov", false, 2, null) == true) goto L10;
        return false;
    }

    public static final Uri e(ContentResolver r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        if (r2 == false) goto L11;
        Uri r3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    L12:
        Intrinsics.checkNotNull(r3);
    L13:
        return r3;
    L11:
        r3 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        goto L12
    L5:
        if (r2 == false) goto L7;
        r3 = MediaStore.Video.Media.getContentUri("external_primary");
    L8:
        Intrinsics.checkNotNull(r3);
        goto L13
    L7:
        r3 = MediaStore.Images.Media.getContentUri("external_primary");
        goto L8
    }

    public static final boolean i(ContentResolver r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return false;
    L12:
        if (g(r3, r4, false) == false) goto L15;
        return true;
    L15:
        return g(r3, r4, true);
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static final boolean j(ContentResolver r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return false;
    L12:
        if (h(r3, r4, false) == false) goto L15;
        return true;
    L15:
        return h(r3, r4, true);
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static final String l(ContentResolver r5, Uri r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "uri");
        Cursor r1 = null;
        String r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        Cursor r7 = b(r5, r6, new String[]{"_data"});     // Catch: Throwable -> L13 Exception -> L15
        if (r7 != null) goto L26;
    L11:
        if (r7 != null) goto L19;
    L20:
        return r2;
    L19:
        r7.close();
        goto L20
    L26:
    L9:
        Exception e = e;
    L17:
        FLogger.a.w("MediaSyncExecutor", "Error querying media file path: " + e.getMessage());     // Catch: Throwable -> L21
        if (r7 == null) goto L20;
    L21:
        th = move-exception;
        r1 = r7;
        th = th;
    L23:
        if (r1 == null) goto L25;
        r1.close();
    L25:
        throw th;
    L6:
        if (r7.moveToFirst() == false) goto L11;
        r2 = r7.getString(0);     // Catch: Exception -> L9 Throwable -> L21
        goto L11
    L15:
        e = move-exception;
        e = e;
        r7 = null;
    L13:
        th = th;
        goto L23
    }

    public static int a(ContentResolver r21, Uri r22, String r23) {
        ArrayList r2 = new ArrayList();
        Object[] r3 = {r22, r23, null};
        f06.b r14 = new f06.b();
        g06.a r4 = (g06.a) ApiHookConfig.b.get(240019);
        if (r4 == null) goto L5;
        f06.a[] r5 = r4.i;
    L6:
        f06.a[] r11 = r5;
        int r10 = r11.length;
        int r9 = 0;
    L8:
        if (r9 >= r10) goto L15;
        f06.a r8 = r11[r9];
        int r18 = r9;
        int r19 = r10;
        f06.a[] r20 = r11;
        f06.d r6 = r8.preInvoke(240019, "android/content/ContentResolver", "delete", r21, r3, "int", r14);     // Catch: Exception -> L22
        if (r6.a == true) goto L17;
        r2.add(r8);     // Catch: Exception -> L22
    L17:
        if (r6.a == false) goto L21;
        return ((Integer) r6.b).intValue();
    L21:
        return r21.delete(r22, r23, null);
    L14:
        r9 = r18 + 1;
        r10 = r19;
        r11 = r20;
        goto L8
    L15:
        r6 = new f06.d(false, null);
        goto L17
    L5:
        r5 = ApiHookConfig.d;
        goto L6
    }

    public static Cursor b(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }

    public static final int d(ContentResolver r16, String[] r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r17, "mediaIds");
        if (r17.length != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L18;
        return 0;
    L18:
        int r0 = a(r16, e(r16, r18), "_id IN (" + ArraysKt.joinToString$default(r17, ",", null, null, 0, null, null, 62, null) + ')');     // Catch: Exception -> L15
        FLogger r1 = FLogger.a;     // Catch: Exception -> L15
        StringBuilder r3 = new StringBuilder("Deleted ");     // Catch: Exception -> L15
        r3.append(r0);     // Catch: Exception -> L15
        r3.append(' ');     // Catch: Exception -> L15
        if (r18 == false) goto L12;
        String r4 = "videos";
    L13:
        r3.append(r4);     // Catch: Exception -> L15
        r3.append(" from media store");     // Catch: Exception -> L15
        r1.i("MediaSyncExecutor", r3.toString());     // Catch: Exception -> L15
        return r0;
    L12:
        r4 = "images";
    L15:
        e = move-exception;
        FLogger.a.e("MediaSyncExecutor", "Failed to delete from media store: " + e.getMessage());
        return 0;
    L5:
        r2 = false;
        goto L6
    }

    public static final boolean g(ContentResolver r4, String r5, boolean r6) {
        boolean r1 = false;
        Cursor r2 = null;
        r2 = b(r4, ContentUris.withAppendedId(e(r4, r6), CastLongProtector.parseLong(r5)), new String[]{"_id"});     // Catch: Throwable -> L10 Exception -> L12
        if (r2 == null) goto L8;
        if (r2.moveToFirst() == false) goto L8;
        r1 = true;
        goto L8
    L8:
        if (r2 == null) goto L16;
    L9:
        r2.close();
    L16:
        return r1;
    L12:
        e = move-exception;
        FLogger.a.w("MediaSyncExecutor", "Error checking media existence: " + e.getMessage());     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
    L10:
        th = move-exception;
        if (r2 == null) goto L19;
        r2.close();
    L19:
        throw th;
    }

    public static final boolean h(ContentResolver r6, String r7, boolean r8) {
        Uri r9 = ContentUris.withAppendedId(e(r6, r8), CastLongProtector.parseLong(r7));
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 29) goto L5;
        String r2 = "relative_path";
    L6:
        boolean r4 = false;
        Cursor r5 = null;
        r5 = b(r6, r9, new String[]{r2});     // Catch: Throwable -> L17 Exception -> L19
        if (r5 != null) goto L10;
    L22:
        if (r5 != null) goto L26;
    L27:
        return r4;
    L26:
        r5.close();
        goto L27
    L10:
        if (r5.moveToFirst() == false) goto L22;
        String r11 = r5.getString(0);     // Catch: Throwable -> L17 Exception -> L19
        if (r11 != null) goto L15;
        r5.close();
        return false;
    L15:
        if (r10 < 29) goto L21;
        e.a.getClass();     // Catch: Throwable -> L17 Exception -> L19
        r4 = e.j(r11);     // Catch: Throwable -> L17 Exception -> L19
        goto L22
    L21:
        e.a.getClass();     // Catch: Throwable -> L17 Exception -> L19
        r4 = e.h(r11);     // Catch: Throwable -> L17 Exception -> L19
    L17:
        th = move-exception;
        if (0 == 0) goto L30;
        r5.close();
    L30:
        throw th;
    L19:
        e = move-exception;
        FLogger.a.w("MediaSyncExecutor", "Error checking media album: " + e.getMessage());     // Catch: Throwable -> L17
        if (0 == 0) goto L27;
    L5:
        r2 = "_data";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static final Uri f(ContentResolver r29, String r30, String r31, MediaMetadata r32) {
        Intrinsics.checkNotNullParameter(r29, "<this>");
        Intrinsics.checkNotNullParameter(r30, "fileName");
        Intrinsics.checkNotNullParameter(r31, "filePath");
        Intrinsics.checkNotNullParameter(r32, "metadata");
        boolean r7 = k(r30);
        Intrinsics.checkNotNullParameter(r30, "<this>");
        String r2 = r30.toLowerCase(Locale.getDefault());
        if (StringsKt.endsWith$default(r2, ".png", false, 2, null) == false) goto L6;
        String r3 = "image/png";
    L30:
        String r8 = r3;
    L32:
        if (r8 != null) goto L38;
        AppHost.Companion r1 = AppHost.a;
        if (r1.isTestChannel() == false) goto L36;
        s.j(s.a, r1.getApplication(), "Unsupported file type: ".concat(r30), null, false, 28);
    L36:
        FLogger.a.e("MediaSyncExecutor", "Unsupported file type: ".concat(r30));
        return null;
    L38:
        long r5 = r32.getCreateTime();
        long r16 = 0;
        if (r5 <= 0) goto L41;
        r16 = r5 / ((long) 1000);
        long r13 = r5;
        int r12 = 1000;
    L51:
        if (r16 >= 31536000) goto L53;
        r16 = System.currentTimeMillis() / ((long) r12);
    L53:
        long r6 = r16;
        FLogger r4 = FLogger.a;
        r4.d("MediaSyncExecutor", "Insert media with timestamp: " + r6 + " seconds (createTimeMs: " + r13 + ", fileName: " + r30 + ')');
        ContentValues r14 = new ContentValues();
        r14.put("_display_name", r30);
        r14.put("mime_type", r8);
        r14.put("date_added", Long.valueOf(r6));
        r14.put("date_modified", Long.valueOf(r6));
        Uri r0 = e(r29, r7);
        int r9 = Build.VERSION.SDK_INT;
        if (r9 < 29) goto L56;
        r14.put("datetaken", Long.valueOf(((long) r12) * r6));
        e.a.getClass();
        r14.put("relative_path", e.k());
    L63:
        GeoLocationInfo r15 = r32.getGeoLocationInfo();
        if (r15 == null) goto L72;
        double r10 = r15.getLatitude();
        if (r15.getLongitude() <= 180.0d) goto L68;
        double r17 = r15.getLongitude() - ((double) 360);
    L70:
        if (r9 >= 29) goto L73;
        r4.d("MediaSyncExecutor", "Setting location info");
        r14.put("latitude", Double.valueOf(r10));
        r14.put("longitude", Double.valueOf(r17));
    L73:
        r4.d("MediaSyncExecutor", "insert media: " + r0 + ", isVideo: " + r7);
        ArrayList r18 = new ArrayList();
        Object[] r11 = {r0, r14};
        f06.b r19 = new f06.b();
        g06.a r20 = (g06.a) ApiHookConfig.b.get(240017);
        if (r20 == null) goto L76;
        f06.a[] r21 = r20.i;
    L77:
        f06.a[] r22 = r21;
        int r23 = r22.length;
        int r24 = 0;
    L79:
        if (r24 >= r23) goto L86;
        f06.a r25 = r22[r24];
        long r26 = r6;
        int r110 = r24;
        ContentResolver r27 = r29;
        int r28 = r23;
        f06.a[] r210 = r22;
        Object[] r211 = r11;
        f06.d r33 = r25.preInvoke(240017, "android/content/ContentResolver", "insert", r27, r11, "android.net.Uri", r19);     // Catch: Exception -> L140
        if (r33.a == true) goto L83;
        r18.add(r25);     // Catch: Exception -> L140
        goto L85
    L83:
        ?? r34 = r27;
    L88:
        if (r33.a == false) goto L90;
        Uri r35 = (Uri) r33.b;
    L91:
        Uri r36 = r35;
        String r37 = "Failed to insert media file.";
        if (r36 != null) goto L151;
        Uri r38 = null;
        ?? r39 = 0;
        FLogger.a.e("MediaSyncExecutor", "Failed to insert media file.");
    L131:
        if (r15 == null) goto L136;
        GalleryMobHelper r40 = GalleryMobHelper.a;
        String r41 = r32.getMediaType();
        if (r41 != null) goto L135;
        r41 = "image";
    L135:
        r40.getClass();
        GalleryMobHelper.j(r41, r15, r39, r37);
    L136:
        if (r39 == 0) goto L139;
        return r36;
    L139:
        return r38;
    L151:
        OutputStream r42 = ContentResolverWrapper.openOutputStream(r29, r36);     // Catch: Exception -> L122
        if (r42 == null) goto L119;
        PolarisFileInputStreamWrapper r43 = new PolarisFileInputStreamWrapper(r31);     // Catch: Throwable -> L110
        r34 = 0;
        ByteStreamsKt.copyTo$default(r43, r42, 0, 2, null);     // Catch: Throwable -> L103
        CloseableKt.closeFinally(r43, null);     // Catch: Throwable -> L101
        CloseableKt.closeFinally(r42, null);     // Catch: Exception -> L120
        FLogger.a.d("MediaSyncExecutor", "Successfully inserted media: " + r36 + " with timestamp: " + r26);     // Catch: Exception -> L120
        Unit r44 = Unit.INSTANCE;     // Catch: Exception -> L120
        r37 = "";
        r38 = null;
        r39 = 1;
        goto L131
    L101:
        th = th;
    L112:
        Throwable r45 = th;
        throw r45;     // Catch: Throwable -> L114
    L114:
        th = move-exception;
        CloseableKt.closeFinally(r42, r45);     // Catch: Exception -> L120
        throw th;     // Catch: Exception -> L120
    L103:
        th = move-exception;
        throw th;     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        CloseableKt.closeFinally(r43, th);     // Catch: Throwable -> L101
        throw th;     // Catch: Throwable -> L101
    L110:
        th = th;
        r34 = 0;
        goto L112
    L119:
        throw new IOException("Failed to open output stream for " + r36);     // Catch: Exception -> L120
    L120:
        e = e;
    L124:
        String r46 = "Failed to insert media file. " + e.getMessage();
        e.printStackTrace();
        FLogger.a.e("MediaSyncExecutor", "Failed to insert media file.", e);
        r38 = null;
        a(r29, r36, null);     // Catch: Exception -> L127
    L129:
        r37 = r46;
        r39 = r34;
    L127:
        e = move-exception;
        FLogger.a.e("MediaSyncExecutor", "Failed to delete empty media file.", e);
        Unit r47 = Unit.INSTANCE;
    L122:
        e = e;
        r34 = 0;
        goto L124
    L90:
        r35 = r29.insert(r0, r14);
    L85:
        int r48 = (r110 == true ? 1 : 0) + 1;
        r23 = r28;
        r6 = r26;
        r22 = r210;
        r11 = r211;
        r24 = r48;
        goto L79
    L86:
        r26 = r6;
        r33 = new f06.d(false, null);
        r34 = r24;
        goto L88
    L76:
        r21 = ApiHookConfig.d;
        goto L77
    L68:
        r17 = r15.getLongitude();
        goto L70
    L72:
        r6 = r6;
        goto L73
    L56:
        File r49 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        if (r49.exists() == false) goto L59;
    L62:
        r14.put("_data", r31);
        goto L63
    L59:
        if (r49.mkdirs() == true) goto L62;
        r4.e("MediaSyncExecutor", "save error: can't create " + Environment.DIRECTORY_DCIM + " directory");
        return null;
    L41:
        Intrinsics.checkNotNullParameter(r30, "<this>");
        r12 = 1000;
        r13 = r5;
        List r50 = StringsKt.split$default(r30, new String[]{"_"}, false, 0, 6, null);
        if (r50.size() < 7) goto L44;
        Long r51 = StringsKt.toLongOrNull((String) ListProtector.get(r50, 6));
    L45:
        if (r51 == null) goto L51;
        if (r51.toString().length() < 13) goto L49;
        r16 = r51.longValue() / ((long) 1000);
        goto L51
    L49:
        r16 = r51.longValue();
        goto L51
    L44:
        r51 = null;
        goto L45
    L6:
        if (StringsKt.endsWith$default(r2, ".jpg", false, 2, null) == false) goto L8;
    L29:
        r3 = "image/jpeg";
        goto L30
    L8:
        if (StringsKt.endsWith$default(r2, ".jpeg", false, 2, null) == true) goto L29;
        if (StringsKt.endsWith$default(r2, ".webp", false, 2, null) == false) goto L14;
        r3 = "image/webp";
        goto L30
    L14:
        if (StringsKt.endsWith$default(r2, ".gif", false, 2, null) == false) goto L17;
        r3 = "image/gif";
        goto L30
    L17:
        if (StringsKt.endsWith$default(r2, ".mp4", false, 2, null) == false) goto L20;
        r3 = "video/mp4";
        goto L30
    L20:
        if (StringsKt.endsWith$default(r2, ".mkv", false, 2, null) == false) goto L23;
        r3 = "video/x-matroska";
        goto L30
    L23:
        if (StringsKt.endsWith$default(r2, ".avi", false, 2, null) == false) goto L26;
        r3 = "video/x-msvideo";
        goto L30
    L26:
        if (StringsKt.endsWith$default(r2, ".mov", false, 2, null) == false) goto L28;
        r3 = "video/quicktime";
        goto L30
    L28:
        r8 = null;
        goto L32
    }
}
