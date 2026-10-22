package com.bytedance.android.livesdk.gift.fastgift;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 {
    public static final <T> Observable<T> a(Observable<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$observeOnP4Ui");
        if (k60.b.d() == false) goto L5;
        Scheduler r0 = RxUtil.getLiveMainThreadP4Scheduler();
    L7:
        return r1.observeOn(r0);
    L5:
        r0 = AndroidSchedulers.mainThread();
        goto L7
    }
}
