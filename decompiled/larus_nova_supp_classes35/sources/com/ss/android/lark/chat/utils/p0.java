package com.ss.android.lark.chat.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p0 implements Runnable {
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

    public static final class b implements DialogInterface.OnDismissListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            n0.a = false;
        }
    }

    public p0(ErrorResult r1) {
        this.a = r1;
    }

    public final void a() {
        Activity r0 = ImSdkProxy.b().getTopActivity();
        if (r0 != null) goto L7;
        Log.e("MessageUtils", "top activity is null");
        return;
    L7:
        if (r0.isFinishing() == false) goto L9;
    L21:
        Log.e("MessageUtils", "activity is finishing or destroyed");
        return;
    L9:
        if (r0.isDestroyed() == true) goto L21;
        String r2 = this.a.getDisplayMsg();
        if (TextUtils.isEmpty(r2) == false) goto L14;
        r2 = UIUtils.getString(r0, 2131890721);
    L14:
        if (r2 != null) goto L16;
        return;
    L16:
        if (n0.a == false) goto L19;
        Log.i("MessageUtils", "isShowingNoFileSharePermissionDialog");
        return;
    L19:
        n0.a = true;
        new UDDialogBuilder(r0).title(2131890722).message(r2).addActionButton(2131391777, 2131890720, a.a).onDismissListener(b.a).show();
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
