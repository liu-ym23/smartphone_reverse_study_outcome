package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.gamecp.host_api.callback.TTCJPayResult;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements zv0.l {
    public final /* synthetic */ sv.b a;

    public i(com.bytedance.android.gamecp.business.props.k r1) {
        this.a = r1;
    }

    public final void a(zv0.m r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        sv.b r0 = this.a;
        if (r0 == null) goto L6;
        TTCJPayResult r1 = new TTCJPayResult();
        r1.setCallBackInfo(r4.a);
        r1.setCode(r4.b);
        Unit r5 = Unit.INSTANCE;
        r0.a(r1);
        return;
    }

    public final void onEvent(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "paramMap");
        sv.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onEvent(r2, r3);
        return;
    }
}
