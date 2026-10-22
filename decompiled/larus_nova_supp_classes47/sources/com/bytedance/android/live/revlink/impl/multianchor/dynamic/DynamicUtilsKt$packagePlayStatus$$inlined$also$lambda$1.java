package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import androidx.lifecycle.MediatorLiveData;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/DynamicUtilsKt$packagePlayStatus$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1 implements Observer<Integer> {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b b;
    public final /* synthetic */ CompositeDisposable c;

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4 == null) goto L8;
        int r0 = RevPkState.DISABLE.ordinal();
        if (r4.intValue() == r0) goto L8;
        int r5 = r4.intValue();
    L10:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.c() == false) goto L12;
        com.bytedance.revenue.platform.api.core.rx.l r1 = com.bytedance.revenue.platform.api.core.rx.l.a;
        Observable r6 = Observable.just(Integer.valueOf(r5)).map(new a(this));
        int r2 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6.observeOn(Schedulers.single()).subscribe(new b(this), c.a), this.c);
        return;
    L12:
        this.a.setValue(e.a(r5, this.b));
        return;
    L8:
        r5 = RevPkState.FINISHED.ordinal();
        goto L10
    }

    public DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1(MediatorLiveData r1, com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b r2, CompositeDisposable r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
