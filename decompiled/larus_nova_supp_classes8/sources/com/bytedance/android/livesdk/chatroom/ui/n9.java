package com.bytedance.android.livesdk.chatroom.ui;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n9 implements View.OnClickListener {
    public final /* synthetic */ TicketPriceInputDialogFragment a;

    public n9(TicketPriceInputDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        TicketPriceInputDialogFragment r4 = this.a;
        EditText r0 = r4.f;
        if (r0 == null) goto L7;
        Editable r1 = r0.getText();
        if (r1 == null) goto L7;
        String r2 = r1.toString();
    L8:
        r4.T90(r2, false);
        return;
    L7:
        r2 = null;
        goto L8
    }
}
