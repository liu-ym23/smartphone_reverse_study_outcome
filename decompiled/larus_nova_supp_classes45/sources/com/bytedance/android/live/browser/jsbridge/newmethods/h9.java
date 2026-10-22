package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenMultiPosterSharePanelResultModel;
import com.bytedance.android.live.room.api.IMatchShareService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openMultiPosterSharePanel")
public final class h9 extends w20.n4<w20.mc, OpenMultiPosterSharePanelResultModel> {

    public static final class a {
    }

    static {
    }

    public final void onTerminate() {
    }

    public h9() {
    }

    public final void invoke(Object r5, CallContext r6) {
        w20.mc r7 = (w20.mc) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        List<String> r8 = r7.d();
        if (r8 == null) goto L18;
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L18;
        Boolean r1 = r7.a();
        if (r1 == null) goto L9;
        boolean r2 = r1.booleanValue();
    L10:
        List r9 = CollectionsKt.toMutableList(r8);
        String r3 = r7.b();
        String r4 = "";
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        String r11 = r7.c();
        if (r11 == null) goto L17;
        r4 = r11;
    L17:
        r0.launchVsMultiPosterShare(r2, r9, r3, r4);
        goto L18
    L9:
        r2 = false;
    L18:
        finishWithSuccess();
    }
}
