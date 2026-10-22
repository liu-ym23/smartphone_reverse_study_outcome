package com.bytedance.android.live.revenue.platform.file.impl;

import android.os.FileObserver;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.h2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends FileObserver {
    public final /* synthetic */ m97.b a;

    public b(h2 r1, String r2) {
        this.a = r1;
        super(r2, 4095);
    }

    @Override // android.os.FileObserver
    public final void onEvent(int r2, String r3) {
        this.a.onEvent(r2, r3);
    }
}
