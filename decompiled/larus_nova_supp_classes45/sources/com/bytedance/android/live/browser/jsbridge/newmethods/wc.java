package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class wc implements DialogInterface.OnDismissListener {
    public final /* synthetic */ xc a;
    public final /* synthetic */ JSONObject b;

    public wc(xc r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        this.a.finishWithResult(this.b);
    }
}
