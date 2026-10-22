package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ Ref.BooleanRef b;

    public g(f r1, Ref.BooleanRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.b.element == true) goto L9;
        this.a.b();     // Catch: Throwable -> L6
        return;
    }
}
