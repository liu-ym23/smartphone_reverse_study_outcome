package com.bytedance.android.livesdk.gift.fastgift;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements DialogInterface.OnClickListener {
    public final /* synthetic */ FastGiftViewV3 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;

    public n(FastGiftViewV3 r1, long r2, int r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        this.a.A.hideConfirm();
        r4.dismiss();
        this.a.A.sendGift(Boolean.TRUE);
        a.b(this.b, this.c, this.d, "confirm");
    }
}
