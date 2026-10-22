package com.bytedance.android.live.room.share.jsbridge;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@XBridgeMethod(biz = "webcast", name = "fullParamsSharePanel")
public final class b extends com.bytedance.ies.web.jsbridge2.f<LiveWebShareParams, Object> {

    public static final class a {
    }

    static {
    }

    public final void onTerminate() {
    }

    public b() {
    }

    public final void invoke(Object r23, CallContext r24) {
        LiveWebShareParams r0 = (LiveWebShareParams) r23;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r24, "callContext");
        ShareParams.Builder r1 = ShareParams.builder();
        r1.setLiveWebShareParams(r0);
        ILiveShareService r3 = (ILiveShareService) jc1.k.n(ILiveShareService.class);
        ShareParams r8 = r1.build();
        Context r2 = r24.getContext();
        if (r2 == null) goto L7;
        r3.share(new i81.a(null, (Activity) r2, null, r8, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ShareFullParamsMethod", LiveShareType.SHARE_DIALOG, new c(this, r0));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
}
