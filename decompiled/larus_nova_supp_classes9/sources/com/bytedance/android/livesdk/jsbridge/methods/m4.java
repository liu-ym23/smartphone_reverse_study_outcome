package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.jsbridge.base.StartPrivateVIPLiveResultModel;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import w20.cf;
import w20.s6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "startPrivateVIPLive")
public final class m4 extends s6<cf, StartPrivateVIPLiveResultModel> {
    public m4() {
    }

    public final void invoke(Object r3, CallContext r4) {
        cf r5 = (cf) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L11;
        IUser r2 = r1.b();
        if (r2 == null) goto L11;
        if (r2.getSecret() != 1) goto L11;
        com.bytedance.android.live.core.utils.f2.b(2131920808, 0);
        finishWithFailure();
        return;
    L11:
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).closeAndRestartBroadcast(r4.getContext(), !Intrinsics.areEqual(r5.a(), Boolean.TRUE));
        finishWithSuccess();
    }
}
