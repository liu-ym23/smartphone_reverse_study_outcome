package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveRequireGiftEffectLynxViewResultModel;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import w20.cb;
import w20.i3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends i3<cb, LiveRequireGiftEffectLynxViewResultModel> {
    public final rh6.a a;

    public k(rh6.a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
    }

    public final void invoke(Object r9, CallContext r10) {
        cb r11 = (cb) r9;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "context");
        rh6.a r13 = this.a;
        com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.d r0 = (com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.d) com.bytedance.android.scope.m.e.d(r13, com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.d.class);
        if (r0 == null) goto L25;
        Integer r14 = r11.getAction();
        if (r14 == null) goto L7;
        int r15 = r14.intValue();
    L8:
        Integer r2 = r11.getType();
        if (r2 == null) goto L11;
        int r3 = r2.intValue();
    L12:
        Boolean r4 = r11.U2();
        if (r4 == null) goto L15;
        boolean r5 = r4.booleanValue();
    L16:
        String r6 = r11.getSchema();
        if (r6 != null) goto L19;
        r6 = BuildConfig.FLAVOR;
    L19:
        Boolean r7 = r11.I5();
        if (r7 == null) goto L22;
        boolean r8 = r7.booleanValue();
    L23:
        int r1 = r15;
        r0.a(r1, r3, r5, r6, r8, r11.getChannel(), r11.i2());
        return;
    L22:
        r8 = false;
        goto L23
    L15:
        r5 = false;
        goto L16
    L11:
        r3 = 0;
        goto L12
    L7:
        r15 = 0;
        goto L8
    }
}
