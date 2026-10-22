package com.ss.android.lark.chat.utils;

import android.app.Activity;
import android.content.DialogInterface;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m0 implements Runnable {
    public final /* synthetic */ ErrorResult a;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public m0(ErrorResult r1) {
        this.a = r1;
    }

    public final void a() {
        Activity r0 = ImSdkProxy.b().getTopActivity();
        if (r0 != null) goto L6;
        return;
    L6:
        if (UIUtils.isActivityRunning(r0) == true) goto L9;
        Log.e("MessageUtils", "top activity is not running");
        return;
    L9:
        new UDDialogBuilder(r0).title(UIUtils.getString(r0, 2131890278)).message(this.a.getDisplayMsg(UIHelper.getString(2131891714))).addActionButton(2131391777, 2131891840, a.a).show();
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
