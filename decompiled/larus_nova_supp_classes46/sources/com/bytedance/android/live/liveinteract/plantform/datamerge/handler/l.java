package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends a {
    public final j b;
    public Disposable c;
    public boolean d;
    public final eg6.b e;
    public final boolean f;

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        eg6.b r0 = this.e;
        if (r0 == null) goto L6;
        r0.h0(this.b);
    L6:
        if (this.f == false) goto L9;
        this.c = Observable.timer(vm2.d.T(), TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(this));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        eg6.b r0 = this.e;
        if (r0 == null) goto L5;
        r0.s(this.b);
    L5:
        Disposable r1 = this.c;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "oldMergeDataList");
        boolean r0 = this.d;
        if (r0 == false) goto L6;
        this.d = false;
    L6:
        return new h.a(r0, r4, null);
    }

    public l(hg6.g r1, boolean r2) {
        this.e = r1;
        this.f = r2;
        this.b = new j(this);
    }
}
