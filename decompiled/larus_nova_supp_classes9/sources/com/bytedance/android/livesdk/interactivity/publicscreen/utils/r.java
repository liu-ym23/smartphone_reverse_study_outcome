package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r implements Runnable {
    public final /* synthetic */ MessageListAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public r(MessageListAdapter r1, int r2) {
        this.a = r1;
        this.b = 0;
        this.c = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.notifyItemRangeRemoved(this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
