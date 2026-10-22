package com.obric.assistant.chat;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k0 implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ ObricChatUIServiceImpl b;
    public final /* synthetic */ View c;
    public final /* synthetic */ int d;
    public final /* synthetic */ boolean e;

    public k0(View r1, ObricChatUIServiceImpl r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = 2131389063;
        this.e = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricChatUIServiceImpl r0 = this.b;     // Catch: Throwable -> L8
        View r1 = this.c;     // Catch: Throwable -> L8
        int r2 = this.d;     // Catch: Throwable -> L8
        Set r3 = ObricChatUIServiceImpl.g;     // Catch: Throwable -> L8
        r0.getClass();     // Catch: Throwable -> L8
        View r4 = r1.findViewById(r2);     // Catch: Throwable -> L8
        if (r4 != null) goto L5;
        FLogger.a.i("ObricChatUIServiceImpl", "ensureToolbarBottomSafeInset skip, toolbarLayout not found, id=" + r2);     // Catch: Throwable -> L8
    L5:
        if (r4 == null) goto L11;
        ObricChatUIServiceImpl r5 = this.b;     // Catch: Throwable -> L8
        boolean r6 = this.e;     // Catch: Throwable -> L8
        r5.getClass();     // Catch: Throwable -> L8
        ObricChatUIServiceImpl.Q(r4, r6);     // Catch: Throwable -> L8
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }
}
