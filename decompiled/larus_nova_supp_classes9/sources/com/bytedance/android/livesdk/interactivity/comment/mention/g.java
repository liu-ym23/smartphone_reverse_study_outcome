package com.bytedance.android.livesdk.interactivity.comment.mention;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements Runnable {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    public final void a() {
        this.a.a.k.a(true);
        if (this.a.a.s.getVisibility() != 8) goto L5;
        this.a.a.b.P(true);
    L5:
        UtilityKotlinExtentionsKt.t(this.a.a.h);
        this.a.a.e.b(true);
        UtilityKotlinExtentionsKt.w(this.a.a.e);
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
