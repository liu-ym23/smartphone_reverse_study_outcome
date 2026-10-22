package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ UgcGiftSaleAdapter a;
    public final /* synthetic */ int b;

    public i(UgcGiftSaleAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        this.a.C2(this.b);
        r2.dismiss();
    }
}
