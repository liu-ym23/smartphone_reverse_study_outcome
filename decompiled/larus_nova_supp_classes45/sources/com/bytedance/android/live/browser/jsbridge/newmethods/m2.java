package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "destroyRoomInfoBanner")
public final class m2 extends com.bytedance.ies.web.jsbridge2.g<Object, Object> {
    public m2() {
    }

    public final Object invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        xs2.b.a().post(new com.bytedance.android.livesdk.event.h());
        return null;
    }
}
