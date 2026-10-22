package com.bytedance.ai.resource.core;

import androidx.room.jarjarred.org.antlr.runtime.a;
import com.bytedance.ai.utils.c;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.utils.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/AIPackageZipExtractor;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageZipExtractor {
    public AIPackageZipExtractor() {
    }

    public static void a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, SVGRenderEngine.PATH);
        ZipFile r5 = new ZipFile(r10);
        Enumeration<? extends ZipEntry> r12 = r5.entries();     // Catch: Throwable -> L12
    L5:
        if (r12.hasMoreElements() == false) goto L46;
        ZipEntry r13 = r12.nextElement();     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.util.zip.ZipEntry");     // Catch: Throwable -> L12
        ZipEntry r14 = r13;     // Catch: Throwable -> L12
        if (StringsKt.g(r14.getName(), "../") == true) goto L9;
        File r15 = new File(r11, r14.getName());     // Catch: Throwable -> L12
        if (StringsKt.P(r15.getCanonicalPath(), new File(r11).getCanonicalPath()) == false) goto L18;
        File r16 = new File(r11, r14.getName());     // Catch: Throwable -> L12
        if (r14.isDirectory() == true) goto L25;
        File r17 = r16.getParentFile();     // Catch: Throwable -> L12
        if (r17 == null) goto L29;
        r17.mkdirs();     // Catch: Throwable -> L12
    L29:
        InputStream r18 = r5.getInputStream(r14);     // Catch: Throwable -> L12
        FileOutputStream r19 = new FileOutputStream(r16);     // Catch: Throwable -> L12
        ByteStreamsKt.copyTo$default(r18, r19, 0, 2, null);     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r19, null);     // Catch: Throwable -> L35
        CloseableKt.closeFinally(r18, null);     // Catch: Throwable -> L12
        goto L5
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r19, th);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L25:
        r16.mkdirs();     // Catch: Throwable -> L12
        goto L5
    L18:
        String r20 = "canonicalPath path is not safe: " + r15.getCanonicalPath();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("AIPackageZipExtractor", "tag");     // Catch: Throwable -> L12
        d r21 = c.f2846a;     // Catch: Throwable -> L12
        if (r21 == null) goto L22;
        r21.e("AIPackageZipExtractor", r20);     // Catch: Throwable -> L12
    L22:
        throw new SecurityException("canonicalPath path is not safe");     // Catch: Throwable -> L12
    L9:
        String r22 = "entry path is not safe: " + r14.getName();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("AIPackageZipExtractor", "tag");     // Catch: Throwable -> L12
        d r23 = c.f2846a;     // Catch: Throwable -> L12
        if (r23 == null) goto L15;
        r23.e("AIPackageZipExtractor", r22);     // Catch: Throwable -> L12
    L15:
        throw new SecurityException("entry path is not safe");     // Catch: Throwable -> L12
    L46:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r5, null);
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }

    public static boolean b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, SVGRenderEngine.PATH);
        if (r10.length() <= 0) goto L5;
        boolean r5 = new File(r10).exists();
    L7:
        if (r5 == true) goto L13;
        String r12 = a.r("Failed to unzip ", r10, ": does not exist", "AIPackageZipExtractor", "tag");
        d r13 = c.f2846a;
        if (r13 == null) goto L11;
        r13.e("AIPackageZipExtractor", r12);
    L11:
        return false;
    L13:
        if (r11.length() <= 0) goto L36;
        File r14 = new File(r11);
        if (r14.exists() == false) goto L17;
        FilesKt.deleteRecursively(r14);
    L17:
        r14.mkdirs();
    L36:
        a(r10, r11);     // Catch: Exception -> L22
        String r15 = "Unzip " + r10 + " to " + r11 + " successfully";     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter("AIPackageZipExtractor", "tag");     // Catch: Exception -> L22
        d r16 = c.f2846a;     // Catch: Exception -> L22
        if (r16 == null) goto L24;
        r16.d("AIPackageZipExtractor", r15);     // Catch: Exception -> L22
        return true;
    L24:
        return true;
    L22:
        e = move-exception;
        String r17 = i.a.h(e, e.b("Failed to unzip ", r10, ": "), "AIPackageZipExtractor");
        d r18 = c.f2846a;
        if (r18 == null) goto L30;
        r18.e("AIPackageZipExtractor", r17);
    L30:
        if (r11.length() <= 0) goto L34;
        File r19 = new File(r11);
        if (r19.exists() == false) goto L34;
        FilesKt.deleteRecursively(r19);
    L34:
        c.i(r10);
        return false;
    L5:
        r5 = false;
        goto L7
    }
}
