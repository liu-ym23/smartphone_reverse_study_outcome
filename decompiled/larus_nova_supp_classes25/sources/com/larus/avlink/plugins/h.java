package com.larus.avlink.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public final boolean a;
    public final NotUploadReason b;

    public h(boolean r2, NotUploadReason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.a = r2;
        this.b = r3;
    }
}
