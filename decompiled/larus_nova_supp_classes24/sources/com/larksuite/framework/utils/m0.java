package com.larksuite.framework.utils;

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
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.file.direct.DirectFileAccess;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.ss.android.lark.log.Log;
import f06.b;
import java.io.File;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Deprecated(message = "consider using InputStream and FD")
public final class m0 {
    public static final List<String> a = null;

    static {
        a = CollectionsKt.listOf(new String[]{"content://downloads/public_downloads", "content://downloads/my_downloads", "content://downloads/all_downloads"});
    }

    public static boolean e(PolarisFileWrapper r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.exists() == false) goto L8;
        if (r1.canRead() == false) goto L8;
        return true;
    }

    public static PolarisFileWrapper d(String r2, boolean r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r2);
        if (r3 == true) goto L9;
        return r1;
    L9:
        if (e(r1) == true) goto L11;
        return null;
    L11:
        return r1;
    }

    @Deprecated(message = "use InputStream or FD instead")
    @JvmStatic
    public static final PolarisFileWrapper b(Context r20, Uri r21, boolean r22) {
        PolarisFileWrapper r9 = null;
        if (r20 != null) goto L6;
        Log.e("UriCompatUtil", "context is null");
        return null;
    L6:
        if (r21 != null) goto L10;
        Log.e("UriCompatUtil", "uri is null");
        return null;
    L10:
        if (DocumentsContract.isDocumentUri(r20, r21) == false) goto L137;
        String r1 = r21.getAuthority();
        if (r1 == null) goto L137;
        int r4 = r1.hashCode();
        if (r4 == 320699453) goto L79;
        if (r4 == 596745902) goto L49;
        if (r4 != 1734583286) goto L137;
        if (r1.equals("com.android.providers.media.documents") == false) goto L137;
        String r14 = DocumentsContract.getDocumentId(r21);
        Intrinsics.checkNotNull(r14);
        List r0 = StringsKt.split$default(r14, new String[]{":"}, false, 0, 6, null);
        String r2 = (String) ListProtector.get(r0, 0);
        int r5 = r2.hashCode();
        if (r5 == 93166550) goto L40;
        if (r5 == 100313435) goto L36;
        if (r5 != 112202875) goto L42;
        if (r2.equals(GlobalAudioSceneEnum.VIDEO) == false) goto L42;
        Uri r3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    L47:
        PolarisFileWrapper r6 = d(c(r20, r3, "_id=?", new String[]{(String) ListProtector.get(r0, 1)}), r22);
    L138:
        if (r6 == null) goto L140;
        return r6;
    L140:
        if (StringsKt.equals("content", r21.getScheme(), true) == true) goto L143;
    L163:
        PolarisFileWrapper r7 = null;
    L165:
        if (r7 == null) goto L167;
        return r7;
    L167:
        if (StringsKt.equals("file", r21.getScheme(), true) == false) goto L171;
        r9 = d(r21.getPath(), r22);
    L171:
        return r9;
    L143:
        if (Intrinsics.areEqual("com.google.android.apps.photos.content", r21.getAuthority()) == false) goto L145;
        r7 = d(r21.getLastPathSegment(), r22);
        goto L165
    L145:
        r7 = d(c(r20, r21, null, null), r22);
        if (r7 != null) goto L165;
        if (Intrinsics.areEqual(r20.getPackageName() + ".common.fileprovider", r21.getAuthority()) == false) goto L159;
        String r8 = StringsKt.removePrefix(String.valueOf(r21.getPath()), File.separator);
        if (StringsKt.startsWith$default(r8, "android_files", false, 2, null) == false) goto L156;
        String r10 = StringsKt.removePrefix(r8, "android_files");
        File r11 = DirectFileAccess.c(new DirectFileAccess.a(null, DirectFileAccess.StorageLocation.EXTERNAL, null, r20, 237));
        if (r11 == null) goto L163;
        r7 = d(r11.getAbsolutePath() + r10, r22);
        goto L165
    L156:
        if (StringsKt.startsWith$default(r8, "external_files", false, 2, null) == false) goto L163;
        r7 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), StringsKt.removePrefix(r8, "external_files"));
        goto L165
    L159:
        if (Intrinsics.areEqual("com.android.fileexplorer.myprovider", r21.getAuthority()) == false) goto L163;
        String r12 = r21.getPath();
        if (r12 == null) goto L163;
        r7 = d(l.d(r20) + File.separator + r12, r22);
    L42:
        if (Build.VERSION.SDK_INT < 29) goto L44;
        r3 = MediaStore.Files.getContentUri("external");
    L45:
        Intrinsics.checkNotNull(r3);
        goto L47
    L44:
        r3 = MediaStore.Files.getContentUri("external");
        goto L45
    L36:
        if (r2.equals("image") == false) goto L42;
        r3 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        goto L47
    L40:
        if (r2.equals("audio") == false) goto L42;
        r3 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        goto L47
    L49:
        if (r1.equals("com.android.externalstorage.documents") == false) goto L137;
        String r13 = DocumentsContract.getDocumentId(r21);
        Intrinsics.checkNotNull(r13);
        List r15 = StringsKt.split$default(r13, new String[]{":"}, false, 0, 6, null);
        if (r15.size() <= 1) goto L137;
        String r16 = (String) ListProtector.get(r15, 0);
        String r17 = (String) ListProtector.get(r15, 1);
        if (StringsKt.equals(r16, "primary", true) == false) goto L57;
        PolarisFileWrapper r19 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), r17);
    L61:
        if (e(r19) == false) goto L63;
    L62:
        r6 = r19;
        goto L138
    L63:
        r19 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), r17);
        if (e(r19) == true) goto L62;
        if (r15.size() <= 2) goto L72;
        PolarisFileWrapper r23 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), r13.substring(StringsKt.indexOf$default(r13, ':', 0, false, 6, null) + 1));
        if (e(r23) == false) goto L72;
        Log.w("UriCompatUtil", "Illegal File Name Found");
    L71:
        r6 = r23;
    L72:
        Iterator r24 = CollectionsKt.listOf(new String[]{"SECONDARY_STORAGE", "EXTERNAL_STORAGE"}).iterator();
    L74:
        if (r24.hasNext() == false) goto L137;
        r23 = new PolarisFileWrapper((String) r24.next(), r17);
        if (e(r23) == false) goto L74;
    L57:
        if (StringsKt.equals(r16, "home", true) == false) goto L59;
        r19 = new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), r17);
        goto L61
    L59:
        r19 = null;
        goto L61
    L79:
        if (r1.equals("com.android.providers.downloads.documents") == false) goto L137;
        String r110 = DocumentsContract.getDocumentId(r21);
        BitSet r25 = f0.a;
        if (r110 != null) goto L84;
    L93:
        boolean r26 = false;
    L94:
        if (r26 == false) goto L129;
        Intrinsics.checkNotNull(r110);
        long r111 = CastLongProtector.parseLong(r110);
        Cursor r27 = a(r20.getContentResolver(), r21, null, null, null);     // Catch: Exception -> L114
        Cursor r29 = r27;     // Catch: Throwable -> L107
        if (r29 != null) goto L100;
    L104:
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L107
        CloseableKt.closeFinally(r27, null);     // Catch: Exception -> L114
        goto L115
    L100:
        if (r29.moveToFirst() == false) goto L104;
        String r31 = r29.getString(r29.getColumnIndexOrThrow("_display_name"));     // Catch: Throwable -> L107
        CloseableKt.closeFinally(r27, null);     // Catch: Exception -> L114
    L116:
        if (r31 == null) goto L120;
        r6 = d(Uri.withAppendedPath(UriProtector.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()), r31).toString(), r22);
        if (e(r6) == false) goto L120;
    L121:
        if (r6 != null) goto L138;
        Iterator<T> r32 = a.iterator();
    L125:
        if (r32.hasNext() == false) goto L137;
        PolarisFileWrapper r33 = d(c(r20, ContentUris.withAppendedId(UriProtector.parse((String) r32.next()), r111), null, null), r22);
        if (r33 == null) goto L125;
        r6 = r33;
    L120:
        r6 = null;
    L107:
        th = move-exception;
        throw th;     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        CloseableKt.closeFinally(r27, th);     // Catch: Exception -> L114
        throw th;     // Catch: Exception -> L114
    L115:
        r31 = null;
        goto L116
    L129:
        Intrinsics.checkNotNull(r110);
        if (StringsKt.startsWith$default(r110, "raw:", false, 2, null) == false) goto L133;
        r6 = d(StringsKt.replaceFirst$default(r110, "raw:", "", false, 4, null), r22);
        goto L138
    L133:
        if (StringsKt.startsWith$default(r110, "msf:", false, 2, null) == false) goto L137;
        if (Build.VERSION.SDK_INT < 29) goto L137;
        r6 = d(c(r20, MediaStore.Downloads.EXTERNAL_CONTENT_URI, "_id=?", new String[]{((String[]) StringsKt.split$default(r110, new String[]{":"}, false, 0, 6, null).toArray(new String[0]))[1]}), r22);
        goto L138
    L84:
        if (r110.length() == 0) goto L93;
        int r34 = r110.length();
        int r35 = 0;
    L87:
        if (r35 >= r34) goto L92;
        if (Character.isDigit(r110.codePointAt(r35)) == false) goto L93;
        r35 = r35 + 1;
        goto L87
    L92:
        r26 = true;
    L137:
        r6 = null;
        goto L138
    }

    public static String c(Context r4, Uri r5, String r6, String[] r7) {
        Cursor r8 = a(r4.getContentResolver(), r5, new String[]{"_data"}, r6, r7);     // Catch: RuntimeException -> L19 UnsupportedOperationException -> L29 SecurityException -> L31 IllegalArgumentException -> L37
        Cursor r9 = r8;     // Catch: Throwable -> L14
        if (r9 != null) goto L7;
    L11:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r8, null);     // Catch: RuntimeException -> L19 UnsupportedOperationException -> L29 SecurityException -> L31 IllegalArgumentException -> L37
    L39:
        return null;
    L7:
        if (r9.moveToFirst() == false) goto L11;
        String r11 = r9.getString(r9.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r8, null);     // Catch: RuntimeException -> L19 UnsupportedOperationException -> L29 SecurityException -> L31 IllegalArgumentException -> L37
        return r11;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: RuntimeException -> L19 UnsupportedOperationException -> L29 SecurityException -> L31 IllegalArgumentException -> L37
        throw th;     // Catch: RuntimeException -> L19 UnsupportedOperationException -> L29 SecurityException -> L31 IllegalArgumentException -> L37
    L37:
        e = move-exception;
        Log.e("UriCompatUtil", e);
    L31:
        Log.w("UriCompatUtil", "SecurityException for uri: " + r5);
        String r12 = r5.getPath();
        if (r12 != null) goto L35;
        return null;
    L35:
        if (StringsKt.startsWith$default(r12, "/storage/emulated/0", false, 2, null) == false) goto L39;
        return r12;
    L29:
        Log.w("UriCompatUtil", "UnsupportedOperationException for uri: " + r5);
        return null;
    L19:
        e = move-exception;
        StringBuilder r13 = new StringBuilder("getDataColumn failed by provider cursor runtime exception, ");
        StringBuilder r14 = new StringBuilder("scheme=");
        String r1 = r5.getScheme();
        String r2 = "";
        if (r1 != null) goto L23;
        r1 = "";
    L23:
        r14.append(r1);
        r14.append(", authority=");
        String r15 = r5.getAuthority();
        if (r15 == null) goto L27;
        r2 = r15;
    L27:
        r14.append(r2);
        r13.append(r14.toString());
        Log.e("UriCompatUtil", r13.toString(), e);
        return null;
    }

    public static Cursor a(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, null};
        b r10 = new b();
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
