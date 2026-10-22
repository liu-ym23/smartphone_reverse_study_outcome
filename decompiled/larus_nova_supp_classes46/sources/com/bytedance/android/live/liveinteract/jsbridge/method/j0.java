package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.SendInteractEffectEventResultModel;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import w20.z9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0 implements oh0.a {
    public final /* synthetic */ k0 a;

    public j0(k0 r1) {
        this.a = r1;
    }

    @Override // oh0.a
    public final void a(z9 r3, String r4, JsonObject r5) {
        Intrinsics.checkNotNullParameter(r3, "errCode");
        Intrinsics.checkNotNullParameter(r4, "errMsg");
        SendInteractEffectEventResultModel r0 = new SendInteractEffectEventResultModel();
        if (r3.getCode() != 1) goto L5;
        SendInteractEffectEventResultModel.Code r6 = SendInteractEffectEventResultModel.Code.Success;
    L6:
        r0.a(r6);
        r0.c(r4);
        r0.b(r5);
        this.a.finishWithResult(r0);
        return;
    L5:
        r6 = SendInteractEffectEventResultModel.Code.Failed;
        goto L6
    }
}
