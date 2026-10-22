package com.ss.android.lark.contact.customized.common;

import android.R;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;

    public c(View r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.b.findViewById(R.id.statusBarBackground);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.setVisibility(4);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
