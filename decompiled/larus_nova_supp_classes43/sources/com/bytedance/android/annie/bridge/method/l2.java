package com.bytedance.android.annie.bridge.method;

import android.content.DialogInterface;
import com.bytedance.android.annie.bridge.ShowModalResultModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ m2 a;

    public l2(m2 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r10) {
        ShowModalResultModel r11 = new ShowModalResultModel();
        r11.b(ShowModalResultModel.Code.Success);
        r11.a(com.bytedance.android.ec.core.event.a.VALUE_CLICK_CONFIRM);
        this.a.finishWithResult(r11);
    }
}
