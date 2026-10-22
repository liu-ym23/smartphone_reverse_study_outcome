package com.ss.android.lark.chat.configurator;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.base.view.recycleview.ItemShineManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Runnable {
    public final /* synthetic */ ItemShineManager<?> a;
    public final /* synthetic */ ItemShineManager b;

    public d(ItemShineManager<?> r1, ItemShineManager r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ItemShineManager<?> r0 = this.a;     // Catch: Throwable -> L12
        if (r0 == null) goto L7;
        g2b.a r1 = r0.e;     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        r1.cancel();     // Catch: Throwable -> L12
    L7:
        ItemShineManager r2 = this.b;     // Catch: Throwable -> L12
        if (r2.e != null) goto L10;
        r2.a();     // Catch: Throwable -> L12
    L10:
        r2.e.b();     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    }
}
