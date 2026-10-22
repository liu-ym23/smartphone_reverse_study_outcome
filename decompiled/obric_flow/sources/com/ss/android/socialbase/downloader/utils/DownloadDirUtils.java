package com.ss.android.socialbase.downloader.utils;

import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import td.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadDirUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f16125a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f16126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile File f16127c;
    public static volatile File d;
    public static volatile File e;
    public static volatile File f;
    public static volatile File g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile File f16128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile Boolean f16129i;

    static {
        String r5 = Environment.DIRECTORY_DOWNLOADS;
        String r10 = File.separator;
        f16125a = SystemClock.uptimeMillis();
        f16126b = null;
        f16127c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        f16128h = null;
        f16129i = null;
    }

    public static String a() {
        Context r5 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e();
        if (r5 == null) goto L8;
        File r10 = c(r5, false);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getAbsolutePath();
    L8:
        return null;
    }

    public static boolean b(File r5) {
        if (r5 != null) goto L16;
        return false;
    L16:
    L15:
        return false;
    L6:
        if (r5.exists() == false) goto L8;
    L10:
        if (r5.isDirectory() == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        if (r5.mkdirs() == true) goto L10;
        return false;
    }

    public static File c(Context r5, boolean r10) {
        if (e == null) goto L13;
        if (r10 == true) goto L13;
        return e;
    L13:
        e = r5.getFilesDir();     // Catch: Throwable -> L9
    L12:
        return e;
    L9:
        th = move-exception;
        c.e("Error:", th, "DownloadDirUtils", "getFilesDir");
        goto L12
    }

    public static File d(Context r5, boolean r10) {
        if (d == null) goto L13;
        if (r10 == true) goto L13;
        return d;
    L13:
        d = r5.getObbDir();     // Catch: Throwable -> L9
    L12:
        return d;
    L9:
        th = move-exception;
        c.e("Error:", th, "DownloadDirUtils", "getObbDirStr");
        goto L12
    }

    public static String b() {
        String r5 = f16126b;
        if (r5 == null) goto L10;
        return r5;
    L10:
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L7
        r10.append(c(((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e(), false));     // Catch: Throwable -> L7
        String r11 = File.separator;     // Catch: Throwable -> L7
        r10.append(r11);     // Catch: Throwable -> L7
        r10.append("download");     // Catch: Throwable -> L7
        r10.append(r11);     // Catch: Throwable -> L7
        r10.append("temp_fast_download");     // Catch: Throwable -> L7
        r10.append(r11);     // Catch: Throwable -> L7
        r10.append(f16125a);     // Catch: Throwable -> L7
        String r12 = r10.toString();     // Catch: Throwable -> L7
        f16126b = r12;     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.c("DownloadDirUtils", "getDownloadFastTempPath", "Error:" + th);
        return null;
    }

    public static String a(File r5) {
        Context r10 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e();
        if (b(r5) == true) goto L5;
        if (r10 != null) goto L10;
        Logger.c("DownloadDirUtils", "getValidDownloadPath", "Context is null");
        return null;
    L10:
        if (DownloadSetting.f.a("fix_save_external_dir", 0) > 0) goto L12;
        File r11 = b(r10, false);
        if (b(r11) == false) goto L18;
        return r11.getAbsolutePath();
    L18:
        return a();
    L12:
        return a();
    L5:
        return r5.getAbsolutePath();
    }

    public static File b(Context r5, boolean r10) {
        if (f == null) goto L13;
        if (r10 == true) goto L13;
        return f;
    L13:
        f = r5.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L9
    L12:
        return f;
    L9:
        th = move-exception;
        c.e("Error:", th, "DownloadDirUtils", "getExternalFilesDir");
        goto L12
    }

    public static boolean a(String r10) {
        Context r5 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e();
        if (r5 != null) goto L5;
    L29:
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L29;
    L11:
        e = move-exception;
        e.printStackTrace();
        Logger.c("DownloadDirUtils", "isSavePathSecurity", "Error:" + e);
        goto L29
    L8:
        if (f16128h == null) goto L30;
        File r11 = f16128h;     // Catch: Exception -> L11
    L19:
        if (r11 != null) goto L21;
    L23:
        File r12 = a(r5, false);     // Catch: Exception -> L11
        if (r12 == null) goto L29;
        if (r10.startsWith(r12.getParent()) == false) goto L29;
        return true;
    L21:
        if (r10.startsWith(r11.getAbsolutePath()) == false) goto L23;
        return true;
    L30:
        f16128h = Environment.getDataDirectory();     // Catch: Throwable -> L15
    L17:
        r11 = f16128h;     // Catch: Exception -> L11
        goto L19
    L15:
        th = move-exception;
        Logger.c("DownloadDirUtils", "getDataDirectory", "Error:" + th);     // Catch: Exception -> L11
        goto L17
    }

    public static File a(Context r5, boolean r10) {
        if (f16127c == null) goto L13;
        if (r10 == true) goto L13;
        return f16127c;
    L13:
        f16127c = r5.getExternalCacheDir();     // Catch: Throwable -> L9
    L12:
        return f16127c;
    L9:
        th = move-exception;
        c.e("Error:", th, "DownloadDirUtils", "getExternalCacheDir");
        goto L12
    }

    public static boolean a(boolean r5) {
        if (f16129i == null) goto L13;
        if (r5 == true) goto L13;
        return f16129i.booleanValue();
    L13:
        f16129i = Boolean.valueOf(Environment.isExternalStorageLegacy());     // Catch: Throwable -> L9
    L12:
        return f16129i.booleanValue();
    L9:
        th = move-exception;
        c.e("Error:", th, "DownloadDirUtils", "isExternalStorageLegacy");
        goto L12
    }

    public static void a(Context r5) {
        a(r5, true);
        d(r5, true);
        c(r5, true);
        b(r5, true);
        g = Environment.getExternalStorageDirectory();     // Catch: Throwable -> L5
    L19:
        f16128h = Environment.getDataDirectory();     // Catch: Throwable -> L9
    L17:
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L13
    L15:
        a(true);
        return;
    L13:
        th = move-exception;
        c.e("Error:", th, "DownloadDirUtils", "getExternalStoragePublicDirectory");
    L9:
        th = move-exception;
        c.e("Error:", th, "DownloadDirUtils", "getDataDirectory");
    L5:
        th = move-exception;
        c.e("Error:", th, "DownloadDirUtils", "getExternalStorageDirectory");
        goto L19
    }
}
