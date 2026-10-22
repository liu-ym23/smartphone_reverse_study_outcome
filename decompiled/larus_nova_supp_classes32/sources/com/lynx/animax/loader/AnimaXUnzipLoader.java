package com.lynx.animax.loader;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.animax.util.AnimaXLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import q4a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXUnzipLoader {

    public static class UnzipResult {
        private String error;
        private String path;

        public String getError() {
            return this.error;
        }

        public String getPath() {
            return this.path;
        }

        public void setError(String r1) {
            this.error = r1;
        }

        public void setPath(String r1) {
            this.path = r1;
        }

        public UnzipResult(String r1, String r2) {
            this.error = r1;
            this.path = r2;
        }
    }

    public AnimaXUnzipLoader() {
    }

    public static String getError(UnzipResult r0) {
        return r0.getError();
    }

    public static String getPath(UnzipResult r0) {
        return r0.getPath();
    }

    public static UnzipResult unzip(String r9, String r10) {
        if (r9 == null) goto L87;
        if (r9.isEmpty() == true) goto L87;
        if (r10 == null) goto L85;
        if (r10.isEmpty() == true) goto L85;
        PolarisFileInputStreamWrapper r11 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r9));     // Catch: FileNotFoundException -> L14
    L16:
        if (r11 != null) goto L18;
        ZipInputStream r2 = null;
    L19:
        if (r2 != null) goto L21;
        d r12 = new d("open zip file error");
    L38:
        if (r12.a == true) goto L42;
        return new UnzipResult(r12.b, null);
    L42:
        return new UnzipResult(null, r10);
    L21:
        PolarisFileWrapper r13 = new PolarisFileWrapper(r10);
        if (r13.exists() == true) goto L24;
        boolean r14 = r13.mkdirs();
    L25:
        if (r14 == true) goto L102;
        r12 = new d("make dst directory error");
    L102:
        ZipEntry r15 = r2.getNextEntry();     // Catch: IOException -> L29
    L31:
        if (r15 == null) goto L88;
        String r3 = r15.getName();
        if (r3 != null) goto L47;
    L90:
        r2.closeEntry();     // Catch: IOException -> L82
    L82:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "closeEntry error: " + e.getMessage());
        goto L102
    L47:
        if (r3.contains("__MACOSX") == true) goto L90;
        if (r3.contains(".DS_Store") == true) goto L90;
        if (r3.contains("../") == true) goto L90;
        if (r15.isDirectory() == false) goto L96;
        new PolarisFileWrapper(r10 + File.separator + r3).mkdirs();
        goto L90
    L96:
        PolarisFileOutputStreamWrapper r4 = new PolarisFileOutputStreamWrapper(r10 + File.separator + r3);     // Catch: FileNotFoundException -> L59
    L61:
        if (r4 == null) goto L90;
        BufferedOutputStream r16 = new BufferedOutputStream(r4);
        byte[] r5 = new byte[4096];
    L94:
        int r6 = r2.read(r5);     // Catch: IOException -> L67
    L69:
        if ((-1) == r6) goto L100;
        boolean r7 = false;
        r16.write(r5, 0, r6);     // Catch: IOException -> L73
        r7 = true;
    L75:
        if (r7 == true) goto L94;
    L73:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "writeToStream error: " + e.getMessage());
    L100:
        r16.close();     // Catch: IOException -> L78
    L78:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "close bufferedOutputStream error: " + e.getMessage());
    L67:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "readZipFile error: " + e.getMessage());
        r6 = -1;
    L59:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "extractFile, create FileOutputStream error: " + e.getMessage());
        r4 = null;
        goto L61
    L88:
        r2.close();     // Catch: IOException -> L34
    L36:
        r12 = new d();
    L34:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "zipInputStream close error: " + e.getMessage());
    L29:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "getNextEntry error: " + e.getMessage());
        r15 = null;
        goto L31
    L24:
        r14 = true;
        goto L25
    L18:
        r2 = new ZipInputStream(r11);
    L14:
        e = move-exception;
        AnimaXLog.a("UnzipUtil", "new FileInputStream error: " + e.getMessage());
        r11 = null;
    L85:
        return new UnzipResult("UnzippedFilePath is null.", null);
    L87:
        return new UnzipResult("ZippedFilePath is null.", null);
    }
}
