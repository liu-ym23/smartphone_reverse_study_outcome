package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Bundle;
import com.bytedance.android.live.browser.jsbridge.base.LiveTaskOperationResultModel;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "liveTaskOperation")
public final class h7 extends w20.n3<w20.ib, LiveTaskOperationResultModel> {
    public h7() {
    }

    public final void invoke(Object r6, CallContext r7) {
        w20.ib r8 = (w20.ib) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        zg1.h1 r0 = new zg1.h1(6);
        Integer r9 = r8.a();
        if (r9 != null) goto L6;
    L11:
        if (r9 != null) goto L14;
    L19:
        if (r9 != null) goto L22;
        return;
    L22:
        if (r9.intValue() != 3) goto L27;
        SharedPrefHelper r11 = SharedPrefHelper.b(r7.getContext());
        r11.l("live.pref.SHOW_COIN_TASK_POPUP_COUNTS", Integer.valueOf(r11.h("live.pref.SHOW_COIN_TASK_POPUP_COUNTS", 0) + 1));
        r11.a();
        Bundle r12 = new Bundle();
        r12.putBoolean("DATA_BOOLEAN_SKIP_INTERCEPTOR", true);
        r0.d = r12;
        xs2.b.a().post(r0);
        return;
    L27:
        return;
    L14:
        if (r9.intValue() != 2) goto L19;
        xs2.b.a().post(new zg1.j1());
        SharedPrefHelper r13 = SharedPrefHelper.b(r7.getContext());
        if (r13.b != null) goto L18;
        r13.b = r13.a.edit();
    L18:
        r13.b.remove("live.pref.SHOW_COIN_TASK_POPUP_COUNTS");
        r13.a();
        return;
    L6:
        if (r9.intValue() != 1) goto L11;
        SharedPrefHelper r14 = SharedPrefHelper.b(r7.getContext());
        if (r14.b != null) goto L10;
        r14.b = r14.a.edit();
    L10:
        r14.b.remove("live.pref.SHOW_COIN_TASK_POPUP_COUNTS");
        r14.a();
    }
}
