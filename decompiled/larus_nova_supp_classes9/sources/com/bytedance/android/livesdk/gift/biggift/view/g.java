package com.bytedance.android.livesdk.gift.biggift.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ CustomGiftHintDialog a;

    public g(CustomGiftHintDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        jy0.b.d("CustomSpecialGiftEffects", "confirm dialog close");
        CustomGiftHintDialog.a(this.a, "close");
        CustomGiftHintDialog.a r3 = this.a.getOnCustomGiftDialogListener();
        if (r3 == null) goto L6;
        r3.a();
        return;
    }
}
