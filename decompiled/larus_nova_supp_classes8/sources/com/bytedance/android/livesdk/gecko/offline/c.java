package com.bytedance.android.livesdk.gecko.offline;

import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements d {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.gecko.offline.d
    public final PolarisFileWrapper a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        boolean r0 = OfflineResourceClient.a;
        d1 r3 = OfflineResourceClient.e(r2);
        if (r3 == null) goto L9;
        String r4 = r3.b;
        if (r4 != null) goto L8;
        return null;
    L8:
        return new PolarisFileWrapper(r4);
    L9:
        return null;
    }
}
