package com.ss.android.lark.conditional.access.web.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ RejectBindDeviceWebActivity a;

    public b(RejectBindDeviceWebActivity r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        if (r1 == null) goto L4;
        r1.dismiss();
    L4:
        this.a.finish();
    }
}
