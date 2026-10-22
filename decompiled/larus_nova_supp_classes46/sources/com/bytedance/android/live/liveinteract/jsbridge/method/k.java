package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements my.d {
    public final /* synthetic */ l a;

    public k(l r1) {
        this.a = r1;
    }

    public final void a(int r9, String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "errMsg");
        l r0 = this.a;
        UpdateLinkmicStatusResultModel r1 = new UpdateLinkmicStatusResultModel();
        this.a.getClass();
        UpdateLinkmicStatusResultModel.Code[] r2 = UpdateLinkmicStatusResultModel.Code.values();
        int r3 = r2.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L11;
        UpdateLinkmicStatusResultModel.Code r6 = r2[r5];
        if (r6.getValue() != r9) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L12;
        r5 = r5 + 1;
    L12:
        if (r6 != null) goto L14;
        r6 = UpdateLinkmicStatusResultModel.Code.Failed;
    L14:
        r1.a(r6);
        r1.c(r10);
        r1.b(r11);
        Unit r12 = Unit.INSTANCE;
        r0.finishWithResult(r1);
        return;
    L7:
        r7 = false;
        goto L8
    L11:
        r6 = null;
        goto L12
    }
}
