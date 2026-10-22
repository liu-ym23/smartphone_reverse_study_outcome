package com.bytedance.android.live.livepkaudience.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;
    public final /* synthetic */ Runnable b;

    public d(LinkPkInteractAudienceGuestWidget r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
        LinkPkInteractAudienceGuestWidget r3 = this.a;
        r3.B = this.b;
        tc0.c.h().G = "";
        this.a.F3("leave_normally");
    }
}
