package bea;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static String b(String r4, Set<String> r5) {
        if (r4 != null) goto L4;
    L5:
        r4 = "logs";
    L6:
        String r1 = r4.concat(".zip");
        HashSet r6 = (HashSet) r5;
        if (r6.add(r1) == false) goto L9;
        return r1;
    L9:
        int r2 = 2;
    L10:
        String r3 = r4 + "_" + r2 + ".zip";
        if (r6.add(r3) == true) goto L12;
        r2 = r2 + 1;
        goto L10
    L12:
        return r3;
    L4:
        if (r4.isEmpty() == false) goto L6;
        goto L5
    }

    public static String e(Context r17, String[] r18) throws IOException {
        String[] r1 = r18;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r17.getFilesDir(), "O_App_alogs.zip");
        if (r5.exists() == false) goto L92;
        r5.delete();
    L92:
        PolarisFileOutputStreamWrapper r6 = new PolarisFileOutputStreamWrapper(r5);     // Catch: IOException -> L85
        ZipOutputStream r7 = new ZipOutputStream(r6);     // Catch: Throwable -> L77
        HashSet r8 = new HashSet();     // Catch: Throwable -> L69
        int r9 = r1.length;     // Catch: Throwable -> L69
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L65;
        String r0 = r1[r11];     // Catch: Throwable -> L69
        PolarisFileWrapper r12 = new PolarisFileWrapper(r0);     // Catch: Throwable -> L69
        if (r12.exists() == true) goto L13;
        FLogger.a.w("LogFC-O-Auto", "Source directory {0} does not exist: " + r0);     // Catch: Throwable -> L69
    L28:
        HashSet r16 = r8;
    L51:
        r11 = r11 + 1;
        r1 = r18;
        r8 = r16;
        goto L8
    L13:
        File r13 = null;
        String r2 = b(r12.getName(), r8);     // Catch: Throwable -> L35 IOException -> L37
        r13 = c(r17, r12, r5);     // Catch: IOException -> L33 Throwable -> L35
        r7.putNextEntry(new ZipEntry(r2));     // Catch: IOException -> L33 Throwable -> L35
        boolean r15 = true;
        f(r13, r7);     // Catch: Throwable -> L29 IOException -> L31
        r7.closeEntry();     // Catch: IOException -> L21 Throwable -> L69
    L24:
        if (r13 == null) goto L28;
        if (r13.exists() == false) goto L28;
        r13.delete();     // Catch: Throwable -> L69
        goto L28
    L21:
        e = move-exception;
        FLogger.a.e("LogFC-O-Auto", "Error closing zip entry for directory " + r12.getAbsolutePath() + " : " + e.getMessage());     // Catch: Throwable -> L69
        goto L24
    L31:
        e = e;
    L108:
        FLogger r10 = FLogger.a;     // Catch: Throwable -> L52
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L52
        r16 = r8;
        r3.append("Error compressing directory ");     // Catch: Throwable -> L52
        r3.append(r12.getAbsolutePath());     // Catch: Throwable -> L52
        r3.append(" : ");     // Catch: Throwable -> L52
        r3.append(e.getMessage());     // Catch: Throwable -> L52
        r10.e("LogFC-O-Auto", r3.toString());     // Catch: Throwable -> L52
        if (r15 == true) goto L104;
    L47:
        if (r13 == null) goto L51;
        if (r13.exists() == false) goto L51;
        r13.delete();     // Catch: Throwable -> L69
        goto L51
    L104:
        r7.closeEntry();     // Catch: IOException -> L44 Throwable -> L69
    L44:
        e = move-exception;
        FLogger.a.e("LogFC-O-Auto", "Error closing zip entry for directory " + r12.getAbsolutePath() + " : " + e.getMessage());     // Catch: Throwable -> L69
    L52:
        th = move-exception;
        Throwable r4 = th;
        boolean r14 = r15;
    L54:
        if (r14 == true) goto L106;
    L60:
        if (r13 != null) goto L62;
        throw r4;     // Catch: Throwable -> L69
    L62:
        if (r13.exists() == false) goto L120;
        r13.delete();     // Catch: Throwable -> L69
        throw r4;     // Catch: Throwable -> L69
    L120:
        throw r4;     // Catch: Throwable -> L69
    L106:
        r7.closeEntry();     // Catch: IOException -> L57 Throwable -> L69
    L57:
        e = move-exception;
        FLogger.a.e("LogFC-O-Auto", "Error closing zip entry for directory " + r12.getAbsolutePath() + " : " + e.getMessage());     // Catch: Throwable -> L69
    L29:
        th = move-exception;
        r4 = th;
        r14 = true;
        goto L54
    L33:
        e = e;
    L39:
        r15 = false;
    L37:
        e = e;
    L35:
        th = move-exception;
        r4 = th;
        r14 = false;
        goto L54
    L65:
        r7.close();     // Catch: Throwable -> L77
        r6.close();     // Catch: IOException -> L85
        return r5.getAbsolutePath();
    L69:
        th = move-exception;
        r7.close();     // Catch: Throwable -> L73
    L121:
        throw th;     // Catch: Throwable -> L77
    L73:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L77
        throw th;     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        r6.close();     // Catch: Throwable -> L81
    L122:
        throw th;     // Catch: IOException -> L85
    L81:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L85
        throw th;     // Catch: IOException -> L85
    L85:
        e = move-exception;
        FLogger r19 = FLogger.a;
        r19.e("LogFC-O-Auto", "Error compressing files to " + r5.getAbsolutePath() + " : " + e.getMessage());
        if (r5.exists() == true) goto L89;
    L91:
        throw e;
    L89:
        if (r5.delete() == true) goto L91;
        r19.w("LogFC-O-Auto", "Failed to delete invalid zip file: " + r5.getAbsolutePath());
        goto L91
    }

    public static void f(File r3, ZipOutputStream r4) throws IOException {
        PolarisFileInputStreamWrapper r0 = new PolarisFileInputStreamWrapper(r3);
        byte[] r5 = new byte[8192];     // Catch: Throwable -> L10
    L4:
        int r1 = r0.read(r5);     // Catch: Throwable -> L10
        if (r1 < 0) goto L8;
        r4.write(r5, 0, r1);     // Catch: Throwable -> L10
        goto L4
    L8:
        r0.close();
        return;
    L10:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public static void a(File r7, String r8, ZipOutputStream r9) {
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r7);     // Catch: Throwable -> L29 IOException -> L31
        r9.putNextEntry(new ZipEntry(r8));     // Catch: Throwable -> L22
        byte[] r5 = new byte[8192];     // Catch: Throwable -> L20
    L7:
        int r6 = r4.read(r5);     // Catch: Throwable -> L20
        if (r6 < 0) goto L11;
        r9.write(r5, 0, r6);     // Catch: Throwable -> L20
        goto L7
    L11:
        r4.close();     // Catch: Throwable -> L16 IOException -> L18
        r9.closeEntry();     // Catch: IOException -> L14
        return;
    L14:
        e = e;
        FLogger r10 = FLogger.a;
        StringBuilder r3 = new StringBuilder("Error closing zip entry for ");
    L39:
        r3.append(r7.getAbsolutePath());
        r3.append(" : ");
        r3.append(e.getMessage());
        r10.e("LogFC-O-Auto", r3.toString());
        return;
    L20:
        Throwable th = th;
    L47:
        r4.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L16 IOException -> L18
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L16 IOException -> L18
    L22:
        th = move-exception;
        th = th;
        goto L47
    L16:
        Throwable th2 = th;
    L41:
        if (r8 != null) goto L56;
    L46:
        throw th2;
    L56:
        r9.closeEntry();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        FLogger.a.e("LogFC-O-Auto", "Error closing zip entry for " + r7.getAbsolutePath() + " : " + e.getMessage());
    L18:
        IOException e = e;
    L33:
        FLogger.a.e("LogFC-O-Auto", "Error compressing file " + r7.getAbsolutePath() + " : " + e.getMessage());     // Catch: Throwable -> L16
        if (r8 == null) goto L63;
        r9.closeEntry();     // Catch: IOException -> L37
        return;
    L37:
        e = e;
        r10 = FLogger.a;
        r3 = new StringBuilder("Error closing zip entry for ");
        goto L39
    L63:
        return;
    L31:
        e = move-exception;
        e = e;
        r8 = null;
    L29:
        th = move-exception;
        th2 = th;
        r8 = null;
        goto L41
    }

    public static File c(Context r3, PolarisFileWrapper r4, PolarisFileWrapper r5) throws IOException {
        File r6 = r3.getCacheDir();
        if (r6.exists() == true) goto L5;
        r6.mkdirs();
    L5:
        File r7 = File.createTempFile("oapp_logs_", ".zip", r6);
        PolarisFileOutputStreamWrapper r0 = new PolarisFileOutputStreamWrapper(r7);
        ZipOutputStream r1 = new ZipOutputStream(r0);     // Catch: Throwable -> L17
        d(r4, r4.getName(), r1, r5);     // Catch: Throwable -> L11
        r1.close();     // Catch: Throwable -> L17
        r0.close();
        return r7;
    L11:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: Throwable -> L17
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    }

    public static void d(File r5, String r6, ZipOutputStream r7, PolarisFileWrapper r8) {
        if (r5.isDirectory() == false) goto L17;
        File[] r9 = r5.listFiles();
        if (r9 == null) goto L25;
        int r0 = r9.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L26;
        File r2 = r9[r1];
        if (r2.equals(r8) == true) goto L15;
        if (r2.isDirectory() == false) goto L14;
        d(r2, r6 + "/" + r2.getName(), r7, r8);
        goto L15
    L14:
        a(r2, r6 + "/" + r2.getName(), r7);
    L15:
        r1 = r1 + 1;
        goto L7
    L26:
        return;
    L25:
        return;
    L17:
        if (r5.equals(r8) == false) goto L19;
        return;
    L19:
        a(r5, r6, r7);
    }
}
