package com.ss.android.lark.contact.base.contact_focus;

import com.bytedance.lark.pb.contact.v1.PushFocusChatter;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ SpecialFocusPush a;
    public final /* synthetic */ PushFocusChatter b;

    public b(SpecialFocusPush r1, PushFocusChatter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CopyOnWriteArrayList<IGetDataCallback<PushFocusChatter>> r0 = this.a.a;     // Catch: Throwable -> L7
        PushFocusChatter r1 = this.b;     // Catch: Throwable -> L7
        Iterator<IGetDataCallback<PushFocusChatter>> r2 = r0.iterator();     // Catch: Throwable -> L7
    L4:
        if (r2.hasNext() == false) goto L16;
        r2.next().onSuccess(r1);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
