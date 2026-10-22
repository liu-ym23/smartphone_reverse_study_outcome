package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetLiveEffectInfoResultModel;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.ugc.effectmanager.EffectManager;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.getLiveEffectInfo")
public final class f6 extends w20.v2<w20.sa, LiveGetLiveEffectInfoResultModel> {
    public f6() {
    }

    public final void invoke(Object r3, CallContext r4) {
        w20.sa r5 = (w20.sa) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        List<String> r6 = r5.a();
        boolean r0 = false;
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == false) goto L18;
        List<String> r8 = r5.b();
        if (r8 != null) goto L13;
    L14:
        r0 = true;
    L15:
        if (r0 == false) goto L17;
        finishWithFailure();
        return;
    L17:
        List<String> r9 = LiveEffectContext.h;
        EffectManager r11 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d();
        List<String> r1 = r5.b();
        Intrinsics.checkNotNull(r1);
        r11.fetchEffectList(r1, MapsKt.mapOf(TuplesKt.to("panel", r5.c())), new e6(this));
        return;
    L13:
        if (r8.isEmpty() == false) goto L15;
    L18:
        List<String> r12 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffectList2(r5.a(), null, new d6(this));
        return;
    L5:
        if (r6.isEmpty() == true) goto L8;
        r7 = false;
        goto L9
    }
}
