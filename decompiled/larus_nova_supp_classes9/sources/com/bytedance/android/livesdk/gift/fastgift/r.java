package com.bytedance.android.livesdk.gift.fastgift;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.FastGiftDialogHintView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ FastGiftDialogHintView b;

    public r(String r1, FastGiftDialogHintView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        r2.dismiss();
        String r4 = this.a;
        if (this.b.d.isChecked() == false) goto L5;
        String r5 = "1";
    L6:
        a.d(r4, "cancel", r5);
        return;
    L5:
        r5 = "0";
        goto L6
    }
}
