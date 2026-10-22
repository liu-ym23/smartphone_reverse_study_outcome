package com.obric.aikernel.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f5592a = null;

    static {
        f5592a = new f();
    }

    private f() {
    }

    public final void a(File r10) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        if (r10.exists() == true) goto L5;
        return;
    L5:
        if (r10.isDirectory() == false) goto L11;
        File[] r11 = r10.listFiles();
        Intrinsics.checkNotNullExpressionValue(r11, "dir.listFiles()");
        int r12 = 0;
        int r13 = r11.length;
    L7:
        if (r12 >= r13) goto L12;
        File r14 = r11[r12];
        f r15 = f5592a;
        Intrinsics.checkNotNullExpressionValue(r14, "it");
        r15.c(r14);
        r12 = r12 + 1;
        goto L7
    L12:
        return;
    }

    public final void b(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "src");
        Intrinsics.checkNotNullParameter(r11, "dest");
        FileInputStream r12 = new FileInputStream(r10);
        FileOutputStream r13 = new FileOutputStream(r11);     // Catch: Throwable -> L14
        ByteStreamsKt.copyTo$default(r12, r13, 0, 2, null);     // Catch: Throwable -> L9
        r13.flush();     // Catch: Throwable -> L9
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r12, null);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    public final void c(File r10) {
        Intrinsics.checkNotNullParameter(r10, "file");
        if (r10.isDirectory() == false) goto L7;
        File[] r11 = r10.listFiles();
        Intrinsics.checkNotNullExpressionValue(r11, "file.listFiles()");
        int r12 = 0;
        int r13 = r11.length;
    L5:
        if (r12 >= r13) goto L7;
        File r14 = r11[r12];
        f r15 = f5592a;
        Intrinsics.checkNotNullExpressionValue(r14, "it");
        r15.c(r14);
        r12 = r12 + 1;
    L7:
        r10.delete();
    }

    public final File d(Context r10, String r11, File r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "content");
        Intrinsics.checkNotNullParameter(r12, "dir");
        Intrinsics.checkNotNullParameter(r13, "fileName");
        File r14 = File.createTempFile(r13, null, r12);     // Catch: IOException -> L5
        Path r15 = r14.toPath();     // Catch: IOException -> L5
        byte[] r16 = r11.getBytes(Charsets.UTF_8);     // Catch: IOException -> L5
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).getBytes(charset)");     // Catch: IOException -> L5
        Files.write(r15, r16, new OpenOption[0]);     // Catch: IOException -> L5
        return r14;
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final File e(Context r10, Uri r11, File r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "dir");
        Intrinsics.checkNotNullParameter(r13, "fileName");
        File r14 = new File(r12, r13);     // Catch: IOException -> L24
        long r15 = 0;
        ContentResolver r16 = r10.getContentResolver();     // Catch: IOException -> L24
        Intrinsics.checkNotNull(r11);     // Catch: IOException -> L24
        InputStream r17 = r16.openInputStream(r11);     // Catch: IOException -> L24
        FileOutputStream r18 = new FileOutputStream(r14);     // Catch: Throwable -> L19
        byte[] r19 = new byte[1024];     // Catch: Throwable -> L14
    L7:
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L14
        int r20 = r17.read(r19);     // Catch: Throwable -> L14
        if (r20 == (-1)) goto L10;
        r18.write(r19, 0, r20);     // Catch: Throwable -> L14
        r15 = r15 + ((long) r20);     // Catch: Throwable -> L14
        goto L7
    L10:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r18, null);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r17, null);     // Catch: IOException -> L24
        AIKLog.INSTANCE.i("FileUtils", "copy uri for post, path: " + r11 + ", size: " + r15);     // Catch: IOException -> L24
        return r14;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: IOException -> L24
        throw th;     // Catch: IOException -> L24
    L24:
        e = move-exception;
        AIKLog.INSTANCE.e("FileUtils", "copy uri file failed, path:" + r11 + ", err: " + e.getMessage());
        return null;
    }

    public final void f(File r10) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        if (r10.exists() == true) goto L6;
        r10.mkdirs();
        return;
    }
}
