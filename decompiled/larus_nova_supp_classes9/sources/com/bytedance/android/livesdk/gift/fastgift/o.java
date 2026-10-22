package com.bytedance.android.livesdk.gift.fastgift;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements DialogInterface.OnClickListener {
    public final /* synthetic */ long a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public o(long r1, int r3, String r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        r4.dismiss();
        a.b(this.a, this.b, this.c, "cancel");
    }
}
