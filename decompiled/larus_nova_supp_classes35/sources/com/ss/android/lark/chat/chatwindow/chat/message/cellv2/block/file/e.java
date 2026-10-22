package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ Context b;

    public e(g r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.showToast(UIUtils.getString(this.b, 2131891433));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
