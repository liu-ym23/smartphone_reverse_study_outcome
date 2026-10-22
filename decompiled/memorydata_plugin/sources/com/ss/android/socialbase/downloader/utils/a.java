package com.ss.android.socialbase.downloader.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.service.k;
import com.ss.android.socialbase.downloader.service.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15648a = "ByteDownload";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f15649b = 0;
    private static String c;
    private static volatile File d;
    private static volatile File e;
    private static volatile File f;
    private static volatile File g;
    private static volatile File h;
    private static volatile File i;
    private static volatile File j;
    private static volatile Boolean k;

    static {
        f15649b = SystemClock.uptimeMillis();
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
    }

    public static File a(Context r2, boolean r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (d == null) goto L13;
        if (r3 == true) goto L13;
        return d;
    L13:
        d = r4.getExternalCacheDir();     // Catch: Throwable -> L9
    L12:
        return d;
    L9:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDirUtils", "getExternalCacheDir", "Error:" + th);
        goto L12
    }

    public static File a(boolean r2) {
        if (h == null) goto L13;
        if (r2 == true) goto L13;
        return h;
    L13:
        h = Environment.getExternalStorageDirectory();     // Catch: Throwable -> L9
    L12:
        return h;
    L9:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDirUtils", "getExternalStorageDirectory", "Error:" + th);
        goto L12
    }

    public static String a() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        File r1 = c(r0, false);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getAbsolutePath();
    L8:
        return null;
    }

    public static String a(File r3) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (b(r3) == true) goto L5;
        if (r0 != null) goto L10;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDirUtils", "getValidDownloadPath", "Context is null");
        return null;
    L10:
        if (com.ss.android.socialbase.downloader.g.a.c().b("fix_save_external_dir") > 0) goto L12;
        File r4 = d(r0, false);
        if (b(r4) == false) goto L18;
        return r4.getAbsolutePath();
    L18:
        return a();
    L12:
        return a();
    L5:
        return r3.getAbsolutePath();
    }

    public static void a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        a(r3, true);
        b(r3, true);
        c(r3, true);
        d(r3, true);
        a(true);
        b(true);
        c(true);
        d(true);
    }

    public static boolean a(String r4) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        File r2 = b(false);     // Catch: Exception -> L17
        if (r2 != null) goto L10;
    L12:
        File r1 = a(r0, false);     // Catch: Exception -> L17
        if (r1 == null) goto L19;
        if (r4.startsWith(r1.getParent()) == false) goto L19;
        return true;
    L10:
        if (r4.startsWith(r2.getAbsolutePath()) == false) goto L12;
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("DownloadDirUtils", "isSavePathSecurity", "Error:" + e);
        goto L19
    }

    public static File b(Context r2, boolean r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (e == null) goto L13;
        if (r3 == true) goto L13;
        return e;
    L13:
        e = r4.getObbDir();     // Catch: Throwable -> L9
    L12:
        return e;
    L9:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDirUtils", "getObbDirStr", "Error:" + th);
        goto L12
    }

    public static File b(boolean r2) {
        if (i == null) goto L13;
        if (r2 == true) goto L13;
        return i;
    L13:
        i = Environment.getDataDirectory();     // Catch: Throwable -> L9
    L12:
        return i;
    L9:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDirUtils", "getDataDirectory", "Error:" + th);
        goto L12
    }

    public static String b() {
        return a(Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getGlobalSaveDir());
    }

    public static boolean b(File r2) {
        if (r2 != null) goto L16;
        return false;
    L16:
    L15:
        return false;
    L6:
        if (r2.exists() == false) goto L8;
    L10:
        if (r2.isDirectory() == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        if (r2.mkdirs() == true) goto L10;
        return false;
    }

    public static File c(Context r2, boolean r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f == null) goto L13;
        if (r3 == true) goto L13;
        return f;
    L13:
        f = r4.getFilesDir();     // Catch: Throwable -> L9
    L12:
        return f;
    L9:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDirUtils", "getFilesDir", "Error:" + th);
        goto L12
    }

    public static File c(boolean r2) {
        if (j == null) goto L13;
        if (r2 == true) goto L13;
        return j;
    L13:
        j = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L9
    L12:
        return j;
    L9:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDirUtils", "getExternalStoragePublicDirectory", "Error:" + th);
        goto L12
    }

    public static String c() {
        return a(Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getGlobalSaveTempDir());
    }

    public static Uri d() {
        return MediaStore.Files.getContentUri("external");
    }

    public static File d(Context r2, boolean r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (g == null) goto L13;
        if (r3 == true) goto L13;
        return g;
    L13:
        g = r4.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L9
    L12:
        return g;
    L9:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDirUtils", "getExternalFilesDir", "Error:" + th);
        goto L12
    }

    public static boolean d(boolean r2) {
        if (k == null) goto L15;
        if (r2 == true) goto L15;
    L6:
        return k.booleanValue();
    L15:
    L13:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadDirUtils", "isExternalStorageLegacy", "Error:" + th);
        goto L6
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L11;
        boolean r3 = Boolean.valueOf(Environment.isExternalStorageLegacy());     // Catch: Throwable -> L13
    L10:
        k = r3;     // Catch: Throwable -> L13
        goto L6
    L11:
        r3 = false;     // Catch: Throwable -> L13
        goto L10
    }

    public static String e() {
        String r1 = c;
        if (r1 == null) goto L10;
        return r1;
    L10:
        String r0 = c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), false) + File.separator + "download" + File.separator + "temp_fast_download" + File.separator + f15649b;     // Catch: Throwable -> L7
        c = r0;     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("DownloadDirUtils", "getDownloadFastTempPath", "Error:" + th);
        return null;
    }
}
