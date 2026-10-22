package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import com.bytedance.android.live.link.data.RevPkState;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/context/RevNewDynamicFeedDataContext$packagePlayStatus$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1 implements Observer<Integer> {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ o0 b;

    public final void onChanged(Object r3) {
        int r4 = ((Number) r3).intValue();
        if (r4 != RevPkState.DISABLE.ordinal()) goto L6;
        r4 = RevPkState.FINISHED.ordinal();
    L6:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.d() == false) goto L8;
        com.bytedance.revenue.platform.api.core.rx.l r0 = com.bytedance.revenue.platform.api.core.rx.l.a;
        Observable r5 = Observable.just(Integer.valueOf(r4)).map(new s0(this));
        int r1 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r5.observeOn(Schedulers.single()).subscribe(new t0(this), u0.a), this.b.a);
        return;
    L8:
        this.a.setValue(o0.i(this.b, r4));
    }

    public RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1(MediatorLiveData r1, o0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
