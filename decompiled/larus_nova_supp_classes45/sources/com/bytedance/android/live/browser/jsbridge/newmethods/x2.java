package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenFansGroupSettingDirectResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openFansGroupSettingDirect")
public final class x2 extends w20.j4<w20.ic, OpenFansGroupSettingDirectResultModel> {

    public static final class a {
    }

    static {
    }

    public x2() {
    }

    public final void invoke(Object r6, CallContext r7) {
        w20.ic r8 = (w20.ic) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        String r0 = r8.a();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r8.b();
        String r9 = r8.c();
        if (r9 == null) goto L9;
        r1 = r9;
    L9:
        xs2.b.a().post(new zg1.b(r2, r1, r0, new WeakReference(r7.getContext())));
        finishWithSuccess();
    }
}
