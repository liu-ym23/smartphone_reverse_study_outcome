package com.bytedance.android.livesdk.interactivity.service.messagelist;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements Runnable {
    public final /* synthetic */ MessageListScrollManager a;
    public final /* synthetic */ IMessageListManager b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MessageListScrollManager.b(this.a.a, ((Integer) r2).intValue());
        }
    }

    public j(MessageListScrollManager r1, IMessageListManager r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageListScrollManager.b(this.a, this.b.c());     // Catch: Throwable -> L10
        MessageListScrollManager r0 = this.a;     // Catch: Throwable -> L10
        IMessageListManager r1 = r0.i;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        PublishSubject r2 = r1.b();     // Catch: Throwable -> L10
        if (r2 == null) goto L7;
        Disposable r3 = r2.subscribe(new a(this));     // Catch: Throwable -> L10
    L8:
        r0.h = r3;     // Catch: Throwable -> L10
        return;
    L7:
        r3 = null;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
