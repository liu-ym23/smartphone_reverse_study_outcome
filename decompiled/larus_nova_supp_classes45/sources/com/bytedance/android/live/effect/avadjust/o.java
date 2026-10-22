package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements Runnable {
    public final /* synthetic */ l.b a;

    public o(l.b r1, Sticker r2) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onSuccess();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
