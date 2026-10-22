package com.bytedance.android.live.saas.middleware.utils;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class ZipFileUtil {
    private static final int NUM_2048 = 2048;

    private ZipFileUtil() {
    }

    public static boolean removeDir(File r5) {
        if (r5.isDirectory() == false) goto L21;
        File[] r0 = r5.listFiles();
        if (r0 == null) goto L19;
        if (r0.length == 0) goto L19;
        int r1 = r0.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L17;
        File r3 = r0[r2];
        if (r3.isDirectory() == false) goto L14;
        removeDir(r3);
    L15:
        r2 = r2 + 1;
        goto L10
    L14:
        r3.delete();
        goto L15
    L17:
        return r5.delete();
    L19:
        return r5.delete();
    L21:
        return r5.delete();
    }

    public static void unZipFolder(String r4, String r5) throws Exception {
        ZipInputStream r0 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r4)));
    L3:
        ZipEntry r6 = r0.getNextEntry();
        if (r6 == null) goto L20;
        String r1 = r6.getName();
        if (r1.contains("..") == true) goto L3;
        if (r6.isDirectory() == true) goto L10;
        PolarisFileWrapper r7 = new PolarisFileWrapper(r5 + File.separator + r1);
        if (r7.exists() == false) goto L14;
        r7.delete();
    L15:
        r7.createNewFile();
        BufferedOutputStream r2 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r7));
        byte[] r8 = new byte[NUM_2048];
    L16:
        int r3 = r0.read(r8);
        if (r3 == (-1)) goto L19;
        r2.write(r8, 0, r3);
        goto L16
    L19:
        r2.flush();
        r2.close();
        goto L3
    L14:
        r7.getParentFile().mkdirs();
        goto L15
    L10:
        new PolarisFileWrapper(r5 + File.separator + r1).mkdirs();
        goto L3
    L20:
        r0.close();
    }
}
