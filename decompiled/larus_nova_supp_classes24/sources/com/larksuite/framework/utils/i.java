package com.larksuite.framework.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i {
    public static PolarisFileWrapper f(String r3) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(Environment.getExternalStorageDirectory() + File.separator + r3);
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        return r0;
    }

    public static String g(String r6, String r7) {
        PolarisFileWrapper r8 = f(r6);
        r8.mkdirs();
        String r9 = PatternProtector.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]").matcher(r7).replaceAll("_");
        Log.i("ExternalStorageUtils", "getExportFileName: " + r9);
        PolarisFileWrapper r0 = new PolarisFileWrapper(r8, r9);
        int r2 = r9.lastIndexOf(46);
        if (r2 >= 0) goto L5;
        r2 = r9.length();
    L5:
        int r3 = 0;
        String r4 = r9;
    L7:
        if (r0.exists() == false) goto L9;
        r3 = r3 + 1;
        r4 = new StringBuilder(r9).insert(r2, "(" + r3 + ")").toString();
        r0 = new PolarisFileWrapper(r8, r4);
        goto L7
    L9:
        Log.i("ExternalStorageUtils", "getUniqueFileNameWithNumber: " + r3);
        return r4;
    }

    public static boolean a(Context r4, String r5, Uri r6) {
        Log.i("ExternalStorageUtils", "copyFileToUri: uri = " + r6);
        if (r5 == null) goto L10;
        if (r6 == null) goto L10;
        return b(r4, new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r5)), r6);
    L8:
        e = move-exception;
        Log.e("ExternalStorageUtils", "copyFileToUri: ", e);
        e.printStackTrace();
    L10:
        return false;
    }

    public static boolean b(Context r4, InputStream r5, Uri r6) {
        Log.i("ExternalStorageUtils", "copyInputStreamToUri: uri = " + r6);
        if (r6 != null) goto L20;
    L19:
        return false;
    L20:
    L17:
        e = move-exception;
        Log.e("ExternalStorageUtils", "copyInputStreamToUri fail ", e);
        e.printStackTrace();
        goto L19
    L6:
        if (Build.VERSION.SDK_INT >= 29) goto L8;
        PolarisFileOutputStreamWrapper r7 = new PolarisFileOutputStreamWrapper(r6.getPath());     // Catch: IOException -> L17
    L9:
        if (r7 == null) goto L19;
        byte[] r8 = new byte[1024];     // Catch: IOException -> L17
    L11:
        int r2 = r5.read(r8);     // Catch: IOException -> L17
        if (r2 == (-1)) goto L14;
        r7.write(r8, 0, r2);     // Catch: IOException -> L17
        goto L11
    L14:
        r7.flush();     // Catch: IOException -> L17
        r5.close();     // Catch: IOException -> L17
        r7.close();     // Catch: IOException -> L17
        Log.i("ExternalStorageUtils", "copyInputStreamToUri success");     // Catch: IOException -> L17
        return true;
    L8:
        r7 = ContentResolverWrapper.openOutputStream(r4.getContentResolver(), r6);     // Catch: IOException -> L17
        goto L9
    }

    public static void h(Context r9, Uri r10, Token r11) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 29) goto L16;
        String r12 = r10.getPath();
        String[] r13 = FileUtils.a;
        if (TextUtils.isEmpty(r12) == true) goto L24;
        PolarisFileWrapper r14 = new PolarisFileWrapper(r12);
        if (r0 >= 29) goto L10;
    L13:
        DownloadManager r1 = (DownloadManager) r9.getSystemService("download");
        if (r1 == null) goto L21;
        r1.addCompletedDownload(r14.getName(), r14.getName(), true, FileUtils.p(r14.getPath()), r14.getAbsolutePath(), r14.length(), true);
        return;
    L21:
        return;
    L10:
        if (Environment.isExternalStorageLegacy() == true) goto L13;
        Log.e("FileUtils", "target Build.VERSION_CODES Q or above and running under the scoped storage model!!! ");
        return;
    L24:
        return;
    L16:
        String r15 = FileUtils.q(r9, r10);
        if (r15 == null) goto L23;
        MediaStoreUtil.j(r9, r15, r11);
        return;
    }

    public static void i(Context r2, Uri r3, Token r4) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        FileUtils.v(r2, r3.getPath(), r4);
        return;
    L5:
        String r5 = FileUtils.q(r2, r3);
        if (r5 == null) goto L10;
        MediaStoreUtil.j(r2, r5, r4);
        return;
    }

    public static void j(Context r6, Uri r7, String r8) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r7.getPath());
        int r1 = Build.VERSION.SDK_INT;
        boolean r2 = false;
        if (r1 >= 29) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L8;
        if (r1 != 29) goto L15;
        r2 = true;
    L15:
        if (r2 == true) goto L17;
    L21:
        Set<String> r3 = MediaStoreUtil.a;
        if (BdMediaFileSystem.isUriExists(r6, r7) == true) goto L25;
        return;
    L25:
        if (TextUtils.isEmpty(r8) == false) goto L27;
        Intrinsics.checkNotNullParameter(r6, "context");
        r8 = r6.getContentResolver().getType(r7);
    L27:
        Log.i("ExternalStorageUtils", "openUri: uri = " + r7 + ", mimeType = " + r8);
        Intent r4 = new Intent();
        r4.setAction("android.intent.action.VIEW");
        r4.addFlags(268435456);
        r4.setDataAndType(r7, r8);
        if (r1 < 24) goto L35;
        r4.addFlags(1);
        r4.addFlags(2);
    L35:
        r6.startActivity(r4);     // Catch: Exception -> L32
        return;
    L32:
        e = move-exception;
        Log.e("ExternalStorageUtils", "openUri: ", e);
        return;
    L17:
        if (r0.exists() == false) goto L21;
        r7 = m.a(r6, new PolarisFileWrapper(r7.getPath()));
        if (TextUtils.isEmpty(r8) == false) goto L27;
        String[] r9 = FileUtils.a;
        r8 = FileUtils.p(r0.getPath());
        goto L27
    L8:
        if (r0.exists() == true) goto L10;
        return;
    L10:
        r7 = m.a(r6, new PolarisFileWrapper(r7.getPath()));
        if (TextUtils.isEmpty(r8) == false) goto L27;
        String[] r10 = FileUtils.a;
        r8 = FileUtils.p(r0.getPath());
        goto L27
    L5:
        r5 = false;
        goto L6
    }

    public static Uri c(Context r1, String r2, String r3, MediaStoreUtil.DirType r4) {
        return e(r1, r2, r3, r4, null);
    }

    public static Uri d(Context r3, String r4, String r5, Token r6) {
        Set<String> r0 = MediaStoreUtil.a;
        MediaStoreUtil.DirType r1 = MediaStoreUtil.h(r4);
        Log.i("ExternalStorageUtils", "createUriPsda ... mimeType = dirType =" + r1 + " name =" + r4);
        if (TextUtils.isEmpty(r5) == true) goto L10;
        if (r5.startsWith("image") == true) goto L10;
        if (r1 != MediaStoreUtil.DirType.PICTURES) goto L10;
        Log.i("ExternalStorageUtils", "createUriPsda .. force dirType to be DOWNLOADS");
        r1 = MediaStoreUtil.DirType.DOWNLOADS;
    L10:
        return e(r3, r4, r5, r1, r6);
    }

    public static Uri e(Context r7, String r8, String r9, MediaStoreUtil.DirType r10, Token r11) {
        Uri r2 = null;
        if (r10 == null) goto L47;
    L7:
        StringBuilder r3 = new StringBuilder("createUri Build.VERSION.SDK_INT =");     // Catch: Throwable -> L5
        int r0 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L5
        r3.append(r0);     // Catch: Throwable -> L5
        r3.append(" mimeType =");     // Catch: Throwable -> L5
        r3.append(r9);     // Catch: Throwable -> L5
        r3.append(" dirType =");     // Catch: Throwable -> L5
        r3.append(r10);     // Catch: Throwable -> L5
        r3.append(" name =");     // Catch: Throwable -> L5
        r3.append(r8);     // Catch: Throwable -> L5
        Log.i("ExternalStorageUtils", r3.toString());     // Catch: Throwable -> L5
        boolean r4 = true;
        if (r0 >= 29) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L14;
        String r12 = MediaStoreUtil.i(r10);     // Catch: Throwable -> L5
        return Uri.fromFile(new PolarisFileWrapper(f(r12), g(r12, r8)));
    L14:
        if (TextUtils.isEmpty(r9) == false) goto L46;
        r9 = FileUtils.p(r8);     // Catch: Throwable -> L5
    L46:
    L28:
        th = move-exception;
        Log.e("ExternalStorageUtils", "createUri fallback", th);     // Catch: Throwable -> L5
    L38:
        if (r2 != null) goto L45;
        if (r11 == null) goto L50;
        return MediaStoreUtil.e(r7, r8, FileUtils.p(r8), MediaStoreUtil.DirType.DOWNLOADS, r11);
    L50:
        return MediaStoreUtil.d(r7, r8, FileUtils.p(r8), MediaStoreUtil.DirType.DOWNLOADS);
    L45:
        return r2;
    L5:
        th = move-exception;
        Log.e("ExternalStorageUtils", "createUri", th);
        goto L45
    L17:
        if (r9.contains("image") == false) goto L19;
    L33:
        if (r11 == null) goto L35;
        Uri r13 = MediaStoreUtil.e(r7, r8, r9, r10, r11);     // Catch: Throwable -> L28
    L36:
        r2 = r13;
        goto L38
    L35:
        r13 = MediaStoreUtil.d(r7, r8, r9, r10);     // Catch: Throwable -> L28
        goto L36
    L19:
        if (r9.contains(GlobalAudioSceneEnum.VIDEO) == true) goto L33;
        if (r9.contains("audio") == true) goto L33;
        if (r0 == 29) goto L26;
        r4 = false;
    L26:
        if (r4 == false) goto L30;
        String r14 = MediaStoreUtil.i(r10);     // Catch: Throwable -> L28
        r13 = Uri.fromFile(new PolarisFileWrapper(f(r14), g(r14, r8)));     // Catch: Throwable -> L28
        goto L36
    L30:
        if (r11 == null) goto L32;
        r13 = MediaStoreUtil.e(r7, r8, r9, r10, r11);     // Catch: Throwable -> L28
        goto L36
    L32:
        r13 = MediaStoreUtil.d(r7, r8, r9, r10);     // Catch: Throwable -> L28
        goto L36
    L10:
        r6 = false;
        goto L11
    L47:
        Set<String> r15 = MediaStoreUtil.a;     // Catch: Throwable -> L5
        r10 = MediaStoreUtil.h(r8);     // Catch: Throwable -> L5
        goto L7
    }
}
