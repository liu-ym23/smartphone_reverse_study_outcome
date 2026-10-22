package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ d b;
    public final /* synthetic */ Animator c;

    public k(MessageListAnimationContainer r1, d r2, Animator r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d = false;     // Catch: Throwable -> L4
        this.c.start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
