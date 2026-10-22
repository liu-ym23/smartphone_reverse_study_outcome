package com.bytedance.android.livesdk.chatroom.ui;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j5 implements View.OnClickListener {
    public final /* synthetic */ h5 a;
    public final /* synthetic */ h5.b b;

    public j5(h5 r1, h5.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        DialogInterface.OnClickListener r4 = this.b.h;
        if (r4 == null) goto L6;
        r4.onClick(this.a, 1);
        return;
    }
}
