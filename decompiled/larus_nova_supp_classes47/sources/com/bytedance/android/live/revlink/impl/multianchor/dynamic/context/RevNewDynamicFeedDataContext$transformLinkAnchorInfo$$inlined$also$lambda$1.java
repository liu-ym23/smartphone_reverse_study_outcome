package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/context/RevNewDynamicFeedDataContext$transformLinkAnchorInfo$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/android/livesdk/link/model/p;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevNewDynamicFeedDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1 implements Observer<List<? extends com.bytedance.android.livesdk.link.model.p>> {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ o0 b;

    public final void onChanged(Object r4) {
        List r5 = (List) r4;
        Intrinsics.checkNotNullParameter(r5, "value");
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.d() == false) goto L5;
        com.bytedance.revenue.platform.api.core.rx.l r0 = com.bytedance.revenue.platform.api.core.rx.l.a;
        Observable r6 = Observable.just(r5).map(w0.a);
        int r1 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6.observeOn(Schedulers.single()).subscribe(new v0(this), x0.a), this.b.a);
        return;
    L5:
        ArrayList r2 = new ArrayList();
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        r2.add(new JSONObject(com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.e((com.bytedance.android.livesdk.link.model.p) r7.next())));
        goto L7
    L9:
        MediatorLiveData r8 = this.a;
        int r3 = com.bytedance.revenue.platform.api.core.b.a;
        Object r9 = JSONObject.wrap(r2);
        if (r9 == null) goto L14;
        r8.setValue((JSONArray) r9);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
    }

    public RevNewDynamicFeedDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1(MediatorLiveData r1, o0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
