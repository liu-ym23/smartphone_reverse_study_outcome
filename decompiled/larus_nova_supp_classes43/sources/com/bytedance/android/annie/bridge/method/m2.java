package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.ShowModalResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "showModal")
public final class m2 extends com.bytedance.android.annie.bridge.e<com.bytedance.android.annie.bridge.t, ShowModalResultModel> {
    public final void onTerminate() {
    }

    public m2() {
    }

    public final void invoke(Object r13, CallContext r14) {
        com.bytedance.android.annie.bridge.t r15 = (com.bytedance.android.annie.bridge.t) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        Boolean r10 = r15.e();
        String r0 = r15.b();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == true) goto L11;
        String r12 = r15.b();
    L12:
        String r16 = r12;
        String r17 = r15.c();
        String r18 = r15.f();
        l2 r19 = new l2(this);
        Boolean r20 = r15.d();
        Boolean r21 = Boolean.TRUE;
        if (Intrinsics.areEqual(r20, r21) == false) goto L23;
        String r22 = r15.a();
        if (r22 != null) goto L17;
    L18:
        r1 = true;
    L19:
        if (r1 == true) goto L21;
        String r110 = r15.a();
    L22:
        j2 r23 = new j2(this);
    L25:
        if (Intrinsics.areEqual(r10, r21) == false) goto L27;
        k2 r24 = new k2(this);
    L28:
        ((a9.h) Annie.getService$default(a9.h.class, null, 2, null)).B0(new b1(r14.getContext(), r18, r17, r16, r19, r110, r23, r24, r10));
        return;
    L27:
        r24 = null;
        goto L28
    L21:
        r110 = "cancel";
        goto L22
    L17:
        if (r22.length() != 0) goto L19;
    L23:
        r110 = null;
        r23 = null;
        goto L25
    L11:
        r12 = com.bytedance.android.ec.core.event.a.VALUE_CLICK_CONFIRM;
        goto L12
    L5:
        if (r0.length() == 0) goto L8;
        r11 = false;
        goto L9
    }
}
