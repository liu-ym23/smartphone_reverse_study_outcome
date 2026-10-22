package com.bytedance.android.live.revlink.impl.pk.feedview;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c b;
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b c;
    public final /* synthetic */ CompositeDisposable d;

    public o(MediatorLiveData r1, com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r2, com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r3, CompositeDisposable r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onChanged(Object r4) {
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r5 = (com.bytedance.android.live.revlink.impl.pk.feedview.machine.l) r4;
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r6 = (com.bytedance.android.live.revlink.impl.pk.feedview.machine.l) this.b.e.getValue();
        if (r6 == null) goto L5;
        Integer r7 = Integer.valueOf(r6.b);
    L7:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.d() == false) goto L10;
        if (r7 == null) goto L12;
        RxUtilKt.c(Observable.just(r7).map(new m(this)).subscribe(new n(this), p.a), this.d);
        return;
    L12:
        return;
    L10:
        this.a.setValue(q.a(r7, this.b, this.c));
        return;
    L5:
        r7 = null;
        goto L7
    }
}
