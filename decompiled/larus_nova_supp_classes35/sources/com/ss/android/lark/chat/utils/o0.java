package com.ss.android.lark.chat.utils;

import android.app.Activity;
import android.content.DialogInterface;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o0 implements Runnable {
    public final /* synthetic */ Runnable a;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Runnable a;

        public a(Runnable r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.run();
            r1.dismiss();
        }
    }

    public o0(com.ss.android.lark.chat.service.impl.k1 r1) {
        this.a = r1;
    }

    public final void a() {
        Activity r0 = ImSdkProxy.b().getTopActivity();
        if (r0 != null) goto L6;
        Log.e("MessageUtils", "top activity is null");
        return;
    L6:
        new UDDialogBuilder(r0).message(2131891298).addActionButton(2131391777, 2131891297, new a(this.a)).addActionButton(2131391778, 2131891296, null).show();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
