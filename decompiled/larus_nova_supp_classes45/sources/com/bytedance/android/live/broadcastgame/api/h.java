package com.bytedance.android.live.broadcastgame.api;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.File;
import java.io.IOException;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static final String a(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter("xplay_peformance.log", "filename");
        Intrinsics.checkNotNullParameter(r6, "content");
        File[] r7 = ContextCompat.getExternalFilesDirs(r5, null);
        if (r7.length != 0) goto L5;
        boolean r2 = true;
    L7:
        if ((!r2) == true) goto L9;
    L21:
        return null;
    L9:
        if (r7[0] == null) goto L21;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r7[0], "xplay_peformance.log");     // Catch: IOException -> L19
        PolarisFileWriterWrapper r8 = new PolarisFileWriterWrapper(r3, true);     // Catch: IOException -> L19
        r8.append(r6);     // Catch: Throwable -> L14
        r8.append("\n");     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r8, null);     // Catch: IOException -> L19
        return r3.getAbsolutePath();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: IOException -> L19
        throw th;     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L5:
        r2 = false;
        goto L7
    }
}
