package com.larksuite.component.card.action.client;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements Runnable {
    public final /* synthetic */ c a;

    public a(c r1, JSONObject r2) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
