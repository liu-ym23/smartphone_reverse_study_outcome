package com.bytedance.android.livesdk.interactivity.publicscreen.pin;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ f b;

    public e(c r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c r0 = this.a;     // Catch: Throwable -> L7
        f r1 = this.b;     // Catch: Throwable -> L7
        r0.getClass();     // Catch: Throwable -> L7
        if ((r1 instanceof z) == false) goto L5;
        r0.f.w(new d(r1));     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        r0.f.Q(r1.b);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }
}
