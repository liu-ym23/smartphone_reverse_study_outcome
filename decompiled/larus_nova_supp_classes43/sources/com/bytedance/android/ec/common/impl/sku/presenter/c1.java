package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c1 implements Runnable {
    public final /* synthetic */ d1 a;

    public c1(d1 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((TextView) this.a.a.Z().b(2131391448).f()).setPadding(0, 0, 8, 0);     // Catch: Throwable -> L4
        ((RelativeLayout) this.a.a.Z().b(2131384714).f()).setPadding(0, 0, 0, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
