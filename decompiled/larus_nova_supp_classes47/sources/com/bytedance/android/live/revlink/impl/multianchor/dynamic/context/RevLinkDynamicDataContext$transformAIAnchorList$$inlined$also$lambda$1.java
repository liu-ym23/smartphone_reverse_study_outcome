package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/context/RevLinkDynamicDataContext$transformAIAnchorList$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/android/livesdk/link/model/e;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkDynamicDataContext$transformAIAnchorList$$inlined$also$lambda$1 implements Observer<List<? extends com.bytedance.android.livesdk.link.model.e>> {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ e0 b;

    public final void onChanged(Object r3) {
        List r4 = (List) r3;
        if (r4 == null) goto L6;
        com.bytedance.revenue.platform.api.core.rx.l r0 = com.bytedance.revenue.platform.api.core.rx.l.a;
        Observable r5 = Observable.just(r4).map(y.a);
        int r1 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r5.observeOn(Schedulers.single()).subscribe(new x(this), z.a), this.b.d);
        return;
    }

    public RevLinkDynamicDataContext$transformAIAnchorList$$inlined$also$lambda$1(MediatorLiveData r1, e0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
