package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.ScanCodeResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "scanCode")
public final class a2 extends e7.y<e7.u0, ScanCodeResultModel> {
    public a2() {
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.u0 r12 = (e7.u0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        Boolean r13 = r12.a();
        if (r13 == null) goto L5;
        r13.booleanValue();
    L5:
        ((u9.c) Annie.getService$default(u9.c.class, null, 2, null)).e1(r11.getContext(), new z1(this));
    }
}
