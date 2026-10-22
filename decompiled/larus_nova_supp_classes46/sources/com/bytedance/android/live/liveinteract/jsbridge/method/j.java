package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements ih0.h {
    public final /* synthetic */ l a;

    public j(l r1) {
        this.a = r1;
    }

    @Override // ih0.h
    public final void a(UpdateLinkmicStatusResultModel.Code r2, String r3, JsonObject r4) {
        Intrinsics.checkNotNullParameter(r2, "errCode");
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        UpdateLinkmicStatusResultModel r0 = new UpdateLinkmicStatusResultModel();
        r0.a(r2);
        r0.c(r3);
        r0.b(r4);
        this.a.finishWithResult(r0);
    }
}
