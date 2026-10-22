package com.obric.matrix.platform.sdk.ones.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import dka.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class StaticAccountStatusReceiver extends BroadcastReceiver {
    public StaticAccountStatusReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r5 = r4.getAction();
        a.c("AccountSDK_StaticAccountStatusReceiver", "onReceive action = " + r5);
        boolean r1 = false;
        int r6 = r4.getIntExtra("obric.intent.extra.account.LOGOUT_SCENE", 0);
        g.c.getClass();
        if (r5 != null) goto L7;
    L8:
        r1 = true;
    L9:
        if (r1 == true) goto L13;
        g.j.post(new f(r5, r6));
        return;
    L13:
        return;
    L7:
        if (r5.length() != 0) goto L9;
        goto L8
    }
}
