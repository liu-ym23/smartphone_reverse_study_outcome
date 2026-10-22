package com.larus.avlink.gallery.thumbnail;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o0 implements t39.i {
    public o0() {
    }

    public final void b(boolean r1) {
    }

    public final void c(boolean r1) {
    }

    public final void p(int r1) {
    }

    public final void a(int r4, int r5) {
        FLogger.a.i("ThumbnailManager", "onIdleStateChanged, state: " + r4 + ", currentState: " + r5);
        ThumbnailManager.m = r4;
    }
}
