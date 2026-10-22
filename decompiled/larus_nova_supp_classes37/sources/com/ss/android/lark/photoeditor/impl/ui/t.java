package com.ss.android.lark.photoeditor.impl.ui;

import android.content.DialogInterface;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class t implements DialogInterface.OnClickListener {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ Map b;

    public t(String[] r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        if (r3 < 0) goto L10;
        String[] r4 = this.a;
        if (r3 >= r4.length) goto L12;
        String r5 = r4[r3];
        r0c.d r6 = (r0c.d) this.b.get(r5);
        if (r6 == null) goto L11;
        r6.getAction().run();
        return;
    L11:
        return;
    L12:
        return;
    }
}
