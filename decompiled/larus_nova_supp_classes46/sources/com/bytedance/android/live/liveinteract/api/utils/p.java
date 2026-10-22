package com.bytedance.android.live.liveinteract.api.utils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p {
    public Disposable a;
    public final com.bytedance.android.live.pushstream.d b;

    public final void b() {
        if (((Boolean) vm2.d.n.getValue(null, vm2.d.a[12])).booleanValue() == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.pushstream.d r0 = this.b;
        if (r0 != null) goto L8;
    L15:
        Disposable r1 = this.a;
        if (r1 == null) goto L18;
        r1.dispose();
    L18:
        this.a = null;
        return;
    L8:
        if (r0.A() == null) goto L15;
        d0 r2 = this.b.A();
        if (r2 == null) goto L12;
        r2.c0();
    L12:
        d0 r3 = this.b.A();
        if (r3 == null) goto L15;
        r3.c0();
        goto L15
    }

    public p(com.bytedance.android.live.pushstream.d r1) {
        this.b = r1;
    }

    public final void a(long r4) {
        if (((Boolean) vm2.d.n.getValue(null, vm2.d.a[12])).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.b != null) goto L8;
        return;
    L8:
        b();
        this.a = Observable.interval(1000, TimeUnit.MILLISECONDS).subscribe(new o(this, r4));
    }
}
