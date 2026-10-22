package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "setMemoryByContainer")
public final class fc extends w<gc, SetMemoryByContainerResultModel> {
    public fc() {
    }

    public final void invoke(Object r6, CallContext r7) {
        gc r8 = (gc) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8.a() != null) goto L5;
        finishWithFailure();
        return;
    L5:
        List<String> r9 = r8.a();
        if (r9 == null) goto L15;
        Map r0 = com.bytedance.android.livesdk.utils.s0.a;
        List<String> r11 = r8.b();
        Intrinsics.checkNotNullParameter(r9, "keys");
        int r1 = r9.size();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L15;
        Map r3 = com.bytedance.android.livesdk.utils.s0.a;
        Object r4 = ListProtector.get(r9, r2);
        if (r11 == null) goto L13;
        String r5 = (String) ListProtector.get(r11, r2);
        if (r5 == null) goto L13;
    L14:
        ((HashMap) r3).put(r4, r5);
        r2 = r2 + 1;
    L13:
        r5 = "";
    L15:
        finishWithSuccess();
    }
}
