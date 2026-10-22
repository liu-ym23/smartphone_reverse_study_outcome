package com.bytedance.ai.resource.core;

import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    static {
    }

    public e() {
    }

    public static void a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, "path");
        PolarisZipFileWrapper r0 = new PolarisZipFileWrapper(r10);
        Enumeration<? extends ZipEntry> r12 = r0.entries();     // Catch: Throwable -> L40
    L5:
        if (r12.hasMoreElements() == false) goto L37;
        ZipEntry r1 = r12.nextElement();     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.util.zip.ZipEntry");     // Catch: Throwable -> L40
        ZipEntry r13 = r1;     // Catch: Throwable -> L40
        if (StringsKt.contains$default(r13.getName(), "../", false, 2, null) == true) goto L35;
        PolarisFileWrapper r14 = new PolarisFileWrapper(r11, r13.getName());     // Catch: Throwable -> L40
        if (StringsKt.startsWith$default(r14.getCanonicalPath(), new PolarisFileWrapper(r11).getCanonicalPath(), false, 2, null) == false) goto L33;
        PolarisFileWrapper r15 = new PolarisFileWrapper(r11, r13.getName());     // Catch: Throwable -> L40
        if (r13.isDirectory() == true) goto L13;
        File r16 = r15.getParentFile();     // Catch: Throwable -> L40
        if (r16 == null) goto L17;
        r16.mkdirs();     // Catch: Throwable -> L40
    L17:
        InputStream r17 = r0.getInputStream(r13);     // Catch: Throwable -> L40
        PolarisFileOutputStreamWrapper r18 = new PolarisFileOutputStreamWrapper(r15);     // Catch: Throwable -> L40
        ByteStreamsKt.copyTo$default(r17, r18, 0, 2, null);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r18, null);     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r17, null);     // Catch: Throwable -> L40
        goto L5
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    L13:
        r15.mkdirs();     // Catch: Throwable -> L40
        goto L5
    L33:
        g.a.e("AIPackageZipExtractor", "canonicalPath path is not safe: " + r14.getCanonicalPath());     // Catch: Throwable -> L40
        throw new SecurityException("canonicalPath path is not safe");     // Catch: Throwable -> L40
    L35:
        g.a.e("AIPackageZipExtractor", "entry path is not safe: " + r13.getName());     // Catch: Throwable -> L40
        throw new SecurityException("entry path is not safe");     // Catch: Throwable -> L40
    L37:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L40
        CloseableKt.closeFinally(r0, null);
        return;
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    public static boolean b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, "path");
        boolean r12 = true;
        if (r10.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        boolean r13 = new PolarisFileWrapper(r10).exists();
    L10:
        if (r13 == true) goto L13;
        g.a.e("AIPackageZipExtractor", "Failed to unzip " + r10 + ": does not exist");
        return false;
    L13:
        if (r11.length() <= 0) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == false) goto L34;
        PolarisFileWrapper r15 = new PolarisFileWrapper(r11);
        if (r15.exists() == false) goto L20;
        FilesKt.deleteRecursively(r15);
    L20:
        r15.mkdirs();
    L34:
        a(r10, r11);     // Catch: Exception -> L23
        g.a.d("AIPackageZipExtractor", "Unzip " + r10 + " to " + r11 + " successfully");     // Catch: Exception -> L23
        return true;
    L23:
        e = move-exception;
        g.a.e("AIPackageZipExtractor", "Failed to unzip " + r10 + ": " + ExceptionsKt.stackTraceToString(e));
        if (r11.length() > 0) goto L28;
        r12 = false;
    L28:
        if (r12 == false) goto L32;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r11);
        if (r0.exists() == false) goto L32;
        FilesKt.deleteRecursively(r0);
    L32:
        f.d(r10);
        return false;
    L15:
        r14 = false;
        goto L16
    L8:
        r13 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }
}
