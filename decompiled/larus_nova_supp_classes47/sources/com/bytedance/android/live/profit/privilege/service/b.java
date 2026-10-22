package com.bytedance.android.live.profit.privilege.service;

import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements o {
    public final CompositeDisposable a;
    public final yz0.g b;
    public final n01.a c;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
        if (this.c.wm() == false) goto L5;
        return;
    L5:
        if (this.b.isAnchor() == true) goto L17;
        boolean r2 = false;
        HashMap r0 = (HashMap) com.bytedance.android.live.profit.privilege.datalayer.c.b.getValue(null, com.bytedance.android.live.profit.privilege.datalayer.c.a[0]);
        String r1 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        if (r0 == null) goto L18;
        String r3 = (String) r0.get(r1);
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.length() <= 0) goto L13;
        r2 = true;
    L13:
        if (r2 != true) goto L20;
        CompositeDisposable r4 = this.a;
        Observable r5 = Observable.timer(1000, TimeUnit.MILLISECONDS);
        int r6 = p.a;
        r4.add(r5.observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r0, r1)));
        return;
    L20:
        return;
    L18:
        return;
    }

    public final void onStop() {
        this.a.dispose();
    }

    public b(yz0.g r2, n01.a r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "vsService");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }
}
