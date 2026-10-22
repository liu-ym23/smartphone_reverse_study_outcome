package kb;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.utils.g;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import qb.k;
import qb.l;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SparseArray<a> f10148a;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Uri f10149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10151c;

        a() {
        }

        static a a(Uri r10, String r11) {
            a r12 = new a();
            r12.f10149a = r10;
            r12.f10150b = r10.toString();
            r12.f10151c = r11;
            return r12;
        }
    }

    static {
        f10148a = new SparseArray();     // Catch: Throwable -> L9
        if (n() == false) goto L7;
        f10148a.put(2, a.a(MediaStore.Images.Media.getContentUri("external_primary"), "_id"));     // Catch: Throwable -> L9
        f10148a.put(3, a.a(MediaStore.Video.Media.getContentUri("external_primary"), "_id"));     // Catch: Throwable -> L9
        f10148a.put(4, a.a(MediaStore.Audio.Media.getContentUri("external_primary"), "_id"));     // Catch: Throwable -> L9
        f10148a.put(5, a.a(MediaStore.Downloads.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        f10148a.put(2, a.a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
        f10148a.put(3, a.a(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
        f10148a.put(4, a.a(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a(Uri r10, int r11) {
        a r12 = f10148a.get(r11);
        if (r12 == null) goto L20;
        String r13 = r12.f10151c + " = ?";
        String[] r14 = {r10.getLastPathSegment()};
        Cursor r15 = null;
        Uri r16 = r12.f10149a;     // Catch: Throwable -> L16
        if (Build.VERSION.SDK_INT < 29) goto L8;
        r16 = MediaStore.setIncludePending(r16);     // Catch: Throwable -> L16
    L8:
        r15 = ((l) k.a(l.class)).getAppContext().getContentResolver().query(r16, null, r13, r14, null);     // Catch: Throwable -> L16
        if (r15 == null) goto L15;
        if (r15.moveToFirst() == false) goto L15;
        g.a0(new Cursor[]{r15});
        return;
    L15:
        throw new Throwable("Fail to check Uri with cursor.");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        g.a0(new Cursor[]{r15});
        throw th;
    L20:
        throw new Throwable("Fail to check Uri, type error :" + r11);
    }

    public static boolean b(String r10) {
        a(Uri.parse(r10), l(r10));     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static void c(Uri r10) {
        ((l) k.a(l.class)).getAppContext().getContentResolver().delete(r10, null, null);
    }

    public static boolean d(FileOutputStream r10) {
        r10.write(new byte[0]);     // Catch: Throwable -> L6
        r10.close();     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static boolean e(Uri r10) {
        if (j(r10) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean f(kb.a r10) {
        if (r10.h() == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.length() <= 0) goto L7;
        return true;
    }

    public static String g(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        if (r10.startsWith("content") == false) goto L18;
        int r11 = 0;
    L8:
        if (r11 >= f10148a.size()) goto L19;
        int r12 = f10148a.keyAt(r11);
        a r13 = f10148a.get(r12);
        if (r10.startsWith(r13.f10150b) == true) goto L12;
        r11 = r11 + 1;
        goto L8
    L12:
        return r13.f10150b;
    L19:
        return null;
    L18:
        return null;
    }

    public static FileDescriptor h(Uri r10, String r11) {
        ParcelFileDescriptor r12 = k(r10, r11);
        if (r12 == null) goto L7;
        return r12.getFileDescriptor();
    L7:
        throw new IOException("Fail to get FileDescriptor, ParcelFileDescriptor is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String i(Uri r10) {
        String[] r11 = {"_data"};
        String r12 = null;
        Context r13 = ((l) k.a(l.class)).getAppContext();     // Catch: Throwable -> L17
        if (r13 != null) goto L7;
        g.a0(new Cursor[]{null});
        return null;
    L7:
        Cursor r14 = r13.getContentResolver().query(r10, r11, null, null, null);     // Catch: Throwable -> L17
        if (r14 != null) goto L22;
    L15:
        g.a0(new Cursor[]{r14});
        return r12;
    L22:
    L13:
        th = th;
        r12 = r14;
    L18:
        g.a0(new Cursor[]{r12});
        throw th;
    L10:
        if (r14.moveToFirst() == false) goto L15;
        r12 = r14.getString(r14.getColumnIndex(r11[0]));     // Catch: Throwable -> L13
    L17:
        th = th;
        goto L18
    }

    public static long j(Uri r10) {
        ParcelFileDescriptor r11 = null;
        r11 = k(r10, "r");     // Catch: Throwable -> L6
        long r12 = r11.getStatSize();     // Catch: Throwable -> L6
        g.b0(new Closeable[]{r11});
        return r12;
    L6:
        g.b0(new Closeable[]{r11});
        return -1;
    }

    public static ParcelFileDescriptor k(Uri r10, String r11) {
        if (r10 == null) goto L12;
        ParcelFileDescriptor r12 = ((l) k.a(l.class)).getAppContext().getContentResolver().openFileDescriptor(r10, r11);     // Catch: Exception -> L8
        if (r12 == null) goto L7;
        return r12;
    L7:
        throw new IOException("Fail to get ParcelFileDescriptor, fileDescriptor is null");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        throw new IOException("Fail to get ParcelFileDescriptor", e);
    L12:
        throw new IOException("Fail to get ParcelFileDescriptor, uri is null");
    }

    public static int l(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return -1;
    L6:
        if (r10.startsWith("content") == false) goto L15;
        int r11 = 0;
    L9:
        if (r11 >= f10148a.size()) goto L14;
        int r12 = f10148a.keyAt(r11);
        if (r10.startsWith(f10148a.get(r12).f10150b) == true) goto L12;
        r11 = r11 + 1;
        goto L9
    L12:
        return r12;
    L14:
        return -1;
    L15:
        return 1;
    }

    public static Uri m(String r13) {
        Uri r10 = com.ss.android.socialbase.downloader.utils.a.m();
        Cursor r11 = null;
    L19:
        th = th;
    L20:
        g.a0(new Cursor[]{r11});
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Cursor r14 = ((l) k.a(l.class)).getAppContext().getContentResolver().query(MediaStore.setIncludePending(r10), new String[]{"_id"}, "_data=? ", new String[]{r13}, null);     // Catch: Throwable -> L19
    L9:
        if (r14 != null) goto L22;
    L17:
        g.a0(new Cursor[]{r14});
        return null;
    L22:
    L15:
        th = move-exception;
        r11 = r14;
        th = th;
        goto L20
    L11:
        if (r14.moveToFirst() == false) goto L17;
        Uri r12 = ContentUris.withAppendedId(r10, r14.getInt(r14.getColumnIndex("_id")));     // Catch: Throwable -> L15
        g.a0(new Cursor[]{r14});
        return r12;
    L8:
        r14 = null;
        goto L9
    }

    public static boolean n() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean o(String r10) {
        if (p(r10) == false) goto L5;
        return true;
    L5:
        File r11 = com.ss.android.socialbase.downloader.utils.a.i(false);
        if (r11 != null) goto L8;
    L31:
        return false;
    L8:
        if (r10.startsWith(r11.getPath()) == false) goto L31;
        Context r12 = ((l) k.a(l.class)).getAppContext();
        if (r12 != null) goto L14;
        String r13 = "Context is null";
    L12:
        lb.a.c("DownloadFileUtils", "isFilePathInExternalPublicDir", r13);
        return false;
    L14:
        File r14 = com.ss.android.socialbase.downloader.utils.a.g(r12, false);
        if (r14 != null) goto L17;
        r13 = "ExternalCacheDir is null";
        goto L12
    L17:
        String r15 = r14.getParent();
        if (r15 != null) goto L20;
    L22:
        File r16 = com.ss.android.socialbase.downloader.utils.a.l(r12, false);
        if (r16 == null) goto L28;
        if (r10.startsWith(r16.getAbsolutePath()) == false) goto L28;
        return false;
    L28:
        if (rb.a.j().o("uncheck_external_public_dir", 0) <= 0) goto L30;
        return false;
    L30:
        return true;
    L20:
        if (r10.startsWith(r15) == false) goto L22;
        return false;
    }

    public static boolean p(String r10) {
        if (l(r10) > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean q() {
        Context r10 = ((l) k.a(l.class)).getAppContext();
        if (r10 == null) goto L5;
        int r11 = r10.getApplicationInfo().targetSdkVersion;
        if (lb.a.a() == false) goto L12;
        lb.a.b("DownloadFileUtils", "isScopedStorage", "SDK_INT:" + Build.VERSION.SDK_INT + " targetSdkVersion:" + r11);
    L12:
        if (Build.VERSION.SDK_INT >= 29) goto L18;
        if (lb.a.a() == false) goto L16;
        lb.a.b("DownloadFileUtils", "isScopedStorage", "SDK_INT < Android Q");
    L16:
        return false;
    L18:
        if (r11 == 29) goto L20;
    L25:
        if (r11 <= 29) goto L31;
        if (lb.a.a() == false) goto L29;
        lb.a.b("DownloadFileUtils", "isScopedStorage", "SDK_INT > Android Q");
    L29:
        return true;
    L31:
        if (lb.a.a() == false) goto L33;
        lb.a.b("DownloadFileUtils", "isScopedStorage", "ScopedStorage = False");
    L33:
        return false;
    L20:
        if (com.ss.android.socialbase.downloader.utils.a.o(false) == true) goto L25;
        if (lb.a.a() == false) goto L24;
        lb.a.b("DownloadFileUtils", "isScopedStorage", "SDK_INT = Android Q and isExternalStorageLegacy");
    L24:
        return true;
    L5:
        if (lb.a.a() == false) goto L7;
        lb.a.b("DownloadFileUtils", "isScopedStorage", "Context is null");
    L7:
        return false;
    }
}
