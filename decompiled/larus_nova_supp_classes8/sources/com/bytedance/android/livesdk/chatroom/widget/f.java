package com.bytedance.android.livesdk.chatroom.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        zg1.q r4 = this.a.e.d;
        if (r4 == null) goto L5;
        zg1.q.a.a(r4, false);
    L5:
        r2.dismiss();
    }
}
