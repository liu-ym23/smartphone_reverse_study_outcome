package com.ss.android.lark.framework.larkwidget;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.component.ChatInitErrorComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ Widget a;
    public final /* synthetic */ Function0<Unit> b;

    public a(ChatInitErrorComponent r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.c == false) goto L9;
        this.b.invoke();     // Catch: Throwable -> L6
        return;
    }
}
