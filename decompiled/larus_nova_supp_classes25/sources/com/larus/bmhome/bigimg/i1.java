package com.larus.bmhome.bigimg;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i1 {
    public static String a;

    public static String b() {
        if (TextUtils.isEmpty(a) == true) goto L7;
        return a;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L19;
        Application r0 = AppHost.a.getApplication();
        if (r0 != null) goto L12;
        return null;
    L12:
        File r1 = r0.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if (r1 == null) goto L18;
        if (r1.exists() == false) goto L18;
        a = r1.getAbsolutePath();
    L18:
        return a;
    L19:
        File r2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2, "Camera");
        if (r3.exists() == false) goto L23;
        String r4 = r3.getAbsolutePath();
        a = r4;
        return r4;
    L23:
        PolarisFileWrapper r5 = new PolarisFileWrapper(r2, "100MEDIA");
        if (r5.exists() == false) goto L27;
        String r6 = r5.getAbsolutePath();
        a = r6;
        return r6;
    L27:
        PolarisFileWrapper r7 = new PolarisFileWrapper(r2, "100ANDRO");
        if (r7.exists() == false) goto L31;
        String r8 = r7.getAbsolutePath();
        a = r8;
        return r8;
    L31:
        String r9 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "nova_image";
        PolarisFileWrapper r10 = new PolarisFileWrapper(r9);
        if (r10.exists() == true) goto L34;
        r10.mkdirs();
    L34:
        a = r9;
        return r9;
    }

    public static Uri c(Context r2, PolarisFileWrapper r3) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        return FileProvider.getUriForFile(r2, r2.getPackageName() + ".ug.sdk.share.fileprovider", r3);
    L9:
        return FileProvider.getUriForFile(r2, r2.getPackageName() + ".fileprovider", r3);
    L11:
        th = move-exception;
        FLogger.a.e("ImageFileUtils", th.toString());
        return null;
    L14:
        return Uri.fromFile(r3);
    L5:
        r0 = false;
        goto L6
    }

    public static Uri a(ContentResolver r18, Uri r19, ContentValues r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (Uri) r4.b;
    L21:
        return r18.insert(r19, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static boolean d(File r7, String r8, String r9) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L90:
        return false;
    L5:
        if (TextUtils.isEmpty(r9) == true) goto L90;
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L90;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r8);
        if (r0.exists() == true) goto L12;
        r0.mkdirs();
    L12:
        PolarisFileWrapper r10 = new PolarisFileWrapper(r0, r9);
        if (r10.exists() == false) goto L28;
        r10 = new PolarisFileWrapper(r0, r9);
        if (r10.exists() == false) goto L28;
        int r2 = r9.lastIndexOf(".");
        if (r2 > 0) goto L20;
    L22:
        String r4 = r9;
        String r11 = "";
    L23:
        int r3 = 1;
    L25:
        if (r10.exists() == false) goto L28;
        r10 = new PolarisFileWrapper(r0, r4 + "(" + r3 + ")" + r11);
        r3 = r3 + 1;
        goto L25
    L20:
        if (r2 >= (r9.length() - 1)) goto L22;
        r4 = r9.substring(0, r2);
        r11 = r9.substring(r2);
    L28:
        if (r10.exists() == false) goto L97;
    L34:
        FileInputStream r12 = null;
        FileInputStream r1 = new PolarisFileInputStreamWrapper(r7);     // Catch: Throwable -> L62 Exception -> L64
        PolarisFileOutputStreamWrapper r13 = new PolarisFileOutputStreamWrapper(r10);     // Catch: Throwable -> L56 Exception -> L59
    L107:
        byte[] r14 = new byte[2048];     // Catch: Throwable -> L52 Exception -> L54
    L40:
        if (r1.read(r14) < 0) goto L42;
        r13.write(r14);     // Catch: Throwable -> L52 Exception -> L54
        goto L40
    L42:
        r13.flush();     // Catch: Throwable -> L52 Exception -> L54
        r1.close();     // Catch: Exception -> L45
    L99:
        r13.close();     // Catch: Exception -> L49
    L51:
        return true;
    L49:
        e = move-exception;
        e.printStackTrace();
    L45:
        e = move-exception;
        e.printStackTrace();
        goto L99
    L54:
        e = e;
    L61:
        r12 = r1;
    L93:
        e.printStackTrace();     // Catch: Throwable -> L78
        if (r12 != null) goto L101;
    L72:
        if (r13 != null) goto L105;
    L77:
        return false;
    L105:
        r13.close();     // Catch: Exception -> L75
    L75:
        e = move-exception;
        e.printStackTrace();
        goto L77
    L101:
        r12.close();     // Catch: Exception -> L70
    L70:
        e = move-exception;
        e.printStackTrace();
    L78:
        th = th;
    L79:
        if (r12 != null) goto L95;
    L84:
        if (r13 == null) goto L115;
        r13.close();     // Catch: Exception -> L87
        throw th;
    L87:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L115:
        throw th;
    L95:
        r12.close();     // Catch: Exception -> L82
    L82:
        e = move-exception;
        e.printStackTrace();
    L52:
        th = th;
    L58:
        r12 = r1;
    L59:
        e = e;
        r13 = null;
    L56:
        th = th;
        r13 = null;
        goto L58
    L64:
        e = e;
        r13 = null;
    L62:
        th = th;
        r13 = null;
        goto L79
    L97:
        r10.createNewFile();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean e(Bitmap r12, String r13, String r14) {
        if (TextUtils.isEmpty(r13) == false) goto L5;
    L75:
        return false;
    L5:
        if (TextUtils.isEmpty(r14) == true) goto L75;
        FileOutputStream r2 = null;
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L40;
        int r0 = j1.a;
        AppHost.Companion r1 = AppHost.a;
        String r4 = r1.getApplication().getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNull(r4);
        String r5 = StringsKt.replace$default(r4, "/user/0/", "/data/", false, 4, null);
        String r3 = r1.getApplication().getCacheDir().getAbsolutePath();
        Intrinsics.checkNotNull(r3);
        String r6 = StringsKt.replace$default(r3, "/user/0/", "/data/", false, 4, null);
        if (r13 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == true) goto L36;
        if (r13 != null) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == true) goto L36;
        if (r13 != null) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == true) goto L36;
        if (r13 != null) goto L30;
    L32:
        boolean r10 = false;
    L33:
        if (r10 == true) goto L36;
        boolean r11 = false;
    L37:
        if (r11 == true) goto L40;
        return false;
    L30:
        if (StringsKt.startsWith$default(r13, r6, false, 2, null) != true) goto L32;
        r10 = true;
        goto L33
    L24:
        if (StringsKt.startsWith$default(r13, r3, false, 2, null) != true) goto L26;
        r9 = true;
        goto L27
    L18:
        if (StringsKt.startsWith$default(r13, r5, false, 2, null) != true) goto L20;
        r8 = true;
    L36:
        r11 = true;
        goto L37
    L12:
        if (StringsKt.startsWith$default(r13, r4, false, 2, null) != true) goto L14;
        r7 = true;
    L40:
        PolarisFileWrapper r15 = new PolarisFileWrapper(r13);
        if (r15.exists() == true) goto L43;
        r15.mkdirs();
    L43:
        PolarisFileWrapper r16 = new PolarisFileWrapper(r15 + "/" + r14);
        if (r16.exists() == false) goto L83;
    L80:
        FileOutputStream r17 = new PolarisFileOutputStreamWrapper(r16);     // Catch: Throwable -> L61 Exception -> L63
        r12.compress(Bitmap.CompressFormat.JPEG, 100, r17);     // Catch: Throwable -> L57 Exception -> L59
        r17.flush();     // Catch: Throwable -> L57 Exception -> L59
        r17.close();     // Catch: Exception -> L54
    L56:
        return true;
    L54:
        e = move-exception;
        e.printStackTrace();
        goto L56
    L59:
        e = e;
        r2 = r17;
    L64:
        e.printStackTrace();     // Catch: Throwable -> L61
        r2.close();     // Catch: Exception -> L67
    L69:
        return false;
    L67:
        e = move-exception;
        e.printStackTrace();
    L57:
        th = th;
        r2 = r17;
    L78:
        r2.close();     // Catch: Exception -> L72
    L74:
        throw th;
    L72:
        e = move-exception;
        e.printStackTrace();
    L63:
        e = e;
    L61:
        th = th;
        goto L78
    L83:
        r16.createNewFile();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static Uri f(Context r6, String r7, boolean r8) {
        BufferedInputStream r0 = null;
        OutputStream r1 = null;
        r1 = null;
        r1 = null;
        r0 = null;
        if (r6 != null) goto L5;
    L73:
        return null;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L73;
        if (Build.VERSION.SDK_INT >= 29) goto L11;
        MediaScannerConnection.scanFile(r6, new String[]{r7}, null, new h1());
        return null;
    L11:
        PolarisFileWrapper r2 = new PolarisFileWrapper(r7);
        if (r2.exists() == true) goto L14;
        return null;
    L14:
        ContentResolver r9 = r6.getContentResolver();
        ContentValues r10 = new ContentValues();
        r10.put("title", r2.getName());
        r10.put("_display_name", r2.getName());
        if (r8 == false) goto L17;
        String r3 = "image/*";
    L18:
        r10.put("mime_type", r3);
        if (r8 == false) goto L21;
        String r4 = Environment.DIRECTORY_PICTURES;
    L22:
        r10.put("relative_path", r4);
        if (r8 == false) goto L25;
        Uri r11 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L28
    L26:
        Uri r12 = a(r9, r11, r10);     // Catch: Exception -> L28
    L76:
        BufferedInputStream r13 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r2));     // Catch: Throwable -> L49 IOException -> L51
        if (r12 != null) goto L81;
    L36:
        if (r1 == null) goto L45;
        byte[] r14 = new byte[4096];     // Catch: Throwable -> L32 IOException -> L34
    L38:
        int r5 = r13.read(r14);     // Catch: Throwable -> L32 IOException -> L34
        if (r5 == (-1)) goto L41;
        r1.write(r14, 0, r5);     // Catch: Throwable -> L32 IOException -> L34
        goto L38
    L41:
        r1.flush();     // Catch: Throwable -> L32 IOException -> L34
    L34:
        e = e;
        OutputStream r15 = r1;
        r0 = r13;
        OutputStream r16 = r15;
    L77:
        e.printStackTrace();     // Catch: Throwable -> L63
        if (r0 == null) goto L58;
        r0.close();     // Catch: IOException -> L56
    L58:
        if (r16 == null) goto L62;
        r16.close();     // Catch: IOException -> L56
    L62:
        return r12;
    L63:
        th = th;
    L64:
        if (r0 != null) goto L74;
    L68:
        if (r16 == null) goto L72;
        r16.close();     // Catch: IOException -> L66
    L66:
        e = move-exception;
        e.printStackTrace();
    L72:
        throw th;
    L74:
        r0.close();     // Catch: IOException -> L66
    L32:
        th = th;
        OutputStream r17 = r1;
        r0 = r13;
        r16 = r17;
    L45:
        r13.close();     // Catch: IOException -> L56
        if (r1 == null) goto L62;
        r1.close();     // Catch: IOException -> L56
        goto L62
    L81:
        r1 = ContentResolverWrapper.openOutputStream(r9, r12);     // Catch: Throwable -> L32 IOException -> L34
        goto L36
    L56:
        e = move-exception;
        e.printStackTrace();
    L51:
        e = e;
        r16 = null;
    L49:
        th = th;
        r16 = null;
        goto L64
    L25:
        r11 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L28
    L28:
        r12 = null;
        goto L76
    L21:
        r4 = Environment.DIRECTORY_MOVIES;
        goto L22
    L17:
        r3 = "video/mp4";
        goto L18
    }

    public static Uri g(Context r6, String r7, String r8, boolean r9) {
        BufferedInputStream r0 = null;
        OutputStream r1 = null;
        r1 = null;
        r1 = null;
        r0 = null;
        if (r6 != null) goto L5;
    L75:
        return null;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L75;
        if (Build.VERSION.SDK_INT >= 29) goto L11;
        MediaScannerConnection.scanFile(r6, new String[]{r7}, null, new h1());
        return null;
    L11:
        PolarisFileWrapper r2 = new PolarisFileWrapper(r7);
        if (r2.exists() == true) goto L14;
        return null;
    L14:
        if (r8 != null) goto L19;
        if (r9 == false) goto L17;
        String r10 = Environment.DIRECTORY_DCIM;
    L18:
        r8 = r10;
        goto L19
    L17:
        r10 = Environment.DIRECTORY_MOVIES;
    L19:
        ContentResolver r11 = r6.getContentResolver();
        ContentValues r12 = new ContentValues();
        r12.put("title", r2.getName());
        r12.put("_display_name", r2.getName());
        if (r9 == false) goto L22;
        String r3 = "image/*";
    L23:
        r12.put("mime_type", r3);
        r12.put("relative_path", r8);
        if (r9 == false) goto L26;
        Uri r13 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L29
    L27:
        Uri r14 = a(r11, r13, r12);     // Catch: Exception -> L29
    L82:
        BufferedInputStream r15 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r2));     // Catch: Throwable -> L51 IOException -> L53
        if (r14 != null) goto L84;
    L38:
        if (r1 == null) goto L47;
        byte[] r16 = new byte[4096];     // Catch: Throwable -> L34 IOException -> L36
    L40:
        int r17 = r15.read(r16);     // Catch: Throwable -> L34 IOException -> L36
        if (r17 == (-1)) goto L43;
        r1.write(r16, 0, r17);     // Catch: Throwable -> L34 IOException -> L36
        goto L40
    L43:
        r1.flush();     // Catch: Throwable -> L34 IOException -> L36
    L36:
        e = e;
        OutputStream r5 = r1;
        r0 = r15;
        OutputStream r18 = r5;
    L78:
        e.printStackTrace();     // Catch: Throwable -> L65
        if (r0 == null) goto L60;
        r0.close();     // Catch: IOException -> L58
    L60:
        if (r18 == null) goto L64;
        r18.close();     // Catch: IOException -> L58
    L64:
        return r14;
    L65:
        th = th;
    L66:
        if (r0 != null) goto L80;
    L70:
        if (r18 == null) goto L74;
        r18.close();     // Catch: IOException -> L68
    L68:
        e = move-exception;
        e.printStackTrace();
    L74:
        throw th;
    L80:
        r0.close();     // Catch: IOException -> L68
    L34:
        th = th;
        OutputStream r19 = r1;
        r0 = r15;
        r18 = r19;
    L47:
        r15.close();     // Catch: IOException -> L58
        if (r1 == null) goto L64;
        r1.close();     // Catch: IOException -> L58
        goto L64
    L84:
        r1 = ContentResolverWrapper.openOutputStream(r11, r14);     // Catch: Throwable -> L34 IOException -> L36
        goto L38
    L58:
        e = move-exception;
        e.printStackTrace();
    L53:
        e = e;
        r18 = null;
    L51:
        th = th;
        r18 = null;
        goto L66
    L26:
        r13 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L29
    L29:
        e = move-exception;
        FLogger.a.e("ImageFileUtils", "syncMediaToTargetAlbum failed", e);
        r14 = null;
        goto L82
    L22:
        r3 = "video/mp4";
        goto L23
    }
}
