package com.larksuite.framework.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import f06.b;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class FileUtils {
    public static final String[] a = null;
    public static final String[] b = null;
    public static final Set<String> c = null;

    public static class MimeTypeCompat {
        public static final String[][] a = null;

        static {
            a = new String[][]{new String[]{"application/zip", "application/x-zip-compressed"}};
            new AnonymousClass1();
        }
    }

    static {
        a = new String[]{" Byte", " KB", " MB", " GB"};
        b = new String[]{"Byte", "KB", "MB", "GB"};
        c = new HashSet(Arrays.asList(new String[]{".tar.gz", ".tar.xz", ".tar.bz2"}));
    }

    public static boolean f(File r5) {
        if (r5.isDirectory() == false) goto L12;
        String[] r0 = r5.list();
        int r2 = 0;
    L6:
        if (r2 >= r0.length) goto L12;
        if (f(new PolarisFileWrapper(r5, r0[r2])) == false) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return false;
    L12:
        return r5.delete();
    }

    public static boolean g(String r1) {
        return new PolarisFileWrapper(r1).delete();
    L4:
        e = move-exception;
        Log.e("FileUtils", e.getMessage());
        return false;
    }

    public static String h(long r1) {
        return i(r1, a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] j(String r7) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r7);
        byte[] r2 = null;
        r2 = null;
        PolarisFileInputStreamWrapper r3 = null;
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r0);     // Catch: Throwable -> L10 IOException -> L12
        r2 = new byte[(int) r0.length()];     // Catch: Throwable -> L6 IOException -> L8
        r4.read(r2);     // Catch: Throwable -> L6 IOException -> L8
        r4.close();     // Catch: Throwable -> L6 IOException -> L8
        d.b(new Closeable[]{r4});
    L19:
        return r2;
    L8:
        e = e;
        byte[] r5 = r2;
        r3 = r4;
    L14:
        e.printStackTrace();     // Catch: Throwable -> L10
        d.b(new Closeable[]{r3});
        r2 = r5;
    L6:
        th = th;
        r2 = r4;
    L17:
        d.b(new Closeable[]{r2});
        throw th;
    L10:
        th = th;
    L12:
        e = e;
        r5 = null;
        goto L14
    }

    public static String k(String r2) {
        if (r2.lastIndexOf(".") > 0) goto L7;
        return "";
    L7:
        return r2.substring(r2.lastIndexOf(".") + 1, r2.length()).toLowerCase();
    }

    public static String l(String r1) {
        return new PolarisFileWrapper(r1).getName();
    }

    public static String m(String r1) {
        int r0 = o(r1);
        if (r0 > 0) goto L7;
        return "";
    L7:
        return r1.substring(r0);
    }

    public static String n(String r2) {
        int r0 = o(r2);
        if (r0 > 0) goto L5;
        return r2;
    L5:
        return r2.substring(0, r0);
    }

    public static int o(String r3) {
        int r1 = r3.lastIndexOf(".");
        if (r1 <= 0) goto L9;
        int r0 = r3.substring(0, r1).lastIndexOf(".");
        if (r0 <= 0) goto L9;
        String r4 = r3.substring(r0);
        if (((HashSet) c).contains(r4) == false) goto L9;
        return r0;
    L9:
        return r1;
    }

    public static String p(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return "*/*";
    L5:
        String r3 = k(r2);
        String r4 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r3);
        if (r4 != null) goto L9;
        r4 = "*/*";
    L9:
        if (TextUtils.isEmpty(r4) == false) goto L12;
        return "*/*";
    L12:
        return r4;
    }

    public static boolean r(String r2) {
        if (new PolarisFileWrapper(r2).exists() == true) goto L6;
        return false;
    L6:
        return true;
    L8:
        return false;
    }

    public static boolean s(String r3) {
        if (URLUtil.isNetworkUrl(r3) == false) goto L6;
        return false;
    L6:
        if (r3 != null) goto L9;
        return true;
    L9:
        if (r3.startsWith(File.separator) == false) goto L15;
        return true;
    L15:
        return "file".equals(new URL(r3).getProtocol());
    L13:
        Log.w("FileUtils", "donot know url is local or not, path: ".concat(r3));
        return false;
    }

    public static void t(String r1) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r1);
        if (r0.exists() == true) goto L6;
        r0.mkdirs();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(File r11, VFSFile r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.exists() == false) goto L46;
        if (r12 != null) goto L8;
        return;
    L8:
        PolarisFileInputStreamWrapper r0 = null;
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r11);     // Catch: Throwable -> L26 Exception -> L28
    L23:
        e = move-exception;
        Exception e = e;
        PolarisFileOutputStreamWrapper r13 = null;
    L25:
        r0 = r4;
    L37:
        e.printStackTrace();     // Catch: Throwable -> L33
        d.b(new Closeable[]{r0, r13});
        return;
    L33:
        Throwable th = th;
    L34:
        d.b(new Closeable[]{r0, r13});
        throw th;
    L20:
        th = move-exception;
        th = th;
        r13 = null;
    L22:
        r0 = r4;
        goto L34
    L11:
        if (r12.exists() == true) goto L13;
        r12.createNewFile();     // Catch: Throwable -> L20 Exception -> L23
    L13:
        r13 = new PolarisFileOutputStreamWrapper(r12);     // Catch: Throwable -> L20 Exception -> L23
    L43:
        FileChannel r5 = r4.getChannel();     // Catch: Throwable -> L16 Exception -> L18
        r5.transferTo(0, r5.size(), r13.getChannel());     // Catch: Throwable -> L16 Exception -> L18
        d.b(new Closeable[]{r4, r13});
        return;
    L18:
        e = e;
    L16:
        th = th;
        goto L22
    L28:
        e = move-exception;
        e = e;
        r13 = null;
    L26:
        th = move-exception;
        th = th;
        r13 = null;
        goto L34
    }

    public static void d(InputStream r4, OutputStream r5) {
        byte[] r0 = new byte[1024];     // Catch: Throwable -> L9 IOException -> L11
    L4:
        int r3 = r4.read(r0);     // Catch: Throwable -> L9 IOException -> L11
        if (r3 <= 0) goto L8;
        r5.write(r0, 0, r3);     // Catch: Throwable -> L9 IOException -> L11
    L8:
        d.b(new Closeable[]{r4});
        d.b(new Closeable[]{r5});
        return;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        d.b(new Closeable[]{r4});
        d.b(new Closeable[]{r5});
        return;
    L9:
        th = move-exception;
        d.b(new Closeable[]{r4});
        d.b(new Closeable[]{r5});
        throw th;
    }

    public static void e(String r12, String r13) {
        new PolarisFileWrapper(r13).mkdirs();     // Catch: Exception -> L25
        String[] r1 = new PolarisFileWrapper(r12).list();     // Catch: Exception -> L25
        int r3 = 0;
    L4:
        if (r3 >= r1.length) goto L34;
        String r4 = File.separator;     // Catch: Exception -> L25
        if (r12.endsWith(r4) == false) goto L9;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r12 + r1[r3]);     // Catch: Exception -> L25
    L12:
        if (r5.isFile() == false) goto L22;
        PolarisFileWrapper r6 = new PolarisFileWrapper(r13 + "/" + r5.getName());     // Catch: Exception -> L25
        if (r6.exists() == true) goto L22;
        PolarisFileInputStreamWrapper r7 = new PolarisFileInputStreamWrapper(r5);     // Catch: Exception -> L25
        PolarisFileOutputStreamWrapper r8 = new PolarisFileOutputStreamWrapper(r13 + "/" + r5.getName());     // Catch: Exception -> L25
        byte[] r9 = new byte[65536];     // Catch: Exception -> L25
    L17:
        int r10 = r7.read(r9);     // Catch: Exception -> L25
        if (r10 == (-1)) goto L20;
        r8.write(r9, 0, r10);     // Catch: Exception -> L25
        goto L17
    L20:
        r8.flush();     // Catch: Exception -> L25
        r8.close();     // Catch: Exception -> L25
        r7.close();     // Catch: Exception -> L25
        Log.i("FileUtils", "destinationFile exists, overwriteExistFile: false, destinationFile: " + r6.getAbsolutePath());     // Catch: Exception -> L25
    L22:
        if (r5.isDirectory() == false) goto L24;
        e(r12 + "/" + r1[r3], r13 + "/" + r1[r3]);     // Catch: Exception -> L25
    L24:
        r3 = r3 + 1;
        goto L4
    L9:
        r5 = new PolarisFileWrapper(r12 + r4 + r1[r3]);     // Catch: Exception -> L25
        goto L12
    L34:
        return;
    L25:
        e = move-exception;
        Log.e("FileUtils", "copy folder error:", e);
    }

    public static String i(long r9, String[] r11) {
        if (r9 >= 0) goto L6;
        r9 = 0;
    L6:
        if (r9 < 1024) goto L8;
        long r10 = r9 / 1024;
        if (r10 >= 1024) goto L14;
        return String.valueOf(r10) + r11[1];
    L14:
        if (r10 >= 1048576) goto L18;
        return String.format("%.2f%s", new Object[]{Double.valueOf(r10 / 1024.0d), r11[2]});
    L18:
        return String.format("%.2f%s", new Object[]{Double.valueOf((((r10 * 100) / 1024) / 1024) / 100.0d), r11[3]});
    L8:
        return String.valueOf(r9) + r11[0];
    }

    public static String q(Context r1, Uri r2) {
        PolarisFileWrapper r3 = m0.b(r1, r2, false);
        if (r3 != null) goto L5;
        return null;
    L5:
        return r3.getAbsolutePath();
    }

    public static void u(Context r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        r2.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new PolarisFileWrapper(r3))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.Bitmap] */
    public static String w(Bitmap r4, String r5) {
        ?? r0 = 0;
        if (r4 != 0) goto L5;
        return null;
    L5:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r5);
        PolarisFileOutputStreamWrapper r6 = new PolarisFileOutputStreamWrapper(r1);     // Catch: Throwable -> L22 Exception -> L24
    L20:
        e = e;
    L26:
        e.printStackTrace();     // Catch: Throwable -> L33
        if (r6 != null) goto L41;
    L32:
        return null;
    L41:
        r6.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L8:
        if (r4.compress(Bitmap.CompressFormat.JPEG, 100, r6) == false) goto L45;
        r6.flush();     // Catch: Exception -> L20 Throwable -> L33
        String r7 = r1.getAbsolutePath();     // Catch: Exception -> L20 Throwable -> L33
        r6.close();     // Catch: Exception -> L12
    L14:
        return r7;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L45:
        r6.close();     // Catch: Exception -> L17
    L19:
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L33:
        th = th;
        r0 = r5;
    L35:
        if (r0 != 0) goto L43;
    L40:
        throw th;
    L43:
        r0.close();     // Catch: Exception -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = e;
        r6 = null;
    L22:
        th = th;
        goto L35
    }

    public static void x(ZipInputStream r8, String r9) throws Exception {
    L2:
        ZipEntry r0 = r8.getNextEntry();
        if (r0 == null) goto L34;
        String r1 = r0.getName();
        if (r1.contains("../") == true) goto L2;
        if (r0.isDirectory() == true) goto L9;
        StringBuilder r2 = new StringBuilder();
        r2.append(r9);
        String r4 = File.separator;
        r2.append(r4);
        r2.append(r1);
        Log.d("FileUtils", r2.toString());
        PolarisFileWrapper r3 = new PolarisFileWrapper(r9 + r4 + r1);
        if (r3.exists() == true) goto L13;
        Log.d("FileUtils", "Create the file:" + r9 + r4 + r1);
        r3.getParentFile().mkdirs();
        r3.createNewFile();
    L13:
        BufferedOutputStream r5 = null;
        BufferedOutputStream r6 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r3));     // Catch: Throwable -> L26 IOException -> L28
    L37:
        byte[] r7 = new byte[1024];     // Catch: Throwable -> L22 IOException -> L24
    L17:
        int r10 = r8.read(r7);     // Catch: Throwable -> L22 IOException -> L24
        if (r10 == (-1)) goto L20;
        r6.write(r7, 0, r10);     // Catch: Throwable -> L22 IOException -> L24
        r6.flush();     // Catch: Throwable -> L22 IOException -> L24
        goto L17
    L20:
        r6.close();     // Catch: Throwable -> L22 IOException -> L24
        d.b(new Closeable[]{r6});
    L24:
        e = e;
        r5 = r6;
    L29:
        Log.i("FileUtils", e.getMessage());     // Catch: Throwable -> L26
        d.b(new Closeable[]{r5});
    L22:
        th = th;
    L32:
        d.b(new Closeable[]{r6});
        throw th;
    L28:
        e = e;
    L26:
        th = th;
        r6 = null;
        goto L32
    L9:
        new PolarisFileWrapper(r9 + File.separator + r1.substring(0, r1.length() - 1)).mkdirs();
        goto L2
    }

    public static Cursor a(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null, null};
        b r10 = new b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Context r7, String r8, String r9) {
        String[] r1 = r7.getAssets().list(r8);     // Catch: Exception -> L39
        int r3 = 0;
        if (r1.length <= 0) goto L9;
        new PolarisFileWrapper(r9).mkdirs();     // Catch: Exception -> L39
        int r2 = r1.length;     // Catch: Exception -> L39
    L6:
        if (r3 >= r2) goto L55;
        String r4 = r1[r3];     // Catch: Exception -> L39
        b(r7, r8 + "/" + r4, r9 + "/" + r4);     // Catch: Exception -> L39
        r3 = r3 + 1;
        goto L6
    L55:
        return;
    L9:
        InputStream r0 = null;
        InputStream r10 = r7.getAssets().open(r8);     // Catch: Throwable -> L30 IOException -> L32
    L47:
        PolarisFileOutputStreamWrapper r11 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r9));     // Catch: Throwable -> L24 IOException -> L27
    L49:
        byte[] r12 = new byte[1024];     // Catch: Throwable -> L20 IOException -> L22
    L14:
        int r5 = r10.read(r12);     // Catch: Throwable -> L20 IOException -> L22
        if (r5 == (-1)) goto L17;
        r11.write(r12, 0, r5);     // Catch: Throwable -> L20 IOException -> L22
        goto L14
    L17:
        r11.flush();     // Catch: Throwable -> L20 IOException -> L22
        d.b(new Closeable[]{r10});     // Catch: Exception -> L39
        d.b(new Closeable[]{r11});     // Catch: Exception -> L39
        return;
    L22:
        e = e;
    L29:
        r0 = r10;
    L43:
        e.printStackTrace();     // Catch: Throwable -> L36
        d.b(new Closeable[]{r0});     // Catch: Exception -> L39
        d.b(new Closeable[]{r11});     // Catch: Exception -> L39
        return;
    L36:
        th = th;
    L37:
        d.b(new Closeable[]{r0});     // Catch: Exception -> L39
        d.b(new Closeable[]{r11});     // Catch: Exception -> L39
        throw th;     // Catch: Exception -> L39
    L20:
        th = th;
    L26:
        r0 = r10;
    L27:
        e = e;
        r11 = null;
    L24:
        th = th;
        r11 = null;
    L32:
        e = e;
        r11 = null;
    L30:
        th = th;
        r11 = null;
    L39:
        e = move-exception;
        e.printStackTrace();
    }

    public static void v(Context r2, String r3, Token r4) {
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return;
    L13:
        uf7.a.a(r4);     // Catch: Exception -> L7
        r2.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new PolarisFileWrapper(r3))));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        if ((e instanceof SensitiveAPIException) == false) goto L12;
        Log.e("FileUtils", "notifySystemScanFile failed", e);
        return;
    L12:
        throw e;
    }
}
