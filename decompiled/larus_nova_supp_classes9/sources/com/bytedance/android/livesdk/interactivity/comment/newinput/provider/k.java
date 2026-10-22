package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements Runnable {
    public final /* synthetic */ e.c a;

    public k(e.c r1) {
        this.a = r1;
    }

    public final void a() {
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r0 = this.a.b.V();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r1 = r0.g;
        if (r1 == null) goto L9;
        com.bytedance.android.live.base.model.data.activityemoji.b r2 = r1.k;
        if (r2 == null) goto L9;
        this.a.b.C(r2);
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r3 = this.a.b.V();
        if (r3 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r4 = r3.g;
        if (r4 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.api.emoji.a r5 = r4.l;
        if (r5 == null) goto L16;
        this.a.b.g(r5);
    L16:
        this.a.b.c();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
