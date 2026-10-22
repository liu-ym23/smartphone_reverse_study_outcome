package com.ss.android.socialbase.downloader.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.File;
import qb.k;
import qb.l;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f8317a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f8318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile File f8319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile File f8320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile File f8321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile File f8322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile File f8323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile File f8324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile File f8325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile Boolean f8326j;

    static {
        f8317a = SystemClock.uptimeMillis();
        f8318b = null;
        f8319c = null;
        f8320d = null;
        f8321e = null;
        f8322f = null;
        f8323g = null;
        f8324h = null;
        f8325i = null;
        f8326j = null;
    }

    public static void a(Context r10) {
        g(r10, true);
        l(r10, true);
        k(r10, true);
        h(r10, true);
        i(true);
        b(true);
        j(true);
        o(true);
    }

    public static File b(boolean r10) {
        if (f8324h == null) goto L13;
        if (r10 == true) goto L13;
        return f8324h;
    L13:
        f8324h = Environment.getDataDirectory();     // Catch: Throwable -> L9
    L12:
        return f8324h;
    L9:
        th = move-exception;
        lb.a.c("DownloadDirUtils", "getDataDirectory", "Error:" + th);
        goto L12
    }

    public static String c() {
        Context r10 = ((l) k.a(l.class)).getAppContext();
        if (r10 == null) goto L8;
        File r11 = k(r10, false);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getAbsolutePath();
    L8:
        return null;
    }

    public static String d() {
        String r10 = f8318b;
        if (r10 == null) goto L10;
        return r10;
    L10:
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L7
        r11.append(k(((l) k.a(l.class)).getAppContext(), false));     // Catch: Throwable -> L7
        String r12 = File.separator;     // Catch: Throwable -> L7
        r11.append(r12);     // Catch: Throwable -> L7
        r11.append("download");     // Catch: Throwable -> L7
        r11.append(r12);     // Catch: Throwable -> L7
        r11.append("temp_fast_download");     // Catch: Throwable -> L7
        r11.append(r12);     // Catch: Throwable -> L7
        r11.append(f8317a);     // Catch: Throwable -> L7
        String r13 = r11.toString();     // Catch: Throwable -> L7
        f8318b = r13;     // Catch: Throwable -> L7
        return r13;
    L7:
        th = move-exception;
        th.printStackTrace();
        lb.a.c("DownloadDirUtils", "getDownloadFastTempPath", "Error:" + th);
        return null;
    }

    public static String e() {
        return n(jb.f.u(((l) k.a(l.class)).getAppContext()).d());
    }

    public static String f() {
        return n(jb.f.u(((l) k.a(l.class)).getAppContext()).f());
    }

    public static File g(Context r10, boolean r11) {
        if (f8319c == null) goto L13;
        if (r11 == true) goto L13;
        return f8319c;
    L13:
        f8319c = r10.getExternalCacheDir();     // Catch: Throwable -> L9
    L12:
        return f8319c;
    L9:
        th = move-exception;
        lb.a.c("DownloadDirUtils", "getExternalCacheDir", "Error:" + th);
        goto L12
    }

    public static File h(Context r10, boolean r11) {
        if (f8322f == null) goto L13;
        if (r11 == true) goto L13;
        return f8322f;
    L13:
        f8322f = r10.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L9
    L12:
        return f8322f;
    L9:
        th = move-exception;
        lb.a.c("DownloadDirUtils", "getExternalFilesDir", "Error:" + th);
        goto L12
    }

    public static File i(boolean r10) {
        if (f8323g == null) goto L13;
        if (r10 == true) goto L13;
        return f8323g;
    L13:
        f8323g = Environment.getExternalStorageDirectory();     // Catch: Throwable -> L9
    L12:
        return f8323g;
    L9:
        th = move-exception;
        lb.a.c("DownloadDirUtils", "getExternalStorageDirectory", "Error:" + th);
        goto L12
    }

    public static File j(boolean r10) {
        if (f8325i == null) goto L13;
        if (r10 == true) goto L13;
        return f8325i;
    L13:
        f8325i = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L9
    L12:
        return f8325i;
    L9:
        th = move-exception;
        lb.a.c("DownloadDirUtils", "getExternalStoragePublicDirectory", "Error:" + th);
        goto L12
    }

    public static File k(Context r10, boolean r11) {
        if (f8321e == null) goto L13;
        if (r11 == true) goto L13;
        return f8321e;
    L13:
        f8321e = r10.getFilesDir();     // Catch: Throwable -> L9
    L12:
        return f8321e;
    L9:
        th = move-exception;
        lb.a.c("DownloadDirUtils", "getFilesDir", "Error:" + th);
        goto L12
    }

    public static File l(Context r10, boolean r11) {
        if (f8320d == null) goto L13;
        if (r11 == true) goto L13;
        return f8320d;
    L13:
        f8320d = r10.getObbDir();     // Catch: Throwable -> L9
    L12:
        return f8320d;
    L9:
        th = move-exception;
        lb.a.c("DownloadDirUtils", "getObbDirStr", "Error:" + th);
        goto L12
    }

    public static Uri m() {
        return MediaStore.Files.getContentUri("external");
    }

    public static String n(File r10) {
        Context r11 = ((l) k.a(l.class)).getAppContext();
        if (q(r10) == true) goto L5;
        if (r11 != null) goto L9;
        lb.a.c("DownloadDirUtils", "getValidDownloadPath", "Context is null");
        return null;
    L9:
        File r12 = h(r11, false);
        if (q(r12) == false) goto L14;
        return r12.getAbsolutePath();
    L14:
        return c();
    L5:
        return r10.getAbsolutePath();
    }

    public static boolean o(boolean r10) {
        if (f8326j == null) goto L15;
        if (r10 == true) goto L15;
    L6:
        return f8326j.booleanValue();
    L15:
    L13:
        th = move-exception;
        lb.a.c("DownloadDirUtils", "isExternalStorageLegacy", "Error:" + th);
        goto L6
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L11;
        Boolean r11 = Boolean.valueOf(Environment.isExternalStorageLegacy());     // Catch: Throwable -> L13
    L10:
        f8326j = r11;     // Catch: Throwable -> L13
        goto L6
    L11:
        r11 = Boolean.FALSE;     // Catch: Throwable -> L13
        goto L10
    }

    public static boolean p(String r10) {
        Context r11 = ((l) k.a(l.class)).getAppContext();
        if (r11 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L19;
        File r12 = b(false);     // Catch: Exception -> L17
        if (r12 != null) goto L10;
    L12:
        File r13 = g(r11, false);     // Catch: Exception -> L17
        if (r13 == null) goto L19;
        if (r10.startsWith(r13.getParent()) == false) goto L19;
        return true;
    L10:
        if (r10.startsWith(r12.getAbsolutePath()) == false) goto L12;
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        lb.a.c("DownloadDirUtils", "isSavePathSecurity", "Error:" + e);
        goto L19
    }

    public static boolean q(File r10) {
        if (r10 != null) goto L16;
        return false;
    L16:
    L15:
        return false;
    L6:
        if (r10.exists() == false) goto L8;
    L10:
        if (r10.isDirectory() == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        if (r10.mkdirs() == true) goto L10;
        return false;
    }
}
