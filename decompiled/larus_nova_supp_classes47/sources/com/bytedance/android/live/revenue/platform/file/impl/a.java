package com.bytedance.android.live.revenue.platform.file.impl;

import android.os.FileObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements m97.a {
    public final FileObserver a;

    public final void a() {
        this.a.stopWatching();
    }

    public final void b() {
        this.a.startWatching();
    }

    public a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "fileObserver");
        this.a = r2;
    }
}
