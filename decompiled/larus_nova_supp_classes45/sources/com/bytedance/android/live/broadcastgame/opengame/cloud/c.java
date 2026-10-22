package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements CloudExecutor.a {
    public c() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor.a
    public final void onSuccess() {
        ALogger.d("CloudExecutor_CloudRequestListener", "onSuccess");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor.a
    public final void a(CloudResultType$ClientResultType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "clientResultType");
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        CloudExecutor.a.C0060a.a(r2, r3);
    }
}
