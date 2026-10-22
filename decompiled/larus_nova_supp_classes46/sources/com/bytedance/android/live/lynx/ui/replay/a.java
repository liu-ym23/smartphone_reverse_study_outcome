package com.bytedance.android.live.lynx.ui.replay;

import androidx.lifecycle.Observer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ ReplayVideoViewForLynx a;

    public a(ReplayVideoViewForLynx r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        this.a.e("paidStatusUpdate", MapsKt.mapOf(new Pair[]{TuplesKt.to("paid_status", (Integer) r4), TuplesKt.to("episode_id", String.valueOf(this.a.o))}));
    }
}
