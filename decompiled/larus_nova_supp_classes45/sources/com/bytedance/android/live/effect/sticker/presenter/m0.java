package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m0 implements Runnable {
    public final /* synthetic */ o.c a;

    public m0(o.c r1, Sticker r2) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o.c r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.b();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
