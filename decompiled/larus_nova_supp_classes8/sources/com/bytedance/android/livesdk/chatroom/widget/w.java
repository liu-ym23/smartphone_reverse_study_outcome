package com.bytedance.android.livesdk.chatroom.widget;

import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w implements Runnable {
    public final /* synthetic */ u.d a;

    public w(u.d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u r0 = this.a.b;     // Catch: Throwable -> L8
        ImageView r1 = r0.b;     // Catch: Throwable -> L8
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getWidth());     // Catch: Throwable -> L8
    L6:
        u.a(r0, r2);     // Catch: Throwable -> L8
        return;
    L5:
        r2 = null;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
