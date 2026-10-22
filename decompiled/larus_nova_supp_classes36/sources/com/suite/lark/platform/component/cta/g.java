package com.suite.lark.platform.component.cta;

import android.content.DialogInterface;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements DialogInterface.OnCancelListener {
    public final /* synthetic */ goc.b.g a;
    public final /* synthetic */ b b;

    public g(goc.b.g r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r8) {
        goc.b.h r9 = this.a.b();
        if (r9 != null) goto L5;
        r9 = new goc.b.h(0);
    L5:
        int r0 = moc.a.a;
        b r1 = this.b;
        String r2 = r1.a;
        String r3 = r1.b;
        String r4 = r9.b();
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        moc.a.a(r2, r3, r4, r9.a(), r9.d(), r.h);
    }
}
