package com.bytedance.android.annie.bridge.method;

import android.content.DialogInterface;
import com.bytedance.android.annie.bridge.ShowModalResultModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k2 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ m2 a;

    public k2(m2 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r10) {
        ShowModalResultModel r11 = new ShowModalResultModel();
        r11.b(ShowModalResultModel.Code.Success);
        r11.a("mask");
        this.a.finishWithResult(r11);
    }
}
