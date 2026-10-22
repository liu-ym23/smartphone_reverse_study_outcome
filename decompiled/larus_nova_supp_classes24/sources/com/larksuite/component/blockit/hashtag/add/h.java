package com.larksuite.component.blockit.hashtag.add;

import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h implements Runnable {
    public final /* synthetic */ b a;

    public h(b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KeyboardUtils.showKeyboard(this.a.a.findViewById(2131371788));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
