package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements Runnable {
    public final /* synthetic */ BaseGuestLinkMainPageDialog a;
    public final /* synthetic */ Ref.FloatRef b;

    public b(BaseGuestLinkMainPageDialog r1, Ref.FloatRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.e;     // Catch: Throwable -> L10
        if (r0 == null) goto L5;
        int r1 = r0.getMeasuredWidth();     // Catch: Throwable -> L10
    L6:
        float r2 = r1 / this.b.element;     // Catch: Throwable -> L10
        View r3 = this.a.e;     // Catch: Throwable -> L10
        if (r3 == null) goto L13;
        a1.k(r3, (int) r2);     // Catch: Throwable -> L10
        return;
    L13:
        return;
    L5:
        r1 = 0;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }
}
