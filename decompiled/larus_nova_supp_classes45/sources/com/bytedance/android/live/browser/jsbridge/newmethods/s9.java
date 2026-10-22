package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.PlayAlphaVideoResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s9 extends w20.z4<w20.ad, PlayAlphaVideoResultModel> {
    public final com.bytedance.android.scope.j a;

    public s9(com.bytedance.android.scope.j r1) {
        this.a = r1;
    }

    public final void invoke(Object r17, CallContext r18) {
        w20.ad r0 = (w20.ad) r17;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r18, "callContext");
        String r1 = r0.e();
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L13;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("PlayAlphaVideoMethod", "resourcePath is null or empty");
        finishWithFailure();
        return;
    L13:
        if (StringsKt.startsWith$default(r1, "file:///", false, 2, null) == false) goto L19;
        if (r1 == null) goto L17;
        r1 = r1.substring(7);
    L24:
        String r11 = r1;
        Boolean r5 = r0.c();
        if (r5 == null) goto L27;
        boolean r12 = r5.booleanValue();
    L28:
        Boolean r6 = r0.d();
        if (r6 == null) goto L31;
        boolean r13 = r6.booleanValue();
    L32:
        Boolean r7 = r0.b();
        if (r7 == null) goto L35;
        boolean r14 = r7.booleanValue();
    L36:
        Boolean r2 = r0.a();
        if (r2 == null) goto L39;
        boolean r15 = r2.booleanValue();
    L40:
        zg1.h2 r3 = new zg1.h2(r11, r12, r13, r14, r15, r0.f());
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("PlayAlphaVideoMethod", "mvi open, event is " + r3);
        com.bytedance.android.scope.j r8 = this.a;
        if (r8 == null) goto L47;
        com.bytedance.android.livesdk.gift.platform.core.scope.service.r0 r9 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.r0) com.bytedance.android.scope.m.e.d(r8, com.bytedance.android.livesdk.gift.platform.core.scope.service.r0.class);
        if (r9 == null) goto L48;
        r9.onEvent(r3);
        return;
    L48:
        return;
    L47:
        return;
    L39:
        r15 = false;
        goto L40
    L35:
        r14 = true;
        goto L36
    L31:
        r13 = false;
        goto L32
    L27:
        r12 = false;
        goto L28
    L17:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        if (StringsKt.startsWith$default(r1, "file://", false, 2, null) == false) goto L24;
        if (r1 == null) goto L23;
        r1 = r1.substring(6);
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L5:
        if (r1.length() == 0) goto L8;
        r4 = false;
        goto L10
    }
}
