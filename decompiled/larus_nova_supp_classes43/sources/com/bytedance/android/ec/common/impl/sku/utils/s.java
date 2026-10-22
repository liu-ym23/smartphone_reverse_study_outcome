package com.bytedance.android.ec.common.impl.sku.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public s(View r1, int r10, int r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = 0;
        this.e = 0;
    }

    public final void a() {
        Rect r0 = new Rect();
        this.a.getHitRect(r0);
        r0.top -= this.b;
        r0.bottom += this.c;
        r0.left -= this.d;
        r0.right += this.e;
        TouchDelegate r1 = new TouchDelegate(r0, this.a);
        if (View.class.isInstance(this.a.getParent()) == false) goto L9;
        Object r10 = this.a.getParent();
        if (r10 == null) goto L8;
        ((View) r10).setTouchDelegate(r1);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
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
