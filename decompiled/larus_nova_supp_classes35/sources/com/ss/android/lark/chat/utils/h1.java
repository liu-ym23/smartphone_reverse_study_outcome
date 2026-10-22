package com.ss.android.lark.chat.utils;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h1 implements Runnable {
    public final /* synthetic */ String a;

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(UIHelper.getContext(), this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h1(String r1) {
        this.a = r1;
    }
}
