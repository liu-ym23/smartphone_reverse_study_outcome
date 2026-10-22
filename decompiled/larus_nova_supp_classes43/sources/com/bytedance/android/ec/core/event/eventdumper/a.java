package com.bytedance.android.ec.core.event.eventdumper;

import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.android.ec.core.event.b;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ Context a;

    public a(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a.registerReceiver(this.a, new ECEventDumper(), new IntentFilter("com.bytedance.ec.eventdumper"));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
