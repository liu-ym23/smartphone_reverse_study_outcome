package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m6 extends Dialog {
    public final String a;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        requestWindowFeature(1);
        View r4 = LayoutInflater.from(getContext()).inflate(2131565489, null);
        TextView r0 = (TextView) r4.findViewById(2131390743);
        if (r0 == null) goto L7;
        String r1 = this.a;
        if (r1 == null) goto L7;
        r0.setText(r1);
    L7:
        setContentView(r4);
        Window r5 = getWindow();
        if (r5 == null) goto L11;
        r5.setGravity(17);
        return;
    }

    public m6(Context r2, String r3) {
        super(r2, 2131954696);
        this.a = null;
        this.a = r3;
    }
}
