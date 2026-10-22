package com.obric.aikernel.res.downloader;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final String a(String r10, DownloadTask.b r11, int r12, Integer r13, Boolean r14, e r15) {
        Intrinsics.checkNotNullParameter(r10, "action");
        Intrinsics.checkNotNullParameter(r11, "file");
        Intrinsics.checkNotNullParameter(r15, "localState");
        StringBuilder r16 = new StringBuilder();
        r16.append("model download ");
        r16.append(r10);
        r16.append(" name=");
        r16.append(r11.c());
        r16.append(" downloadId=");
        r16.append(r12);
        if (r13 == null) goto L5;
        int r17 = r13.intValue();
        r16.append(" status=");
        r16.append(r17);
    L5:
        if (r14 == null) goto L7;
        boolean r18 = r14.booleanValue();
        r16.append(" downloaded=");
        r16.append(r18);
    L7:
        r16.append(" savePath=");
        r16.append(r11.f());
        r16.append(" tmpPath=");
        r16.append(r11.i());
        r16.append(" url=");
        r16.append(r11.j());
        r16.append(" saveDirExists=");
        r16.append(r15.a());
        r16.append(" saveFileExists=");
        r16.append(r15.c());
        r16.append(" saveFileBytes=");
        r16.append(r15.b());
        r16.append(" tmpDirExists=");
        r16.append(r15.d());
        String r19 = r16.toString();
        Intrinsics.checkNotNullExpressionValue(r19, "StringBuilder().apply(builderAction).toString()");
        return r19;
    }

    public static final e b(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "savePath");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        Intrinsics.checkNotNullParameter(r12, "tmpPath");
        File r13 = new File(r10);
        File r14 = new File(r13, r11);
        File r15 = new File(r12);
        boolean r16 = r13.exists();
        boolean r17 = r14.exists();
        if (r14.exists() == true) goto L6;
        r14 = null;
    L6:
        if (r14 == null) goto L8;
        long r18 = r14.length();
    L10:
        return new e(r16, r17, r18, r15.exists());
    L8:
        r18 = 0;
        goto L10
    }

    public static final boolean c(int r10) {
        return ab.d.c(r10);
    }
}
