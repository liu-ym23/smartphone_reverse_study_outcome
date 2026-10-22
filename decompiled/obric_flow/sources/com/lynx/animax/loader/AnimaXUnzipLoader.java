package com.lynx.animax.loader;

import ai.j0;
import am.e;
import androidx.annotation.Keep;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.util.AnimaXLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import sk.a;

/* JADX INFO: loaded from: classes2.dex */
public class AnimaXUnzipLoader {

    @Keep
    public static class UnzipResult {
        private String error;
        private String path;

        public UnzipResult(String r5, String r10) {
            this.error = r5;
            this.path = r10;
        }

        public String getError() {
            return this.error;
        }

        public String getPath() {
            return this.path;
        }

        public void setError(String r5) {
            this.error = r5;
        }

        public void setPath(String r5) {
            this.path = r5;
        }
    }

    @CalledByNative
    public static String getError(UnzipResult r5) {
        return r5.getError();
    }

    @CalledByNative
    public static String getPath(UnzipResult r5) {
        return r5.getPath();
    }

    @CalledByNative
    public static UnzipResult unzip(String r10, String r11) {
        if (r10 == null) goto L86;
        if (r10.isEmpty() == true) goto L86;
        if (r11 == null) goto L84;
        if (r11.isEmpty() == true) goto L84;
        FileInputStream r12 = new FileInputStream(new File(r10));     // Catch: FileNotFoundException -> L14
    L16:
        if (r12 != null) goto L18;
        ZipInputStream r5 = null;
    L19:
        if (r5 != null) goto L21;
        e r13 = new e("open zip file error");
    L38:
        if (r13.f324a == true) goto L42;
        return new UnzipResult(r13.f325b, null);
    L42:
        return new UnzipResult(null, r11);
    L21:
        File r14 = new File(r11);
        if (r14.exists() == true) goto L24;
        boolean r15 = r14.mkdirs();
    L25:
        if (r15 == true) goto L101;
        r13 = new e("make dst directory error");
    L101:
        ZipEntry r16 = r5.getNextEntry();     // Catch: IOException -> L29
    L31:
        if (r16 == null) goto L99;
        String r17 = r16.getName();
        if (r17 != null) goto L47;
    L97:
        r5.closeEntry();     // Catch: IOException -> L81
    L81:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "UnzipUtil", "closeEntry error: " + e.getMessage());
        goto L101
    L47:
        if (r17.contains("__MACOSX") == true) goto L97;
        if (r17.contains(".DS_Store") == true) goto L97;
        if (r17.contains("../") == true) goto L97;
        if (r16.isDirectory() == false) goto L95;
        new File(j0.q(a.a(r11), File.separator, r17)).mkdirs();
        goto L97
    L95:
        FileOutputStream r18 = new FileOutputStream(j0.q(a.a(r11), File.separator, r17));     // Catch: FileNotFoundException -> L59
    L61:
        if (r18 == null) goto L97;
        BufferedOutputStream r19 = new BufferedOutputStream(r18);
        byte[] r20 = new byte[4096];
    L91:
        int r21 = r5.read(r20);     // Catch: IOException -> L67
    L69:
        if ((-1) != r21) goto L87;
    L93:
        r19.close();     // Catch: IOException -> L77
    L77:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "UnzipUtil", "close bufferedOutputStream error: " + e.getMessage());
        goto L97
    L87:
        r19.write(r20, 0, r21);     // Catch: IOException -> L73
    L73:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "UnzipUtil", "writeToStream error: " + e.getMessage());
    L67:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "UnzipUtil", "readZipFile error: " + e.getMessage());
        r21 = -1;
    L59:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "UnzipUtil", "extractFile, create FileOutputStream error: " + e.getMessage());
        r18 = null;
        goto L61
    L99:
        r5.close();     // Catch: IOException -> L34
    L36:
        r13 = new e();
    L34:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "UnzipUtil", "zipInputStream close error: " + e.getMessage());
    L29:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "UnzipUtil", "getNextEntry error: " + e.getMessage());
        r16 = null;
        goto L31
    L24:
        r15 = true;
        goto L25
    L18:
        r5 = new ZipInputStream(r12);
    L14:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "UnzipUtil", "new FileInputStream error: " + e.getMessage());
        r12 = null;
    L84:
        return new UnzipResult("UnzippedFilePath is null.", null);
    L86:
        return new UnzipResult("ZippedFilePath is null.", null);
    }
}
