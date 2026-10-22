package com.ss.android.lark.contact.base.common_ui;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(LarkContext.getApplication(), 2131892010);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
