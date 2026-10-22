package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b1 implements Runnable {
    public final /* synthetic */ d1 a;

    public b1(d1 r1) {
        this.a = r1;
    }

    public final void a() {
        View r0 = this.a.a.Z().b(2131377481).f();
        int r1 = com.bytedance.android.ec.core.utils.g1.a;
        r0.setBackground(com.bytedance.android.ec.core.utils.g1.a.b(this.a.a.Y().c(), 2131247876));
        ((RelativeLayout) this.a.a.Z().b(2131384714).f()).setPadding(0, 0, vf4.a.b(6), 0);
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
