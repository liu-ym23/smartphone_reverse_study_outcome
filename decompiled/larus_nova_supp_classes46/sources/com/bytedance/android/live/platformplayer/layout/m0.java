package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdkapi.model.LayoutEvent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m0 implements Runnable {
    public final /* synthetic */ n0 a;
    public final /* synthetic */ LayoutEvent b;

    public m0(n0 r1, LayoutEvent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LivePlayerWidget.ms(this.a.a, this.b.getFrom(), 0, 0, null, null, 30);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
