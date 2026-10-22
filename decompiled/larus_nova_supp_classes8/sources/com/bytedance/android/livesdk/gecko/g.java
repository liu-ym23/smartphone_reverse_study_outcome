package com.bytedance.android.livesdk.gecko;

import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends f {
    public final xo2.c.a b;

    public g(GeckoUpdateListener r1, xo2.c.a r2) {
        super(r1);
        this.b = r2;
    }

    public final void onDownloadProgress(UpdatePackage r7, long r8, long r10) {
        super.onDownloadProgress(r7, r8, r10);
        xo2.c.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r7, r8, r10);
        return;
    }
}
