package com.ss.android.lark.contact.base.contact_search;

import android.widget.EditText;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements Runnable {
    public final /* synthetic */ s a;

    @Override // java.lang.Runnable
    public final void run() {
        KeyboardUtils.showKeyboard(this.a.v);     // Catch: Throwable -> L4
        EditText r0 = this.a.v;     // Catch: Throwable -> L4
        r0.setSelection(r0.getText().length());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(s r1) {
        this.a = r1;
    }
}
