package com.bytedance.android.livesdk.gift.fastgift;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.FastGiftDialogHintView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements DialogInterface.OnClickListener {
    public final /* synthetic */ FastGiftViewV3 a;
    public final /* synthetic */ FastGiftDialogHintView b;
    public final /* synthetic */ String c;

    public q(FastGiftViewV3 r1, FastGiftDialogHintView r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        if (this.b.d.isChecked() == false) goto L5;
        this.a.A.errorConfirm();
    L5:
        r2.dismiss();
        this.a.A.sendGift(Boolean.TRUE);
        String r4 = this.c;
        if (this.b.d.isChecked() == false) goto L8;
        String r5 = "1";
    L9:
        a.d(r4, "confirm", r5);
        return;
    L8:
        r5 = "0";
        goto L9
    }
}
