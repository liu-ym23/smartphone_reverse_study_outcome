package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateViewInLiveBgResultModel;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l0 implements ih0.h {
    public final /* synthetic */ m0 a;

    public l0(m0 r1) {
        this.a = r1;
    }

    @Override // ih0.h
    public final void a(UpdateLinkmicStatusResultModel.Code r3, String r4, JsonObject r5) {
        Intrinsics.checkNotNullParameter(r3, "errCode");
        Intrinsics.checkNotNullParameter(r4, "errMsg");
        LiveUpdateViewInLiveBgResultModel r0 = new LiveUpdateViewInLiveBgResultModel();
        if (r3 != UpdateLinkmicStatusResultModel.Code.Success) goto L5;
        LiveUpdateViewInLiveBgResultModel.Code r6 = LiveUpdateViewInLiveBgResultModel.Code.Success;
    L6:
        r0.a(r6);
        r0.c(r4);
        r0.b(r5);
        this.a.finishWithResult(r0);
        return;
    L5:
        r6 = LiveUpdateViewInLiveBgResultModel.Code.Failed;
        goto L6
    }
}
