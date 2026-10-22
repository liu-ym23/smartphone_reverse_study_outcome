package com.bytedance.android.live.recharge.widget;

import android.view.View;
import android.view.animation.TranslateAnimation;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x implements Runnable {
    public final /* synthetic */ RechargePanelWidgetComposite a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ View d;

    public x(RechargePanelWidgetComposite r1, boolean r2, boolean r3, View r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        if (this.b == false) goto L12;
        boolean r2 = this.c;
        if (r2 == false) goto L7;
        float r3 = 0.0f;
    L8:
        if (r2 == false) goto L10;
        float r4 = this.a.o;
    L11:
        TranslateAnimation r0 = new TranslateAnimation(0.0f, 0.0f, r3, r4);
    L20:
        r0.setDuration(300);
        r0.setFillAfter(true);
        this.d.startAnimation(r0);
        return;
    L10:
        r4 = 0.0f;
        goto L11
    L7:
        r3 = this.a.o;
        goto L8
    L12:
        boolean r5 = this.c;
        if (r5 == false) goto L15;
        float r6 = 0.0f;
    L16:
        if (r5 == false) goto L18;
        float r7 = this.a.o;
    L19:
        r0 = new TranslateAnimation(r6, r7, 0.0f, 0.0f);
        goto L20
    L18:
        r7 = 0.0f;
        goto L19
    L15:
        r6 = this.a.o;
        goto L16
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
