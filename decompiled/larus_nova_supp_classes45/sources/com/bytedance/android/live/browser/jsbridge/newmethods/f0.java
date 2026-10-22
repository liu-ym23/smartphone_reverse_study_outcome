package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.AlertCheckDialogResultModel;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 implements lm3.c.a {
    public final /* synthetic */ h0 b;

    public f0(h0 r1) {
        this.b = r1;
    }

    public final void onAction(lm3.d r4) {
        h0 r5 = this.b;
        r5.getClass();
        AlertCheckDialogResultModel r0 = new AlertCheckDialogResultModel();
        r0.a(AlertCheckDialogResultModel.Code.Success);
        AlertCheckDialogResultModel.a r1 = new AlertCheckDialogResultModel.a();
        r1.c(Boolean.TRUE);
        r1.a(Boolean.FALSE);
        r1.b(Boolean.valueOf(r5.a));
        Unit r2 = Unit.INSTANCE;
        r0.b(r1);
        r5.finishWithResult(r0);
        r5.b = true;
    }
}
