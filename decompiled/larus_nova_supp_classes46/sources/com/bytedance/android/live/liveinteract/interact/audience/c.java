package com.bytedance.android.live.liveinteract.interact.audience;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ InteractAudienceGuestWidget a;
    public final /* synthetic */ Runnable b;

    public c(InteractAudienceGuestWidget r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
        InteractAudienceGuestWidget r3 = this.a;
        r3.F = this.b;
        tc0.c.h().G = "";
        this.a.F3("leave_normally");
    }
}
