package com.bytedance.android.ec.core.utils.rotation;

import android.animation.Animator;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Runnable {
    public final /* synthetic */ e a;

    public b(e r1) {
        this.a = r1;
    }

    public final void a() {
        e r0 = this.a;
        r0.h = r0.d(r0.h);
        e r1 = this.a;
        int r10 = r1.h;
        if (r10 >= 0) goto L5;
    L7:
        this.a.g();
        return;
    L5:
        if (r10 >= r1.a.size()) goto L7;
        e r11 = this.a;
        int r12 = r11.i;
        int r13 = (r12 + 1) % 2;
        r11.i = r13;
        r11.i(r13, ListProtector.get(r11.a, r11.h));
        View r14 = r11.f(r13);
        View r15 = r11.f(r12);
        Animator r16 = r11.b(r14);
        r16.addListener(new c(r11, r14));
        r16.start();
        Unit r17 = Unit.INSTANCE;
        r11.e = r16;
        Animator r18 = r11.c(r15);
        r18.addListener(new d(r11, r15));
        r18.start();
        r11.f = r18;
        e r19 = this.a;
        int r20 = r19.h;
        long r21 = r19.e();
        b r22 = new b(r19);
        r19.g.postDelayed(r22, r21);
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
