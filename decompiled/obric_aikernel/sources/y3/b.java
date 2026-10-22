package y3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import x3.d;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<String> f13675a;

    static {
        f13675a = new ArrayList();
    }

    private static File a(Context r10, String r11) {
        String r12 = System.mapLibraryName(r11);
        File r13 = b(r10);
        if (r13 != null) goto L5;
        return null;
    L5:
        return new File(r13, r12);
    }

    private static File b(Context r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.getFilesDir() == null) goto L12;
        File r11 = new File(r10.getFilesDir(), "libso");
        if (r11.exists() == true) goto L9;
        d.a(r11.getAbsolutePath());
    L9:
        return r11;
    L12:
        return null;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static synchronized boolean c(Context r10, String r11) {
        monitor-enter(b.class);
    L32:
        th = move-exception;
        throw th;
    L6:
        if (f13675a.contains(r11) == false) goto L38;
        monitor-exit(b.class);
        return true;
    L38:
        System.loadLibrary(r11);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
        f13675a.add(r11);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
    L28:
        monitor-exit(b.class);
        return true;
    L14:
        e = move-exception;
        File r12 = a(r10, r11);     // Catch: Throwable -> L32
        if (r12 != null) goto L20;
        return false;
    L20:
        if (r12.exists() == false) goto L22;
        r12.delete();     // Catch: Throwable -> L32
    L22:
        String r13 = d(r10, r11, r12);     // Catch: Throwable -> L32
        if (r13 == null) goto L35;
        Log.e("loadLibrary", e.getMessage() + "[" + r13 + "]");     // Catch: Throwable -> L32
        return false;
    L35:
        System.load(r12.getAbsolutePath());     // Catch: Throwable -> L30
        f13675a.add(r11);     // Catch: Throwable -> L30
    L31:
        return false;
    L13:
        return false;
    }

    public static String d(Context r10, String r11, File r12) {
        FileOutputStream r13 = null;
        ZipFile r14 = new ZipFile(new File(r10.getApplicationInfo().sourceDir), 1);     // Catch: Throwable -> L33
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L31
        r15.append("lib/");     // Catch: Throwable -> L31
        String r16 = Build.CPU_ABI;     // Catch: Throwable -> L31
        r15.append(r16);     // Catch: Throwable -> L31
        r15.append("/");     // Catch: Throwable -> L31
        r15.append(System.mapLibraryName(r11));     // Catch: Throwable -> L31
        ZipEntry r17 = r14.getEntry(r15.toString());     // Catch: Throwable -> L31
        if (r17 != null) goto L17;
        int r18 = r16.indexOf(45);     // Catch: Throwable -> L31
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L31
        r19.append("lib/");     // Catch: Throwable -> L31
        if (r18 > 0) goto L10;
        r18 = r16.length();     // Catch: Throwable -> L31
    L10:
        r19.append(r16.substring(0, r18));     // Catch: Throwable -> L31
        r19.append("/");     // Catch: Throwable -> L31
        r19.append(System.mapLibraryName(r11));     // Catch: Throwable -> L31
        String r20 = r19.toString();     // Catch: Throwable -> L31
        ZipEntry r21 = r14.getEntry(r20);     // Catch: Throwable -> L31
        if (r21 != null) goto L16;
        String r22 = "Library entry not found:" + r20;     // Catch: Throwable -> L31
        d.b(null);
        d.b(null);
    L14:
        d.c(r14);
        return r22;
    L16:
        r17 = r21;
    L17:
        r12.createNewFile();     // Catch: Throwable -> L31
        InputStream r23 = r14.getInputStream(r17);     // Catch: Throwable -> L31
        FileOutputStream r24 = new FileOutputStream(r12);     // Catch: Throwable -> L29
        byte[] r25 = new byte[4096];     // Catch: Throwable -> L27
    L21:
        int r26 = r23.read(r25);     // Catch: Throwable -> L27
        if (r26 <= 0) goto L24;
        r24.write(r25, 0, r26);     // Catch: Throwable -> L27
        goto L21
    L24:
        d.d(r12.getAbsolutePath(), 493);     // Catch: Throwable -> L27
        d.b(r24);
        d.b(r23);
        d.c(r14);
        return null;
    L27:
        th = move-exception;
        r13 = r24;
        InputStream r27 = r23;
        th = th;
    L45:
        r22 = th.getMessage();     // Catch: Throwable -> L37
        d.b(r13);
        d.b(r27);
    L37:
        th = move-exception;
        d.b(r13);
        d.b(r27);
        d.c(r14);
        throw th;
    L29:
        th = move-exception;
        r27 = r23;
        th = th;
    L31:
        th = th;
        r27 = null;
    L33:
        th = th;
        r27 = null;
        r14 = null;
        goto L45
    }
}
