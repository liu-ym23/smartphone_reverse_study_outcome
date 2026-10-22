package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.publishVSMessageBoardStory")
public final class t6 extends j<u6, v6> {
    public t6() {
    }

    public final void invoke(Object r11, CallContext r12) {
        u6 r13 = (u6) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        Context r14 = r12.getContext();
        if ((r14 instanceof Activity) == true) goto L5;
        r14 = null;
    L5:
        Activity r3 = (Activity) r14;
        if (r3 != null) goto L8;
        v6 r15 = new v6();
        r15.a(-1001);
        r15.b("context is not activity");
        Unit r16 = Unit.INSTANCE;
        finishWithResult(r15);
        return;
    L8:
        String r17 = r13.a();
        if (r17 == null) goto L43;
        boolean r2 = false;
        if (r17.length() <= 0) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L16;
        String r5 = r17;
    L17:
        if (r5 == null) goto L43;
        String r18 = r13.b();
        if (r18 != null) goto L22;
    L42:
        v6 r19 = new v6();
        r19.a(-1003);
        r19.b("shootWay is null or empty");
        Unit r110 = Unit.INSTANCE;
        finishWithResult(r19);
        return;
    L22:
        if (r18.length() <= 0) goto L24;
        boolean r1 = true;
    L25:
        if (r1 == false) goto L27;
        String r6 = r18;
    L28:
        if (r6 == null) goto L42;
        String r111 = r13.b();
        if (r111 != null) goto L33;
    L41:
        v6 r112 = new v6();
        r112.a(-1004);
        r112.b("enterFrom is null or empty");
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r112);
        return;
    L33:
        if (r111.length() <= 0) goto L35;
        r2 = true;
    L35:
        if (r2 == false) goto L37;
        String r7 = r111;
    L38:
        if (r7 == null) goto L41;
        jc1.k.n(IHostShare.class).publishToStory(r3, r13.c(), r5, r6, r7, null);
        finishWithSuccess();
        return;
    L37:
        r7 = null;
        goto L38
    L27:
        r6 = null;
        goto L28
    L24:
        r1 = false;
        goto L25
    L16:
        r5 = null;
        goto L17
    L13:
        r0 = false;
    L43:
        v6 r114 = new v6();
        r114.a(-1002);
        r114.b("content is null or empty");
        Unit r115 = Unit.INSTANCE;
        finishWithResult(r114);
    }
}
