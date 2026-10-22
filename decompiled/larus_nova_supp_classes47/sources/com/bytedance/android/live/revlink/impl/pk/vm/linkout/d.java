package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import com.bytedance.revenue.platform.api.core.rx.q;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ PkAutoMatchManager a;

    public d(PkAutoMatchManager r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        String r5 = (String) r4;
        com.bytedance.android.live.revlink.impl.pk.service.i r0 = PkAutoMatchManager.g(this.a);
        if (r0 == null) goto L5;
        r0.J2(r5);
    L5:
        int r6 = q.a;
        int r7 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Scheduler r8 = AndroidSchedulers.mainThread();
        com.bytedance.revenue.platform.api.core.rx.f.a(Single.timer(5000, TimeUnit.MILLISECONDS, r8).subscribe(new b(this), c.a), this.a.c);
    }
}
