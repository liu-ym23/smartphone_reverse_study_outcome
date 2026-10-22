package com.suite.lark.platform.component.cta;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements DialogInterface.OnDismissListener {
    public final /* synthetic */ goc.a a;

    public h(goc.a r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        goc.a r2 = this.a;
        if (r2 == null) goto L6;
        r2.onDismiss();
        return;
    }
}
