package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.apm6.util.IOUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4304a = "b";

    static {
    }

    private static void a(File r10, ZipOutputStream r11, String r12) {
        if (r10.isDirectory() == false) goto L6;
        c(r10, r11, r12 + r10.getName() + File.separator);
        return;
    L6:
        if (com.bytedance.apm.d.D() == false) goto L8;
        e0.e.b("cloudmessage", new String[]{"压缩：" + r12 + r10.getName()});
    L8:
        d(r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static void b(String r10, String... r11) {
        ?? r12 = new File(r10);
        FileOutputStream r13 = new FileOutputStream(r12);     // Catch: Throwable -> L25 Exception -> L28
        CheckedOutputStream r14 = new CheckedOutputStream(r13, new CRC32());     // Catch: Throwable -> L21 Exception -> L23
    L42:
        ZipOutputStream r15 = new ZipOutputStream(r14);     // Catch: Throwable -> L17 Exception -> L19
        int r16 = r11.length;     // Catch: Exception -> L15 Throwable -> L33
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L13;
        String r18 = r11[r17];     // Catch: Exception -> L15 Throwable -> L33
        File r19 = new File(r18);     // Catch: Exception -> L15 Throwable -> L33
        if (r19.exists() == false) goto L12;
        a(r19, r15, "");     // Catch: Exception -> L15 Throwable -> L33
        r17 = r17 + 1;     // Catch: Exception -> L15 Throwable -> L33
        goto L7
    L12:
        throw new RuntimeException(r18 + "不存在！");     // Catch: Exception -> L15 Throwable -> L33
    L13:
        IOUtils.closeQuietly(r15);
        IOUtils.closeQuietly(r14);
        IOUtils.closeQuietly(r13);
        return;
    L15:
        Exception e10 = e;
    L32:
        throw new RuntimeException(e10);     // Catch: Throwable -> L33
    L19:
        e = e;
    L30:
        e10 = e;
    L17:
        th = th;
        Closeable r20 = null;
        r12 = r14;
    L27:
        th = th;
    L34:
        IOUtils.closeQuietly(r20);
        IOUtils.closeQuietly(r12);
        IOUtils.closeQuietly(r13);
        throw th;
    L23:
        e = e;
    L21:
        th = th;
        r12 = 0;
        r20 = null;
        goto L27
    L33:
        th = th;
    L28:
        e = e;
    L25:
        th = th;
        r12 = 0;
        r13 = null;
        r20 = null;
        goto L27
    }

    private static void c(File r10, ZipOutputStream r11, String r12) {
        if (r10.exists() == true) goto L5;
        return;
    L5:
        File[] r13 = r10.listFiles();
        int r14 = 0;
    L7:
        if (r14 >= r13.length) goto L9;
        a(r13[r14], r11, r12);
        r14 = r14 + 1;
        goto L7
    }

    private static void d(File r10, ZipOutputStream r11, String r12) {
        if (r10.exists() == true) goto L5;
        return;
    L5:
        InputStream r13 = null;
        InputStream r14 = new FileInputStream(r10);     // Catch: Throwable -> L24 Exception -> L26
        BufferedInputStream r15 = new BufferedInputStream(r14);     // Catch: Throwable -> L19 Exception -> L21
        r11.putNextEntry(new ZipEntry(r12 + r10.getName()));     // Catch: Throwable -> L15 Exception -> L17
        byte[] r16 = new byte[8192];     // Catch: Throwable -> L15 Exception -> L17
    L9:
        int r17 = r15.read(r16, 0, 8192);     // Catch: Throwable -> L15 Exception -> L17
        if (r17 == (-1)) goto L13;
        r11.write(r16, 0, r17);     // Catch: Throwable -> L15 Exception -> L17
    L13:
        IOUtils.closeQuietly(r15);
        IOUtils.closeQuietly(r14);
        return;
    L17:
        e = e;
    L23:
        r13 = r14;
    L35:
    L30:
        th = th;
        r14 = r13;
    L32:
        r13 = r15;
    L33:
        IOUtils.closeQuietly(r13);
        IOUtils.closeQuietly(r14);
        throw th;
    L29:
        throw new RuntimeException(e);     // Catch: Throwable -> L30
    L15:
        th = th;
        goto L32
    L21:
        e = e;
        r15 = null;
    L19:
        th = th;
        goto L33
    L26:
        e = e;
        r15 = null;
    L24:
        th = th;
        r14 = null;
        goto L33
    }

    public static boolean e(String r10, String r11, String r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L28:
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L28;
        if (TextUtils.isEmpty(r12) == true) goto L28;
        FileInputStream r13 = null;
        FileInputStream r14 = new FileInputStream(r10);     // Catch: Throwable -> L18 Exception -> L20
        boolean r15 = l(r14, r11, r12);     // Catch: Throwable -> L14 Exception -> L16
        r14.close();     // Catch: Exception -> L29
    L13:
        return r15;
    L16:
        e = e;
        r13 = r14;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r13 != null) goto L37;
    L24:
        return false;
    L37:
        r13.close();     // Catch: Exception -> L31
    L14:
        th = th;
        r13 = r14;
    L25:
        if (r13 != null) goto L34;
    L27:
        throw th;
    L34:
        r13.close();     // Catch: Exception -> L30
    L20:
        e = e;
    L18:
        th = th;
        goto L25
    }

    public static void f(@NonNull File r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.exists() == true) goto L7;
        return;
    L7:
        if (r10.isDirectory() == false) goto L17;
        File[] r11 = r10.listFiles();
        int r12 = r11.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L17;
        File r14 = r11[r13];
        if (r14.isFile() == false) goto L14;
        r14.delete();
    L16:
        r13 = r13 + 1;
        goto L9
    L14:
        if (r10.isDirectory() == false) goto L16;
        f(r14);
    L17:
        r10.delete();
    }

    public static void g(File r10) {
        if (r10.exists() == false) goto L5;
        k(r10.getAbsolutePath());
    L5:
        r10.mkdirs();
    }

    public static File h(Context r10) {
        File r11 = r10.getExternalFilesDir("cloudMessage");
        if (r11 != null) goto L6;
        r11 = new File(r10.getFilesDir(), "cloudMessage");
    L6:
        if (r11.exists() == true) goto L8;
        r11.mkdir();
    L8:
        return r11;
    }

    public static String i(String r10, String r11) {
        Context r12 = k6.a.k().i();
        r10.hashCode();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1481211727: goto L26;
            case -1427366653: goto L22;
            case -1301710629: goto L18;
            case -540898700: goto L14;
            case 70125656: goto L10;
            case 1506669642: goto L6;
            default: goto L30;
        };
    L6:
        if (r10.equals("data_package_file") == false) goto L30;
        r13 = 5;
        goto L30
    L10:
        if (r10.equals("sd_package") == false) goto L30;
        r13 = 4;
        goto L30
    L14:
        if (r10.equals("data_package_cache") == false) goto L30;
        r13 = 3;
        goto L30
    L18:
        if (r10.equals("sd_package_cache") == false) goto L30;
        r13 = 2;
        goto L30
    L22:
        if (r10.equals("sd_package_file") == false) goto L30;
        r13 = 1;
        goto L30
    L26:
        if (r10.equals("data_package") == false) goto L30;
        r13 = 0;
    L30:
        switch(r13) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            default: goto L31;
        };
    L31:
        return null;
    L33:
        return new File(r12.getFilesDir(), r11).getAbsolutePath();
    L35:
        return new File(r12.getExternalFilesDir(null).getParentFile(), r11).getAbsolutePath();
    L37:
        return new File(r12.getCacheDir(), r11).getAbsolutePath();
    L39:
        return new File(r12.getExternalCacheDir(), r11).getAbsolutePath();
    L41:
        return new File(r12.getExternalFilesDir(null), r11).getAbsolutePath();
    L43:
        return new File(r12.getFilesDir().getParentFile(), r11).getAbsolutePath();
    }

    public static File j(String r10, String r11) {
        Context r12 = k6.a.k().i();
        r10.hashCode();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1481211727: goto L26;
            case -1427366653: goto L22;
            case -1301710629: goto L18;
            case -540898700: goto L14;
            case 70125656: goto L10;
            case 1506669642: goto L6;
            default: goto L30;
        };
    L6:
        if (r10.equals("data_package_file") == false) goto L30;
        r13 = 5;
        goto L30
    L10:
        if (r10.equals("sd_package") == false) goto L30;
        r13 = 4;
        goto L30
    L14:
        if (r10.equals("data_package_cache") == false) goto L30;
        r13 = 3;
        goto L30
    L18:
        if (r10.equals("sd_package_cache") == false) goto L30;
        r13 = 2;
        goto L30
    L22:
        if (r10.equals("sd_package_file") == false) goto L30;
        r13 = 1;
        goto L30
    L26:
        if (r10.equals("data_package") == false) goto L30;
        r13 = 0;
    L30:
        switch(r13) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            default: goto L31;
        };
    L31:
        return null;
    L33:
        return new File(r12.getFilesDir(), r11);
    L35:
        return new File(r12.getExternalFilesDir(null).getParentFile(), r11);
    L37:
        return new File(r12.getCacheDir(), r11);
    L39:
        return new File(r12.getExternalCacheDir(), r11);
    L41:
        return new File(r12.getExternalFilesDir(null), r11);
    L43:
        return new File(r12.getFilesDir().getParentFile(), r11);
    }

    public static boolean k(String r10) {
        File r11 = new File(r10);
        if (r11.exists() == true) goto L5;
        return true;
    L5:
        if (r11.isDirectory() == false) goto L30;
        File[] r12 = r11.listFiles();
        int r13 = r12.length;
        boolean r14 = true;
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L20;
        if (r12[r15].isDirectory() == false) goto L15;
        if (r14 == true) goto L12;
    L14:
        r14 = false;
    L19:
        r15 = r15 + 1;
        goto L7
    L12:
        if (k(r12[r15].getAbsolutePath()) == false) goto L14;
    L13:
        r14 = true;
        goto L19
    L15:
        if (r14 == false) goto L14;
        if (r12[r15].delete() == false) goto L14;
    L20:
        if (r14 == false) goto L25;
        if (r11.delete() == false) goto L25;
        return true;
    L25:
        return false;
    L30:
        return true;
    }

    public static boolean l(InputStream r10, String r11, String r12) {
        if (r10 != null) goto L5;
        return false;
    L5:
        FileOutputStream r13 = null;
        File r14 = new File(r11);     // Catch: Throwable -> L27 Exception -> L29
        if (r14.exists() == false) goto L9;
    L12:
        FileOutputStream r15 = new FileOutputStream(new File(r14, r12));     // Catch: Throwable -> L27 Exception -> L29
        byte[] r16 = new byte[1024];     // Catch: Throwable -> L23 Exception -> L25
    L15:
        int r17 = r10.read(r16);     // Catch: Throwable -> L23 Exception -> L25
        if (r17 == (-1)) goto L18;
        r15.write(r16, 0, r17);     // Catch: Throwable -> L23 Exception -> L25
        goto L15
    L18:
        r15.flush();     // Catch: Throwable -> L23 Exception -> L25
        r15.close();     // Catch: Throwable -> L23 Exception -> L25
        r10.close();     // Catch: Throwable -> L27 Exception -> L29
        r10.close();     // Catch: Exception -> L40
        return true;
    L64:
        return true;
    L25:
        e = e;
        r13 = r15;
    L30:
        Log.d(f4304a, "save inputstream error: " + e);     // Catch: Throwable -> L27
        if (r13 != null) goto L56;
    L54:
        r10.close();     // Catch: Exception -> L44
    L34:
        return false;
    L56:
        r13.close();     // Catch: Exception -> L43
    L23:
        th = th;
        r13 = r15;
    L35:
        if (r13 == null) goto L58;
        r13.close();     // Catch: Exception -> L41
    L58:
        r10.close();     // Catch: Exception -> L42
        throw th;
    L63:
        throw th;
    L9:
        if (r14.mkdirs() == true) goto L12;
        r10.close();     // Catch: Exception -> L39
    L11:
        return false;
    L29:
        e = e;
    L27:
        th = th;
        goto L35
    }

    private static void m(String r10, File r11) {
        ZipOutputStream r12 = null;
        ZipOutputStream r13 = new ZipOutputStream(new FileOutputStream(r10));     // Catch: Throwable -> L9
        o(r13, r11, "");     // Catch: Throwable -> L7
        IOUtils.closeQuietly(r13);
        return;
    L7:
        th = th;
        r12 = r13;
    L10:
        IOUtils.closeQuietly(r12);
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static void n(String r10, String r11) {
        m(r11, new File(r10));
    }

    private static void o(ZipOutputStream r10, File r11, String r12) {
        if (r11.isDirectory() == false) goto L12;
        File[] r13 = r11.listFiles();
        r10.putNextEntry(new ZipEntry(r12 + "/"));
        if (r12.length() != 0) goto L7;
        String r14 = "";
    L8:
        int r15 = 0;
    L10:
        if (r15 >= r13.length) goto L32;
        o(r10, r13[r15], r14 + r13[r15].getName());
        r15 = r15 + 1;
        goto L10
    L32:
        return;
    L7:
        r14 = r12 + "/";
        goto L8
    L12:
        r10.putNextEntry(new ZipEntry(r12));
        FileInputStream r16 = null;
        FileInputStream r17 = new FileInputStream(r11);     // Catch: Throwable -> L22
    L25:
        int r18 = r17.read();     // Catch: Throwable -> L20
        if (r18 == (-1)) goto L18;
        r10.write(r18);     // Catch: Throwable -> L20
        goto L25
    L18:
        IOUtils.closeQuietly(r17);
        return;
    L20:
        th = th;
        r16 = r17;
    L23:
        IOUtils.closeQuietly(r16);
        throw th;
    L22:
        th = th;
        goto L23
    }
}
