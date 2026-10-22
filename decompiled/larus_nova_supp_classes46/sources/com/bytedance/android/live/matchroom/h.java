package com.bytedance.android.live.matchroom;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;
    public final /* synthetic */ View d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;

    public h(g r1, View r2, View r3, View r4, boolean r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void a() {
        g r0 = this.a;
        if (this.f == false) goto L5;
        float r1 = 0.0f;
    L6:
        r0.b = r1;
        g r2 = this.a;
        if (this.f == false) goto L9;
        float r3 = 1.0f;
    L10:
        r2.c = r3;
        this.b.setTranslationX(this.c.getTranslationX());
        this.b.setScaleY(this.c.getScaleY());
        this.b.setScaleX(this.c.getScaleX());
        if (this.e == false) goto L14;
        this.b.setOutlineProvider(new o());
        this.b.setClipToOutline(true);
        return;
    L14:
        return;
    L9:
        r3 = this.b.getScaleX();
        goto L10
    L5:
        r1 = this.b.getTranslationX();
        goto L6
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
