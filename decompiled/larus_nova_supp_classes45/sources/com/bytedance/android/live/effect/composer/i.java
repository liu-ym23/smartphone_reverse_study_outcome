package com.bytedance.android.live.effect.composer;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements Runnable {
    public final /* synthetic */ Sticker a;
    public final /* synthetic */ n b;
    public final /* synthetic */ LiveComposerManagerB$restoreEffect$1 c;

    public i(Sticker r1, n r2, LiveComposerManagerB$restoreEffect$1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = y50.c.a;     // Catch: Throwable -> L4
        long r1 = y50.c.g("restore_effect_total_in_room");     // Catch: Throwable -> L4
        this.c.invoke(this.b, this.a);     // Catch: Throwable -> L4
        y50.c.h("restore_effect_total_in_room", r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
