package com.larus.bmhome.chat.layout.item;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b3 implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ PromptSpan c;

    public b3(PromptSpan r1, int r2, PromptSpan r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.b;     // Catch: Throwable -> L9
        PromptSpan r1 = this.c;     // Catch: Throwable -> L9
        if (r0 != r1.q) goto L12;
        Function0<Unit> r2 = r1.K;     // Catch: Throwable -> L9
        if (r2 == null) goto L7;
        r2.invoke();     // Catch: Throwable -> L9
    L7:
        this.c.animate().alpha(1.0f).setDuration(150).start();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
