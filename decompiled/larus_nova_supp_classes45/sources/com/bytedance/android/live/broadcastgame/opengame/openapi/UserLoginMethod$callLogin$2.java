package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudResultType$ClientResultType;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "resultType", "Lcom/bytedance/android/live/broadcastgame/opengame/cloud/CloudResultType$ClientResultType;", "errMsg", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class UserLoginMethod$callLogin$2 extends Lambda implements Function2<CloudResultType$ClientResultType, String, Unit> {
    final /* synthetic */ i1 this$0;

    public UserLoginMethod$callLogin$2(i1 r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(CloudResultType$ClientResultType r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "resultType");
        Intrinsics.checkNotNullParameter(r5, "errMsg");
        ALogger.i("UserLoginMethod_callLogin", "login fail: resultType=" + r4 + ", errMsg=" + r5);
        int r0 = j1.a[r4.ordinal()];
        if (r0 != 1) goto L5;
        i1 r6 = this.this$0;
        OpenApiErrorInfo r7 = OpenApiErrorInfo.NET_REQUEST_TIMEOUT;
        int r1 = BaseOpenMethod.g;
        r6.n(r7, null);
        return;
    L5:
        if (r0 != 2) goto L7;
        i1 r8 = this.this$0;
        OpenApiErrorInfo r9 = OpenApiErrorInfo.NETWORK_ERROR;
        int r2 = BaseOpenMethod.g;
        r8.n(r9, null);
        return;
    L7:
        if (r0 != 3) goto L9;
    L11:
        BaseOpenMethod.p(this.this$0, r4.getErrNo(), r5, null, 12);
        return;
    L9:
        if (r0 == 4) goto L11;
        i1 r11 = this.this$0;
        OpenApiErrorInfo r12 = OpenApiErrorInfo.INTERNAL_ERROR;
        int r3 = BaseOpenMethod.g;
        r11.n(r12, null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((CloudResultType$ClientResultType) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
