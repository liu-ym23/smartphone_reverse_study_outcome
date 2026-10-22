package com.ss.android.lark.chat.service.impl;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.im.sdk.ImSdk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l1 implements Runnable {
    public final /* synthetic */ ErrorResult a;

    @Override // java.lang.Runnable
    public final void run() {
        Context r0 = ImSdk.a.getContext();     // Catch: Throwable -> L7
        String r1 = this.a.getDisplayMsg();     // Catch: Throwable -> L7
        String r2 = UIUtils.getString(r0, 2131891714);     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r1 = r2;
    L5:
        LKUIToast.show(r0, r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public l1(ErrorResult r1) {
        this.a = r1;
    }
}
