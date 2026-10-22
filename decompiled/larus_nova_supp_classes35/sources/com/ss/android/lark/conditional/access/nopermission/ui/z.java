package com.ss.android.lark.conditional.access.nopermission.ui;

import android.content.DialogInterface;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z implements DialogInterface.OnClickListener {
    public final /* synthetic */ DialogInterface.OnClickListener a;

    public z(com.ss.android.lark.conditional.access.nopermission.manager.v r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        TextView r1 = null;
        if ((r3 instanceof UDDialog) == false) goto L5;
        UDDialog r0 = (UDDialog) r3;
    L6:
        if (r0 == null) goto L8;
        r1 = (TextView) r0.findViewById(r4);
    L8:
        if (r1 == null) goto L10;
        r1.setEnabled(false);
    L10:
        DialogInterface.OnClickListener r2 = this.a;
        if (r2 == null) goto L14;
        r2.onClick(r3, r4);
        return;
    L14:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
