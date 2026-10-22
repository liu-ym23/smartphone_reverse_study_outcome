package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;
import com.bytedance.android.live.browser.jsbridge.base.AlertResultModel;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ m0 a;

    public j0(m0 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        if (r2 == null) goto L4;
        r2.dismiss();
    L4:
        m0 r4 = this.a;
        if (r4.a == true) goto L8;
        AlertResultModel r5 = new AlertResultModel();
        r5.a(AlertResultModel.Code.action);
        Unit r0 = Unit.INSTANCE;
        r4.finishWithResult(r5);
        return;
    }
}
