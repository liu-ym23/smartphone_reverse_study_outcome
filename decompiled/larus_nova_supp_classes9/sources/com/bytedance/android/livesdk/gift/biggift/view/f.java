package com.bytedance.android.livesdk.gift.biggift.view;

import android.view.View;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ CustomGiftHintDialog a;

    public f(CustomGiftHintDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        CustomGiftHintDialog.a(this.a, "continue");
        CustomGiftHintDialog.a r3 = this.a.getOnCustomGiftDialogListener();
        if (r3 == null) goto L5;
        r3.b();
    L5:
        ViewUtilsKt.e(this.a);
    }
}
