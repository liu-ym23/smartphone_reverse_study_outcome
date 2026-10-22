package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class hb implements DialogInterface.OnClickListener {
    public final /* synthetic */ gb a;

    public hb(gb r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        if (r2 == null) goto L4;
        r2.dismiss();
    L4:
        this.a.finishWithResult(new gb.c("cancel"));
    }
}
