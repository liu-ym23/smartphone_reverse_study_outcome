package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateViewInLiveBgResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import w20.ob;
import w20.t3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m0 extends t3<ob, LiveUpdateViewInLiveBgResultModel> {
    public final boolean a;
    public final ih0.b b;

    public m0() {
        this(false, null);
    }

    public m0(boolean r1, ih0.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void invoke(Object r3, CallContext r4) {
        ob r5 = (ob) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r6 = r5.getType();
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        JsonObject r7 = r5.a();
        ALogger.i("MultiLinkUpdateViewInLiveBgMethod", "updateViewInLiveBgEvent: type=" + r6 + ", data=" + r7 + ", isFeed=" + this.a);
        l0 r0 = new l0(this);
        if (this.a == false) goto L11;
        if (r7 == null) goto L17;
        ih0.b r1 = this.b;
        if (r1 == null) goto L18;
        r1.updateViewInLiveBg(r6, r7, r0);
        return;
    L18:
        return;
    L17:
        return;
    L11:
        IInteractService r2 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r7 == null) goto L15;
        if (r2 == null) goto L15;
        r2.updateViewInLiveBg(r6, r7, r0);
        return;
    L15:
        finishWithFailure();
    }
}
