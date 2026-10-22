package com.larus.dora.impl.feedback;

import android.content.Context;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Context r7, Uri r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "uri");
        InputStream r4 = ContentResolverWrapper.openInputStream(r7.getContentResolver(), r8);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        if (r4 == null) goto L22;
        File r9 = File.createTempFile("temp_video_", ".mp4", r7.getCacheDir());     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        PolarisFileOutputStreamWrapper r2 = new PolarisFileOutputStreamWrapper(r9);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        ByteStreamsKt.copyTo$default(r4, r2, 0, 2, null);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r2, null);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        pk4.j.d("UriToPathUtil", "URI content copied to cache: " + r9.getAbsolutePath() + ", size=" + r9.length());     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        return r9.getAbsolutePath();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        throw th;     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L22:
        pk4.j.b("UriToPathUtil", "openInputStream returned null, uri=" + r8);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        return null;
    L26:
        e = move-exception;
        pk4.j.c("UriToPathUtil", "IOException: failed to copy URI content, uri=" + r8, e);
        return null;
    L28:
        e = move-exception;
        pk4.j.c("UriToPathUtil", "SecurityException: URI permission denied or expired, uri=" + r8, e);
        return null;
    L24:
        e = move-exception;
        pk4.j.c("UriToPathUtil", "Unexpected error copying URI content, uri=" + r8, e);
        return null;
    }
}
