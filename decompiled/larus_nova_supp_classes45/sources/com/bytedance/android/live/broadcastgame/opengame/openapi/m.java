package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudResultType$ClientResultType;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements CloudExecutor.a {
    public final /* synthetic */ k.b a;
    public final /* synthetic */ n b;

    @Override // com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor.a
    public final void onSuccess() {
        ALogger.d("CloudExecutor_CloudRequestListener", "onSuccess");
        ALogger.i("CloudCallContainerMethod_call", "refresh sid success");
        k.t(this.a.a, this.b);
    }

    public m(k.b r1, n r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor.a
    public final void a(CloudResultType$ClientResultType r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "clientResultType");
        Intrinsics.checkNotNullParameter(r5, "errMsg");
        CloudExecutor.a.C0060a.a(r4, r5);
        ALogger.i("CloudCallContainerMethod_call", "refresh sid fail: resultType = " + r4 + ", errMsg = " + r5);
        int r0 = l.a[r4.ordinal()];
        if (r0 != 1) goto L5;
        k r6 = this.a.a;
        OpenApiErrorInfo r7 = OpenApiErrorInfo.NET_REQUEST_TIMEOUT;
        int r1 = BaseOpenMethod.g;
        r6.n(r7, null);
        return;
    L5:
        if (r0 != 2) goto L7;
    L14:
        BaseOpenMethod.p(this.a.a, r4.getErrNo(), r5, null, 12);
        return;
    L7:
        if (r0 == 3) goto L14;
        if (r0 == 4) goto L14;
        if (r0 == 5) goto L13;
        k r8 = this.a.a;
        OpenApiErrorInfo r9 = OpenApiErrorInfo.INTERNAL_ERROR;
        int r2 = BaseOpenMethod.g;
        r8.n(r9, null);
        return;
    L13:
        k r11 = this.a.a;
        OpenApiErrorInfo r12 = OpenApiErrorInfo.NOT_LOGIN;
        int r3 = BaseOpenMethod.g;
        r11.n(r12, null);
    }
}
