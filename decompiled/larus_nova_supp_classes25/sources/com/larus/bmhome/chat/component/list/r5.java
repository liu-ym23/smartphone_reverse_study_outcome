package com.larus.bmhome.chat.component.list;

import android.content.DialogInterface;
import android.os.Handler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r5 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ Handler a;

    public /* synthetic */ r5(Handler r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        Handler r3 = this.a;
        if (r3 == null) goto L6;
        r3.removeCallbacksAndMessages(null);
        return;
    }
}
