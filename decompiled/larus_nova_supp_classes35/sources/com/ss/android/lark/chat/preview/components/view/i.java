package com.ss.android.lark.chat.preview.components.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.preview.entity.component.property.TimeProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements Runnable {
    public final /* synthetic */ TimingView a;
    public final /* synthetic */ TimeProperty b;

    public i(TimingView r1, TimeProperty r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TimingView r0 = this.a;     // Catch: Throwable -> L4
        TimeProperty r1 = this.b;     // Catch: Throwable -> L4
        int r2 = TimingView.b;     // Catch: Throwable -> L4
        r0.z(r1, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
