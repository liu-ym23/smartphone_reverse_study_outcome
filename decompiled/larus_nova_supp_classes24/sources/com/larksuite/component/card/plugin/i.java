package com.larksuite.component.card.plugin;

import android.content.DialogInterface;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ j18.f<CallbackProcessResponse> b;

    public i(String r1, j18.f<CallbackProcessResponse> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        Log.d("MsgCardPluginUtils", "alert cancel, actionId: " + this.a);
        CallbackProcessResponse r3 = new CallbackProcessResponse();
        n18.b r4 = g.a;
        r3.setApiErrNo(g.a);
        this.b.callback(r3);
    }
}
