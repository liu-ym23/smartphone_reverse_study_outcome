package com.obric.aikernel.res.downloader;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final boolean a(DownloadTask r10, DownloadTask r11) {
        Intrinsics.checkNotNullParameter(r10, "task");
        Intrinsics.checkNotNullParameter(r11, "pendingTask");
        if (r11.w() >= r10.w()) goto L6;
    L10:
        return false;
    L6:
        if (r11.w() <= r10.w()) goto L9;
        return true;
    L9:
        if ((r10.u() / (r11.u() + 1)) <= 5) goto L10;
        return true;
    }
}
