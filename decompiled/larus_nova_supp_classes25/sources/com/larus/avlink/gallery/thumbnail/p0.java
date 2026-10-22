package com.larus.avlink.gallery.thumbnail;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p0 implements t39.n {
    public p0() {
    }

    public final void e(int r4, int r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "productName");
        FLogger.a.i("ThumbnailManager", "onDoraLinkChanged, state: " + r4 + ", productId: " + r5 + ", productName: " + r6 + ", fwVersion: " + r7);
        if (r4 != 0) goto L6;
        ThumbnailManager.e.clear();
        ThumbnailManager.g.clear();
        return;
    }
}
