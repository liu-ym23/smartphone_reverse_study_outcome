package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v7 extends n<w7, LiveUpdateDiggAnimStyleResultModel> {
    public final DataCenter a;

    public static final class a {
    }

    static {
    }

    public v7(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = r2;
    }

    public final void invoke(Object r2, CallContext r3) {
        w7 r4 = (w7) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        ALogger.d("LiveUpdateDiggAnimStyleMethod", "invoke : enableDiggAnimStyle:" + r4.a());
        DiggContext.a r5 = DiggContext.Companion;
        DataCenter r0 = this.a;
        r5.getClass();
        DiggContext r6 = DiggContext.a.a(r0);
        if (r6 == null) goto L7;
        com.bytedance.live.datacontext.m r7 = r6.getVsLiveRoomDiggCountAnim();
        if (r7 == null) goto L7;
        r7.setValue(Boolean.valueOf(Intrinsics.areEqual(r4.a(), Boolean.TRUE)));
    L7:
        finishWithSuccess();
    }
}
