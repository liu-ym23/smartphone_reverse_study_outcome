package com.ss.android.socialbase.downloader.d;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import com.obric.aikernel.sdk.ext.Params;
import com.ss.android.socialbase.downloader.service.k;
import com.ss.android.socialbase.downloader.service.l;
import com.ss.android.socialbase.downloader.utils.g;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SparseArray<a> f15357a;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Uri f15358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15359b;
        public String c;

        a() {
        }

        static a a(Uri r1, String r2) {
            a r0 = new a();
            r0.f15358a = r1;
            r0.f15359b = r1.toString();
            r0.c = r2;
            return r0;
        }
    }

    static {
        f15357a = new SparseArray();     // Catch: Throwable -> L9
        if (a() == false) goto L7;
        f15357a.put(2, a.a(MediaStore.Images.Media.getContentUri("external_primary"), "_id"));     // Catch: Throwable -> L9
        f15357a.put(3, a.a(MediaStore.Video.Media.getContentUri("external_primary"), "_id"));     // Catch: Throwable -> L9
        f15357a.put(4, a.a(MediaStore.Audio.Media.getContentUri("external_primary"), "_id"));     // Catch: Throwable -> L9
        f15357a.put(5, a.a(MediaStore.Downloads.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        f15357a.put(2, a.a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
        f15357a.put(3, a.a(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
        f15357a.put(4, a.a(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public static ParcelFileDescriptor a(Uri r3, String r4) {
        if (r3 == null) goto L13;
        ParcelFileDescriptor r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver().openFileDescriptor(r3, r4);     // Catch: Exception -> L9
        if (r5 == null) goto L8;
        return r5;
    L8:
        throw new IOException("Fail to get ParcelFileDescriptor, fileDescriptor is null");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        throw new IOException("Fail to get ParcelFileDescriptor", e);
    L13:
        throw new IOException("Fail to get ParcelFileDescriptor, uri is null");
    }

    public static void a(Uri r3) {
        ZeusProviderTransform.delete(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r3, null, null, "com.obric.memorydata.plugin");
    }

    public static void a(Uri r10, int r11) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(f15357a.get(r11), a.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L21;
        String r6 = r0.c + " = ?";
        String[] r7 = {r10.getLastPathSegment()};
        Cursor r12 = null;
        Uri r3 = r0.f15358a;     // Catch: Throwable -> L17
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Uri r4 = MediaStore.setIncludePending(r0.f15358a);     // Catch: Throwable -> L17
    L9:
        r12 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r4, null, r6, r7, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r12 == null) goto L16;
        if (r12.moveToFirst() == false) goto L16;
        g.a(new Cursor[]{r12});
        return;
    L16:
        throw new Throwable("Fail to check Uri with cursor.");     // Catch: Throwable -> L17
    L8:
        r4 = r3;
    L17:
        th = move-exception;
        g.a(new Cursor[]{r12});
        throw th;
    L21:
        throw new Throwable("Fail to check Uri, type error :" + r11);
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(com.ss.android.socialbase.downloader.d.a r4) {
        if (r4.b() == true) goto L5;
    L7:
        return false;
    L5:
        if (r4.a() <= 0) goto L7;
        return true;
    }

    public static boolean a(FileOutputStream r2) {
        r2.write(new byte[0]);     // Catch: Throwable -> L6
        r2.close();     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static boolean a(String r1) {
        if (c(r1) > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static long b(Uri r5) {
        ParcelFileDescriptor r2 = null;
        r2 = a(r5, "r");     // Catch: Throwable -> L6
        long r3 = r2.getStatSize();     // Catch: Throwable -> L6
        g.a(new Closeable[]{r2});
        return r3;
    L6:
        g.a(new Closeable[]{r2});
        return -1;
    }

    public static FileDescriptor b(Uri r0, String r1) {
        ParcelFileDescriptor r2 = a(r0, r1);
        if (r2 == null) goto L7;
        return r2.getFileDescriptor();
    L7:
        throw new IOException("Fail to get FileDescriptor, ParcelFileDescriptor is null");
    }

    public static String b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        if (r4.startsWith(Params.CONTENT) == false) goto L18;
        int r0 = 0;
    L8:
        if (r0 >= f15357a.size()) goto L19;
        int r1 = f15357a.keyAt(r0);
        a r2 = (a) ZeusTransformUtils.preCheckCast(f15357a.get(r1), a.class, "com.obric.memorydata.plugin");
        if (r4.startsWith(r2.f15359b) == true) goto L12;
        r0 = r0 + 1;
        goto L8
    L12:
        return r2.f15359b;
    L19:
        return null;
    L18:
        return null;
    }

    public static boolean b() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        int r1 = r0.getApplicationInfo().targetSdkVersion;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L12;
        com.ss.android.socialbase.downloader.e.a.a("DownloadFileUtils", "isScopedStorage", "SDK_INT:" + Build.VERSION.SDK_INT + " targetSdkVersion:" + r1);
    L12:
        if (Build.VERSION.SDK_INT >= 29) goto L18;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a("DownloadFileUtils", "isScopedStorage", "SDK_INT < Android Q");
    L16:
        return false;
    L18:
        if (r1 == 29) goto L20;
    L25:
        if (r1 <= 29) goto L31;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L29;
        com.ss.android.socialbase.downloader.e.a.a("DownloadFileUtils", "isScopedStorage", "SDK_INT > Android Q");
    L29:
        return true;
    L31:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L33;
        com.ss.android.socialbase.downloader.e.a.a("DownloadFileUtils", "isScopedStorage", "ScopedStorage = False");
    L33:
        return false;
    L20:
        if (com.ss.android.socialbase.downloader.utils.a.d(false) == true) goto L25;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L24;
        com.ss.android.socialbase.downloader.e.a.a("DownloadFileUtils", "isScopedStorage", "SDK_INT = Android Q and isExternalStorageLegacy");
    L24:
        return true;
    L5:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L7;
        com.ss.android.socialbase.downloader.e.a.a("DownloadFileUtils", "isScopedStorage", "Context is null");
    L7:
        return false;
    }

    public static int c(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return -1;
    L6:
        if (r6.startsWith(Params.CONTENT) == false) goto L15;
        int r0 = 0;
    L9:
        if (r0 >= f15357a.size()) goto L14;
        int r2 = f15357a.keyAt(r0);
        if (r6.startsWith(((a) ZeusTransformUtils.preCheckCast(f15357a.get(r2), a.class, "com.obric.memorydata.plugin")).f15359b) == true) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        return r2;
    L14:
        return -1;
    L15:
        return 1;
    }

    public static boolean c(Uri r4) {
        if (b(r4) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static Uri d(String r15) {
        Uri r1 = com.ss.android.socialbase.downloader.utils.a.d();
        Cursor r2 = null;
    L19:
        th = th;
    L20:
        g.a(new Cursor[]{r2});
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Cursor r16 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), MediaStore.setIncludePending(r1), new String[]{"_id"}, "_data=? ", new String[]{r15}, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
    L9:
        if (r16 != null) goto L24;
    L17:
        g.a(new Cursor[]{r16});
        return null;
    L24:
    L15:
        th = move-exception;
        r2 = r16;
        th = th;
        goto L20
    L11:
        if (r16.moveToFirst() == false) goto L17;
        Uri r0 = ContentUris.withAppendedId(r1, r16.getInt(r16.getColumnIndex("_id")));     // Catch: Throwable -> L15
        g.a(new Cursor[]{r16});
        return r0;
    L8:
        r16 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String d(Uri r12) {
        String[] r1 = {"_data"};
        String r9 = null;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r0 != null) goto L7;
        g.a(new Cursor[]{null});
        return null;
    L7:
        Cursor r13 = ZeusProviderTransform.query(r0.getContentResolver(), r12, r1, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r13 != null) goto L22;
    L15:
        g.a(new Cursor[]{r13});
        return r9;
    L22:
    L13:
        th = th;
        r9 = r13;
    L18:
        g.a(new Cursor[]{r9});
        throw th;
    L10:
        if (r13.moveToFirst() == false) goto L15;
        r9 = r13.getString(r13.getColumnIndex(r1[0]));     // Catch: Throwable -> L13
    L17:
        th = th;
        goto L18
    }

    public static boolean e(String r1) {
        a(Uri.parse(r1), c(r1));     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static boolean f(String r6) {
        if (a(r6) == false) goto L5;
        return true;
    L5:
        File r2 = com.ss.android.socialbase.downloader.utils.a.a(false);
        if (r2 != null) goto L8;
    L31:
        return false;
    L8:
        if (r6.startsWith(r2.getPath()) == false) goto L31;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L14;
        String r7 = "Context is null";
    L12:
        com.ss.android.socialbase.downloader.e.a.b("DownloadFileUtils", "isFilePathInExternalPublicDir", r7);
        return false;
    L14:
        File r5 = com.ss.android.socialbase.downloader.utils.a.a(r3, false);
        if (r5 != null) goto L17;
        r7 = "ExternalCacheDir is null";
        goto L12
    L17:
        String r4 = r5.getParent();
        if (r4 != null) goto L20;
    L22:
        File r8 = com.ss.android.socialbase.downloader.utils.a.b(r3, false);
        if (r8 == null) goto L28;
        if (r6.startsWith(r8.getAbsolutePath()) == false) goto L28;
        return false;
    L28:
        if (com.ss.android.socialbase.downloader.g.a.c().a("uncheck_external_public_dir", 0) <= 0) goto L30;
        return false;
    L30:
        return true;
    L20:
        if (r6.startsWith(r4) == false) goto L22;
        return false;
    }
}
