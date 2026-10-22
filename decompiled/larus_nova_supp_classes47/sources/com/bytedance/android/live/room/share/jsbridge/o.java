package com.bytedance.android.live.room.share.jsbridge;

import android.content.DialogInterface;
import android.content.Intent;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livesdk.config.xr0;
import com.bytedance.ies.web.jsbridge2.CallContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o implements DialogInterface.OnClickListener {
    public final /* synthetic */ CallContext a;
    public final /* synthetic */ String b;

    public o(CallContext r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        if (((Boolean) xr0.a.getValue()).booleanValue() == false) goto L5;
        ((ILiveShareService) jc1.k.n(ILiveShareService.class)).openInstallApp(this.a.getContext(), this.b);
    L6:
        if (r3 == null) goto L9;
        r3.dismiss();
        return;
    L9:
        return;
    L5:
        Intent r5 = ita.k.e(this.a.getContext(), this.b);
        this.a.getContext().startActivity(r5);
        goto L6
    }
}
