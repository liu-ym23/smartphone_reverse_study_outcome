package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.GetLiveServiceTimeResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends wy0.a<Object, GetLiveServiceTimeResultModel> {
    public final void onTerminate() {
    }

    public h() {
    }

    public final void invoke(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callContext");
        jy0.b.d("NotifyPKEventMethod", "param: " + r3);
        GetLiveServiceTimeResultModel r5 = new GetLiveServiceTimeResultModel();
        r5.a(GetLiveServiceTimeResultModel.Code.Success);
        r5.b(Long.valueOf(com.bytedance.live.kmp.util.e.b()));
        Unit r6 = Unit.INSTANCE;
        j(r5);
    }
}
