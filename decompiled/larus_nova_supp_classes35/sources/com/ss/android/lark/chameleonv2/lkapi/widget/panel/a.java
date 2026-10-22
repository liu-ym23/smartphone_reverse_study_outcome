package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public final /* synthetic */ Function1<Integer, Unit> a;
    public final /* synthetic */ View b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super Integer, Unit> r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.invoke(Integer.valueOf(this.b.getWidth()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
