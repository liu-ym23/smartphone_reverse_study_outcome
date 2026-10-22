package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.Bitmap;
import com.bytedance.commerce.base.richtext.SpanUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v implements Runnable {
    public final /* synthetic */ w a;
    public final /* synthetic */ Bitmap b;

    public v(w r1, Bitmap r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SpanUtils r1 = new SpanUtils(this.a.a.h);     // Catch: Throwable -> L4
        Bitmap r0 = this.b;     // Catch: Throwable -> L4
        r1.b();     // Catch: Throwable -> L4
        r1.v = 1;     // Catch: Throwable -> L4
        r1.p = r0;     // Catch: Throwable -> L4
        r1.r = 2;     // Catch: Throwable -> L4
        r1.a(" ");     // Catch: Throwable -> L4
        r1.a(this.a.b.d);     // Catch: Throwable -> L4
        r1.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
