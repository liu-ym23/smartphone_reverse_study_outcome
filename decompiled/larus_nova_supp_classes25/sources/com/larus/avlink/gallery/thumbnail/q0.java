package com.larus.avlink.gallery.thumbnail;

import com.larus.utils.logger.FLogger;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q0 implements b98.d {
    public q0() {
    }

    public final void a(int r6, int r7) {
        FLogger.a.i("ThumbnailManager", "Dora scene state changed, scene=" + r6 + ", state=" + r7);
        if (CollectionsKt.listOf(new Integer[]{1, 5, 4, 7}).contains(Integer.valueOf(r6)) == false) goto L8;
        if (r7 != 2) goto L9;
        ThumbnailManager r8 = ThumbnailManager.a;
        ThumbnailManager.s("Exit FlowDoraScene(" + r6 + ')');
        return;
    L9:
        return;
    }
}
