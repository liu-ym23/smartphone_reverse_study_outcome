package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.bytedance.android.live.browser.jsbridge.base.RechargeScreenShieldResultModel;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.config.er0;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import w20.cd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k3 extends w20.b5<cd, RechargeScreenShieldResultModel> {

    public static final class a {
    }

    static {
    }

    public k3(WeakReference<Context> r2) {
        Intrinsics.checkNotNullParameter(r2, "contextRef");
    }

    public final void invoke(Object r3, CallContext r4) {
        cd r5 = (cd) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        r5.a();
        if (((Boolean) er0.a.getValue()).booleanValue() == false) goto L18;
        Activity r6 = ContextUtil.contextToActivity(r4.getContext());
        Integer r7 = r5.a();
        if (r7 != null) goto L8;
    L13:
        if (r6 == null) goto L17;
        Window r8 = r6.getWindow();
        if (r8 == null) goto L17;
        r8.clearFlags(8192);
    L17:
        finishWithSuccess();
        return;
    L8:
        if (r7.intValue() != 1) goto L13;
        if (r6 == null) goto L17;
        Window r9 = r6.getWindow();
        if (r9 == null) goto L17;
        r9.setFlags(8192, 8192);
        goto L17
    L18:
        finishWithSuccess();
    }
}
