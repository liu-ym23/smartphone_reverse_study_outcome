package com.bytedance.android.live.lynx.ui.replay;

import androidx.lifecycle.Observer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ ReplayVideoViewForLynx a;

    public b(ReplayVideoViewForLynx r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        this.a.e("paidTrialCountDown", MapsKt.mapOf(new Pair[]{TuplesKt.to("remain_second", Long.valueOf(((Long) r6).longValue() / 1000)), TuplesKt.to("episode_id", String.valueOf(this.a.o))}));
    }
}
