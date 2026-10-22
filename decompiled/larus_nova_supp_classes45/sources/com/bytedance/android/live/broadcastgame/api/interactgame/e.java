package com.bytedance.android.live.broadcastgame.api.interactgame;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ long c;
    public final /* synthetic */ View d;
    public final /* synthetic */ boolean e;

    public e(d r1, Context r2, long r3, View r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
    }

    public final void a() {
        c r0 = this.a.a;
        if (r0 == null) goto L11;
        String r1 = r0.b();
        if (r1 == null) goto L12;
        Context r2 = this.b;
        if (r2 == null) goto L10;
        c90.a.C0006a r3 = new c90.a.C0006a((Activity) r2);
        r3.f = true;
        Intrinsics.checkNotNullParameter(r1, "str");
        r3.j = r1;
        r3.e = this.c;
        r3.b = false;
        r3.r = false;
        c90.a r4 = new c90.a(r3);
        r4.f();
        r4.i(this.d, 48, this.e);
        this.a.a = null;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L12:
        return;
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
