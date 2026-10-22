package com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Runnable {
    public final /* synthetic */ KeyboardWrapper a;
    public final /* synthetic */ Function0<Unit> b;

    public d(KeyboardWrapper r1, Function0<Unit> r2, int r3) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<T> r0 = this.a.a().iterator();     // Catch: Throwable -> L10
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IKeyboardWrapper.a) r0.next()).b(0);     // Catch: Throwable -> L10
        goto L4
    L6:
        Function0<Unit> r1 = this.b;     // Catch: Throwable -> L10
        if (r1 == null) goto L13;
        r1.invoke();     // Catch: Throwable -> L10
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
