package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import com.bytedance.android.live.link.data.RevPkState;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/context/RevLinkDynamicDataContext$packagePlayStatus$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkDynamicDataContext$packagePlayStatus$$inlined$also$lambda$1 implements Observer<Integer> {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ e0 b;

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4 == null) goto L8;
        int r0 = RevPkState.DISABLE.ordinal();
        if (r4.intValue() == r0) goto L8;
        int r5 = r4.intValue();
    L10:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.c() == false) goto L12;
        com.bytedance.revenue.platform.api.core.rx.l r1 = com.bytedance.revenue.platform.api.core.rx.l.a;
        Observable r6 = Observable.just(Integer.valueOf(r5)).map(new t(this));
        int r2 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6.observeOn(Schedulers.single()).subscribe(new u(this), v.a), this.b.d);
        return;
    L12:
        this.a.setValue(e0.c(this.b, r5));
        return;
    L8:
        r5 = RevPkState.FINISHED.ordinal();
        goto L10
    }

    public RevLinkDynamicDataContext$packagePlayStatus$$inlined$also$lambda$1(MediatorLiveData r1, e0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
