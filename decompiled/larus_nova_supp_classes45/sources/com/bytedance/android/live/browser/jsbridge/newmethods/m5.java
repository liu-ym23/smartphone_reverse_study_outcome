package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.browser.jsbridge.base.ImageToastResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "imageToast")
public final class m5 extends w20.d2<w20.ba, ImageToastResultModel> {
    public m5() {
    }

    public final void invoke(Object r4, CallContext r5) {
        w20.ba r6 = (w20.ba) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r0 = r6.a();
        String r1 = r6.c();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r7 = r6.b();
        if (r7 == null) goto L10;
        r2 = r7;
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L14;
        Context r8 = r5.getContext();
        if (r8 == null) goto L18;
        com.bytedance.android.live.core.utils.f2.e(r8, null, r1, r2);
        return;
    L18:
        return;
    L14:
        Context r9 = r5.getContext();
        if (r9 == null) goto L20;
        com.bytedance.android.live.core.utils.f2.e(r9, r0, r1, r2);
        return;
    }
}
