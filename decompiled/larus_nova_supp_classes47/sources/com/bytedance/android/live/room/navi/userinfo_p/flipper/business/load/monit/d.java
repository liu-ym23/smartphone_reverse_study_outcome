package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import s91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ DiggTemporaryDataMonitor a;

    public d(DiggTemporaryDataMonitor r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        DiggTemporaryDataMonitor r7 = this.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(o91.b.h.class, "tabType");
        s91.a<f> r8 = r7.a;
        if (r8 == null) goto L5;
        boolean r9 = r8.a(o91.b.h.class);
    L6:
        if (r9 == true) goto L13;
        DiggTemporaryDataMonitor r10 = this.a;
        r10.e((f) r10.j.getValue());
        Disposable r12 = this.a.h;
        if (r12 == null) goto L11;
        r12.dispose();
    L11:
        DiggTemporaryDataMonitor r13 = this.a;
        r13.h = Observable.just("").delay(2000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this));
        return;
    L13:
        return;
    L5:
        r9 = false;
        goto L6
    }
}
