package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.LiveOpenLiveEffectSelectPanelResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.openLiveEffectSelectPanel")
public final class s6 extends w20.c3<w20.wa, LiveOpenLiveEffectSelectPanelResultModel> {
    public final List<String> a;

    public s6() {
        this.a = CollectionsKt.listOf("zongyiyouxi");
    }

    public final void invoke(Object r5, CallContext r6) {
        w20.wa r7 = (w20.wa) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r7.b() != null) goto L5;
    L18:
        finishWithFailure();
        return;
    L5:
        if (CollectionsKt.contains(this.a, r7.b()) == false) goto L18;
        xs2.b r8 = xs2.b.a();
        String r1 = r7.b();
        String r2 = "";
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        String r3 = r7.a();
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        String r9 = r7.c();
        if (r9 == null) goto L17;
        r2 = r9;
    L17:
        r8.post(new zg1.d2(r1, r3, r2, new r6(this)));
    }
}
