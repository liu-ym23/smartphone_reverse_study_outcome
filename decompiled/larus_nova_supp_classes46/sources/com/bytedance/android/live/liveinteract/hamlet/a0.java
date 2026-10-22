package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public a0(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        CompositeDisposable r6 = this.a.a;
        int r0 = ff0.n.a;
        Intrinsics.checkNotNullParameter(r6, "compositeDisposable");
        ALogger.i("HamletAvatar", "prepareResource");
        RxUtilKt.c(Observable.create(ff0.k.a).compose(RxUtil.rxSchedulerHelper()).subscribe(ff0.l.a, ff0.m.a), r6);
    }
}
