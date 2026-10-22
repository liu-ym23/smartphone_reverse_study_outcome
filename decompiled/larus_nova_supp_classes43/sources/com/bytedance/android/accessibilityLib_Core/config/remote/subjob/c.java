package com.bytedance.android.accessibilityLib_Core.config.remote.subjob;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static void a(PolarisFileWrapper r10, PolarisFileWrapper r11) {
        PolarisZipFileWrapper r0 = new PolarisZipFileWrapper(r10);     // Catch: Exception -> L25
        Enumeration<? extends ZipEntry> r12 = r0.entries();     // Catch: Exception -> L25
    L4:
        if (r12.hasMoreElements() == false) goto L41;
        ZipEntry r1 = r12.nextElement();     // Catch: Exception -> L25
        String r13 = r1.getName();     // Catch: Exception -> L25
        if (StringsKt.contains$default(r13, "../", false, 2, null) == true) goto L24;
        if (StringsKt.startsWith$default(new PolarisFileWrapper(r11, r13).getCanonicalPath(), r11.getCanonicalPath(), false, 2, null) == false) goto L22;
        PolarisFileWrapper r14 = new PolarisFileWrapper(r11, r13);     // Catch: Exception -> L25
        if (r1.isDirectory() == true) goto L12;
        File r15 = r14.getParentFile();     // Catch: Exception -> L25
        if (r15 == null) goto L16;
        r15.mkdirs();     // Catch: Exception -> L25
    L16:
        r14.createNewFile();     // Catch: Exception -> L25
        InputStream r16 = r0.getInputStream(r1);     // Catch: Exception -> L25
        PolarisFileOutputStreamWrapper r17 = new PolarisFileOutputStreamWrapper(r14);     // Catch: Exception -> L25
        byte[] r18 = new byte[1024];     // Catch: Exception -> L25
        int r19 = r16.read(r18);     // Catch: Exception -> L25
    L18:
        if (r19 == (-1)) goto L20;
        r17.write(r18, 0, r19);     // Catch: Exception -> L25
        r19 = r16.read(r18);     // Catch: Exception -> L25
        goto L18
    L20:
        r17.close();     // Catch: Exception -> L25
        r16.close();     // Catch: Exception -> L25
        goto L4
    L12:
        r14.mkdirs();     // Catch: Exception -> L25
        goto L4
    L22:
        throw new SecurityException("unzip slip");     // Catch: Exception -> L25
    L24:
        throw new SecurityException("unzip slip");     // Catch: Exception -> L25
    L41:
        return;
    L25:
        e = move-exception;
        if (("unzip error>>> " + e.getMessage()) == null) goto L40;
        Context r20 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        return;
    }
}
