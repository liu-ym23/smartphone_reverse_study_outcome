package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p0 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final yz0.k b;
    public final i12.e c;
    public final uz1.a d;

    public final void onStop() {
        this.a.clear();
    }

    public final void onStart() {
        com.bytedance.android.live.profit.privilege.a r0 = yt0.c.i();
        if (r0 == null) goto L6;
        this.a.add(RxUtilKt.h(r0.getPayGrade().a().subscribeOn(Schedulers.io())).subscribe(new o0(this)));
        return;
    }

    public p0(yz0.k r2, i12.e r3, uz1.a r4) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "giftMVIFacade");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new CompositeDisposable();
    }
}
